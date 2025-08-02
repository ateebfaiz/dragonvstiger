package com.google.android.gms.internal.measurement;

import java.util.Iterator;

public final class zzat implements Iterable, zzap {
    /* access modifiers changed from: private */
    public final String zza;

    public zzat(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        return this.zza.equals(((zzat) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator iterator() {
        return new f(this);
    }

    public final String toString() {
        String str = this.zza;
        return "\"" + str + "\"";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0184, code lost:
        com.google.android.gms.internal.measurement.zzh.zzh("toUpperCase", 0, r23);
        r6 = r20;
        r1 = new com.google.android.gms.internal.measurement.zzat(r6.zza.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0197, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x019b, code lost:
        r6 = r20;
        com.google.android.gms.internal.measurement.zzh.zzh("toUpperCase", 0, r23);
        r1 = new com.google.android.gms.internal.measurement.zzat(r6.zza.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01b1, code lost:
        r6 = r20;
        com.google.android.gms.internal.measurement.zzh.zzh("toString", 0, r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01bb, code lost:
        r6 = r20;
        com.google.android.gms.internal.measurement.zzh.zzh("toLowerCase", 0, r23);
        r1 = new com.google.android.gms.internal.measurement.zzat(r6.zza.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d1, code lost:
        r6 = r20;
        com.google.android.gms.internal.measurement.zzh.zzh("toLocaleLowerCase", 0, r23);
        r1 = new com.google.android.gms.internal.measurement.zzat(r6.zza.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e5, code lost:
        r6 = r20;
        com.google.android.gms.internal.measurement.zzh.zzh(r11, 0, r23);
        r1 = new com.google.android.gms.internal.measurement.zzat(r6.zza.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f9, code lost:
        r6 = r20;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("substring", 2, r0);
        r2 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0208, code lost:
        if (r23.isEmpty() != false) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x020a, code lost:
        r1 = r22;
        r3 = (int) com.google.android.gms.internal.measurement.zzh.zza(r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0224, code lost:
        r1 = r22;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x022c, code lost:
        if (r23.size() <= 1) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x022e, code lost:
        r0 = (int) com.google.android.gms.internal.measurement.zzh.zza(r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0247, code lost:
        r0 = r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x024c, code lost:
        r3 = java.lang.Math.min(java.lang.Math.max(r3, 0), r2.length());
        r0 = java.lang.Math.min(java.lang.Math.max(r0, 0), r2.length());
        r1 = new com.google.android.gms.internal.measurement.zzat(r2.substring(java.lang.Math.min(r3, r0), java.lang.Math.max(r3, r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0277, code lost:
        r6 = r20;
        r1 = r22;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("split", 2, r0);
        r2 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0287, code lost:
        if (r2.length() != 0) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0289, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{r6}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0298, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x029c, code lost:
        r4 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02a6, code lost:
        if (r23.isEmpty() == false) goto L_0x02ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02a8, code lost:
        r4.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02ad, code lost:
        r3 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02c0, code lost:
        if (r23.size() <= 1) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02c2, code lost:
        r0 = com.google.android.gms.internal.measurement.zzh.zzd(r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02d9, code lost:
        r0 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02e0, code lost:
        if (r0 != 0) goto L_0x02e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02e2, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02e8, code lost:
        r2 = r2.split(java.util.regex.Pattern.quote(r3), ((int) r0) + 1);
        r5 = r2.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02f8, code lost:
        if (r3.isEmpty() == false) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02fa, code lost:
        if (r5 <= 0) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02fc, code lost:
        r8 = r2[0].isEmpty();
        r3 = -1;
        r7 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x030c, code lost:
        if (r2[r7].isEmpty() != false) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x030e, code lost:
        r7 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0310, code lost:
        r3 = -1;
        r7 = r5;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0316, code lost:
        if (((long) r5) <= r0) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0318, code lost:
        r7 = r7 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0319, code lost:
        if (r8 >= r7) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x031b, code lost:
        r4.add(new com.google.android.gms.internal.measurement.zzat(r2[r8]));
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0328, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x032f, code lost:
        r6 = r20;
        r1 = r22;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("slice", 2, r0);
        r4 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x033f, code lost:
        if (r23.isEmpty() != false) goto L_0x0355;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0341, code lost:
        r7 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0355, code lost:
        r7 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0356, code lost:
        r7 = com.google.android.gms.internal.measurement.zzh.zza(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x035c, code lost:
        if (r7 >= 0.0d) goto L_0x0369;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x035e, code lost:
        r7 = java.lang.Math.max(((double) r4.length()) + r7, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0369, code lost:
        r7 = java.lang.Math.min(r7, (double) r4.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0372, code lost:
        r5 = (int) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0378, code lost:
        if (r23.size() <= 1) goto L_0x038d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x037a, code lost:
        r0 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x038d, code lost:
        r0 = (double) r4.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0392, code lost:
        r0 = com.google.android.gms.internal.measurement.zzh.zza(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0398, code lost:
        if (r0 >= 0.0d) goto L_0x03a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x039a, code lost:
        r0 = java.lang.Math.max(((double) r4.length()) + r0, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03a5, code lost:
        r0 = java.lang.Math.min(r0, (double) r4.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03ae, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzat(r4.substring(r5, java.lang.Math.max(0, ((int) r0) - r5) + r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03c1, code lost:
        r6 = r20;
        r1 = r22;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj(com.google.firebase.analytics.FirebaseAnalytics.Event.SEARCH, 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03d0, code lost:
        if (r23.isEmpty() != false) goto L_0x03e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03d2, code lost:
        r16 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03e0, code lost:
        r0 = java.util.regex.Pattern.compile(r16).matcher(r6.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03ee, code lost:
        if (r0.find() == false) goto L_0x0400;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03f0, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0400, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x040d, code lost:
        r6 = r20;
        r1 = r22;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj(r17, 2, r0);
        r2 = com.google.android.gms.internal.measurement.zzap.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x041f, code lost:
        if (r23.isEmpty() != false) goto L_0x0441;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0421, code lost:
        r16 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0435, code lost:
        if (r23.size() <= 1) goto L_0x0441;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0437, code lost:
        r2 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0441, code lost:
        r0 = r16;
        r3 = r6.zza;
        r4 = r3.indexOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0449, code lost:
        if (r4 < 0) goto L_0x062e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x044d, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x0475;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x044f, code lost:
        r9 = 0;
        r2 = ((com.google.android.gms.internal.measurement.zzai) r2).zza(r1, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r0), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r4)), r6}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0475, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0476, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzat(r3.substring(r9, r4) + r2.zzi() + r3.substring(r4 + r0.length()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x04a0, code lost:
        r6 = r20;
        r1 = r22;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("match", 1, r0);
        r2 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x04b1, code lost:
        if (r23.size() > 0) goto L_0x04b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x04b3, code lost:
        r0 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04b6, code lost:
        r0 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x04c5, code lost:
        r0 = java.util.regex.Pattern.compile(r0).matcher(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x04d1, code lost:
        if (r0.find() == false) goto L_0x04ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x04d3, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzap[]{new com.google.android.gms.internal.measurement.zzat(r0.group())}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x04ed, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x04f1, code lost:
        r6 = r20;
        r1 = r22;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj(r18, 2, r0);
        r2 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0504, code lost:
        if (r23.size() > 0) goto L_0x0509;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0506, code lost:
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0509, code lost:
        r16 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x051c, code lost:
        if (r23.size() >= 2) goto L_0x0521;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x051e, code lost:
        r0 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0521, code lost:
        r0 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0538, code lost:
        if (java.lang.Double.isNaN(r0) == false) goto L_0x053d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x053a, code lost:
        r0 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x053d, code lost:
        r0 = com.google.android.gms.internal.measurement.zzh.zza(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0541, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0554, code lost:
        r6 = r20;
        r1 = r22;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj("indexOf", 2, r0);
        r5 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0564, code lost:
        if (r23.size() > 0) goto L_0x0569;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0566, code lost:
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0569, code lost:
        r16 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzi();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x057d, code lost:
        if (r23.size() >= 2) goto L_0x0580;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0580, code lost:
        r2 = r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(1)).zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0593, code lost:
        r19 = r6;
        r6 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r5.indexOf(r7, (int) com.google.android.gms.internal.measurement.zzh.zza(r2))));
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x05ad, code lost:
        r6 = r20;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzh(r12, 1, r0);
        r2 = r6.zza;
        r0 = r22.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x05ce, code lost:
        if ("length".equals(r0.zzi()) == false) goto L_0x05d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x05d0, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x05d4, code lost:
        r0 = r0.zzh().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x05e2, code lost:
        if (r0 != java.lang.Math.floor(r0)) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x05e4, code lost:
        r0 = (int) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x05e5, code lost:
        if (r0 < 0) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x05eb, code lost:
        if (r0 >= r2.length()) goto L_0x05f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x05ed, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x05f1, code lost:
        r0 = com.google.android.gms.internal.measurement.zzap.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x05f5, code lost:
        r6 = r20;
        r1 = r22;
        r0 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x05ff, code lost:
        if (r23.isEmpty() != false) goto L_0x062e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0601, code lost:
        r2 = new java.lang.StringBuilder(r6.zza);
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x060d, code lost:
        if (r8 >= r23.size()) goto L_0x0623;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x060f, code lost:
        r2.append(r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(r8)).zzi());
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0623, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzat(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x062e, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0630, code lost:
        r2 = r20;
        r1 = r22;
        r0 = r23;
        com.google.android.gms.internal.measurement.zzh.zzj(r6, 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x063e, code lost:
        if (r23.isEmpty() != false) goto L_0x0659;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0640, code lost:
        r8 = (int) com.google.android.gms.internal.measurement.zzh.zza(r1.zzb((com.google.android.gms.internal.measurement.zzap) r0.get(0)).zzh().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0659, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x065b, code lost:
        r0 = r2.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x065d, code lost:
        if (r8 < 0) goto L_0x0674;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0663, code lost:
        if (r8 < r0.length()) goto L_0x0666;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return com.google.android.gms.internal.measurement.zzap.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2.lastIndexOf(r3, (int) r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:?, code lost:
        return new com.google.android.gms.internal.measurement.zzat(java.lang.String.valueOf(r0.charAt(r8)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c0, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d8, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00da, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0170, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0171, code lost:
        r16 = "undefined";
        r17 = "replace";
        r18 = "lastIndexOf";
        r2 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0179, code lost:
        switch(r1) {
            case 0: goto L_0x0630;
            case 1: goto L_0x05f5;
            case 2: goto L_0x05ad;
            case 3: goto L_0x0554;
            case 4: goto L_0x04f1;
            case 5: goto L_0x04a0;
            case 6: goto L_0x040d;
            case 7: goto L_0x03c1;
            case 8: goto L_0x032f;
            case 9: goto L_0x0277;
            case 10: goto L_0x01f9;
            case 11: goto L_0x01e5;
            case 12: goto L_0x01d1;
            case 13: goto L_0x01bb;
            case 14: goto L_0x01b1;
            case 15: goto L_0x019b;
            case 16: goto L_0x0184;
            default: goto L_0x017c;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0183, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzap zzbR(java.lang.String r21, com.google.android.gms.internal.measurement.zzg r22, java.util.List r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.String r6 = "trim"
            java.lang.String r10 = "charAt"
            boolean r11 = r10.equals(r1)
            java.lang.String r12 = "concat"
            java.lang.String r13 = "toLocaleUpperCase"
            java.lang.String r14 = "toString"
            java.lang.String r15 = "toLocaleLowerCase"
            java.lang.String r4 = "toLowerCase"
            java.lang.String r7 = "substring"
            java.lang.String r5 = "split"
            java.lang.String r8 = "slice"
            java.lang.String r9 = "search"
            java.lang.String r2 = "replace"
            java.lang.String r0 = "match"
            java.lang.String r3 = "lastIndexOf"
            r16 = r10
            java.lang.String r10 = "indexOf"
            r17 = r6
            java.lang.String r6 = "hasOwnProperty"
            r18 = r13
            java.lang.String r13 = "toUpperCase"
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r12.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r6.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r10.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r3.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r0.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r2.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r9.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r8.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r5.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r7.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r4.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r15.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r14.equals(r1)
            if (r11 != 0) goto L_0x00b4
            boolean r11 = r13.equals(r1)
            if (r11 != 0) goto L_0x00b4
            r11 = r18
            boolean r18 = r11.equals(r1)
            if (r18 != 0) goto L_0x00af
            r18 = r6
            r6 = r17
            boolean r17 = r6.equals(r1)
            if (r17 == 0) goto L_0x009d
            goto L_0x00b7
        L_0x009d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            java.lang.String r1 = "%s is not a String function"
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x00af:
            r18 = r6
            r6 = r17
            goto L_0x00b7
        L_0x00b4:
            r11 = r18
            goto L_0x00af
        L_0x00b7:
            int r17 = r21.hashCode()
            switch(r17) {
                case -1789698943: goto L_0x0164;
                case -1776922004: goto L_0x0158;
                case -1464939364: goto L_0x014d;
                case -1361633751: goto L_0x0141;
                case -1354795244: goto L_0x0135;
                case -1137582698: goto L_0x012c;
                case -906336856: goto L_0x0124;
                case -726908483: goto L_0x011b;
                case -467511597: goto L_0x0113;
                case -399551817: goto L_0x010a;
                case 3568674: goto L_0x0101;
                case 103668165: goto L_0x00f9;
                case 109526418: goto L_0x00f0;
                case 109648666: goto L_0x00e7;
                case 530542161: goto L_0x00de;
                case 1094496948: goto L_0x00d1;
                case 1943291465: goto L_0x00c4;
                default: goto L_0x00be;
            }
        L_0x00be:
            r6 = r16
        L_0x00c0:
            r12 = r18
            goto L_0x0170
        L_0x00c4:
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00be
            r6 = r16
            r12 = r18
            r1 = 3
            goto L_0x0171
        L_0x00d1:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00be
            r1 = 6
        L_0x00d8:
            r6 = r16
        L_0x00da:
            r12 = r18
            goto L_0x0171
        L_0x00de:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00be
            r1 = 10
            goto L_0x00d8
        L_0x00e7:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00be
            r1 = 9
            goto L_0x00d8
        L_0x00f0:
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00be
            r1 = 8
            goto L_0x00d8
        L_0x00f9:
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00be
            r1 = 5
            goto L_0x00d8
        L_0x0101:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00be
            r1 = 16
            goto L_0x00d8
        L_0x010a:
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00be
            r1 = 15
            goto L_0x00d8
        L_0x0113:
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00be
            r1 = 4
            goto L_0x00d8
        L_0x011b:
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x00be
            r1 = 11
            goto L_0x00d8
        L_0x0124:
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00be
            r1 = 7
            goto L_0x00d8
        L_0x012c:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00be
            r1 = 13
            goto L_0x00d8
        L_0x0135:
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x00be
            r6 = r16
            r12 = r18
            r1 = 1
            goto L_0x0171
        L_0x0141:
            r6 = r16
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00c0
            r12 = r18
            r1 = 0
            goto L_0x0171
        L_0x014d:
            r6 = r16
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x00c0
            r1 = 12
            goto L_0x00da
        L_0x0158:
            r6 = r16
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x00c0
            r1 = 14
            goto L_0x00da
        L_0x0164:
            r6 = r16
            r12 = r18
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x0170
            r1 = 2
            goto L_0x0171
        L_0x0170:
            r1 = -1
        L_0x0171:
            java.lang.String r16 = "undefined"
            r17 = r2
            r18 = r3
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0630;
                case 1: goto L_0x05f5;
                case 2: goto L_0x05ad;
                case 3: goto L_0x0554;
                case 4: goto L_0x04f1;
                case 5: goto L_0x04a0;
                case 6: goto L_0x040d;
                case 7: goto L_0x03c1;
                case 8: goto L_0x032f;
                case 9: goto L_0x0277;
                case 10: goto L_0x01f9;
                case 11: goto L_0x01e5;
                case 12: goto L_0x01d1;
                case 13: goto L_0x01bb;
                case 14: goto L_0x01b1;
                case 15: goto L_0x019b;
                case 16: goto L_0x0184;
                default: goto L_0x017c;
            }
        L_0x017c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0184:
            r0 = r23
            r1 = 0
            com.google.android.gms.internal.measurement.zzh.zzh(r13, r1, r0)
            r6 = r20
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.trim()
            r1.<init>(r0)
        L_0x0197:
            r2 = r6
            r6 = r1
            goto L_0x0676
        L_0x019b:
            r1 = 0
            r6 = r20
            r0 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r13, r1, r0)
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r2)
            r1.<init>(r0)
            goto L_0x0197
        L_0x01b1:
            r1 = 0
            r6 = r20
            r0 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r14, r1, r0)
            goto L_0x062e
        L_0x01bb:
            r1 = 0
            r6 = r20
            r0 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r4, r1, r0)
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r2)
            r1.<init>(r0)
            goto L_0x0197
        L_0x01d1:
            r1 = 0
            r6 = r20
            r0 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r15, r1, r0)
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.toLowerCase()
            r1.<init>(r0)
            goto L_0x0197
        L_0x01e5:
            r1 = 0
            r6 = r20
            r0 = r23
            com.google.android.gms.internal.measurement.zzh.zzh(r11, r1, r0)
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.toUpperCase()
            r1.<init>(r0)
            goto L_0x0197
        L_0x01f9:
            r6 = r20
            r0 = r23
            r1 = 0
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r7, r2, r0)
            java.lang.String r2 = r6.zza
            boolean r3 = r23.isEmpty()
            if (r3 != 0) goto L_0x0224
            java.lang.Object r3 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            r1 = r22
            com.google.android.gms.internal.measurement.zzap r3 = r1.zzb(r3)
            java.lang.Double r3 = r3.zzh()
            double r3 = r3.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzh.zza(r3)
            int r3 = (int) r3
            goto L_0x0227
        L_0x0224:
            r1 = r22
            r3 = 0
        L_0x0227:
            int r4 = r23.size()
            r5 = 1
            if (r4 <= r5) goto L_0x0247
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r1.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.zzh.zza(r0)
            int r0 = (int) r0
        L_0x0245:
            r1 = 0
            goto L_0x024c
        L_0x0247:
            int r0 = r2.length()
            goto L_0x0245
        L_0x024c:
            int r3 = java.lang.Math.max(r3, r1)
            int r4 = r2.length()
            int r3 = java.lang.Math.min(r3, r4)
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r2.length()
            int r0 = java.lang.Math.min(r0, r1)
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            int r4 = java.lang.Math.min(r3, r0)
            int r0 = java.lang.Math.max(r3, r0)
            java.lang.String r0 = r2.substring(r4, r0)
            r1.<init>(r0)
            goto L_0x0197
        L_0x0277:
            r6 = r20
            r1 = r22
            r0 = r23
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r5, r2, r0)
            java.lang.String r2 = r6.zza
            int r3 = r2.length()
            if (r3 != 0) goto L_0x029c
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r1 = 1
            com.google.android.gms.internal.measurement.zzap[] r1 = new com.google.android.gms.internal.measurement.zzap[r1]
            r3 = 0
            r1[r3] = r6
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
        L_0x0298:
            r2 = r6
            r6 = r0
            goto L_0x0676
        L_0x029c:
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r5 = r23.isEmpty()
            if (r5 == 0) goto L_0x02ad
            r4.add(r6)
            goto L_0x0328
        L_0x02ad:
            java.lang.Object r5 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzap r5 = (com.google.android.gms.internal.measurement.zzap) r5
            com.google.android.gms.internal.measurement.zzap r3 = r1.zzb(r5)
            java.lang.String r3 = r3.zzi()
            int r5 = r23.size()
            r7 = 1
            if (r5 <= r7) goto L_0x02d9
            java.lang.Object r0 = r0.get(r7)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r1.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r0 = r0.doubleValue()
            long r0 = com.google.android.gms.internal.measurement.zzh.zzd(r0)
            goto L_0x02dc
        L_0x02d9:
            r0 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x02dc:
            r7 = 0
            int r5 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x02e8
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x0298
        L_0x02e8:
            java.lang.String r5 = java.util.regex.Pattern.quote(r3)
            int r7 = (int) r0
            r8 = 1
            int r7 = r7 + r8
            java.lang.String[] r2 = r2.split(r5, r7)
            int r5 = r2.length
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0310
            if (r5 <= 0) goto L_0x0310
            r3 = 0
            r3 = r2[r3]
            boolean r8 = r3.isEmpty()
            r3 = -1
            int r7 = r5 + -1
            r9 = r2[r7]
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x0313
            r7 = r5
            goto L_0x0313
        L_0x0310:
            r3 = -1
            r7 = r5
            r8 = 0
        L_0x0313:
            long r9 = (long) r5
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0319
            int r7 = r7 + r3
        L_0x0319:
            if (r8 >= r7) goto L_0x0328
            com.google.android.gms.internal.measurement.zzat r0 = new com.google.android.gms.internal.measurement.zzat
            r1 = r2[r8]
            r0.<init>(r1)
            r4.add(r0)
            r0 = 1
            int r8 = r8 + r0
            goto L_0x0319
        L_0x0328:
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>(r4)
            goto L_0x0298
        L_0x032f:
            r6 = r20
            r1 = r22
            r0 = r23
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r8, r4, r0)
            java.lang.String r4 = r6.zza
            boolean r5 = r23.isEmpty()
            if (r5 != 0) goto L_0x0355
            r5 = 0
            java.lang.Object r7 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r5 = r1.zzb(r7)
            java.lang.Double r5 = r5.zzh()
            double r7 = r5.doubleValue()
            goto L_0x0356
        L_0x0355:
            r7 = r2
        L_0x0356:
            double r7 = com.google.android.gms.internal.measurement.zzh.zza(r7)
            int r5 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x0369
            int r5 = r4.length()
            double r9 = (double) r5
            double r9 = r9 + r7
            double r7 = java.lang.Math.max(r9, r2)
            goto L_0x0372
        L_0x0369:
            int r5 = r4.length()
            double r9 = (double) r5
            double r7 = java.lang.Math.min(r7, r9)
        L_0x0372:
            int r5 = (int) r7
            int r7 = r23.size()
            r8 = 1
            if (r7 <= r8) goto L_0x038d
            java.lang.Object r0 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r1.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r0 = r0.doubleValue()
            goto L_0x0392
        L_0x038d:
            int r0 = r4.length()
            double r0 = (double) r0
        L_0x0392:
            double r0 = com.google.android.gms.internal.measurement.zzh.zza(r0)
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x03a5
            int r7 = r4.length()
            double r7 = (double) r7
            double r7 = r7 + r0
            double r0 = java.lang.Math.max(r7, r2)
            goto L_0x03ae
        L_0x03a5:
            int r2 = r4.length()
            double r2 = (double) r2
            double r0 = java.lang.Math.min(r0, r2)
        L_0x03ae:
            int r0 = (int) r0
            int r0 = r0 - r5
            r2 = 0
            int r0 = java.lang.Math.max(r2, r0)
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            int r0 = r0 + r5
            java.lang.String r0 = r4.substring(r5, r0)
            r1.<init>(r0)
            goto L_0x0197
        L_0x03c1:
            r6 = r20
            r1 = r22
            r0 = r23
            r2 = 0
            r3 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r9, r3, r0)
            boolean r3 = r23.isEmpty()
            if (r3 != 0) goto L_0x03e0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r1.zzb(r0)
            java.lang.String r16 = r0.zzi()
        L_0x03e0:
            java.lang.String r0 = r6.zza
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r16)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0400
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            int r0 = r0.start()
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            goto L_0x0197
        L_0x0400:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            goto L_0x0298
        L_0x040d:
            r3 = 2
            r6 = r20
            r1 = r22
            r0 = r23
            r2 = r17
            com.google.android.gms.internal.measurement.zzh.zzj(r2, r3, r0)
            com.google.android.gms.internal.measurement.zzap r2 = com.google.android.gms.internal.measurement.zzap.zzf
            boolean r3 = r23.isEmpty()
            if (r3 != 0) goto L_0x0441
            r3 = 0
            java.lang.Object r4 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzap r4 = (com.google.android.gms.internal.measurement.zzap) r4
            com.google.android.gms.internal.measurement.zzap r3 = r1.zzb(r4)
            java.lang.String r16 = r3.zzi()
            int r3 = r23.size()
            r4 = 1
            if (r3 <= r4) goto L_0x0441
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r2 = r1.zzb(r0)
        L_0x0441:
            r0 = r16
            java.lang.String r3 = r6.zza
            int r4 = r3.indexOf(r0)
            if (r4 < 0) goto L_0x062e
            boolean r5 = r2 instanceof com.google.android.gms.internal.measurement.zzai
            if (r5 == 0) goto L_0x0475
            com.google.android.gms.internal.measurement.zzai r2 = (com.google.android.gms.internal.measurement.zzai) r2
            com.google.android.gms.internal.measurement.zzat r5 = new com.google.android.gms.internal.measurement.zzat
            r5.<init>(r0)
            com.google.android.gms.internal.measurement.zzah r7 = new com.google.android.gms.internal.measurement.zzah
            double r8 = (double) r4
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r7.<init>(r8)
            r8 = 3
            com.google.android.gms.internal.measurement.zzap[] r8 = new com.google.android.gms.internal.measurement.zzap[r8]
            r9 = 0
            r8[r9] = r5
            r5 = 1
            r8[r5] = r7
            r5 = 2
            r8[r5] = r6
            java.util.List r5 = java.util.Arrays.asList(r8)
            com.google.android.gms.internal.measurement.zzap r2 = r2.zza(r1, r5)
            goto L_0x0476
        L_0x0475:
            r9 = 0
        L_0x0476:
            com.google.android.gms.internal.measurement.zzat r1 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r5 = r3.substring(r9, r4)
            java.lang.String r2 = r2.zzi()
            int r0 = r0.length()
            int r4 = r4 + r0
            java.lang.String r0 = r3.substring(r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            goto L_0x0197
        L_0x04a0:
            r6 = r20
            r1 = r22
            r2 = r0
            r3 = 1
            r0 = r23
            com.google.android.gms.internal.measurement.zzh.zzj(r2, r3, r0)
            java.lang.String r2 = r6.zza
            int r3 = r23.size()
            if (r3 > 0) goto L_0x04b6
            java.lang.String r0 = ""
            goto L_0x04c5
        L_0x04b6:
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r1.zzb(r0)
            java.lang.String r0 = r0.zzi()
        L_0x04c5:
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r2)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x04ed
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            com.google.android.gms.internal.measurement.zzat r2 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r0 = r0.group()
            r2.<init>(r0)
            r0 = 1
            com.google.android.gms.internal.measurement.zzap[] r0 = new com.google.android.gms.internal.measurement.zzap[r0]
            r3 = 0
            r0[r3] = r2
            java.util.List r0 = java.util.Arrays.asList(r0)
            r1.<init>(r0)
            goto L_0x0197
        L_0x04ed:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzg
            goto L_0x0298
        L_0x04f1:
            r6 = r20
            r1 = r22
            r0 = r23
            r2 = r18
            r3 = 0
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r2, r4, r0)
            java.lang.String r2 = r6.zza
            int r5 = r23.size()
            if (r5 > 0) goto L_0x0509
        L_0x0506:
            r3 = r16
            goto L_0x0518
        L_0x0509:
            java.lang.Object r3 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r1.zzb(r3)
            java.lang.String r16 = r3.zzi()
            goto L_0x0506
        L_0x0518:
            int r5 = r23.size()
            if (r5 >= r4) goto L_0x0521
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x0534
        L_0x0521:
            r4 = 1
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r1.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r0 = r0.doubleValue()
        L_0x0534:
            boolean r4 = java.lang.Double.isNaN(r0)
            if (r4 == 0) goto L_0x053d
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x0541
        L_0x053d:
            double r0 = com.google.android.gms.internal.measurement.zzh.zza(r0)
        L_0x0541:
            com.google.android.gms.internal.measurement.zzah r4 = new com.google.android.gms.internal.measurement.zzah
            int r0 = (int) r0
            int r0 = r2.lastIndexOf(r3, r0)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r4.<init>(r0)
            r2 = r6
            r6 = r4
            goto L_0x0676
        L_0x0554:
            r6 = r20
            r1 = r22
            r0 = r23
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzj(r10, r4, r0)
            java.lang.String r5 = r6.zza
            int r7 = r23.size()
            if (r7 > 0) goto L_0x0569
        L_0x0566:
            r7 = r16
            goto L_0x0579
        L_0x0569:
            r7 = 0
            java.lang.Object r7 = r0.get(r7)
            com.google.android.gms.internal.measurement.zzap r7 = (com.google.android.gms.internal.measurement.zzap) r7
            com.google.android.gms.internal.measurement.zzap r7 = r1.zzb(r7)
            java.lang.String r16 = r7.zzi()
            goto L_0x0566
        L_0x0579:
            int r8 = r23.size()
            if (r8 >= r4) goto L_0x0580
            goto L_0x0593
        L_0x0580:
            r2 = 1
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r1.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r2 = r0.doubleValue()
        L_0x0593:
            double r0 = com.google.android.gms.internal.measurement.zzh.zza(r2)
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            int r0 = (int) r0
            int r0 = r5.indexOf(r7, r0)
            double r0 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r2.<init>(r0)
            r19 = r6
            r6 = r2
            r2 = r19
            goto L_0x0676
        L_0x05ad:
            r6 = r20
            r1 = r22
            r0 = r23
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzh(r12, r2, r0)
            java.lang.String r2 = r6.zza
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r1.zzb(r0)
            java.lang.String r1 = r0.zzi()
            java.lang.String r3 = "length"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x05d4
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x0298
        L_0x05d4:
            java.lang.Double r0 = r0.zzh()
            double r0 = r0.doubleValue()
            double r3 = java.lang.Math.floor(r0)
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x05f1
            int r0 = (int) r0
            if (r0 < 0) goto L_0x05f1
            int r1 = r2.length()
            if (r0 >= r1) goto L_0x05f1
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzk
            goto L_0x0298
        L_0x05f1:
            com.google.android.gms.internal.measurement.zzap r0 = com.google.android.gms.internal.measurement.zzap.zzl
            goto L_0x0298
        L_0x05f5:
            r6 = r20
            r1 = r22
            r0 = r23
            boolean r2 = r23.isEmpty()
            if (r2 != 0) goto L_0x062e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = r6.zza
            r2.<init>(r3)
            r8 = 0
        L_0x0609:
            int r3 = r23.size()
            if (r8 >= r3) goto L_0x0623
            java.lang.Object r3 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzap r3 = (com.google.android.gms.internal.measurement.zzap) r3
            com.google.android.gms.internal.measurement.zzap r3 = r1.zzb(r3)
            java.lang.String r3 = r3.zzi()
            r2.append(r3)
            r3 = 1
            int r8 = r8 + r3
            goto L_0x0609
        L_0x0623:
            com.google.android.gms.internal.measurement.zzat r0 = new com.google.android.gms.internal.measurement.zzat
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            goto L_0x0298
        L_0x062e:
            r2 = r6
            goto L_0x0676
        L_0x0630:
            r2 = r20
            r1 = r22
            r0 = r23
            r3 = 1
            com.google.android.gms.internal.measurement.zzh.zzj(r6, r3, r0)
            boolean r3 = r23.isEmpty()
            if (r3 != 0) goto L_0x0659
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzap r0 = (com.google.android.gms.internal.measurement.zzap) r0
            com.google.android.gms.internal.measurement.zzap r0 = r1.zzb(r0)
            java.lang.Double r0 = r0.zzh()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.zzh.zza(r0)
            int r8 = (int) r0
            goto L_0x065b
        L_0x0659:
            r3 = 0
            r8 = r3
        L_0x065b:
            java.lang.String r0 = r2.zza
            if (r8 < 0) goto L_0x0674
            int r1 = r0.length()
            if (r8 < r1) goto L_0x0666
            goto L_0x0674
        L_0x0666:
            com.google.android.gms.internal.measurement.zzat r6 = new com.google.android.gms.internal.measurement.zzat
            char r0 = r0.charAt(r8)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r6.<init>(r0)
            goto L_0x0676
        L_0x0674:
            com.google.android.gms.internal.measurement.zzap r6 = com.google.android.gms.internal.measurement.zzap.zzm
        L_0x0676:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzat.zzbR(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzap");
    }

    public final zzap zzd() {
        return new zzat(this.zza);
    }

    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String zzi() {
        return this.zza;
    }

    public final Iterator zzl() {
        return new e(this);
    }
}
