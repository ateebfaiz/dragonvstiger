package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class s extends AbstractList {

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicInteger f20938g = new AtomicInteger();

    /* renamed from: h  reason: collision with root package name */
    public static final b f20939h = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Handler f20940a;

    /* renamed from: b  reason: collision with root package name */
    private int f20941b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20942c;

    /* renamed from: d  reason: collision with root package name */
    private List f20943d;

    /* renamed from: e  reason: collision with root package name */
    private List f20944e;

    /* renamed from: f  reason: collision with root package name */
    private String f20945f;

    public interface a {
        void a(s sVar);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public s() {
        this.f20942c = String.valueOf(f20938g.incrementAndGet());
        this.f20944e = new ArrayList();
        this.f20943d = new ArrayList();
    }

    private final List g() {
        return GraphRequest.f19541t.g(this);
    }

    private final r j() {
        return GraphRequest.f19541t.j(this);
    }

    /* renamed from: a */
    public void add(int i10, GraphRequest graphRequest) {
        m.f(graphRequest, "element");
        this.f20943d.add(i10, graphRequest);
    }

    /* renamed from: c */
    public boolean add(GraphRequest graphRequest) {
        m.f(graphRequest, "element");
        return this.f20943d.add(graphRequest);
    }

    public void clear() {
        this.f20943d.clear();
    }

    public final /* bridge */ boolean contains(Object obj) {
        boolean z10;
        if (obj != null) {
            z10 = obj instanceof GraphRequest;
        } else {
            z10 = true;
        }
        if (z10) {
            return e((GraphRequest) obj);
        }
        return false;
    }

    public final void d(a aVar) {
        m.f(aVar, "callback");
        if (!this.f20944e.contains(aVar)) {
            this.f20944e.add(aVar);
        }
    }

    public /* bridge */ boolean e(GraphRequest graphRequest) {
        return super.contains(graphRequest);
    }

    public final List f() {
        return g();
    }

    public final r i() {
        return j();
    }

    public final /* bridge */ int indexOf(Object obj) {
        boolean z10;
        if (obj != null) {
            z10 = obj instanceof GraphRequest;
        } else {
            z10 = true;
        }
        if (z10) {
            return s((GraphRequest) obj);
        }
        return -1;
    }

    /* renamed from: k */
    public GraphRequest get(int i10) {
        return (GraphRequest) this.f20943d.get(i10);
    }

    public final String l() {
        return this.f20945f;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        boolean z10;
        if (obj != null) {
            z10 = obj instanceof GraphRequest;
        } else {
            z10 = true;
        }
        if (z10) {
            return t((GraphRequest) obj);
        }
        return -1;
    }

    public final Handler m() {
        return this.f20940a;
    }

    public final List n() {
        return this.f20944e;
    }

    public final String o() {
        return this.f20942c;
    }

    public final List p() {
        return this.f20943d;
    }

    public int q() {
        return this.f20943d.size();
    }

    public final int r() {
        return this.f20941b;
    }

    public /* bridge */ int s(GraphRequest graphRequest) {
        return super.indexOf(graphRequest);
    }

    public final /* bridge */ int size() {
        return q();
    }

    public /* bridge */ int t(GraphRequest graphRequest) {
        return super.lastIndexOf(graphRequest);
    }

    public /* bridge */ boolean u(GraphRequest graphRequest) {
        return super.remove(graphRequest);
    }

    /* renamed from: v */
    public GraphRequest remove(int i10) {
        return (GraphRequest) this.f20943d.remove(i10);
    }

    /* renamed from: w */
    public GraphRequest set(int i10, GraphRequest graphRequest) {
        m.f(graphRequest, "element");
        return (GraphRequest) this.f20943d.set(i10, graphRequest);
    }

    public final void x(Handler handler) {
        this.f20940a = handler;
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (obj != null ? obj instanceof GraphRequest : true) {
            return u((GraphRequest) obj);
        }
        return false;
    }

    public s(Collection collection) {
        m.f(collection, "requests");
        this.f20942c = String.valueOf(f20938g.incrementAndGet());
        this.f20944e = new ArrayList();
        this.f20943d = new ArrayList(collection);
    }

    public s(GraphRequest... graphRequestArr) {
        m.f(graphRequestArr, "requests");
        this.f20942c = String.valueOf(f20938g.incrementAndGet());
        this.f20944e = new ArrayList();
        this.f20943d = new ArrayList(j.c(graphRequestArr));
    }
}
