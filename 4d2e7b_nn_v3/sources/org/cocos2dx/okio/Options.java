package org.cocos2dx.okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j10, Buffer buffer, int i10, List<ByteString> list, int i11, int i12, List<Integer> list2) {
        int i13;
        int i14;
        int i15;
        int i16;
        Buffer buffer2;
        int i17;
        Buffer buffer3 = buffer;
        int i18 = i10;
        List<ByteString> list3 = list;
        int i19 = i11;
        int i20 = i12;
        List<Integer> list4 = list2;
        if (i19 < i20) {
            int i21 = i19;
            while (i21 < i20) {
                if (list3.get(i21).size() >= i18) {
                    i21++;
                } else {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i11);
            ByteString byteString2 = list3.get(i20 - 1);
            if (i18 == byteString.size()) {
                int intValue = list4.get(i19).intValue();
                int i22 = i19 + 1;
                i13 = i22;
                i14 = intValue;
                byteString = list3.get(i22);
            } else {
                i14 = -1;
                i13 = i19;
            }
            if (byteString.getByte(i18) != byteString2.getByte(i18)) {
                int i23 = 1;
                for (int i24 = i13 + 1; i24 < i20; i24++) {
                    if (list3.get(i24 - 1).getByte(i18) != list3.get(i24).getByte(i18)) {
                        i23++;
                    }
                }
                long intCount = j10 + ((long) intCount(buffer)) + 2 + ((long) (i23 * 2));
                buffer3.writeInt(i23);
                buffer3.writeInt(i14);
                for (int i25 = i13; i25 < i20; i25++) {
                    byte b10 = list3.get(i25).getByte(i18);
                    if (i25 == i13 || b10 != list3.get(i25 - 1).getByte(i18)) {
                        buffer3.writeInt((int) b10 & 255);
                    }
                }
                Buffer buffer4 = new Buffer();
                int i26 = i13;
                while (i26 < i20) {
                    byte b11 = list3.get(i26).getByte(i18);
                    int i27 = i26 + 1;
                    int i28 = i27;
                    while (true) {
                        if (i28 >= i20) {
                            i16 = i20;
                            break;
                        } else if (b11 != list3.get(i28).getByte(i18)) {
                            i16 = i28;
                            break;
                        } else {
                            i28++;
                        }
                    }
                    if (i27 == i16 && i18 + 1 == list3.get(i26).size()) {
                        buffer3.writeInt(list4.get(i26).intValue());
                        i17 = i16;
                        buffer2 = buffer4;
                    } else {
                        buffer3.writeInt((int) ((((long) intCount(buffer4)) + intCount) * -1));
                        i17 = i16;
                        buffer2 = buffer4;
                        buildTrieRecursive(intCount, buffer4, i18 + 1, list, i26, i16, list2);
                    }
                    buffer4 = buffer2;
                    i26 = i17;
                }
                Buffer buffer5 = buffer4;
                buffer3.write(buffer5, buffer5.size());
                return;
            }
            int min = Math.min(byteString.size(), byteString2.size());
            int i29 = 0;
            int i30 = i18;
            while (i30 < min && byteString.getByte(i30) == byteString2.getByte(i30)) {
                i29++;
                i30++;
            }
            long intCount2 = 1 + j10 + ((long) intCount(buffer)) + 2 + ((long) i29);
            buffer3.writeInt(-i29);
            buffer3.writeInt(i14);
            int i31 = i18;
            while (true) {
                i15 = i18 + i29;
                if (i31 >= i15) {
                    break;
                }
                buffer3.writeInt((int) byteString.getByte(i31) & 255);
                i31++;
            }
            if (i13 + 1 != i20) {
                Buffer buffer6 = new Buffer();
                buffer3.writeInt((int) ((((long) intCount(buffer6)) + intCount2) * -1));
                buildTrieRecursive(intCount2, buffer6, i15, list, i13, i12, list2);
                buffer3.write(buffer6, buffer6.size());
            } else if (i15 == list3.get(i13).size()) {
                buffer3.writeInt(list4.get(i13).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            arrayList2.add(-1);
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i11]), Integer.valueOf(i11));
        }
        if (((ByteString) arrayList.get(0)).size() != 0) {
            int i12 = 0;
            while (i12 < arrayList.size()) {
                ByteString byteString = (ByteString) arrayList.get(i12);
                int i13 = i12 + 1;
                int i14 = i13;
                while (i14 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i14);
                    if (!byteString2.startsWith(byteString)) {
                        continue;
                        break;
                    } else if (byteString2.size() == byteString.size()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else if (((Integer) arrayList2.get(i14)).intValue() > ((Integer) arrayList2.get(i12)).intValue()) {
                        arrayList.remove(i14);
                        arrayList2.remove(i14);
                    } else {
                        i14++;
                    }
                }
                i12 = i13;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive(0, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
            int intCount = intCount(buffer);
            int[] iArr = new int[intCount];
            for (int i15 = 0; i15 < intCount; i15++) {
                iArr[i15] = buffer.readInt();
            }
            if (buffer.exhausted()) {
                return new Options((ByteString[]) byteStringArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    public final int size() {
        return this.byteStrings.length;
    }

    public ByteString get(int i10) {
        return this.byteStrings[i10];
    }
}
