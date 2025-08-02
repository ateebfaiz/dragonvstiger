package com.sensorsdata.analytics.android.sdk.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.lang.ref.WeakReference;

public class SAFragmentUtils {
    @SuppressLint({"NewApi"})
    private static LruCache<String, WeakReference<Object>> sFragmentLruCache = new LruCache<>(Integer.MAX_VALUE);

    public static boolean fragmentGetUserVisibleHint(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("getUserVisibleHint", (Class[]) null).invoke(obj, (Object[]) null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean fragmentIsHidden(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("isHidden", (Class[]) null).invoke(obj, (Object[]) null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean fragmentIsResumed(Object obj) {
        try {
            return ((Boolean) obj.getClass().getMethod("isResumed", (Class[]) null).invoke(obj, (Object[]) null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Activity getActivityFromFragment(Object obj) {
        try {
            return (Activity) obj.getClass().getMethod("getActivity", (Class[]) null).invoke(obj, (Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object getFragmentFromCache(String str) {
        Object obj;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            WeakReference weakReference = sFragmentLruCache.get(str);
            if (weakReference != null && (obj = weakReference.get()) != null) {
                return obj;
            }
            Object newInstance = Class.forName(str).newInstance();
            sFragmentLruCache.put(str, new WeakReference(newInstance));
            return newInstance;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public static Object getFragmentFromView(View view) {
        return getFragmentFromView(view, (Activity) null);
    }

    public static boolean isFragment(Object obj) {
        Class<?> cls;
        Class<Fragment> cls2;
        Class<Fragment> cls3 = Fragment.class;
        if (obj == null) {
            return false;
        }
        try {
            cls = Class.forName("android.app.Fragment");
        } catch (Exception unused) {
            cls = null;
        }
        try {
            int i10 = Fragment.f15537a;
            cls2 = cls3;
        } catch (Exception unused2) {
            cls2 = null;
        }
        try {
            int i11 = Fragment.f15537a;
        } catch (Exception unused3) {
            cls3 = null;
        }
        if (cls2 == null && cls3 == null && cls == null) {
            return false;
        }
        if (cls2 != null) {
            try {
                if (cls2.isInstance(obj)) {
                    return true;
                }
            } catch (Exception unused4) {
            }
        }
        if (cls3 != null && cls3.isInstance(obj)) {
            return true;
        }
        if (cls == null || !cls.isInstance(obj)) {
            return false;
        }
        return true;
    }

    public static boolean isFragmentVisible(Object obj) {
        Object obj2 = null;
        try {
            obj2 = obj.getClass().getMethod("getParentFragment", (Class[]) null).invoke(obj, (Object[]) null);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        if (obj2 == null) {
            try {
                if (fragmentIsHidden(obj) || !fragmentGetUserVisibleHint(obj) || !fragmentIsResumed(obj)) {
                    return false;
                }
                return true;
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
                return false;
            }
        } else if (fragmentIsHidden(obj) || !fragmentGetUserVisibleHint(obj) || !fragmentIsResumed(obj) || fragmentIsHidden(obj2) || !fragmentGetUserVisibleHint(obj2) || !fragmentIsResumed(obj2)) {
            return false;
        } else {
            return true;
        }
    }

    public static void setFragmentToCache(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            sFragmentLruCache.put(str, new WeakReference(obj));
        }
    }

    private static String traverseParentViewTag(View view) {
        try {
            ViewParent parent = view.getParent();
            String str = null;
            while (TextUtils.isEmpty(str) && (parent instanceof View)) {
                str = (String) ((View) parent).getTag(R.id.sensors_analytics_tag_view_fragment_name);
                parent = parent.getParent();
            }
            return str;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public static Object getFragmentFromView(View view, Activity activity) {
        Window window;
        if (view == null) {
            return null;
        }
        try {
            String str = (String) view.getTag(R.id.sensors_analytics_tag_view_fragment_name);
            String str2 = (String) view.getTag(R.id.sensors_analytics_tag_view_fragment_name2);
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
            if (TextUtils.isEmpty(str)) {
                if (activity == null) {
                    activity = SAViewUtils.getActivityOfView(view.getContext(), view);
                }
                if (!(activity == null || (window = activity.getWindow()) == null || !window.isActive() || window.getDecorView().getRootView().getTag(R.id.sensors_analytics_tag_view_fragment_name) == null)) {
                    str = traverseParentViewTag(view);
                }
            }
            return getFragmentFromCache(str);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }
}
