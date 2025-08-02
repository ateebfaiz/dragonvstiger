package c2;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class a implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17279a;

    public a(Context context) {
        this.f17279a = context;
    }

    public void onComplete(Task task) {
        if (task == null) {
            s1.a.a("MTGoogleListener", "onTokenFailed");
            b2.a.a().c(this.f17279a, AuthApiStatusCodes.AUTH_API_SERVER_ERROR, 0, 3900, 1);
        } else if (!task.isSuccessful()) {
            s1.a.a("MTGoogleListener", "onTokenFailed " + task.getException());
            b2.a.a().c(this.f17279a, AuthApiStatusCodes.AUTH_API_SERVER_ERROR, 0, 3900, 1);
        } else {
            String str = (String) task.getResult();
            if (TextUtils.isEmpty(str)) {
                s1.a.a("MTGoogleListener", "onTokenFailed:get token is empty");
                b2.a.a().c(this.f17279a, AuthApiStatusCodes.AUTH_API_SERVER_ERROR, 0, 3900, 1);
                return;
            }
            s1.a.a("MTGoogleListener", "onTokenSuccess:get token is " + str);
            b2.a.a().d(this.f17279a, str, 1);
        }
    }
}
