package com.facebook;

import android.util.Log;
import com.facebook.AccessToken;
import com.google.firebase.messaging.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import q5.d0;
import q5.p0;

public final class t {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String f20946i = t.class.getCanonicalName();

    /* renamed from: j  reason: collision with root package name */
    public static final a f20947j = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f20948a;

    /* renamed from: b  reason: collision with root package name */
    private final JSONArray f20949b;

    /* renamed from: c  reason: collision with root package name */
    private final GraphRequest f20950c;

    /* renamed from: d  reason: collision with root package name */
    private final HttpURLConnection f20951d;

    /* renamed from: e  reason: collision with root package name */
    private final String f20952e;

    /* renamed from: f  reason: collision with root package name */
    private final JSONObject f20953f;

    /* renamed from: g  reason: collision with root package name */
    private final JSONArray f20954g;

    /* renamed from: h  reason: collision with root package name */
    private final FacebookRequestError f20955h;

    public static final class a {
        private a() {
        }

        private final t b(GraphRequest graphRequest, HttpURLConnection httpURLConnection, Object obj, Object obj2) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                FacebookRequestError a10 = FacebookRequestError.N0.a(jSONObject, obj2, httpURLConnection);
                if (a10 != null) {
                    Log.e(t.f20946i, a10.toString());
                    if (a10.b() == 190 && p0.U(graphRequest.k())) {
                        if (a10.h() != 493) {
                            AccessToken.N0.i((AccessToken) null);
                        } else {
                            AccessToken.c cVar = AccessToken.N0;
                            AccessToken e10 = cVar.e();
                            if (e10 != null && !e10.p()) {
                                cVar.d();
                            }
                        }
                    }
                    return new t(graphRequest, httpURLConnection, a10);
                }
                Object J = p0.J(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                if (J instanceof JSONObject) {
                    return new t(graphRequest, httpURLConnection, J.toString(), (JSONObject) J);
                }
                if (J instanceof JSONArray) {
                    return new t(graphRequest, httpURLConnection, J.toString(), (JSONArray) J);
                }
                obj = JSONObject.NULL;
                m.e(obj, "JSONObject.NULL");
            }
            if (obj == JSONObject.NULL) {
                return new t(graphRequest, httpURLConnection, obj.toString(), (JSONObject) null);
            }
            throw new l("Got unexpected object type in response, class: " + obj.getClass().getSimpleName());
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.List c(java.net.HttpURLConnection r9, java.util.List r10, java.lang.Object r11) {
            /*
                r8 = this;
                int r0 = r10.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 1
                r3 = 0
                if (r0 != r2) goto L_0x0053
                java.lang.Object r2 = r10.get(r3)
                com.facebook.GraphRequest r2 = (com.facebook.GraphRequest) r2
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
                r4.<init>()     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
                java.lang.String r5 = "body"
                r4.put(r5, r11)     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
                if (r9 == 0) goto L_0x0028
                int r5 = r9.getResponseCode()     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
                goto L_0x002a
            L_0x0024:
                r4 = move-exception
                goto L_0x0038
            L_0x0026:
                r4 = move-exception
                goto L_0x0046
            L_0x0028:
                r5 = 200(0xc8, float:2.8E-43)
            L_0x002a:
                java.lang.String r6 = "code"
                r4.put(r6, r5)     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
                org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
                r5.<init>()     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
                r5.put(r4)     // Catch:{ JSONException -> 0x0026, IOException -> 0x0024 }
                goto L_0x0054
            L_0x0038:
                com.facebook.t r5 = new com.facebook.t
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r5.<init>(r2, r9, r6)
                r1.add(r5)
                goto L_0x0053
            L_0x0046:
                com.facebook.t r5 = new com.facebook.t
                com.facebook.FacebookRequestError r6 = new com.facebook.FacebookRequestError
                r6.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r5.<init>(r2, r9, r6)
                r1.add(r5)
            L_0x0053:
                r5 = r11
            L_0x0054:
                boolean r2 = r5 instanceof org.json.JSONArray
                if (r2 == 0) goto L_0x00a4
                r2 = r5
                org.json.JSONArray r2 = (org.json.JSONArray) r2
                int r4 = r2.length()
                if (r4 != r0) goto L_0x00a4
                int r0 = r2.length()
            L_0x0065:
                if (r3 >= r0) goto L_0x00a3
                java.lang.Object r2 = r10.get(r3)
                com.facebook.GraphRequest r2 = (com.facebook.GraphRequest) r2
                r4 = r5
                org.json.JSONArray r4 = (org.json.JSONArray) r4     // Catch:{ JSONException -> 0x0083, l -> 0x0081 }
                java.lang.Object r4 = r4.get(r3)     // Catch:{ JSONException -> 0x0083, l -> 0x0081 }
                java.lang.String r6 = "obj"
                kotlin.jvm.internal.m.e(r4, r6)     // Catch:{ JSONException -> 0x0083, l -> 0x0081 }
                com.facebook.t r4 = r8.b(r2, r9, r4, r11)     // Catch:{ JSONException -> 0x0083, l -> 0x0081 }
                r1.add(r4)     // Catch:{ JSONException -> 0x0083, l -> 0x0081 }
                goto L_0x00a0
            L_0x0081:
                r4 = move-exception
                goto L_0x0085
            L_0x0083:
                r4 = move-exception
                goto L_0x0093
            L_0x0085:
                com.facebook.t r6 = new com.facebook.t
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                r7.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r6.<init>(r2, r9, r7)
                r1.add(r6)
                goto L_0x00a0
            L_0x0093:
                com.facebook.t r6 = new com.facebook.t
                com.facebook.FacebookRequestError r7 = new com.facebook.FacebookRequestError
                r7.<init>((java.net.HttpURLConnection) r9, (java.lang.Exception) r4)
                r6.<init>(r2, r9, r7)
                r1.add(r6)
            L_0x00a0:
                int r3 = r3 + 1
                goto L_0x0065
            L_0x00a3:
                return r1
            L_0x00a4:
                com.facebook.l r9 = new com.facebook.l
                java.lang.String r10 = "Unexpected number of results"
                r9.<init>((java.lang.String) r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.t.a.c(java.net.HttpURLConnection, java.util.List, java.lang.Object):java.util.List");
        }

        public final List a(List list, HttpURLConnection httpURLConnection, l lVar) {
            m.f(list, "requests");
            Iterable<GraphRequest> iterable = list;
            ArrayList arrayList = new ArrayList(r.v(iterable, 10));
            for (GraphRequest tVar : iterable) {
                arrayList.add(new t(tVar, httpURLConnection, new FacebookRequestError(httpURLConnection, (Exception) lVar)));
            }
            return arrayList;
        }

        public final List d(InputStream inputStream, HttpURLConnection httpURLConnection, s sVar) {
            m.f(sVar, "requests");
            String p02 = p0.p0(inputStream);
            d0.f23283f.c(w.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(p02.length()), p02);
            return e(p02, httpURLConnection, sVar);
        }

        public final List e(String str, HttpURLConnection httpURLConnection, s sVar) {
            m.f(str, "responseString");
            m.f(sVar, "requests");
            Object nextValue = new JSONTokener(str).nextValue();
            m.e(nextValue, "resultObject");
            List c10 = c(httpURLConnection, sVar, nextValue);
            d0.f23283f.c(w.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", sVar.o(), Integer.valueOf(str.length()), c10);
            return c10;
        }

        public final List f(HttpURLConnection httpURLConnection, s sVar) {
            List list;
            m.f(httpURLConnection, "connection");
            m.f(sVar, "requests");
            InputStream inputStream = null;
            try {
                if (o.z()) {
                    if (httpURLConnection.getResponseCode() >= 400) {
                        inputStream = httpURLConnection.getErrorStream();
                    } else {
                        inputStream = httpURLConnection.getInputStream();
                    }
                    list = d(inputStream, httpURLConnection, sVar);
                    p0.i(inputStream);
                    return list;
                }
                Log.e(t.f20946i, "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                throw new l("GraphRequest can't be used when Facebook SDK isn't fully initialized");
            } catch (l e10) {
                d0.f23283f.c(w.REQUESTS, "Response", "Response <Error>: %s", e10);
                list = a(sVar, httpURLConnection, e10);
            } catch (Exception e11) {
                d0.f23283f.c(w.REQUESTS, "Response", "Response <Error>: %s", e11);
                list = a(sVar, httpURLConnection, new l((Throwable) e11));
            } catch (Throwable th) {
                p0.i((Closeable) null);
                throw th;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public t(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        m.f(graphRequest, "request");
        this.f20950c = graphRequest;
        this.f20951d = httpURLConnection;
        this.f20952e = str;
        this.f20953f = jSONObject;
        this.f20954g = jSONArray;
        this.f20955h = facebookRequestError;
        this.f20948a = jSONObject;
        this.f20949b = jSONArray;
    }

    public final FacebookRequestError b() {
        return this.f20955h;
    }

    public final JSONObject c() {
        return this.f20953f;
    }

    public final JSONObject d() {
        return this.f20948a;
    }

    public String toString() {
        String str;
        int i10;
        try {
            b0 b0Var = b0.f709a;
            Locale locale = Locale.US;
            HttpURLConnection httpURLConnection = this.f20951d;
            if (httpURLConnection != null) {
                i10 = httpURLConnection.getResponseCode();
            } else {
                i10 = 200;
            }
            str = String.format(locale, "%d", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
            m.e(str, "java.lang.String.format(locale, format, *args)");
        } catch (IOException unused) {
            str = "unknown";
        }
        String str2 = "{Response: " + " responseCode: " + str + ", graphObject: " + this.f20953f + ", error: " + this.f20955h + "}";
        m.e(str2, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public t(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject) {
        this(graphRequest, httpURLConnection, str, jSONObject, (JSONArray) null, (FacebookRequestError) null);
        m.f(graphRequest, "request");
        m.f(str, "rawResponse");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public t(GraphRequest graphRequest, HttpURLConnection httpURLConnection, String str, JSONArray jSONArray) {
        this(graphRequest, httpURLConnection, str, (JSONObject) null, jSONArray, (FacebookRequestError) null);
        m.f(graphRequest, "request");
        m.f(str, "rawResponse");
        m.f(jSONArray, "graphObjects");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public t(GraphRequest graphRequest, HttpURLConnection httpURLConnection, FacebookRequestError facebookRequestError) {
        this(graphRequest, httpURLConnection, (String) null, (JSONObject) null, (JSONArray) null, facebookRequestError);
        m.f(graphRequest, "request");
        m.f(facebookRequestError, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
    }
}
