package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public interface zzcc extends IInterface {
    void beginAdUnitExposure(String str, long j10) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j10) throws RemoteException;

    void endAdUnitExposure(String str, long j10) throws RemoteException;

    void generateEventId(zzcf zzcf) throws RemoteException;

    void getAppInstanceId(zzcf zzcf) throws RemoteException;

    void getCachedAppInstanceId(zzcf zzcf) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, zzcf zzcf) throws RemoteException;

    void getCurrentScreenClass(zzcf zzcf) throws RemoteException;

    void getCurrentScreenName(zzcf zzcf) throws RemoteException;

    void getGmpAppId(zzcf zzcf) throws RemoteException;

    void getMaxUserProperties(String str, zzcf zzcf) throws RemoteException;

    void getSessionId(zzcf zzcf) throws RemoteException;

    void getTestFlag(zzcf zzcf, int i10) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z10, zzcf zzcf) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(IObjectWrapper iObjectWrapper, zzcl zzcl, long j10) throws RemoteException;

    void isDataCollectionEnabled(zzcf zzcf) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcf, long j10) throws RemoteException;

    void logHealthData(int i10, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j10) throws RemoteException;

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcf, long j10) throws RemoteException;

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j10) throws RemoteException;

    void performAction(Bundle bundle, zzcf zzcf, long j10) throws RemoteException;

    void registerOnMeasurementEventListener(zzci zzci) throws RemoteException;

    void resetAnalyticsData(long j10) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j10) throws RemoteException;

    void setConsent(Bundle bundle, long j10) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j10) throws RemoteException;

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j10) throws RemoteException;

    void setDataCollectionEnabled(boolean z10) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(zzci zzci) throws RemoteException;

    void setInstanceIdProvider(zzck zzck) throws RemoteException;

    void setMeasurementEnabled(boolean z10, long j10) throws RemoteException;

    void setMinimumSessionDuration(long j10) throws RemoteException;

    void setSessionTimeoutDuration(long j10) throws RemoteException;

    void setUserId(String str, long j10) throws RemoteException;

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z10, long j10) throws RemoteException;

    void unregisterOnMeasurementEventListener(zzci zzci) throws RemoteException;
}
