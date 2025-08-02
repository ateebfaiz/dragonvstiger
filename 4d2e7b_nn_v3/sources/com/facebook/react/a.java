package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Iterator;

public final /* synthetic */ class a implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f20738a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Iterator f20739b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f20740c;

    public /* synthetic */ a(b bVar, Iterator it, ReactApplicationContext reactApplicationContext) {
        this.f20738a = bVar;
        this.f20739b = it;
        this.f20740c = reactApplicationContext;
    }

    public final Iterator iterator() {
        return this.f20738a.d(this.f20739b, this.f20740c);
    }
}
