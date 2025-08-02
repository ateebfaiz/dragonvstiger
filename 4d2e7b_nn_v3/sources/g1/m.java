package g1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.appsflyer.AppsFlyerProperties;
import com.engagelab.privates.core.api.MTReporter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import t1.b;
import u1.f;
import u1.g;
import u1.l;
import u1.n;

public class m {

    /* renamed from: c  reason: collision with root package name */
    public static int f21600c = 200;

    /* renamed from: d  reason: collision with root package name */
    public static volatile m f21601d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f21602a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f21603b;

    public class a implements Comparator {
        public a(m mVar) {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            int i10 = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
            if (i10 < 0) {
                return -1;
            }
            if (i10 > 0) {
                return 1;
            }
            return 0;
        }
    }

    public static m b() {
        if (f21601d == null) {
            synchronized (m.class) {
                f21601d = new m();
            }
        }
        return f21601d;
    }

    public final int a(Context context, String str, JSONObject jSONObject, File file) {
        byte[] bArr;
        String str2;
        String str3 = str;
        try {
            if (!n.b(context)) {
                s1.a.a("MTReportBusiness", "can't report, network is disConnected");
                return -1;
            }
            long G = n.G(context);
            if (G == 0) {
                s1.a.a("MTReportBusiness", "uid is 0");
                return -1;
            }
            List d10 = x1.a.d(context);
            if (d10.isEmpty()) {
                s1.a.a("MTReportBusiness", "there are no report url");
                return -1;
            }
            jSONObject.put("uid", G);
            byte[] c10 = g.c(jSONObject.toString().getBytes(o1.a.f22951b));
            String j10 = u1.a.j((long) u1.a.h());
            String i10 = u1.a.i(new String("\u000b\r\u0012PRQRVRWRT\u00032\tC".getBytes(), Charset.forName("UTF-8")), 'b');
            int o10 = p1.a.o();
            if (o10 != 2) {
                bArr = u1.a.f(c10, j10, i10);
                o10 = 1;
            } else {
                bArr = l.k(c10, j10, i10);
            }
            String str4 = G + ":" + u1.m.c(G + u1.m.e(n.v(context)) + u1.m.d(bArr)) + ":" + j10;
            String str5 = "Basic " + Base64.encodeToString(str4.getBytes(), 10);
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i11 = 0; i11 < 3; i11++) {
                arrayList.addAll(d10);
            }
            for (String str6 : arrayList) {
                if (str3.contains("sgm") && !str6.contains("/v3/sgm/report")) {
                    str6 = str6 + "/v3/sgm/report";
                }
                if (!str3.contains("sgm") && !str6.contains("/v3/report")) {
                    str6 = str6 + "/v3/report";
                }
                int a10 = p.a(context, str6, str5, bArr);
                if (a10 == 200) {
                    s1.a.a("MTReportBusiness", "report success encrypt:" + o10 + ", url:" + str6 + ", fileName:" + file.getName() + s1.a.g(jSONObject));
                    if (!file.exists()) {
                        return 0;
                    }
                    boolean delete = file.delete();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("delete ");
                    if (delete) {
                        str2 = FirebaseAnalytics.Param.SUCCESS;
                    } else {
                        str2 = "failed";
                    }
                    sb2.append(str2);
                    sb2.append(" file:");
                    sb2.append(file.getAbsolutePath());
                    s1.a.a("MTReportBusiness", sb2.toString());
                    return 0;
                }
                s1.a.a("MTReportBusiness", "report failed code:" + a10 + ", url:" + str6 + ", fileName:" + file.getName() + s1.a.g(jSONObject));
                str3 = str;
            }
            return -1;
        } catch (Throwable th) {
            s1.a.h("MTReportBusiness", "report failed " + th.getMessage());
            return -1;
        }
    }

    public File c(Context context, String str) {
        try {
            if (TextUtils.isEmpty(this.f21603b)) {
                File filesDir = context.getFilesDir();
                String b10 = p1.a.b(context);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(filesDir.getAbsolutePath());
                String str2 = File.separator;
                sb2.append(str2);
                sb2.append("com_engagelab_privates_core");
                sb2.append(str2);
                sb2.append(b10);
                this.f21603b = sb2.toString();
            }
            String str3 = this.f21603b + File.separator + System.currentTimeMillis();
            s1.a.a("MTReportBusiness", "save file:" + str3);
            File file = new File(str3);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                return null;
            }
            if (!file.exists() && !file.createNewFile()) {
                return null;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes(o1.a.f22951b));
            fileOutputStream.close();
            return file;
        } catch (Throwable th) {
            s1.a.h("MTReportBusiness", "saveReportContent failed " + th.getMessage());
            return null;
        }
    }

    public final JSONObject d(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("itime", System.currentTimeMillis() / 1000);
            jSONObject.put("account_id", "");
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject2.put(FirebaseAnalytics.Param.CONTENT, jSONArray);
            jSONObject2.put("platform", "a");
            jSONObject2.put("uid", n.G(context));
            jSONObject2.put("app_version", p1.a.e(context));
            jSONObject2.put("app_key", p1.a.b(context));
            jSONObject2.put(AppsFlyerProperties.CHANNEL, p1.a.a(context));
            Iterator it = t1.a.b().f24068a.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.i()) {
                    if (!TextUtils.isEmpty(bVar.c())) {
                        if (!TextUtils.isEmpty(bVar.e())) {
                            jSONObject2.put(bVar.c(), bVar.e());
                        }
                    }
                }
            }
            return jSONObject2;
        } catch (Throwable th) {
            s1.a.h("MTReportBusiness", "prepareReportJson failed " + th.getMessage());
            return null;
        }
    }

    public synchronized void e(Context context) {
        if (!this.f21602a) {
            s1.a.a("MTReportBusiness", "report cache begin");
            this.f21602a = true;
            if (TextUtils.isEmpty(this.f21603b)) {
                this.f21602a = false;
                s1.a.a("MTReportBusiness", "there are no report cache");
                return;
            }
            File file = new File(this.f21603b);
            if (!file.exists()) {
                this.f21602a = false;
                s1.a.a("MTReportBusiness", "there are no report cache");
                return;
            }
            f.b(this.f21603b, f21600c);
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                if (listFiles.length != 0) {
                    List<File> asList = Arrays.asList(listFiles);
                    Collections.sort(asList, new a(this));
                    for (File file2 : asList) {
                        if (!file2.exists()) {
                            s1.a.a("MTReportBusiness", "cacheFile [" + file2.getAbsolutePath() + "] is no exist");
                        } else {
                            try {
                                FileInputStream fileInputStream = new FileInputStream(file2);
                                byte[] bArr = new byte[fileInputStream.available()];
                                fileInputStream.read(bArr);
                                fileInputStream.close();
                                String str = new String(bArr, o1.a.f22951b);
                                if (!TextUtils.isEmpty(str)) {
                                    JSONObject jSONObject = new JSONObject(str);
                                    String optString = jSONObject.optString("type");
                                    s1.a.a("MTReportBusiness", "reportCache file:" + file2.getAbsolutePath());
                                    a(context, optString, jSONObject, file2);
                                } else {
                                    return;
                                }
                            } catch (Throwable th) {
                                s1.a.h("MTReportBusiness", "reportCache failed " + th.getMessage());
                            }
                        }
                    }
                    this.f21602a = false;
                    s1.a.a("MTReportBusiness", "report cache finish");
                    return;
                }
            }
            this.f21602a = false;
            s1.a.a("MTReportBusiness", "there are no report cache");
        }
    }

    public void f(Context context, Bundle bundle) {
        try {
            bundle.setClassLoader(MTReporter.class.getClassLoader());
            if (!bundle.containsKey("protocol")) {
                e(context);
                return;
            }
            MTReporter mTReporter = (MTReporter) bundle.getParcelable("protocol");
            JSONObject jSONObject = new JSONObject(mTReporter.a());
            jSONObject.put("type", mTReporter.b());
            JSONObject d10 = d(context, jSONObject);
            if (d10 != null) {
                if (a(context, mTReporter.b(), d10, c(context, d10.toString())) == 0) {
                    e(context);
                }
            }
        } catch (Throwable th) {
            s1.a.h("MTReportBusiness", "report failed " + th.getMessage());
        }
    }
}
