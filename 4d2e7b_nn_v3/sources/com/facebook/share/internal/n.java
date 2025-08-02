package com.facebook.share.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.l;
import com.facebook.o;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import q5.p0;
import q5.q0;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final c f4536a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final c f4537b = new c();

    /* renamed from: c  reason: collision with root package name */
    private static final c f4538c = new a();

    /* renamed from: d  reason: collision with root package name */
    private static final c f4539d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final n f4540e = new n();

    private static final class a extends c {
        public void c(ShareLinkContent shareLinkContent) {
            m.f(shareLinkContent, "linkContent");
            if (!p0.Y(shareLinkContent.k())) {
                throw new l("Cannot share link content with quote using the share api");
            }
        }

        public void e(ShareMediaContent shareMediaContent) {
            m.f(shareMediaContent, "mediaContent");
            throw new l("Cannot share ShareMediaContent using the share api");
        }

        public void m(SharePhoto sharePhoto) {
            m.f(sharePhoto, "photo");
            n.f4540e.J(sharePhoto, this);
        }

        public void q(ShareVideoContent shareVideoContent) {
            m.f(shareVideoContent, "videoContent");
            if (!p0.Y(shareVideoContent.d())) {
                throw new l("Cannot share video content with place IDs using the share api");
            } else if (!p0.Z(shareVideoContent.c())) {
                throw new l("Cannot share video content with people IDs using the share api");
            } else if (!p0.Y(shareVideoContent.e())) {
                throw new l("Cannot share video content with referrer URL using the share api");
            }
        }
    }

    private static final class b extends c {
        public void o(ShareStoryContent shareStoryContent) {
            n.f4540e.Q(shareStoryContent, this);
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4541a;

        public final boolean a() {
            return this.f4541a;
        }

        public void b(ShareCameraEffectContent shareCameraEffectContent) {
            m.f(shareCameraEffectContent, "cameraEffectContent");
            n.f4540e.s(shareCameraEffectContent);
        }

        public void c(ShareLinkContent shareLinkContent) {
            m.f(shareLinkContent, "linkContent");
            n.f4540e.x(shareLinkContent, this);
        }

        public void d(ShareMedia shareMedia) {
            m.f(shareMedia, "medium");
            n.z(shareMedia, this);
        }

        public void e(ShareMediaContent shareMediaContent) {
            m.f(shareMediaContent, "mediaContent");
            n.f4540e.y(shareMediaContent, this);
        }

        public void f(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            m.f(shareMessengerGenericTemplateContent, FirebaseAnalytics.Param.CONTENT);
            n.f4540e.N(shareMessengerGenericTemplateContent);
        }

        public void g(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            m.f(shareMessengerMediaTemplateContent, FirebaseAnalytics.Param.CONTENT);
            n.f4540e.O(shareMessengerMediaTemplateContent);
        }

        public void h(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            m.f(shareMessengerOpenGraphMusicTemplateContent, FirebaseAnalytics.Param.CONTENT);
            n.f4540e.A(shareMessengerOpenGraphMusicTemplateContent);
        }

        public void i(ShareOpenGraphAction shareOpenGraphAction) {
            n.f4540e.B(shareOpenGraphAction, this);
        }

        public void j(ShareOpenGraphContent shareOpenGraphContent) {
            m.f(shareOpenGraphContent, "openGraphContent");
            this.f4541a = true;
            n.f4540e.C(shareOpenGraphContent, this);
        }

        public void k(ShareOpenGraphObject shareOpenGraphObject) {
            n.f4540e.E(shareOpenGraphObject, this);
        }

        public void l(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z10) {
            m.f(shareOpenGraphValueContainer, "openGraphValueContainer");
            n.f4540e.F(shareOpenGraphValueContainer, this, z10);
        }

        public void m(SharePhoto sharePhoto) {
            m.f(sharePhoto, "photo");
            n.f4540e.K(sharePhoto, this);
        }

        public void n(SharePhotoContent sharePhotoContent) {
            m.f(sharePhotoContent, "photoContent");
            n.f4540e.I(sharePhotoContent, this);
        }

        public void o(ShareStoryContent shareStoryContent) {
            n.f4540e.Q(shareStoryContent, this);
        }

        public void p(ShareVideo shareVideo) {
            n.f4540e.R(shareVideo, this);
        }

        public void q(ShareVideoContent shareVideoContent) {
            m.f(shareVideoContent, "videoContent");
            n.f4540e.S(shareVideoContent, this);
        }
    }

    private static final class d extends c {
        public void e(ShareMediaContent shareMediaContent) {
            m.f(shareMediaContent, "mediaContent");
            throw new l("Cannot share ShareMediaContent via web sharing dialogs");
        }

        public void m(SharePhoto sharePhoto) {
            m.f(sharePhoto, "photo");
            n.f4540e.L(sharePhoto, this);
        }

        public void q(ShareVideoContent shareVideoContent) {
            m.f(shareVideoContent, "videoContent");
            throw new l("Cannot share ShareVideoContent via web sharing dialogs");
        }
    }

    private n() {
    }

    /* access modifiers changed from: private */
    public final void A(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        if (p0.Y(shareMessengerOpenGraphMusicTemplateContent.b())) {
            throw new l("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
        } else if (shareMessengerOpenGraphMusicTemplateContent.i() != null) {
            M(shareMessengerOpenGraphMusicTemplateContent.h());
        } else {
            throw new l("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
        }
    }

    /* access modifiers changed from: private */
    public final void B(ShareOpenGraphAction shareOpenGraphAction, c cVar) {
        if (shareOpenGraphAction == null) {
            throw new l("Must specify a non-null ShareOpenGraphAction");
        } else if (!p0.Y(shareOpenGraphAction.e())) {
            cVar.l(shareOpenGraphAction, false);
        } else {
            throw new l("ShareOpenGraphAction must have a non-empty actionType");
        }
    }

    /* access modifiers changed from: private */
    public final void C(ShareOpenGraphContent shareOpenGraphContent, c cVar) {
        cVar.i(shareOpenGraphContent.h());
        String i10 = shareOpenGraphContent.i();
        if (!p0.Y(i10)) {
            ShareOpenGraphAction h10 = shareOpenGraphContent.h();
            if (h10 == null || h10.a(i10) == null) {
                throw new l("Property \"" + i10 + "\" was not found on the action. The name of the preview property must match the name of an action property.");
            }
            return;
        }
        throw new l("Must specify a previewPropertyName.");
    }

    private final void D(String str, boolean z10) {
        if (z10) {
            Object[] array = j.v0(str, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                if (strArr.length >= 2) {
                    int length = strArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        if (strArr[i10].length() != 0) {
                            i10++;
                        } else {
                            throw new l("Invalid key found in Open Graph dictionary: %s", str);
                        }
                    }
                    return;
                }
                throw new l("Open Graph keys must be namespaced: %s", str);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    /* access modifiers changed from: private */
    public final void E(ShareOpenGraphObject shareOpenGraphObject, c cVar) {
        if (shareOpenGraphObject != null) {
            cVar.l(shareOpenGraphObject, true);
            return;
        }
        throw new l("Cannot share a null ShareOpenGraphObject");
    }

    /* access modifiers changed from: private */
    public final void F(ShareOpenGraphValueContainer shareOpenGraphValueContainer, c cVar, boolean z10) {
        for (String str : shareOpenGraphValueContainer.d()) {
            m.e(str, "key");
            D(str, z10);
            Object a10 = shareOpenGraphValueContainer.a(str);
            if (a10 instanceof List) {
                for (Object next : (List) a10) {
                    if (next != null) {
                        G(next, cVar);
                    } else {
                        throw new l("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                }
                continue;
            } else {
                G(a10, cVar);
            }
        }
    }

    private final void G(Object obj, c cVar) {
        if (obj instanceof ShareOpenGraphObject) {
            cVar.k((ShareOpenGraphObject) obj);
        } else if (obj instanceof SharePhoto) {
            cVar.m((SharePhoto) obj);
        }
    }

    private final void H(SharePhoto sharePhoto) {
        if (sharePhoto != null) {
            Bitmap c10 = sharePhoto.c();
            Uri e10 = sharePhoto.e();
            if (c10 == null && e10 == null) {
                throw new l("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            return;
        }
        throw new l("Cannot share a null SharePhoto");
    }

    /* access modifiers changed from: private */
    public final void I(SharePhotoContent sharePhotoContent, c cVar) {
        List<SharePhoto> h10 = sharePhotoContent.h();
        if (h10 == null || h10.isEmpty()) {
            throw new l("Must specify at least one Photo in SharePhotoContent.");
        } else if (h10.size() <= 6) {
            for (SharePhoto m10 : h10) {
                cVar.m(m10);
            }
        } else {
            b0 b0Var = b0.f709a;
            String format = String.format(Locale.ROOT, "Cannot add more than %d photos.", Arrays.copyOf(new Object[]{6}, 1));
            m.e(format, "java.lang.String.format(locale, format, *args)");
            throw new l(format);
        }
    }

    /* access modifiers changed from: private */
    public final void J(SharePhoto sharePhoto, c cVar) {
        H(sharePhoto);
        Bitmap c10 = sharePhoto.c();
        Uri e10 = sharePhoto.e();
        if (c10 == null && p0.a0(e10) && !cVar.a()) {
            throw new l("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    /* access modifiers changed from: private */
    public final void K(SharePhoto sharePhoto, c cVar) {
        J(sharePhoto, cVar);
        if (sharePhoto.c() != null || !p0.a0(sharePhoto.e())) {
            q0.d(o.f());
        }
    }

    /* access modifiers changed from: private */
    public final void L(SharePhoto sharePhoto, c cVar) {
        H(sharePhoto);
    }

    private final void M(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton != null) {
            if (p0.Y(shareMessengerActionButton.a())) {
                throw new l("Must specify title for ShareMessengerActionButton");
            } else if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                P((ShareMessengerURLActionButton) shareMessengerActionButton);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void N(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        if (p0.Y(shareMessengerGenericTemplateContent.b())) {
            throw new l("Must specify Page Id for ShareMessengerGenericTemplateContent");
        } else if (shareMessengerGenericTemplateContent.h() != null) {
            ShareMessengerGenericTemplateElement h10 = shareMessengerGenericTemplateContent.h();
            m.e(h10, "content.genericTemplateElement");
            if (!p0.Y(h10.e())) {
                ShareMessengerGenericTemplateElement h11 = shareMessengerGenericTemplateContent.h();
                m.e(h11, "content.genericTemplateElement");
                M(h11.a());
                return;
            }
            throw new l("Must specify title for ShareMessengerGenericTemplateElement");
        } else {
            throw new l("Must specify element for ShareMessengerGenericTemplateContent");
        }
    }

    /* access modifiers changed from: private */
    public final void O(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        if (p0.Y(shareMessengerMediaTemplateContent.b())) {
            throw new l("Must specify Page Id for ShareMessengerMediaTemplateContent");
        } else if (shareMessengerMediaTemplateContent.k() != null || !p0.Y(shareMessengerMediaTemplateContent.h())) {
            M(shareMessengerMediaTemplateContent.i());
        } else {
            throw new l("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
        }
    }

    private final void P(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.e() == null) {
            throw new l("Must specify url for ShareMessengerURLActionButton");
        }
    }

    /* access modifiers changed from: private */
    public final void Q(ShareStoryContent shareStoryContent, c cVar) {
        if (shareStoryContent == null || (shareStoryContent.i() == null && shareStoryContent.k() == null)) {
            throw new l("Must pass the Facebook app a background asset, a sticker asset, or both");
        }
        if (shareStoryContent.i() != null) {
            ShareMedia i10 = shareStoryContent.i();
            m.e(i10, "storyContent.backgroundAsset");
            cVar.d(i10);
        }
        if (shareStoryContent.k() != null) {
            SharePhoto k10 = shareStoryContent.k();
            m.e(k10, "storyContent.stickerAsset");
            cVar.m(k10);
        }
    }

    /* access modifiers changed from: private */
    public final void R(ShareVideo shareVideo, c cVar) {
        if (shareVideo != null) {
            Uri c10 = shareVideo.c();
            if (c10 != null) {
                m.e(c10, "video.localUrl ?: throw …ve a LocalUrl specified\")");
                if (!p0.T(c10) && !p0.W(c10)) {
                    throw new l("ShareVideo must reference a video that is on the device");
                }
                return;
            }
            throw new l("ShareVideo does not have a LocalUrl specified");
        }
        throw new l("Cannot share a null ShareVideo");
    }

    /* access modifiers changed from: private */
    public final void S(ShareVideoContent shareVideoContent, c cVar) {
        cVar.p(shareVideoContent.k());
        SharePhoto j10 = shareVideoContent.j();
        if (j10 != null) {
            cVar.m(j10);
        }
    }

    private final void r(ShareContent shareContent, c cVar) {
        if (shareContent == null) {
            throw new l("Must provide non-null content to share");
        } else if (shareContent instanceof ShareLinkContent) {
            cVar.c((ShareLinkContent) shareContent);
        } else if (shareContent instanceof SharePhotoContent) {
            cVar.n((SharePhotoContent) shareContent);
        } else if (shareContent instanceof ShareVideoContent) {
            cVar.q((ShareVideoContent) shareContent);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            cVar.j((ShareOpenGraphContent) shareContent);
        } else if (shareContent instanceof ShareMediaContent) {
            cVar.e((ShareMediaContent) shareContent);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            cVar.b((ShareCameraEffectContent) shareContent);
        } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
            cVar.h((ShareMessengerOpenGraphMusicTemplateContent) shareContent);
        } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
            cVar.g((ShareMessengerMediaTemplateContent) shareContent);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            cVar.f((ShareMessengerGenericTemplateContent) shareContent);
        } else if (shareContent instanceof ShareStoryContent) {
            cVar.o((ShareStoryContent) shareContent);
        }
    }

    /* access modifiers changed from: private */
    public final void s(ShareCameraEffectContent shareCameraEffectContent) {
        if (p0.Y(shareCameraEffectContent.i())) {
            throw new l("Must specify a non-empty effectId");
        }
    }

    public static final void t(ShareContent shareContent) {
        f4540e.r(shareContent, f4537b);
    }

    public static final void u(ShareContent shareContent) {
        f4540e.r(shareContent, f4537b);
    }

    public static final void v(ShareContent shareContent) {
        f4540e.r(shareContent, f4539d);
    }

    public static final void w(ShareContent shareContent) {
        f4540e.r(shareContent, f4536a);
    }

    /* access modifiers changed from: private */
    public final void x(ShareLinkContent shareLinkContent, c cVar) {
        Uri j10 = shareLinkContent.j();
        if (j10 != null && !p0.a0(j10)) {
            throw new l("Image Url must be an http:// or https:// url");
        }
    }

    /* access modifiers changed from: private */
    public final void y(ShareMediaContent shareMediaContent, c cVar) {
        List<ShareMedia> h10 = shareMediaContent.h();
        if (h10 == null || h10.isEmpty()) {
            throw new l("Must specify at least one medium in ShareMediaContent.");
        } else if (h10.size() <= 6) {
            for (ShareMedia shareMedia : h10) {
                m.e(shareMedia, "medium");
                cVar.d(shareMedia);
            }
        } else {
            b0 b0Var = b0.f709a;
            String format = String.format(Locale.ROOT, "Cannot add more than %d media.", Arrays.copyOf(new Object[]{6}, 1));
            m.e(format, "java.lang.String.format(locale, format, *args)");
            throw new l(format);
        }
    }

    public static final void z(ShareMedia shareMedia, c cVar) {
        m.f(shareMedia, "medium");
        m.f(cVar, "validator");
        if (shareMedia instanceof SharePhoto) {
            cVar.m((SharePhoto) shareMedia);
        } else if (shareMedia instanceof ShareVideo) {
            cVar.p((ShareVideo) shareMedia);
        } else {
            b0 b0Var = b0.f709a;
            String format = String.format(Locale.ROOT, "Invalid media type: %s", Arrays.copyOf(new Object[]{shareMedia.getClass().getSimpleName()}, 1));
            m.e(format, "java.lang.String.format(locale, format, *args)");
            throw new l(format);
        }
    }
}
