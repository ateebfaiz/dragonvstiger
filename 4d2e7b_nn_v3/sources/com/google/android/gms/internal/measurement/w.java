package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.internal.zzfj;

final class w extends t0 {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f7340e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ String f7341f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Context f7342g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ Bundle f7343h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ zzef f7344i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    w(zzef zzef, String str, String str2, Context context, Bundle bundle) {
        super(zzef, true);
        this.f7344i = zzef;
        this.f7340e = str;
        this.f7341f = str2;
        this.f7342g = context;
        this.f7343h = bundle;
    }

    public final void a() {
        String str;
        String str2;
        String str3;
        boolean z10;
        try {
            if (this.f7344i.zzW(this.f7340e, this.f7341f)) {
                str = this.f7341f;
                str2 = this.f7340e;
                str3 = this.f7344i.zzd;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            Preconditions.checkNotNull(this.f7342g);
            zzef zzef = this.f7344i;
            zzef.zzj = zzef.zzf(this.f7342g, true);
            if (this.f7344i.zzj == null) {
                Log.w(this.f7344i.zzd, "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(this.f7342g, ModuleDescriptor.MODULE_ID);
            int remoteVersion = DynamiteModule.getRemoteVersion(this.f7342g, ModuleDescriptor.MODULE_ID);
            int max = Math.max(localVersion, remoteVersion);
            if (remoteVersion < localVersion) {
                z10 = true;
            } else {
                z10 = false;
            }
            ((zzcc) Preconditions.checkNotNull(this.f7344i.zzj)).initialize(ObjectWrapper.wrap(this.f7342g), new zzcl(74029, (long) max, z10, str3, str2, str, this.f7343h, zzfj.zza(this.f7342g)), this.f7315a);
        } catch (Exception e10) {
            this.f7344i.zzT(e10, true, false);
        }
    }
}
