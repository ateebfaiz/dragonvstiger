package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;
import androidx.cursoradapter.widget.a;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, a.C0195a {
    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mAutoRequery;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected a mChangeObserver;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Context mContext;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Cursor mCursor;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected a mCursorFilter;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected DataSetObserver mDataSetObserver;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mDataValid;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected FilterQueryProvider mFilterQueryProvider;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int mRowIDColumn;

    private class a extends ContentObserver {
        a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z10) {
            CursorAdapter.this.onContentChanged();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.mDataValid = true;
            cursorAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.mDataValid = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context context, Cursor cursor) {
        init(context, cursor, 1);
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return "";
        }
        return cursor.toString();
    }

    public int getCount() {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            return null;
        }
        this.mCursor.moveToPosition(i10);
        if (view == null) {
            view = newDropDownView(this.mContext, this.mCursor, viewGroup);
        }
        bindView(view, this.mContext, this.mCursor);
        return view;
    }

    public Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new a(this);
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.mCursor;
    }

    public long getItemId(int i10) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null || !cursor.moveToPosition(i10)) {
            return 0;
        }
        return this.mCursor.getLong(this.mRowIDColumn);
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.mCursor.moveToPosition(i10)) {
            if (view == null) {
                view = newView(this.mContext, this.mCursor, viewGroup);
            }
            bindView(view, this.mContext, this.mCursor);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i10);
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void init(Context context, Cursor cursor, boolean z10) {
        init(context, cursor, z10 ? 1 : 2);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void onContentChanged() {
        Cursor cursor;
        if (this.mAutoRequery && (cursor = this.mCursor) != null && !cursor.isClosed()) {
            this.mDataValid = this.mCursor.requery();
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            a aVar = this.mChangeObserver;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = cursor;
        if (cursor != null) {
            a aVar2 = this.mChangeObserver;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    /* access modifiers changed from: package-private */
    public void init(Context context, Cursor cursor, int i10) {
        boolean z10 = false;
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        if (cursor != null) {
            z10 = true;
        }
        this.mCursor = cursor;
        this.mDataValid = z10;
        this.mContext = context;
        this.mRowIDColumn = z10 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i10 & 2) == 2) {
            this.mChangeObserver = new a();
            this.mDataSetObserver = new b();
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z10) {
            a aVar = this.mChangeObserver;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z10) {
        init(context, cursor, z10 ? 1 : 2);
    }

    public CursorAdapter(Context context, Cursor cursor, int i10) {
        init(context, cursor, i10);
    }
}
