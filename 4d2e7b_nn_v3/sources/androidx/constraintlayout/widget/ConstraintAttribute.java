package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14756a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType[] r0 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14756a = r0
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14756a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14756a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.INT_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14756a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f14756a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.STRING_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f14756a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.BOOLEAN_TYPE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f14756a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.DIMENSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintAttribute.a.<clinit>():void");
        }
    }

    public ConstraintAttribute(String str, AttributeType attributeType) {
        this.mName = str;
        this.mType = attributeType;
    }

    private static int clamp(int i10) {
        int i11 = (i10 & (~(i10 >> 31))) - 255;
        return (i11 & (i11 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(next);
            try {
                if (next.equals("BackgroundColor")) {
                    hashMap2.put(next, new ConstraintAttribute(constraintAttribute, (Object) Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(next, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + next, (Class[]) null).invoke(view, (Object[]) null)));
                }
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void parse(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    string = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    attributeType = AttributeType.INT_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    attributeType = AttributeType.STRING_TYPE;
                    string = obtainStyledAttributes.getString(index);
                }
                Object obj2 = string;
                attributeType2 = attributeType;
                obj = obj2;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj));
        }
        obtainStyledAttributes.recycle();
    }

    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> hashMap) {
        Class<?> cls = view.getClass();
        for (String next : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(next);
            String str = "set" + next;
            try {
                switch (a.f14756a[constraintAttribute.mType.ordinal()]) {
                    case 1:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.mColorValue)});
                        break;
                    case 2:
                        Method method = cls.getMethod(str, new Class[]{Drawable.class});
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.mColorValue);
                        method.invoke(view, new Object[]{colorDrawable});
                        break;
                    case 3:
                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(view, new Object[]{Integer.valueOf(constraintAttribute.mIntegerValue)});
                        break;
                    case 4:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(constraintAttribute.mFloatValue)});
                        break;
                    case 5:
                        cls.getMethod(str, new Class[]{CharSequence.class}).invoke(view, new Object[]{constraintAttribute.mStringValue});
                        break;
                    case 6:
                        cls.getMethod(str, new Class[]{Boolean.TYPE}).invoke(view, new Object[]{Boolean.valueOf(constraintAttribute.mBooleanValue)});
                        break;
                    case 7:
                        cls.getMethod(str, new Class[]{Float.TYPE}).invoke(view, new Object[]{Float.valueOf(constraintAttribute.mFloatValue)});
                        break;
                }
            } catch (NoSuchMethodException e10) {
                Log.e(TAG, e10.getMessage());
                Log.e(TAG, " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls.getName());
                sb2.append(" must have a method ");
                sb2.append(str);
                Log.e(TAG, sb2.toString());
            } catch (IllegalAccessException e11) {
                Log.e(TAG, " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                Log.e(TAG, " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                e12.printStackTrace();
            }
        }
    }

    public boolean diff(ConstraintAttribute constraintAttribute) {
        AttributeType attributeType;
        if (constraintAttribute == null || (attributeType = this.mType) != constraintAttribute.mType) {
            return false;
        }
        switch (a.f14756a[attributeType.ordinal()]) {
            case 1:
            case 2:
                if (this.mColorValue == constraintAttribute.mColorValue) {
                    return true;
                }
                return false;
            case 3:
                if (this.mIntegerValue == constraintAttribute.mIntegerValue) {
                    return true;
                }
                return false;
            case 4:
                if (this.mFloatValue == constraintAttribute.mFloatValue) {
                    return true;
                }
                return false;
            case 5:
                if (this.mIntegerValue == constraintAttribute.mIntegerValue) {
                    return true;
                }
                return false;
            case 6:
                if (this.mBooleanValue == constraintAttribute.mBooleanValue) {
                    return true;
                }
                return false;
            case 7:
                if (this.mFloatValue == constraintAttribute.mFloatValue) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (a.f14756a[this.mType.ordinal()]) {
            case 1:
            case 2:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 3:
                return (float) this.mIntegerValue;
            case 4:
                return this.mFloatValue;
            case 5:
                throw new RuntimeException("Cannot interpolate String");
            case 6:
                if (this.mBooleanValue) {
                    return 0.0f;
                }
                return 1.0f;
            case 7:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        float f10;
        switch (a.f14756a[this.mType.ordinal()]) {
            case 1:
            case 2:
                int i10 = this.mColorValue;
                float pow = (float) Math.pow((double) (((float) ((i10 >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i10 >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i10 & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i10 >> 24) & 255)) / 255.0f;
                return;
            case 3:
                fArr[0] = (float) this.mIntegerValue;
                return;
            case 4:
                fArr[0] = this.mFloatValue;
                return;
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                if (this.mBooleanValue) {
                    f10 = 0.0f;
                } else {
                    f10 = 1.0f;
                }
                fArr[0] = f10;
                return;
            case 7:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public int noOfInterpValues() {
        int i10 = a.f14756a[this.mType.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return 4;
        }
        return 1;
    }

    public void setColorValue(int i10) {
        this.mColorValue = i10;
    }

    public void setFloatValue(float f10) {
        this.mFloatValue = f10;
    }

    public void setIntValue(int i10) {
        this.mIntegerValue = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0126, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0128, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0183, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0054, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0054 A[Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }, ExcHandler: InvocationTargetException (r0v5 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE, Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }]), Splitter:B:1:0x0023] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInterpolatedValue(android.view.View r17, float[] r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r0 = 0
            r3 = 1
            java.lang.String r4 = "\""
            java.lang.String r5 = "on View \""
            java.lang.String r6 = "TransitionLayout"
            java.lang.Class r7 = r17.getClass()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "set"
            r8.append(r9)
            java.lang.String r9 = r1.mName
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            int[] r9 = androidx.constraintlayout.widget.ConstraintAttribute.a.f14756a     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r10 = r1.mType     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            int r10 = r10.ordinal()     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9 = r9[r10]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r10 = 3
            r11 = 2
            r12 = 4601859982876761367(0x3fdd1745d1745d17, double:0.45454545454545453)
            r14 = 1132396544(0x437f0000, float:255.0)
            switch(r9) {
                case 1: goto L_0x012b;
                case 2: goto L_0x00cd;
                case 3: goto L_0x00b3;
                case 4: goto L_0x009a;
                case 5: goto L_0x0081;
                case 6: goto L_0x005f;
                case 7: goto L_0x003b;
                default: goto L_0x0039;
            }     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
        L_0x0039:
            goto L_0x01d0
        L_0x003b:
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Class r10 = java.lang.Float.TYPE     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9[r0] = r10     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9 = r18[r0]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r3[r0] = r9     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r7.invoke(r2, r3)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            goto L_0x01d0
        L_0x0054:
            r0 = move-exception
            goto L_0x0183
        L_0x0057:
            r0 = move-exception
            r9 = r4
            goto L_0x0187
        L_0x005b:
            r0 = move-exception
            r9 = r4
            goto L_0x01ac
        L_0x005f:
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9[r0] = r10     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9 = r18[r0]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r10 = 1056964608(0x3f000000, float:0.5)
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0073
            r9 = r3
            goto L_0x0074
        L_0x0073:
            r9 = r0
        L_0x0074:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r3[r0] = r9     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r7.invoke(r2, r3)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            goto L_0x01d0
        L_0x0081:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r3.<init>()     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.String r7 = "unable to interpolate strings "
            r3.append(r7)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.String r7 = r1.mName     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r3.append(r7)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.String r3 = r3.toString()     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r0.<init>(r3)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            throw r0     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
        L_0x009a:
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Class r10 = java.lang.Float.TYPE     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9[r0] = r10     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9 = r18[r0]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r3[r0] = r9     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r7.invoke(r2, r3)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            goto L_0x01d0
        L_0x00b3:
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9[r0] = r10     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9 = r18[r0]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            int r9 = (int) r9     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r3[r0] = r9     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r7.invoke(r2, r3)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            goto L_0x01d0
        L_0x00cd:
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.Class<android.graphics.drawable.Drawable> r15 = android.graphics.drawable.Drawable.class
            r9[r0] = r15     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9 = r18[r0]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            double r0 = (double) r9     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            double r0 = java.lang.Math.pow(r0, r12)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            float r0 = (float) r0     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            float r0 = r0 * r14
            int r0 = (int) r0     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            int r0 = clamp(r0)     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r1 = r18[r3]     // Catch:{ NoSuchMethodException -> 0x005b, IllegalAccessException -> 0x0057, InvocationTargetException -> 0x0054 }
            r9 = r4
            double r3 = (double) r1
            double r3 = java.lang.Math.pow(r3, r12)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r1 = (float) r3     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r1 = r1 * r14
            int r1 = (int) r1     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            int r1 = clamp(r1)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r3 = r18[r11]     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            double r3 = (double) r3     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            double r3 = java.lang.Math.pow(r3, r12)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r3 = (float) r3     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r3 = r3 * r14
            int r3 = (int) r3     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            int r3 = clamp(r3)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r4 = r18[r10]     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r4 = r4 * r14
            int r4 = (int) r4     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            int r4 = clamp(r4)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            int r4 = r4 << 24
            int r0 = r0 << 16
            r0 = r0 | r4
            int r1 = r1 << 8
            r0 = r0 | r1
            r0 = r0 | r3
            android.graphics.drawable.ColorDrawable r1 = new android.graphics.drawable.ColorDrawable     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r1.<init>()     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r1.setColor(r0)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r3 = 0
            r0[r3] = r1     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r7.invoke(r2, r0)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            goto L_0x01d0
        L_0x0126:
            r0 = move-exception
            goto L_0x0187
        L_0x0128:
            r0 = move-exception
            goto L_0x01ac
        L_0x012b:
            r0 = r3
            r9 = r4
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r3 = 0
            r1[r3] = r0     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            java.lang.reflect.Method r0 = r7.getMethod(r8, r1)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r1 = r18[r3]     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            double r3 = (double) r1     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            double r3 = java.lang.Math.pow(r3, r12)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r1 = (float) r3     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r1 = r1 * r14
            int r1 = (int) r1     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            int r1 = clamp(r1)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r3 = 1
            r4 = r18[r3]     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            double r3 = (double) r4     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            double r3 = java.lang.Math.pow(r3, r12)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r3 = (float) r3     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r3 = r3 * r14
            int r3 = (int) r3     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            int r3 = clamp(r3)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r4 = r18[r11]     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            double r10 = (double) r4     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            double r10 = java.lang.Math.pow(r10, r12)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r4 = (float) r10     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r4 = r4 * r14
            int r4 = (int) r4     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            int r4 = clamp(r4)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r7 = 3
            r7 = r18[r7]     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            float r7 = r7 * r14
            int r7 = (int) r7     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            int r7 = clamp(r7)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            int r7 = r7 << 24
            int r1 = r1 << 16
            r1 = r1 | r7
            int r3 = r3 << 8
            r1 = r1 | r3
            r1 = r1 | r4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r4 = 0
            r3[r4] = r1     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            r0.invoke(r2, r3)     // Catch:{ NoSuchMethodException -> 0x0128, IllegalAccessException -> 0x0126, InvocationTargetException -> 0x0054 }
            goto L_0x01d0
        L_0x0183:
            r0.printStackTrace()
            goto L_0x01d0
        L_0x0187:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "cannot access method "
            r1.append(r3)
            r1.append(r8)
            r1.append(r5)
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getName(r17)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r6, r1)
            r0.printStackTrace()
            goto L_0x01d0
        L_0x01ac:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "no method "
            r1.append(r3)
            r1.append(r8)
            r1.append(r5)
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getName(r17)
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r6, r1)
            r0.printStackTrace()
        L_0x01d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintAttribute.setInterpolatedValue(android.view.View, float[]):void");
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        boolean z10 = false;
        switch (a.f14756a[this.mType.ordinal()]) {
            case 1:
            case 2:
                int HSVToColor = Color.HSVToColor(fArr);
                this.mColorValue = HSVToColor;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (HSVToColor & ViewCompat.MEASURED_SIZE_MASK);
                return;
            case 3:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 4:
                this.mFloatValue = fArr[0];
                return;
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                if (((double) fArr[0]) > 0.5d) {
                    z10 = true;
                }
                this.mBooleanValue = z10;
                return;
            case 7:
                this.mFloatValue = fArr[0];
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj) {
        this.mName = str;
        this.mType = attributeType;
        setValue(obj);
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.mName = constraintAttribute.mName;
        this.mType = constraintAttribute.mType;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (a.f14756a[this.mType.ordinal()]) {
            case 1:
            case 2:
                this.mColorValue = ((Integer) obj).intValue();
                return;
            case 3:
                this.mIntegerValue = ((Integer) obj).intValue();
                return;
            case 4:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            case 5:
                this.mStringValue = (String) obj;
                return;
            case 6:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                return;
            case 7:
                this.mFloatValue = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }
}
