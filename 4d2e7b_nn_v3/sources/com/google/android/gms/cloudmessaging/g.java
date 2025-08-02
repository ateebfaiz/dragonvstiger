package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class g extends f {
    g(int i10, int i11, Bundle bundle) {
        super(i10, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        d(bundle2);
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return false;
    }
}
