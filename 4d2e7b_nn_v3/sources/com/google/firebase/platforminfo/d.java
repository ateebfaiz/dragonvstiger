package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;

public final /* synthetic */ class d implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9327a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LibraryVersionComponent.VersionExtractor f9328b;

    public /* synthetic */ d(String str, LibraryVersionComponent.VersionExtractor versionExtractor) {
        this.f9327a = str;
        this.f9328b = versionExtractor;
    }

    public final Object create(ComponentContainer componentContainer) {
        return c.a(this.f9327a, this.f9328b.extract((Context) componentContainer.get(Context.class)));
    }
}
