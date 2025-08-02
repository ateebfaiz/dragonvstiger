package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

public class DifferentialMotionFlingController {
    private final Context mContext;
    private final int[] mFlingVelocityThresholds;
    private float mLastFlingVelocity;
    private int mLastProcessedAxis;
    private int mLastProcessedDeviceId;
    private int mLastProcessedSource;
    private final DifferentialMotionFlingTarget mTarget;
    private final a mVelocityProvider;
    private final b mVelocityThresholdCalculator;
    @Nullable
    private VelocityTracker mVelocityTracker;

    interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10);
    }

    interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i10);
    }

    public DifferentialMotionFlingController(@NonNull Context context, @NonNull DifferentialMotionFlingTarget differentialMotionFlingTarget) {
        this(context, differentialMotionFlingTarget, new q(), new r());
    }

    private boolean calculateFlingVelocityThresholds(MotionEvent motionEvent, int i10) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.mLastProcessedSource == source && this.mLastProcessedDeviceId == deviceId && this.mLastProcessedAxis == i10) {
            return false;
        }
        this.mVelocityThresholdCalculator.a(this.mContext, this.mFlingVelocityThresholds, motionEvent, i10);
        this.mLastProcessedSource = source;
        this.mLastProcessedDeviceId = deviceId;
        this.mLastProcessedAxis = i10;
        return true;
    }

    private float getCurrentVelocity(MotionEvent motionEvent, int i10) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        return this.mVelocityProvider.a(this.mVelocityTracker, motionEvent, i10);
    }

    public void onMotionEvent(@NonNull MotionEvent motionEvent, int i10) {
        boolean calculateFlingVelocityThresholds = calculateFlingVelocityThresholds(motionEvent, i10);
        if (this.mFlingVelocityThresholds[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
                return;
            }
            return;
        }
        float currentVelocity = getCurrentVelocity(motionEvent, i10) * this.mTarget.getScaledScrollFactor();
        float signum = Math.signum(currentVelocity);
        float f10 = 0.0f;
        if (calculateFlingVelocityThresholds || !(signum == Math.signum(this.mLastFlingVelocity) || signum == 0.0f)) {
            this.mTarget.stopDifferentialMotionFling();
        }
        float abs = Math.abs(currentVelocity);
        int[] iArr = this.mFlingVelocityThresholds;
        if (abs >= ((float) iArr[0])) {
            int i11 = iArr[1];
            float max = Math.max((float) (-i11), Math.min(currentVelocity, (float) i11));
            if (this.mTarget.startDifferentialMotionFling(max)) {
                f10 = max;
            }
            this.mLastFlingVelocity = f10;
        }
    }

    @VisibleForTesting
    DifferentialMotionFlingController(Context context, DifferentialMotionFlingTarget differentialMotionFlingTarget, b bVar, a aVar) {
        this.mLastProcessedAxis = -1;
        this.mLastProcessedSource = -1;
        this.mLastProcessedDeviceId = -1;
        this.mFlingVelocityThresholds = new int[]{Integer.MAX_VALUE, 0};
        this.mContext = context;
        this.mTarget = differentialMotionFlingTarget;
        this.mVelocityThresholdCalculator = bVar;
        this.mVelocityProvider = aVar;
    }

    /* access modifiers changed from: private */
    public static float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
        VelocityTrackerCompat.addMovement(velocityTracker, motionEvent);
        VelocityTrackerCompat.computeCurrentVelocity(velocityTracker, 1000);
        return VelocityTrackerCompat.getAxisVelocity(velocityTracker, i10);
    }

    /* access modifiers changed from: private */
    public static void calculateFlingVelocityThresholds(Context context, int[] iArr, MotionEvent motionEvent, int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = ViewConfigurationCompat.getScaledMinimumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
        iArr[1] = ViewConfigurationCompat.getScaledMaximumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
    }
}
