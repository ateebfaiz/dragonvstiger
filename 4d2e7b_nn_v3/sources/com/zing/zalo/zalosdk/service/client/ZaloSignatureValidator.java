package com.zing.zalo.zalosdk.service.client;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;

class ZaloSignatureValidator {
    private static final String ZALO_DEBUG_HASH = "701554e30e4dadc7e21e132746ee0c4922bad83f";
    private static final String ZALO_RELEASE_HASH = "9487ba76b32e9e36785fb4c3540021f85af8d7b7";
    private static final HashSet<String> validAppSignatureHashes = buildAppSignatureHashes();

    ZaloSignatureValidator() {
    }

    private static HashSet<String> buildAppSignatureHashes() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(ZALO_DEBUG_HASH);
        hashSet.add(ZALO_RELEASE_HASH);
        return hashSet;
    }

    static boolean validateSignature(Context context, String str) {
        String str2 = Build.BRAND;
        int i10 = context.getApplicationInfo().flags;
        if (str2.startsWith("generic") && (i10 & 2) != 0) {
            return true;
        }
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            if (signatureArr != null) {
                if (signatureArr.length > 0) {
                    for (Signature byteArray : signatureArr) {
                        if (!validAppSignatureHashes.contains(Utility.sha1hash(byteArray.toByteArray()))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
