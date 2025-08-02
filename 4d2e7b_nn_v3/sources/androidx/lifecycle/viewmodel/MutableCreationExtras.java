package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this((CreationExtras) null, 1, (DefaultConstructorMarker) null);
    }

    public <T> T get(CreationExtras.Key<T> key) {
        m.f(key, "key");
        return getMap$lifecycle_viewmodel_release().get(key);
    }

    public final <T> void set(CreationExtras.Key<T> key, T t10) {
        m.f(key, "key");
        getMap$lifecycle_viewmodel_release().put(key, t10);
    }

    public MutableCreationExtras(CreationExtras creationExtras) {
        m.f(creationExtras, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(creationExtras.getMap$lifecycle_viewmodel_release());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }
}
