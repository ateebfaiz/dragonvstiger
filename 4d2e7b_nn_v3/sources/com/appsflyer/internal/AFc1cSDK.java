package com.appsflyer.internal;

import androidx.annotation.NonNull;
import org.json.JSONException;

public interface AFc1cSDK<ResponseType> {
    @NonNull
    ResponseType valueOf(String str) throws JSONException;
}
