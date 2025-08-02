package com.alpha0010.fs;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.documentfile.provider.DocumentFile;
import com.alibaba.pdns.f;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;
import kotlin.text.j;
import kotlinx.coroutines.b0;
import kotlinx.coroutines.c0;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.l0;
import okhttp3.Call;

public final class FileAccessModule extends FileAccessSpec {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String NAME = "FileAccess";
    /* access modifiers changed from: private */
    public final Map<Integer, WeakReference<Call>> fetchCalls = new LinkedHashMap();
    private final b0 ioScope = c0.a(l0.b());

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileAccessModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "context");
    }

    private final String guessMimeType(String str) {
        String I0 = j.I0(str, f.G, "");
        if (I0.length() <= 0) {
            return "application/octet-stream";
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = I0.toLowerCase(Locale.ROOT);
        m.e(lowerCase, "toLowerCase(...)");
        String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
        if (mimeTypeFromExtension != null) {
            return mimeTypeFromExtension;
        }
        return "application/octet-stream";
    }

    /* access modifiers changed from: private */
    public final InputStream openForReading(String str) {
        if (!e.b(str)) {
            return new FileInputStream(e.d(str));
        }
        InputStream openInputStream = getReactApplicationContext().getContentResolver().openInputStream(Uri.parse(str));
        m.c(openInputStream);
        m.c(openInputStream);
        return openInputStream;
    }

    /* access modifiers changed from: private */
    public final OutputStream openForWriting(String str) {
        DocumentFile createFile;
        if (!e.b(str)) {
            return new FileOutputStream(e.d(str));
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        DocumentFile a10 = e.a(str, reactApplicationContext);
        if (a10.isFile()) {
            OutputStream openOutputStream = getReactApplicationContext().getContentResolver().openOutputStream(a10.getUri());
            m.c(openOutputStream);
            return openOutputStream;
        }
        Pair e10 = e.e(str);
        String str2 = (String) e10.b();
        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getReactApplicationContext(), (Uri) e10.a());
        if (fromTreeUri == null || (createFile = fromTreeUri.createFile(guessMimeType(str2), str2)) == null) {
            throw new IOException("Failed to open '" + str + "' for writing.");
        }
        OutputStream openOutputStream2 = getReactApplicationContext().getContentResolver().openOutputStream(createFile.getUri());
        m.c(openOutputStream2);
        return openOutputStream2;
    }

    /* access modifiers changed from: private */
    public final ReadableMap statFile(DocumentFile documentFile) {
        String str;
        Pair a10 = t.a("filename", documentFile.getName());
        Pair a11 = t.a("lastModified", Long.valueOf(documentFile.lastModified()));
        String str2 = "file";
        if (m.b(documentFile.getUri().getScheme(), str2)) {
            str = documentFile.getUri().getPath();
        } else {
            str = documentFile.getUri().toString();
        }
        Pair a12 = t.a("path", str);
        Pair a13 = t.a("size", Long.valueOf(documentFile.length()));
        if (documentFile.isDirectory()) {
            str2 = "directory";
        }
        WritableNativeMap makeNativeMap = Arguments.makeNativeMap((Map<String, Object>) i0.i(a10, a11, a12, a13, t.a("type", str2)));
        m.e(makeNativeMap, "makeNativeMap(...)");
        return makeNativeMap;
    }

    @ReactMethod
    public void addListener(String str) {
        m.f(str, "eventType");
    }

    @ReactMethod
    public void appendFile(String str, String str2, String str3, Promise promise) {
        m.f(str, "path");
        m.f(str2, "data");
        m.f(str3, "encoding");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$appendFile$1(str3, str, str2, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void cancelFetch(double d10, Promise promise) {
        Call call;
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        WeakReference remove = this.fetchCalls.remove(Integer.valueOf((int) d10));
        if (!(remove == null || (call = (Call) remove.get()) == null)) {
            call.cancel();
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void concatFiles(String str, String str2, Promise promise) {
        m.f(str, "source");
        m.f(str2, "target");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$concatFiles$1(this, str, promise, str2, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void cp(String str, String str2, Promise promise) {
        m.f(str, "source");
        m.f(str2, "target");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$cp$1(this, str, promise, str2, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void cpAsset(String str, String str2, String str3, Promise promise) {
        m.f(str, "asset");
        m.f(str2, "target");
        m.f(str3, "type");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$cpAsset$1(str3, this, str, promise, str2, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void cpExternal(String str, String str2, String str3, Promise promise) {
        m.f(str, "source");
        m.f(str2, "targetName");
        m.f(str3, "dir");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$cpExternal$1(this, str, promise, str3, str2, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void df(Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$df$1(this, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void exists(String str, Promise promise) {
        m.f(str, "path");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$exists$1(promise, str, this, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void fetch(double d10, String str, ReadableMap readableMap) {
        m.f(str, "resource");
        m.f(readableMap, "init");
        f1 unused = f.b(c0.a(l0.a()), (CoroutineContext) null, (d0) null, new FileAccessModule$fetch$1(d10, this, str, readableMap, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void getAppGroupDir(String str, Promise promise) {
        m.f(str, "groupName");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        promise.reject("ERR", "App group unavailable on Android.");
    }

    public String getName() {
        return NAME;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getTypedExportedConstants() {
        String str;
        try {
            str = System.getenv("SECONDARY_STORAGE");
            if (str == null) {
                str = System.getenv("EXTERNAL_STORAGE");
            }
        } catch (Throwable unused) {
            str = null;
        }
        return i0.g(t.a("CacheDir", getReactApplicationContext().getCacheDir().getAbsolutePath()), t.a("DatabaseDir", getReactApplicationContext().getDatabasePath("FileAccessProbe").getParent()), t.a("DocumentDir", getReactApplicationContext().getFilesDir().getAbsolutePath()), t.a("MainBundleDir", getReactApplicationContext().getApplicationInfo().dataDir), t.a("SDCardDir", str));
    }

    @ReactMethod
    public void hash(String str, String str2, Promise promise) {
        m.f(str, "path");
        m.f(str2, "algorithm");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$hash$1(str2, this, str, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void isDir(String str, Promise promise) {
        m.f(str, "path");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$isDir$1(promise, str, this, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void ls(String str, Promise promise) {
        m.f(str, "path");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$ls$1(str, this, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void mkdir(String str, Promise promise) {
        m.f(str, "path");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$mkdir$1(str, this, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void mv(String str, String str2, Promise promise) {
        m.f(str, "source");
        m.f(str2, "target");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$mv$1(str, this, str2, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void readFile(String str, String str2, Promise promise) {
        m.f(str, "path");
        m.f(str2, "encoding");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$readFile$1(this, str, str2, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void readFileChunk(String str, double d10, double d11, String str2, Promise promise) {
        m.f(str, "path");
        String str3 = str2;
        m.f(str3, "encoding");
        Promise promise2 = promise;
        m.f(promise2, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$readFileChunk$1(this, str, str3, promise2, d10, d11, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void removeListeners(double d10) {
    }

    @ReactMethod
    public void stat(String str, Promise promise) {
        m.f(str, "path");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$stat$1(str, this, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void statDir(String str, Promise promise) {
        m.f(str, "path");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$statDir$1(str, this, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void unlink(String str, Promise promise) {
        m.f(str, "path");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$unlink$1(str, this, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void unzip(String str, String str2, Promise promise) {
        m.f(str, "source");
        m.f(str2, "target");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$unzip$1(str2, this, str, promise, (d) null), 3, (Object) null);
    }

    @ReactMethod
    public void writeFile(String str, String str2, String str3, Promise promise) {
        m.f(str, "path");
        m.f(str2, "data");
        m.f(str3, "encoding");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        f1 unused = f.b(this.ioScope, (CoroutineContext) null, (d0) null, new FileAccessModule$writeFile$1(str3, this, str, promise, str2, (d) null), 3, (Object) null);
    }
}
