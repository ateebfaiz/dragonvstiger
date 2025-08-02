package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.f;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;
import java.util.Queue;

@KeepForSdk
public class ServiceStarter {
    static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    static final int ERROR_ILLEGAL_STATE_EXCEPTION = 402;
    static final int ERROR_ILLEGAL_STATE_EXCEPTION_FALLBACK_TO_BIND = 403;
    static final int ERROR_NOT_FOUND = 404;
    static final int ERROR_SECURITY_EXCEPTION = 401;
    @KeepForSdk
    public static final int ERROR_UNKNOWN = 500;
    private static final String EXTRA_WRAPPED_INTENT = "wrapped_intent";
    private static final String PERMISSIONS_MISSING_HINT = "this should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    public static final int SUCCESS = -1;
    private static ServiceStarter instance;
    @GuardedBy("this")
    @Nullable
    private String firebaseMessagingServiceClassName = null;
    private Boolean hasAccessNetworkStatePermission = null;
    private Boolean hasWakeLockPermission = null;
    private final Queue<Intent> messagingEvents = new ArrayDeque();

    private ServiceStarter() {
    }

    private int doStartService(Context context, Intent intent) {
        ComponentName componentName;
        String resolveServiceClassName = resolveServiceClassName(context, intent);
        if (resolveServiceClassName != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "Restricting intent to a specific service: " + resolveServiceClassName);
            }
            intent.setClassName(context.getPackageName(), resolveServiceClassName);
        }
        try {
            if (hasWakeLockPermission(context)) {
                componentName = v0.h(context, intent);
            } else {
                componentName = context.startService(intent);
                Log.d(Constants.TAG, "Missing wake lock permission, service start may be delayed");
            }
            if (componentName != null) {
                return -1;
            }
            Log.e(Constants.TAG, "Error while delivering the message: ServiceIntent not found.");
            return ERROR_NOT_FOUND;
        } catch (SecurityException e10) {
            Log.e(Constants.TAG, "Error while delivering the message to the serviceIntent", e10);
            return ERROR_SECURITY_EXCEPTION;
        } catch (IllegalStateException e11) {
            Log.e(Constants.TAG, "Failed to start service while in background: " + e11);
            return ERROR_ILLEGAL_STATE_EXCEPTION;
        }
    }

    static synchronized ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            try {
                if (instance == null) {
                    instance = new ServiceStarter();
                }
                serviceStarter = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceStarter;
    }

    @Nullable
    private synchronized String resolveServiceClassName(Context context, Intent intent) {
        try {
            String str = this.firebaseMessagingServiceClassName;
            if (str != null) {
                return str;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (serviceInfo != null) {
                    if (context.getPackageName().equals(serviceInfo.packageName)) {
                        String str2 = serviceInfo.name;
                        if (str2 != null) {
                            if (str2.startsWith(f.G)) {
                                this.firebaseMessagingServiceClassName = context.getPackageName() + serviceInfo.name;
                            } else {
                                this.firebaseMessagingServiceClassName = serviceInfo.name;
                            }
                            return this.firebaseMessagingServiceClassName;
                        }
                    }
                    Log.e(Constants.TAG, "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + DomExceptionUtils.SEPARATOR + serviceInfo.name);
                    return null;
                }
            }
            Log.e(Constants.TAG, "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @VisibleForTesting
    public static void setForTesting(ServiceStarter serviceStarter) {
        instance = serviceStarter;
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public Intent getMessagingEvent() {
        return this.messagingEvents.poll();
    }

    /* access modifiers changed from: package-private */
    public boolean hasAccessNetworkStatePermission(Context context) {
        boolean z10;
        if (this.hasAccessNetworkStatePermission == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.hasAccessNetworkStatePermission = Boolean.valueOf(z10);
        }
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean hasWakeLockPermission(Context context) {
        boolean z10;
        if (this.hasWakeLockPermission == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.hasWakeLockPermission = Boolean.valueOf(z10);
        }
        if (!this.hasWakeLockPermission.booleanValue() && Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.hasWakeLockPermission.booleanValue();
    }

    @MainThread
    public int startMessagingService(Context context, Intent intent) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "Starting service");
        }
        this.messagingEvents.offer(intent);
        Intent intent2 = new Intent(ACTION_MESSAGING_EVENT);
        intent2.setPackage(context.getPackageName());
        return doStartService(context, intent2);
    }
}
