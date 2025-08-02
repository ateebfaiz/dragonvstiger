package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f14192b = false;

    /* renamed from: a  reason: collision with root package name */
    private boolean f14193a;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet, i10, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i10, i11);
        if (obtainStyledAttributes.hasValue(R.styleable.PopupWindow_overlapAnchor)) {
            b(obtainStyledAttributes.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
    }

    private void b(boolean z10) {
        if (f14192b) {
            this.f14193a = z10;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z10);
        }
    }

    public void showAsDropDown(View view, int i10, int i11) {
        if (f14192b && this.f14193a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11);
    }

    public void update(View view, int i10, int i11, int i12, int i13) {
        if (f14192b && this.f14193a) {
            i11 -= view.getHeight();
        }
        super.update(view, i10, i11, i12, i13);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        a(context, attributeSet, i10, i11);
    }

    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (f14192b && this.f14193a) {
            i11 -= view.getHeight();
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
