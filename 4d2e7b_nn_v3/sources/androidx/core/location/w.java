package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Consumer f15030a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Location f15031b;

    public /* synthetic */ w(Consumer consumer, Location location) {
        this.f15030a = consumer;
        this.f15031b = location;
    }

    public final void run() {
        this.f15030a.accept(this.f15031b);
    }
}
