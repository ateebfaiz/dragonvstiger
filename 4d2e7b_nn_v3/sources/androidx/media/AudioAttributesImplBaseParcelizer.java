package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f15931a = versionedParcel.readInt(audioAttributesImplBase.f15931a, 1);
        audioAttributesImplBase.f15932b = versionedParcel.readInt(audioAttributesImplBase.f15932b, 2);
        audioAttributesImplBase.f15933c = versionedParcel.readInt(audioAttributesImplBase.f15933c, 3);
        audioAttributesImplBase.f15934d = versionedParcel.readInt(audioAttributesImplBase.f15934d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(audioAttributesImplBase.f15931a, 1);
        versionedParcel.writeInt(audioAttributesImplBase.f15932b, 2);
        versionedParcel.writeInt(audioAttributesImplBase.f15933c, 3);
        versionedParcel.writeInt(audioAttributesImplBase.f15934d, 4);
    }
}
