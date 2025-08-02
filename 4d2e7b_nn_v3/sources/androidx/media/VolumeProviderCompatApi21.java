package androidx.media;

import android.media.VolumeProvider;

abstract class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i10);

        void onSetVolumeTo(int i10);
    }

    static class a extends VolumeProvider {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Delegate f16028a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(int i10, int i11, int i12, Delegate delegate) {
            super(i10, i11, i12);
            this.f16028a = delegate;
        }

        public void onAdjustVolume(int i10) {
            this.f16028a.onAdjustVolume(i10);
        }

        public void onSetVolumeTo(int i10) {
            this.f16028a.onSetVolumeTo(i10);
        }
    }

    public static Object a(int i10, int i11, int i12, Delegate delegate) {
        return new a(i10, i11, i12, delegate);
    }

    public static void b(Object obj, int i10) {
        ((VolumeProvider) obj).setCurrentVolume(i10);
    }
}
