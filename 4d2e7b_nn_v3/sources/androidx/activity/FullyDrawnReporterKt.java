package androidx.activity;

import kotlin.Unit;
import kotlin.coroutines.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.k;

public final class FullyDrawnReporterKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object reportWhenComplete(androidx.activity.FullyDrawnReporter r4, kotlin.jvm.functions.Function1<? super kotlin.coroutines.d, ? extends java.lang.Object> r5, kotlin.coroutines.d r6) {
        /*
            boolean r0 = r6 instanceof androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.L$0
            androidx.activity.FullyDrawnReporter r4 = (androidx.activity.FullyDrawnReporter) r4
            kotlin.p.b(r6)     // Catch:{ all -> 0x002d }
            goto L_0x0051
        L_0x002d:
            r5 = move-exception
            goto L_0x005d
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.p.b(r6)
            r4.addReporter()
            boolean r6 = r4.isFullyDrawnReported()
            if (r6 == 0) goto L_0x0046
            kotlin.Unit r4 = kotlin.Unit.f12577a
            return r4
        L_0x0046:
            r0.L$0 = r4     // Catch:{ all -> 0x002d }
            r0.label = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r5.invoke(r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x0051
            return r1
        L_0x0051:
            kotlin.jvm.internal.k.b(r3)
            r4.removeReporter()
            kotlin.jvm.internal.k.a(r3)
            kotlin.Unit r4 = kotlin.Unit.f12577a
            return r4
        L_0x005d:
            kotlin.jvm.internal.k.b(r3)
            r4.removeReporter()
            kotlin.jvm.internal.k.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, kotlin.jvm.functions.Function1, kotlin.coroutines.d):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, Function1<? super d, ? extends Object> function1, d dVar) {
        fullyDrawnReporter.addReporter();
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return Unit.f12577a;
        }
        try {
            function1.invoke(dVar);
            k.b(1);
            fullyDrawnReporter.removeReporter();
            k.a(1);
            return Unit.f12577a;
        } catch (Throwable th) {
            k.b(1);
            fullyDrawnReporter.removeReporter();
            k.a(1);
            throw th;
        }
    }
}
