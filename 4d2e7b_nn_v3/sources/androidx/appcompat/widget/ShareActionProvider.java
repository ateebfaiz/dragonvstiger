package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;

public class ShareActionProvider extends ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final Context mContext;
    private int mMaxShownActivityCount = 4;
    private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final b mOnMenuItemClickListener = new b();
    OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    String mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    private class a implements ActivityChooserModel.OnChooseActivityListener {
        a() {
        }

        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.mOnShareTargetSelectedListener;
            if (onShareTargetSelectedListener == null) {
                return false;
            }
            onShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
            return false;
        }
    }

    private class b implements MenuItem.OnMenuItemClickListener {
        b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            Intent b10 = ActivityChooserModel.d(shareActionProvider.mContext, shareActionProvider.mShareHistoryFileName).b(menuItem.getItemId());
            if (b10 == null) {
                return true;
            }
            String action = b10.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.this.updateIntent(b10);
            }
            ShareActionProvider.this.mContext.startActivity(b10);
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.mContext = context;
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener != null) {
            if (this.mOnChooseActivityListener == null) {
                this.mOnChooseActivityListener = new a();
            }
            ActivityChooserModel.d(this.mContext, this.mShareHistoryFileName).q(this.mOnChooseActivityListener);
        }
    }

    public boolean hasSubMenu() {
        return true;
    }

    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.mContext);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.d(this.mContext, this.mShareHistoryFileName));
        }
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel d10 = ActivityChooserModel.d(this.mContext, this.mShareHistoryFileName);
        PackageManager packageManager = this.mContext.getPackageManager();
        int f10 = d10.f();
        int min = Math.min(f10, this.mMaxShownActivityCount);
        for (int i10 = 0; i10 < min; i10++) {
            ResolveInfo e10 = d10.e(i10);
            subMenu.add(0, i10, i10, e10.loadLabel(packageManager)).setIcon(e10.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        }
        if (min < f10) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i11 = 0; i11 < f10; i11++) {
                ResolveInfo e11 = d10.e(i11);
                addSubMenu.add(0, i11, i11, e11.loadLabel(packageManager)).setIcon(e11.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
            }
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.mOnShareTargetSelectedListener = onShareTargetSelectedListener;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String str) {
        this.mShareHistoryFileName = str;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                updateIntent(intent);
            }
        }
        ActivityChooserModel.d(this.mContext, this.mShareHistoryFileName).p(intent);
    }

    /* access modifiers changed from: package-private */
    public void updateIntent(Intent intent) {
        intent.addFlags(134742016);
    }
}
