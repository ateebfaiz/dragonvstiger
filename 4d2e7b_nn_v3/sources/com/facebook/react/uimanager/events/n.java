package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.f1;
import com.facebook.react.uimanager.g0;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class n extends d {

    /* renamed from: g  reason: collision with root package name */
    private static final String f3619g = "n";

    /* renamed from: h  reason: collision with root package name */
    private static final Pools.SynchronizedPool f3620h = new Pools.SynchronizedPool(6);

    /* renamed from: a  reason: collision with root package name */
    private MotionEvent f3621a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f3622b;

    /* renamed from: c  reason: collision with root package name */
    private short f3623c = -1;

    /* renamed from: d  reason: collision with root package name */
    private List f3624d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public b f3625e;

    /* renamed from: f  reason: collision with root package name */
    private d.b f3626f;

    class a implements d.b {
        a() {
        }

        public boolean a(int i10, String str) {
            if (!str.equals(n.this.f3622b)) {
                return false;
            }
            if (o.f(str)) {
                for (f1.b b10 : n.this.f3625e.e()) {
                    if (b10.b() == i10) {
                        return true;
                    }
                }
                return false;
            } else if (n.this.getViewTag() == i10) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f3628a;

        /* renamed from: b  reason: collision with root package name */
        private int f3629b;

        /* renamed from: c  reason: collision with root package name */
        private int f3630c;

        /* renamed from: d  reason: collision with root package name */
        private int f3631d;

        /* renamed from: e  reason: collision with root package name */
        private Map f3632e;

        /* renamed from: f  reason: collision with root package name */
        private Map f3633f;

        /* renamed from: g  reason: collision with root package name */
        private Map f3634g;

        /* renamed from: h  reason: collision with root package name */
        private Map f3635h;

        /* renamed from: i  reason: collision with root package name */
        private Set f3636i;

        public b(int i10, int i11, int i12, int i13, Map map, Map map2, Map map3, Map map4, Set set) {
            this.f3628a = i10;
            this.f3629b = i11;
            this.f3630c = i12;
            this.f3631d = i13;
            this.f3632e = map;
            this.f3633f = map2;
            this.f3634g = map3;
            this.f3635h = map4;
            this.f3636i = new HashSet(set);
        }

        public int b() {
            return this.f3629b;
        }

        public final Map c() {
            return this.f3634g;
        }

        public final Map d() {
            return this.f3633f;
        }

        public final List e() {
            return (List) this.f3633f.get(Integer.valueOf(this.f3629b));
        }

        public Set f() {
            return this.f3636i;
        }

        public int g() {
            return this.f3630c;
        }

        public final Map h() {
            return this.f3632e;
        }

        public int i() {
            return this.f3628a;
        }

        public final Map j() {
            return this.f3635h;
        }

        public int k() {
            return this.f3631d;
        }

        public boolean l(int i10) {
            return this.f3636i.contains(Integer.valueOf(i10));
        }
    }

    private n() {
    }

    private void c(WritableMap writableMap, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if ((i10 & 4096) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        writableMap.putBoolean("ctrlKey", z10);
        if ((i10 & 1) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        writableMap.putBoolean("shiftKey", z11);
        if ((i10 & 2) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        writableMap.putBoolean("altKey", z12);
        if ((i10 & 65536) != 0) {
            z13 = true;
        }
        writableMap.putBoolean("metaKey", z13);
    }

    private List d() {
        int actionIndex = this.f3621a.getActionIndex();
        String str = this.f3622b;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1786514288:
                if (str.equals("topPointerEnter")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1780335505:
                if (str.equals("topPointerLeave")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1304584214:
                if (str.equals("topPointerDown")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1304316135:
                if (str.equals("topPointerMove")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1304250340:
                if (str.equals("topPointerOver")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1065042973:
                if (str.equals("topPointerUp")) {
                    c10 = 5;
                    break;
                }
                break;
            case -992108237:
                if (str.equals("topClick")) {
                    c10 = 6;
                    break;
                }
                break;
            case 383186882:
                if (str.equals("topPointerCancel")) {
                    c10 = 7;
                    break;
                }
                break;
            case 1343400710:
                if (str.equals("topPointerOut")) {
                    c10 = 8;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 8:
                return Arrays.asList(new WritableMap[]{e(actionIndex)});
            case 3:
            case 7:
                return f();
            default:
                return null;
        }
    }

    private WritableMap e(int i10) {
        boolean z10;
        double d10;
        WritableMap createMap = Arguments.createMap();
        int pointerId = this.f3621a.getPointerId(i10);
        createMap.putDouble("pointerId", (double) pointerId);
        String e10 = o.e(this.f3621a.getToolType(i10));
        createMap.putString("pointerType", e10);
        if (h() || (!this.f3625e.l(pointerId) && pointerId != this.f3625e.f3628a)) {
            z10 = false;
        } else {
            z10 = true;
        }
        createMap.putBoolean("isPrimary", z10);
        float[] fArr = (float[]) this.f3625e.c().get(Integer.valueOf(pointerId));
        double b10 = (double) g0.b(fArr[0]);
        double b11 = (double) g0.b(fArr[1]);
        createMap.putDouble("clientX", b10);
        createMap.putDouble("clientY", b11);
        float[] fArr2 = (float[]) this.f3625e.j().get(Integer.valueOf(pointerId));
        createMap.putDouble("screenX", (double) g0.b(fArr2[0]));
        createMap.putDouble("screenY", (double) g0.b(fArr2[1]));
        createMap.putDouble("x", b10);
        createMap.putDouble("y", b11);
        createMap.putDouble("pageX", b10);
        createMap.putDouble("pageY", b11);
        float[] fArr3 = (float[]) this.f3625e.h().get(Integer.valueOf(pointerId));
        createMap.putDouble("offsetX", (double) g0.b(fArr3[0]));
        createMap.putDouble("offsetY", (double) g0.b(fArr3[1]));
        createMap.putInt("target", getViewTag());
        createMap.putDouble("timestamp", (double) getTimestampMs());
        createMap.putInt("detail", 0);
        createMap.putDouble("tiltX", 0.0d);
        createMap.putDouble("tiltY", 0.0d);
        createMap.putInt("twist", 0);
        if (e10.equals("mouse") || h()) {
            createMap.putDouble(Snapshot.WIDTH, 1.0d);
            createMap.putDouble(Snapshot.HEIGHT, 1.0d);
        } else {
            double b12 = (double) g0.b(this.f3621a.getTouchMajor(i10));
            createMap.putDouble(Snapshot.WIDTH, b12);
            createMap.putDouble(Snapshot.HEIGHT, b12);
        }
        int buttonState = this.f3621a.getButtonState();
        createMap.putInt("button", o.a(e10, this.f3625e.g(), buttonState));
        createMap.putInt("buttons", o.b(this.f3622b, e10, buttonState));
        if (h()) {
            d10 = 0.0d;
        } else {
            d10 = o.d(createMap.getInt("buttons"), this.f3622b);
        }
        createMap.putDouble("pressure", d10);
        createMap.putDouble("tangentialPressure", 0.0d);
        c(createMap, this.f3621a.getMetaState());
        return createMap;
    }

    private List f() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f3621a.getPointerCount(); i10++) {
            arrayList.add(e(i10));
        }
        return arrayList;
    }

    private void g(String str, int i10, b bVar, MotionEvent motionEvent, short s10) {
        super.init(bVar.k(), i10, motionEvent.getEventTime());
        this.f3622b = str;
        this.f3621a = MotionEvent.obtain(motionEvent);
        this.f3623c = s10;
        this.f3625e = bVar;
    }

    private boolean h() {
        return this.f3622b.equals("topClick");
    }

    public static n i(String str, int i10, b bVar, MotionEvent motionEvent) {
        n nVar = (n) f3620h.acquire();
        if (nVar == null) {
            nVar = new n();
        }
        nVar.g(str, i10, bVar, (MotionEvent) p5.a.c(motionEvent), 0);
        return nVar;
    }

    public static n j(String str, int i10, b bVar, MotionEvent motionEvent, short s10) {
        n nVar = (n) f3620h.acquire();
        if (nVar == null) {
            nVar = new n();
        }
        nVar.g(str, i10, bVar, (MotionEvent) p5.a.c(motionEvent), s10);
        return nVar;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        if (this.f3621a == null) {
            ReactSoftExceptionLogger.logSoftException(f3619g, new IllegalStateException("Cannot dispatch a Pointer that has no MotionEvent; the PointerEvehas been recycled"));
            return;
        }
        if (this.f3624d == null) {
            this.f3624d = d();
        }
        List list = this.f3624d;
        if (list != null) {
            boolean z10 = true;
            if (list.size() <= 1) {
                z10 = false;
            }
            for (WritableMap writableMap : this.f3624d) {
                if (z10) {
                    writableMap = writableMap.copy();
                }
                rCTEventEmitter.receiveEvent(getViewTag(), this.f3622b, writableMap);
            }
        }
    }

    public void dispatchModern(RCTModernEventEmitter rCTModernEventEmitter) {
        boolean z10;
        boolean z11;
        if (this.f3621a == null) {
            ReactSoftExceptionLogger.logSoftException(f3619g, new IllegalStateException("Cannot dispatch a Pointer that has no MotionEvent; the PointerEvehas been recycled"));
            return;
        }
        if (this.f3624d == null) {
            this.f3624d = d();
        }
        List list = this.f3624d;
        if (list != null) {
            if (list.size() > 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            for (WritableMap writableMap : this.f3624d) {
                if (z10) {
                    writableMap = writableMap.copy();
                }
                WritableMap writableMap2 = writableMap;
                int surfaceId = getSurfaceId();
                int viewTag = getViewTag();
                String str = this.f3622b;
                short s10 = this.f3623c;
                if (s10 != -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                rCTModernEventEmitter.receiveEvent(surfaceId, viewTag, str, z11, s10, writableMap2, o.c(str));
            }
        }
    }

    public short getCoalescingKey() {
        return this.f3623c;
    }

    public d.b getEventAnimationDriverMatchSpec() {
        if (this.f3626f == null) {
            this.f3626f = new a();
        }
        return this.f3626f;
    }

    public String getEventName() {
        return this.f3622b;
    }

    public void onDispose() {
        this.f3624d = null;
        MotionEvent motionEvent = this.f3621a;
        this.f3621a = null;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        try {
            f3620h.release(this);
        } catch (IllegalStateException e10) {
            ReactSoftExceptionLogger.logSoftException(f3619g, e10);
        }
    }
}
