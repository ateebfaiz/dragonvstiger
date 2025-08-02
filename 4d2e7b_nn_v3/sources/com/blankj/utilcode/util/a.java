package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static List f18396a;

    /* renamed from: com.blankj.utilcode.util.a$a  reason: collision with other inner class name */
    class C0238a implements Runnable {
        C0238a() {
        }

        public void run() {
            a.g();
        }
    }

    private static void b(Resources resources, float f10) {
        resources.getDisplayMetrics().xdpi = f10;
        p.a().getResources().getDisplayMetrics().xdpi = f10;
        d(resources, f10);
    }

    private static void c(Resources resources, float f10) {
        for (Field field : f18396a) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) field.get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f10;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private static void d(Resources resources, float f10) {
        if (f18396a == null) {
            f18396a = new ArrayList();
            Class cls = resources.getClass();
            Field[] declaredFields = cls.getDeclaredFields();
            while (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                        field.setAccessible(true);
                        DisplayMetrics e10 = e(resources, field);
                        if (e10 != null) {
                            f18396a.add(field);
                            e10.xdpi = f10;
                        }
                    }
                }
                cls = cls.getSuperclass();
                if (cls != null) {
                    declaredFields = cls.getDeclaredFields();
                } else {
                    return;
                }
            }
            return;
        }
        c(resources, f10);
    }

    private static DisplayMetrics e(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    static Runnable f() {
        return new C0238a();
    }

    /* access modifiers changed from: private */
    public static void g() {
        b(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }
}
