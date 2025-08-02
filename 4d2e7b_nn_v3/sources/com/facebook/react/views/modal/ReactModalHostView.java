package com.facebook.react.views.modal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.q;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.t;
import com.facebook.react.uimanager.u;
import com.facebook.react.uimanager.z0;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.coroutines.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@SuppressLint({"ViewConstructor"})
public final class ReactModalHostView extends ViewGroup implements LifecycleEventListener {

    /* renamed from: w  reason: collision with root package name */
    private static final a f4025w = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Dialog f4026a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4027b;

    /* renamed from: c  reason: collision with root package name */
    private DialogInterface.OnShowListener f4028c;

    /* renamed from: d  reason: collision with root package name */
    private b f4029d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4030e;

    /* renamed from: f  reason: collision with root package name */
    private String f4031f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4032g;

    /* renamed from: h  reason: collision with root package name */
    private DialogRootViewGroup f4033h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4034i;

    /* renamed from: j  reason: collision with root package name */
    private volatile u8.b f4035j;

    public final class DialogRootViewGroup extends ReactViewGroup implements z0 {

        /* renamed from: a  reason: collision with root package name */
        private d1 f4036a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4037b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f4038c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f4039d;

        /* renamed from: e  reason: collision with root package name */
        private final u f4040e = new u(this);

        /* renamed from: f  reason: collision with root package name */
        private t f4041f;

        /* renamed from: g  reason: collision with root package name */
        private e f4042g;

        public static final class a extends GuardedRunnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ DialogRootViewGroup f4044a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f4045b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(ReactContext reactContext, DialogRootViewGroup dialogRootViewGroup, int i10) {
                super(reactContext);
                this.f4044a = dialogRootViewGroup;
                this.f4045b = i10;
            }

            public void runGuarded() {
                UIManagerModule uIManagerModule = (UIManagerModule) this.f4044a.getReactContext().b().getNativeModule(UIManagerModule.class);
                if (uIManagerModule != null) {
                    uIManagerModule.updateNodeSize(this.f4045b, this.f4044a.f4038c, this.f4044a.f4039d);
                }
            }
        }

        public DialogRootViewGroup(Context context) {
            super(context);
            if (ReactFeatureFlags.dispatchPointerEvents) {
                this.f4041f = new t(this);
            }
        }

        /* access modifiers changed from: private */
        public final e1 getReactContext() {
            Context context = getContext();
            m.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
            return (e1) context;
        }

        private final void s() {
            if (getChildCount() > 0) {
                this.f4037b = false;
                int id2 = getChildAt(0).getId();
                if (this.f4036a != null) {
                    t(this.f4038c, this.f4039d);
                    return;
                }
                e1 reactContext = getReactContext();
                reactContext.runOnNativeModulesQueueThread(new a(reactContext, this, id2));
                return;
            }
            this.f4037b = true;
        }

        public void a(View view, MotionEvent motionEvent) {
            m.f(view, "childView");
            m.f(motionEvent, "ev");
            e eVar = this.f4042g;
            if (eVar != null) {
                this.f4040e.e(motionEvent, eVar);
                t tVar = this.f4041f;
                if (tVar != null) {
                    tVar.p(view, motionEvent, eVar);
                }
            }
        }

        public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
            m.f(view, "child");
            m.f(layoutParams, "params");
            super.addView(view, i10, layoutParams);
            if (this.f4037b) {
                s();
            }
        }

        public void c(View view, MotionEvent motionEvent) {
            m.f(view, "childView");
            m.f(motionEvent, "ev");
            e eVar = this.f4042g;
            if (eVar != null) {
                this.f4040e.d(motionEvent, eVar);
            }
            t tVar = this.f4041f;
            if (tVar != null) {
                tVar.o();
            }
        }

        public final e getEventDispatcher$ReactAndroid_release() {
            return this.f4042g;
        }

        public final d1 getStateWrapper$ReactAndroid_release() {
            return this.f4036a;
        }

        public void handleException(Throwable th) {
            m.f(th, "t");
            getReactContext().b().handleException(new RuntimeException(th));
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            t tVar;
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            e eVar = this.f4042g;
            if (!(eVar == null || (tVar = this.f4041f) == null)) {
                tVar.k(motionEvent, eVar, false);
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
            t tVar;
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            e eVar = this.f4042g;
            if (!(eVar == null || (tVar = this.f4041f) == null)) {
                tVar.k(motionEvent, eVar, true);
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            e eVar = this.f4042g;
            if (eVar != null) {
                this.f4040e.c(motionEvent, eVar);
                t tVar = this.f4041f;
                if (tVar != null) {
                    tVar.k(motionEvent, eVar, true);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i10, int i11, int i12, int i13) {
            super.onSizeChanged(i10, i11, i12, i13);
            this.f4038c = i10;
            this.f4039d = i11;
            s();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            e eVar = this.f4042g;
            if (eVar != null) {
                this.f4040e.c(motionEvent, eVar);
                t tVar = this.f4041f;
                if (tVar != null) {
                    tVar.k(motionEvent, eVar, false);
                }
            }
            super.onTouchEvent(motionEvent);
            return true;
        }

        public void requestDisallowInterceptTouchEvent(boolean z10) {
        }

        public final void setEventDispatcher$ReactAndroid_release(e eVar) {
            this.f4042g = eVar;
        }

        public final void setStateWrapper$ReactAndroid_release(d1 d1Var) {
            this.f4036a = d1Var;
        }

        public final void t(int i10, int i11) {
            ReadableNativeMap readableNativeMap;
            float f10;
            float b10 = g0.b((float) i10);
            float b11 = g0.b((float) i11);
            d1 d1Var = this.f4036a;
            if (d1Var != null) {
                readableNativeMap = d1Var.getStateData();
            } else {
                readableNativeMap = null;
            }
            if (readableNativeMap != null) {
                float f11 = 0.0f;
                if (readableNativeMap.hasKey("screenHeight")) {
                    f10 = (float) readableNativeMap.getDouble("screenHeight");
                } else {
                    f10 = 0.0f;
                }
                if (readableNativeMap.hasKey("screenWidth")) {
                    f11 = (float) readableNativeMap.getDouble("screenWidth");
                }
                double d10 = (double) 0.9f;
                if (Math.abs((double) (f11 - b10)) < d10 && Math.abs((double) (f10 - b11)) < d10) {
                    return;
                }
            }
            d1 d1Var2 = this.f4036a;
            if (d1Var2 != null) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putDouble("screenWidth", (double) b10);
                writableNativeMap.putDouble("screenHeight", (double) b11);
                d1Var2.updateState(writableNativeMap);
            }
        }
    }

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void a(DialogInterface dialogInterface);
    }

    public static final class c implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ReactModalHostView f4046a;

        c(ReactModalHostView reactModalHostView) {
            this.f4046a = reactModalHostView;
        }

        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            m.f(dialogInterface, "dialog");
            m.f(keyEvent, NotificationCompat.CATEGORY_EVENT);
            if (keyEvent.getAction() != 1) {
                return false;
            }
            if (i10 == 4 || i10 == 111) {
                b onRequestCloseListener = this.f4046a.getOnRequestCloseListener();
                if (onRequestCloseListener != null) {
                    onRequestCloseListener.a(dialogInterface);
                    return true;
                }
                throw new IllegalStateException("onRequestClose callback must be set if back key is expected to close the modal".toString());
            }
            Context context = this.f4046a.getContext();
            m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            Activity currentActivity = ((ReactContext) context).getCurrentActivity();
            if (currentActivity != null) {
                return currentActivity.onKeyUp(i10, keyEvent);
            }
            return false;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactModalHostView(e1 e1Var) {
        super(e1Var);
        m.f(e1Var, "context");
        e1Var.addLifecycleEventListener(this);
        this.f4033h = new DialogRootViewGroup(e1Var);
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r3 = this;
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()
            android.app.Dialog r0 = r3.f4026a
            if (r0 == 0) goto L_0x003d
            boolean r1 = r0.isShowing()
            if (r1 == 0) goto L_0x0024
            android.content.Context r1 = r0.getContext()
            java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
            java.lang.Object r1 = q7.a.a(r1, r2)
            android.app.Activity r1 = (android.app.Activity) r1
            if (r1 == 0) goto L_0x0021
            boolean r1 = r1.isFinishing()
            if (r1 != 0) goto L_0x0024
        L_0x0021:
            r0.dismiss()
        L_0x0024:
            r0 = 0
            r3.f4026a = r0
            r1 = 1
            r3.f4034i = r1
            com.facebook.react.views.modal.ReactModalHostView$DialogRootViewGroup r1 = r3.f4033h
            android.view.ViewParent r1 = r1.getParent()
            boolean r2 = r1 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x0037
            r0 = r1
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L_0x0037:
            if (r0 == 0) goto L_0x003d
            r1 = 0
            r0.removeViewAt(r1)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.modal.ReactModalHostView.a():void");
    }

    private final void c() {
        Dialog dialog = this.f4026a;
        if (dialog != null) {
            Activity currentActivity = getCurrentActivity();
            Window window = dialog.getWindow();
            if (window != null) {
                m.e(window, "checkNotNull(...)");
                if (currentActivity != null && !currentActivity.isFinishing() && window.isActive()) {
                    Window window2 = currentActivity.getWindow();
                    if (window2 != null) {
                        if ((window2.getAttributes().flags & 1024) != 0) {
                            window.addFlags(1024);
                        } else {
                            window.clearFlags(1024);
                        }
                    }
                    if (this.f4027b) {
                        window.clearFlags(2);
                        return;
                    }
                    window.setDimAmount(0.5f);
                    window.setFlags(2, 2);
                    return;
                }
                return;
            }
            throw new IllegalStateException("dialog must have window when we call updateProperties".toString());
        }
        throw new IllegalStateException("dialog must exist when we call updateProperties".toString());
    }

    private final void e() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Dialog dialog = this.f4026a;
            if (dialog != null) {
                Window window = dialog.getWindow();
                if (window != null) {
                    m.e(window, "checkNotNull(...)");
                    if (Build.VERSION.SDK_INT > 30) {
                        WindowInsetsController a10 = currentActivity.getWindow().getInsetsController();
                        if (a10 != null) {
                            int a11 = a10.getSystemBarsAppearance() & 8;
                            WindowInsetsController a12 = window.getInsetsController();
                            if (a12 != null) {
                                a12.setSystemBarsAppearance(a11, 8);
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                    Window window2 = currentActivity.getWindow();
                    if (window2 != null) {
                        View decorView = window2.getDecorView();
                        m.e(decorView, "getDecorView(...)");
                        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility());
                        return;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                throw new IllegalStateException("dialog must have window when we call updateProperties".toString());
            }
            throw new IllegalStateException("dialog must exist when we call updateProperties".toString());
        }
    }

    private final View getContentView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.f4033h);
        if (this.f4030e) {
            frameLayout.setSystemUiVisibility(1024);
        } else {
            frameLayout.setFitsSystemWindows(true);
        }
        return frameLayout;
    }

    private final Activity getCurrentActivity() {
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        return ((e1) context).getCurrentActivity();
    }

    public void addChildrenForAccessibility(ArrayList arrayList) {
        m.f(arrayList, "outChildren");
    }

    public void addView(View view, int i10) {
        UiThreadUtil.assertOnUiThread();
        this.f4033h.addView(view, i10);
    }

    public final void b() {
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ((e1) context).removeLifecycleEventListener(this);
        a();
    }

    public final void d(int i10, int i11) {
        this.f4033h.t(i10, i11);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        m.f(accessibilityEvent, NotificationCompat.CATEGORY_EVENT);
        return false;
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
        m.f(viewStructure, "structure");
        this.f4033h.dispatchProvideStructure(viewStructure);
    }

    public final String getAnimationType() {
        return this.f4031f;
    }

    public View getChildAt(int i10) {
        return this.f4033h.getChildAt(i10);
    }

    public int getChildCount() {
        return this.f4033h.getChildCount();
    }

    public final Dialog getDialog() {
        return this.f4026a;
    }

    public final e getEventDispatcher() {
        return this.f4033h.getEventDispatcher$ReactAndroid_release();
    }

    public final boolean getHardwareAccelerated() {
        return this.f4032g;
    }

    public final b getOnRequestCloseListener() {
        return this.f4029d;
    }

    public final DialogInterface.OnShowListener getOnShowListener() {
        return this.f4028c;
    }

    public final d1 getStateWrapper() {
        return this.f4033h.getStateWrapper$ReactAndroid_release();
    }

    public final boolean getStatusBarTranslucent() {
        return this.f4030e;
    }

    public final boolean getTransparent() {
        return this.f4027b;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void onHostDestroy() {
        b();
    }

    public void onHostPause() {
    }

    public void onHostResume() {
        showOrUpdate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        if (view != null) {
            this.f4033h.removeView(view);
        }
    }

    public void removeViewAt(int i10) {
        UiThreadUtil.assertOnUiThread();
        this.f4033h.removeView(getChildAt(i10));
    }

    public final void setAnimationType(String str) {
        this.f4031f = str;
        this.f4034i = true;
    }

    public final void setEventDispatcher(e eVar) {
        this.f4033h.setEventDispatcher$ReactAndroid_release(eVar);
    }

    public final void setHardwareAccelerated(boolean z10) {
        this.f4032g = z10;
        this.f4034i = true;
    }

    public final void setOnRequestCloseListener(b bVar) {
        this.f4029d = bVar;
    }

    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f4028c = onShowListener;
    }

    public final void setStateWrapper(d1 d1Var) {
        this.f4033h.setStateWrapper$ReactAndroid_release(d1Var);
    }

    public final void setStatusBarTranslucent(boolean z10) {
        this.f4030e = z10;
        this.f4034i = true;
    }

    public final void setTransparent(boolean z10) {
        this.f4027b = z10;
    }

    public final void showOrUpdate() {
        if (this.f4035j == null) {
            synchronized (this) {
                if (this.f4035j == null) {
                    u8.b bVar = new u8.b("com_facebook_react_views_modal_ReactModalHostView$Invoke56925e2fc0a1778c7a808d5d83730886", ReactModalHostView.class, "showOrUpdate", "showOrUpdate$$7045700e143525cf6954c26278553dfa$$AndroidAOP", false, this);
                    bVar.g(new String[]{"org.cocos2dx.javascript.aop.HideModalVirtualBtn"});
                    bVar.f(new Class[0]);
                    bVar.i(new String[0]);
                    bVar.j(Void.TYPE);
                    bVar.h(new e(), false);
                    this.f4035j = bVar;
                }
            }
        }
        this.f4035j.d((Object[]) null, (d) null);
    }

    public final void showOrUpdate$$7045700e143525cf6954c26278553dfa$$AndroidAOP() {
        int i10;
        Context context;
        Window window;
        UiThreadUtil.assertOnUiThread();
        if (this.f4034i) {
            a();
            this.f4034i = false;
            String str = this.f4031f;
            if (m.b(str, "fade")) {
                i10 = q.f20909d;
            } else if (m.b(str, "slide")) {
                i10 = q.f20910e;
            } else {
                i10 = q.f20908c;
            }
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                context = currentActivity;
            } else {
                context = getContext();
            }
            Dialog dialog = new Dialog(context, i10);
            this.f4026a = dialog;
            Window window2 = dialog.getWindow();
            Objects.requireNonNull(window2);
            window2.setFlags(8, 8);
            dialog.setContentView(getContentView());
            c();
            dialog.setOnShowListener(this.f4028c);
            dialog.setOnKeyListener(new c(this));
            Window window3 = dialog.getWindow();
            if (window3 != null) {
                window3.setSoftInputMode(16);
            }
            if (this.f4032g && (window = dialog.getWindow()) != null) {
                window.addFlags(16777216);
            }
            if (currentActivity != null && !currentActivity.isFinishing()) {
                dialog.show();
                e();
                Window window4 = dialog.getWindow();
                if (window4 != null) {
                    window4.clearFlags(8);
                    return;
                }
                return;
            }
            return;
        }
        c();
    }
}
