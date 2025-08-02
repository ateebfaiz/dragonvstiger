package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    Handler mHandler;
    private Handler.Callback mHandlerCallback = new a();
    d mInflateThread;
    LayoutInflater mInflater;

    public interface OnInflateFinishedListener {
        void onInflateFinished(@NonNull View view, @LayoutRes int i10, @Nullable ViewGroup viewGroup);
    }

    class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            c cVar = (c) message.obj;
            if (cVar.f14410d == null) {
                cVar.f14410d = AsyncLayoutInflater.this.mInflater.inflate(cVar.f14409c, cVar.f14408b, false);
            }
            cVar.f14411e.onInflateFinished(cVar.f14410d, cVar.f14409c, cVar.f14408b);
            AsyncLayoutInflater.this.mInflateThread.d(cVar);
            return true;
        }
    }

    private static class b extends LayoutInflater {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f14406a = {"android.widget.", "android.webkit.", "android.app."};

        b(Context context) {
            super(context);
        }

        public LayoutInflater cloneInContext(Context context) {
            return new b(context);
        }

        /* access modifiers changed from: protected */
        public View onCreateView(String str, AttributeSet attributeSet) {
            String[] strArr = f14406a;
            int length = strArr.length;
            int i10 = 0;
            while (i10 < length) {
                try {
                    View createView = createView(str, strArr[i10], attributeSet);
                    if (createView != null) {
                        return createView;
                    }
                    i10++;
                } catch (ClassNotFoundException unused) {
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        AsyncLayoutInflater f14407a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f14408b;

        /* renamed from: c  reason: collision with root package name */
        int f14409c;

        /* renamed from: d  reason: collision with root package name */
        View f14410d;

        /* renamed from: e  reason: collision with root package name */
        OnInflateFinishedListener f14411e;

        c() {
        }
    }

    private static class d extends Thread {

        /* renamed from: c  reason: collision with root package name */
        private static final d f14412c;

        /* renamed from: a  reason: collision with root package name */
        private ArrayBlockingQueue f14413a = new ArrayBlockingQueue(10);

        /* renamed from: b  reason: collision with root package name */
        private Pools.SynchronizedPool f14414b = new Pools.SynchronizedPool(10);

        static {
            d dVar = new d();
            f14412c = dVar;
            dVar.start();
        }

        private d() {
        }

        public static d b() {
            return f14412c;
        }

        public void a(c cVar) {
            try {
                this.f14413a.put(cVar);
            } catch (InterruptedException e10) {
                throw new RuntimeException("Failed to enqueue async inflate request", e10);
            }
        }

        public c c() {
            c cVar = (c) this.f14414b.acquire();
            if (cVar == null) {
                return new c();
            }
            return cVar;
        }

        public void d(c cVar) {
            cVar.f14411e = null;
            cVar.f14407a = null;
            cVar.f14408b = null;
            cVar.f14409c = 0;
            cVar.f14410d = null;
            this.f14414b.release(cVar);
        }

        public void e() {
            try {
                c cVar = (c) this.f14413a.take();
                try {
                    cVar.f14410d = cVar.f14407a.mInflater.inflate(cVar.f14409c, cVar.f14408b, false);
                } catch (RuntimeException e10) {
                    Log.w(AsyncLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e10);
                }
                Message.obtain(cVar.f14407a.mHandler, 0, cVar).sendToTarget();
            } catch (InterruptedException e11) {
                Log.w(AsyncLayoutInflater.TAG, e11);
            }
        }

        public void run() {
            while (true) {
                e();
            }
        }
    }

    public AsyncLayoutInflater(@NonNull Context context) {
        this.mInflater = new b(context);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = d.b();
    }

    @UiThread
    public void inflate(@LayoutRes int i10, @Nullable ViewGroup viewGroup, @NonNull OnInflateFinishedListener onInflateFinishedListener) {
        if (onInflateFinishedListener != null) {
            c c10 = this.mInflateThread.c();
            c10.f14407a = this;
            c10.f14409c = i10;
            c10.f14408b = viewGroup;
            c10.f14411e = onInflateFinishedListener;
            this.mInflateThread.a(c10);
            return;
        }
        throw new NullPointerException("callback argument may not be null!");
    }
}
