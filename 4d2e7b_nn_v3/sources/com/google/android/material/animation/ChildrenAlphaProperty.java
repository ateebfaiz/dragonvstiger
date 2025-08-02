package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R;

public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    @NonNull
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f10 = (Float) viewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (f10 != null) {
            return f10;
        }
        return Float.valueOf(1.0f);
    }

    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f10) {
        float floatValue = f10.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, f10);
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            viewGroup.getChildAt(i10).setAlpha(floatValue);
        }
    }
}
