package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Status;

final class i implements WorkAccountApi.AddAccountResult {

    /* renamed from: c  reason: collision with root package name */
    private static final Account f6931c = new Account("DUMMY_NAME", "com.google");

    /* renamed from: a  reason: collision with root package name */
    private final Status f6932a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f6933b;

    public i(Status status, Account account) {
        this.f6932a = status;
        this.f6933b = account == null ? f6931c : account;
    }

    public final Account getAccount() {
        return this.f6933b;
    }

    public final Status getStatus() {
        return this.f6932a;
    }
}
