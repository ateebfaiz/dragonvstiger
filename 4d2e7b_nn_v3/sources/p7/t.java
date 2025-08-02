package p7;

import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.alibaba.fastjson.parser.JSONLexer;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;

public class t extends e {
    public t(f fVar) {
        super(fVar);
    }

    public void b(View view, String str, Object obj) {
        int i10;
        boolean z10 = true;
        str.hashCode();
        float f10 = -1.0f;
        String str2 = null;
        boolean z11 = false;
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1937389126:
                if (str.equals("homeIndicatorHidden")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1853558344:
                if (str.equals("gestureEnabled")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1734097646:
                if (str.equals("hideKeyboardOnSwipe")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1349152186:
                if (str.equals("sheetCornerRadius")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1322084375:
                if (str.equals("navigationBarHidden")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1156137512:
                if (str.equals("statusBarTranslucent")) {
                    c10 = 5;
                    break;
                }
                break;
            case -1150711358:
                if (str.equals("stackPresentation")) {
                    c10 = 6;
                    break;
                }
                break;
            case -1047235902:
                if (str.equals("activityState")) {
                    c10 = 7;
                    break;
                }
                break;
            case -973702878:
                if (str.equals("statusBarColor")) {
                    c10 = 8;
                    break;
                }
                break;
            case -958765200:
                if (str.equals("statusBarStyle")) {
                    c10 = 9;
                    break;
                }
                break;
            case -952227806:
                if (str.equals("fullScreenSwipeShadowEnabled")) {
                    c10 = 10;
                    break;
                }
                break;
            case -577711652:
                if (str.equals("stackAnimation")) {
                    c10 = 11;
                    break;
                }
                break;
            case -462720700:
                if (str.equals("navigationBarColor")) {
                    c10 = 12;
                    break;
                }
                break;
            case -274098190:
                if (str.equals("sheetAllowedDetents")) {
                    c10 = 13;
                    break;
                }
                break;
            case -257141968:
                if (str.equals("replaceAnimation")) {
                    c10 = 14;
                    break;
                }
                break;
            case -166356101:
                if (str.equals("preventNativeDismiss")) {
                    c10 = 15;
                    break;
                }
                break;
            case 17337291:
                if (str.equals("statusBarHidden")) {
                    c10 = 16;
                    break;
                }
                break;
            case 129956386:
                if (str.equals("fullScreenSwipeEnabled")) {
                    c10 = 17;
                    break;
                }
                break;
            case 187703999:
                if (str.equals("gestureResponseDistance")) {
                    c10 = 18;
                    break;
                }
                break;
            case 227582404:
                if (str.equals("screenOrientation")) {
                    c10 = 19;
                    break;
                }
                break;
            case 241896530:
                if (str.equals("sheetLargestUndimmedDetent")) {
                    c10 = 20;
                    break;
                }
                break;
            case 425064969:
                if (str.equals("transitionDuration")) {
                    c10 = 21;
                    break;
                }
                break;
            case 1082157413:
                if (str.equals("swipeDirection")) {
                    c10 = 22;
                    break;
                }
                break;
            case 1110843912:
                if (str.equals("customAnimationOnSwipe")) {
                    c10 = 23;
                    break;
                }
                break;
            case 1116050554:
                if (str.equals("navigationBarTranslucent")) {
                    c10 = 24;
                    break;
                }
                break;
            case 1357942638:
                if (str.equals("sheetGrabberVisible")) {
                    c10 = 25;
                    break;
                }
                break;
            case 1387359683:
                if (str.equals("statusBarAnimation")) {
                    c10 = JSONLexer.EOI;
                    break;
                }
                break;
            case 1729091548:
                if (str.equals("nativeBackButtonDismissalEnabled")) {
                    c10 = 27;
                    break;
                }
                break;
            case 2097450072:
                if (str.equals("sheetExpandsWhenScrolledToEdge")) {
                    c10 = 28;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                u uVar = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar.setHomeIndicatorHidden(view, z11);
                return;
            case 1:
                u uVar2 = (u) this.f3579a;
                if (obj != null) {
                    z10 = ((Boolean) obj).booleanValue();
                }
                uVar2.setGestureEnabled(view, z10);
                return;
            case 2:
                u uVar3 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar3.setHideKeyboardOnSwipe(view, z11);
                return;
            case 3:
                u uVar4 = (u) this.f3579a;
                if (obj != null) {
                    f10 = ((Double) obj).floatValue();
                }
                uVar4.setSheetCornerRadius(view, f10);
                return;
            case 4:
                u uVar5 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar5.setNavigationBarHidden(view, z11);
                return;
            case 5:
                u uVar6 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar6.setStatusBarTranslucent(view, z11);
                return;
            case 6:
                ((u) this.f3579a).setStackPresentation(view, (String) obj);
                return;
            case 7:
                u uVar7 = (u) this.f3579a;
                if (obj != null) {
                    f10 = ((Double) obj).floatValue();
                }
                uVar7.setActivityState(view, f10);
                return;
            case 8:
                ((u) this.f3579a).setStatusBarColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 9:
                u uVar8 = (u) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                uVar8.setStatusBarStyle(view, str2);
                return;
            case 10:
                u uVar9 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar9.setFullScreenSwipeShadowEnabled(view, z11);
                return;
            case 11:
                ((u) this.f3579a).setStackAnimation(view, (String) obj);
                return;
            case 12:
                ((u) this.f3579a).setNavigationBarColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 13:
                ((u) this.f3579a).setSheetAllowedDetents(view, (String) obj);
                return;
            case 14:
                ((u) this.f3579a).setReplaceAnimation(view, (String) obj);
                return;
            case 15:
                u uVar10 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar10.setPreventNativeDismiss(view, z11);
                return;
            case 16:
                u uVar11 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar11.setStatusBarHidden(view, z11);
                return;
            case 17:
                u uVar12 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar12.setFullScreenSwipeEnabled(view, z11);
                return;
            case 18:
                ((u) this.f3579a).setGestureResponseDistance(view, (ReadableMap) obj);
                return;
            case 19:
                u uVar13 = (u) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                uVar13.setScreenOrientation(view, str2);
                return;
            case 20:
                ((u) this.f3579a).setSheetLargestUndimmedDetent(view, (String) obj);
                return;
            case 21:
                u uVar14 = (u) this.f3579a;
                if (obj == null) {
                    i10 = 350;
                } else {
                    i10 = ((Double) obj).intValue();
                }
                uVar14.setTransitionDuration(view, i10);
                return;
            case 22:
                ((u) this.f3579a).setSwipeDirection(view, (String) obj);
                return;
            case 23:
                u uVar15 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar15.setCustomAnimationOnSwipe(view, z11);
                return;
            case 24:
                u uVar16 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar16.setNavigationBarTranslucent(view, z11);
                return;
            case 25:
                u uVar17 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar17.setSheetGrabberVisible(view, z11);
                return;
            case 26:
                u uVar18 = (u) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                uVar18.setStatusBarAnimation(view, str2);
                return;
            case 27:
                u uVar19 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar19.setNativeBackButtonDismissalEnabled(view, z11);
                return;
            case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                u uVar20 = (u) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                uVar20.setSheetExpandsWhenScrolledToEdge(view, z11);
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
