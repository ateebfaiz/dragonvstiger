package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class q implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f6803a;

    /* synthetic */ q(r rVar, zzq zzq) {
        this.f6803a = rVar;
    }

    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            synchronized (this.f6803a.f6804a) {
                try {
                    zzo zzo = (zzo) message.obj;
                    p pVar = (p) this.f6803a.f6804a.get(zzo);
                    if (pVar != null && pVar.i()) {
                        if (pVar.j()) {
                            pVar.g("GmsClientSupervisor");
                        }
                        this.f6803a.f6804a.remove(zzo);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } else if (i10 != 1) {
            return false;
        } else {
            synchronized (this.f6803a.f6804a) {
                try {
                    zzo zzo2 = (zzo) message.obj;
                    p pVar2 = (p) this.f6803a.f6804a.get(zzo2);
                    if (pVar2 != null && pVar2.a() == 3) {
                        String valueOf = String.valueOf(zzo2);
                        Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                        ComponentName b10 = pVar2.b();
                        if (b10 == null) {
                            b10 = zzo2.zza();
                        }
                        if (b10 == null) {
                            String zzc = zzo2.zzc();
                            Preconditions.checkNotNull(zzc);
                            b10 = new ComponentName(zzc, "unknown");
                        }
                        pVar2.onServiceDisconnected(b10);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return true;
        }
    }
}
