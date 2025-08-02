package com.facebook.react.devsupport;

import androidx.annotation.Nullable;
import com.facebook.fbreact.specs.NativeJSCHeapCaptureSpec;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.File;

@s6.a(name = "JSCHeapCapture", needsEagerInit = true)
public class JSCHeapCapture extends NativeJSCHeapCaptureSpec {
    @Nullable
    private a mCaptureInProgress = null;

    public interface HeapCapture extends JavaScriptModule {
        void captureHeap(String str);
    }

    public interface a {
        void a(File file);

        void b(b bVar);
    }

    public static class b extends Exception {
        b(String str) {
            super(str);
        }
    }

    public JSCHeapCapture(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public synchronized void captureComplete(String str, String str2) {
        try {
            a aVar = this.mCaptureInProgress;
            if (aVar != null) {
                if (str2 == null) {
                    aVar.a(new File(str));
                } else {
                    aVar.b(new b(str2));
                }
                this.mCaptureInProgress = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void captureHeap(java.lang.String r3, com.facebook.react.devsupport.JSCHeapCapture.a r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.facebook.react.devsupport.JSCHeapCapture$a r0 = r2.mCaptureInProgress     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x0013
            com.facebook.react.devsupport.JSCHeapCapture$b r3 = new com.facebook.react.devsupport.JSCHeapCapture$b     // Catch:{ all -> 0x0011 }
            java.lang.String r0 = "Heap capture already in progress."
            r3.<init>(r0)     // Catch:{ all -> 0x0011 }
            r4.b(r3)     // Catch:{ all -> 0x0011 }
            monitor-exit(r2)
            return
        L_0x0011:
            r3 = move-exception
            goto L_0x0053
        L_0x0013:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0011 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0011 }
            r1.<init>()     // Catch:{ all -> 0x0011 }
            r1.append(r3)     // Catch:{ all -> 0x0011 }
            java.lang.String r3 = "/capture.json"
            r1.append(r3)     // Catch:{ all -> 0x0011 }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0011 }
            r0.<init>(r3)     // Catch:{ all -> 0x0011 }
            r0.delete()     // Catch:{ all -> 0x0011 }
            com.facebook.react.bridge.ReactApplicationContext r3 = r2.getReactApplicationContextIfActiveOrWarn()     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x0051
            java.lang.Class<com.facebook.react.devsupport.JSCHeapCapture$HeapCapture> r1 = com.facebook.react.devsupport.JSCHeapCapture.HeapCapture.class
            com.facebook.react.bridge.JavaScriptModule r3 = r3.getJSModule(r1)     // Catch:{ all -> 0x0011 }
            com.facebook.react.devsupport.JSCHeapCapture$HeapCapture r3 = (com.facebook.react.devsupport.JSCHeapCapture.HeapCapture) r3     // Catch:{ all -> 0x0011 }
            if (r3 != 0) goto L_0x0048
            com.facebook.react.devsupport.JSCHeapCapture$b r3 = new com.facebook.react.devsupport.JSCHeapCapture$b     // Catch:{ all -> 0x0011 }
            java.lang.String r0 = "Heap capture js module not registered."
            r3.<init>(r0)     // Catch:{ all -> 0x0011 }
            r4.b(r3)     // Catch:{ all -> 0x0011 }
            monitor-exit(r2)
            return
        L_0x0048:
            r2.mCaptureInProgress = r4     // Catch:{ all -> 0x0011 }
            java.lang.String r4 = r0.getPath()     // Catch:{ all -> 0x0011 }
            r3.captureHeap(r4)     // Catch:{ all -> 0x0011 }
        L_0x0051:
            monitor-exit(r2)
            return
        L_0x0053:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.JSCHeapCapture.captureHeap(java.lang.String, com.facebook.react.devsupport.JSCHeapCapture$a):void");
    }
}
