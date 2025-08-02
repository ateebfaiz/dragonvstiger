package com.zing.zalo.zalosdk.payment.direct;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.zing.zalo.zalosdk.core.helper.DeviceHelper;

public class DynamicLayout extends RelativeLayout {
    int mBoundedWidth = 900;

    /* renamed from: w  reason: collision with root package name */
    int f11863w;

    public DynamicLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @TargetApi(13)
    public void onMeasure(int i10, int i11) {
        if (DeviceHelper.isTablet(getContext())) {
            Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            int i12 = point.x;
            int i13 = point.y;
            if (View.MeasureSpec.getSize(i10) < View.MeasureSpec.getSize(i11)) {
                this.mBoundedWidth = (int) (((double) i12) * 0.8d);
            } else {
                this.mBoundedWidth = (int) (((double) i13) * 0.8d);
            }
            if (this.mBoundedWidth < View.MeasureSpec.getSize(i10)) {
                this.f11863w = View.MeasureSpec.makeMeasureSpec(this.mBoundedWidth, View.MeasureSpec.getMode(i10));
            }
        } else if (View.MeasureSpec.getSize(i10) < View.MeasureSpec.getSize(i11)) {
            this.f11863w = i10;
        } else {
            this.f11863w = i11 + 50;
        }
        super.onMeasure(this.f11863w, i11);
    }

    public DynamicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
