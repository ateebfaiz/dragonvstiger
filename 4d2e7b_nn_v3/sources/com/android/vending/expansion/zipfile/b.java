package com.android.vending.expansion.zipfile;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.games.paddleboat.GameControllerManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f18330a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public HashMap f18331b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    ByteBuffer f18332c = ByteBuffer.allocate(4);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final File f18333a;

        /* renamed from: b  reason: collision with root package name */
        public final String f18334b;

        /* renamed from: c  reason: collision with root package name */
        public final String f18335c;

        /* renamed from: d  reason: collision with root package name */
        public long f18336d;

        /* renamed from: e  reason: collision with root package name */
        public int f18337e;

        /* renamed from: f  reason: collision with root package name */
        public long f18338f;

        /* renamed from: g  reason: collision with root package name */
        public long f18339g;

        /* renamed from: h  reason: collision with root package name */
        public long f18340h;

        /* renamed from: i  reason: collision with root package name */
        public long f18341i;

        /* renamed from: j  reason: collision with root package name */
        public long f18342j = -1;

        public a(String str, File file, String str2) {
            this.f18334b = str2;
            this.f18335c = str;
            this.f18333a = file;
        }

        public AssetFileDescriptor a() {
            if (this.f18337e != 0) {
                return null;
            }
            try {
                return new AssetFileDescriptor(ParcelFileDescriptor.open(this.f18333a, GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR), b(), this.f18341i);
            } catch (FileNotFoundException e10) {
                e10.printStackTrace();
                return null;
            }
        }

        public long b() {
            return this.f18342j;
        }

        public String c() {
            return this.f18335c;
        }

        public void d(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer) {
            long j10 = this.f18336d;
            try {
                randomAccessFile.seek(j10);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) == 67324752) {
                    this.f18342j = j10 + 30 + ((long) (byteBuffer.getShort(26) & com.alibaba.pdns.net.f.a.f18108a)) + ((long) (byteBuffer.getShort(28) & com.alibaba.pdns.net.f.a.f18108a));
                    return;
                }
                Log.w("zipro", "didn't find signature at start of lfh");
                throw new IOException();
            } catch (FileNotFoundException e10) {
                e10.printStackTrace();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
    }

    public b(String str) {
        a(str);
    }

    private static int d(RandomAccessFile randomAccessFile) {
        return e(randomAccessFile.readInt());
    }

    private static int e(int i10) {
        return ((i10 & 255) << 24) + ((65280 & i10) << 8) + ((16711680 & i10) >>> 8) + ((i10 >>> 24) & 255);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        String str2 = str;
        File file = new File(str2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = randomAccessFile.length();
        if (length >= 22) {
            long j10 = 65557;
            if (65557 > length) {
                j10 = length;
            }
            randomAccessFile.seek(0);
            int d10 = d(randomAccessFile);
            if (d10 == 101010256) {
                Log.i("zipro", "Found Zip archive, but it looks empty");
                throw new IOException();
            } else if (d10 == 67324752) {
                randomAccessFile.seek(length - j10);
                ByteBuffer allocate = ByteBuffer.allocate((int) j10);
                byte[] array = allocate.array();
                randomAccessFile.readFully(array);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                int length2 = array.length - 22;
                while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != 101010256)) {
                    length2--;
                }
                if (length2 < 0) {
                    Log.d("zipro", "Zip: EOCD not found, " + str2 + " is not zip");
                }
                short s10 = allocate.getShort(length2 + 8);
                long j11 = ((long) allocate.getInt(length2 + 12)) & 4294967295L;
                long j12 = ((long) allocate.getInt(length2 + 16)) & 4294967295L;
                if (j12 + j11 > length) {
                    Log.w("zipro", "bad offsets (dir " + j12 + ", size " + j11 + ", eocd " + length2 + ")");
                    throw new IOException();
                } else if (s10 != 0) {
                    MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, j12, j11);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    short s11 = com.alibaba.pdns.net.f.a.f18108a;
                    byte[] bArr = new byte[65535];
                    ByteBuffer allocate2 = ByteBuffer.allocate(30);
                    allocate2.order(byteOrder);
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < s10) {
                        if (map.getInt(i12) == 33639248) {
                            short s12 = map.getShort(i12 + 28) & s11;
                            short s13 = map.getShort(i12 + 30) & s11;
                            short s14 = map.getShort(i12 + 32) & s11;
                            map.position(i12 + 46);
                            map.get(bArr, i10, s12);
                            map.position(i10);
                            String str3 = new String(bArr, i10, s12);
                            a aVar = new a(str2, file, str3);
                            aVar.f18337e = map.getShort(i12 + 10) & com.alibaba.pdns.net.f.a.f18108a;
                            aVar.f18338f = ((long) map.getInt(i12 + 12)) & 4294967295L;
                            aVar.f18339g = map.getLong(i12 + 16) & 4294967295L;
                            aVar.f18340h = map.getLong(i12 + 20) & 4294967295L;
                            aVar.f18341i = map.getLong(i12 + 24) & 4294967295L;
                            aVar.f18336d = ((long) map.getInt(i12 + 42)) & 4294967295L;
                            allocate2.clear();
                            aVar.d(randomAccessFile, allocate2);
                            this.f18330a.put(str3, aVar);
                            i12 += s12 + 46 + s13 + s14;
                            i11++;
                            str2 = str;
                            s11 = 65535;
                            file = file;
                            i10 = 0;
                        } else {
                            Log.w("zipro", "Missed a central dir sig (at " + i12 + ")");
                            throw new IOException();
                        }
                    }
                } else {
                    Log.w("zipro", "empty archive?");
                    throw new IOException();
                }
            } else {
                Log.v("zipro", "Not a Zip archive");
                throw new IOException();
            }
        } else {
            throw new IOException();
        }
    }

    public a[] b() {
        Collection values = this.f18330a.values();
        return (a[]) values.toArray(new a[values.size()]);
    }

    public AssetFileDescriptor c(String str) {
        a aVar = (a) this.f18330a.get(str);
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }
}
