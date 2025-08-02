package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

public final class zac {
    private static final SimpleArrayMap<String, String> zaa = new SimpleArrayMap<>();
    @Nullable
    private static Locale zab;

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    @NonNull
    public static String zac(Context context, int i10) {
        Resources resources = context.getResources();
        if (i10 == 1) {
            return resources.getString(R.string.common_google_play_services_install_button);
        }
        if (i10 == 2) {
            return resources.getString(R.string.common_google_play_services_update_button);
        }
        if (i10 != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(R.string.common_google_play_services_enable_button);
    }

    @NonNull
    public static String zad(Context context, int i10) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context);
        if (i10 == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, new Object[]{zaa2});
        } else if (i10 != 2) {
            if (i10 == 3) {
                return resources.getString(R.string.common_google_play_services_enable_text, new Object[]{zaa2});
            } else if (i10 == 5) {
                return zah(context, "common_google_play_services_invalid_account_text", zaa2);
            } else {
                if (i10 == 7) {
                    return zah(context, "common_google_play_services_network_error_text", zaa2);
                }
                if (i10 == 9) {
                    return resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{zaa2});
                } else if (i10 == 20) {
                    return zah(context, "common_google_play_services_restricted_profile_text", zaa2);
                } else {
                    switch (i10) {
                        case 16:
                            return zah(context, "common_google_play_services_api_unavailable_text", zaa2);
                        case 17:
                            return zah(context, "common_google_play_services_sign_in_failed_text", zaa2);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, new Object[]{zaa2});
                        default:
                            return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, new Object[]{zaa2});
                    }
                }
            }
        } else if (DeviceProperties.isWearableWithoutPlayStore(context)) {
            return resources.getString(R.string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R.string.common_google_play_services_update_text, new Object[]{zaa2});
        }
    }

    @NonNull
    public static String zae(Context context, int i10) {
        if (i10 == 6 || i10 == 19) {
            return zah(context, "common_google_play_services_resolution_required_text", zaa(context));
        }
        return zad(context, i10);
    }

    @NonNull
    public static String zaf(Context context, int i10) {
        String str;
        if (i10 == 6) {
            str = zai(context, "common_google_play_services_resolution_required_title");
        } else {
            str = zag(context, i10);
        }
        if (str == null) {
            return context.getResources().getString(R.string.common_google_play_services_notification_ticker);
        }
        return str;
    }

    @Nullable
    public static String zag(Context context, int i10) {
        Resources resources = context.getResources();
        switch (i10) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zai(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zai(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zai(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zai(context, "common_google_play_services_restricted_profile_title");
            default:
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Unexpected error code ");
                sb2.append(i10);
                Log.e("GoogleApiAvailability", sb2.toString());
                return null;
        }
    }

    private static String zah(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zai = zai(context, str);
        if (zai == null) {
            zai = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zai, new Object[]{str2});
    }

    @Nullable
    private static String zai(Context context, String str) {
        String str2;
        String str3;
        SimpleArrayMap<String, String> simpleArrayMap = zaa;
        synchronized (simpleArrayMap) {
            try {
                Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
                if (!locale.equals(zab)) {
                    simpleArrayMap.clear();
                    zab = locale;
                }
                String str4 = simpleArrayMap.get(str);
                if (str4 != null) {
                    return str4;
                }
                Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
                if (remoteResource == null) {
                    return null;
                }
                int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    if (str.length() != 0) {
                        str3 = "Missing resource: ".concat(str);
                    } else {
                        str3 = new String("Missing resource: ");
                    }
                    Log.w("GoogleApiAvailability", str3);
                    return null;
                }
                String string = remoteResource.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    if (str.length() != 0) {
                        str2 = "Got empty resource: ".concat(str);
                    } else {
                        str2 = new String("Got empty resource: ");
                    }
                    Log.w("GoogleApiAvailability", str2);
                    return null;
                }
                simpleArrayMap.put(str, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
