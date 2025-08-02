package com.reactnativepagerview;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

public final class g extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList f11343a = new ArrayList();

    public final void a(View view, int i10) {
        m.f(view, "child");
        this.f11343a.add(i10, view);
        notifyItemInserted(i10);
    }

    public final View b(int i10) {
        Object obj = this.f11343a.get(i10);
        m.e(obj, "get(...)");
        return (View) obj;
    }

    /* renamed from: c */
    public void onBindViewHolder(h hVar, int i10) {
        m.f(hVar, "holder");
        FrameLayout container = hVar.getContainer();
        View b10 = b(i10);
        hVar.setIsRecyclable(false);
        if (container.getChildCount() > 0) {
            container.removeAllViews();
        }
        if (b10.getParent() != null) {
            ViewParent parent = b10.getParent();
            m.d(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
            ((FrameLayout) parent).removeView(b10);
        }
        container.addView(b10);
    }

    /* renamed from: d */
    public h onCreateViewHolder(ViewGroup viewGroup, int i10) {
        m.f(viewGroup, "parent");
        return h.f11344a.a(viewGroup);
    }

    public final void e() {
        ViewParent viewParent;
        int size = this.f11343a.size();
        int i10 = 1;
        if (1 <= size) {
            while (true) {
                Object obj = this.f11343a.get(i10 - 1);
                m.e(obj, "get(...)");
                View view = (View) obj;
                ViewParent parent = view.getParent();
                if (parent != null) {
                    viewParent = parent.getParent();
                } else {
                    viewParent = null;
                }
                if (viewParent != null) {
                    ViewParent parent2 = view.getParent().getParent();
                    m.d(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
                    ViewParent parent3 = view.getParent();
                    m.d(parent3, "null cannot be cast to non-null type android.view.View");
                    ((ViewGroup) parent2).removeView((View) parent3);
                }
                if (i10 == size) {
                    break;
                }
                i10++;
            }
        }
        int size2 = this.f11343a.size();
        this.f11343a.clear();
        notifyItemRangeRemoved(0, size2);
    }

    public final void f(View view) {
        m.f(view, "child");
        int indexOf = this.f11343a.indexOf(view);
        if (indexOf > -1) {
            g(indexOf);
        }
    }

    public final void g(int i10) {
        if (i10 >= 0 && i10 < this.f11343a.size()) {
            this.f11343a.remove(i10);
            notifyItemRemoved(i10);
        }
    }

    public int getItemCount() {
        return this.f11343a.size();
    }
}
