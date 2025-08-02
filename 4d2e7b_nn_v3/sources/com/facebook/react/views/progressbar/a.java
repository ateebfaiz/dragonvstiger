package com.facebook.react.views.progressbar;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.react.uimanager.v;
import com.facebook.yoga.n;
import com.facebook.yoga.o;
import com.facebook.yoga.p;
import com.facebook.yoga.q;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.m;

public final class a extends v implements n {
    private final SparseIntArray A = new SparseIntArray();
    private final SparseIntArray B = new SparseIntArray();
    private final Set C = new HashSet();
    private String D;

    public a() {
        X0(this);
        this.D = "Normal";
    }

    public long U(q qVar, float f10, o oVar, float f11, o oVar2) {
        m.f(qVar, "node");
        m.f(oVar, "widthMode");
        m.f(oVar2, "heightMode");
        int styleFromString = ReactProgressBarViewManager.getStyleFromString(this.D);
        if (!this.C.contains(Integer.valueOf(styleFromString))) {
            ProgressBar createProgressBar = ReactProgressBarViewManager.createProgressBar(F(), styleFromString);
            m.e(createProgressBar, "createProgressBar(...)");
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
            createProgressBar.measure(makeMeasureSpec, makeMeasureSpec);
            this.A.put(styleFromString, createProgressBar.getMeasuredHeight());
            this.B.put(styleFromString, createProgressBar.getMeasuredWidth());
            this.C.add(Integer.valueOf(styleFromString));
        }
        return p.b(this.B.get(styleFromString), this.A.get(styleFromString));
    }

    @h7.a(name = "styleAttr")
    public final void setStyle(String str) {
        if (str == null) {
            str = "Normal";
        }
        this.D = str;
    }
}
