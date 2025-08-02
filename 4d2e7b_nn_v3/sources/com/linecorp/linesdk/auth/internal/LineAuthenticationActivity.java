package com.linecorp.linesdk.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.linecorp.linesdk.auth.LineAuthenticationConfig;
import com.linecorp.linesdk.auth.LineAuthenticationParams;
import com.linecorp.linesdk.auth.LineLoginResult;
import com.linecorp.linesdk.auth.internal.LineAuthenticationStatus;
import i9.i;

public class LineAuthenticationActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10041a = false;

    /* renamed from: b  reason: collision with root package name */
    private LineAuthenticationStatus f10042b;

    /* renamed from: c  reason: collision with root package name */
    private c f10043c;

    private LineAuthenticationStatus a(Bundle bundle) {
        if (bundle == null) {
            return new LineAuthenticationStatus();
        }
        LineAuthenticationStatus lineAuthenticationStatus = (LineAuthenticationStatus) bundle.getParcelable("authentication_status");
        if (lineAuthenticationStatus == null) {
            return new LineAuthenticationStatus();
        }
        return lineAuthenticationStatus;
    }

    @NonNull
    public static Intent getLoginIntent(@NonNull Context context, @NonNull LineAuthenticationConfig lineAuthenticationConfig, @NonNull LineAuthenticationParams lineAuthenticationParams) {
        Intent intent = new Intent(context, LineAuthenticationActivity.class);
        intent.putExtra("authentication_config", lineAuthenticationConfig);
        intent.putExtra("authentication_params", lineAuthenticationParams);
        return intent;
    }

    @NonNull
    public static LineLoginResult getResultFromIntent(@NonNull Intent intent) {
        LineLoginResult lineLoginResult = (LineLoginResult) intent.getParcelableExtra("authentication_result");
        if (lineLoginResult == null) {
            return LineLoginResult.j("Authentication result is not found.");
        }
        return lineLoginResult;
    }

    /* access modifiers changed from: package-private */
    public void b(LineLoginResult lineLoginResult) {
        LineAuthenticationStatus lineAuthenticationStatus = this.f10042b;
        if (lineAuthenticationStatus == null) {
            finish();
        } else if ((lineAuthenticationStatus.h() == LineAuthenticationStatus.b.STARTED && !this.f10041a) || this.f10042b.h() == LineAuthenticationStatus.b.INTENT_HANDLED) {
            Intent intent = new Intent();
            intent.putExtra("authentication_result", lineLoginResult);
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (this.f10042b.h() == LineAuthenticationStatus.b.STARTED) {
            this.f10043c.m(i10, i11, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.f12365b);
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data == null || !data.getScheme().equals("lineauth")) {
            LineAuthenticationConfig lineAuthenticationConfig = (LineAuthenticationConfig) intent.getParcelableExtra("authentication_config");
            LineAuthenticationParams lineAuthenticationParams = (LineAuthenticationParams) intent.getParcelableExtra("authentication_params");
            if (lineAuthenticationConfig == null || lineAuthenticationParams == null) {
                b(LineLoginResult.j("The requested parameter is illegal."));
                return;
            }
            LineAuthenticationStatus a10 = a(bundle);
            this.f10042b = a10;
            this.f10043c = new c(this, lineAuthenticationConfig, a10, lineAuthenticationParams);
            return;
        }
        c.n(intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.f10042b.h() == LineAuthenticationStatus.b.STARTED) {
            this.f10043c.l(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f10042b.h() == LineAuthenticationStatus.b.INIT) {
            this.f10043c.o();
        } else if (this.f10042b.h() != LineAuthenticationStatus.b.INTENT_RECEIVED) {
            this.f10043c.k();
        }
        this.f10041a = false;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("authentication_status", this.f10042b);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f10041a = true;
    }
}
