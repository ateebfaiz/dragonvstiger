package com.facebook.react.devsupport;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.react.m;
import com.facebook.react.o;
import k6.i;
import k6.j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

public class RedBoxContentView extends LinearLayout implements AdapterView.OnItemClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public k6.e f2967a;

    /* renamed from: b  reason: collision with root package name */
    private ListView f2968b;

    /* renamed from: c  reason: collision with root package name */
    private Button f2969c;

    /* renamed from: d  reason: collision with root package name */
    private Button f2970d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2971e = false;

    /* renamed from: f  reason: collision with root package name */
    private i.a f2972f = new a();

    /* renamed from: g  reason: collision with root package name */
    private View.OnClickListener f2973g = new b();

    class a implements i.a {
        a() {
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            i unused = RedBoxContentView.this.getClass();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        public void onClick(View view) {
            ((k6.e) p5.a.c(RedBoxContentView.this.f2967a)).r();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        public void onClick(View view) {
            ((k6.e) p5.a.c(RedBoxContentView.this.f2967a)).p();
        }
    }

    private static class e extends AsyncTask {

        /* renamed from: b  reason: collision with root package name */
        private static final MediaType f2978b = MediaType.parse("application/json; charset=utf-8");

        /* renamed from: a  reason: collision with root package name */
        private final k6.e f2979a;

        private static JSONObject b(j jVar) {
            return new JSONObject(e6.f.g("file", jVar.b(), "methodName", jVar.c(), "lineNumber", Integer.valueOf(jVar.a()), "column", Integer.valueOf(jVar.e())));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(j... jVarArr) {
            try {
                String uri = Uri.parse(this.f2979a.v()).buildUpon().path("/open-stack-frame").query((String) null).build().toString();
                OkHttpClient okHttpClient = new OkHttpClient();
                for (j b10 : jVarArr) {
                    okHttpClient.newCall(new Request.Builder().url(uri).post(RequestBody.create(f2978b, b(b10).toString())).build()).execute();
                }
            } catch (Exception e10) {
                z2.a.k("ReactNative", "Could not open stack frame", e10);
            }
            return null;
        }

        private e(k6.e eVar) {
            this.f2979a = eVar;
        }
    }

    private static class f extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final String f2980a;

        /* renamed from: b  reason: collision with root package name */
        private final j[] f2981b;

        private static class a {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public final TextView f2982a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public final TextView f2983b;

            private a(View view) {
                this.f2982a = (TextView) view.findViewById(m.f20863t);
                this.f2983b = (TextView) view.findViewById(m.f20862s);
            }
        }

        public f(String str, j[] jVarArr) {
            this.f2980a = str;
            this.f2981b = jVarArr;
            p5.a.c(str);
            p5.a.c(jVarArr);
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public int getCount() {
            return this.f2981b.length + 1;
        }

        public Object getItem(int i10) {
            if (i10 == 0) {
                return this.f2980a;
            }
            return this.f2981b[i10 - 1];
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public int getItemViewType(int i10) {
            return i10 == 0 ? 0 : 1;
        }

        /* JADX WARNING: type inference failed for: r3v13, types: [android.view.View] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r3, android.view.View r4, android.view.ViewGroup r5) {
            /*
                r2 = this;
                r0 = 0
                if (r3 != 0) goto L_0x002b
                if (r4 == 0) goto L_0x0008
                android.widget.TextView r4 = (android.widget.TextView) r4
                goto L_0x0019
            L_0x0008:
                android.content.Context r3 = r5.getContext()
                android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
                int r4 = com.facebook.react.o.f20876e
                android.view.View r3 = r3.inflate(r4, r5, r0)
                r4 = r3
                android.widget.TextView r4 = (android.widget.TextView) r4
            L_0x0019:
                java.lang.String r3 = r2.f2980a
                if (r3 != 0) goto L_0x001f
                java.lang.String r3 = "<unknown title>"
            L_0x001f:
                java.lang.String r5 = "\\x1b\\[[0-9;]*m"
                java.lang.String r0 = ""
                java.lang.String r3 = r3.replaceAll(r5, r0)
                r4.setText(r3)
                return r4
            L_0x002b:
                if (r4 != 0) goto L_0x0044
                android.content.Context r4 = r5.getContext()
                android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
                int r1 = com.facebook.react.o.f20875d
                android.view.View r4 = r4.inflate(r1, r5, r0)
                com.facebook.react.devsupport.RedBoxContentView$f$a r5 = new com.facebook.react.devsupport.RedBoxContentView$f$a
                r0 = 0
                r5.<init>(r4)
                r4.setTag(r5)
            L_0x0044:
                k6.j[] r5 = r2.f2981b
                int r3 = r3 + -1
                r3 = r5[r3]
                java.lang.Object r5 = r4.getTag()
                com.facebook.react.devsupport.RedBoxContentView$f$a r5 = (com.facebook.react.devsupport.RedBoxContentView.f.a) r5
                android.widget.TextView r0 = r5.f2982a
                java.lang.String r1 = r3.c()
                r0.setText(r1)
                android.widget.TextView r0 = r5.f2983b
                java.lang.String r1 = com.facebook.react.devsupport.d1.d(r3)
                r0.setText(r1)
                android.widget.TextView r0 = r5.f2982a
                boolean r1 = r3.d()
                if (r1 == 0) goto L_0x0074
                r1 = -5592406(0xffffffffffaaaaaa, float:NaN)
                goto L_0x0075
            L_0x0074:
                r1 = -1
            L_0x0075:
                r0.setTextColor(r1)
                android.widget.TextView r5 = r5.f2983b
                boolean r3 = r3.d()
                if (r3 == 0) goto L_0x0086
                r3 = -8355712(0xffffffffff808080, float:NaN)
                goto L_0x0089
            L_0x0086:
                r3 = -5000269(0xffffffffffb3b3b3, float:NaN)
            L_0x0089:
                r5.setTextColor(r3)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.RedBoxContentView.f.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        public int getViewTypeCount() {
            return 2;
        }

        public boolean isEnabled(int i10) {
            return i10 > 0;
        }
    }

    public RedBoxContentView(Context context) {
        super(context);
    }

    public void c() {
        LayoutInflater.from(getContext()).inflate(o.f20877f, this);
        ListView listView = (ListView) findViewById(m.f20866w);
        this.f2968b = listView;
        listView.setOnItemClickListener(this);
        Button button = (Button) findViewById(m.f20865v);
        this.f2969c = button;
        button.setOnClickListener(new c());
        Button button2 = (Button) findViewById(m.f20864u);
        this.f2970d = button2;
        button2.setOnClickListener(new d());
    }

    public void d() {
        String l10 = this.f2967a.l();
        j[] A = this.f2967a.A();
        this.f2967a.u();
        Pair s10 = this.f2967a.s(Pair.create(l10, A));
        f((String) s10.first, (j[]) s10.second);
        this.f2967a.x();
    }

    public RedBoxContentView e(k6.e eVar) {
        this.f2967a = eVar;
        return this;
    }

    public void f(String str, j[] jVarArr) {
        this.f2968b.setAdapter(new f(str, jVarArr));
    }

    public RedBoxContentView g(i iVar) {
        return this;
    }

    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        new e((k6.e) p5.a.c(this.f2967a)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new j[]{(j) this.f2968b.getAdapter().getItem(i10)});
    }
}
