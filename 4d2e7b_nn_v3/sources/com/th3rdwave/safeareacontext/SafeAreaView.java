package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.d1;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.v;

public final class SafeAreaView extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private m f11702a = m.PADDING;

    /* renamed from: b  reason: collision with root package name */
    private a f11703b;

    /* renamed from: c  reason: collision with root package name */
    private k f11704c;

    /* renamed from: d  reason: collision with root package name */
    private View f11705d;

    /* renamed from: e  reason: collision with root package name */
    private d1 f11706e;

    public SafeAreaView(Context context) {
        super(context);
    }

    private final View r() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof SafeAreaProvider) {
                return (View) parent;
            }
        }
        return this;
    }

    private final boolean s() {
        a e10;
        View view = this.f11705d;
        if (view == null || (e10 = g.e(view)) == null || m.b(this.f11703b, e10)) {
            return false;
        }
        this.f11703b = e10;
        t();
        return true;
    }

    private final void t() {
        a aVar = this.f11703b;
        if (aVar != null) {
            k kVar = this.f11704c;
            if (kVar == null) {
                j jVar = j.ADDITIVE;
                kVar = new k(jVar, jVar, jVar, jVar);
            }
            d1 stateWrapper = getStateWrapper();
            if (stateWrapper != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putMap("insets", o.b(aVar));
                stateWrapper.updateState(createMap);
                return;
            }
            l lVar = new l(aVar, this.f11702a, kVar);
            ReactContext a10 = p.a(this);
            UIManagerModule uIManagerModule = (UIManagerModule) a10.getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), lVar);
                a10.runOnNativeModulesQueueThread(new h(uIManagerModule));
                v();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void u(UIManagerModule uIManagerModule) {
        uIManagerModule.getUIImplementation().m(-1);
    }

    private final void v() {
        v vVar = new v();
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        long nanoTime = System.nanoTime();
        p.a(this).runOnNativeModulesQueueThread(new i(reentrantLock, vVar, newCondition));
        reentrantLock.lock();
        long j10 = 0;
        while (!vVar.f722a && j10 < 500000000) {
            try {
                newCondition.awaitNanos(500000000);
            } catch (InterruptedException unused) {
                vVar.f722a = true;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
            j10 += System.nanoTime() - nanoTime;
        }
        Unit unit = Unit.f12577a;
        reentrantLock.unlock();
        if (j10 >= 500000000) {
            Log.w("SafeAreaView", "Timed out waiting for layout.");
        }
    }

    /* access modifiers changed from: private */
    public static final void w(ReentrantLock reentrantLock, v vVar, Condition condition) {
        m.f(reentrantLock, "$lock");
        m.f(vVar, "$done");
        reentrantLock.lock();
        try {
            if (!vVar.f722a) {
                vVar.f722a = true;
                condition.signal();
            }
            Unit unit = Unit.f12577a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final d1 getStateWrapper() {
        return this.f11706e;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onAttachedToWindow();
        View r10 = r();
        this.f11705d = r10;
        if (!(r10 == null || (viewTreeObserver = r10.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnPreDrawListener(this);
        }
        s();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver;
        super.onDetachedFromWindow();
        View view = this.f11705d;
        if (!(view == null || (viewTreeObserver = view.getViewTreeObserver()) == null)) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
        this.f11705d = null;
    }

    public boolean onPreDraw() {
        boolean s10 = s();
        if (s10) {
            requestLayout();
        }
        return !s10;
    }

    public final void setEdges(k kVar) {
        m.f(kVar, "edges");
        this.f11704c = kVar;
        t();
    }

    public final void setMode(m mVar) {
        m.f(mVar, "mode");
        this.f11702a = mVar;
        t();
    }

    public final void setStateWrapper(d1 d1Var) {
        this.f11706e = d1Var;
    }
}
