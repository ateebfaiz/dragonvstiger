package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.ShareOpenGraphValueContainer.a;
import java.util.Set;

public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends a> implements ShareModel {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f4663a;

    public static abstract class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Bundle f4664a = new Bundle();

        public a b(String str, String str2) {
            this.f4664a.putString(str, str2);
            return this;
        }

        public a c(ShareOpenGraphValueContainer shareOpenGraphValueContainer) {
            if (shareOpenGraphValueContainer != null) {
                this.f4664a.putAll(shareOpenGraphValueContainer.b());
            }
            return this;
        }
    }

    protected ShareOpenGraphValueContainer(a aVar) {
        this.f4663a = (Bundle) aVar.f4664a.clone();
    }

    public Object a(String str) {
        return this.f4663a.get(str);
    }

    public Bundle b() {
        return (Bundle) this.f4663a.clone();
    }

    public String c(String str) {
        return this.f4663a.getString(str);
    }

    public Set d() {
        return this.f4663a.keySet();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f4663a);
    }

    ShareOpenGraphValueContainer(Parcel parcel) {
        this.f4663a = parcel.readBundle(a.class.getClassLoader());
    }
}
