package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import com.alibaba.pdns.s.e.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
    private static final Comparator<b> COMPARATOR = new b();
    private static final String[] EMPTY_STRING = new String[0];

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    static class a {
        @DoNotInline
        static void a(TextView textView, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
        }

        @DoNotInline
        static boolean b(Spannable spannable, Pattern pattern, String str, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        URLSpan f15117a;

        /* renamed from: b  reason: collision with root package name */
        String f15118b;

        /* renamed from: c  reason: collision with root package name */
        int f15119c;

        /* renamed from: d  reason: collision with root package name */
        int f15120d;

        b() {
        }
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(@NonNull TextView textView) {
        if (!(textView.getMovementMethod() instanceof LinkMovementMethod) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, int i10) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, i10);
        }
        if (i10 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i10 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i10 & 1) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{c.f18246k, c.f18247l, "rtsp://"}, Linkify.sUrlMatchFilter, (Linkify.TransformFilter) null);
        }
        if ((i10 & 2) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
        if ((i10 & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f15117a == null) {
                applyLink(bVar.f15118b, bVar.f15119c, bVar.f15120d, spannable);
            }
        }
        return true;
    }

    private static void applyLink(String str, int i10, int i11, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i10, i11, 33);
    }

    private static String findAddress(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            return WebView.findAddress(str);
        }
        return a.c(str);
    }

    private static void gatherLinks(ArrayList<b> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if ((matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) && group != null) {
                b bVar = new b();
                bVar.f15118b = makeUrl(group, strArr, matcher, transformFilter);
                bVar.f15119c = start;
                bVar.f15120d = end;
                arrayList.add(bVar);
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0005 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A[LOOP:0: B:1:0x0005->B:14:0x0005, LOOP_START, PHI: r0 r6 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:0:0x0000, B:14:0x0005] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r6v2 java.lang.String) = (r6v1 java.lang.String), (r6v3 java.lang.String) binds: [B:0:0x0000, B:14:0x0005] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void gatherMapLinks(java.util.ArrayList<androidx.core.text.util.LinkifyCompat.b> r5, android.text.Spannable r6) {
        /*
            java.lang.String r6 = r6.toString()
            r0 = 0
        L_0x0005:
            java.lang.String r1 = findAddress(r6)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            if (r1 == 0) goto L_0x0043
            int r2 = r6.indexOf(r1)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            if (r2 >= 0) goto L_0x0012
            goto L_0x0043
        L_0x0012:
            androidx.core.text.util.LinkifyCompat$b r3 = new androidx.core.text.util.LinkifyCompat$b     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r3.<init>()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r4 = r1.length()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r4 = r4 + r2
            int r2 = r2 + r0
            r3.f15119c = r2     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r0 = r0 + r4
            r3.f15120d = r0     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r6 = r6.substring(r4)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r2 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x0005 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r2.<init>()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r4 = "geo:0,0?q="
            r2.append(r4)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r2.append(r1)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r1 = r2.toString()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r3.f15118b = r1     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r5.add(r3)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            goto L_0x0005
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.LinkifyCompat.gatherMapLinks(java.util.ArrayList, android.text.Spannable):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(b bVar, b bVar2) {
        int i10 = bVar.f15119c;
        int i11 = bVar2.f15119c;
        if (i10 < i11) {
            return -1;
        }
        if (i10 > i11) {
            return 1;
        }
        return Integer.compare(bVar2.f15120d, bVar.f15120d);
    }

    private static String makeUrl(@NonNull String str, @NonNull String[] strArr, Matcher matcher, @Nullable Linkify.TransformFilter transformFilter) {
        boolean z10;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            String str2 = strArr[i10];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                z10 = true;
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i10++;
            }
        }
        if (z10 || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void pruneOverlaps(ArrayList<b> arrayList, Spannable spannable) {
        int i10;
        int i11;
        int i12 = 0;
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            b bVar = new b();
            bVar.f15117a = uRLSpan;
            bVar.f15119c = spannable.getSpanStart(uRLSpan);
            bVar.f15120d = spannable.getSpanEnd(uRLSpan);
            arrayList.add(bVar);
        }
        Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i12 < size - 1) {
            b bVar2 = arrayList.get(i12);
            int i13 = i12 + 1;
            b bVar3 = arrayList.get(i13);
            int i14 = bVar2.f15119c;
            int i15 = bVar3.f15119c;
            if (i14 <= i15 && (i10 = bVar2.f15120d) > i15) {
                int i16 = bVar3.f15120d;
                if (i16 <= i10 || i10 - i14 > i16 - i15) {
                    i11 = i13;
                } else if (i10 - i14 < i16 - i15) {
                    i11 = i12;
                } else {
                    i11 = -1;
                }
                if (i11 != -1) {
                    URLSpan uRLSpan2 = arrayList.get(i11).f15117a;
                    if (uRLSpan2 != null) {
                        spannable.removeSpan(uRLSpan2);
                    }
                    arrayList.remove(i11);
                    size--;
                }
            }
            i12 = i13;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    public static boolean addLinks(@NonNull TextView textView, int i10) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(textView, i10);
        }
        if (i10 == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            SpannableString valueOf = SpannableString.valueOf(text);
            if (addLinks((Spannable) valueOf, i10)) {
                addLinkMovementMethod(textView);
                textView.setText(valueOf);
                return true;
            }
        } else if (addLinks((Spannable) text, i10)) {
            addLinkMovementMethod(textView);
            return true;
        }
        return false;
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            a.a(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks((Spannable) valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str);
        }
        return addLinks(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter);
        }
        return addLinks(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        String str2;
        if (shouldAddLinksFallbackToFramework()) {
            return a.b(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = EMPTY_STRING;
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i10 = 0;
        while (i10 < strArr.length) {
            String str3 = strArr[i10];
            i10++;
            if (str3 == null) {
                str2 = "";
            } else {
                str2 = str3.toLowerCase(Locale.ROOT);
            }
            strArr2[i10] = str2;
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z10 = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if ((matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) && group != null) {
                applyLink(makeUrl(group, strArr2, matcher, transformFilter), start, end, spannable);
                z10 = true;
            }
        }
        return z10;
    }
}
