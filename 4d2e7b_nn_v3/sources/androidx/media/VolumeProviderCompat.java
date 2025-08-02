package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    class a implements VolumeProviderCompatApi21.Delegate {
        a() {
        }

        public void onAdjustVolume(int i10) {
            VolumeProviderCompat.this.onAdjustVolume(i10);
        }

        public void onSetVolumeTo(int i10) {
            VolumeProviderCompat.this.onSetVolumeTo(i10);
        }
    }

    public VolumeProviderCompat(int i10, int i11, int i12) {
        this.mControlType = i10;
        this.mMaxVolume = i11;
        this.mCurrentVolume = i12;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderObj == null) {
            this.mVolumeProviderObj = VolumeProviderCompatApi21.a(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new a());
        }
        return this.mVolumeProviderObj;
    }

    public void onAdjustVolume(int i10) {
    }

    public void onSetVolumeTo(int i10) {
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public final void setCurrentVolume(int i10) {
        this.mCurrentVolume = i10;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null) {
            VolumeProviderCompatApi21.b(volumeProvider, i10);
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }
}
