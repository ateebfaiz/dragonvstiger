package com.facebook.react.views.textinput;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.autofill.HintConstants;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.adjust.sdk.Constants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.v;
import com.facebook.react.uimanager.v0;
import com.facebook.react.views.scroll.f;
import com.facebook.react.views.text.i;
import com.facebook.react.views.text.m;
import com.facebook.react.views.text.n;
import com.facebook.react.views.text.p;
import com.facebook.react.views.text.r;
import com.facebook.react.views.text.s;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@s6.a(name = "AndroidTextInput")
public class ReactTextInputManager extends BaseViewManager<ReactEditText, v> {
    private static final int AUTOCAPITALIZE_FLAGS = 28672;
    private static final int BLUR_TEXT_INPUT = 2;
    private static final String[] DRAWABLE_HANDLE_FIELDS = {"mSelectHandleLeft", "mSelectHandleRight", "mSelectHandleCenter"};
    private static final String[] DRAWABLE_HANDLE_RESOURCES = {"mTextSelectHandleLeftRes", "mTextSelectHandleRightRes", "mTextSelectHandleRes"};
    private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
    private static final int FOCUS_TEXT_INPUT = 1;
    private static final int IME_ACTION_ID = 1648;
    private static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    private static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    private static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    private static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    private static final String KEYBOARD_TYPE_URI = "url";
    private static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    private static final int PASSWORD_VISIBILITY_FLAG = 16;
    public static final String REACT_CLASS = "AndroidTextInput";
    private static final Map<String, String> REACT_PROPS_AUTOFILL_HINTS_MAP = new a();
    private static final int SET_MOST_RECENT_EVENT_COUNT = 3;
    private static final int SET_TEXT_AND_SELECTION = 4;
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    public static final String TAG = "ReactTextInputManager";
    private static final short TX_STATE_KEY_ATTRIBUTED_STRING = 0;
    private static final short TX_STATE_KEY_HASH = 2;
    private static final short TX_STATE_KEY_MOST_RECENT_EVENT_COUNT = 3;
    private static final short TX_STATE_KEY_PARAGRAPH_ATTRIBUTES = 1;
    private static final int UNSET = -1;
    @Nullable
    protected m mReactTextViewManagerCallback;

    class a extends HashMap {
        a() {
            put("birthdate-day", HintConstants.AUTOFILL_HINT_BIRTH_DATE_DAY);
            put("birthdate-full", HintConstants.AUTOFILL_HINT_BIRTH_DATE_FULL);
            put("birthdate-month", HintConstants.AUTOFILL_HINT_BIRTH_DATE_MONTH);
            put("birthdate-year", HintConstants.AUTOFILL_HINT_BIRTH_DATE_YEAR);
            put("cc-csc", HintConstants.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE);
            put("cc-exp", HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE);
            put("cc-exp-day", HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY);
            put("cc-exp-month", HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH);
            put("cc-exp-year", HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR);
            put("cc-number", HintConstants.AUTOFILL_HINT_CREDIT_CARD_NUMBER);
            put("email", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS);
            put(HintConstants.AUTOFILL_HINT_GENDER, HintConstants.AUTOFILL_HINT_GENDER);
            put("name", HintConstants.AUTOFILL_HINT_PERSON_NAME);
            put("name-family", HintConstants.AUTOFILL_HINT_PERSON_NAME_FAMILY);
            put("name-given", HintConstants.AUTOFILL_HINT_PERSON_NAME_GIVEN);
            put("name-middle", HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE);
            put("name-middle-initial", HintConstants.AUTOFILL_HINT_PERSON_NAME_MIDDLE_INITIAL);
            put("name-prefix", HintConstants.AUTOFILL_HINT_PERSON_NAME_PREFIX);
            put("name-suffix", HintConstants.AUTOFILL_HINT_PERSON_NAME_SUFFIX);
            put(HintConstants.AUTOFILL_HINT_PASSWORD, HintConstants.AUTOFILL_HINT_PASSWORD);
            put("password-new", HintConstants.AUTOFILL_HINT_NEW_PASSWORD);
            put("postal-address", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS);
            put("postal-address-country", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY);
            put("postal-address-extended", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS);
            put("postal-address-extended-postal-code", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_POSTAL_CODE);
            put("postal-address-locality", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY);
            put("postal-address-region", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_REGION);
            put("postal-code", HintConstants.AUTOFILL_HINT_POSTAL_CODE);
            put("street-address", HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS);
            put("sms-otp", HintConstants.AUTOFILL_HINT_SMS_OTP);
            put("tel", HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
            put("tel-country-code", HintConstants.AUTOFILL_HINT_PHONE_COUNTRY_CODE);
            put("tel-national", HintConstants.AUTOFILL_HINT_PHONE_NATIONAL);
            put("tel-device", HintConstants.AUTOFILL_HINT_PHONE_NUMBER_DEVICE);
            put(HintConstants.AUTOFILL_HINT_USERNAME, HintConstants.AUTOFILL_HINT_USERNAME);
            put("username-new", HintConstants.AUTOFILL_HINT_NEW_USERNAME);
        }
    }

    private static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final ReactEditText f4302a;

        /* renamed from: b  reason: collision with root package name */
        private final com.facebook.react.uimanager.events.e f4303b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4304c;

        /* renamed from: d  reason: collision with root package name */
        private int f4305d = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f4306e = 0;

        public b(ReactEditText reactEditText) {
            this.f4302a = reactEditText;
            ReactContext d10 = k1.d(reactEditText);
            this.f4303b = ReactTextInputManager.getEventDispatcher(d10, reactEditText);
            this.f4304c = k1.e(d10);
        }

        public void a() {
            if (this.f4303b != null) {
                int width = this.f4302a.getWidth();
                int height = this.f4302a.getHeight();
                if (this.f4302a.getLayout() != null) {
                    width = this.f4302a.getCompoundPaddingLeft() + this.f4302a.getLayout().getWidth() + this.f4302a.getCompoundPaddingRight();
                    height = this.f4302a.getCompoundPaddingTop() + this.f4302a.getLayout().getHeight() + this.f4302a.getCompoundPaddingBottom();
                }
                if (width != this.f4305d || height != this.f4306e) {
                    this.f4306e = height;
                    this.f4305d = width;
                    this.f4303b.c(new b(this.f4304c, this.f4302a.getId(), g0.b((float) width), g0.b((float) height)));
                }
            }
        }
    }

    private static class c implements l0 {

        /* renamed from: a  reason: collision with root package name */
        private final ReactEditText f4307a;

        /* renamed from: b  reason: collision with root package name */
        private final com.facebook.react.uimanager.events.e f4308b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4309c;

        /* renamed from: d  reason: collision with root package name */
        private int f4310d;

        /* renamed from: e  reason: collision with root package name */
        private int f4311e;

        public c(ReactEditText reactEditText) {
            this.f4307a = reactEditText;
            ReactContext d10 = k1.d(reactEditText);
            this.f4308b = ReactTextInputManager.getEventDispatcher(d10, reactEditText);
            this.f4309c = k1.e(d10);
        }

        public void a(int i10, int i11, int i12, int i13) {
            int i14 = i10;
            int i15 = i11;
            if (this.f4310d != i14 || this.f4311e != i15) {
                this.f4308b.c(com.facebook.react.views.scroll.e.d(this.f4309c, this.f4307a.getId(), f.SCROLL, (float) i14, (float) i15, 0.0f, 0.0f, 0, 0, this.f4307a.getWidth(), this.f4307a.getHeight(), false));
                this.f4310d = i14;
                this.f4311e = i15;
            }
        }
    }

    private static class d implements m0 {

        /* renamed from: a  reason: collision with root package name */
        private final ReactEditText f4312a;

        /* renamed from: b  reason: collision with root package name */
        private final com.facebook.react.uimanager.events.e f4313b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4314c;

        /* renamed from: d  reason: collision with root package name */
        private int f4315d;

        /* renamed from: e  reason: collision with root package name */
        private int f4316e;

        public d(ReactEditText reactEditText) {
            this.f4312a = reactEditText;
            ReactContext d10 = k1.d(reactEditText);
            this.f4313b = ReactTextInputManager.getEventDispatcher(d10, reactEditText);
            this.f4314c = k1.e(d10);
        }

        public void a(int i10, int i11) {
            int min = Math.min(i10, i11);
            int max = Math.max(i10, i11);
            if (this.f4315d != min || this.f4316e != max) {
                this.f4313b.c(new i0(this.f4314c, this.f4312a.getId(), min, max));
                this.f4315d = min;
                this.f4316e = max;
            }
        }
    }

    private final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        private final ReactEditText f4317a;

        /* renamed from: b  reason: collision with root package name */
        private final com.facebook.react.uimanager.events.e f4318b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4319c;

        /* renamed from: d  reason: collision with root package name */
        private String f4320d = null;

        public e(ReactContext reactContext, ReactEditText reactEditText) {
            this.f4318b = ReactTextInputManager.getEventDispatcher(reactContext, reactEditText);
            this.f4317a = reactEditText;
            this.f4319c = k1.e(reactContext);
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            this.f4320d = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (!this.f4317a.f4290f1) {
                if (i12 != 0 || i11 != 0) {
                    p5.a.c(this.f4320d);
                    String substring = charSequence.toString().substring(i10, i10 + i12);
                    String substring2 = this.f4320d.substring(i10, i10 + i11);
                    if (i12 != i11 || !substring.equals(substring2)) {
                        d1 stateWrapper = this.f4317a.getStateWrapper();
                        if (stateWrapper != null) {
                            WritableNativeMap writableNativeMap = new WritableNativeMap();
                            writableNativeMap.putInt("mostRecentEventCount", this.f4317a.u());
                            writableNativeMap.putInt("opaqueCacheId", this.f4317a.getId());
                            stateWrapper.updateState(writableNativeMap);
                        }
                        this.f4318b.c(new l(this.f4319c, this.f4317a.getId(), charSequence.toString(), this.f4317a.u()));
                    }
                }
            }
        }
    }

    private static void checkPasswordType(ReactEditText reactEditText) {
        if ((reactEditText.getStagedInputType() & INPUT_TYPE_KEYBOARD_NUMBERED) != 0 && (reactEditText.getStagedInputType() & 128) != 0) {
            updateStagedInputTypeFlag(reactEditText, 128, 16);
        }
    }

    /* access modifiers changed from: private */
    public static com.facebook.react.uimanager.events.e getEventDispatcher(ReactContext reactContext, ReactEditText reactEditText) {
        return k1.c(reactContext, reactEditText.getId());
    }

    private i getReactTextUpdate(String str, int i10) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(s.b(str, s.UNSET));
        return new i(spannableStringBuilder, i10, false, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$addEventEmitters$0(e1 e1Var, ReactEditText reactEditText, View view, boolean z10) {
        int c10 = e1Var.c();
        com.facebook.react.uimanager.events.e eventDispatcher = getEventDispatcher(e1Var, reactEditText);
        if (z10) {
            eventDispatcher.c(new o(c10, reactEditText.getId()));
            return;
        }
        eventDispatcher.c(new m(c10, reactEditText.getId()));
        eventDispatcher.c(new n(c10, reactEditText.getId(), reactEditText.getText().toString()));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$addEventEmitters$1(ReactEditText reactEditText, e1 e1Var, TextView textView, int i10, KeyEvent keyEvent) {
        if ((i10 & 255) == 0 && i10 != 0) {
            return true;
        }
        boolean v10 = reactEditText.v();
        boolean T = reactEditText.T();
        boolean S = reactEditText.S();
        if (T) {
            getEventDispatcher(e1Var, reactEditText).c(new k0(e1Var.c(), reactEditText.getId(), reactEditText.getText().toString()));
        }
        if (S) {
            reactEditText.clearFocus();
        }
        if (S || T || !v10 || i10 == 5 || i10 == 7) {
            return true;
        }
        return false;
    }

    private void setAutofillHints(ReactEditText reactEditText, String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setAutofillHints(strArr);
        }
    }

    private static boolean shouldHideCursorForEmailTextInput() {
        String lowerCase = Build.MANUFACTURER.toLowerCase(Locale.ROOT);
        if (Build.VERSION.SDK_INT != 29 || !lowerCase.contains(Constants.REFERRER_API_XIAOMI)) {
            return false;
        }
        return true;
    }

    private static void updateStagedInputTypeFlag(ReactEditText reactEditText, int i10, int i11) {
        reactEditText.setStagedInputType(((~i10) & reactEditText.getStagedInputType()) | i11);
    }

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return e6.f.e("focusTextInput", 1, "blurTextInput", 2);
    }

    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> exportedCustomBubblingEventTypeConstants = super.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants == null) {
            exportedCustomBubblingEventTypeConstants = new HashMap<>();
        }
        exportedCustomBubblingEventTypeConstants.putAll(e6.f.a().b("topSubmitEditing", e6.f.d("phasedRegistrationNames", e6.f.e("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).b("topEndEditing", e6.f.d("phasedRegistrationNames", e6.f.e("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).b("topFocus", e6.f.d("phasedRegistrationNames", e6.f.e("bubbled", "onFocus", "captured", "onFocusCapture"))).b("topBlur", e6.f.d("phasedRegistrationNames", e6.f.e("bubbled", "onBlur", "captured", "onBlurCapture"))).b("topKeyPress", e6.f.d("phasedRegistrationNames", e6.f.e("bubbled", "onKeyPress", "captured", "onKeyPressCapture"))).a());
        return exportedCustomBubblingEventTypeConstants;
    }

    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(e6.f.a().b(f.b(f.SCROLL), e6.f.d("registrationName", "onScroll")).a());
        return exportedCustomDirectEventTypeConstants;
    }

    @Nullable
    public Map<String, Object> getExportedViewConstants() {
        return e6.f.d("AutoCapitalizationType", e6.f.g(DevicePublicKeyStringDef.NONE, 0, "characters", 4096, "words", 8192, "sentences", 16384));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<? extends v> getShadowNodeClass() {
        return j0.class;
    }

    @h7.a(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(ReactEditText reactEditText, boolean z10) {
        reactEditText.setAllowFontScaling(z10);
    }

    @h7.a(name = "autoCapitalize")
    public void setAutoCapitalize(ReactEditText reactEditText, Dynamic dynamic) {
        int i10 = 0;
        if (dynamic.getType() == ReadableType.Number) {
            i10 = dynamic.asInt();
        } else {
            if (dynamic.getType() == ReadableType.String) {
                String asString = dynamic.asString();
                asString.hashCode();
                char c10 = 65535;
                switch (asString.hashCode()) {
                    case 3387192:
                        if (asString.equals(DevicePublicKeyStringDef.NONE)) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case 113318569:
                        if (asString.equals("words")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case 490141296:
                        if (asString.equals("sentences")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case 1245424234:
                        if (asString.equals("characters")) {
                            c10 = 3;
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        break;
                    case 1:
                        i10 = 8192;
                        break;
                    case 3:
                        i10 = 4096;
                        break;
                }
            }
            i10 = 16384;
        }
        updateStagedInputTypeFlag(reactEditText, AUTOCAPITALIZE_FLAGS, i10);
    }

    @h7.a(name = "autoCorrect")
    public void setAutoCorrect(ReactEditText reactEditText, @Nullable Boolean bool) {
        int i10;
        if (bool == null) {
            i10 = 0;
        } else if (bool.booleanValue()) {
            i10 = 32768;
        } else {
            i10 = 524288;
        }
        updateStagedInputTypeFlag(reactEditText, 557056, i10);
    }

    @h7.a(defaultBoolean = false, name = "autoFocus")
    public void setAutoFocus(ReactEditText reactEditText, boolean z10) {
        reactEditText.setAutoFocus(z10);
    }

    @h7.b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactEditText reactEditText, int i10, Integer num) {
        float f10;
        float f11 = Float.NaN;
        if (num == null) {
            f10 = Float.NaN;
        } else {
            f10 = (float) (num.intValue() & ViewCompat.MEASURED_SIZE_MASK);
        }
        if (num != null) {
            f11 = (float) (num.intValue() >>> 24);
        }
        reactEditText.O(SPACING_TYPES[i10], f10, f11);
    }

    @h7.b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactEditText reactEditText, int i10, float f10) {
        if (!com.facebook.yoga.e.a(f10)) {
            f10 = g0.d(f10);
        }
        if (i10 == 0) {
            reactEditText.setBorderRadius(f10);
        } else {
            reactEditText.P(f10, i10 - 1);
        }
    }

    @h7.a(name = "borderStyle")
    public void setBorderStyle(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setBorderStyle(str);
    }

    @h7.b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactEditText reactEditText, int i10, float f10) {
        if (!com.facebook.yoga.e.a(f10)) {
            f10 = g0.d(f10);
        }
        reactEditText.Q(SPACING_TYPES[i10], f10);
    }

    @h7.a(defaultBoolean = false, name = "caretHidden")
    public void setCaretHidden(ReactEditText reactEditText, boolean z10) {
        if (reactEditText.getStagedInputType() != 32 || !shouldHideCursorForEmailTextInput()) {
            reactEditText.setCursorVisible(!z10);
        }
    }

    @h7.a(customType = "Color", name = "color")
    public void setColor(ReactEditText reactEditText, @Nullable Integer num) {
        String str;
        if (num == null) {
            ColorStateList b10 = com.facebook.react.views.text.a.b(reactEditText.getContext());
            if (b10 != null) {
                reactEditText.setTextColor(b10);
                return;
            }
            Context context = reactEditText.getContext();
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not get default text color from View Context: ");
            if (context != null) {
                str = context.getClass().getCanonicalName();
            } else {
                str = "null";
            }
            sb2.append(str);
            ReactSoftExceptionLogger.logSoftException(str2, new IllegalStateException(sb2.toString()));
            return;
        }
        reactEditText.setTextColor(num.intValue());
    }

    @h7.a(defaultBoolean = false, name = "contextMenuHidden")
    public void setContextMenuHidden(ReactEditText reactEditText, boolean z10) {
        reactEditText.setContextMenuHidden(z10);
    }

    @h7.a(customType = "Color", name = "cursorColor")
    public void setCursorColor(ReactEditText reactEditText, @Nullable Integer num) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            Drawable a10 = reactEditText.getTextCursorDrawable();
            if (a10 != null) {
                if (num != null) {
                    w.a();
                    a10.setColorFilter(v.a(num.intValue(), BlendMode.SRC_IN));
                } else {
                    a10.clearColorFilter();
                }
                reactEditText.setTextCursorDrawable(a10);
            }
        } else if (i10 != 28) {
            try {
                Field declaredField = reactEditText.getClass().getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                int i11 = declaredField.getInt(reactEditText);
                if (i11 != 0) {
                    Drawable mutate = ContextCompat.getDrawable(reactEditText.getContext(), i11).mutate();
                    if (num != null) {
                        mutate.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
                    } else {
                        mutate.clearColorFilter();
                    }
                    Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(reactEditText);
                    Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
                    declaredField3.setAccessible(true);
                    declaredField3.set(obj, new Drawable[]{mutate, mutate});
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
        }
    }

    @h7.a(defaultBoolean = false, name = "disableFullscreenUI")
    public void setDisableFullscreenUI(ReactEditText reactEditText, boolean z10) {
        reactEditText.setDisableFullscreenUI(z10);
    }

    @h7.a(defaultBoolean = true, name = "editable")
    public void setEditable(ReactEditText reactEditText, boolean z10) {
        reactEditText.setEnabled(z10);
    }

    @h7.a(name = "fontFamily")
    public void setFontFamily(ReactEditText reactEditText, String str) {
        reactEditText.setFontFamily(str);
    }

    @h7.a(defaultFloat = 14.0f, name = "fontSize")
    public void setFontSize(ReactEditText reactEditText, float f10) {
        reactEditText.setFontSize(f10);
    }

    @h7.a(name = "fontStyle")
    public void setFontStyle(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setFontStyle(str);
    }

    @h7.a(name = "fontVariant")
    public void setFontVariant(ReactEditText reactEditText, @Nullable ReadableArray readableArray) {
        reactEditText.setFontFeatureSettings(n.c(readableArray));
    }

    @h7.a(name = "fontWeight")
    public void setFontWeight(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setFontWeight(str);
    }

    @h7.a(name = "importantForAutofill")
    public void setImportantForAutofill(ReactEditText reactEditText, @Nullable String str) {
        int i10;
        if ("no".equals(str)) {
            i10 = 2;
        } else if ("noExcludeDescendants".equals(str)) {
            i10 = 8;
        } else if ("yes".equals(str)) {
            i10 = 1;
        } else {
            i10 = "yesExcludeDescendants".equals(str) ? 4 : 0;
        }
        setImportantForAutofill(reactEditText, i10);
    }

    @h7.a(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(ReactEditText reactEditText, boolean z10) {
        reactEditText.setIncludeFontPadding(z10);
    }

    @h7.a(name = "inlineImageLeft")
    public void setInlineImageLeft(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setCompoundDrawablesWithIntrinsicBounds(t7.c.d().f(reactEditText.getContext(), str), 0, 0, 0);
    }

    @h7.a(name = "inlineImagePadding")
    public void setInlineImagePadding(ReactEditText reactEditText, int i10) {
        reactEditText.setCompoundDrawablePadding(i10);
    }

    @h7.a(name = "keyboardType")
    public void setKeyboardType(ReactEditText reactEditText, @Nullable String str) {
        int i10;
        if (KEYBOARD_TYPE_NUMERIC.equalsIgnoreCase(str)) {
            i10 = INPUT_TYPE_KEYBOARD_NUMBERED;
        } else if (KEYBOARD_TYPE_NUMBER_PAD.equalsIgnoreCase(str)) {
            i10 = 2;
        } else if (KEYBOARD_TYPE_DECIMAL_PAD.equalsIgnoreCase(str)) {
            i10 = 8194;
        } else if (KEYBOARD_TYPE_EMAIL_ADDRESS.equalsIgnoreCase(str)) {
            if (shouldHideCursorForEmailTextInput()) {
                reactEditText.setCursorVisible(false);
            }
            i10 = 33;
        } else if (KEYBOARD_TYPE_PHONE_PAD.equalsIgnoreCase(str)) {
            i10 = 3;
        } else if (KEYBOARD_TYPE_VISIBLE_PASSWORD.equalsIgnoreCase(str)) {
            i10 = 144;
        } else if ("url".equalsIgnoreCase(str)) {
            i10 = 16;
        } else {
            i10 = 1;
        }
        updateStagedInputTypeFlag(reactEditText, 15, i10);
        checkPasswordType(reactEditText);
    }

    @h7.a(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(ReactEditText reactEditText, float f10) {
        reactEditText.setLetterSpacingPt(f10);
    }

    @h7.a(defaultFloat = 0.0f, name = "lineHeight")
    public void setLineHeight(ReactEditText reactEditText, int i10) {
        reactEditText.setLineHeight(i10);
    }

    @h7.a(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(ReactEditText reactEditText, float f10) {
        reactEditText.setMaxFontSizeMultiplier(f10);
    }

    /* JADX WARNING: type inference failed for: r8v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    @h7.a(name = "maxLength")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMaxLength(com.facebook.react.views.textinput.ReactEditText r7, @androidx.annotation.Nullable java.lang.Integer r8) {
        /*
            r6 = this;
            android.text.InputFilter[] r0 = r7.getFilters()
            android.text.InputFilter[] r1 = EMPTY_FILTERS
            r2 = 0
            if (r8 != 0) goto L_0x0034
            int r8 = r0.length
            if (r8 <= 0) goto L_0x0078
            java.util.LinkedList r8 = new java.util.LinkedList
            r8.<init>()
            int r3 = r0.length
        L_0x0012:
            if (r2 >= r3) goto L_0x0020
            r4 = r0[r2]
            boolean r5 = r4 instanceof android.text.InputFilter.LengthFilter
            if (r5 != 0) goto L_0x001d
            r8.add(r4)
        L_0x001d:
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0020:
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L_0x0078
            int r0 = r8.size()
            android.text.InputFilter[] r0 = new android.text.InputFilter[r0]
            java.lang.Object[] r8 = r8.toArray(r0)
            r1 = r8
            android.text.InputFilter[] r1 = (android.text.InputFilter[]) r1
            goto L_0x0078
        L_0x0034:
            int r1 = r0.length
            r3 = 1
            if (r1 <= 0) goto L_0x006b
            r1 = r2
            r4 = r1
        L_0x003a:
            int r5 = r0.length
            if (r1 >= r5) goto L_0x0052
            r5 = r0[r1]
            boolean r5 = r5 instanceof android.text.InputFilter.LengthFilter
            if (r5 == 0) goto L_0x004f
            android.text.InputFilter$LengthFilter r4 = new android.text.InputFilter$LengthFilter
            int r5 = r8.intValue()
            r4.<init>(r5)
            r0[r1] = r4
            r4 = r3
        L_0x004f:
            int r1 = r1 + 1
            goto L_0x003a
        L_0x0052:
            if (r4 != 0) goto L_0x0069
            int r1 = r0.length
            int r1 = r1 + r3
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            int r3 = r0.length
            java.lang.System.arraycopy(r0, r2, r1, r2, r3)
            int r2 = r0.length
            android.text.InputFilter$LengthFilter r3 = new android.text.InputFilter$LengthFilter
            int r8 = r8.intValue()
            r3.<init>(r8)
            r0[r2] = r3
            r0 = r1
        L_0x0069:
            r1 = r0
            goto L_0x0078
        L_0x006b:
            android.text.InputFilter[] r1 = new android.text.InputFilter[r3]
            android.text.InputFilter$LengthFilter r0 = new android.text.InputFilter$LengthFilter
            int r8 = r8.intValue()
            r0.<init>(r8)
            r1[r2] = r0
        L_0x0078:
            r7.setFilters(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.setMaxLength(com.facebook.react.views.textinput.ReactEditText, java.lang.Integer):void");
    }

    @h7.a(defaultBoolean = false, name = "multiline")
    public void setMultiline(ReactEditText reactEditText, boolean z10) {
        int i10;
        int i11 = 131072;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 131072;
        }
        if (!z10) {
            i11 = 0;
        }
        updateStagedInputTypeFlag(reactEditText, i10, i11);
    }

    @h7.a(defaultInt = 1, name = "numberOfLines")
    public void setNumLines(ReactEditText reactEditText, int i10) {
        reactEditText.setLines(i10);
    }

    @h7.a(defaultBoolean = false, name = "onContentSizeChange")
    public void setOnContentSizeChange(ReactEditText reactEditText, boolean z10) {
        if (z10) {
            reactEditText.setContentSizeWatcher(new b(reactEditText));
        } else {
            reactEditText.setContentSizeWatcher((a) null);
        }
    }

    @h7.a(defaultBoolean = false, name = "onKeyPress")
    public void setOnKeyPress(ReactEditText reactEditText, boolean z10) {
        reactEditText.setOnKeyPress(z10);
    }

    @h7.a(defaultBoolean = false, name = "onScroll")
    public void setOnScroll(ReactEditText reactEditText, boolean z10) {
        if (z10) {
            reactEditText.setScrollWatcher(new c(reactEditText));
        } else {
            reactEditText.setScrollWatcher((l0) null);
        }
    }

    @h7.a(defaultBoolean = false, name = "onSelectionChange")
    public void setOnSelectionChange(ReactEditText reactEditText, boolean z10) {
        if (z10) {
            reactEditText.setSelectionWatcher(new d(reactEditText));
        } else {
            reactEditText.setSelectionWatcher((m0) null);
        }
    }

    @h7.a(name = "overflow")
    public void setOverflow(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setOverflow(str);
    }

    @h7.a(name = "placeholder")
    public void setPlaceholder(ReactEditText reactEditText, String str) {
        reactEditText.setPlaceholder(str);
    }

    @h7.a(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setHintTextColor(com.facebook.react.views.text.a.d(reactEditText.getContext()));
        } else {
            reactEditText.setHintTextColor(num.intValue());
        }
    }

    @h7.a(name = "returnKeyLabel")
    public void setReturnKeyLabel(ReactEditText reactEditText, String str) {
        reactEditText.setImeActionLabel(str, IME_ACTION_ID);
    }

    @h7.a(name = "returnKeyType")
    public void setReturnKeyType(ReactEditText reactEditText, String str) {
        reactEditText.setReturnKeyType(str);
    }

    @h7.a(defaultBoolean = false, name = "secureTextEntry")
    public void setSecureTextEntry(ReactEditText reactEditText, boolean z10) {
        int i10;
        if (z10) {
            i10 = 128;
        } else {
            i10 = 0;
        }
        updateStagedInputTypeFlag(reactEditText, 144, i10);
        checkPasswordType(reactEditText);
    }

    @h7.a(defaultBoolean = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(ReactEditText reactEditText, boolean z10) {
        reactEditText.setSelectAllOnFocus(z10);
    }

    @h7.a(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setHighlightColor(com.facebook.react.views.text.a.c(reactEditText.getContext()));
        } else {
            reactEditText.setHighlightColor(num.intValue());
        }
    }

    @h7.a(customType = "Color", name = "selectionHandleColor")
    public void setSelectionHandleColor(ReactEditText reactEditText, @Nullable Integer num) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            Drawable mutate = reactEditText.getTextSelectHandle().mutate();
            Drawable mutate2 = reactEditText.getTextSelectHandleLeft().mutate();
            Drawable mutate3 = reactEditText.getTextSelectHandleRight().mutate();
            if (num != null) {
                w.a();
                BlendModeColorFilter a10 = v.a(num.intValue(), BlendMode.SRC_IN);
                mutate.setColorFilter(a10);
                mutate2.setColorFilter(a10);
                mutate3.setColorFilter(a10);
            } else {
                mutate.clearColorFilter();
                mutate2.clearColorFilter();
                mutate3.clearColorFilter();
            }
            reactEditText.setTextSelectHandle(mutate);
            reactEditText.setTextSelectHandleLeft(mutate2);
            reactEditText.setTextSelectHandleRight(mutate3);
        } else if (i10 != 28) {
            int i11 = 0;
            while (true) {
                String[] strArr = DRAWABLE_HANDLE_RESOURCES;
                if (i11 < strArr.length) {
                    try {
                        Field declaredField = reactEditText.getClass().getDeclaredField(strArr[i11]);
                        declaredField.setAccessible(true);
                        int i12 = declaredField.getInt(reactEditText);
                        if (i12 != 0) {
                            Drawable mutate4 = ContextCompat.getDrawable(reactEditText.getContext(), i12).mutate();
                            if (num != null) {
                                mutate4.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
                            } else {
                                mutate4.clearColorFilter();
                            }
                            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                            declaredField2.setAccessible(true);
                            Object obj = declaredField2.get(reactEditText);
                            Field declaredField3 = obj.getClass().getDeclaredField(DRAWABLE_HANDLE_FIELDS[i11]);
                            declaredField3.setAccessible(true);
                            declaredField3.set(obj, mutate4);
                            i11++;
                        } else {
                            return;
                        }
                    } catch (IllegalAccessException | NoSuchFieldException unused) {
                    }
                } else {
                    return;
                }
            }
        }
    }

    @h7.a(name = "submitBehavior")
    public void setSubmitBehavior(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setSubmitBehavior(str);
    }

    @h7.a(name = "textAlign")
    public void setTextAlign(ReactEditText reactEditText, @Nullable String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                reactEditText.setJustificationMode(1);
            }
            reactEditText.setGravityHorizontal(3);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setJustificationMode(0);
        }
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityHorizontal(0);
        } else if ("left".equals(str)) {
            reactEditText.setGravityHorizontal(3);
        } else if ("right".equals(str)) {
            reactEditText.setGravityHorizontal(5);
        } else if ("center".equals(str)) {
            reactEditText.setGravityHorizontal(1);
        } else {
            z2.a.G("ReactNative", "Invalid textAlign: " + str);
            reactEditText.setGravityHorizontal(0);
        }
    }

    @h7.a(name = "textAlignVertical")
    public void setTextAlignVertical(ReactEditText reactEditText, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityVertical(0);
        } else if ("top".equals(str)) {
            reactEditText.setGravityVertical(48);
        } else if ("bottom".equals(str)) {
            reactEditText.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactEditText.setGravityVertical(16);
        } else {
            z2.a.G("ReactNative", "Invalid textAlignVertical: " + str);
            reactEditText.setGravityVertical(0);
        }
    }

    @h7.a(name = "autoComplete")
    public void setTextContentType(ReactEditText reactEditText, @Nullable String str) {
        if (str == null) {
            setImportantForAutofill(reactEditText, 2);
        } else if ("off".equals(str)) {
            setImportantForAutofill(reactEditText, 2);
        } else {
            Map<String, String> map = REACT_PROPS_AUTOFILL_HINTS_MAP;
            if (map.containsKey(str)) {
                setAutofillHints(reactEditText, map.get(str));
                return;
            }
            z2.a.G("ReactNative", "Invalid autoComplete: " + str);
            setImportantForAutofill(reactEditText, 2);
        }
    }

    @h7.a(name = "textDecorationLine")
    public void setTextDecorationLine(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setPaintFlags(reactEditText.getPaintFlags() & -25);
        for (String str2 : str.split(" ")) {
            if (str2.equals("underline")) {
                reactEditText.setPaintFlags(reactEditText.getPaintFlags() | 8);
            } else if (str2.equals("line-through")) {
                reactEditText.setPaintFlags(reactEditText.getPaintFlags() | 16);
            }
        }
    }

    @h7.a(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(ReactEditText reactEditText, @Nullable Integer num) {
        Drawable background = reactEditText.getBackground();
        if (background != null) {
            if (background.getConstantState() != null) {
                try {
                    background = background.mutate();
                } catch (NullPointerException e10) {
                    z2.a.k(TAG, "NullPointerException when setting underlineColorAndroid for TextInput", e10);
                }
            }
            if (num == null) {
                background.clearColorFilter();
            } else {
                background.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    @h7.a(defaultBoolean = true, name = "showSoftInputOnFocus")
    public void showKeyboardOnFocus(ReactEditText reactEditText, boolean z10) {
        reactEditText.setShowSoftInputOnFocus(z10);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(e1 e1Var, ReactEditText reactEditText) {
        reactEditText.setEventDispatcher(getEventDispatcher(e1Var, reactEditText));
        reactEditText.addTextChangedListener(new e(e1Var, reactEditText));
        reactEditText.setOnFocusChangeListener(new g0(e1Var, reactEditText));
        reactEditText.setOnEditorActionListener(new h0(reactEditText, e1Var));
    }

    public com.facebook.react.views.text.c createShadowNodeInstance() {
        return new j0();
    }

    public ReactEditText createViewInstance(e1 e1Var) {
        ReactEditText reactEditText = new ReactEditText(e1Var);
        reactEditText.setInputType(reactEditText.getInputType() & -131073);
        reactEditText.setReturnKeyType("done");
        reactEditText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return reactEditText;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactEditText reactEditText) {
        super.onAfterUpdateTransaction(reactEditText);
        reactEditText.J();
        reactEditText.s();
    }

    public void setPadding(ReactEditText reactEditText, int i10, int i11, int i12, int i13) {
        reactEditText.setPadding(i10, i11, i12, i13);
    }

    public void updateExtraData(ReactEditText reactEditText, Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            int f10 = (int) iVar.f();
            int h10 = (int) iVar.h();
            int g10 = (int) iVar.g();
            int e10 = (int) iVar.e();
            int i10 = -1;
            if (!(f10 == -1 && h10 == -1 && g10 == -1 && e10 == -1)) {
                if (f10 == -1) {
                    f10 = reactEditText.getPaddingLeft();
                }
                if (h10 == -1) {
                    h10 = reactEditText.getPaddingTop();
                }
                if (g10 == -1) {
                    g10 = reactEditText.getPaddingRight();
                }
                if (e10 == -1) {
                    e10 = reactEditText.getPaddingBottom();
                }
                reactEditText.setPadding(f10, h10, g10, e10);
            }
            if (iVar.b()) {
                w7.i.g(iVar.i(), reactEditText);
            }
            int i11 = 0;
            if (reactEditText.getSelectionStart() == reactEditText.getSelectionEnd()) {
                if (reactEditText.getText() != null) {
                    i11 = reactEditText.getText().length();
                }
                i10 = iVar.i().length() - (i11 - reactEditText.getSelectionStart());
            }
            reactEditText.I(iVar);
            reactEditText.F(iVar.c(), i10, i10);
        }
    }

    public Object updateState(ReactEditText reactEditText, v0 v0Var, d1 d1Var) {
        if (reactEditText.getStateWrapper() == null) {
            reactEditText.setPadding(0, 0, 0, 0);
        }
        reactEditText.setStateWrapper(d1Var);
        ReadableMapBuffer stateDataMapBuffer = d1Var.getStateDataMapBuffer();
        if (stateDataMapBuffer != null) {
            return getReactTextUpdate(reactEditText, v0Var, stateDataMapBuffer);
        }
        return null;
    }

    public com.facebook.react.views.text.c createShadowNodeInstance(@Nullable m mVar) {
        return new j0(mVar);
    }

    public void receiveCommand(ReactEditText reactEditText, int i10, @Nullable ReadableArray readableArray) {
        if (i10 == 1) {
            receiveCommand(reactEditText, "focus", readableArray);
        } else if (i10 == 2) {
            receiveCommand(reactEditText, "blur", readableArray);
        } else if (i10 == 4) {
            receiveCommand(reactEditText, "setTextAndSelection", readableArray);
        }
    }

    @Nullable
    public Object getReactTextUpdate(ReactEditText reactEditText, v0 v0Var, com.facebook.react.common.mapbuffer.a aVar) {
        if (aVar.getCount() == 0) {
            return null;
        }
        int i10 = 0;
        com.facebook.react.common.mapbuffer.a h10 = aVar.h(0);
        com.facebook.react.common.mapbuffer.a h11 = aVar.h(1);
        Spannable f10 = r.f(reactEditText.getContext(), h10, (m) null);
        int h12 = p.h(h11.getString(2));
        if (Build.VERSION.SDK_INT >= 26) {
            i10 = reactEditText.getJustificationMode();
        }
        return i.a(f10, aVar.getInt(3), p.g(v0Var, r.i(h10), reactEditText.getGravityHorizontal()), h12, p.d(v0Var, i10));
    }

    private void setImportantForAutofill(ReactEditText reactEditText, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setImportantForAutofill(i10);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.facebook.react.views.textinput.ReactEditText r7, java.lang.String r8, @androidx.annotation.Nullable com.facebook.react.bridge.ReadableArray r9) {
        /*
            r6 = this;
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            r8.hashCode()
            r4 = -1
            int r5 = r8.hashCode()
            switch(r5) {
                case -1699362314: goto L_0x003d;
                case 3027047: goto L_0x0032;
                case 97604824: goto L_0x0027;
                case 1427010500: goto L_0x001c;
                case 1690703013: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            r8 = r4
            goto L_0x0047
        L_0x0011:
            java.lang.String r5 = "focusTextInput"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            r8 = 4
            goto L_0x0047
        L_0x001c:
            java.lang.String r5 = "setTextAndSelection"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0025
            goto L_0x000f
        L_0x0025:
            r8 = r0
            goto L_0x0047
        L_0x0027:
            java.lang.String r5 = "focus"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0030
            goto L_0x000f
        L_0x0030:
            r8 = r1
            goto L_0x0047
        L_0x0032:
            java.lang.String r5 = "blur"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x003b
            goto L_0x000f
        L_0x003b:
            r8 = r2
            goto L_0x0047
        L_0x003d:
            java.lang.String r5 = "blurTextInput"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L_0x0046
            goto L_0x000f
        L_0x0046:
            r8 = r3
        L_0x0047:
            switch(r8) {
                case 0: goto L_0x0076;
                case 1: goto L_0x0076;
                case 2: goto L_0x0072;
                case 3: goto L_0x004b;
                case 4: goto L_0x0072;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x0079
        L_0x004b:
            int r8 = r9.getInt(r3)
            if (r8 != r4) goto L_0x0052
            return
        L_0x0052:
            int r1 = r9.getInt(r1)
            int r0 = r9.getInt(r0)
            if (r0 != r4) goto L_0x005d
            r0 = r1
        L_0x005d:
            boolean r3 = r9.isNull(r2)
            if (r3 != 0) goto L_0x006e
            java.lang.String r9 = r9.getString(r2)
            com.facebook.react.views.text.i r9 = r6.getReactTextUpdate(r9, r8)
            r7.H(r9)
        L_0x006e:
            r7.F(r8, r1, r0)
            goto L_0x0079
        L_0x0072:
            r7.L()
            goto L_0x0079
        L_0x0076:
            r7.r()
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.receiveCommand(com.facebook.react.views.textinput.ReactEditText, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
