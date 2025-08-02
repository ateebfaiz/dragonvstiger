package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowCallbackWrapper implements Window.Callback {
    final Window.Callback mWrapped;

    static class a {
        @DoNotInline
        static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        @DoNotInline
        static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i10) {
            return callback.onWindowStartingActionMode(callback2, i10);
        }
    }

    static class b {
        @DoNotInline
        static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            callback.onProvideKeyboardShortcuts(list, menu, i10);
        }
    }

    static class c {
        @DoNotInline
        static void a(Window.Callback callback, boolean z10) {
            callback.onPointerCaptureChanged(z10);
        }
    }

    public WindowCallbackWrapper(Window.Callback callback) {
        if (callback != null) {
            this.mWrapped = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mWrapped.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mWrapped.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mWrapped.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mWrapped.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mWrapped.dispatchTrackballEvent(motionEvent);
    }

    public final Window.Callback getWrapped() {
        return this.mWrapped;
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.mWrapped.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.mWrapped.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.mWrapped.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.mWrapped.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i10, Menu menu) {
        return this.mWrapped.onCreatePanelMenu(i10, menu);
    }

    public View onCreatePanelView(int i10) {
        return this.mWrapped.onCreatePanelView(i10);
    }

    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        return this.mWrapped.onMenuItemSelected(i10, menuItem);
    }

    public boolean onMenuOpened(int i10, Menu menu) {
        return this.mWrapped.onMenuOpened(i10, menu);
    }

    public void onPanelClosed(int i10, Menu menu) {
        this.mWrapped.onPanelClosed(i10, menu);
    }

    @RequiresApi(26)
    public void onPointerCaptureChanged(boolean z10) {
        c.a(this.mWrapped, z10);
    }

    public boolean onPreparePanel(int i10, View view, Menu menu) {
        return this.mWrapped.onPreparePanel(i10, view, menu);
    }

    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
        b.a(this.mWrapped, list, menu, i10);
    }

    @RequiresApi(23)
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return a.a(this.mWrapped, searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mWrapped.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z10) {
        this.mWrapped.onWindowFocusChanged(z10);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.mWrapped.onWindowStartingActionMode(callback);
    }

    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    @RequiresApi(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        return a.b(this.mWrapped, callback, i10);
    }
}
