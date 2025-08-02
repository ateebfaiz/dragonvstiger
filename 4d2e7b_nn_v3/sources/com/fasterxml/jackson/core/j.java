package com.fasterxml.jackson.core;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.fasterxml.jackson.core.io.a;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    protected int f5169a;

    /* renamed from: b  reason: collision with root package name */
    protected int f5170b;

    protected j() {
    }

    public final int a() {
        int i10 = this.f5170b;
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    public abstract String b();

    public final int c() {
        return this.f5170b + 1;
    }

    public final boolean d() {
        if (this.f5169a == 1) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (this.f5169a == 2) {
            return true;
        }
        return false;
    }

    public String f() {
        int i10 = this.f5169a;
        if (i10 == 0) {
            return "root";
        }
        if (i10 == 1) {
            return "Array";
        }
        if (i10 != 2) {
            return "?";
        }
        return "Object";
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        int i10 = this.f5169a;
        if (i10 == 0) {
            sb2.append(DomExceptionUtils.SEPARATOR);
        } else if (i10 != 1) {
            sb2.append('{');
            String b10 = b();
            if (b10 != null) {
                sb2.append('\"');
                a.a(sb2, b10);
                sb2.append('\"');
            } else {
                sb2.append('?');
            }
            sb2.append('}');
        } else {
            sb2.append('[');
            sb2.append(a());
            sb2.append(']');
        }
        return sb2.toString();
    }
}
