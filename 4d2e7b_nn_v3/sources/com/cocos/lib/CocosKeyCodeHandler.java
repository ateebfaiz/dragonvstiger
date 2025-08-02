package com.cocos.lib;

import android.view.KeyEvent;

public class CocosKeyCodeHandler {
    private CocosActivity mAct;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19286a;

        a(int i10) {
            this.f19286a = i10;
        }

        public void run() {
            CocosKeyCodeHandler.this.handleKeyDown(this.f19286a);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19288a;

        b(int i10) {
            this.f19288a = i10;
        }

        public void run() {
            CocosKeyCodeHandler.this.handleKeyUp(this.f19288a);
        }
    }

    public CocosKeyCodeHandler(CocosActivity cocosActivity) {
        this.mAct = cocosActivity;
    }

    public native void handleKeyDown(int i10);

    public native void handleKeyUp(int i10);

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!(i10 == 4 || i10 == 66 || i10 == 82 || i10 == 85)) {
            switch (i10) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    break;
                default:
                    return false;
            }
        }
        CocosHelper.runOnGameThreadAtForeground(new a(i10));
        return true;
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (!(i10 == 4 || i10 == 66 || i10 == 82 || i10 == 85)) {
            switch (i10) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    break;
                default:
                    return false;
            }
        }
        CocosHelper.runOnGameThreadAtForeground(new b(i10));
        return true;
    }
}
