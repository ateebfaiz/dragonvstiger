package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.l;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;
import q5.q0;

public abstract class j {
    private static Bundle a(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z10) {
        Bundle l10 = l(shareCameraEffectContent, z10);
        p0.n0(l10, "effect_id", shareCameraEffectContent.i());
        if (bundle != null) {
            l10.putBundle("effect_textures", bundle);
        }
        try {
            JSONObject a10 = b.a(shareCameraEffectContent.h());
            if (a10 != null) {
                p0.n0(l10, "effect_arguments", a10.toString());
            }
            return l10;
        } catch (JSONException e10) {
            throw new l("Unable to create a JSON Object from the provided CameraEffectArguments: " + e10.getMessage());
        }
    }

    private static Bundle b(ShareLinkContent shareLinkContent, boolean z10) {
        Bundle l10 = l(shareLinkContent, z10);
        p0.n0(l10, "TITLE", shareLinkContent.i());
        p0.n0(l10, "DESCRIPTION", shareLinkContent.h());
        p0.o0(l10, "IMAGE", shareLinkContent.j());
        p0.n0(l10, "QUOTE", shareLinkContent.k());
        p0.o0(l10, "MESSENGER_LINK", shareLinkContent.a());
        p0.o0(l10, "TARGET_DISPLAY", shareLinkContent.a());
        return l10;
    }

    private static Bundle c(ShareMediaContent shareMediaContent, List list, boolean z10) {
        Bundle l10 = l(shareMediaContent, z10);
        l10.putParcelableArrayList("MEDIA", new ArrayList(list));
        return l10;
    }

    private static Bundle d(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent, boolean z10) {
        Bundle l10 = l(shareMessengerGenericTemplateContent, z10);
        try {
            i.b(l10, shareMessengerGenericTemplateContent);
            return l10;
        } catch (JSONException e10) {
            throw new l("Unable to create a JSON Object from the provided ShareMessengerGenericTemplateContent: " + e10.getMessage());
        }
    }

    private static Bundle e(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent, boolean z10) {
        Bundle l10 = l(shareMessengerMediaTemplateContent, z10);
        try {
            i.d(l10, shareMessengerMediaTemplateContent);
            return l10;
        } catch (JSONException e10) {
            throw new l("Unable to create a JSON Object from the provided ShareMessengerMediaTemplateContent: " + e10.getMessage());
        }
    }

    private static Bundle f(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent, boolean z10) {
        Bundle l10 = l(shareMessengerOpenGraphMusicTemplateContent, z10);
        try {
            i.f(l10, shareMessengerOpenGraphMusicTemplateContent);
            return l10;
        } catch (JSONException e10) {
            throw new l("Unable to create a JSON Object from the provided ShareMessengerOpenGraphMusicTemplateContent: " + e10.getMessage());
        }
    }

    private static Bundle g(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z10) {
        Bundle l10 = l(shareOpenGraphContent, z10);
        p0.n0(l10, "PREVIEW_PROPERTY_NAME", (String) p.f(shareOpenGraphContent.i()).second);
        p0.n0(l10, "ACTION_TYPE", shareOpenGraphContent.h().e());
        p0.n0(l10, "ACTION", jSONObject.toString());
        return l10;
    }

    private static Bundle h(SharePhotoContent sharePhotoContent, List list, boolean z10) {
        Bundle l10 = l(sharePhotoContent, z10);
        l10.putStringArrayList("PHOTOS", new ArrayList(list));
        return l10;
    }

    private static Bundle i(ShareStoryContent shareStoryContent, Bundle bundle, Bundle bundle2, boolean z10) {
        Bundle l10 = l(shareStoryContent, z10);
        if (bundle != null) {
            l10.putParcelable("bg_asset", bundle);
        }
        if (bundle2 != null) {
            l10.putParcelable("interactive_asset_uri", bundle2);
        }
        List j10 = shareStoryContent.j();
        if (!p0.Z(j10)) {
            l10.putStringArrayList("top_background_color_list", new ArrayList(j10));
        }
        p0.n0(l10, "content_url", shareStoryContent.h());
        return l10;
    }

    private static Bundle j(ShareVideoContent shareVideoContent, String str, boolean z10) {
        Bundle l10 = l(shareVideoContent, z10);
        p0.n0(l10, "TITLE", shareVideoContent.i());
        p0.n0(l10, "DESCRIPTION", shareVideoContent.h());
        p0.n0(l10, "VIDEO", str);
        return l10;
    }

    public static Bundle k(UUID uuid, ShareContent shareContent, boolean z10) {
        q0.m(shareContent, "shareContent");
        q0.m(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return b((ShareLinkContent) shareContent, z10);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return h(sharePhotoContent, p.j(sharePhotoContent, uuid), z10);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return j(shareVideoContent, p.p(shareVideoContent, uuid), z10);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return g(shareOpenGraphContent, p.A(p.B(uuid, shareOpenGraphContent), false), z10);
            } catch (JSONException e10) {
                throw new l("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e10.getMessage());
            }
        } else if (shareContent instanceof ShareMediaContent) {
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            return c(shareMediaContent, p.g(shareMediaContent, uuid), z10);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            return a(shareCameraEffectContent, p.n(shareCameraEffectContent, uuid), z10);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            return d((ShareMessengerGenericTemplateContent) shareContent, z10);
        } else {
            if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
                return f((ShareMessengerOpenGraphMusicTemplateContent) shareContent, z10);
            }
            if (shareContent instanceof ShareMessengerMediaTemplateContent) {
                return e((ShareMessengerMediaTemplateContent) shareContent, z10);
            }
            if (!(shareContent instanceof ShareStoryContent)) {
                return null;
            }
            ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
            return i(shareStoryContent, p.e(shareStoryContent, uuid), p.m(shareStoryContent, uuid), z10);
        }
    }

    private static Bundle l(ShareContent shareContent, boolean z10) {
        Bundle bundle = new Bundle();
        p0.o0(bundle, "LINK", shareContent.a());
        p0.n0(bundle, "PLACE", shareContent.d());
        p0.n0(bundle, "PAGE", shareContent.b());
        p0.n0(bundle, "REF", shareContent.e());
        bundle.putBoolean("DATA_FAILURES_FATAL", z10);
        List c10 = shareContent.c();
        if (!p0.Z(c10)) {
            bundle.putStringArrayList("FRIENDS", new ArrayList(c10));
        }
        ShareHashtag f10 = shareContent.f();
        if (f10 != null) {
            p0.n0(bundle, "HASHTAG", f10.a());
        }
        return bundle;
    }
}
