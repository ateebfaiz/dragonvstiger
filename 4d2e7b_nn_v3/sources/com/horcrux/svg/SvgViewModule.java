package com.horcrux.svg;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

@s6.a(name = "RNSVGSvgViewModule")
class SvgViewModule extends NativeSvgViewModuleSpec {
    public static final String NAME = "RNSVGSvgViewModule";

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f9717a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f9718b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callback f9719c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f9720d;

        /* renamed from: com.horcrux.svg.SvgViewModule$a$a  reason: collision with other inner class name */
        class C0111a implements Runnable {

            /* renamed from: com.horcrux.svg.SvgViewModule$a$a$a  reason: collision with other inner class name */
            class C0112a implements Runnable {
                C0112a() {
                }

                public void run() {
                    a aVar = a.this;
                    SvgViewModule.toDataURL(aVar.f9717a, aVar.f9718b, aVar.f9719c, aVar.f9720d + 1);
                }
            }

            C0111a() {
            }

            public void run() {
                SvgView svgViewByTag = SvgViewManager.getSvgViewByTag(a.this.f9717a);
                if (svgViewByTag != null) {
                    svgViewByTag.setToDataUrlTask(new C0112a());
                }
            }
        }

        class b implements Runnable {
            b() {
            }

            public void run() {
                a aVar = a.this;
                SvgViewModule.toDataURL(aVar.f9717a, aVar.f9718b, aVar.f9719c, aVar.f9720d + 1);
            }
        }

        a(int i10, ReadableMap readableMap, Callback callback, int i11) {
            this.f9717a = i10;
            this.f9718b = readableMap;
            this.f9719c = callback;
            this.f9720d = i11;
        }

        public void run() {
            SvgView svgViewByTag = SvgViewManager.getSvgViewByTag(this.f9717a);
            if (svgViewByTag == null) {
                SvgViewManager.runWhenViewIsAvailable(this.f9717a, new C0111a());
            } else if (svgViewByTag.notRendered()) {
                svgViewByTag.setToDataUrlTask(new b());
            } else {
                ReadableMap readableMap = this.f9718b;
                if (readableMap != null) {
                    this.f9719c.invoke(svgViewByTag.toDataURL(readableMap.getInt(Snapshot.WIDTH), this.f9718b.getInt(Snapshot.HEIGHT)));
                    return;
                }
                this.f9719c.invoke(svgViewByTag.toDataURL());
            }
        }
    }

    SvgViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public static void toDataURL(int i10, ReadableMap readableMap, Callback callback, int i11) {
        UiThreadUtil.runOnUiThread(new a(i10, readableMap, callback, i11));
    }

    public String getName() {
        return "RNSVGSvgViewModule";
    }

    @ReactMethod
    public void toDataURL(Double d10, ReadableMap readableMap, Callback callback) {
        toDataURL(d10.intValue(), readableMap, callback, 0);
    }
}
