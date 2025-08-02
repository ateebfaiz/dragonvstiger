package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation;

abstract class e extends BaseImplementation.ApiMethodImpl {
    public e(GoogleApiClient googleApiClient) {
        super((Api<?>) Common.API, googleApiClient);
    }
}
