package com.reactnativecommunity.webview;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11327a = Pattern.compile("attachment(?:;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1)?(?:;\\s*filename\\s*\\*\\s*=\\s*([^']*)'[^']*'([^']*))?\\s*$", 2);

    public static final String a(String str, String str2, String str3) {
        String str4;
        String decode;
        int lastIndexOf;
        int lastIndexOf2;
        String str5 = null;
        if (str2 != null) {
            str4 = b(str2);
            if (str4 != null && (lastIndexOf2 = str4.lastIndexOf(47) + 1) > 0) {
                str4 = str4.substring(lastIndexOf2);
            }
        } else {
            str4 = null;
        }
        if (str4 == null && (decode = Uri.decode(str)) != null) {
            int indexOf = decode.indexOf(63);
            if (indexOf > 0) {
                decode = decode.substring(0, indexOf);
            }
            if (!decode.endsWith(DomExceptionUtils.SEPARATOR) && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                str4 = decode.substring(lastIndexOf);
            }
        }
        if (str4 == null) {
            str4 = "downloadfile";
        }
        int indexOf2 = str4.indexOf(46);
        if (indexOf2 < 0) {
            if (!(str3 == null || (str5 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3)) == null)) {
                str5 = f.G + str5;
            }
            if (str5 == null) {
                if (str3 == null || !str3.toLowerCase(Locale.ROOT).startsWith("text/")) {
                    str5 = ".bin";
                } else if (str3.equalsIgnoreCase("text/html")) {
                    str5 = ".html";
                } else {
                    str5 = ".txt";
                }
            }
        } else {
            if (str3 != null) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str4.substring(str4.lastIndexOf(46) + 1));
                if (!(mimeTypeFromExtension == null || mimeTypeFromExtension.equalsIgnoreCase(str3) || (str5 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str3)) == null)) {
                    str5 = f.G + str5;
                }
            }
            if (str5 == null) {
                str5 = str4.substring(indexOf2);
            }
            str4 = str4.substring(0, indexOf2);
        }
        return str4 + str5;
    }

    static String b(String str) {
        String str2;
        try {
            Matcher matcher = f11327a.matcher(str);
            if (!matcher.find()) {
                return null;
            }
            if (!(matcher.group(3) == null || matcher.group(4) == null)) {
                try {
                    String group = matcher.group(4);
                    if (matcher.group(3).isEmpty()) {
                        str2 = "UTF-8";
                    } else {
                        str2 = matcher.group(3);
                    }
                    return URLDecoder.decode(group, str2);
                } catch (UnsupportedEncodingException unused) {
                }
            }
            return matcher.group(2);
        } catch (IllegalStateException unused2) {
            return null;
        }
    }
}
