package com.bugsnag.android;

import android.content.Context;
import c1.j;
import d1.d;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class g1 {

    /* renamed from: a  reason: collision with root package name */
    private final File f18735a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0 f18736b;

    /* renamed from: c  reason: collision with root package name */
    private final File f18737c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0 f18738d;

    /* renamed from: e  reason: collision with root package name */
    private final d f18739e;

    /* renamed from: f  reason: collision with root package name */
    private final s2 f18740f;

    /* renamed from: g  reason: collision with root package name */
    private f1 f18741g;

    /* renamed from: h  reason: collision with root package name */
    private f1 f18742h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f18743i;

    /* renamed from: j  reason: collision with root package name */
    private c f18744j;

    static final class a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18745a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    static final class b extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18746a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f18747a;

        /* renamed from: b  reason: collision with root package name */
        private final String f18748b;

        public c(String str, String str2) {
            this.f18747a = str;
            this.f18748b = str2;
        }

        public final String a() {
            return this.f18747a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return m.b(this.f18747a, cVar.f18747a) && m.b(this.f18748b, cVar.f18748b);
        }

        public int hashCode() {
            String str = this.f18747a;
            int i10 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.f18748b;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return hashCode + i10;
        }

        public String toString() {
            return "DeviceIds(deviceId=" + this.f18747a + ", internalDeviceId=" + this.f18748b + ')';
        }
    }

    public g1(Context context, File file, Function0 function0, File file2, Function0 function02, d dVar, j jVar, s2 s2Var) {
        this.f18735a = file;
        this.f18736b = function0;
        this.f18737c = file2;
        this.f18738d = function02;
        this.f18739e = dVar;
        this.f18740f = s2Var;
        this.f18743i = jVar.p();
    }

    private final String b() {
        f1 f1Var = null;
        if (!this.f18743i) {
            return null;
        }
        f1 f1Var2 = this.f18741g;
        if (f1Var2 == null) {
            m.u("persistence");
            f1Var2 = null;
        }
        String a10 = f1Var2.a(false);
        if (a10 != null) {
            return a10;
        }
        String a11 = ((r3) this.f18739e.get()).a(false);
        if (a11 != null) {
            return a11;
        }
        f1 f1Var3 = this.f18741g;
        if (f1Var3 == null) {
            m.u("persistence");
        } else {
            f1Var = f1Var3;
        }
        return f1Var.a(true);
    }

    private final String c() {
        f1 f1Var = null;
        if (!this.f18743i) {
            return null;
        }
        f1 f1Var2 = this.f18742h;
        if (f1Var2 == null) {
            m.u("internalPersistence");
        } else {
            f1Var = f1Var2;
        }
        return f1Var.a(true);
    }

    public final c a() {
        c cVar = this.f18744j;
        if (cVar != null) {
            return cVar;
        }
        this.f18741g = new e1(this.f18735a, this.f18736b, this.f18740f);
        this.f18742h = new e1(this.f18737c, this.f18738d, this.f18740f);
        String b10 = b();
        String c10 = c();
        if (!(b10 == null && c10 == null)) {
            this.f18744j = new c(b10, c10);
        }
        return this.f18744j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(Context context, File file, Function0 function0, File file2, Function0 function02, d dVar, j jVar, s2 s2Var, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? new File(context.getFilesDir(), "device-id") : file, (i10 & 4) != 0 ? a.f18745a : function0, (i10 & 8) != 0 ? new File(context.getFilesDir(), "internal-device-id") : file2, (i10 & 16) != 0 ? b.f18746a : function02, dVar, jVar, s2Var);
    }
}
