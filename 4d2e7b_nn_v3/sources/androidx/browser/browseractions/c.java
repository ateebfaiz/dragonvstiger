package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.browser.R;
import androidx.core.widget.TextViewCompat;
import java.util.List;

class c implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14422a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f14423b;

    /* renamed from: c  reason: collision with root package name */
    private final List f14424c;

    /* renamed from: d  reason: collision with root package name */
    private b f14425d;

    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14426a;

        a(TextView textView) {
            this.f14426a = textView;
        }

        public void onClick(View view) {
            if (TextViewCompat.getMaxLines(this.f14426a) == Integer.MAX_VALUE) {
                this.f14426a.setMaxLines(1);
                this.f14426a.setEllipsize(TextUtils.TruncateAt.END);
                return;
            }
            this.f14426a.setMaxLines(Integer.MAX_VALUE);
            this.f14426a.setEllipsize((TextUtils.TruncateAt) null);
        }
    }

    c(Context context, Uri uri, List list) {
        this.f14422a = context;
        this.f14423b = uri;
        this.f14424c = list;
    }

    private BrowserActionsFallbackMenuView b(View view) {
        BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView) view.findViewById(R.id.browser_actions_menu_view);
        TextView textView = (TextView) view.findViewById(R.id.browser_actions_header_text);
        textView.setText(this.f14423b.toString());
        textView.setOnClickListener(new a(textView));
        ListView listView = (ListView) view.findViewById(R.id.browser_actions_menu_items);
        listView.setAdapter(new a(this.f14424c, this.f14422a));
        listView.setOnItemClickListener(this);
        return browserActionsFallbackMenuView;
    }

    public void a() {
        View inflate = LayoutInflater.from(this.f14422a).inflate(R.layout.browser_actions_context_menu_page, (ViewGroup) null);
        b bVar = new b(this.f14422a, b(inflate));
        this.f14425d = bVar;
        bVar.setContentView(inflate);
        this.f14425d.show();
    }

    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        try {
            ((BrowserActionItem) this.f14424c.get(i10)).getAction().send();
            this.f14425d.dismiss();
        } catch (PendingIntent.CanceledException e10) {
            Log.e("BrowserActionskMenuUi", "Failed to send custom item action", e10);
        }
    }
}
