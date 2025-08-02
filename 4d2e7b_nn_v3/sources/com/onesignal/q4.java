package com.onesignal;

import android.content.Context;
import com.alibaba.pdns.model.DomainUhfReportModel;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.onesignal.o3;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class q4 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f11001a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11002b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f11003c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11004d = false;

    /* renamed from: e  reason: collision with root package name */
    private Object f11005e;

    /* renamed from: f  reason: collision with root package name */
    private Field f11006f;

    class a implements Runnable {
        a() {
        }

        public void run() {
            PurchasingService.registerListener(q4.this.f11001a, q4.this.f11003c);
        }
    }

    private class b implements PurchasingListener {

        /* renamed from: a  reason: collision with root package name */
        PurchasingListener f11008a;

        private b() {
        }

        /* synthetic */ b(q4 q4Var, a aVar) {
            this();
        }
    }

    q4(Context context) {
        this.f11001a = context;
        try {
            Class<?> cls = Class.forName("com.amazon.device.iap.internal.d");
            try {
                this.f11005e = cls.getMethod(DomainUhfReportModel.ENCRYPTDATA, (Class[]) null).invoke((Object) null, (Object[]) null);
            } catch (NullPointerException unused) {
                this.f11005e = cls.getMethod("e", (Class[]) null).invoke((Object) null, (Object[]) null);
                this.f11004d = true;
            }
            Field declaredField = cls.getDeclaredField("f");
            this.f11006f = declaredField;
            declaredField.setAccessible(true);
            b bVar = new b(this, (a) null);
            this.f11003c = bVar;
            bVar.f11008a = (PurchasingListener) this.f11006f.get(this.f11005e);
            this.f11002b = true;
            e();
        } catch (ClassNotFoundException e10) {
            d(e10);
        } catch (IllegalAccessException e11) {
            d(e11);
        } catch (InvocationTargetException e12) {
            d(e12);
        } catch (NoSuchMethodException e13) {
            d(e13);
        } catch (NoSuchFieldException e14) {
            d(e14);
        } catch (ClassCastException e15) {
            d(e15);
        }
    }

    private static void d(Exception exc) {
        o3.b(o3.v.ERROR, "Error adding Amazon IAP listener.", exc);
        exc.printStackTrace();
    }

    private void e() {
        if (this.f11004d) {
            OSUtils.S(new a());
        } else {
            PurchasingService.registerListener(this.f11001a, this.f11003c);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f11002b) {
            try {
                b bVar = (PurchasingListener) this.f11006f.get(this.f11005e);
                b bVar2 = this.f11003c;
                if (bVar != bVar2) {
                    bVar2.f11008a = bVar;
                    e();
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            }
        }
    }
}
