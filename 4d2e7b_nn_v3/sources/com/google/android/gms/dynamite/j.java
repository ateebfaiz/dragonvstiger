package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class j implements DynamiteModule.VersionPolicy {
    j() {
    }

    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.zza(context, str);
        int zzb = iVersions.zzb(context, str, true);
        selectionResult.remoteVersion = zzb;
        int i10 = selectionResult.localVersion;
        if (i10 == 0) {
            i10 = 0;
            if (zzb == 0) {
                selectionResult.selection = 0;
                return selectionResult;
            }
        }
        if (i10 >= zzb) {
            selectionResult.selection = -1;
        } else {
            selectionResult.selection = 1;
        }
        return selectionResult;
    }
}
