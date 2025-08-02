package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;

final class e0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ApiKey f6685a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Feature f6686b;

    /* synthetic */ e0(ApiKey apiKey, Feature feature, zabr zabr) {
        this.f6685a = apiKey;
        this.f6686b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof e0)) {
            e0 e0Var = (e0) obj;
            if (!Objects.equal(this.f6685a, e0Var.f6685a) || !Objects.equal(this.f6686b, e0Var.f6686b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f6685a, this.f6686b);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("key", this.f6685a).add("feature", this.f6686b).toString();
    }
}
