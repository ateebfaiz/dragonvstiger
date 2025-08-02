package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzio<MessageType extends zzio<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>> implements zzlm {
    protected int zzb = 0;

    protected static void zzbt(Iterable iterable, List list) {
        zzkn.zze(iterable);
        if (iterable instanceof zzku) {
            List zzh = ((zzku) iterable).zzh();
            zzku zzku = (zzku) list;
            int size = list.size();
            for (Object next : zzh) {
                if (next == null) {
                    int size2 = zzku.size();
                    String str = "Element at index " + (size2 - size) + " is null.";
                    int size3 = zzku.size();
                    while (true) {
                        size3--;
                        if (size3 >= size) {
                            zzku.remove(size3);
                        } else {
                            throw new NullPointerException(str);
                        }
                    }
                } else if (next instanceof zzje) {
                    zzku.zzi((zzje) next);
                } else {
                    zzku.add((String) next);
                }
            }
        } else if (!(iterable instanceof s3)) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size4 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    int size5 = list.size();
                    String str2 = "Element at index " + (size5 - size4) + " is null.";
                    int size6 = list.size();
                    while (true) {
                        size6--;
                        if (size6 >= size4) {
                            list.remove(size6);
                        } else {
                            throw new NullPointerException(str2);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzbr(w3 w3Var) {
        throw null;
    }

    public final zzje zzbs() {
        try {
            int zzbw = zzbw();
            zzje zzje = zzje.zzb;
            byte[] bArr = new byte[zzbw];
            zzjm zzC = zzjm.zzC(bArr);
            zzbN(zzC);
            zzC.zzD();
            return new p2(bArr);
        } catch (IOException e10) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e10);
        }
    }

    public final byte[] zzbu() {
        try {
            byte[] bArr = new byte[zzbw()];
            zzjm zzC = zzjm.zzC(bArr);
            zzbN(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e10) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e10);
        }
    }
}
