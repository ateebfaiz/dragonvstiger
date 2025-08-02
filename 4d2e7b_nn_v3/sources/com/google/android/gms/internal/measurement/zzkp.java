package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzkp extends IOException {
    public zzkp(String str) {
        super(str);
    }

    static zzko zza() {
        return new zzko("Protocol message tag had invalid wire type.");
    }

    static zzkp zzb() {
        return new zzkp("Protocol message contained an invalid tag (zero).");
    }

    static zzkp zzc() {
        return new zzkp("Protocol message had invalid UTF-8.");
    }

    static zzkp zzd() {
        return new zzkp("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzkp zze() {
        return new zzkp("Failed to parse the message.");
    }

    static zzkp zzf() {
        return new zzkp("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
