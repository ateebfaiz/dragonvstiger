package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class n4 {

    /* renamed from: a  reason: collision with root package name */
    final String f7645a;

    /* renamed from: b  reason: collision with root package name */
    final int f7646b;

    /* renamed from: c  reason: collision with root package name */
    Boolean f7647c;

    /* renamed from: d  reason: collision with root package name */
    Boolean f7648d;

    /* renamed from: e  reason: collision with root package name */
    Long f7649e;

    /* renamed from: f  reason: collision with root package name */
    Long f7650f;

    n4(String str, int i10) {
        this.f7645a = str;
        this.f7646b = i10;
    }

    private static Boolean d(String str, int i10, boolean z10, String str2, List list, String str3, zzeh zzeh) {
        int i11;
        if (i10 == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z10 && i10 != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i10 - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                if (true != z10) {
                    i11 = 66;
                } else {
                    i11 = 0;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, i11).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzeh != null) {
                        zzeh.zzk().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean e(BigDecimal bigDecimal, zzer zzer, double d10) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzer);
        if (zzer.zzg()) {
            boolean z10 = true;
            if (zzer.zzm() != 1) {
                if (zzer.zzm() == 5) {
                    if (!zzer.zzk() || !zzer.zzj()) {
                        return null;
                    }
                } else if (!zzer.zzh()) {
                    return null;
                }
                int zzm = zzer.zzm();
                if (zzer.zzm() == 5) {
                    if (zzkv.zzx(zzer.zze()) && zzkv.zzx(zzer.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzer.zze());
                            bigDecimal3 = new BigDecimal(zzer.zzd());
                            bigDecimal2 = bigDecimal5;
                            bigDecimal4 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!zzkv.zzx(zzer.zzc())) {
                    return null;
                } else {
                    try {
                        bigDecimal4 = new BigDecimal(zzer.zzc());
                        bigDecimal2 = null;
                        bigDecimal3 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (zzm == 5) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                }
                int i10 = zzm - 1;
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4 || bigDecimal2 == null) {
                                return null;
                            }
                            if (bigDecimal.compareTo(bigDecimal2) < 0 || bigDecimal.compareTo(bigDecimal3) > 0) {
                                z10 = false;
                            }
                            return Boolean.valueOf(z10);
                        } else if (bigDecimal4 == null) {
                            return null;
                        } else {
                            if (d10 != 0.0d) {
                                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d10).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d10).multiply(new BigDecimal(2)))) >= 0) {
                                    z10 = false;
                                }
                                return Boolean.valueOf(z10);
                            }
                            if (bigDecimal.compareTo(bigDecimal4) != 0) {
                                z10 = false;
                            }
                            return Boolean.valueOf(z10);
                        }
                    } else if (bigDecimal4 == null) {
                        return null;
                    } else {
                        if (bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z10 = false;
                        }
                        return Boolean.valueOf(z10);
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal4) >= 0) {
                        z10 = false;
                    }
                    return Boolean.valueOf(z10);
                }
            }
        }
        return null;
    }

    static Boolean f(String str, zzey zzey, zzeh zzeh) {
        String zzd;
        List list;
        String str2;
        Preconditions.checkNotNull(zzey);
        if (str == null || !zzey.zzi() || zzey.zzj() == 1) {
            return null;
        }
        if (zzey.zzj() == 7) {
            if (zzey.zza() == 0) {
                return null;
            }
        } else if (!zzey.zzh()) {
            return null;
        }
        int zzj = zzey.zzj();
        boolean zzf = zzey.zzf();
        if (zzf || zzj == 2 || zzj == 7) {
            zzd = zzey.zzd();
        } else {
            zzd = zzey.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str3 = zzd;
        if (zzey.zza() == 0) {
            list = null;
        } else {
            List<String> zze = zzey.zze();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zze.size());
                for (String upperCase : zze) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zze = Collections.unmodifiableList(arrayList);
            }
            list = zze;
        }
        if (zzj == 2) {
            str2 = str3;
        } else {
            str2 = null;
        }
        return d(str, zzj, zzf, str3, list, str2, zzeh);
    }

    static Boolean g(double d10, zzer zzer) {
        try {
            return e(new BigDecimal(d10), zzer, Math.ulp(d10));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean h(long j10, zzer zzer) {
        try {
            return e(new BigDecimal(j10), zzer, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean i(String str, zzer zzer) {
        if (!zzkv.zzx(str)) {
            return null;
        }
        try {
            return e(new BigDecimal(str), zzer, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean j(Boolean bool, boolean z10) {
        boolean z11;
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue() != z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: package-private */
    public abstract int a();

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public abstract boolean c();
}
