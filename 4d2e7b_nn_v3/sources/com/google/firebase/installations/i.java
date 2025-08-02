package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

class i implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Utils f9138a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f9139b;

    public i(Utils utils, TaskCompletionSource taskCompletionSource) {
        this.f9138a = utils;
        this.f9139b = taskCompletionSource;
    }

    public boolean a(Exception exc) {
        this.f9139b.trySetException(exc);
        return true;
    }

    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isRegistered() || this.f9138a.isAuthTokenExpired(persistedInstallationEntry)) {
            return false;
        }
        this.f9139b.setResult(InstallationTokenResult.builder().setToken(persistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs()).build());
        return true;
    }
}
