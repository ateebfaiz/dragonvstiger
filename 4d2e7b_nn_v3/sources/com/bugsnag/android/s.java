package com.bugsnag.android;

import c1.f;
import com.bugsnag.android.ErrorType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final s2 f18972a;

    /* renamed from: b  reason: collision with root package name */
    private final a f18973b = new a();

    public static final class a extends ThreadLocal {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    }

    public s(s2 s2Var) {
        this.f18972a = s2Var;
    }

    private final UUID j(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        String substring = str.substring(0, 16);
        m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Long k10 = k(substring);
        if (k10 == null) {
            return null;
        }
        long longValue = k10.longValue();
        String substring2 = str.substring(16);
        m.e(substring2, "this as java.lang.String).substring(startIndex)");
        Long k11 = k(substring2);
        if (k11 == null) {
            return null;
        }
        return new UUID(longValue, k11.longValue());
    }

    private final Long k(String str) {
        if (str.length() != 16) {
            return null;
        }
        try {
            String substring = str.substring(0, 2);
            m.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring2 = str.substring(2);
            m.e(substring2, "this as java.lang.String).substring(startIndex)");
            return Long.valueOf(Long.parseLong(substring2, kotlin.text.a.a(16)) | (Long.parseLong(substring, kotlin.text.a.a(16)) << 56));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Date l(String str) {
        if (str.length() > 0 && str.charAt(0) == 't') {
            String substring = str.substring(1);
            m.e(substring, "this as java.lang.String).substring(startIndex)");
            Long k10 = j.k(substring);
            if (k10 != null) {
                return new Date(k10.longValue());
            }
        }
        try {
            return f.a(str);
        } catch (IllegalArgumentException unused) {
            Object obj = this.f18973b.get();
            m.c(obj);
            Date parse = ((DateFormat) obj).parse(str);
            if (parse != null) {
                return parse;
            }
            throw new IllegalArgumentException(m.n("cannot parse date ", str));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bugsnag.android.m a(java.util.Map r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "binaryArch"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.String
            r3 = 0
            if (r2 == 0) goto L_0x0011
            java.lang.String r1 = (java.lang.String) r1
            r5 = r1
            goto L_0x0012
        L_0x0011:
            r5 = r3
        L_0x0012:
            java.lang.String r1 = "id"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0020
            java.lang.String r1 = (java.lang.String) r1
            r6 = r1
            goto L_0x0021
        L_0x0020:
            r6 = r3
        L_0x0021:
            java.lang.String r1 = "releaseStage"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x002f
            java.lang.String r1 = (java.lang.String) r1
            r7 = r1
            goto L_0x0030
        L_0x002f:
            r7 = r3
        L_0x0030:
            java.lang.String r1 = "version"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x003e
            java.lang.String r1 = (java.lang.String) r1
            r8 = r1
            goto L_0x003f
        L_0x003e:
            r8 = r3
        L_0x003f:
            java.lang.String r1 = "codeBundleId"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x004d
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            goto L_0x004e
        L_0x004d:
            r9 = r3
        L_0x004e:
            java.lang.String r1 = "buildUUID"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x005b
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x005c
        L_0x005b:
            r1 = r3
        L_0x005c:
            if (r1 != 0) goto L_0x0060
            r10 = r3
            goto L_0x0066
        L_0x0060:
            d1.g r2 = new d1.g
            r2.<init>(r1)
            r10 = r2
        L_0x0066:
            java.lang.String r1 = "type"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0074
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            goto L_0x0075
        L_0x0074:
            r11 = r3
        L_0x0075:
            java.lang.String r1 = "versionCode"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.Number
            if (r2 == 0) goto L_0x0082
            java.lang.Number r1 = (java.lang.Number) r1
            goto L_0x0083
        L_0x0082:
            r1 = r3
        L_0x0083:
            if (r1 != 0) goto L_0x0087
            r12 = r3
            goto L_0x0090
        L_0x0087:
            int r1 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12 = r1
        L_0x0090:
            java.lang.String r1 = "duration"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.Number
            if (r2 == 0) goto L_0x009d
            java.lang.Number r1 = (java.lang.Number) r1
            goto L_0x009e
        L_0x009d:
            r1 = r3
        L_0x009e:
            if (r1 != 0) goto L_0x00a2
            r13 = r3
            goto L_0x00ab
        L_0x00a2:
            long r1 = r1.longValue()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r13 = r1
        L_0x00ab:
            java.lang.String r1 = "durationInForeground"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.Number
            if (r2 == 0) goto L_0x00b8
            java.lang.Number r1 = (java.lang.Number) r1
            goto L_0x00b9
        L_0x00b8:
            r1 = r3
        L_0x00b9:
            if (r1 != 0) goto L_0x00bd
            r14 = r3
            goto L_0x00c6
        L_0x00bd:
            long r1 = r1.longValue()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r14 = r1
        L_0x00c6:
            java.lang.String r1 = "inForeground"
            java.lang.Object r1 = r0.get(r1)
            boolean r2 = r1 instanceof java.lang.Boolean
            if (r2 == 0) goto L_0x00d4
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r15 = r1
            goto L_0x00d5
        L_0x00d4:
            r15 = r3
        L_0x00d5:
            java.lang.String r1 = "isLaunching"
            java.lang.Object r0 = r0.get(r1)
            boolean r1 = r0 instanceof java.lang.Boolean
            if (r1 == 0) goto L_0x00e2
            r3 = r0
            java.lang.Boolean r3 = (java.lang.Boolean) r3
        L_0x00e2:
            r16 = r3
            com.bugsnag.android.m r0 = new com.bugsnag.android.m
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.s.a(java.util.Map):com.bugsnag.android.m");
    }

    public final p b(Map map) {
        Map map2;
        Object obj = map.get("name");
        if (obj instanceof String) {
            String str = (String) obj;
            Object obj2 = map.get("type");
            if (obj2 instanceof String) {
                BreadcrumbType a10 = BreadcrumbType.Companion.a((String) obj2);
                if (a10 == null) {
                    a10 = BreadcrumbType.MANUAL;
                }
                Object obj3 = map.get("metaData");
                if (c0.l(obj3)) {
                    map2 = (Map) obj3;
                } else {
                    map2 = null;
                }
                Object obj4 = map.get("timestamp");
                if (obj4 instanceof String) {
                    return new p(str, a10, map2, l((String) obj4));
                }
                if (obj4 == null) {
                    throw new IllegalStateException("cannot find json property '" + "timestamp" + '\'');
                }
                throw new IllegalArgumentException("json property '" + "timestamp" + "' not of expected type, found " + obj4.getClass().getName());
            } else if (obj2 == null) {
                throw new IllegalStateException("cannot find json property '" + "type" + '\'');
            } else {
                throw new IllegalArgumentException("json property '" + "type" + "' not of expected type, found " + obj2.getClass().getName());
            }
        } else if (obj == null) {
            throw new IllegalStateException("cannot find json property '" + "name" + '\'');
        } else {
            throw new IllegalArgumentException("json property '" + "name" + "' not of expected type, found " + obj.getClass().getName());
        }
    }

    public final i1 c(Map map) {
        String str;
        String str2;
        String str3;
        List list;
        String[] strArr;
        Boolean bool;
        String str4;
        String str5;
        Number number;
        Long l10;
        Map map2;
        Map map3;
        Number number2;
        Long l11;
        Number number3;
        Long l12;
        String str6;
        String str7;
        Date date;
        Object obj = map.get("manufacturer");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        Object obj2 = map.get("model");
        if (obj2 instanceof String) {
            str2 = (String) obj2;
        } else {
            str2 = null;
        }
        Object obj3 = map.get("osVersion");
        if (obj3 instanceof String) {
            str3 = (String) obj3;
        } else {
            str3 = null;
        }
        Object obj4 = map.get("cpuAbi");
        if (obj4 instanceof List) {
            list = (List) obj4;
        } else {
            list = null;
        }
        if (list == null) {
            strArr = null;
        } else {
            Object[] array = list.toArray(new String[0]);
            if (array != null) {
                strArr = (String[]) array;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        x0 x0Var = new x0(str, str2, str3, (Integer) null, (String) null, (String) null, (String) null, (String) null, strArr);
        Object obj5 = map.get("jailbroken");
        if (obj5 instanceof Boolean) {
            bool = (Boolean) obj5;
        } else {
            bool = null;
        }
        Object obj6 = map.get("id");
        if (obj6 instanceof String) {
            str4 = (String) obj6;
        } else {
            str4 = null;
        }
        Object obj7 = map.get("locale");
        if (obj7 instanceof String) {
            str5 = (String) obj7;
        } else {
            str5 = null;
        }
        Object obj8 = map.get("totalMemory");
        if (obj8 instanceof Number) {
            number = (Number) obj8;
        } else {
            number = null;
        }
        if (number == null) {
            l10 = null;
        } else {
            l10 = Long.valueOf(number.longValue());
        }
        Object obj9 = map.get("runtimeVersions");
        if (obj9 instanceof Map) {
            map2 = (Map) obj9;
        } else {
            map2 = null;
        }
        if (map2 == null) {
            map3 = null;
        } else {
            map3 = i0.r(map2);
        }
        if (map3 == null) {
            map3 = new LinkedHashMap();
        }
        Map map4 = map3;
        Object obj10 = map.get("freeDisk");
        if (obj10 instanceof Number) {
            number2 = (Number) obj10;
        } else {
            number2 = null;
        }
        if (number2 == null) {
            l11 = null;
        } else {
            l11 = Long.valueOf(number2.longValue());
        }
        Object obj11 = map.get("freeMemory");
        if (obj11 instanceof Number) {
            number3 = (Number) obj11;
        } else {
            number3 = null;
        }
        if (number3 == null) {
            l12 = null;
        } else {
            l12 = Long.valueOf(number3.longValue());
        }
        Object obj12 = map.get("orientation");
        if (obj12 instanceof String) {
            str6 = (String) obj12;
        } else {
            str6 = null;
        }
        Object obj13 = map.get("time");
        if (obj13 instanceof String) {
            str7 = (String) obj13;
        } else {
            str7 = null;
        }
        if (str7 == null) {
            date = null;
        } else {
            date = l(str7);
        }
        return new i1(x0Var, bool, str4, str5, l10, map4, l11, l12, str6, date);
    }

    public final m1 d(Map map) {
        String str;
        Object obj = map.get("errorClass");
        if (obj instanceof String) {
            String str2 = (String) obj;
            Object obj2 = map.get("message");
            if (obj2 instanceof String) {
                str = (String) obj2;
            } else {
                str = null;
            }
            Object obj3 = map.get("type");
            if (obj3 instanceof String) {
                String str3 = (String) obj3;
                ErrorType a10 = ErrorType.Companion.a(str3);
                if (a10 != null) {
                    Object obj4 = map.get("stacktrace");
                    if (obj4 instanceof List) {
                        return new m1(str2, str, e((List) obj4), a10);
                    }
                    if (obj4 == null) {
                        throw new IllegalStateException("cannot find json property '" + "stacktrace" + '\'');
                    }
                    throw new IllegalArgumentException("json property '" + "stacktrace" + "' not of expected type, found " + obj4.getClass().getName());
                }
                throw new IllegalArgumentException("unknown ErrorType: '" + str3 + '\'');
            } else if (obj3 == null) {
                throw new IllegalStateException("cannot find json property '" + "type" + '\'');
            } else {
                throw new IllegalArgumentException("json property '" + "type" + "' not of expected type, found " + obj3.getClass().getName());
            }
        } else if (obj == null) {
            throw new IllegalStateException("cannot find json property '" + "errorClass" + '\'');
        } else {
            throw new IllegalArgumentException("json property '" + "errorClass" + "' not of expected type, found " + obj.getClass().getName());
        }
    }

    public final u3 e(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new s3((Map) it.next()));
        }
        return new u3(arrayList);
    }

    public final c4 f(Map map) {
        String str;
        List list;
        u3 u3Var;
        String valueOf = String.valueOf(map.get("id"));
        Object obj = map.get("name");
        if (obj instanceof String) {
            String str2 = (String) obj;
            ErrorType.a aVar = ErrorType.Companion;
            Object obj2 = map.get("type");
            if (obj2 instanceof String) {
                ErrorType a10 = aVar.a((String) obj2);
                if (a10 == null) {
                    a10 = ErrorType.ANDROID;
                }
                ErrorType errorType = a10;
                boolean b10 = m.b(map.get("errorReportingThread"), Boolean.TRUE);
                Object obj3 = map.get("state");
                u3 u3Var2 = null;
                if (obj3 instanceof String) {
                    str = (String) obj3;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                Object obj4 = map.get("stacktrace");
                if (obj4 instanceof List) {
                    list = (List) obj4;
                } else {
                    list = null;
                }
                if (list != null) {
                    u3Var2 = e(list);
                }
                if (u3Var2 == null) {
                    u3Var = new u3(new ArrayList());
                } else {
                    u3Var = u3Var2;
                }
                return new c4(valueOf, str2, errorType, b10, str, u3Var);
            } else if (obj2 == null) {
                throw new IllegalStateException("cannot find json property '" + "type" + '\'');
            } else {
                throw new IllegalArgumentException("json property '" + "type" + "' not of expected type, found " + obj2.getClass().getName());
            }
        } else if (obj == null) {
            throw new IllegalStateException("cannot find json property '" + "name" + '\'');
        } else {
            throw new IllegalArgumentException("json property '" + "name" + "' not of expected type, found " + obj.getClass().getName());
        }
    }

    public final r1 g(Map map, String str) {
        List<Map> list;
        Map map2;
        List<Map> list2;
        List<Map> list3;
        String str2;
        String str3;
        Map map3;
        List<Map> list4;
        List list5;
        Map map4;
        String str4;
        Map map5 = map;
        r1 r1Var = r2;
        r1 r1Var2 = new r1(str, this.f18972a, (List) null, (Set) null, (List) null, (y2) null, (c2) null, (Throwable) null, (Collection) null, (q3) null, (List) null, (k4) null, (Set) null, 8188, (DefaultConstructorMarker) null);
        Object obj = map5.get("exceptions");
        Long l10 = null;
        if (obj instanceof List) {
            list = (List) obj;
        } else {
            list = null;
        }
        if (list != null) {
            Collection j10 = r1Var.j();
            for (Map d10 : list) {
                j10.add(new k1(d(d10), this.f18972a));
            }
            List list6 = (List) j10;
        }
        Object obj2 = map5.get("user");
        if (obj2 instanceof Map) {
            k4 h10 = h((Map) obj2);
            r1 r1Var3 = r1Var;
            r1Var3.D(h10);
            Object obj3 = map5.get("metaData");
            if (obj3 instanceof Map) {
                map2 = (Map) obj3;
            } else {
                map2 = null;
            }
            if (map2 == null) {
                map2 = i0.f();
            }
            for (Map.Entry entry : map2.entrySet()) {
                r1Var3.c((String) entry.getKey(), (Map) entry.getValue());
            }
            Object obj4 = map5.get("featureFlags");
            if (obj4 instanceof List) {
                list2 = (List) obj4;
            } else {
                list2 = null;
            }
            if (list2 == null) {
                list2 = r.l();
            }
            for (Map map6 : list2) {
                Object obj5 = map6.get("featureFlag");
                if (obj5 instanceof String) {
                    String str5 = (String) obj5;
                    Object obj6 = map6.get("variant");
                    if (obj6 instanceof String) {
                        str4 = (String) obj6;
                    } else {
                        str4 = null;
                    }
                    r1Var3.a(str5, str4);
                } else if (obj5 == null) {
                    throw new IllegalStateException("cannot find json property '" + "featureFlag" + '\'');
                } else {
                    throw new IllegalArgumentException("json property '" + "featureFlag" + "' not of expected type, found " + obj5.getClass().getName());
                }
            }
            Object obj7 = map5.get("breadcrumbs");
            if (obj7 instanceof List) {
                list3 = (List) obj7;
            } else {
                list3 = null;
            }
            if (list3 == null) {
                list3 = r.l();
            }
            Collection g10 = r1Var3.g();
            for (Map b10 : list3) {
                g10.add(new Breadcrumb(b(b10), this.f18972a));
            }
            Object obj8 = map5.get("context");
            if (obj8 instanceof String) {
                str2 = (String) obj8;
            } else {
                str2 = null;
            }
            r1Var3.v(str2);
            Object obj9 = map5.get("groupingHash");
            if (obj9 instanceof String) {
                str3 = (String) obj9;
            } else {
                str3 = null;
            }
            r1Var3.x(str3);
            Object obj10 = map5.get("app");
            if (obj10 instanceof Map) {
                r1Var3.t(a((Map) obj10));
                Object obj11 = map5.get("device");
                if (obj11 instanceof Map) {
                    r1Var3.w(c((Map) obj11));
                    Object obj12 = map5.get("session");
                    if (obj12 instanceof Map) {
                        map3 = (Map) obj12;
                    } else {
                        map3 = null;
                    }
                    if (map3 != null) {
                        r1Var3.f18961i = new l3(map3, this.f18972a, str);
                        Unit unit = Unit.f12577a;
                    }
                    Object obj13 = map5.get("threads");
                    if (obj13 instanceof List) {
                        list4 = (List) obj13;
                    } else {
                        list4 = null;
                    }
                    if (list4 != null) {
                        Collection o10 = r1Var3.o();
                        for (Map f10 : list4) {
                            o10.add(new a4(f(f10), this.f18972a));
                        }
                        List list7 = (List) o10;
                    }
                    Object obj14 = map5.get("projectPackages");
                    if (obj14 instanceof List) {
                        list5 = (List) obj14;
                    } else {
                        list5 = null;
                    }
                    if (list5 != null) {
                        r1Var3.z(list5);
                        Unit unit2 = Unit.f12577a;
                    }
                    Object obj15 = map5.get("severity");
                    if (obj15 instanceof String) {
                        Severity a10 = Severity.Companion.a((String) obj15);
                        Object obj16 = map5.get("unhandled");
                        if (obj16 instanceof Boolean) {
                            r1Var3.H(i(map5, ((Boolean) obj16).booleanValue(), a10));
                            r1Var3.r();
                            r1Var3.y(new c1.m(c0.d(map5.get("usage"))));
                            Object obj17 = map5.get("correlation");
                            if (obj17 instanceof Map) {
                                map4 = (Map) obj17;
                            } else {
                                map4 = null;
                            }
                            if (map4 != null) {
                                UUID j11 = j((String) map4.get("traceId"));
                                String str6 = (String) map4.get("spanId");
                                if (str6 != null) {
                                    l10 = k(str6);
                                }
                                if (!(j11 == null || l10 == null)) {
                                    r1Var3.B(new h4(j11, l10.longValue()));
                                }
                                Unit unit3 = Unit.f12577a;
                            }
                            return r1Var3;
                        } else if (obj16 == null) {
                            throw new IllegalStateException("cannot find json property '" + "unhandled" + '\'');
                        } else {
                            throw new IllegalArgumentException("json property '" + "unhandled" + "' not of expected type, found " + obj16.getClass().getName());
                        }
                    } else if (obj15 == null) {
                        throw new IllegalStateException("cannot find json property '" + "severity" + '\'');
                    } else {
                        throw new IllegalArgumentException("json property '" + "severity" + "' not of expected type, found " + obj15.getClass().getName());
                    }
                } else if (obj11 == null) {
                    throw new IllegalStateException("cannot find json property '" + "device" + '\'');
                } else {
                    throw new IllegalArgumentException("json property '" + "device" + "' not of expected type, found " + obj11.getClass().getName());
                }
            } else if (obj10 == null) {
                throw new IllegalStateException("cannot find json property '" + "app" + '\'');
            } else {
                throw new IllegalArgumentException("json property '" + "app" + "' not of expected type, found " + obj10.getClass().getName());
            }
        } else if (obj2 == null) {
            throw new IllegalStateException("cannot find json property '" + "user" + '\'');
        } else {
            throw new IllegalArgumentException("json property '" + "user" + "' not of expected type, found " + obj2.getClass().getName());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.bugsnag.android.k4 h(java.util.Map r6) {
        /*
            r5 = this;
            com.bugsnag.android.k4 r0 = new com.bugsnag.android.k4
            java.lang.String r1 = "id"
            java.lang.Object r1 = r6.get(r1)
            boolean r2 = r1 instanceof java.lang.String
            r3 = 0
            if (r2 == 0) goto L_0x0010
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0011
        L_0x0010:
            r1 = r3
        L_0x0011:
            java.lang.String r2 = "email"
            java.lang.Object r2 = r6.get(r2)
            boolean r4 = r2 instanceof java.lang.String
            if (r4 == 0) goto L_0x001e
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x001f
        L_0x001e:
            r2 = r3
        L_0x001f:
            java.lang.String r4 = "name"
            java.lang.Object r6 = r6.get(r4)
            boolean r4 = r6 instanceof java.lang.String
            if (r4 == 0) goto L_0x002c
            r3 = r6
            java.lang.String r3 = (java.lang.String) r3
        L_0x002c:
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.s.h(java.util.Map):com.bugsnag.android.k4");
    }

    public final q3 i(Map map, boolean z10, Severity severity) {
        boolean z11;
        Map.Entry entry;
        String str;
        Set entrySet;
        Object obj = map.get("severityReason");
        if (obj instanceof Map) {
            Map map2 = (Map) obj;
            Object obj2 = map2.get("unhandledOverridden");
            if (obj2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                Object obj3 = map2.get("type");
                if (obj3 instanceof String) {
                    String str2 = (String) obj3;
                    boolean z12 = true;
                    if (!booleanValue) {
                        z11 = z10;
                    } else if (!z10) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    Object obj4 = map2.get("attributes");
                    if (obj4 != null) {
                        z12 = obj4 instanceof Map;
                    }
                    if (z12) {
                        Map map3 = (Map) obj4;
                        String str3 = null;
                        if (map3 == null || (entrySet = map3.entrySet()) == null) {
                            entry = null;
                        } else {
                            entry = (Map.Entry) r.p0(entrySet);
                        }
                        if (entry == null) {
                            str = null;
                        } else {
                            str = (String) entry.getValue();
                        }
                        if (entry != null) {
                            str3 = (String) entry.getKey();
                        }
                        return new q3(str2, severity, z10, z11, str, str3);
                    } else if (obj4 == null) {
                        throw new IllegalStateException("cannot find json property '" + "attributes" + '\'');
                    } else {
                        throw new IllegalArgumentException("json property '" + "attributes" + "' not of expected type, found " + obj4.getClass().getName());
                    }
                } else if (obj3 == null) {
                    throw new IllegalStateException("cannot find json property '" + "type" + '\'');
                } else {
                    throw new IllegalArgumentException("json property '" + "type" + "' not of expected type, found " + obj3.getClass().getName());
                }
            } else if (obj2 == null) {
                throw new IllegalStateException("cannot find json property '" + "unhandledOverridden" + '\'');
            } else {
                throw new IllegalArgumentException("json property '" + "unhandledOverridden" + "' not of expected type, found " + obj2.getClass().getName());
            }
        } else if (obj == null) {
            throw new IllegalStateException("cannot find json property '" + "severityReason" + '\'');
        } else {
            throw new IllegalArgumentException("json property '" + "severityReason" + "' not of expected type, found " + obj.getClass().getName());
        }
    }
}
