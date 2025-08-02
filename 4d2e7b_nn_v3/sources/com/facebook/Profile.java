package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.AccessToken;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;
import q5.q0;
import q5.w;

public final class Profile implements Parcelable {
    public static final Parcelable.Creator<Profile> CREATOR = new a();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String f19570h;

    /* renamed from: i  reason: collision with root package name */
    public static final b f19571i = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f19572a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19573b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19574c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19575d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19576e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f19577f;

    /* renamed from: g  reason: collision with root package name */
    private final Uri f19578g;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public Profile createFromParcel(Parcel parcel) {
            m.f(parcel, "source");
            return new Profile(parcel, (DefaultConstructorMarker) null);
        }

        /* renamed from: b */
        public Profile[] newArray(int i10) {
            return new Profile[i10];
        }
    }

    public static final class b {

        public static final class a implements p0.a {
            a() {
            }

            public void a(JSONObject jSONObject) {
                String str;
                Uri uri;
                Uri uri2 = null;
                if (jSONObject != null) {
                    str = jSONObject.optString("id");
                } else {
                    str = null;
                }
                if (str == null) {
                    Log.w(Profile.f19570h, "No user ID returned on Me request");
                    return;
                }
                String optString = jSONObject.optString("link");
                String optString2 = jSONObject.optString("profile_picture", (String) null);
                String optString3 = jSONObject.optString("first_name");
                String optString4 = jSONObject.optString("middle_name");
                String optString5 = jSONObject.optString("last_name");
                String optString6 = jSONObject.optString("name");
                if (optString != null) {
                    uri = Uri.parse(optString);
                } else {
                    uri = null;
                }
                if (optString2 != null) {
                    uri2 = Uri.parse(optString2);
                }
                Profile.f19571i.c(new Profile(str, optString3, optString4, optString5, optString6, uri, uri2));
            }

            public void b(l lVar) {
                String a10 = Profile.f19570h;
                Log.e(a10, "Got unexpected exception: " + lVar);
            }
        }

        private b() {
        }

        public final void a() {
            AccessToken.c cVar = AccessToken.N0;
            AccessToken e10 = cVar.e();
            if (e10 == null) {
                return;
            }
            if (!cVar.g()) {
                c((Profile) null);
            } else {
                p0.D(e10.m(), new a());
            }
        }

        public final Profile b() {
            return y.f20976e.a().c();
        }

        public final void c(Profile profile) {
            y.f20976e.a().f(profile);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = Profile.class.getSimpleName();
        m.e(simpleName, "Profile::class.java.simpleName");
        f19570h = simpleName;
    }

    public /* synthetic */ Profile(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public static final void b() {
        f19571i.a();
    }

    public static final Profile c() {
        return f19571i.b();
    }

    public static final void g(Profile profile) {
        f19571i.c(profile);
    }

    public final String d() {
        return this.f19572a;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f19576e;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Uri uri;
        Uri uri2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        String str5 = this.f19572a;
        if (((str5 != null || ((Profile) obj).f19572a != null) && !m.b(str5, ((Profile) obj).f19572a)) || ((((str = this.f19573b) != null || ((Profile) obj).f19573b != null) && !m.b(str, ((Profile) obj).f19573b)) || ((((str2 = this.f19574c) != null || ((Profile) obj).f19574c != null) && !m.b(str2, ((Profile) obj).f19574c)) || ((((str3 = this.f19575d) != null || ((Profile) obj).f19575d != null) && !m.b(str3, ((Profile) obj).f19575d)) || ((((str4 = this.f19576e) != null || ((Profile) obj).f19576e != null) && !m.b(str4, ((Profile) obj).f19576e)) || ((((uri = this.f19577f) != null || ((Profile) obj).f19577f != null) && !m.b(uri, ((Profile) obj).f19577f)) || (((uri2 = this.f19578g) != null || ((Profile) obj).f19578g != null) && !m.b(uri2, ((Profile) obj).f19578g)))))))) {
            return false;
        }
        return true;
    }

    public final Uri f(int i10, int i11) {
        String str;
        Uri uri = this.f19578g;
        if (uri != null) {
            return uri;
        }
        AccessToken.c cVar = AccessToken.N0;
        if (cVar.g()) {
            AccessToken e10 = cVar.e();
            if (e10 != null) {
                str = e10.m();
            } else {
                str = null;
            }
        } else {
            str = "";
        }
        return w.f23532f.a(this.f19572a, i10, i11, str);
    }

    public final JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f19572a);
            jSONObject.put("first_name", this.f19573b);
            jSONObject.put("middle_name", this.f19574c);
            jSONObject.put("last_name", this.f19575d);
            jSONObject.put("name", this.f19576e);
            Uri uri = this.f19577f;
            if (uri != null) {
                jSONObject.put("link_uri", uri.toString());
            }
            Uri uri2 = this.f19578g;
            if (uri2 != null) {
                jSONObject.put("picture_uri", uri2.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public int hashCode() {
        int i10;
        String str = this.f19572a;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i11 = 527 + i10;
        String str2 = this.f19573b;
        if (str2 != null) {
            i11 = (i11 * 31) + str2.hashCode();
        }
        String str3 = this.f19574c;
        if (str3 != null) {
            i11 = (i11 * 31) + str3.hashCode();
        }
        String str4 = this.f19575d;
        if (str4 != null) {
            i11 = (i11 * 31) + str4.hashCode();
        }
        String str5 = this.f19576e;
        if (str5 != null) {
            i11 = (i11 * 31) + str5.hashCode();
        }
        Uri uri = this.f19577f;
        if (uri != null) {
            i11 = (i11 * 31) + uri.hashCode();
        }
        Uri uri2 = this.f19578g;
        if (uri2 != null) {
            return (i11 * 31) + uri2.hashCode();
        }
        return i11;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        String str;
        m.f(parcel, "dest");
        parcel.writeString(this.f19572a);
        parcel.writeString(this.f19573b);
        parcel.writeString(this.f19574c);
        parcel.writeString(this.f19575d);
        parcel.writeString(this.f19576e);
        Uri uri = this.f19577f;
        String str2 = null;
        if (uri != null) {
            str = uri.toString();
        } else {
            str = null;
        }
        parcel.writeString(str);
        Uri uri2 = this.f19578g;
        if (uri2 != null) {
            str2 = uri2.toString();
        }
        parcel.writeString(str2);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2) {
        q0.n(str, "id");
        this.f19572a = str;
        this.f19573b = str2;
        this.f19574c = str3;
        this.f19575d = str4;
        this.f19576e = str5;
        this.f19577f = uri;
        this.f19578g = uri2;
    }

    public Profile(JSONObject jSONObject) {
        Uri uri;
        m.f(jSONObject, "jsonObject");
        Uri uri2 = null;
        this.f19572a = jSONObject.optString("id", (String) null);
        this.f19573b = jSONObject.optString("first_name", (String) null);
        this.f19574c = jSONObject.optString("middle_name", (String) null);
        this.f19575d = jSONObject.optString("last_name", (String) null);
        this.f19576e = jSONObject.optString("name", (String) null);
        String optString = jSONObject.optString("link_uri", (String) null);
        if (optString == null) {
            uri = null;
        } else {
            uri = Uri.parse(optString);
        }
        this.f19577f = uri;
        String optString2 = jSONObject.optString("picture_uri", (String) null);
        this.f19578g = optString2 != null ? Uri.parse(optString2) : uri2;
    }

    private Profile(Parcel parcel) {
        Uri uri;
        this.f19572a = parcel.readString();
        this.f19573b = parcel.readString();
        this.f19574c = parcel.readString();
        this.f19575d = parcel.readString();
        this.f19576e = parcel.readString();
        String readString = parcel.readString();
        Uri uri2 = null;
        if (readString == null) {
            uri = null;
        } else {
            uri = Uri.parse(readString);
        }
        this.f19577f = uri;
        String readString2 = parcel.readString();
        this.f19578g = readString2 != null ? Uri.parse(readString2) : uri2;
    }
}
