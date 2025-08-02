package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    private class b extends BottomSheetBehavior.BottomSheetCallback {
        private b() {
        }

        public void onSlide(View view, float f10) {
        }

        public void onStateChanged(View view, int i10) {
            if (i10 == 5) {
                BottomSheetDialogFragment.this.dismissAfterAnimation();
            }
        }
    }

    /* access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void dismissWithAnimation(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z10) {
        this.waitingForDismissAllowingStateLoss = z10;
        if (bottomSheetBehavior.getState() == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof BottomSheetDialog) {
            ((BottomSheetDialog) getDialog()).removeDefaultCallback();
        }
        bottomSheetBehavior.addBottomSheetCallback(new b());
        bottomSheetBehavior.setState(5);
    }

    private boolean tryDismissWithAnimation(boolean z10) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof BottomSheetDialog)) {
            return false;
        }
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
        if (!behavior.isHideable() || !bottomSheetDialog.getDismissWithAnimation()) {
            return false;
        }
        dismissWithAnimation(behavior, z10);
        return true;
    }

    public void dismiss() {
        if (!tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    public void dismissAllowingStateLoss() {
        if (!tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }
}
