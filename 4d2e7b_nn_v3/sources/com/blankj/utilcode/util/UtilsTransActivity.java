package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import c.d;
import com.blankj.utilcode.util.p;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UtilsTransActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f18395a = new HashMap();

    public static abstract class a implements Serializable {
    }

    protected static void g(Activity activity, p.a aVar, a aVar2, Class cls) {
    }

    public static void start(a aVar) {
        g((Activity) null, (p.a) null, aVar, UtilsTransActivity.class);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        d.a(f18395a.get(this));
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        d.a(f18395a.get(this));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        getIntent().getSerializableExtra("extra_delegate");
        super.onCreate(bundle);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        d.a(f18395a.get(this));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        d.a(f18395a.get(this));
    }

    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        d.a(f18395a.get(this));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        d.a(f18395a.get(this));
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        d.a(f18395a.get(this));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        d.a(f18395a.get(this));
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        d.a(f18395a.get(this));
    }

    public static void start(p.a aVar, a aVar2) {
        g((Activity) null, aVar, aVar2, UtilsTransActivity.class);
    }

    public static void start(Activity activity, a aVar) {
        g(activity, (p.a) null, aVar, UtilsTransActivity.class);
    }

    public static void start(Activity activity, p.a aVar, a aVar2) {
        g(activity, aVar, aVar2, UtilsTransActivity.class);
    }
}
