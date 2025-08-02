package org.cocos2dx.javascript.aop;

import android.app.Dialog;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.facebook.react.views.modal.ReactModalHostView;
import org.cocos2dx.javascript.PlatformUtils;
import u8.d;
import v8.b;

public class HideModalVirtualBtn implements b {
    @Nullable
    public Object invoke(@NonNull d dVar, @NonNull String str) throws Throwable {
        Object b10 = dVar.b();
        Dialog dialog = ((ReactModalHostView) dVar.a()).getDialog();
        if (!(dialog == null || dialog.getWindow() == null)) {
            if (PlatformUtils.getStatusBarState() == 1) {
                dialog.getWindow().getDecorView().setSystemUiVisibility(12290);
            } else {
                dialog.getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            }
            dialog.getWindow().clearFlags(8);
        }
        return b10;
    }
}
