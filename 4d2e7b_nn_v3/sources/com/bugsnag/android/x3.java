package com.bugsnag.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class x3 {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f19132a;

    static {
        HashMap hashMap = new HashMap();
        f19132a = hashMap;
        hashMap.put(1, "DiskWrite");
        hashMap.put(2, "DiskRead");
        hashMap.put(4, "NetworkOperation");
        hashMap.put(8, "CustomSlowCall");
        hashMap.put(16, "ResourceMismatch");
        hashMap.put(256, "CursorLeak");
        hashMap.put(512, "CloseableLeak");
        hashMap.put(1024, "ActivityLeak");
        hashMap.put(2048, "InstanceLeak");
        hashMap.put(4096, "RegistrationLeak");
        hashMap.put(8192, "FileUriLeak");
        hashMap.put(16384, "CleartextNetwork");
    }

    x3() {
    }

    private Throwable a(Throwable th) {
        List a10 = g4.a(th);
        return (Throwable) a10.get(a10.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf("violation=");
            if (lastIndexOf == -1) {
                return null;
            }
            String replace = str.substring(lastIndexOf).replace("violation=", "");
            if (!TextUtils.isDigitsOnly(replace)) {
                return null;
            }
            return (String) f19132a.get(Integer.valueOf(replace));
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public boolean c(Throwable th) {
        return a(th).getClass().getName().toLowerCase(Locale.US).startsWith("android.os.strictmode");
    }
}
