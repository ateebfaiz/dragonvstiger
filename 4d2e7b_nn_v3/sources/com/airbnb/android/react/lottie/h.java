package com.airbnb.android.react.lottie;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.a1;
import com.airbnb.lottie.b;
import com.airbnb.lottie.r0;
import com.airbnb.lottie.y0;
import com.airbnb.lottie.z0;
import com.alibaba.pdns.f;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.views.text.d;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p;
import r0.e;
import z0.c;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f17567a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17568b = "lottie-react-native";

    /* renamed from: c  reason: collision with root package name */
    private boolean f17569c;

    /* renamed from: d  reason: collision with root package name */
    private String f17570d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView.ScaleType f17571e;

    /* renamed from: f  reason: collision with root package name */
    private String f17572f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f17573g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f17574h;

    /* renamed from: i  reason: collision with root package name */
    private ReadableArray f17575i;

    /* renamed from: j  reason: collision with root package name */
    private ReadableArray f17576j;

    /* renamed from: k  reason: collision with root package name */
    private y0 f17577k;

    /* renamed from: l  reason: collision with root package name */
    private Integer f17578l;

    /* renamed from: m  reason: collision with root package name */
    private String f17579m;

    /* renamed from: n  reason: collision with root package name */
    private String f17580n;

    /* renamed from: o  reason: collision with root package name */
    private String f17581o;

    /* renamed from: p  reason: collision with root package name */
    private Float f17582p;

    /* renamed from: q  reason: collision with root package name */
    private Boolean f17583q;

    /* renamed from: r  reason: collision with root package name */
    private Boolean f17584r;

    /* renamed from: s  reason: collision with root package name */
    private Float f17585s;

    public static final class a extends b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f17586a;

        a(LottieAnimationView lottieAnimationView) {
            this.f17586a = lottieAnimationView;
        }

        public Typeface a(String str) {
            m.f(str, "fontFamily");
            Typeface b10 = d.a().b(str, -1, -1, this.f17586a.getContext().getAssets());
            m.e(b10, "getTypeface(...)");
            return b10;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
            if (r4.equals("Regular") == false) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
            if (r4.equals("Normal") == false) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
            r3 = com.adjust.sdk.Constants.MINIMAL_ERROR_STATUS_CODE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
            r3 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
            r3 = com.facebook.react.views.text.d.a().b(r5, -1, r3, r2.f17586a.getContext().getAssets());
            kotlin.jvm.internal.m.e(r3, "getTypeface(...)");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
            return r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Typeface b(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
            /*
                r2 = this;
                java.lang.String r0 = "fontFamily"
                kotlin.jvm.internal.m.f(r3, r0)
                java.lang.String r3 = "fontStyle"
                kotlin.jvm.internal.m.f(r4, r3)
                java.lang.String r3 = "fontName"
                kotlin.jvm.internal.m.f(r5, r3)
                int r3 = r4.hashCode()
                r0 = -1
                switch(r3) {
                    case -1994163307: goto L_0x005c;
                    case -1955878649: goto L_0x0050;
                    case -1543850116: goto L_0x0047;
                    case 2076325: goto L_0x003b;
                    case 2605753: goto L_0x0030;
                    case 64266207: goto L_0x0024;
                    case 73417974: goto L_0x0018;
                    default: goto L_0x0017;
                }
            L_0x0017:
                goto L_0x0064
            L_0x0018:
                java.lang.String r3 = "Light"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0021
                goto L_0x0064
            L_0x0021:
                r3 = 200(0xc8, float:2.8E-43)
                goto L_0x0068
            L_0x0024:
                java.lang.String r3 = "Black"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x002d
                goto L_0x0064
            L_0x002d:
                r3 = 900(0x384, float:1.261E-42)
                goto L_0x0068
            L_0x0030:
                java.lang.String r3 = "Thin"
                boolean r3 = r4.equals(r3)
                if (r3 == 0) goto L_0x0064
                r3 = 100
                goto L_0x0068
            L_0x003b:
                java.lang.String r3 = "Bold"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0044
                goto L_0x0064
            L_0x0044:
                r3 = 700(0x2bc, float:9.81E-43)
                goto L_0x0068
            L_0x0047:
                java.lang.String r3 = "Regular"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0059
                goto L_0x0064
            L_0x0050:
                java.lang.String r3 = "Normal"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0059
                goto L_0x0064
            L_0x0059:
                r3 = 400(0x190, float:5.6E-43)
                goto L_0x0068
            L_0x005c:
                java.lang.String r3 = "Medium"
                boolean r3 = r4.equals(r3)
                if (r3 != 0) goto L_0x0066
            L_0x0064:
                r3 = r0
                goto L_0x0068
            L_0x0066:
                r3 = 500(0x1f4, float:7.0E-43)
            L_0x0068:
                com.facebook.react.views.text.d r4 = com.facebook.react.views.text.d.a()
                com.airbnb.lottie.LottieAnimationView r1 = r2.f17586a
                android.content.Context r1 = r1.getContext()
                android.content.res.AssetManager r1 = r1.getAssets()
                android.graphics.Typeface r3 = r4.b(r5, r0, r3, r1)
                java.lang.String r4 = "getTypeface(...)"
                kotlin.jvm.internal.m.e(r3, r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.android.react.lottie.h.a.b(java.lang.String, java.lang.String, java.lang.String):android.graphics.Typeface");
        }
    }

    public h(LottieAnimationView lottieAnimationView) {
        m.f(lottieAnimationView, "view");
        this.f17567a = new WeakReference(lottieAnimationView);
        lottieAnimationView.setFontAssetDelegate(new a(lottieAnimationView));
    }

    private final void b(ReadableMap readableMap, LottieAnimationView lottieAnimationView) {
        int i10;
        List list;
        if (readableMap.getType("color") == ReadableType.Map) {
            Integer color = ColorPropConverter.getColor(readableMap.getMap("color"), lottieAnimationView.getContext());
            m.c(color);
            i10 = color.intValue();
        } else {
            i10 = readableMap.getInt("color");
        }
        String quote = Pattern.quote(f.G);
        m.e(quote, "quote(...)");
        List e10 = new kotlin.text.h(quote).e(readableMap.getString("keypath") + ".**", 0);
        if (!e10.isEmpty()) {
            ListIterator listIterator = e10.listIterator(e10.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        list = r.t0(e10, listIterator.nextIndex() + 1);
                        break;
                    }
                } else {
                    break;
                }
            }
            String[] strArr = (String[]) list.toArray(new String[0]);
            lottieAnimationView.i(new e((String[]) Arrays.copyOf(strArr, strArr.length)), r0.K, new c(new z0(i10)));
        }
        list = r.l();
        String[] strArr2 = (String[]) list.toArray(new String[0]);
        lottieAnimationView.i(new e((String[]) Arrays.copyOf(strArr2, strArr2.length)), r0.K, new c(new z0(i10)));
    }

    public final void a() {
        int i10;
        Object obj;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f17567a.get();
        if (lottieAnimationView != null) {
            ReadableArray readableArray = this.f17576j;
            if (readableArray != null && readableArray.size() > 0) {
                a1 a1Var = new a1(lottieAnimationView);
                int size = readableArray.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ReadableMap map = readableArray.getMap(i11);
                    if (map != null) {
                        a1Var.e(map.getString("find"), map.getString("replace"));
                    }
                }
                lottieAnimationView.setTextDelegate(a1Var);
            }
            String str = this.f17579m;
            if (str != null) {
                lottieAnimationView.A(str, String.valueOf(str.hashCode()));
                this.f17579m = null;
            }
            String str2 = this.f17580n;
            if (str2 != null) {
                File file = new File(str2);
                if (file.exists()) {
                    lottieAnimationView.y(new FileInputStream(file), String.valueOf(str2.hashCode()));
                } else {
                    lottieAnimationView.B(str2, String.valueOf(str2.hashCode()));
                }
                this.f17580n = null;
            }
            String str3 = this.f17581o;
            if (str3 != null) {
                File file2 = new File(str3);
                if (file2.exists()) {
                    lottieAnimationView.z(new ZipInputStream(new FileInputStream(file2)), String.valueOf(str3.hashCode()));
                    this.f17581o = null;
                    return;
                }
                try {
                    o.a aVar = o.f12592b;
                    obj = o.b(Uri.parse(str3).getScheme());
                } catch (Throwable th) {
                    o.a aVar2 = o.f12592b;
                    obj = o.b(p.a(th));
                }
                if (o.f(obj)) {
                    obj = null;
                }
                String str4 = (String) obj;
                if (str4 != null) {
                    if (m.b(str4, "file")) {
                        String path = Uri.parse(str3).getPath();
                        if (path != null) {
                            lottieAnimationView.z(new ZipInputStream(new FileInputStream(new File(path))), String.valueOf(str3.hashCode()));
                        } else {
                            Log.w(this.f17568b, "URI path is null for asset: " + str3);
                        }
                    } else {
                        lottieAnimationView.setAnimationFromUrl(str3);
                    }
                    this.f17581o = null;
                    return;
                }
                int identifier = lottieAnimationView.getResources().getIdentifier(str3, "raw", lottieAnimationView.getContext().getPackageName());
                if (identifier == 0) {
                    o7.c.a("Animation for " + str3 + " was not found in raw resources");
                    return;
                }
                lottieAnimationView.setAnimation(identifier);
                this.f17569c = false;
                this.f17581o = null;
            }
            if (this.f17569c) {
                lottieAnimationView.setAnimation(this.f17570d);
                this.f17569c = false;
            }
            Float f10 = this.f17582p;
            if (f10 != null) {
                lottieAnimationView.setProgress(f10.floatValue());
                this.f17582p = null;
            }
            Boolean bool = this.f17583q;
            if (bool != null) {
                if (bool.booleanValue()) {
                    i10 = -1;
                } else {
                    i10 = 0;
                }
                lottieAnimationView.setRepeatCount(i10);
                this.f17583q = null;
            }
            Boolean bool2 = this.f17584r;
            if (bool2 != null && bool2.booleanValue() && !lottieAnimationView.q()) {
                lottieAnimationView.v();
            }
            Float f11 = this.f17585s;
            if (f11 != null) {
                lottieAnimationView.setSpeed(f11.floatValue());
                this.f17585s = null;
            }
            ImageView.ScaleType scaleType = this.f17571e;
            if (scaleType != null) {
                lottieAnimationView.setScaleType(scaleType);
                this.f17571e = null;
            }
            y0 y0Var = this.f17577k;
            if (y0Var != null) {
                lottieAnimationView.setRenderMode(y0Var);
                this.f17577k = null;
            }
            Integer num = this.f17578l;
            if (num != null) {
                lottieAnimationView.setLayerType(num.intValue(), (Paint) null);
            }
            String str5 = this.f17572f;
            if (str5 != null) {
                lottieAnimationView.setImageAssetsFolder(str5);
                this.f17572f = null;
            }
            Boolean bool3 = this.f17573g;
            if (bool3 != null) {
                lottieAnimationView.m(bool3.booleanValue());
                this.f17573g = null;
            }
            Boolean bool4 = this.f17574h;
            if (bool4 != null) {
                lottieAnimationView.setSafeMode(bool4.booleanValue());
                this.f17574h = null;
            }
            ReadableArray readableArray2 = this.f17575i;
            if (readableArray2 != null && readableArray2.size() > 0) {
                int size2 = readableArray2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    ReadableMap map2 = readableArray2.getMap(i12);
                    if (map2 != null) {
                        b(map2, lottieAnimationView);
                    }
                }
            }
        }
    }

    public final void c(String str) {
        this.f17579m = str;
    }

    public final void d(String str) {
        this.f17570d = str;
        this.f17569c = true;
    }

    public final void e(String str) {
        this.f17580n = str;
    }

    public final void f(Boolean bool) {
        this.f17584r = bool;
    }

    public final void g(ReadableArray readableArray) {
        this.f17575i = readableArray;
    }

    public final void h(Boolean bool) {
        this.f17573g = bool;
    }

    public final void i(Boolean bool) {
        this.f17574h = bool;
    }

    public final void j(String str) {
        this.f17572f = str;
    }

    public final void k(Integer num) {
        this.f17578l = num;
    }

    public final void l(Boolean bool) {
        this.f17583q = bool;
    }

    public final void m(Float f10) {
        this.f17582p = f10;
    }

    public final void n(y0 y0Var) {
        this.f17577k = y0Var;
    }

    public final void o(ImageView.ScaleType scaleType) {
        this.f17571e = scaleType;
    }

    public final void p(String str) {
        this.f17581o = str;
    }

    public final void q(Float f10) {
        this.f17585s = f10;
    }

    public final void r(ReadableArray readableArray) {
        this.f17576j = readableArray;
    }
}
