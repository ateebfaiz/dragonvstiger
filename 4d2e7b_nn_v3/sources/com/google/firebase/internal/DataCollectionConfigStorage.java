package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

public class DataCollectionConfigStorage {
    @VisibleForTesting
    public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";
    private static final String FIREBASE_APP_PREFS = "com.google.firebase.common.prefs:";
    private boolean dataCollectionDefaultEnabled = readAutoDataCollectionEnabled();
    private final Context deviceProtectedContext;
    private final Publisher publisher;
    private final SharedPreferences sharedPreferences;

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher2) {
        Context directBootSafe = directBootSafe(context);
        this.deviceProtectedContext = directBootSafe;
        this.sharedPreferences = directBootSafe.getSharedPreferences(FIREBASE_APP_PREFS + str, 0);
        this.publisher = publisher2;
    }

    private static Context directBootSafe(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        return ContextCompat.createDeviceProtectedStorageContext(context);
    }

    private boolean readAutoDataCollectionEnabled() {
        if (this.sharedPreferences.contains(DATA_COLLECTION_DEFAULT_ENABLED)) {
            return this.sharedPreferences.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED, true);
        }
        return readManifestDataCollectionEnabled();
    }

    private boolean readManifestDataCollectionEnabled() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.deviceProtectedContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.deviceProtectedContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(DATA_COLLECTION_DEFAULT_ENABLED)) {
                return true;
            }
            return applicationInfo.metaData.getBoolean(DATA_COLLECTION_DEFAULT_ENABLED);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    private synchronized void updateDataCollectionDefaultEnabled(boolean z10) {
        if (this.dataCollectionDefaultEnabled != z10) {
            this.dataCollectionDefaultEnabled = z10;
            this.publisher.publish(new Event(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z10)));
        }
    }

    public synchronized boolean isEnabled() {
        return this.dataCollectionDefaultEnabled;
    }

    public synchronized void setEnabled(Boolean bool) {
        if (bool == null) {
            try {
                this.sharedPreferences.edit().remove(DATA_COLLECTION_DEFAULT_ENABLED).apply();
                updateDataCollectionDefaultEnabled(readManifestDataCollectionEnabled());
            } catch (Throwable th) {
                throw th;
            }
        } else {
            boolean equals = Boolean.TRUE.equals(bool);
            this.sharedPreferences.edit().putBoolean(DATA_COLLECTION_DEFAULT_ENABLED, equals).apply();
            updateDataCollectionDefaultEnabled(equals);
        }
    }
}
