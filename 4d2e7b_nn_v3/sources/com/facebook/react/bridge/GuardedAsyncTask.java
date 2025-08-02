package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedAsyncTask<Params, Progress> extends AsyncTask<Params, Progress, Void> {
    private final JSExceptionHandler mExceptionHandler;

    protected GuardedAsyncTask(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    /* access modifiers changed from: protected */
    public abstract void doInBackgroundGuarded(Params... paramsArr);

    protected GuardedAsyncTask(JSExceptionHandler jSExceptionHandler) {
        this.mExceptionHandler = jSExceptionHandler;
    }

    /* access modifiers changed from: protected */
    public final Void doInBackground(Params... paramsArr) {
        try {
            doInBackgroundGuarded(paramsArr);
            return null;
        } catch (RuntimeException e10) {
            this.mExceptionHandler.handleException(e10);
            return null;
        }
    }
}
