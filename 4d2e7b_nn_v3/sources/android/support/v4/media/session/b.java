package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: android.support.v4.media.session.b$a$a  reason: collision with other inner class name */
        private static class C0177a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f13764a;

            C0177a(IBinder iBinder) {
                this.f13764a = iBinder;
            }

            public IBinder asBinder() {
                return this.f13764a;
            }
        }

        public static b M(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0177a(iBinder);
            }
            return (b) queryLocalInterface;
        }
    }
}
