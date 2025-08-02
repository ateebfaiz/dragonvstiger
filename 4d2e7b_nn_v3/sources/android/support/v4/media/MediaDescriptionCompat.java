package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.support.v4.media.c;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f13703a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f13704b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f13705c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f13706d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f13707e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f13708f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f13709g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f13710h;

    /* renamed from: i  reason: collision with root package name */
    private Object f13711i;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(b.a(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i10) {
            return new MediaDescriptionCompat[i10];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f13712a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f13713b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f13714c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f13715d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f13716e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f13717f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f13718g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f13719h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f13712a, this.f13713b, this.f13714c, this.f13715d, this.f13716e, this.f13717f, this.f13718g, this.f13719h);
        }

        public b b(CharSequence charSequence) {
            this.f13715d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f13718g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f13716e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f13717f = uri;
            return this;
        }

        public b f(String str) {
            this.f13712a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f13719h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f13714c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f13713b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f13703a = str;
        this.f13704b = charSequence;
        this.f13705c = charSequence2;
        this.f13706d = charSequence3;
        this.f13707e = bitmap;
        this.f13708f = uri;
        this.f13709g = bundle;
        this.f13710h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0074
            android.support.v4.media.MediaDescriptionCompat$b r1 = new android.support.v4.media.MediaDescriptionCompat$b
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.b.f(r8)
            r1.f(r2)
            java.lang.CharSequence r2 = android.support.v4.media.b.h(r8)
            r1.i(r2)
            java.lang.CharSequence r2 = android.support.v4.media.b.g(r8)
            r1.h(r2)
            java.lang.CharSequence r2 = android.support.v4.media.b.b(r8)
            r1.b(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.b.d(r8)
            r1.d(r2)
            android.net.Uri r2 = android.support.v4.media.b.e(r8)
            r1.e(r2)
            android.os.Bundle r2 = android.support.v4.media.b.c(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L_0x0044
            android.support.v4.media.session.MediaSessionCompat.a(r2)
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            goto L_0x0045
        L_0x0044:
            r4 = r0
        L_0x0045:
            if (r4 == 0) goto L_0x005d
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L_0x0057
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L_0x0057
            goto L_0x005e
        L_0x0057:
            r2.remove(r3)
            r2.remove(r5)
        L_0x005d:
            r0 = r2
        L_0x005e:
            r1.c(r0)
            if (r4 == 0) goto L_0x0067
            r1.g(r4)
            goto L_0x006e
        L_0x0067:
            android.net.Uri r0 = android.support.v4.media.c.a(r8)
            r1.g(r0)
        L_0x006e:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.f13711i = r8
        L_0x0074:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Object b() {
        Object obj = this.f13711i;
        if (obj != null) {
            return obj;
        }
        Object b10 = b.a.b();
        b.a.g(b10, this.f13703a);
        b.a.i(b10, this.f13704b);
        b.a.h(b10, this.f13705c);
        b.a.c(b10, this.f13706d);
        b.a.e(b10, this.f13707e);
        b.a.f(b10, this.f13708f);
        b.a.d(b10, this.f13709g);
        c.a.a(b10, this.f13710h);
        Object a10 = b.a.a(b10);
        this.f13711i = a10;
        return a10;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f13704b + ", " + this.f13705c + ", " + this.f13706d;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        b.i(b(), parcel, i10);
    }
}
