package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f15023a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Location f15024b;

    public /* synthetic */ r(Consumer consumer, Location location) {
        this.f15023a = consumer;
        this.f15024b = location;
    }

    public final void run() {
        this.f15023a.accept(this.f15024b);
    }
}
