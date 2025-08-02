package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

public class SymbolTable {
    private final int indexMask;
    private final Entry[] symbols;

    static class Entry {
        final char[] chars;
        final int hashCode;
        final String value;

        Entry(String str, int i10) {
            this.value = str;
            this.chars = str.toCharArray();
            this.hashCode = i10;
        }
    }

    public SymbolTable(int i10) {
        this.indexMask = i10 - 1;
        this.symbols = new Entry[i10];
        addSymbol("$ref", 0, 4, 1185263);
        addSymbol(JSON.DEFAULT_TYPE_KEY, 0, 5, 62680954);
    }

    private static String subString(String str, int i10, int i11) {
        char[] cArr = new char[i11];
        str.getChars(i10, i11 + i10, cArr, 0);
        return new String(cArr);
    }

    public String addSymbol(char[] cArr, int i10, int i11, int i12) {
        int i13 = this.indexMask & i12;
        Entry entry = this.symbols[i13];
        if (entry != null) {
            if (i12 == entry.hashCode && i11 == entry.chars.length) {
                int i14 = 0;
                while (i14 < i11) {
                    if (cArr[i10 + i14] == entry.chars[i14]) {
                        i14++;
                    }
                }
                return entry.value;
            }
            return new String(cArr, i10, i11);
        }
        String intern = new String(cArr, i10, i11).intern();
        this.symbols[i13] = new Entry(intern, i12);
        return intern;
    }

    public String addSymbol(String str, int i10, int i11, int i12) {
        int i13 = this.indexMask & i12;
        Entry entry = this.symbols[i13];
        if (entry == null) {
            if (i11 != str.length()) {
                str = subString(str, i10, i11);
            }
            String intern = str.intern();
            this.symbols[i13] = new Entry(intern, i12);
            return intern;
        } else if (i12 == entry.hashCode && i11 == entry.chars.length && str.regionMatches(i10, entry.value, 0, i11)) {
            return entry.value;
        } else {
            return subString(str, i10, i11);
        }
    }
}
