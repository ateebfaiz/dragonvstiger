package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback = new a();
    private final int mDestructAfterMillisec;
    @GuardedBy("mLock")
    private int mGeneration;
    @GuardedBy("mLock")
    private Handler mHandler;
    private final Object mLock = new Object();
    private final int mPriority;
    @GuardedBy("mLock")
    private HandlerThread mThread;
    private final String mThreadName;

    public interface ReplyCallback<T> {
        void onReply(T t10);
    }

    class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                SelfDestructiveThread.this.onDestruction();
                return true;
            } else if (i10 != 1) {
                return true;
            } else {
                SelfDestructiveThread.this.onInvokeRunnable((Runnable) message.obj);
                return true;
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callable f15054a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Handler f15055b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReplyCallback f15056c;

        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f15058a;

            a(Object obj) {
                this.f15058a = obj;
            }

            public void run() {
                b.this.f15056c.onReply(this.f15058a);
            }
        }

        b(Callable callable, Handler handler, ReplyCallback replyCallback) {
            this.f15054a = callable;
            this.f15055b = handler;
            this.f15056c = replyCallback;
        }

        public void run() {
            Object obj;
            try {
                obj = this.f15054a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f15055b.post(new a(obj));
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f15060a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callable f15061b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReentrantLock f15062c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f15063d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Condition f15064e;

        c(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f15060a = atomicReference;
            this.f15061b = callable;
            this.f15062c = reentrantLock;
            this.f15063d = atomicBoolean;
            this.f15064e = condition;
        }

        public void run() {
            try {
                this.f15060a.set(this.f15061b.call());
            } catch (Exception unused) {
            }
            this.f15062c.lock();
            try {
                this.f15063d.set(false);
                this.f15064e.signal();
            } finally {
                this.f15062c.unlock();
            }
        }
    }

    public SelfDestructiveThread(String str, int i10, int i11) {
        this.mThreadName = str;
        this.mPriority = i10;
        this.mDestructAfterMillisec = i11;
        this.mGeneration = 0;
    }

    private void post(Runnable runnable) {
        synchronized (this.mLock) {
            try {
                if (this.mThread == null) {
                    HandlerThread handlerThread = new HandlerThread(this.mThreadName, this.mPriority);
                    this.mThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
                    this.mGeneration++;
                }
                this.mHandler.removeMessages(0);
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage(1, runnable));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public int getGeneration() {
        int i10;
        synchronized (this.mLock) {
            i10 = this.mGeneration;
        }
        return i10;
    }

    @VisibleForTesting
    public boolean isRunning() {
        boolean z10;
        synchronized (this.mLock) {
            if (this.mThread != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public void onDestruction() {
        synchronized (this.mLock) {
            try {
                if (!this.mHandler.hasMessages(1)) {
                    this.mThread.quit();
                    this.mThread = null;
                    this.mHandler = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onInvokeRunnable(Runnable runnable) {
        runnable.run();
        synchronized (this.mLock) {
            this.mHandler.removeMessages(0);
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(0), (long) this.mDestructAfterMillisec);
        }
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        post(new b(callable, b.a(), replyCallback));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:10|11|12|13|(4:25|15|16|17)(1:18)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T postAndWait(java.util.concurrent.Callable<T> r13, int r14) throws java.lang.InterruptedException {
        /*
            r12 = this;
            java.util.concurrent.locks.ReentrantLock r7 = new java.util.concurrent.locks.ReentrantLock
            r7.<init>()
            java.util.concurrent.locks.Condition r8 = r7.newCondition()
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            java.util.concurrent.atomic.AtomicBoolean r10 = new java.util.concurrent.atomic.AtomicBoolean
            r0 = 1
            r10.<init>(r0)
            androidx.core.provider.SelfDestructiveThread$c r11 = new androidx.core.provider.SelfDestructiveThread$c
            r0 = r11
            r1 = r12
            r2 = r9
            r3 = r13
            r4 = r7
            r5 = r10
            r6 = r8
            r0.<init>(r2, r3, r4, r5, r6)
            r12.post(r11)
            r7.lock()
            boolean r13 = r10.get()     // Catch:{ all -> 0x0034 }
            if (r13 != 0) goto L_0x0036
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x0034 }
            r7.unlock()
            return r13
        L_0x0034:
            r13 = move-exception
            goto L_0x005e
        L_0x0036:
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0034 }
            long r0 = (long) r14     // Catch:{ all -> 0x0034 }
            long r13 = r13.toNanos(r0)     // Catch:{ all -> 0x0034 }
        L_0x003d:
            long r13 = r8.awaitNanos(r13)     // Catch:{ InterruptedException -> 0x0041 }
        L_0x0041:
            boolean r0 = r10.get()     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x004f
            java.lang.Object r13 = r9.get()     // Catch:{ all -> 0x0034 }
            r7.unlock()
            return r13
        L_0x004f:
            r0 = 0
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0056
            goto L_0x003d
        L_0x0056:
            java.lang.InterruptedException r13 = new java.lang.InterruptedException     // Catch:{ all -> 0x0034 }
            java.lang.String r14 = "timeout"
            r13.<init>(r14)     // Catch:{ all -> 0x0034 }
            throw r13     // Catch:{ all -> 0x0034 }
        L_0x005e:
            r7.unlock()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.SelfDestructiveThread.postAndWait(java.util.concurrent.Callable, int):java.lang.Object");
    }
}
