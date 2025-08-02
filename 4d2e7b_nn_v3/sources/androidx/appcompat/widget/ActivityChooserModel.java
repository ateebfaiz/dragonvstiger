package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class ActivityChooserModel extends DataSetObservable {

    /* renamed from: n  reason: collision with root package name */
    static final String f14147n = "ActivityChooserModel";

    /* renamed from: o  reason: collision with root package name */
    private static final Object f14148o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private static final Map f14149p = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Object f14150a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final List f14151b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final List f14152c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    final Context f14153d;

    /* renamed from: e  reason: collision with root package name */
    final String f14154e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f14155f;

    /* renamed from: g  reason: collision with root package name */
    private ActivitySorter f14156g = new a();

    /* renamed from: h  reason: collision with root package name */
    private int f14157h = 50;

    /* renamed from: i  reason: collision with root package name */
    boolean f14158i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14159j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f14160k = true;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14161l = false;

    /* renamed from: m  reason: collision with root package name */
    private OnChooseActivityListener f14162m;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo2) {
            this.resolveInfo = resolveInfo2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.resolveInfo.toString() + "; weight:" + new BigDecimal((double) this.weight) + "]";
        }

        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j10, float f10) {
            this(ComponentName.unflattenFromString(str), j10, f10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            if (this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                i10 = 0;
            } else {
                i10 = componentName.hashCode();
            }
            long j10 = this.time;
            return ((((i10 + 31) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public String toString() {
            return "[" + "; activity:" + this.activity + "; time:" + this.time + "; weight:" + new BigDecimal((double) this.weight) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j10, float f10) {
            this.activity = componentName;
            this.time = j10;
            this.weight = f10;
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    private static final class a implements ActivitySorter {

        /* renamed from: a  reason: collision with root package name */
        private final Map f14163a = new HashMap();

        a() {
        }

        public void sort(Intent intent, List list, List list2) {
            Map map = this.f14163a;
            map.clear();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) list.get(i10);
                activityResolveInfo.weight = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f10 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = (HistoricalRecord) list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight += historicalRecord.weight * f10;
                    f10 *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    private final class b extends AsyncTask {
        b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
            if (r15 != null) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0096, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b5, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d4, code lost:
            if (r15 == null) goto L_0x00d7;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.ActivityChooserModel r7 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x00e2 }
                android.content.Context r7 = r7.f14153d     // Catch:{ FileNotFoundException -> 0x00e2 }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00e2 }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r9 = r3
            L_0x002f:
                if (r9 >= r8) goto L_0x006a
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord r10 = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) r10     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.activity     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "time"
                long r12 = r10.time     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r11 = "weight"
                float r10 = r10.weight     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                int r9 = r9 + 1
                goto L_0x002f
            L_0x0061:
                r0 = move-exception
                goto L_0x00d8
            L_0x0064:
                r0 = move-exception
                goto L_0x007a
            L_0x0066:
                r0 = move-exception
                goto L_0x0099
            L_0x0068:
                r0 = move-exception
                goto L_0x00b8
            L_0x006a:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x0068, IllegalStateException -> 0x0066, IOException -> 0x0064 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f14158i = r5
                if (r15 == 0) goto L_0x00d7
            L_0x0076:
                r15.close()     // Catch:{ IOException -> 0x00d7 }
                goto L_0x00d7
            L_0x007a:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.f14147n     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.f14154e     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f14158i = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x0099:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.f14147n     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.f14154e     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f14158i = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x00b8:
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.f14147n     // Catch:{ all -> 0x0061 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
                r3.<init>()     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r2 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r2.f14154e     // Catch:{ all -> 0x0061 }
                r3.append(r2)     // Catch:{ all -> 0x0061 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0061 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0061 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.f14158i = r5
                if (r15 == 0) goto L_0x00d7
                goto L_0x0076
            L_0x00d7:
                return r6
            L_0x00d8:
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this
                r1.f14158i = r5
                if (r15 == 0) goto L_0x00e1
                r15.close()     // Catch:{ IOException -> 0x00e1 }
            L_0x00e1:
                throw r0
            L_0x00e2:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.ActivityChooserModel.f14147n
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r15)
                java.lang.String r15 = r3.toString()
                android.util.Log.e(r1, r15, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.b.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private ActivityChooserModel(Context context, String str) {
        this.f14153d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.f14154e = str;
            return;
        }
        this.f14154e = str + ".xml";
    }

    private boolean a(HistoricalRecord historicalRecord) {
        boolean add = this.f14152c.add(historicalRecord);
        if (add) {
            this.f14160k = true;
            l();
            k();
            r();
            notifyChanged();
        }
        return add;
    }

    private void c() {
        boolean j10 = j() | m();
        l();
        if (j10) {
            r();
            notifyChanged();
        }
    }

    public static ActivityChooserModel d(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (f14148o) {
            try {
                Map map = f14149p;
                activityChooserModel = (ActivityChooserModel) map.get(str);
                if (activityChooserModel == null) {
                    activityChooserModel = new ActivityChooserModel(context, str);
                    map.put(str, activityChooserModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityChooserModel;
    }

    private boolean j() {
        if (!this.f14161l || this.f14155f == null) {
            return false;
        }
        this.f14161l = false;
        this.f14151b.clear();
        List<ResolveInfo> queryIntentActivities = this.f14153d.getPackageManager().queryIntentActivities(this.f14155f, 0);
        int size = queryIntentActivities.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f14151b.add(new ActivityResolveInfo(queryIntentActivities.get(i10)));
        }
        return true;
    }

    private void k() {
        if (!this.f14159j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f14160k) {
            this.f14160k = false;
            if (!TextUtils.isEmpty(this.f14154e)) {
                new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f14152c), this.f14154e});
            }
        }
    }

    private void l() {
        int size = this.f14152c.size() - this.f14157h;
        if (size > 0) {
            this.f14160k = true;
            for (int i10 = 0; i10 < size; i10++) {
                HistoricalRecord historicalRecord = (HistoricalRecord) this.f14152c.remove(0);
            }
        }
    }

    private boolean m() {
        if (!this.f14158i || !this.f14160k || TextUtils.isEmpty(this.f14154e)) {
            return false;
        }
        this.f14158i = false;
        this.f14159j = true;
        n();
        return true;
    }

    private void n() {
        try {
            FileInputStream openFileInput = this.f14153d.openFileInput(this.f14154e);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i10 = 0;
                while (i10 != 1 && i10 != 2) {
                    i10 = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f14152c;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new HistoricalRecord(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e10) {
                String str = f14147n;
                Log.e(str, "Error reading historical recrod file: " + this.f14154e, e10);
                if (openFileInput == null) {
                }
            } catch (IOException e11) {
                String str2 = f14147n;
                Log.e(str2, "Error reading historical recrod file: " + this.f14154e, e11);
                if (openFileInput == null) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    private boolean r() {
        if (this.f14156g == null || this.f14155f == null || this.f14151b.isEmpty() || this.f14152c.isEmpty()) {
            return false;
        }
        this.f14156g.sort(this.f14155f, this.f14151b, Collections.unmodifiableList(this.f14152c));
        return true;
    }

    public Intent b(int i10) {
        synchronized (this.f14150a) {
            try {
                if (this.f14155f == null) {
                    return null;
                }
                c();
                ActivityInfo activityInfo = ((ActivityResolveInfo) this.f14151b.get(i10)).resolveInfo.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent(this.f14155f);
                intent.setComponent(componentName);
                if (this.f14162m != null) {
                    if (this.f14162m.onChooseActivity(this, new Intent(intent))) {
                        return null;
                    }
                }
                a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
                return intent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo e(int i10) {
        ResolveInfo resolveInfo;
        synchronized (this.f14150a) {
            c();
            resolveInfo = ((ActivityResolveInfo) this.f14151b.get(i10)).resolveInfo;
        }
        return resolveInfo;
    }

    public int f() {
        int size;
        synchronized (this.f14150a) {
            c();
            size = this.f14151b.size();
        }
        return size;
    }

    public int g(ResolveInfo resolveInfo) {
        synchronized (this.f14150a) {
            try {
                c();
                List list = this.f14151b;
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (((ActivityResolveInfo) list.get(i10)).resolveInfo == resolveInfo) {
                        return i10;
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo h() {
        synchronized (this.f14150a) {
            try {
                c();
                if (this.f14151b.isEmpty()) {
                    return null;
                }
                ResolveInfo resolveInfo = ((ActivityResolveInfo) this.f14151b.get(0)).resolveInfo;
                return resolveInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int i() {
        int size;
        synchronized (this.f14150a) {
            c();
            size = this.f14152c.size();
        }
        return size;
    }

    public void o(int i10) {
        float f10;
        synchronized (this.f14150a) {
            try {
                c();
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.f14151b.get(i10);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) this.f14151b.get(0);
                if (activityResolveInfo2 != null) {
                    f10 = (activityResolveInfo2.weight - activityResolveInfo.weight) + 5.0f;
                } else {
                    f10 = 1.0f;
                }
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                a(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f10));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void p(Intent intent) {
        synchronized (this.f14150a) {
            try {
                if (this.f14155f != intent) {
                    this.f14155f = intent;
                    this.f14161l = true;
                    c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void q(OnChooseActivityListener onChooseActivityListener) {
        synchronized (this.f14150a) {
            this.f14162m = onChooseActivityListener;
        }
    }
}
