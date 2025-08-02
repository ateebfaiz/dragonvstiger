package androidx.credentials.playservices;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class HiddenActivity$$ExternalSyntheticLambda3 implements OnFailureListener {
    public final /* synthetic */ HiddenActivity f$0;

    public /* synthetic */ HiddenActivity$$ExternalSyntheticLambda3(HiddenActivity hiddenActivity) {
        this.f$0 = hiddenActivity;
    }

    public final void onFailure(Exception exc) {
        HiddenActivity.handleCreatePassword$lambda$14$lambda$13(this.f$0, exc);
    }
}
