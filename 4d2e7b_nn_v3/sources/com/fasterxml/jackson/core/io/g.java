package com.fasterxml.jackson.core.io;

import j8.a;
import j8.j;
import java.io.Writer;

public final class g extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final j f5164a;

    public g(a aVar) {
        this.f5164a = new j(aVar);
    }

    public String a() {
        String h10 = this.f5164a.h();
        this.f5164a.l();
        return h10;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(char[] cArr) {
        this.f5164a.c(cArr, 0, cArr.length);
    }

    public void write(char[] cArr, int i10, int i11) {
        this.f5164a.c(cArr, i10, i11);
    }

    public void write(int i10) {
        this.f5164a.a((char) i10);
    }

    public Writer append(char c10) {
        write((int) c10);
        return this;
    }

    public void write(String str) {
        this.f5164a.b(str, 0, str.length());
    }

    public Writer append(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        this.f5164a.b(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void write(String str, int i10, int i11) {
        this.f5164a.b(str, i10, i11);
    }

    public Writer append(CharSequence charSequence, int i10, int i11) {
        String charSequence2 = charSequence.subSequence(i10, i11).toString();
        this.f5164a.b(charSequence2, 0, charSequence2.length());
        return this;
    }
}
