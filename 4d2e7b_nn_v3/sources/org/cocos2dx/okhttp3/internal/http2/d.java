package org.cocos2dx.okhttp3.internal.http2;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.alibaba.pdns.DNSResolver;
import java.io.ByteArrayOutputStream;
import org.cocos2dx.okio.ByteString;

class d {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1694b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, DNSResolver.GOBACK_LOCAL, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 103, LocationRequestCompat.QUALITY_LOW_POWER, 105, 106, 107, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f1695c = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: d  reason: collision with root package name */
    private static final d f1696d = new d();

    /* renamed from: a  reason: collision with root package name */
    private final a f1697a = new a();

    private d() {
        b();
    }

    private void a(int i10, int i11, byte b10) {
        a aVar = new a(i10, b10);
        a aVar2 = this.f1697a;
        while (b10 > 8) {
            b10 = (byte) (b10 - 8);
            int i12 = (i11 >>> b10) & 255;
            a[] aVarArr = aVar2.f1698a;
            if (aVarArr != null) {
                if (aVarArr[i12] == null) {
                    aVarArr[i12] = new a();
                }
                aVar2 = aVar2.f1698a[i12];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i13 = 8 - b10;
        int i14 = (i11 << i13) & 255;
        int i15 = 1 << i13;
        for (int i16 = i14; i16 < i14 + i15; i16++) {
            aVar2.f1698a[i16] = aVar;
        }
    }

    private void b() {
        int i10 = 0;
        while (true) {
            byte[] bArr = f1695c;
            if (i10 < bArr.length) {
                a(i10, f1694b[i10], bArr[i10]);
                i10++;
            } else {
                return;
            }
        }
    }

    public static d f() {
        return f1696d;
    }

    /* access modifiers changed from: package-private */
    public byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = this.f1697a;
        byte b10 = 0;
        int i10 = 0;
        for (byte b11 : bArr) {
            b10 = (b10 << 8) | (b11 & 255);
            i10 += 8;
            while (i10 >= 8) {
                aVar = aVar.f1698a[(b10 >>> (i10 - 8)) & 255];
                if (aVar.f1698a == null) {
                    byteArrayOutputStream.write(aVar.f1699b);
                    i10 -= aVar.f1700c;
                    aVar = this.f1697a;
                } else {
                    i10 -= 8;
                }
            }
        }
        while (i10 > 0) {
            a aVar2 = aVar.f1698a[(b10 << (8 - i10)) & 255];
            if (aVar2.f1698a != null || aVar2.f1700c > i10) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f1699b);
            i10 -= aVar2.f1700c;
            aVar = this.f1697a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(org.cocos2dx.okio.ByteString r8, org.cocos2dx.okio.BufferedSink r9) {
        /*
            r7 = this;
            r0 = 0
            r2 = 0
            r3 = r2
        L_0x0004:
            int r4 = r8.size()
            r5 = 255(0xff, float:3.57E-43)
            if (r2 >= r4) goto L_0x002d
            byte r4 = r8.getByte(r2)
            r4 = r4 & r5
            int[] r5 = f1694b
            r5 = r5[r4]
            byte[] r6 = f1695c
            byte r4 = r6[r4]
            long r0 = r0 << r4
            long r5 = (long) r5
            long r0 = r0 | r5
            int r3 = r3 + r4
        L_0x001d:
            r4 = 8
            if (r3 < r4) goto L_0x002a
            int r3 = r3 + -8
            long r4 = r0 >> r3
            int r4 = (int) r4
            r9.writeByte(r4)
            goto L_0x001d
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x002d:
            if (r3 <= 0) goto L_0x003a
            int r8 = 8 - r3
            long r0 = r0 << r8
            int r8 = r5 >>> r3
            long r2 = (long) r8
            long r0 = r0 | r2
            int r8 = (int) r0
            r9.writeByte(r8)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.http2.d.d(org.cocos2dx.okio.ByteString, org.cocos2dx.okio.BufferedSink):void");
    }

    /* access modifiers changed from: package-private */
    public int e(ByteString byteString) {
        long j10 = 0;
        for (int i10 = 0; i10 < byteString.size(); i10++) {
            j10 += (long) f1695c[byteString.getByte(i10) & 255];
        }
        return (int) ((j10 + 7) >> 3);
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final a[] f1698a;

        /* renamed from: b  reason: collision with root package name */
        final int f1699b;

        /* renamed from: c  reason: collision with root package name */
        final int f1700c;

        a() {
            this.f1698a = new a[256];
            this.f1699b = 0;
            this.f1700c = 0;
        }

        a(int i10, int i11) {
            this.f1698a = null;
            this.f1699b = i10;
            int i12 = i11 & 7;
            this.f1700c = i12 == 0 ? 8 : i12;
        }
    }
}
