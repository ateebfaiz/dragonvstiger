package androidx.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.webkit.internal.AssetHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class WebViewAssetLoader {
    public static final String DEFAULT_DOMAIN = "appassets.androidplatform.net";
    private static final String TAG = "WebViewAssetLoader";
    private final List<a> mMatchers;

    public static final class Builder {
        private String mDomain = WebViewAssetLoader.DEFAULT_DOMAIN;
        private final List<Pair<String, PathHandler>> mHandlerList = new ArrayList();
        private boolean mHttpAllowed;

        public Builder addPathHandler(String str, PathHandler pathHandler) {
            this.mHandlerList.add(Pair.create(str, pathHandler));
            return this;
        }

        public WebViewAssetLoader build() {
            ArrayList arrayList = new ArrayList();
            for (Pair next : this.mHandlerList) {
                arrayList.add(new a(this.mDomain, (String) next.first, this.mHttpAllowed, (PathHandler) next.second));
            }
            return new WebViewAssetLoader(arrayList);
        }

        public Builder setDomain(String str) {
            this.mDomain = str;
            return this;
        }

        public Builder setHttpAllowed(boolean z10) {
            this.mHttpAllowed = z10;
            return this;
        }
    }

    public static final class InternalStoragePathHandler implements PathHandler {
        private static final String[] FORBIDDEN_DATA_DIRS = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};
        private final File mDirectory;

        public InternalStoragePathHandler(Context context, File file) {
            try {
                this.mDirectory = new File(AssetHelper.getCanonicalDirPath(file));
                if (!isAllowedInternalStorageDir(context)) {
                    throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
                }
            } catch (IOException e10) {
                throw new IllegalArgumentException("Failed to resolve the canonical path for the given directory: " + file.getPath(), e10);
            }
        }

        private boolean isAllowedInternalStorageDir(Context context) throws IOException {
            String canonicalDirPath = AssetHelper.getCanonicalDirPath(this.mDirectory);
            String canonicalDirPath2 = AssetHelper.getCanonicalDirPath(context.getCacheDir());
            String canonicalDirPath3 = AssetHelper.getCanonicalDirPath(AssetHelper.getDataDir(context));
            if ((!canonicalDirPath.startsWith(canonicalDirPath2) && !canonicalDirPath.startsWith(canonicalDirPath3)) || canonicalDirPath.equals(canonicalDirPath2) || canonicalDirPath.equals(canonicalDirPath3)) {
                return false;
            }
            for (String str : FORBIDDEN_DATA_DIRS) {
                if (canonicalDirPath.startsWith(canonicalDirPath3 + str)) {
                    return false;
                }
            }
            return true;
        }

        @WorkerThread
        public WebResourceResponse handle(String str) {
            try {
                File canonicalFileIfChild = AssetHelper.getCanonicalFileIfChild(this.mDirectory, str);
                if (canonicalFileIfChild != null) {
                    return new WebResourceResponse(AssetHelper.guessMimeType(str), (String) null, AssetHelper.openFile(canonicalFileIfChild));
                }
                Log.e(WebViewAssetLoader.TAG, String.format("The requested file: %s is outside the mounted directory: %s", new Object[]{str, this.mDirectory}));
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            } catch (IOException e10) {
                Log.e(WebViewAssetLoader.TAG, "Error opening the requested path: " + str, e10);
            }
        }
    }

    public interface PathHandler {
        @WorkerThread
        WebResourceResponse handle(String str);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final boolean f16923a;

        /* renamed from: b  reason: collision with root package name */
        final String f16924b;

        /* renamed from: c  reason: collision with root package name */
        final String f16925c;

        /* renamed from: d  reason: collision with root package name */
        final PathHandler f16926d;

        a(String str, String str2, boolean z10, PathHandler pathHandler) {
            if (str2.isEmpty() || str2.charAt(0) != '/') {
                throw new IllegalArgumentException("Path should start with a slash '/'.");
            } else if (str2.endsWith(DomExceptionUtils.SEPARATOR)) {
                this.f16924b = str;
                this.f16925c = str2;
                this.f16923a = z10;
                this.f16926d = pathHandler;
            } else {
                throw new IllegalArgumentException("Path should end with a slash '/'");
            }
        }

        public String a(String str) {
            return str.replaceFirst(this.f16925c, "");
        }

        public PathHandler b(Uri uri) {
            if (uri.getScheme().equals("http") && !this.f16923a) {
                return null;
            }
            if ((uri.getScheme().equals("http") || uri.getScheme().equals("https")) && uri.getAuthority().equals(this.f16924b) && uri.getPath().startsWith(this.f16925c)) {
                return this.f16926d;
            }
            return null;
        }
    }

    WebViewAssetLoader(List<a> list) {
        this.mMatchers = list;
    }

    @WorkerThread
    public WebResourceResponse shouldInterceptRequest(Uri uri) {
        WebResourceResponse handle;
        for (a next : this.mMatchers) {
            PathHandler b10 = next.b(uri);
            if (b10 != null && (handle = b10.handle(next.a(uri.getPath()))) != null) {
                return handle;
            }
        }
        return null;
    }

    public static final class AssetsPathHandler implements PathHandler {
        private final AssetHelper mAssetHelper;

        public AssetsPathHandler(Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @WorkerThread
        public WebResourceResponse handle(String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), (String) null, this.mAssetHelper.openAsset(str));
            } catch (IOException e10) {
                Log.e(WebViewAssetLoader.TAG, "Error opening asset path: " + str, e10);
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            }
        }

        @VisibleForTesting
        AssetsPathHandler(AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }

    public static final class ResourcesPathHandler implements PathHandler {
        private final AssetHelper mAssetHelper;

        public ResourcesPathHandler(Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @WorkerThread
        public WebResourceResponse handle(String str) {
            try {
                return new WebResourceResponse(AssetHelper.guessMimeType(str), (String) null, this.mAssetHelper.openResource(str));
            } catch (Resources.NotFoundException e10) {
                Log.e(WebViewAssetLoader.TAG, "Resource not found from the path: " + str, e10);
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            } catch (IOException e11) {
                Log.e(WebViewAssetLoader.TAG, "Error opening resource from the path: " + str, e11);
                return new WebResourceResponse((String) null, (String) null, (InputStream) null);
            }
        }

        @VisibleForTesting
        ResourcesPathHandler(AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }
}
