package androidx.media;

import android.os.Bundle;
import androidx.versionedparcelable.VersionedParcelable;

interface AudioAttributesImpl extends VersionedParcelable {
    Object a();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();

    Bundle toBundle();
}
