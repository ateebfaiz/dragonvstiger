package org.cocos2dx.javascript.rn;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.cocos.lib.GlobalObject;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.u;
import com.facebook.react.w;
import java.io.Serializable;
import java.lang.reflect.Field;
import org.cocos2dx.javascript.PlatformUtils;

public class RNDelegateManager {
    private static final String KEY_DATA = "data";
    private static final String KEY_PAGE_TYPE = "pageType";
    private static final String TAG = "RNDelegateManager";
    private static volatile RNDelegateManager instance;
    private MutableLiveData<Integer> hotUpdateLiveData;
    /* access modifiers changed from: private */
    public AppCompatActivity mActivity;
    private boolean mIsRnVCDismissWithoutArgs;
    /* access modifiers changed from: private */
    public PreloadReactFragment mPreloadReactFragment;
    private w mRNDelegate;
    public boolean mReloadWhenExit = false;

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                RNDelegateManager.this.mActivity.getSupportFragmentManager().beginTransaction().hide(RNDelegateManager.this.mPreloadReactFragment).commitAllowingStateLoss();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private RNDelegateManager() {
    }

    private int getContainerViewId() {
        try {
            Field declaredField = this.mActivity.getClass().getSuperclass().getSuperclass().getDeclaredField("contentViewId");
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(this.mActivity)).intValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static RNDelegateManager getInstance() {
        if (instance == null) {
            synchronized (RNDelegateManager.class) {
                try {
                    if (instance == null) {
                        instance = new RNDelegateManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private Bundle getLaunchOptions(Activity activity) {
        Serializable serializableExtra = activity.getIntent().getSerializableExtra("data");
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PAGE_TYPE, "preload");
        bundle.putSerializable("data", serializableExtra);
        return bundle;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$hide$3(boolean z10) {
        Log.d(TAG, "hide 关闭rn页面");
        if (this.mReloadWhenExit) {
            this.mReloadWhenExit = false;
            getInstance().destroy();
            Log.d(TAG, "hide: RNDelegateManager init");
            getInstance().init(PlatformUtils.mActivity);
            return;
        }
        if (!z10) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_PAGE_TYPE, "dismiss");
            w wVar = this.mRNDelegate;
            if (!(wVar == null || wVar.f() == null)) {
                this.mRNDelegate.f().setAppProperties(bundle);
            }
        }
        if (this.mPreloadReactFragment != null) {
            this.mActivity.getSupportFragmentManager().beginTransaction().hide(this.mPreloadReactFragment).commitAllowingStateLoss();
        } else {
            Log.e(TAG, "hide: mPreloadReactFragment is null");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(ReactContext reactContext) {
        preload();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$observerHotUpdate$1(Integer num) {
        if (isVisible()) {
            this.mReloadWhenExit = true;
            return;
        }
        getInstance().destroy();
        Log.d(TAG, "observerHotUpdate: RNDelegateManager init");
        getInstance().init(PlatformUtils.mActivity);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$show$2(String str, String str2) {
        w wVar = this.mRNDelegate;
        if (wVar == null || wVar.f() == null) {
            Log.d(TAG, "show: getReactRootView is null");
            return;
        }
        if (this.mPreloadReactFragment == null) {
            this.mActivity.getSupportFragmentManager().beginTransaction().add(getContainerViewId(), (Fragment) getPreloadFragment()).addToBackStack((String) null).commitAllowingStateLoss();
        } else {
            this.mActivity.getSupportFragmentManager().beginTransaction().show(this.mPreloadReactFragment).commitAllowingStateLoss();
        }
        if (!this.mIsRnVCDismissWithoutArgs) {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_PAGE_TYPE, String.valueOf(str));
            bundle.putString("data", str2);
            this.mRNDelegate.f().setAppProperties(bundle);
        }
        this.mIsRnVCDismissWithoutArgs = false;
    }

    private void observerHotUpdate() {
        if (this.hotUpdateLiveData == null) {
            MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
            this.hotUpdateLiveData = mutableLiveData;
            mutableLiveData.observe(this.mActivity, new c(this));
        }
    }

    public void codePushInstallSuccess() {
        int i10;
        Log.d(TAG, "codePushInstallSuccess");
        if (this.hotUpdateLiveData.getValue() != null) {
            i10 = this.hotUpdateLiveData.getValue().intValue();
        } else {
            i10 = 1;
        }
        this.hotUpdateLiveData.postValue(Integer.valueOf(i10 + 1));
    }

    public void destroy() {
        Log.d(TAG, "destroy");
        if (this.mPreloadReactFragment != null && !this.mActivity.getSupportFragmentManager().isDestroyed()) {
            this.mActivity.getSupportFragmentManager().beginTransaction().remove(this.mPreloadReactFragment).commitAllowingStateLoss();
        }
        this.mPreloadReactFragment = null;
        this.mRNDelegate = null;
    }

    public PreloadReactFragment getPreloadFragment() {
        if (this.mPreloadReactFragment == null) {
            this.mPreloadReactFragment = new PreloadReactFragment();
        }
        return this.mPreloadReactFragment;
    }

    public w getReactDelegate() {
        return this.mRNDelegate;
    }

    public void hide(boolean z10) {
        GlobalObject.runOnUiThread(new a(this, z10));
    }

    @MainThread
    public w init(AppCompatActivity appCompatActivity) {
        this.mActivity = appCompatActivity;
        observerHotUpdate();
        w wVar = this.mRNDelegate;
        if (wVar == null || wVar.f() == null) {
            this.mRNDelegate = new w(this.mActivity, ((u) this.mActivity.getApplication()).getReactNativeHost(), "rn", getLaunchOptions(this.mActivity), false);
            Log.d(TAG, "ReactDelegate init loadApp");
            this.mRNDelegate.i();
            this.mRNDelegate.d().q(new d(this));
        } else {
            Log.d(TAG, "ReactDelegate init reload");
            this.mRNDelegate.q();
        }
        return this.mRNDelegate;
    }

    public boolean isVisible() {
        PreloadReactFragment preloadReactFragment = this.mPreloadReactFragment;
        if (preloadReactFragment == null || !preloadReactFragment.isVisible()) {
            return false;
        }
        return true;
    }

    public void preload() {
        Log.d(TAG, "preload");
        show("preload", "");
        if (this.mPreloadReactFragment != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 1000);
        } else {
            Log.e(TAG, "preload: mPreloadReactFragment is null");
        }
    }

    public void show(String str, String str2) {
        Log.d(TAG, "show 显示rn页面: " + str);
        GlobalObject.runOnUiThread(new b(this, str, str2));
    }
}
