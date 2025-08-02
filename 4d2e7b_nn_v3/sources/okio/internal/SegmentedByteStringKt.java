package okio.internal;

import kotlin.collections.j;
import kotlin.jvm.internal.m;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;
import vb.n;

public final class SegmentedByteStringKt {
    public static final int binarySearch(int[] iArr, int i10, int i11, int i12) {
        m.f(iArr, "$this$binarySearch");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else if (i15 <= i10) {
                return i14;
            } else {
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final boolean commonEquals(SegmentedByteString segmentedByteString, Object obj) {
        m.f(segmentedByteString, "$this$commonEquals");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(SegmentedByteString segmentedByteString) {
        m.f(segmentedByteString, "$this$commonGetSize");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(SegmentedByteString segmentedByteString) {
        m.f(segmentedByteString, "$this$commonHashCode");
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = segmentedByteString.getDirectory$okio()[length + i10];
            int i14 = segmentedByteString.getDirectory$okio()[i10];
            byte[] bArr = segmentedByteString.getSegments$okio()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        segmentedByteString.setHashCode$okio(i11);
        return i11;
    }

    public static final byte commonInternalGet(SegmentedByteString segmentedByteString, int i10) {
        int i11;
        m.f(segmentedByteString, "$this$commonInternalGet");
        Util.checkOffsetAndCount((long) segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], (long) i10, 1);
        int segment = segment(segmentedByteString, i10);
        if (segment == 0) {
            i11 = 0;
        } else {
            i11 = segmentedByteString.getDirectory$okio()[segment - 1];
        }
        return segmentedByteString.getSegments$okio()[segment][(i10 - i11) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i10, ByteString byteString, int i11, int i12) {
        int i13;
        m.f(segmentedByteString, "$this$commonRangeEquals");
        m.f(byteString, "other");
        if (i10 < 0 || i10 > segmentedByteString.size() - i12) {
            return false;
        }
        int i14 = i12 + i10;
        int segment = segment(segmentedByteString, i10);
        while (i10 < i14) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i15 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i14, (segmentedByteString.getDirectory$okio()[segment] - i13) + i13) - i10;
            if (!byteString.rangeEquals(i11, segmentedByteString.getSegments$okio()[segment], i15 + (i10 - i13), min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(SegmentedByteString segmentedByteString, int i10, int i11) {
        boolean z10;
        boolean z11;
        boolean z12;
        m.f(segmentedByteString, "$this$commonSubstring");
        int i12 = 0;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 <= segmentedByteString.size()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                int i13 = i11 - i10;
                if (i13 >= 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    throw new IllegalArgumentException(("endIndex=" + i11 + " < beginIndex=" + i10).toString());
                } else if (i10 == 0 && i11 == segmentedByteString.size()) {
                    return segmentedByteString;
                } else {
                    if (i10 == i11) {
                        return ByteString.EMPTY;
                    }
                    int segment = segment(segmentedByteString, i10);
                    int segment2 = segment(segmentedByteString, i11 - 1);
                    byte[][] bArr = (byte[][]) j.i(segmentedByteString.getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (segment <= segment2) {
                        int i14 = 0;
                        int i15 = segment;
                        while (true) {
                            iArr[i14] = Math.min(segmentedByteString.getDirectory$okio()[i15] - i10, i13);
                            int i16 = i14 + 1;
                            iArr[i14 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i15];
                            if (i15 == segment2) {
                                break;
                            }
                            i15++;
                            i14 = i16;
                        }
                    }
                    if (segment != 0) {
                        i12 = segmentedByteString.getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i10 - i12);
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + i11 + " > length(" + segmentedByteString.size() + ')').toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
        }
    }

    public static final byte[] commonToByteArray(SegmentedByteString segmentedByteString) {
        m.f(segmentedByteString, "$this$commonToByteArray");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = segmentedByteString.getDirectory$okio()[length + i10];
            int i14 = segmentedByteString.getDirectory$okio()[i10];
            int i15 = i14 - i11;
            j.d(segmentedByteString.getSegments$okio()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    public static final void commonWrite(SegmentedByteString segmentedByteString, Buffer buffer, int i10, int i11) {
        int i12;
        m.f(segmentedByteString, "$this$commonWrite");
        m.f(buffer, "buffer");
        int i13 = i10 + i11;
        int segment = segment(segmentedByteString, i10);
        while (i10 < i13) {
            if (segment == 0) {
                i12 = 0;
            } else {
                i12 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i14 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i13, (segmentedByteString.getDirectory$okio()[segment] - i12) + i12) - i10;
            int i15 = i14 + (i10 - i12);
            Segment segment2 = new Segment(segmentedByteString.getSegments$okio()[segment], i15, i15 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                m.c(segment3);
                Segment segment4 = segment3.prev;
                m.c(segment4);
                segment4.push(segment2);
            }
            i10 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i11));
    }

    public static final void forEachSegment(SegmentedByteString segmentedByteString, n nVar) {
        m.f(segmentedByteString, "$this$forEachSegment");
        m.f(nVar, "action");
        int length = segmentedByteString.getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = segmentedByteString.getDirectory$okio()[length + i10];
            int i13 = segmentedByteString.getDirectory$okio()[i10];
            nVar.e(segmentedByteString.getSegments$okio()[i10], Integer.valueOf(i12), Integer.valueOf(i13 - i11));
            i10++;
            i11 = i13;
        }
    }

    public static final int segment(SegmentedByteString segmentedByteString, int i10) {
        m.f(segmentedByteString, "$this$segment");
        int binarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i10 + 1, 0, segmentedByteString.getSegments$okio().length);
        if (binarySearch >= 0) {
            return binarySearch;
        }
        return ~binarySearch;
    }

    /* access modifiers changed from: private */
    public static final void forEachSegment(SegmentedByteString segmentedByteString, int i10, int i11, n nVar) {
        int i12;
        int segment = segment(segmentedByteString, i10);
        while (i10 < i11) {
            if (segment == 0) {
                i12 = 0;
            } else {
                i12 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i13 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i11, (segmentedByteString.getDirectory$okio()[segment] - i12) + i12) - i10;
            nVar.e(segmentedByteString.getSegments$okio()[segment], Integer.valueOf(i13 + (i10 - i12)), Integer.valueOf(min));
            i10 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i10, byte[] bArr, int i11, int i12) {
        int i13;
        m.f(segmentedByteString, "$this$commonRangeEquals");
        m.f(bArr, "other");
        if (i10 < 0 || i10 > segmentedByteString.size() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int i14 = i12 + i10;
        int segment = segment(segmentedByteString, i10);
        while (i10 < i14) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i15 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i14, (segmentedByteString.getDirectory$okio()[segment] - i13) + i13) - i10;
            if (!Util.arrayRangeEquals(segmentedByteString.getSegments$okio()[segment], i15 + (i10 - i13), bArr, i11, min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            segment++;
        }
        return true;
    }
}
