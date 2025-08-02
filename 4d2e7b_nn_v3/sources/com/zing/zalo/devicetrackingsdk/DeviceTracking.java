package com.zing.zalo.devicetrackingsdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class DeviceTracking implements Handler.Callback {
    static final int ACT_GEN = 16385;
    static final int ACT_GEN_SDK_ID = 16386;
    static final int ACT_LOAD = 16384;
    private static DeviceTracking baseAppInfoInstance = new DeviceTracking();
    Api api;
    private String appID;
    private Context context;
    private Handler handler;
    private List<GetInfoListener> infoListeners;
    private boolean isGeneratingDeviceId;
    private boolean isGeneratingSDKId;
    public boolean isInitialized;
    private BaseAppInfoStorage storage;
    private HandlerThread thread;

    public interface GetInfoListener {
        void onGetDeviceIdComplete(String str);
    }

    DeviceTracking() {
        this.infoListeners = new ArrayList();
        this.api = new Api();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r0.hasNext() == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        ((com.zing.zalo.devicetrackingsdk.DeviceTracking.GetInfoListener) r0.next()).onGetDeviceIdComplete(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        r0 = r0.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void callbackAndResetListener(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List<com.zing.zalo.devicetrackingsdk.DeviceTracking$GetInfoListener> r0 = r2.infoListeners     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0030
            int r0 = r0.size()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x000c
            goto L_0x0030
        L_0x000c:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x002e }
            java.util.List<com.zing.zalo.devicetrackingsdk.DeviceTracking$GetInfoListener> r1 = r2.infoListeners     // Catch:{ all -> 0x002e }
            r0.<init>(r1)     // Catch:{ all -> 0x002e }
            java.util.List<com.zing.zalo.devicetrackingsdk.DeviceTracking$GetInfoListener> r1 = r2.infoListeners     // Catch:{ all -> 0x002e }
            r1.clear()     // Catch:{ all -> 0x002e }
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            java.util.Iterator r0 = r0.iterator()
        L_0x001d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r0.next()
            com.zing.zalo.devicetrackingsdk.DeviceTracking$GetInfoListener r1 = (com.zing.zalo.devicetrackingsdk.DeviceTracking.GetInfoListener) r1
            r1.onGetDeviceIdComplete(r3)
            goto L_0x001d
        L_0x002d:
            return
        L_0x002e:
            r3 = move-exception
            goto L_0x0032
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            return
        L_0x0032:
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.devicetrackingsdk.DeviceTracking.callbackAndResetListener(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0 = r5.api.getDeviceId(r5.context, r5.storage.getDeviceId());
        r5.storage.setDeviceId(r0.deviceId, r0.expireTime);
        r0 = r0.deviceId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        if (r0 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        r0 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        callbackAndResetListener(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r5.api.viewer = r5.storage.getViewer();
        r5.api.sdkId = r5.storage.getSDKId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generateDeviceIdIfNeeded() {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.isGeneratingDeviceId     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x004f
            boolean r0 = r5.isDeviceIdValid()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x000c
            goto L_0x004f
        L_0x000c:
            r0 = 1
            r5.isGeneratingDeviceId = r0     // Catch:{ all -> 0x004d }
            monitor-exit(r5)     // Catch:{ all -> 0x004d }
            com.zing.zalo.devicetrackingsdk.Api r0 = r5.api
            com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage r1 = r5.storage
            java.lang.String r1 = r1.getViewer()
            r0.viewer = r1
            com.zing.zalo.devicetrackingsdk.Api r0 = r5.api
            com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage r1 = r5.storage
            java.lang.String r1 = r1.getSDKId()
            r0.sdkId = r1
            com.zing.zalo.devicetrackingsdk.Api r0 = r5.api     // Catch:{ Exception -> 0x0044 }
            android.content.Context r1 = r5.context     // Catch:{ Exception -> 0x0044 }
            com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage r2 = r5.storage     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = r2.getDeviceId()     // Catch:{ Exception -> 0x0044 }
            com.zing.zalo.devicetrackingsdk.Api$DeviceIdResponse r0 = r0.getDeviceId(r1, r2)     // Catch:{ Exception -> 0x0044 }
            com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage r1 = r5.storage     // Catch:{ Exception -> 0x0044 }
            java.lang.String r2 = r0.deviceId     // Catch:{ Exception -> 0x0044 }
            long r3 = r0.expireTime     // Catch:{ Exception -> 0x0044 }
            r1.setDeviceId(r2, r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r0 = r0.deviceId     // Catch:{ Exception -> 0x0044 }
            if (r0 != 0) goto L_0x0041
            java.lang.String r0 = ""
        L_0x0041:
            r5.callbackAndResetListener(r0)     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            monitor-enter(r5)
            r0 = 0
            r5.isGeneratingDeviceId = r0     // Catch:{ all -> 0x004a }
            monitor-exit(r5)     // Catch:{ all -> 0x004a }
            return
        L_0x004a:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x004a }
            throw r0
        L_0x004d:
            r0 = move-exception
            goto L_0x0051
        L_0x004f:
            monitor-exit(r5)     // Catch:{ all -> 0x004d }
            return
        L_0x0051:
            monitor-exit(r5)     // Catch:{ all -> 0x004d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.devicetrackingsdk.DeviceTracking.generateDeviceIdIfNeeded():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.api.viewer = r3.storage.getViewer();
        r0 = r3.api.getSdkId(r3.context);
        r3.storage.setSDKId(r0.sdkId, r0.privateKey);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        com.zing.zalo.zalosdk.core.log.Log.e(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generateSDKIdIfNeeded() {
        /*
            r3 = this;
            com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage r0 = r3.storage
            java.lang.String r0 = r0.getSDKId()
            com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage r1 = r3.storage
            java.lang.String r1 = r1.getPrivateKey()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0019
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x0019
            return
        L_0x0019:
            monitor-enter(r3)
            boolean r0 = r3.isGeneratingSDKId     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0022
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
            return
        L_0x0020:
            r0 = move-exception
            goto L_0x004f
        L_0x0022:
            r0 = 1
            r3.isGeneratingSDKId = r0     // Catch:{ all -> 0x0020 }
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
            com.zing.zalo.devicetrackingsdk.Api r0 = r3.api     // Catch:{ Exception -> 0x0042 }
            com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage r1 = r3.storage     // Catch:{ Exception -> 0x0042 }
            java.lang.String r1 = r1.getViewer()     // Catch:{ Exception -> 0x0042 }
            r0.viewer = r1     // Catch:{ Exception -> 0x0042 }
            com.zing.zalo.devicetrackingsdk.Api r0 = r3.api     // Catch:{ Exception -> 0x0042 }
            android.content.Context r1 = r3.context     // Catch:{ Exception -> 0x0042 }
            com.zing.zalo.devicetrackingsdk.Api$SDKIdResponse r0 = r0.getSdkId(r1)     // Catch:{ Exception -> 0x0042 }
            com.zing.zalo.devicetrackingsdk.BaseAppInfoStorage r1 = r3.storage     // Catch:{ Exception -> 0x0042 }
            java.lang.String r2 = r0.sdkId     // Catch:{ Exception -> 0x0042 }
            java.lang.String r0 = r0.privateKey     // Catch:{ Exception -> 0x0042 }
            r1.setSDKId(r2, r0)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r0 = move-exception
            com.zing.zalo.zalosdk.core.log.Log.e((java.lang.Exception) r0)
        L_0x0046:
            monitor-enter(r3)
            r0 = 0
            r3.isGeneratingSDKId = r0     // Catch:{ all -> 0x004c }
            monitor-exit(r3)     // Catch:{ all -> 0x004c }
            return
        L_0x004c:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x004c }
            throw r0
        L_0x004f:
            monitor-exit(r3)     // Catch:{ all -> 0x0020 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zing.zalo.devicetrackingsdk.DeviceTracking.generateSDKIdIfNeeded():void");
    }

    public static DeviceTracking getInstance() {
        return baseAppInfoInstance;
    }

    private boolean hasDeviceId() {
        BaseAppInfoStorage baseAppInfoStorage;
        String deviceId;
        if (!this.isInitialized || (baseAppInfoStorage = this.storage) == null || (deviceId = baseAppInfoStorage.getDeviceId()) == null || deviceId.equals("")) {
            return false;
        }
        return true;
    }

    private boolean isDeviceIdValid() {
        BaseAppInfoStorage baseAppInfoStorage;
        if (!this.isInitialized || (baseAppInfoStorage = this.storage) == null) {
            return false;
        }
        String deviceId = baseAppInfoStorage.getDeviceId();
        if (this.storage.getDeviceIdExpiredTime() <= System.currentTimeMillis() || deviceId == null || deviceId.equals("")) {
            return false;
        }
        return true;
    }

    private void loadDeviceId() {
        this.storage.loadDeviceId();
        if (isDeviceIdValid()) {
            callbackAndResetListener(this.storage.getDeviceId());
        } else {
            generateDeviceIdIfNeeded();
        }
    }

    private synchronized void sendMessage(int i10) {
        try {
            if (this.handler == null) {
                HandlerThread handlerThread = new HandlerThread("zdt-device-tracker", 5);
                this.thread = handlerThread;
                handlerThread.start();
                this.handler = new Handler(this.thread.getLooper(), this);
            }
            Message obtainMessage = this.handler.obtainMessage(i10);
            if (obtainMessage != null) {
                this.handler.sendMessage(obtainMessage);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String getDeviceId() {
        if (!this.isInitialized) {
            return null;
        }
        if (!isDeviceIdValid()) {
            sendMessage(ACT_GEN);
        }
        return this.storage.getDeviceId();
    }

    public long getDeviceIdExpireTime() {
        if (!this.isInitialized) {
            return 0;
        }
        return this.storage.getDeviceIdExpiredTime();
    }

    public String getPrivateKey() {
        if (!this.isInitialized) {
            return null;
        }
        String privateKey = this.storage.getPrivateKey();
        if (!TextUtils.isEmpty(privateKey)) {
            return privateKey;
        }
        sendMessage(16386);
        return null;
    }

    public String getSDKId() {
        if (!this.isInitialized) {
            return null;
        }
        return this.storage.getSDKId();
    }

    public String getVersion() {
        return "4.24.1101";
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 16384:
                loadDeviceId();
                this.storage.loadSDKId();
                generateSDKIdIfNeeded();
                return true;
            case ACT_GEN /*16385*/:
                generateDeviceIdIfNeeded();
                return true;
            case 16386:
                generateSDKIdIfNeeded();
                return true;
            default:
                return false;
        }
    }

    public synchronized void initDeviceTracking(Context context2, BaseAppInfoStorage baseAppInfoStorage, String str) {
        if (!this.isInitialized) {
            this.storage = baseAppInfoStorage;
            this.context = context2;
            this.appID = str;
            Api api2 = this.api;
            api2.appId = str;
            api2.isPreInstalled = baseAppInfoStorage.ispreInstalled();
            this.isInitialized = true;
            sendMessage(16384);
        }
    }

    public JSONObject prepareCommonHeaderData() {
        return this.api.prepareCommonHeaderData(this.context);
    }

    public JSONObject prepareDeviceIdData() {
        return this.api.prepareDeviceIdData(this.context);
    }

    public JSONObject prepareExtraInfo(int i10) {
        return this.api.prepareExtraInfo(i10);
    }

    public JSONObject prepareTrackingData() {
        return this.api.prepareTrackingData(this.context, this.storage.getDeviceId(), System.currentTimeMillis());
    }

    DeviceTracking(Api api2, Handler handler2) {
        this.infoListeners = new ArrayList();
        this.api = api2;
        this.handler = handler2;
    }

    public void getDeviceId(GetInfoListener getInfoListener) {
        if (hasDeviceId()) {
            if (getInfoListener != null) {
                getInfoListener.onGetDeviceIdComplete(this.storage.getDeviceId());
            }
            if (!isDeviceIdValid()) {
                sendMessage(ACT_GEN);
                return;
            }
            return;
        }
        if (getInfoListener != null) {
            synchronized (this) {
                this.infoListeners.add(getInfoListener);
            }
        }
        if (this.isInitialized) {
            sendMessage(ACT_GEN);
        }
    }
}
