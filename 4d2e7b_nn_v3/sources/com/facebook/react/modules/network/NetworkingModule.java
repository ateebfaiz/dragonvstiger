package com.facebook.react.modules.network;

import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

@s6.a(name = "Networking")
public final class NetworkingModule extends NativeNetworkingAndroidSpec {
    private static final int CHUNK_TIMEOUT_NS = 100000000;
    private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
    private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    private static final String REQUEST_BODY_KEY_BASE64 = "base64";
    private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    private static final String REQUEST_BODY_KEY_STRING = "string";
    private static final String REQUEST_BODY_KEY_URI = "uri";
    private static final String TAG = "Networking";
    private static final String USER_AGENT_HEADER_NAME = "user-agent";
    @Nullable
    private static c customClientBuilder;
    /* access modifiers changed from: private */
    public final OkHttpClient mClient;
    private final e mCookieHandler;
    private final a mCookieJarContainer;
    @Nullable
    private final String mDefaultUserAgent;
    private final List<e> mRequestBodyHandlers;
    private final Set<Integer> mRequestIds;
    /* access modifiers changed from: private */
    public final List<f> mResponseHandlers;
    /* access modifiers changed from: private */
    public boolean mShuttingDown;
    private final List<g> mUriHandlers;

    class a implements i {

        /* renamed from: a  reason: collision with root package name */
        long f3303a = System.nanoTime();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f3304b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactApplicationContext f3305c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f3306d;

        a(String str, ReactApplicationContext reactApplicationContext, int i10) {
            this.f3304b = str;
            this.f3305c = reactApplicationContext;
            this.f3306d = i10;
        }

        public void a(long j10, long j11, boolean z10) {
            long nanoTime = System.nanoTime();
            if ((z10 || NetworkingModule.shouldDispatch(nanoTime, this.f3303a)) && !this.f3304b.equals("text")) {
                o.c(this.f3305c, this.f3306d, j10, j11);
                this.f3303a = nanoTime;
            }
        }
    }

    class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3308a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReactApplicationContext f3309b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f3310c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f3311d;

        b(int i10, ReactApplicationContext reactApplicationContext, String str, boolean z10) {
            this.f3308a = i10;
            this.f3309b = reactApplicationContext;
            this.f3310c = str;
            this.f3311d = z10;
        }

        public void onFailure(Call call, IOException iOException) {
            String str;
            if (!NetworkingModule.this.mShuttingDown) {
                NetworkingModule.this.removeRequest(this.f3308a);
                if (iOException.getMessage() != null) {
                    str = iOException.getMessage();
                } else {
                    str = "Error while executing request: " + iOException.getClass().getSimpleName();
                }
                o.f(this.f3309b, this.f3308a, str, iOException);
            }
        }

        public void onResponse(Call call, Response response) {
            MediaType mediaType;
            if (!NetworkingModule.this.mShuttingDown) {
                NetworkingModule.this.removeRequest(this.f3308a);
                o.h(this.f3309b, this.f3308a, response.code(), NetworkingModule.translateHeaders(response.headers()), response.request().url().toString());
                try {
                    ResponseBody body = response.body();
                    if ("gzip".equalsIgnoreCase(response.header("Content-Encoding")) && body != null) {
                        GzipSource gzipSource = new GzipSource(body.source());
                        String header = response.header("Content-Type");
                        if (header != null) {
                            mediaType = MediaType.parse(header);
                        } else {
                            mediaType = null;
                        }
                        body = ResponseBody.create(mediaType, -1, Okio.buffer((Source) gzipSource));
                    }
                    for (f fVar : NetworkingModule.this.mResponseHandlers) {
                        if (fVar.b(this.f3310c)) {
                            o.a(this.f3309b, this.f3308a, fVar.a(body));
                            o.g(this.f3309b, this.f3308a);
                            return;
                        }
                    }
                    if (this.f3311d) {
                        if (this.f3310c.equals("text")) {
                            NetworkingModule.this.readWithProgress(this.f3308a, body);
                            o.g(this.f3309b, this.f3308a);
                            return;
                        }
                    }
                    String str = "";
                    if (this.f3310c.equals("text")) {
                        try {
                            str = body.string();
                        } catch (IOException e10) {
                            if (!response.request().method().equalsIgnoreCase("HEAD")) {
                                o.f(this.f3309b, this.f3308a, e10.getMessage(), e10);
                            }
                        }
                    } else if (this.f3310c.equals(NetworkingModule.REQUEST_BODY_KEY_BASE64)) {
                        str = Base64.encodeToString(body.bytes(), 2);
                    }
                    o.b(this.f3309b, this.f3308a, str);
                    o.g(this.f3309b, this.f3308a);
                } catch (IOException e11) {
                    o.f(this.f3309b, this.f3308a, e11.getMessage(), e11);
                }
            }
        }
    }

    class c implements i {

        /* renamed from: a  reason: collision with root package name */
        long f3313a = System.nanoTime();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReactApplicationContext f3314b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f3315c;

        c(ReactApplicationContext reactApplicationContext, int i10) {
            this.f3314b = reactApplicationContext;
            this.f3315c = i10;
        }

        public void a(long j10, long j11, boolean z10) {
            long nanoTime = System.nanoTime();
            if (z10 || NetworkingModule.shouldDispatch(nanoTime, this.f3313a)) {
                o.d(this.f3314b, this.f3315c, j10, j11);
                this.f3313a = nanoTime;
            }
        }
    }

    class d extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f3317a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ReactContext reactContext, int i10) {
            super(reactContext);
            this.f3317a = i10;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            i6.a.a(NetworkingModule.this.mClient, Integer.valueOf(this.f3317a));
        }
    }

    public interface e {
        boolean a(ReadableMap readableMap);

        RequestBody b(ReadableMap readableMap, String str);
    }

    public interface f {
        WritableMap a(ResponseBody responseBody);

        boolean b(String str);
    }

    public interface g {
        WritableMap a(Uri uri);

        boolean b(Uri uri, String str);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, @Nullable String str, OkHttpClient okHttpClient, @Nullable List<Object> list) {
        super(reactApplicationContext);
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        if (list != null) {
            OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
            Iterator<Object> it = list.iterator();
            if (!it.hasNext()) {
                okHttpClient = newBuilder.build();
            } else {
                c.d.a(it.next());
                throw null;
            }
        }
        this.mClient = okHttpClient;
        this.mCookieHandler = new e(reactApplicationContext);
        this.mCookieJarContainer = (a) okHttpClient.cookieJar();
        this.mShuttingDown = false;
        this.mDefaultUserAgent = str;
        this.mRequestIds = new HashSet();
    }

    private synchronized void addRequest(int i10) {
        this.mRequestIds.add(Integer.valueOf(i10));
    }

    private static void applyCustomBuilder(OkHttpClient.Builder builder) {
    }

    private synchronized void cancelAllRequests() {
        try {
            for (Integer intValue : this.mRequestIds) {
                cancelRequest(intValue.intValue());
            }
            this.mRequestIds.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void cancelRequest(int i10) {
        new d(getReactApplicationContext(), i10).execute(new Void[0]);
    }

    @Nullable
    private MultipartBody.Builder constructMultipartBody(ReadableArray readableArray, String str, int i10) {
        MediaType mediaType;
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MediaType.parse(str));
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        int size = readableArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            ReadableMap map = readableArray.getMap(i11);
            Headers extractHeaders = extractHeaders(map.getArray("headers"), (ReadableMap) null);
            if (extractHeaders == null) {
                o.f(reactApplicationContextIfActiveOrWarn, i10, "Missing or invalid header format for FormData part.", (Throwable) null);
                return null;
            }
            String str2 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
            if (str2 != null) {
                mediaType = MediaType.parse(str2);
                extractHeaders = extractHeaders.newBuilder().removeAll(CONTENT_TYPE_HEADER_NAME).build();
            } else {
                mediaType = null;
            }
            if (map.hasKey(REQUEST_BODY_KEY_STRING)) {
                builder.addPart(extractHeaders, RequestBody.create(mediaType, map.getString(REQUEST_BODY_KEY_STRING)));
            } else if (!map.hasKey(REQUEST_BODY_KEY_URI)) {
                o.f(reactApplicationContextIfActiveOrWarn, i10, "Unrecognized FormData part.", (Throwable) null);
            } else if (mediaType == null) {
                o.f(reactApplicationContextIfActiveOrWarn, i10, "Binary FormData part needs a content-type header.", (Throwable) null);
                return null;
            } else {
                String string = map.getString(REQUEST_BODY_KEY_URI);
                InputStream h10 = n.h(getReactApplicationContext(), string);
                if (h10 == null) {
                    o.f(reactApplicationContextIfActiveOrWarn, i10, "Could not retrieve file for uri " + string, (Throwable) null);
                    return null;
                }
                builder.addPart(extractHeaders, n.c(mediaType, h10));
            }
        }
        return builder;
    }

    @Nullable
    private Headers extractHeaders(@Nullable ReadableArray readableArray, @Nullable ReadableMap readableMap) {
        String str;
        if (readableArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = readableArray.size();
        int i10 = 0;
        while (i10 < size) {
            ReadableArray array = readableArray.getArray(i10);
            if (array != null && array.size() == 2) {
                String a10 = f.a(array.getString(0));
                String string = array.getString(1);
                if (!(a10 == null || string == null)) {
                    builder.addUnsafeNonAscii(a10, string);
                    i10++;
                }
            }
            return null;
        }
        if (builder.get(USER_AGENT_HEADER_NAME) == null && (str = this.mDefaultUserAgent) != null) {
            builder.add(USER_AGENT_HEADER_NAME, str);
        }
        if (readableMap == null || !readableMap.hasKey(REQUEST_BODY_KEY_STRING)) {
            builder.removeAll(CONTENT_ENCODING_HEADER_NAME);
        }
        return builder.build();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Response lambda$sendRequestInternal$0(String str, ReactApplicationContext reactApplicationContext, int i10, Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new k(proceed.body(), new a(str, reactApplicationContext, i10))).build();
    }

    /* access modifiers changed from: private */
    public void readWithProgress(int i10, ResponseBody responseBody) throws IOException {
        long j10;
        Charset charset;
        long j11 = -1;
        try {
            k kVar = (k) responseBody;
            j10 = kVar.m();
            try {
                j11 = kVar.contentLength();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j10 = -1;
        }
        if (responseBody.contentType() == null) {
            charset = StandardCharsets.UTF_8;
        } else {
            charset = responseBody.contentType().charset(StandardCharsets.UTF_8);
        }
        l lVar = new l(charset);
        InputStream byteStream = responseBody.byteStream();
        try {
            byte[] bArr = new byte[8192];
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    o.e(reactApplicationContextIfActiveOrWarn, i10, lVar.a(bArr, read), j10, j11);
                } else {
                    return;
                }
            }
        } finally {
            byteStream.close();
        }
    }

    /* access modifiers changed from: private */
    public synchronized void removeRequest(int i10) {
        this.mRequestIds.remove(Integer.valueOf(i10));
    }

    public static void setCustomClientBuilder(c cVar) {
    }

    /* access modifiers changed from: private */
    public static boolean shouldDispatch(long j10, long j11) {
        return j11 + 100000000 < j10;
    }

    /* access modifiers changed from: private */
    public static WritableMap translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        for (int i10 = 0; i10 < headers.size(); i10++) {
            String name = headers.name(i10);
            if (bundle.containsKey(name)) {
                bundle.putString(name, bundle.getString(name) + ", " + headers.value(i10));
            } else {
                bundle.putString(name, headers.value(i10));
            }
        }
        return Arguments.fromBundle(bundle);
    }

    private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, int i10) {
        if (requestBody == null) {
            return null;
        }
        return n.e(requestBody, new c(getReactApplicationContextIfActiveOrWarn(), i10));
    }

    public void abortRequest(double d10) {
        int i10 = (int) d10;
        cancelRequest(i10);
        removeRequest(i10);
    }

    public void addListener(String str) {
    }

    public void addRequestBodyHandler(e eVar) {
        this.mRequestBodyHandlers.add(eVar);
    }

    public void addResponseHandler(f fVar) {
        this.mResponseHandlers.add(fVar);
    }

    public void addUriHandler(g gVar) {
        this.mUriHandlers.add(gVar);
    }

    @ReactMethod
    public void clearCookies(com.facebook.react.bridge.Callback callback) {
        this.mCookieHandler.d(callback);
    }

    public void initialize() {
        this.mCookieJarContainer.b(new JavaNetCookieJar(this.mCookieHandler));
    }

    public void invalidate() {
        this.mShuttingDown = true;
        cancelAllRequests();
        this.mCookieHandler.e();
        this.mCookieJarContainer.a();
        this.mRequestBodyHandlers.clear();
        this.mResponseHandlers.clear();
        this.mUriHandlers.clear();
    }

    public void removeListeners(double d10) {
    }

    public void removeRequestBodyHandler(e eVar) {
        this.mRequestBodyHandlers.remove(eVar);
    }

    public void removeResponseHandler(f fVar) {
        this.mResponseHandlers.remove(fVar);
    }

    public void removeUriHandler(g gVar) {
        this.mUriHandlers.remove(gVar);
    }

    public void sendRequest(String str, String str2, double d10, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z10, double d11, boolean z11) {
        int i10 = (int) d10;
        try {
            sendRequestInternal(str, str2, i10, readableArray, readableMap, str3, z10, (int) d11, z11);
        } catch (Throwable th) {
            Throwable th2 = th;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to send url request: ");
            String str4 = str2;
            sb2.append(str2);
            z2.a.k("Networking", sb2.toString(), th2);
            o.f(getReactApplicationContextIfActiveOrWarn(), i10, th2.getMessage(), th2);
        }
    }

    public void sendRequestInternal(String str, String str2, int i10, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z10, int i11, boolean z11) {
        e eVar;
        RequestBody requestBody;
        Charset charset;
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        try {
            Uri parse = Uri.parse(str2);
            for (g next : this.mUriHandlers) {
                if (next.b(parse, str3)) {
                    o.a(reactApplicationContextIfActiveOrWarn, i10, next.a(parse));
                    o.g(reactApplicationContextIfActiveOrWarn, i10);
                    return;
                }
            }
            try {
                Request.Builder url = new Request.Builder().url(str2);
                if (i10 != 0) {
                    url.tag(Integer.valueOf(i10));
                }
                OkHttpClient.Builder newBuilder = this.mClient.newBuilder();
                applyCustomBuilder(newBuilder);
                if (!z11) {
                    newBuilder.cookieJar(CookieJar.NO_COOKIES);
                }
                if (z10) {
                    newBuilder.addNetworkInterceptor(new g(this, str3, reactApplicationContextIfActiveOrWarn, i10));
                }
                if (i11 != this.mClient.callTimeoutMillis()) {
                    newBuilder.callTimeout((long) i11, TimeUnit.MILLISECONDS);
                }
                OkHttpClient build = newBuilder.build();
                Headers extractHeaders = extractHeaders(readableArray, readableMap);
                if (extractHeaders == null) {
                    o.f(reactApplicationContextIfActiveOrWarn, i10, "Unrecognized headers format", (Throwable) null);
                    return;
                }
                String str4 = extractHeaders.get(CONTENT_TYPE_HEADER_NAME);
                String str5 = extractHeaders.get(CONTENT_ENCODING_HEADER_NAME);
                url.headers(extractHeaders);
                if (readableMap != null) {
                    Iterator<e> it = this.mRequestBodyHandlers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        eVar = it.next();
                        if (eVar.a(readableMap)) {
                            break;
                        }
                    }
                }
                eVar = null;
                if (readableMap != null) {
                    Locale locale = Locale.ROOT;
                    if (!str.toLowerCase(locale).equals("get") && !str.toLowerCase(locale).equals("head")) {
                        if (eVar != null) {
                            requestBody = eVar.b(readableMap, str4);
                        } else if (readableMap.hasKey(REQUEST_BODY_KEY_STRING)) {
                            if (str4 == null) {
                                o.f(reactApplicationContextIfActiveOrWarn, i10, "Payload is set but no content-type header specified", (Throwable) null);
                                return;
                            }
                            String string = readableMap.getString(REQUEST_BODY_KEY_STRING);
                            MediaType parse2 = MediaType.parse(str4);
                            if (n.i(str5)) {
                                requestBody = n.d(parse2, string);
                                if (requestBody == null) {
                                    o.f(reactApplicationContextIfActiveOrWarn, i10, "Failed to gzip request body", (Throwable) null);
                                    return;
                                }
                            } else {
                                if (parse2 == null) {
                                    charset = StandardCharsets.UTF_8;
                                } else {
                                    charset = parse2.charset(StandardCharsets.UTF_8);
                                }
                                requestBody = RequestBody.create(parse2, string.getBytes(charset));
                            }
                        } else if (readableMap.hasKey(REQUEST_BODY_KEY_BASE64)) {
                            if (str4 == null) {
                                o.f(reactApplicationContextIfActiveOrWarn, i10, "Payload is set but no content-type header specified", (Throwable) null);
                                return;
                            } else {
                                requestBody = RequestBody.create(MediaType.parse(str4), ByteString.decodeBase64(readableMap.getString(REQUEST_BODY_KEY_BASE64)));
                            }
                        } else if (readableMap.hasKey(REQUEST_BODY_KEY_URI)) {
                            if (str4 == null) {
                                o.f(reactApplicationContextIfActiveOrWarn, i10, "Payload is set but no content-type header specified", (Throwable) null);
                                return;
                            }
                            String string2 = readableMap.getString(REQUEST_BODY_KEY_URI);
                            InputStream h10 = n.h(getReactApplicationContext(), string2);
                            if (h10 == null) {
                                o.f(reactApplicationContextIfActiveOrWarn, i10, "Could not retrieve file for uri " + string2, (Throwable) null);
                                return;
                            }
                            requestBody = n.c(MediaType.parse(str4), h10);
                        } else if (readableMap.hasKey(REQUEST_BODY_KEY_FORMDATA)) {
                            if (str4 == null) {
                                str4 = "multipart/form-data";
                            }
                            MultipartBody.Builder constructMultipartBody = constructMultipartBody(readableMap.getArray(REQUEST_BODY_KEY_FORMDATA), str4, i10);
                            if (constructMultipartBody != null) {
                                requestBody = constructMultipartBody.build();
                            } else {
                                return;
                            }
                        } else {
                            requestBody = n.g(str);
                        }
                        url.method(str, wrapRequestBodyWithProgressEmitter(requestBody, i10));
                        addRequest(i10);
                        build.newCall(url.build()).enqueue(new b(i10, reactApplicationContextIfActiveOrWarn, str3, z10));
                    }
                }
                requestBody = n.g(str);
                url.method(str, wrapRequestBodyWithProgressEmitter(requestBody, i10));
                addRequest(i10);
                build.newCall(url.build()).enqueue(new b(i10, reactApplicationContextIfActiveOrWarn, str3, z10));
            } catch (Exception e10) {
                o.f(reactApplicationContextIfActiveOrWarn, i10, e10.getMessage(), (Throwable) null);
            }
        } catch (IOException e11) {
            o.f(reactApplicationContextIfActiveOrWarn, i10, e11.getMessage(), e11);
        }
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, @Nullable String str, OkHttpClient okHttpClient) {
        this(reactApplicationContext, str, okHttpClient, (List<Object>) null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, (String) null, h.b(reactApplicationContext), (List<Object>) null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, List<Object> list) {
        this(reactApplicationContext, (String) null, h.b(reactApplicationContext), list);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
        this(reactApplicationContext, str, h.b(reactApplicationContext), (List<Object>) null);
    }
}
