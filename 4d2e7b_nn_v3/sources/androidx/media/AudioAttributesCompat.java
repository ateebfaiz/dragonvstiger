package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AudioAttributesCompat implements VersionedParcelable {
    static final String AUDIO_ATTRIBUTES_CONTENT_TYPE = "androidx.media.audio_attrs.CONTENT_TYPE";
    static final String AUDIO_ATTRIBUTES_FLAGS = "androidx.media.audio_attrs.FLAGS";
    static final String AUDIO_ATTRIBUTES_FRAMEWORKS = "androidx.media.audio_attrs.FRAMEWORKS";
    static final String AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE = "androidx.media.audio_attrs.LEGACY_STREAM_TYPE";
    static final String AUDIO_ATTRIBUTES_USAGE = "androidx.media.audio_attrs.USAGE";
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    static final int FLAG_ALL = 1023;
    static final int FLAG_ALL_PUBLIC = 273;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    static final int FLAG_BEACON = 8;
    static final int FLAG_BYPASS_INTERRUPTION_POLICY = 64;
    static final int FLAG_BYPASS_MUTE = 128;
    static final int FLAG_DEEP_BUFFER = 512;
    public static final int FLAG_HW_AV_SYNC = 16;
    static final int FLAG_HW_HOTWORD = 32;
    static final int FLAG_LOW_LATENCY = 256;
    static final int FLAG_SCO = 4;
    static final int FLAG_SECURE = 2;
    static final int INVALID_STREAM_TYPE = -1;
    private static final int[] SDK_USAGES = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    private static final int SUPPRESSIBLE_CALL = 2;
    private static final int SUPPRESSIBLE_NOTIFICATION = 1;
    private static final SparseIntArray SUPPRESSIBLE_USAGES;
    private static final String TAG = "AudioAttributesCompat";
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    private static final int USAGE_VIRTUAL_SOURCE = 15;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    static boolean sForceLegacyBehavior;
    AudioAttributesImpl mImpl;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeContentType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeUsage {
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        SUPPRESSIBLE_USAGES = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    AudioAttributesCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static AudioAttributesCompat fromBundle(Bundle bundle) {
        AudioAttributesImpl b10 = AudioAttributesImplApi21.b(bundle);
        if (b10 == null) {
            return null;
        }
        return new AudioAttributesCompat(b10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setForceLegacyBehavior(boolean z10) {
        sForceLegacyBehavior = z10;
    }

    static int toVolumeStreamType(boolean z10, AudioAttributesCompat audioAttributesCompat) {
        return toVolumeStreamType(z10, audioAttributesCompat.getFlags(), audioAttributesCompat.getUsage());
    }

    static int usageForStreamType(int i10) {
        switch (i10) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 10:
                return 11;
            default:
                return 0;
        }
    }

    static String usageToString(int i10) {
        switch (i10) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 16:
                return "USAGE_ASSISTANT";
            default:
                return "unknown usage " + i10;
        }
    }

    @Nullable
    public static AudioAttributesCompat wrap(@NonNull Object obj) {
        if (sForceLegacyBehavior) {
            return null;
        }
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21((AudioAttributes) obj);
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.mImpl = audioAttributesImplApi21;
        return audioAttributesCompat;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.mImpl;
        if (audioAttributesImpl != null) {
            return audioAttributesImpl.equals(audioAttributesCompat.mImpl);
        }
        if (audioAttributesCompat.mImpl == null) {
            return true;
        }
        return false;
    }

    public int getContentType() {
        return this.mImpl.getContentType();
    }

    public int getFlags() {
        return this.mImpl.getFlags();
    }

    public int getLegacyStreamType() {
        return this.mImpl.getLegacyStreamType();
    }

    /* access modifiers changed from: package-private */
    public int getRawLegacyStreamType() {
        return this.mImpl.getRawLegacyStreamType();
    }

    public int getUsage() {
        return this.mImpl.getUsage();
    }

    public int getVolumeControlStream() {
        return this.mImpl.getVolumeControlStream();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Bundle toBundle() {
        return this.mImpl.toBundle();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.a();
    }

    AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.mImpl = audioAttributesImpl;
    }

    static int toVolumeStreamType(boolean z10, int i10, int i11) {
        if ((i10 & 1) == 1) {
            return z10 ? 1 : 7;
        }
        if ((i10 & 4) == 4) {
            return z10 ? 0 : 6;
        }
        switch (i11) {
            case 0:
                return z10 ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z10 ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            default:
                if (!z10) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i11 + " in audio attributes");
        }
    }

    public static class Builder {
        private int mContentType = 0;
        private int mFlags = 0;
        private int mLegacyStream = -1;
        private int mUsage = 0;

        public Builder() {
        }

        public AudioAttributesCompat build() {
            AudioAttributesImpl audioAttributesImpl;
            if (!AudioAttributesCompat.sForceLegacyBehavior) {
                AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.mContentType).setFlags(this.mFlags).setUsage(this.mUsage);
                int i10 = this.mLegacyStream;
                if (i10 != -1) {
                    usage.setLegacyStreamType(i10);
                }
                audioAttributesImpl = new AudioAttributesImplApi21(usage.build(), this.mLegacyStream);
            } else {
                audioAttributesImpl = new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream);
            }
            return new AudioAttributesCompat(audioAttributesImpl);
        }

        public Builder setContentType(int i10) {
            if (i10 == 0 || i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
                this.mContentType = i10;
            } else {
                this.mUsage = 0;
            }
            return this;
        }

        public Builder setFlags(int i10) {
            this.mFlags = (i10 & AudioAttributesCompat.FLAG_ALL) | this.mFlags;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setInternalLegacyStreamType(int i10) {
            switch (i10) {
                case 0:
                    this.mContentType = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.mContentType = 4;
                    break;
                case 3:
                    this.mContentType = 2;
                    break;
                case 4:
                    this.mContentType = 4;
                    break;
                case 5:
                    this.mContentType = 4;
                    break;
                case 6:
                    this.mContentType = 1;
                    this.mFlags |= 4;
                    break;
                case 7:
                    this.mFlags = 1 | this.mFlags;
                    break;
                case 8:
                    this.mContentType = 4;
                    break;
                case 9:
                    this.mContentType = 4;
                    break;
                case 10:
                    this.mContentType = 1;
                    break;
                default:
                    Log.e(AudioAttributesCompat.TAG, "Invalid stream type " + i10 + " for AudioAttributesCompat");
                    break;
            }
            this.mContentType = 4;
            this.mUsage = AudioAttributesCompat.usageForStreamType(i10);
            return this;
        }

        public Builder setLegacyStreamType(int i10) {
            if (i10 != 10) {
                this.mLegacyStream = i10;
                return setInternalLegacyStreamType(i10);
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }

        public Builder setUsage(int i10) {
            switch (i10) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.mUsage = i10;
                    break;
                case 16:
                    if (!AudioAttributesCompat.sForceLegacyBehavior && Build.VERSION.SDK_INT > 25) {
                        this.mUsage = i10;
                        break;
                    } else {
                        this.mUsage = 12;
                        break;
                    }
                default:
                    this.mUsage = 0;
                    break;
            }
            return this;
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            this.mUsage = audioAttributesCompat.getUsage();
            this.mContentType = audioAttributesCompat.getContentType();
            this.mFlags = audioAttributesCompat.getFlags();
            this.mLegacyStream = audioAttributesCompat.getRawLegacyStreamType();
        }
    }
}
