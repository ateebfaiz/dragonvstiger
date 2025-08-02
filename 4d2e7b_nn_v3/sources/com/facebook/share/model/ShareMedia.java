package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public abstract class ShareMedia implements ShareModel {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f4624a;

    public static abstract class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Bundle f4625a = new Bundle();

        static List c(Parcel parcel) {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
            ArrayList arrayList = new ArrayList(readParcelableArray.length);
            for (Parcelable parcelable : readParcelableArray) {
                arrayList.add((ShareMedia) parcelable);
            }
            return arrayList;
        }

        public a b(ShareMedia shareMedia) {
            if (shareMedia == null) {
                return this;
            }
            return d(shareMedia.b());
        }

        public a d(Bundle bundle) {
            this.f4625a.putAll(bundle);
            return this;
        }
    }

    public enum b {
        PHOTO,
        VIDEO
    }

    protected ShareMedia(a aVar) {
        this.f4624a = new Bundle(aVar.f4625a);
    }

    public abstract b a();

    public Bundle b() {
        return new Bundle(this.f4624a);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f4624a);
    }

    ShareMedia(Parcel parcel) {
        this.f4624a = parcel.readBundle();
    }
}
