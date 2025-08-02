package com.facebook.react.views.text;

import androidx.annotation.Nullable;
import com.facebook.react.uimanager.u0;
import h7.a;

public class e extends u0 {

    /* renamed from: y  reason: collision with root package name */
    private String f4207y = null;

    @a(name = "text")
    public void setText(@Nullable String str) {
        this.f4207y = str;
        x0();
    }

    public boolean t() {
        return true;
    }

    public String toString() {
        return M() + " [text: " + this.f4207y + "]";
    }

    public String v1() {
        return this.f4207y;
    }
}
