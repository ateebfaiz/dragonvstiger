package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState = -1;
    private SparseArray<a> mStateList = new SparseArray<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f14777a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList f14778b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        int f14779c = -1;

        /* renamed from: d  reason: collision with root package name */
        boolean f14780d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f14780d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.State_android_id) {
                    this.f14777a = obtainStyledAttributes.getResourceId(index, this.f14777a);
                } else if (index == R.styleable.State_constraints) {
                    this.f14779c = obtainStyledAttributes.getResourceId(index, this.f14779c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f14779c);
                    context.getResources().getResourceName(this.f14779c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f14780d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f14778b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f14778b.size(); i10++) {
                if (((b) this.f14778b.get(i10)).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        float f14781a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f14782b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f14783c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f14784d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        int f14785e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f14786f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f14786f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Variant_constraints) {
                    this.f14785e = obtainStyledAttributes.getResourceId(index, this.f14785e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f14785e);
                    context.getResources().getResourceName(this.f14785e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f14786f = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f14784d = obtainStyledAttributes.getDimension(index, this.f14784d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f14782b = obtainStyledAttributes.getDimension(index, this.f14782b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f14783c = obtainStyledAttributes.getDimension(index, this.f14783c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f14781a = obtainStyledAttributes.getDimension(index, this.f14781a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f14781a) && f10 < this.f14781a) {
                return false;
            }
            if (!Float.isNaN(this.f14782b) && f11 < this.f14782b) {
                return false;
            }
            if (!Float.isNaN(this.f14783c) && f10 > this.f14783c) {
                return false;
            }
            if (Float.isNaN(this.f14784d) || f11 <= this.f14784d) {
                return true;
            }
            return false;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            r8 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r10)
            int[] r1 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L_0x0010:
            if (r3 >= r1) goto L_0x0025
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r4 != r5) goto L_0x0022
            int r5 = r8.mDefaultState
            int r4 = r0.getResourceId(r4, r5)
            r8.mDefaultState = r4
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0025:
            int r0 = r10.getEventType()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            r1 = 0
        L_0x002a:
            r3 = 1
            if (r0 == r3) goto L_0x00c4
            if (r0 == 0) goto L_0x00b4
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L_0x004a
            if (r0 == r5) goto L_0x0039
            goto L_0x00b7
        L_0x0039:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            boolean r0 = r4.equals(r0)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            if (r0 == 0) goto L_0x00b7
            return
        L_0x0044:
            r9 = move-exception
            goto L_0x00bd
        L_0x0047:
            r9 = move-exception
            goto L_0x00c1
        L_0x004a:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            int r7 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            switch(r7) {
                case 80204913: goto L_0x0072;
                case 1301459538: goto L_0x0068;
                case 1382829617: goto L_0x0060;
                case 1901439077: goto L_0x0056;
                default: goto L_0x0055;
            }     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
        L_0x0055:
            goto L_0x007c
        L_0x0056:
            java.lang.String r4 = "Variant"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            if (r4 == 0) goto L_0x007c
            r4 = r5
            goto L_0x007d
        L_0x0060:
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            if (r4 == 0) goto L_0x007c
            r4 = r3
            goto L_0x007d
        L_0x0068:
            java.lang.String r4 = "LayoutDescription"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            if (r4 == 0) goto L_0x007c
            r4 = r2
            goto L_0x007d
        L_0x0072:
            java.lang.String r4 = "State"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            if (r4 == 0) goto L_0x007c
            r4 = r6
            goto L_0x007d
        L_0x007c:
            r4 = -1
        L_0x007d:
            if (r4 == 0) goto L_0x00b7
            if (r4 == r3) goto L_0x00b7
            if (r4 == r6) goto L_0x00a7
            if (r4 == r5) goto L_0x009c
            java.lang.String r3 = "ConstraintLayoutStates"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            java.lang.String r5 = "unknown tag "
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            r4.append(r0)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            java.lang.String r0 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            android.util.Log.v(r3, r0)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            goto L_0x00b7
        L_0x009c:
            androidx.constraintlayout.widget.StateSet$b r0 = new androidx.constraintlayout.widget.StateSet$b     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            r0.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            if (r1 == 0) goto L_0x00b7
            r1.a(r0)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            goto L_0x00b7
        L_0x00a7:
            androidx.constraintlayout.widget.StateSet$a r1 = new androidx.constraintlayout.widget.StateSet$a     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            r1.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$a> r0 = r8.mStateList     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            int r3 = r1.f14777a     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            r0.put(r3, r1)     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            goto L_0x00b7
        L_0x00b4:
            r10.getName()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
        L_0x00b7:
            int r0 = r10.next()     // Catch:{ XmlPullParserException -> 0x0047, IOException -> 0x0044 }
            goto L_0x002a
        L_0x00bd:
            r9.printStackTrace()
            goto L_0x00c4
        L_0x00c1:
            r9.printStackTrace()
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int convertToConstraintSet(int i10, int i11, float f10, float f11) {
        a aVar = this.mStateList.get(i11);
        if (aVar == null) {
            return i11;
        }
        if (f10 != -1.0f && f11 != -1.0f) {
            Iterator it = aVar.f14778b.iterator();
            b bVar = null;
            while (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (bVar2.a(f10, f11)) {
                    if (i10 == bVar2.f14785e) {
                        return i10;
                    }
                    bVar = bVar2;
                }
            }
            if (bVar != null) {
                return bVar.f14785e;
            }
            return aVar.f14779c;
        } else if (aVar.f14779c == i10) {
            return i10;
        } else {
            Iterator it2 = aVar.f14778b.iterator();
            while (it2.hasNext()) {
                if (i10 == ((b) it2.next()).f14785e) {
                    return i10;
                }
            }
            return aVar.f14779c;
        }
    }

    public boolean needsToChange(int i10, float f10, float f11) {
        Object obj;
        int i11 = this.mCurrentStateId;
        if (i11 != i10) {
            return true;
        }
        if (i10 == -1) {
            obj = this.mStateList.valueAt(0);
        } else {
            obj = this.mStateList.get(i11);
        }
        a aVar = (a) obj;
        int i12 = this.mCurrentConstraintNumber;
        if ((i12 == -1 || !((b) aVar.f14778b.get(i12)).a(f10, f11)) && this.mCurrentConstraintNumber != aVar.b(f10, f11)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i10, int i11, int i12) {
        return updateConstraints(-1, i10, (float) i11, (float) i12);
    }

    public int updateConstraints(int i10, int i11, float f10, float f11) {
        a aVar;
        int b10;
        if (i10 == i11) {
            if (i11 == -1) {
                aVar = this.mStateList.valueAt(0);
            } else {
                aVar = this.mStateList.get(this.mCurrentStateId);
            }
            if (aVar == null) {
                return -1;
            }
            if ((this.mCurrentConstraintNumber != -1 && ((b) aVar.f14778b.get(i10)).a(f10, f11)) || i10 == (b10 = aVar.b(f10, f11))) {
                return i10;
            }
            if (b10 == -1) {
                return aVar.f14779c;
            }
            return ((b) aVar.f14778b.get(b10)).f14785e;
        }
        a aVar2 = this.mStateList.get(i11);
        if (aVar2 == null) {
            return -1;
        }
        int b11 = aVar2.b(f10, f11);
        if (b11 == -1) {
            return aVar2.f14779c;
        }
        return ((b) aVar2.f14778b.get(b11)).f14785e;
    }
}
