package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;

public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    public AppCompatDialog(@NonNull Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void addContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    public void dismiss() {
        super.dismiss();
        getDelegate().onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.dispatchKeyEvent(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    @Nullable
    public <T extends View> T findViewById(@IdRes int i10) {
        return getDelegate().findViewById(i10);
    }

    @NonNull
    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.create((Dialog) this, (AppCompatCallback) this);
        }
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().installViewFactory();
        super.onCreate(bundle);
        getDelegate().onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Nullable
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void setContentView(@LayoutRes int i10) {
        getDelegate().setContentView(i10);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().setTitle(charSequence);
    }

    /* access modifiers changed from: package-private */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().requestWindowFeature(i10);
    }

    public AppCompatDialog(@NonNull Context context, int i10) {
        super(context, getThemeResId(context, i10));
        this.mKeyDispatcher = new q(this);
        AppCompatDelegate delegate = getDelegate();
        delegate.setTheme(getThemeResId(context, i10));
        delegate.onCreate((Bundle) null);
    }

    public void setContentView(@NonNull View view) {
        getDelegate().setContentView(view);
    }

    public void setContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    public void setTitle(int i10) {
        super.setTitle(i10);
        getDelegate().setTitle(getContext().getString(i10));
    }

    protected AppCompatDialog(@NonNull Context context, boolean z10, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.mKeyDispatcher = new q(this);
        setCancelable(z10);
        setOnCancelListener(onCancelListener);
    }
}
