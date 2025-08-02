package f0;

import android.app.slice.Slice;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.CredentialEntry;

public abstract /* synthetic */ class k0 {
    public static /* synthetic */ CredentialEntry a(BeginGetCredentialOption beginGetCredentialOption, Slice slice) {
        return new CredentialEntry(beginGetCredentialOption, slice);
    }
}
