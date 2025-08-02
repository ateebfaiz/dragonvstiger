package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.R;
import androidx.core.content.res.ResourcesCompat;
import java.util.List;

class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final List f14415a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f14416b;

    /* renamed from: androidx.browser.browseractions.a$a  reason: collision with other inner class name */
    static class C0181a {

        /* renamed from: a  reason: collision with root package name */
        ImageView f14417a;

        /* renamed from: b  reason: collision with root package name */
        TextView f14418b;

        C0181a() {
        }
    }

    a(List list, Context context) {
        this.f14415a = list;
        this.f14416b = context;
    }

    public int getCount() {
        return this.f14415a.size();
    }

    public Object getItem(int i10) {
        return this.f14415a.get(i10);
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        C0181a aVar;
        BrowserActionItem browserActionItem = (BrowserActionItem) this.f14415a.get(i10);
        if (view == null) {
            view = LayoutInflater.from(this.f14416b).inflate(R.layout.browser_actions_context_menu_row, (ViewGroup) null);
            aVar = new C0181a();
            aVar.f14417a = (ImageView) view.findViewById(R.id.browser_actions_menu_item_icon);
            aVar.f14418b = (TextView) view.findViewById(R.id.browser_actions_menu_item_text);
            view.setTag(aVar);
        } else {
            aVar = (C0181a) view.getTag();
        }
        aVar.f14418b.setText(browserActionItem.getTitle());
        if (browserActionItem.getIconId() != 0) {
            aVar.f14417a.setImageDrawable(ResourcesCompat.getDrawable(this.f14416b.getResources(), browserActionItem.getIconId(), (Resources.Theme) null));
        } else {
            aVar.f14417a.setImageDrawable((Drawable) null);
        }
        return view;
    }
}
