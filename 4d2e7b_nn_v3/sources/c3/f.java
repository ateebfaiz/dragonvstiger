package c3;

import java.lang.ref.SoftReference;

public class f {

    /* renamed from: a  reason: collision with root package name */
    SoftReference f17288a = null;

    /* renamed from: b  reason: collision with root package name */
    SoftReference f17289b = null;

    /* renamed from: c  reason: collision with root package name */
    SoftReference f17290c = null;

    public void a() {
        SoftReference softReference = this.f17288a;
        if (softReference != null) {
            softReference.clear();
            this.f17288a = null;
        }
        SoftReference softReference2 = this.f17289b;
        if (softReference2 != null) {
            softReference2.clear();
            this.f17289b = null;
        }
        SoftReference softReference3 = this.f17290c;
        if (softReference3 != null) {
            softReference3.clear();
            this.f17290c = null;
        }
    }

    public Object b() {
        SoftReference softReference = this.f17288a;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void c(Object obj) {
        this.f17288a = new SoftReference(obj);
        this.f17289b = new SoftReference(obj);
        this.f17290c = new SoftReference(obj);
    }
}
