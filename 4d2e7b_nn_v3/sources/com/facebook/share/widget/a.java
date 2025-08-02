package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.facebook.share.internal.c;
import com.facebook.share.internal.j;
import com.facebook.share.internal.n;
import com.facebook.share.internal.p;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import e2.m;
import java.util.ArrayList;
import java.util.List;
import q5.d;
import q5.g;
import q5.h;
import q5.i;
import q5.u;

public final class a extends i {

    /* renamed from: i  reason: collision with root package name */
    private static final int f4739i = d.c.Message.a();

    /* renamed from: h  reason: collision with root package name */
    private boolean f4740h;

    private class b extends i.b {

        /* renamed from: com.facebook.share.widget.a$b$a  reason: collision with other inner class name */
        class C0066a implements h.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ q5.a f4742a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ShareContent f4743b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f4744c;

            C0066a(q5.a aVar, ShareContent shareContent, boolean z10) {
                this.f4742a = aVar;
                this.f4743b = shareContent;
                this.f4744c = z10;
            }

            public Bundle a() {
                return c.e(this.f4742a.d(), this.f4743b, this.f4744c);
            }

            public Bundle getParameters() {
                return j.k(this.f4742a.d(), this.f4743b, this.f4744c);
            }
        }

        private b() {
            super();
        }

        /* renamed from: d */
        public boolean a(ShareContent shareContent, boolean z10) {
            if (shareContent == null || !a.s(shareContent.getClass())) {
                return false;
            }
            return true;
        }

        /* renamed from: e */
        public q5.a b(ShareContent shareContent) {
            n.t(shareContent);
            q5.a e10 = a.this.e();
            boolean u10 = a.this.u();
            a.v(a.this.f(), shareContent, e10);
            h.j(e10, new C0066a(e10, shareContent, u10), a.t(shareContent.getClass()));
            return e10;
        }
    }

    a(Activity activity, int i10) {
        super(activity, i10);
        this.f4740h = false;
        p.y(i10);
    }

    public static boolean s(Class cls) {
        g t10 = t(cls);
        if (t10 == null || !h.a(t10)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static g t(Class cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.h.MESSAGE_DIALOG;
        }
        if (ShareMessengerGenericTemplateContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.h.MESSENGER_GENERIC_TEMPLATE;
        }
        if (ShareMessengerOpenGraphMusicTemplateContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.h.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE;
        }
        if (ShareMessengerMediaTemplateContent.class.isAssignableFrom(cls)) {
            return com.facebook.share.internal.h.MESSENGER_MEDIA_TEMPLATE;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static void v(Context context, ShareContent shareContent, q5.a aVar) {
        String str;
        g t10 = t(shareContent.getClass());
        if (t10 == com.facebook.share.internal.h.MESSAGE_DIALOG) {
            str = NotificationCompat.CATEGORY_STATUS;
        } else if (t10 == com.facebook.share.internal.h.MESSENGER_GENERIC_TEMPLATE) {
            str = "GenericTemplate";
        } else if (t10 == com.facebook.share.internal.h.MESSENGER_MEDIA_TEMPLATE) {
            str = "MediaTemplate";
        } else if (t10 == com.facebook.share.internal.h.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE) {
            str = "OpenGraphMusicTemplate";
        } else {
            str = "unknown";
        }
        m mVar = new m(context);
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_content_type", str);
        bundle.putString("fb_share_dialog_content_uuid", aVar.d().toString());
        bundle.putString("fb_share_dialog_content_page_id", shareContent.b());
        mVar.g("fb_messenger_share_dialog_show", bundle);
    }

    /* access modifiers changed from: protected */
    public q5.a e() {
        return new q5.a(h());
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void k(d dVar, com.facebook.j jVar) {
        p.x(h(), dVar, jVar);
    }

    public boolean u() {
        return this.f4740h;
    }

    a(Fragment fragment, int i10) {
        this(new u(fragment), i10);
    }

    a(android.app.Fragment fragment, int i10) {
        this(new u(fragment), i10);
    }

    private a(u uVar, int i10) {
        super(uVar, i10);
        this.f4740h = false;
        p.y(i10);
    }
}
