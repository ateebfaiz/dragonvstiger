package mb;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import wb.b;

public final class j extends g implements Set, Serializable, b {

    /* renamed from: b  reason: collision with root package name */
    private static final a f1313b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final j f1314c = new j(d.Y.e());

    /* renamed from: a  reason: collision with root package name */
    private final d f1315a;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(d dVar) {
        m.f(dVar, "backing");
        this.f1315a = dVar;
    }

    private final Object writeReplace() {
        if (this.f1315a.G()) {
            return new h(this, 1);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    public int a() {
        return this.f1315a.size();
    }

    public boolean add(Object obj) {
        if (this.f1315a.l(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean addAll(Collection collection) {
        m.f(collection, "elements");
        this.f1315a.o();
        return super.addAll(collection);
    }

    public final Set c() {
        this.f1315a.n();
        if (size() > 0) {
            return this;
        }
        return f1314c;
    }

    public void clear() {
        this.f1315a.clear();
    }

    public boolean contains(Object obj) {
        return this.f1315a.containsKey(obj);
    }

    public boolean isEmpty() {
        return this.f1315a.isEmpty();
    }

    public Iterator iterator() {
        return this.f1315a.H();
    }

    public boolean remove(Object obj) {
        if (this.f1315a.P(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        m.f(collection, "elements");
        this.f1315a.o();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        m.f(collection, "elements");
        this.f1315a.o();
        return super.retainAll(collection);
    }

    public j() {
        this(new d());
    }

    public j(int i10) {
        this(new d(i10));
    }
}
