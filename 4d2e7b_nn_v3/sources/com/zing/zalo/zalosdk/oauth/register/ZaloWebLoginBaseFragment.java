package com.zing.zalo.zalosdk.oauth.register;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.zing.zalo.zalosdk.core.helper.Utils;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.oauth.WebLoginActivity;
import com.zing.zalo.zalosdk.oauth.model.LoginResponse;

public class ZaloWebLoginBaseFragment extends Fragment {
    protected ZaloWebLoginBaseFragmentListener listener;

    public interface ZaloWebLoginBaseFragmentListener {
        void hideBackButton();

        void hideLoading();

        void onLoginCompleted(LoginResponse loginResponse);

        void onLoginFailed(LoginResponse loginResponse);

        void setTitle(String str);

        void showBackButton();

        void showConfirmDialog(Activity activity, WebLoginActivity.OnDialogClickListener onDialogClickListener, String str, String str2, String str3, String str4, String str5);

        void showDialog(Activity activity, WebLoginActivity.OnDialogClickListener onDialogClickListener, String str, String str2, String str3);

        void showLoading();

        void showMessageDialog(String str, String str2);
    }

    /* access modifiers changed from: protected */
    public void hideBackButton() {
        ZaloWebLoginBaseFragmentListener zaloWebLoginBaseFragmentListener = this.listener;
        if (zaloWebLoginBaseFragmentListener != null) {
            zaloWebLoginBaseFragmentListener.hideBackButton();
        }
    }

    /* access modifiers changed from: protected */
    public void hideLoading() {
        ZaloWebLoginBaseFragmentListener zaloWebLoginBaseFragmentListener = this.listener;
        if (zaloWebLoginBaseFragmentListener != null) {
            zaloWebLoginBaseFragmentListener.hideLoading();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.listener = (ZaloWebLoginBaseFragmentListener) context;
        } catch (ClassCastException unused) {
            Log.e(context.getClass().getSimpleName() + " must implement " + ZaloWebLoginBaseFragmentListener.class.getSimpleName());
        }
    }

    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    /* access modifiers changed from: protected */
    public void onLoginCompleted(LoginResponse loginResponse) {
        ZaloWebLoginBaseFragmentListener zaloWebLoginBaseFragmentListener = this.listener;
        if (zaloWebLoginBaseFragmentListener != null) {
            zaloWebLoginBaseFragmentListener.onLoginCompleted(loginResponse);
        }
    }

    /* access modifiers changed from: protected */
    public void onLoginFailed(LoginResponse loginResponse) {
        ZaloWebLoginBaseFragmentListener zaloWebLoginBaseFragmentListener = this.listener;
        if (zaloWebLoginBaseFragmentListener != null) {
            zaloWebLoginBaseFragmentListener.onLoginFailed(loginResponse);
        }
    }

    /* access modifiers changed from: protected */
    public void setTitle(String str) {
        ZaloWebLoginBaseFragmentListener zaloWebLoginBaseFragmentListener = this.listener;
        if (zaloWebLoginBaseFragmentListener != null) {
            zaloWebLoginBaseFragmentListener.setTitle(str);
        }
    }

    public void setTouchHide(View view, String str) {
        int resourceId = Utils.getResourceId(getActivity(), str, "id");
        if (resourceId > 0) {
            view.findViewById(resourceId).setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    Utils.hideSoftKeyboard(ZaloWebLoginBaseFragment.this.getActivity());
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void showBackButton() {
        ZaloWebLoginBaseFragmentListener zaloWebLoginBaseFragmentListener = this.listener;
        if (zaloWebLoginBaseFragmentListener != null) {
            zaloWebLoginBaseFragmentListener.showBackButton();
        }
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        ZaloWebLoginBaseFragmentListener zaloWebLoginBaseFragmentListener = this.listener;
        if (zaloWebLoginBaseFragmentListener != null) {
            zaloWebLoginBaseFragmentListener.showLoading();
        }
    }

    /* access modifiers changed from: protected */
    public void showMessageDialog(String str, String str2) {
        ZaloWebLoginBaseFragmentListener zaloWebLoginBaseFragmentListener = this.listener;
        if (zaloWebLoginBaseFragmentListener != null) {
            zaloWebLoginBaseFragmentListener.showMessageDialog(str, str2);
        }
    }
}
