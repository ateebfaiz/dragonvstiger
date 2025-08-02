package com.facebook.react;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import w6.b;
import w6.g;
import w6.h;

public abstract class ReactActivity extends AppCompatActivity implements b, g {
    public s getReactActivityDelegate() {
        return null;
    }

    @Nullable
    public w getReactDelegate() {
        throw null;
    }

    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        throw null;
    }

    public void onBackPressed() {
        throw null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        throw null;
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        throw null;
    }

    public boolean onKeyLongPress(int i10, KeyEvent keyEvent) {
        throw null;
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        throw null;
    }

    public void onNewIntent(Intent intent) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        throw null;
    }

    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        throw null;
    }

    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        throw null;
    }

    public void requestPermissions(String[] strArr, int i10, h hVar) {
        throw null;
    }
}
