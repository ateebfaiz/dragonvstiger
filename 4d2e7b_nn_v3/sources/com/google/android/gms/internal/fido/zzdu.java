package com.google.android.gms.internal.fido;

import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class zzdu implements Closeable {
    private final InputStream zza;
    private zzdt zzb;
    private final byte[] zzc = new byte[8];
    private final s0 zzd = s0.a();

    public zzdu(InputStream inputStream) {
        this.zza = inputStream;
    }

    private final long zzh() throws IOException {
        if (this.zzb.zza() < 24) {
            long zza2 = (long) this.zzb.zza();
            this.zzb = null;
            return zza2;
        } else if (this.zzb.zza() == 24) {
            int read = this.zza.read();
            if (read != -1) {
                this.zzb = null;
                return ((long) read) & 255;
            }
            throw new EOFException();
        } else if (this.zzb.zza() == 25) {
            zzk(this.zzc, 2);
            byte[] bArr = this.zzc;
            return (((long) bArr[1]) & 255) | ((((long) bArr[0]) & 255) << 8);
        } else if (this.zzb.zza() == 26) {
            zzk(this.zzc, 4);
            byte[] bArr2 = this.zzc;
            long j10 = (long) bArr2[0];
            long j11 = (long) bArr2[2];
            long j12 = (long) bArr2[3];
            return ((((long) bArr2[1]) & 255) << 16) | ((j10 & 255) << 24) | ((j11 & 255) << 8) | (j12 & 255);
        } else if (this.zzb.zza() == 27) {
            zzk(this.zzc, 8);
            byte[] bArr3 = this.zzc;
            long j13 = (long) bArr3[0];
            long j14 = (long) bArr3[2];
            long j15 = (long) bArr3[3];
            long j16 = (long) bArr3[4];
            long j17 = (long) bArr3[5];
            long j18 = (long) bArr3[6];
            long j19 = (long) bArr3[7];
            return (j19 & 255) | ((((long) bArr3[1]) & 255) << 48) | ((j13 & 255) << 56) | ((j14 & 255) << 40) | ((j15 & 255) << 32) | ((j16 & 255) << 24) | ((j17 & 255) << 16) | ((j18 & 255) << 8);
        } else {
            throw new IOException(String.format("invalid additional information %s for major type %s", new Object[]{Byte.valueOf(this.zzb.zza()), Integer.valueOf(this.zzb.zzc())}));
        }
    }

    private final void zzi() throws IOException {
        zzd();
        if (this.zzb.zza() == 31) {
            throw new IllegalStateException(String.format("expected definite length but found %s", new Object[]{Byte.valueOf(this.zzb.zza())}));
        }
    }

    private final void zzj(byte b10) throws IOException {
        zzd();
        if (this.zzb.zzb() != b10) {
            throw new IllegalStateException(String.format("expected major type %s but found %s", new Object[]{Integer.valueOf((b10 >> 5) & 7), Integer.valueOf(this.zzb.zzc())}));
        }
    }

    private final void zzk(byte[] bArr, int i10) throws IOException {
        int i11 = 0;
        while (i11 != i10) {
            int read = this.zza.read(bArr, i11, i10 - i11);
            if (read != -1) {
                i11 += read;
            } else {
                throw new EOFException();
            }
        }
        this.zzb = null;
    }

    private final byte[] zzl() throws IOException {
        zzi();
        long zzh = zzh();
        if (zzh < 0 || zzh > 2147483647L) {
            throw new UnsupportedOperationException(String.format("the maximum supported byte/text string length is %s bytes", new Object[]{Integer.MAX_VALUE}));
        } else if (((long) this.zza.available()) >= zzh) {
            int i10 = (int) zzh;
            byte[] bArr = new byte[i10];
            zzk(bArr, i10);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public final void close() throws IOException {
        this.zza.close();
        this.zzd.b();
    }

    public final long zza() throws IOException {
        zzj(Byte.MIN_VALUE);
        zzi();
        long zzh = zzh();
        int i10 = (zzh > 0 ? 1 : (zzh == 0 ? 0 : -1));
        if (i10 >= 0) {
            if (i10 > 0) {
                this.zzd.g(zzh);
            }
            return zzh;
        }
        throw new UnsupportedOperationException(String.format("the maximum supported array length is %s", new Object[]{Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL)}));
    }

    public final long zzb() throws IOException {
        boolean z10;
        zzd();
        if (this.zzb.zzb() == 0) {
            z10 = true;
        } else if (this.zzb.zzb() == 32) {
            z10 = false;
        } else {
            throw new IllegalStateException(String.format("expected major type 0 or 1 but found %s", new Object[]{Integer.valueOf(this.zzb.zzc())}));
        }
        long zzh = zzh();
        if (zzh < 0) {
            throw new UnsupportedOperationException(String.format("the maximum supported unsigned/negative integer is %s", new Object[]{Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL)}));
        } else if (z10) {
            return zzh;
        } else {
            return ~zzh;
        }
    }

    public final long zzc() throws IOException {
        zzj((byte) -96);
        zzi();
        long zzh = zzh();
        int i10 = (zzh > 0 ? 1 : (zzh == 0 ? 0 : -1));
        if (i10 < 0 || zzh > 4611686018427387903L) {
            throw new UnsupportedOperationException("the maximum supported map length is 4611686018427387903L");
        }
        if (i10 > 0) {
            this.zzd.g(zzh + zzh);
        }
        return zzh;
    }

    public final zzdt zzd() throws IOException {
        if (this.zzb == null) {
            int read = this.zza.read();
            if (read == -1) {
                this.zzd.b();
                return null;
            }
            zzdt zzdt = new zzdt(read);
            this.zzb = zzdt;
            byte zzb2 = zzdt.zzb();
            if (!(zzb2 == Byte.MIN_VALUE || zzb2 == -96 || zzb2 == -64)) {
                if (zzb2 != -32) {
                    if (!(zzb2 == 0 || zzb2 == 32)) {
                        if (zzb2 == 64) {
                            this.zzd.e(-1);
                        } else if (zzb2 == 96) {
                            this.zzd.e(-2);
                        } else {
                            throw new IllegalStateException(String.format("invalid major type: %s", new Object[]{Integer.valueOf(this.zzb.zzc())}));
                        }
                        this.zzd.f();
                    }
                } else if (this.zzb.zza() == 31) {
                    this.zzd.c();
                }
            }
            this.zzd.d();
            this.zzd.f();
        }
        return this.zzb;
    }

    public final String zze() throws IOException {
        zzj((byte) 96);
        return new String(zzl(), StandardCharsets.UTF_8);
    }

    public final boolean zzf() throws IOException {
        zzj((byte) -32);
        if (this.zzb.zza() <= 24) {
            int zzh = (int) zzh();
            if (zzh == 20) {
                return false;
            }
            if (zzh == 21) {
                return true;
            }
            throw new IllegalStateException(String.format("expected FALSE or TRUE", new Object[0]));
        }
        throw new IllegalStateException("expected simple value");
    }

    public final byte[] zzg() throws IOException {
        zzj((byte) 64);
        return zzl();
    }
}
