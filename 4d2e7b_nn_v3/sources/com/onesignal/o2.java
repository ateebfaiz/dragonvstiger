package com.onesignal;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class o2 {

    /* renamed from: a  reason: collision with root package name */
    private String f10873a;

    /* renamed from: b  reason: collision with root package name */
    private List f10874b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f10875c;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f10876a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f10877b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f10878c;

        a(Method method, Object obj, Object obj2) {
            this.f10876a = method;
            this.f10877b = obj;
            this.f10878c = obj2;
        }

        public void run() {
            try {
                this.f10876a.invoke(this.f10877b, new Object[]{this.f10878c});
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
    }

    o2(String str, boolean z10) {
        this.f10873a = str;
        this.f10875c = z10;
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        this.f10874b.add(new WeakReference(obj));
    }

    /* access modifiers changed from: package-private */
    public void b(Object obj) {
        this.f10874b.add(obj);
    }

    /* access modifiers changed from: package-private */
    public boolean c(Object obj) {
        boolean z10 = false;
        for (Object next : this.f10874b) {
            if (next instanceof WeakReference) {
                next = ((WeakReference) next).get();
            }
            if (next != null) {
                try {
                    Method declaredMethod = next.getClass().getDeclaredMethod(this.f10873a, new Class[]{obj.getClass()});
                    declaredMethod.setAccessible(true);
                    if (this.f10875c) {
                        q.f10966a.b(new a(declaredMethod, next, obj));
                    } else {
                        try {
                            declaredMethod.invoke(next, new Object[]{obj});
                        } catch (IllegalAccessException e10) {
                            e10.printStackTrace();
                        } catch (InvocationTargetException e11) {
                            e11.printStackTrace();
                        }
                    }
                    z10 = true;
                } catch (NoSuchMethodException e12) {
                    e12.printStackTrace();
                }
            }
        }
        return z10;
    }
}
