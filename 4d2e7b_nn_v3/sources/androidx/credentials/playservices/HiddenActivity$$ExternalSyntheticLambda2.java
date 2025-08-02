package androidx.credentials.playservices;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class HiddenActivity$$ExternalSyntheticLambda2 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ HiddenActivity$$ExternalSyntheticLambda2(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        HiddenActivity.handleCreatePassword$lambda$14$lambda$12(this.f$0, obj);
    }
}
