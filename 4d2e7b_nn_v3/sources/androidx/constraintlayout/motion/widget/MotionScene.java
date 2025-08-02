package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.adjust.sdk.Constants;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class MotionScene {
    static final int ANTICIPATE = 4;
    static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private boolean DEBUG_DESKTOP = false;
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    /* access modifiers changed from: private */
    public SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    Transition mCurrentTransition = null;
    /* access modifiers changed from: private */
    public int mDefaultDuration = Constants.MINIMAL_ERROR_STATUS_CODE;
    private Transition mDefaultTransition = null;
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean mDisableAutoTransition = false;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    /* access modifiers changed from: private */
    public int mLayoutDuringTransition = 0;
    /* access modifiers changed from: private */
    public final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion = false;
    private boolean mRtl;
    StateSet mStateSet = null;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private MotionLayout.MotionTracker mVelocityTracker;

    class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Easing f14619a;

        a(Easing easing) {
            this.f14619a = easing;
        }

        public float getInterpolation(float f10) {
            return (float) this.f14619a.get((double) f10);
        }
    }

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private int getId(Context context, String str) {
        int i10;
        if (str.contains(DomExceptionUtils.SEPARATOR)) {
            i10 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                System.out.println("id getMap res = " + i10);
            }
        } else {
            i10 = -1;
        }
        if (i10 != -1) {
            return i10;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e(TAG, "error in parsing id");
        return i10;
    }

    private int getIndex(Transition transition) {
        int access$300 = transition.mId;
        if (access$300 != -1) {
            for (int i10 = 0; i10 < this.mTransitionList.size(); i10++) {
                if (this.mTransitionList.get(i10).mId == access$300) {
                    return i10;
                }
            }
            return -1;
        }
        throw new IllegalArgumentException("The transition must have an id");
    }

    private int getRealID(int i10) {
        int stateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        if (stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i10, -1, -1)) == -1) {
            return i10;
        }
        return stateGetConstraintID;
    }

    private boolean hasCycleDependency(int i10) {
        int i11 = this.mDeriveMap.get(i10);
        int size = this.mDeriveMap.size();
        while (i11 > 0) {
            if (i11 == i10) {
                return true;
            }
            int i12 = size - 1;
            if (size < 0) {
                return true;
            }
            i11 = this.mDeriveMap.get(i11);
            size = i12;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        if (this.mVelocityTracker != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r0 = r0.getXml(r10)
            int r1 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r2 = 0
        L_0x000d:
            r3 = 1
            if (r1 == r3) goto L_0x0154
            if (r1 == 0) goto L_0x0144
            r4 = 2
            if (r1 == r4) goto L_0x0017
            goto L_0x0147
        L_0x0017:
            java.lang.String r1 = r0.getName()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            boolean r5 = r8.DEBUG_DESKTOP     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r5 == 0) goto L_0x003c
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r7 = "parsing = "
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r6.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r6 = r6.toString()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r5.println(r6)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x003c
        L_0x0036:
            r9 = move-exception
            goto L_0x014d
        L_0x0039:
            r9 = move-exception
            goto L_0x0151
        L_0x003c:
            int r5 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r6 = -1
            java.lang.String r7 = "MotionScene"
            switch(r5) {
                case -1349929691: goto L_0x0080;
                case -1239391468: goto L_0x0076;
                case 269306229: goto L_0x006d;
                case 312750793: goto L_0x0063;
                case 327855227: goto L_0x0059;
                case 793277014: goto L_0x0051;
                case 1382829617: goto L_0x0047;
                default: goto L_0x0046;
            }
        L_0x0046:
            goto L_0x008a
        L_0x0047:
            java.lang.String r3 = "StateSet"
            boolean r3 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r3 == 0) goto L_0x008a
            r3 = 4
            goto L_0x008b
        L_0x0051:
            boolean r3 = r1.equals(r7)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r3 == 0) goto L_0x008a
            r3 = 0
            goto L_0x008b
        L_0x0059:
            java.lang.String r3 = "OnSwipe"
            boolean r3 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r3 == 0) goto L_0x008a
            r3 = r4
            goto L_0x008b
        L_0x0063:
            java.lang.String r3 = "OnClick"
            boolean r3 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r3 == 0) goto L_0x008a
            r3 = 3
            goto L_0x008b
        L_0x006d:
            java.lang.String r4 = "Transition"
            boolean r4 = r1.equals(r4)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r4 == 0) goto L_0x008a
            goto L_0x008b
        L_0x0076:
            java.lang.String r3 = "KeyFrameSet"
            boolean r3 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r3 == 0) goto L_0x008a
            r3 = 6
            goto L_0x008b
        L_0x0080:
            java.lang.String r3 = "ConstraintSet"
            boolean r3 = r1.equals(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r3 == 0) goto L_0x008a
            r3 = 5
            goto L_0x008b
        L_0x008a:
            r3 = r6
        L_0x008b:
            switch(r3) {
                case 0: goto L_0x0140;
                case 1: goto L_0x00ff;
                case 2: goto L_0x00c5;
                case 3: goto L_0x00c0;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00b2;
                case 6: goto L_0x00a4;
                default: goto L_0x008e;
            }     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x008e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r3.<init>()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r4 = "WARNING UNKNOWN ATTRIBUTE "
            r3.append(r4)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r3.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = r3.toString()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            android.util.Log.v(r7, r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x0147
        L_0x00a4:
            androidx.constraintlayout.motion.widget.KeyFrames r1 = new androidx.constraintlayout.motion.widget.KeyFrames     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.util.ArrayList r3 = r2.mKeyFramesList     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r3.add(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x0147
        L_0x00b2:
            r8.parseConstraintSet(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x0147
        L_0x00b7:
            androidx.constraintlayout.widget.StateSet r1 = new androidx.constraintlayout.widget.StateSet     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r8.mStateSet = r1     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x0147
        L_0x00c0:
            r2.addOnClick(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x0147
        L_0x00c5:
            if (r2 != 0) goto L_0x00f4
            android.content.res.Resources r1 = r9.getResources()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = r1.getResourceEntryName(r10)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            int r3 = r0.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r4.<init>()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r5 = " OnSwipe ("
            r4.append(r5)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = ".xml:"
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r4.append(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = ")"
            r4.append(r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            java.lang.String r1 = r4.toString()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            android.util.Log.v(r7, r1)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x00f4:
            androidx.constraintlayout.motion.widget.d r1 = new androidx.constraintlayout.motion.widget.d     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.MotionLayout r3 = r8.mMotionLayout     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.<init>(r9, r3, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.d unused = r2.mTouchResponse = r1     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x0147
        L_0x00ff:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r1 = r8.mTransitionList     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = new androidx.constraintlayout.motion.widget.MotionScene$Transition     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r2.<init>(r8, r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r8.mCurrentTransition     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 != 0) goto L_0x0126
            boolean r1 = r2.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 != 0) goto L_0x0126
            r8.mCurrentTransition = r2     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.d r1 = r2.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x0126
            androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = r8.mCurrentTransition     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            androidx.constraintlayout.motion.widget.d r1 = r1.mTouchResponse     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            boolean r3 = r8.mRtl     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.p(r3)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x0126:
            boolean r1 = r2.mIsAbstract     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 == 0) goto L_0x0147
            int r1 = r2.mConstraintSetEnd     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            if (r1 != r6) goto L_0x0135
            r8.mDefaultTransition = r2     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x013a
        L_0x0135:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r1 = r8.mAbstractTransitionList     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.add(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x013a:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r1 = r8.mTransitionList     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            r1.remove(r2)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x0147
        L_0x0140:
            r8.parseMotionSceneTags(r9, r0)     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x0147
        L_0x0144:
            r0.getName()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
        L_0x0147:
            int r1 = r0.next()     // Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0036 }
            goto L_0x000d
        L_0x014d:
            r9.printStackTrace()
            goto L_0x0154
        L_0x0151:
            r9.printStackTrace()
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.load(android.content.Context, int):void");
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.setForceId(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < attributeCount; i12++) {
            String attributeName = xmlPullParser.getAttributeName(i12);
            String attributeValue = xmlPullParser.getAttributeValue(i12);
            if (this.DEBUG_DESKTOP) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            if (attributeName.equals("deriveConstraintsFrom")) {
                i11 = getId(context, attributeValue);
            } else if (attributeName.equals("id")) {
                i10 = getId(context, attributeValue);
                this.mConstraintSetIdMap.put(stripID(attributeValue), Integer.valueOf(i10));
            }
        }
        if (i10 != -1) {
            if (this.mMotionLayout.mDebugPath != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlPullParser);
            if (i11 != -1) {
                this.mDeriveMap.put(i10, i11);
            }
            this.mConstraintSetMap.put(i10, constraintSet);
        }
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i10) {
        int i11 = this.mDeriveMap.get(i10);
        if (i11 > 0) {
            readConstraintChain(this.mDeriveMap.get(i10));
            ConstraintSet constraintSet = this.mConstraintSetMap.get(i10);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i11);
            if (constraintSet2 == null) {
                Log.e(TAG, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), i11));
                return;
            }
            constraintSet.readFallback(constraintSet2);
            this.mDeriveMap.put(i10, -1);
        }
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i10) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mOnClicks.size() > 0) {
                Iterator it2 = next.mOnClicks.iterator();
                while (it2.hasNext()) {
                    ((Transition.a) it2.next()).c(motionLayout);
                }
            }
        }
        Iterator<Transition> it3 = this.mAbstractTransitionList.iterator();
        while (it3.hasNext()) {
            Transition next2 = it3.next();
            if (next2.mOnClicks.size() > 0) {
                Iterator it4 = next2.mOnClicks.iterator();
                while (it4.hasNext()) {
                    ((Transition.a) it4.next()).c(motionLayout);
                }
            }
        }
        Iterator<Transition> it5 = this.mTransitionList.iterator();
        while (it5.hasNext()) {
            Transition next3 = it5.next();
            if (next3.mOnClicks.size() > 0) {
                Iterator it6 = next3.mOnClicks.iterator();
                while (it6.hasNext()) {
                    ((Transition.a) it6.next()).a(motionLayout, i10, next3);
                }
            }
        }
        Iterator<Transition> it7 = this.mAbstractTransitionList.iterator();
        while (it7.hasNext()) {
            Transition next4 = it7.next();
            if (next4.mOnClicks.size() > 0) {
                Iterator it8 = next4.mOnClicks.iterator();
                while (it8.hasNext()) {
                    ((Transition.a) it8.next()).a(motionLayout, i10, next4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean autoTransition(MotionLayout motionLayout, int i10) {
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mAutoTransition != 0) {
                if (i10 == next.mConstraintSetStart && (next.mAutoTransition == 4 || next.mAutoTransition == 2)) {
                    MotionLayout.h hVar = MotionLayout.h.FINISHED;
                    motionLayout.setState(hVar);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.h.SETUP);
                        motionLayout.setState(MotionLayout.h.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.h.SETUP);
                        motionLayout.setState(MotionLayout.h.MOVING);
                        motionLayout.setState(hVar);
                    }
                    return true;
                } else if (i10 == next.mConstraintSetEnd && (next.mAutoTransition == 3 || next.mAutoTransition == 1)) {
                    MotionLayout.h hVar2 = MotionLayout.h.FINISHED;
                    motionLayout.setState(hVar2);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.h.SETUP);
                        motionLayout.setState(MotionLayout.h.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.h.SETUP);
                        motionLayout.setState(MotionLayout.h.MOVING);
                        motionLayout.setState(hVar2);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i10, float f10, float f11, MotionEvent motionEvent) {
        RectF j10;
        float f12;
        if (i10 == -1) {
            return this.mCurrentTransition;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i10);
        RectF rectF = new RectF();
        float f13 = 0.0f;
        Transition transition = null;
        for (Transition next : transitionsWithState) {
            if (!next.mDisable && next.mTouchResponse != null) {
                next.mTouchResponse.p(this.mRtl);
                RectF j11 = next.mTouchResponse.j(this.mMotionLayout, rectF);
                if ((j11 == null || motionEvent == null || j11.contains(motionEvent.getX(), motionEvent.getY())) && ((j10 = next.mTouchResponse.j(this.mMotionLayout, rectF)) == null || motionEvent == null || j10.contains(motionEvent.getX(), motionEvent.getY()))) {
                    float a10 = next.mTouchResponse.a(f10, f11);
                    if (next.mConstraintSetEnd == i10) {
                        f12 = -1.0f;
                    } else {
                        f12 = 1.1f;
                    }
                    float f14 = a10 * f12;
                    if (f14 > f13) {
                        transition = next;
                        f13 = f14;
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z10) {
        this.mDisableAutoTransition = z10;
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        if (this.DEBUG_DESKTOP) {
            PrintStream printStream = System.out;
            printStream.println("id " + str);
            printStream.println("size " + this.mConstraintSetMap.size());
        }
        for (int i10 = 0; i10 < this.mConstraintSetMap.size(); i10++) {
            int keyAt = this.mConstraintSetMap.keyAt(i10);
            String resourceName = context.getResources().getResourceName(keyAt);
            if (this.DEBUG_DESKTOP) {
                PrintStream printStream2 = System.out;
                printStream2.println("Id for <" + i10 + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.mConstraintSetMap.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.mConstraintSetMap.keyAt(i10);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mDuration;
        }
        return this.mDefaultDuration;
    }

    /* access modifiers changed from: package-private */
    public int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public Interpolator getInterpolator() {
        int access$1400 = this.mCurrentTransition.mDefaultInterpolator;
        if (access$1400 == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
        }
        if (access$1400 == -1) {
            return new a(Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString));
        }
        if (access$1400 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (access$1400 == 1) {
            return new AccelerateInterpolator();
        }
        if (access$1400 == 2) {
            return new DecelerateInterpolator();
        }
        if (access$1400 == 4) {
            return new AnticipateInterpolator();
        }
        if (access$1400 != 5) {
            return null;
        }
        return new BounceInterpolator();
    }

    /* access modifiers changed from: package-private */
    public Key getKeyFrame(Context context, int i10, int i11, int i12) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            Iterator<Integer> it2 = keyFrames.getKeys().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Integer next = it2.next();
                    if (i11 == next.intValue()) {
                        Iterator<Key> it3 = keyFrames.getKeyFramesForView(next.intValue()).iterator();
                        while (it3.hasNext()) {
                            Key next2 = it3.next();
                            if (next2.mFramePosition == i12 && next2.mType == i10) {
                                return next2;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                Iterator it = transition2.mKeyFramesList.iterator();
                while (it.hasNext()) {
                    ((KeyFrames) it.next()).addFrames(motionController);
                }
                return;
            }
            return;
        }
        Iterator it2 = transition.mKeyFramesList.iterator();
        while (it2.hasNext()) {
            ((KeyFrames) it2.next()).addFrames(motionController);
        }
    }

    /* access modifiers changed from: package-private */
    public float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.f();
    }

    /* access modifiers changed from: package-private */
    public float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.g();
    }

    /* access modifiers changed from: package-private */
    public boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return this.mCurrentTransition.mTouchResponse.h();
    }

    public float getPathPercent(View view, int i10) {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getProgressDirection(float f10, float f11) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.i(f10, f11);
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    public Transition getTransitionById(int i10) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mId == i10) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getTransitionDirection(int i10) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mConstraintSetStart == i10) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i10) {
        int realID = getRealID(i10);
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mConstraintSetStart == realID || next.mConstraintSetEnd == realID) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public boolean hasKeyFramePosition(View view, int i10) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().mFramePosition == i10) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int lookUpConstraintId(String str) {
        return this.mConstraintSetIdMap.get(str).intValue();
    }

    public String lookUpConstraintName(int i10) {
        for (Map.Entry next : this.mConstraintSetIdMap.entrySet()) {
            if (((Integer) next.getValue()).intValue() == i10) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    /* access modifiers changed from: package-private */
    public void processScrollMove(float f10, float f11) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.m(f10, f11);
        }
    }

    /* access modifiers changed from: package-private */
    public void processScrollUp(float f10, float f11) {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.n(f10, f11);
        }
    }

    /* access modifiers changed from: package-private */
    public void processTouchEvent(MotionEvent motionEvent, int i10, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i10 != -1) {
            int action = motionEvent.getAction();
            boolean z10 = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                if (this.mCurrentTransition.mTouchResponse != null) {
                    RectF e10 = this.mCurrentTransition.mTouchResponse.e(this.mMotionLayout, rectF);
                    if (e10 == null || e10.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        RectF j10 = this.mCurrentTransition.mTouchResponse.j(this.mMotionLayout, rectF);
                        if (j10 == null || j10.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            this.mMotionOutsideRegion = false;
                        } else {
                            this.mMotionOutsideRegion = true;
                        }
                        this.mCurrentTransition.mTouchResponse.o(this.mLastTouchX, this.mLastTouchY);
                        return;
                    }
                    this.mLastTouchDown = null;
                    return;
                }
                return;
            } else if (action == 2) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((((double) rawX) != 0.0d || ((double) rawY) != 0.0d) && (motionEvent2 = this.mLastTouchDown) != null) {
                    Transition bestTransitionFor = bestTransitionFor(i10, rawX, rawY, motionEvent2);
                    if (bestTransitionFor != null) {
                        motionLayout.setTransition(bestTransitionFor);
                        RectF j11 = this.mCurrentTransition.mTouchResponse.j(this.mMotionLayout, rectF);
                        if (j11 != null && !j11.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                            z10 = true;
                        }
                        this.mMotionOutsideRegion = z10;
                        this.mCurrentTransition.mTouchResponse.q(this.mLastTouchX, this.mLastTouchY);
                    }
                } else {
                    return;
                }
            }
        }
        Transition transition = this.mCurrentTransition;
        if (!(transition == null || transition.mTouchResponse == null || this.mMotionOutsideRegion)) {
            this.mCurrentTransition.mTouchResponse.l(motionEvent, this.mVelocityTracker, i10, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() == 1 && (motionTracker = this.mVelocityTracker) != null) {
            motionTracker.recycle();
            this.mVelocityTracker = null;
            int i11 = motionLayout.mCurrentState;
            if (i11 != -1) {
                autoTransition(motionLayout, i11);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void readFallback(MotionLayout motionLayout) {
        int i10 = 0;
        while (i10 < this.mConstraintSetMap.size()) {
            int keyAt = this.mConstraintSetMap.keyAt(i10);
            if (hasCycleDependency(keyAt)) {
                Log.e(TAG, "Cannot be derived from yourself");
                return;
            } else {
                readConstraintChain(keyAt);
                i10++;
            }
        }
        for (int i11 = 0; i11 < this.mConstraintSetMap.size(); i11++) {
            this.mConstraintSetMap.valueAt(i11).readFallback((ConstraintLayout) motionLayout);
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i10, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i10, constraintSet);
    }

    public void setDuration(int i10) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i10);
        } else {
            this.mDefaultDuration = i10;
        }
    }

    public void setKeyframe(View view, int i10, String str, Object obj) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            Iterator it = transition.mKeyFramesList.iterator();
            while (it.hasNext()) {
                Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
                while (it2.hasNext()) {
                    if (it2.next().mFramePosition == i10) {
                        if (obj != null) {
                            Float f10 = (Float) obj;
                        }
                        str.equalsIgnoreCase("app:PerpendicularPath_percent");
                    }
                }
            }
        }
    }

    public void setRtl(boolean z10) {
        this.mRtl = z10;
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.p(this.mRtl);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if (r2 != -1) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTransition(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.StateSet r0 = r6.mStateSet
            r1 = -1
            if (r0 == 0) goto L_0x0018
            int r0 = r0.stateGetConstraintID(r7, r1, r1)
            if (r0 == r1) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r0 = r7
        L_0x000d:
            androidx.constraintlayout.widget.StateSet r2 = r6.mStateSet
            int r2 = r2.stateGetConstraintID(r8, r1, r1)
            if (r2 == r1) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            r2 = r8
            goto L_0x001a
        L_0x0018:
            r0 = r7
            goto L_0x0016
        L_0x001a:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mTransitionList
            java.util.Iterator r3 = r3.iterator()
        L_0x0020:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.mConstraintSetEnd
            if (r5 != r2) goto L_0x0038
            int r5 = r4.mConstraintSetStart
            if (r5 == r0) goto L_0x0044
        L_0x0038:
            int r5 = r4.mConstraintSetEnd
            if (r5 != r8) goto L_0x0020
            int r5 = r4.mConstraintSetStart
            if (r5 != r7) goto L_0x0020
        L_0x0044:
            r6.mCurrentTransition = r4
            if (r4 == 0) goto L_0x0059
            androidx.constraintlayout.motion.widget.d r7 = r4.mTouchResponse
            if (r7 == 0) goto L_0x0059
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.mCurrentTransition
            androidx.constraintlayout.motion.widget.d r7 = r7.mTouchResponse
            boolean r8 = r6.mRtl
            r7.p(r8)
        L_0x0059:
            return
        L_0x005a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.mDefaultTransition
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mAbstractTransitionList
            java.util.Iterator r3 = r3.iterator()
        L_0x0062:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0076
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = r4.mConstraintSetEnd
            if (r5 != r8) goto L_0x0062
            r7 = r4
            goto L_0x0062
        L_0x0076:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r8.<init>(r6, r7)
            int unused = r8.mConstraintSetStart = r0
            int unused = r8.mConstraintSetEnd = r2
            if (r0 == r1) goto L_0x0088
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r7 = r6.mTransitionList
            r7.add(r8)
        L_0x0088:
            r6.mCurrentTransition = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.setTransition(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.r();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean supportTouch() {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mTouchResponse != null) {
                return true;
            }
        }
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        if (motionLayout == this.mMotionLayout && motionLayout.mScene == this) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public ConstraintSet getConstraintSet(int i10) {
        return getConstraintSet(i10, -1, -1);
    }

    /* access modifiers changed from: package-private */
    public ConstraintSet getConstraintSet(int i10, int i11, int i12) {
        int stateGetConstraintID;
        if (this.DEBUG_DESKTOP) {
            PrintStream printStream = System.out;
            printStream.println("id " + i10);
            printStream.println("size " + this.mConstraintSetMap.size());
        }
        StateSet stateSet = this.mStateSet;
        if (!(stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i10, i11, i12)) == -1)) {
            i10 = stateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i10) != null) {
            return this.mConstraintSetMap.get(i10);
        }
        Log.e(TAG, "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), i10) + " In MotionScene");
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    MotionScene(Context context, MotionLayout motionLayout, int i10) {
        this.mMotionLayout = motionLayout;
        load(context, i10);
        this.mConstraintSetMap.put(R.id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition != null && transition.mTouchResponse != null) {
            this.mCurrentTransition.mTouchResponse.p(this.mRtl);
        }
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        /* access modifiers changed from: private */
        public int mAutoTransition = 0;
        /* access modifiers changed from: private */
        public int mConstraintSetEnd = -1;
        /* access modifiers changed from: private */
        public int mConstraintSetStart = -1;
        /* access modifiers changed from: private */
        public int mDefaultInterpolator = 0;
        /* access modifiers changed from: private */
        public int mDefaultInterpolatorID = -1;
        /* access modifiers changed from: private */
        public String mDefaultInterpolatorString = null;
        /* access modifiers changed from: private */
        public boolean mDisable = false;
        /* access modifiers changed from: private */
        public int mDuration = Constants.MINIMAL_ERROR_STATUS_CODE;
        /* access modifiers changed from: private */
        public int mId = -1;
        /* access modifiers changed from: private */
        public boolean mIsAbstract = false;
        /* access modifiers changed from: private */
        public ArrayList<KeyFrames> mKeyFramesList = new ArrayList<>();
        private int mLayoutDuringTransition = 0;
        /* access modifiers changed from: private */
        public final MotionScene mMotionScene;
        /* access modifiers changed from: private */
        public ArrayList<a> mOnClicks = new ArrayList<>();
        /* access modifiers changed from: private */
        public int mPathMotionArc = -1;
        /* access modifiers changed from: private */
        public float mStagger = 0.0f;
        /* access modifiers changed from: private */
        public d mTouchResponse = null;
        private int mTransitionFlags = 0;

        static class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            private final Transition f14616a;

            /* renamed from: b  reason: collision with root package name */
            int f14617b = -1;

            /* renamed from: c  reason: collision with root package name */
            int f14618c = 17;

            public a(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.f14616a = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i10 = 0; i10 < indexCount; i10++) {
                    int index = obtainStyledAttributes.getIndex(i10);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f14617b = obtainStyledAttributes.getResourceId(index, this.f14617b);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.f14618c = obtainStyledAttributes.getInt(index, this.f14618c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i10, Transition transition) {
                boolean z10;
                boolean z11;
                boolean z12;
                boolean z13;
                int i11 = this.f14617b;
                View view = motionLayout;
                if (i11 != -1) {
                    view = motionLayout.findViewById(i11);
                }
                if (view == null) {
                    Log.e(MotionScene.TAG, "OnClick could not find id " + this.f14617b);
                    return;
                }
                int access$100 = transition.mConstraintSetStart;
                int access$000 = transition.mConstraintSetEnd;
                if (access$100 == -1) {
                    view.setOnClickListener(this);
                    return;
                }
                int i12 = this.f14618c;
                boolean z14 = false;
                if ((i12 & 1) == 0 || i10 != access$100) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if ((i12 & 256) == 0 || i10 != access$100) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                boolean z15 = z10 | z11;
                if ((i12 & 1) == 0 || i10 != access$100) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                boolean z16 = z12 | z15;
                if ((i12 & 16) == 0 || i10 != access$000) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                boolean z17 = z16 | z13;
                if ((i12 & 4096) != 0 && i10 == access$000) {
                    z14 = true;
                }
                if (z17 || z14) {
                    view.setOnClickListener(this);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean b(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.f14616a;
                if (transition2 == transition) {
                    return true;
                }
                int access$000 = transition2.mConstraintSetEnd;
                int access$100 = this.f14616a.mConstraintSetStart;
                if (access$100 != -1) {
                    int i10 = motionLayout.mCurrentState;
                    if (i10 == access$100 || i10 == access$000) {
                        return true;
                    }
                    return false;
                } else if (motionLayout.mCurrentState != access$000) {
                    return true;
                } else {
                    return false;
                }
            }

            public void c(MotionLayout motionLayout) {
                int i10 = this.f14617b;
                if (i10 != -1) {
                    View findViewById = motionLayout.findViewById(i10);
                    if (findViewById == null) {
                        Log.e(MotionScene.TAG, " (*)  could not find id " + this.f14617b);
                        return;
                    }
                    findViewById.setOnClickListener((View.OnClickListener) null);
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
            /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r8) {
                /*
                    r7 = this;
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = r7.f14616a
                    androidx.constraintlayout.motion.widget.MotionScene r8 = r8.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionLayout r8 = r8.mMotionLayout
                    boolean r0 = r8.isInteractionEnabled()
                    if (r0 != 0) goto L_0x0011
                    return
                L_0x0011:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f14616a
                    int r0 = r0.mConstraintSetStart
                    r1 = -1
                    if (r0 != r1) goto L_0x004a
                    int r0 = r8.getCurrentState()
                    if (r0 != r1) goto L_0x002a
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f14616a
                    int r0 = r0.mConstraintSetEnd
                    r8.transitionToState(r0)
                    return
                L_0x002a:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r1 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r2 = r7.f14616a
                    androidx.constraintlayout.motion.widget.MotionScene r2 = r2.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r7.f14616a
                    r1.<init>(r2, r3)
                    int unused = r1.mConstraintSetStart = r0
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f14616a
                    int r0 = r0.mConstraintSetEnd
                    int unused = r1.mConstraintSetEnd = r0
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r1)
                    r8.transitionToEnd()
                    return
                L_0x004a:
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f14616a
                    androidx.constraintlayout.motion.widget.MotionScene r0 = r0.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r0.mCurrentTransition
                    int r1 = r7.f14618c
                    r2 = r1 & 1
                    r3 = 0
                    r4 = 1
                    if (r2 != 0) goto L_0x0061
                    r2 = r1 & 256(0x100, float:3.59E-43)
                    if (r2 == 0) goto L_0x005f
                    goto L_0x0061
                L_0x005f:
                    r2 = r3
                    goto L_0x0062
                L_0x0061:
                    r2 = r4
                L_0x0062:
                    r5 = r1 & 16
                    if (r5 != 0) goto L_0x006d
                    r1 = r1 & 4096(0x1000, float:5.74E-42)
                    if (r1 == 0) goto L_0x006b
                    goto L_0x006d
                L_0x006b:
                    r1 = r3
                    goto L_0x006e
                L_0x006d:
                    r1 = r4
                L_0x006e:
                    if (r2 == 0) goto L_0x0097
                    if (r1 == 0) goto L_0x0097
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r7.f14616a
                    androidx.constraintlayout.motion.widget.MotionScene r5 = r5.mMotionScene
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r5 = r5.mCurrentTransition
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = r7.f14616a
                    if (r5 == r6) goto L_0x0081
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r6)
                L_0x0081:
                    int r5 = r8.getCurrentState()
                    int r6 = r8.getEndState()
                    if (r5 == r6) goto L_0x0098
                    float r5 = r8.getProgress()
                    r6 = 1056964608(0x3f000000, float:0.5)
                    int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                    if (r5 <= 0) goto L_0x0096
                    goto L_0x0098
                L_0x0096:
                    r1 = r3
                L_0x0097:
                    r3 = r2
                L_0x0098:
                    boolean r0 = r7.b(r0, r8)
                    if (r0 == 0) goto L_0x00e3
                    if (r3 == 0) goto L_0x00ae
                    int r0 = r7.f14618c
                    r0 = r0 & r4
                    if (r0 == 0) goto L_0x00ae
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f14616a
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r8.transitionToEnd()
                    goto L_0x00e3
                L_0x00ae:
                    if (r1 == 0) goto L_0x00bf
                    int r0 = r7.f14618c
                    r0 = r0 & 16
                    if (r0 == 0) goto L_0x00bf
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f14616a
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r8.transitionToStart()
                    goto L_0x00e3
                L_0x00bf:
                    if (r3 == 0) goto L_0x00d2
                    int r0 = r7.f14618c
                    r0 = r0 & 256(0x100, float:3.59E-43)
                    if (r0 == 0) goto L_0x00d2
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f14616a
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r0 = 1065353216(0x3f800000, float:1.0)
                    r8.setProgress(r0)
                    goto L_0x00e3
                L_0x00d2:
                    if (r1 == 0) goto L_0x00e3
                    int r0 = r7.f14618c
                    r0 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r0 == 0) goto L_0x00e3
                    androidx.constraintlayout.motion.widget.MotionScene$Transition r0 = r7.f14616a
                    r8.setTransition((androidx.constraintlayout.motion.widget.MotionScene.Transition) r0)
                    r0 = 0
                    r8.setProgress(r0)
                L_0x00e3:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.Transition.a.onClick(android.view.View):void");
            }
        }

        Transition(MotionScene motionScene, Transition transition) {
            this.mMotionScene = motionScene;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, this.mConstraintSetEnd);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i11 == 3) {
                        String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string.indexOf(DomExceptionUtils.SEPARATOR) > 0) {
                            this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                            this.mDefaultInterpolator = -2;
                        } else {
                            this.mDefaultInterpolator = -1;
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    this.mDuration = typedArray.getInt(index, this.mDuration);
                } else if (index == R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            fill(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new a(context, this, xmlPullParser));
        }

        public String debugString(Context context) {
            String str;
            if (this.mConstraintSetStart == -1) {
                str = "null";
            } else {
                str = context.getResources().getResourceEntryName(this.mConstraintSetStart);
            }
            if (this.mConstraintSetEnd == -1) {
                return str + " -> null";
            }
            return str + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<a> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public d getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i10) {
            if ((i10 & this.mTransitionFlags) != 0) {
                return true;
            }
            return false;
        }

        public void setDuration(int i10) {
            this.mDuration = i10;
        }

        public void setEnable(boolean z10) {
            this.mDisable = !z10;
        }

        public void setPathMotionArc(int i10) {
            this.mPathMotionArc = i10;
        }

        public void setStagger(float f10) {
            this.mStagger = f10;
        }

        public Transition(int i10, MotionScene motionScene, int i11, int i12) {
            this.mId = i10;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i11;
            this.mConstraintSetEnd = i12;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
