package n9;

import android.os.Parcel;
import java.util.Date;

public abstract class c {
    public static Date a(Parcel parcel) {
        long readLong = parcel.readLong();
        if (readLong != -1) {
            return new Date(readLong);
        }
        return null;
    }

    public static Enum b(Parcel parcel, Class cls) {
        String readString = parcel.readString();
        if (readString != null) {
            return Enum.valueOf(cls, readString);
        }
        return null;
    }

    public static void c(Parcel parcel, Date date) {
        long j10;
        if (date != null) {
            j10 = date.getTime();
        } else {
            j10 = -1;
        }
        parcel.writeLong(j10);
    }

    public static void d(Parcel parcel, Enum enumR) {
        String str;
        if (enumR != null) {
            str = enumR.name();
        } else {
            str = null;
        }
        parcel.writeString(str);
    }
}
