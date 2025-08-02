package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

final class b extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    private final List f16893a;

    b(int i10) {
        this.f16893a = new ArrayList(i10);
    }

    private void c(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    /* access modifiers changed from: package-private */
    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f16893a.add(onPageChangeCallback);
    }

    /* access modifiers changed from: package-private */
    public void b(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f16893a.remove(onPageChangeCallback);
    }

    public void onPageScrollStateChanged(int i10) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageScrollStateChanged : this.f16893a) {
                onPageScrollStateChanged.onPageScrollStateChanged(i10);
            }
        } catch (ConcurrentModificationException e10) {
            c(e10);
        }
    }

    public void onPageScrolled(int i10, float f10, int i11) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageScrolled : this.f16893a) {
                onPageScrolled.onPageScrolled(i10, f10, i11);
            }
        } catch (ConcurrentModificationException e10) {
            c(e10);
        }
    }

    public void onPageSelected(int i10) {
        try {
            for (ViewPager2.OnPageChangeCallback onPageSelected : this.f16893a) {
                onPageSelected.onPageSelected(i10);
            }
        } catch (ConcurrentModificationException e10) {
            c(e10);
        }
    }
}
