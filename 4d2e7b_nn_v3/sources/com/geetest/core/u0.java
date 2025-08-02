package com.geetest.core;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class u0 implements Enumeration {

    /* renamed from: a  reason: collision with root package name */
    public int f6187a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ w0 f6188b;

    public u0(w0 w0Var) {
        this.f6188b = w0Var;
    }

    public boolean hasMoreElements() {
        if (this.f6187a < this.f6188b.f6201a.length) {
            return true;
        }
        return false;
    }

    public Object nextElement() {
        int i10 = this.f6187a;
        v[] vVarArr = this.f6188b.f6201a;
        if (i10 < vVarArr.length) {
            this.f6187a = i10 + 1;
            return vVarArr[i10];
        }
        throw new NoSuchElementException();
    }
}
