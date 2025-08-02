package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;

public final /* synthetic */ class d implements InputConnectionCompat.OnCommitContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f15266a;

    public /* synthetic */ d(View view) {
        this.f15266a = view;
    }

    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i10, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(this.f15266a, inputContentInfoCompat, i10, bundle);
    }
}
