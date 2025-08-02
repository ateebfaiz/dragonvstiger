package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.g;
import kotlin.ranges.l;
import kotlin.text.j;

public final class MediaType {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    /* access modifiers changed from: private */
    public static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        /* renamed from: -deprecated_get  reason: not valid java name */
        public final MediaType m76deprecated_get(String str) {
            m.f(str, "mediaType");
            return get(str);
        }

        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final MediaType m77deprecated_parse(String str) {
            m.f(str, "mediaType");
            return parse(str);
        }

        public final MediaType get(String str) {
            m.f(str, "$this$toMediaType");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                m.e(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                m.e(locale, "Locale.US");
                if (group != null) {
                    String lowerCase = group.toLowerCase(locale);
                    m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String group2 = matcher.group(2);
                    m.e(group2, "typeSubtype.group(2)");
                    m.e(locale, "Locale.US");
                    if (group2 != null) {
                        String lowerCase2 = group2.toLowerCase(locale);
                        m.e(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        ArrayList arrayList = new ArrayList();
                        Matcher matcher2 = MediaType.PARAMETER.matcher(str);
                        int end = matcher.end();
                        while (end < str.length()) {
                            matcher2.region(end, str.length());
                            if (matcher2.lookingAt()) {
                                String group3 = matcher2.group(1);
                                if (group3 == null) {
                                    end = matcher2.end();
                                } else {
                                    String group4 = matcher2.group(2);
                                    if (group4 == null) {
                                        group4 = matcher2.group(3);
                                    } else if (j.F(group4, "'", false, 2, (Object) null) && j.p(group4, "'", false, 2, (Object) null) && group4.length() > 2) {
                                        group4 = group4.substring(1, group4.length() - 1);
                                        m.e(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    }
                                    arrayList.add(group3);
                                    arrayList.add(group4);
                                    end = matcher2.end();
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Parameter is not formatted correctly: \"");
                                String substring = str.substring(end);
                                m.e(substring, "(this as java.lang.String).substring(startIndex)");
                                sb2.append(substring);
                                sb2.append("\" for: \"");
                                sb2.append(str);
                                sb2.append('\"');
                                throw new IllegalArgumentException(sb2.toString().toString());
                            }
                        }
                        Object[] array = arrayList.toArray(new String[0]);
                        if (array != null) {
                            return new MediaType(str, lowerCase, lowerCase2, (String[]) array, (DefaultConstructorMarker) null);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }

        public final MediaType parse(String str) {
            m.f(str, "$this$toMediaTypeOrNull");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType2, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = null;
        }
        return mediaType2.charset(charset);
    }

    public static final MediaType get(String str) {
        return Companion.get(str);
    }

    public static final MediaType parse(String str) {
        return Companion.parse(str);
    }

    /* renamed from: -deprecated_subtype  reason: not valid java name */
    public final String m74deprecated_subtype() {
        return this.subtype;
    }

    /* renamed from: -deprecated_type  reason: not valid java name */
    public final String m75deprecated_type() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, (Charset) null, 1, (Object) null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaType) || !m.b(((MediaType) obj).mediaType, this.mediaType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String parameter(String str) {
        m.f(str, "name");
        g k10 = l.k(kotlin.collections.j.x(this.parameterNamesAndValues), 2);
        int a10 = k10.a();
        int c10 = k10.c();
        int d10 = k10.d();
        if (d10 >= 0) {
            if (a10 > c10) {
                return null;
            }
        } else if (a10 < c10) {
            return null;
        }
        while (!j.q(this.parameterNamesAndValues[a10], str, true)) {
            if (a10 == c10) {
                return null;
            }
            a10 += d10;
        }
        return this.parameterNamesAndValues[a10 + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, strArr);
    }

    public final Charset charset(Charset charset) {
        String parameter = parameter("charset");
        if (parameter == null) {
            return charset;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
