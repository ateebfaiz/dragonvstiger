package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

class a {

    /* renamed from: a  reason: collision with root package name */
    final Set f16432a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase f16433b;

    a(RoomDatabase roomDatabase) {
        this.f16433b = roomDatabase;
    }

    /* access modifiers changed from: package-private */
    public LiveData a(String[] strArr, boolean z10, Callable callable) {
        return new c(this.f16433b, this, z10, callable, strArr);
    }

    /* access modifiers changed from: package-private */
    public void b(LiveData liveData) {
        this.f16432a.add(liveData);
    }

    /* access modifiers changed from: package-private */
    public void c(LiveData liveData) {
        this.f16432a.remove(liveData);
    }
}
