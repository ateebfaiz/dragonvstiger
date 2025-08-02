package com.bugsnag.android.ndk;

import android.os.Build;
import c1.q;
import c1.s;
import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.NativeInterface;
import com.bugsnag.android.s2;
import com.bugsnag.android.v3;
import e1.b;
import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;
import kotlin.text.j;

public final class NativeBridge implements q {
    private final c1.a bgTaskService;
    private final AtomicBoolean installed = new AtomicBoolean(false);
    private final ReentrantLock lock = new ReentrantLock();
    private final s2 logger = NativeInterface.getLogger();
    private final File reportDirectory = NativeInterface.getNativeReportPath();

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18885a;

        static {
            int[] iArr = new int[BreadcrumbType.values().length];
            iArr[BreadcrumbType.ERROR.ordinal()] = 1;
            iArr[BreadcrumbType.LOG.ordinal()] = 2;
            iArr[BreadcrumbType.MANUAL.ordinal()] = 3;
            iArr[BreadcrumbType.NAVIGATION.ordinal()] = 4;
            iArr[BreadcrumbType.PROCESS.ordinal()] = 5;
            iArr[BreadcrumbType.REQUEST.ordinal()] = 6;
            iArr[BreadcrumbType.STATE.ordinal()] = 7;
            iArr[BreadcrumbType.USER.ordinal()] = 8;
            f18885a = iArr;
        }
    }

    public NativeBridge(c1.a aVar) {
        this.bgTaskService = aVar;
    }

    private final native void addBreadcrumb(String str, int i10, String str2, Object obj);

    private final void deliverPendingReports() {
        b bVar = new b(this.logger, (Collection) null, 2, (DefaultConstructorMarker) null);
        File[] listFiles = this.reportDirectory.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i10 = 0;
            while (i10 < length) {
                File file = listFiles[i10];
                i10++;
                if (bVar.a(file)) {
                    file.delete();
                } else {
                    NativeInterface.deliverReport(file);
                }
            }
        }
    }

    private final void handleAddMetadata(v3.c cVar) {
        if (cVar.f19047b != null) {
            Object c10 = OpaqueValue.f18886b.c(cVar.f19048c);
            if (c10 instanceof String) {
                String str = cVar.f19046a;
                String str2 = cVar.f19047b;
                m.c(str2);
                addMetadataString(str, str2, (String) c10);
            } else if (c10 instanceof Boolean) {
                String str3 = cVar.f19046a;
                String str4 = cVar.f19047b;
                m.c(str4);
                addMetadataBoolean(str3, str4, ((Boolean) c10).booleanValue());
            } else if (c10 instanceof Number) {
                String str5 = cVar.f19046a;
                String str6 = cVar.f19047b;
                m.c(str6);
                addMetadataDouble(str5, str6, ((Number) c10).doubleValue());
            } else if (c10 instanceof OpaqueValue) {
                String str7 = cVar.f19046a;
                String str8 = cVar.f19047b;
                m.c(str8);
                addMetadataOpaque(str7, str8, ((OpaqueValue) c10).getJson());
            }
        }
    }

    private final void handleInstallMessage(v3.i iVar) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.installed.get()) {
                this.logger.g(m.n("Received duplicate setup message with arg: ", iVar));
            } else {
                install(iVar.f19055a, this.reportDirectory.getAbsolutePath(), iVar.f19060f, UUID.randomUUID().toString(), iVar.f19061g, iVar.f19056b, Build.VERSION.SDK_INT, is32bit(), iVar.f19062h.ordinal(), iVar.f19063i);
                this.installed.set(true);
            }
            Unit unit = Unit.f12577a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private final boolean is32bit() {
        String[] cpuAbi = NativeInterface.getCpuAbi();
        int length = cpuAbi.length;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            String str = cpuAbi[i10];
            i10++;
            if (j.K(str, "64", false, 2, (Object) null)) {
                z10 = true;
                break;
            }
        }
        return !z10;
    }

    private final boolean isInvalidMessage(Object obj) {
        if (obj == null || !(obj instanceof v3)) {
            return true;
        }
        if (this.installed.get() || (obj instanceof v3.i)) {
            return false;
        }
        this.logger.g(m.n("Received message before INSTALL: ", obj));
        return true;
    }

    private final int toNativeValue(BreadcrumbType breadcrumbType) {
        switch (a.f18885a[breadcrumbType.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            default:
                throw new n();
        }
    }

    public final void addBreadcrumb(String str, String str2, String str3, Object obj) {
        BreadcrumbType breadcrumbType;
        BreadcrumbType[] values = BreadcrumbType.values();
        int length = values.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                breadcrumbType = null;
                break;
            }
            breadcrumbType = values[i10];
            i10++;
            if (m.b(breadcrumbType.toString(), str2)) {
                break;
            }
        }
        if (breadcrumbType == null) {
            breadcrumbType = BreadcrumbType.MANUAL;
        }
        addBreadcrumb(str, toNativeValue(breadcrumbType), str3, obj);
    }

    public final native void addFeatureFlag(String str, String str2);

    public final native void addHandledEvent();

    public final native void addMetadataBoolean(String str, String str2, boolean z10);

    public final native void addMetadataDouble(String str, String str2, double d10);

    public final native void addMetadataOpaque(String str, String str2, String str3);

    public final native void addMetadataString(String str, String str2, String str3);

    public final native void addUnhandledEvent();

    public final native void clearFeatureFlag(String str);

    public final native void clearFeatureFlags();

    public final native void clearMetadataTab(String str);

    public final native Map<String, Integer> getCurrentCallbackSetCounts();

    public final native Map<String, Boolean> getCurrentNativeApiCallUsage();

    public final native long getSignalUnwindStackFunction();

    public final native void initCallbackCounts(Map<String, Integer> map);

    public final native void install(String str, String str2, String str3, String str4, int i10, boolean z10, int i11, boolean z11, int i12, int i13);

    public final native void notifyAddCallback(String str);

    public final native void notifyRemoveCallback(String str);

    public void onStateChange(v3 v3Var) {
        if (!isInvalidMessage(v3Var)) {
            if (v3Var instanceof v3.i) {
                handleInstallMessage((v3.i) v3Var);
            } else if (v3Var instanceof v3.h) {
                deliverPendingReports();
            } else if (v3Var instanceof v3.c) {
                handleAddMetadata((v3.c) v3Var);
            } else if (v3Var instanceof v3.f) {
                clearMetadataTab(((v3.f) v3Var).f19051a);
            } else {
                String str = "";
                if (v3Var instanceof v3.g) {
                    v3.g gVar = (v3.g) v3Var;
                    String str2 = gVar.f19052a;
                    String str3 = gVar.f19053b;
                    if (str3 != null) {
                        str = str3;
                    }
                    removeMetadata(str2, str);
                } else if (v3Var instanceof v3.a) {
                    v3.a aVar = (v3.a) v3Var;
                    addBreadcrumb(aVar.f19040a, toNativeValue(aVar.f19041b), aVar.f19042c, (Object) aVar.f19043d);
                } else if (m.b(v3Var, v3.j.f19064a)) {
                    addHandledEvent();
                } else if (m.b(v3Var, v3.k.f19065a)) {
                    addUnhandledEvent();
                } else if (m.b(v3Var, v3.l.f19066a)) {
                    pausedSession();
                } else if (v3Var instanceof v3.m) {
                    v3.m mVar = (v3.m) v3Var;
                    startedSession(mVar.f19067a, mVar.f19068b, mVar.f19069c, mVar.a());
                } else if (v3Var instanceof v3.n) {
                    String str4 = ((v3.n) v3Var).f19071a;
                    if (str4 != null) {
                        str = str4;
                    }
                    updateContext(str);
                } else if (v3Var instanceof v3.o) {
                    v3.o oVar = (v3.o) v3Var;
                    boolean z10 = oVar.f19072a;
                    String a10 = oVar.a();
                    if (a10 != null) {
                        str = a10;
                    }
                    updateInForeground(z10, str);
                } else if (v3Var instanceof v3.p) {
                    v3.p pVar = (v3.p) v3Var;
                    updateIsLaunching(pVar.f19074a);
                    if (!pVar.f19074a) {
                        this.bgTaskService.d(s.DEFAULT, new e1.a(this));
                    }
                } else if (v3Var instanceof v3.r) {
                    String str5 = ((v3.r) v3Var).f19078a;
                    if (str5 != null) {
                        str = str5;
                    }
                    updateOrientation(str);
                } else if (v3Var instanceof v3.s) {
                    v3.s sVar = (v3.s) v3Var;
                    String b10 = sVar.f19079a.b();
                    if (b10 == null) {
                        b10 = str;
                    }
                    updateUserId(b10);
                    String c10 = sVar.f19079a.c();
                    if (c10 == null) {
                        c10 = str;
                    }
                    updateUserName(c10);
                    String a11 = sVar.f19079a.a();
                    if (a11 != null) {
                        str = a11;
                    }
                    updateUserEmail(str);
                } else if (v3Var instanceof v3.q) {
                    v3.q qVar = (v3.q) v3Var;
                    updateLowMemory(qVar.f19075a, qVar.f19077c);
                } else if (v3Var instanceof v3.b) {
                    v3.b bVar = (v3.b) v3Var;
                    addFeatureFlag(bVar.f19044a, bVar.f19045b);
                } else if (v3Var instanceof v3.d) {
                    clearFeatureFlag(((v3.d) v3Var).f19049a);
                } else if (v3Var instanceof v3.e) {
                    clearFeatureFlags();
                }
            }
        }
    }

    public final native void pausedSession();

    public final native void refreshSymbolTable();

    public final native void removeMetadata(String str, String str2);

    public final native void setInternalMetricsEnabled(boolean z10);

    public final native void setStaticJsonData(String str);

    public final native void startedSession(String str, String str2, int i10, int i11);

    public final native void updateContext(String str);

    public final native void updateInForeground(boolean z10, String str);

    public final native void updateIsLaunching(boolean z10);

    public final native void updateLastRunInfo(int i10);

    public final native void updateLowMemory(boolean z10, String str);

    public final native void updateOrientation(String str);

    public final native void updateUserEmail(String str);

    public final native void updateUserId(String str);

    public final native void updateUserName(String str);
}
