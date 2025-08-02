package com.swmansion.rnscreens;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.widget.SearchView;
import kotlin.jvm.internal.m;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    private SearchView f11609a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f11610b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f11611c;

    public a0(SearchView searchView) {
        m.f(searchView, "searchView");
        this.f11609a = searchView;
    }

    private final ImageView a() {
        return (ImageView) this.f11609a.findViewById(R.id.search_close_btn);
    }

    private final EditText b() {
        View findViewById = this.f11609a.findViewById(R.id.search_src_text);
        if (findViewById instanceof EditText) {
            return (EditText) findViewById;
        }
        return null;
    }

    private final ImageView c() {
        return (ImageView) this.f11609a.findViewById(R.id.search_button);
    }

    private final View d() {
        return this.f11609a.findViewById(R.id.search_plate);
    }

    public final void e(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            c().setColorFilter(intValue);
            a().setColorFilter(intValue);
        }
    }

    public final void f(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            EditText b10 = b();
            if (b10 != null) {
                b10.setHintTextColor(intValue);
            }
        }
    }

    public final void g(String str, boolean z10) {
        m.f(str, "placeholder");
        if (z10) {
            this.f11609a.setQueryHint(str);
            return;
        }
        EditText b10 = b();
        if (b10 != null) {
            b10.setHint(str);
        }
    }

    public final void h(Integer num) {
        EditText b10;
        Integer num2;
        ColorStateList textColors;
        Integer num3 = this.f11610b;
        if (num != null) {
            if (num3 == null) {
                EditText b11 = b();
                if (b11 == null || (textColors = b11.getTextColors()) == null) {
                    num2 = null;
                } else {
                    num2 = Integer.valueOf(textColors.getDefaultColor());
                }
                this.f11610b = num2;
            }
            EditText b12 = b();
            if (b12 != null) {
                b12.setTextColor(num.intValue());
            }
        } else if (num3 != null && (b10 = b()) != null) {
            b10.setTextColor(num3.intValue());
        }
    }

    public final void i(Integer num) {
        Drawable drawable = this.f11611c;
        if (num != null) {
            if (drawable == null) {
                this.f11611c = d().getBackground();
            }
            d().setBackgroundColor(num.intValue());
        } else if (drawable != null) {
            d().setBackground(drawable);
        }
    }
}
