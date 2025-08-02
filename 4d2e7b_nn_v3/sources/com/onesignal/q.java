package com.onesignal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10966a = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static b f10967b = b.MainUI;

    public static final class a {

        /* renamed from: com.onesignal.q$a$a  reason: collision with other inner class name */
        public /* synthetic */ class C0127a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f10968a;

            static {
                int[] iArr = new int[b.values().length];
                iArr[b.MainUI.ordinal()] = 1;
                iArr[b.Background.ordinal()] = 2;
                f10968a = iArr;
            }
        }

        static final class b extends n implements Function0 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f10969a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Runnable runnable) {
                super(0);
                this.f10969a = runnable;
            }

            public final void invoke() {
                this.f10969a.run();
            }
        }

        private a() {
        }

        public final b a() {
            return q.f10967b;
        }

        public final void b(Runnable runnable) {
            m.f(runnable, "runnable");
            int i10 = C0127a.f10968a[a().ordinal()];
            if (i10 == 1) {
                OSUtils.S(runnable);
            } else if (i10 == 2) {
                ob.a.b(false, false, (ClassLoader) null, (String) null, 0, new b(runnable), 31, (Object) null);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public enum b {
        MainUI,
        Background
    }
}
