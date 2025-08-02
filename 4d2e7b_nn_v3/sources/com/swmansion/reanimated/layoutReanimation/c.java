package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.ArrayList;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f11457a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f11458b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewGroupManager f11459c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f11460d;

    public /* synthetic */ c(ArrayList arrayList, View view, ViewGroupManager viewGroupManager, ViewGroup viewGroup) {
        this.f11457a = arrayList;
        this.f11458b = view;
        this.f11459c = viewGroupManager;
        this.f11460d = viewGroup;
    }

    public final void run() {
        ReanimatedNativeHierarchyManager.lambda$manageChildren$0(this.f11457a, this.f11458b, this.f11459c, this.f11460d);
    }
}
