package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

class d implements ClockHandView.OnRotateListener, TimePickerView.g, TimePickerView.f, ClockHandView.OnActionUpListener, e {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f8717f = {"12", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", DbParams.GZIP_DATA_ENCRYPT, "10", "11"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f8718g = {"00", ExifInterface.GPS_MEASUREMENT_2D, "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f8719h = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: a  reason: collision with root package name */
    private final TimePickerView f8720a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final TimeModel f8721b;

    /* renamed from: c  reason: collision with root package name */
    private float f8722c;

    /* renamed from: d  reason: collision with root package name */
    private float f8723d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8724e = false;

    class a extends b {
        a(Context context, int i10) {
            super(context, i10);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R.string.material_hour_suffix, new Object[]{String.valueOf(d.this.f8721b.c())}));
        }
    }

    class b extends b {
        b(Context context, int i10) {
            super(context, i10);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(view.getResources().getString(R.string.material_minute_suffix, new Object[]{String.valueOf(d.this.f8721b.f8698e)}));
        }
    }

    public d(TimePickerView timePickerView, TimeModel timeModel) {
        this.f8720a = timePickerView;
        this.f8721b = timeModel;
        g();
    }

    private int e() {
        if (this.f8721b.f8696c == 1) {
            return 15;
        }
        return 30;
    }

    private String[] f() {
        if (this.f8721b.f8696c == 1) {
            return f8718g;
        }
        return f8717f;
    }

    private void h(int i10, int i11) {
        TimeModel timeModel = this.f8721b;
        if (timeModel.f8698e != i11 || timeModel.f8697d != i10) {
            this.f8720a.performHapticFeedback(4);
        }
    }

    private void j() {
        TimePickerView timePickerView = this.f8720a;
        TimeModel timeModel = this.f8721b;
        timePickerView.s(timeModel.f8700g, timeModel.c(), this.f8721b.f8698e);
    }

    private void k() {
        l(f8717f, "%d");
        l(f8718g, "%d");
        l(f8719h, "%02d");
    }

    private void l(String[] strArr, String str) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr[i10] = TimeModel.b(this.f8720a.getResources(), strArr[i10], str);
        }
    }

    public void a() {
        this.f8720a.setVisibility(8);
    }

    public void b(int i10) {
        this.f8721b.j(i10);
    }

    public void c(int i10) {
        i(i10, true);
    }

    public void g() {
        if (this.f8721b.f8696c == 0) {
            this.f8720a.q();
        }
        this.f8720a.d(this);
        this.f8720a.m(this);
        this.f8720a.l(this);
        this.f8720a.j(this);
        k();
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void i(int i10, boolean z10) {
        boolean z11;
        String[] strArr;
        int i11;
        float f10;
        if (i10 == 12) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f8720a.f(z11);
        this.f8721b.f8699f = i10;
        TimePickerView timePickerView = this.f8720a;
        if (z11) {
            strArr = f8719h;
        } else {
            strArr = f();
        }
        if (z11) {
            i11 = R.string.material_minute_suffix;
        } else {
            i11 = R.string.material_hour_suffix;
        }
        timePickerView.o(strArr, i11);
        TimePickerView timePickerView2 = this.f8720a;
        if (z11) {
            f10 = this.f8722c;
        } else {
            f10 = this.f8723d;
        }
        timePickerView2.g(f10, z10);
        this.f8720a.e(i10);
        this.f8720a.i(new a(this.f8720a.getContext(), R.string.material_hour_selection));
        this.f8720a.h(new b(this.f8720a.getContext(), R.string.material_minute_selection));
    }

    public void invalidate() {
        this.f8723d = (float) (this.f8721b.c() * e());
        TimeModel timeModel = this.f8721b;
        this.f8722c = (float) (timeModel.f8698e * 6);
        i(timeModel.f8699f, false);
        j();
    }

    public void onActionUp(float f10, boolean z10) {
        this.f8724e = true;
        TimeModel timeModel = this.f8721b;
        int i10 = timeModel.f8698e;
        int i11 = timeModel.f8697d;
        if (timeModel.f8699f == 10) {
            this.f8720a.g(this.f8723d, false);
            AccessibilityManager accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(this.f8720a.getContext(), AccessibilityManager.class);
            if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                i(12, true);
            }
        } else {
            int round = Math.round(f10);
            if (!z10) {
                this.f8721b.i(((round + 15) / 30) * 5);
                this.f8722c = (float) (this.f8721b.f8698e * 6);
            }
            this.f8720a.g(this.f8722c, z10);
        }
        this.f8724e = false;
        j();
        h(i11, i10);
    }

    public void onRotate(float f10, boolean z10) {
        if (!this.f8724e) {
            TimeModel timeModel = this.f8721b;
            int i10 = timeModel.f8697d;
            int i11 = timeModel.f8698e;
            int round = Math.round(f10);
            TimeModel timeModel2 = this.f8721b;
            if (timeModel2.f8699f == 12) {
                timeModel2.i((round + 3) / 6);
                this.f8722c = (float) Math.floor((double) (this.f8721b.f8698e * 6));
            } else {
                this.f8721b.g((round + (e() / 2)) / e());
                this.f8723d = (float) (this.f8721b.c() * e());
            }
            if (!z10) {
                j();
                h(i10, i11);
            }
        }
    }

    public void show() {
        this.f8720a.setVisibility(0);
    }
}
