package com.facebook.share.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.j;
import java.util.ArrayList;
import java.util.List;
import q5.d;
import q5.g;
import q5.h;
import q5.i;
import q5.u;

public class e extends i {

    /* renamed from: h  reason: collision with root package name */
    private static final int f4505h = d.c.Like.a();

    class a extends m {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f4506b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(j jVar, j jVar2) {
            super(jVar);
            this.f4506b = jVar2;
        }

        public void c(q5.a aVar, Bundle bundle) {
            this.f4506b.onSuccess(new d(bundle));
        }
    }

    class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m f4508a;

        b(m mVar) {
            this.f4508a = mVar;
        }

        public boolean a(int i10, Intent intent) {
            return p.q(e.this.h(), i10, intent, this.f4508a);
        }
    }

    private class c extends i.b {

        class a implements h.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LikeContent f4511a;

            a(LikeContent likeContent) {
                this.f4511a = likeContent;
            }

            public Bundle a() {
                Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
                return new Bundle();
            }

            public Bundle getParameters() {
                return e.t(this.f4511a);
            }
        }

        private c() {
            super();
        }

        /* renamed from: d */
        public boolean a(LikeContent likeContent, boolean z10) {
            return false;
        }

        /* renamed from: e */
        public q5.a b(LikeContent likeContent) {
            q5.a e10 = e.this.e();
            h.j(e10, new a(likeContent), e.u());
            return e10;
        }

        /* synthetic */ c(e eVar, a aVar) {
            this();
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f4513a;

        public d(Bundle bundle) {
            this.f4513a = bundle;
        }
    }

    /* renamed from: com.facebook.share.internal.e$e  reason: collision with other inner class name */
    private class C0064e extends i.b {
        private C0064e() {
            super();
        }

        /* renamed from: d */
        public boolean a(LikeContent likeContent, boolean z10) {
            return false;
        }

        /* renamed from: e */
        public q5.a b(LikeContent likeContent) {
            q5.a e10 = e.this.e();
            h.m(e10, e.t(likeContent), e.u());
            return e10;
        }

        /* synthetic */ C0064e(e eVar, a aVar) {
            this();
        }
    }

    public e(Activity activity) {
        super(activity, f4505h);
    }

    public static boolean r() {
        return false;
    }

    public static boolean s() {
        return false;
    }

    /* access modifiers changed from: private */
    public static Bundle t(LikeContent likeContent) {
        Bundle bundle = new Bundle();
        bundle.putString("object_id", likeContent.a());
        bundle.putString("object_type", likeContent.b());
        return bundle;
    }

    /* access modifiers changed from: private */
    public static g u() {
        return f.LIKE_DIALOG;
    }

    /* access modifiers changed from: protected */
    public q5.a e() {
        return new q5.a(h());
    }

    /* access modifiers changed from: protected */
    public List g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c(this, (a) null));
        arrayList.add(new C0064e(this, (a) null));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void k(q5.d dVar, j jVar) {
        a aVar;
        if (jVar == null) {
            aVar = null;
        } else {
            aVar = new a(jVar, jVar);
        }
        dVar.c(h(), new b(aVar));
    }

    /* renamed from: v */
    public void m(LikeContent likeContent) {
    }

    public e(u uVar) {
        super(uVar, f4505h);
    }
}
