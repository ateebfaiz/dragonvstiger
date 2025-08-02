package androidx.credentials.playservices;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class HiddenActivity$$ExternalSyntheticLambda1 implements OnFailureListener {
    public final /* synthetic */ HiddenActivity f$0;

    public /* synthetic */ HiddenActivity$$ExternalSyntheticLambda1(HiddenActivity hiddenActivity) {
        this.f$0 = hiddenActivity;
    }

    public final void onFailure(Exception exc) {
        HiddenActivity.handleCreatePublicKeyCredential$lambda$2$lambda$1(this.f$0, exc);
    }
}
