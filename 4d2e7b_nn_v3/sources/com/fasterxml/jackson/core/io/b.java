package com.fasterxml.jackson.core.io;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;
import java.util.Objects;

public class b implements Serializable {

    /* renamed from: e  reason: collision with root package name */
    protected static final b f5137e = new b(false, (Object) null);

    /* renamed from: a  reason: collision with root package name */
    protected final transient Object f5138a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f5139b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f5140c;

    /* renamed from: d  reason: collision with root package name */
    protected final boolean f5141d;

    protected b(boolean z10, Object obj) {
        this(z10, obj, -1, -1);
    }

    public static b a(boolean z10, Object obj) {
        return new b(z10, obj);
    }

    public static b c() {
        return f5137e;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
    }

    public Object b() {
        return this.f5138a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f5139b != bVar.f5139b || this.f5140c != bVar.f5140c) {
            return false;
        }
        Object obj2 = bVar.f5138a;
        Object obj3 = this.f5138a;
        if (obj3 == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        } else if (obj2 == null) {
            return false;
        } else {
            if ((obj3 instanceof File) || (obj3 instanceof URL) || (obj3 instanceof URI)) {
                return obj3.equals(obj2);
            }
            if (obj3 == obj2) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.f5138a);
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return f5137e;
    }

    protected b(boolean z10, Object obj, int i10, int i11) {
        this.f5141d = z10;
        this.f5138a = obj;
        this.f5139b = i10;
        this.f5140c = i11;
    }
}
