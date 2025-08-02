package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.LinkedList;

@KeepForSdk
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */
    public T zaa;
    /* access modifiers changed from: private */
    @Nullable
    public Bundle zab;
    /* access modifiers changed from: private */
    public LinkedList<h> zac;
    private final OnDelegateCreatedListener<T> zad = new a(this);

    @KeepForSdk
    public static void showGooglePlayUnavailableMessage(@NonNull FrameLayout frameLayout) {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(context);
        String zad2 = zac.zad(context, isGooglePlayServicesAvailable);
        String zac2 = zac.zac(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zad2);
        linearLayout.addView(textView);
        Intent errorResolutionIntent = instance.getErrorResolutionIntent(context, isGooglePlayServicesAvailable, (String) null);
        if (errorResolutionIntent != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zac2);
            linearLayout.addView(button);
            button.setOnClickListener(new e(context, errorResolutionIntent));
        }
    }

    private final void zae(int i10) {
        while (!this.zac.isEmpty() && this.zac.getLast().zaa() >= i10) {
            this.zac.removeLast();
        }
    }

    private final void zaf(@Nullable Bundle bundle, h hVar) {
        T t10 = this.zaa;
        if (t10 != null) {
            hVar.a(t10);
            return;
        }
        if (this.zac == null) {
            this.zac = new LinkedList<>();
        }
        this.zac.add(hVar);
        if (bundle != null) {
            Bundle bundle2 = this.zab;
            if (bundle2 == null) {
                this.zab = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.zad);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract void createDelegate(@NonNull OnDelegateCreatedListener<T> onDelegateCreatedListener);

    @NonNull
    @KeepForSdk
    public T getDelegate() {
        return this.zaa;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void handleGooglePlayUnavailable(@NonNull FrameLayout frameLayout) {
        showGooglePlayUnavailableMessage(frameLayout);
    }

    @KeepForSdk
    public void onCreate(@Nullable Bundle bundle) {
        zaf(bundle, new c(this, bundle));
    }

    @NonNull
    @KeepForSdk
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        zaf(bundle, new d(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.zaa == null) {
            handleGooglePlayUnavailable(frameLayout);
        }
        return frameLayout;
    }

    @KeepForSdk
    public void onDestroy() {
        T t10 = this.zaa;
        if (t10 != null) {
            t10.onDestroy();
        } else {
            zae(1);
        }
    }

    @KeepForSdk
    public void onDestroyView() {
        T t10 = this.zaa;
        if (t10 != null) {
            t10.onDestroyView();
        } else {
            zae(2);
        }
    }

    @KeepForSdk
    public void onInflate(@NonNull Activity activity, @NonNull Bundle bundle, @Nullable Bundle bundle2) {
        zaf(bundle2, new b(this, activity, bundle, bundle2));
    }

    @KeepForSdk
    public void onLowMemory() {
        T t10 = this.zaa;
        if (t10 != null) {
            t10.onLowMemory();
        }
    }

    @KeepForSdk
    public void onPause() {
        T t10 = this.zaa;
        if (t10 != null) {
            t10.onPause();
        } else {
            zae(5);
        }
    }

    @KeepForSdk
    public void onResume() {
        zaf((Bundle) null, new g(this));
    }

    @KeepForSdk
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        T t10 = this.zaa;
        if (t10 != null) {
            t10.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.zab;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @KeepForSdk
    public void onStart() {
        zaf((Bundle) null, new f(this));
    }

    @KeepForSdk
    public void onStop() {
        T t10 = this.zaa;
        if (t10 != null) {
            t10.onStop();
        } else {
            zae(4);
        }
    }
}
