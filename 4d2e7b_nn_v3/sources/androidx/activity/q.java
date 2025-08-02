package androidx.activity;

import android.view.Window;
import androidx.annotation.DoNotInline;
import kotlin.jvm.internal.m;

class q extends o {
    @DoNotInline
    public void b(Window window) {
        m.f(window, "window");
        window.getAttributes().layoutInDisplayCutoutMode = 1;
    }
}
