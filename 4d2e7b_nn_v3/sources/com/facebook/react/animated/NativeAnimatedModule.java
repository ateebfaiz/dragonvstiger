package com.facebook.react.animated;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.a;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.c0;
import com.facebook.react.uimanager.i1;
import com.facebook.react.uimanager.k1;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

@s6.a(name = "NativeAnimatedModule")
public class NativeAnimatedModule extends NativeAnimatedModuleSpec implements LifecycleEventListener, UIManagerListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean ANIMATED_MODULE_DEBUG = false;
    @NonNull
    private final com.facebook.react.uimanager.o mAnimatedFrameCallback;
    private boolean mBatchingControlledByJS = false;
    private volatile long mCurrentBatchNumber;
    private volatile long mCurrentFrameNumber;
    /* access modifiers changed from: private */
    public boolean mEnqueuedAnimationOnFrame = false;
    private boolean mInitializedForFabric = false;
    private boolean mInitializedForNonFabric = false;
    private final AtomicReference<p> mNodesManager = new AtomicReference<>();
    private int mNumFabricAnimations = 0;
    private int mNumNonFabricAnimations = 0;
    /* access modifiers changed from: private */
    @NonNull
    public final a0 mOperations = new a0();
    /* access modifiers changed from: private */
    @NonNull
    public final a0 mPreOperations = new a0();
    /* access modifiers changed from: private */
    public final com.facebook.react.modules.core.a mReactChoreographer = com.facebook.react.modules.core.a.h();
    private int mUIManagerType = 1;

    class a extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2689c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ double f2690d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(int i10, double d10) {
            super();
            this.f2689c = i10;
            this.f2690d = d10;
        }

        public void a(p pVar) {
            pVar.u(this.f2689c, this.f2690d);
        }
    }

    private class a0 {

        /* renamed from: a  reason: collision with root package name */
        private final Queue f2692a;

        /* renamed from: b  reason: collision with root package name */
        private b0 f2693b;

        private List b(long j10) {
            if (d()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                b0 b0Var = this.f2693b;
                if (b0Var != null) {
                    if (b0Var.b() > j10) {
                        break;
                    }
                    arrayList.add(this.f2693b);
                    this.f2693b = null;
                }
                b0 b0Var2 = (b0) this.f2692a.poll();
                if (b0Var2 == null) {
                    break;
                } else if (b0Var2.b() > j10) {
                    this.f2693b = b0Var2;
                    break;
                } else {
                    arrayList.add(b0Var2);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public void a(b0 b0Var) {
            this.f2692a.add(b0Var);
        }

        /* access modifiers changed from: package-private */
        public void c(long j10, p pVar) {
            List<b0> b10 = b(j10);
            if (b10 != null) {
                for (b0 a10 : b10) {
                    a10.a(pVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            if (!this.f2692a.isEmpty() || this.f2693b != null) {
                return false;
            }
            return true;
        }

        private a0() {
            this.f2692a = new ConcurrentLinkedQueue();
            this.f2693b = null;
        }
    }

    class b extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2695c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ double f2696d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i10, double d10) {
            super();
            this.f2695c = i10;
            this.f2696d = d10;
        }

        public void a(p pVar) {
            pVar.t(this.f2695c, this.f2696d);
        }
    }

    private abstract class b0 {

        /* renamed from: a  reason: collision with root package name */
        long f2698a;

        /* access modifiers changed from: package-private */
        public abstract void a(p pVar);

        public long b() {
            return this.f2698a;
        }

        public void c(long j10) {
            this.f2698a = j10;
        }

        private b0() {
            this.f2698a = -1;
        }
    }

    class c extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2700c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(int i10) {
            super();
            this.f2700c = i10;
        }

        public void a(p pVar) {
            pVar.j(this.f2700c);
        }
    }

    class d extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2702c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(int i10) {
            super();
            this.f2702c = i10;
        }

        public void a(p pVar) {
            pVar.i(this.f2702c);
        }
    }

    class e extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2704c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2705d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ReadableMap f2706e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Callback f2707f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(int i10, int i11, ReadableMap readableMap, Callback callback) {
            super();
            this.f2704c = i10;
            this.f2705d = i11;
            this.f2706e = readableMap;
            this.f2707f = callback;
        }

        public void a(p pVar) {
            pVar.v(this.f2704c, this.f2705d, this.f2706e, this.f2707f);
        }
    }

    class f extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2709c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(int i10) {
            super();
            this.f2709c = i10;
        }

        public void a(p pVar) {
            pVar.x(this.f2709c);
        }
    }

    class g extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2711c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2712d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(int i10, int i11) {
            super();
            this.f2711c = i10;
            this.f2712d = i11;
        }

        public void a(p pVar) {
            pVar.d(this.f2711c, this.f2712d);
        }
    }

    class h extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2714c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2715d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(int i10, int i11) {
            super();
            this.f2714c = i10;
            this.f2715d = i11;
        }

        public void a(p pVar) {
            pVar.g(this.f2714c, this.f2715d);
        }
    }

    class i extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2717c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2718d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(int i10, int i11) {
            super();
            this.f2717c = i10;
            this.f2718d = i11;
        }

        public void a(p pVar) {
            pVar.c(this.f2717c, this.f2718d);
        }
    }

    class j extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2720c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f2721d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(int i10, int i11) {
            super();
            this.f2720c = i10;
            this.f2721d = i11;
        }

        public void a(p pVar) {
            pVar.f(this.f2720c, this.f2721d);
        }
    }

    class k extends com.facebook.react.uimanager.o {
        k(ReactContext reactContext) {
            super(reactContext);
        }

        /* access modifiers changed from: protected */
        public void doFrameGuarded(long j10) {
            try {
                NativeAnimatedModule.this.mEnqueuedAnimationOnFrame = false;
                p nodesManager = NativeAnimatedModule.this.getNodesManager();
                if (nodesManager != null && nodesManager.n()) {
                    nodesManager.s(j10);
                }
                if (nodesManager == null) {
                    return;
                }
                if (NativeAnimatedModule.this.mReactChoreographer != null) {
                    if (!o6.a.c() || nodesManager.n()) {
                        NativeAnimatedModule.this.enqueueFrameCallback();
                    }
                }
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    class l extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2724c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(int i10) {
            super();
            this.f2724c = i10;
        }

        public void a(p pVar) {
            pVar.r(this.f2724c);
        }
    }

    class m extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2726c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f2727d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ReadableMap f2728e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(int i10, String str, ReadableMap readableMap) {
            super();
            this.f2726c = i10;
            this.f2727d = str;
            this.f2728e = readableMap;
        }

        public void a(p pVar) {
            pVar.b(this.f2726c, this.f2727d, this.f2728e);
        }
    }

    class n extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2730c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f2731d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f2732e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(int i10, String str, int i11) {
            super();
            this.f2730c = i10;
            this.f2731d = str;
            this.f2732e = i11;
        }

        public void a(p pVar) {
            pVar.q(this.f2730c, this.f2731d, this.f2732e);
        }
    }

    class o extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2734c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Callback f2735d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(int i10, Callback callback) {
            super();
            this.f2734c = i10;
            this.f2735d = callback;
        }

        public void a(p pVar) {
            pVar.l(this.f2734c, this.f2735d);
        }
    }

    class p extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2737c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ReadableArray f2738d;

        class a implements c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f2740a;

            a(int i10) {
                this.f2740a = i10;
            }

            public void a(double d10) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("tag", this.f2740a);
                createMap.putDouble("value", d10);
                ReactApplicationContext access$200 = NativeAnimatedModule.this.getReactApplicationContextIfActiveOrWarn();
                if (access$200 != null) {
                    access$200.emitDeviceEvent("onAnimatedValueUpdate", createMap);
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(int i10, ReadableArray readableArray) {
            super();
            this.f2737c = i10;
            this.f2738d = readableArray;
        }

        public void a(p pVar) {
            ReactApplicationContext unused = NativeAnimatedModule.this.getReactApplicationContextIfActiveOrWarn();
            int i10 = 0;
            while (i10 < this.f2737c) {
                int i11 = i10 + 1;
                switch (q.f2742a[z.b(this.f2738d.getInt(i10)).ordinal()]) {
                    case 1:
                        i10 += 2;
                        pVar.l(this.f2738d.getInt(i11), (Callback) null);
                        break;
                    case 2:
                        i10 += 2;
                        int i12 = this.f2738d.getInt(i11);
                        pVar.w(i12, new a(i12));
                        break;
                    case 3:
                        i10 += 2;
                        pVar.z(this.f2738d.getInt(i11));
                        break;
                    case 4:
                        i10 += 2;
                        pVar.x(this.f2738d.getInt(i11));
                        break;
                    case 5:
                        i10 += 2;
                        pVar.j(this.f2738d.getInt(i11));
                        break;
                    case 6:
                        i10 += 2;
                        pVar.i(this.f2738d.getInt(i11));
                        break;
                    case 7:
                        i10 += 2;
                        pVar.r(this.f2738d.getInt(i11));
                        break;
                    case 8:
                        i10 += 2;
                        pVar.h(this.f2738d.getInt(i11));
                        break;
                    case 9:
                    case 10:
                        i10 += 2;
                        break;
                    case 11:
                        int i13 = i10 + 2;
                        i10 += 3;
                        pVar.e(this.f2738d.getInt(i11), this.f2738d.getMap(i13));
                        break;
                    case 12:
                        int i14 = i10 + 2;
                        i10 += 3;
                        pVar.A(this.f2738d.getInt(i11), this.f2738d.getMap(i14));
                        break;
                    case 13:
                        int i15 = i10 + 2;
                        i10 += 3;
                        pVar.d(this.f2738d.getInt(i11), this.f2738d.getInt(i15));
                        break;
                    case 14:
                        int i16 = i10 + 2;
                        i10 += 3;
                        pVar.g(this.f2738d.getInt(i11), this.f2738d.getInt(i16));
                        break;
                    case 15:
                        int i17 = i10 + 2;
                        i10 += 3;
                        pVar.u(this.f2738d.getInt(i11), this.f2738d.getDouble(i17));
                        break;
                    case 16:
                        int i18 = i10 + 2;
                        i10 += 3;
                        pVar.u(this.f2738d.getInt(i11), this.f2738d.getDouble(i18));
                        break;
                    case 17:
                        int i19 = i10 + 2;
                        int i20 = this.f2738d.getInt(i11);
                        i10 += 3;
                        int i21 = this.f2738d.getInt(i19);
                        NativeAnimatedModule.this.decrementInFlightAnimationsForViewTag(i21);
                        pVar.f(i20, i21);
                        break;
                    case 18:
                        if (o6.a.c()) {
                            NativeAnimatedModule.this.enqueueFrameCallback();
                        }
                        int i22 = i10 + 3;
                        i10 += 4;
                        pVar.v(this.f2738d.getInt(i11), this.f2738d.getInt(i10 + 2), this.f2738d.getMap(i22), (Callback) null);
                        break;
                    case 19:
                        int i23 = this.f2738d.getInt(i11);
                        NativeAnimatedModule.this.decrementInFlightAnimationsForViewTag(i23);
                        int i24 = i10 + 3;
                        i10 += 4;
                        pVar.q(i23, this.f2738d.getString(i10 + 2), this.f2738d.getInt(i24));
                        break;
                    case 20:
                        int i25 = i10 + 2;
                        i10 += 3;
                        pVar.c(this.f2738d.getInt(i11), this.f2738d.getInt(i25));
                        break;
                    case 21:
                        int i26 = i10 + 3;
                        i10 += 4;
                        pVar.b(this.f2738d.getInt(i11), this.f2738d.getString(i10 + 2), this.f2738d.getMap(i26));
                        break;
                    default:
                        throw new IllegalArgumentException("Batch animation execution op: unknown op code");
                }
            }
        }
    }

    static /* synthetic */ class q {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2742a;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.animated.NativeAnimatedModule$z[] r0 = com.facebook.react.animated.NativeAnimatedModule.z.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2742a = r0
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_GET_VALUE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_START_LISTENING_TO_ANIMATED_NODE_VALUE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_STOP_LISTENING_TO_ANIMATED_NODE_VALUE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_STOP_ANIMATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_FLATTEN_ANIMATED_NODE_OFFSET     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_EXTRACT_ANIMATED_NODE_OFFSET     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_RESTORE_DEFAULT_VALUES     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_DROP_ANIMATED_NODE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_ADD_LISTENER     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_REMOVE_LISTENERS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_CREATE_ANIMATED_NODE     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_UPDATE_ANIMATED_NODE_CONFIG     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_CONNECT_ANIMATED_NODES     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_DISCONNECT_ANIMATED_NODES     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_SET_ANIMATED_NODE_VALUE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_SET_ANIMATED_NODE_OFFSET     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_DISCONNECT_ANIMATED_NODE_FROM_VIEW     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_START_ANIMATING_NODE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_REMOVE_ANIMATED_EVENT_FROM_VIEW     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_CONNECT_ANIMATED_NODE_TO_VIEW     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = f2742a     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.facebook.react.animated.NativeAnimatedModule$z r1 = com.facebook.react.animated.NativeAnimatedModule.z.OP_CODE_ADD_ANIMATED_EVENT_TO_VIEW     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.NativeAnimatedModule.q.<clinit>():void");
        }
    }

    class r implements i1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f2743a;

        r(long j10) {
            this.f2743a = j10;
        }

        public void a(c0 c0Var) {
            NativeAnimatedModule.this.mPreOperations.c(this.f2743a, NativeAnimatedModule.this.getNodesManager());
        }
    }

    class s implements i1 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f2745a;

        s(long j10) {
            this.f2745a = j10;
        }

        public void a(c0 c0Var) {
            NativeAnimatedModule.this.mOperations.c(this.f2745a, NativeAnimatedModule.this.getNodesManager());
        }
    }

    class t extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2747c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ReadableMap f2748d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(int i10, ReadableMap readableMap) {
            super();
            this.f2747c = i10;
            this.f2748d = readableMap;
        }

        public void a(p pVar) {
            pVar.e(this.f2747c, this.f2748d);
        }
    }

    class u extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2750c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ReadableMap f2751d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(int i10, ReadableMap readableMap) {
            super();
            this.f2750c = i10;
            this.f2751d = readableMap;
        }

        public void a(p pVar) {
            pVar.A(this.f2750c, this.f2751d);
        }
    }

    class v implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2753a;

        v(int i10) {
            this.f2753a = i10;
        }

        public void a(double d10) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("tag", this.f2753a);
            createMap.putDouble("value", d10);
            ReactApplicationContext access$000 = NativeAnimatedModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$000 != null) {
                access$000.emitDeviceEvent("onAnimatedValueUpdate", createMap);
            }
        }
    }

    class w extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2755c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f2756d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(int i10, c cVar) {
            super();
            this.f2755c = i10;
            this.f2756d = cVar;
        }

        public void a(p pVar) {
            pVar.w(this.f2755c, this.f2756d);
        }
    }

    class x extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2758c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(int i10) {
            super();
            this.f2758c = i10;
        }

        public void a(p pVar) {
            pVar.z(this.f2758c);
        }
    }

    class y extends b0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2760c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(int i10) {
            super();
            this.f2760c = i10;
        }

        public void a(p pVar) {
            pVar.h(this.f2760c);
        }
    }

    private enum z {
        OP_CODE_CREATE_ANIMATED_NODE(1),
        OP_CODE_UPDATE_ANIMATED_NODE_CONFIG(2),
        OP_CODE_GET_VALUE(3),
        OP_START_LISTENING_TO_ANIMATED_NODE_VALUE(4),
        OP_STOP_LISTENING_TO_ANIMATED_NODE_VALUE(5),
        OP_CODE_CONNECT_ANIMATED_NODES(6),
        OP_CODE_DISCONNECT_ANIMATED_NODES(7),
        OP_CODE_START_ANIMATING_NODE(8),
        OP_CODE_STOP_ANIMATION(9),
        OP_CODE_SET_ANIMATED_NODE_VALUE(10),
        OP_CODE_SET_ANIMATED_NODE_OFFSET(11),
        OP_CODE_FLATTEN_ANIMATED_NODE_OFFSET(12),
        OP_CODE_EXTRACT_ANIMATED_NODE_OFFSET(13),
        OP_CODE_CONNECT_ANIMATED_NODE_TO_VIEW(14),
        OP_CODE_DISCONNECT_ANIMATED_NODE_FROM_VIEW(15),
        OP_CODE_RESTORE_DEFAULT_VALUES(16),
        OP_CODE_DROP_ANIMATED_NODE(17),
        OP_CODE_ADD_ANIMATED_EVENT_TO_VIEW(18),
        OP_CODE_REMOVE_ANIMATED_EVENT_FROM_VIEW(19),
        OP_CODE_ADD_LISTENER(20),
        OP_CODE_REMOVE_LISTENERS(21);
        
        private static z[] U0;

        /* renamed from: a  reason: collision with root package name */
        private final int f2772a;

        static {
            U0 = null;
        }

        private z(int i10) {
            this.f2772a = i10;
        }

        public static z b(int i10) {
            if (U0 == null) {
                U0 = values();
            }
            return U0[i10 - 1];
        }
    }

    public NativeAnimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mAnimatedFrameCallback = new k(reactApplicationContext);
    }

    private void addOperation(b0 b0Var) {
        b0Var.c(this.mCurrentBatchNumber);
        this.mOperations.a(b0Var);
    }

    private void addPreOperation(b0 b0Var) {
        b0Var.c(this.mCurrentBatchNumber);
        this.mPreOperations.a(b0Var);
    }

    private void addUnbatchedOperation(b0 b0Var) {
        b0Var.c(-1);
        this.mOperations.a(b0Var);
    }

    private void clearFrameCallback() {
        ((com.facebook.react.modules.core.a) p5.a.c(this.mReactChoreographer)).o(a.b.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
        this.mEnqueuedAnimationOnFrame = false;
    }

    /* access modifiers changed from: private */
    public void decrementInFlightAnimationsForViewTag(int i10) {
        if (i7.a.a(i10) == 2) {
            this.mNumFabricAnimations--;
        } else {
            this.mNumNonFabricAnimations--;
        }
        int i11 = this.mNumNonFabricAnimations;
        if (i11 == 0 && this.mNumFabricAnimations > 0 && this.mUIManagerType != 2) {
            this.mUIManagerType = 2;
        } else if (this.mNumFabricAnimations == 0 && i11 > 0 && this.mUIManagerType != 1) {
            this.mUIManagerType = 1;
        }
    }

    /* access modifiers changed from: private */
    public void enqueueFrameCallback() {
        if (!this.mEnqueuedAnimationOnFrame) {
            ((com.facebook.react.modules.core.a) p5.a.c(this.mReactChoreographer)).m(a.b.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
            this.mEnqueuedAnimationOnFrame = true;
        }
    }

    private void initializeLifecycleEventListenersForViewTag(int i10) {
        UIManager g10;
        int a10 = i7.a.a(i10);
        this.mUIManagerType = a10;
        if (a10 == 2) {
            this.mNumFabricAnimations++;
        } else {
            this.mNumNonFabricAnimations++;
        }
        p nodesManager = getNodesManager();
        if (nodesManager != null) {
            nodesManager.o(this.mUIManagerType);
        } else {
            ReactSoftExceptionLogger.logSoftException(NativeAnimatedModuleSpec.NAME, new RuntimeException("initializeLifecycleEventListenersForViewTag could not get NativeAnimatedNodesManager"));
        }
        if (this.mUIManagerType == 2) {
            if (this.mInitializedForFabric) {
                return;
            }
        } else if (this.mInitializedForNonFabric) {
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null && (g10 = k1.g(reactApplicationContext, this.mUIManagerType)) != null) {
            g10.addUIManagerEventListener(this);
            if (this.mUIManagerType == 2) {
                this.mInitializedForFabric = true;
            } else {
                this.mInitializedForNonFabric = true;
            }
        }
    }

    public void addAnimatedEventToView(double d10, String str, ReadableMap readableMap) {
        int i10 = (int) d10;
        initializeLifecycleEventListenersForViewTag(i10);
        addOperation(new m(i10, str, readableMap));
    }

    public void addListener(String str) {
    }

    public void connectAnimatedNodeToView(double d10, double d11) {
        int i10 = (int) d11;
        initializeLifecycleEventListenersForViewTag(i10);
        addOperation(new i((int) d10, i10));
    }

    public void connectAnimatedNodes(double d10, double d11) {
        addOperation(new g((int) d10, (int) d11));
    }

    public void createAnimatedNode(double d10, ReadableMap readableMap) {
        addOperation(new t((int) d10, readableMap));
    }

    @UiThread
    public void didDispatchMountItems(UIManager uIManager) {
        if (this.mUIManagerType == 2) {
            long j10 = this.mCurrentBatchNumber - 1;
            if (!this.mBatchingControlledByJS) {
                this.mCurrentFrameNumber++;
                if (this.mCurrentFrameNumber - this.mCurrentBatchNumber > 2) {
                    this.mCurrentBatchNumber = this.mCurrentFrameNumber;
                    j10 = this.mCurrentBatchNumber;
                }
            }
            this.mPreOperations.c(j10, getNodesManager());
            this.mOperations.c(j10, getNodesManager());
        }
    }

    public void didMountItems(UIManager uIManager) {
    }

    public void didScheduleMountItems(UIManager uIManager) {
        this.mCurrentFrameNumber++;
    }

    public void disconnectAnimatedNodeFromView(double d10, double d11) {
        int i10 = (int) d11;
        decrementInFlightAnimationsForViewTag(i10);
        addOperation(new j((int) d10, i10));
    }

    public void disconnectAnimatedNodes(double d10, double d11) {
        addOperation(new h((int) d10, (int) d11));
    }

    public void dropAnimatedNode(double d10) {
        addOperation(new y((int) d10));
    }

    public void extractAnimatedNodeOffset(double d10) {
        addOperation(new d((int) d10));
    }

    public void finishOperationBatch() {
        this.mBatchingControlledByJS = true;
        this.mCurrentBatchNumber++;
    }

    public void flattenAnimatedNodeOffset(double d10) {
        addOperation(new c((int) d10));
    }

    @Nullable
    public p getNodesManager() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn;
        if (this.mNodesManager.get() == null && (reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn()) != null) {
            d.a.a(this.mNodesManager, (Object) null, new p(reactApplicationContextIfActiveOrWarn));
        }
        return this.mNodesManager.get();
    }

    public void getValue(double d10, Callback callback) {
        addOperation(new o((int) d10, callback));
    }

    public void initialize() {
        super.initialize();
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    public void invalidate() {
        super.invalidate();
        getReactApplicationContext().removeLifecycleEventListener(this);
    }

    public void onHostDestroy() {
        clearFrameCallback();
    }

    public void onHostPause() {
        clearFrameCallback();
    }

    public void onHostResume() {
        enqueueFrameCallback();
    }

    public void queueAndExecuteBatchedOperations(ReadableArray readableArray) {
        int size = readableArray.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            switch (q.f2742a[z.b(readableArray.getInt(i10)).ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    i10 += 2;
                    continue;
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                    i10 += 3;
                    continue;
                case 18:
                case 19:
                    break;
                case 20:
                    int i12 = i10 + 2;
                    i10 += 3;
                    initializeLifecycleEventListenersForViewTag(readableArray.getInt(i12));
                    continue;
                case 21:
                    initializeLifecycleEventListenersForViewTag(readableArray.getInt(i11));
                    break;
                default:
                    throw new IllegalArgumentException("Batch animation execution op: fetching viewTag: unknown op code");
            }
            i10 += 4;
        }
        startOperationBatch();
        addUnbatchedOperation(new p(size, readableArray));
        finishOperationBatch();
    }

    public void removeAnimatedEventFromView(double d10, String str, double d11) {
        int i10 = (int) d10;
        decrementInFlightAnimationsForViewTag(i10);
        addOperation(new n(i10, str, (int) d11));
    }

    public void removeListeners(double d10) {
    }

    public void restoreDefaultValues(double d10) {
        addPreOperation(new l((int) d10));
    }

    public void setAnimatedNodeOffset(double d10, double d11) {
        addOperation(new b((int) d10, d11));
    }

    public void setAnimatedNodeValue(double d10, double d11) {
        addOperation(new a((int) d10, d11));
    }

    public void setNodesManager(p pVar) {
        this.mNodesManager.set(pVar);
    }

    public void startAnimatingNode(double d10, double d11, ReadableMap readableMap, Callback callback) {
        addUnbatchedOperation(new e((int) d10, (int) d11, readableMap, callback));
    }

    public void startListeningToAnimatedNodeValue(double d10) {
        int i10 = (int) d10;
        addOperation(new w(i10, new v(i10)));
    }

    public void startOperationBatch() {
        this.mBatchingControlledByJS = true;
        this.mCurrentBatchNumber++;
    }

    public void stopAnimation(double d10) {
        addOperation(new f((int) d10));
    }

    public void stopListeningToAnimatedNodeValue(double d10) {
        addOperation(new x((int) d10));
    }

    public void updateAnimatedNodeConfig(double d10, ReadableMap readableMap) {
        addOperation(new u((int) d10, readableMap));
    }

    @UiThread
    public void willDispatchViewUpdates(UIManager uIManager) {
        if ((!this.mOperations.d() || !this.mPreOperations.d()) && this.mUIManagerType != 2) {
            long j10 = this.mCurrentBatchNumber;
            this.mCurrentBatchNumber = 1 + j10;
            r rVar = new r(j10);
            s sVar = new s(j10);
            UIManagerModule uIManagerModule = (UIManagerModule) uIManager;
            uIManagerModule.prependUIBlock(rVar);
            uIManagerModule.addUIBlock(sVar);
        }
    }

    public void willMountItems(UIManager uIManager) {
    }
}
