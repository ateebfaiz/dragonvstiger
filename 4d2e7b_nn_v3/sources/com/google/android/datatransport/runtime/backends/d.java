package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6457a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f6458b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f6459c;

    d(Context context, Clock clock, Clock clock2) {
        this.f6457a = context;
        this.f6458b = clock;
        this.f6459c = clock2;
    }

    /* access modifiers changed from: package-private */
    public CreationContext a(String str) {
        return CreationContext.create(this.f6457a, this.f6458b, this.f6459c, str);
    }
}
