package com.facebook.react.uimanager;

import android.widget.ImageView;
import com.facebook.react.uimanager.events.s;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import e6.f;
import java.util.HashMap;
import java.util.Map;

abstract class m1 {
    static Map a() {
        return f.a().b("topChange", f.d("phasedRegistrationNames", f.e("bubbled", "onChange", "captured", "onChangeCapture"))).b("topSelect", f.d("phasedRegistrationNames", f.e("bubbled", "onSelect", "captured", "onSelectCapture"))).b(s.b(s.START), f.d("phasedRegistrationNames", f.e("bubbled", "onTouchStart", "captured", "onTouchStartCapture"))).b(s.b(s.MOVE), f.d("phasedRegistrationNames", f.e("bubbled", "onTouchMove", "captured", "onTouchMoveCapture"))).b(s.b(s.END), f.d("phasedRegistrationNames", f.e("bubbled", "onTouchEnd", "captured", "onTouchEndCapture"))).b(s.b(s.CANCEL), f.d("phasedRegistrationNames", f.e("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture"))).a();
    }

    public static Map b() {
        HashMap b10 = f.b();
        b10.put("UIView", f.d("ContentMode", f.f("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()))));
        b10.put("StyleConstants", f.d("PointerEventsValues", f.g(DevicePublicKeyStringDef.NONE, Integer.valueOf(h0.NONE.ordinal()), "boxNone", Integer.valueOf(h0.BOX_NONE.ordinal()), "boxOnly", Integer.valueOf(h0.BOX_ONLY.ordinal()), "unspecified", Integer.valueOf(h0.AUTO.ordinal()))));
        b10.put("AccessibilityEventTypes", f.f("typeWindowStateChanged", 32, "typeViewFocused", 8, "typeViewClicked", 1));
        return b10;
    }

    static Map c() {
        return f.a().b("topContentSizeChange", f.d("registrationName", "onContentSizeChange")).b("topLayout", f.d("registrationName", "onLayout")).b("topLoadingError", f.d("registrationName", "onLoadingError")).b("topLoadingFinish", f.d("registrationName", "onLoadingFinish")).b("topLoadingStart", f.d("registrationName", "onLoadingStart")).b("topSelectionChange", f.d("registrationName", "onSelectionChange")).b("topMessage", f.d("registrationName", "onMessage")).b("topScrollBeginDrag", f.d("registrationName", "onScrollBeginDrag")).b("topScrollEndDrag", f.d("registrationName", "onScrollEndDrag")).b("topScroll", f.d("registrationName", "onScroll")).b("topMomentumScrollBegin", f.d("registrationName", "onMomentumScrollBegin")).b("topMomentumScrollEnd", f.d("registrationName", "onMomentumScrollEnd")).a();
    }
}
