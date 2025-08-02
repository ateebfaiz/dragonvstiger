package com.swmansion.reanimated;

import com.facebook.react.fabric.interop.UIBlock;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import java.util.ArrayList;

public final /* synthetic */ class e implements UIBlock {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReanimatedModule f11439a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f11440b;

    public /* synthetic */ e(ReanimatedModule reanimatedModule, ArrayList arrayList) {
        this.f11439a = reanimatedModule;
        this.f11440b = arrayList;
    }

    public final void execute(UIBlockViewResolver uIBlockViewResolver) {
        this.f11439a.lambda$willDispatchViewUpdates$0(this.f11440b, uIBlockViewResolver);
    }
}
