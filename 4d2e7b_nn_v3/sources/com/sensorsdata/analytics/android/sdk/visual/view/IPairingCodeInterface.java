package com.sensorsdata.analytics.android.sdk.visual.view;

interface IPairingCodeInterface {

    public interface OnPairingCodeChangedListener {
        void onInputCompleted(CharSequence charSequence);

        void onPairingCodeChanged(CharSequence charSequence, int i10, int i11, int i12);
    }

    void setBottomLineHeight(int i10);

    void setBottomNormalColor(int i10);

    void setBottomSelectedColor(int i10);

    void setFigures(int i10);

    void setOnPairingCodeChangedListener(OnPairingCodeChangedListener onPairingCodeChangedListener);

    void setPairingCodeMargin(int i10);

    void setSelectedBackgroundColor(int i10);
}
