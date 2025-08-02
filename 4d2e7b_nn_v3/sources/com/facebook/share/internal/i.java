package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.p0;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f4527a = Pattern.compile("^(.+)\\.(facebook\\.com)$");

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4528a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f4529b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f4530c;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|5|6|7|9|10|11|12|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        static {
            /*
                com.facebook.share.model.ShareMessengerMediaTemplateContent$b[] r0 = com.facebook.share.model.ShareMessengerMediaTemplateContent.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4530c = r0
                r1 = 1
                com.facebook.share.model.ShareMessengerMediaTemplateContent$b r2 = com.facebook.share.model.ShareMessengerMediaTemplateContent.b.VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.facebook.share.model.ShareMessengerGenericTemplateContent$b[] r0 = com.facebook.share.model.ShareMessengerGenericTemplateContent.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4529b = r0
                com.facebook.share.model.ShareMessengerGenericTemplateContent$b r2 = com.facebook.share.model.ShareMessengerGenericTemplateContent.b.SQUARE     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                com.facebook.share.model.ShareMessengerURLActionButton$b[] r0 = com.facebook.share.model.ShareMessengerURLActionButton.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4528a = r0
                com.facebook.share.model.ShareMessengerURLActionButton$b r2 = com.facebook.share.model.ShareMessengerURLActionButton.b.WebviewHeightRatioCompact     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                int[] r0 = f4528a     // Catch:{ NoSuchFieldError -> 0x003f }
                com.facebook.share.model.ShareMessengerURLActionButton$b r1 = com.facebook.share.model.ShareMessengerURLActionButton.b.WebviewHeightRatioTall     // Catch:{ NoSuchFieldError -> 0x003f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003f }
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.i.a.<clinit>():void");
        }
    }

    private static void a(Bundle bundle, ShareMessengerActionButton shareMessengerActionButton, boolean z10) {
        Class<i> cls = i.class;
        if (!v5.a.d(cls) && shareMessengerActionButton != null) {
            try {
                if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                    h(bundle, (ShareMessengerURLActionButton) shareMessengerActionButton, z10);
                }
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static void b(Bundle bundle, ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        Class<i> cls = i.class;
        if (!v5.a.d(cls)) {
            try {
                c(bundle, shareMessengerGenericTemplateContent.h());
                p0.m0(bundle, "MESSENGER_PLATFORM_CONTENT", p(shareMessengerGenericTemplateContent));
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private static void c(Bundle bundle, ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
        Class<i> cls = i.class;
        if (!v5.a.d(cls)) {
            try {
                if (shareMessengerGenericTemplateElement.a() != null) {
                    a(bundle, shareMessengerGenericTemplateElement.a(), false);
                } else if (shareMessengerGenericTemplateElement.b() != null) {
                    a(bundle, shareMessengerGenericTemplateElement.b(), true);
                }
                p0.o0(bundle, "IMAGE", shareMessengerGenericTemplateElement.c());
                p0.n0(bundle, "PREVIEW_TYPE", "DEFAULT");
                p0.n0(bundle, "TITLE", shareMessengerGenericTemplateElement.e());
                p0.n0(bundle, "SUBTITLE", shareMessengerGenericTemplateElement.d());
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static void d(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        Class<i> cls = i.class;
        if (!v5.a.d(cls)) {
            try {
                e(bundle, shareMessengerMediaTemplateContent);
                p0.m0(bundle, "MESSENGER_PLATFORM_CONTENT", r(shareMessengerMediaTemplateContent));
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private static void e(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        Class<i> cls = i.class;
        if (!v5.a.d(cls)) {
            try {
                a(bundle, shareMessengerMediaTemplateContent.i(), false);
                p0.n0(bundle, "PREVIEW_TYPE", "DEFAULT");
                p0.n0(bundle, "ATTACHMENT_ID", shareMessengerMediaTemplateContent.h());
                if (shareMessengerMediaTemplateContent.k() != null) {
                    p0.o0(bundle, k(shareMessengerMediaTemplateContent.k()), shareMessengerMediaTemplateContent.k());
                }
                p0.n0(bundle, "type", j(shareMessengerMediaTemplateContent.j()));
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    public static void f(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        Class<i> cls = i.class;
        if (!v5.a.d(cls)) {
            try {
                g(bundle, shareMessengerOpenGraphMusicTemplateContent);
                p0.m0(bundle, "MESSENGER_PLATFORM_CONTENT", t(shareMessengerOpenGraphMusicTemplateContent));
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private static void g(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        Class<i> cls = i.class;
        if (!v5.a.d(cls)) {
            try {
                a(bundle, shareMessengerOpenGraphMusicTemplateContent.h(), false);
                p0.n0(bundle, "PREVIEW_TYPE", "OPEN_GRAPH");
                p0.o0(bundle, "OPEN_GRAPH_URL", shareMessengerOpenGraphMusicTemplateContent.i());
            } catch (Throwable th) {
                v5.a.b(th, cls);
            }
        }
    }

    private static void h(Bundle bundle, ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z10) {
        String str;
        Class<i> cls = i.class;
        if (!v5.a.d(cls)) {
            if (z10) {
                try {
                    str = p0.K(shareMessengerURLActionButton.e());
                } catch (Throwable th) {
                    v5.a.b(th, cls);
                    return;
                }
            } else {
                str = shareMessengerURLActionButton.a() + " - " + p0.K(shareMessengerURLActionButton.e());
            }
            p0.n0(bundle, "TARGET_DISPLAY", str);
            p0.o0(bundle, "ITEM_URL", shareMessengerURLActionButton.e());
        }
    }

    private static String i(ShareMessengerGenericTemplateContent.b bVar) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        if (bVar == null) {
            return "horizontal";
        }
        try {
            if (a.f4529b[bVar.ordinal()] != 1) {
                return "horizontal";
            }
            return "square";
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static String j(ShareMessengerMediaTemplateContent.b bVar) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        if (bVar == null) {
            return "image";
        }
        try {
            if (a.f4530c[bVar.ordinal()] != 1) {
                return "image";
            }
            return "video";
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static String k(Uri uri) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            String host = uri.getHost();
            if (p0.Y(host) || !f4527a.matcher(host).matches()) {
                return "IMAGE";
            }
            return "uri";
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static String l(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            if (shareMessengerURLActionButton.d()) {
                return "hide";
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static String m(ShareMessengerURLActionButton.b bVar) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        if (bVar == null) {
            return "full";
        }
        try {
            int i10 = a.f4528a[bVar.ordinal()];
            if (i10 == 1) {
                return "compact";
            }
            if (i10 != 2) {
                return "full";
            }
            return "tall";
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static JSONObject n(ShareMessengerActionButton shareMessengerActionButton) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return o(shareMessengerActionButton, false);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static JSONObject o(ShareMessengerActionButton shareMessengerActionButton, boolean z10) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                return v((ShareMessengerURLActionButton) shareMessengerActionButton, z10);
            }
            return null;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static JSONObject p(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put("template_type", "generic").put("sharable", shareMessengerGenericTemplateContent.j()).put("image_aspect_ratio", i(shareMessengerGenericTemplateContent.i())).put("elements", new JSONArray().put(q(shareMessengerGenericTemplateContent.h())))));
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static JSONObject q(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put("title", shareMessengerGenericTemplateElement.e()).put("subtitle", shareMessengerGenericTemplateElement.d()).put("image_url", p0.K(shareMessengerGenericTemplateElement.c()));
            if (shareMessengerGenericTemplateElement.a() != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(n(shareMessengerGenericTemplateElement.a()));
                put.put("buttons", jSONArray);
            }
            if (shareMessengerGenericTemplateElement.b() != null) {
                put.put("default_action", o(shareMessengerGenericTemplateElement.b(), true));
            }
            return put;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static JSONObject r(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put("template_type", "media").put("elements", new JSONArray().put(s(shareMessengerMediaTemplateContent)))));
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static JSONObject s(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put("attachment_id", shareMessengerMediaTemplateContent.h()).put(ImagesContract.URL, p0.K(shareMessengerMediaTemplateContent.k())).put("media_type", j(shareMessengerMediaTemplateContent.j()));
            if (shareMessengerMediaTemplateContent.i() != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(n(shareMessengerMediaTemplateContent.i()));
                put.put("buttons", jSONArray);
            }
            return put;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static JSONObject t(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            return new JSONObject().put("attachment", new JSONObject().put("type", "template").put("payload", new JSONObject().put("template_type", "open_graph").put("elements", new JSONArray().put(u(shareMessengerOpenGraphMusicTemplateContent)))));
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static JSONObject u(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put(ImagesContract.URL, p0.K(shareMessengerOpenGraphMusicTemplateContent.i()));
            if (shareMessengerOpenGraphMusicTemplateContent.h() != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(n(shareMessengerOpenGraphMusicTemplateContent.h()));
                put.put("buttons", jSONArray);
            }
            return put;
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }

    private static JSONObject v(ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z10) {
        String str;
        Class<i> cls = i.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put("type", "web_url");
            if (z10) {
                str = null;
            } else {
                str = shareMessengerURLActionButton.a();
            }
            return put.put("title", str).put(ImagesContract.URL, p0.K(shareMessengerURLActionButton.e())).put("webview_height_ratio", m(shareMessengerURLActionButton.f())).put("messenger_extensions", shareMessengerURLActionButton.c()).put("fallback_url", p0.K(shareMessengerURLActionButton.b())).put("webview_share_button", l(shareMessengerURLActionButton));
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }
}
