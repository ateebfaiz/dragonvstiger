package androidx.credentials.playservices;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class HiddenActivity$$ExternalSyntheticLambda7 implements OnFailureListener {
    public final /* synthetic */ HiddenActivity f$0;

    public /* synthetic */ HiddenActivity$$ExternalSyntheticLambda7(HiddenActivity hiddenActivity) {
        this.f$0 = hiddenActivity;
    }

    public final void onFailure(Exception exc) {
        HiddenActivity.handleBeginSignIn$lambda$10$lambda$9(this.f$0, exc);
    }
}
