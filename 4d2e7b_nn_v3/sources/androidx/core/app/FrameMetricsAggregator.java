package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window$OnFrameMetricsAvailableListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;
    private final b mInstance;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetricType {
    }

    private static class a extends b {

        /* renamed from: e  reason: collision with root package name */
        private static HandlerThread f14794e;

        /* renamed from: f  reason: collision with root package name */
        private static Handler f14795f;

        /* renamed from: a  reason: collision with root package name */
        int f14796a;

        /* renamed from: b  reason: collision with root package name */
        SparseIntArray[] f14797b = new SparseIntArray[9];

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList f14798c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        Window$OnFrameMetricsAvailableListener f14799d = new C0186a();

        /* renamed from: androidx.core.app.FrameMetricsAggregator$a$a  reason: collision with other inner class name */
        class C0186a implements Window$OnFrameMetricsAvailableListener {
            C0186a() {
            }

            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i10) {
                a aVar = a.this;
                if ((aVar.f14796a & 1) != 0) {
                    aVar.f(aVar.f14797b[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f14796a & 2) != 0) {
                    aVar2.f(aVar2.f14797b[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f14796a & 4) != 0) {
                    aVar3.f(aVar3.f14797b[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f14796a & 8) != 0) {
                    aVar4.f(aVar4.f14797b[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f14796a & 16) != 0) {
                    aVar5.f(aVar5.f14797b[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f14796a & 64) != 0) {
                    aVar6.f(aVar6.f14797b[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f14796a & 32) != 0) {
                    aVar7.f(aVar7.f14797b[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f14796a & 128) != 0) {
                    aVar8.f(aVar8.f14797b[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f14796a & 256) != 0) {
                    aVar9.f(aVar9.f14797b[8], frameMetrics.getMetric(2));
                }
            }
        }

        a(int i10) {
            this.f14796a = i10;
        }

        public void a(Activity activity) {
            if (f14794e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f14794e = handlerThread;
                handlerThread.start();
                f14795f = new Handler(f14794e.getLooper());
            }
            for (int i10 = 0; i10 <= 8; i10++) {
                SparseIntArray[] sparseIntArrayArr = this.f14797b;
                if (sparseIntArrayArr[i10] == null && (this.f14796a & (1 << i10)) != 0) {
                    sparseIntArrayArr[i10] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f14799d, f14795f);
            this.f14798c.add(new WeakReference(activity));
        }

        public SparseIntArray[] b() {
            return this.f14797b;
        }

        public SparseIntArray[] c(Activity activity) {
            Iterator it = this.f14798c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() == activity) {
                    this.f14798c.remove(weakReference);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f14799d);
            return this.f14797b;
        }

        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.f14797b;
            this.f14797b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        public SparseIntArray[] e() {
            for (int size = this.f14798c.size() - 1; size >= 0; size--) {
                WeakReference weakReference = (WeakReference) this.f14798c.get(size);
                Activity activity = (Activity) weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f14799d);
                    this.f14798c.remove(size);
                }
            }
            return this.f14797b;
        }

        /* access modifiers changed from: package-private */
        public void f(SparseIntArray sparseIntArray, long j10) {
            if (sparseIntArray != null) {
                int i10 = (int) ((500000 + j10) / 1000000);
                if (j10 >= 0) {
                    sparseIntArray.put(i10, sparseIntArray.get(i10) + 1);
                }
            }
        }
    }

    private static class b {
        b() {
        }

        public void a(Activity activity) {
        }

        public SparseIntArray[] b() {
            return null;
        }

        public SparseIntArray[] c(Activity activity) {
            return null;
        }

        public SparseIntArray[] d() {
            return null;
        }

        public SparseIntArray[] e() {
            return null;
        }
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void add(@NonNull Activity activity) {
        this.mInstance.a(activity);
    }

    @Nullable
    public SparseIntArray[] getMetrics() {
        return this.mInstance.b();
    }

    @Nullable
    public SparseIntArray[] remove(@NonNull Activity activity) {
        return this.mInstance.c(activity);
    }

    @Nullable
    public SparseIntArray[] reset() {
        return this.mInstance.d();
    }

    @Nullable
    public SparseIntArray[] stop() {
        return this.mInstance.e();
    }

    public FrameMetricsAggregator(int i10) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mInstance = new a(i10);
        } else {
            this.mInstance = new b();
        }
    }
}
