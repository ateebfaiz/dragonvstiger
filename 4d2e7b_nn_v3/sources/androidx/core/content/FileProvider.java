package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.XmlRes;
import androidx.core.util.ObjectsCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File(DomExceptionUtils.SEPARATOR);
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f14874a = 0;
    @GuardedBy("sCache")
    private static final HashMap<String, b> sCache = new HashMap<>();
    @GuardedBy("mLock")
    private String mAuthority;
    @GuardedBy("mLock")
    @Nullable
    private b mLocalPathStrategy;
    @NonNull
    private final Object mLock;
    private final int mResourceId;

    static class a {
        @DoNotInline
        static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    interface b {
        File a(Uri uri);

        Uri b(File file);
    }

    static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final String f14875a;

        /* renamed from: b  reason: collision with root package name */
        private final HashMap f14876b = new HashMap();

        c(String str) {
            this.f14875a = str;
        }

        private boolean d(String str, String str2) {
            String access$000 = FileProvider.removeTrailingSlash(str);
            String access$0002 = FileProvider.removeTrailingSlash(str2);
            if (!access$000.equals(access$0002)) {
                if (access$000.startsWith(access$0002 + '/')) {
                    return true;
                }
                return false;
            }
            return true;
        }

        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = (File) this.f14876b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (d(canonicalFile.getPath(), file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            } else {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
        }

        public Uri b(File file) {
            String str;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry entry = null;
                for (Map.Entry entry2 : this.f14876b.entrySet()) {
                    String path = ((File) entry2.getValue()).getPath();
                    if (d(canonicalPath, path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = ((File) entry.getValue()).getPath();
                    if (path2.endsWith(DomExceptionUtils.SEPARATOR)) {
                        str = canonicalPath.substring(path2.length());
                    } else {
                        str = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(this.f14875a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(str, DomExceptionUtils.SEPARATOR)).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f14876b.put(str, file.getCanonicalFile());
                } catch (IOException e10) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e10);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }
    }

    public FileProvider() {
        this(0);
    }

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] copyOf(String[] strArr, int i10) {
        String[] strArr2 = new String[i10];
        System.arraycopy(strArr, 0, strArr2, 0, i10);
        return strArr2;
    }

    @VisibleForTesting
    static XmlResourceParser getFileProviderPathsMetaData(Context context, String str, @Nullable ProviderInfo providerInfo, int i10) {
        if (providerInfo != null) {
            if (providerInfo.metaData == null && i10 != 0) {
                Bundle bundle = new Bundle(1);
                providerInfo.metaData = bundle;
                bundle.putInt(META_DATA_FILE_PROVIDER_PATHS, i10);
            }
            XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
            if (loadXmlMetaData != null) {
                return loadXmlMetaData;
            }
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
    }

    @NonNull
    private b getLocalPathStrategy() {
        b bVar;
        synchronized (this.mLock) {
            try {
                ObjectsCompat.requireNonNull(this.mAuthority, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
                if (this.mLocalPathStrategy == null) {
                    this.mLocalPathStrategy = getPathStrategy(getContext(), this.mAuthority, this.mResourceId);
                }
                bVar = this.mLocalPathStrategy;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private static b getPathStrategy(Context context, String str, int i10) {
        b bVar;
        HashMap<String, b> hashMap = sCache;
        synchronized (hashMap) {
            try {
                bVar = hashMap.get(str);
                if (bVar == null) {
                    bVar = parsePathStrategy(context, str, i10);
                    hashMap.put(str, bVar);
                }
            } catch (IOException e10) {
                throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e10);
            } catch (XmlPullParserException e11) {
                throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e11);
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static Uri getUriForFile(@NonNull Context context, @NonNull String str, @NonNull File file) {
        return getPathStrategy(context, str, 0).b(file);
    }

    private static int modeToMode(String str) {
        if ("r".equals(str)) {
            return GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static b parsePathStrategy(Context context, String str, int i10) throws IOException, XmlPullParserException {
        c cVar = new c(str);
        XmlResourceParser fileProviderPathsMetaData = getFileProviderPathsMetaData(context, str, context.getPackageManager().resolveContentProvider(str, 128), i10);
        while (true) {
            int next = fileProviderPathsMetaData.next();
            if (next == 1) {
                return cVar;
            }
            if (next == 2) {
                String name = fileProviderPathsMetaData.getName();
                File file = null;
                String attributeValue = fileProviderPathsMetaData.getAttributeValue((String) null, "name");
                String attributeValue2 = fileProviderPathsMetaData.getAttributeValue((String) null, ATTR_PATH);
                if (TAG_ROOT_PATH.equals(name)) {
                    file = DEVICE_ROOT;
                } else if (TAG_FILES_PATH.equals(name)) {
                    file = context.getFilesDir();
                } else if (TAG_CACHE_PATH.equals(name)) {
                    file = context.getCacheDir();
                } else if (TAG_EXTERNAL.equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if (TAG_EXTERNAL_FILES.equals(name)) {
                    File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, (String) null);
                    if (externalFilesDirs.length > 0) {
                        file = externalFilesDirs[0];
                    }
                } else if (TAG_EXTERNAL_CACHE.equals(name)) {
                    File[] externalCacheDirs = ContextCompat.getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        file = externalCacheDirs[0];
                    }
                } else if (TAG_EXTERNAL_MEDIA.equals(name)) {
                    File[] a10 = a.a(context);
                    if (a10.length > 0) {
                        file = a10[0];
                    }
                }
                if (file != null) {
                    cVar.c(attributeValue, buildPath(file, attributeValue2));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public static String removeTrailingSlash(@NonNull String str) {
        if (str.length() <= 0 || str.charAt(str.length() - 1) != '/') {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }

    @CallSuper
    public void attachInfo(@NonNull Context context, @NonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            String str = providerInfo.authority.split(";")[0];
            synchronized (this.mLock) {
                this.mAuthority = str;
            }
            HashMap<String, b> hashMap = sCache;
            synchronized (hashMap) {
                hashMap.remove(str);
            }
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return getLocalPathStrategy().a(uri).delete() ? 1 : 0;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        String mimeTypeFromExtension;
        File a10 = getLocalPathStrategy().a(uri);
        int lastIndexOf = a10.getName().lastIndexOf(46);
        if (lastIndexOf < 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a10.getName().substring(lastIndexOf + 1))) == null) {
            return "application/octet-stream";
        }
        return mimeTypeFromExtension;
    }

    @Nullable
    public String getTypeAnonymous(@NonNull Uri uri) {
        return "application/octet-stream";
    }

    public Uri insert(@NonNull Uri uri, @NonNull ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate() {
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(getLocalPathStrategy().a(uri), modeToMode(str));
    }

    @NonNull
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int i10;
        String str3;
        File a10 = getLocalPathStrategy().a(uri);
        String queryParameter = uri.getQueryParameter(DISPLAYNAME_FIELD);
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i11 = 0;
        for (String str4 : strArr) {
            if ("_display_name".equals(str4)) {
                strArr3[i11] = "_display_name";
                i10 = i11 + 1;
                if (queryParameter == null) {
                    str3 = a10.getName();
                } else {
                    str3 = queryParameter;
                }
                objArr[i11] = str3;
            } else if ("_size".equals(str4)) {
                strArr3[i11] = "_size";
                i10 = i11 + 1;
                objArr[i11] = Long.valueOf(a10.length());
            }
            i11 = i10;
        }
        String[] copyOf = copyOf(strArr3, i11);
        Object[] copyOf2 = copyOf(objArr, i11);
        MatrixCursor matrixCursor = new MatrixCursor(copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    public int update(@NonNull Uri uri, @NonNull ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    protected FileProvider(@XmlRes int i10) {
        this.mLock = new Object();
        this.mResourceId = i10;
    }

    private static Object[] copyOf(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[i10];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        return objArr2;
    }

    @SuppressLint({"StreamFiles"})
    @NonNull
    public static Uri getUriForFile(@NonNull Context context, @NonNull String str, @NonNull File file, @NonNull String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, str2).build();
    }
}
