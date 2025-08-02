package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import g6.b;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f4205b;

    /* renamed from: a  reason: collision with root package name */
    private final b f4206a;

    private d(b bVar) {
        this.f4206a = bVar;
    }

    public static d a() {
        if (f4205b == null) {
            f4205b = new d(b.b());
        }
        return f4205b;
    }

    public Typeface b(String str, int i10, int i11, AssetManager assetManager) {
        return this.f4206a.c(str, i10, i11, assetManager);
    }

    public Typeface c(String str, int i10, AssetManager assetManager) {
        return this.f4206a.d(str, i10, assetManager);
    }
}
