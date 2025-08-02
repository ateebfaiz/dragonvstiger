package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

class v implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    private final ActionBar.OnNavigationListener f13981a;

    public v(ActionBar.OnNavigationListener onNavigationListener) {
        this.f13981a = onNavigationListener;
    }

    public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
        ActionBar.OnNavigationListener onNavigationListener = this.f13981a;
        if (onNavigationListener != null) {
            onNavigationListener.onNavigationItemSelected(i10, j10);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}
