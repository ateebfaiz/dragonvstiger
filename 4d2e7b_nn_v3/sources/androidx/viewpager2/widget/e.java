package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class e extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f16904a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f16905b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f16906c;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayoutManager f16907d;

    /* renamed from: e  reason: collision with root package name */
    private int f16908e;

    /* renamed from: f  reason: collision with root package name */
    private int f16909f;

    /* renamed from: g  reason: collision with root package name */
    private a f16910g = new a();

    /* renamed from: h  reason: collision with root package name */
    private int f16911h;

    /* renamed from: i  reason: collision with root package name */
    private int f16912i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16913j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16914k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16915l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16916m;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f16917a;

        /* renamed from: b  reason: collision with root package name */
        float f16918b;

        /* renamed from: c  reason: collision with root package name */
        int f16919c;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f16917a = -1;
            this.f16918b = 0.0f;
            this.f16919c = 0;
        }
    }

    e(ViewPager2 viewPager2) {
        this.f16905b = viewPager2;
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        this.f16906c = recyclerView;
        this.f16907d = (LinearLayoutManager) recyclerView.getLayoutManager();
        o();
    }

    private void a(int i10, float f10, int i11) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f16904a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i10, f10, i11);
        }
    }

    private void b(int i10) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f16904a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i10);
        }
    }

    private void c(int i10) {
        if ((this.f16908e != 3 || this.f16909f != 0) && this.f16909f != i10) {
            this.f16909f = i10;
            ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f16904a;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.onPageScrollStateChanged(i10);
            }
        }
    }

    private int d() {
        return this.f16907d.findFirstVisibleItemPosition();
    }

    private boolean j() {
        int i10 = this.f16908e;
        if (i10 == 1 || i10 == 4) {
            return true;
        }
        return false;
    }

    private void o() {
        this.f16908e = 0;
        this.f16909f = 0;
        this.f16910g.a();
        this.f16911h = -1;
        this.f16912i = -1;
        this.f16913j = false;
        this.f16914k = false;
        this.f16916m = false;
        this.f16915l = false;
    }

    private void q(boolean z10) {
        int i10;
        this.f16916m = z10;
        if (z10) {
            i10 = 4;
        } else {
            i10 = 1;
        }
        this.f16908e = i10;
        int i11 = this.f16912i;
        if (i11 != -1) {
            this.f16911h = i11;
            this.f16912i = -1;
        } else if (this.f16911h == -1) {
            this.f16911h = d();
        }
        c(1);
    }

    private void r() {
        int i10;
        float f10;
        a aVar = this.f16910g;
        int findFirstVisibleItemPosition = this.f16907d.findFirstVisibleItemPosition();
        aVar.f16917a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            aVar.a();
            return;
        }
        View findViewByPosition = this.f16907d.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            aVar.a();
            return;
        }
        int leftDecorationWidth = this.f16907d.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f16907d.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f16907d.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f16907d.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f16907d.getOrientation() == 0) {
            i10 = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f16906c.getPaddingLeft();
            if (this.f16905b.isRtl()) {
                i10 = -i10;
            }
            height = width;
        } else {
            i10 = (findViewByPosition.getTop() - topDecorationHeight) - this.f16906c.getPaddingTop();
        }
        int i11 = -i10;
        aVar.f16919c = i11;
        if (i11 >= 0) {
            if (height == 0) {
                f10 = 0.0f;
            } else {
                f10 = ((float) i11) / ((float) height);
            }
            aVar.f16918b = f10;
        } else if (new a(this.f16907d).d()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(aVar.f16919c)}));
        }
    }

    /* access modifiers changed from: package-private */
    public double e() {
        r();
        a aVar = this.f16910g;
        return ((double) aVar.f16917a) + ((double) aVar.f16918b);
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f16909f;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        if (this.f16909f == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f16916m;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        if (this.f16909f == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f16908e = 4;
        q(true);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f16915l = true;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        if (!g() || this.f16916m) {
            this.f16916m = false;
            r();
            a aVar = this.f16910g;
            if (aVar.f16919c == 0) {
                int i10 = aVar.f16917a;
                if (i10 != this.f16911h) {
                    b(i10);
                }
                c(0);
                o();
                return;
            }
            c(2);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(int i10, boolean z10) {
        int i11;
        if (z10) {
            i11 = 2;
        } else {
            i11 = 3;
        }
        this.f16908e = i11;
        boolean z11 = false;
        this.f16916m = false;
        if (this.f16912i != i10) {
            z11 = true;
        }
        this.f16912i = i10;
        c(2);
        if (z11) {
            b(i10);
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        if (!(this.f16908e == 1 && this.f16909f == 1) && i10 == 1) {
            q(false);
        } else if (!j() || i10 != 2) {
            if (j() && i10 == 0) {
                r();
                if (!this.f16914k) {
                    int i11 = this.f16910g.f16917a;
                    if (i11 != -1) {
                        a(i11, 0.0f, 0);
                    }
                } else {
                    a aVar = this.f16910g;
                    if (aVar.f16919c == 0) {
                        int i12 = this.f16911h;
                        int i13 = aVar.f16917a;
                        if (i12 != i13) {
                            b(i13);
                        }
                    }
                }
                c(0);
                o();
            }
            if (this.f16908e == 2 && i10 == 0 && this.f16915l) {
                r();
                a aVar2 = this.f16910g;
                if (aVar2.f16919c == 0) {
                    int i14 = this.f16912i;
                    int i15 = aVar2.f16917a;
                    if (i14 != i15) {
                        if (i15 == -1) {
                            i15 = 0;
                        }
                        b(i15);
                    }
                    c(0);
                    o();
                }
            }
        } else if (this.f16914k) {
            c(2);
            this.f16913j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r5 == r3.f16905b.isRtl()) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f16914k = r4
            r3.r()
            boolean r0 = r3.f16913j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x0037
            r3.f16913j = r2
            if (r6 > 0) goto L_0x001f
            if (r6 != 0) goto L_0x0029
            if (r5 >= 0) goto L_0x0016
            r5 = r4
            goto L_0x0017
        L_0x0016:
            r5 = r2
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f16905b
            boolean r6 = r6.isRtl()
            if (r5 != r6) goto L_0x0029
        L_0x001f:
            androidx.viewpager2.widget.e$a r5 = r3.f16910g
            int r6 = r5.f16919c
            if (r6 == 0) goto L_0x0029
            int r5 = r5.f16917a
            int r5 = r5 + r4
            goto L_0x002d
        L_0x0029:
            androidx.viewpager2.widget.e$a r5 = r3.f16910g
            int r5 = r5.f16917a
        L_0x002d:
            r3.f16912i = r5
            int r6 = r3.f16911h
            if (r6 == r5) goto L_0x0045
            r3.b(r5)
            goto L_0x0045
        L_0x0037:
            int r5 = r3.f16908e
            if (r5 != 0) goto L_0x0045
            androidx.viewpager2.widget.e$a r5 = r3.f16910g
            int r5 = r5.f16917a
            if (r5 != r1) goto L_0x0042
            r5 = r2
        L_0x0042:
            r3.b(r5)
        L_0x0045:
            androidx.viewpager2.widget.e$a r5 = r3.f16910g
            int r6 = r5.f16917a
            if (r6 != r1) goto L_0x004c
            r6 = r2
        L_0x004c:
            float r0 = r5.f16918b
            int r5 = r5.f16919c
            r3.a(r6, r0, r5)
            androidx.viewpager2.widget.e$a r5 = r3.f16910g
            int r6 = r5.f16917a
            int r0 = r3.f16912i
            if (r6 == r0) goto L_0x005d
            if (r0 != r1) goto L_0x006b
        L_0x005d:
            int r5 = r5.f16919c
            if (r5 != 0) goto L_0x006b
            int r5 = r3.f16909f
            if (r5 == r4) goto L_0x006b
            r3.c(r2)
            r3.o()
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.e.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void p(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f16904a = onPageChangeCallback;
    }
}
