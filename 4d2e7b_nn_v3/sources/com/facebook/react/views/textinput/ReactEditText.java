package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.util.Predicate;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.k1;
import com.facebook.react.views.text.i;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import com.facebook.react.views.text.n;
import com.facebook.react.views.text.q;
import com.facebook.react.views.text.r;
import com.facebook.react.views.view.e;
import com.google.android.games.paddleboat.GameControllerManager;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ReactEditText extends AppCompatEditText {
    /* access modifiers changed from: private */

    /* renamed from: i1  reason: collision with root package name */
    public static final KeyListener f4278i1 = QwertyKeyListener.getInstanceForFullKeyboard();
    private boolean C;
    private String N0;
    private m0 O0;
    private a P0;
    private l0 Q0;
    private c R0;
    private boolean S0 = false;
    private boolean T0 = false;
    private q U0;
    private boolean V0 = false;
    private String W0 = null;
    private int X0 = -1;
    private int Y0 = -1;
    private boolean Z0 = false;

    /* renamed from: a  reason: collision with root package name */
    private final InputMethodManager f4279a;
    /* access modifiers changed from: private */

    /* renamed from: a1  reason: collision with root package name */
    public boolean f4280a1 = false;

    /* renamed from: b  reason: collision with root package name */
    private final String f4281b = ReactEditText.class.getSimpleName();

    /* renamed from: b1  reason: collision with root package name */
    private boolean f4282b1 = false;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f4283c;

    /* renamed from: c1  reason: collision with root package name */
    private String f4284c1 = null;

    /* renamed from: d  reason: collision with root package name */
    private final int f4285d;

    /* renamed from: d1  reason: collision with root package name */
    private final e f4286d1;

    /* renamed from: e  reason: collision with root package name */
    private final int f4287e;

    /* renamed from: e1  reason: collision with root package name */
    private d1 f4288e1 = null;

    /* renamed from: f  reason: collision with root package name */
    protected int f4289f;

    /* renamed from: f1  reason: collision with root package name */
    protected boolean f4290f1 = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f4291g;

    /* renamed from: g1  reason: collision with root package name */
    protected boolean f4292g1 = false;

    /* renamed from: h  reason: collision with root package name */
    private d f4293h;

    /* renamed from: h1  reason: collision with root package name */
    private com.facebook.react.uimanager.events.e f4294h1;

    /* renamed from: i  reason: collision with root package name */
    private int f4295i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f4296j;

    /* renamed from: w  reason: collision with root package name */
    private String f4297w = null;

    class a extends i0 {
        a(View view, boolean z10, int i10) {
            super(view, z10, i10);
        }

        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 != 16) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            int length = ReactEditText.this.getText().length();
            if (length > 0) {
                ReactEditText.this.setSelection(length);
            }
            return ReactEditText.this.M();
        }
    }

    class b implements ActionMode.Callback {
        b() {
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            if (ReactEditText.this.f4280a1) {
                return false;
            }
            menu.removeItem(16908337);
            return true;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }
    }

    private static class c implements KeyListener {

        /* renamed from: a  reason: collision with root package name */
        private int f4300a = 0;

        public void a(int i10) {
            this.f4300a = i10;
        }

        public void clearMetaKeyState(View view, Editable editable, int i10) {
            ReactEditText.f4278i1.clearMetaKeyState(view, editable, i10);
        }

        public int getInputType() {
            return this.f4300a;
        }

        public boolean onKeyDown(View view, Editable editable, int i10, KeyEvent keyEvent) {
            return ReactEditText.f4278i1.onKeyDown(view, editable, i10, keyEvent);
        }

        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return ReactEditText.f4278i1.onKeyOther(view, editable, keyEvent);
        }

        public boolean onKeyUp(View view, Editable editable, int i10, KeyEvent keyEvent) {
            return ReactEditText.f4278i1.onKeyUp(view, editable, i10, keyEvent);
        }
    }

    private class d implements TextWatcher {
        public void afterTextChanged(Editable editable) {
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.f4283c && reactEditText.f4291g != null) {
                Iterator it = ReactEditText.this.f4291g.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).afterTextChanged(editable);
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.f4283c && reactEditText.f4291g != null) {
                Iterator it = ReactEditText.this.f4291g.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).beforeTextChanged(charSequence, i10, i11, i12);
                }
            }
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ReactEditText reactEditText = ReactEditText.this;
            if (!reactEditText.f4283c && reactEditText.f4291g != null) {
                Iterator it = ReactEditText.this.f4291g.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(charSequence, i10, i11, i12);
                }
            }
            ReactEditText.this.X();
            ReactEditText.this.K();
        }

        private d() {
        }
    }

    public ReactEditText(Context context) {
        super(context);
        setFocusableInTouchMode(false);
        this.f4286d1 = new e(this);
        this.f4279a = (InputMethodManager) p5.a.c(context.getSystemService("input_method"));
        this.f4285d = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        this.f4287e = getGravity() & 112;
        this.f4289f = 0;
        this.f4283c = false;
        this.C = false;
        this.f4291g = null;
        this.f4293h = null;
        this.f4295i = getInputType();
        if (this.R0 == null) {
            this.R0 = new c();
        }
        this.Q0 = null;
        this.U0 = new q();
        o();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26 && i10 <= 27) {
            setLayerType(1, (Paint) null);
        }
        ViewCompat.setAccessibilityDelegate(this, new a(this, isFocusable(), getImportantForAccessibility()));
        b bVar = new b();
        setCustomSelectionActionModeCallback(bVar);
        setCustomInsertionActionModeCallback(bVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean A(ReactStrikethroughSpan reactStrikethroughSpan) {
        if ((getPaintFlags() & 16) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean B(ReactUnderlineSpan reactUnderlineSpan) {
        if ((getPaintFlags() & 8) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean C(w7.a aVar) {
        if (aVar.b() == this.U0.d()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean D(w7.c cVar) {
        if (cVar.c() != this.Y0 || !Objects.equals(cVar.a(), this.W0) || cVar.d() != this.X0 || !Objects.equals(cVar.b(), getFontFeatureSettings())) {
            return false;
        }
        return true;
    }

    private void E(SpannableStringBuilder spannableStringBuilder) {
        boolean z10;
        Object[] spans = getText().getSpans(0, length(), Object.class);
        for (Object obj : spans) {
            int spanFlags = getText().getSpanFlags(obj);
            if ((spanFlags & 33) == 33) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (obj instanceof w7.e) {
                getText().removeSpan(obj);
            }
            if (z10) {
                int spanStart = getText().getSpanStart(obj);
                int spanEnd = getText().getSpanEnd(obj);
                getText().removeSpan(obj);
                if (N(getText(), spannableStringBuilder, spanStart, spanEnd)) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void K() {
        a aVar = this.P0;
        if (aVar != null) {
            aVar.a();
        }
        R();
    }

    /* access modifiers changed from: private */
    public boolean M() {
        setFocusableInTouchMode(true);
        boolean requestFocus = super.requestFocus(130, (Rect) null);
        if (getShowSoftInputOnFocus()) {
            U();
        }
        return requestFocus;
    }

    private static boolean N(Editable editable, SpannableStringBuilder spannableStringBuilder, int i10, int i11) {
        if (i10 > spannableStringBuilder.length() || i11 > spannableStringBuilder.length()) {
            return false;
        }
        while (i10 < i11) {
            if (editable.charAt(i10) != spannableStringBuilder.charAt(i10)) {
                return false;
            }
            i10++;
        }
        return true;
    }

    private void R() {
        ReactContext d10 = k1.d(this);
        if (this.f4288e1 == null && !d10.isBridgeless()) {
            q qVar = new q(this);
            UIManagerModule uIManagerModule = (UIManagerModule) d10.getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.setViewLocalData(getId(), qVar);
            }
        }
    }

    private void V(SpannableStringBuilder spannableStringBuilder, Class cls, Predicate predicate) {
        for (Object obj : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), cls)) {
            if (predicate.test(obj)) {
                spannableStringBuilder.removeSpan(obj);
            }
        }
    }

    private void W(SpannableStringBuilder spannableStringBuilder) {
        V(spannableStringBuilder, ReactAbsoluteSizeSpan.class, new c(this));
        V(spannableStringBuilder, ReactBackgroundColorSpan.class, new d(this));
        V(spannableStringBuilder, ReactForegroundColorSpan.class, new e(this));
        V(spannableStringBuilder, ReactStrikethroughSpan.class, new f(this));
        V(spannableStringBuilder, ReactUnderlineSpan.class, new g(this));
        V(spannableStringBuilder, w7.a.class, new h(this));
        V(spannableStringBuilder, w7.c.class, new i(this));
    }

    /* access modifiers changed from: private */
    public void X() {
        boolean z10;
        if (this.f4288e1 != null && getId() != -1) {
            Editable text = getText();
            if (text == null || text.length() <= 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (z10) {
                try {
                    spannableStringBuilder.append(text.subSequence(0, text.length()));
                } catch (IndexOutOfBoundsException e10) {
                    ReactSoftExceptionLogger.logSoftException(this.f4281b, e10);
                }
            }
            if (!z10) {
                if (getHint() == null || getHint().length() <= 0) {
                    spannableStringBuilder.append("I");
                } else {
                    spannableStringBuilder.append(getHint());
                }
            }
            n(spannableStringBuilder);
            r.l(getId(), spannableStringBuilder);
        }
    }

    private void Y() {
        int i10 = 5;
        String str = this.N0;
        if (str != null) {
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -1273775369:
                    if (str.equals("previous")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -906336856:
                    if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 3304:
                    if (str.equals("go")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 3387192:
                    if (str.equals(DevicePublicKeyStringDef.NONE)) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        c10 = 6;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    i10 = 7;
                    break;
                case 1:
                    i10 = 3;
                    break;
                case 2:
                    i10 = 2;
                    break;
                case 4:
                    break;
                case 5:
                    i10 = 1;
                    break;
                case 6:
                    i10 = 4;
                    break;
            }
        }
        i10 = 6;
        if (this.C) {
            setImeOptions(i10 | GameControllerManager.DEVICEFLAG_LIGHT_RGB);
        } else {
            setImeOptions(i10);
        }
    }

    private d getTextWatcherDelegator() {
        if (this.f4293h == null) {
            this.f4293h = new d();
        }
        return this.f4293h;
    }

    private void n(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.setSpan(new ReactAbsoluteSizeSpan(this.U0.c()), 0, spannableStringBuilder.length(), 16711698);
        spannableStringBuilder.setSpan(new ReactForegroundColorSpan(getCurrentTextColor()), 0, spannableStringBuilder.length(), 16711698);
        int b10 = this.f4286d1.b();
        if (b10 != 0) {
            spannableStringBuilder.setSpan(new ReactBackgroundColorSpan(b10), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 16) != 0) {
            spannableStringBuilder.setSpan(new ReactStrikethroughSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 8) != 0) {
            spannableStringBuilder.setSpan(new ReactUnderlineSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        float d10 = this.U0.d();
        if (!Float.isNaN(d10)) {
            spannableStringBuilder.setSpan(new w7.a(d10), 0, spannableStringBuilder.length(), 16711698);
        }
        if (!(this.Y0 == -1 && this.X0 == -1 && this.W0 == null && getFontFeatureSettings() == null)) {
            spannableStringBuilder.setSpan(new w7.c(this.Y0, this.X0, getFontFeatureSettings(), this.W0, getContext().getAssets()), 0, spannableStringBuilder.length(), 16711698);
        }
        float e10 = this.U0.e();
        if (!Float.isNaN(e10)) {
            spannableStringBuilder.setSpan(new w7.b(e10), 0, spannableStringBuilder.length(), 16711698);
        }
    }

    private int q(int i10) {
        int i11;
        if (getText() == null) {
            i11 = 0;
        } else {
            i11 = getText().length();
        }
        return Math.max(0, Math.min(i10, i11));
    }

    private boolean w() {
        if ((getInputType() & 144) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean x(ReactAbsoluteSizeSpan reactAbsoluteSizeSpan) {
        if (reactAbsoluteSizeSpan.getSize() == this.U0.c()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean y(ReactBackgroundColorSpan reactBackgroundColorSpan) {
        if (reactBackgroundColorSpan.getBackgroundColor() == this.f4286d1.b()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean z(ReactForegroundColorSpan reactForegroundColorSpan) {
        if (reactForegroundColorSpan.getForegroundColor() == getCurrentTextColor()) {
            return true;
        }
        return false;
    }

    public void F(int i10, int i11, int i12) {
        if (p(i10) && i11 != -1 && i12 != -1) {
            setSelection(q(i11), q(i12));
        }
    }

    public void G(i iVar) {
        if ((!w() || !TextUtils.equals(getText(), iVar.i())) && p(iVar.c())) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(iVar.i());
            E(spannableStringBuilder);
            W(spannableStringBuilder);
            this.f4296j = iVar.b();
            this.f4290f1 = true;
            if (iVar.i().length() == 0) {
                setText((CharSequence) null);
            } else {
                getText().replace(0, length(), spannableStringBuilder);
            }
            this.f4290f1 = false;
            if (getBreakStrategy() != iVar.k()) {
                setBreakStrategy(iVar.k());
            }
            X();
        }
    }

    public void H(i iVar) {
        this.f4283c = true;
        G(iVar);
        this.f4283c = false;
    }

    public void I(i iVar) {
        this.f4292g1 = true;
        G(iVar);
        this.f4292g1 = false;
    }

    public void J() {
        if (this.V0) {
            this.V0 = false;
            setTypeface(n.a(getTypeface(), this.Y0, this.X0, this.W0, getContext().getAssets()));
            if (this.Y0 == -1 && this.X0 == -1 && this.W0 == null && getFontFeatureSettings() == null) {
                setPaintFlags(getPaintFlags() & -129);
            } else {
                setPaintFlags(getPaintFlags() | 128);
            }
        }
    }

    public void L() {
        M();
    }

    public void O(int i10, float f10, float f11) {
        this.f4286d1.f(i10, f10, f11);
    }

    public void P(float f10, int i10) {
        this.f4286d1.h(f10, i10);
    }

    public void Q(int i10, float f10) {
        this.f4286d1.j(i10, f10);
    }

    public boolean S() {
        String submitBehavior = getSubmitBehavior();
        if (submitBehavior != null) {
            return submitBehavior.equals("blurAndSubmit");
        }
        if (!v()) {
            return true;
        }
        return false;
    }

    public boolean T() {
        String submitBehavior = getSubmitBehavior();
        if (submitBehavior == null) {
            if (v()) {
                return false;
            }
        } else if (!submitBehavior.equals("submit") && !submitBehavior.equals("blurAndSubmit")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean U() {
        return this.f4279a.showSoftInput(this, 0);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        if (this.f4291g == null) {
            this.f4291g = new ArrayList();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        this.f4291g.add(textWatcher);
    }

    public void clearFocus() {
        setFocusableInTouchMode(false);
        super.clearFocus();
        t();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        r.e(getId());
    }

    public boolean getDisableFullscreenUI() {
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public int getGravityHorizontal() {
        return getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
    }

    public String getReturnKeyType() {
        return this.N0;
    }

    /* access modifiers changed from: package-private */
    public int getStagedInputType() {
        return this.f4295i;
    }

    @Nullable
    public d1 getStateWrapper() {
        return this.f4288e1;
    }

    public String getSubmitBehavior() {
        return this.f4297w;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f4296j) {
            Editable text = getText();
            for (w7.i a10 : (w7.i[]) text.getSpans(0, text.length(), w7.i.class)) {
                if (a10.a() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public boolean isLayoutRequested() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void o() {
        setTextSize(0, (float) this.U0.c());
        float d10 = this.U0.d();
        if (!Float.isNaN(d10)) {
            setLetterSpacing(d10);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        super.setTextIsSelectable(true);
        if (this.f4296j) {
            Editable text = getText();
            for (w7.i c10 : (w7.i[]) text.getSpans(0, text.length(), w7.i.class)) {
                c10.c();
            }
        }
        if (this.Z0 && !this.f4282b1) {
            M();
        }
        this.f4282b1 = true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        ReactContext d10 = k1.d(this);
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && this.T0) {
            onCreateInputConnection = new k(onCreateInputConnection, d10, this, this.f4294h1);
        }
        if (v() && (S() || T())) {
            editorInfo.imeOptions &= -1073741825;
        }
        return onCreateInputConnection;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f4296j) {
            Editable text = getText();
            for (w7.i d10 : (w7.i[]) text.getSpans(0, text.length(), w7.i.class)) {
                d10.d();
            }
        }
    }

    public void onDraw(Canvas canvas) {
        this.f4286d1.d(canvas);
        super.onDraw(canvas);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f4296j) {
            Editable text = getText();
            for (w7.i e10 : (w7.i[]) text.getSpans(0, text.length(), w7.i.class)) {
                e10.e();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        m0 m0Var;
        super.onFocusChanged(z10, i10, rect);
        if (z10 && (m0Var = this.O0) != null) {
            m0Var.a(getSelectionStart(), getSelectionEnd());
        }
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 66 || v()) {
            return super.onKeyUp(i10, keyEvent);
        }
        t();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        K();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        l0 l0Var = this.Q0;
        if (l0Var != null) {
            l0Var.a(i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i10, int i11) {
        super.onSelectionChanged(i10, i11);
        if (this.O0 != null && hasFocus()) {
            this.O0.a(i10, i11);
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f4296j) {
            Editable text = getText();
            for (w7.i f10 : (w7.i[]) text.getSpans(0, text.length(), w7.i.class)) {
                f10.f();
            }
        }
    }

    public boolean onTextContextMenuItem(int i10) {
        if (i10 == 16908322) {
            i10 = 16908337;
        }
        return super.onTextContextMenuItem(i10);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.S0 = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && this.S0) {
            if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.S0 = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean p(int i10) {
        if (i10 >= this.f4289f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        clearFocus();
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        ArrayList arrayList = this.f4291g;
        if (arrayList != null) {
            arrayList.remove(textWatcher);
            if (this.f4291g.isEmpty()) {
                this.f4291g = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    public boolean requestFocus(int i10, Rect rect) {
        return isFocused();
    }

    /* access modifiers changed from: package-private */
    public void s() {
        if (getInputType() != this.f4295i) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            setInputType(this.f4295i);
            setSelection(selectionStart, selectionEnd);
        }
    }

    public void setAllowFontScaling(boolean z10) {
        if (this.U0.b() != z10) {
            this.U0.m(z10);
            o();
        }
    }

    public void setAutoFocus(boolean z10) {
        this.Z0 = z10;
    }

    public void setBackgroundColor(int i10) {
        this.f4286d1.e(i10);
    }

    public void setBorderRadius(float f10) {
        this.f4286d1.g(f10);
    }

    public void setBorderStyle(@Nullable String str) {
        this.f4286d1.i(str);
    }

    public void setContentSizeWatcher(@Nullable a aVar) {
        this.P0 = aVar;
    }

    public void setContextMenuHidden(boolean z10) {
        this.f4280a1 = z10;
    }

    public void setDisableFullscreenUI(boolean z10) {
        this.C = z10;
        Y();
    }

    /* access modifiers changed from: package-private */
    public void setEventDispatcher(@Nullable com.facebook.react.uimanager.events.e eVar) {
        this.f4294h1 = eVar;
    }

    public void setFontFamily(String str) {
        this.W0 = str;
        this.V0 = true;
    }

    public void setFontFeatureSettings(String str) {
        if (!Objects.equals(str, getFontFeatureSettings())) {
            super.setFontFeatureSettings(str);
            this.V0 = true;
        }
    }

    public void setFontSize(float f10) {
        this.U0.n(f10);
        o();
    }

    public void setFontStyle(String str) {
        int b10 = n.b(str);
        if (b10 != this.Y0) {
            this.Y0 = b10;
            this.V0 = true;
        }
    }

    public void setFontWeight(String str) {
        int d10 = n.d(str);
        if (d10 != this.X0) {
            this.X0 = d10;
            this.V0 = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void setGravityHorizontal(int i10) {
        if (i10 == 0) {
            i10 = this.f4285d;
        }
        setGravity(i10 | (getGravity() & -8388616));
    }

    /* access modifiers changed from: package-private */
    public void setGravityVertical(int i10) {
        if (i10 == 0) {
            i10 = this.f4287e;
        }
        setGravity(i10 | (getGravity() & -113));
    }

    public void setInputType(int i10) {
        Typeface typeface = super.getTypeface();
        super.setInputType(i10);
        this.f4295i = i10;
        super.setTypeface(typeface);
        if (v()) {
            setSingleLine(false);
        }
        if (this.R0 == null) {
            this.R0 = new c();
        }
        this.R0.a(i10);
        setKeyListener(this.R0);
    }

    public void setLetterSpacingPt(float f10) {
        this.U0.p(f10);
        o();
    }

    public void setLineHeight(int i10) {
        this.U0.q((float) i10);
    }

    public void setMaxFontSizeMultiplier(float f10) {
        if (f10 != this.U0.k()) {
            this.U0.r(f10);
            o();
        }
    }

    public void setOnKeyPress(boolean z10) {
        this.T0 = z10;
    }

    public void setOverflow(@Nullable String str) {
        this.f4286d1.k(str);
    }

    public void setPlaceholder(@Nullable String str) {
        if (!Objects.equals(str, this.f4284c1)) {
            this.f4284c1 = str;
            setHint(str);
        }
    }

    public void setReturnKeyType(String str) {
        this.N0 = str;
        Y();
    }

    public void setScrollWatcher(@Nullable l0 l0Var) {
        this.Q0 = l0Var;
    }

    public void setSelection(int i10, int i11) {
        super.setSelection(i10, i11);
    }

    public void setSelectionWatcher(@Nullable m0 m0Var) {
        this.O0 = m0Var;
    }

    /* access modifiers changed from: package-private */
    public void setStagedInputType(int i10) {
        this.f4295i = i10;
    }

    public void setStateWrapper(d1 d1Var) {
        this.f4288e1 = d1Var;
    }

    public void setSubmitBehavior(@Nullable String str) {
        this.f4297w = str;
    }

    /* access modifiers changed from: protected */
    public void t() {
        this.f4279a.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public int u() {
        int i10 = this.f4289f + 1;
        this.f4289f = i10;
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        if ((getInputType() & 131072) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (this.f4296j) {
            Editable text = getText();
            for (w7.i a10 : (w7.i[]) text.getSpans(0, text.length(), w7.i.class)) {
                if (a10.a() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }
}
