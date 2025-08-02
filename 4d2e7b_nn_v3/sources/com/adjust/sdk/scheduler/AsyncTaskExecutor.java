package com.adjust.sdk.scheduler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;

public abstract class AsyncTaskExecutor<Params, Result> {

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object[] f17503a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f17504b;

        /* renamed from: com.adjust.sdk.scheduler.AsyncTaskExecutor$a$a  reason: collision with other inner class name */
        public class C0227a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Object f17506a;

            public C0227a(Object obj) {
                this.f17506a = obj;
            }

            public final void run() {
                AsyncTaskExecutor.this.onPostExecute(this.f17506a);
            }
        }

        public a(Object[] objArr, Handler handler) {
            this.f17503a = objArr;
            this.f17504b = handler;
        }

        public final void run() {
            this.f17504b.post(new C0227a(AsyncTaskExecutor.this.doInBackground(this.f17503a)));
        }
    }

    public abstract Result doInBackground(Params[] paramsArr);

    @SafeVarargs
    public final AsyncTaskExecutor<Params, Result> execute(Params... paramsArr) {
        onPreExecute();
        Executors.newSingleThreadExecutor().execute(new a(paramsArr, new Handler(Looper.getMainLooper())));
        return this;
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }
}
