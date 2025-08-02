package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;

public final class zzbb {
    /* JADX WARNING: type inference failed for: r0v119, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f8, code lost:
        r4 = r24.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01fc, code lost:
        r2 = r24.zzc();
        r6 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x020a, code lost:
        if (r26.size() <= 1) goto L_0x0272;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x020c, code lost:
        r1 = java.lang.Math.max(0, (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0228, code lost:
        if (r1 <= 0) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x022a, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0231, code lost:
        if (r7 >= java.lang.Math.min(r2, r4 + r1)) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0233, code lost:
        r6.zzq(r6.zzc(), r5.zze(r4));
        r5.zzp(r4);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0249, code lost:
        if (r26.size() <= 2) goto L_0x0285;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x024b, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0250, code lost:
        if (r7 >= r26.size()) goto L_0x0285;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0252, code lost:
        r1 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x025e, code lost:
        if ((r1 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0260, code lost:
        r5.zzo((r4 + r7) - 2, r1);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0271, code lost:
        throw new java.lang.IllegalArgumentException("Failed to parse elements to add");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0272, code lost:
        if (r4 >= r2) goto L_0x0285;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0274, code lost:
        r6.zzq(r6.zzc(), r5.zze(r4));
        r5.zzq(r4, (com.google.android.gms.internal.measurement.zzap) null);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0287, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzj("sort", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0296, code lost:
        if (r24.zzc() >= 2) goto L_0x0299;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0299, code lost:
        r2 = r24.zzm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02a1, code lost:
        if (r26.isEmpty() != false) goto L_0x02be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02a3, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02b0, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x02b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02b2, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02bd, code lost:
        throw new java.lang.IllegalArgumentException("Comparator should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02be, code lost:
        java.util.Collections.sort(r2, new com.google.android.gms.internal.measurement.g(r1, r3));
        r24.zzn();
        r0 = r2.iterator();
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02d2, code lost:
        if (r0.hasNext() == false) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02d4, code lost:
        r5.zzq(r7, (com.google.android.gms.internal.measurement.zzap) r0.next());
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02e2, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02e3, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh("some", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02fa, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0300, code lost:
        if (r24.zzc() != 0) goto L_0x0305;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0305, code lost:
        r0 = (com.google.android.gms.internal.measurement.zzai) r0;
        r1 = r24.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x030f, code lost:
        if (r1.hasNext() == false) goto L_0x0350;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0311, code lost:
        r2 = ((java.lang.Integer) r1.next()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x031f, code lost:
        if (r5.zzs(r2) == false) goto L_0x030b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x034b, code lost:
        if (r0.zza(r3, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{r5.zze(r2), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2)), r5})).zzg().booleanValue() == false) goto L_0x030b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0358, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0359, code lost:
        r5 = r24;
        r0 = r26;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzh.zzj("slice", 2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0368, code lost:
        if (r26.isEmpty() == false) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0370, code lost:
        r1 = (double) r24.zzc();
        r6 = com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0390, code lost:
        if (r6 >= 0.0d) goto L_0x0398;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0392, code lost:
        r6 = java.lang.Math.max(r6 + r1, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0398, code lost:
        r6 = java.lang.Math.min(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03a1, code lost:
        if (r26.size() != 2) goto L_0x03ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03a3, code lost:
        r3 = com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03be, code lost:
        if (r3 >= 0.0d) goto L_0x03c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03c0, code lost:
        r1 = java.lang.Math.max(r1 + r3, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03c6, code lost:
        r1 = java.lang.Math.min(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03ca, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r3 = (int) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03d3, code lost:
        if (((double) r3) >= r1) goto L_0x03e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03d5, code lost:
        r0.zzq(r0.zzc(), r5.zze(r3));
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03e4, code lost:
        r5 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("shift", 0, r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03f0, code lost:
        if (r24.zzc() != 0) goto L_0x03f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03f5, code lost:
        r0 = r5.zze(0);
        r5.zzp(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03fd, code lost:
        r5 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh(r21, 0, r26);
        r0 = r24.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x040b, code lost:
        if (r0 == 0) goto L_0x0437;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x040d, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0411, code lost:
        if (r7 >= (r0 / 2)) goto L_0x0437;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0417, code lost:
        if (r5.zzs(r7) == false) goto L_0x0433;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0419, code lost:
        r2 = r5.zze(r7);
        r5.zzq(r7, (com.google.android.gms.internal.measurement.zzap) null);
        r3 = (r0 - 1) - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0427, code lost:
        if (r5.zzs(r3) == false) goto L_0x0430;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0429, code lost:
        r5.zzq(r7, r5.zze(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0430, code lost:
        r5.zzq(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0433, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0437, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0443, code lost:
        return zzc(r24, r25, r26, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x044f, code lost:
        return zzc(r24, r25, r26, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0450, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x045a, code lost:
        if (r26.isEmpty() != false) goto L_0x0478;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x045c, code lost:
        r0 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0464, code lost:
        if (r0.hasNext() == false) goto L_0x0478;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0466, code lost:
        r5.zzq(r24.zzc(), r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0486, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r24.zzc()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0487, code lost:
        r5 = r24;
        com.google.android.gms.internal.measurement.zzh.zzh("pop", 0, r26);
        r0 = r24.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0493, code lost:
        if (r0 != 0) goto L_0x0498;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0498, code lost:
        r0 = r0 - 1;
        r1 = r5.zze(r0);
        r5.zzp(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04a3, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh("map", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04ba, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x04cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04c0, code lost:
        if (r24.zzc() != 0) goto L_0x04c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x04d4, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x04d5, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzj("lastIndexOf", 2, r0);
        r1 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04e5, code lost:
        if (r26.isEmpty() != false) goto L_0x04f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04e7, code lost:
        r1 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04f2, code lost:
        r6 = (double) (r24.zzc() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x04fe, code lost:
        if (r26.size() <= 1) goto L_0x053b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0500, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0516, code lost:
        if (java.lang.Double.isNaN(r0.zzh().doubleValue()) == false) goto L_0x0523;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0518, code lost:
        r2 = (double) (r24.zzc() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x051f, code lost:
        r6 = r2;
        r2 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0523, code lost:
        r2 = com.google.android.gms.internal.measurement.zzh.zza(r0.zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0532, code lost:
        if (r6 >= 0.0d) goto L_0x053d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0534, code lost:
        r6 = r6 + ((double) r24.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x053b, code lost:
        r2 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x053f, code lost:
        if (r6 >= r2) goto L_0x054b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x054b, code lost:
        r0 = (int) java.lang.Math.min((double) r24.zzc(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0555, code lost:
        if (r0 < 0) goto L_0x0576;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x055b, code lost:
        if (r5.zzs(r0) == false) goto L_0x0573;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0565, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzl(r5.zze(r0), r1) == false) goto L_0x0573;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0573, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0580, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        r1 = r16;
        com.google.android.gms.internal.measurement.zzh.zzj("join", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0590, code lost:
        if (r24.zzc() != 0) goto L_0x0595;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0599, code lost:
        if (r26.isEmpty() != false) goto L_0x05b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x059b, code lost:
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x05a8, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) != false) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x05ac, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzau) == false) goto L_0x05af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x05af, code lost:
        r4 = r0.zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x05b4, code lost:
        r4 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x05b7, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05c2, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzj(r22, 2, r0);
        r1 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x05d4, code lost:
        if (r26.isEmpty() != false) goto L_0x05e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x05d6, code lost:
        r1 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x05e6, code lost:
        if (r26.size() <= 1) goto L_0x061e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x05e8, code lost:
        r2 = com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0605, code lost:
        if (r2 < ((double) r24.zzc())) goto L_0x0611;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0615, code lost:
        if (r2 >= 0.0d) goto L_0x0621;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0617, code lost:
        r2 = r2 + ((double) r24.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x061e, code lost:
        r2 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0621, code lost:
        r0 = r24.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0629, code lost:
        if (r0.hasNext() == false) goto L_0x064e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x062b, code lost:
        r4 = ((java.lang.Integer) r0.next()).intValue();
        r6 = (double) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0638, code lost:
        if (r6 < r2) goto L_0x0625;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0642, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzl(r5.zze(r4), r1) == false) goto L_0x0625;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0658, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh("forEach", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x066f, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x0682;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0675, code lost:
        if (r24.zzb() != 0) goto L_0x067a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x067a, code lost:
        zzb(r5, r3, (com.google.android.gms.internal.measurement.zzao) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0687, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0688, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh("filter", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x069f, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x06e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x06a5, code lost:
        if (r24.zzb() != 0) goto L_0x06ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x06ad, code lost:
        r2 = r24.zzd();
        r0 = zzb(r5, r3, (com.google.android.gms.internal.measurement.zzao) r0, (java.lang.Boolean) null, java.lang.Boolean.TRUE);
        r1 = new com.google.android.gms.internal.measurement.zzae();
        r0 = r0.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x06c6, code lost:
        if (r0.hasNext() == false) goto L_0x06e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x06c8, code lost:
        r1.zzq(r1.zzc(), ((com.google.android.gms.internal.measurement.zzae) r2).zze(((java.lang.Integer) r0.next()).intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x06e8, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x06e9, code lost:
        r1 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzh("every", 1, r0);
        r0 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0700, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzao) == false) goto L_0x0725;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0706, code lost:
        if (r24.zzc() != 0) goto L_0x070b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x071d, code lost:
        if (zzb(r1, r3, (com.google.android.gms.internal.measurement.zzao) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).zzc() == r24.zzc()) goto L_0x0722;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0033, code lost:
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x072a, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x072b, code lost:
        r1 = r24;
        r3 = r25;
        r0 = r26;
        r1 = r24.zzd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0739, code lost:
        if (r26.isEmpty() != false) goto L_0x078d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x073b, code lost:
        r0 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0743, code lost:
        if (r0.hasNext() == false) goto L_0x078d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0745, code lost:
        r2 = r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0751, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0785;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0753, code lost:
        r4 = (com.google.android.gms.internal.measurement.zzae) r1;
        r5 = r4.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x075c, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzae) == false) goto L_0x0781;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x075e, code lost:
        r2 = (com.google.android.gms.internal.measurement.zzae) r2;
        r6 = r2.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0768, code lost:
        if (r6.hasNext() == false) goto L_0x073f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x076a, code lost:
        r7 = (java.lang.Integer) r6.next();
        r4.zzq(r7.intValue() + r5, r2.zze(r7.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x0781, code lost:
        r4.zzq(r5, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x078c, code lost:
        throw new java.lang.IllegalStateException("Failed evaluation of arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x078d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:?, code lost:
        return r24.zzd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:?, code lost:
        return zzb(r5, r3, (com.google.android.gms.internal.measurement.zzao) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r5.zzj(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ff, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0101, code lost:
        r21 = "reverse";
        r22 = "indexOf";
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010a, code lost:
        switch(r0) {
            case 0: goto L_0x072b;
            case 1: goto L_0x06e9;
            case 2: goto L_0x0688;
            case 3: goto L_0x0658;
            case 4: goto L_0x05c2;
            case 5: goto L_0x0580;
            case 6: goto L_0x04d5;
            case 7: goto L_0x04a3;
            case 8: goto L_0x0487;
            case 9: goto L_0x0450;
            case 10: goto L_0x0444;
            case 11: goto L_0x0438;
            case 12: goto L_0x03fd;
            case 13: goto L_0x03e4;
            case 14: goto L_0x0359;
            case 15: goto L_0x02e3;
            case 16: goto L_0x0287;
            case 17: goto L_0x01bb;
            case 18: goto L_0x01a7;
            case 19: goto L_0x0115;
            default: goto L_0x010d;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0114, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003e, code lost:
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0119, code lost:
        if (r26.isEmpty() != false) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011b, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r1 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0128, code lost:
        if (r1.hasNext() == false) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012a, code lost:
        r2 = r25.zzb((com.google.android.gms.internal.measurement.zzap) r1.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0138, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x013a, code lost:
        r0.zzq(r0.zzc(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0149, code lost:
        throw new java.lang.IllegalStateException("Argument evaluation failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014a, code lost:
        r1 = r0.zzc();
        r2 = r24.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0156, code lost:
        if (r2.hasNext() == false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0158, code lost:
        r3 = (java.lang.Integer) r2.next();
        r0.zzq(r3.intValue() + r1, r24.zze(r3.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0171, code lost:
        r5 = r24;
        r24.zzn();
        r1 = r0.zzk();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x017e, code lost:
        if (r1.hasNext() == false) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0180, code lost:
        r2 = (java.lang.Integer) r1.next();
        r5.zzq(r2.intValue(), r0.zze(r2.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0196, code lost:
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a6, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r24.zzc()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a7, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh(r6, 0, r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ba, code lost:
        return new com.google.android.gms.internal.measurement.zzat(r24.zzj(r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01bb, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01c6, code lost:
        if (r26.isEmpty() == false) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01cf, code lost:
        r4 = (int) com.google.android.gms.internal.measurement.zzh.zza(r3.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e6, code lost:
        if (r4 >= 0) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e8, code lost:
        r4 = java.lang.Math.max(0, r4 + r24.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f6, code lost:
        if (r4 <= r24.zzc()) goto L_0x01fc;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzap zza(java.lang.String r23, com.google.android.gms.internal.measurement.zzae r24, com.google.android.gms.internal.measurement.zzg r25, java.util.List r26) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            java.lang.String r4 = ","
            int r6 = r23.hashCode()
            java.lang.String r7 = "toString"
            java.lang.String r8 = "filter"
            java.lang.String r9 = "forEach"
            java.lang.String r10 = "lastIndexOf"
            java.lang.String r11 = "map"
            java.lang.String r12 = "pop"
            java.lang.String r13 = "join"
            java.lang.String r14 = "some"
            java.lang.String r15 = "sort"
            java.lang.String r5 = "every"
            r16 = r4
            java.lang.String r4 = "shift"
            java.lang.String r3 = "slice"
            java.lang.String r1 = "reverse"
            java.lang.String r2 = "indexOf"
            r17 = -1
            r18 = r7
            switch(r6) {
                case -1776922004: goto L_0x00f4;
                case -1354795244: goto L_0x00e8;
                case -1274492040: goto L_0x00de;
                case -934873754: goto L_0x00d2;
                case -895859076: goto L_0x00c6;
                case -678635926: goto L_0x00bc;
                case -467511597: goto L_0x00b4;
                case -277637751: goto L_0x00a9;
                case 107868: goto L_0x00a1;
                case 111185: goto L_0x0098;
                case 3267882: goto L_0x0090;
                case 3452698: goto L_0x0085;
                case 3536116: goto L_0x007c;
                case 3536286: goto L_0x0073;
                case 96891675: goto L_0x0068;
                case 109407362: goto L_0x005f;
                case 109526418: goto L_0x0056;
                case 965561430: goto L_0x004b;
                case 1099846370: goto L_0x0042;
                case 1943291465: goto L_0x0037;
                default: goto L_0x0033;
            }
        L_0x0033:
            r6 = r18
            goto L_0x00ff
        L_0x0037:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0033
            r0 = 4
        L_0x003e:
            r6 = r18
            goto L_0x0101
        L_0x0042:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0033
            r0 = 12
            goto L_0x003e
        L_0x004b:
            java.lang.String r6 = "reduceRight"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 11
            goto L_0x003e
        L_0x0056:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 14
            goto L_0x003e
        L_0x005f:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0033
            r0 = 13
            goto L_0x003e
        L_0x0068:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 1
            goto L_0x0101
        L_0x0073:
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0033
            r0 = 16
            goto L_0x003e
        L_0x007c:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0033
            r0 = 15
            goto L_0x003e
        L_0x0085:
            java.lang.String r6 = "push"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 9
            goto L_0x003e
        L_0x0090:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0033
            r0 = 5
            goto L_0x003e
        L_0x0098:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0033
            r0 = 8
            goto L_0x003e
        L_0x00a1:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0033
            r0 = 7
            goto L_0x003e
        L_0x00a9:
            java.lang.String r6 = "unshift"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 19
            goto L_0x003e
        L_0x00b4:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0033
            r0 = 6
            goto L_0x003e
        L_0x00bc:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 3
            goto L_0x0101
        L_0x00c6:
            java.lang.String r6 = "splice"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 17
            goto L_0x003e
        L_0x00d2:
            java.lang.String r6 = "reduce"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 10
            goto L_0x003e
        L_0x00de:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 2
            goto L_0x0101
        L_0x00e8:
            java.lang.String r6 = "concat"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 0
            goto L_0x0101
        L_0x00f4:
            r6 = r18
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00ff
            r0 = 18
            goto L_0x0101
        L_0x00ff:
            r0 = r17
        L_0x0101:
            r19 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.String r7 = "Callback should be a method"
            r21 = r1
            r22 = r2
            r1 = 0
            switch(r0) {
                case 0: goto L_0x072b;
                case 1: goto L_0x06e9;
                case 2: goto L_0x0688;
                case 3: goto L_0x0658;
                case 4: goto L_0x05c2;
                case 5: goto L_0x0580;
                case 6: goto L_0x04d5;
                case 7: goto L_0x04a3;
                case 8: goto L_0x0487;
                case 9: goto L_0x0450;
                case 10: goto L_0x0444;
                case 11: goto L_0x0438;
                case 12: goto L_0x03fd;
                case 13: goto L_0x03e4;
                case 14: goto L_0x0359;
                case 15: goto L_0x02e3;
                case 16: goto L_0x0287;
                case 17: goto L_0x01bb;
                case 18: goto L_0x01a7;
                case 19: goto L_0x0115;
                default: goto L_0x010d;
            }
        L_0x010d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0115:
            boolean r0 = r26.isEmpty()
            if (r0 != 0) goto L_0x0196
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            java.util.Iterator r1 = r26.iterator()
        L_0x0124:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x014a
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            r3 = r25
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x0142
            int r4 = r0.zzc()
            r0.zzq(r4, r2)
            goto L_0x0124
        L_0x0142:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x014a:
            int r1 = r0.zzc()
            java.util.Iterator r2 = r24.zzk()
        L_0x0152:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0171
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            r5 = r24
            com.google.android.gms.internal.measurement.zzap r3 = r5.zze(r3)
            r0.zzq(r4, r3)
            goto L_0x0152
        L_0x0171:
            r5 = r24
            r24.zzn()
            java.util.Iterator r1 = r0.zzk()
        L_0x017a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0198
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.zzap r2 = r0.zze(r2)
            r5.zzq(r3, r2)
            goto L_0x017a
        L_0x0196:
            r5 = r24
        L_0x0198:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r24.zzc()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x01a7:
            r5 = r24
            r0 = r26
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r6, r2, r0)
            com.google.android.gms.internal.measurement.zzat r0 = new com.google.android.gms.internal.measurement.zzat
            r1 = r16
            java.lang.String r1 = r5.zzj(r1)
            r0.<init>(r1)
            return r0
        L_0x01bb:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 0
            boolean r4 = r26.isEmpty()
            if (r4 == 0) goto L_0x01cf
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x0286
        L_0x01cf:
            java.lang.Object r4 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
            java.lang.Double r4 = r4.zzh()
            double r6 = r4.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzh.zza(r6)
            int r4 = (int) r6
            if (r4 >= 0) goto L_0x01f2
            int r6 = r24.zzc()
            int r4 = r4 + r6
            int r4 = java.lang.Math.max(r2, r4)
            goto L_0x01fc
        L_0x01f2:
            int r2 = r24.zzc()
            if (r4 <= r2) goto L_0x01fc
            int r4 = r24.zzc()
        L_0x01fc:
            int r2 = r24.zzc()
            com.google.android.gms.internal.measurement.zzae r6 = new com.google.android.gms.internal.measurement.zzae
            r6.<init>()
            int r7 = r26.size()
            r8 = 1
            if (r7 <= r8) goto L_0x0272
            java.lang.Object r1 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            java.lang.Double r1 = r1.zzh()
            double r7 = r1.doubleValue()
            double r7 = com.google.android.gms.internal.measurement.zzh.zza(r7)
            int r1 = (int) r7
            r7 = 0
            int r1 = java.lang.Math.max(r7, r1)
            if (r1 <= 0) goto L_0x0244
            r7 = r4
        L_0x022b:
            int r8 = r4 + r1
            int r8 = java.lang.Math.min(r2, r8)
            if (r7 >= r8) goto L_0x0244
            com.google.android.gms.internal.measurement.zzap r8 = r5.zze(r4)
            int r9 = r6.zzc()
            r6.zzq(r9, r8)
            r5.zzp(r4)
            r8 = 1
            int r7 = r7 + r8
            goto L_0x022b
        L_0x0244:
            int r1 = r26.size()
            r2 = 2
            if (r1 <= r2) goto L_0x0285
            r7 = 2
        L_0x024c:
            int r1 = r26.size()
            if (r7 >= r1) goto L_0x0285
            java.lang.Object r1 = r0.get(r7)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r2 != 0) goto L_0x026a
            int r2 = r4 + r7
            int r2 = r2 + -2
            r5.zzo(r2, r1)
            r1 = 1
            int r7 = r7 + r1
            goto L_0x024c
        L_0x026a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x0272:
            if (r4 >= r2) goto L_0x0285
            com.google.android.gms.internal.measurement.zzap r0 = r5.zze(r4)
            int r3 = r6.zzc()
            r6.zzq(r3, r0)
            r5.zzq(r4, r1)
            r7 = 1
            int r4 = r4 + r7
            goto L_0x0272
        L_0x0285:
            r0 = r6
        L_0x0286:
            return r0
        L_0x0287:
            r5 = r24
            r3 = r25
            r0 = r26
            r7 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r15, r7, r0)
            int r2 = r24.zzc()
            r4 = 2
            if (r2 >= r4) goto L_0x0299
            goto L_0x02e2
        L_0x0299:
            java.util.List r2 = r24.zzm()
            boolean r4 = r26.isEmpty()
            if (r4 != 0) goto L_0x02be
            r4 = 0
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r1 == 0) goto L_0x02b6
            r1 = r0
            com.google.android.gms.internal.measurement.zzai r1 = (com.google.android.gms.internal.measurement.zzai) r1
            goto L_0x02be
        L_0x02b6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x02be:
            com.google.android.gms.internal.measurement.g r0 = new com.google.android.gms.internal.measurement.g
            r0.<init>(r1, r3)
            java.util.Collections.sort(r2, r0)
            r24.zzn()
            java.util.Iterator r0 = r2.iterator()
            r7 = 0
        L_0x02ce:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02e2
            r1 = 1
            int r2 = r7 + 1
            java.lang.Object r3 = r0.next()
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            r5.zzq(r7, r3)
            r7 = r2
            goto L_0x02ce
        L_0x02e2:
            return r5
        L_0x02e3:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r1, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r1 == 0) goto L_0x0353
            int r1 = r24.zzc()
            if (r1 != 0) goto L_0x0305
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x0352
        L_0x0305:
            com.google.android.gms.internal.measurement.zzai r0 = (com.google.android.gms.internal.measurement.zzai) r0
            java.util.Iterator r1 = r24.zzk()
        L_0x030b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0350
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            boolean r4 = r5.zzs(r2)
            if (r4 == 0) goto L_0x030b
            com.google.android.gms.internal.measurement.zzap r4 = r5.zze(r2)
            com.google.android.gms.internal.measurement.zzah r6 = new com.google.android.gms.internal.measurement.zzah
            double r7 = (double) r2
            java.lang.Double r2 = java.lang.Double.valueOf(r7)
            r6.<init>(r2)
            r2 = 3
            com.google.android.gms.internal.measurement.zzap[] r7 = new com.google.android.gms.internal.measurement.zzap[r2]
            r8 = 0
            r7[r8] = r4
            r4 = 1
            r7[r4] = r6
            r4 = 2
            r7[r4] = r5
            java.util.List r4 = java.util.Arrays.asList(r7)
            com.google.android.gms.internal.measurement.zzap r4 = r0.zza(r3, r4)
            java.lang.Boolean r4 = r4.zzg()
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x030b
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x0352
        L_0x0350:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
        L_0x0352:
            return r0
        L_0x0353:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x0359:
            r5 = r24
            r0 = r26
            r1 = r3
            r2 = 2
            r3 = r25
            com.google.android.gms.internal.measurement.zzh.zzj(r1, r2, r0)
            boolean r1 = r26.isEmpty()
            if (r1 == 0) goto L_0x0370
            com.google.android.gms.internal.measurement.zzap r0 = r24.zzd()
            goto L_0x03e3
        L_0x0370:
            int r1 = r24.zzc()
            double r1 = (double) r1
            r4 = 0
            java.lang.Object r4 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r3.zzb(r4)
            java.lang.Double r4 = r4.zzh()
            double r6 = r4.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzh.zza(r6)
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0398
            double r6 = r6 + r1
            double r6 = java.lang.Math.max(r6, r8)
            goto L_0x039c
        L_0x0398:
            double r6 = java.lang.Math.min(r6, r1)
        L_0x039c:
            int r4 = r26.size()
            r8 = 2
            if (r4 != r8) goto L_0x03ca
            r4 = 1
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r3 = r0.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            r8 = 0
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x03c6
            double r1 = r1 + r3
            double r1 = java.lang.Math.max(r1, r8)
            goto L_0x03ca
        L_0x03c6:
            double r1 = java.lang.Math.min(r1, r3)
        L_0x03ca:
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            int r3 = (int) r6
        L_0x03d0:
            double r6 = (double) r3
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x03e3
            com.google.android.gms.internal.measurement.zzap r4 = r5.zze(r3)
            int r6 = r0.zzc()
            r0.zzq(r6, r4)
            r4 = 1
            int r3 = r3 + r4
            goto L_0x03d0
        L_0x03e3:
            return r0
        L_0x03e4:
            r5 = r24
            r0 = r26
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r4, r2, r0)
            int r0 = r24.zzc()
            if (r0 != 0) goto L_0x03f5
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x03fc
        L_0x03f5:
            com.google.android.gms.internal.measurement.zzap r0 = r5.zze(r2)
            r5.zzp(r2)
        L_0x03fc:
            return r0
        L_0x03fd:
            r5 = r24
            r0 = r26
            r3 = r21
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r3, r2, r0)
            int r0 = r24.zzc()
            if (r0 == 0) goto L_0x0437
            r2 = 2
            r7 = 0
        L_0x040f:
            int r3 = r0 / 2
            if (r7 >= r3) goto L_0x0437
            boolean r2 = r5.zzs(r7)
            if (r2 == 0) goto L_0x0433
            com.google.android.gms.internal.measurement.zzap r2 = r5.zze(r7)
            r5.zzq(r7, r1)
            int r3 = r0 + -1
            int r3 = r3 - r7
            boolean r4 = r5.zzs(r3)
            if (r4 == 0) goto L_0x0430
            com.google.android.gms.internal.measurement.zzap r4 = r5.zze(r3)
            r5.zzq(r7, r4)
        L_0x0430:
            r5.zzq(r3, r2)
        L_0x0433:
            r2 = 1
            int r7 = r7 + r2
            r2 = 2
            goto L_0x040f
        L_0x0437:
            return r5
        L_0x0438:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = 0
            com.google.android.gms.internal.measurement.zzap r0 = zzc(r5, r3, r0, r1)
            return r0
        L_0x0444:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzap r0 = zzc(r5, r3, r0, r2)
            return r0
        L_0x0450:
            r5 = r24
            r3 = r25
            r0 = r26
            boolean r1 = r26.isEmpty()
            if (r1 != 0) goto L_0x0478
            java.util.Iterator r0 = r26.iterator()
        L_0x0460:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0478
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
            int r2 = r24.zzc()
            r5.zzq(r2, r1)
            goto L_0x0460
        L_0x0478:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r24.zzc()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x0487:
            r5 = r24
            r0 = r26
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r12, r2, r0)
            int r0 = r24.zzc()
            if (r0 != 0) goto L_0x0498
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x04a2
        L_0x0498:
            int r0 = r0 + -1
            com.google.android.gms.internal.measurement.zzap r1 = r5.zze(r0)
            r5.zzp(r0)
            r0 = r1
        L_0x04a2:
            return r0
        L_0x04a3:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 0
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r11, r4, r0)
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x04cf
            int r2 = r24.zzc()
            if (r2 != 0) goto L_0x04c8
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x04ce
        L_0x04c8:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r5, r3, r0, r1, r1)
        L_0x04ce:
            return r0
        L_0x04cf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x04d5:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r10, r1, r0)
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x04f2
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
        L_0x04f2:
            int r2 = r24.zzc()
            int r2 = r2 + -1
            double r6 = (double) r2
            int r2 = r26.size()
            r4 = 1
            if (r2 <= r4) goto L_0x053b
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.Double r2 = r0.zzh()
            double r2 = r2.doubleValue()
            boolean r2 = java.lang.Double.isNaN(r2)
            if (r2 == 0) goto L_0x0523
            int r0 = r24.zzc()
            int r0 = r0 + -1
            double r2 = (double) r0
        L_0x051f:
            r6 = r2
            r2 = 0
            goto L_0x0530
        L_0x0523:
            java.lang.Double r0 = r0.zzh()
            double r2 = r0.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzh.zza(r2)
            goto L_0x051f
        L_0x0530:
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x053d
            int r0 = r24.zzc()
            double r8 = (double) r0
            double r6 = r6 + r8
            goto L_0x053d
        L_0x053b:
            r2 = 0
        L_0x053d:
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x054b
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x057f
        L_0x054b:
            int r0 = r24.zzc()
            double r2 = (double) r0
            double r2 = java.lang.Math.min(r2, r6)
            int r0 = (int) r2
        L_0x0555:
            if (r0 < 0) goto L_0x0576
            boolean r2 = r5.zzs(r0)
            if (r2 == 0) goto L_0x0573
            com.google.android.gms.internal.measurement.zzap r2 = r5.zze(r0)
            boolean r2 = com.google.android.gms.internal.measurement.zzh.zzl(r2, r1)
            if (r2 == 0) goto L_0x0573
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            r0 = r1
            goto L_0x057f
        L_0x0573:
            int r0 = r0 + -1
            goto L_0x0555
        L_0x0576:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
        L_0x057f:
            return r0
        L_0x0580:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = r16
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r13, r2, r0)
            int r2 = r24.zzc()
            if (r2 != 0) goto L_0x0595
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzm
            goto L_0x05c1
        L_0x0595:
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x05b7
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r1 != 0) goto L_0x05b4
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzau
            if (r1 == 0) goto L_0x05af
            goto L_0x05b4
        L_0x05af:
            java.lang.String r4 = r0.zzi()
            goto L_0x05b8
        L_0x05b4:
            java.lang.String r4 = ""
            goto L_0x05b8
        L_0x05b7:
            r4 = r1
        L_0x05b8:
            com.google.android.gms.internal.measurement.zzat r0 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r5.zzj(r4)
            r0.<init>(r1)
        L_0x05c1:
            return r0
        L_0x05c2:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = r22
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r1, r2, r0)
            com.google.android.gms.internal.measurement.zzap r1 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x05e1
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r1 = (com.google.android.gms.internal.measurement.zzap) r1
            com.google.android.gms.internal.measurement.zzap r1 = r3.zzb(r1)
        L_0x05e1:
            int r2 = r26.size()
            r4 = 1
            if (r2 <= r4) goto L_0x061e
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r2 = r0.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzh.zza(r2)
            int r0 = r24.zzc()
            double r6 = (double) r0
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0611
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x0657
        L_0x0611:
            r6 = 0
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0621
            int r0 = r24.zzc()
            double r6 = (double) r0
            double r2 = r2 + r6
            goto L_0x0621
        L_0x061e:
            r6 = 0
            r2 = r6
        L_0x0621:
            java.util.Iterator r0 = r24.zzk()
        L_0x0625:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x064e
            java.lang.Object r4 = r0.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            double r6 = (double) r4
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x0625
            com.google.android.gms.internal.measurement.zzap r4 = r5.zze(r4)
            boolean r4 = com.google.android.gms.internal.measurement.zzh.zzl(r4, r1)
            if (r4 == 0) goto L_0x0625
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r6)
            r0.<init>(r1)
            goto L_0x0657
        L_0x064e:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
        L_0x0657:
            return r0
        L_0x0658:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r9, r2, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x0682
            int r2 = r24.zzb()
            if (r2 != 0) goto L_0x067a
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
            goto L_0x0681
        L_0x067a:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            zzb(r5, r3, r0, r1, r1)
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzf
        L_0x0681:
            return r0
        L_0x0682:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x0688:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r8, r2, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x06e3
            int r2 = r24.zzb()
            if (r2 != 0) goto L_0x06ad
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x06e2
        L_0x06ad:
            com.google.android.gms.internal.measurement.zzap r2 = r24.zzd()
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r5, r3, r0, r1, r4)
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r1.<init>()
            java.util.Iterator r0 = r0.zzk()
        L_0x06c2:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x06e1
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = r2
            com.google.android.gms.internal.measurement.zzae r4 = (com.google.android.gms.internal.measurement.zzae) r4
            com.google.android.gms.internal.measurement.zzap r3 = r4.zze(r3)
            int r4 = r1.zzc()
            r1.zzq(r4, r3)
            goto L_0x06c2
        L_0x06e1:
            r0 = r1
        L_0x06e2:
            return r0
        L_0x06e3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x06e9:
            r1 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r5, r2, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r3.zzb(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r2 == 0) goto L_0x0725
            int r2 = r24.zzc()
            if (r2 != 0) goto L_0x070b
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x0724
        L_0x070b:
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.zzae r0 = zzb(r1, r3, r0, r2, r4)
            int r0 = r0.zzc()
            int r1 = r24.zzc()
            if (r0 == r1) goto L_0x0722
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x0724
        L_0x0722:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
        L_0x0724:
            return r0
        L_0x0725:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x072b:
            r1 = r24
            r3 = r25
            r0 = r26
            com.google.android.gms.internal.measurement.zzap r1 = r24.zzd()
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x078d
            java.util.Iterator r0 = r26.iterator()
        L_0x073f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x078d
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.zzap r2 = (com.google.android.gms.internal.measurement.zzap) r2
            com.google.android.gms.internal.measurement.zzap r2 = r3.zzb(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x0785
            r4 = r1
            com.google.android.gms.internal.measurement.zzae r4 = (com.google.android.gms.internal.measurement.zzae) r4
            int r5 = r4.zzc()
            boolean r6 = r2 instanceof com.google.android.gms.internal.measurement.zzae
            if (r6 == 0) goto L_0x0781
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            java.util.Iterator r6 = r2.zzk()
        L_0x0764:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x073f
            java.lang.Object r7 = r6.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r8 = r7.intValue()
            int r7 = r7.intValue()
            com.google.android.gms.internal.measurement.zzap r7 = r2.zze(r7)
            int r8 = r8 + r5
            r4.zzq(r8, r7)
            goto L_0x0764
        L_0x0781:
            r4.zzq(r5, r2)
            goto L_0x073f
        L_0x0785:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x078d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbb.zza(java.lang.String, com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    private static zzae zzb(zzae zzae, zzg zzg, zzai zzai, Boolean bool, Boolean bool2) {
        zzae zzae2 = new zzae();
        Iterator zzk = zzae.zzk();
        while (zzk.hasNext()) {
            int intValue = ((Integer) zzk.next()).intValue();
            if (zzae.zzs(intValue)) {
                zzap zza = zzai.zza(zzg, Arrays.asList(new zzap[]{zzae.zze(intValue), new zzah(Double.valueOf((double) intValue)), zzae}));
                if (zza.zzg().equals(bool)) {
                    return zzae2;
                }
                if (bool2 == null || zza.zzg().equals(bool2)) {
                    zzae2.zzq(intValue, zza);
                }
            }
        }
        return zzae2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.zzap zzc(com.google.android.gms.internal.measurement.zzae r10, com.google.android.gms.internal.measurement.zzg r11, java.util.List r12, boolean r13) {
        /*
            r0 = -1
            java.lang.String r1 = "reduce"
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzi(r1, r2, r12)
            r3 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r1, r3, r12)
            r1 = 0
            java.lang.Object r4 = r12.get(r1)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r4 = r11.zzb(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzai
            if (r5 == 0) goto L_0x009f
            int r5 = r12.size()
            if (r5 != r3) goto L_0x0037
            java.lang.Object r12 = r12.get(r2)
            com.google.android.gms.internal.measurement.zzap r12 = (com.google.android.gms.internal.measurement.zzap) r12
            com.google.android.gms.internal.measurement.zzap r12 = r11.zzb(r12)
            boolean r5 = r12 instanceof com.google.android.gms.internal.measurement.zzag
            if (r5 != 0) goto L_0x002f
            goto L_0x003e
        L_0x002f:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Failed to parse initial value"
            r10.<init>(r11)
            throw r10
        L_0x0037:
            int r12 = r10.zzc()
            if (r12 == 0) goto L_0x0097
            r12 = 0
        L_0x003e:
            com.google.android.gms.internal.measurement.zzai r4 = (com.google.android.gms.internal.measurement.zzai) r4
            int r5 = r10.zzc()
            if (r13 == 0) goto L_0x0048
            r6 = r1
            goto L_0x004a
        L_0x0048:
            int r6 = r5 + -1
        L_0x004a:
            if (r13 == 0) goto L_0x004e
            int r5 = r5 + r0
            goto L_0x004f
        L_0x004e:
            r5 = r1
        L_0x004f:
            if (r2 == r13) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r0 = r2
        L_0x0053:
            if (r12 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzap r12 = r10.zze(r6)
            goto L_0x0094
        L_0x005a:
            int r13 = r5 - r6
            int r13 = r13 * r0
            if (r13 < 0) goto L_0x0096
            boolean r13 = r10.zzs(r6)
            if (r13 == 0) goto L_0x0094
            com.google.android.gms.internal.measurement.zzap r13 = r10.zze(r6)
            com.google.android.gms.internal.measurement.zzah r7 = new com.google.android.gms.internal.measurement.zzah
            double r8 = (double) r6
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r7.<init>(r8)
            r8 = 4
            com.google.android.gms.internal.measurement.zzap[] r8 = new com.google.android.gms.internal.measurement.zzap[r8]
            r8[r1] = r12
            r8[r2] = r13
            r8[r3] = r7
            r12 = 3
            r8[r12] = r10
            java.util.List r12 = java.util.Arrays.asList(r8)
            com.google.android.gms.internal.measurement.zzap r12 = r4.zza(r11, r12)
            boolean r13 = r12 instanceof com.google.android.gms.internal.measurement.zzag
            if (r13 != 0) goto L_0x008c
            goto L_0x0094
        L_0x008c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Reduce operation failed"
            r10.<init>(r11)
            throw r10
        L_0x0094:
            int r6 = r6 + r0
            goto L_0x005a
        L_0x0096:
            return r12
        L_0x0097:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Empty array with no initial value error"
            r10.<init>(r11)
            throw r10
        L_0x009f:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Callback should be a method"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbb.zzc(com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List, boolean):com.google.android.gms.internal.measurement.zzap");
    }
}
