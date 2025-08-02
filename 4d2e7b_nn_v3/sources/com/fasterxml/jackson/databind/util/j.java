package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class j implements k, Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected final transient int f5689a;

    /* renamed from: b  reason: collision with root package name */
    protected final transient ConcurrentHashMap f5690b;

    /* renamed from: c  reason: collision with root package name */
    protected transient int f5691c;

    public j(int i10, int i11) {
        this.f5690b = new ConcurrentHashMap(i10, 0.8f, 4);
        this.f5689a = i11;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.f5691c = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f5691c);
    }

    public void a() {
        this.f5690b.clear();
    }

    public Object b(Object obj, Object obj2) {
        if (this.f5690b.size() >= this.f5689a) {
            synchronized (this) {
                try {
                    if (this.f5690b.size() >= this.f5689a) {
                        a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f5690b.put(obj, obj2);
    }

    public Object get(Object obj) {
        return this.f5690b.get(obj);
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        if (this.f5690b.size() >= this.f5689a) {
            synchronized (this) {
                try {
                    if (this.f5690b.size() >= this.f5689a) {
                        a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f5690b.putIfAbsent(obj, obj2);
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        int i10 = this.f5691c;
        return new j(i10, i10);
    }
}
