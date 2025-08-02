package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

final class g {

    /* renamed from: a  reason: collision with root package name */
    private final EmojiCompat.d f15450a;

    /* renamed from: b  reason: collision with root package name */
    private final MetadataRepo f15451b;

    /* renamed from: c  reason: collision with root package name */
    private EmojiCompat.GlyphChecker f15452c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15453d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f15454e;

    private static final class a {
        static int a(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    i10--;
                    if (i10 >= 0) {
                        char charAt = charSequence.charAt(i10);
                        if (z10) {
                            if (!Character.isHighSurrogate(charAt)) {
                                return -1;
                            }
                            i11--;
                        } else if (!Character.isSurrogate(charAt)) {
                            i11--;
                        } else if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        } else {
                            z10 = true;
                        }
                    } else if (z10) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
                return i10;
            }
        }

        static int b(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    if (r7 < length) {
                        char charAt = charSequence.charAt(r7);
                        if (z10) {
                            if (!Character.isLowSurrogate(charAt)) {
                                return -1;
                            }
                            i11--;
                            i10 = r7 + 1;
                        } else if (!Character.isSurrogate(charAt)) {
                            i11--;
                            r7++;
                        } else if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        } else {
                            r7++;
                            z10 = true;
                        }
                    } else if (z10) {
                        return -1;
                    } else {
                        return length;
                    }
                }
                return r7;
            }
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f15455a = 1;

        /* renamed from: b  reason: collision with root package name */
        private final MetadataRepo.a f15456b;

        /* renamed from: c  reason: collision with root package name */
        private MetadataRepo.a f15457c;

        /* renamed from: d  reason: collision with root package name */
        private MetadataRepo.a f15458d;

        /* renamed from: e  reason: collision with root package name */
        private int f15459e;

        /* renamed from: f  reason: collision with root package name */
        private int f15460f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f15461g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f15462h;

        b(MetadataRepo.a aVar, boolean z10, int[] iArr) {
            this.f15456b = aVar;
            this.f15457c = aVar;
            this.f15461g = z10;
            this.f15462h = iArr;
        }

        private static boolean d(int i10) {
            return i10 == 65039;
        }

        private static boolean f(int i10) {
            return i10 == 65038;
        }

        private int g() {
            this.f15455a = 1;
            this.f15457c = this.f15456b;
            this.f15460f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f15457c.b().isDefaultEmoji() || d(this.f15459e)) {
                return true;
            }
            if (this.f15461g) {
                if (this.f15462h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f15462h, this.f15457c.b().getCodepointAt(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int a(int i10) {
            MetadataRepo.a a10 = this.f15457c.a(i10);
            int i11 = 2;
            if (this.f15455a != 2) {
                if (a10 == null) {
                    i11 = g();
                } else {
                    this.f15455a = 2;
                    this.f15457c = a10;
                    this.f15460f = 1;
                }
            } else if (a10 != null) {
                this.f15457c = a10;
                this.f15460f++;
            } else if (f(i10)) {
                i11 = g();
            } else if (!d(i10)) {
                if (this.f15457c.b() != null) {
                    i11 = 3;
                    if (this.f15460f != 1) {
                        this.f15458d = this.f15457c;
                        g();
                    } else if (h()) {
                        this.f15458d = this.f15457c;
                        g();
                    } else {
                        i11 = g();
                    }
                } else {
                    i11 = g();
                }
            }
            this.f15459e = i10;
            return i11;
        }

        /* access modifiers changed from: package-private */
        public EmojiMetadata b() {
            return this.f15457c.b();
        }

        /* access modifiers changed from: package-private */
        public EmojiMetadata c() {
            return this.f15458d.b();
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            if (this.f15455a != 2 || this.f15457c.b() == null || (this.f15460f <= 1 && !h())) {
                return false;
            }
            return true;
        }
    }

    g(MetadataRepo metadataRepo, EmojiCompat.d dVar, EmojiCompat.GlyphChecker glyphChecker, boolean z10, int[] iArr) {
        this.f15450a = dVar;
        this.f15451b = metadataRepo;
        this.f15452c = glyphChecker;
        this.f15453d = z10;
        this.f15454e = iArr;
    }

    private void a(Spannable spannable, EmojiMetadata emojiMetadata, int i10, int i11) {
        spannable.setSpan(this.f15450a.a(emojiMetadata), i10, i11, 33);
    }

    private static boolean b(Editable editable, KeyEvent keyEvent, boolean z10) {
        EmojiSpan[] emojiSpanArr;
        if (i(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!h(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            int length = emojiSpanArr.length;
            int i10 = 0;
            while (i10 < length) {
                EmojiSpan emojiSpan = emojiSpanArr[i10];
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((!z10 || spanStart != selectionStart) && ((z10 || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i10++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean e(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        int i12;
        int i13;
        if (editable != null && inputConnection != null && i10 >= 0 && i11 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (h(selectionStart, selectionEnd)) {
                return false;
            }
            if (z10) {
                i13 = a.a(editable, selectionStart, Math.max(i10, 0));
                i12 = a.b(editable, selectionEnd, Math.max(i11, 0));
                if (i13 == -1 || i12 == -1) {
                    return false;
                }
            } else {
                i13 = Math.max(selectionStart - i10, 0);
                i12 = Math.min(selectionEnd + i11, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(i13, i12, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    i13 = Math.min(spanStart, i13);
                    i12 = Math.max(spanEnd, i12);
                }
                int max = Math.max(i13, 0);
                int min = Math.min(i12, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max, min);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean f(Editable editable, int i10, KeyEvent keyEvent) {
        boolean z10;
        if (i10 == 67) {
            z10 = b(editable, keyEvent, false);
        } else if (i10 != 112) {
            z10 = false;
        } else {
            z10 = b(editable, keyEvent, true);
        }
        if (!z10) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean g(CharSequence charSequence, int i10, int i11, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.getHasGlyph() == 0) {
            emojiMetadata.setHasGlyph(this.f15452c.hasGlyph(charSequence, i10, i11, emojiMetadata.getSdkAdded()));
        }
        if (emojiMetadata.getHasGlyph() == 2) {
            return true;
        }
        return false;
    }

    private static boolean h(int i10, int i11) {
        return i10 == -1 || i11 == -1 || i10 != i11;
    }

    private static boolean i(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* access modifiers changed from: package-private */
    public int c(CharSequence charSequence) {
        return d(charSequence, this.f15451b.getMetadataVersion());
    }

    /* access modifiers changed from: package-private */
    public int d(CharSequence charSequence, int i10) {
        b bVar = new b(this.f15451b.getRootNode(), this.f15453d, this.f15454e);
        int length = charSequence.length();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int codePointAt = Character.codePointAt(charSequence, i11);
            int a10 = bVar.a(codePointAt);
            EmojiMetadata b10 = bVar.b();
            if (a10 == 1) {
                i11 += Character.charCount(codePointAt);
                i13 = 0;
            } else if (a10 == 2) {
                i11 += Character.charCount(codePointAt);
            } else if (a10 == 3) {
                b10 = bVar.c();
                if (b10.getCompatAdded() <= i10) {
                    i12++;
                }
            }
            if (b10 != null && b10.getCompatAdded() <= i10) {
                i13++;
            }
        }
        if (i12 != 0) {
            return 2;
        }
        if (bVar.e() && bVar.b().getCompatAdded() <= i10) {
            return 1;
        }
        if (i13 == 0) {
            return 0;
        }
        return 2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence j(java.lang.CharSequence r11, int r12, int r13, int r14, boolean r15) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.emoji2.text.SpannableBuilder
            if (r0 == 0) goto L_0x000a
            r1 = r11
            androidx.emoji2.text.SpannableBuilder r1 = (androidx.emoji2.text.SpannableBuilder) r1
            r1.beginBatchEdit()
        L_0x000a:
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r1 = androidx.emoji2.text.EmojiSpan.class
            if (r0 != 0) goto L_0x002f
            boolean r2 = r11 instanceof android.text.Spannable     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x0013
            goto L_0x002f
        L_0x0013:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x002d
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch:{ all -> 0x002a }
            int r3 = r12 + -1
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r1)     // Catch:{ all -> 0x002a }
            if (r2 > r13) goto L_0x002d
            androidx.emoji2.text.m r2 = new androidx.emoji2.text.m     // Catch:{ all -> 0x002a }
            r2.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x002a }
            goto L_0x0037
        L_0x002a:
            r12 = move-exception
            goto L_0x012b
        L_0x002d:
            r2 = 0
            goto L_0x0037
        L_0x002f:
            androidx.emoji2.text.m r2 = new androidx.emoji2.text.m     // Catch:{ all -> 0x002a }
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch:{ all -> 0x002a }
            r2.<init>((android.text.Spannable) r3)     // Catch:{ all -> 0x002a }
        L_0x0037:
            r3 = 0
            if (r2 == 0) goto L_0x0063
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r1)     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.EmojiSpan[] r4 = (androidx.emoji2.text.EmojiSpan[]) r4     // Catch:{ all -> 0x002a }
            if (r4 == 0) goto L_0x0063
            int r5 = r4.length     // Catch:{ all -> 0x002a }
            if (r5 <= 0) goto L_0x0063
            int r5 = r4.length     // Catch:{ all -> 0x002a }
            r6 = r3
        L_0x0047:
            if (r6 >= r5) goto L_0x0063
            r7 = r4[r6]     // Catch:{ all -> 0x002a }
            int r8 = r2.getSpanStart(r7)     // Catch:{ all -> 0x002a }
            int r9 = r2.getSpanEnd(r7)     // Catch:{ all -> 0x002a }
            if (r8 == r13) goto L_0x0058
            r2.removeSpan(r7)     // Catch:{ all -> 0x002a }
        L_0x0058:
            int r12 = java.lang.Math.min(r8, r12)     // Catch:{ all -> 0x002a }
            int r13 = java.lang.Math.max(r9, r13)     // Catch:{ all -> 0x002a }
            int r6 = r6 + 1
            goto L_0x0047
        L_0x0063:
            if (r12 == r13) goto L_0x0122
            int r4 = r11.length()     // Catch:{ all -> 0x002a }
            if (r12 < r4) goto L_0x006d
            goto L_0x0122
        L_0x006d:
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r4) goto L_0x0080
            if (r2 == 0) goto L_0x0080
            int r4 = r2.length()     // Catch:{ all -> 0x002a }
            java.lang.Object[] r1 = r2.getSpans(r3, r4, r1)     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.EmojiSpan[] r1 = (androidx.emoji2.text.EmojiSpan[]) r1     // Catch:{ all -> 0x002a }
            int r1 = r1.length     // Catch:{ all -> 0x002a }
            int r14 = r14 - r1
        L_0x0080:
            androidx.emoji2.text.g$b r1 = new androidx.emoji2.text.g$b     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.MetadataRepo r4 = r10.f15451b     // Catch:{ all -> 0x002a }
            androidx.emoji2.text.MetadataRepo$a r4 = r4.getRootNode()     // Catch:{ all -> 0x002a }
            boolean r5 = r10.f15453d     // Catch:{ all -> 0x002a }
            int[] r6 = r10.f15454e     // Catch:{ all -> 0x002a }
            r1.<init>(r4, r5, r6)     // Catch:{ all -> 0x002a }
            int r4 = java.lang.Character.codePointAt(r11, r12)     // Catch:{ all -> 0x002a }
            r5 = r4
            r4 = r3
            r3 = r2
        L_0x0096:
            r2 = r12
        L_0x0097:
            if (r12 >= r13) goto L_0x00e9
            if (r4 >= r14) goto L_0x00e9
            int r6 = r1.a(r5)     // Catch:{ all -> 0x002a }
            r7 = 1
            if (r6 == r7) goto L_0x00d7
            r7 = 2
            if (r6 == r7) goto L_0x00cb
            r7 = 3
            if (r6 == r7) goto L_0x00a9
            goto L_0x0097
        L_0x00a9:
            if (r15 != 0) goto L_0x00b5
            androidx.emoji2.text.EmojiMetadata r6 = r1.c()     // Catch:{ all -> 0x002a }
            boolean r6 = r10.g(r11, r2, r12, r6)     // Catch:{ all -> 0x002a }
            if (r6 != 0) goto L_0x0096
        L_0x00b5:
            if (r3 != 0) goto L_0x00c1
            androidx.emoji2.text.m r3 = new androidx.emoji2.text.m     // Catch:{ all -> 0x002a }
            android.text.SpannableString r6 = new android.text.SpannableString     // Catch:{ all -> 0x002a }
            r6.<init>(r11)     // Catch:{ all -> 0x002a }
            r3.<init>((android.text.Spannable) r6)     // Catch:{ all -> 0x002a }
        L_0x00c1:
            androidx.emoji2.text.EmojiMetadata r6 = r1.c()     // Catch:{ all -> 0x002a }
            r10.a(r3, r6, r2, r12)     // Catch:{ all -> 0x002a }
            int r4 = r4 + 1
            goto L_0x0096
        L_0x00cb:
            int r6 = java.lang.Character.charCount(r5)     // Catch:{ all -> 0x002a }
            int r12 = r12 + r6
            if (r12 >= r13) goto L_0x0097
            int r5 = java.lang.Character.codePointAt(r11, r12)     // Catch:{ all -> 0x002a }
            goto L_0x0097
        L_0x00d7:
            int r12 = java.lang.Character.codePointAt(r11, r2)     // Catch:{ all -> 0x002a }
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x002a }
            int r2 = r2 + r12
            if (r2 >= r13) goto L_0x00e7
            int r12 = java.lang.Character.codePointAt(r11, r2)     // Catch:{ all -> 0x002a }
            r5 = r12
        L_0x00e7:
            r12 = r2
            goto L_0x0097
        L_0x00e9:
            boolean r13 = r1.e()     // Catch:{ all -> 0x002a }
            if (r13 == 0) goto L_0x010b
            if (r4 >= r14) goto L_0x010b
            if (r15 != 0) goto L_0x00fd
            androidx.emoji2.text.EmojiMetadata r13 = r1.b()     // Catch:{ all -> 0x002a }
            boolean r13 = r10.g(r11, r2, r12, r13)     // Catch:{ all -> 0x002a }
            if (r13 != 0) goto L_0x010b
        L_0x00fd:
            if (r3 != 0) goto L_0x0104
            androidx.emoji2.text.m r3 = new androidx.emoji2.text.m     // Catch:{ all -> 0x002a }
            r3.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x002a }
        L_0x0104:
            androidx.emoji2.text.EmojiMetadata r13 = r1.b()     // Catch:{ all -> 0x002a }
            r10.a(r3, r13, r2, r12)     // Catch:{ all -> 0x002a }
        L_0x010b:
            if (r3 == 0) goto L_0x0119
            android.text.Spannable r12 = r3.b()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0118
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.endBatchEdit()
        L_0x0118:
            return r12
        L_0x0119:
            if (r0 == 0) goto L_0x0121
            r12 = r11
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.endBatchEdit()
        L_0x0121:
            return r11
        L_0x0122:
            if (r0 == 0) goto L_0x012a
            r12 = r11
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.endBatchEdit()
        L_0x012a:
            return r11
        L_0x012b:
            if (r0 == 0) goto L_0x0132
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.endBatchEdit()
        L_0x0132:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.g.j(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
