package com.google.firebase;

import android.content.Context;
import com.google.firebase.platforminfo.LibraryVersionComponent;

public final /* synthetic */ class f implements LibraryVersionComponent.VersionExtractor {
    public final String extract(Object obj) {
        return FirebaseCommonRegistrar.lambda$getComponents$1((Context) obj);
    }
}
