package com.bugsnag.android;

import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.r;

public abstract class g4 {
    public static final List a(Throwable th) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (th != null && linkedHashSet.add(th)) {
            th = th.getCause();
        }
        return r.w0(linkedHashSet);
    }
}
