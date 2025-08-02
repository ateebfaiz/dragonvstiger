package com.google.android.gms.common.images;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Size {
    private final int zaa;
    private final int zab;

    public Size(int i10, int i11) {
        this.zaa = i10;
        this.zab = i11;
    }

    @NonNull
    public static Size parseSize(@NonNull String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw zaa(str);
                }
            } else {
                throw zaa(str);
            }
        } else {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    private static NumberFormatException zaa(String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 16);
        sb2.append("Invalid Size: \"");
        sb2.append(str);
        sb2.append("\"");
        throw new NumberFormatException(sb2.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.zaa == size.zaa && this.zab == size.zab) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int getHeight() {
        return this.zab;
    }

    public int getWidth() {
        return this.zaa;
    }

    public int hashCode() {
        int i10 = this.zab;
        int i11 = this.zaa;
        return i10 ^ ((i11 >>> 16) | (i11 << 16));
    }

    @NonNull
    public String toString() {
        int i10 = this.zaa;
        int i11 = this.zab;
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append(i10);
        sb2.append("x");
        sb2.append(i11);
        return sb2.toString();
    }
}
