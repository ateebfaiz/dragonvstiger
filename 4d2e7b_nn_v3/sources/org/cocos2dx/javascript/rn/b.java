package org.cocos2dx.javascript.rn;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RNDelegateManager f1483a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1484b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1485c;

    public /* synthetic */ b(RNDelegateManager rNDelegateManager, String str, String str2) {
        this.f1483a = rNDelegateManager;
        this.f1484b = str;
        this.f1485c = str2;
    }

    public final void run() {
        this.f1483a.lambda$show$2(this.f1484b, this.f1485c);
    }
}
