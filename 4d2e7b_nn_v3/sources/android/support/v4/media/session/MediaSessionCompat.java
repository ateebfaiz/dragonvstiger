package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import androidx.annotation.RestrictTo;

public abstract class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final MediaDescriptionCompat f13738a;

        /* renamed from: b  reason: collision with root package name */
        private final long f13739b;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: b */
            public QueueItem[] newArray(int i10) {
                return new QueueItem[i10];
            }
        }

        QueueItem(Parcel parcel) {
            this.f13738a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f13739b = parcel.readLong();
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f13738a + ", Id=" + this.f13739b + " }";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            this.f13738a.writeToParcel(parcel, i10);
            parcel.writeLong(this.f13739b);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        ResultReceiver f13740a;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i10) {
                return new ResultReceiverWrapper[i10];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f13740a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            this.f13740a.writeToParcel(parcel, i10);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Object f13741a;

        /* renamed from: b  reason: collision with root package name */
        private b f13742b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f13743c;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable((ClassLoader) null));
            }

            /* renamed from: b */
            public Token[] newArray(int i10) {
                return new Token[i10];
            }
        }

        Token(Object obj) {
            this(obj, (b) null, (Bundle) null);
        }

        public static Token a(Object obj) {
            return b(obj, (b) null);
        }

        public static Token b(Object obj, b bVar) {
            if (obj != null) {
                return new Token(d.a(obj), bVar);
            }
            return null;
        }

        public b c() {
            return this.f13742b;
        }

        public Object d() {
            return this.f13741a;
        }

        public int describeContents() {
            return 0;
        }

        public void e(b bVar) {
            this.f13742b = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f13741a;
            if (obj2 != null) {
                Object obj3 = token.f13741a;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (token.f13741a == null) {
                return true;
            } else {
                return false;
            }
        }

        public void f(Bundle bundle) {
            this.f13743c = bundle;
        }

        public int hashCode() {
            Object obj = this.f13741a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable((Parcelable) this.f13741a, i10);
        }

        Token(Object obj, b bVar) {
            this(obj, bVar, (Bundle) null);
        }

        Token(Object obj, b bVar, Bundle bundle) {
            this.f13741a = obj;
            this.f13742b = bVar;
            this.f13743c = bundle;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }
}
