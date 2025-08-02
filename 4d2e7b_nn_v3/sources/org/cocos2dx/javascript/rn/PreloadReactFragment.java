package org.cocos2dx.javascript.rn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.facebook.react.w;
import org.cocos2dx.javascript.PlatformUtils;
import w6.g;
import w6.h;

public class PreloadReactFragment extends Fragment implements g {
    protected static final String ARG_COMPONENT_NAME = "arg_component_name";
    protected static final String ARG_DELEGATE = "arg_delegate";
    protected static final String ARG_FABRIC_ENABLED = "arg_fabric_enabled";
    protected static final String ARG_LAUNCH_OPTIONS = "arg_launch_options";
    @Nullable
    private h mPermissionListener;
    protected w mReactDelegate;

    public int checkPermission(String str, int i10, int i11) {
        return getActivity().checkPermission(str, i10, i11);
    }

    public int checkSelfPermission(String str) {
        return getActivity().checkSelfPermission(str);
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        w wVar = this.mReactDelegate;
        if (wVar != null) {
            wVar.k(i10, i11, intent, false);
        }
    }

    public boolean onBackPressed() {
        w wVar = this.mReactDelegate;
        if (wVar == null || !wVar.l()) {
            return false;
        }
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w reactDelegate = RNDelegateManager.getInstance().getReactDelegate();
        this.mReactDelegate = reactDelegate;
        if (reactDelegate == null) {
            this.mReactDelegate = RNDelegateManager.getInstance().init(PlatformUtils.getActivity());
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        w wVar = this.mReactDelegate;
        if (!(wVar == null || wVar.f() == null)) {
            this.mReactDelegate.f().setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        w wVar2 = this.mReactDelegate;
        if (wVar2 != null) {
            return wVar2.f();
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        w wVar = this.mReactDelegate;
        if (wVar != null) {
            wVar.m();
        }
    }

    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        w wVar = this.mReactDelegate;
        if (wVar == null || !wVar.r(i10, keyEvent)) {
            return false;
        }
        return true;
    }

    public void onPause() {
        super.onPause();
        if (this.mReactDelegate != null && !RNDelegateManager.getInstance().mReloadWhenExit) {
            try {
                this.mReactDelegate.n();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        h hVar = this.mPermissionListener;
        if (hVar != null && hVar.onRequestPermissionsResult(i10, strArr, iArr)) {
            this.mPermissionListener = null;
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mReactDelegate != null && !RNDelegateManager.getInstance().mReloadWhenExit) {
            this.mReactDelegate.o();
        }
    }

    public void requestPermissions(String[] strArr, int i10, h hVar) {
        this.mPermissionListener = hVar;
        requestPermissions(strArr, i10);
    }
}
