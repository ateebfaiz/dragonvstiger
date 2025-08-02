package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.LifecycleEventObserver;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class ImmLeaksCleaner implements LifecycleEventObserver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy cleaner$delegate = i.b(a.f13783a);
    private final Activity activity;

    public static abstract class Cleaner {
        private Cleaner() {
        }

        public abstract boolean clearNextServedView(InputMethodManager inputMethodManager);

        public abstract Object getLock(InputMethodManager inputMethodManager);

        public abstract View getServedView(InputMethodManager inputMethodManager);

        public /* synthetic */ Cleaner(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static final class Companion {
        private Companion() {
        }

        public final Cleaner getCleaner() {
            return (Cleaner) ImmLeaksCleaner.cleaner$delegate.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class FailedInitialization extends Cleaner {
        public static final FailedInitialization INSTANCE = new FailedInitialization();

        private FailedInitialization() {
            super((DefaultConstructorMarker) null);
        }

        public boolean clearNextServedView(InputMethodManager inputMethodManager) {
            m.f(inputMethodManager, "<this>");
            return false;
        }

        public Object getLock(InputMethodManager inputMethodManager) {
            m.f(inputMethodManager, "<this>");
            return null;
        }

        public View getServedView(InputMethodManager inputMethodManager) {
            m.f(inputMethodManager, "<this>");
            return null;
        }
    }

    public static final class ValidCleaner extends Cleaner {
        private final Field hField;
        private final Field nextServedViewField;
        private final Field servedViewField;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValidCleaner(Field field, Field field2, Field field3) {
            super((DefaultConstructorMarker) null);
            m.f(field, "hField");
            m.f(field2, "servedViewField");
            m.f(field3, "nextServedViewField");
            this.hField = field;
            this.servedViewField = field2;
            this.nextServedViewField = field3;
        }

        public boolean clearNextServedView(InputMethodManager inputMethodManager) {
            m.f(inputMethodManager, "<this>");
            try {
                this.nextServedViewField.set(inputMethodManager, (Object) null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        public Object getLock(InputMethodManager inputMethodManager) {
            m.f(inputMethodManager, "<this>");
            try {
                return this.hField.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public View getServedView(InputMethodManager inputMethodManager) {
            m.f(inputMethodManager, "<this>");
            try {
                return (View) this.servedViewField.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    static final class a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f13783a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Cleaner invoke() {
            Class<InputMethodManager> cls = InputMethodManager.class;
            try {
                Field declaredField = cls.getDeclaredField("mServedView");
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getDeclaredField("mNextServedView");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mH");
                declaredField3.setAccessible(true);
                m.e(declaredField3, "hField");
                m.e(declaredField, "servedViewField");
                m.e(declaredField2, "nextServedViewField");
                return new ValidCleaner(declaredField3, declaredField, declaredField2);
            } catch (NoSuchFieldException unused) {
                return FailedInitialization.INSTANCE;
            }
        }
    }

    public ImmLeaksCleaner(Activity activity2) {
        m.f(activity2, "activity");
        this.activity = activity2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r4 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        r3.isActive();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStateChanged(androidx.lifecycle.LifecycleOwner r3, androidx.lifecycle.Lifecycle.Event r4) {
        /*
            r2 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.m.f(r3, r0)
            java.lang.String r3 = "event"
            kotlin.jvm.internal.m.f(r4, r3)
            androidx.lifecycle.Lifecycle$Event r3 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY
            if (r4 == r3) goto L_0x000f
            return
        L_0x000f:
            android.app.Activity r3 = r2.activity
            java.lang.String r4 = "input_method"
            java.lang.Object r3 = r3.getSystemService(r4)
            java.lang.String r4 = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
            kotlin.jvm.internal.m.d(r3, r4)
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            androidx.activity.ImmLeaksCleaner$Companion r4 = Companion
            androidx.activity.ImmLeaksCleaner$Cleaner r4 = r4.getCleaner()
            java.lang.Object r0 = r4.getLock(r3)
            if (r0 != 0) goto L_0x002b
            return
        L_0x002b:
            monitor-enter(r0)
            android.view.View r1 = r4.getServedView(r3)     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x0034
            monitor-exit(r0)
            return
        L_0x0034:
            boolean r1 = r1.isAttachedToWindow()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x003c
            monitor-exit(r0)
            return
        L_0x003c:
            boolean r4 = r4.clearNextServedView(r3)     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)
            if (r4 == 0) goto L_0x0046
            r3.isActive()
        L_0x0046:
            return
        L_0x0047:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ImmLeaksCleaner.onStateChanged(androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Lifecycle$Event):void");
    }
}
