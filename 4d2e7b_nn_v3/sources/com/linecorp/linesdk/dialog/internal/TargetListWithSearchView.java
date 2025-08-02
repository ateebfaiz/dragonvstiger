package com.linecorp.linesdk.dialog.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import c.d;
import i9.h;
import i9.i;

public class TargetListWithSearchView extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f10083a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public SearchView f10084b;

    /* renamed from: c  reason: collision with root package name */
    private AppCompatTextView f10085c;

    class a implements SearchView.OnQueryTextListener {
        a() {
        }

        private void a(String str) {
            d.a(TargetListWithSearchView.this.f10083a.getAdapter());
        }

        public boolean onQueryTextChange(String str) {
            a(str);
            return true;
        }

        public boolean onQueryTextSubmit(String str) {
            a(str);
            TargetListWithSearchView.this.f10084b.clearFocus();
            return true;
        }
    }

    public TargetListWithSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void c() {
        View inflate = View.inflate(getContext(), i.f12364a, this);
        this.f10083a = (RecyclerView) inflate.findViewById(h.f12362b);
        this.f10084b = (SearchView) inflate.findViewById(h.f12363c);
        this.f10085c = (AppCompatTextView) inflate.findViewById(h.f12361a);
        this.f10084b.setOnQueryTextListener(new a());
    }

    public TargetListWithSearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c();
    }
}
