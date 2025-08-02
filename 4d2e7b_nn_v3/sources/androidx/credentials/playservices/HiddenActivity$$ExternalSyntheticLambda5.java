package androidx.credentials.playservices;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class HiddenActivity$$ExternalSyntheticLambda5 implements OnFailureListener {
    public final /* synthetic */ HiddenActivity f$0;

    public /* synthetic */ HiddenActivity$$ExternalSyntheticLambda5(HiddenActivity hiddenActivity) {
        this.f$0 = hiddenActivity;
    }

    public final void onFailure(Exception exc) {
        HiddenActivity.handleGetSignInIntent$lambda$6$lambda$5(this.f$0, exc);
    }
}
