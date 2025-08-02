package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.List;

public final class GoogleAuthUtil extends zzl {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    @NonNull
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    @NonNull
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    @NonNull
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    private GoogleAuthUtil() {
    }

    public static void clearToken(@NonNull Context context, @NonNull String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        zzl.clearToken(context, str);
    }

    @NonNull
    public static List<AccountChangeEvent> getAccountChangeEvents(@NonNull Context context, int i10, @NonNull String str) throws GoogleAuthException, IOException {
        return zzl.getAccountChangeEvents(context, i10, str);
    }

    @NonNull
    public static String getAccountId(@NonNull Context context, @NonNull String str) throws GoogleAuthException, IOException {
        return zzl.getAccountId(context, str);
    }

    @NonNull
    public static String getToken(@NonNull Context context, @NonNull Account account, @NonNull String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzl.getToken(context, account, str);
    }

    @NonNull
    public static String getTokenWithNotification(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle).zza();
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(@NonNull Context context, @NonNull String str) {
        zzl.invalidateToken(context, str);
    }

    @TargetApi(23)
    @NonNull
    public static Bundle removeAccount(@NonNull Context context, @NonNull Account account) throws GoogleAuthException, IOException {
        return zzl.removeAccount(context, account);
    }

    @TargetApi(26)
    @NonNull
    public static Boolean requestGoogleAccountsAccess(@NonNull Context context) throws GoogleAuthException, IOException {
        return zzl.requestGoogleAccountsAccess(context);
    }

    private static TokenData zzg(Context context, Account account, String str, Bundle bundle) throws IOException, GoogleAuthException {
        try {
            TokenData zza = zzl.zza(context, account, str, bundle);
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            return zza;
        } catch (GooglePlayServicesAvailabilityException e10) {
            GooglePlayServicesUtil.showErrorNotification(e10.getConnectionStatusCode(), context);
            Log.w("GoogleAuthUtil", "Error when getting token", e10);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.", e10);
        } catch (UserRecoverableAuthException e11) {
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            Log.w("GoogleAuthUtil", "Error when getting token", e11);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.", e11);
        }
    }

    @NonNull
    public static String getToken(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzl.getToken(context, account, str, bundle);
    }

    @NonNull
    @Deprecated
    public static String getToken(@NonNull Context context, @NonNull String str, @NonNull String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzl.getToken(context, str, str2);
    }

    @NonNull
    @Deprecated
    public static String getToken(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzl.getToken(context, str, str2, bundle);
    }

    @NonNull
    public static String getTokenWithNotification(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle, @NonNull Intent intent) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        zzl.zzf(intent);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable("callback_intent", intent);
        bundle.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle).zza();
    }

    @NonNull
    public static String getTokenWithNotification(@NonNull Context context, @NonNull Account account, @NonNull String str, @NonNull Bundle bundle, @NonNull String str2, @NonNull Bundle bundle2) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        Preconditions.checkNotEmpty(str2, "Authority cannot be empty or null.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle2);
        bundle.putString("authority", str2);
        bundle.putBundle("sync_extras", bundle2);
        bundle.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle).zza();
    }

    @NonNull
    @Deprecated
    public static String getTokenWithNotification(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle);
    }

    @NonNull
    @Deprecated
    public static String getTokenWithNotification(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle, @NonNull Intent intent) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, intent);
    }

    @NonNull
    @Deprecated
    public static String getTokenWithNotification(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull Bundle bundle, @NonNull String str3, @NonNull Bundle bundle2) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, str3, bundle2);
    }
}
