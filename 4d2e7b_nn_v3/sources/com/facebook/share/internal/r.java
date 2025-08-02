package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.l;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f4565a = new r();

    private r() {
    }

    public static final Bundle a(ShareLinkContent shareLinkContent) {
        m.f(shareLinkContent, "shareLinkContent");
        Bundle d10 = d(shareLinkContent);
        p0.o0(d10, "href", shareLinkContent.a());
        p0.n0(d10, "quote", shareLinkContent.k());
        return d10;
    }

    public static final Bundle b(ShareOpenGraphContent shareOpenGraphContent) {
        String str;
        m.f(shareOpenGraphContent, "shareOpenGraphContent");
        Bundle d10 = d(shareOpenGraphContent);
        ShareOpenGraphAction h10 = shareOpenGraphContent.h();
        String str2 = null;
        if (h10 != null) {
            str = h10.e();
        } else {
            str = null;
        }
        p0.n0(d10, "action_type", str);
        try {
            JSONObject A = p.A(p.C(shareOpenGraphContent), false);
            if (A != null) {
                str2 = A.toString();
            }
            p0.n0(d10, "action_properties", str2);
            return d10;
        } catch (JSONException e10) {
            throw new l("Unable to serialize the ShareOpenGraphContent to JSON", (Throwable) e10);
        }
    }

    public static final Bundle c(SharePhotoContent sharePhotoContent) {
        m.f(sharePhotoContent, "sharePhotoContent");
        Bundle d10 = d(sharePhotoContent);
        List h10 = sharePhotoContent.h();
        if (h10 == null) {
            h10 = kotlin.collections.r.l();
        }
        Iterable<SharePhoto> iterable = h10;
        ArrayList arrayList = new ArrayList(kotlin.collections.r.v(iterable, 10));
        for (SharePhoto e10 : iterable) {
            arrayList.add(String.valueOf(e10.e()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            d10.putStringArray("media", (String[]) array);
            return d10;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final Bundle d(ShareContent shareContent) {
        String str;
        m.f(shareContent, "shareContent");
        Bundle bundle = new Bundle();
        ShareHashtag f10 = shareContent.f();
        if (f10 != null) {
            str = f10.a();
        } else {
            str = null;
        }
        p0.n0(bundle, "hashtag", str);
        return bundle;
    }

    public static final Bundle e(ShareFeedContent shareFeedContent) {
        m.f(shareFeedContent, "shareFeedContent");
        Bundle bundle = new Bundle();
        p0.n0(bundle, "to", shareFeedContent.n());
        p0.n0(bundle, "link", shareFeedContent.h());
        p0.n0(bundle, "picture", shareFeedContent.m());
        p0.n0(bundle, "source", shareFeedContent.l());
        p0.n0(bundle, "name", shareFeedContent.k());
        p0.n0(bundle, "caption", shareFeedContent.i());
        p0.n0(bundle, "description", shareFeedContent.j());
        return bundle;
    }

    public static final Bundle f(ShareLinkContent shareLinkContent) {
        String str;
        m.f(shareLinkContent, "shareLinkContent");
        Bundle bundle = new Bundle();
        p0.n0(bundle, "name", shareLinkContent.i());
        p0.n0(bundle, "description", shareLinkContent.h());
        p0.n0(bundle, "link", p0.K(shareLinkContent.a()));
        p0.n0(bundle, "picture", p0.K(shareLinkContent.j()));
        p0.n0(bundle, "quote", shareLinkContent.k());
        ShareHashtag f10 = shareLinkContent.f();
        if (f10 != null) {
            str = f10.a();
        } else {
            str = null;
        }
        p0.n0(bundle, "hashtag", str);
        return bundle;
    }
}
