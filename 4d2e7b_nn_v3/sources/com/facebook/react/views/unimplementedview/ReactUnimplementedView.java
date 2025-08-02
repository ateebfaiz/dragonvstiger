package com.facebook.react.views.unimplementedview;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.m;

public final class ReactUnimplementedView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final AppCompatTextView f4358a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactUnimplementedView(Context context) {
        super(context);
        m.f(context, "context");
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.f4358a = appCompatTextView;
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        appCompatTextView.setGravity(17);
        appCompatTextView.setTextColor(-1);
        setBackgroundColor(1442775040);
        setGravity(1);
        setOrientation(1);
        addView(appCompatTextView);
    }

    public final void setName(String str) {
        m.f(str, "name");
        AppCompatTextView appCompatTextView = this.f4358a;
        appCompatTextView.setText("'" + str + "' is not Fabric compatible yet.");
    }
}
