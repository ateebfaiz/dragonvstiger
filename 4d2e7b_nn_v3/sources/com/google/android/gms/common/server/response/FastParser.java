package com.google.android.gms.common.server.response;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import okio.internal.BufferKt;

@ShowFirstParty
@KeepForSdk
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaa = {'u', 'l', 'l'};
    private static final char[] zab = {'r', 'u', 'e'};
    private static final char[] zac = {'r', 'u', 'e', '\"'};
    private static final char[] zad = {'a', 'l', 's', 'e'};
    private static final char[] zae = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zaf = {10};
    private static final i zag = new a();
    private static final i zah = new b();
    private static final i zai = new c();
    private static final i zaj = new d();
    private static final i zak = new e();
    private static final i zal = new f();
    private static final i zam = new g();
    private static final i zan = new h();
    private final char[] zao = new char[1];
    private final char[] zap = new char[32];
    private final char[] zaq = new char[1024];
    private final StringBuilder zar = new StringBuilder(32);
    private final StringBuilder zas = new StringBuilder(1024);
    private final Stack<Integer> zat = new Stack<>();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
        public ParseException(@NonNull String str) {
            super(str);
        }

        public ParseException(@NonNull String str, @NonNull Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(@NonNull Throwable th) {
            super(th);
        }
    }

    private static final String zaA(BufferedReader bufferedReader, char[] cArr, StringBuilder sb2, @Nullable char[] cArr2) throws ParseException, IOException {
        sb2.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z10 = false;
        boolean z11 = false;
        loop0:
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                for (int i10 = 0; i10 < read; i10++) {
                    char c10 = cArr[i10];
                    if (Character.isISOControl(c10)) {
                        if (cArr2 == null) {
                            break loop0;
                        }
                        int i11 = 0;
                        while (i11 <= 0) {
                            if (cArr2[i11] != c10) {
                                i11++;
                            }
                        }
                        break loop0;
                    }
                    if (c10 == '\"') {
                        if (!z11) {
                            sb2.append(cArr, 0, i10);
                            bufferedReader.reset();
                            bufferedReader.skip((long) (i10 + 1));
                            if (z10) {
                                return JsonUtils.unescapeString(sb2.toString());
                            }
                            return sb2.toString();
                        }
                    } else if (c10 == '\\') {
                        z11 = !z11;
                        z10 = true;
                    }
                    z11 = false;
                }
                sb2.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    private final char zai(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zao) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.zao[0])) {
            if (bufferedReader.read(this.zao) == -1) {
                return 0;
            }
        }
        return this.zao[0];
    }

    /* access modifiers changed from: private */
    public final double zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final float zak(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    public final int zal(BufferedReader bufferedReader) throws ParseException, IOException {
        int i10;
        int i11;
        int i12;
        int i13;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            char c10 = cArr[0];
            if (c10 == '-') {
                i10 = Integer.MIN_VALUE;
            } else {
                i10 = -2147483647;
            }
            if (c10 == '-') {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (i11 < zam2) {
                i13 = i11 + 1;
                int digit = Character.digit(cArr[i11], 10);
                if (digit >= 0) {
                    i12 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                i12 = 0;
                i13 = i11;
            }
            while (i13 < zam2) {
                int i14 = i13 + 1;
                int digit2 = Character.digit(cArr[i13], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i12 >= -214748364) {
                    int i15 = i12 * 10;
                    if (i15 >= i10 + digit2) {
                        i12 = i15 - digit2;
                        i13 = i14;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i11 == 0) {
                return -i12;
            }
            if (i13 > 1) {
                return i12;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    private final int zam(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i10;
        char zai2 = zai(bufferedReader);
        if (zai2 == 0) {
            throw new ParseException("Unexpected EOF");
        } else if (zai2 == ',') {
            throw new ParseException("Missing value");
        } else if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (zai2 == '\"') {
                i10 = 0;
                boolean z10 = false;
                while (i10 < 1024 && bufferedReader.read(cArr, i10, 1) != -1) {
                    char c10 = cArr[i10];
                    if (!Character.isISOControl(c10)) {
                        if (c10 == '\"') {
                            if (!z10) {
                                bufferedReader.reset();
                                bufferedReader.skip((long) (i10 + 1));
                                return i10;
                            }
                        } else if (c10 == '\\') {
                            z10 = !z10;
                            i10++;
                        }
                        z10 = false;
                        i10++;
                    } else {
                        throw new ParseException("Unexpected control character while reading string");
                    }
                }
            } else {
                cArr[0] = zai2;
                int i11 = 1;
                while (i10 < 1024 && bufferedReader.read(cArr, i10, 1) != -1) {
                    char c11 = cArr[i10];
                    if (c11 == '}' || c11 == ',' || Character.isWhitespace(c11) || cArr[i10] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i10 - 1));
                        cArr[i10] = 0;
                        return i10;
                    }
                    i11 = i10 + 1;
                }
            }
            if (i10 == 1024) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException("Unexpected EOF");
        }
    }

    /* access modifiers changed from: private */
    public final long zan(BufferedReader bufferedReader) throws ParseException, IOException {
        long j10;
        long j11;
        int i10;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            int i11 = 0;
            char c10 = cArr[0];
            if (c10 == '-') {
                j10 = Long.MIN_VALUE;
            } else {
                j10 = -9223372036854775807L;
            }
            if (c10 == '-') {
                i11 = 1;
            }
            if (i11 < zam2) {
                i10 = i11 + 1;
                int digit = Character.digit(cArr[i11], 10);
                if (digit >= 0) {
                    j11 = (long) (-digit);
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                j11 = 0;
                i10 = i11;
            }
            while (i10 < zam2) {
                int i12 = i10 + 1;
                int digit2 = Character.digit(cArr[i10], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j11 >= BufferKt.OVERFLOW_ZONE) {
                    long j12 = j11 * 10;
                    int i13 = zam2;
                    long j13 = (long) digit2;
                    if (j12 >= j10 + j13) {
                        j11 = j12 - j13;
                        zam2 = i13;
                        i10 = i12;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (i11 == 0) {
                return -j11;
            }
            if (i10 > 1) {
                return j11;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    @Nullable
    public final String zao(BufferedReader bufferedReader) throws ParseException, IOException {
        return zap(bufferedReader, this.zap, this.zar, (char[]) null);
    }

    @Nullable
    private final String zap(BufferedReader bufferedReader, char[] cArr, StringBuilder sb2, @Nullable char[] cArr2) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            return zaA(bufferedReader, cArr, sb2, cArr2);
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        }
        throw new ParseException("Expected string");
    }

    @Nullable
    private final String zaq(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zat.push(2);
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            this.zat.push(3);
            String zaA = zaA(bufferedReader, this.zap, this.zar, (char[]) null);
            zaw(3);
            if (zai(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zai2 == ']') {
            zaw(2);
            zaw(1);
            zaw(5);
            return null;
        } else if (zai2 == '}') {
            zaw(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Unexpected token: ");
            sb2.append(zai2);
            throw new ParseException(sb2.toString());
        }
    }

    @Nullable
    private final String zar(BufferedReader bufferedReader) throws ParseException, IOException {
        BufferedReader bufferedReader2 = bufferedReader;
        bufferedReader2.mark(1024);
        char zai2 = zai(bufferedReader);
        int i10 = 1;
        if (zai2 != '\"') {
            if (zai2 == ',') {
                throw new ParseException("Missing value");
            } else if (zai2 == '[') {
                this.zat.push(5);
                bufferedReader2.mark(32);
                if (zai(bufferedReader) == ']') {
                    zaw(5);
                } else {
                    bufferedReader.reset();
                    boolean z10 = false;
                    boolean z11 = false;
                    while (i10 > 0) {
                        char zai3 = zai(bufferedReader);
                        if (zai3 == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        } else if (!Character.isISOControl(zai3)) {
                            if (zai3 == '\"') {
                                if (!z11) {
                                    z10 = !z10;
                                }
                                zai3 = '\"';
                            }
                            if (zai3 == '[') {
                                if (!z10) {
                                    i10++;
                                }
                                zai3 = '[';
                            }
                            if (zai3 == ']' && !z10) {
                                i10--;
                            }
                            if (zai3 != '\\' || !z10) {
                                z11 = false;
                            } else {
                                z11 = !z11;
                            }
                        } else {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                    }
                    zaw(5);
                }
            } else if (zai2 != '{') {
                bufferedReader.reset();
                zam(bufferedReader2, this.zaq);
            } else {
                this.zat.push(1);
                bufferedReader2.mark(32);
                char zai4 = zai(bufferedReader);
                if (zai4 == '}') {
                    zaw(1);
                } else if (zai4 == '\"') {
                    bufferedReader.reset();
                    zaq(bufferedReader);
                    do {
                    } while (zar(bufferedReader) != null);
                    zaw(1);
                } else {
                    StringBuilder sb2 = new StringBuilder(18);
                    sb2.append("Unexpected token ");
                    sb2.append(zai4);
                    throw new ParseException(sb2.toString());
                }
            }
        } else if (bufferedReader2.read(this.zao) != -1) {
            char c10 = this.zao[0];
            boolean z12 = false;
            do {
                if (c10 == '\"') {
                    if (z12) {
                        c10 = '\"';
                        z12 = true;
                    }
                }
                if (c10 == '\\') {
                    z12 = !z12;
                } else {
                    z12 = false;
                }
                if (bufferedReader2.read(this.zao) != -1) {
                    c10 = this.zao[0];
                } else {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
            } while (!Character.isISOControl(c10));
            throw new ParseException("Unexpected control character while reading string");
        } else {
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char zai5 = zai(bufferedReader);
        if (zai5 == ',') {
            zaw(2);
            return zaq(bufferedReader);
        } else if (zai5 == '}') {
            zaw(2);
            return null;
        } else {
            StringBuilder sb3 = new StringBuilder(18);
            sb3.append("Unexpected token ");
            sb3.append(zai5);
            throw new ParseException(sb3.toString());
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public final BigDecimal zas(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaq, 0, zam2));
    }

    /* access modifiers changed from: private */
    @Nullable
    public final BigInteger zat(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaq, 0, zam2));
    }

    @Nullable
    private final <O> ArrayList<O> zau(BufferedReader bufferedReader, i iVar) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        } else if (zai2 == '[') {
            this.zat.push(5);
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char zai3 = zai(bufferedReader);
                if (zai3 == 0) {
                    throw new ParseException("Unexpected EOF");
                } else if (zai3 != ',') {
                    if (zai3 != ']') {
                        bufferedReader.reset();
                        arrayList.add(iVar.a(this, bufferedReader));
                    } else {
                        zaw(5);
                        return arrayList;
                    }
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    @Nullable
    private final <T extends FastJsonResponse> ArrayList<T> zav(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = new ArrayList<>();
        char zai2 = zai(bufferedReader);
        if (zai2 == ']') {
            zaw(5);
            return arrayList;
        } else if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            zaw(5);
            return null;
        } else if (zai2 == '{') {
            this.zat.push(1);
            while (true) {
                try {
                    FastJsonResponse zad2 = field.zad();
                    if (!zaz(bufferedReader, zad2)) {
                        return arrayList;
                    }
                    arrayList.add(zad2);
                    char zai3 = zai(bufferedReader);
                    if (zai3 != ',') {
                        if (zai3 == ']') {
                            zaw(5);
                            return arrayList;
                        }
                        StringBuilder sb2 = new StringBuilder(19);
                        sb2.append("Unexpected token: ");
                        sb2.append(zai3);
                        throw new ParseException(sb2.toString());
                    } else if (zai(bufferedReader) == '{') {
                        this.zat.push(1);
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (InstantiationException e10) {
                    throw new ParseException("Error instantiating inner object", e10);
                } catch (IllegalAccessException e11) {
                    throw new ParseException("Error instantiating inner object", e11);
                }
            }
        } else {
            StringBuilder sb3 = new StringBuilder(19);
            sb3.append("Unexpected token: ");
            sb3.append(zai2);
            throw new ParseException(sb3.toString());
        }
    }

    private final void zaw(int i10) throws ParseException {
        if (!this.zat.isEmpty()) {
            int intValue = this.zat.pop().intValue();
            if (intValue != i10) {
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Expected state ");
                sb2.append(i10);
                sb2.append(" but had ");
                sb2.append(intValue);
                throw new ParseException(sb2.toString());
            }
            return;
        }
        StringBuilder sb3 = new StringBuilder(46);
        sb3.append("Expected state ");
        sb3.append(i10);
        sb3.append(" but had empty stack");
        throw new ParseException(sb3.toString());
    }

    private final void zax(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i10 = 0;
        while (true) {
            int length = cArr.length;
            if (i10 < length) {
                int read = bufferedReader.read(this.zap, 0, length - i10);
                if (read != -1) {
                    int i11 = 0;
                    while (i11 < read) {
                        if (cArr[i11 + i10] == this.zap[i11]) {
                            i11++;
                        } else {
                            throw new ParseException("Unexpected character");
                        }
                    }
                    i10 += read;
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zay(BufferedReader bufferedReader, boolean z10) throws ParseException, IOException {
        char[] cArr;
        char[] cArr2;
        char zai2 = zai(bufferedReader);
        if (zai2 != '\"') {
            if (zai2 == 'f') {
                if (z10) {
                    cArr = zae;
                } else {
                    cArr = zad;
                }
                zax(bufferedReader, cArr);
                return false;
            } else if (zai2 == 'n') {
                zax(bufferedReader, zaa);
                return false;
            } else if (zai2 == 't') {
                if (z10) {
                    cArr2 = zac;
                } else {
                    cArr2 = zab;
                }
                zax(bufferedReader, cArr2);
                return true;
            } else {
                StringBuilder sb2 = new StringBuilder(19);
                sb2.append("Unexpected token: ");
                sb2.append(zai2);
                throw new ParseException(sb2.toString());
            }
        } else if (!z10) {
            return zay(bufferedReader, true);
        } else {
            throw new ParseException("No boolean value found in string");
        }
    }

    private final boolean zaz(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        int i10;
        HashMap hashMap;
        String str;
        String str2;
        BufferedReader bufferedReader2 = bufferedReader;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaq2 = zaq(bufferedReader);
        if (zaq2 != null) {
            while (zaq2 != null) {
                FastJsonResponse.Field field = fieldMappings.get(zaq2);
                if (field == null) {
                    zaq2 = zar(bufferedReader);
                } else {
                    this.zat.push(4);
                    int i11 = field.zaa;
                    switch (i11) {
                        case 0:
                            if (!field.zab) {
                                fastJsonResponse2.zau(field, zal(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zav(field, zau(bufferedReader2, zag));
                                break;
                            }
                        case 1:
                            if (!field.zab) {
                                fastJsonResponse2.zae(field, zat(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zag(field, zau(bufferedReader2, zam));
                                break;
                            }
                        case 2:
                            if (!field.zab) {
                                fastJsonResponse2.zax(field, zan(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zay(field, zau(bufferedReader2, zah));
                                break;
                            }
                        case 3:
                            if (!field.zab) {
                                fastJsonResponse2.zaq(field, zak(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zas(field, zau(bufferedReader2, zai));
                                break;
                            }
                        case 4:
                            if (!field.zab) {
                                fastJsonResponse2.zam(field, zaj(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zao(field, zau(bufferedReader2, zaj));
                                break;
                            }
                        case 5:
                            if (!field.zab) {
                                fastJsonResponse2.zaa(field, zas(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zac(field, zau(bufferedReader2, zan));
                                break;
                            }
                        case 6:
                            if (!field.zab) {
                                fastJsonResponse2.zai(field, zay(bufferedReader2, false));
                                break;
                            } else {
                                fastJsonResponse2.zaj(field, zau(bufferedReader2, zak));
                                break;
                            }
                        case 7:
                            if (!field.zab) {
                                fastJsonResponse2.zaA(field, zao(bufferedReader));
                                break;
                            } else {
                                fastJsonResponse2.zaC(field, zau(bufferedReader2, zal));
                                break;
                            }
                        case 8:
                            fastJsonResponse2.zal(field, Base64Utils.decode(zap(bufferedReader2, this.zaq, this.zas, zaf)));
                            break;
                        case 9:
                            fastJsonResponse2.zal(field, Base64Utils.decodeUrlSafe(zap(bufferedReader2, this.zaq, this.zas, zaf)));
                            break;
                        case 10:
                            char zai2 = zai(bufferedReader);
                            if (zai2 == 'n') {
                                zax(bufferedReader2, zaa);
                                hashMap = null;
                            } else if (zai2 == '{') {
                                this.zat.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char zai3 = zai(bufferedReader);
                                    if (zai3 == 0) {
                                        throw new ParseException("Unexpected EOF");
                                    } else if (zai3 == '\"') {
                                        String zaA = zaA(bufferedReader2, this.zap, this.zar, (char[]) null);
                                        if (zai(bufferedReader) != ':') {
                                            String valueOf = String.valueOf(zaA);
                                            if (valueOf.length() != 0) {
                                                str = "No map value found for key ".concat(valueOf);
                                            } else {
                                                str = new String("No map value found for key ");
                                            }
                                            throw new ParseException(str);
                                        } else if (zai(bufferedReader) != '\"') {
                                            String valueOf2 = String.valueOf(zaA);
                                            if (valueOf2.length() != 0) {
                                                str2 = "Expected String value for key ".concat(valueOf2);
                                            } else {
                                                str2 = new String("Expected String value for key ");
                                            }
                                            throw new ParseException(str2);
                                        } else {
                                            hashMap.put(zaA, zaA(bufferedReader2, this.zap, this.zar, (char[]) null));
                                            char zai4 = zai(bufferedReader);
                                            if (zai4 != ',') {
                                                if (zai4 == '}') {
                                                    zaw(1);
                                                } else {
                                                    StringBuilder sb2 = new StringBuilder(48);
                                                    sb2.append("Unexpected character while parsing string map: ");
                                                    sb2.append(zai4);
                                                    throw new ParseException(sb2.toString());
                                                }
                                            }
                                        }
                                    } else if (zai3 == '}') {
                                        zaw(1);
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse2.zaB(field, hashMap);
                            break;
                        case 11:
                            if (field.zab) {
                                char zai5 = zai(bufferedReader);
                                if (zai5 == 'n') {
                                    zax(bufferedReader2, zaa);
                                    fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zae, (ArrayList) null);
                                } else {
                                    this.zat.push(5);
                                    if (zai5 == '[') {
                                        fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader2, field));
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char zai6 = zai(bufferedReader);
                                if (zai6 == 'n') {
                                    zax(bufferedReader2, zaa);
                                    fastJsonResponse2.addConcreteTypeInternal(field, field.zae, null);
                                } else {
                                    this.zat.push(1);
                                    if (zai6 == '{') {
                                        try {
                                            FastJsonResponse zad2 = field.zad();
                                            zaz(bufferedReader2, zad2);
                                            fastJsonResponse2.addConcreteTypeInternal(field, field.zae, zad2);
                                        } catch (InstantiationException e10) {
                                            throw new ParseException("Error instantiating inner object", e10);
                                        } catch (IllegalAccessException e11) {
                                            throw new ParseException("Error instantiating inner object", e11);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                            i10 = 4;
                            break;
                        default:
                            StringBuilder sb3 = new StringBuilder(30);
                            sb3.append("Invalid field type ");
                            sb3.append(i11);
                            throw new ParseException(sb3.toString());
                    }
                    i10 = 4;
                    zaw(i10);
                    zaw(2);
                    char zai7 = zai(bufferedReader);
                    if (zai7 == ',') {
                        zaq2 = zaq(bufferedReader);
                    } else if (zai7 == '}') {
                        zaq2 = null;
                    } else {
                        StringBuilder sb4 = new StringBuilder(55);
                        sb4.append("Expected end of object or field separator, but found: ");
                        sb4.append(zai7);
                        throw new ParseException(sb4.toString());
                    }
                }
            }
            zaw(1);
            return true;
        }
        zaw(1);
        return false;
    }

    @KeepForSdk
    public void parse(@NonNull InputStream inputStream, @NonNull T t10) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.zat.push(0);
            char zai2 = zai(bufferedReader);
            if (zai2 != 0) {
                if (zai2 == '[') {
                    this.zat.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t10.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        FastJsonResponse.Field field = (FastJsonResponse.Field) fieldMappings.entrySet().iterator().next().getValue();
                        t10.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                    } else {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                } else if (zai2 == '{') {
                    this.zat.push(1);
                    zaz(bufferedReader, t10);
                } else {
                    StringBuilder sb2 = new StringBuilder(19);
                    sb2.append("Unexpected token: ");
                    sb2.append(zai2);
                    throw new ParseException(sb2.toString());
                }
                zaw(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } else {
                throw new ParseException("No data to parse");
            }
        } catch (IOException e10) {
            throw new ParseException((Throwable) e10);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
