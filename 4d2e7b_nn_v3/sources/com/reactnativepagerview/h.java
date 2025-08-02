package com.reactnativepagerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class h extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public static final a f11344a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public final h a(ViewGroup viewGroup) {
            m.f(viewGroup, "parent");
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setSaveEnabled(false);
            return new h(frameLayout, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ h(FrameLayout frameLayout, DefaultConstructorMarker defaultConstructorMarker) {
        this(frameLayout);
    }

    public final FrameLayout getContainer() {
        View view = this.itemView;
        m.d(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        return (FrameLayout) view;
    }

    private h(FrameLayout frameLayout) {
        super(frameLayout);
    }
}
