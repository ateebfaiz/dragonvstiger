package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent;

public final /* synthetic */ class g implements LibraryVersionComponent.VersionExtractor {
    public final String extract(Object obj) {
        return FirebaseCommonRegistrar.lambda$getComponents$2((Context) obj);
    }
}
