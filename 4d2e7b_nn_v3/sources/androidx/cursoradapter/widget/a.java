package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

class a extends Filter {

    /* renamed from: a  reason: collision with root package name */
    C0195a f15352a;

    /* renamed from: androidx.cursoradapter.widget.a$a  reason: collision with other inner class name */
    interface C0195a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    a(C0195a aVar) {
        this.f15352a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f15352a.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f15352a.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.f15352a.getCursor();
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            this.f15352a.changeCursor((Cursor) obj);
        }
    }
}
