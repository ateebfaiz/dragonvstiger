package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.l;
import com.facebook.n;
import com.facebook.o;
import com.facebook.share.internal.l;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView;
import com.facebook.u;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import com.reactnativecommunity.clipboard.ClipboardModule;
import e2.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.d;
import q5.e0;
import q5.f0;
import q5.p0;

public abstract class p {

    static class a implements p0.b {
        a() {
        }

        /* renamed from: a */
        public Bundle apply(e0.a aVar) {
            Bundle bundle = new Bundle();
            bundle.putString("uri", aVar.b());
            String o10 = p.o(aVar.e());
            if (o10 != null) {
                p0.n0(bundle, "extension", o10);
            }
            return bundle;
        }
    }

    static class b implements p0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UUID f4550a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f4551b;

        b(UUID uuid, List list) {
            this.f4550a = uuid;
            this.f4551b = list;
        }

        /* renamed from: a */
        public Bundle apply(ShareMedia shareMedia) {
            e0.a a10 = p.a(this.f4550a, shareMedia);
            this.f4551b.add(a10);
            Bundle bundle = new Bundle();
            bundle.putString("type", shareMedia.a().name());
            bundle.putString("uri", a10.b());
            String o10 = p.o(a10.e());
            if (o10 != null) {
                p0.n0(bundle, "extension", o10);
            }
            return bundle;
        }
    }

    static class c extends m {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.facebook.j f4552b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(com.facebook.j jVar, com.facebook.j jVar2) {
            super(jVar);
            this.f4552b = jVar2;
        }

        public void a(q5.a aVar) {
            p.r(this.f4552b);
        }

        public void b(q5.a aVar, l lVar) {
            p.s(this.f4552b, lVar);
        }

        public void c(q5.a aVar, Bundle bundle) {
            if (bundle != null) {
                String i10 = p.i(bundle);
                if (i10 == null || "post".equalsIgnoreCase(i10)) {
                    String k10 = p.k(bundle);
                    if (k10 != null) {
                        p.t(this.f4552b, k10);
                    } else {
                        p.s(this.f4552b, new l("UnknownError"));
                    }
                } else if ("cancel".equalsIgnoreCase(i10)) {
                    p.r(this.f4552b);
                } else {
                    p.s(this.f4552b, new l("UnknownError"));
                }
            }
        }
    }

    static class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4553a;

        d(int i10) {
            this.f4553a = i10;
        }

        public boolean a(int i10, Intent intent) {
            return p.q(this.f4553a, i10, intent, p.l((com.facebook.j) null));
        }
    }

    static class e implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4554a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.facebook.j f4555b;

        e(int i10, com.facebook.j jVar) {
            this.f4554a = i10;
            this.f4555b = jVar;
        }

        public boolean a(int i10, Intent intent) {
            return p.q(this.f4554a, i10, intent, p.l(this.f4555b));
        }
    }

    static class f implements p0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UUID f4556a;

        f(UUID uuid) {
            this.f4556a = uuid;
        }

        /* renamed from: a */
        public e0.a apply(SharePhoto sharePhoto) {
            return p.a(this.f4556a, sharePhoto);
        }
    }

    static class g implements p0.b {
        g() {
        }

        /* renamed from: a */
        public String apply(e0.a aVar) {
            return aVar.b();
        }
    }

    static class h implements p0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UUID f4557a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f4558b;

        h(UUID uuid, List list) {
            this.f4557a = uuid;
            this.f4558b = list;
        }

        /* renamed from: a */
        public Bundle apply(ShareMedia shareMedia) {
            e0.a a10 = p.a(this.f4557a, shareMedia);
            this.f4558b.add(a10);
            Bundle bundle = new Bundle();
            bundle.putString("type", shareMedia.a().name());
            bundle.putString("uri", a10.b());
            return bundle;
        }
    }

    static class i implements l.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UUID f4559a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f4560b;

        i(UUID uuid, ArrayList arrayList) {
            this.f4559a = uuid;
            this.f4560b = arrayList;
        }

        public JSONObject a(SharePhoto sharePhoto) {
            e0.a a10 = p.a(this.f4559a, sharePhoto);
            if (a10 == null) {
                return null;
            }
            this.f4560b.add(a10);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ImagesContract.URL, a10.b());
                if (sharePhoto.f()) {
                    jSONObject.put("user_generated", true);
                }
                return jSONObject;
            } catch (JSONException e10) {
                throw new com.facebook.l("Unable to attach images", (Throwable) e10);
            }
        }
    }

    static class j implements l.a {
        j() {
        }

        public JSONObject a(SharePhoto sharePhoto) {
            Uri e10 = sharePhoto.e();
            if (p0.a0(e10)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ImagesContract.URL, e10.toString());
                    return jSONObject;
                } catch (JSONException e11) {
                    throw new com.facebook.l("Unable to attach images", (Throwable) e11);
                }
            } else {
                throw new com.facebook.l("Only web images may be used in OG objects shared via the web dialog");
            }
        }
    }

    static class k implements p0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UUID f4561a;

        k(UUID uuid) {
            this.f4561a = uuid;
        }

        /* renamed from: a */
        public e0.a apply(SharePhoto sharePhoto) {
            return p.a(this.f4561a, sharePhoto);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:39|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
        throw new com.facebook.l("Failed to create json object from share content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0099, code lost:
        v5.a.b(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009c, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0091 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject A(org.json.JSONObject r11, boolean r12) {
        /*
            java.lang.Class<com.facebook.share.internal.p> r0 = com.facebook.share.internal.p.class
            boolean r1 = v5.a.d(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            if (r11 != 0) goto L_0x000d
            return r2
        L_0x000d:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0091 }
            r1.<init>()     // Catch:{ JSONException -> 0x0091 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0091 }
            r3.<init>()     // Catch:{ JSONException -> 0x0091 }
            org.json.JSONArray r4 = r11.names()     // Catch:{ JSONException -> 0x0091 }
            r5 = 0
        L_0x001c:
            int r6 = r4.length()     // Catch:{ JSONException -> 0x0091 }
            if (r5 >= r6) goto L_0x0085
            java.lang.String r6 = r4.getString(r5)     // Catch:{ JSONException -> 0x0091 }
            java.lang.Object r7 = r11.get(r6)     // Catch:{ JSONException -> 0x0091 }
            boolean r8 = r7 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0091 }
            r9 = 1
            if (r8 == 0) goto L_0x0038
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x0091 }
            org.json.JSONObject r7 = A(r7, r9)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0042
        L_0x0036:
            r11 = move-exception
            goto L_0x0099
        L_0x0038:
            boolean r8 = r7 instanceof org.json.JSONArray     // Catch:{ JSONException -> 0x0091 }
            if (r8 == 0) goto L_0x0042
            org.json.JSONArray r7 = (org.json.JSONArray) r7     // Catch:{ JSONException -> 0x0091 }
            org.json.JSONArray r7 = z(r7, r9)     // Catch:{ JSONException -> 0x0091 }
        L_0x0042:
            android.util.Pair r8 = f(r6)     // Catch:{ JSONException -> 0x0091 }
            java.lang.Object r9 = r8.first     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ JSONException -> 0x0091 }
            java.lang.Object r8 = r8.second     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x0091 }
            if (r12 == 0) goto L_0x0071
            if (r9 == 0) goto L_0x005e
            java.lang.String r10 = "fbsdk"
            boolean r10 = r9.equals(r10)     // Catch:{ JSONException -> 0x0091 }
            if (r10 == 0) goto L_0x005e
            r1.put(r6, r7)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0082
        L_0x005e:
            if (r9 == 0) goto L_0x006d
            java.lang.String r6 = "og"
            boolean r6 = r9.equals(r6)     // Catch:{ JSONException -> 0x0091 }
            if (r6 == 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            r3.put(r8, r7)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0082
        L_0x006d:
            r1.put(r8, r7)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0082
        L_0x0071:
            if (r9 == 0) goto L_0x007f
            java.lang.String r10 = "fb"
            boolean r9 = r9.equals(r10)     // Catch:{ JSONException -> 0x0091 }
            if (r9 == 0) goto L_0x007f
            r1.put(r6, r7)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0082
        L_0x007f:
            r1.put(r8, r7)     // Catch:{ JSONException -> 0x0091 }
        L_0x0082:
            int r5 = r5 + 1
            goto L_0x001c
        L_0x0085:
            int r11 = r3.length()     // Catch:{ JSONException -> 0x0091 }
            if (r11 <= 0) goto L_0x0090
            java.lang.String r11 = "data"
            r1.put(r11, r3)     // Catch:{ JSONException -> 0x0091 }
        L_0x0090:
            return r1
        L_0x0091:
            com.facebook.l r11 = new com.facebook.l     // Catch:{ all -> 0x0036 }
            java.lang.String r12 = "Failed to create json object from share content"
            r11.<init>((java.lang.String) r12)     // Catch:{ all -> 0x0036 }
            throw r11     // Catch:{ all -> 0x0036 }
        L_0x0099:
            v5.a.b(r11, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.p.A(org.json.JSONObject, boolean):org.json.JSONObject");
    }

    public static JSONObject B(UUID uuid, ShareOpenGraphContent shareOpenGraphContent) {
        Set set;
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            ShareOpenGraphAction h10 = shareOpenGraphContent.h();
            ArrayList arrayList = new ArrayList();
            JSONObject b10 = l.b(h10, new i(uuid, arrayList));
            e0.a(arrayList);
            if (shareOpenGraphContent.d() != null && p0.Y(b10.optString("place"))) {
                b10.put("place", shareOpenGraphContent.d());
            }
            if (shareOpenGraphContent.c() != null) {
                JSONArray optJSONArray = b10.optJSONArray("tags");
                if (optJSONArray == null) {
                    set = new HashSet();
                } else {
                    set = p0.b0(optJSONArray);
                }
                for (String add : shareOpenGraphContent.c()) {
                    set.add(add);
                }
                b10.put("tags", new JSONArray(set));
            }
            return b10;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static JSONObject C(ShareOpenGraphContent shareOpenGraphContent) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return l.b(shareOpenGraphContent.h(), new j());
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    static /* synthetic */ e0.a a(UUID uuid, ShareMedia shareMedia) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return d(uuid, shareMedia);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static q5.a b(int i10, int i11, Intent intent) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            UUID t10 = f0.t(intent);
            if (t10 == null) {
                return null;
            }
            return q5.a.c(t10, i10);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static e0.a c(UUID uuid, Uri uri, Bitmap bitmap) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        if (bitmap != null) {
            try {
                return e0.d(uuid, bitmap);
            } catch (Throwable th) {
                v5.a.b(th, cls);
                return null;
            }
        } else if (uri != null) {
            return e0.e(uuid, uri);
        } else {
            return null;
        }
    }

    private static e0.a d(UUID uuid, ShareMedia shareMedia) {
        Uri uri;
        Bitmap bitmap;
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            if (shareMedia instanceof SharePhoto) {
                SharePhoto sharePhoto = (SharePhoto) shareMedia;
                bitmap = sharePhoto.c();
                uri = sharePhoto.e();
            } else if (shareMedia instanceof ShareVideo) {
                uri = ((ShareVideo) shareMedia).c();
                bitmap = null;
            } else {
                uri = null;
                bitmap = null;
            }
            return c(uuid, uri, bitmap);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static Bundle e(ShareStoryContent shareStoryContent, UUID uuid) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls) && shareStoryContent != null) {
            try {
                if (shareStoryContent.i() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(shareStoryContent.i());
                    ArrayList arrayList2 = new ArrayList();
                    List h02 = p0.h0(arrayList, new b(uuid, arrayList2));
                    e0.a(arrayList2);
                    return (Bundle) h02.get(0);
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
        return null;
    }

    public static Pair f(String str) {
        String str2;
        int i10;
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || str.length() <= (i10 = indexOf + 1)) {
                str2 = null;
            } else {
                str2 = str.substring(0, indexOf);
                str = str.substring(i10);
            }
            return new Pair(str2, str);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static List g(ShareMediaContent shareMediaContent, UUID uuid) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls) && shareMediaContent != null) {
            try {
                List h10 = shareMediaContent.h();
                if (h10 != null) {
                    ArrayList arrayList = new ArrayList();
                    List h02 = p0.h0(h10, new h(uuid, arrayList));
                    e0.a(arrayList);
                    return h02;
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
        return null;
    }

    public static LikeView.g h(LikeView.g gVar, LikeView.g gVar2) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        if (gVar == gVar2) {
            return gVar;
        }
        try {
            LikeView.g gVar3 = LikeView.g.UNKNOWN;
            if (gVar == gVar3) {
                return gVar2;
            }
            if (gVar2 == gVar3) {
                return gVar;
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static String i(Bundle bundle) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            if (bundle.containsKey("completionGesture")) {
                return bundle.getString("completionGesture");
            }
            return bundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static List j(SharePhotoContent sharePhotoContent, UUID uuid) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls) && sharePhotoContent != null) {
            try {
                List h10 = sharePhotoContent.h();
                if (h10 != null) {
                    List h02 = p0.h0(h10, new f(uuid));
                    List h03 = p0.h0(h02, new g());
                    e0.a(h02);
                    return h03;
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
        return null;
    }

    public static String k(Bundle bundle) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            if (bundle.containsKey("postId")) {
                return bundle.getString("postId");
            }
            if (bundle.containsKey("com.facebook.platform.extra.POST_ID")) {
                return bundle.getString("com.facebook.platform.extra.POST_ID");
            }
            return bundle.getString("post_id");
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static m l(com.facebook.j jVar) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return new c(jVar, jVar);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static Bundle m(ShareStoryContent shareStoryContent, UUID uuid) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls) && shareStoryContent != null) {
            try {
                if (shareStoryContent.k() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(shareStoryContent.k());
                    List h02 = p0.h0(arrayList, new k(uuid));
                    List h03 = p0.h0(h02, new a());
                    e0.a(h02);
                    return (Bundle) h03.get(0);
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
        return null;
    }

    public static Bundle n(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls) && shareCameraEffectContent != null) {
            try {
                CameraEffectTextures j10 = shareCameraEffectContent.j();
                if (j10 != null) {
                    Bundle bundle = new Bundle();
                    ArrayList arrayList = new ArrayList();
                    for (String str : j10.d()) {
                        e0.a c10 = c(uuid, j10.c(str), j10.b(str));
                        arrayList.add(c10);
                        bundle.putString(str, c10.b());
                    }
                    e0.a(arrayList);
                    return bundle;
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
        return null;
    }

    public static String o(Uri uri) {
        Class<p> cls = p.class;
        if (v5.a.d(cls) || uri == null) {
            return null;
        }
        try {
            String uri2 = uri.toString();
            int lastIndexOf = uri2.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return null;
            }
            return uri2.substring(lastIndexOf);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static String p(ShareVideoContent shareVideoContent, UUID uuid) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls) && shareVideoContent != null) {
            try {
                if (shareVideoContent.k() != null) {
                    e0.a e10 = e0.e(uuid, shareVideoContent.k().c());
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(e10);
                    e0.a(arrayList);
                    return e10.b();
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
        return null;
    }

    public static boolean q(int i10, int i11, Intent intent, m mVar) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return false;
        }
        try {
            q5.a b10 = b(i10, i11, intent);
            if (b10 == null) {
                return false;
            }
            e0.c(b10.d());
            if (mVar == null) {
                return true;
            }
            com.facebook.l v10 = f0.v(f0.u(intent));
            if (v10 == null) {
                mVar.c(b10, f0.C(intent));
            } else if (v10 instanceof n) {
                mVar.a(b10);
            } else {
                mVar.b(b10, v10);
            }
            return true;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return false;
        }
    }

    static void r(com.facebook.j jVar) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls)) {
            try {
                u("cancelled", (String) null);
                if (jVar != null) {
                    jVar.onCancel();
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    static void s(com.facebook.j jVar, com.facebook.l lVar) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls)) {
            try {
                u(Constants.IPC_BUNDLE_KEY_SEND_ERROR, lVar.getMessage());
                if (jVar != null) {
                    jVar.a(lVar);
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    static void t(com.facebook.j jVar, String str) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls)) {
            try {
                u("succeeded", (String) null);
                if (jVar != null) {
                    jVar.onSuccess(new y7.c(str));
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private static void u(String str, String str2) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls)) {
            try {
                m mVar = new m(o.f());
                Bundle bundle = new Bundle();
                bundle.putString("fb_share_dialog_outcome", str);
                if (str2 != null) {
                    bundle.putString("error_message", str2);
                }
                mVar.g("fb_share_dialog_result", bundle);
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static GraphRequest v(AccessToken accessToken, Uri uri, GraphRequest.b bVar) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            if (p0.W(uri)) {
                return w(accessToken, new File(uri.getPath()), bVar);
            }
            if (p0.T(uri)) {
                GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType((Parcelable) uri, ClipboardModule.MIMETYPE_PNG);
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("file", parcelableResourceWithMimeType);
                return new GraphRequest(accessToken, "me/staging_resources", bundle, u.POST, bVar);
            }
            throw new com.facebook.l("The image Uri must be either a file:// or content:// Uri");
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static GraphRequest w(AccessToken accessToken, File file, GraphRequest.b bVar) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType((Parcelable) ParcelFileDescriptor.open(file, GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR), ClipboardModule.MIMETYPE_PNG);
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, "me/staging_resources", bundle, u.POST, bVar);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    public static void x(int i10, com.facebook.g gVar, com.facebook.j jVar) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls)) {
            try {
                if (gVar instanceof q5.d) {
                    ((q5.d) gVar).c(i10, new e(i10, jVar));
                    return;
                }
                throw new com.facebook.l("Unexpected CallbackManager, please use the provided Factory.");
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static void y(int i10) {
        Class<p> cls = p.class;
        if (!v5.a.d(cls)) {
            try {
                q5.d.d(i10, new d(i10));
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static JSONArray z(JSONArray jSONArray, boolean z10) {
        Class<p> cls = p.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                Object obj = jSONArray.get(i10);
                if (obj instanceof JSONArray) {
                    obj = z((JSONArray) obj, z10);
                } else if (obj instanceof JSONObject) {
                    obj = A((JSONObject) obj, z10);
                }
                jSONArray2.put(obj);
            }
            return jSONArray2;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }
}
