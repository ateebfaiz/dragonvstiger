package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    static final String LOG_TAG = "SupportMenuInflater";
    static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    final Object[] mActionProviderConstructorArguments;
    final Object[] mActionViewConstructorArguments;
    Context mContext;
    private Object mRealOwner;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class[] f14035c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f14036a;

        /* renamed from: b  reason: collision with root package name */
        private Method f14037b;

        public a(Object obj, String str) {
            this.f14036a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f14037b = cls.getMethod(str, f14035c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f14037b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f14037b.invoke(this.f14036a, new Object[]{menuItem})).booleanValue();
                }
                this.f14037b.invoke(this.f14036a, new Object[]{menuItem});
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    private class b {
        ActionProvider A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f14038a;

        /* renamed from: b  reason: collision with root package name */
        private int f14039b;

        /* renamed from: c  reason: collision with root package name */
        private int f14040c;

        /* renamed from: d  reason: collision with root package name */
        private int f14041d;

        /* renamed from: e  reason: collision with root package name */
        private int f14042e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f14043f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f14044g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f14045h;

        /* renamed from: i  reason: collision with root package name */
        private int f14046i;

        /* renamed from: j  reason: collision with root package name */
        private int f14047j;

        /* renamed from: k  reason: collision with root package name */
        private CharSequence f14048k;

        /* renamed from: l  reason: collision with root package name */
        private CharSequence f14049l;

        /* renamed from: m  reason: collision with root package name */
        private int f14050m;

        /* renamed from: n  reason: collision with root package name */
        private char f14051n;

        /* renamed from: o  reason: collision with root package name */
        private int f14052o;

        /* renamed from: p  reason: collision with root package name */
        private char f14053p;

        /* renamed from: q  reason: collision with root package name */
        private int f14054q;

        /* renamed from: r  reason: collision with root package name */
        private int f14055r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f14056s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f14057t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f14058u;

        /* renamed from: v  reason: collision with root package name */
        private int f14059v;

        /* renamed from: w  reason: collision with root package name */
        private int f14060w;

        /* renamed from: x  reason: collision with root package name */
        private String f14061x;

        /* renamed from: y  reason: collision with root package name */
        private String f14062y;

        /* renamed from: z  reason: collision with root package name */
        private String f14063z;

        public b(Menu menu) {
            this.f14038a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.mContext.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w(SupportMenuInflater.LOG_TAG, "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z10;
            MenuItem enabled = menuItem.setChecked(this.f14056s).setVisible(this.f14057t).setEnabled(this.f14058u);
            boolean z11 = false;
            if (this.f14055r >= 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            enabled.setCheckable(z10).setTitleCondensed(this.f14049l).setIcon(this.f14050m);
            int i10 = this.f14059v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f14063z != null) {
                if (!SupportMenuInflater.this.mContext.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(SupportMenuInflater.this.getRealOwner(), this.f14063z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f14055r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            String str = this.f14061x;
            if (str != null) {
                menuItem.setActionView((View) e(str, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionViewConstructorArguments));
                z11 = true;
            }
            int i11 = this.f14060w;
            if (i11 > 0) {
                if (!z11) {
                    menuItem.setActionView(i11);
                } else {
                    Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.B);
            MenuItemCompat.setTooltipText(menuItem, this.C);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.f14051n, this.f14052o);
            MenuItemCompat.setNumericShortcut(menuItem, this.f14053p, this.f14054q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f14045h = true;
            i(this.f14038a.add(this.f14039b, this.f14046i, this.f14047j, this.f14048k));
        }

        public SubMenu b() {
            this.f14045h = true;
            SubMenu addSubMenu = this.f14038a.addSubMenu(this.f14039b, this.f14046i, this.f14047j, this.f14048k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f14045h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = SupportMenuInflater.this.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f14039b = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f14040c = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f14041d = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f14042e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f14043f = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f14044g = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            boolean z10;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(SupportMenuInflater.this.mContext, attributeSet, R.styleable.MenuItem);
            this.f14046i = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_id, 0);
            this.f14047j = (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_menuCategory, this.f14040c) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes.getInt(R.styleable.MenuItem_android_orderInCategory, this.f14041d) & 65535);
            this.f14048k = obtainStyledAttributes.getText(R.styleable.MenuItem_android_title);
            this.f14049l = obtainStyledAttributes.getText(R.styleable.MenuItem_android_titleCondensed);
            this.f14050m = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_android_icon, 0);
            this.f14051n = c(obtainStyledAttributes.getString(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f14052o = obtainStyledAttributes.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f14053p = c(obtainStyledAttributes.getString(R.styleable.MenuItem_android_numericShortcut));
            this.f14054q = obtainStyledAttributes.getInt(R.styleable.MenuItem_numericModifiers, 4096);
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_android_checkable)) {
                this.f14055r = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f14055r = this.f14042e;
            }
            this.f14056s = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_checked, false);
            this.f14057t = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_visible, this.f14043f);
            this.f14058u = obtainStyledAttributes.getBoolean(R.styleable.MenuItem_android_enabled, this.f14044g);
            this.f14059v = obtainStyledAttributes.getInt(R.styleable.MenuItem_showAsAction, -1);
            this.f14063z = obtainStyledAttributes.getString(R.styleable.MenuItem_android_onClick);
            this.f14060w = obtainStyledAttributes.getResourceId(R.styleable.MenuItem_actionLayout, 0);
            this.f14061x = obtainStyledAttributes.getString(R.styleable.MenuItem_actionViewClass);
            String string = obtainStyledAttributes.getString(R.styleable.MenuItem_actionProviderClass);
            this.f14062y = string;
            if (string != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && this.f14060w == 0 && this.f14061x == null) {
                this.A = (ActionProvider) e(string, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, SupportMenuInflater.this.mActionProviderConstructorArguments);
            } else {
                if (z10) {
                    Log.w(SupportMenuInflater.LOG_TAG, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = obtainStyledAttributes.getText(R.styleable.MenuItem_contentDescription);
            this.C = obtainStyledAttributes.getText(R.styleable.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTintMode)) {
                this.E = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (obtainStyledAttributes.hasValue(R.styleable.MenuItem_iconTint)) {
                this.D = obtainStyledAttributes.getColorStateList(R.styleable.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            obtainStyledAttributes.recycle();
            this.f14045h = false;
        }

        public void h() {
            this.f14039b = 0;
            this.f14040c = 0;
            this.f14041d = 0;
            this.f14042e = 0;
            this.f14043f = true;
            this.f14044g = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            r2 = 0
            r0[r2] = r1
            ACTION_VIEW_CONSTRUCTOR_SIGNATURE = r0
            ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.SupportMenuInflater.<clinit>():void");
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        Object[] objArr = {context};
        this.mActionViewConstructorArguments = objArr;
        this.mActionProviderConstructorArguments = objArr;
    }

    private Object findRealOwner(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return findRealOwner(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    private void parseMenu(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals(XML_MENU)) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        boolean z10 = false;
        boolean z11 = false;
        String str = null;
        while (!z10) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z11 && name2.equals(str)) {
                            z11 = false;
                            str = null;
                        } else if (name2.equals(XML_GROUP)) {
                            bVar.h();
                        } else if (name2.equals(XML_ITEM)) {
                            if (!bVar.d()) {
                                ActionProvider actionProvider = bVar.A;
                                if (actionProvider == null || !actionProvider.hasSubMenu()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals(XML_MENU)) {
                            z10 = true;
                        }
                    }
                } else if (!z11) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals(XML_GROUP)) {
                        bVar.f(attributeSet);
                    } else if (name3.equals(XML_ITEM)) {
                        bVar.g(attributeSet);
                    } else if (name3.equals(XML_MENU)) {
                        parseMenu(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z11 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object getRealOwner() {
        if (this.mRealOwner == null) {
            this.mRealOwner = findRealOwner(this.mContext);
        }
        return this.mRealOwner;
    }

    public void inflate(@LayoutRes int i10, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.mContext.getResources().getLayout(i10);
            parseMenu(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e10) {
            throw new InflateException("Error inflating menu XML", e10);
        } catch (IOException e11) {
            throw new InflateException("Error inflating menu XML", e11);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
