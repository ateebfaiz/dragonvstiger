package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.d0;

public final class v {

    /* renamed from: c  reason: collision with root package name */
    private static final String f20960c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f20961d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f20962a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f20963b;

    public static final class a {
        private a() {
        }

        private final Date b(Bundle bundle, String str) {
            if (bundle == null) {
                return null;
            }
            long j10 = bundle.getLong(str, Long.MIN_VALUE);
            if (j10 == Long.MIN_VALUE) {
                return null;
            }
            return new Date(j10);
        }

        public final String a(Bundle bundle) {
            m.f(bundle, "bundle");
            return bundle.getString("com.facebook.TokenCachingStrategy.ApplicationId");
        }

        public final Date c(Bundle bundle) {
            m.f(bundle, "bundle");
            return b(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
        }

        public final Date d(Bundle bundle) {
            m.f(bundle, "bundle");
            return b(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate");
        }

        public final d e(Bundle bundle) {
            m.f(bundle, "bundle");
            if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
                return (d) bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
            }
            if (bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO")) {
                return d.FACEBOOK_APPLICATION_WEB;
            }
            return d.WEB_VIEW;
        }

        public final String f(Bundle bundle) {
            m.f(bundle, "bundle");
            return bundle.getString("com.facebook.TokenCachingStrategy.Token");
        }

        public final boolean g(Bundle bundle) {
            String string;
            if (bundle == null || (string = bundle.getString("com.facebook.TokenCachingStrategy.Token")) == null || string.length() == 0 || bundle.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0) == 0) {
                return false;
            }
            return true;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = v.class.getSimpleName();
        m.e(simpleName, "LegacyTokenHelper::class.java.simpleName");
        f20960c = simpleName;
    }

    public v(Context context, String str) {
        m.f(context, "context");
        str = (str == null || str.length() == 0) ? "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY" : str;
        this.f20962a = str;
        Context applicationContext = context.getApplicationContext();
        SharedPreferences sharedPreferences = (applicationContext != null ? applicationContext : context).getSharedPreferences(str, 0);
        m.e(sharedPreferences, "context.getSharedPrefere…ey, Context.MODE_PRIVATE)");
        this.f20963b = sharedPreferences;
    }

    private final void b(String str, Bundle bundle) {
        String str2;
        String string = this.f20963b.getString(str, "{}");
        if (string != null) {
            JSONObject jSONObject = new JSONObject(string);
            String string2 = jSONObject.getString("valueType");
            if (m.b(string2, "bool")) {
                bundle.putBoolean(str, jSONObject.getBoolean("value"));
                return;
            }
            int i10 = 0;
            if (m.b(string2, "bool[]")) {
                JSONArray jSONArray = jSONObject.getJSONArray("value");
                int length = jSONArray.length();
                boolean[] zArr = new boolean[length];
                while (i10 < length) {
                    zArr[i10] = jSONArray.getBoolean(i10);
                    i10++;
                }
                bundle.putBooleanArray(str, zArr);
            } else if (m.b(string2, "byte")) {
                bundle.putByte(str, (byte) jSONObject.getInt("value"));
            } else if (m.b(string2, "byte[]")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("value");
                int length2 = jSONArray2.length();
                byte[] bArr = new byte[length2];
                while (i10 < length2) {
                    bArr[i10] = (byte) jSONArray2.getInt(i10);
                    i10++;
                }
                bundle.putByteArray(str, bArr);
            } else if (m.b(string2, "short")) {
                bundle.putShort(str, (short) jSONObject.getInt("value"));
            } else if (m.b(string2, "short[]")) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("value");
                int length3 = jSONArray3.length();
                short[] sArr = new short[length3];
                while (i10 < length3) {
                    sArr[i10] = (short) jSONArray3.getInt(i10);
                    i10++;
                }
                bundle.putShortArray(str, sArr);
            } else if (m.b(string2, "int")) {
                bundle.putInt(str, jSONObject.getInt("value"));
            } else if (m.b(string2, "int[]")) {
                JSONArray jSONArray4 = jSONObject.getJSONArray("value");
                int length4 = jSONArray4.length();
                int[] iArr = new int[length4];
                while (i10 < length4) {
                    iArr[i10] = jSONArray4.getInt(i10);
                    i10++;
                }
                bundle.putIntArray(str, iArr);
            } else if (m.b(string2, Constants.LONG)) {
                bundle.putLong(str, jSONObject.getLong("value"));
            } else if (m.b(string2, "long[]")) {
                JSONArray jSONArray5 = jSONObject.getJSONArray("value");
                int length5 = jSONArray5.length();
                long[] jArr = new long[length5];
                while (i10 < length5) {
                    jArr[i10] = jSONArray5.getLong(i10);
                    i10++;
                }
                bundle.putLongArray(str, jArr);
            } else if (m.b(string2, "float")) {
                bundle.putFloat(str, (float) jSONObject.getDouble("value"));
            } else if (m.b(string2, "float[]")) {
                JSONArray jSONArray6 = jSONObject.getJSONArray("value");
                int length6 = jSONArray6.length();
                float[] fArr = new float[length6];
                while (i10 < length6) {
                    fArr[i10] = (float) jSONArray6.getDouble(i10);
                    i10++;
                }
                bundle.putFloatArray(str, fArr);
            } else if (m.b(string2, "double")) {
                bundle.putDouble(str, jSONObject.getDouble("value"));
            } else if (m.b(string2, "double[]")) {
                JSONArray jSONArray7 = jSONObject.getJSONArray("value");
                int length7 = jSONArray7.length();
                double[] dArr = new double[length7];
                while (i10 < length7) {
                    dArr[i10] = jSONArray7.getDouble(i10);
                    i10++;
                }
                bundle.putDoubleArray(str, dArr);
            } else if (m.b(string2, "char")) {
                String string3 = jSONObject.getString("value");
                if (string3 != null && string3.length() == 1) {
                    bundle.putChar(str, string3.charAt(0));
                }
            } else if (m.b(string2, "char[]")) {
                JSONArray jSONArray8 = jSONObject.getJSONArray("value");
                int length8 = jSONArray8.length();
                char[] cArr = new char[length8];
                for (int i11 = 0; i11 < length8; i11++) {
                    String string4 = jSONArray8.getString(i11);
                    if (string4 != null && string4.length() == 1) {
                        cArr[i11] = string4.charAt(0);
                    }
                }
                bundle.putCharArray(str, cArr);
            } else if (m.b(string2, "string")) {
                bundle.putString(str, jSONObject.getString("value"));
            } else if (m.b(string2, "stringList")) {
                JSONArray jSONArray9 = jSONObject.getJSONArray("value");
                int length9 = jSONArray9.length();
                ArrayList arrayList = new ArrayList(length9);
                while (i10 < length9) {
                    Object obj = jSONArray9.get(i10);
                    if (obj == JSONObject.NULL) {
                        str2 = null;
                    } else if (obj != null) {
                        str2 = (String) obj;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    arrayList.add(i10, str2);
                    i10++;
                }
                bundle.putStringArrayList(str, arrayList);
            } else if (m.b(string2, "enum")) {
                try {
                    bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString("enumType")), jSONObject.getString("value")));
                } catch (ClassNotFoundException | IllegalArgumentException unused) {
                }
            }
        } else {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    public final void a() {
        this.f20963b.edit().clear().apply();
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        for (String next : this.f20963b.getAll().keySet()) {
            try {
                m.e(next, "key");
                b(next, bundle);
            } catch (JSONException e10) {
                d0.a aVar = d0.f23283f;
                w wVar = w.CACHE;
                String str = f20960c;
                aVar.a(wVar, 5, str, "Error reading cached value for key: '" + next + "' -- " + e10);
                return null;
            }
        }
        return bundle;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(Context context, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : str);
    }
}
