package w7;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.adjust.sdk.Constants;
import com.facebook.react.views.text.n;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class c extends MetricAffectingSpan implements e {

    /* renamed from: f  reason: collision with root package name */
    public static final a f13193f = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f13194a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13195b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13196c;

    /* renamed from: d  reason: collision with root package name */
    private final String f13197d;

    /* renamed from: e  reason: collision with root package name */
    private final AssetManager f13198e;

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final void b(Paint paint, int i10, int i11, String str, String str2, AssetManager assetManager) {
            Typeface a10 = n.a(paint.getTypeface(), i10, i11, str2, assetManager);
            m.e(a10, "applyStyles(...)");
            paint.setFontFeatureSettings(str);
            paint.setTypeface(a10);
            paint.setSubpixelText(true);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(int i10, int i11, String str, String str2, AssetManager assetManager) {
        m.f(assetManager, "assetManager");
        this.f13194a = i10;
        this.f13195b = i11;
        this.f13196c = str;
        this.f13197d = str2;
        this.f13198e = assetManager;
    }

    public final String a() {
        return this.f13197d;
    }

    public final String b() {
        return this.f13196c;
    }

    public final int c() {
        int i10 = this.f13194a;
        if (i10 == -1) {
            return 0;
        }
        return i10;
    }

    public final int d() {
        int i10 = this.f13195b;
        if (i10 == -1) {
            return Constants.MINIMAL_ERROR_STATUS_CODE;
        }
        return i10;
    }

    public void updateDrawState(TextPaint textPaint) {
        m.f(textPaint, "ds");
        f13193f.b(textPaint, this.f13194a, this.f13195b, this.f13196c, this.f13197d, this.f13198e);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m.f(textPaint, "paint");
        f13193f.b(textPaint, this.f13194a, this.f13195b, this.f13196c, this.f13197d, this.f13198e);
    }
}
