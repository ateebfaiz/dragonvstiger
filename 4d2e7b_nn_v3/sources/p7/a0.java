package p7;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;

public class a0 extends e {
    public a0(f fVar) {
        super(fVar);
    }

    public void a(View view, String str, ReadableArray readableArray) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1833485118:
                if (str.equals("cancelSearch")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1270906598:
                if (str.equals("clearText")) {
                    c10 = 1;
                    break;
                }
                break;
            case -664358976:
                if (str.equals("toggleCancelButton")) {
                    c10 = 2;
                    break;
                }
                break;
            case 3027047:
                if (str.equals("blur")) {
                    c10 = 3;
                    break;
                }
                break;
            case 97604824:
                if (str.equals("focus")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1984984239:
                if (str.equals("setText")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                ((b0) this.f3579a).cancelSearch(view);
                return;
            case 1:
                ((b0) this.f3579a).clearText(view);
                return;
            case 2:
                ((b0) this.f3579a).toggleCancelButton(view, readableArray.getBoolean(0));
                return;
            case 3:
                ((b0) this.f3579a).blur(view);
                return;
            case 4:
                ((b0) this.f3579a).focus(view);
                return;
            case 5:
                ((b0) this.f3579a).setText(view, readableArray.getString(0));
                return;
            default:
                return;
        }
    }

    public void b(View view, String str, Object obj) {
        boolean z10 = true;
        str.hashCode();
        String str2 = null;
        boolean z11 = false;
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1619312835:
                if (str.equals("hideNavigationBar")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1465798051:
                if (str.equals("headerIconColor")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1339545093:
                if (str.equals("autoCapitalize")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    c10 = 3;
                    break;
                }
                break;
            case -336520619:
                if (str.equals("barTintColor")) {
                    c10 = 4;
                    break;
                }
                break;
            case -256845969:
                if (str.equals("hintTextColor")) {
                    c10 = 5;
                    break;
                }
                break;
            case -186579527:
                if (str.equals("hideWhenScrolling")) {
                    c10 = 6;
                    break;
                }
                break;
            case -146361959:
                if (str.equals("cancelButtonText")) {
                    c10 = 7;
                    break;
                }
                break;
            case -109380883:
                if (str.equals("disableBackButtonOverride")) {
                    c10 = 8;
                    break;
                }
                break;
            case -39414888:
                if (str.equals("shouldShowHintSearchIcon")) {
                    c10 = 9;
                    break;
                }
                break;
            case 598246771:
                if (str.equals("placeholder")) {
                    c10 = 10;
                    break;
                }
                break;
            case 1327599912:
                if (str.equals("tintColor")) {
                    c10 = 11;
                    break;
                }
                break;
            case 1584806451:
                if (str.equals("obscureBackground")) {
                    c10 = 12;
                    break;
                }
                break;
            case 1706976804:
                if (str.equals("inputType")) {
                    c10 = 13;
                    break;
                }
                break;
            case 1792938725:
                if (str.equals("placement")) {
                    c10 = 14;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                b0 b0Var = (b0) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                b0Var.setHideNavigationBar(view, z11);
                return;
            case 1:
                ((b0) this.f3579a).setHeaderIconColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 2:
                ((b0) this.f3579a).setAutoCapitalize(view, (String) obj);
                return;
            case 3:
                ((b0) this.f3579a).setTextColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 4:
                ((b0) this.f3579a).setBarTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 5:
                ((b0) this.f3579a).setHintTextColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 6:
                b0 b0Var2 = (b0) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                b0Var2.setHideWhenScrolling(view, z11);
                return;
            case 7:
                b0 b0Var3 = (b0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                b0Var3.setCancelButtonText(view, str2);
                return;
            case 8:
                b0 b0Var4 = (b0) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                b0Var4.setDisableBackButtonOverride(view, z11);
                return;
            case 9:
                b0 b0Var5 = (b0) this.f3579a;
                if (obj != null) {
                    z10 = ((Boolean) obj).booleanValue();
                }
                b0Var5.setShouldShowHintSearchIcon(view, z10);
                return;
            case 10:
                b0 b0Var6 = (b0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                b0Var6.setPlaceholder(view, str2);
                return;
            case 11:
                ((b0) this.f3579a).setTintColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 12:
                b0 b0Var7 = (b0) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                b0Var7.setObscureBackground(view, z11);
                return;
            case 13:
                b0 b0Var8 = (b0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                b0Var8.setInputType(view, str2);
                return;
            case 14:
                ((b0) this.f3579a).setPlacement(view, (String) obj);
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
