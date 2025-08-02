package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import io.jsonwebtoken.JwsHeader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rpc {
    private static int zza;
    private static PendingIntent zzb;
    private static final Executor zzc = zzz.zza;
    private static final Pattern zzd = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zze = new SimpleArrayMap<>();
    private final Context zzf;
    private final zzt zzg;
    private final ScheduledExecutorService zzh;
    private Messenger zzi;
    private Messenger zzj;
    private zzd zzk;

    public Rpc(@NonNull Context context) {
        this.zzf = context;
        this.zzg = new zzt(context);
        this.zzi = new Messenger(new a(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzh = scheduledThreadPoolExecutor;
    }

    static /* synthetic */ Task zza(Bundle bundle) throws Exception {
        if (zzi(bundle)) {
            return Tasks.forResult(null);
        }
        return Tasks.forResult(bundle);
    }

    static /* bridge */ /* synthetic */ void zzc(Rpc rpc, Message message) {
        String str;
        String str2;
        String str3;
        String str4;
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzc());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        rpc.zzk = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        rpc.zzj = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    String stringExtra = intent2.getStringExtra("registration_id");
                    if (stringExtra == null) {
                        stringExtra = intent2.getStringExtra("unregistered");
                    }
                    if (stringExtra == null) {
                        String stringExtra2 = intent2.getStringExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                        if (stringExtra2 == null) {
                            String valueOf = String.valueOf(intent2.getExtras());
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 49);
                            sb2.append("Unexpected response, no error or registration id ");
                            sb2.append(valueOf);
                            Log.w("Rpc", sb2.toString());
                            return;
                        }
                        if (Log.isLoggable("Rpc", 3)) {
                            if (stringExtra2.length() != 0) {
                                str3 = "Received InstanceID error ".concat(stringExtra2);
                            } else {
                                str3 = new String("Received InstanceID error ");
                            }
                            Log.d("Rpc", str3);
                        }
                        if (stringExtra2.startsWith("|")) {
                            String[] split = stringExtra2.split("\\|");
                            if (split.length <= 2 || !"ID".equals(split[1])) {
                                if (stringExtra2.length() != 0) {
                                    str2 = "Unexpected structured response ".concat(stringExtra2);
                                } else {
                                    str2 = new String("Unexpected structured response ");
                                }
                                Log.w("Rpc", str2);
                                return;
                            }
                            String str5 = split[2];
                            String str6 = split[3];
                            if (str6.startsWith(":")) {
                                str6 = str6.substring(1);
                            }
                            rpc.zzh(str5, intent2.putExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR, str6).getExtras());
                            return;
                        }
                        synchronized (rpc.zze) {
                            int i10 = 0;
                            while (i10 < rpc.zze.size()) {
                                try {
                                    rpc.zzh(rpc.zze.keyAt(i10), intent2.getExtras());
                                    i10++;
                                } finally {
                                }
                            }
                        }
                        return;
                    }
                    Matcher matcher = zzd.matcher(stringExtra);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        if (group != null) {
                            Bundle extras = intent2.getExtras();
                            extras.putString("registration_id", group2);
                            rpc.zzh(group, extras);
                            return;
                        }
                        return;
                    } else if (Log.isLoggable("Rpc", 3)) {
                        if (stringExtra.length() != 0) {
                            str = "Unexpected response string: ".concat(stringExtra);
                        } else {
                            str = new String("Unexpected response string: ");
                        }
                        Log.d("Rpc", str);
                        return;
                    } else {
                        return;
                    }
                } else if (Log.isLoggable("Rpc", 3)) {
                    String valueOf2 = String.valueOf(action);
                    if (valueOf2.length() != 0) {
                        str4 = "Unexpected response action: ".concat(valueOf2);
                    } else {
                        str4 = new String("Unexpected response action: ");
                    }
                    Log.d("Rpc", str4);
                    return;
                } else {
                    return;
                }
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    @AnyThread
    private final Task<Bundle> zze(Bundle bundle) {
        String zzf2 = zzf();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.zze) {
            this.zze.put(zzf2, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        if (this.zzg.zzb() == 2) {
            intent.setAction("com.google.iid.TOKEN_REQUEST");
        } else {
            intent.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent.putExtras(bundle);
        zzg(this.zzf, intent);
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzf2).length() + 5);
        sb2.append("|ID|");
        sb2.append(zzf2);
        sb2.append("|");
        intent.putExtra(JwsHeader.KEY_ID, sb2.toString());
        if (Log.isLoggable("Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 8);
            sb3.append("Sending ");
            sb3.append(valueOf);
            Log.d("Rpc", sb3.toString());
        }
        intent.putExtra("google.messenger", this.zzi);
        if (!(this.zzj == null && this.zzk == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                Messenger messenger = this.zzj;
                if (messenger != null) {
                    messenger.send(obtain);
                } else {
                    this.zzk.zzb(obtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
            }
            taskCompletionSource.getTask().addOnCompleteListener(zzc, new zzw(this, zzf2, this.zzh.schedule(new zzy(taskCompletionSource), 30, TimeUnit.SECONDS)));
            return taskCompletionSource.getTask();
        }
        if (this.zzg.zzb() == 2) {
            this.zzf.sendBroadcast(intent);
        } else {
            this.zzf.startService(intent);
        }
        taskCompletionSource.getTask().addOnCompleteListener(zzc, new zzw(this, zzf2, this.zzh.schedule(new zzy(taskCompletionSource), 30, TimeUnit.SECONDS)));
        return taskCompletionSource.getTask();
    }

    private static synchronized String zzf() {
        String num;
        synchronized (Rpc.class) {
            int i10 = zza;
            zza = i10 + 1;
            num = Integer.toString(i10);
        }
        return num;
    }

    private static synchronized void zzg(Context context, Intent intent) {
        synchronized (Rpc.class) {
            try {
                if (zzb == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage("com.google.example.invalidpackage");
                    zzb = zza.zza(context, 0, intent2, zza.zza);
                }
                intent.putExtra("app", zzb);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzh(String str, @Nullable Bundle bundle) {
        String str2;
        synchronized (this.zze) {
            try {
                TaskCompletionSource remove = this.zze.remove(str);
                if (remove == null) {
                    String valueOf = String.valueOf(str);
                    if (valueOf.length() != 0) {
                        str2 = "Missing callback for ".concat(valueOf);
                    } else {
                        str2 = new String("Missing callback for ");
                    }
                    Log.w("Rpc", str2);
                    return;
                }
                remove.setResult(bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean zzi(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("google.messenger")) {
            return false;
        }
        return true;
    }

    @NonNull
    public Task<Bundle> send(@NonNull Bundle bundle) {
        if (this.zzg.zza() >= 12000000) {
            return zzs.zzb(this.zzf).zzd(1, bundle).continueWith(zzc, zzv.zza);
        }
        if (this.zzg.zzb() != 0) {
            return zze(bundle).continueWithTask(zzc, new zzu(this, bundle));
        }
        return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
    }

    @NonNull
    public final /* synthetic */ Task zzb(@NonNull Bundle bundle, @NonNull Task task) throws Exception {
        if (task.isSuccessful() && zzi((Bundle) task.getResult())) {
            return zze(bundle).onSuccessTask(zzc, zzx.zza);
        }
        return task;
    }

    public final /* synthetic */ void zzd(@NonNull String str, @NonNull ScheduledFuture scheduledFuture, @NonNull Task task) {
        synchronized (this.zze) {
            this.zze.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
