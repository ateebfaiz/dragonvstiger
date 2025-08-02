package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzdt {
    private static final Object zza = new Object();
    private final String zzb;
    private final m zzc;
    private final Object zzd;
    private final Object zze;
    private final Object zzf = new Object();
    @GuardedBy("overrideLock")
    private volatile Object zzg = null;
    @GuardedBy("cachingLock")
    private volatile Object zzh = null;

    /* synthetic */ zzdt(String str, Object obj, Object obj2, m mVar, zzds zzds) {
        this.zzb = str;
        this.zzd = obj;
        this.zze = obj2;
        this.zzc = mVar;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0048 */
    public final java.lang.Object zza(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzf
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x0007
            return r4
        L_0x0007:
            com.google.android.gms.measurement.internal.zzab r4 = com.google.android.gms.measurement.internal.n.f7636a
            if (r4 != 0) goto L_0x000e
            java.lang.Object r4 = r3.zzd
            return r4
        L_0x000e:
            java.lang.Object r4 = zza
            monitor-enter(r4)
            boolean r0 = com.google.android.gms.measurement.internal.zzab.zza()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r3.zzh     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0020
            java.lang.Object r0 = r3.zzd     // Catch:{ all -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r0 = move-exception
            goto L_0x006c
        L_0x0020:
            java.lang.Object r0 = r3.zzh     // Catch:{ all -> 0x001e }
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            return r0
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            java.util.List r4 = com.google.android.gms.measurement.internal.zzdu.zzav     // Catch:{ SecurityException -> 0x005a }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ SecurityException -> 0x005a }
        L_0x002d:
            boolean r0 = r4.hasNext()     // Catch:{ SecurityException -> 0x005a }
            if (r0 == 0) goto L_0x005a
            java.lang.Object r0 = r4.next()     // Catch:{ SecurityException -> 0x005a }
            com.google.android.gms.measurement.internal.zzdt r0 = (com.google.android.gms.measurement.internal.zzdt) r0     // Catch:{ SecurityException -> 0x005a }
            boolean r1 = com.google.android.gms.measurement.internal.zzab.zza()     // Catch:{ SecurityException -> 0x005a }
            if (r1 != 0) goto L_0x0052
            r1 = 0
            com.google.android.gms.measurement.internal.m r2 = r0.zzc     // Catch:{ IllegalStateException -> 0x0048 }
            if (r2 == 0) goto L_0x0048
            java.lang.Object r1 = r2.zza()     // Catch:{ IllegalStateException -> 0x0048 }
        L_0x0048:
            java.lang.Object r2 = zza     // Catch:{ SecurityException -> 0x005a }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x005a }
            r0.zzh = r1     // Catch:{ all -> 0x004f }
            monitor-exit(r2)     // Catch:{ all -> 0x004f }
            goto L_0x002d
        L_0x004f:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004f }
            throw r4     // Catch:{ SecurityException -> 0x005a }
        L_0x0052:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x005a }
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch:{ SecurityException -> 0x005a }
            throw r4     // Catch:{ SecurityException -> 0x005a }
        L_0x005a:
            com.google.android.gms.measurement.internal.m r4 = r3.zzc
            if (r4 != 0) goto L_0x0061
            java.lang.Object r4 = r3.zzd
            return r4
        L_0x0061:
            java.lang.Object r4 = r4.zza()     // Catch:{ SecurityException -> 0x0069, IllegalStateException -> 0x0066 }
            return r4
        L_0x0066:
            java.lang.Object r4 = r3.zzd
            return r4
        L_0x0069:
            java.lang.Object r4 = r3.zzd
            return r4
        L_0x006c:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            throw r0
        L_0x006e:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdt.zza(java.lang.Object):java.lang.Object");
    }

    public final String zzb() {
        return this.zzb;
    }
}
