package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public final class zzaz extends zzaw {
    protected zzaz() {
        this.zza.add(zzbl.APPLY);
        this.zza.add(zzbl.BLOCK);
        this.zza.add(zzbl.BREAK);
        this.zza.add(zzbl.CASE);
        this.zza.add(zzbl.DEFAULT);
        this.zza.add(zzbl.CONTINUE);
        this.zza.add(zzbl.DEFINE_FUNCTION);
        this.zza.add(zzbl.FN);
        this.zza.add(zzbl.IF);
        this.zza.add(zzbl.QUOTE);
        this.zza.add(zzbl.RETURN);
        this.zza.add(zzbl.SWITCH);
        this.zza.add(zzbl.TERNARY);
    }

    private static zzap zzc(zzg zzg, List list) {
        zzh.zzi(zzbl.FN.name(), 2, list);
        zzap zzb = zzg.zzb((zzap) list.get(0));
        zzap zzb2 = zzg.zzb((zzap) list.get(1));
        if (zzb2 instanceof zzae) {
            List zzm = ((zzae) zzb2).zzm();
            List arrayList = new ArrayList();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new zzao(zzb.zzi(), zzm, arrayList, zzg);
        }
        throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", new Object[]{zzb2.getClass().getCanonicalName()}));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0128, code lost:
        if (r8.equals("continue") == false) goto L_0x012c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzap zza(java.lang.String r8, com.google.android.gms.internal.measurement.zzg r9, java.util.List r10) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzbl r2 = com.google.android.gms.internal.measurement.zzbl.ADD
            com.google.android.gms.internal.measurement.zzbl r2 = com.google.android.gms.internal.measurement.zzh.zze(r8)
            int r2 = r2.ordinal()
            r3 = 3
            r4 = 2
            if (r2 == r4) goto L_0x0210
            r5 = 15
            if (r2 == r5) goto L_0x0204
            r5 = 25
            if (r2 == r5) goto L_0x01ff
            r5 = 41
            if (r2 == r5) goto L_0x01ad
            r5 = 54
            if (r2 == r5) goto L_0x01a7
            r5 = 57
            java.lang.String r6 = "return"
            if (r2 == r5) goto L_0x0184
            r5 = 19
            if (r2 == r5) goto L_0x0163
            r5 = 20
            if (r2 == r5) goto L_0x013f
            r5 = 60
            if (r2 == r5) goto L_0x008b
            r5 = 61
            if (r2 == r5) goto L_0x0058
            switch(r2) {
                case 11: goto L_0x004a;
                case 12: goto L_0x003e;
                case 13: goto L_0x0163;
                default: goto L_0x0039;
            }
        L_0x0039:
            com.google.android.gms.internal.measurement.zzap r8 = super.zzb(r8)
            return r8
        L_0x003e:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.BREAK
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r0, r10)
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzi
            return r8
        L_0x004a:
            com.google.android.gms.internal.measurement.zzg r8 = r9.zza()
            com.google.android.gms.internal.measurement.zzae r9 = new com.google.android.gms.internal.measurement.zzae
            r9.<init>(r10)
            com.google.android.gms.internal.measurement.zzap r8 = r8.zzc(r9)
            return r8
        L_0x0058:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.TERNARY
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r3, r10)
            java.lang.Object r8 = r10.get(r0)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.Boolean r8 = r8.zzg()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0080
            java.lang.Object r8 = r10.get(r1)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            goto L_0x008a
        L_0x0080:
            java.lang.Object r8 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
        L_0x008a:
            return r8
        L_0x008b:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.SWITCH
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r3, r10)
            java.lang.Object r8 = r10.get(r0)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.Object r2 = r10.get(r1)
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            com.google.android.gms.internal.measurement.zzap r2 = r9.zzb(r2)
            java.lang.Object r10 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r9.zzb(r10)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzae
            if (r3 == 0) goto L_0x0137
            boolean r3 = r10 instanceof com.google.android.gms.internal.measurement.zzae
            if (r3 == 0) goto L_0x012f
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            r3 = r0
            r4 = r3
        L_0x00c0:
            int r5 = r2.zzc()
            if (r3 >= r5) goto L_0x00fa
            if (r4 != 0) goto L_0x00d9
            com.google.android.gms.internal.measurement.zzap r4 = r2.zze(r3)
            com.google.android.gms.internal.measurement.zzap r4 = r9.zzb(r4)
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x00d7
            goto L_0x00d9
        L_0x00d7:
            r4 = r0
            goto L_0x00f8
        L_0x00d9:
            com.google.android.gms.internal.measurement.zzap r4 = r10.zze(r3)
            com.google.android.gms.internal.measurement.zzap r4 = r9.zzb(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzag
            if (r5 == 0) goto L_0x00f7
            r8 = r4
            com.google.android.gms.internal.measurement.zzag r8 = (com.google.android.gms.internal.measurement.zzag) r8
            java.lang.String r8 = r8.zzc()
            java.lang.String r9 = "break"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x012b
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzf
            return r8
        L_0x00f7:
            r4 = r1
        L_0x00f8:
            int r3 = r3 + r1
            goto L_0x00c0
        L_0x00fa:
            int r8 = r2.zzc()
            int r8 = r8 + r1
            int r0 = r10.zzc()
            if (r8 != r0) goto L_0x012c
            int r8 = r2.zzc()
            com.google.android.gms.internal.measurement.zzap r8 = r10.zze(r8)
            com.google.android.gms.internal.measurement.zzap r4 = r9.zzb(r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.measurement.zzag
            if (r8 == 0) goto L_0x012c
            r8 = r4
            com.google.android.gms.internal.measurement.zzag r8 = (com.google.android.gms.internal.measurement.zzag) r8
            java.lang.String r8 = r8.zzc()
            boolean r9 = r8.equals(r6)
            if (r9 != 0) goto L_0x012b
            java.lang.String r9 = "continue"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x012b
            goto L_0x012c
        L_0x012b:
            return r4
        L_0x012c:
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzf
            return r8
        L_0x012f:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Malformed SWITCH statement, case statements are not a list"
            r8.<init>(r9)
            throw r8
        L_0x0137:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Malformed SWITCH statement, cases are not a list"
            r8.<init>(r9)
            throw r8
        L_0x013f:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.DEFINE_FUNCTION
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzi(r8, r4, r10)
            com.google.android.gms.internal.measurement.zzap r8 = zzc(r9, r10)
            r10 = r8
            com.google.android.gms.internal.measurement.zzai r10 = (com.google.android.gms.internal.measurement.zzai) r10
            java.lang.String r0 = r10.zzc()
            if (r0 != 0) goto L_0x015b
            java.lang.String r10 = ""
            r9.zzg(r10, r8)
            goto L_0x0162
        L_0x015b:
            java.lang.String r10 = r10.zzc()
            r9.zzg(r10, r8)
        L_0x0162:
            return r8
        L_0x0163:
            boolean r8 = r10.isEmpty()
            if (r8 == 0) goto L_0x016c
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x0183
        L_0x016c:
            java.lang.Object r8 = r10.get(r0)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            boolean r10 = r8 instanceof com.google.android.gms.internal.measurement.zzae
            if (r10 == 0) goto L_0x0181
            com.google.android.gms.internal.measurement.zzae r8 = (com.google.android.gms.internal.measurement.zzae) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzc(r8)
            goto L_0x0183
        L_0x0181:
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzf
        L_0x0183:
            return r8
        L_0x0184:
            boolean r8 = r10.isEmpty()
            if (r8 == 0) goto L_0x018d
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzj
            goto L_0x01a6
        L_0x018d:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.RETURN
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r1, r10)
            java.lang.Object r8 = r10.get(r0)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            com.google.android.gms.internal.measurement.zzag r9 = new com.google.android.gms.internal.measurement.zzag
            r9.<init>(r6, r8)
            r8 = r9
        L_0x01a6:
            return r8
        L_0x01a7:
            com.google.android.gms.internal.measurement.zzae r8 = new com.google.android.gms.internal.measurement.zzae
            r8.<init>(r10)
            return r8
        L_0x01ad:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.IF
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzi(r8, r4, r10)
            java.lang.Object r8 = r10.get(r0)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.Object r0 = r10.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r9.zzb(r0)
            int r1 = r10.size()
            if (r1 <= r4) goto L_0x01db
            java.lang.Object r10 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r9.zzb(r10)
            goto L_0x01dc
        L_0x01db:
            r10 = 0
        L_0x01dc:
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzf
            java.lang.Boolean r8 = r8.zzg()
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x01ef
            com.google.android.gms.internal.measurement.zzae r0 = (com.google.android.gms.internal.measurement.zzae) r0
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzc(r0)
            goto L_0x01f9
        L_0x01ef:
            if (r10 == 0) goto L_0x01f8
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzc(r10)
            goto L_0x01f9
        L_0x01f8:
            r8 = r1
        L_0x01f9:
            boolean r9 = r8 instanceof com.google.android.gms.internal.measurement.zzag
            if (r9 == 0) goto L_0x01fe
            return r8
        L_0x01fe:
            return r1
        L_0x01ff:
            com.google.android.gms.internal.measurement.zzap r8 = zzc(r9, r10)
            return r8
        L_0x0204:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.BREAK
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r0, r10)
            com.google.android.gms.internal.measurement.zzap r8 = com.google.android.gms.internal.measurement.zzap.zzh
            return r8
        L_0x0210:
            com.google.android.gms.internal.measurement.zzbl r8 = com.google.android.gms.internal.measurement.zzbl.APPLY
            java.lang.String r8 = r8.name()
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r3, r10)
            java.lang.Object r8 = r10.get(r0)
            com.google.android.gms.internal.measurement.zzap r8 = (com.google.android.gms.internal.measurement.zzap) r8
            com.google.android.gms.internal.measurement.zzap r8 = r9.zzb(r8)
            java.lang.Object r2 = r10.get(r1)
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            com.google.android.gms.internal.measurement.zzap r2 = r9.zzb(r2)
            java.lang.String r2 = r2.zzi()
            java.lang.Object r10 = r10.get(r4)
            com.google.android.gms.internal.measurement.zzap r10 = (com.google.android.gms.internal.measurement.zzap) r10
            com.google.android.gms.internal.measurement.zzap r10 = r9.zzb(r10)
            boolean r3 = r10 instanceof com.google.android.gms.internal.measurement.zzae
            if (r3 == 0) goto L_0x0258
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x0250
            com.google.android.gms.internal.measurement.zzae r10 = (com.google.android.gms.internal.measurement.zzae) r10
            java.util.List r10 = r10.zzm()
            com.google.android.gms.internal.measurement.zzap r8 = r8.zzbR(r2, r9, r10)
            return r8
        L_0x0250:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Function name for apply is undefined"
            r8.<init>(r9)
            throw r8
        L_0x0258:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.Class r9 = r10.getClass()
            java.lang.String r9 = r9.getCanonicalName()
            java.lang.Object[] r10 = new java.lang.Object[r1]
            r10[r0] = r9
            java.lang.String r9 = "Function arguments for Apply are not a list found %s"
            java.lang.String r9 = java.lang.String.format(r9, r10)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaz.zza(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }
}
