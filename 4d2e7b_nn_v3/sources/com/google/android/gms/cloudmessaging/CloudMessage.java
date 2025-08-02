package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.Constants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

@SafeParcelable.Class(creator = "CloudMessageCreator")
public final class CloudMessage extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CloudMessage> CREATOR = new zza();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @SafeParcelable.Field(id = 1)
    @NonNull
    Intent zza;
    private Map<String, String> zzb;

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    @SafeParcelable.Constructor
    public CloudMessage(@SafeParcelable.Param(id = 1) @NonNull Intent intent) {
        this.zza = intent;
    }

    private static int zza(@Nullable String str) {
        if (Constants.HIGH.equals(str)) {
            return 1;
        }
        if (Constants.NORMAL.equals(str)) {
            return 2;
        }
        return 0;
    }

    @Nullable
    public String getCollapseKey() {
        return this.zza.getStringExtra(Constants.MessagePayloadKeys.COLLAPSE_KEY);
    }

    @NonNull
    public synchronized Map<String, String> getData() {
        try {
            if (this.zzb == null) {
                Bundle extras = this.zza.getExtras();
                ArrayMap arrayMap = new ArrayMap();
                if (extras != null) {
                    for (String next : extras.keySet()) {
                        Object obj = extras.get(next);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (!next.startsWith(Constants.MessagePayloadKeys.RESERVED_PREFIX) && !next.equals(Constants.MessagePayloadKeys.FROM) && !next.equals(Constants.MessagePayloadKeys.MESSAGE_TYPE) && !next.equals(Constants.MessagePayloadKeys.COLLAPSE_KEY)) {
                                arrayMap.put(next, str);
                            }
                        }
                    }
                }
                this.zzb = arrayMap;
            }
        } finally {
        }
        return this.zzb;
    }

    @Nullable
    public String getFrom() {
        return this.zza.getStringExtra(Constants.MessagePayloadKeys.FROM);
    }

    @NonNull
    public Intent getIntent() {
        return this.zza;
    }

    @Nullable
    public String getMessageId() {
        String stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        if (stringExtra == null) {
            return this.zza.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER);
        }
        return stringExtra;
    }

    @Nullable
    public String getMessageType() {
        return this.zza.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
    }

    public int getOriginalPriority() {
        String stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.ORIGINAL_PRIORITY);
        if (stringExtra == null) {
            stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.PRIORITY_V19);
        }
        return zza(stringExtra);
    }

    public int getPriority() {
        String stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.DELIVERED_PRIORITY);
        if (stringExtra == null) {
            if ("1".equals(this.zza.getStringExtra(Constants.MessagePayloadKeys.PRIORITY_REDUCED_V19))) {
                return 2;
            }
            stringExtra = this.zza.getStringExtra(Constants.MessagePayloadKeys.PRIORITY_V19);
        }
        return zza(stringExtra);
    }

    @Nullable
    public byte[] getRawData() {
        return this.zza.getByteArrayExtra(Constants.MessagePayloadKeys.RAW_DATA);
    }

    @Nullable
    public String getSenderId() {
        return this.zza.getStringExtra(Constants.MessagePayloadKeys.SENDER_ID);
    }

    public long getSentTime() {
        Object obj;
        Bundle extras = this.zza.getExtras();
        if (extras != null) {
            obj = extras.get(Constants.MessagePayloadKeys.SENT_TIME);
        } else {
            obj = null;
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
            sb2.append("Invalid sent time: ");
            sb2.append(valueOf);
            Log.w("CloudMessage", sb2.toString());
            return 0;
        }
    }

    @Nullable
    public String getTo() {
        return this.zza.getStringExtra(Constants.MessagePayloadKeys.TO);
    }

    public int getTtl() {
        Object obj;
        Bundle extras = this.zza.getExtras();
        if (extras != null) {
            obj = extras.get(Constants.MessagePayloadKeys.TTL);
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 13);
            sb2.append("Invalid TTL: ");
            sb2.append(valueOf);
            Log.w("CloudMessage", sb2.toString());
            return 0;
        }
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
