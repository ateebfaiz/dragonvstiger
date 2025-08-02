package y5;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.pdns.f;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y5.a;

public final class b {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static b f24944d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static Method f24945e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f24946f = new c((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a f24947a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final d f24948b = new d();

    /* renamed from: c  reason: collision with root package name */
    private Method f24949c;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f24950a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f24951b = new a();

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mKeyedTags");
                f24950a = declaredField;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
            } catch (NoSuchFieldException unused) {
            }
        }

        private a() {
        }

        private final JSONObject a(View view) {
            Object obj;
            try {
                if (f24950a == null) {
                    Field declaredField = View.class.getDeclaredField("mKeyedTags");
                    f24950a = declaredField;
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                    }
                }
                Field field = f24950a;
                if (field != null) {
                    obj = field.get(view);
                } else {
                    obj = null;
                }
                if (obj != null) {
                    SparseArray sparseArray = (SparseArray) obj;
                    if (sparseArray.size() <= 0) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int size = sparseArray.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            try {
                                jSONObject.put(c.c(view.getResources(), sparseArray.keyAt(i10)), sparseArray.valueAt(i10));
                            } catch (JSONException unused) {
                            }
                        }
                    } catch (Exception unused2) {
                    }
                    return jSONObject;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.util.SparseArray<*>");
            } catch (Exception unused3) {
                return null;
            }
        }

        public final void b(PrintWriter printWriter, View view) {
            m.f(printWriter, "writer");
            m.f(view, "view");
            c cVar = b.f24946f;
            AccessibilityNodeInfo a10 = cVar.i(view);
            if (a10 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (view instanceof TextView) {
                        ColorStateList textColors = ((TextView) view).getTextColors();
                        m.e(textColors, "view.textColors");
                        jSONObject.put("textColor", textColors.getDefaultColor());
                        jSONObject.put("textSize", (double) ((TextView) view).getTextSize());
                        jSONObject.put("hint", cVar.j(((TextView) view).getHint(), 100));
                    }
                    JSONObject a11 = a(view);
                    if (a11 != null) {
                        jSONObject.put("keyedTags", a11);
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (AccessibilityNodeInfo.AccessibilityAction next : a10.getActionList()) {
                        m.e(next, "action");
                        CharSequence label = next.getLabel();
                        if (label != null) {
                            jSONArray.put(b.f24946f.j((String) label, 50));
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("actions", jSONArray);
                    }
                    c cVar2 = b.f24946f;
                    String b10 = cVar2.j(a10.getContentDescription(), 50);
                    if (b10 != null && b10.length() > 0) {
                        jSONObject.put("content-description", b10);
                    }
                    jSONObject.put("accessibility-focused", a10.isAccessibilityFocused()).put("checkable", a10.isCheckable()).put("checked", a10.isChecked()).put("class-name", cVar2.j(a10.getClassName(), 50)).put("clickable", a10.isClickable()).put("content-invalid", a10.isContentInvalid()).put("dismissable", a10.isDismissable()).put("editable", a10.isEditable()).put("enabled", a10.isEnabled()).put("focusable", a10.isFocusable()).put("focused", a10.isFocused()).put("long-clickable", a10.isLongClickable()).put("multiline", a10.isMultiLine()).put(HintConstants.AUTOFILL_HINT_PASSWORD, a10.isPassword()).put("scrollable", a10.isScrollable()).put("selected", a10.isSelected()).put("visible-to-user", a10.isVisibleToUser());
                    if (Build.VERSION.SDK_INT >= 24) {
                        C0357b.f24952a.a(jSONObject, a10);
                    }
                } catch (Exception e10) {
                    try {
                        jSONObject.put("DUMP-ERROR", b.f24946f.j(e10.getMessage(), 50));
                    } catch (JSONException unused) {
                    }
                }
                printWriter.append(" props=\"").append(jSONObject.toString()).append("\"");
            }
        }
    }

    /* renamed from: y5.b$b  reason: collision with other inner class name */
    private static final class C0357b {

        /* renamed from: a  reason: collision with root package name */
        public static final C0357b f24952a = new C0357b();

        private C0357b() {
        }

        public final void a(JSONObject jSONObject, AccessibilityNodeInfo accessibilityNodeInfo) {
            m.f(jSONObject, "props");
            m.f(accessibilityNodeInfo, "nodeInfo");
            if (Build.VERSION.SDK_INT >= 24) {
                jSONObject.put("context-clickable", accessibilityNodeInfo.isContextClickable()).put("drawing-order", accessibilityNodeInfo.getDrawingOrder()).put("important-for-accessibility", accessibilityNodeInfo.isImportantForAccessibility());
            }
        }
    }

    public static final class c {
        private c() {
        }

        /* access modifiers changed from: private */
        public final AccessibilityNodeInfo i(View view) {
            if (view == null) {
                return null;
            }
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            try {
                view.onInitializeAccessibilityNodeInfo(obtain);
                return obtain;
            } catch (NullPointerException unused) {
                if (obtain != null) {
                    obtain.recycle();
                }
                return null;
            }
        }

        /* access modifiers changed from: private */
        public final String j(CharSequence charSequence, int i10) {
            if (charSequence == null || charSequence.length() == 0) {
                return "";
            }
            String z10 = j.z(j.z(j.z(charSequence.toString(), " \n", " ", false, 4, (Object) null), "\n", " ", false, 4, (Object) null), "\"", "", false, 4, (Object) null);
            if (charSequence.length() <= i10) {
                return z10;
            }
            StringBuilder sb2 = new StringBuilder();
            if (z10 != null) {
                String substring = z10.substring(0, i10);
                m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb2.append(substring);
                sb2.append("...");
                return sb2.toString();
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        private final String k(View view) {
            Object obj;
            if (b.f24945e == null) {
                b.f24945e = view.getClass().getDeclaredMethod("getText", (Class[]) null);
            }
            Method c10 = b.f24945e;
            if (c10 != null) {
                obj = c10.invoke(view, (Object[]) null);
            } else {
                obj = null;
            }
            if (obj != null) {
                return obj.toString();
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final boolean l(String[] strArr, String str) {
            if (strArr == null) {
                return false;
            }
            for (String q10 : strArr) {
                if (j.q(str, q10, true)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean m(View view) {
            for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                if (m.b(cls.getName(), "com.facebook.litho.LithoView")) {
                    return true;
                }
            }
            return false;
        }

        private final void o(PrintWriter printWriter, View view) {
            Object tag = view.getTag();
            if (!(tag instanceof String)) {
                tag = null;
            }
            String str = (String) tag;
            if (str != null && str.length() != 0) {
                printWriter.print(" app:tag/");
                printWriter.print(j(str, 60));
            }
        }

        /* access modifiers changed from: private */
        public final void p(PrintWriter printWriter, View view, int i10, int i11) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            printWriter.print(" ");
            printWriter.print(iArr[0] - i10);
            printWriter.print(",");
            printWriter.print(iArr[1] - i11);
            printWriter.print("-");
            printWriter.print((iArr[0] + view.getWidth()) - i10);
            printWriter.print(",");
            printWriter.print((iArr[1] + view.getHeight()) - i11);
        }

        /* access modifiers changed from: private */
        public final void q(PrintWriter printWriter, View view) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            printWriter.print(" ");
            int visibility = view.getVisibility();
            String str8 = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            String str9 = f.G;
            if (visibility == 0) {
                printWriter.print(str8);
            } else if (visibility == 4) {
                printWriter.print("I");
            } else if (visibility != 8) {
                printWriter.print(str9);
            } else {
                printWriter.print("G");
            }
            String str10 = "F";
            if (view.isFocusable()) {
                str = str10;
            } else {
                str = str9;
            }
            printWriter.print(str);
            if (view.isEnabled()) {
                str2 = ExifInterface.LONGITUDE_EAST;
            } else {
                str2 = str9;
            }
            printWriter.print(str2);
            printWriter.print(str9);
            String str11 = "H";
            if (view.isHorizontalScrollBarEnabled()) {
                str3 = str11;
            } else {
                str3 = str9;
            }
            printWriter.print(str3);
            if (!view.isVerticalScrollBarEnabled()) {
                str8 = str9;
            }
            printWriter.print(str8);
            if (view.isClickable()) {
                str4 = "C";
            } else {
                str4 = str9;
            }
            printWriter.print(str4);
            if (view.isLongClickable()) {
                str5 = "L";
            } else {
                str5 = str9;
            }
            printWriter.print(str5);
            printWriter.print(" ");
            if (!view.isFocused()) {
                str10 = str9;
            }
            printWriter.print(str10);
            if (view.isSelected()) {
                str6 = "S";
            } else {
                str6 = str9;
            }
            printWriter.print(str6);
            if (!view.isHovered()) {
                str11 = str9;
            }
            printWriter.print(str11);
            if (view.isActivated()) {
                str7 = "A";
            } else {
                str7 = str9;
            }
            printWriter.print(str7);
            if (view.isDirty()) {
                str9 = "D";
            }
            printWriter.print(str9);
        }

        /* access modifiers changed from: private */
        public final void r(PrintWriter printWriter, View view) {
            String str;
            try {
                int id2 = view.getId();
                if (id2 == -1) {
                    o(printWriter, view);
                    return;
                }
                printWriter.append(" #");
                printWriter.append(Integer.toHexString(id2));
                Resources resources = view.getResources();
                if (id2 > 0) {
                    if (resources != null) {
                        int i10 = -16777216 & id2;
                        if (i10 == 16777216) {
                            str = f.f17924q;
                        } else if (i10 != 2130706432) {
                            str = resources.getResourcePackageName(id2);
                            m.e(str, "resources.getResourcePackageName(id)");
                        } else {
                            str = "app";
                        }
                        printWriter.print(" ");
                        printWriter.print(str);
                        printWriter.print(":");
                        printWriter.print(resources.getResourceTypeName(id2));
                        printWriter.print(DomExceptionUtils.SEPARATOR);
                        printWriter.print(resources.getResourceEntryName(id2));
                        return;
                    }
                }
                o(printWriter, view);
            } catch (Exception unused) {
                o(printWriter, view);
            }
        }

        /* access modifiers changed from: private */
        public final void s(PrintWriter printWriter, View view) {
            String str;
            String str2;
            Object tag;
            int i10;
            boolean z10;
            try {
                if (view instanceof TextView) {
                    str = ((TextView) view).getText().toString();
                } else if (m.b(view.getClass().getSimpleName(), "RCTextView")) {
                    str = k(view);
                } else {
                    CharSequence contentDescription = view.getContentDescription();
                    if (contentDescription != null) {
                        str2 = contentDescription.toString();
                    } else {
                        str2 = null;
                    }
                    if ((str2 == null || str2.length() == 0) && (tag = view.getTag()) != null) {
                        String obj = tag.toString();
                        int length = obj.length() - 1;
                        int i11 = 0;
                        boolean z11 = false;
                        while (true) {
                            if (i11 > length) {
                                break;
                            }
                            if (!z11) {
                                i10 = i11;
                            } else {
                                i10 = length;
                            }
                            if (m.g(obj.charAt(i10), 32) <= 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (!z11) {
                                if (!z10) {
                                    z11 = true;
                                } else {
                                    i11++;
                                }
                            } else if (!z10) {
                                break;
                            } else {
                                length--;
                            }
                        }
                        str = obj.subSequence(i11, length + 1).toString();
                    } else {
                        str = str2;
                    }
                }
                if (str == null) {
                    return;
                }
                if (str.length() != 0) {
                    printWriter.print(" text=\"");
                    printWriter.print(j(str, 600));
                    printWriter.print("\"");
                }
            } catch (Exception unused) {
            }
        }

        public final boolean n(String str, PrintWriter printWriter, String[] strArr) {
            boolean z10;
            m.f(str, "prefix");
            m.f(printWriter, "writer");
            if (strArr != null) {
                if (strArr.length == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((!z10) && m.b("e2e", strArr[0])) {
                    if (b.f24944d == null) {
                        b.f24944d = new b();
                    }
                    b b10 = b.f24944d;
                    if (b10 != null) {
                        b10.g(str, printWriter, strArr);
                    }
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void f(String str, PrintWriter printWriter, View view, int i10, int i11, boolean z10, boolean z11) {
        ViewGroup viewGroup;
        int childCount;
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        View view2 = view;
        boolean z12 = z11;
        printWriter2.print(str2);
        if (view2 == null) {
            printWriter2.println("null");
            return;
        }
        printWriter2.print(view.getClass().getName());
        printWriter2.print("{");
        printWriter2.print(Integer.toHexString(view.hashCode()));
        c cVar = f24946f;
        cVar.q(printWriter2, view2);
        cVar.p(printWriter2, view2, i10, i11);
        cVar.r(printWriter2, view2);
        cVar.s(printWriter2, view2);
        if (z12) {
            a.f24951b.b(printWriter2, view2);
        }
        printWriter2.println("}");
        if (cVar.m(view2)) {
            h(printWriter2, view2, str2, z12);
        }
        if (z10 && (view2 instanceof WebView)) {
            this.f24948b.c((WebView) view2);
        }
        if ((view2 instanceof ViewGroup) && (childCount = viewGroup.getChildCount()) > 0) {
            String str3 = str2 + "  ";
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            for (int i12 = 0; i12 < childCount; i12++) {
                f(str3, printWriter, (viewGroup = (ViewGroup) view2).getChildAt(i12), iArr[0], iArr[1], z10, z11);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void g(String str, PrintWriter printWriter, String[] strArr) {
        View b10;
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        printWriter2.print(str2);
        printWriter2.println("Top Level Window View Hierarchy:");
        c cVar = f24946f;
        boolean c10 = cVar.l(strArr2, "all-roots");
        boolean c11 = cVar.l(strArr2, "top-root");
        boolean c12 = cVar.l(strArr2, "webview");
        boolean c13 = cVar.l(strArr2, "props");
        try {
            List b11 = this.f24947a.b();
            if (b11 == null) {
                return;
            }
            if (!b11.isEmpty()) {
                Collections.reverse(b11);
                Iterator it = b11.iterator();
                WindowManager.LayoutParams layoutParams = null;
                while (true) {
                    if (it.hasNext()) {
                        a.b bVar = (a.b) it.next();
                        if (!(bVar == null || (b10 = bVar.b()) == null)) {
                            if (b10.getVisibility() == 0) {
                                if (!c10 && layoutParams != null && Math.abs(bVar.a().type - layoutParams.type) != 1) {
                                    break;
                                }
                                f(str2 + "  ", printWriter, bVar.b(), 0, 0, c12, c13);
                                layoutParams = bVar.a();
                                if (c11) {
                                    break;
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
                this.f24948b.b(printWriter2);
            }
        } catch (Exception e10) {
            printWriter2.println("Failure in view hierarchy dump: " + e10.getMessage());
        }
    }

    private final void h(PrintWriter printWriter, View view, String str, boolean z10) {
        try {
            if (this.f24949c == null) {
                Class<?> cls = Class.forName("com.facebook.litho.LithoViewTestHelper");
                m.e(cls, "Class.forName(LITHO_VIEW_TEST_HELPER_CLASS)");
                this.f24949c = cls.getDeclaredMethod("viewToStringForE2E", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            }
            Method method = this.f24949c;
            Object obj = null;
            if (method != null) {
                obj = method.invoke((Object) null, new Object[]{view, Integer.valueOf((str.length() / 2) + 1), Boolean.valueOf(z10)});
            }
            if (obj != null) {
                m.e(printWriter.append((String) obj), "writer.append(lithoViewDump)");
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception e10) {
            printWriter.append(str).append("Failed litho view sub hierarch dump: ").append(f24946f.j(e10.getMessage(), 100)).println();
        }
    }
}
