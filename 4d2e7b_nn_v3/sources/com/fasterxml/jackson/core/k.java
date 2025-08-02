package com.fasterxml.jackson.core;

public enum k {
    NOT_AVAILABLE((String) null, -1),
    START_OBJECT("{", 1),
    END_OBJECT("}", 2),
    START_ARRAY("[", 3),
    END_ARRAY("]", 4),
    FIELD_NAME((String) null, 5),
    VALUE_EMBEDDED_OBJECT((String) null, 12),
    VALUE_STRING((String) null, 6),
    VALUE_NUMBER_INT((String) null, 7),
    VALUE_NUMBER_FLOAT((String) null, 8),
    VALUE_TRUE("true", 9),
    VALUE_FALSE("false", 10),
    VALUE_NULL("null", 11);
    

    /* renamed from: a  reason: collision with root package name */
    final String f5173a;

    /* renamed from: b  reason: collision with root package name */
    final char[] f5174b;

    /* renamed from: c  reason: collision with root package name */
    final byte[] f5175c;

    /* renamed from: d  reason: collision with root package name */
    final int f5176d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f5177e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f5178f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f5179g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f5180h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f5181i;

    private k(String str, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = false;
        if (str == null) {
            this.f5173a = null;
            this.f5174b = null;
            this.f5175c = null;
        } else {
            this.f5173a = str;
            char[] charArray = str.toCharArray();
            this.f5174b = charArray;
            int length = charArray.length;
            this.f5175c = new byte[length];
            for (int i11 = 0; i11 < length; i11++) {
                this.f5175c[i11] = (byte) this.f5174b[i11];
            }
        }
        this.f5176d = i10;
        if (i10 == 10 || i10 == 9) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f5180h = z10;
        if (i10 == 7 || i10 == 8) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f5179g = z11;
        if (i10 == 1 || i10 == 3) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.f5177e = z12;
        if (i10 == 2 || i10 == 4) {
            z13 = true;
        } else {
            z13 = false;
        }
        this.f5178f = z13;
        if (!z12 && !z13 && i10 != 5 && i10 != -1) {
            z14 = true;
        }
        this.f5181i = z14;
    }
}
