package com.google.android.gms.tasks;

final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f7859a;

    l(m mVar) {
        this.f7859a = mVar;
    }

    public final void run() {
        synchronized (this.f7859a.f7861b) {
            try {
                m mVar = this.f7859a;
                if (mVar.f7862c != null) {
                    mVar.f7862c.onCanceled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
