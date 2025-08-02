package o9;

import android.view.View;
import com.linecorp.linesdk.widget.LoginButton;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginButton f12882a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f12883b;

    public /* synthetic */ a(LoginButton loginButton, View.OnClickListener onClickListener) {
        this.f12882a = loginButton;
        this.f12883b = onClickListener;
    }

    public final void onClick(View view) {
        this.f12882a.lambda$setOnClickListener$1(this.f12883b, view);
    }
}
