package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    @ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";
    @ColorInt
    private int[] act;
    @NonNull
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    @Nullable
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    @ColorInt
    private int[] mainScratch;
    private GifHeaderParser parser;
    @ColorInt
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider2, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider2, gifHeader, byteBuffer, 1);
    }

    @ColorInt
    private int averageColorsNear(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.sampleSize + i10; i18++) {
            byte[] bArr = this.mainPixels;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.act[bArr[i18] & 255];
            if (i19 != 0) {
                i13 += (i19 >> 24) & 255;
                i14 += (i19 >> 16) & 255;
                i15 += (i19 >> 8) & 255;
                i16 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.sampleSize + i20; i21++) {
            byte[] bArr2 = this.mainPixels;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.act[bArr2[i21] & 255];
            if (i22 != 0) {
                i13 += (i22 >> 24) & 255;
                i14 += (i22 >> 16) & 255;
                i15 += (i22 >> 8) & 255;
                i16 += i22 & 255;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        boolean z10;
        boolean z11;
        int i10;
        int i11;
        boolean z12;
        int i12;
        int i13;
        int i14;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i15 = gifFrame2.ih;
        int i16 = this.sampleSize;
        int i17 = i15 / i16;
        int i18 = gifFrame2.iy / i16;
        int i19 = gifFrame2.iw / i16;
        int i20 = gifFrame2.ix / i16;
        if (this.framePointer == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i21 = this.downsampledWidth;
        int i22 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool = this.isFirstFrameTransparent;
        int i23 = 8;
        int i24 = 0;
        int i25 = 0;
        int i26 = 1;
        while (i25 < i17) {
            Boolean bool2 = bool;
            if (gifFrame2.interlace) {
                if (i24 >= i17) {
                    int i27 = i26 + 1;
                    i10 = i17;
                    if (i27 == 2) {
                        i24 = 4;
                    } else if (i27 == 3) {
                        i23 = 4;
                        i26 = i27;
                        i24 = 2;
                    } else if (i27 == 4) {
                        i26 = i27;
                        i24 = 1;
                        i23 = 2;
                    }
                    i26 = i27;
                } else {
                    i10 = i17;
                }
                i11 = i24 + i23;
            } else {
                i10 = i17;
                i11 = i24;
                i24 = i25;
            }
            int i28 = i24 + i18;
            if (i16 == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (i28 < i22) {
                int i29 = i28 * i21;
                int i30 = i29 + i20;
                int i31 = i30 + i19;
                int i32 = i29 + i21;
                if (i32 < i31) {
                    i31 = i32;
                }
                i12 = i11;
                int i33 = i25 * i16 * gifFrame2.iw;
                if (z12) {
                    int i34 = i30;
                    while (i34 < i31) {
                        int i35 = i18;
                        int i36 = iArr2[bArr[i33] & 255];
                        if (i36 != 0) {
                            iArr[i34] = i36;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i34++;
                        i18 = i35;
                    }
                } else {
                    i14 = i18;
                    int i37 = ((i31 - i30) * i16) + i33;
                    int i38 = i30;
                    while (true) {
                        i13 = i19;
                        if (i38 >= i31) {
                            break;
                        }
                        int averageColorsNear = averageColorsNear(i33, i37, gifFrame2.iw);
                        if (averageColorsNear != 0) {
                            iArr[i38] = averageColorsNear;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i38++;
                        i19 = i13;
                    }
                    bool = bool2;
                    i25++;
                    i18 = i14;
                    i17 = i10;
                    i19 = i13;
                    i24 = i12;
                }
            } else {
                i12 = i11;
            }
            i14 = i18;
            i13 = i19;
            bool = bool2;
            i25++;
            i18 = i14;
            i17 = i10;
            i19 = i13;
            i24 = i12;
        }
        Boolean bool3 = bool;
        if (this.isFirstFrameTransparent == null) {
            if (bool3 == null) {
                z11 = false;
            } else {
                z11 = bool3.booleanValue();
            }
            this.isFirstFrameTransparent = Boolean.valueOf(z11);
        }
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        boolean z10;
        boolean z11;
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i10 = gifFrame2.ih;
        int i11 = gifFrame2.iy;
        int i12 = gifFrame2.iw;
        int i13 = gifFrame2.ix;
        if (this.framePointer == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i14 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = gifFrame2.iw * i15;
            int i21 = i17;
            while (i21 < i18) {
                byte b11 = bArr[i20];
                int i22 = i10;
                byte b12 = b11 & 255;
                if (b12 != b10) {
                    int i23 = iArr2[b12];
                    if (i23 != 0) {
                        iArr[i21] = i23;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
                i21++;
                GifFrame gifFrame3 = gifFrame;
                i10 = i22;
            }
            int i24 = i10;
            i15++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.isFirstFrameTransparent;
        if ((bool == null || !bool.booleanValue()) && (this.isFirstFrameTransparent != null || !z10 || b10 == -1)) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.isFirstFrameTransparent = Boolean.valueOf(z11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.rawData
            int r3 = r1.bufferFrameStart
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0017
            com.bumptech.glide.gifdecoder.GifHeader r1 = r0.header
            int r2 = r1.width
            int r1 = r1.height
        L_0x0015:
            int r2 = r2 * r1
            goto L_0x001c
        L_0x0017:
            int r2 = r1.iw
            int r1 = r1.ih
            goto L_0x0015
        L_0x001c:
            byte[] r1 = r0.mainPixels
            if (r1 == 0) goto L_0x0023
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002b
        L_0x0023:
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r1 = r0.bitmapProvider
            byte[] r1 = r1.obtainByteArray(r2)
            r0.mainPixels = r1
        L_0x002b:
            byte[] r1 = r0.mainPixels
            short[] r3 = r0.prefix
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0037
            short[] r3 = new short[r4]
            r0.prefix = r3
        L_0x0037:
            short[] r3 = r0.prefix
            byte[] r5 = r0.suffix
            if (r5 != 0) goto L_0x0041
            byte[] r5 = new byte[r4]
            r0.suffix = r5
        L_0x0041:
            byte[] r5 = r0.suffix
            byte[] r6 = r0.pixelStack
            if (r6 != 0) goto L_0x004d
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.pixelStack = r6
        L_0x004d:
            byte[] r6 = r0.pixelStack
            int r7 = r28.readByte()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = r13
        L_0x0060:
            if (r14 >= r9) goto L_0x006a
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0060
        L_0x006a:
            byte[] r14 = r0.block
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r25 = r20
            r26 = r25
            r24 = r15
        L_0x0083:
            if (r13 >= r2) goto L_0x0090
            if (r16 != 0) goto L_0x0097
            int r16 = r28.readBlock()
            if (r16 > 0) goto L_0x0095
            r3 = 3
            r0.status = r3
        L_0x0090:
            r13 = r20
            r0 = 0
            goto L_0x014f
        L_0x0095:
            r17 = 0
        L_0x0097:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00b1:
            if (r4 < r15) goto L_0x0139
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c5
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00b1
        L_0x00c5:
            if (r11 != r10) goto L_0x00dc
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0083
        L_0x00dc:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00f0
            byte r0 = r5[r11]
            r1[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00b1
        L_0x00f0:
            if (r11 < r8) goto L_0x00f9
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00fa
        L_0x00f9:
            r7 = r11
        L_0x00fa:
            if (r7 < r9) goto L_0x0105
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00fa
        L_0x0105:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x010c:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x0119
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r1[r20] = r27
            goto L_0x010c
        L_0x0119:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x0130
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x0130
            if (r8 >= r6) goto L_0x0130
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x0130:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00b1
        L_0x0139:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0083
        L_0x014f:
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame):void");
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Bitmap.Config config;
        Boolean bool = this.isFirstFrameTransparent;
        if (bool == null || bool.booleanValue()) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = this.bitmapConfig;
        }
        Bitmap obtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, config);
        obtain.setHasAlpha(true);
        return obtain;
    }

    private int readBlock() {
        int readByte = readByte();
        if (readByte <= 0) {
            return readByte;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(readByte, byteBuffer.remaining()));
        return readByte;
    }

    private int readByte() {
        return this.rawData.get() & 255;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.mainScratch;
        int i12 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                this.bitmapProvider.release(bitmap2);
            }
            this.previousImage = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i11 = gifFrame2.dispose) > 0) {
            if (i11 == 2) {
                if (!gifFrame.transparency) {
                    GifHeader gifHeader = this.header;
                    int i13 = gifHeader.bgColor;
                    if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                        i12 = i13;
                    }
                }
                int i14 = gifFrame2.ih;
                int i15 = this.sampleSize;
                int i16 = i14 / i15;
                int i17 = gifFrame2.iy / i15;
                int i18 = gifFrame2.iw / i15;
                int i19 = gifFrame2.ix / i15;
                int i20 = this.downsampledWidth;
                int i21 = (i17 * i20) + i19;
                int i22 = (i16 * i20) + i21;
                while (i21 < i22) {
                    int i23 = i21 + i18;
                    for (int i24 = i21; i24 < i23; i24++) {
                        iArr[i24] = i12;
                    }
                    i21 += this.downsampledWidth;
                }
            } else if (i11 == 3 && (bitmap = this.previousImage) != null) {
                int i25 = this.downsampledWidth;
                bitmap.getPixels(iArr, 0, i25, 0, 0, i25, this.downsampledHeight);
            }
        }
        decodeBitmapData(gifFrame);
        if (gifFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(gifFrame);
        } else {
            copyIntoScratchFast(gifFrame);
        }
        if (this.savePrevious && ((i10 = gifFrame.dispose) == 0 || i10 == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap3 = this.previousImage;
            int i26 = this.downsampledWidth;
            bitmap3.setPixels(iArr, 0, i26, 0, 0, i26, this.downsampledHeight);
        }
        Bitmap nextBitmap = getNextBitmap();
        int i27 = this.downsampledWidth;
        nextBitmap.setPixels(iArr, 0, i27, 0, 0, i27, this.downsampledHeight);
        return nextBitmap;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4);
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @NonNull
    public ByteBuffer getData() {
        return this.rawData;
    }

    public int getDelay(int i10) {
        if (i10 >= 0) {
            GifHeader gifHeader = this.header;
            if (i10 < gifHeader.frameCount) {
                return gifHeader.frames.get(i10).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    @Deprecated
    public int getLoopCount() {
        int i10 = this.header.loopCount;
        if (i10 == -1) {
            return 1;
        }
        return i10;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        int i10;
        if (this.header.frameCount <= 0 || (i10 = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e7, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[Catch:{ all -> 0x000e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d0 A[Catch:{ all -> 0x000e }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.gifdecoder.GifHeader r0 = r8.header     // Catch:{ all -> 0x000e }
            int r0 = r0.frameCount     // Catch:{ all -> 0x000e }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x0011
            int r0 = r8.framePointer     // Catch:{ all -> 0x000e }
            if (r0 >= 0) goto L_0x003d
            goto L_0x0011
        L_0x000e:
            r0 = move-exception
            goto L_0x00e8
        L_0x0011:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x000e }
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x000e }
            if (r3 == 0) goto L_0x003b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r3.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x000e }
            com.bumptech.glide.gifdecoder.GifHeader r4 = r8.header     // Catch:{ all -> 0x000e }
            int r4 = r4.frameCount     // Catch:{ all -> 0x000e }
            r3.append(r4)     // Catch:{ all -> 0x000e }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x000e }
            int r4 = r8.framePointer     // Catch:{ all -> 0x000e }
            r3.append(r4)     // Catch:{ all -> 0x000e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x000e }
        L_0x003b:
            r8.status = r2     // Catch:{ all -> 0x000e }
        L_0x003d:
            int r0 = r8.status     // Catch:{ all -> 0x000e }
            r3 = 0
            if (r0 == r2) goto L_0x00c8
            r4 = 2
            if (r0 != r4) goto L_0x0047
            goto L_0x00c8
        L_0x0047:
            r0 = 0
            r8.status = r0     // Catch:{ all -> 0x000e }
            byte[] r5 = r8.block     // Catch:{ all -> 0x000e }
            if (r5 != 0) goto L_0x0058
            com.bumptech.glide.gifdecoder.GifDecoder$BitmapProvider r5 = r8.bitmapProvider     // Catch:{ all -> 0x000e }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.obtainByteArray(r6)     // Catch:{ all -> 0x000e }
            r8.block = r5     // Catch:{ all -> 0x000e }
        L_0x0058:
            com.bumptech.glide.gifdecoder.GifHeader r5 = r8.header     // Catch:{ all -> 0x000e }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r5 = r5.frames     // Catch:{ all -> 0x000e }
            int r6 = r8.framePointer     // Catch:{ all -> 0x000e }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x000e }
            com.bumptech.glide.gifdecoder.GifFrame r5 = (com.bumptech.glide.gifdecoder.GifFrame) r5     // Catch:{ all -> 0x000e }
            int r6 = r8.framePointer     // Catch:{ all -> 0x000e }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0074
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.header     // Catch:{ all -> 0x000e }
            java.util.List<com.bumptech.glide.gifdecoder.GifFrame> r7 = r7.frames     // Catch:{ all -> 0x000e }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x000e }
            com.bumptech.glide.gifdecoder.GifFrame r6 = (com.bumptech.glide.gifdecoder.GifFrame) r6     // Catch:{ all -> 0x000e }
            goto L_0x0075
        L_0x0074:
            r6 = r3
        L_0x0075:
            int[] r7 = r5.lct     // Catch:{ all -> 0x000e }
            if (r7 == 0) goto L_0x007a
            goto L_0x007e
        L_0x007a:
            com.bumptech.glide.gifdecoder.GifHeader r7 = r8.header     // Catch:{ all -> 0x000e }
            int[] r7 = r7.gct     // Catch:{ all -> 0x000e }
        L_0x007e:
            r8.act = r7     // Catch:{ all -> 0x000e }
            if (r7 != 0) goto L_0x00a4
            java.lang.String r0 = TAG     // Catch:{ all -> 0x000e }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x00a0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r1.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x000e }
            int r4 = r8.framePointer     // Catch:{ all -> 0x000e }
            r1.append(r4)     // Catch:{ all -> 0x000e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x000e }
        L_0x00a0:
            r8.status = r2     // Catch:{ all -> 0x000e }
            monitor-exit(r8)
            return r3
        L_0x00a4:
            boolean r1 = r5.transparency     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x00c2
            int[] r1 = r8.pct     // Catch:{ all -> 0x000e }
            int r2 = r7.length     // Catch:{ all -> 0x000e }
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch:{ all -> 0x000e }
            int[] r1 = r8.pct     // Catch:{ all -> 0x000e }
            r8.act = r1     // Catch:{ all -> 0x000e }
            int r2 = r5.transIndex     // Catch:{ all -> 0x000e }
            r1[r2] = r0     // Catch:{ all -> 0x000e }
            int r0 = r5.dispose     // Catch:{ all -> 0x000e }
            if (r0 != r4) goto L_0x00c2
            int r0 = r8.framePointer     // Catch:{ all -> 0x000e }
            if (r0 != 0) goto L_0x00c2
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x000e }
            r8.isFirstFrameTransparent = r0     // Catch:{ all -> 0x000e }
        L_0x00c2:
            android.graphics.Bitmap r0 = r8.setPixels(r5, r6)     // Catch:{ all -> 0x000e }
            monitor-exit(r8)
            return r0
        L_0x00c8:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x000e }
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x00e6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r1.<init>()     // Catch:{ all -> 0x000e }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x000e }
            int r2 = r8.status     // Catch:{ all -> 0x000e }
            r1.append(r2)     // Catch:{ all -> 0x000e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x000e }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x000e }
        L_0x00e6:
            monitor-exit(r8)
            return r3
        L_0x00e8:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalIterationCount() {
        int i10 = this.header.loopCount;
        if (i10 == -1) {
            return 1;
        }
        if (i10 == 0) {
            return 0;
        }
        return i10 + 1;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(@Nullable InputStream inputStream, int i10) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i10 > 0 ? i10 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e10) {
                Log.w(TAG, "Error reading data from stream", e10);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e11) {
                Log.w(TAG, "Error closing stream", e11);
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider2, GifHeader gifHeader, ByteBuffer byteBuffer, int i10) {
        this(bitmapProvider2);
        setData(gifHeader, byteBuffer, i10);
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider2) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider2;
        this.header = new GifHeader();
    }

    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i10) {
        if (i10 > 0) {
            try {
                int highestOneBit = Integer.highestOneBit(i10);
                this.status = 0;
                this.header = gifHeader;
                this.framePointer = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.rawData = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                this.savePrevious = false;
                Iterator<GifFrame> it = gifHeader.frames.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().dispose == 3) {
                            this.savePrevious = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.sampleSize = highestOneBit;
                int i11 = gifHeader.width;
                this.downsampledWidth = i11 / highestOneBit;
                int i12 = gifHeader.height;
                this.downsampledHeight = i12 / highestOneBit;
                this.mainPixels = this.bitmapProvider.obtainByteArray(i11 * i12);
                this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
        }
    }

    public synchronized int read(@Nullable byte[] bArr) {
        try {
            GifHeader parseHeader = getHeaderParser().setData(bArr).parseHeader();
            this.header = parseHeader;
            if (bArr != null) {
                setData(parseHeader, bArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.status;
    }
}
