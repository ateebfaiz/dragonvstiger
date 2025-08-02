package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.events.i;
import com.facebook.react.uimanager.k1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class p implements i {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray f2834a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray f2835b = new SparseArray();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray f2836c = new SparseArray();

    /* renamed from: d  reason: collision with root package name */
    private final List f2837d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final ReactApplicationContext f2838e;

    /* renamed from: f  reason: collision with root package name */
    private int f2839f = 0;

    /* renamed from: g  reason: collision with root package name */
    private final List f2840g = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    private boolean f2841h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2842i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2843j = false;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f2844a;

        a(d dVar) {
            this.f2844a = dVar;
        }

        public void run() {
            p.this.m(this.f2844a);
        }
    }

    public p(ReactApplicationContext reactApplicationContext) {
        this.f2838e = reactApplicationContext;
    }

    private void B(List list) {
        String str;
        int i10;
        int i11 = this.f2839f;
        int i12 = i11 + 1;
        this.f2839f = i12;
        if (i12 == 0) {
            this.f2839f = i11 + 2;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        Iterator it = list.iterator();
        int i13 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            int i14 = bVar.f2777c;
            int i15 = this.f2839f;
            if (i14 != i15) {
                bVar.f2777c = i15;
                i13++;
                arrayDeque.add(bVar);
            }
        }
        while (!arrayDeque.isEmpty()) {
            b bVar2 = (b) arrayDeque.poll();
            if (bVar2.f2775a != null) {
                for (int i16 = 0; i16 < bVar2.f2775a.size(); i16++) {
                    b bVar3 = (b) bVar2.f2775a.get(i16);
                    bVar3.f2776b++;
                    int i17 = bVar3.f2777c;
                    int i18 = this.f2839f;
                    if (i17 != i18) {
                        bVar3.f2777c = i18;
                        i13++;
                        arrayDeque.add(bVar3);
                    }
                }
            }
        }
        int i19 = this.f2839f;
        int i20 = i19 + 1;
        this.f2839f = i20;
        if (i20 == 0) {
            this.f2839f = i19 + 2;
        }
        Iterator it2 = list.iterator();
        int i21 = 0;
        while (it2.hasNext()) {
            b bVar4 = (b) it2.next();
            if (bVar4.f2776b == 0 && bVar4.f2777c != (i10 = this.f2839f)) {
                bVar4.f2777c = i10;
                i21++;
                arrayDeque.add(bVar4);
            }
        }
        int i22 = 0;
        while (!arrayDeque.isEmpty()) {
            b bVar5 = (b) arrayDeque.poll();
            try {
                bVar5.h();
                if (bVar5 instanceof r) {
                    ((r) bVar5).m();
                }
            } catch (JSApplicationCausedNativeException e10) {
                z2.a.k("NativeAnimatedNodesManager", "Native animation workaround, frame lost as result of race condition", e10);
            }
            if (bVar5 instanceof b0) {
                ((b0) bVar5).m();
            }
            if (bVar5.f2775a != null) {
                for (int i23 = 0; i23 < bVar5.f2775a.size(); i23++) {
                    b bVar6 = (b) bVar5.f2775a.get(i23);
                    int i24 = bVar6.f2776b - 1;
                    bVar6.f2776b = i24;
                    int i25 = bVar6.f2777c;
                    int i26 = this.f2839f;
                    if (i25 != i26 && i24 == 0) {
                        bVar6.f2777c = i26;
                        i21++;
                        arrayDeque.add(bVar6);
                    } else if (i25 == i26) {
                        i22++;
                    }
                }
            }
        }
        if (i13 == i21) {
            this.f2843j = false;
        } else if (!this.f2843j) {
            this.f2843j = true;
            z2.a.j("NativeAnimatedNodesManager", "Detected animation cycle or disconnected graph. ");
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                z2.a.j("NativeAnimatedNodesManager", ((b) it3.next()).f());
            }
            if (i22 > 0) {
                str = "cycles (" + i22 + ")";
            } else {
                str = "disconnected regions";
            }
            IllegalStateException illegalStateException = new IllegalStateException("Looks like animated nodes graph has " + str + ", there are " + i13 + " but toposort visited only " + i21);
            boolean z10 = this.f2841h;
            if (z10 && i22 == 0) {
                ReactSoftExceptionLogger.logSoftException("NativeAnimatedNodesManager", new ReactNoCrashSoftException((Throwable) illegalStateException));
            } else if (z10) {
                ReactSoftExceptionLogger.logSoftException("NativeAnimatedNodesManager", new ReactNoCrashSoftException((Throwable) illegalStateException));
            } else {
                throw illegalStateException;
            }
        }
    }

    /* access modifiers changed from: private */
    public void m(d dVar) {
        ReactApplicationContext reactApplicationContext;
        if (!this.f2837d.isEmpty() && (reactApplicationContext = this.f2838e) != null && k1.g(reactApplicationContext, i7.a.b(dVar.getViewTag(), dVar.getSurfaceId())) != null) {
            d.b eventAnimationDriverMatchSpec = dVar.getEventAnimationDriverMatchSpec();
            boolean z10 = false;
            for (EventAnimationDriver eventAnimationDriver : this.f2837d) {
                if (eventAnimationDriverMatchSpec.a(eventAnimationDriver.mViewTag, eventAnimationDriver.mEventName)) {
                    y(eventAnimationDriver.mValueNode);
                    dVar.dispatchModern(eventAnimationDriver);
                    this.f2840g.add(eventAnimationDriver.mValueNode);
                    z10 = true;
                }
            }
            if (z10) {
                B(this.f2840g);
                this.f2840g.clear();
            }
        }
    }

    private String p(String str) {
        if (!str.startsWith("on")) {
            return str;
        }
        return "top" + str.substring(2);
    }

    private void y(b bVar) {
        WritableArray writableArray = null;
        int i10 = 0;
        while (i10 < this.f2835b.size()) {
            e eVar = (e) this.f2835b.valueAt(i10);
            if (bVar.equals(eVar.f2783b)) {
                if (eVar.f2784c != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    createMap.putDouble("value", eVar.f2783b.f2779e);
                    eVar.f2784c.invoke(createMap);
                } else if (this.f2838e != null) {
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putInt("animationId", eVar.f2785d);
                    createMap2.putBoolean("finished", false);
                    createMap2.putDouble("value", eVar.f2783b.f2779e);
                    if (writableArray == null) {
                        writableArray = Arguments.createArray();
                    }
                    writableArray.pushMap(createMap2);
                }
                this.f2835b.removeAt(i10);
                i10--;
            }
            i10++;
        }
        if (writableArray != null) {
            this.f2838e.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArray);
        }
    }

    public void A(int i10, ReadableMap readableMap) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null) {
            throw new JSApplicationIllegalArgumentException("updateAnimatedNode: Animated node [" + i10 + "] does not exist");
        } else if (bVar instanceof d) {
            y(bVar);
            ((d) bVar).a(readableMap);
            this.f2836c.put(i10, bVar);
        }
    }

    public void b(int i10, String str, ReadableMap readableMap) {
        int i11 = readableMap.getInt("animatedValueTag");
        b bVar = (b) this.f2834a.get(i11);
        if (bVar == null) {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node with tag [" + i11 + "] does not exist");
        } else if (bVar instanceof b0) {
            ReadableArray array = readableMap.getArray("nativeEventPath");
            ArrayList arrayList = new ArrayList(array.size());
            for (int i12 = 0; i12 < array.size(); i12++) {
                arrayList.add(array.getString(i12));
            }
            this.f2837d.add(new EventAnimationDriver(p(str), i10, arrayList, (b0) bVar));
        } else {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node on view [" + i10 + "] connected to event handler (" + str + ") should be of type " + b0.class.getName());
        }
    }

    public void c(int i10, int i11) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node with tag [" + i10 + "] does not exist");
        } else if (bVar instanceof r) {
            ReactApplicationContext reactApplicationContext = this.f2838e;
            if (reactApplicationContext != null) {
                UIManager i12 = k1.i(reactApplicationContext, i11);
                if (i12 == null) {
                    ReactSoftExceptionLogger.logSoftException("NativeAnimatedNodesManager", new ReactNoCrashSoftException("connectAnimatedNodeToView: Animated node could not be connected to UIManager - uiManager disappeared for tag: " + i11));
                    return;
                }
                ((r) bVar).i(i11, i12);
                this.f2836c.put(i10, bVar);
                return;
            }
            throw new IllegalStateException("connectAnimatedNodeToView: Animated node could not be connected, no ReactApplicationContext: " + i11);
        } else {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node connected to view [" + i11 + "] should be of type " + r.class.getName());
        }
    }

    public void d(int i10, int i11) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar != null) {
            b bVar2 = (b) this.f2834a.get(i11);
            if (bVar2 != null) {
                bVar.b(bVar2);
                this.f2836c.put(i11, bVar2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (child) [" + i11 + "] does not exist");
        }
        throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (parent) [" + i10 + "] does not exist");
    }

    public void e(int i10, ReadableMap readableMap) {
        b bVar;
        if (this.f2834a.get(i10) == null) {
            String string = readableMap.getString("type");
            if ("style".equals(string)) {
                bVar = new u(readableMap, this);
            } else if ("value".equals(string)) {
                bVar = new b0(readableMap);
            } else if ("color".equals(string)) {
                bVar = new f(readableMap, this, this.f2838e);
            } else if ("props".equals(string)) {
                bVar = new r(readableMap, this);
            } else if ("interpolation".equals(string)) {
                bVar = new k(readableMap);
            } else if ("addition".equals(string)) {
                bVar = new a(readableMap, this);
            } else if ("subtraction".equals(string)) {
                bVar = new v(readableMap, this);
            } else if ("division".equals(string)) {
                bVar = new i(readableMap, this);
            } else if ("multiplication".equals(string)) {
                bVar = new m(readableMap, this);
            } else if ("modulus".equals(string)) {
                bVar = new l(readableMap, this);
            } else if ("diffclamp".equals(string)) {
                bVar = new h(readableMap, this);
            } else if ("transform".equals(string)) {
                bVar = new y(readableMap, this);
            } else if ("tracking".equals(string)) {
                bVar = new w(readableMap, this);
            } else if ("object".equals(string)) {
                bVar = new q(readableMap, this);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
            }
            bVar.f2778d = i10;
            this.f2834a.put(i10, bVar);
            this.f2836c.put(i10, bVar);
            return;
        }
        throw new JSApplicationIllegalArgumentException("createAnimatedNode: Animated node [" + i10 + "] already exists");
    }

    public void f(int i10, int i11) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node with tag [" + i10 + "] does not exist");
        } else if (bVar instanceof r) {
            ((r) bVar).j(i11);
        } else {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node connected to view [" + i11 + "] should be of type " + r.class.getName());
        }
    }

    public void g(int i10, int i11) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar != null) {
            b bVar2 = (b) this.f2834a.get(i11);
            if (bVar2 != null) {
                bVar.g(bVar2);
                this.f2836c.put(i11, bVar2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (child) [" + i11 + "] does not exist");
        }
        throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (parent) [" + i10 + "] does not exist");
    }

    public void h(int i10) {
        this.f2834a.remove(i10);
        this.f2836c.remove(i10);
    }

    public void i(int i10) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null || !(bVar instanceof b0)) {
            throw new JSApplicationIllegalArgumentException("extractAnimatedNodeOffset: Animated node [" + i10 + "] does not exist, or is not a 'value' node");
        }
        ((b0) bVar).i();
    }

    public void j(int i10) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null || !(bVar instanceof b0)) {
            throw new JSApplicationIllegalArgumentException("flattenAnimatedNodeOffset: Animated node [" + i10 + "] does not exist, or is not a 'value' node");
        }
        ((b0) bVar).j();
    }

    public b k(int i10) {
        return (b) this.f2834a.get(i10);
    }

    public void l(int i10, Callback callback) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null || !(bVar instanceof b0)) {
            throw new JSApplicationIllegalArgumentException("getValue: Animated node with tag [" + i10 + "] does not exist or is not a 'value' node");
        }
        double l10 = ((b0) bVar).l();
        if (callback != null) {
            callback.invoke(Double.valueOf(l10));
        } else if (this.f2838e != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("tag", i10);
            createMap.putDouble("value", l10);
            this.f2838e.emitDeviceEvent("onNativeAnimatedModuleGetValue", createMap);
        }
    }

    public boolean n() {
        if (this.f2835b.size() > 0 || this.f2836c.size() > 0) {
            return true;
        }
        return false;
    }

    public void o(int i10) {
        if (i10 == 2) {
            if (this.f2841h) {
                return;
            }
        } else if (this.f2842i) {
            return;
        }
        UIManager g10 = k1.g(this.f2838e, i10);
        if (g10 != null) {
            ((e) g10.getEventDispatcher()).b(this);
            if (i10 == 2) {
                this.f2841h = true;
            } else {
                this.f2842i = true;
            }
        }
    }

    public void onEventDispatch(d dVar) {
        if (UiThreadUtil.isOnUiThread()) {
            m(dVar);
        } else {
            UiThreadUtil.runOnUiThread(new a(dVar));
        }
    }

    public void q(int i10, String str, int i11) {
        String p10 = p(str);
        ListIterator listIterator = this.f2837d.listIterator();
        while (listIterator.hasNext()) {
            EventAnimationDriver eventAnimationDriver = (EventAnimationDriver) listIterator.next();
            if (p10.equals(eventAnimationDriver.mEventName) && i10 == eventAnimationDriver.mViewTag && i11 == eventAnimationDriver.mValueNode.f2778d) {
                listIterator.remove();
                return;
            }
        }
    }

    public void r(int i10) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar != null) {
            if (bVar instanceof r) {
                ((r) bVar).l();
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view [?] should be of type " + r.class.getName());
        }
    }

    public void s(long j10) {
        UiThreadUtil.assertOnUiThread();
        for (int i10 = 0; i10 < this.f2836c.size(); i10++) {
            this.f2840g.add((b) this.f2836c.valueAt(i10));
        }
        this.f2836c.clear();
        boolean z10 = false;
        for (int i11 = 0; i11 < this.f2835b.size(); i11++) {
            e eVar = (e) this.f2835b.valueAt(i11);
            eVar.b(j10);
            this.f2840g.add(eVar.f2783b);
            if (eVar.f2782a) {
                z10 = true;
            }
        }
        B(this.f2840g);
        this.f2840g.clear();
        if (z10) {
            WritableArray writableArray = null;
            for (int size = this.f2835b.size() - 1; size >= 0; size--) {
                e eVar2 = (e) this.f2835b.valueAt(size);
                if (eVar2.f2782a) {
                    if (eVar2.f2784c != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("finished", true);
                        createMap.putDouble("value", eVar2.f2783b.f2779e);
                        eVar2.f2784c.invoke(createMap);
                    } else if (this.f2838e != null) {
                        WritableMap createMap2 = Arguments.createMap();
                        createMap2.putInt("animationId", eVar2.f2785d);
                        createMap2.putBoolean("finished", true);
                        createMap2.putDouble("value", eVar2.f2783b.f2779e);
                        if (writableArray == null) {
                            writableArray = Arguments.createArray();
                        }
                        writableArray.pushMap(createMap2);
                    }
                    this.f2835b.removeAt(size);
                }
            }
            if (writableArray != null) {
                this.f2838e.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArray);
            }
        }
    }

    public void t(int i10, double d10) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null || !(bVar instanceof b0)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeOffset: Animated node [" + i10 + "] does not exist, or is not a 'value' node");
        }
        ((b0) bVar).f2780f = d10;
        this.f2836c.put(i10, bVar);
    }

    public void u(int i10, double d10) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null || !(bVar instanceof b0)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeValue: Animated node [" + i10 + "] does not exist, or is not a 'value' node");
        }
        y(bVar);
        ((b0) bVar).f2779e = d10;
        this.f2836c.put(i10, bVar);
    }

    public void v(int i10, int i11, ReadableMap readableMap, Callback callback) {
        e eVar;
        b bVar = (b) this.f2834a.get(i11);
        if (bVar == null) {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i11 + "] does not exist");
        } else if (bVar instanceof b0) {
            e eVar2 = (e) this.f2835b.get(i10);
            if (eVar2 != null) {
                eVar2.a(readableMap);
                return;
            }
            String string = readableMap.getString("type");
            if ("frames".equals(string)) {
                eVar = new j(readableMap);
            } else if ("spring".equals(string)) {
                eVar = new t(readableMap);
            } else if ("decay".equals(string)) {
                eVar = new g(readableMap);
            } else {
                throw new JSApplicationIllegalArgumentException("startAnimatingNode: Unsupported animation type [" + i11 + "]: " + string);
            }
            eVar.f2785d = i10;
            eVar.f2784c = callback;
            eVar.f2783b = (b0) bVar;
            this.f2835b.put(i10, eVar);
        } else {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i11 + "] should be of type " + b0.class.getName());
        }
    }

    public void w(int i10, c cVar) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null || !(bVar instanceof b0)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i10 + "] does not exist, or is not a 'value' node");
        }
        ((b0) bVar).n(cVar);
    }

    public void x(int i10) {
        WritableArray writableArray;
        int i11 = 0;
        while (true) {
            writableArray = null;
            if (i11 >= this.f2835b.size()) {
                break;
            }
            e eVar = (e) this.f2835b.valueAt(i11);
            if (eVar.f2785d == i10) {
                if (eVar.f2784c != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    createMap.putDouble("value", eVar.f2783b.f2779e);
                    eVar.f2784c.invoke(createMap);
                } else if (this.f2838e != null) {
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putInt("animationId", eVar.f2785d);
                    createMap2.putBoolean("finished", false);
                    createMap2.putDouble("value", eVar.f2783b.f2779e);
                    writableArray = Arguments.createArray();
                    writableArray.pushMap(createMap2);
                }
                this.f2835b.removeAt(i11);
            } else {
                i11++;
            }
        }
        if (writableArray != null) {
            this.f2838e.emitDeviceEvent("onNativeAnimatedModuleAnimationFinished", writableArray);
        }
    }

    public void z(int i10) {
        b bVar = (b) this.f2834a.get(i10);
        if (bVar == null || !(bVar instanceof b0)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i10 + "] does not exist, or is not a 'value' node");
        }
        ((b0) bVar).n((c) null);
    }
}
