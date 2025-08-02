package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.blankj.utilcode.util.h;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.android.gms.base.R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    @NonNull
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final Object zaa = new Object();
    private static final GoogleApiAvailability zab = new GoogleApiAvailability();
    @GuardedBy("mLock")
    private String zac;

    @NonNull
    public static GoogleApiAvailability getInstance() {
        return zab;
    }

    @NonNull
    public static final Task<Map<ApiKey<?>, String>> zai(@NonNull HasApiKey<?> hasApiKey, @NonNull HasApiKey<?>... hasApiKeyArr) {
        Preconditions.checkNotNull(hasApiKey, "Requested API must not be null.");
        for (HasApiKey<?> checkNotNull : hasApiKeyArr) {
            Preconditions.checkNotNull(checkNotNull, "Requested API must not be null.");
        }
        ArrayList arrayList = new ArrayList(hasApiKeyArr.length + 1);
        arrayList.add(hasApiKey);
        arrayList.addAll(Arrays.asList(hasApiKeyArr));
        return GoogleApiManager.zal().zao(arrayList);
    }

    @NonNull
    public Task<Void> checkApiAvailability(@NonNull GoogleApi<?> googleApi, @NonNull GoogleApi<?>... googleApiArr) {
        return zai(googleApi, googleApiArr).onSuccessTask(zab.zaa);
    }

    @ShowFirstParty
    @KeepForSdk
    public int getClientVersion(@NonNull Context context) {
        return super.getClientVersion(context);
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Activity activity, int i10, int i11) {
        return getErrorDialog(activity, i10, i11, (DialogInterface.OnCancelListener) null);
    }

    @ShowFirstParty
    @KeepForSdk
    @Nullable
    public Intent getErrorResolutionIntent(@Nullable Context context, int i10, @Nullable String str) {
        return super.getErrorResolutionIntent(context, i10, str);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(@NonNull Context context, int i10, int i11) {
        return super.getErrorResolutionPendingIntent(context, i10, i11);
    }

    @NonNull
    public final String getErrorString(int i10) {
        return super.getErrorString(i10);
    }

    @HideFirstParty
    public int isGooglePlayServicesAvailable(@NonNull Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    public final boolean isUserResolvableError(int i10) {
        return super.isUserResolvableError(i10);
    }

    @MainThread
    @NonNull
    public Task<Void> makeGooglePlayServicesAvailable(@NonNull Activity activity) {
        int i10 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity, i10);
        if (isGooglePlayServicesAvailable == 0) {
            return Tasks.forResult(null);
        }
        zacc zaa2 = zacc.zaa(activity);
        zaa2.zah(new ConnectionResult(isGooglePlayServicesAvailable, (PendingIntent) null), 0);
        return zaa2.zad();
    }

    @TargetApi(26)
    public void setDefaultNotificationChannelId(@NonNull Context context, @NonNull String str) {
        if (PlatformVersion.isAtLeastO()) {
            Preconditions.checkNotNull(((NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"))).getNotificationChannel(str));
        }
        synchronized (zaa) {
            this.zac = str;
        }
    }

    public boolean showErrorDialogFragment(@NonNull Activity activity, int i10, int i11) {
        return showErrorDialogFragment(activity, i10, i11, (DialogInterface.OnCancelListener) null);
    }

    public void showErrorNotification(@NonNull Context context, int i10) {
        zae(context, i10, (String) null, getErrorResolutionPendingIntent(context, i10, 0, "n"));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final Dialog zaa(@NonNull Context context, int i10, zag zag, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(zac.zad(context, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String zac2 = zac.zac(context, i10);
        if (zac2 != null) {
            builder.setPositiveButton(zac2, zag);
        }
        String zag2 = zac.zag(context, i10);
        if (zag2 != null) {
            builder.setTitle(zag2);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[]{Integer.valueOf(i10)}), new IllegalArgumentException());
        return builder.create();
    }

    @NonNull
    public final Dialog zab(@NonNull Activity activity, @NonNull DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(zac.zad(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        zad(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    @Nullable
    public final zabx zac(Context context, zabw zabw) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabx = new zabx(zabw);
        context.registerReceiver(zabx, intentFilter);
        zabx.zaa(context);
        if (isUninstalledAppPossiblyUpdating(context, "com.google.android.gms")) {
            return zabx;
        }
        zabw.zaa();
        zabx.zab();
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zad(Activity activity, Dialog dialog, String str, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* access modifiers changed from: package-private */
    @TargetApi(20)
    public final void zae(Context context, int i10, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        int i11;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i10), null}), new IllegalArgumentException());
        if (i10 == 18) {
            zaf(context);
        } else if (pendingIntent != null) {
            String zaf = zac.zaf(context, i10);
            String zae = zac.zae(context, i10);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) Preconditions.checkNotNull(context.getSystemService("notification"));
            NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(zaf).setStyle(new NotificationCompat.BigTextStyle().bigText(zae));
            if (DeviceProperties.isWearable(context)) {
                Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
                style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
                if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                    style.addAction(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), pendingIntent);
                } else {
                    style.setContentIntent(pendingIntent);
                }
            } else {
                style.setSmallIcon(17301642).setTicker(resources.getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(zae);
            }
            if (PlatformVersion.isAtLeastO()) {
                Preconditions.checkState(PlatformVersion.isAtLeastO());
                synchronized (zaa) {
                    str2 = this.zac;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    NotificationChannel a10 = notificationManager.getNotificationChannel(str2);
                    String zab2 = zac.zab(context);
                    if (a10 == null) {
                        notificationManager.createNotificationChannel(h.a(str2, zab2, 4));
                    } else if (!zab2.contentEquals(a10.getName())) {
                        a10.setName(zab2);
                        notificationManager.createNotificationChannel(a10);
                    }
                }
                style.setChannelId(str2);
            }
            Notification build = style.build();
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
                i11 = 10436;
            } else {
                i11 = 39789;
            }
            notificationManager.notify(i11, build);
        } else if (i10 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaf(Context context) {
        new c(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public final boolean zag(@NonNull Activity activity, @NonNull LifecycleFragment lifecycleFragment, int i10, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog zaa2 = zaa(activity, i10, zag.zad(lifecycleFragment, getErrorResolutionIntent(activity, i10, DomainUhfReportModel.ENCRYPTDATA), 2), onCancelListener);
        if (zaa2 == null) {
            return false;
        }
        zad(activity, zaa2, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public final boolean zah(@NonNull Context context, @NonNull ConnectionResult connectionResult, int i10) {
        PendingIntent errorResolutionPendingIntent;
        if (InstantApps.isInstantApp(context) || (errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult)) == null) {
            return false;
        }
        zae(context, connectionResult.getErrorCode(), (String) null, zal.zaa(context, 0, GoogleApiActivity.zaa(context, errorResolutionPendingIntent, i10, true), zal.zaa | GameControllerManager.DEVICEFLAG_VIBRATION));
        return true;
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Activity activity, int i10, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return zaa(activity, i10, zag.zab(activity, getErrorResolutionIntent(activity, i10, DomainUhfReportModel.ENCRYPTDATA), i11), onCancelListener);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            return connectionResult.getResolution();
        }
        return getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
    }

    @ShowFirstParty
    @KeepForSdk
    public int isGooglePlayServicesAvailable(@NonNull Context context, int i10) {
        return super.isGooglePlayServicesAvailable(context, i10);
    }

    public boolean showErrorDialogFragment(@NonNull Activity activity, int i10, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i10, i11, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        zad(activity, errorDialog, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @NonNull
    public Task<Void> checkApiAvailability(@NonNull HasApiKey<?> hasApiKey, @NonNull HasApiKey<?>... hasApiKeyArr) {
        return zai(hasApiKey, hasApiKeyArr).onSuccessTask(zaa.zaa);
    }

    public void showErrorNotification(@NonNull Context context, @NonNull ConnectionResult connectionResult) {
        zae(context, connectionResult.getErrorCode(), (String) null, getErrorResolutionPendingIntent(context, connectionResult));
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Fragment fragment, int i10, int i11) {
        return getErrorDialog(fragment, i10, i11, (DialogInterface.OnCancelListener) null);
    }

    @Nullable
    public Dialog getErrorDialog(@NonNull Fragment fragment, int i10, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return zaa(fragment.requireContext(), i10, zag.zac(fragment, getErrorResolutionIntent(fragment.requireContext(), i10, DomainUhfReportModel.ENCRYPTDATA), i11), onCancelListener);
    }
}
