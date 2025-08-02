package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.l;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;
import q5.q0;

public abstract class c {
    private static Bundle a(ShareLinkContent shareLinkContent, boolean z10) {
        Bundle f10 = f(shareLinkContent, z10);
        p0.n0(f10, "com.facebook.platform.extra.TITLE", shareLinkContent.i());
        p0.n0(f10, "com.facebook.platform.extra.DESCRIPTION", shareLinkContent.h());
        p0.o0(f10, "com.facebook.platform.extra.IMAGE", shareLinkContent.j());
        return f10;
    }

    private static Bundle b(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z10) {
        Bundle f10 = f(shareOpenGraphContent, z10);
        p0.n0(f10, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", shareOpenGraphContent.i());
        p0.n0(f10, "com.facebook.platform.extra.ACTION_TYPE", shareOpenGraphContent.h().e());
        p0.n0(f10, "com.facebook.platform.extra.ACTION", jSONObject.toString());
        return f10;
    }

    private static Bundle c(SharePhotoContent sharePhotoContent, List list, boolean z10) {
        Bundle f10 = f(sharePhotoContent, z10);
        f10.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(list));
        return f10;
    }

    private static Bundle d(ShareVideoContent shareVideoContent, boolean z10) {
        return null;
    }

    public static Bundle e(UUID uuid, ShareContent shareContent, boolean z10) {
        q0.m(shareContent, "shareContent");
        q0.m(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return a((ShareLinkContent) shareContent, z10);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return c(sharePhotoContent, p.j(sharePhotoContent, uuid), z10);
        } else if (shareContent instanceof ShareVideoContent) {
            return d((ShareVideoContent) shareContent, z10);
        } else {
            if (!(shareContent instanceof ShareOpenGraphContent)) {
                return null;
            }
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return b(shareOpenGraphContent, p.B(uuid, shareOpenGraphContent), z10);
            } catch (JSONException e10) {
                throw new l("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e10.getMessage());
            }
        }
    }

    private static Bundle f(ShareContent shareContent, boolean z10) {
        Bundle bundle = new Bundle();
        p0.o0(bundle, "com.facebook.platform.extra.LINK", shareContent.a());
        p0.n0(bundle, "com.facebook.platform.extra.PLACE", shareContent.d());
        p0.n0(bundle, "com.facebook.platform.extra.REF", shareContent.e());
        bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", z10);
        List c10 = shareContent.c();
        if (!p0.Z(c10)) {
            bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(c10));
        }
        return bundle;
    }
}
