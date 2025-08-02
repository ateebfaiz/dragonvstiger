package com.sensorsdata.analytics.android.sdk.useridentity;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor;
import com.sensorsdata.analytics.android.sdk.useridentity.Identities;
import com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityStrategy;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.UUID;
import org.json.JSONObject;

public final class UserIdentityAPI implements IUserIdentityAPI {
    private static final String TAG = "SA.UserIdentityAPI";
    private final PersistentDistinctId mAnonymousId;
    private H5UserIdentityStrategy mH5UserIdentityStrategy;
    private final Identities mIdentitiesInstance;
    private String mLoginIdValue = null;
    private final SAContextManager mSAContextManager;

    public UserIdentityAPI(SAContextManager sAContextManager) {
        this.mSAContextManager = sAContextManager;
        PersistentDistinctId anonymousIdPst = PersistentLoader.getInstance().getAnonymousIdPst();
        this.mAnonymousId = anonymousIdPst;
        Identities identities = new Identities();
        this.mIdentitiesInstance = identities;
        try {
            identities.init(SensorsDataUtils.getIdentifier(sAContextManager.getContext()), (String) anonymousIdPst.get());
            this.mLoginIdValue = identities.getJointLoginID();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void bind(String str, String str2) {
        bindBack(str, str2);
    }

    public boolean bindBack(String str, String str2) {
        try {
            return this.mIdentitiesInstance.update(str, str2);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public String getAnonymousId() {
        String str;
        try {
            synchronized (this.mAnonymousId) {
                str = (String) this.mAnonymousId.get();
            }
            return str;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public String getDistinctId() {
        try {
            String loginId = getLoginId();
            if (!TextUtils.isEmpty(loginId)) {
                return loginId;
            }
            return getAnonymousId();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public JSONObject getIdentities(EventType eventType) {
        if (EventType.TRACK_SIGNUP == eventType) {
            return this.mIdentitiesInstance.getIdentities(Identities.State.LOGIN_KEY);
        }
        if (EventType.TRACK_ID_UNBIND == eventType) {
            return this.mIdentitiesInstance.getIdentities(Identities.State.REMOVE_KEYID);
        }
        return this.mIdentitiesInstance.getIdentities(Identities.State.DEFAULT);
    }

    public Identities getIdentitiesInstance() {
        return this.mIdentitiesInstance;
    }

    public String getLoginId() {
        String str = "";
        try {
            if (!AppInfoUtils.isTaskExecuteThread()) {
                return this.mLoginIdValue;
            }
            String jointLoginID = this.mIdentitiesInstance.getJointLoginID();
            if (!TextUtils.isEmpty(jointLoginID)) {
                return jointLoginID;
            }
            String loginIDKey = this.mIdentitiesInstance.getLoginIDKey();
            if (TextUtils.isEmpty(jointLoginID)) {
                loginIDKey = LoginIDAndKey.LOGIN_ID_KEY_DEFAULT;
            }
            JSONObject identities = this.mIdentitiesInstance.getIdentities(Identities.State.LOGIN_KEY);
            if (identities != null) {
                str = identities.optString(loginIDKey);
            }
            return str;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return str;
        }
    }

    public void identify(String str) {
        try {
            SALog.i(TAG, "identify is called");
            synchronized (this.mAnonymousId) {
                if (!str.equals(this.mAnonymousId.get())) {
                    this.mAnonymousId.commit(str);
                    this.mIdentitiesInstance.updateSpecialIDKeyAndValue(Identities.SpecialID.ANONYMOUS_ID, str);
                    if (this.mSAContextManager.getEventListenerList() != null) {
                        for (SAEventListener identify : this.mSAContextManager.getEventListenerList()) {
                            try {
                                identify.identify();
                            } catch (Exception e10) {
                                SALog.printStackTrace(e10);
                            }
                        }
                    }
                    TrackMonitor.getInstance().callIdentify(str);
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void login(String str) {
        loginWithKeyBack(LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, str);
    }

    public void loginWithKey(String str, String str2) {
        loginWithKeyBack(str, str2);
    }

    public boolean loginWithKeyBack(String str, String str2) {
        try {
            boolean updateLoginKeyAndID = this.mIdentitiesInstance.updateLoginKeyAndID(str, str2, getAnonymousId());
            if (!updateLoginKeyAndID) {
                return updateLoginKeyAndID;
            }
            if (this.mSAContextManager.getEventListenerList() != null) {
                for (SAEventListener login : this.mSAContextManager.getEventListenerList()) {
                    try {
                        login.login();
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            }
            TrackMonitor.getInstance().callLogin(this.mIdentitiesInstance.getJointLoginID());
            return updateLoginKeyAndID;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return false;
        }
    }

    public void logout() {
        try {
            SensorsDataContentObserver.State.LOGOUT.isDid = true;
            SensorsDataContentObserver.State.LOGIN.isDid = false;
            JSONObject identities = this.mIdentitiesInstance.getIdentities(Identities.State.DEFAULT);
            boolean z10 = !TextUtils.isEmpty(this.mIdentitiesInstance.getLoginId());
            if (!z10) {
                if (identities == null) {
                    return;
                }
                if (identities.length() == 1) {
                    if (identities.has(Identities.ANDROID_ID)) {
                        return;
                    }
                    if (identities.has(Identities.ANDROID_UUID)) {
                        return;
                    }
                }
            }
            SALog.i(TAG, "logout is called");
            this.mIdentitiesInstance.removeLoginKeyAndID();
            if (z10) {
                if (this.mSAContextManager.getEventListenerList() != null) {
                    for (SAEventListener logout : this.mSAContextManager.getEventListenerList()) {
                        try {
                            logout.logout();
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                        }
                    }
                }
                TrackMonitor.getInstance().callLogout();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        SALog.i(TAG, "Clean loginId");
    }

    public boolean mergeH5Identities(EventType eventType, JSONObject jSONObject) {
        if (this.mH5UserIdentityStrategy == null) {
            this.mH5UserIdentityStrategy = new H5UserIdentityStrategy(this);
        }
        return this.mH5UserIdentityStrategy.processH5UserIdentity(eventType, jSONObject);
    }

    public void resetAnonymousId() {
        try {
            synchronized (this.mAnonymousId) {
                SALog.i(TAG, "resetAnonymousId is called");
                String identifier = SensorsDataUtils.getIdentifier(this.mSAContextManager.getContext());
                if (identifier.equals(this.mAnonymousId.get())) {
                    SALog.i(TAG, "DistinctId not change");
                    return;
                }
                if (!SensorsDataUtils.isValidAndroidId(identifier)) {
                    identifier = UUID.randomUUID().toString();
                }
                this.mAnonymousId.commit(identifier);
                if (this.mIdentitiesInstance.getIdentities(Identities.State.DEFAULT).has(Identities.ANONYMOUS_ID)) {
                    this.mIdentitiesInstance.updateSpecialIDKeyAndValue(Identities.SpecialID.ANONYMOUS_ID, (String) this.mAnonymousId.get());
                }
                if (this.mSAContextManager.getEventListenerList() != null) {
                    for (SAEventListener resetAnonymousId : this.mSAContextManager.getEventListenerList()) {
                        try {
                            resetAnonymousId.resetAnonymousId();
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                        }
                    }
                }
                TrackMonitor.getInstance().callResetAnonymousId(identifier);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void resetAnonymousIdentity(String str) {
        try {
            if (!TextUtils.isEmpty(this.mLoginIdValue)) {
                SALog.i(TAG, "resetAnonymousIdentity 需退出登录后调用");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = UUID.randomUUID().toString();
            }
            this.mAnonymousId.commit(str);
            this.mIdentitiesInstance.updateIDKeyAndValue(str);
            if (this.mSAContextManager.getEventListenerList() != null) {
                for (SAEventListener resetAnonymousId : this.mSAContextManager.getEventListenerList()) {
                    try {
                        resetAnonymousId.resetAnonymousId();
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            }
            TrackMonitor.getInstance().callResetAnonymousId(str);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void trackH5Notify(JSONObject jSONObject) {
        try {
            if (this.mSAContextManager.getEventListenerList() != null) {
                for (SAEventListener trackEvent : this.mSAContextManager.getEventListenerList()) {
                    try {
                        trackEvent.trackEvent(jSONObject);
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        TrackMonitor.getInstance().callTrack(jSONObject);
    }

    public void unbind(String str, String str2) {
        unbindBack(str, str2);
    }

    public boolean unbindBack(String str, String str2) {
        try {
            return this.mIdentitiesInstance.remove(str, str2);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public void updateLoginId(String str, String str2) {
        this.mLoginIdValue = LoginIDAndKey.jointLoginID(str, str2);
    }

    public void login(String str, JSONObject jSONObject) {
        loginWithKeyBack(LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, str);
    }

    public void loginWithKey(String str, String str2, JSONObject jSONObject) {
        loginWithKeyBack(str, str2);
    }

    public JSONObject getIdentities() {
        return this.mIdentitiesInstance.getIdentities(Identities.State.DEFAULT);
    }
}
