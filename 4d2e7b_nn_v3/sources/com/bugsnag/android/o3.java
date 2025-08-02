package com.bugsnag.android;

import com.bugsnag.android.d2;
import com.bugsnag.android.m3;
import java.io.File;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class o3 extends d2 {

    /* renamed from: h  reason: collision with root package name */
    public static final a f18895h = new a((DefaultConstructorMarker) null);

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator f18896i = new n3();

    /* renamed from: g  reason: collision with root package name */
    private final String f18897g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public o3(File file, int i10, String str, s2 s2Var, d2.a aVar) {
        super(new File(file, "sessions"), i10, s2Var, aVar);
        this.f18897g = str;
    }

    /* access modifiers changed from: private */
    public static final int m(File file, File file2) {
        if (file == null && file2 == null) {
            return 0;
        }
        if (file == null) {
            return 1;
        }
        if (file2 == null) {
            return -1;
        }
        return file.getName().compareTo(file2.getName());
    }

    public String f(Object obj) {
        return m3.f18854d.a(obj, this.f18897g).a();
    }

    public final Date n(File file) {
        m3.a aVar = m3.f18854d;
        m.c(file);
        return new Date(aVar.c(file));
    }

    public final boolean o(File file) {
        Calendar instance = Calendar.getInstance();
        instance.add(5, -60);
        m3.a aVar = m3.f18854d;
        m.c(file);
        if (aVar.c(file) < instance.getTimeInMillis()) {
            return true;
        }
        return false;
    }
}
