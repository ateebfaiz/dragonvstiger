package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class d extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f16902a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager2.PageTransformer f16903b;

    d(LinearLayoutManager linearLayoutManager) {
        this.f16902a = linearLayoutManager;
    }

    /* access modifiers changed from: package-private */
    public ViewPager2.PageTransformer a() {
        return this.f16903b;
    }

    /* access modifiers changed from: package-private */
    public void b(ViewPager2.PageTransformer pageTransformer) {
        this.f16903b = pageTransformer;
    }

    public void onPageScrollStateChanged(int i10) {
    }

    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.f16903b != null) {
            float f11 = -f10;
            int i12 = 0;
            while (i12 < this.f16902a.getChildCount()) {
                View childAt = this.f16902a.getChildAt(i12);
                if (childAt != null) {
                    this.f16903b.transformPage(childAt, ((float) (this.f16902a.getPosition(childAt) - i10)) + f11);
                    i12++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i12), Integer.valueOf(this.f16902a.getChildCount())}));
                }
            }
        }
    }

    public void onPageSelected(int i10) {
    }
}
