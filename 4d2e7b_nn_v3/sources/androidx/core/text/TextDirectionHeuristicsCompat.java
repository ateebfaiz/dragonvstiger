package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new e(a.f15111b, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE = f.f15116b;
    public static final TextDirectionHeuristicCompat LTR = new e((c) null, false);
    public static final TextDirectionHeuristicCompat RTL = new e((c) null, true);
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    private static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        static final a f15111b = new a(true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f15112a;

        private a(boolean z10) {
            this.f15112a = z10;
        }

        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int isRtlText = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(charSequence.charAt(i10)));
                if (isRtlText != 0) {
                    if (isRtlText != 1) {
                        continue;
                        i10++;
                    } else if (!this.f15112a) {
                        return 1;
                    }
                } else if (this.f15112a) {
                    return 0;
                }
                z10 = true;
                i10++;
            }
            if (z10) {
                return this.f15112a ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f15113a = new b();

        private b() {
        }

        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int i13 = 2;
            while (i10 < i12 && i13 == 2) {
                i13 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return i13;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    private static abstract class d implements TextDirectionHeuristicCompat {

        /* renamed from: a  reason: collision with root package name */
        private final c f15114a;

        d(c cVar) {
            this.f15114a = cVar;
        }

        private boolean b(CharSequence charSequence, int i10, int i11) {
            int a10 = this.f15114a.a(charSequence, i10, i11);
            if (a10 == 0) {
                return true;
            }
            if (a10 != 1) {
                return a();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract boolean a();

        public boolean isRtl(char[] cArr, int i10, int i11) {
            return isRtl((CharSequence) CharBuffer.wrap(cArr), i10, i11);
        }

        public boolean isRtl(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            } else if (this.f15114a == null) {
                return a();
            } else {
                return b(charSequence, i10, i11);
            }
        }
    }

    private static class e extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f15115b;

        e(c cVar, boolean z10) {
            super(cVar);
            this.f15115b = z10;
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return this.f15115b;
        }
    }

    private static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        static final f f15116b = new f();

        f() {
            super((c) null);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static {
        b bVar = b.f15113a;
        FIRSTSTRONG_LTR = new e(bVar, false);
        FIRSTSTRONG_RTL = new e(bVar, true);
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int isRtlText(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int isRtlTextOrFormat(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
