package com.google.android.material.color;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.loader.ResourcesLoader;
import android.os.Build;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import java.util.HashMap;
import java.util.Map;

public class HarmonizedColors {
    private static final String TAG = "HarmonizedColors";

    private HarmonizedColors() {
    }

    @RequiresApi(api = 21)
    private static void addHarmonizedColorAttributesToReplacementMap(@NonNull Map<Integer, Integer> map, @NonNull TypedArray typedArray, @Nullable TypedArray typedArray2, @ColorInt int i10) {
        if (typedArray2 == null) {
            typedArray2 = typedArray;
        }
        for (int i11 = 0; i11 < typedArray.getIndexCount(); i11++) {
            int resourceId = typedArray2.getResourceId(i11, 0);
            if (resourceId != 0 && typedArray.hasValue(i11) && isColorResource(typedArray.getType(i11))) {
                map.put(Integer.valueOf(resourceId), Integer.valueOf(MaterialColors.harmonize(typedArray.getColor(i11, 0), i10)));
            }
        }
    }

    @RequiresApi(api = 30)
    private static boolean addResourcesLoaderToContext(Context context, Map<Integer, Integer> map) {
        ResourcesLoader a10 = h.a(context, map);
        if (a10 == null) {
            return false;
        }
        context.getResources().addLoaders(new ResourcesLoader[]{a10});
        return true;
    }

    @NonNull
    public static void applyToContextIfAvailable(@NonNull Context context, @NonNull HarmonizedColorsOptions harmonizedColorsOptions) {
        if (isHarmonizedColorAvailable()) {
            Map<Integer, Integer> createHarmonizedColorReplacementMap = createHarmonizedColorReplacementMap(context, harmonizedColorsOptions);
            int themeOverlayResourceId = harmonizedColorsOptions.getThemeOverlayResourceId(0);
            if (addResourcesLoaderToContext(context, createHarmonizedColorReplacementMap) && themeOverlayResourceId != 0) {
                n.a(context, themeOverlayResourceId);
            }
        }
    }

    @RequiresApi(api = 21)
    private static Map<Integer, Integer> createHarmonizedColorReplacementMap(Context context, HarmonizedColorsOptions harmonizedColorsOptions) {
        TypedArray typedArray;
        HashMap hashMap = new HashMap();
        int color = MaterialColors.getColor(context, harmonizedColorsOptions.getColorAttributeToHarmonizeWith(), TAG);
        for (int i10 : harmonizedColorsOptions.getColorResourceIds()) {
            hashMap.put(Integer.valueOf(i10), Integer.valueOf(MaterialColors.harmonize(ContextCompat.getColor(context, i10), color)));
        }
        HarmonizedColorAttributes colorAttributes = harmonizedColorsOptions.getColorAttributes();
        if (colorAttributes != null) {
            int[] attributes = colorAttributes.getAttributes();
            if (attributes.length > 0) {
                int themeOverlay = colorAttributes.getThemeOverlay();
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributes);
                if (themeOverlay != 0) {
                    typedArray = new ContextThemeWrapper(context, themeOverlay).obtainStyledAttributes(attributes);
                } else {
                    typedArray = null;
                }
                addHarmonizedColorAttributesToReplacementMap(hashMap, obtainStyledAttributes, typedArray, color);
                obtainStyledAttributes.recycle();
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
        return hashMap;
    }

    private static boolean isColorResource(int i10) {
        return 28 <= i10 && i10 <= 31;
    }

    @ChecksSdkIntAtLeast(api = 30)
    public static boolean isHarmonizedColorAvailable() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context, @NonNull HarmonizedColorsOptions harmonizedColorsOptions) {
        if (!isHarmonizedColorAvailable()) {
            return context;
        }
        Map<Integer, Integer> createHarmonizedColorReplacementMap = createHarmonizedColorReplacementMap(context, harmonizedColorsOptions);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, harmonizedColorsOptions.getThemeOverlayResourceId(R.style.ThemeOverlay_Material3_HarmonizedColors_Empty));
        contextThemeWrapper.applyOverrideConfiguration(new Configuration());
        if (addResourcesLoaderToContext(contextThemeWrapper, createHarmonizedColorReplacementMap)) {
            return contextThemeWrapper;
        }
        return context;
    }
}
