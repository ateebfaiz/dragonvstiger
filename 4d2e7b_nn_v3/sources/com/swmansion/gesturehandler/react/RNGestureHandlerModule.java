package com.swmansion.gesturehandler.react;

import ab.a0;
import ab.n;
import ab.o;
import ab.p;
import ab.r;
import ab.s;
import ab.v;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.g0;
import com.facebook.soloader.SoLoader;
import com.swmansion.gesturehandler.NativeRNGestureHandlerModuleSpec;
import com.swmansion.gesturehandler.react.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;

@s6.a(name = "RNGestureHandlerModule")
public final class RNGestureHandlerModule extends NativeRNGestureHandlerModuleSpec implements ya.a {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final String KEY_DIRECTION = "direction";
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_HIT_SLOP = "hitSlop";
    private static final String KEY_HIT_SLOP_BOTTOM = "bottom";
    private static final String KEY_HIT_SLOP_HEIGHT = "height";
    private static final String KEY_HIT_SLOP_HORIZONTAL = "horizontal";
    private static final String KEY_HIT_SLOP_LEFT = "left";
    private static final String KEY_HIT_SLOP_RIGHT = "right";
    private static final String KEY_HIT_SLOP_TOP = "top";
    private static final String KEY_HIT_SLOP_VERTICAL = "vertical";
    private static final String KEY_HIT_SLOP_WIDTH = "width";
    private static final String KEY_LONG_PRESS_MAX_DIST = "maxDist";
    private static final String KEY_LONG_PRESS_MIN_DURATION_MS = "minDurationMs";
    private static final String KEY_MANUAL_ACTIVATION = "manualActivation";
    private static final String KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION = "disallowInterruption";
    private static final String KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START = "shouldActivateOnStart";
    private static final String KEY_NEEDS_POINTER_DATA = "needsPointerData";
    private static final String KEY_NUMBER_OF_POINTERS = "numberOfPointers";
    private static final String KEY_PAN_ACTIVATE_AFTER_LONG_PRESS = "activateAfterLongPress";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_END = "activeOffsetXEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_X_START = "activeOffsetXStart";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_END = "activeOffsetYEnd";
    private static final String KEY_PAN_ACTIVE_OFFSET_Y_START = "activeOffsetYStart";
    private static final String KEY_PAN_AVG_TOUCHES = "avgTouches";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_END = "failOffsetXEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_X_START = "failOffsetXStart";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_END = "failOffsetYEnd";
    private static final String KEY_PAN_FAIL_OFFSET_RANGE_Y_START = "failOffsetYStart";
    private static final String KEY_PAN_MAX_POINTERS = "maxPointers";
    private static final String KEY_PAN_MIN_DIST = "minDist";
    private static final String KEY_PAN_MIN_POINTERS = "minPointers";
    private static final String KEY_PAN_MIN_VELOCITY = "minVelocity";
    private static final String KEY_PAN_MIN_VELOCITY_X = "minVelocityX";
    private static final String KEY_PAN_MIN_VELOCITY_Y = "minVelocityY";
    private static final String KEY_SHOULD_CANCEL_WHEN_OUTSIDE = "shouldCancelWhenOutside";
    private static final String KEY_TAP_MAX_DELAY_MS = "maxDelayMs";
    private static final String KEY_TAP_MAX_DELTA_X = "maxDeltaX";
    private static final String KEY_TAP_MAX_DELTA_Y = "maxDeltaY";
    private static final String KEY_TAP_MAX_DIST = "maxDist";
    private static final String KEY_TAP_MAX_DURATION_MS = "maxDurationMs";
    private static final String KEY_TAP_MIN_POINTERS = "minPointers";
    private static final String KEY_TAP_NUMBER_OF_TAPS = "numberOfTaps";
    public static final String NAME = "RNGestureHandlerModule";
    private final l eventListener = new l(this);
    private final c[] handlerFactories = {new g(), new k(), new e(), new h(), new i(), new j(), new b(), new f(), new d()};
    private final d interactionManager = new d();
    private final za.f reanimatedEventDispatcher = new za.f();
    private final g registry = new g();
    private final List<i> roots = new ArrayList();

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final void b(ab.d dVar, ReadableMap readableMap) {
            float f10;
            float f11;
            float f12;
            if (readableMap.getType(RNGestureHandlerModule.KEY_HIT_SLOP) == ReadableType.Number) {
                float c10 = g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP));
                dVar.x0(c10, c10, c10, c10, Float.NaN, Float.NaN);
                return;
            }
            ReadableMap map = readableMap.getMap(RNGestureHandlerModule.KEY_HIT_SLOP);
            m.c(map);
            float f13 = Float.NaN;
            if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL)) {
                f10 = g0.c(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HORIZONTAL));
            } else {
                f10 = Float.NaN;
            }
            float f14 = f10;
            if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL)) {
                f11 = g0.c(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_VERTICAL));
            } else {
                f11 = Float.NaN;
            }
            float f15 = f11;
            if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT)) {
                f10 = g0.c(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT));
            }
            float f16 = f10;
            if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_TOP)) {
                f11 = g0.c(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_TOP));
            }
            float f17 = f11;
            if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT)) {
                f14 = g0.c(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT));
            }
            float f18 = f14;
            if (map.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM)) {
                f15 = g0.c(map.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM));
            }
            float f19 = f15;
            if (map.hasKey("width")) {
                f12 = g0.c(map.getDouble("width"));
            } else {
                f12 = Float.NaN;
            }
            if (map.hasKey("height")) {
                f13 = g0.c(map.getDouble("height"));
            }
            dVar.x0(f16, f17, f18, f19, f12, f13);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f11376a = ab.b.class;

        /* renamed from: b  reason: collision with root package name */
        private final String f11377b = "FlingGestureHandler";

        public String d() {
            return this.f11377b;
        }

        public Class e() {
            return this.f11376a;
        }

        /* renamed from: f */
        public void a(ab.b bVar, ReadableMap readableMap) {
            m.f(bVar, "handler");
            m.f(readableMap, "config");
            super.a(bVar, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                bVar.X0(readableMap.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_DIRECTION)) {
                bVar.W0(readableMap.getInt(RNGestureHandlerModule.KEY_DIRECTION));
            }
        }

        /* renamed from: g */
        public ab.b b(Context context) {
            return new ab.b();
        }

        /* renamed from: h */
        public bb.a c(ab.b bVar) {
            m.f(bVar, "handler");
            return new bb.a(bVar);
        }
    }

    private static abstract class c {
        public void a(ab.d dVar, ReadableMap readableMap) {
            m.f(dVar, "handler");
            m.f(readableMap, "config");
            dVar.o0();
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE)) {
                dVar.E0(readableMap.getBoolean(RNGestureHandlerModule.KEY_SHOULD_CANCEL_WHEN_OUTSIDE));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_ENABLED)) {
                dVar.v0(readableMap.getBoolean(RNGestureHandlerModule.KEY_ENABLED));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP)) {
                RNGestureHandlerModule.Companion.b(dVar, readableMap);
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA)) {
                dVar.B0(readableMap.getBoolean(RNGestureHandlerModule.KEY_NEEDS_POINTER_DATA));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION)) {
                dVar.z0(readableMap.getBoolean(RNGestureHandlerModule.KEY_MANUAL_ACTIVATION));
            }
            if (readableMap.hasKey("mouseButton")) {
                dVar.A0(readableMap.getInt("mouseButton"));
            }
        }

        public abstract ab.d b(Context context);

        public abstract bb.b c(ab.d dVar);

        public abstract String d();

        public abstract Class e();
    }

    private static final class d extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f11378a = ab.k.class;

        /* renamed from: b  reason: collision with root package name */
        private final String f11379b = "HoverGestureHandler";

        public String d() {
            return this.f11379b;
        }

        public Class e() {
            return this.f11378a;
        }

        /* renamed from: f */
        public ab.k b(Context context) {
            return new ab.k();
        }

        /* renamed from: g */
        public bb.c c(ab.k kVar) {
            m.f(kVar, "handler");
            return new bb.c(kVar);
        }
    }

    private static final class e extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f11380a = ab.m.class;

        /* renamed from: b  reason: collision with root package name */
        private final String f11381b = "LongPressGestureHandler";

        public String d() {
            return this.f11381b;
        }

        public Class e() {
            return this.f11380a;
        }

        /* renamed from: f */
        public void a(ab.m mVar, ReadableMap readableMap) {
            m.f(mVar, "handler");
            m.f(readableMap, "config");
            super.a(mVar, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS)) {
                mVar.Y0((long) readableMap.getInt(RNGestureHandlerModule.KEY_LONG_PRESS_MIN_DURATION_MS));
            }
            if (readableMap.hasKey("maxDist")) {
                mVar.X0(g0.c(readableMap.getDouble("maxDist")));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS)) {
                mVar.Z0(readableMap.getInt(RNGestureHandlerModule.KEY_NUMBER_OF_POINTERS));
            }
        }

        /* renamed from: g */
        public ab.m b(Context context) {
            m.c(context);
            return new ab.m(context);
        }

        /* renamed from: h */
        public bb.d c(ab.m mVar) {
            m.f(mVar, "handler");
            return new bb.d(mVar);
        }
    }

    private static final class f extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f11382a = n.class;

        /* renamed from: b  reason: collision with root package name */
        private final String f11383b = "ManualGestureHandler";

        public String d() {
            return this.f11383b;
        }

        public Class e() {
            return this.f11382a;
        }

        /* renamed from: f */
        public n b(Context context) {
            return new n();
        }

        /* renamed from: g */
        public bb.e c(n nVar) {
            m.f(nVar, "handler");
            return new bb.e(nVar);
        }
    }

    private static final class g extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f11384a = o.class;

        /* renamed from: b  reason: collision with root package name */
        private final String f11385b = "NativeViewGestureHandler";

        public String d() {
            return this.f11385b;
        }

        public Class e() {
            return this.f11384a;
        }

        /* renamed from: f */
        public void a(o oVar, ReadableMap readableMap) {
            m.f(oVar, "handler");
            m.f(readableMap, "config");
            super.a(oVar, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START)) {
                oVar.U0(readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_SHOULD_ACTIVATE_ON_START));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION)) {
                oVar.T0(readableMap.getBoolean(RNGestureHandlerModule.KEY_NATIVE_VIEW_DISALLOW_INTERRUPTION));
            }
        }

        /* renamed from: g */
        public o b(Context context) {
            return new o();
        }

        /* renamed from: h */
        public bb.f c(o oVar) {
            m.f(oVar, "handler");
            return new bb.f(oVar);
        }
    }

    private static final class h extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f11386a = r.class;

        /* renamed from: b  reason: collision with root package name */
        private final String f11387b = "PanGestureHandler";

        public String d() {
            return this.f11387b;
        }

        public Class e() {
            return this.f11386a;
        }

        /* renamed from: f */
        public void a(r rVar, ReadableMap readableMap) {
            boolean z10;
            m.f(rVar, "handler");
            m.f(readableMap, "config");
            super.a(rVar, readableMap);
            boolean z11 = true;
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)) {
                rVar.b1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_START)));
                z10 = true;
            } else {
                z10 = false;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)) {
                rVar.a1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_X_END)));
                z10 = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)) {
                rVar.g1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_START)));
                z10 = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)) {
                rVar.f1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_X_END)));
                z10 = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)) {
                rVar.d1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_START)));
                z10 = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)) {
                rVar.c1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_ACTIVE_OFFSET_Y_END)));
                z10 = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)) {
                rVar.i1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_START)));
                z10 = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)) {
                rVar.h1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_FAIL_OFFSET_RANGE_Y_END)));
                z10 = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)) {
                rVar.m1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY)));
                z10 = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)) {
                rVar.n1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_X)));
                z10 = true;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)) {
                rVar.o1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_VELOCITY_Y)));
            } else {
                z11 = z10;
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MIN_DIST)) {
                rVar.k1(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_PAN_MIN_DIST)));
            } else if (z11) {
                rVar.k1(Float.MAX_VALUE);
            }
            if (readableMap.hasKey("minPointers")) {
                rVar.l1(readableMap.getInt("minPointers"));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS)) {
                rVar.j1(readableMap.getInt(RNGestureHandlerModule.KEY_PAN_MAX_POINTERS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES)) {
                rVar.e1(readableMap.getBoolean(RNGestureHandlerModule.KEY_PAN_AVG_TOUCHES));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_PAN_ACTIVATE_AFTER_LONG_PRESS)) {
                rVar.Z0((long) readableMap.getInt(RNGestureHandlerModule.KEY_PAN_ACTIVATE_AFTER_LONG_PRESS));
            }
        }

        /* renamed from: g */
        public r b(Context context) {
            return new r(context);
        }

        /* renamed from: h */
        public bb.g c(r rVar) {
            m.f(rVar, "handler");
            return new bb.g(rVar);
        }
    }

    private static final class i extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f11388a = s.class;

        /* renamed from: b  reason: collision with root package name */
        private final String f11389b = "PinchGestureHandler";

        public String d() {
            return this.f11389b;
        }

        public Class e() {
            return this.f11388a;
        }

        /* renamed from: f */
        public s b(Context context) {
            return new s();
        }

        /* renamed from: g */
        public bb.h c(s sVar) {
            m.f(sVar, "handler");
            return new bb.h(sVar);
        }
    }

    private static final class j extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f11390a = v.class;

        /* renamed from: b  reason: collision with root package name */
        private final String f11391b = "RotationGestureHandler";

        public String d() {
            return this.f11391b;
        }

        public Class e() {
            return this.f11390a;
        }

        /* renamed from: f */
        public v b(Context context) {
            return new v();
        }

        /* renamed from: g */
        public bb.i c(v vVar) {
            m.f(vVar, "handler");
            return new bb.i(vVar);
        }
    }

    private static final class k extends c {

        /* renamed from: a  reason: collision with root package name */
        private final Class f11392a = a0.class;

        /* renamed from: b  reason: collision with root package name */
        private final String f11393b = "TapGestureHandler";

        public String d() {
            return this.f11393b;
        }

        public Class e() {
            return this.f11392a;
        }

        /* renamed from: f */
        public void a(a0 a0Var, ReadableMap readableMap) {
            m.f(a0Var, "handler");
            m.f(readableMap, "config");
            super.a(a0Var, readableMap);
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS)) {
                a0Var.b1(readableMap.getInt(RNGestureHandlerModule.KEY_TAP_NUMBER_OF_TAPS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS)) {
                a0Var.X0((long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DURATION_MS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS)) {
                a0Var.V0((long) readableMap.getInt(RNGestureHandlerModule.KEY_TAP_MAX_DELAY_MS));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)) {
                a0Var.Y0(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_X)));
            }
            if (readableMap.hasKey(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)) {
                a0Var.Z0(g0.c(readableMap.getDouble(RNGestureHandlerModule.KEY_TAP_MAX_DELTA_Y)));
            }
            if (readableMap.hasKey("maxDist")) {
                a0Var.W0(g0.c(readableMap.getDouble("maxDist")));
            }
            if (readableMap.hasKey("minPointers")) {
                a0Var.a1(readableMap.getInt("minPointers"));
            }
        }

        /* renamed from: g */
        public a0 b(Context context) {
            return new a0();
        }

        /* renamed from: h */
        public bb.j c(a0 a0Var) {
            m.f(a0Var, "handler");
            return new bb.j(a0Var);
        }
    }

    public static final class l implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RNGestureHandlerModule f11394a;

        l(RNGestureHandlerModule rNGestureHandlerModule) {
            this.f11394a = rNGestureHandlerModule;
        }

        public void a(ab.d dVar) {
            m.f(dVar, "handler");
            this.f11394a.onTouchEvent(dVar);
        }

        public void b(ab.d dVar, MotionEvent motionEvent) {
            m.f(dVar, "handler");
            m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
            this.f11394a.onHandlerUpdate(dVar);
        }

        public void c(ab.d dVar, int i10, int i11) {
            m.f(dVar, "handler");
            this.f11394a.onStateChange(dVar, i10, i11);
        }
    }

    public RNGestureHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private final <T extends ab.d> void createGestureHandlerHelper(String str, int i10, ReadableMap readableMap) {
        if (this.registry.h(i10) == null) {
            for (c cVar : this.handlerFactories) {
                if (m.b(cVar.d(), str)) {
                    ab.d b10 = cVar.b(getReactApplicationContext());
                    b10.G0(i10);
                    b10.C0(this.eventListener);
                    this.registry.j(b10);
                    this.interactionManager.e(b10, readableMap);
                    cVar.a(b10, readableMap);
                    return;
                }
            }
            throw new JSApplicationIllegalArgumentException("Invalid handler name " + str);
        }
        throw new IllegalStateException("Handler with tag " + i10 + " already exists. Please ensure that no Gesture instance is used across multiple GestureDetectors.");
    }

    private final native void decorateRuntime(long j10);

    private final <T extends ab.d> c findFactoryForHandler(ab.d dVar) {
        for (c cVar : this.handlerFactories) {
            if (m.b(cVar.e(), dVar.getClass())) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.swmansion.gesturehandler.react.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.swmansion.gesturehandler.react.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.swmansion.gesturehandler.react.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.swmansion.gesturehandler.react.i} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.swmansion.gesturehandler.react.i findRootHelperForViewAncestor(int r7) {
        /*
            r6 = this;
            com.facebook.react.bridge.ReactApplicationContext r0 = r6.getReactApplicationContext()
            java.lang.String r1 = "getReactApplicationContext(...)"
            kotlin.jvm.internal.m.e(r0, r1)
            com.facebook.react.uimanager.UIManagerModule r0 = com.swmansion.gesturehandler.react.a.b(r0)
            int r7 = r0.resolveRootTagFromReactTag(r7)
            r0 = 1
            r1 = 0
            if (r7 >= r0) goto L_0x0016
            return r1
        L_0x0016:
            java.util.List<com.swmansion.gesturehandler.react.i> r0 = r6.roots
            monitor-enter(r0)
            java.util.List<com.swmansion.gesturehandler.react.i> r2 = r6.roots     // Catch:{ all -> 0x0044 }
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ all -> 0x0044 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0044 }
        L_0x0021:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0044 }
            if (r3 == 0) goto L_0x0046
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0044 }
            r4 = r3
            com.swmansion.gesturehandler.react.i r4 = (com.swmansion.gesturehandler.react.i) r4     // Catch:{ all -> 0x0044 }
            android.view.ViewGroup r5 = r4.f()     // Catch:{ all -> 0x0044 }
            boolean r5 = r5 instanceof com.facebook.react.ReactRootView     // Catch:{ all -> 0x0044 }
            if (r5 == 0) goto L_0x0021
            android.view.ViewGroup r4 = r4.f()     // Catch:{ all -> 0x0044 }
            com.facebook.react.ReactRootView r4 = (com.facebook.react.ReactRootView) r4     // Catch:{ all -> 0x0044 }
            int r4 = r4.getRootViewTag()     // Catch:{ all -> 0x0044 }
            if (r4 != r7) goto L_0x0021
            r1 = r3
            goto L_0x0046
        L_0x0044:
            r7 = move-exception
            goto L_0x004a
        L_0x0046:
            com.swmansion.gesturehandler.react.i r1 = (com.swmansion.gesturehandler.react.i) r1     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)
            return r1
        L_0x004a:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerModule.findRootHelperForViewAncestor(int):com.swmansion.gesturehandler.react.i");
    }

    /* access modifiers changed from: private */
    public static final void install$lambda$2(RNGestureHandlerModule rNGestureHandlerModule) {
        m.f(rNGestureHandlerModule, "this$0");
        try {
            SoLoader.t("gesturehandler");
            JavaScriptContextHolder javaScriptContextHolder = rNGestureHandlerModule.getReactApplicationContext().getJavaScriptContextHolder();
            m.c(javaScriptContextHolder);
            rNGestureHandlerModule.decorateRuntime(javaScriptContextHolder.get());
        } catch (Exception unused) {
            Log.w("[RNGestureHandler]", "Could not install JSI bindings.");
        }
    }

    /* access modifiers changed from: private */
    public final <T extends ab.d> void onHandlerUpdate(T t10) {
        c findFactoryForHandler;
        if (t10.R() < 0 || t10.Q() != 4 || (findFactoryForHandler = findFactoryForHandler(t10)) == null) {
            return;
        }
        if (t10.D() == 1) {
            sendEventForReanimated(c.a.c(c.f11398d, t10, findFactoryForHandler.c(t10), false, 4, (Object) null));
        } else if (t10.D() == 2) {
            sendEventForNativeAnimatedEvent(c.f11398d.b(t10, findFactoryForHandler.c(t10), true));
        } else if (t10.D() == 3) {
            sendEventForDirectEvent(c.a.c(c.f11398d, t10, findFactoryForHandler.c(t10), false, 4, (Object) null));
        } else if (t10.D() == 4) {
            sendEventForDeviceEvent("onGestureHandlerEvent", c.f11398d.a(findFactoryForHandler.c(t10)));
        }
    }

    /* access modifiers changed from: private */
    public final <T extends ab.d> void onStateChange(T t10, int i10, int i11) {
        c findFactoryForHandler;
        if (t10.R() < 0 || (findFactoryForHandler = findFactoryForHandler(t10)) == null) {
            return;
        }
        if (t10.D() == 1) {
            sendEventForReanimated(j.f11420d.b(t10, i10, i11, findFactoryForHandler.c(t10)));
        } else if (t10.D() == 2 || t10.D() == 3) {
            sendEventForDirectEvent(j.f11420d.b(t10, i10, i11, findFactoryForHandler.c(t10)));
        } else if (t10.D() == 4) {
            sendEventForDeviceEvent("onGestureHandlerStateChange", j.f11420d.a(findFactoryForHandler.c(t10), i10, i11));
        }
    }

    /* access modifiers changed from: private */
    public final <T extends ab.d> void onTouchEvent(T t10) {
        if (t10.R() >= 0) {
            if (t10.Q() != 2 && t10.Q() != 4 && t10.Q() != 0 && t10.U() == null) {
                return;
            }
            if (t10.D() == 1) {
                sendEventForReanimated(k.f11425c.b(t10));
            } else if (t10.D() == 4) {
                sendEventForDeviceEvent("onGestureHandlerEvent", k.f11425c.a(t10));
            }
        }
    }

    private final void sendEventForDeviceEvent(String str, WritableMap writableMap) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        a.a(reactApplicationContext).emit(str, writableMap);
    }

    private final <T extends com.facebook.react.uimanager.events.d> void sendEventForDirectEvent(T t10) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        za.e.a(reactApplicationContext, t10);
    }

    private final void sendEventForNativeAnimatedEvent(c cVar) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        za.e.a(reactApplicationContext, cVar);
    }

    private final <T extends com.facebook.react.uimanager.events.d> void sendEventForReanimated(T t10) {
        sendEventForDirectEvent(t10);
    }

    private final <T extends ab.d> void updateGestureHandlerHelper(int i10, ReadableMap readableMap) {
        c findFactoryForHandler;
        ab.d h10 = this.registry.h(i10);
        if (h10 != null && (findFactoryForHandler = findFactoryForHandler(h10)) != null) {
            this.interactionManager.g(i10);
            this.interactionManager.e(h10, readableMap);
            findFactoryForHandler.a(h10, readableMap);
        }
    }

    @ReactMethod
    public void attachGestureHandler(double d10, double d11, double d12) {
        int i10 = (int) d10;
        if (!this.registry.c(i10, (int) d11, (int) d12)) {
            throw new JSApplicationIllegalArgumentException("Handler with tag " + i10 + " does not exists");
        }
    }

    @ReactMethod
    public void createGestureHandler(String str, double d10, ReadableMap readableMap) {
        m.f(str, "handlerName");
        m.f(readableMap, "config");
        createGestureHandlerHelper(str, (int) d10, readableMap);
    }

    @ReactMethod
    public void dropGestureHandler(double d10) {
        int i10 = (int) d10;
        this.interactionManager.g(i10);
        this.registry.g(i10);
    }

    @ReactMethod
    public void flushOperations() {
    }

    public Map<String, Object> getConstants() {
        return i0.i(t.a("State", i0.i(t.a("UNDETERMINED", 0), t.a("BEGAN", 2), t.a("ACTIVE", 4), t.a("CANCELLED", 3), t.a("FAILED", 1), t.a("END", 5))), t.a("Direction", i0.i(t.a("RIGHT", 1), t.a("LEFT", 2), t.a("UP", 4), t.a("DOWN", 8))));
    }

    public String getName() {
        return "RNGestureHandlerModule";
    }

    public final g getRegistry() {
        return this.registry;
    }

    @ReactMethod
    public void handleClearJSResponder() {
    }

    @ReactMethod
    public void handleSetJSResponder(double d10, boolean z10) {
        int i10 = (int) d10;
        i findRootHelperForViewAncestor = findRootHelperForViewAncestor(i10);
        if (findRootHelperForViewAncestor != null) {
            findRootHelperForViewAncestor.g(i10, z10);
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean install() {
        getReactApplicationContext().runOnJSQueueThread(new e(this));
        return true;
    }

    public void invalidate() {
        this.registry.f();
        this.interactionManager.h();
        synchronized (this.roots) {
            while (!this.roots.isEmpty()) {
                try {
                    int size = this.roots.size();
                    this.roots.get(0).j();
                    if (this.roots.size() >= size) {
                        throw new IllegalStateException("Expected root helper to get unregistered while tearing down");
                    }
                } finally {
                }
            }
            Unit unit = Unit.f12577a;
        }
        super.invalidate();
    }

    public final void registerRootHelper(i iVar) {
        m.f(iVar, "root");
        synchronized (this.roots) {
            if (!this.roots.contains(iVar)) {
                this.roots.add(iVar);
            } else {
                throw new IllegalStateException("Root helper" + iVar + " already registered");
            }
        }
    }

    public void setGestureHandlerState(int i10, int i11) {
        ab.d h10 = this.registry.h(i10);
        if (h10 == null) {
            return;
        }
        if (i11 == 1) {
            h10.B();
        } else if (i11 == 2) {
            h10.n();
        } else if (i11 == 3) {
            h10.o();
        } else if (i11 == 4) {
            h10.j(true);
        } else if (i11 == 5) {
            h10.z();
        }
    }

    public final void unregisterRootHelper(i iVar) {
        m.f(iVar, "root");
        synchronized (this.roots) {
            this.roots.remove(iVar);
        }
    }

    @ReactMethod
    public void updateGestureHandler(double d10, ReadableMap readableMap) {
        m.f(readableMap, "config");
        updateGestureHandlerHelper((int) d10, readableMap);
    }
}
