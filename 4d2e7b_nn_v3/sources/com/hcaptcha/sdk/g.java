package com.hcaptcha.sdk;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.InflateException;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public final class g extends DialogFragment implements w {

    /* renamed from: g  reason: collision with root package name */
    private static final String f9521g = "HCaptchaDialogFragment";

    /* renamed from: h  reason: collision with root package name */
    private static HCaptchaWebView f9522h;

    /* renamed from: b  reason: collision with root package name */
    private HCaptchaWebViewHelper f9523b;

    /* renamed from: c  reason: collision with root package name */
    private HCaptchaStateListener f9524c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f9525d;

    /* renamed from: e  reason: collision with root package name */
    private float f9526e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9527f;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            if (g.this.f9525d != null) {
                g.this.f9525d.setVisibility(8);
            }
        }
    }

    public g() {
        this.f9526e = 0.6f;
        this.f9527f = false;
    }

    private void r() {
        HCaptchaWebViewHelper hCaptchaWebViewHelper;
        if (this.f9525d == null || (hCaptchaWebViewHelper = this.f9523b) == null || !Boolean.TRUE.equals(hCaptchaWebViewHelper.c().getLoading())) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.getWindow().addFlags(2);
                dialog.getWindow().setDimAmount(this.f9526e);
                return;
            }
            return;
        }
        this.f9525d.animate().alpha(0.0f).setDuration(200).setListener(new a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean s(HCaptchaConfig hCaptchaConfig, View view, int i10, KeyEvent keyEvent) {
        if (i10 != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        if (!this.f9527f && Boolean.FALSE.equals(hCaptchaConfig.getLoading())) {
            return true;
        }
        HCaptchaWebViewHelper hCaptchaWebViewHelper = this.f9523b;
        if (hCaptchaWebViewHelper == null || !hCaptchaWebViewHelper.h(new i(h.CHALLENGE_CLOSED))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean t(View view, MotionEvent motionEvent) {
        FragmentActivity activity;
        if (this.f9527f || !isAdded() || (activity = getActivity()) == null) {
            return view.performClick();
        }
        activity.dispatchTouchEvent(motionEvent);
        return true;
    }

    public static g u(Context context, HCaptchaConfig hCaptchaConfig, l lVar, HCaptchaStateListener hCaptchaStateListener) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("hCaptchaConfig", hCaptchaConfig);
        bundle.putSerializable("hCaptchaInternalConfig", lVar);
        bundle.putParcelable("hCaptchaDialogListener", hCaptchaStateListener);
        g gVar = new g(context, hCaptchaConfig, lVar);
        gVar.setArguments(bundle);
        gVar.f9524c = hCaptchaStateListener;
        return gVar;
    }

    private View w(LayoutInflater layoutInflater, ViewGroup viewGroup, HCaptchaConfig hCaptchaConfig) {
        View inflate = layoutInflater.inflate(y.f9567a, viewGroup, false);
        inflate.setFocusableInTouchMode(true);
        inflate.requestFocus();
        inflate.setOnKeyListener(new f(this, hCaptchaConfig));
        return inflate;
    }

    private void x(View view, HCaptchaConfig hCaptchaConfig) {
        View findViewById = view.findViewById(x.f9566b);
        if (findViewById instanceof ViewStub) {
            ViewGroup viewGroup = (ViewGroup) view;
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            if (f9522h.getParent() != null) {
                ((ViewGroup) f9522h.getParent()).removeView(f9522h);
            }
            viewGroup.addView(f9522h, indexOfChild);
            if (Boolean.FALSE.equals(hCaptchaConfig.getLoading())) {
                f9522h.setOnTouchListener(new e(this));
            }
        }
    }

    public void a() {
        if (this.f9523b.c().getSize() == HCaptchaSize.INVISIBLE) {
            r();
        }
        this.f9527f = true;
        HCaptchaStateListener hCaptchaStateListener = this.f9524c;
        if (hCaptchaStateListener != null) {
            hCaptchaStateListener.b();
        }
    }

    public void f(i iVar) {
        boolean z10;
        HCaptchaWebViewHelper hCaptchaWebViewHelper = this.f9523b;
        if (hCaptchaWebViewHelper == null || !hCaptchaWebViewHelper.h(iVar)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (isAdded() && !z10) {
            dismissAllowingStateLoss();
        }
        HCaptchaWebViewHelper hCaptchaWebViewHelper2 = this.f9523b;
        if (hCaptchaWebViewHelper2 == null) {
            return;
        }
        if (z10) {
            hCaptchaWebViewHelper2.f();
            return;
        }
        HCaptchaStateListener hCaptchaStateListener = this.f9524c;
        if (hCaptchaStateListener != null) {
            hCaptchaStateListener.a(iVar);
        }
    }

    public void h(Activity activity) {
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        String str = f9521g;
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
        if ((findFragmentByTag == null || !findFragmentByTag.isAdded()) && !supportFragmentManager.isStateSaved()) {
            try {
                show(supportFragmentManager, str);
            } catch (IllegalStateException e10) {
                new StringBuilder("DialogFragment.startVerification ").append(e10.getMessage());
                HCaptchaStateListener hCaptchaStateListener = this.f9524c;
                if (hCaptchaStateListener != null) {
                    hCaptchaStateListener.a(new i(h.ERROR));
                }
            }
        }
    }

    public void k() {
        if (this.f9523b.c().getSize() != HCaptchaSize.INVISIBLE) {
            this.f9527f = true;
            r();
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        f(new i(h.CHALLENGE_CLOSED));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, z.f9568a);
        try {
            Bundle arguments = getArguments();
            this.f9524c = (HCaptchaStateListener) b.a(arguments, "hCaptchaDialogListener", HCaptchaStateListener.class);
            HCaptchaConfig hCaptchaConfig = (HCaptchaConfig) b.b(arguments, "hCaptchaConfig", HCaptchaConfig.class);
            l lVar = (l) b.b(arguments, "hCaptchaInternalConfig", l.class);
            HCaptchaStateListener hCaptchaStateListener = this.f9524c;
            if (!(hCaptchaStateListener == null || hCaptchaConfig == null)) {
                if (lVar != null) {
                    if (f9522h == null) {
                        f9522h = new HCaptchaWebView(requireContext());
                    }
                    if (this.f9523b == null) {
                        this.f9523b = new HCaptchaWebViewHelper(new Handler(Looper.getMainLooper()), requireContext(), hCaptchaConfig, lVar, this, f9522h);
                        return;
                    }
                    return;
                }
            }
            if (hCaptchaStateListener != null) {
                hCaptchaStateListener.a(new i(h.ERROR));
            }
        } catch (BadParcelableException | AssertionError | ClassCastException unused) {
            HCaptchaStateListener hCaptchaStateListener2 = this.f9524c;
            if (hCaptchaStateListener2 != null) {
                hCaptchaStateListener2.a(new i(h.ERROR));
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        try {
            HCaptchaConfig hCaptchaConfig = (HCaptchaConfig) b.b(getArguments(), "hCaptchaConfig", HCaptchaConfig.class);
            if (layoutInflater != null) {
                View w10 = w(layoutInflater, viewGroup, hCaptchaConfig);
                x(w10, hCaptchaConfig);
                LinearLayout linearLayout = (LinearLayout) w10.findViewById(x.f9565a);
                this.f9525d = linearLayout;
                if (!Boolean.TRUE.equals(hCaptchaConfig.getLoading()) || this.f9527f) {
                    i10 = 8;
                } else {
                    i10 = 0;
                }
                linearLayout.setVisibility(i10);
                return w10;
            }
            throw new InflateException("inflater is null");
        } catch (BadParcelableException | InflateException | AssertionError | ClassCastException unused) {
            dismiss();
            HCaptchaStateListener hCaptchaStateListener = this.f9524c;
            if (hCaptchaStateListener == null) {
                return null;
            }
            hCaptchaStateListener.a(new i(h.ERROR));
            return null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        HCaptchaWebViewHelper hCaptchaWebViewHelper = this.f9523b;
        if (hCaptchaWebViewHelper != null) {
            hCaptchaWebViewHelper.e();
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && this.f9523b != null) {
            Window window = dialog.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            this.f9526e = window.getAttributes().dimAmount;
            if (Boolean.FALSE.equals(this.f9523b.c().getLoading())) {
                window.clearFlags(2);
                window.setDimAmount(0.0f);
            }
        }
    }

    /* renamed from: v */
    public void onSuccess(String str) {
        if (isAdded()) {
            dismissAllowingStateLoss();
        }
        HCaptchaStateListener hCaptchaStateListener = this.f9524c;
        if (hCaptchaStateListener != null) {
            hCaptchaStateListener.c(str);
        }
    }

    public g(Context context, HCaptchaConfig hCaptchaConfig, l lVar) {
        this();
        f9522h = new HCaptchaWebView(context);
        this.f9523b = new HCaptchaWebViewHelper(new Handler(Looper.getMainLooper()), context, hCaptchaConfig, lVar, this, f9522h);
    }
}
