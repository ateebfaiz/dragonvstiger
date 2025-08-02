package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.UserManagerCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    private final Context applicationContext;
    private final Executor backgroundExecutor;
    private final Set<HeartBeatConsumer> consumers;
    private final Provider<m> storageProvider;
    private final Provider<UserAgentPublisher> userAgentProvider;

    private DefaultHeartBeatController(Context context, String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider, Executor executor) {
        this((Provider<m>) new c(context, str), set, executor, provider, context);
    }

    @NonNull
    public static Component<DefaultHeartBeatController> component() {
        Qualified<Executor> qualified = Qualified.qualified(Background.class, Executor.class);
        return Component.builder(DefaultHeartBeatController.class, (Class<? super T>[]) new Class[]{HeartBeatController.class, HeartBeatInfo.class}).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.setOf((Class<?>) HeartBeatConsumer.class)).add(Dependency.requiredProvider((Class<?>) UserAgentPublisher.class)).add(Dependency.required((Qualified<?>) qualified)).factory(new e(qualified)).build();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ DefaultHeartBeatController lambda$component$3(Qualified qualified, ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.get(Context.class), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).getPersistenceKey(), componentContainer.setOf(HeartBeatConsumer.class), componentContainer.getProvider(UserAgentPublisher.class), (Executor) componentContainer.get(qualified));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$getHeartBeatsHeader$1() throws Exception {
        Base64OutputStream base64OutputStream;
        GZIPOutputStream gZIPOutputStream;
        String byteArrayOutputStream;
        synchronized (this) {
            try {
                m mVar = this.storageProvider.get();
                List c10 = mVar.c();
                mVar.b();
                JSONArray jSONArray = new JSONArray();
                for (int i10 = 0; i10 < c10.size(); i10++) {
                    HeartBeatResult heartBeatResult = (HeartBeatResult) c10.get(i10);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", heartBeatResult.getUserAgent());
                    jSONObject.put("dates", new JSONArray(heartBeatResult.getUsedDates()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", ExifInterface.GPS_MEASUREMENT_2D);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString("UTF-8");
            } catch (Throwable th) {
                throw th;
            }
        }
        return byteArrayOutputStream;
        throw th;
        throw th;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ m lambda$new$2(Context context, String str) {
        return new m(context, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$registerHeartBeat$0() throws Exception {
        synchronized (this) {
            this.storageProvider.get().k(System.currentTimeMillis(), this.userAgentProvider.get().getUserAgent());
        }
        return null;
    }

    @NonNull
    public synchronized HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String str) {
        long currentTimeMillis = System.currentTimeMillis();
        m mVar = this.storageProvider.get();
        if (mVar.i(currentTimeMillis)) {
            mVar.g();
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    public Task<String> getHeartBeatsHeader() {
        if (!UserManagerCompat.isUserUnlocked(this.applicationContext)) {
            return Tasks.forResult("");
        }
        return Tasks.call(this.backgroundExecutor, new d(this));
    }

    public Task<Void> registerHeartBeat() {
        if (this.consumers.size() <= 0) {
            return Tasks.forResult(null);
        }
        if (!UserManagerCompat.isUserUnlocked(this.applicationContext)) {
            return Tasks.forResult(null);
        }
        return Tasks.call(this.backgroundExecutor, new f(this));
    }

    @VisibleForTesting
    DefaultHeartBeatController(Provider<m> provider, Set<HeartBeatConsumer> set, Executor executor, Provider<UserAgentPublisher> provider2, Context context) {
        this.storageProvider = provider;
        this.consumers = set;
        this.backgroundExecutor = executor;
        this.userAgentProvider = provider2;
        this.applicationContext = context;
    }
}
