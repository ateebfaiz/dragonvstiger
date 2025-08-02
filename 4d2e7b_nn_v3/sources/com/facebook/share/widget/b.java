package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.j;
import com.facebook.share.internal.k;
import com.facebook.share.internal.n;
import com.facebook.share.internal.o;
import com.facebook.share.internal.p;
import com.facebook.share.internal.q;
import com.facebook.share.internal.r;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import e2.m;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import q5.d;
import q5.e0;
import q5.h;
import q5.i;
import q5.p0;
import q5.u;

public final class b extends i {

    /* renamed from: j  reason: collision with root package name */
    private static final String f4746j = "b";

    /* renamed from: k  reason: collision with root package name */
    private static final int f4747k = d.c.Share.a();

    /* renamed from: h  reason: collision with root package name */
    private boolean f4748h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4749i;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4750a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.share.widget.b$d[] r0 = com.facebook.share.widget.b.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4750a = r0
                com.facebook.share.widget.b$d r1 = com.facebook.share.widget.b.d.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4750a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.share.widget.b$d r1 = com.facebook.share.widget.b.d.WEB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4750a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.share.widget.b$d r1 = com.facebook.share.widget.b.d.NATIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.b.a.<clinit>():void");
        }
    }

    /* renamed from: com.facebook.share.widget.b$b  reason: collision with other inner class name */
    private class C0067b extends i.b {

        /* renamed from: com.facebook.share.widget.b$b$a */
        class a implements h.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ q5.a f4752a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ShareContent f4753b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f4754c;

            a(q5.a aVar, ShareContent shareContent, boolean z10) {
                this.f4752a = aVar;
                this.f4753b = shareContent;
                this.f4754c = z10;
            }

            public Bundle a() {
                return com.facebook.share.internal.c.e(this.f4752a.d(), this.f4753b, this.f4754c);
            }

            public Bundle getParameters() {
                return j.k(this.f4752a.d(), this.f4753b, this.f4754c);
            }
        }

        private C0067b() {
            super();
        }

        public Object c() {
            return d.NATIVE;
        }

        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z10) {
            if (!(shareContent instanceof ShareCameraEffectContent) || !b.x(shareContent.getClass())) {
                return false;
            }
            return true;
        }

        /* renamed from: e */
        public q5.a b(ShareContent shareContent) {
            n.u(shareContent);
            q5.a e10 = b.this.e();
            h.j(e10, new a(e10, shareContent, b.this.B()), b.A(shareContent.getClass()));
            return e10;
        }

        /* synthetic */ C0067b(b bVar, a aVar) {
            this();
        }
    }

    private class c extends i.b {
        private c() {
            super();
        }

        public Object c() {
            return d.FEED;
        }

        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z10) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent)) {
                return true;
            }
            return false;
        }

        /* renamed from: e */
        public q5.a b(ShareContent shareContent) {
            Bundle bundle;
            b bVar = b.this;
            bVar.C(bVar.f(), shareContent, d.FEED);
            q5.a e10 = b.this.e();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                n.w(shareLinkContent);
                bundle = r.f(shareLinkContent);
            } else {
                bundle = r.e((ShareFeedContent) shareContent);
            }
            h.l(e10, "feed", bundle);
            return e10;
        }

        /* synthetic */ c(b bVar, a aVar) {
            this();
        }
    }

    public enum d {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    private class e extends i.b {

        class a implements h.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ q5.a f4763a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ShareContent f4764b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f4765c;

            a(q5.a aVar, ShareContent shareContent, boolean z10) {
                this.f4763a = aVar;
                this.f4764b = shareContent;
                this.f4765c = z10;
            }

            public Bundle a() {
                return com.facebook.share.internal.c.e(this.f4763a.d(), this.f4764b, this.f4765c);
            }

            public Bundle getParameters() {
                return j.k(this.f4763a.d(), this.f4764b, this.f4765c);
            }
        }

        private e() {
            super();
        }

        public Object c() {
            return d.NATIVE;
        }

        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z10) {
            boolean z11;
            if (shareContent == null || (shareContent instanceof ShareCameraEffectContent) || (shareContent instanceof ShareStoryContent)) {
                return false;
            }
            if (!z10) {
                if (shareContent.f() != null) {
                    z11 = h.a(o.HASHTAG);
                } else {
                    z11 = true;
                }
                if ((shareContent instanceof ShareLinkContent) && !p0.Y(((ShareLinkContent) shareContent).k())) {
                    z11 &= h.a(o.LINK_SHARE_QUOTES);
                }
            } else {
                z11 = true;
            }
            if (!z11 || !b.x(shareContent.getClass())) {
                return false;
            }
            return true;
        }

        /* renamed from: e */
        public q5.a b(ShareContent shareContent) {
            b bVar = b.this;
            bVar.C(bVar.f(), shareContent, d.NATIVE);
            n.u(shareContent);
            q5.a e10 = b.this.e();
            h.j(e10, new a(e10, shareContent, b.this.B()), b.A(shareContent.getClass()));
            return e10;
        }

        /* synthetic */ e(b bVar, a aVar) {
            this();
        }
    }

    private class f extends i.b {

        class a implements h.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ q5.a f4768a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ShareContent f4769b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f4770c;

            a(q5.a aVar, ShareContent shareContent, boolean z10) {
                this.f4768a = aVar;
                this.f4769b = shareContent;
                this.f4770c = z10;
            }

            public Bundle a() {
                return com.facebook.share.internal.c.e(this.f4768a.d(), this.f4769b, this.f4770c);
            }

            public Bundle getParameters() {
                return j.k(this.f4768a.d(), this.f4769b, this.f4770c);
            }
        }

        private f() {
            super();
        }

        public Object c() {
            return d.NATIVE;
        }

        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z10) {
            if (!(shareContent instanceof ShareStoryContent) || !b.x(shareContent.getClass())) {
                return false;
            }
            return true;
        }

        /* renamed from: e */
        public q5.a b(ShareContent shareContent) {
            n.v(shareContent);
            q5.a e10 = b.this.e();
            h.j(e10, new a(e10, shareContent, b.this.B()), b.A(shareContent.getClass()));
            return e10;
        }

        /* synthetic */ f(b bVar, a aVar) {
            this();
        }
    }

    private class g extends i.b {
        private g() {
            super();
        }

        private SharePhotoContent e(SharePhotoContent sharePhotoContent, UUID uuid) {
            SharePhotoContent.a r10 = new SharePhotoContent.a().r(sharePhotoContent);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i10 = 0; i10 < sharePhotoContent.h().size(); i10++) {
                SharePhoto sharePhoto = (SharePhoto) sharePhotoContent.h().get(i10);
                Bitmap c10 = sharePhoto.c();
                if (c10 != null) {
                    e0.a d10 = e0.d(uuid, c10);
                    sharePhoto = new SharePhoto.b().m(sharePhoto).q(Uri.parse(d10.b())).o((Bitmap) null).i();
                    arrayList2.add(d10);
                }
                arrayList.add(sharePhoto);
            }
            r10.s(arrayList);
            e0.a(arrayList2);
            return r10.p();
        }

        private String g(ShareContent shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return FirebaseAnalytics.Event.SHARE;
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return "share_open_graph";
            }
            return null;
        }

        public Object c() {
            return d.WEB;
        }

        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z10) {
            if (shareContent == null || !b.y(shareContent)) {
                return false;
            }
            return true;
        }

        /* renamed from: f */
        public q5.a b(ShareContent shareContent) {
            Bundle bundle;
            b bVar = b.this;
            bVar.C(bVar.f(), shareContent, d.WEB);
            q5.a e10 = b.this.e();
            n.w(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                bundle = r.a((ShareLinkContent) shareContent);
            } else if (shareContent instanceof SharePhotoContent) {
                bundle = r.c(e((SharePhotoContent) shareContent, e10.d()));
            } else {
                bundle = r.b((ShareOpenGraphContent) shareContent);
            }
            h.l(e10, g(shareContent), bundle);
            return e10;
        }

        /* synthetic */ g(b bVar, a aVar) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(android.app.Activity r2) {
        /*
            r1 = this;
            int r0 = f4747k
            r1.<init>((android.app.Activity) r2, (int) r0)
            r2 = 0
            r1.f4748h = r2
            r2 = 1
            r1.f4749i = r2
            com.facebook.share.internal.p.y(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.b.<init>(android.app.Activity):void");
    }

    /* access modifiers changed from: private */
    public static q5.g A(Class cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return o.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return o.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return o.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return k.OG_ACTION_DIALOG;
        }
        if (ShareMediaContent.class.isAssignableFrom(cls)) {
            return o.MULTIMEDIA;
        }
        if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.a.SHARE_CAMERA_EFFECT;
        }
        if (ShareStoryContent.class.isAssignableFrom(cls)) {
            return q.SHARE_STORY_ASSET;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void C(Context context, ShareContent shareContent, d dVar) {
        String str;
        if (this.f4749i) {
            dVar = d.AUTOMATIC;
        }
        int i10 = a.f4750a[dVar.ordinal()];
        String str2 = "unknown";
        if (i10 == 1) {
            str = "automatic";
        } else if (i10 == 2) {
            str = "web";
        } else if (i10 != 3) {
            str = str2;
        } else {
            str = "native";
        }
        q5.g A = A(shareContent.getClass());
        if (A == o.SHARE_DIALOG) {
            str2 = NotificationCompat.CATEGORY_STATUS;
        } else if (A == o.PHOTOS) {
            str2 = "photo";
        } else if (A == o.VIDEO) {
            str2 = "video";
        } else if (A == k.OG_ACTION_DIALOG) {
            str2 = "open_graph";
        }
        m mVar = new m(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_show", str);
        bundle.putString("fb_share_dialog_content_type", str2);
        mVar.g("fb_share_dialog_show", bundle);
    }

    public static boolean w(Class cls) {
        if (z(cls) || x(cls)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean x(Class cls) {
        q5.g A = A(cls);
        if (A == null || !h.a(A)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean y(ShareContent shareContent) {
        if (!z(shareContent.getClass())) {
            return false;
        }
        if (!(shareContent instanceof ShareOpenGraphContent)) {
            return true;
        }
        try {
            p.C((ShareOpenGraphContent) shareContent);
            return true;
        } catch (Exception e10) {
            p0.g0(f4746j, "canShow returned false because the content of the Opem Graph object can't be shared via the web dialog", e10);
            return false;
        }
    }

    private static boolean z(Class cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls) || (SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.o())) {
            return true;
        }
        return false;
    }

    public boolean B() {
        return this.f4748h;
    }

    /* access modifiers changed from: protected */
    public q5.a e() {
        return new q5.a(h());
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e(this, (a) null));
        arrayList.add(new c(this, (a) null));
        arrayList.add(new g(this, (a) null));
        arrayList.add(new C0067b(this, (a) null));
        arrayList.add(new f(this, (a) null));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void k(q5.d dVar, com.facebook.j jVar) {
        p.x(h(), dVar, jVar);
    }

    b(Activity activity, int i10) {
        super(activity, i10);
        this.f4748h = false;
        this.f4749i = true;
        p.y(i10);
    }

    b(Fragment fragment, int i10) {
        this(new u(fragment), i10);
    }

    b(android.app.Fragment fragment, int i10) {
        this(new u(fragment), i10);
    }

    private b(u uVar, int i10) {
        super(uVar, i10);
        this.f4748h = false;
        this.f4749i = true;
        p.y(i10);
    }
}
