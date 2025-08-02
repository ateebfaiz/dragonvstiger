package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;

final class c implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Collection f7830a;

    c(Collection collection) {
        this.f7830a = collection;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f7830a);
        return Tasks.forResult(arrayList);
    }
}
