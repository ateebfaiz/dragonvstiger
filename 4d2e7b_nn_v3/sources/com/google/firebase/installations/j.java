package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

class j implements k {

    /* renamed from: a  reason: collision with root package name */
    final TaskCompletionSource f9140a;

    public j(TaskCompletionSource taskCompletionSource) {
        this.f9140a = taskCompletionSource;
    }

    public boolean a(Exception exc) {
        return false;
    }

    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && !persistedInstallationEntry.isErrored()) {
            return false;
        }
        this.f9140a.trySetResult(persistedInstallationEntry.getFirebaseInstallationId());
        return true;
    }
}
