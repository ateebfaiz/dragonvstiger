package androidx.activity;

import android.view.Window;
import androidx.annotation.DoNotInline;
import kotlin.jvm.internal.m;

final class v extends u {
    @DoNotInline
    public void b(Window window) {
        m.f(window, "window");
        window.getAttributes().layoutInDisplayCutoutMode = 3;
    }
}
