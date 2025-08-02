package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    static final BidiFormatter DEFAULT_LTR_INSTANCE;
    static final BidiFormatter DEFAULT_RTL_INSTANCE;
    static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '‪';
    private static final char LRM = '‎';
    private static final String LRM_STRING = Character.toString(LRM);
    private static final char PDF = '‬';
    private static final char RLE = '‫';
    private static final char RLM = '‏';
    private static final String RLM_STRING = Character.toString(RLM);
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    private static class a {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f15103f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f15104a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f15105b;

        /* renamed from: c  reason: collision with root package name */
        private final int f15106c;

        /* renamed from: d  reason: collision with root package name */
        private int f15107d;

        /* renamed from: e  reason: collision with root package name */
        private char f15108e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f15103f[i10] = Character.getDirectionality(i10);
            }
        }

        a(CharSequence charSequence, boolean z10) {
            this.f15104a = charSequence;
            this.f15105b = z10;
            this.f15106c = charSequence.length();
        }

        private static byte c(char c10) {
            if (c10 < 1792) {
                return f15103f[c10];
            }
            return Character.getDirectionality(c10);
        }

        private byte f() {
            char charAt;
            int i10 = this.f15107d;
            do {
                int i11 = this.f15107d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f15104a;
                int i12 = i11 - 1;
                this.f15107d = i12;
                charAt = charSequence.charAt(i12);
                this.f15108e = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.f15107d = i10;
            this.f15108e = ';';
            return 13;
        }

        private byte g() {
            char charAt;
            do {
                int i10 = this.f15107d;
                if (i10 >= this.f15106c) {
                    return 12;
                }
                CharSequence charSequence = this.f15104a;
                this.f15107d = i10 + 1;
                charAt = charSequence.charAt(i10);
                this.f15108e = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte h() {
            char charAt;
            int i10 = this.f15107d;
            while (true) {
                int i11 = this.f15107d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f15104a;
                int i12 = i11 - 1;
                this.f15107d = i12;
                char charAt2 = charSequence.charAt(i12);
                this.f15108e = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i13 = this.f15107d;
                        if (i13 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f15104a;
                        int i14 = i13 - 1;
                        this.f15107d = i14;
                        charAt = charSequence2.charAt(i14);
                        this.f15108e = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.f15107d = i10;
            this.f15108e = '>';
            return 13;
        }

        private byte i() {
            char charAt;
            int i10 = this.f15107d;
            while (true) {
                int i11 = this.f15107d;
                if (i11 < this.f15106c) {
                    CharSequence charSequence = this.f15104a;
                    this.f15107d = i11 + 1;
                    char charAt2 = charSequence.charAt(i11);
                    this.f15108e = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i12 = this.f15107d;
                            if (i12 >= this.f15106c) {
                                break;
                            }
                            CharSequence charSequence2 = this.f15104a;
                            this.f15107d = i12 + 1;
                            charAt = charSequence2.charAt(i12);
                            this.f15108e = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f15107d = i10;
                    this.f15108e = '<';
                    return 13;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public byte a() {
            char charAt = this.f15104a.charAt(this.f15107d - 1);
            this.f15108e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f15104a, this.f15107d);
                this.f15107d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f15107d--;
            byte c10 = c(this.f15108e);
            if (!this.f15105b) {
                return c10;
            }
            char c11 = this.f15108e;
            if (c11 == '>') {
                return h();
            }
            if (c11 == ';') {
                return f();
            }
            return c10;
        }

        /* access modifiers changed from: package-private */
        public byte b() {
            char charAt = this.f15104a.charAt(this.f15107d);
            this.f15108e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f15104a, this.f15107d);
                this.f15107d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f15107d++;
            byte c10 = c(this.f15108e);
            if (!this.f15105b) {
                return c10;
            }
            char c11 = this.f15108e;
            if (c11 == '<') {
                return i();
            }
            if (c11 == '&') {
                return g();
            }
            return c10;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            this.f15107d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f15107d < this.f15106c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 == 1 || b10 == 2) {
                        if (i12 == 0) {
                            return 1;
                        }
                    } else if (b10 != 9) {
                        switch (b10) {
                            case 14:
                            case 15:
                                i12++;
                                i11 = -1;
                                continue;
                            case 16:
                            case 17:
                                i12++;
                                i11 = 1;
                                continue;
                            case 18:
                                i12--;
                                i11 = 0;
                                continue;
                        }
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f15107d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        break;
                    case 18:
                        i12++;
                        continue;
                }
                i12--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int e() {
            this.f15107d = this.f15106c;
            int i10 = 0;
            while (true) {
                int i11 = i10;
                while (this.f15107d > 0) {
                    byte a10 = a();
                    if (a10 != 0) {
                        if (a10 == 1 || a10 == 2) {
                            if (i10 == 0) {
                                return 1;
                            }
                            if (i11 == 0) {
                            }
                        } else if (a10 != 9) {
                            switch (a10) {
                                case 14:
                                case 15:
                                    if (i11 == i10) {
                                        return -1;
                                    }
                                    break;
                                case 16:
                                case 17:
                                    if (i11 == i10) {
                                        return 1;
                                    }
                                    break;
                                case 18:
                                    i10++;
                                    break;
                                default:
                                    if (i11 != 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            i10--;
                        } else {
                            continue;
                        }
                    } else if (i10 == 0) {
                        return -1;
                    } else {
                        if (i11 == 0) {
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        DEFAULT_TEXT_DIRECTION_HEURISTIC = textDirectionHeuristicCompat;
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    BidiFormatter(boolean z10, int i10, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z10;
        this.mFlags = i10;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    private static int getEntryDir(CharSequence charSequence) {
        return new a(charSequence, false).d();
    }

    private static int getExitDir(CharSequence charSequence) {
        return new a(charSequence, false).e();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    static boolean isRtlLocale(Locale locale) {
        if (TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1) {
            return true;
        }
        return false;
    }

    private String markAfter(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getExitDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (!this.mIsRtlContext) {
            return "";
        }
        if (!isRtl || getExitDir(charSequence) == -1) {
            return RLM_STRING;
        }
        return "";
    }

    private String markBefore(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.mIsRtlContext && (isRtl || getEntryDir(charSequence) == 1)) {
            return LRM_STRING;
        }
        if (!this.mIsRtlContext) {
            return "";
        }
        if (!isRtl || getEntryDir(charSequence) == -1) {
            return RLM_STRING;
        }
        return "";
    }

    public boolean getStereoReset() {
        if ((this.mFlags & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean isRtl(String str) {
        return isRtl((CharSequence) str);
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z10) {
        if (str == null) {
            return null;
        }
        return unicodeWrap((CharSequence) str, textDirectionHeuristicCompat, z10).toString();
    }

    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z10) {
            if (z10) {
                return BidiFormatter.DEFAULT_RTL_INSTANCE;
            }
            return BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z10) {
            this.mIsRtlContext = z10;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public BidiFormatter build() {
            if (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return getDefaultInstanceFromContext(this.mIsRtlContext);
            }
            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public Builder stereoReset(boolean z10) {
            if (z10) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }

        public Builder(boolean z10) {
            initialize(z10);
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }
    }

    public static BidiFormatter getInstance(boolean z10) {
        return new Builder(z10).build();
    }

    public boolean isRtl(CharSequence charSequence) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z10) {
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (getStereoReset() && z10) {
            spannableStringBuilder.append(markBefore(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            spannableStringBuilder.append(isRtl ? RLE : LRE);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(PDF);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            spannableStringBuilder.append(markAfter(charSequence, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return spannableStringBuilder;
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(charSequence, textDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String str, boolean z10) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z10);
    }

    public CharSequence unicodeWrap(CharSequence charSequence, boolean z10) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, z10);
    }

    public String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence charSequence) {
        return unicodeWrap(charSequence, this.mDefaultTextDirectionHeuristicCompat, true);
    }
}
