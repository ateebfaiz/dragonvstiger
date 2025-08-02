package com.facebook.react.devsupport;

import androidx.core.app.NotificationCompat;
import com.facebook.react.devsupport.q0;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.BufferedSource;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f2984a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Call f2985b;

    /* renamed from: com.facebook.react.devsupport.a$a  reason: collision with other inner class name */
    class C0048a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k6.b f2986a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f2987b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f2988c;

        C0048a(k6.b bVar, File file, c cVar) {
            this.f2986a = bVar;
            this.f2987b = file;
            this.f2988c = cVar;
        }

        public void onFailure(Call call, IOException iOException) {
            if (a.this.f2985b == null || a.this.f2985b.isCanceled()) {
                a.this.f2985b = null;
                return;
            }
            a.this.f2985b = null;
            String httpUrl = call.request().url().toString();
            k6.b bVar = this.f2986a;
            bVar.onFailure(e6.c.a(httpUrl, "Could not connect to development server.", "URL: " + httpUrl, iOException));
        }

        public void onResponse(Call call, Response response) {
            ResponseBody body;
            try {
                if (a.this.f2985b != null) {
                    if (!a.this.f2985b.isCanceled()) {
                        a.this.f2985b = null;
                        String httpUrl = response.request().url().toString();
                        Matcher matcher = Pattern.compile("multipart/mixed;.*boundary=\"([^\"]+)\"").matcher(response.header("content-type"));
                        if (matcher.find()) {
                            a.this.i(httpUrl, response, matcher.group(1), this.f2987b, this.f2988c, this.f2986a);
                        } else {
                            body = response.body();
                            a.this.h(httpUrl, response.code(), response.headers(), response.body().source(), this.f2987b, this.f2988c, this.f2986a);
                            if (body != null) {
                                body.close();
                            }
                        }
                        response.close();
                        return;
                    }
                }
                a.this.f2985b = null;
                if (response != null) {
                    response.close();
                    return;
                }
                return;
                throw th;
                throw th;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
    }

    class b implements q0.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Response f2990a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2991b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f2992c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f2993d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ k6.b f2994e;

        b(Response response, String str, File file, c cVar, k6.b bVar) {
            this.f2990a = response;
            this.f2991b = str;
            this.f2992c = file;
            this.f2993d = cVar;
            this.f2994e = bVar;
        }

        public void a(Map map, long j10, long j11) {
            if ("application/javascript".equals(map.get("Content-Type"))) {
                this.f2994e.a("Downloading", Integer.valueOf((int) (j10 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE)), Integer.valueOf((int) (j11 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE)));
            }
        }

        public void b(Map map, Buffer buffer, boolean z10) {
            String str;
            Integer num;
            if (z10) {
                int code = this.f2990a.code();
                if (map.containsKey("X-Http-Status")) {
                    code = Integer.parseInt((String) map.get("X-Http-Status"));
                }
                a.this.h(this.f2991b, code, Headers.of((Map<String, String>) map), buffer, this.f2992c, this.f2993d, this.f2994e);
            } else if (map.containsKey("Content-Type") && ((String) map.get("Content-Type")).equals("application/json")) {
                try {
                    JSONObject jSONObject = new JSONObject(buffer.readUtf8());
                    if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                        str = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
                    } else {
                        str = "Bundling";
                    }
                    Integer num2 = null;
                    if (jSONObject.has("done")) {
                        num = Integer.valueOf(jSONObject.getInt("done"));
                    } else {
                        num = null;
                    }
                    if (jSONObject.has("total")) {
                        num2 = Integer.valueOf(jSONObject.getInt("total"));
                    }
                    this.f2994e.a(str, num, num2);
                } catch (JSONException e10) {
                    z2.a.j("ReactNative", "Error parsing progress JSON. " + e10.toString());
                }
            }
        }
    }

    public static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f2996a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f2997b;

        public String c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ImagesContract.URL, this.f2996a);
                jSONObject.put("filesChangedCount", this.f2997b);
                return jSONObject.toString();
            } catch (JSONException e10) {
                z2.a.k("BundleDownloader", "Can't serialize bundle info: ", e10);
                return null;
            }
        }
    }

    public a(OkHttpClient okHttpClient) {
        this.f2984a = okHttpClient;
    }

    private static void g(String str, Headers headers, c cVar) {
        cVar.f2996a = str;
        String str2 = headers.get("X-Metro-Files-Changed-Count");
        if (str2 != null) {
            try {
                cVar.f2997b = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                cVar.f2997b = -2;
            }
        }
    }

    /* access modifiers changed from: private */
    public void h(String str, int i10, Headers headers, BufferedSource bufferedSource, File file, c cVar, k6.b bVar) {
        if (i10 != 200) {
            String readUtf8 = bufferedSource.readUtf8();
            e6.c c10 = e6.c.c(str, readUtf8);
            if (c10 != null) {
                bVar.onFailure(c10);
                return;
            }
            bVar.onFailure(new e6.c("The development server returned response error code: " + i10 + "\n\n" + "URL: " + str + "\n\n" + "Body:\n" + readUtf8));
            return;
        }
        if (cVar != null) {
            g(str, headers, cVar);
        }
        File file2 = new File(file.getPath() + ".tmp");
        if (!j(bufferedSource, file2) || file2.renameTo(file)) {
            bVar.onSuccess();
            return;
        }
        throw new IOException("Couldn't rename " + file2 + " to " + file);
    }

    /* access modifiers changed from: private */
    public void i(String str, Response response, String str2, File file, c cVar, k6.b bVar) {
        if (!new q0(response.body().source(), str2).d(new b(response, str, file, cVar, bVar))) {
            bVar.onFailure(new e6.c("Error while reading multipart response.\n\nResponse code: " + response.code() + "\n\nURL: " + str.toString() + "\n\n"));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean j(okio.BufferedSource r0, java.io.File r1) {
        /*
            okio.Sink r1 = okio.Okio.sink((java.io.File) r1)     // Catch:{ all -> 0x0010 }
            r0.readAll(r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000c
            r1.close()
        L_0x000c:
            r0 = 1
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0017
            r1.close()
        L_0x0017:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.a.j(okio.BufferedSource, java.io.File):boolean");
    }

    public void e(k6.b bVar, File file, String str, c cVar) {
        f(bVar, file, str, cVar, new Request.Builder());
    }

    public void f(k6.b bVar, File file, String str, c cVar, Request.Builder builder) {
        Call call = (Call) p5.a.c(this.f2984a.newCall(builder.url(str).addHeader("Accept", "multipart/mixed").build()));
        this.f2985b = call;
        call.enqueue(new C0048a(bVar, file, cVar));
    }
}
