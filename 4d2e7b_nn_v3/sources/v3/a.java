package v3;

import android.graphics.drawable.Animatable;
import t3.c;

public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    private long f24391b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f24392c = -1;

    /* renamed from: d  reason: collision with root package name */
    private b f24393d;

    public a(b bVar) {
        this.f24393d = bVar;
    }

    public void f(String str, Object obj, Animatable animatable) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f24392c = currentTimeMillis;
        b bVar = this.f24393d;
        if (bVar != null) {
            bVar.a(currentTimeMillis - this.f24391b);
        }
    }

    public void o(String str, Object obj) {
        this.f24391b = System.currentTimeMillis();
    }
}
