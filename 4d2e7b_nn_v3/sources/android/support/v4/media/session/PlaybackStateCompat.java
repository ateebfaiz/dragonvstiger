package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f13749a;

    /* renamed from: b  reason: collision with root package name */
    final long f13750b;

    /* renamed from: c  reason: collision with root package name */
    final long f13751c;

    /* renamed from: d  reason: collision with root package name */
    final float f13752d;

    /* renamed from: e  reason: collision with root package name */
    final long f13753e;

    /* renamed from: f  reason: collision with root package name */
    final int f13754f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f13755g;

    /* renamed from: h  reason: collision with root package name */
    final long f13756h;

    /* renamed from: i  reason: collision with root package name */
    List f13757i;

    /* renamed from: j  reason: collision with root package name */
    final long f13758j;

    /* renamed from: w  reason: collision with root package name */
    final Bundle f13759w;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f13760a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f13761b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13762c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f13763d;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i10) {
                return new CustomAction[i10];
            }
        }

        CustomAction(Parcel parcel) {
            this.f13760a = parcel.readString();
            this.f13761b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f13762c = parcel.readInt();
            this.f13763d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f13761b + ", mIcon=" + this.f13762c + ", mExtras=" + this.f13763d;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f13760a);
            TextUtils.writeToParcel(this.f13761b, parcel, i10);
            parcel.writeInt(this.f13762c);
            parcel.writeBundle(this.f13763d);
        }
    }

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i10) {
            return new PlaybackStateCompat[i10];
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f13749a = parcel.readInt();
        this.f13750b = parcel.readLong();
        this.f13752d = parcel.readFloat();
        this.f13756h = parcel.readLong();
        this.f13751c = parcel.readLong();
        this.f13753e = parcel.readLong();
        this.f13755g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f13757i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f13758j = parcel.readLong();
        this.f13759w = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f13754f = parcel.readInt();
    }

    public static int a(long j10) {
        if (j10 == 4) {
            return WebSocketProtocol.PAYLOAD_SHORT;
        }
        if (j10 == 2) {
            return 127;
        }
        if (j10 == 32) {
            return 87;
        }
        if (j10 == 16) {
            return 88;
        }
        if (j10 == 1) {
            return 86;
        }
        if (j10 == 64) {
            return 90;
        }
        if (j10 == 8) {
            return 89;
        }
        return j10 == 512 ? 85 : 0;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f13749a + ", position=" + this.f13750b + ", buffered position=" + this.f13751c + ", speed=" + this.f13752d + ", updated=" + this.f13756h + ", actions=" + this.f13753e + ", error code=" + this.f13754f + ", error message=" + this.f13755g + ", custom actions=" + this.f13757i + ", active item id=" + this.f13758j + "}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f13749a);
        parcel.writeLong(this.f13750b);
        parcel.writeFloat(this.f13752d);
        parcel.writeLong(this.f13756h);
        parcel.writeLong(this.f13751c);
        parcel.writeLong(this.f13753e);
        TextUtils.writeToParcel(this.f13755g, parcel, i10);
        parcel.writeTypedList(this.f13757i);
        parcel.writeLong(this.f13758j);
        parcel.writeBundle(this.f13759w);
        parcel.writeInt(this.f13754f);
    }
}
