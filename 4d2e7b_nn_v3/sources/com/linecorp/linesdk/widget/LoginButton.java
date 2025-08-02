package com.linecorp.linesdk.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.linecorp.linesdk.LoginDelegate;
import com.linecorp.linesdk.LoginListener;
import com.linecorp.linesdk.auth.LineAuthenticationParams;
import com.linecorp.linesdk.internal.FragmentWrapper;
import com.linecorp.linesdk.internal.LoginHandler;
import i9.f;
import i9.g;
import i9.j;
import i9.k;
import java.util.Arrays;
import o9.a;
import o9.b;

public class LoginButton extends AppCompatTextView {
    @NonNull
    private LineAuthenticationParams authenticationParams = new LineAuthenticationParams.c().f(Arrays.asList(new k[]{k.f12368c})).e();
    @Nullable
    private String channelId;
    @Nullable
    private FragmentWrapper fragmentWrapper;
    @NonNull
    private View.OnClickListener internalListener = new b(this);
    private boolean isLineAppAuthEnabled = true;
    @Nullable
    private LoginDelegate loginDelegate;
    @NonNull
    private LoginHandler loginHandler = new LoginHandler();

    public LoginButton(Context context) {
        super(context);
        init();
    }

    @NonNull
    private Activity getActivity() {
        Context context = getContext();
        while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        throw new RuntimeException("Cannot find an Activity");
    }

    private void init() {
        setAllCaps(false);
        setGravity(17);
        setText(j.f12366a);
        setTextColor(ContextCompat.getColor(getContext(), f.f12359a));
        setBackgroundResource(g.f12360a);
        super.setOnClickListener(this.internalListener);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        String str = this.channelId;
        if (str == null) {
            throw new RuntimeException("Channel id should be set.");
        } else if (!str.isEmpty()) {
            FragmentWrapper fragmentWrapper2 = this.fragmentWrapper;
            if (fragmentWrapper2 != null) {
                performLoginWithFragment(this.channelId, fragmentWrapper2);
            } else {
                performLoginWithActivity(this.channelId, getActivity());
            }
        } else {
            throw new RuntimeException("Channel id should not be empty.");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnClickListener$1(@Nullable View.OnClickListener onClickListener, View view) {
        this.internalListener.onClick(view);
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private void performLoginWithActivity(@NonNull String str, @NonNull Activity activity) {
        this.loginHandler.d(activity, this.isLineAppAuthEnabled, str, this.authenticationParams);
    }

    private void performLoginWithFragment(@NonNull String str, @NonNull FragmentWrapper fragmentWrapper2) {
        this.loginHandler.c(getActivity(), fragmentWrapper2, this.isLineAppAuthEnabled, str, this.authenticationParams);
    }

    public void addLoginListener(@NonNull LoginListener loginListener) {
        if (this.loginDelegate != null) {
            this.loginHandler.a(loginListener);
            return;
        }
        throw new RuntimeException("You must set LoginDelegate through setLoginDelegate()  first");
    }

    public void enableLineAppAuthentication(boolean z10) {
        this.isLineAppAuthEnabled = z10;
    }

    public void removeLoginListener(@NonNull LoginListener loginListener) {
        this.loginHandler.e(loginListener);
    }

    public void setAuthenticationParams(@NonNull LineAuthenticationParams lineAuthenticationParams) {
        this.authenticationParams = lineAuthenticationParams;
    }

    public void setChannelId(@NonNull String str) {
        this.channelId = str;
    }

    public void setFragment(@NonNull Fragment fragment) {
        this.fragmentWrapper = new FragmentWrapper(fragment);
    }

    public void setLoginDelegate(@NonNull LoginDelegate loginDelegate2) {
        throw new RuntimeException("Unexpected LoginDelegate, please use the provided Factory to create the instance");
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(new a(this, onClickListener));
    }

    public void setFragment(@NonNull androidx.fragment.app.Fragment fragment) {
        this.fragmentWrapper = new FragmentWrapper(fragment);
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init();
    }
}
