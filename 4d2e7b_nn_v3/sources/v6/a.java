package v6;

import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.camera.ImageStoreManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageStoreManager f13164a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f13165b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callback f13166c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Callback f13167d;

    public /* synthetic */ a(ImageStoreManager imageStoreManager, String str, Callback callback, Callback callback2) {
        this.f13164a = imageStoreManager;
        this.f13165b = str;
        this.f13166c = callback;
        this.f13167d = callback2;
    }

    public final void run() {
        ImageStoreManager.getBase64ForTag$lambda$0(this.f13164a, this.f13165b, this.f13166c, this.f13167d);
    }
}
