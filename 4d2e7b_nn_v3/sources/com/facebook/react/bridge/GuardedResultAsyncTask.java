package com.facebook.react.bridge;

import android.os.AsyncTask;

public abstract class GuardedResultAsyncTask<Result> extends AsyncTask<Void, Void, Result> {
    private final JSExceptionHandler mExceptionHandler;

    protected GuardedResultAsyncTask(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    /* access modifiers changed from: protected */
    public abstract Result doInBackgroundGuarded();

    /* access modifiers changed from: protected */
    public final void onPostExecute(Result result) {
        try {
            onPostExecuteGuarded(result);
        } catch (RuntimeException e10) {
            this.mExceptionHandler.handleException(e10);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onPostExecuteGuarded(Result result);

    protected GuardedResultAsyncTask(JSExceptionHandler jSExceptionHandler) {
        this.mExceptionHandler = jSExceptionHandler;
    }

    /* access modifiers changed from: protected */
    public final Result doInBackground(Void... voidArr) {
        try {
            return doInBackgroundGuarded();
        } catch (RuntimeException e10) {
            this.mExceptionHandler.handleException(e10);
            throw e10;
        }
    }
}
