package l7;

import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;

public class e {
    @Nullable
    private Runnable mCompletionRunnable;
    private final a mLayoutCreateAnimation = new h();
    private final a mLayoutDeleteAnimation = new i();
    /* access modifiers changed from: private */
    public final SparseArray<j> mLayoutHandlers = new SparseArray<>(0);
    private final a mLayoutUpdateAnimation = new k();
    private long mMaxAnimationDuration = -1;
    private boolean mShouldAnimateLayout;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f12631a;

        a(Callback callback) {
            this.f12631a = callback;
        }

        public void run() {
            this.f12631a.invoke(Boolean.TRUE);
        }
    }

    class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f12633a;

        b(int i10) {
            this.f12633a = i10;
        }

        public void onAnimationEnd(Animation animation) {
            e.this.mLayoutHandlers.remove(this.f12633a);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            e.this.mLayoutHandlers.put(this.f12633a, (j) animation);
        }
    }

    class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f12635a;

        c(f fVar) {
            this.f12635a = fVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f12635a.a();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    private void b(View view) {
        view.setClickable(false);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                b(viewGroup.getChildAt(i10));
            }
        }
    }

    private void c(long j10) {
        if (this.mCompletionRunnable != null) {
            Handler uiThreadHandler = UiThreadUtil.getUiThreadHandler();
            uiThreadHandler.removeCallbacks(this.mCompletionRunnable);
            uiThreadHandler.postDelayed(this.mCompletionRunnable, j10);
        }
    }

    public void applyLayoutUpdate(View view, int i10, int i11, int i12, int i13) {
        a aVar;
        UiThreadUtil.assertOnUiThread();
        int id2 = view.getId();
        j jVar = this.mLayoutHandlers.get(id2);
        if (jVar != null) {
            jVar.a(i10, i11, i12, i13);
            return;
        }
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            aVar = this.mLayoutCreateAnimation;
        } else {
            aVar = this.mLayoutUpdateAnimation;
        }
        Animation a10 = aVar.a(view, i10, i11, i12, i13);
        if (a10 instanceof j) {
            a10.setAnimationListener(new b(id2));
        } else {
            view.layout(i10, i11, i12 + i10, i13 + i11);
        }
        if (a10 != null) {
            long duration = a10.getDuration();
            if (duration > this.mMaxAnimationDuration) {
                this.mMaxAnimationDuration = duration;
                c(duration);
            }
            view.startAnimation(a10);
        }
    }

    public void deleteView(View view, f fVar) {
        UiThreadUtil.assertOnUiThread();
        Animation a10 = this.mLayoutDeleteAnimation.a(view, view.getLeft(), view.getTop(), view.getWidth(), view.getHeight());
        if (a10 != null) {
            b(view);
            a10.setAnimationListener(new c(fVar));
            long duration = a10.getDuration();
            if (duration > this.mMaxAnimationDuration) {
                c(duration);
                this.mMaxAnimationDuration = duration;
            }
            view.startAnimation(a10);
            return;
        }
        fVar.a();
    }

    public void initializeFromConfig(@Nullable ReadableMap readableMap, Callback callback) {
        if (readableMap == null) {
            reset();
            return;
        }
        int i10 = 0;
        this.mShouldAnimateLayout = false;
        if (readableMap.hasKey("duration")) {
            i10 = readableMap.getInt("duration");
        }
        g gVar = g.CREATE;
        if (readableMap.hasKey(g.b(gVar))) {
            this.mLayoutCreateAnimation.d(readableMap.getMap(g.b(gVar)), i10);
            this.mShouldAnimateLayout = true;
        }
        g gVar2 = g.UPDATE;
        if (readableMap.hasKey(g.b(gVar2))) {
            this.mLayoutUpdateAnimation.d(readableMap.getMap(g.b(gVar2)), i10);
            this.mShouldAnimateLayout = true;
        }
        g gVar3 = g.DELETE;
        if (readableMap.hasKey(g.b(gVar3))) {
            this.mLayoutDeleteAnimation.d(readableMap.getMap(g.b(gVar3)), i10);
            this.mShouldAnimateLayout = true;
        }
        if (this.mShouldAnimateLayout && callback != null) {
            this.mCompletionRunnable = new a(callback);
        }
    }

    public void reset() {
        this.mLayoutCreateAnimation.f();
        this.mLayoutUpdateAnimation.f();
        this.mLayoutDeleteAnimation.f();
        this.mCompletionRunnable = null;
        this.mShouldAnimateLayout = false;
        this.mMaxAnimationDuration = -1;
    }

    public boolean shouldAnimateLayout(View view) {
        if (view == null) {
            return false;
        }
        if ((!this.mShouldAnimateLayout || view.getParent() == null) && this.mLayoutHandlers.get(view.getId()) == null) {
            return false;
        }
        return true;
    }
}
