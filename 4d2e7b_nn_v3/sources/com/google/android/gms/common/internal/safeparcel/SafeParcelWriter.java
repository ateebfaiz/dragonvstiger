package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(@NonNull Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void finishObjectHeader(@NonNull Parcel parcel, int i10) {
        zzb(parcel, i10);
    }

    public static void writeBigDecimal(@NonNull Parcel parcel, int i10, @NonNull BigDecimal bigDecimal, boolean z10) {
        if (bigDecimal != null) {
            int zza = zza(parcel, i10);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeBigDecimalArray(@NonNull Parcel parcel, int i10, @NonNull BigDecimal[] bigDecimalArr, boolean z10) {
        if (bigDecimalArr != null) {
            int zza = zza(parcel, i10);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i11 = 0; i11 < length; i11++) {
                parcel.writeByteArray(bigDecimalArr[i11].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i11].scale());
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeBigInteger(@NonNull Parcel parcel, int i10, @NonNull BigInteger bigInteger, boolean z10) {
        if (bigInteger != null) {
            int zza = zza(parcel, i10);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeBigIntegerArray(@NonNull Parcel parcel, int i10, @NonNull BigInteger[] bigIntegerArr, boolean z10) {
        if (bigIntegerArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeInt(r5);
            for (BigInteger byteArray : bigIntegerArr) {
                parcel.writeByteArray(byteArray.toByteArray());
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeBoolean(@NonNull Parcel parcel, int i10, boolean z10) {
        zzc(parcel, i10, 4);
        parcel.writeInt(z10 ? 1 : 0);
    }

    public static void writeBooleanArray(@NonNull Parcel parcel, int i10, @NonNull boolean[] zArr, boolean z10) {
        if (zArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeBooleanList(@NonNull Parcel parcel, int i10, @NonNull List<Boolean> list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(list.get(i11).booleanValue() ? 1 : 0);
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeBooleanObject(@NonNull Parcel parcel, int i10, @NonNull Boolean bool, boolean z10) {
        if (bool != null) {
            zzc(parcel, i10, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeBundle(@NonNull Parcel parcel, int i10, @NonNull Bundle bundle, boolean z10) {
        if (bundle != null) {
            int zza = zza(parcel, i10);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeByte(@NonNull Parcel parcel, int i10, byte b10) {
        zzc(parcel, i10, 4);
        parcel.writeInt(b10);
    }

    public static void writeByteArray(@NonNull Parcel parcel, int i10, @NonNull byte[] bArr, boolean z10) {
        if (bArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeByteArrayArray(@NonNull Parcel parcel, int i10, @NonNull byte[][] bArr, boolean z10) {
        if (bArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeInt(r5);
            for (byte[] writeByteArray : bArr) {
                parcel.writeByteArray(writeByteArray);
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeByteArraySparseArray(@NonNull Parcel parcel, int i10, @NonNull SparseArray<byte[]> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int zza = zza(parcel, i10);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(sparseArray.keyAt(i11));
                parcel.writeByteArray(sparseArray.valueAt(i11));
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeChar(@NonNull Parcel parcel, int i10, char c10) {
        zzc(parcel, i10, 4);
        parcel.writeInt(c10);
    }

    public static void writeCharArray(@NonNull Parcel parcel, int i10, @NonNull char[] cArr, boolean z10) {
        if (cArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeCharArray(cArr);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeDouble(@NonNull Parcel parcel, int i10, double d10) {
        zzc(parcel, i10, 8);
        parcel.writeDouble(d10);
    }

    public static void writeDoubleArray(@NonNull Parcel parcel, int i10, @NonNull double[] dArr, boolean z10) {
        if (dArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeDoubleArray(dArr);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeDoubleList(@NonNull Parcel parcel, int i10, @NonNull List<Double> list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeDouble(list.get(i11).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeDoubleObject(@NonNull Parcel parcel, int i10, @NonNull Double d10, boolean z10) {
        if (d10 != null) {
            zzc(parcel, i10, 8);
            parcel.writeDouble(d10.doubleValue());
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeDoubleSparseArray(@NonNull Parcel parcel, int i10, @NonNull SparseArray<Double> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int zza = zza(parcel, i10);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(sparseArray.keyAt(i11));
                parcel.writeDouble(sparseArray.valueAt(i11).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeFloat(@NonNull Parcel parcel, int i10, float f10) {
        zzc(parcel, i10, 4);
        parcel.writeFloat(f10);
    }

    public static void writeFloatArray(@NonNull Parcel parcel, int i10, @NonNull float[] fArr, boolean z10) {
        if (fArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeFloatArray(fArr);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeFloatList(@NonNull Parcel parcel, int i10, @NonNull List<Float> list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeFloat(list.get(i11).floatValue());
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeFloatObject(@NonNull Parcel parcel, int i10, @NonNull Float f10, boolean z10) {
        if (f10 != null) {
            zzc(parcel, i10, 4);
            parcel.writeFloat(f10.floatValue());
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeFloatSparseArray(@NonNull Parcel parcel, int i10, @NonNull SparseArray<Float> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int zza = zza(parcel, i10);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(sparseArray.keyAt(i11));
                parcel.writeFloat(sparseArray.valueAt(i11).floatValue());
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeIBinder(@NonNull Parcel parcel, int i10, @NonNull IBinder iBinder, boolean z10) {
        if (iBinder != null) {
            int zza = zza(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeIBinderArray(@NonNull Parcel parcel, int i10, @NonNull IBinder[] iBinderArr, boolean z10) {
        if (iBinderArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeBinderArray(iBinderArr);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeIBinderList(@NonNull Parcel parcel, int i10, @NonNull List<IBinder> list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            parcel.writeBinderList(list);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeIBinderSparseArray(@NonNull Parcel parcel, int i10, @NonNull SparseArray<IBinder> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int zza = zza(parcel, i10);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(sparseArray.keyAt(i11));
                parcel.writeStrongBinder(sparseArray.valueAt(i11));
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeInt(@NonNull Parcel parcel, int i10, int i11) {
        zzc(parcel, i10, 4);
        parcel.writeInt(i11);
    }

    public static void writeIntArray(@NonNull Parcel parcel, int i10, @NonNull int[] iArr, boolean z10) {
        if (iArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeIntegerList(@NonNull Parcel parcel, int i10, @NonNull List<Integer> list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(list.get(i11).intValue());
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeIntegerObject(@NonNull Parcel parcel, int i10, @NonNull Integer num, boolean z10) {
        if (num != null) {
            zzc(parcel, i10, 4);
            parcel.writeInt(num.intValue());
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeList(@NonNull Parcel parcel, int i10, @NonNull List list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            parcel.writeList(list);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeLong(@NonNull Parcel parcel, int i10, long j10) {
        zzc(parcel, i10, 8);
        parcel.writeLong(j10);
    }

    public static void writeLongArray(@NonNull Parcel parcel, int i10, @NonNull long[] jArr, boolean z10) {
        if (jArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeLongArray(jArr);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeLongList(@NonNull Parcel parcel, int i10, @NonNull List<Long> list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeLong(list.get(i11).longValue());
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeLongObject(@NonNull Parcel parcel, int i10, @NonNull Long l10, boolean z10) {
        if (l10 != null) {
            zzc(parcel, i10, 8);
            parcel.writeLong(l10.longValue());
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeParcel(@NonNull Parcel parcel, int i10, @NonNull Parcel parcel2, boolean z10) {
        if (parcel2 != null) {
            int zza = zza(parcel, i10);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeParcelArray(@NonNull Parcel parcel, int i10, @NonNull Parcel[] parcelArr, boolean z10) {
        if (parcelArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeInt(r7);
            for (Parcel parcel2 : parcelArr) {
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeParcelList(@NonNull Parcel parcel, int i10, @NonNull List<Parcel> list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                Parcel parcel2 = list.get(i11);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeParcelSparseArray(@NonNull Parcel parcel, int i10, @NonNull SparseArray<Parcel> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int zza = zza(parcel, i10);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(sparseArray.keyAt(i11));
                Parcel valueAt = sparseArray.valueAt(i11);
                if (valueAt != null) {
                    parcel.writeInt(valueAt.dataSize());
                    parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeParcelable(@NonNull Parcel parcel, int i10, @NonNull Parcelable parcelable, int i11, boolean z10) {
        if (parcelable != null) {
            int zza = zza(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writePendingIntent(@NonNull Parcel parcel, int i10, @NonNull PendingIntent pendingIntent, boolean z10) {
        if (pendingIntent != null) {
            int zza = zza(parcel, i10);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeShort(@NonNull Parcel parcel, int i10, short s10) {
        zzc(parcel, i10, 4);
        parcel.writeInt(s10);
    }

    public static void writeSparseBooleanArray(@NonNull Parcel parcel, int i10, @NonNull SparseBooleanArray sparseBooleanArray, boolean z10) {
        if (sparseBooleanArray != null) {
            int zza = zza(parcel, i10);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeSparseIntArray(@NonNull Parcel parcel, int i10, @NonNull SparseIntArray sparseIntArray, boolean z10) {
        if (sparseIntArray != null) {
            int zza = zza(parcel, i10);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(sparseIntArray.keyAt(i11));
                parcel.writeInt(sparseIntArray.valueAt(i11));
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeSparseLongArray(@NonNull Parcel parcel, int i10, @NonNull SparseLongArray sparseLongArray, boolean z10) {
        if (sparseLongArray != null) {
            int zza = zza(parcel, i10);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(sparseLongArray.keyAt(i11));
                parcel.writeLong(sparseLongArray.valueAt(i11));
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeString(@NonNull Parcel parcel, int i10, @NonNull String str, boolean z10) {
        if (str != null) {
            int zza = zza(parcel, i10);
            parcel.writeString(str);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeStringArray(@NonNull Parcel parcel, int i10, @NonNull String[] strArr, boolean z10) {
        if (strArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeStringArray(strArr);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeStringList(@NonNull Parcel parcel, int i10, @NonNull List<String> list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static void writeStringSparseArray(@NonNull Parcel parcel, int i10, @NonNull SparseArray<String> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int zza = zza(parcel, i10);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(sparseArray.keyAt(i11));
                parcel.writeString(sparseArray.valueAt(i11));
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(@NonNull Parcel parcel, int i10, @NonNull T[] tArr, int i11, boolean z10) {
        if (tArr != null) {
            int zza = zza(parcel, i10);
            parcel.writeInt(r7);
            for (T t10 : tArr) {
                if (t10 == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, t10, i11);
                }
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(@NonNull Parcel parcel, int i10, @NonNull List<T> list, boolean z10) {
        if (list != null) {
            int zza = zza(parcel, i10);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                Parcelable parcelable = (Parcelable) list.get(i11);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(@NonNull Parcel parcel, int i10, @NonNull SparseArray<T> sparseArray, boolean z10) {
        if (sparseArray != null) {
            int zza = zza(parcel, i10);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(sparseArray.keyAt(i11));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i11);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z10) {
            zzc(parcel, i10, 0);
        }
    }

    private static int zza(Parcel parcel, int i10) {
        parcel.writeInt(i10 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzb(Parcel parcel, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(dataPosition - i10);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzc(Parcel parcel, int i10, int i11) {
        parcel.writeInt(i10 | (i11 << 16));
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i10);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
