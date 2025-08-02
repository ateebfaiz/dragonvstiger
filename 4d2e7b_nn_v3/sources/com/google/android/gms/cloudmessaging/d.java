package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f6642a;

    /* renamed from: b  reason: collision with root package name */
    private final zzd f6643b;

    d(IBinder iBinder) {
        String str;
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f6642a = new Messenger(iBinder);
            this.f6643b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f6643b = new zzd(iBinder);
            this.f6642a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            if (valueOf.length() != 0) {
                str = "Invalid interface descriptor: ".concat(valueOf);
            } else {
                str = new String("Invalid interface descriptor: ");
            }
            Log.w("MessengerIpcClient", str);
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        Messenger messenger = this.f6642a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzd zzd = this.f6643b;
        if (zzd != null) {
            zzd.zzb(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
