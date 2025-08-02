package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    private static class a extends ActivityOptionsCompat {

        /* renamed from: a  reason: collision with root package name */
        private final ActivityOptions f14793a;

        a(ActivityOptions activityOptions) {
            this.f14793a = activityOptions;
        }

        public Rect getLaunchBounds() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return d.a(this.f14793a);
        }

        public void requestUsageTimeReport(PendingIntent pendingIntent) {
            c.c(this.f14793a, pendingIntent);
        }

        public ActivityOptionsCompat setLaunchBounds(Rect rect) {
            if (Build.VERSION.SDK_INT < 24) {
                return this;
            }
            return new a(d.b(this.f14793a, rect));
        }

        public ActivityOptionsCompat setShareIdentityEnabled(boolean z10) {
            if (Build.VERSION.SDK_INT < 34) {
                return this;
            }
            return new a(e.a(this.f14793a, z10));
        }

        public Bundle toBundle() {
            return this.f14793a.toBundle();
        }

        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof a) {
                this.f14793a.update(((a) activityOptionsCompat).f14793a);
            }
        }
    }

    static class b {
        @DoNotInline
        static ActivityOptions a(Activity activity, View view, String str) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        }

        @DoNotInline
        @SafeVarargs
        static ActivityOptions b(Activity activity, Pair<View, String>... pairArr) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
        }

        @DoNotInline
        static ActivityOptions c() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    static class c {
        @DoNotInline
        static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }

        @DoNotInline
        static ActivityOptions b(View view, int i10, int i11, int i12, int i13) {
            return ActivityOptions.makeClipRevealAnimation(view, i10, i11, i12, i13);
        }

        @DoNotInline
        static void c(ActivityOptions activityOptions, PendingIntent pendingIntent) {
            activityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    static class d {
        @DoNotInline
        static Rect a(ActivityOptions activityOptions) {
            return activityOptions.getLaunchBounds();
        }

        @DoNotInline
        static ActivityOptions b(ActivityOptions activityOptions, Rect rect) {
            return activityOptions.setLaunchBounds(rect);
        }
    }

    static class e {
        @DoNotInline
        static ActivityOptions a(ActivityOptions activityOptions, boolean z10) {
            return activityOptions.setShareIdentityEnabled(z10);
        }
    }

    protected ActivityOptionsCompat() {
    }

    @NonNull
    public static ActivityOptionsCompat makeBasic() {
        return new a(c.a());
    }

    @NonNull
    public static ActivityOptionsCompat makeClipRevealAnimation(@NonNull View view, int i10, int i11, int i12, int i13) {
        return new a(c.b(view, i10, i11, i12, i13));
    }

    @NonNull
    public static ActivityOptionsCompat makeCustomAnimation(@NonNull Context context, int i10, int i11) {
        return new a(ActivityOptions.makeCustomAnimation(context, i10, i11));
    }

    @NonNull
    public static ActivityOptionsCompat makeScaleUpAnimation(@NonNull View view, int i10, int i11, int i12, int i13) {
        return new a(ActivityOptions.makeScaleUpAnimation(view, i10, i11, i12, i13));
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity activity, @NonNull View view, @NonNull String str) {
        return new a(b.a(activity, view, str));
    }

    @NonNull
    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        return new a(b.c());
    }

    @NonNull
    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(@NonNull View view, @NonNull Bitmap bitmap, int i10, int i11) {
        return new a(ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i10, i11));
    }

    @Nullable
    public Rect getLaunchBounds() {
        return null;
    }

    public void requestUsageTimeReport(@NonNull PendingIntent pendingIntent) {
    }

    @NonNull
    public ActivityOptionsCompat setLaunchBounds(@Nullable Rect rect) {
        return this;
    }

    @NonNull
    public ActivityOptionsCompat setShareIdentityEnabled(boolean z10) {
        return this;
    }

    @Nullable
    public Bundle toBundle() {
        return null;
    }

    public void update(@NonNull ActivityOptionsCompat activityOptionsCompat) {
    }

    @NonNull
    public static ActivityOptionsCompat makeSceneTransitionAnimation(@NonNull Activity activity, @Nullable androidx.core.util.Pair<View, String>... pairArr) {
        Pair[] pairArr2;
        if (pairArr != null) {
            pairArr2 = new Pair[pairArr.length];
            for (int i10 = 0; i10 < pairArr.length; i10++) {
                androidx.core.util.Pair<View, String> pair = pairArr[i10];
                pairArr2[i10] = Pair.create((View) pair.first, (String) pair.second);
            }
        } else {
            pairArr2 = null;
        }
        return new a(b.b(activity, pairArr2));
    }
}
