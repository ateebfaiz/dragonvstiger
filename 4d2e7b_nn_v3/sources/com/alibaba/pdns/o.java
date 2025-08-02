package com.alibaba.pdns;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.ArraySet;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.s.e.c;
import com.alibaba.pdns.u.a;
import java.lang.Character;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18137a = "o";

    /* renamed from: b  reason: collision with root package name */
    public static final int f18138b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final String f18139c = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: d  reason: collision with root package name */
    private static Context f18140d;

    @SuppressLint({"SimpleDateFormat"})
    public static String a(long j10) {
        Date date = new Date(j10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f18139c);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZone.getDefault().getDisplayName(true, 0)));
        a.a("当前时区：" + TimeZone.getDefault().getDisplayName(true, 0));
        return simpleDateFormat.format(date);
    }

    public static String b(String str, String str2, String str3, String str4) {
        if (str == null) {
            a.a(f18137a, "URL NULL");
        }
        if (str2 == null) {
            a.a(f18137a, "host NULL");
        }
        if (str3 == null) {
            a.a(f18137a, "ip NULL");
        }
        if (str == null || str2 == null || str3 == null) {
            return str;
        }
        if (TextUtils.equals(str4, "1")) {
            return str.replaceFirst(Pattern.quote(str2), Matcher.quoteReplacement(str3));
        }
        if (!TextUtils.equals(str4, DNSResolver.QTYPE_IPV6)) {
            return null;
        }
        String quote = Pattern.quote(str2);
        return str.replaceFirst(quote, Matcher.quoteReplacement("[" + str3 + "]"));
    }

    public static String c(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        String lowerCase = trim.toLowerCase();
        if (lowerCase.startsWith(c.f18246k)) {
            int indexOf = trim.indexOf(DomExceptionUtils.SEPARATOR, 8);
            if (indexOf > 7) {
                return trim.substring(7, indexOf);
            }
            return trim.substring(7);
        } else if (!lowerCase.startsWith(c.f18247l)) {
            return trim.indexOf(DomExceptionUtils.SEPARATOR, 1) > 1 ? trim.substring(0, trim.indexOf(DomExceptionUtils.SEPARATOR, 1)) : trim;
        } else {
            int indexOf2 = trim.indexOf(DomExceptionUtils.SEPARATOR, 9);
            if (indexOf2 > 8) {
                return trim.substring(8, indexOf2);
            }
            return trim.substring(8);
        }
    }

    public static String d(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static boolean e(String str) {
        char[] charArray = str.toCharArray();
        for (char a10 : charArray) {
            if (a(a10)) {
                return true;
            }
        }
        return false;
    }

    private static int[] f(String str) {
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr2[i10] = str.charAt(i10 % str.length());
            iArr[i10] = i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < 256; i12++) {
            int i13 = iArr[i12];
            i11 = ((i11 + i13) + iArr2[i12]) % 256;
            iArr[i12] = iArr[i11];
            iArr[i11] = i13;
        }
        return iArr;
    }

    public static String g(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        int i10 = 0;
        if (str2 == null) {
            while (i10 != length && Character.isWhitespace(str.charAt(i10))) {
                i10++;
            }
        } else if (str2.isEmpty()) {
            return str;
        } else {
            while (i10 != length && str2.indexOf(str.charAt(i10)) != -1) {
                i10++;
            }
        }
        return str.substring(i10);
    }

    public static boolean h(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String trim = str.trim();
        if (trim.contains(":")) {
            String[] split = trim.split(":");
            if (split != null && split.length == 2) {
                trim = split[0].trim();
            }
        } else if (trim.length() < 7 || trim.length() > 15 || "".equals(trim)) {
            return false;
        }
        boolean find = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$").matcher(trim).find();
        long currentTimeMillis2 = System.currentTimeMillis();
        a.a("Tools:", "regular time spend : " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        return find;
    }

    public static boolean i(String str) {
        try {
            return InetAddress.getByName(str) instanceof Inet4Address;
        } catch (UnknownHostException e10) {
            if (a.f18279a) {
                e10.printStackTrace();
            }
            return false;
        } catch (Error | Exception e11) {
            if (a.f18279a) {
                e11.printStackTrace();
            }
            return false;
        }
    }

    public static boolean j(String str) {
        try {
            if (!str.startsWith("[")) {
                return false;
            }
            if (!str.endsWith("]")) {
                return false;
            }
            if (InetAddress.getByName(str.substring(1, str.lastIndexOf("]"))) instanceof Inet6Address) {
                return true;
            }
            return false;
        } catch (UnknownHostException e10) {
            if (a.f18279a) {
                e10.printStackTrace();
            }
            return false;
        } catch (Error | Exception e11) {
            if (a.f18279a) {
                e11.printStackTrace();
            }
            return false;
        }
    }

    public static boolean k(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (!(byName instanceof Inet4Address)) {
                if (byName instanceof Inet6Address) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (UnknownHostException e10) {
            if (a.f18279a) {
                e10.printStackTrace();
            }
            return false;
        } catch (Error | Exception e11) {
            if (a.f18279a) {
                e11.printStackTrace();
            }
            return false;
        }
    }

    public static long d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH).parse(str).getTime();
            }
        } catch (Error | Exception e10) {
            if (a.f18279a) {
                e10.printStackTrace();
            }
        }
        return 0;
    }

    public static String e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return f(g(str, str2), str2);
    }

    public static String a(boolean z10, boolean z11, int i10) {
        char c10;
        int i11 = i10 / 60000;
        if (i11 < 0) {
            i11 = -i11;
            c10 = '-';
        } else {
            c10 = '+';
        }
        StringBuilder sb2 = new StringBuilder(9);
        if (z10) {
            sb2.append("GMT");
        }
        sb2.append(c10);
        a(sb2, 2, i11 / 60);
        if (z11) {
            sb2.append(':');
        }
        a(sb2, 2, i11 % 60);
        return sb2.toString();
    }

    public static boolean g(String str) {
        try {
            return Pattern.compile("(\\w*\\.?){1,3}\\.(com.cn|net.cn|gov.cn|org\\.nz|org.cn|com|net|org|gov|cc|biz|info|cn|co)$").matcher(str).find();
        } catch (Error | Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static String b(String str) {
        return a(Long.valueOf(str).longValue());
    }

    public static String f(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else if (str2.isEmpty()) {
            return str;
        } else {
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String b() {
        return a(true, true, TimeZone.getDefault().getRawOffset());
    }

    public static String b(String str, String str2, String str3) {
        String str4;
        if (str3.indexOf("//") == -1) {
            return "";
        }
        String[] split = str3.split("//");
        String str5 = split[0] + "//";
        if (str2 != null) {
            str4 = str5 + str + ":" + str2;
        } else {
            str4 = str5 + str;
        }
        if (split.length < 1 || split[1].indexOf(DomExceptionUtils.SEPARATOR) == -1) {
            a.a("replaceUrl:" + str4);
            return str4;
        }
        String[] split2 = split[1].split(DomExceptionUtils.SEPARATOR);
        if (split2.length > 1) {
            for (int i10 = 1; i10 < split2.length; i10++) {
                str4 = str4 + DomExceptionUtils.SEPARATOR + split2[i10];
            }
        }
        a.a("replaceUrl:" + str4);
        return str4;
    }

    public static String c(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmMMdd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String format = simpleDateFormat.format(new Date());
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            return a(instance.doFinal((str + format + str2).getBytes()));
        } catch (InvalidKeyException | NoSuchAlgorithmException e10) {
            if (a.f18279a) {
                e10.printStackTrace();
            }
            return null;
        } catch (Error | Exception e11) {
            if (a.f18279a) {
                e11.printStackTrace();
            }
            return null;
        }
    }

    private static void a(StringBuilder sb2, int i10, int i11) {
        String num = Integer.toString(i11);
        for (int i12 = 0; i12 < i10 - num.length(); i12++) {
            sb2.append('0');
        }
        sb2.append(num);
    }

    public static CopyOnWriteArrayList a(CopyOnWriteArrayList<com.alibaba.pdns.model.c> copyOnWriteArrayList) {
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        copyOnWriteArrayList2.addAll(copyOnWriteArrayList);
        int size = copyOnWriteArrayList2.size();
        com.alibaba.pdns.model.c[] cVarArr = new com.alibaba.pdns.model.c[size];
        Random random = new Random();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            cVarArr[i11] = (com.alibaba.pdns.model.c) copyOnWriteArrayList2.remove(random.nextInt(size - i11));
        }
        ListIterator<com.alibaba.pdns.model.c> listIterator = copyOnWriteArrayList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(cVarArr[i10]);
            i10++;
        }
        return copyOnWriteArrayList2;
    }

    public static String b(String str, String str2) {
        try {
            return c.f().a().b(a(str, str2.getBytes(StandardCharsets.UTF_8)));
        } catch (Error | Exception e10) {
            if (!a.f18279a) {
                return "";
            }
            e10.printStackTrace();
            return "";
        }
    }

    public static String c() {
        int ipAddress = ((WifiManager) b.d().getSystemService("wifi")).getConnectionInfo().getIpAddress();
        return String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
    }

    public static String b(int i10) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < i10; i11++) {
            stringBuffer.append("zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.util.HashMap<java.lang.String, java.lang.String> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "{}"
            org.json.JSONStringer r1 = new org.json.JSONStringer
            r1.<init>()
            org.json.JSONStringer r1 = r1.object()     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
        L_0x0013:
            boolean r2 = r5.hasNext()     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r5.next()     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            org.json.JSONStringer r1 = r1.key(r3)     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            org.json.JSONStringer r1 = r1.value(r2)     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            goto L_0x0013
        L_0x0032:
            r5 = move-exception
            goto L_0x0041
        L_0x0034:
            r5 = move-exception
            goto L_0x0041
        L_0x0036:
            r5 = move-exception
            goto L_0x0049
        L_0x0038:
            org.json.JSONStringer r5 = r1.endObject()     // Catch:{ JSONException -> 0x0036, Exception -> 0x0034, Error -> 0x0032 }
            java.lang.String r5 = r5.toString()
            return r5
        L_0x0041:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x0048
            r5.printStackTrace()
        L_0x0048:
            return r0
        L_0x0049:
            boolean r1 = com.alibaba.pdns.u.a.f18279a
            if (r1 == 0) goto L_0x0050
            r5.printStackTrace()
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pdns.o.a(java.util.HashMap):java.lang.String");
    }

    public static boolean a(char c10) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c10);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static String a(String str, String str2) {
        try {
            return new String(a(str, c.e().a(str2)), StandardCharsets.UTF_8);
        } catch (Error | Exception e10) {
            if (!a.f18279a) {
                return "";
            }
            e10.printStackTrace();
            return "";
        }
    }

    private static byte[] a(String str, byte[] bArr) {
        int[] f10 = f(str);
        byte[] bArr2 = new byte[bArr.length];
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            i11 = (i11 + 1) % 256;
            int i13 = f10[i11];
            i10 = (i10 + i13) % 256;
            f10[i11] = f10[i10];
            f10[i10] = i13;
            bArr2[i12] = (byte) (f10[(f10[i11] + i13) % 256] ^ bArr[i12]);
        }
        return bArr2;
    }

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (bArr != null && i10 < bArr.length) {
            String hexString = Integer.toHexString(bArr[i10] & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
            i10++;
        }
        return sb2.toString().toLowerCase();
    }

    public static <T> T[] a(T[] tArr, T[] tArr2) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, copyOf, tArr.length, tArr2.length);
        return copyOf;
    }

    public static Float a(Float f10, Float f11) {
        return Float.valueOf(new BigDecimal(Math.random()).multiply(new BigDecimal((double) (f11.floatValue() - f10.floatValue()))).add(new BigDecimal((double) f10.floatValue())).setScale(6, 3).floatValue());
    }

    public static String a(String str, String str2, String str3) {
        if (DNSResolver.ispEnable()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("_");
            stringBuffer.append(str2);
            stringBuffer.append("_");
            stringBuffer.append(str3);
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("_");
        stringBuffer2.append(str2);
        stringBuffer2.append("_");
        stringBuffer2.append(str3);
        return stringBuffer2.toString();
    }

    public static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(str);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("_");
        stringBuffer.append(str2);
        stringBuffer.append("_");
        stringBuffer.append(str3);
        stringBuffer.append("_");
        stringBuffer.append(str4);
        return stringBuffer.toString();
    }

    public static boolean a(Set<String> set, Set<String> set2) {
        if (set.size() != set2.size()) {
            return false;
        }
        return set.equals(set2);
    }

    public static <E> Set<E> a(int i10) {
        return new ArraySet(i10);
    }

    public static <E> Set<E> a() {
        return new ArraySet();
    }
}
