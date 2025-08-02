package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: c  reason: collision with root package name */
    static Method f15928c;

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f15929a;

    /* renamed from: b  reason: collision with root package name */
    int f15930b;

    AudioAttributesImplApi21() {
        this.f15930b = -1;
    }

    public static AudioAttributesImpl b(Bundle bundle) {
        AudioAttributes audioAttributes;
        if (bundle == null || (audioAttributes = (AudioAttributes) bundle.getParcelable("androidx.media.audio_attrs.FRAMEWORKS")) == null) {
            return null;
        }
        return new AudioAttributesImplApi21(audioAttributes, bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    static Method c() {
        Class<AudioAttributes> cls = AudioAttributes.class;
        try {
            if (f15928c == null) {
                f15928c = cls.getMethod("toLegacyStreamType", new Class[]{cls});
            }
            return f15928c;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public Object a() {
        return this.f15929a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f15929a.equals(((AudioAttributesImplApi21) obj).f15929a);
    }

    public int getContentType() {
        return this.f15929a.getContentType();
    }

    public int getFlags() {
        return this.f15929a.getFlags();
    }

    public int getLegacyStreamType() {
        int i10 = this.f15930b;
        if (i10 != -1) {
            return i10;
        }
        Method c10 = c();
        if (c10 == null) {
            Log.w("AudioAttributesCompat21", "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
            return -1;
        }
        try {
            return ((Integer) c10.invoke((Object) null, new Object[]{this.f15929a})).intValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            Log.w("AudioAttributesCompat21", "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT, e10);
            return -1;
        }
    }

    public int getRawLegacyStreamType() {
        return this.f15930b;
    }

    public int getUsage() {
        return this.f15929a.getUsage();
    }

    public int getVolumeControlStream() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f15929a.getVolumeControlStream();
        }
        return AudioAttributesCompat.toVolumeStreamType(true, getFlags(), getUsage());
    }

    public int hashCode() {
        return this.f15929a.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.f15929a);
        int i10 = this.f15930b;
        if (i10 != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i10);
        }
        return bundle;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f15929a;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i10) {
        this.f15929a = audioAttributes;
        this.f15930b = i10;
    }
}
