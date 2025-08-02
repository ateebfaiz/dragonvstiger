package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final a f8181a;

    /* renamed from: b  reason: collision with root package name */
    final a f8182b;

    /* renamed from: c  reason: collision with root package name */
    final a f8183c;

    /* renamed from: d  reason: collision with root package name */
    final a f8184d;

    /* renamed from: e  reason: collision with root package name */
    final a f8185e;

    /* renamed from: f  reason: collision with root package name */
    final a f8186f;

    /* renamed from: g  reason: collision with root package name */
    final a f8187g;

    /* renamed from: h  reason: collision with root package name */
    final Paint f8188h;

    b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f8181a = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.f8187g = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f8182b = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f8183c = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f8184d = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f8185e = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f8186f = a.a(context, obtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f8188h = paint;
        paint.setColor(colorStateList.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
