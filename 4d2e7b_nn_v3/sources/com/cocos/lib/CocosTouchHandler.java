package com.cocos.lib;

import android.util.Log;
import android.view.MotionEvent;

public class CocosTouchHandler {
    public static final String TAG = "CocosTouchHandler";
    private boolean mStopHandleTouchAndKeyEvents = false;
    /* access modifiers changed from: private */
    public int mWindowId;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19294a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f19295b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f19296c;

        a(int i10, float f10, float f11) {
            this.f19294a = i10;
            this.f19295b = f10;
            this.f19296c = f11;
        }

        public void run() {
            CocosTouchHandler cocosTouchHandler = CocosTouchHandler.this;
            cocosTouchHandler.handleActionDown(cocosTouchHandler.mWindowId, this.f19294a, this.f19295b, this.f19296c);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19298a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f19299b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f19300c;

        b(int i10, float f10, float f11) {
            this.f19298a = i10;
            this.f19299b = f10;
            this.f19300c = f11;
        }

        public void run() {
            CocosTouchHandler cocosTouchHandler = CocosTouchHandler.this;
            cocosTouchHandler.handleActionDown(cocosTouchHandler.mWindowId, this.f19298a, this.f19299b, this.f19300c);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f19302a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float[] f19303b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float[] f19304c;

        c(int[] iArr, float[] fArr, float[] fArr2) {
            this.f19302a = iArr;
            this.f19303b = fArr;
            this.f19304c = fArr2;
        }

        public void run() {
            CocosTouchHandler cocosTouchHandler = CocosTouchHandler.this;
            cocosTouchHandler.handleActionMove(cocosTouchHandler.mWindowId, this.f19302a, this.f19303b, this.f19304c);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19306a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f19307b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f19308c;

        d(int i10, float f10, float f11) {
            this.f19306a = i10;
            this.f19307b = f10;
            this.f19308c = f11;
        }

        public void run() {
            CocosTouchHandler cocosTouchHandler = CocosTouchHandler.this;
            cocosTouchHandler.handleActionUp(cocosTouchHandler.mWindowId, this.f19306a, this.f19307b, this.f19308c);
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19310a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f19311b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f19312c;

        e(int i10, float f10, float f11) {
            this.f19310a = i10;
            this.f19311b = f10;
            this.f19312c = f11;
        }

        public void run() {
            CocosTouchHandler cocosTouchHandler = CocosTouchHandler.this;
            cocosTouchHandler.handleActionUp(cocosTouchHandler.mWindowId, this.f19310a, this.f19311b, this.f19312c);
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f19314a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float[] f19315b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float[] f19316c;

        f(int[] iArr, float[] fArr, float[] fArr2) {
            this.f19314a = iArr;
            this.f19315b = fArr;
            this.f19316c = fArr2;
        }

        public void run() {
            CocosTouchHandler cocosTouchHandler = CocosTouchHandler.this;
            cocosTouchHandler.handleActionCancel(cocosTouchHandler.mWindowId, this.f19314a, this.f19315b, this.f19316c);
        }
    }

    public CocosTouchHandler(int i10) {
        this.mWindowId = i10;
    }

    private static void dumpMotionEvent(MotionEvent motionEvent) {
        StringBuilder sb2 = new StringBuilder();
        int action = motionEvent.getAction();
        int i10 = action & 255;
        sb2.append("event ACTION_");
        sb2.append(new String[]{"DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE", "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"}[i10]);
        if (i10 == 5 || i10 == 6) {
            sb2.append("(pid ");
            sb2.append(action >> 8);
            sb2.append(")");
        }
        sb2.append("[");
        int i11 = 0;
        while (i11 < motionEvent.getPointerCount()) {
            sb2.append("#");
            sb2.append(i11);
            sb2.append("(pid ");
            sb2.append(motionEvent.getPointerId(i11));
            sb2.append(")=");
            sb2.append((int) motionEvent.getX(i11));
            sb2.append(",");
            sb2.append((int) motionEvent.getY(i11));
            i11++;
            if (i11 < motionEvent.getPointerCount()) {
                sb2.append(";");
            }
        }
        sb2.append("]");
        Log.d(TAG, sb2.toString());
    }

    /* access modifiers changed from: private */
    public native void handleActionCancel(int i10, int[] iArr, float[] fArr, float[] fArr2);

    /* access modifiers changed from: private */
    public native void handleActionDown(int i10, int i11, float f10, float f11);

    /* access modifiers changed from: private */
    public native void handleActionMove(int i10, int[] iArr, float[] fArr, float[] fArr2);

    /* access modifiers changed from: private */
    public native void handleActionUp(int i10, int i11, float f10, float f11);

    /* access modifiers changed from: package-private */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int[] iArr = new int[pointerCount];
        float[] fArr = new float[pointerCount];
        float[] fArr2 = new float[pointerCount];
        for (int i10 = 0; i10 < pointerCount; i10++) {
            iArr[i10] = motionEvent.getPointerId(i10);
            fArr[i10] = motionEvent.getX(i10);
            fArr2[i10] = motionEvent.getY(i10);
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                CocosHelper.runOnGameThreadAtForeground(new e(motionEvent.getPointerId(0), fArr[0], fArr2[0]));
            } else if (action == 2) {
                CocosHelper.runOnGameThreadAtForeground(new c(iArr, fArr, fArr2));
            } else if (action == 3) {
                CocosHelper.runOnGameThreadAtForeground(new f(iArr, fArr, fArr2));
            } else if (action != 5) {
                if (action == 6) {
                    int action2 = motionEvent.getAction() >> 8;
                    CocosHelper.runOnGameThreadAtForeground(new d(motionEvent.getPointerId(action2), motionEvent.getX(action2), motionEvent.getY(action2)));
                }
            } else if (this.mStopHandleTouchAndKeyEvents) {
                return true;
            } else {
                int action3 = motionEvent.getAction() >> 8;
                CocosHelper.runOnGameThreadAtForeground(new a(motionEvent.getPointerId(action3), motionEvent.getX(action3), motionEvent.getY(action3)));
            }
        } else if (this.mStopHandleTouchAndKeyEvents) {
            return true;
        } else {
            CocosHelper.runOnGameThreadAtForeground(new b(motionEvent.getPointerId(0), fArr[0], fArr2[0]));
        }
        return true;
    }

    public void setStopHandleTouchAndKeyEvents(boolean z10) {
        this.mStopHandleTouchAndKeyEvents = z10;
    }
}
