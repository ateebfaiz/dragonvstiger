package com.zing.zalo.zalosdk.service.client;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.zing.zalo.zalosdk.core.log.Log;
import com.zing.zalo.zalosdk.service.client.PlatformServiceClient;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class ZaloService {
    public int getUserLoggedStatus(Context context) throws InterruptedException {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            PlatformServiceClient platformServiceClient = new PlatformServiceClient(context, 10001);
            final AtomicInteger atomicInteger = new AtomicInteger(-1);
            platformServiceClient.setCompletedListener(new PlatformServiceClient.CompletedListener() {
                public void completed(Bundle bundle) {
                    if (bundle != null) {
                        try {
                            if (bundle.getInt("com.zing.zalo.platform.result.ERROR_CODE") == 0) {
                                JSONObject jSONObject = new JSONObject(bundle.getString("com.zing.zalo.platform.result.DATA"));
                                if (jSONObject.has("isUserLogged")) {
                                    atomicInteger.set(jSONObject.getBoolean("isUserLogged") ? 1 : 0);
                                }
                            }
                        } catch (Exception e10) {
                            Log.e(e10);
                        }
                    }
                    synchronized (atomicInteger) {
                        atomicInteger.notifyAll();
                    }
                }
            });
            if (!platformServiceClient.start()) {
                return -1;
            }
            synchronized (atomicInteger) {
                atomicInteger.wait(5000);
            }
            return atomicInteger.get();
        }
        throw new IllegalThreadStateException("'isUserLogged' can't run in UI-thread");
    }
}
