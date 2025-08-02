package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray<a> mStateList = new SparseArray<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f14767a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList f14768b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        int f14769c = -1;

        /* renamed from: d  reason: collision with root package name */
        ConstraintSet f14770d;

        public a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.State_android_id) {
                    this.f14767a = obtainStyledAttributes.getResourceId(index, this.f14767a);
                } else if (index == R.styleable.State_constraints) {
                    this.f14769c = obtainStyledAttributes.getResourceId(index, this.f14769c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f14769c);
                    context.getResources().getResourceName(this.f14769c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f14770d = constraintSet;
                        constraintSet.clone(context, this.f14769c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f14768b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f14768b.size(); i10++) {
                if (((b) this.f14768b.get(i10)).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        float f14771a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f14772b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f14773c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f14774d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        int f14775e = -1;

        /* renamed from: f  reason: collision with root package name */
        ConstraintSet f14776f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Variant_constraints) {
                    this.f14775e = obtainStyledAttributes.getResourceId(index, this.f14775e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f14775e);
                    context.getResources().getResourceName(this.f14775e);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f14776f = constraintSet;
                        constraintSet.clone(context, this.f14775e);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f14774d = obtainStyledAttributes.getDimension(index, this.f14774d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f14772b = obtainStyledAttributes.getDimension(index, this.f14772b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f14773c = obtainStyledAttributes.getDimension(index, this.f14773c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f14771a = obtainStyledAttributes.getDimension(index, this.f14771a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f14771a) && f10 < this.f14771a) {
                return false;
            }
            if (!Float.isNaN(this.f14772b) && f11 < this.f14772b) {
                return false;
            }
            if (!Float.isNaN(this.f14773c) && f10 > this.f14773c) {
                return false;
            }
            if (Float.isNaN(this.f14774d) || f11 <= this.f14774d) {
                return true;
            }
            return false;
        }
    }

    ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i10) {
        this.mConstraintLayout = constraintLayout;
        load(context, i10);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            r1 = 0
        L_0x000d:
            r2 = 1
            if (r0 == r2) goto L_0x00ab
            if (r0 == 0) goto L_0x009b
            r3 = 2
            if (r0 == r3) goto L_0x0017
            goto L_0x009e
        L_0x0017:
            java.lang.String r0 = r9.getName()     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            int r4 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L_0x0053;
                case 80204913: goto L_0x0049;
                case 1382829617: goto L_0x003f;
                case 1657696882: goto L_0x0035;
                case 1901439077: goto L_0x0025;
                default: goto L_0x0024;
            }     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
        L_0x0024:
            goto L_0x005d
        L_0x0025:
            java.lang.String r4 = "Variant"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            if (r4 == 0) goto L_0x005d
            r4 = r6
            goto L_0x005e
        L_0x002f:
            r8 = move-exception
            goto L_0x00a4
        L_0x0032:
            r8 = move-exception
            goto L_0x00a8
        L_0x0035:
            java.lang.String r4 = "layoutDescription"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            if (r4 == 0) goto L_0x005d
            r4 = 0
            goto L_0x005e
        L_0x003f:
            java.lang.String r4 = "StateSet"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            if (r4 == 0) goto L_0x005d
            r4 = r2
            goto L_0x005e
        L_0x0049:
            java.lang.String r4 = "State"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            if (r4 == 0) goto L_0x005d
            r4 = r3
            goto L_0x005e
        L_0x0053:
            java.lang.String r4 = "ConstraintSet"
            boolean r4 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            if (r4 == 0) goto L_0x005d
            r4 = r5
            goto L_0x005e
        L_0x005d:
            r4 = -1
        L_0x005e:
            if (r4 == 0) goto L_0x009e
            if (r4 == r2) goto L_0x009e
            if (r4 == r3) goto L_0x008e
            if (r4 == r6) goto L_0x0083
            if (r4 == r5) goto L_0x007f
            java.lang.String r2 = "ConstraintLayoutStates"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            java.lang.String r4 = "unknown tag "
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            r3.append(r0)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            java.lang.String r0 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            android.util.Log.v(r2, r0)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            goto L_0x009e
        L_0x007f:
            r7.parseConstraintSet(r8, r9)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            goto L_0x009e
        L_0x0083:
            androidx.constraintlayout.widget.ConstraintLayoutStates$b r0 = new androidx.constraintlayout.widget.ConstraintLayoutStates$b     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            r0.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            if (r1 == 0) goto L_0x009e
            r1.a(r0)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            goto L_0x009e
        L_0x008e:
            androidx.constraintlayout.widget.ConstraintLayoutStates$a r1 = new androidx.constraintlayout.widget.ConstraintLayoutStates$a     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            r1.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintLayoutStates$a> r0 = r7.mStateList     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            int r2 = r1.f14767a     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            r0.put(r2, r1)     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            goto L_0x009e
        L_0x009b:
            r9.getName()     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
        L_0x009e:
            int r0 = r9.next()     // Catch:{ XmlPullParserException -> 0x0032, IOException -> 0x002f }
            goto L_0x000d
        L_0x00a4:
            r8.printStackTrace()
            goto L_0x00ab
        L_0x00a8:
            r8.printStackTrace()
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.load(android.content.Context, int):void");
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        int i10;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            if ("id".equals(xmlPullParser.getAttributeName(i11))) {
                String attributeValue = xmlPullParser.getAttributeValue(i11);
                if (attributeValue.contains(DomExceptionUtils.SEPARATOR)) {
                    i10 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i10 = -1;
                }
                if (i10 == -1) {
                    if (attributeValue.length() > 1) {
                        i10 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.load(context, xmlPullParser);
                this.mConstraintSetMap.put(i10, constraintSet);
                return;
            }
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
        if ((i12 == -1 || !((b) aVar.f14768b.get(i12)).a(f10, f11)) && this.mCurrentConstraintNumber != aVar.b(f10, f11)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public void updateConstraints(int i10, float f10, float f11) {
        ConstraintSet constraintSet;
        int i11;
        a aVar;
        int b10;
        ConstraintSet constraintSet2;
        int i12;
        int i13 = this.mCurrentStateId;
        if (i13 == i10) {
            if (i10 == -1) {
                aVar = this.mStateList.valueAt(0);
            } else {
                aVar = this.mStateList.get(i13);
            }
            int i14 = this.mCurrentConstraintNumber;
            if ((i14 == -1 || !((b) aVar.f14768b.get(i14)).a(f10, f11)) && this.mCurrentConstraintNumber != (b10 = aVar.b(f10, f11))) {
                if (b10 == -1) {
                    constraintSet2 = this.mDefaultConstraintSet;
                } else {
                    constraintSet2 = ((b) aVar.f14768b.get(b10)).f14776f;
                }
                if (b10 == -1) {
                    i12 = aVar.f14769c;
                } else {
                    i12 = ((b) aVar.f14768b.get(b10)).f14775e;
                }
                if (constraintSet2 != null) {
                    this.mCurrentConstraintNumber = b10;
                    ConstraintsChangedListener constraintsChangedListener = this.mConstraintsChangedListener;
                    if (constraintsChangedListener != null) {
                        constraintsChangedListener.preLayoutChange(-1, i12);
                    }
                    constraintSet2.applyTo(this.mConstraintLayout);
                    ConstraintsChangedListener constraintsChangedListener2 = this.mConstraintsChangedListener;
                    if (constraintsChangedListener2 != null) {
                        constraintsChangedListener2.postLayoutChange(-1, i12);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.mCurrentStateId = i10;
        a aVar2 = this.mStateList.get(i10);
        int b11 = aVar2.b(f10, f11);
        if (b11 == -1) {
            constraintSet = aVar2.f14770d;
        } else {
            constraintSet = ((b) aVar2.f14768b.get(b11)).f14776f;
        }
        if (b11 == -1) {
            i11 = aVar2.f14769c;
        } else {
            i11 = ((b) aVar2.f14768b.get(b11)).f14775e;
        }
        if (constraintSet == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i10 + ", dim =" + f10 + ", " + f11);
            return;
        }
        this.mCurrentConstraintNumber = b11;
        ConstraintsChangedListener constraintsChangedListener3 = this.mConstraintsChangedListener;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.preLayoutChange(i10, i11);
        }
        constraintSet.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener constraintsChangedListener4 = this.mConstraintsChangedListener;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.postLayoutChange(i10, i11);
        }
    }
}
