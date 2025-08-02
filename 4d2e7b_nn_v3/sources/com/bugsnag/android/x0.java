package com.bugsnag.android;

import android.os.Build;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class x0 {

    /* renamed from: j  reason: collision with root package name */
    public static final a f19119j = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f19120a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19121b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19122c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f19123d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19124e;

    /* renamed from: f  reason: collision with root package name */
    private final String f19125f;

    /* renamed from: g  reason: collision with root package name */
    private final String f19126g;

    /* renamed from: h  reason: collision with root package name */
    private final String f19127h;

    /* renamed from: i  reason: collision with root package name */
    private final String[] f19128i;

    public static final class a {
        private a() {
        }

        public final x0 a() {
            int i10 = Build.VERSION.SDK_INT;
            return new x0(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(i10), Build.DISPLAY, Build.FINGERPRINT, Build.TAGS, Build.BRAND, Build.SUPPORTED_ABIS);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public x0(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String[] strArr) {
        this.f19120a = str;
        this.f19121b = str2;
        this.f19122c = str3;
        this.f19123d = num;
        this.f19124e = str4;
        this.f19125f = str5;
        this.f19126g = str6;
        this.f19127h = str7;
        this.f19128i = strArr;
    }

    public final Integer a() {
        return this.f19123d;
    }

    public final String b() {
        return this.f19127h;
    }

    public final String[] c() {
        return this.f19128i;
    }

    public final String d() {
        return this.f19125f;
    }

    public final String e() {
        return this.f19120a;
    }

    public final String f() {
        return this.f19121b;
    }

    public final String g() {
        return this.f19124e;
    }

    public final String h() {
        return this.f19122c;
    }

    public final String i() {
        return this.f19126g;
    }
}
