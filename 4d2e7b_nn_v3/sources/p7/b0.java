package p7;

import android.view.View;

public interface b0 {
    void blur(View view);

    void cancelSearch(View view);

    void clearText(View view);

    void focus(View view);

    void setAutoCapitalize(View view, String str);

    void setBarTintColor(View view, Integer num);

    void setCancelButtonText(View view, String str);

    void setDisableBackButtonOverride(View view, boolean z10);

    void setHeaderIconColor(View view, Integer num);

    void setHideNavigationBar(View view, boolean z10);

    void setHideWhenScrolling(View view, boolean z10);

    void setHintTextColor(View view, Integer num);

    void setInputType(View view, String str);

    void setObscureBackground(View view, boolean z10);

    void setPlaceholder(View view, String str);

    void setPlacement(View view, String str);

    void setShouldShowHintSearchIcon(View view, boolean z10);

    void setText(View view, String str);

    void setTextColor(View view, Integer num);

    void setTintColor(View view, Integer num);

    void toggleCancelButton(View view, boolean z10);
}
