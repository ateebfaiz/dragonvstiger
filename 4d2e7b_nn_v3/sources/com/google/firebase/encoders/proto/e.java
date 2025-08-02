package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;

class e implements ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private boolean f9104a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9105b = false;

    /* renamed from: c  reason: collision with root package name */
    private FieldDescriptor f9106c;

    /* renamed from: d  reason: collision with root package name */
    private final c f9107d;

    e(c cVar) {
        this.f9107d = cVar;
    }

    private void a() {
        if (!this.f9104a) {
            this.f9104a = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    public ValueEncoderContext add(String str) {
        a();
        this.f9107d.d(this.f9106c, str, this.f9105b);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b(FieldDescriptor fieldDescriptor, boolean z10) {
        this.f9104a = false;
        this.f9106c = fieldDescriptor;
        this.f9105b = z10;
    }

    public ValueEncoderContext add(float f10) {
        a();
        this.f9107d.c(this.f9106c, f10, this.f9105b);
        return this;
    }

    public ValueEncoderContext add(double d10) {
        a();
        this.f9107d.b(this.f9106c, d10, this.f9105b);
        return this;
    }

    public ValueEncoderContext add(int i10) {
        a();
        this.f9107d.f(this.f9106c, i10, this.f9105b);
        return this;
    }

    public ValueEncoderContext add(long j10) {
        a();
        this.f9107d.h(this.f9106c, j10, this.f9105b);
        return this;
    }

    public ValueEncoderContext add(boolean z10) {
        a();
        this.f9107d.j(this.f9106c, z10, this.f9105b);
        return this;
    }

    public ValueEncoderContext add(byte[] bArr) {
        a();
        this.f9107d.d(this.f9106c, bArr, this.f9105b);
        return this;
    }
}
