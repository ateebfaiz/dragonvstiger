package com.swmansion.gesturehandler.react;

import ab.e;
import ab.o;
import android.util.SparseArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.swmansion.gesturehandler.react.i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class d implements e {

    /* renamed from: d  reason: collision with root package name */
    public static final a f11403d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray f11404a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray f11405b = new SparseArray();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray f11406c = new SparseArray();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final int[] f(ReadableMap readableMap, String str) {
        ReadableArray array = readableMap.getArray(str);
        m.c(array);
        int size = array.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = array.getInt(i10);
        }
        return iArr;
    }

    public boolean a(ab.d dVar, ab.d dVar2) {
        m.f(dVar, "handler");
        m.f(dVar2, "otherHandler");
        int[] iArr = (int[]) this.f11406c.get(dVar.R());
        if (iArr == null) {
            return false;
        }
        for (int i10 : iArr) {
            if (i10 == dVar2.R()) {
                return true;
            }
        }
        return false;
    }

    public boolean b(ab.d dVar, ab.d dVar2) {
        m.f(dVar, "handler");
        m.f(dVar2, "otherHandler");
        int[] iArr = (int[]) this.f11405b.get(dVar.R());
        if (iArr == null) {
            return false;
        }
        for (int i10 : iArr) {
            if (i10 == dVar2.R()) {
                return true;
            }
        }
        return false;
    }

    public boolean c(ab.d dVar, ab.d dVar2) {
        m.f(dVar, "handler");
        m.f(dVar2, "otherHandler");
        int[] iArr = (int[]) this.f11404a.get(dVar.R());
        if (iArr == null) {
            return false;
        }
        for (int i10 : iArr) {
            if (i10 == dVar2.R()) {
                return true;
            }
        }
        return false;
    }

    public boolean d(ab.d dVar, ab.d dVar2) {
        m.f(dVar, "handler");
        m.f(dVar2, "otherHandler");
        if (dVar2 instanceof o) {
            return ((o) dVar2).S0();
        }
        if (dVar2 instanceof i.b) {
            return true;
        }
        return false;
    }

    public final void e(ab.d dVar, ReadableMap readableMap) {
        m.f(dVar, "handler");
        m.f(readableMap, "config");
        dVar.y0(this);
        if (readableMap.hasKey("waitFor")) {
            this.f11404a.put(dVar.R(), f(readableMap, "waitFor"));
        }
        if (readableMap.hasKey("simultaneousHandlers")) {
            this.f11405b.put(dVar.R(), f(readableMap, "simultaneousHandlers"));
        }
        if (readableMap.hasKey("blocksHandlers")) {
            this.f11406c.put(dVar.R(), f(readableMap, "blocksHandlers"));
        }
    }

    public final void g(int i10) {
        this.f11404a.remove(i10);
        this.f11405b.remove(i10);
    }

    public final void h() {
        this.f11404a.clear();
        this.f11405b.clear();
    }
}
