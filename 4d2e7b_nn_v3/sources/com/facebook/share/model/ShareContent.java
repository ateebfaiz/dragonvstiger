package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.a;
import com.facebook.share.model.ShareHashtag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.m;

public abstract class ShareContent<P extends ShareContent<P, E>, E extends a> implements ShareModel {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f4602a;

    /* renamed from: b  reason: collision with root package name */
    private final List f4603b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4604c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4605d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4606e;

    /* renamed from: f  reason: collision with root package name */
    private final ShareHashtag f4607f;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private Uri f4608a;

        /* renamed from: b  reason: collision with root package name */
        private List f4609b;

        /* renamed from: c  reason: collision with root package name */
        private String f4610c;

        /* renamed from: d  reason: collision with root package name */
        private String f4611d;

        /* renamed from: e  reason: collision with root package name */
        private String f4612e;

        /* renamed from: f  reason: collision with root package name */
        private ShareHashtag f4613f;

        public final Uri a() {
            return this.f4608a;
        }

        public final ShareHashtag b() {
            return this.f4613f;
        }

        public final String c() {
            return this.f4611d;
        }

        public final List d() {
            return this.f4609b;
        }

        public final String e() {
            return this.f4610c;
        }

        public final String f() {
            return this.f4612e;
        }

        public a g(ShareContent shareContent) {
            if (shareContent == null) {
                return this;
            }
            return h(shareContent.a()).j(shareContent.c()).k(shareContent.d()).i(shareContent.b()).l(shareContent.e()).m(shareContent.f());
        }

        public final a h(Uri uri) {
            this.f4608a = uri;
            return this;
        }

        public final a i(String str) {
            this.f4611d = str;
            return this;
        }

        public final a j(List list) {
            List list2;
            if (list == null) {
                list2 = null;
            } else {
                list2 = Collections.unmodifiableList(list);
            }
            this.f4609b = list2;
            return this;
        }

        public final a k(String str) {
            this.f4610c = str;
            return this;
        }

        public final a l(String str) {
            this.f4612e = str;
            return this;
        }

        public final a m(ShareHashtag shareHashtag) {
            this.f4613f = shareHashtag;
            return this;
        }
    }

    protected ShareContent(a aVar) {
        m.f(aVar, "builder");
        this.f4602a = aVar.a();
        this.f4603b = aVar.d();
        this.f4604c = aVar.e();
        this.f4605d = aVar.c();
        this.f4606e = aVar.f();
        this.f4607f = aVar.b();
    }

    private final List g(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Uri a() {
        return this.f4602a;
    }

    public final String b() {
        return this.f4605d;
    }

    public final List c() {
        return this.f4603b;
    }

    public final String d() {
        return this.f4604c;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f4606e;
    }

    public final ShareHashtag f() {
        return this.f4607f;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "out");
        parcel.writeParcelable(this.f4602a, 0);
        parcel.writeStringList(this.f4603b);
        parcel.writeString(this.f4604c);
        parcel.writeString(this.f4605d);
        parcel.writeString(this.f4606e);
        parcel.writeParcelable(this.f4607f, 0);
    }

    protected ShareContent(Parcel parcel) {
        m.f(parcel, "parcel");
        this.f4602a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f4603b = g(parcel);
        this.f4604c = parcel.readString();
        this.f4605d = parcel.readString();
        this.f4606e = parcel.readString();
        this.f4607f = new ShareHashtag.b().c(parcel).b();
    }
}
