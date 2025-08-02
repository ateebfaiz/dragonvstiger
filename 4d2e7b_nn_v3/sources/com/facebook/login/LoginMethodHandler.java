package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.alibaba.pdns.f;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.d;
import com.facebook.l;
import com.facebook.login.LoginClient;
import com.zing.zalo.zalosdk.common.Constant;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONException;
import org.json.JSONObject;
import q5.p0;

@VisibleForTesting(otherwise = 3)
public abstract class LoginMethodHandler implements Parcelable {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20460c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Map f20461a;

    /* renamed from: b  reason: collision with root package name */
    public LoginClient f20462b;

    public static final class a {
        private a() {
        }

        public final AccessToken a(Bundle bundle, d dVar, String str) {
            String string;
            Bundle bundle2 = bundle;
            m.f(bundle, "bundle");
            m.f(str, "applicationId");
            Date w10 = p0.w(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0));
            ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            String string2 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
            Date w11 = p0.w(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0));
            if (string2 == null || string2.length() == 0 || (string = bundle.getString("com.facebook.platform.extra.USER_ID")) == null || string.length() == 0) {
                return null;
            }
            return new AccessToken(string2, str, string, stringArrayList, (Collection) null, (Collection) null, dVar, w10, new Date(), w11, bundle.getString("graph_domain"));
        }

        public final AccessToken b(Collection collection, Bundle bundle, d dVar, String str) {
            Collection collection2;
            ArrayList arrayList;
            ArrayList arrayList2;
            Bundle bundle2 = bundle;
            m.f(bundle2, "bundle");
            m.f(str, "applicationId");
            Date w10 = p0.w(bundle2, "expires_in", new Date());
            String string = bundle2.getString("access_token");
            if (string != null) {
                m.e(string, "bundle.getString(AccessT…TOKEN_KEY) ?: return null");
                Date w11 = p0.w(bundle2, "data_access_expiration_time", new Date(0));
                String string2 = bundle2.getString("granted_scopes");
                if (string2 == null || string2.length() <= 0) {
                    collection2 = collection;
                } else {
                    Object[] array = j.v0(string2, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array != null) {
                        String[] strArr = (String[]) array;
                        collection2 = r.g((String[]) Arrays.copyOf(strArr, strArr.length));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                String string3 = bundle2.getString("denied_scopes");
                if (string3 == null || string3.length() <= 0) {
                    arrayList = null;
                } else {
                    Object[] array2 = j.v0(string3, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr2 = (String[]) array2;
                        arrayList = r.g((String[]) Arrays.copyOf(strArr2, strArr2.length));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                String string4 = bundle2.getString("expired_scopes");
                if (string4 == null || string4.length() <= 0) {
                    arrayList2 = null;
                } else {
                    Object[] array3 = j.v0(string4, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array3 != null) {
                        String[] strArr3 = (String[]) array3;
                        arrayList2 = r.g((String[]) Arrays.copyOf(strArr3, strArr3.length));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                if (p0.Y(string)) {
                    return null;
                }
                return new AccessToken(string, str, e(bundle2.getString("signed_request")), collection2, arrayList, arrayList2, dVar, w10, new Date(), w11, bundle2.getString("graph_domain"));
            }
            return null;
        }

        public final AuthenticationToken c(Bundle bundle, String str) {
            m.f(bundle, "bundle");
            String string = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
            if (string == null || string.length() == 0 || str == null || str.length() == 0) {
                return null;
            }
            try {
                return new AuthenticationToken(string, str);
            } catch (Exception e10) {
                throw new l(e10.getMessage());
            }
        }

        public final AuthenticationToken d(Bundle bundle, String str) {
            m.f(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string == null || string.length() == 0 || str == null || str.length() == 0) {
                return null;
            }
            try {
                return new AuthenticationToken(string, str);
            } catch (Exception e10) {
                throw new l(e10.getMessage(), (Throwable) e10);
            }
        }

        public final String e(String str) {
            if (str == null || str.length() == 0) {
                throw new l("Authorization response does not contain the signed_request");
            }
            try {
                Object[] array = j.v0(str, new String[]{f.G}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    if (strArr.length == 2) {
                        byte[] decode = Base64.decode(strArr[1], 0);
                        m.e(decode, "data");
                        String string = new JSONObject(new String(decode, kotlin.text.d.f797b)).getString("user_id");
                        m.e(string, "jsonObject.getString(\"user_id\")");
                        return string;
                    }
                    throw new l("Failed to retrieve user_id from signed_request");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (UnsupportedEncodingException | JSONException unused) {
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LoginMethodHandler(LoginClient loginClient) {
        m.f(loginClient, "loginClient");
        this.f20462b = loginClient;
    }

    public static final AccessToken c(Collection collection, Bundle bundle, d dVar, String str) {
        return f20460c.b(collection, bundle, dVar, str);
    }

    public static final AuthenticationToken d(Bundle bundle, String str) {
        return f20460c.d(bundle, str);
    }

    /* access modifiers changed from: protected */
    public void a(String str, Object obj) {
        String str2;
        if (this.f20461a == null) {
            this.f20461a = new HashMap();
        }
        Map map = this.f20461a;
        if (map != null) {
            if (obj != null) {
                str2 = obj.toString();
            } else {
                str2 = null;
            }
            String str3 = (String) map.put(str, str2);
        }
    }

    public void b() {
    }

    /* access modifiers changed from: protected */
    public String e(String str) {
        m.f(str, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", h());
            l(jSONObject);
        } catch (JSONException e10) {
            Log.w("LoginMethodHandler", "Error creating client state json: " + e10.getMessage());
        }
        String jSONObject2 = jSONObject.toString();
        m.e(jSONObject2, "param.toString()");
        return jSONObject2;
    }

    public final LoginClient f() {
        LoginClient loginClient = this.f20462b;
        if (loginClient == null) {
            m.u("loginClient");
        }
        return loginClient;
    }

    public final Map g() {
        return this.f20461a;
    }

    public abstract String h();

    /* access modifiers changed from: protected */
    public void i(String str) {
        LoginClient loginClient = this.f20462b;
        if (loginClient == null) {
            m.u("loginClient");
        }
        LoginClient.Request q10 = loginClient.q();
        m.e(q10, "loginClient.getPendingRequest()");
        String a10 = q10.a();
        LoginClient loginClient2 = this.f20462b;
        if (loginClient2 == null) {
            m.u("loginClient");
        }
        e2.m mVar = new e2.m(loginClient2.i(), a10);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString(Constant.PARAM_APP_ID, a10);
        mVar.h("fb_dialogs_web_login_dialog_complete", (Double) null, bundle);
    }

    public boolean j() {
        return false;
    }

    public boolean k(int i10, int i11, Intent intent) {
        return false;
    }

    public void l(JSONObject jSONObject) {
        m.f(jSONObject, "param");
    }

    public final void m(LoginClient loginClient) {
        m.f(loginClient, "<set-?>");
        this.f20462b = loginClient;
    }

    public boolean n() {
        return false;
    }

    public abstract int o(LoginClient.Request request);

    public void writeToParcel(Parcel parcel, int i10) {
        m.f(parcel, "dest");
        p0.F0(parcel, this.f20461a);
    }

    protected LoginMethodHandler(Parcel parcel) {
        m.f(parcel, "source");
        Map q02 = p0.q0(parcel);
        this.f20461a = q02 != null ? i0.r(q02) : null;
    }
}
