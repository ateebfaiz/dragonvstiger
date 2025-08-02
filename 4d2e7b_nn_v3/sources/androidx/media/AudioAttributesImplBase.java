package androidx.media;

import android.os.Bundle;
import java.util.Arrays;

class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    int f15931a;

    /* renamed from: b  reason: collision with root package name */
    int f15932b;

    /* renamed from: c  reason: collision with root package name */
    int f15933c;

    /* renamed from: d  reason: collision with root package name */
    int f15934d;

    AudioAttributesImplBase() {
        this.f15931a = 0;
        this.f15932b = 0;
        this.f15933c = 0;
        this.f15934d = -1;
    }

    public Object a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f15932b == audioAttributesImplBase.getContentType() && this.f15933c == audioAttributesImplBase.getFlags() && this.f15931a == audioAttributesImplBase.getUsage() && this.f15934d == audioAttributesImplBase.f15934d) {
            return true;
        }
        return false;
    }

    public int getContentType() {
        return this.f15932b;
    }

    public int getFlags() {
        int i10 = this.f15933c;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i10 |= 4;
        } else if (legacyStreamType == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public int getLegacyStreamType() {
        int i10 = this.f15934d;
        if (i10 != -1) {
            return i10;
        }
        return AudioAttributesCompat.toVolumeStreamType(false, this.f15933c, this.f15931a);
    }

    public int getRawLegacyStreamType() {
        return this.f15934d;
    }

    public int getUsage() {
        return this.f15931a;
    }

    public int getVolumeControlStream() {
        return AudioAttributesCompat.toVolumeStreamType(true, this.f15933c, this.f15931a);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f15932b), Integer.valueOf(this.f15933c), Integer.valueOf(this.f15931a), Integer.valueOf(this.f15934d)});
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.media.audio_attrs.USAGE", this.f15931a);
        bundle.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.f15932b);
        bundle.putInt("androidx.media.audio_attrs.FLAGS", this.f15933c);
        int i10 = this.f15934d;
        if (i10 != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i10);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f15934d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f15934d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.usageToString(this.f15931a));
        sb2.append(" content=");
        sb2.append(this.f15932b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f15933c).toUpperCase());
        return sb2.toString();
    }

    AudioAttributesImplBase(int i10, int i11, int i12, int i13) {
        this.f15932b = i10;
        this.f15933c = i11;
        this.f15931a = i12;
        this.f15934d = i13;
    }
}
