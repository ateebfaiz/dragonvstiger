package com.facebook.react.bridge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import z2.a;

public class ColorPropConverter {
    private static final String ATTR = "attr";
    private static final String ATTR_SEGMENT = "attr/";
    private static final String JSON_KEY = "resource_paths";
    private static final String PACKAGE_DELIMITER = ":";
    private static final String PATH_DELIMITER = "/";
    private static final String PREFIX_ATTR = "?";
    private static final String PREFIX_RESOURCE = "@";

    public static Integer getColor(Object obj, Context context) {
        Color colorInstance;
        try {
            if (supportWideGamut() && (colorInstance = getColorInstance(obj, context)) != null) {
                return Integer.valueOf(colorInstance.toArgb());
            }
        } catch (JSApplicationCausedNativeException e10) {
            a.J("ReactNative", e10, "Error extracting color from WideGamut", new Object[0]);
        }
        return getColorInteger(obj, context);
    }

    @Nullable
    public static Color getColorInstance(Object obj, Context context) {
        ColorSpace.Named named;
        if (obj == null) {
            return null;
        }
        if (supportWideGamut() && (obj instanceof Double)) {
            return Color.valueOf(((Double) obj).intValue());
        }
        if (context == null) {
            throw new RuntimeException("Context may not be null.");
        } else if (obj instanceof ReadableMap) {
            ReadableMap readableMap = (ReadableMap) obj;
            if (!supportWideGamut() || !readableMap.hasKey("space")) {
                ReadableArray array = readableMap.getArray(JSON_KEY);
                if (array != null) {
                    for (int i10 = 0; i10 < array.size(); i10++) {
                        Integer resolveResourcePath = resolveResourcePath(context, array.getString(i10));
                        if (supportWideGamut() && resolveResourcePath != null) {
                            return Color.valueOf(resolveResourcePath.intValue());
                        }
                    }
                    throw new JSApplicationCausedNativeException("ColorValue: None of the paths in the `resource_paths` array resolved to a color resource.");
                }
                throw new JSApplicationCausedNativeException("ColorValue: The `resource_paths` must be an array of color resource path strings.");
            }
            String string = readableMap.getString("space");
            if (string == null || !string.equals("display-p3")) {
                named = ColorSpace.Named.SRGB;
            } else {
                named = ColorSpace.Named.DISPLAY_P3;
            }
            return Color.valueOf(Color.pack((float) readableMap.getDouble("r"), (float) readableMap.getDouble("g"), (float) readableMap.getDouble("b"), (float) readableMap.getDouble("a"), ColorSpace.get(named)));
        } else {
            throw new JSApplicationCausedNativeException("ColorValue: the value must be a number or Object.");
        }
    }

    @Nullable
    private static Integer getColorInteger(Object obj, Context context) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if (context == null) {
            throw new RuntimeException("Context may not be null.");
        } else if (obj instanceof ReadableMap) {
            ReadableMap readableMap = (ReadableMap) obj;
            if (readableMap.hasKey("space")) {
                return Integer.valueOf(Color.argb((int) (((float) readableMap.getDouble("a")) * 255.0f), (int) (((float) readableMap.getDouble("r")) * 255.0f), (int) (((float) readableMap.getDouble("g")) * 255.0f), (int) (((float) readableMap.getDouble("b")) * 255.0f)));
            }
            ReadableArray array = readableMap.getArray(JSON_KEY);
            if (array != null) {
                for (int i10 = 0; i10 < array.size(); i10++) {
                    Integer resolveResourcePath = resolveResourcePath(context, array.getString(i10));
                    if (resolveResourcePath != null) {
                        return resolveResourcePath;
                    }
                }
                throw new JSApplicationCausedNativeException("ColorValue: None of the paths in the `resource_paths` array resolved to a color resource.");
            }
            throw new JSApplicationCausedNativeException("ColorValue: The `resource_paths` must be an array of color resource path strings.");
        } else {
            throw new JSApplicationCausedNativeException("ColorValue: the value must be a number or Object.");
        }
    }

    private static int resolveResource(Context context, String str) {
        String[] split = str.split(PACKAGE_DELIMITER);
        String packageName = context.getPackageName();
        if (split.length > 1) {
            packageName = split[0];
            str = split[1];
        }
        String[] split2 = str.split("/");
        String str2 = split2[0];
        return ResourcesCompat.getColor(context.getResources(), context.getResources().getIdentifier(split2[1], str2, packageName), context.getTheme());
    }

    public static Integer resolveResourcePath(Context context, @Nullable String str) {
        if (str != null && !str.isEmpty()) {
            boolean startsWith = str.startsWith(PREFIX_RESOURCE);
            boolean startsWith2 = str.startsWith(PREFIX_ATTR);
            String substring = str.substring(1);
            if (startsWith) {
                try {
                    return Integer.valueOf(resolveResource(context, substring));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (startsWith2) {
                return Integer.valueOf(resolveThemeAttribute(context, substring));
            }
        }
        return null;
    }

    private static int resolveThemeAttribute(Context context, String str) {
        String replaceAll = str.replaceAll(ATTR_SEGMENT, "");
        String[] split = replaceAll.split(PACKAGE_DELIMITER);
        String packageName = context.getPackageName();
        if (split.length > 1) {
            packageName = split[0];
            replaceAll = split[1];
        }
        int identifier = context.getResources().getIdentifier(replaceAll, ATTR, packageName);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(identifier, typedValue, true)) {
            return typedValue.data;
        }
        throw new Resources.NotFoundException();
    }

    private static boolean supportWideGamut() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static Integer getColor(Object obj, Context context, int i10) {
        try {
            return getColor(obj, context);
        } catch (JSApplicationCausedNativeException e10) {
            a.J("ReactNative", e10, "Error converting ColorValue", new Object[0]);
            return Integer.valueOf(i10);
        }
    }
}
