package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Choreographer;

public class ChoreographerCallback implements Choreographer.FrameCallback {
    private static final String LOG_TAG = "ChoreographerCallback";
    private long mCookie;
    private b mLooper;

    class a implements Runnable {
        a() {
        }

        public void run() {
            Choreographer.getInstance().postFrameCallback(ChoreographerCallback.this);
        }
    }

    private class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public Handler f8950a;

        /* synthetic */ b(ChoreographerCallback choreographerCallback, a aVar) {
            this();
        }

        public void run() {
            Log.i(ChoreographerCallback.LOG_TAG, "Starting looper thread");
            Looper.prepare();
            this.f8950a = new Handler();
            Looper.loop();
            Log.i(ChoreographerCallback.LOG_TAG, "Terminating looper thread");
        }

        private b() {
        }
    }

    public ChoreographerCallback(long j10) {
        this.mCookie = j10;
        b bVar = new b(this, (a) null);
        this.mLooper = bVar;
        bVar.start();
    }

    public void doFrame(long j10) {
        nOnChoreographer(this.mCookie, j10);
    }

    public native void nOnChoreographer(long j10, long j11);

    public void postFrameCallback() {
        this.mLooper.f8950a.post(new a());
    }

    public void postFrameCallbackDelayed(long j10) {
        Choreographer.getInstance().postFrameCallbackDelayed(this, j10);
    }

    public void terminate() {
        this.mLooper.f8950a.getLooper().quit();
    }
}
