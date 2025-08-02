package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.VisibleForTesting;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    @NonNull
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @NonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    @NonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    @Nullable
    public static Dialog getErrorDialog(int i10, @NonNull Activity activity, int i11) {
        return getErrorDialog(i10, activity, i11, (DialogInterface.OnCancelListener) null);
    }

    @NonNull
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i10, @NonNull Context context, int i11) {
        return GooglePlayServicesUtilLight.getErrorPendingIntent(i10, context, i11);
    }

    @NonNull
    @Deprecated
    @VisibleForTesting
    public static String getErrorString(int i10) {
        return GooglePlayServicesUtilLight.getErrorString(i10);
    }

    @NonNull
    public static Context getRemoteContext(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    @NonNull
    public static Resources getRemoteResource(@NonNull Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    @Deprecated
    @HideFirstParty
    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i10) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i10);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i10, @NonNull Activity activity, int i11) {
        return showErrorDialogFragment(i10, activity, i11, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static void showErrorNotification(int i10, @NonNull Context context) {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i10) || GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i10)) {
            instance.zaf(context);
        } else {
            instance.showErrorNotification(context, i10);
        }
    }

    @Deprecated
    @Nullable
    public static Dialog getErrorDialog(int i10, @NonNull Activity activity, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i10)) {
            i10 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i10, i11, onCancelListener);
    }

    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context, int i10) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i10);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i10, @NonNull Activity activity, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i10, activity, (Fragment) null, i11, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i10, @NonNull Activity activity, @Nullable Fragment fragment, int i11, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(activity, i10)) {
            i10 = 18;
        }
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return instance.showErrorDialogFragment(activity, i10, i11, onCancelListener);
        }
        Dialog zaa = instance.zaa(activity, i10, zag.zac(fragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent(activity, i10, DomainUhfReportModel.ENCRYPTDATA), i11), onCancelListener);
        if (zaa == null) {
            return false;
        }
        instance.zad(activity, zaa, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
