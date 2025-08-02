package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.j;
import com.facebook.l;
import q5.a;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    private j f4535a;

    public m(j jVar) {
        this.f4535a = jVar;
    }

    public void a(a aVar) {
        j jVar = this.f4535a;
        if (jVar != null) {
            jVar.onCancel();
        }
    }

    public void b(a aVar, l lVar) {
        j jVar = this.f4535a;
        if (jVar != null) {
            jVar.a(lVar);
        }
    }

    public abstract void c(a aVar, Bundle bundle);
}
