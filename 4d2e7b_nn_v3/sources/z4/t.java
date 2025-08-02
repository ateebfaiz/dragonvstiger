package z4;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.a0;
import com.facebook.imagepipeline.producers.b1;
import com.facebook.imagepipeline.producers.d1;
import com.facebook.imagepipeline.producers.h0;
import com.facebook.imagepipeline.producers.i0;
import com.facebook.imagepipeline.producers.i1;
import com.facebook.imagepipeline.producers.j0;
import com.facebook.imagepipeline.producers.j1;
import com.facebook.imagepipeline.producers.k1;
import com.facebook.imagepipeline.producers.n0;
import com.facebook.imagepipeline.producers.n1;
import com.facebook.imagepipeline.producers.o0;
import com.facebook.imagepipeline.producers.p1;
import com.facebook.imagepipeline.producers.r1;
import com.facebook.imagepipeline.producers.s0;
import com.facebook.imagepipeline.producers.t0;
import com.facebook.imagepipeline.producers.t1;
import com.facebook.imagepipeline.producers.u1;
import com.facebook.imagepipeline.producers.v;
import com.facebook.imagepipeline.producers.x;
import com.facebook.imagepipeline.producers.x0;
import com.facebook.imagepipeline.producers.y;
import com.facebook.imagepipeline.producers.y0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import k5.b;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class t {
    public static final a K = new a((DefaultConstructorMarker) null);
    private final Lazy A = kotlin.i.b(new c(this));
    private final Lazy B = kotlin.i.b(new b(this));
    private final Lazy C = kotlin.i.b(new l(this));
    private final Lazy D = kotlin.i.b(new o(this));
    private final Lazy E = kotlin.i.b(new i(this));
    private final Lazy F = kotlin.i.b(new n(this));
    private final Lazy G = kotlin.i.b(new s(this));
    private final Lazy H = kotlin.i.b(new m(this));
    private final Lazy I = kotlin.i.b(new g(this));
    private final Lazy J = kotlin.i.b(new f(this));

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f25206a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final s f25207b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final x0 f25208c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f25209d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25210e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final p1 f25211f;

    /* renamed from: g  reason: collision with root package name */
    private final e f25212g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f25213h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f25214i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f25215j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final m5.d f25216k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f25217l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f25218m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f25219n;

    /* renamed from: o  reason: collision with root package name */
    private final Set f25220o;

    /* renamed from: p  reason: collision with root package name */
    private Map f25221p = new LinkedHashMap();

    /* renamed from: q  reason: collision with root package name */
    private Map f25222q = new LinkedHashMap();

    /* renamed from: r  reason: collision with root package name */
    private Map f25223r = new LinkedHashMap();

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f25224s = kotlin.i.b(new p(this));

    /* renamed from: t  reason: collision with root package name */
    private final Lazy f25225t = kotlin.i.b(new j(this));

    /* renamed from: u  reason: collision with root package name */
    private final Lazy f25226u = kotlin.i.b(new h(this));

    /* renamed from: v  reason: collision with root package name */
    private final Lazy f25227v = kotlin.i.b(new q(this));

    /* renamed from: w  reason: collision with root package name */
    private final Lazy f25228w = kotlin.i.b(new d(this));

    /* renamed from: x  reason: collision with root package name */
    private final Lazy f25229x = kotlin.i.b(new r(this));

    /* renamed from: y  reason: collision with root package name */
    private final Lazy f25230y = kotlin.i.b(new e(this));

    /* renamed from: z  reason: collision with root package name */
    private final Lazy f25231z = kotlin.i.b(new k(this));

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final String c(Uri uri) {
            String uri2 = uri.toString();
            kotlin.jvm.internal.m.e(uri2, "uri.toString()");
            if (uri2.length() <= 30) {
                return uri2;
            }
            String substring = uri2.substring(0, 30);
            kotlin.jvm.internal.m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring + "...";
        }

        /* access modifiers changed from: private */
        public final void d(k5.b bVar) {
            boolean z10;
            if (bVar.j().b() <= b.c.ENCODED_MEMORY_CACHE.b()) {
                z10 = true;
            } else {
                z10 = false;
            }
            y2.l.b(Boolean.valueOf(z10));
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25232a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t tVar) {
            super(0);
            this.f25232a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25232a;
            if (!l5.b.d()) {
                i0 r10 = tVar.f25207b.r();
                kotlin.jvm.internal.m.e(r10, "producerFactory.newLocalContentUriFetchProducer()");
                return tVar.f25207b.b(tVar.J(r10), tVar.f25211f);
            }
            l5.b.a("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
            try {
                i0 r11 = tVar.f25207b.r();
                kotlin.jvm.internal.m.e(r11, "producerFactory.newLocalContentUriFetchProducer()");
                return tVar.f25207b.b(tVar.J(r11), tVar.f25211f);
            } finally {
                l5.b.b();
            }
        }
    }

    static final class c extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25233a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(t tVar) {
            super(0);
            this.f25233a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25233a;
            if (!l5.b.d()) {
                n0 u10 = tVar.f25207b.u();
                kotlin.jvm.internal.m.e(u10, "producerFactory.newLocalFileFetchProducer()");
                return tVar.f25207b.b(tVar.J(u10), tVar.f25211f);
            }
            l5.b.a("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
            try {
                n0 u11 = tVar.f25207b.u();
                kotlin.jvm.internal.m.e(u11, "producerFactory.newLocalFileFetchProducer()");
                return tVar.f25207b.b(tVar.J(u11), tVar.f25211f);
            } finally {
                l5.b.b();
            }
        }
    }

    static final class d extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25234a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(t tVar) {
            super(0);
            this.f25234a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25234a;
            if (!l5.b.d()) {
                return tVar.f25207b.b(tVar.n(), tVar.f25211f);
            }
            l5.b.a("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
            try {
                return tVar.f25207b.b(tVar.n(), tVar.f25211f);
            } finally {
                l5.b.b();
            }
        }
    }

    static final class e extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25235a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(t tVar) {
            super(0);
            this.f25235a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25235a;
            if (!l5.b.d()) {
                return tVar.H(tVar.f25208c);
            }
            l5.b.a("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
            try {
                return tVar.H(tVar.f25208c);
            } finally {
                l5.b.b();
            }
        }
    }

    static final class f extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25236a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(t tVar) {
            super(0);
            this.f25236a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            com.facebook.imagepipeline.producers.o i10 = this.f25236a.f25207b.i();
            kotlin.jvm.internal.m.e(i10, "producerFactory.newDataFetchProducer()");
            com.facebook.imagepipeline.producers.b a10 = s.a(i10);
            kotlin.jvm.internal.m.e(a10, "newAddImageTransformMeta…taProducer(inputProducer)");
            k1 D = this.f25236a.f25207b.D(a10, true, this.f25236a.f25216k);
            kotlin.jvm.internal.m.e(D, "producerFactory.newResiz…, imageTranscoderFactory)");
            return this.f25236a.E(D);
        }
    }

    static final class g extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25237a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(t tVar) {
            super(0);
            this.f25237a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            h0 q10 = this.f25237a.f25207b.q();
            kotlin.jvm.internal.m.e(q10, "producerFactory.newLocalAssetFetchProducer()");
            return this.f25237a.F(q10);
        }
    }

    static final class h extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25238a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(t tVar) {
            super(0);
            this.f25238a = tVar;
        }

        /* renamed from: a */
        public final j1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25238a;
            if (!l5.b.d()) {
                return new j1(tVar.i());
            }
            l5.b.a("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
            try {
                return new j1(tVar.i());
            } finally {
                l5.b.b();
            }
        }
    }

    static final class i extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25239a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(t tVar) {
            super(0);
            this.f25239a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            i0 r10 = this.f25239a.f25207b.r();
            kotlin.jvm.internal.m.e(r10, "producerFactory.newLocalContentUriFetchProducer()");
            j0 s10 = this.f25239a.f25207b.s();
            kotlin.jvm.internal.m.e(s10, "producerFactory.newLocal…iThumbnailFetchProducer()");
            LocalExifThumbnailProducer t10 = this.f25239a.f25207b.t();
            kotlin.jvm.internal.m.e(t10, "producerFactory.newLocalExifThumbnailProducer()");
            return this.f25239a.G(r10, new u1[]{s10, t10});
        }
    }

    static final class j extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25240a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(t tVar) {
            super(0);
            this.f25240a = tVar;
        }

        /* renamed from: a */
        public final j1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25240a;
            if (!l5.b.d()) {
                return new j1(tVar.j());
            }
            l5.b.a("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
            try {
                return new j1(tVar.j());
            } finally {
                l5.b.b();
            }
        }
    }

    static final class k extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25241a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(t tVar) {
            super(0);
            this.f25241a = tVar;
        }

        /* renamed from: a */
        public final n1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25241a;
            if (!l5.b.d()) {
                return tVar.f25207b.E(tVar.j());
            }
            l5.b.a("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
            try {
                return tVar.f25207b.E(tVar.j());
            } finally {
                l5.b.b();
            }
        }
    }

    static final class l extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25242a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(t tVar) {
            super(0);
            this.f25242a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            n0 u10 = this.f25242a.f25207b.u();
            kotlin.jvm.internal.m.e(u10, "producerFactory.newLocalFileFetchProducer()");
            return this.f25242a.F(u10);
        }
    }

    static final class m extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25243a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(t tVar) {
            super(0);
            this.f25243a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            o0 v10 = this.f25243a.f25207b.v();
            kotlin.jvm.internal.m.e(v10, "producerFactory.newLocalResourceFetchProducer()");
            return this.f25243a.F(v10);
        }
    }

    static final class n extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25244a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(t tVar) {
            super(0);
            this.f25244a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            if (Build.VERSION.SDK_INT >= 29) {
                t tVar = this.f25244a;
                s0 w10 = tVar.f25207b.w();
                kotlin.jvm.internal.m.e(w10, "producerFactory.newLocal…nailBitmapSdk29Producer()");
                return tVar.D(w10);
            }
            throw new Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
        }
    }

    static final class o extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25245a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(t tVar) {
            super(0);
            this.f25245a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            t0 x10 = this.f25245a.f25207b.x();
            kotlin.jvm.internal.m.e(x10, "producerFactory.newLocalVideoThumbnailProducer()");
            return this.f25245a.D(x10);
        }
    }

    static final class p extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25246a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(t tVar) {
            super(0);
            this.f25246a = tVar;
        }

        /* renamed from: a */
        public final j1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25246a;
            if (!l5.b.d()) {
                return new j1(tVar.k());
            }
            l5.b.a("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
            try {
                return new j1(tVar.k());
            } finally {
                l5.b.b();
            }
        }
    }

    static final class q extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25247a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(t tVar) {
            super(0);
            this.f25247a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25247a;
            if (!l5.b.d()) {
                return tVar.E(tVar.n());
            }
            l5.b.a("ProducerSequenceFactory#getNetworkFetchSequence:init");
            try {
                return tVar.E(tVar.n());
            } finally {
                l5.b.b();
            }
        }
    }

    static final class r extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25248a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(t tVar) {
            super(0);
            this.f25248a = tVar;
        }

        /* renamed from: a */
        public final n1 invoke() {
            l5.b bVar = l5.b.f22458a;
            t tVar = this.f25248a;
            if (!l5.b.d()) {
                return tVar.f25207b.E(tVar.k());
            }
            l5.b.a("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
            try {
                return tVar.f25207b.E(tVar.k());
            } finally {
                l5.b.b();
            }
        }
    }

    static final class s extends kotlin.jvm.internal.n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f25249a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(t tVar) {
            super(0);
            this.f25249a = tVar;
        }

        /* renamed from: a */
        public final d1 invoke() {
            i1 C = this.f25249a.f25207b.C();
            kotlin.jvm.internal.m.e(C, "producerFactory.newQuali…edResourceFetchProducer()");
            return this.f25249a.F(C);
        }
    }

    public t(ContentResolver contentResolver, s sVar, x0 x0Var, boolean z10, boolean z11, p1 p1Var, e eVar, boolean z12, boolean z13, boolean z14, m5.d dVar, boolean z15, boolean z16, boolean z17, Set set) {
        m5.d dVar2 = dVar;
        kotlin.jvm.internal.m.f(contentResolver, "contentResolver");
        kotlin.jvm.internal.m.f(sVar, "producerFactory");
        kotlin.jvm.internal.m.f(x0Var, "networkFetcher");
        kotlin.jvm.internal.m.f(p1Var, "threadHandoffProducerQueue");
        kotlin.jvm.internal.m.f(eVar, "downsampleMode");
        kotlin.jvm.internal.m.f(dVar2, "imageTranscoderFactory");
        this.f25206a = contentResolver;
        this.f25207b = sVar;
        this.f25208c = x0Var;
        this.f25209d = z10;
        this.f25210e = z11;
        this.f25211f = p1Var;
        this.f25212g = eVar;
        this.f25213h = z12;
        this.f25214i = z13;
        this.f25215j = z14;
        this.f25216k = dVar2;
        this.f25217l = z15;
        this.f25218m = z16;
        this.f25219n = z17;
        this.f25220o = set;
    }

    private final synchronized d1 B(d1 d1Var) {
        d1 d1Var2;
        d1Var2 = (d1) this.f25221p.get(d1Var);
        if (d1Var2 == null) {
            b1 B2 = this.f25207b.B(d1Var);
            kotlin.jvm.internal.m.e(B2, "producerFactory.newPostp…orProducer(inputProducer)");
            d1Var2 = this.f25207b.A(B2);
            this.f25221p.put(d1Var, d1Var2);
        }
        return d1Var2;
    }

    /* access modifiers changed from: private */
    public final d1 D(d1 d1Var) {
        com.facebook.imagepipeline.producers.i e10 = this.f25207b.e(d1Var);
        kotlin.jvm.internal.m.e(e10, "producerFactory.newBitma…heProducer(inputProducer)");
        com.facebook.imagepipeline.producers.h d10 = this.f25207b.d(e10);
        kotlin.jvm.internal.m.e(d10, "producerFactory.newBitma…itmapMemoryCacheProducer)");
        d1 b10 = this.f25207b.b(d10, this.f25211f);
        kotlin.jvm.internal.m.e(b10, "producerFactory.newBackg…readHandoffProducerQueue)");
        if (this.f25217l || this.f25218m) {
            com.facebook.imagepipeline.producers.g c10 = this.f25207b.c(b10);
            kotlin.jvm.internal.m.e(c10, "producerFactory.newBitma…er(threadHandoffProducer)");
            com.facebook.imagepipeline.producers.k g10 = this.f25207b.g(c10);
            kotlin.jvm.internal.m.e(g10, "producerFactory.newBitma…apMemoryCacheGetProducer)");
            return g10;
        }
        com.facebook.imagepipeline.producers.g c11 = this.f25207b.c(b10);
        kotlin.jvm.internal.m.e(c11, "producerFactory.newBitma…er(threadHandoffProducer)");
        return c11;
    }

    /* access modifiers changed from: private */
    public final d1 F(d1 d1Var) {
        LocalExifThumbnailProducer t10 = this.f25207b.t();
        kotlin.jvm.internal.m.e(t10, "producerFactory.newLocalExifThumbnailProducer()");
        return G(d1Var, new u1[]{t10});
    }

    /* access modifiers changed from: private */
    public final d1 G(d1 d1Var, u1[] u1VarArr) {
        return E(L(J(d1Var), u1VarArr));
    }

    private final d1 I(d1 d1Var) {
        x xVar;
        x xVar2;
        if (!l5.b.d()) {
            if (this.f25214i) {
                y0 z10 = this.f25207b.z(d1Var);
                kotlin.jvm.internal.m.e(z10, "producerFactory.newParti…heProducer(inputProducer)");
                xVar2 = this.f25207b.m(z10);
            } else {
                xVar2 = this.f25207b.m(d1Var);
            }
            kotlin.jvm.internal.m.e(xVar2, "if (partialImageCachingE…utProducer)\n            }");
            v l10 = this.f25207b.l(xVar2);
            kotlin.jvm.internal.m.e(l10, "producerFactory.newDiskC…ducer(cacheWriteProducer)");
            return l10;
        }
        l5.b.a("ProducerSequenceFactory#newDiskCacheSequence");
        try {
            if (this.f25214i) {
                y0 z11 = this.f25207b.z(d1Var);
                kotlin.jvm.internal.m.e(z11, "producerFactory.newParti…heProducer(inputProducer)");
                xVar = this.f25207b.m(z11);
            } else {
                xVar = this.f25207b.m(d1Var);
            }
            kotlin.jvm.internal.m.e(xVar, "if (partialImageCachingE…utProducer)\n            }");
            v l11 = this.f25207b.l(xVar);
            kotlin.jvm.internal.m.e(l11, "producerFactory.newDiskC…ducer(cacheWriteProducer)");
            l5.b.b();
            return l11;
        } catch (Throwable th) {
            l5.b.b();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final d1 J(d1 d1Var) {
        if (this.f25215j) {
            d1Var = I(d1Var);
        }
        d1 o10 = this.f25207b.o(d1Var);
        kotlin.jvm.internal.m.e(o10, "producerFactory.newEncodedMemoryCacheProducer(ip)");
        if (this.f25218m) {
            a0 p10 = this.f25207b.p(o10);
            kotlin.jvm.internal.m.e(p10, "producerFactory.newEncod…codedMemoryCacheProducer)");
            y n10 = this.f25207b.n(p10);
            kotlin.jvm.internal.m.e(n10, "producerFactory.newEncod…exProducer(probeProducer)");
            return n10;
        }
        y n11 = this.f25207b.n(o10);
        kotlin.jvm.internal.m.e(n11, "producerFactory.newEncod…codedMemoryCacheProducer)");
        return n11;
    }

    private final d1 K(u1[] u1VarArr) {
        t1 G2 = this.f25207b.G(u1VarArr);
        kotlin.jvm.internal.m.e(G2, "producerFactory.newThumb…ducer(thumbnailProducers)");
        k1 D2 = this.f25207b.D(G2, true, this.f25216k);
        kotlin.jvm.internal.m.e(D2, "producerFactory.newResiz…, imageTranscoderFactory)");
        return D2;
    }

    private final d1 L(d1 d1Var, u1[] u1VarArr) {
        com.facebook.imagepipeline.producers.b a10 = s.a(d1Var);
        kotlin.jvm.internal.m.e(a10, "newAddImageTransformMeta…taProducer(inputProducer)");
        k1 D2 = this.f25207b.D(a10, true, this.f25216k);
        kotlin.jvm.internal.m.e(D2, "producerFactory.newResiz…, imageTranscoderFactory)");
        r1 F2 = this.f25207b.F(D2);
        kotlin.jvm.internal.m.e(F2, "producerFactory.newThrot…ducer(localImageProducer)");
        com.facebook.imagepipeline.producers.m h10 = s.h(K(u1VarArr), F2);
        kotlin.jvm.internal.m.e(h10, "newBranchOnSeparateImage…lImageThrottlingProducer)");
        return h10;
    }

    private final d1 l(k5.b bVar) {
        d1 d1Var;
        if (!l5.b.d()) {
            Uri u10 = bVar.u();
            kotlin.jvm.internal.m.e(u10, "imageRequest.sourceUri");
            if (u10 != null) {
                int v10 = bVar.v();
                if (v10 == 0) {
                    return z();
                }
                switch (v10) {
                    case 2:
                        if (bVar.h()) {
                            return x();
                        }
                        return y();
                    case 3:
                        if (bVar.h()) {
                            return x();
                        }
                        return v();
                    case 4:
                        if (bVar.h()) {
                            return x();
                        }
                        if (a3.a.c(this.f25206a.getType(u10))) {
                            return y();
                        }
                        return t();
                    case 5:
                        return s();
                    case 6:
                        return w();
                    case 7:
                        return o();
                    case 8:
                        return C();
                    default:
                        Set set = this.f25220o;
                        if (set != null) {
                            Iterator it = set.iterator();
                            if (it.hasNext()) {
                                c.d.a(it.next());
                                throw null;
                            }
                        }
                        String a10 = K.c(u10);
                        throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + a10);
                }
            } else {
                throw new IllegalStateException("Uri is null.".toString());
            }
        } else {
            l5.b.a("ProducerSequenceFactory#getBasicDecodedImageSequence");
            try {
                Uri u11 = bVar.u();
                kotlin.jvm.internal.m.e(u11, "imageRequest.sourceUri");
                if (u11 != null) {
                    int v11 = bVar.v();
                    if (v11 != 0) {
                        switch (v11) {
                            case 2:
                                if (!bVar.h()) {
                                    d1Var = y();
                                    break;
                                } else {
                                    d1 x10 = x();
                                    l5.b.b();
                                    return x10;
                                }
                            case 3:
                                if (!bVar.h()) {
                                    d1Var = v();
                                    break;
                                } else {
                                    d1 x11 = x();
                                    l5.b.b();
                                    return x11;
                                }
                            case 4:
                                if (!bVar.h()) {
                                    if (!a3.a.c(this.f25206a.getType(u11))) {
                                        d1Var = t();
                                        break;
                                    } else {
                                        d1 y10 = y();
                                        l5.b.b();
                                        return y10;
                                    }
                                } else {
                                    d1 x12 = x();
                                    l5.b.b();
                                    return x12;
                                }
                            case 5:
                                d1Var = s();
                                break;
                            case 6:
                                d1Var = w();
                                break;
                            case 7:
                                d1Var = o();
                                break;
                            case 8:
                                d1Var = C();
                                break;
                            default:
                                Set set2 = this.f25220o;
                                if (set2 != null) {
                                    Iterator it2 = set2.iterator();
                                    if (it2.hasNext()) {
                                        c.d.a(it2.next());
                                        throw null;
                                    }
                                }
                                String a11 = K.c(u11);
                                throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + a11);
                        }
                    } else {
                        d1Var = z();
                    }
                    return d1Var;
                }
                throw new IllegalStateException("Uri is null.".toString());
            } finally {
                l5.b.b();
            }
        }
    }

    private final synchronized d1 m(d1 d1Var) {
        d1 d1Var2;
        d1Var2 = (d1) this.f25223r.get(d1Var);
        if (d1Var2 == null) {
            d1Var2 = this.f25207b.f(d1Var);
            this.f25223r.put(d1Var, d1Var2);
        }
        return d1Var2;
    }

    private final synchronized d1 q(d1 d1Var) {
        com.facebook.imagepipeline.producers.s k10;
        k10 = this.f25207b.k(d1Var);
        kotlin.jvm.internal.m.e(k10, "producerFactory.newDelayProducer(inputProducer)");
        return k10;
    }

    public final d1 A() {
        Object value = this.f25229x.getValue();
        kotlin.jvm.internal.m.e(value, "<get-networkFetchToEncod…oryPrefetchSequence>(...)");
        return (d1) value;
    }

    public final d1 C() {
        return (d1) this.G.getValue();
    }

    public final d1 E(d1 d1Var) {
        kotlin.jvm.internal.m.f(d1Var, "inputProducer");
        if (!l5.b.d()) {
            com.facebook.imagepipeline.producers.p j10 = this.f25207b.j(d1Var);
            kotlin.jvm.internal.m.e(j10, "producerFactory.newDecodeProducer(inputProducer)");
            return D(j10);
        }
        l5.b.a("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        try {
            com.facebook.imagepipeline.producers.p j11 = this.f25207b.j(d1Var);
            kotlin.jvm.internal.m.e(j11, "producerFactory.newDecodeProducer(inputProducer)");
            return D(j11);
        } finally {
            l5.b.b();
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized d1 H(x0 x0Var) {
        try {
            kotlin.jvm.internal.m.f(x0Var, "networkFetcher");
            boolean z10 = false;
            if (!l5.b.d()) {
                d1 y10 = this.f25207b.y(x0Var);
                kotlin.jvm.internal.m.e(y10, "producerFactory.newNetwo…hProducer(networkFetcher)");
                com.facebook.imagepipeline.producers.b a10 = s.a(J(y10));
                kotlin.jvm.internal.m.e(a10, "newAddImageTransformMeta…taProducer(inputProducer)");
                s sVar = this.f25207b;
                if (this.f25209d && this.f25212g != e.NEVER) {
                    z10 = true;
                }
                k1 D2 = sVar.D(a10, z10, this.f25216k);
                kotlin.jvm.internal.m.e(D2, "producerFactory.newResiz…  imageTranscoderFactory)");
                kotlin.jvm.internal.m.e(D2, "networkFetchToEncodedMemorySequence");
                return D2;
            }
            l5.b.a("ProducerSequenceFactory#createCommonNetworkFetchToEncodedMemorySequence");
            d1 y11 = this.f25207b.y(x0Var);
            kotlin.jvm.internal.m.e(y11, "producerFactory.newNetwo…hProducer(networkFetcher)");
            com.facebook.imagepipeline.producers.b a11 = s.a(J(y11));
            kotlin.jvm.internal.m.e(a11, "newAddImageTransformMeta…taProducer(inputProducer)");
            s sVar2 = this.f25207b;
            if (this.f25209d && this.f25212g != e.NEVER) {
                z10 = true;
            }
            k1 D3 = sVar2.D(a11, z10, this.f25216k);
            kotlin.jvm.internal.m.e(D3, "producerFactory.newResiz…  imageTranscoderFactory)");
            kotlin.jvm.internal.m.e(D3, "networkFetchToEncodedMemorySequence");
            l5.b.b();
            return D3;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final d1 i() {
        Object value = this.B.getValue();
        kotlin.jvm.internal.m.e(value, "<get-backgroundLocalCont…ncodeMemorySequence>(...)");
        return (d1) value;
    }

    public final d1 j() {
        Object value = this.A.getValue();
        kotlin.jvm.internal.m.e(value, "<get-backgroundLocalFile…ncodeMemorySequence>(...)");
        return (d1) value;
    }

    public final d1 k() {
        Object value = this.f25228w.getValue();
        kotlin.jvm.internal.m.e(value, "<get-backgroundNetworkFe…codedMemorySequence>(...)");
        return (d1) value;
    }

    public final d1 n() {
        return (d1) this.f25230y.getValue();
    }

    public final d1 o() {
        return (d1) this.J.getValue();
    }

    public final d1 p(k5.b bVar) {
        kotlin.jvm.internal.m.f(bVar, "imageRequest");
        if (!l5.b.d()) {
            d1 l10 = l(bVar);
            if (bVar.k() != null) {
                l10 = B(l10);
            }
            if (this.f25213h) {
                l10 = m(l10);
            }
            if (!this.f25219n || bVar.e() <= 0) {
                return l10;
            }
            return q(l10);
        }
        l5.b.a("ProducerSequenceFactory#getDecodedImageProducerSequence");
        try {
            d1 l11 = l(bVar);
            if (bVar.k() != null) {
                l11 = B(l11);
            }
            if (this.f25213h) {
                l11 = m(l11);
            }
            if (this.f25219n && bVar.e() > 0) {
                l11 = q(l11);
            }
            l5.b.b();
            return l11;
        } catch (Throwable th) {
            l5.b.b();
            throw th;
        }
    }

    public final d1 r(k5.b bVar) {
        kotlin.jvm.internal.m.f(bVar, "imageRequest");
        a aVar = K;
        aVar.d(bVar);
        int v10 = bVar.v();
        if (v10 == 0) {
            return A();
        }
        if (v10 == 2 || v10 == 3) {
            return u();
        }
        Uri u10 = bVar.u();
        kotlin.jvm.internal.m.e(u10, "imageRequest.sourceUri");
        String a10 = aVar.c(u10);
        throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + a10);
    }

    public final d1 s() {
        return (d1) this.I.getValue();
    }

    public final d1 t() {
        return (d1) this.E.getValue();
    }

    public final d1 u() {
        Object value = this.f25231z.getValue();
        kotlin.jvm.internal.m.e(value, "<get-localFileFetchToEnc…oryPrefetchSequence>(...)");
        return (d1) value;
    }

    public final d1 v() {
        return (d1) this.C.getValue();
    }

    public final d1 w() {
        return (d1) this.H.getValue();
    }

    public final d1 x() {
        return (d1) this.F.getValue();
    }

    public final d1 y() {
        return (d1) this.D.getValue();
    }

    public final d1 z() {
        return (d1) this.f25227v.getValue();
    }
}
