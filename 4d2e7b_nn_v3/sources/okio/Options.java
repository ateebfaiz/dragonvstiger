package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.c;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class Options extends c<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    public static final class Companion {
        private Companion() {
        }

        private final void buildTrieRecursive(long j10, Buffer buffer, int i10, List<? extends ByteString> list, int i11, int i12, List<Integer> list2) {
            boolean z10;
            int i13;
            int i14;
            boolean z11;
            int i15;
            int i16;
            Buffer buffer2;
            boolean z12;
            Buffer buffer3 = buffer;
            int i17 = i10;
            List<? extends ByteString> list3 = list;
            int i18 = i11;
            int i19 = i12;
            List<Integer> list4 = list2;
            if (i18 < i19) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                int i20 = i18;
                while (i20 < i19) {
                    if (((ByteString) list3.get(i20)).size() >= i17) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        i20++;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = (ByteString) list.get(i11);
                ByteString byteString2 = (ByteString) list3.get(i19 - 1);
                int i21 = -1;
                if (i17 == byteString.size()) {
                    int intValue = list4.get(i18).intValue();
                    int i22 = i18 + 1;
                    i13 = i22;
                    i14 = intValue;
                    byteString = (ByteString) list3.get(i22);
                } else {
                    i13 = i18;
                    i14 = -1;
                }
                if (byteString.getByte(i17) != byteString2.getByte(i17)) {
                    int i23 = 1;
                    for (int i24 = i13 + 1; i24 < i19; i24++) {
                        if (((ByteString) list3.get(i24 - 1)).getByte(i17) != ((ByteString) list3.get(i24)).getByte(i17)) {
                            i23++;
                        }
                    }
                    long intCount = j10 + getIntCount(buffer3) + ((long) 2) + ((long) (i23 * 2));
                    buffer3.writeInt(i23);
                    buffer3.writeInt(i14);
                    for (int i25 = i13; i25 < i19; i25++) {
                        byte b10 = ((ByteString) list3.get(i25)).getByte(i17);
                        if (i25 == i13 || b10 != ((ByteString) list3.get(i25 - 1)).getByte(i17)) {
                            buffer3.writeInt((int) b10 & 255);
                        }
                    }
                    Buffer buffer4 = new Buffer();
                    while (i13 < i19) {
                        byte b11 = ((ByteString) list3.get(i13)).getByte(i17);
                        int i26 = i13 + 1;
                        int i27 = i26;
                        while (true) {
                            if (i27 >= i19) {
                                i15 = i19;
                                break;
                            } else if (b11 != ((ByteString) list3.get(i27)).getByte(i17)) {
                                i15 = i27;
                                break;
                            } else {
                                i27++;
                            }
                        }
                        if (i26 == i15 && i17 + 1 == ((ByteString) list3.get(i13)).size()) {
                            buffer3.writeInt(list4.get(i13).intValue());
                            i16 = i15;
                            buffer2 = buffer4;
                        } else {
                            buffer3.writeInt(((int) (intCount + getIntCount(buffer4))) * i21);
                            i16 = i15;
                            buffer2 = buffer4;
                            buildTrieRecursive(intCount, buffer4, i17 + 1, list, i13, i15, list2);
                        }
                        buffer4 = buffer2;
                        i13 = i16;
                        i21 = -1;
                    }
                    buffer3.writeAll(buffer4);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i28 = i17;
                int i29 = 0;
                while (i28 < min && byteString.getByte(i28) == byteString2.getByte(i28)) {
                    i29++;
                    i28++;
                }
                long intCount2 = j10 + getIntCount(buffer3) + ((long) 2) + ((long) i29) + 1;
                buffer3.writeInt(-i29);
                buffer3.writeInt(i14);
                int i30 = i17 + i29;
                while (i17 < i30) {
                    buffer3.writeInt((int) byteString.getByte(i17) & 255);
                    i17++;
                }
                if (i13 + 1 == i19) {
                    if (i30 == ((ByteString) list3.get(i13)).size()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        buffer3.writeInt(list4.get(i13).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer5 = new Buffer();
                buffer3.writeInt(((int) (getIntCount(buffer5) + intCount2)) * -1);
                buildTrieRecursive(intCount2, buffer5, i30, list, i13, i12, list2);
                buffer3.writeAll(buffer5);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j10, Buffer buffer, int i10, List list, int i11, int i12, List list2, int i13, Object obj) {
            companion.buildTrieRecursive((i13 & 1) != 0 ? 0 : j10, buffer, (i13 & 4) != 0 ? 0 : i10, list, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? list.size() : i12, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        public final Options of(ByteString... byteStringArr) {
            boolean z10;
            boolean z11;
            ByteString[] byteStringArr2 = byteStringArr;
            m.f(byteStringArr2, "byteStrings");
            int i10 = 0;
            if (byteStringArr2.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, (DefaultConstructorMarker) null);
            }
            List X = j.X(byteStringArr);
            r.x(X);
            ArrayList arrayList = new ArrayList(byteStringArr2.length);
            for (ByteString byteString : byteStringArr2) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array != null) {
                Integer[] numArr = (Integer[]) array;
                List q10 = r.q((Integer[]) Arrays.copyOf(numArr, numArr.length));
                int length = byteStringArr2.length;
                int i11 = 0;
                int i12 = 0;
                while (i11 < length) {
                    q10.set(r.k(X, byteStringArr2[i11], 0, 0, 6, (Object) null), Integer.valueOf(i12));
                    i11++;
                    i12++;
                }
                if (((ByteString) X.get(0)).size() > 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    int i13 = 0;
                    while (i13 < X.size()) {
                        ByteString byteString2 = (ByteString) X.get(i13);
                        int i14 = i13 + 1;
                        int i15 = i14;
                        while (i15 < X.size()) {
                            ByteString byteString3 = (ByteString) X.get(i15);
                            if (!byteString3.startsWith(byteString2)) {
                                continue;
                                break;
                            }
                            if (byteString3.size() != byteString2.size()) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (!z11) {
                                throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                            } else if (((Number) q10.get(i15)).intValue() > ((Number) q10.get(i13)).intValue()) {
                                X.remove(i15);
                                q10.remove(i15);
                            } else {
                                i15++;
                            }
                        }
                        i13 = i14;
                    }
                    Buffer buffer = new Buffer();
                    buildTrieRecursive$default(this, 0, buffer, 0, X, 0, 0, q10, 53, (Object) null);
                    int[] iArr = new int[((int) getIntCount(buffer))];
                    while (!buffer.exhausted()) {
                        iArr[i10] = buffer.readInt();
                        i10++;
                    }
                    Object[] copyOf = Arrays.copyOf(byteStringArr2, byteStringArr2.length);
                    m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                    return new Options((ByteString[]) copyOf, iArr, (DefaultConstructorMarker) null);
                }
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains(byteString);
    }

    public ByteString get(int i10) {
        return this.byteStrings[i10];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }
}
