package f0;

import android.os.Bundle;
import android.service.credentials.BeginCreateCredentialRequest;
import android.service.credentials.CallingAppInfo;

public abstract /* synthetic */ class e {
    public static /* synthetic */ BeginCreateCredentialRequest a(String str, Bundle bundle, CallingAppInfo callingAppInfo) {
        return new BeginCreateCredentialRequest(str, bundle, callingAppInfo);
    }
}
