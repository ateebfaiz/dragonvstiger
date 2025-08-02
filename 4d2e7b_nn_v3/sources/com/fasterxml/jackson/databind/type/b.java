package com.fasterxml.jackson.databind.type;

import java.io.Serializable;

public final class b implements Comparable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f5612a;

    /* renamed from: b  reason: collision with root package name */
    private Class f5613b;

    /* renamed from: c  reason: collision with root package name */
    private int f5614c;

    public b(Class cls) {
        this.f5613b = cls;
        String name = cls.getName();
        this.f5612a = name;
        this.f5614c = name.hashCode();
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        return this.f5612a.compareTo(bVar.f5612a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != b.class) {
            return false;
        }
        if (((b) obj).f5613b == this.f5613b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f5614c;
    }

    public String toString() {
        return this.f5612a;
    }
}
