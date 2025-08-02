package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.google.firebase.messaging.Constants;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.jvm.internal.m;

public final class m2 {

    /* renamed from: a  reason: collision with root package name */
    public static final m2 f3812a = new m2();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f3813b = {8, 4, 5, 1, 3, 0, 2};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f3814c = {8, 7, 6, 4, 5, 1, 3, 0, 2};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f3815d = {4, 5, 1, 3};

    /* renamed from: e  reason: collision with root package name */
    private static final HashSet f3816e = new HashSet(Arrays.asList(new String[]{"alignSelf", "alignItems", "collapsable", "flex", "flexBasis", "flexDirection", "flexGrow", "rowGap", "columnGap", "gap", "flexShrink", "flexWrap", "justifyContent", "alignContent", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "position", "right", "top", "bottom", "left", "start", "end", Snapshot.WIDTH, Snapshot.HEIGHT, "minWidth", "maxWidth", "minHeight", "maxHeight", "margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd"}));

    private m2() {
    }

    public static final boolean a(ReadableMap readableMap, String str) {
        ReadableType type;
        m.f(readableMap, "map");
        m.f(str, "prop");
        if (f3816e.contains(str)) {
            return true;
        }
        if (m.b("pointerEvents", str)) {
            String string = readableMap.getString(str);
            if (m.b("auto", string) || m.b("box-none", string)) {
                return true;
            }
            return false;
        }
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals("borderRightColor") && readableMap.getType("borderRightColor") == ReadableType.Number && readableMap.getInt("borderRightColor") == 0) {
                    return true;
                }
            case -1971292586:
                if (str.equals("borderRightWidth") && (readableMap.isNull("borderRightWidth") || readableMap.getDouble("borderRightWidth") == 0.0d)) {
                    return true;
                }
            case -1470826662:
                if (str.equals("borderTopColor") && readableMap.getType("borderTopColor") == ReadableType.Number && readableMap.getInt("borderTopColor") == 0) {
                    return true;
                }
            case -1452542531:
                if (str.equals("borderTopWidth") && (readableMap.isNull("borderTopWidth") || readableMap.getDouble("borderTopWidth") == 0.0d)) {
                    return true;
                }
            case -1308858324:
                if (str.equals("borderBottomColor") && readableMap.getType("borderBottomColor") == ReadableType.Number && readableMap.getInt("borderBottomColor") == 0) {
                    return true;
                }
            case -1290574193:
                if (str.equals("borderBottomWidth") && (readableMap.isNull("borderBottomWidth") || readableMap.getDouble("borderBottomWidth") == 0.0d)) {
                    return true;
                }
            case -1267206133:
                if (str.equals("opacity") && (readableMap.isNull("opacity") || readableMap.getDouble("opacity") == 1.0d)) {
                    return true;
                }
            case -242276144:
                if (str.equals("borderLeftColor") && readableMap.getType("borderLeftColor") == ReadableType.Number && readableMap.getInt("borderLeftColor") == 0) {
                    return true;
                }
            case -223992013:
                if (str.equals("borderLeftWidth") && (readableMap.isNull("borderLeftWidth") || readableMap.getDouble("borderLeftWidth") == 0.0d)) {
                    return true;
                }
            case 306963138:
                if (str.equals("borderBlockStartColor") && readableMap.getType("borderBlockStartColor") == ReadableType.Number && readableMap.getInt("borderBlockStartColor") == 0) {
                    return true;
                }
            case 529642498:
                if (str.equals("overflow") && (readableMap.isNull("overflow") || m.b("visible", readableMap.getString("overflow")))) {
                    return true;
                }
            case 684610594:
                if (str.equals("borderBlockColor") && readableMap.getType("borderBlockColor") == ReadableType.Number && readableMap.getInt("borderBlockColor") == 0) {
                    return true;
                }
            case 741115130:
                if (str.equals("borderWidth") && (readableMap.isNull("borderWidth") || readableMap.getDouble("borderWidth") == 0.0d)) {
                    return true;
                }
            case 762983977:
                if (str.equals("borderBlockEndColor") && readableMap.getType("borderBlockEndColor") == ReadableType.Number && readableMap.getInt("borderBlockEndColor") == 0) {
                    return true;
                }
            case 1349188574:
                if (str.equals(Snapshot.BORDER_RADIUS)) {
                    if (readableMap.hasKey("backgroundColor") && (((type = readableMap.getType("backgroundColor")) == ReadableType.Number && readableMap.getInt("backgroundColor") != 0) || type != ReadableType.Null)) {
                        return false;
                    }
                    if (!readableMap.hasKey("borderWidth") || readableMap.isNull("borderWidth") || readableMap.getDouble("borderWidth") == 0.0d) {
                        return true;
                    }
                    return false;
                }
                break;
        }
        return false;
    }
}
