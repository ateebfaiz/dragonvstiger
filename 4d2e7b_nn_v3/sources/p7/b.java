package p7;

import android.view.View;

public interface b {
    void closeDrawer(View view);

    void openDrawer(View view);

    void setDrawerBackgroundColor(View view, Integer num);

    void setDrawerLockMode(View view, String str);

    void setDrawerPosition(View view, String str);

    void setDrawerWidth(View view, Float f10);

    void setKeyboardDismissMode(View view, String str);

    void setStatusBarBackgroundColor(View view, Integer num);
}
