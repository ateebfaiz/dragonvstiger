package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.PendingIntentCompat;

public class PendingIntentActivityWrapper {
    private final Context mContext;
    private final int mFlags;
    @NonNull
    private final Intent mIntent;
    private final boolean mIsMutable;
    @Nullable
    private final Bundle mOptions;
    @Nullable
    private final PendingIntent mPendingIntent;
    private final int mRequestCode;

    public PendingIntentActivityWrapper(@NonNull Context context, int i10, @NonNull Intent intent, int i11, boolean z10) {
        this(context, i10, intent, i11, (Bundle) null, z10);
    }

    @Nullable
    private PendingIntent createPendingIntent() {
        Bundle bundle = this.mOptions;
        if (bundle == null) {
            return PendingIntentCompat.getActivity(this.mContext, this.mRequestCode, this.mIntent, this.mFlags, this.mIsMutable);
        }
        return PendingIntentCompat.getActivity(this.mContext, this.mRequestCode, this.mIntent, this.mFlags, bundle, this.mIsMutable);
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    public int getFlags() {
        return this.mFlags;
    }

    @NonNull
    public Intent getIntent() {
        return this.mIntent;
    }

    @NonNull
    public Bundle getOptions() {
        return this.mOptions;
    }

    @Nullable
    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public boolean isMutable() {
        return this.mIsMutable;
    }

    public PendingIntentActivityWrapper(@NonNull Context context, int i10, @NonNull Intent intent, int i11, @Nullable Bundle bundle, boolean z10) {
        this.mContext = context;
        this.mRequestCode = i10;
        this.mIntent = intent;
        this.mFlags = i11;
        this.mOptions = bundle;
        this.mIsMutable = z10;
        this.mPendingIntent = createPendingIntent();
    }
}
