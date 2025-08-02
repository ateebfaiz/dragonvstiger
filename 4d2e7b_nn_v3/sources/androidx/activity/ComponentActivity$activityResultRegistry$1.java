package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.m;

public final class ComponentActivity$activityResultRegistry$1 extends ActivityResultRegistry {
    final /* synthetic */ ComponentActivity this$0;

    ComponentActivity$activityResultRegistry$1(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    /* access modifiers changed from: private */
    public static final void onLaunch$lambda$0(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i10, ActivityResultContract.SynchronousResult synchronousResult) {
        m.f(componentActivity$activityResultRegistry$1, "this$0");
        componentActivity$activityResultRegistry$1.dispatchResult(i10, synchronousResult.getValue());
    }

    /* access modifiers changed from: private */
    public static final void onLaunch$lambda$1(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i10, IntentSender.SendIntentException sendIntentException) {
        m.f(componentActivity$activityResultRegistry$1, "this$0");
        m.f(sendIntentException, "$e");
        componentActivity$activityResultRegistry$1.dispatchResult(i10, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, sendIntentException));
    }

    public <I, O> void onLaunch(int i10, ActivityResultContract<I, O> activityResultContract, I i11, ActivityOptionsCompat activityOptionsCompat) {
        Bundle bundle;
        Bundle bundle2;
        m.f(activityResultContract, "contract");
        ComponentActivity componentActivity = this.this$0;
        ActivityResultContract.SynchronousResult<O> synchronousResult = activityResultContract.getSynchronousResult(componentActivity, i11);
        if (synchronousResult != null) {
            new Handler(Looper.getMainLooper()).post(new h(this, i10, synchronousResult));
            return;
        }
        Intent createIntent = activityResultContract.createIntent(componentActivity, i11);
        if (createIntent.getExtras() != null) {
            Bundle extras = createIntent.getExtras();
            m.c(extras);
            if (extras.getClassLoader() == null) {
                createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
        }
        if (createIntent.hasExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
            Bundle bundleExtra = createIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            createIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            bundle = bundleExtra;
        } else {
            if (activityOptionsCompat != null) {
                bundle2 = activityOptionsCompat.toBundle();
            } else {
                bundle2 = null;
            }
            bundle = bundle2;
        }
        if (m.b(ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS, createIntent.getAction())) {
            String[] stringArrayExtra = createIntent.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            ActivityCompat.requestPermissions(componentActivity, stringArrayExtra, i10);
        } else if (m.b(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST, createIntent.getAction())) {
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
            try {
                m.c(intentSenderRequest);
                ActivityCompat.startIntentSenderForResult(componentActivity, intentSenderRequest.getIntentSender(), i10, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
            } catch (IntentSender.SendIntentException e10) {
                new Handler(Looper.getMainLooper()).post(new i(this, i10, e10));
            }
        } else {
            ActivityCompat.startActivityForResult(componentActivity, createIntent, i10, bundle);
        }
    }
}
