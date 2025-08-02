package com.sensorsdata.analytics.android.autotrack.utils;

import android.view.View;
import android.view.ViewGroup;
import com.sensorsdata.analytics.android.autotrack.R;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import java.util.regex.Pattern;

public class KeyboardViewUtil {
    private static final String MATCH_RULE_KEYBOARD = "^([A-Za-z]|[0-9])";
    private static final String TAG_KEYBOARD = "keyboard_tag";
    private static boolean isSensorsCheckKeyboard = true;

    private static boolean getKeyboardSimilarFatherView(View view) {
        if (!(view.getParent() instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup.getTag(R.id.sensors_analytics_tag_view_keyboard) != null) {
            return true;
        }
        int childCount = viewGroup.getChildCount();
        if (childCount <= 1) {
            return false;
        }
        int indexOfChild = viewGroup.indexOfChild(view);
        for (int i10 = 0; i10 < childCount; i10++) {
            if (indexOfChild != i10) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getTag(R.id.sensors_analytics_tag_view_keyboard) == null) {
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        int childCount2 = viewGroup2.getChildCount();
                        int i11 = 0;
                        while (i11 < childCount2) {
                            if (Pattern.matches(MATCH_RULE_KEYBOARD, SAViewUtils.getViewContent(viewGroup2.getChildAt(i11)))) {
                                viewGroup2.setTag(R.id.sensors_analytics_tag_view_keyboard, TAG_KEYBOARD);
                                viewGroup.setTag(R.id.sensors_analytics_tag_view_keyboard, TAG_KEYBOARD);
                            } else {
                                i11++;
                            }
                        }
                        continue;
                    } else if (Pattern.matches(MATCH_RULE_KEYBOARD, SAViewUtils.getViewContent(childAt))) {
                        childAt.setTag(R.id.sensors_analytics_tag_view_keyboard, TAG_KEYBOARD);
                        viewGroup.setTag(R.id.sensors_analytics_tag_view_keyboard, TAG_KEYBOARD);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static boolean getKeyboardSimilarView(View view) {
        if (!(view.getParent() instanceof ViewGroup)) {
            return getKeyboardSimilarFatherView((View) view.getParent());
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup.getTag(R.id.sensors_analytics_tag_view_keyboard) != null) {
            return true;
        }
        int indexOfChild = viewGroup.indexOfChild(view);
        int childCount = viewGroup.getChildCount();
        if (childCount <= 1) {
            return getKeyboardSimilarFatherView(viewGroup);
        }
        int i10 = 0;
        while (i10 < childCount) {
            if (indexOfChild == i10 || !Pattern.matches(MATCH_RULE_KEYBOARD, SAViewUtils.getViewContent(viewGroup.getChildAt(i10)))) {
                i10++;
            } else {
                viewGroup.setTag(R.id.sensors_analytics_tag_view_keyboard, TAG_KEYBOARD);
                return true;
            }
        }
        return getKeyboardSimilarFatherView(viewGroup);
    }

    public static boolean isKeyboardView(View view) {
        if (!isSensorsCheckKeyboard || view == null || !Pattern.matches(MATCH_RULE_KEYBOARD, SAViewUtils.getViewContent(view))) {
            return false;
        }
        return getKeyboardSimilarView(view);
    }
}
