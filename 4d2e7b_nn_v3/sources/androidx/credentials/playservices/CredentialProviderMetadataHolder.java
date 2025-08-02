package androidx.credentials.playservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class CredentialProviderMetadataHolder extends Service {
    private final LocalBinder binder = new LocalBinder();

    public final class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public final CredentialProviderMetadataHolder getService() {
            return CredentialProviderMetadataHolder.this;
        }
    }

    public IBinder onBind(Intent intent) {
        m.f(intent, "intent");
        return this.binder;
    }
}
