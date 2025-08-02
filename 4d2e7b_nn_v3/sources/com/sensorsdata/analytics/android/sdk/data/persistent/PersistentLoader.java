package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

public class PersistentLoader {
    private static volatile PersistentLoader INSTANCE;
    private final PersistentDistinctId mAnonymousIdPst = ((PersistentDistinctId) loadPersistent(DbParams.PersistentName.DISTINCT_ID));
    private final PersistentAppEndData mAppEndDataPst = ((PersistentAppEndData) loadPersistent(DbParams.PersistentName.APP_END_DATA));
    private final PersistentAppExitData mAppExitDataPst = ((PersistentAppExitData) loadPersistent(DbParams.APP_EXIT_DATA));
    private final Context mContext;
    private final PersistentDailyDate mDayDatePst = ((PersistentDailyDate) loadPersistent(DbParams.PersistentName.PERSISTENT_DAY_DATE));
    private final PersistentFirstDay mFirstDayPst = ((PersistentFirstDay) loadPersistent(DbParams.PersistentName.FIRST_DAY));
    private final PersistentFirstTrackInstallation mFirstInstallationPst = ((PersistentFirstTrackInstallation) loadPersistent(DbParams.PersistentName.FIRST_INSTALL));
    private final PersistentFirstTrackInstallationWithCallback mFirstInstallationWithCallbackPst = ((PersistentFirstTrackInstallationWithCallback) loadPersistent(DbParams.PersistentName.FIRST_INSTALL_CALLBACK));
    private final PersistentFirstStart mFirstStartPst = ((PersistentFirstStart) loadPersistent(DbParams.PersistentName.FIRST_START));
    private final LoginIdKeyPersistent mLoginIdKeyPst = ((LoginIdKeyPersistent) loadPersistent(DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY));
    private final PersistentLoginId mLoginIdPst = ((PersistentLoginId) loadPersistent(DbParams.PersistentName.LOGIN_ID));
    private final PersistentRemoteSDKConfig mRemoteSDKConfig = ((PersistentRemoteSDKConfig) loadPersistent(DbParams.PersistentName.REMOTE_CONFIG));
    private final PersistentSuperProperties mSuperPropertiesPst = ((PersistentSuperProperties) loadPersistent(DbParams.PersistentName.SUPER_PROPERTIES));
    private final UserIdentityPersistent mUserIdsPst = ((UserIdentityPersistent) loadPersistent(DbParams.PersistentName.PERSISTENT_USER_ID));
    private final PersistentVisualConfig mVisualConfigPst = ((PersistentVisualConfig) loadPersistent(DbParams.PersistentName.VISUAL_PROPERTIES));

    private PersistentLoader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static PersistentLoader getInstance() {
        return INSTANCE;
    }

    private PersistentIdentity<?> loadPersistent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1436067305:
                if (str.equals(DbParams.PersistentName.LOGIN_ID)) {
                    c10 = 0;
                    break;
                }
                break;
            case -951089033:
                if (str.equals(DbParams.PersistentName.SUPER_PROPERTIES)) {
                    c10 = 1;
                    break;
                }
                break;
            case -854148740:
                if (str.equals(DbParams.PersistentName.FIRST_INSTALL_CALLBACK)) {
                    c10 = 2;
                    break;
                }
                break;
            case -690407917:
                if (str.equals(DbParams.PersistentName.FIRST_START)) {
                    c10 = 3;
                    break;
                }
                break;
            case -456824111:
                if (str.equals(DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY)) {
                    c10 = 4;
                    break;
                }
                break;
            case -266152892:
                if (str.equals(DbParams.PersistentName.PERSISTENT_USER_ID)) {
                    c10 = 5;
                    break;
                }
                break;
            case -212773998:
                if (str.equals(DbParams.PersistentName.VISUAL_PROPERTIES)) {
                    c10 = 6;
                    break;
                }
                break;
            case 133344653:
                if (str.equals(DbParams.PersistentName.FIRST_DAY)) {
                    c10 = 7;
                    break;
                }
                break;
            case 721318680:
                if (str.equals(DbParams.PersistentName.DISTINCT_ID)) {
                    c10 = 8;
                    break;
                }
                break;
            case 923005325:
                if (str.equals(DbParams.APP_EXIT_DATA)) {
                    c10 = 9;
                    break;
                }
                break;
            case 947194773:
                if (str.equals(DbParams.PersistentName.REMOTE_CONFIG)) {
                    c10 = 10;
                    break;
                }
                break;
            case 1214783133:
                if (str.equals(DbParams.PersistentName.FIRST_INSTALL)) {
                    c10 = 11;
                    break;
                }
                break;
            case 1521941740:
                if (str.equals(DbParams.PersistentName.APP_END_DATA)) {
                    c10 = 12;
                    break;
                }
                break;
            case 1526641172:
                if (str.equals(DbParams.PersistentName.PERSISTENT_DAY_DATE)) {
                    c10 = 13;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new PersistentLoginId();
            case 1:
                return new PersistentSuperProperties();
            case 2:
                return new PersistentFirstTrackInstallationWithCallback();
            case 3:
                return new PersistentFirstStart();
            case 4:
                return new LoginIdKeyPersistent();
            case 5:
                return new UserIdentityPersistent();
            case 6:
                return new PersistentVisualConfig();
            case 7:
                return new PersistentFirstDay();
            case 8:
                return new PersistentDistinctId(this.mContext);
            case 9:
                return new PersistentAppExitData();
            case 10:
                return new PersistentRemoteSDKConfig();
            case 11:
                return new PersistentFirstTrackInstallation();
            case 12:
                return new PersistentAppEndData();
            case 13:
                return new PersistentDailyDate();
            default:
                return null;
        }
    }

    public static void preInit(Context context) {
        if (INSTANCE == null) {
            synchronized (PersistentLoader.class) {
                try {
                    if (INSTANCE == null) {
                        INSTANCE = new PersistentLoader(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public PersistentDistinctId getAnonymousIdPst() {
        return this.mAnonymousIdPst;
    }

    public PersistentAppEndData getAppEndDataPst() {
        return this.mAppEndDataPst;
    }

    public PersistentAppExitData getAppExitDataPst() {
        return this.mAppExitDataPst;
    }

    public PersistentDailyDate getDayDatePst() {
        return this.mDayDatePst;
    }

    public PersistentFirstDay getFirstDayPst() {
        return this.mFirstDayPst;
    }

    public PersistentFirstTrackInstallation getFirstInstallationPst() {
        return this.mFirstInstallationPst;
    }

    public PersistentFirstTrackInstallationWithCallback getFirstInstallationWithCallbackPst() {
        return this.mFirstInstallationWithCallbackPst;
    }

    public PersistentFirstStart getFirstStartPst() {
        return this.mFirstStartPst;
    }

    public LoginIdKeyPersistent getLoginIdKeyPst() {
        return this.mLoginIdKeyPst;
    }

    public PersistentLoginId getLoginIdPst() {
        return this.mLoginIdPst;
    }

    public PersistentRemoteSDKConfig getRemoteSDKConfig() {
        return this.mRemoteSDKConfig;
    }

    public PersistentSuperProperties getSuperPropertiesPst() {
        return this.mSuperPropertiesPst;
    }

    public UserIdentityPersistent getUserIdsPst() {
        return this.mUserIdsPst;
    }

    public PersistentVisualConfig getVisualConfigPst() {
        return this.mVisualConfigPst;
    }
}
