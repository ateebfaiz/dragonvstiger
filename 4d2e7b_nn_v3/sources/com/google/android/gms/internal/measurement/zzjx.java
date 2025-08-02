package com.google.android.gms.internal.measurement;

public enum zzjx {
    DOUBLE(0, 1, r7),
    FLOAT(1, 1, r15),
    INT64(2, 1, r5),
    UINT64(3, 1, r5),
    INT32(4, 1, r12),
    FIXED64(5, 1, r5),
    FIXED32(6, 1, r12),
    BOOL(7, 1, r24),
    STRING(8, 1, r18),
    MESSAGE(9, 1, r20),
    BYTES(10, 1, r22),
    UINT32(11, 1, r5),
    ENUM(12, 1, r33),
    SFIXED32(13, 1, r5),
    SFIXED64(14, 1, r9),
    SINT32(15, 1, r12),
    SINT64(16, 1, r9),
    GROUP(17, 1, r20),
    DOUBLE_LIST(18, 2, r7),
    FLOAT_LIST(19, 2, r15),
    INT64_LIST(20, 2, r5),
    UINT64_LIST(21, 2, r5),
    INT32_LIST(22, 2, r12),
    FIXED64_LIST(23, 2, r9),
    FIXED32_LIST(24, 2, r12),
    BOOL_LIST(25, 2, r24),
    STRING_LIST(26, 2, r18),
    MESSAGE_LIST(27, 2, r20),
    BYTES_LIST(28, 2, r22),
    UINT32_LIST(29, 2, r12),
    ENUM_LIST(30, 2, r33),
    SFIXED32_LIST(31, 2, r12),
    SFIXED64_LIST(32, 2, r9),
    SINT32_LIST(33, 2, r12),
    SINT64_LIST(34, 2, r9),
    DOUBLE_LIST_PACKED(35, 3, r7),
    FLOAT_LIST_PACKED(36, 3, r15),
    INT64_LIST_PACKED(37, 3, r5),
    UINT64_LIST_PACKED(38, 3, r5),
    INT32_LIST_PACKED(39, 3, r12),
    FIXED64_LIST_PACKED(40, 3, r9),
    FIXED32_LIST_PACKED(41, 3, r12),
    BOOL_LIST_PACKED(42, 3, r24),
    UINT32_LIST_PACKED(43, 3, r12),
    ENUM_LIST_PACKED(44, 3, r33),
    SFIXED32_LIST_PACKED(45, 3, r12),
    SFIXED64_LIST_PACKED(46, 3, r9),
    SINT32_LIST_PACKED(47, 3, r12),
    SINT64_LIST_PACKED(48, 3, r9),
    GROUP_LIST(49, 2, r20),
    MAP(50, 4, zzkq.VOID);
    
    private static final zzjx[] zzZ = null;
    private final zzkq zzab;
    private final int zzac;
    private final Class zzad;

    static {
        int i10;
        zzZ = new zzjx[r1];
        for (zzjx zzjx : values()) {
            zzZ[zzjx.zzac] = zzjx;
        }
    }

    private zzjx(int i10, int i11, zzkq zzkq) {
        this.zzac = i10;
        this.zzab = zzkq;
        zzkq zzkq2 = zzkq.VOID;
        int i12 = i11 - 1;
        if (i12 == 1) {
            this.zzad = zzkq.zza();
        } else if (i12 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzkq.zza();
        }
        if (i11 == 1) {
            zzkq.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
