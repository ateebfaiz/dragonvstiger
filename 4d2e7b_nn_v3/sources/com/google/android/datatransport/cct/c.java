package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.adjust.sdk.Constants;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

final class c implements TransportBackend {

    /* renamed from: a  reason: collision with root package name */
    private final DataEncoder f6291a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f6292b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f6293c;

    /* renamed from: d  reason: collision with root package name */
    final URL f6294d;

    /* renamed from: e  reason: collision with root package name */
    private final Clock f6295e;

    /* renamed from: f  reason: collision with root package name */
    private final Clock f6296f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6297g;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final URL f6298a;

        /* renamed from: b  reason: collision with root package name */
        final BatchedLogRequest f6299b;

        /* renamed from: c  reason: collision with root package name */
        final String f6300c;

        a(URL url, BatchedLogRequest batchedLogRequest, String str) {
            this.f6298a = url;
            this.f6299b = batchedLogRequest;
            this.f6300c = str;
        }

        /* access modifiers changed from: package-private */
        public a a(URL url) {
            return new a(url, this.f6299b, this.f6300c);
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f6301a;

        /* renamed from: b  reason: collision with root package name */
        final URL f6302b;

        /* renamed from: c  reason: collision with root package name */
        final long f6303c;

        b(int i10, URL url, long j10) {
            this.f6301a = i10;
            this.f6302b = url;
            this.f6303c = j10;
        }
    }

    c(Context context, Clock clock, Clock clock2, int i10) {
        this.f6291a = BatchedLogRequest.createDataEncoder();
        this.f6293c = context;
        this.f6292b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f6294d = l(CCTDestination.DEFAULT_END_POINT);
        this.f6295e = clock2;
        this.f6296f = clock;
        this.f6297g = i10;
    }

    /* access modifiers changed from: private */
    public b c(a aVar) {
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        InputStream k10;
        Logging.i("CctTransportBackend", "Making request to: %s", aVar.f6298a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f6298a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f6297g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", new Object[]{"3.1.8"}));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f6300c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            outputStream = httpURLConnection.getOutputStream();
            gZIPOutputStream = new GZIPOutputStream(outputStream);
            this.f6291a.encode(aVar.f6299b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
            gZIPOutputStream.close();
            if (outputStream != null) {
                outputStream.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            Logging.i("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
            Logging.d("CctTransportBackend", "Content-Type: %s", (Object) httpURLConnection.getHeaderField("Content-Type"));
            Logging.d("CctTransportBackend", "Content-Encoding: %s", (Object) httpURLConnection.getHeaderField("Content-Encoding"));
            if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0);
            }
            if (responseCode != 200) {
                return new b(responseCode, (URL) null, 0);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                k10 = k(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                b bVar = new b(responseCode, (URL) null, LogResponse.fromJson(new BufferedReader(new InputStreamReader(k10))).getNextRequestWaitMillis());
                if (k10 != null) {
                    k10.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return bVar;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
            throw th;
            throw th;
            throw th;
        } catch (ConnectException | UnknownHostException e10) {
            Logging.e("CctTransportBackend", "Couldn't open connection, returning with 500", e10);
            return new b(500, (URL) null, 0);
        } catch (EncodingException | IOException e11) {
            Logging.e("CctTransportBackend", "Couldn't encode request, returning with 400", e11);
            return new b(Constants.MINIMAL_ERROR_STATUS_CODE, (URL) null, 0);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private static int d(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    private static int e(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.getValue();
        }
        return networkInfo.getType();
    }

    private static int f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            Logging.e("CctTransportBackend", "Unable to find version code for package", e10);
            return -1;
        }
    }

    private BatchedLogRequest g(BackendRequest backendRequest) {
        LogEvent.Builder builder;
        HashMap hashMap = new HashMap();
        for (EventInternal next : backendRequest.getEvents()) {
            String transportName = next.getTransportName();
            if (!hashMap.containsKey(transportName)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(transportName, arrayList);
            } else {
                ((List) hashMap.get(transportName)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder clientInfo = LogRequest.builder().setQosTier(QosTier.DEFAULT).setRequestTimeMs(this.f6296f.getTime()).setRequestUptimeMs(this.f6295e.getTime()).setClientInfo(ClientInfo.builder().setClientType(ClientInfo.ClientType.ANDROID_FIREBASE).setAndroidClientInfo(AndroidClientInfo.builder().setSdkVersion(Integer.valueOf(eventInternal.getInteger("sdk-version"))).setModel(eventInternal.get("model")).setHardware(eventInternal.get("hardware")).setDevice(eventInternal.get("device")).setProduct(eventInternal.get("product")).setOsBuild(eventInternal.get("os-uild")).setManufacturer(eventInternal.get("manufacturer")).setFingerprint(eventInternal.get("fingerprint")).setCountry(eventInternal.get("country")).setLocale(eventInternal.get("locale")).setMccMnc(eventInternal.get("mcc_mnc")).setApplicationBuild(eventInternal.get("application_build")).build()).build());
            try {
                clientInfo.setSource(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                clientInfo.setSource((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal2 : (List) entry.getValue()) {
                EncodedPayload encodedPayload = eventInternal2.getEncodedPayload();
                Encoding encoding = encodedPayload.getEncoding();
                if (encoding.equals(Encoding.of("proto"))) {
                    builder = LogEvent.protoBuilder(encodedPayload.getBytes());
                } else if (encoding.equals(Encoding.of("json"))) {
                    builder = LogEvent.jsonBuilder(new String(encodedPayload.getBytes(), Charset.forName("UTF-8")));
                } else {
                    Logging.w("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", encoding);
                }
                builder.setEventTimeMs(eventInternal2.getEventMillis()).setEventUptimeMs(eventInternal2.getUptimeMillis()).setTimezoneOffsetSeconds(eventInternal2.getLong("tz-offset")).setNetworkConnectionInfo(NetworkConnectionInfo.builder().setNetworkType(NetworkConnectionInfo.NetworkType.forNumber(eventInternal2.getInteger("net-type"))).setMobileSubtype(NetworkConnectionInfo.MobileSubtype.forNumber(eventInternal2.getInteger("mobile-subtype"))).build());
                if (eventInternal2.getCode() != null) {
                    builder.setEventCode(eventInternal2.getCode());
                }
                arrayList3.add(builder.build());
            }
            clientInfo.setLogEvents(arrayList3);
            arrayList2.add(clientInfo.build());
        }
        return BatchedLogRequest.create(arrayList2);
    }

    private static TelephonyManager h(Context context) {
        return (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
    }

    static long i() {
        Calendar.getInstance();
        return (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ a j(a aVar, b bVar) {
        URL url = bVar.f6302b;
        if (url == null) {
            return null;
        }
        Logging.d("CctTransportBackend", "Following redirect to: %s", (Object) url);
        return aVar.a(bVar.f6302b);
    }

    private static InputStream k(InputStream inputStream, String str) {
        if ("gzip".equals(str)) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    private static URL l(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException("Invalid url: " + str, e10);
        }
    }

    public EventInternal decorate(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.f6292b.getActiveNetworkInfo();
        return eventInternal.toBuilder().addMetadata("sdk-version", Build.VERSION.SDK_INT).addMetadata("model", Build.MODEL).addMetadata("hardware", Build.HARDWARE).addMetadata("device", Build.DEVICE).addMetadata("product", Build.PRODUCT).addMetadata("os-uild", Build.ID).addMetadata("manufacturer", Build.MANUFACTURER).addMetadata("fingerprint", Build.FINGERPRINT).addMetadata("tz-offset", i()).addMetadata("net-type", e(activeNetworkInfo)).addMetadata("mobile-subtype", d(activeNetworkInfo)).addMetadata("country", Locale.getDefault().getCountry()).addMetadata("locale", Locale.getDefault().getLanguage()).addMetadata("mcc_mnc", h(this.f6293c).getSimOperator()).addMetadata("application_build", Integer.toString(f(this.f6293c))).build();
    }

    public BackendResponse send(BackendRequest backendRequest) {
        BatchedLogRequest g10 = g(backendRequest);
        URL url = this.f6294d;
        String str = null;
        if (backendRequest.getExtras() != null) {
            try {
                CCTDestination fromByteArray = CCTDestination.fromByteArray(backendRequest.getExtras());
                if (fromByteArray.getAPIKey() != null) {
                    str = fromByteArray.getAPIKey();
                }
                if (fromByteArray.getEndPoint() != null) {
                    url = l(fromByteArray.getEndPoint());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.fatalError();
            }
        }
        try {
            b bVar = (b) Retries.retry(5, new a(url, g10, str), new a(this), new b());
            int i10 = bVar.f6301a;
            if (i10 == 200) {
                return BackendResponse.ok(bVar.f6303c);
            }
            if (i10 < 500) {
                if (i10 != 404) {
                    if (i10 == 400) {
                        return BackendResponse.invalidPayload();
                    }
                    return BackendResponse.fatalError();
                }
            }
            return BackendResponse.transientError();
        } catch (IOException e10) {
            Logging.e("CctTransportBackend", "Could not make request to the backend", e10);
            return BackendResponse.transientError();
        }
    }

    c(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, 130000);
    }
}
