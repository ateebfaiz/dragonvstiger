package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {
    NestedScrollView A;
    private int B = 0;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I = -1;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q = 0;
    Handler R;
    private final View.OnClickListener S = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f13847a;

    /* renamed from: b  reason: collision with root package name */
    final AppCompatDialog f13848b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f13849c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13850d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f13851e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f13852f;

    /* renamed from: g  reason: collision with root package name */
    ListView f13853g;

    /* renamed from: h  reason: collision with root package name */
    private View f13854h;

    /* renamed from: i  reason: collision with root package name */
    private int f13855i;

    /* renamed from: j  reason: collision with root package name */
    private int f13856j;

    /* renamed from: k  reason: collision with root package name */
    private int f13857k;

    /* renamed from: l  reason: collision with root package name */
    private int f13858l;

    /* renamed from: m  reason: collision with root package name */
    private int f13859m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13860n = false;

    /* renamed from: o  reason: collision with root package name */
    Button f13861o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f13862p;

    /* renamed from: q  reason: collision with root package name */
    Message f13863q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f13864r;

    /* renamed from: s  reason: collision with root package name */
    Button f13865s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f13866t;

    /* renamed from: u  reason: collision with root package name */
    Message f13867u;

    /* renamed from: v  reason: collision with root package name */
    private Drawable f13868v;

    /* renamed from: w  reason: collision with root package name */
    Button f13869w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f13870x;

    /* renamed from: y  reason: collision with root package name */
    Message f13871y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f13872z;

    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem = -1;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId = 0;
        public int mIconId = 0;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure = true;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified = false;
        public int mViewSpacingTop;

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        class a extends ArrayAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecycleListView f13873a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f13873a = recycleListView;
            }

            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = AlertParams.this.mCheckedItems;
                if (zArr != null && zArr[i10]) {
                    this.f13873a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        class b extends CursorAdapter {

            /* renamed from: a  reason: collision with root package name */
            private final int f13875a;

            /* renamed from: b  reason: collision with root package name */
            private final int f13876b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ RecycleListView f13877c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ AlertController f13878d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f13877c = recycleListView;
                this.f13878d = alertController;
                Cursor cursor2 = getCursor();
                this.f13875a = cursor2.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                this.f13876b = cursor2.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f13875a));
                RecycleListView recycleListView = this.f13877c;
                int position = cursor.getPosition();
                boolean z10 = true;
                if (cursor.getInt(this.f13876b) != 1) {
                    z10 = false;
                }
                recycleListView.setItemChecked(position, z10);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return AlertParams.this.mInflater.inflate(this.f13878d.M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AlertController f13880a;

            c(AlertController alertController) {
                this.f13880a = alertController;
            }

            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                AlertParams.this.mOnClickListener.onClick(this.f13880a.f13848b, i10);
                if (!AlertParams.this.mIsSingleChoice) {
                    this.f13880a.f13848b.dismiss();
                }
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecycleListView f13882a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AlertController f13883b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f13882a = recycleListView;
                this.f13883b = alertController;
            }

            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                boolean[] zArr = AlertParams.this.mCheckedItems;
                if (zArr != null) {
                    zArr[i10] = this.f13882a.isItemChecked(i10);
                }
                AlertParams.this.mOnCheckboxClickListener.onClick(this.f13883b.f13848b, i10, this.f13882a.isItemChecked(i10));
            }
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r8v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r8v3 */
        /* JADX WARNING: type inference failed for: r8v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v23, types: [androidx.appcompat.app.AlertController$AlertParams$b] */
        /* JADX WARNING: type inference failed for: r1v24, types: [androidx.appcompat.app.AlertController$AlertParams$a] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void createListView(androidx.appcompat.app.AlertController r10) {
            /*
                r9 = this;
                android.view.LayoutInflater r0 = r9.mInflater
                int r1 = r10.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r9.mIsMultiChoice
                if (r1 == 0) goto L_0x0034
                android.database.Cursor r1 = r9.mCursor
                if (r1 != 0) goto L_0x0025
                androidx.appcompat.app.AlertController$AlertParams$a r8 = new androidx.appcompat.app.AlertController$AlertParams$a
                android.content.Context r3 = r9.mContext
                int r4 = r10.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r9.mItems
                r1 = r8
                r2 = r9
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0069
            L_0x0025:
                androidx.appcompat.app.AlertController$AlertParams$b r8 = new androidx.appcompat.app.AlertController$AlertParams$b
                android.content.Context r3 = r9.mContext
                android.database.Cursor r4 = r9.mCursor
                r5 = 0
                r1 = r8
                r2 = r9
                r6 = r0
                r7 = r10
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0069
            L_0x0034:
                boolean r1 = r9.mIsSingleChoice
                if (r1 == 0) goto L_0x003c
                int r1 = r10.N
            L_0x003a:
                r4 = r1
                goto L_0x003f
            L_0x003c:
                int r1 = r10.O
                goto L_0x003a
            L_0x003f:
                android.database.Cursor r1 = r9.mCursor
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005b
                android.widget.SimpleCursorAdapter r8 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r9.mContext
                android.database.Cursor r5 = r9.mCursor
                java.lang.String r1 = r9.mLabelColumn
                java.lang.String[] r6 = new java.lang.String[]{r1}
                int[] r7 = new int[]{r2}
                r2 = r8
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x0069
            L_0x005b:
                android.widget.ListAdapter r8 = r9.mAdapter
                if (r8 == 0) goto L_0x0060
                goto L_0x0069
            L_0x0060:
                androidx.appcompat.app.AlertController$c r8 = new androidx.appcompat.app.AlertController$c
                android.content.Context r1 = r9.mContext
                java.lang.CharSequence[] r3 = r9.mItems
                r8.<init>(r1, r4, r2, r3)
            L_0x0069:
                androidx.appcompat.app.AlertController$AlertParams$OnPrepareListViewListener r1 = r9.mOnPrepareListViewListener
                if (r1 == 0) goto L_0x0070
                r1.onPrepareListView(r0)
            L_0x0070:
                r10.H = r8
                int r1 = r9.mCheckedItem
                r10.I = r1
                android.content.DialogInterface$OnClickListener r1 = r9.mOnClickListener
                if (r1 == 0) goto L_0x0083
                androidx.appcompat.app.AlertController$AlertParams$c r1 = new androidx.appcompat.app.AlertController$AlertParams$c
                r1.<init>(r10)
                r0.setOnItemClickListener(r1)
                goto L_0x008f
            L_0x0083:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r9.mOnCheckboxClickListener
                if (r1 == 0) goto L_0x008f
                androidx.appcompat.app.AlertController$AlertParams$d r1 = new androidx.appcompat.app.AlertController$AlertParams$d
                r1.<init>(r0, r10)
                r0.setOnItemClickListener(r1)
            L_0x008f:
                android.widget.AdapterView$OnItemSelectedListener r1 = r9.mOnItemSelectedListener
                if (r1 == 0) goto L_0x0096
                r0.setOnItemSelectedListener(r1)
            L_0x0096:
                boolean r1 = r9.mIsSingleChoice
                if (r1 == 0) goto L_0x009f
                r1 = 1
                r0.setChoiceMode(r1)
                goto L_0x00a7
            L_0x009f:
                boolean r1 = r9.mIsMultiChoice
                if (r1 == 0) goto L_0x00a7
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a7:
                r10.f13853g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.AlertParams.createListView(androidx.appcompat.app.AlertController):void");
        }

        public void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.m(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.r(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.o(drawable);
                }
                int i10 = this.mIconId;
                if (i10 != 0) {
                    alertController.n(i10);
                }
                int i11 = this.mIconAttrId;
                if (i11 != 0) {
                    alertController.n(alertController.d(i11));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.p(charSequence2);
            }
            CharSequence charSequence3 = this.mPositiveButtonText;
            if (!(charSequence3 == null && this.mPositiveButtonIcon == null)) {
                alertController.k(-1, charSequence3, this.mPositiveButtonListener, (Message) null, this.mPositiveButtonIcon);
            }
            CharSequence charSequence4 = this.mNegativeButtonText;
            if (!(charSequence4 == null && this.mNegativeButtonIcon == null)) {
                alertController.k(-2, charSequence4, this.mNegativeButtonListener, (Message) null, this.mNegativeButtonIcon);
            }
            CharSequence charSequence5 = this.mNeutralButtonText;
            if (!(charSequence5 == null && this.mNeutralButtonIcon == null)) {
                alertController.k(-3, charSequence5, this.mNeutralButtonListener, (Message) null, this.mNeutralButtonIcon);
            }
            if (!(this.mItems == null && this.mCursor == null && this.mAdapter == null)) {
                createListView(alertController);
            }
            View view2 = this.mView;
            if (view2 == null) {
                int i12 = this.mViewLayoutResId;
                if (i12 != 0) {
                    alertController.s(i12);
                }
            } else if (this.mViewSpacingSpecified) {
                alertController.u(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            } else {
                alertController.t(view2);
            }
        }
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public void setHasDecor(boolean z10, boolean z11) {
            int i10;
            int i11;
            if (!z11 || !z10) {
                int paddingLeft = getPaddingLeft();
                if (z10) {
                    i10 = getPaddingTop();
                } else {
                    i10 = this.mPaddingTopNoTitle;
                }
                int paddingRight = getPaddingRight();
                if (z11) {
                    i11 = getPaddingBottom();
                } else {
                    i11 = this.mPaddingBottomNoButtons;
                }
                setPadding(paddingLeft, i10, paddingRight, i11);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f13861o && (message4 = alertController.f13863q) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f13865s && (message3 = alertController.f13867u) != null) {
                message = Message.obtain(message3);
            } else if (view != alertController.f13869w || (message2 = alertController.f13871y) == null) {
                message = null;
            } else {
                message = Message.obtain(message2);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f13848b).sendToTarget();
        }
    }

    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference f13886a;

        public b(DialogInterface dialogInterface) {
            this.f13886a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f13886a.get(), message.what);
            } else if (i10 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class c extends ArrayAdapter {
        public c(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f13847a = context;
        this.f13848b = appCompatDialog;
        this.f13849c = window;
        this.R = new b(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f13850d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    private static boolean A(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i10 = this.K;
        if (i10 == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i10;
        }
        return this.J;
    }

    private void q(ViewGroup viewGroup, View view, int i10, int i11) {
        View findViewById = this.f13849c.findViewById(R.id.scrollIndicatorUp);
        View findViewById2 = this.f13849c.findViewById(R.id.scrollIndicatorDown);
        ViewCompat.setScrollIndicators(view, i10, i11);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void v(ViewGroup viewGroup) {
        boolean z10;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f13861o = button;
        button.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f13862p) || this.f13864r != null) {
            this.f13861o.setText(this.f13862p);
            Drawable drawable = this.f13864r;
            if (drawable != null) {
                int i10 = this.f13850d;
                drawable.setBounds(0, 0, i10, i10);
                this.f13861o.setCompoundDrawables(this.f13864r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f13861o.setVisibility(0);
            z10 = true;
        } else {
            this.f13861o.setVisibility(8);
            z10 = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f13865s = button2;
        button2.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f13866t) || this.f13868v != null) {
            this.f13865s.setText(this.f13866t);
            Drawable drawable2 = this.f13868v;
            if (drawable2 != null) {
                int i11 = this.f13850d;
                drawable2.setBounds(0, 0, i11, i11);
                this.f13865s.setCompoundDrawables(this.f13868v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f13865s.setVisibility(0);
            z10 |= true;
        } else {
            this.f13865s.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f13869w = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f13870x) || this.f13872z != null) {
            this.f13869w.setText(this.f13870x);
            Drawable drawable3 = this.f13872z;
            if (drawable3 != null) {
                int i12 = this.f13850d;
                drawable3.setBounds(0, 0, i12, i12);
                this.f13869w.setCompoundDrawables(this.f13872z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f13869w.setVisibility(0);
            z10 |= true;
        } else {
            this.f13869w.setVisibility(8);
        }
        if (A(this.f13847a)) {
            if (z10) {
                b(this.f13861o);
            } else if (z10) {
                b(this.f13865s);
            } else if (z10) {
                b(this.f13869w);
            }
        }
        if (!z10) {
            viewGroup.setVisibility(8);
        }
    }

    private void w(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f13849c.findViewById(R.id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f13852f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f13853g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f13853g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void x(ViewGroup viewGroup) {
        View view = this.f13854h;
        boolean z10 = false;
        if (view == null) {
            if (this.f13855i != 0) {
                view = LayoutInflater.from(this.f13847a).inflate(this.f13855i, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z10 = true;
        }
        if (!z10 || !a(view)) {
            this.f13849c.setFlags(131072, 131072);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) this.f13849c.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f13860n) {
                frameLayout.setPadding(this.f13856j, this.f13857k, this.f13858l, this.f13859m);
            }
            if (this.f13853g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void y(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f13849c.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f13849c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f13851e)) || !this.P) {
            this.f13849c.findViewById(R.id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f13849c.findViewById(R.id.alertTitle);
        this.E = textView;
        textView.setText(this.f13851e);
        int i10 = this.B;
        if (i10 != 0) {
            this.D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            return;
        }
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }

    private void z() {
        boolean z10;
        boolean z11;
        boolean z12;
        ListAdapter listAdapter;
        View findViewById;
        View view;
        View findViewById2;
        View findViewById3 = this.f13849c.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        x(viewGroup);
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup i10 = i(findViewById7, findViewById4);
        ViewGroup i11 = i(findViewById8, findViewById5);
        ViewGroup i12 = i(findViewById9, findViewById6);
        w(i11);
        v(i12);
        y(i10);
        char c10 = 0;
        if (viewGroup.getVisibility() != 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i10 == null || i10.getVisibility() == 8) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (i12 == null || i12.getVisibility() == 8) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!(z12 || i11 == null || (findViewById2 = i11.findViewById(R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z11) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            if (this.f13852f == null && this.f13853g == null) {
                view = null;
            } else {
                view = i10.findViewById(R.id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(i11 == null || (findViewById = i11.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f13853g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z11, z12);
        }
        if (!z10) {
            View view2 = this.f13853g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z12) {
                    c10 = 2;
                }
                q(i11, view2, z11 | c10 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f13853g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i13 = this.I;
            if (i13 > -1) {
                listView2.setItemChecked(i13, true);
                listView2.setSelection(i13);
            }
        }
    }

    public Button c(int i10) {
        if (i10 == -3) {
            return this.f13869w;
        }
        if (i10 == -2) {
            return this.f13865s;
        }
        if (i10 != -1) {
            return null;
        }
        return this.f13861o;
    }

    public int d(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f13847a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f13853g;
    }

    public void f() {
        this.f13848b.setContentView(j());
        z();
    }

    public boolean g(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        if (nestedScrollView == null || !nestedScrollView.executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        if (nestedScrollView == null || !nestedScrollView.executeKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public void k(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f13870x = charSequence;
            this.f13871y = message;
            this.f13872z = drawable;
        } else if (i10 == -2) {
            this.f13866t = charSequence;
            this.f13867u = message;
            this.f13868v = drawable;
        } else if (i10 == -1) {
            this.f13862p = charSequence;
            this.f13863q = message;
            this.f13864r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void l(int i10) {
        this.Q = i10;
    }

    public void m(View view) {
        this.G = view;
    }

    public void n(int i10) {
        this.C = null;
        this.B = i10;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i10 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void o(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void p(CharSequence charSequence) {
        this.f13852f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(CharSequence charSequence) {
        this.f13851e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(int i10) {
        this.f13854h = null;
        this.f13855i = i10;
        this.f13860n = false;
    }

    public void t(View view) {
        this.f13854h = view;
        this.f13855i = 0;
        this.f13860n = false;
    }

    public void u(View view, int i10, int i11, int i12, int i13) {
        this.f13854h = view;
        this.f13855i = 0;
        this.f13860n = true;
        this.f13856j = i10;
        this.f13857k = i11;
        this.f13858l = i12;
        this.f13859m = i13;
    }
}
