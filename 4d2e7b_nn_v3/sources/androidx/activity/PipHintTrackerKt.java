package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;

public final class PipHintTrackerKt {

    static final class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f13795a;

        a(Activity activity) {
            this.f13795a = activity;
        }

        /* renamed from: a */
        public final Object i(Rect rect, kotlin.coroutines.d dVar) {
            Api26Impl.INSTANCE.setPipParamsSourceRectHint(this.f13795a, rect);
            return Unit.f12577a;
        }
    }

    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(Activity activity, View view, kotlin.coroutines.d dVar) {
        Object a10 = e.d(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, (kotlin.coroutines.d) null)).a(new a(activity), dVar);
        if (a10 == b.c()) {
            return a10;
        }
        return Unit.f12577a;
    }

    /* access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
