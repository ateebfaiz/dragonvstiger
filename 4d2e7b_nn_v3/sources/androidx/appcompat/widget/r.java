package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

class r extends ResourceCursorAdapter implements View.OnClickListener {
    private int C = -1;
    private int X = -1;
    private int Y = -1;

    /* renamed from: a  reason: collision with root package name */
    private final SearchView f14357a;

    /* renamed from: b  reason: collision with root package name */
    private final SearchableInfo f14358b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f14359c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap f14360d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14361e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14362f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f14363g = 1;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f14364h;

    /* renamed from: i  reason: collision with root package name */
    private int f14365i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f14366j = -1;

    /* renamed from: w  reason: collision with root package name */
    private int f14367w = -1;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f14368a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f14369b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f14370c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f14371d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f14372e;

        public a(View view) {
            this.f14368a = (TextView) view.findViewById(16908308);
            this.f14369b = (TextView) view.findViewById(16908309);
            this.f14370c = (ImageView) view.findViewById(16908295);
            this.f14371d = (ImageView) view.findViewById(16908296);
            this.f14372e = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    public r(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f14357a = searchView;
        this.f14358b = searchableInfo;
        this.f14361e = searchView.getSuggestionCommitIconResId();
        this.f14359c = context;
        this.f14360d = weakHashMap;
    }

    private Drawable a(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f14360d.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence b(CharSequence charSequence) {
        if (this.f14364h == null) {
            TypedValue typedValue = new TypedValue();
            this.f14359c.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
            this.f14364h = this.f14359c.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f14364h, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable c(ComponentName componentName) {
        PackageManager packageManager = this.f14359c.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("SuggestionsAdapter", e10.toString());
            return null;
        }
    }

    private Drawable d(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f14360d.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = (Drawable.ConstantState) this.f14360d.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f14359c.getResources());
        }
        Drawable c10 = c(componentName);
        if (c10 != null) {
            constantState = c10.getConstantState();
        }
        this.f14360d.put(flattenToShortString, constantState);
        return c10;
    }

    public static String e(Cursor cursor, String str) {
        return m(cursor, cursor.getColumnIndex(str));
    }

    private Drawable f() {
        Drawable d10 = d(this.f14358b.getSearchActivity());
        if (d10 != null) {
            return d10;
        }
        return this.f14359c.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable g(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0016 }
            if (r3 == 0) goto L_0x002f
            android.graphics.drawable.Drawable r7 = r6.h(r7)     // Catch:{ NotFoundException -> 0x0018 }
            return r7
        L_0x0016:
            r0 = move-exception
            goto L_0x0087
        L_0x0018:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r4 = "Resource does not exist: "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0016 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0016 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x002f:
            android.content.Context r3 = r6.f14359c     // Catch:{ FileNotFoundException -> 0x0016 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            if (r3 == 0) goto L_0x0070
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch:{ all -> 0x0057 }
            r3.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0056
        L_0x0043:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x0056:
            return r4
        L_0x0057:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x006f
        L_0x005c:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0016 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x006f:
            throw r4     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x0070:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0016 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r4 = "Failed to open "
            r3.append(r4)     // Catch:{ FileNotFoundException -> 0x0016 }
            r3.append(r7)     // Catch:{ FileNotFoundException -> 0x0016 }
            java.lang.String r3 = r3.toString()     // Catch:{ FileNotFoundException -> 0x0016 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0016 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0016 }
        L_0x0087:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r0.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r1, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r.g(android.net.Uri):android.graphics.drawable.Drawable");
    }

    private Drawable i(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f14359c.getPackageName() + DomExceptionUtils.SEPARATOR + parseInt;
            Drawable a10 = a(str2);
            if (a10 != null) {
                return a10;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f14359c, parseInt);
            q(str2, drawable);
            return drawable;
        } catch (NumberFormatException unused) {
            Drawable a11 = a(str);
            if (a11 != null) {
                return a11;
            }
            Drawable g10 = g(Uri.parse(str));
            q(str, g10);
            return g10;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable j(Cursor cursor) {
        int i10 = this.C;
        if (i10 == -1) {
            return null;
        }
        Drawable i11 = i(cursor.getString(i10));
        if (i11 != null) {
            return i11;
        }
        return f();
    }

    private Drawable k(Cursor cursor) {
        int i10 = this.X;
        if (i10 == -1) {
            return null;
        }
        return i(cursor.getString(i10));
    }

    private static String m(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    private void o(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void p(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void q(String str, Drawable drawable) {
        if (drawable != null) {
            this.f14360d.put(str, drawable.getConstantState());
        }
    }

    private void r(Cursor cursor) {
        Bundle bundle;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    public void bindView(View view, Context context, Cursor cursor) {
        int i10;
        CharSequence charSequence;
        a aVar = (a) view.getTag();
        int i11 = this.Y;
        if (i11 != -1) {
            i10 = cursor.getInt(i11);
        } else {
            i10 = 0;
        }
        if (aVar.f14368a != null) {
            p(aVar.f14368a, m(cursor, this.f14365i));
        }
        if (aVar.f14369b != null) {
            String m10 = m(cursor, this.f14367w);
            if (m10 != null) {
                charSequence = b(m10);
            } else {
                charSequence = m(cursor, this.f14366j);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TextView textView = aVar.f14368a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f14368a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f14368a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f14368a.setMaxLines(1);
                }
            }
            p(aVar.f14369b, charSequence);
        }
        ImageView imageView = aVar.f14370c;
        if (imageView != null) {
            o(imageView, j(cursor), 4);
        }
        ImageView imageView2 = aVar.f14371d;
        if (imageView2 != null) {
            o(imageView2, k(cursor), 8);
        }
        int i12 = this.f14363g;
        if (i12 == 2 || (i12 == 1 && (i10 & 1) != 0)) {
            aVar.f14372e.setVisibility(0);
            aVar.f14372e.setTag(aVar.f14368a.getText());
            aVar.f14372e.setOnClickListener(this);
            return;
        }
        aVar.f14372e.setVisibility(8);
    }

    public void changeCursor(Cursor cursor) {
        if (this.f14362f) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.f14365i = cursor.getColumnIndex("suggest_text_1");
                this.f14366j = cursor.getColumnIndex("suggest_text_2");
                this.f14367w = cursor.getColumnIndex("suggest_text_2_url");
                this.C = cursor.getColumnIndex("suggest_icon_1");
                this.X = cursor.getColumnIndex("suggest_icon_2");
                this.Y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        String e10;
        String e11;
        if (cursor == null) {
            return null;
        }
        String e12 = e(cursor, "suggest_intent_query");
        if (e12 != null) {
            return e12;
        }
        if (this.f14358b.shouldRewriteQueryFromData() && (e11 = e(cursor, "suggest_intent_data")) != null) {
            return e11;
        }
        if (!this.f14358b.shouldRewriteQueryFromText() || (e10 = e(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return e10;
    }

    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View newDropDownView = newDropDownView(this.f14359c, getCursor(), viewGroup);
            if (newDropDownView != null) {
                ((a) newDropDownView.getTag()).f14368a.setText(e10.toString());
            }
            return newDropDownView;
        }
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e10);
            View newView = newView(this.f14359c, getCursor(), viewGroup);
            if (newView != null) {
                ((a) newView.getTag()).f14368a.setText(e10.toString());
            }
            return newView;
        }
    }

    /* access modifiers changed from: package-private */
    public Drawable h(Uri uri) {
        int i10;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f14359c.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i10 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i10 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i10 != 0) {
                        return resourcesForApplication.getDrawable(i10);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public Cursor l(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f14359c.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public void n(int i10) {
        this.f14363g = i10;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new a(newView));
        ((ImageView) newView.findViewById(R.id.edit_query)).setImageResource(this.f14361e);
        return newView;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        r(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        r(getCursor());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f14357a.onQueryRefine((CharSequence) tag);
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String str;
        if (charSequence == null) {
            str = "";
        } else {
            str = charSequence.toString();
        }
        if (this.f14357a.getVisibility() == 0 && this.f14357a.getWindowVisibility() == 0) {
            try {
                Cursor l10 = l(this.f14358b, str, 50);
                if (l10 != null) {
                    l10.getCount();
                    return l10;
                }
            } catch (RuntimeException e10) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e10);
            }
        }
        return null;
    }
}
