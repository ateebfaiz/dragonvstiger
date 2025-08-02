package com.sensorsdata.analytics.android.sdk.core.rpc;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey;

public class SensorsDataContentObserver extends ContentObserver {

    public enum State {
        LOGOUT(false, false),
        LOGIN(false, false),
        ENABLE_SDK(false, false),
        DISABLE_SDK(false, false);
        
        public boolean isDid;
        public boolean isObserverCalled;

        private State(boolean z10, boolean z11) {
            this.isDid = z10;
            this.isObserverCalled = z11;
        }
    }

    public SensorsDataContentObserver() {
        super(new Handler(Looper.getMainLooper()));
    }

    public void onChange(boolean z10, Uri uri) {
        SAContextManager sAContextManager;
        try {
            if (DbParams.getInstance().getSessionTimeUri().equals(uri)) {
                SensorsDataAPI.sharedInstance().setSessionIntervalTime(DbAdapter.getInstance().getSessionIntervalTime());
            } else if (DbParams.getInstance().getLoginIdUri().equals(uri)) {
                String loginIdKey = DbAdapter.getInstance().getLoginIdKey();
                String loginId = DbAdapter.getInstance().getLoginId();
                if ((TextUtils.isEmpty(loginId) || loginIdKey.equals(LoginIDAndKey.LOGIN_ID_KEY_DEFAULT)) && TextUtils.isEmpty(loginId)) {
                    State state = State.LOGOUT;
                    if (state.isDid) {
                        state.isDid = false;
                        return;
                    }
                    state.isObserverCalled = true;
                    SensorsDataAPI.sharedInstance().logout();
                    return;
                }
                State state2 = State.LOGIN;
                if (state2.isDid) {
                    state2.isDid = false;
                } else {
                    SensorsDataAPI.sharedInstance().loginWithKey(loginIdKey, loginId);
                }
            } else if (DbParams.getInstance().getDisableSDKUri().equals(uri)) {
                State state3 = State.DISABLE_SDK;
                if (state3.isDid) {
                    state3.isDid = false;
                    return;
                }
                state3.isObserverCalled = true;
                SensorsDataAPI.disableSDK();
            } else if (DbParams.getInstance().getEnableSDKUri().equals(uri)) {
                State state4 = State.ENABLE_SDK;
                if (state4.isDid) {
                    state4.isDid = false;
                    return;
                }
                state4.isObserverCalled = true;
                SensorsDataAPI.enableSDK();
            } else if (DbParams.getInstance().getUserIdentities().equals(uri)) {
                SensorsDataAPI sharedInstance = SensorsDataAPI.sharedInstance();
                if (!(sharedInstance instanceof SensorsDataAPIEmptyImplementation) && (sAContextManager = sharedInstance.getSAContextManager()) != null) {
                    sAContextManager.getUserIdentityAPI().getIdentitiesInstance().updateIdentities();
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
