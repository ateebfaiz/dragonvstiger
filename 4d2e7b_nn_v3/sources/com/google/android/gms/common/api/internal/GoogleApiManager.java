package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArraySet;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.zal;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

@ShowFirstParty
@KeepForSdk
public class GoogleApiManager implements Handler.Callback {
    @NonNull
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */
    public static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */
    public static final Object zac = new Object();
    @Nullable
    private static GoogleApiManager zad;
    /* access modifiers changed from: private */
    public long zae = 5000;
    /* access modifiers changed from: private */
    public long zaf = 120000;
    /* access modifiers changed from: private */
    public long zag = WorkRequest.MIN_BACKOFF_MILLIS;
    /* access modifiers changed from: private */
    public boolean zah = false;
    @Nullable
    private TelemetryData zai;
    @Nullable
    private TelemetryLoggingClient zaj;
    /* access modifiers changed from: private */
    public final Context zak;
    /* access modifiers changed from: private */
    public final GoogleApiAvailability zal;
    /* access modifiers changed from: private */
    public final zal zam;
    private final AtomicInteger zan = new AtomicInteger(1);
    private final AtomicInteger zao = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Map<ApiKey<?>, zabq<?>> zap = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */
    @Nullable
    public zaae zaq = null;
    /* access modifiers changed from: private */
    public final Set<ApiKey<?>> zar = new ArraySet();
    private final Set<ApiKey<?>> zas = new ArraySet();
    /* access modifiers changed from: private */
    @NotOnlyInitialized
    public final Handler zat;
    /* access modifiers changed from: private */
    public volatile boolean zau = true;

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zak = context;
        zaq zaq2 = new zaq(looper, this);
        this.zat = zaq2;
        this.zal = googleApiAvailability;
        this.zam = new zal(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.zau = false;
        }
        zaq2.sendMessage(zaq2.obtainMessage(6));
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (zac) {
            try {
                GoogleApiManager googleApiManager = zad;
                if (googleApiManager != null) {
                    googleApiManager.zao.incrementAndGet();
                    Handler handler = googleApiManager.zat;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static Status zaH(ApiKey<?> apiKey, ConnectionResult connectionResult) {
        String zab2 = apiKey.zab();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb2 = new StringBuilder(String.valueOf(zab2).length() + 63 + valueOf.length());
        sb2.append("API: ");
        sb2.append(zab2);
        sb2.append(" is not available on this device. Connection failed with: ");
        sb2.append(valueOf);
        return new Status(connectionResult, sb2.toString());
    }

    @WorkerThread
    private final zabq<?> zaI(GoogleApi<?> googleApi) {
        ApiKey<?> apiKey = googleApi.getApiKey();
        zabq<?> zabq = this.zap.get(apiKey);
        if (zabq == null) {
            zabq = new zabq<>(this, googleApi);
            this.zap.put(apiKey, zabq);
        }
        if (zabq.zaz()) {
            this.zas.add(apiKey);
        }
        zabq.zao();
        return zabq;
    }

    @WorkerThread
    private final TelemetryLoggingClient zaJ() {
        if (this.zaj == null) {
            this.zaj = TelemetryLogging.getClient(this.zak);
        }
        return this.zaj;
    }

    @WorkerThread
    private final void zaK() {
        TelemetryData telemetryData = this.zai;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || zaF()) {
                zaJ().log(telemetryData);
            }
            this.zai = null;
        }
    }

    private final <T> void zaL(TaskCompletionSource<T> taskCompletionSource, int i10, GoogleApi googleApi) {
        h0 a10;
        if (i10 != 0 && (a10 = h0.a(this, i10, googleApi.getApiKey())) != null) {
            Task<T> task = taskCompletionSource.getTask();
            Handler handler = this.zat;
            handler.getClass();
            task.addOnCompleteListener((Executor) new zabk(handler), (OnCompleteListener<T>) a10);
        }
    }

    @NonNull
    public static GoogleApiManager zal() {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            Preconditions.checkNotNull(zad, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    @NonNull
    public static GoogleApiManager zam(@NonNull Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            try {
                if (zad == null) {
                    zad = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.getInstance());
                }
                googleApiManager = zad;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    @WorkerThread
    public final boolean handleMessage(@NonNull Message message) {
        int i10 = message.what;
        long j10 = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        zabq zabq = null;
        switch (i10) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j10 = WorkRequest.MIN_BACKOFF_MILLIS;
                }
                this.zag = j10;
                this.zat.removeMessages(12);
                for (ApiKey<?> obtainMessage : this.zap.keySet()) {
                    Handler handler = this.zat;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.zag);
                }
                break;
            case 2:
                zal zal2 = (zal) message.obj;
                Iterator<ApiKey<?>> it = zal2.zab().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        ApiKey next = it.next();
                        zabq zabq2 = this.zap.get(next);
                        if (zabq2 == null) {
                            zal2.zac(next, new ConnectionResult(13), (String) null);
                            break;
                        } else if (zabq2.zay()) {
                            zal2.zac(next, ConnectionResult.RESULT_SUCCESS, zabq2.zaf().getEndpointPackageName());
                        } else {
                            ConnectionResult zad2 = zabq2.zad();
                            if (zad2 != null) {
                                zal2.zac(next, zad2, (String) null);
                            } else {
                                zabq2.zat(zal2);
                                zabq2.zao();
                            }
                        }
                    }
                }
            case 3:
                for (zabq next2 : this.zap.values()) {
                    next2.zan();
                    next2.zao();
                }
                break;
            case 4:
            case 8:
            case 13:
                zach zach = (zach) message.obj;
                zabq<?> zabq3 = this.zap.get(zach.zac.getApiKey());
                if (zabq3 == null) {
                    zabq3 = zaI(zach.zac);
                }
                if (zabq3.zaz() && this.zao.get() != zach.zab) {
                    zach.zaa.zad(zaa);
                    zabq3.zav();
                    break;
                } else {
                    zabq3.zap(zach.zaa);
                    break;
                }
                break;
            case 5:
                int i11 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zabq<?>> it2 = this.zap.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zabq next3 = it2.next();
                        if (next3.zab() == i11) {
                            zabq = next3;
                        }
                    }
                }
                if (zabq != null) {
                    if (connectionResult.getErrorCode() != 13) {
                        zabq.zaD(zaH(zabq.zad, connectionResult));
                        break;
                    } else {
                        String errorString = this.zal.getErrorString(connectionResult.getErrorCode());
                        String errorMessage = connectionResult.getErrorMessage();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(errorString).length() + 69 + String.valueOf(errorMessage).length());
                        sb2.append("Error resolution was canceled by the user, original error message: ");
                        sb2.append(errorString);
                        sb2.append(": ");
                        sb2.append(errorMessage);
                        zabq.zaD(new Status(17, sb2.toString()));
                        break;
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder(76);
                    sb3.append("Could not find API instance ");
                    sb3.append(i11);
                    sb3.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb3.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.zak.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) this.zak.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new z(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zag = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
                        break;
                    }
                }
                break;
            case 7:
                zaI((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zap.containsKey(message.obj)) {
                    this.zap.get(message.obj).zau();
                    break;
                }
                break;
            case 10:
                for (ApiKey<?> remove : this.zas) {
                    zabq remove2 = this.zap.remove(remove);
                    if (remove2 != null) {
                        remove2.zav();
                    }
                }
                this.zas.clear();
                break;
            case 11:
                if (this.zap.containsKey(message.obj)) {
                    this.zap.get(message.obj).zaw();
                    break;
                }
                break;
            case 12:
                if (this.zap.containsKey(message.obj)) {
                    this.zap.get(message.obj).zaA();
                    break;
                }
                break;
            case 14:
                e eVar = (e) message.obj;
                ApiKey a10 = eVar.a();
                if (this.zap.containsKey(a10)) {
                    eVar.b().setResult(Boolean.valueOf(this.zap.get(a10).zaN(false)));
                    break;
                } else {
                    eVar.b().setResult(Boolean.FALSE);
                    break;
                }
            case 15:
                e0 e0Var = (e0) message.obj;
                if (this.zap.containsKey(e0Var.f6685a)) {
                    zabq.zal(this.zap.get(e0Var.f6685a), e0Var);
                    break;
                }
                break;
            case 16:
                e0 e0Var2 = (e0) message.obj;
                if (this.zap.containsKey(e0Var2.f6685a)) {
                    zabq.zam(this.zap.get(e0Var2.f6685a), e0Var2);
                    break;
                }
                break;
            case 17:
                zaK();
                break;
            case 18:
                i0 i0Var = (i0) message.obj;
                if (i0Var.f6708c != 0) {
                    TelemetryData telemetryData = this.zai;
                    if (telemetryData != null) {
                        List<MethodInvocation> zab2 = telemetryData.zab();
                        if (telemetryData.zaa() != i0Var.f6707b || (zab2 != null && zab2.size() >= i0Var.f6709d)) {
                            this.zat.removeMessages(17);
                            zaK();
                        } else {
                            this.zai.zac(i0Var.f6706a);
                        }
                    }
                    if (this.zai == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(i0Var.f6706a);
                        this.zai = new TelemetryData(i0Var.f6707b, arrayList);
                        Handler handler2 = this.zat;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), i0Var.f6708c);
                        break;
                    }
                } else {
                    zaJ().log(new TelemetryData(i0Var.f6707b, Arrays.asList(new MethodInvocation[]{i0Var.f6706a})));
                    break;
                }
                break;
            case 19:
                this.zah = false;
                break;
            default:
                StringBuilder sb4 = new StringBuilder(31);
                sb4.append("Unknown message id: ");
                sb4.append(i10);
                Log.w("GoogleApiManager", sb4.toString());
                return false;
        }
        return true;
    }

    public final void zaA() {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void zaB(@NonNull GoogleApi<?> googleApi) {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void zaC(@NonNull zaae zaae) {
        synchronized (zac) {
            try {
                if (this.zaq != zaae) {
                    this.zaq = zaae;
                    this.zar.clear();
                }
                this.zar.addAll(zaae.zaa());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaD(@NonNull zaae zaae) {
        synchronized (zac) {
            try {
                if (this.zaq == zaae) {
                    this.zaq = null;
                    this.zar.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zaF() {
        if (this.zah) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null && !config.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int zaa2 = this.zam.zaa(this.zak, 203400000);
        if (zaa2 == -1 || zaa2 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zaG(ConnectionResult connectionResult, int i10) {
        return this.zal.zah(this.zak, connectionResult, i10);
    }

    public final int zaa() {
        return this.zan.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final zabq zak(ApiKey<?> apiKey) {
        return this.zap.get(apiKey);
    }

    @NonNull
    public final Task<Map<ApiKey<?>, String>> zao(@NonNull Iterable<? extends HasApiKey<?>> iterable) {
        zal zal2 = new zal(iterable);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(2, zal2));
        return zal2.zaa();
    }

    @NonNull
    public final Task<Boolean> zap(@NonNull GoogleApi<?> googleApi) {
        e eVar = new e(googleApi.getApiKey());
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(14, eVar));
        return eVar.b().getTask();
    }

    @NonNull
    public final <O extends Api.ApiOptions> Task<Void> zaq(@NonNull GoogleApi<O> googleApi, @NonNull RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, @NonNull UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod, @NonNull Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaL(taskCompletionSource, registerListenerMethod.zaa(), googleApi);
        zaf zaf2 = new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(8, new zach(zaf2, this.zao.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public final <O extends Api.ApiOptions> Task<Boolean> zar(@NonNull GoogleApi<O> googleApi, @NonNull ListenerHolder.ListenerKey listenerKey, int i10) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaL(taskCompletionSource, i10, googleApi);
        zah zah2 = new zah(listenerKey, taskCompletionSource);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(13, new zach(zah2, this.zao.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> void zaw(@NonNull GoogleApi<O> googleApi, int i10, @NonNull BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zae zae2 = new zae(i10, apiMethodImpl);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(4, new zach(zae2, this.zao.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void zax(@NonNull GoogleApi<O> googleApi, int i10, @NonNull TaskApiCall<Api.AnyClient, ResultT> taskApiCall, @NonNull TaskCompletionSource<ResultT> taskCompletionSource, @NonNull StatusExceptionMapper statusExceptionMapper) {
        zaL(taskCompletionSource, taskApiCall.zaa(), googleApi);
        zag zag2 = new zag(i10, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(4, new zach(zag2, this.zao.get(), googleApi)));
    }

    /* access modifiers changed from: package-private */
    public final void zay(MethodInvocation methodInvocation, int i10, long j10, int i11) {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(18, new i0(methodInvocation, i10, j10, i11)));
    }

    public final void zaz(@NonNull ConnectionResult connectionResult, int i10) {
        if (!zaG(connectionResult, i10)) {
            Handler handler = this.zat;
            handler.sendMessage(handler.obtainMessage(5, i10, 0, connectionResult));
        }
    }
}
