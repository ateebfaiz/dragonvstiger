package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f6777a;

    public d(Uri uri) {
        this.f6777a = uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        return Objects.equal(((d) obj).f6777a, this.f6777a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f6777a);
    }
}
