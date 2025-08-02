package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.a1;
import java.util.concurrent.Executor;

class x0 extends Binder {

    /* renamed from: a  reason: collision with root package name */
    private final a f9321a;

    interface a {
        Task a(Intent intent);
    }

    x0(a aVar) {
        this.f9321a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void c(a1.a aVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "service received new intent via bind strategy");
            }
            this.f9321a.a(aVar.f9217a).addOnCompleteListener((Executor) new androidx.credentials.a(), new w0(aVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
