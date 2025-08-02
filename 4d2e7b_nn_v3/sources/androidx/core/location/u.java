package androidx.core.location;

import android.location.Location;
import java.util.function.Consumer;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ androidx.core.util.Consumer f15028a;

    public /* synthetic */ u(androidx.core.util.Consumer consumer) {
        this.f15028a = consumer;
    }

    public final void accept(Object obj) {
        this.f15028a.accept((Location) obj);
    }
}
