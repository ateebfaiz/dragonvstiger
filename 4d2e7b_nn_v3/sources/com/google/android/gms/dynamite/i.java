package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class i implements DynamiteModule.VersionPolicy {
    i() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zzb = iVersions.zzb(context, str, false);
        selectionResult.remoteVersion = zzb;
        if (zzb == 0) {
            selectionResult.selection = 0;
        } else {
            selectionResult.selection = 1;
        }
        return selectionResult;
    }
}
