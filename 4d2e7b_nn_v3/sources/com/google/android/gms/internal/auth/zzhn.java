package com.google.android.gms.internal.auth;

public enum zzhn {
    DOUBLE(zzho.DOUBLE, 1),
    FLOAT(zzho.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzho.BOOLEAN, 0),
    STRING(zzho.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(zzho.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(zzho.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzho zzt;

    private zzhn(zzho zzho, int i10) {
        this.zzt = zzho;
    }

    public final zzho zza() {
        return this.zzt;
    }
}
