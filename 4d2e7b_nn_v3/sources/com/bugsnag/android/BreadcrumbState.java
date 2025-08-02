package com.bugsnag.android;

import c1.f;
import c1.q;
import com.bugsnag.android.k2;
import com.bugsnag.android.v3;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.j;
import kotlin.collections.r;

public final class BreadcrumbState extends n implements k2.a {
    private final y callbackState;
    private final AtomicInteger index;
    private final s2 logger;
    private final int maxBreadcrumbs;
    private final Breadcrumb[] store;
    private final int validIndexMask = Integer.MAX_VALUE;

    public BreadcrumbState(int i10, y yVar, s2 s2Var) {
        this.maxBreadcrumbs = i10;
        this.callbackState = yVar;
        this.logger = s2Var;
        this.store = new Breadcrumb[i10];
        this.index = new AtomicInteger(0);
    }

    private final int getBreadcrumbIndex() {
        int i10;
        do {
            i10 = this.index.get() & this.validIndexMask;
        } while (!this.index.compareAndSet(i10, (i10 + 1) % this.maxBreadcrumbs));
        return i10;
    }

    public final void add(Breadcrumb breadcrumb) {
        if (this.maxBreadcrumbs != 0 && this.callbackState.g(breadcrumb, this.logger)) {
            this.store[getBreadcrumbIndex()] = breadcrumb;
            if (!getObservers$bugsnag_android_core_release().isEmpty()) {
                p pVar = breadcrumb.impl;
                String str = pVar.f18905a;
                BreadcrumbType breadcrumbType = pVar.f18906b;
                String c10 = f.c(pVar.f18908d);
                Map map = breadcrumb.impl.f18907c;
                if (map == null) {
                    map = new LinkedHashMap();
                }
                v3.a aVar = new v3.a(str, breadcrumbType, c10, map);
                for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                    onStateChange.onStateChange(aVar);
                }
            }
        }
    }

    public final List<Breadcrumb> copy() {
        if (this.maxBreadcrumbs == 0) {
            return r.l();
        }
        int i10 = -1;
        while (i10 == -1) {
            i10 = this.index.getAndSet(-1);
        }
        try {
            int i11 = this.maxBreadcrumbs;
            Breadcrumb[] breadcrumbArr = new Breadcrumb[i11];
            j.e(this.store, breadcrumbArr, 0, i10, i11);
            j.e(this.store, breadcrumbArr, this.maxBreadcrumbs - i10, 0, i10);
            return j.t(breadcrumbArr);
        } finally {
            this.index.set(i10);
        }
    }

    public void toStream(k2 k2Var) throws IOException {
        List<Breadcrumb> copy = copy();
        k2Var.h();
        for (Breadcrumb stream : copy) {
            stream.toStream(k2Var);
        }
        k2Var.m();
    }
}
