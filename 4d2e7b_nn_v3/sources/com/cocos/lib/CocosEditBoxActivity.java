package com.cocos.lib;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.core.view.ViewCompat;
import com.google.firebase.analytics.FirebaseAnalytics;

public class CocosEditBoxActivity extends Activity {
    private static final int DARK_GREEN = Color.parseColor("#1fa014");
    private static final int DARK_GREEN_PRESS = Color.parseColor("#008e26");
    /* access modifiers changed from: private */
    public static CocosEditBoxActivity sThis = null;
    public static int statusBarState = 1;
    private Button mButton = null;
    private int mButtonLayoutID = 2;
    /* access modifiers changed from: private */
    public String mButtonTitle = null;
    /* access modifiers changed from: private */
    public boolean mConfirmHold = true;
    /* access modifiers changed from: private */
    public Cocos2dxEditText mEditText = null;
    private int mEditTextID = 1;

    class Cocos2dxEditText extends EditText {

        /* renamed from: a  reason: collision with root package name */
        private final String f19250a = "Cocos2dxEditBox";
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f19251b = false;

        /* renamed from: c  reason: collision with root package name */
        private TextWatcher f19252c = null;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f19253d = false;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f19254e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f19255f = false;

        class a implements TextWatcher {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CocosEditBoxActivity f19257a;

            a(CocosEditBoxActivity cocosEditBoxActivity) {
                this.f19257a = cocosEditBoxActivity;
            }

            public void afterTextChanged(Editable editable) {
                CocosEditBoxActivity.this.onKeyboardInput(editable.toString());
            }

            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        }

        class b implements TextView.OnEditorActionListener {
            b() {
            }

            public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                if (Cocos2dxEditText.this.f19251b) {
                    return false;
                }
                CocosEditBoxActivity.this.hide();
                return false;
            }
        }

        class c implements ViewTreeObserver.OnGlobalLayoutListener {

            class a implements Runnable {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f19261a;

                a(String str) {
                    this.f19261a = str;
                }

                public void run() {
                    CocosJavascriptJavaBridge.evalString(this.f19261a);
                }
            }

            c() {
            }

            public void onGlobalLayout() {
                Rect rect = new Rect();
                Cocos2dxEditText.this.getWindowVisibleDisplayFrame(rect);
                int height = Cocos2dxEditText.this.getRootView().getHeight() - (rect.bottom - rect.top);
                if (height > Cocos2dxEditText.this.f19254e / 4) {
                    if (!Cocos2dxEditText.this.f19253d) {
                        Cocos2dxEditText.this.f19253d = true;
                        Log.d("CocosEditBoxActivity", "打开键盘");
                        CocosHelper.runOnGameThread(new a(String.format("window['G']?.PlatformUtils?.GetKeyBoardHeight(%d);", new Object[]{Integer.valueOf(height)})));
                    }
                } else if (Cocos2dxEditText.this.f19253d) {
                    Cocos2dxEditText.this.f19253d = false;
                    CocosEditBoxActivity.this.hide();
                }
            }
        }

        public Cocos2dxEditText(Activity activity) {
            super(activity);
            setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.f19254e = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getHeight();
            this.f19252c = new a(CocosEditBoxActivity.this);
            f();
        }

        private void e() {
            setOnEditorActionListener(new b());
            addTextChangedListener(this.f19252c);
        }

        private void f() {
            getViewTreeObserver().addOnGlobalLayoutListener(new c());
        }

        private void g(String str) {
            if (str.contentEquals("done")) {
                setImeOptions(268435462);
                CocosEditBoxActivity.this.mButtonTitle = getResources().getString(R.string.done);
            } else if (str.contentEquals("next")) {
                setImeOptions(268435461);
                CocosEditBoxActivity.this.mButtonTitle = getResources().getString(R.string.next);
            } else if (str.contentEquals(FirebaseAnalytics.Event.SEARCH)) {
                setImeOptions(268435459);
                CocosEditBoxActivity.this.mButtonTitle = getResources().getString(R.string.search);
            } else if (str.contentEquals("go")) {
                setImeOptions(268435458);
                CocosEditBoxActivity.this.mButtonTitle = getResources().getString(R.string.go);
            } else if (str.contentEquals("send")) {
                setImeOptions(268435460);
                CocosEditBoxActivity.this.mButtonTitle = getResources().getString(R.string.send);
            } else {
                CocosEditBoxActivity.this.mButtonTitle = null;
                Log.e("Cocos2dxEditBox", "unknown confirm type " + str);
            }
        }

        private void h(String str, boolean z10) {
            this.f19255f = false;
            if (str.contentEquals("text")) {
                if (z10) {
                    setInputType(131073);
                } else {
                    setInputType(1);
                }
            } else if (str.contentEquals("email")) {
                setInputType(32);
            } else if (str.contentEquals("number")) {
                setInputType(12290);
            } else if (str.contentEquals(HintConstants.AUTOFILL_HINT_PHONE)) {
                setInputType(3);
            } else if (str.contentEquals(HintConstants.AUTOFILL_HINT_PASSWORD)) {
                if (Build.BRAND.equalsIgnoreCase("oppo")) {
                    this.f19255f = true;
                }
                setInputType(129);
            } else if (str.contentEquals("password_num")) {
                setInputType(130);
            } else {
                Log.e("Cocos2dxEditBox", "unknown input type " + str);
            }
        }

        public void i(String str, int i10, boolean z10, boolean z11, String str2, String str3) {
            this.f19251b = z10;
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i10)});
            setText(str);
            if (getText().length() >= str.length()) {
                setSelection(str.length());
            } else {
                setSelection(getText().length());
            }
            g(str2);
            h(str3, this.f19251b);
            setVisibility(0);
            requestFocus();
            e();
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            CocosEditBoxActivity.this.hide();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            CocosEditBoxActivity cocosEditBoxActivity = CocosEditBoxActivity.this;
            cocosEditBoxActivity.onKeyboardConfirm(cocosEditBoxActivity.mEditText.getText().toString());
            if (!CocosEditBoxActivity.this.mConfirmHold) {
                CocosEditBoxActivity.this.hide();
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19265a;

        c(String str) {
            this.f19265a = str;
        }

        public void run() {
            CocosJavascriptJavaBridge.evalString(this.f19265a);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19268b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f19269c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f19270d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f19271e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f19272f;

        d(String str, int i10, boolean z10, boolean z11, String str2, String str3) {
            this.f19267a = str;
            this.f19268b = i10;
            this.f19269c = z10;
            this.f19270d = z11;
            this.f19271e = str2;
            this.f19272f = str3;
        }

        public void run() {
            Intent intent = new Intent(GlobalObject.getActivity(), CocosEditBoxActivity.class);
            intent.putExtra("defaultValue", this.f19267a);
            intent.putExtra("maxLength", this.f19268b);
            intent.putExtra("isMultiline", this.f19269c);
            intent.putExtra("confirmHold", this.f19270d);
            intent.putExtra("confirmType", this.f19271e);
            intent.putExtra("inputType", this.f19272f);
            GlobalObject.getActivity().startActivity(intent);
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            CocosEditBoxActivity.sThis.hide();
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19273a;

        f(String str) {
            this.f19273a = str;
        }

        public void run() {
            CocosEditBoxActivity.onKeyboardInputNative(this.f19273a);
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19275a;

        g(String str) {
            this.f19275a = str;
        }

        public void run() {
            CocosEditBoxActivity.onKeyboardCompleteNative(this.f19275a);
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f19277a;

        h(String str) {
            this.f19277a = str;
        }

        public void run() {
            CocosEditBoxActivity.onKeyboardConfirmNative(this.f19277a);
        }
    }

    private void addButton(RelativeLayout relativeLayout) {
        this.mButton = new Button(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.mButton.setTextColor(-1);
        this.mButton.setTextSize(16.0f);
        this.mButton.setBackground(getRoundRectShape(18, DARK_GREEN, DARK_GREEN_PRESS));
        int dpToPixel = dpToPixel(5);
        this.mButton.setPadding(dpToPixel, 0, dpToPixel, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(6, this.mEditTextID);
        layoutParams.addRule(8, this.mEditTextID);
        layoutParams.rightMargin = dpToPixel(4);
        relativeLayout.addView(this.mButton, layoutParams);
        this.mButton.setGravity(17);
        this.mButton.setId(this.mButtonLayoutID);
        this.mButton.setOnClickListener(new b());
    }

    private void addEditText(RelativeLayout relativeLayout) {
        Cocos2dxEditText cocos2dxEditText = new Cocos2dxEditText(this);
        this.mEditText = cocos2dxEditText;
        cocos2dxEditText.setVisibility(4);
        this.mEditText.setGravity(16);
        this.mEditText.setBackground(getRoundRectShape(18, -1, -1));
        this.mEditText.setId(this.mEditTextID);
        int dpToPixel = dpToPixel(4);
        int dpToPixel2 = dpToPixel(3);
        this.mEditText.setPadding(dpToPixel2, dpToPixel, dpToPixel2, dpToPixel);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, this.mButtonLayoutID);
        int dpToPixel3 = dpToPixel(5);
        layoutParams.setMargins(dpToPixel(4), dpToPixel3, dpToPixel3, dpToPixel3);
        relativeLayout.addView(this.mEditText, layoutParams);
    }

    private void addItems(RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setBackgroundColor(Color.argb(255, 244, 244, 244));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(relativeLayout2, layoutParams);
        addEditText(relativeLayout2);
        addButton(relativeLayout2);
    }

    private void closeKeyboard() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
        onKeyboardComplete(this.mEditText.getText().toString());
    }

    private int dpToPixel(int i10) {
        return (int) ((((float) i10) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private Drawable getRoundRectShape(int i10, int i11, int i12) {
        float f10 = (float) i10;
        RoundRectShape roundRectShape = new RoundRectShape(new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, (RectF) null, (float[]) null);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(roundRectShape);
        Paint paint = shapeDrawable.getPaint();
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        shapeDrawable.getPaint().setColor(i11);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable();
        shapeDrawable2.setShape(roundRectShape);
        shapeDrawable2.getPaint().setStyle(style);
        shapeDrawable2.getPaint().setColor(i12);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, shapeDrawable2);
        stateListDrawable.addState(new int[0], shapeDrawable);
        return stateListDrawable;
    }

    /* access modifiers changed from: private */
    public void hide() {
        Utils.hideVirtualButton();
        closeKeyboard();
        finish();
    }

    private static void hideNative() {
        if (sThis != null) {
            GlobalObject.runOnUiThread(new e());
        }
    }

    private void onKeyboardComplete(String str) {
        CocosHelper.runOnGameThread(new g(str));
    }

    /* access modifiers changed from: private */
    public static native void onKeyboardCompleteNative(String str);

    /* access modifiers changed from: private */
    public void onKeyboardConfirm(String str) {
        CocosHelper.runOnGameThread(new h(str));
    }

    /* access modifiers changed from: private */
    public static native void onKeyboardConfirmNative(String str);

    /* access modifiers changed from: private */
    public void onKeyboardInput(String str) {
        CocosHelper.runOnGameThread(new f(str));
    }

    /* access modifiers changed from: private */
    public static native void onKeyboardInputNative(String str);

    private void openKeyboard() {
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.mEditText, 1);
    }

    private static void showNative(String str, int i10, boolean z10, boolean z11, String str2, String str3) {
        GlobalObject.runOnUiThread(new d(str, i10, z10, z11, str2, str3));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        sThis = this;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setClickable(true);
        relativeLayout.setOnClickListener(new a());
        setContentView(relativeLayout);
        addItems(relativeLayout);
        Intent intent = getIntent();
        if (intent != null) {
            bundle2 = intent.getExtras();
        } else {
            bundle2 = null;
        }
        if (bundle2 == null) {
            show("", 10, false, false, "done", "text");
        } else {
            show(bundle2.getString("defaultValue"), bundle2.getInt("maxLength"), bundle2.getBoolean("isMultiline"), bundle2.getBoolean("confirmHold"), bundle2.getString("confirmType"), bundle2.getString("inputType"));
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        int i10 = statusBarState;
        if (i10 == 1) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        } else if (i10 == 2) {
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Log.d("CocosEditBoxActivity", "关闭键盘");
        CocosHelper.runOnGameThread(new c(String.format("window['G']?.PlatformUtils?.GetKeyBoardHeight(%d);", new Object[]{0})));
    }

    public void show(String str, int i10, boolean z10, boolean z11, String str2, String str3) {
        this.mConfirmHold = z11;
        this.mEditText.i(str, i10, z10, z11, str2, str3);
        this.mButton.setText(this.mButtonTitle);
        if (TextUtils.isEmpty(this.mButtonTitle)) {
            this.mButton.setVisibility(4);
        } else {
            this.mButton.setVisibility(0);
        }
        openKeyboard();
    }
}
