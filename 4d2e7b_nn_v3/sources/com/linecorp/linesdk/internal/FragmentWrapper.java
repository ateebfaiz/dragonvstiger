package com.linecorp.linesdk.internal;

import android.app.Fragment;
import android.content.Intent;

public class FragmentWrapper {

    /* renamed from: a  reason: collision with root package name */
    private Fragment f10087a;

    /* renamed from: b  reason: collision with root package name */
    private androidx.fragment.app.Fragment f10088b;

    public FragmentWrapper(Fragment fragment) {
        this.f10087a = fragment;
    }

    public void a(Intent intent, int i10) {
        Fragment fragment = this.f10087a;
        if (fragment != null) {
            fragment.startActivityForResult(intent, i10);
            return;
        }
        androidx.fragment.app.Fragment fragment2 = this.f10088b;
        if (fragment2 != null) {
            fragment2.startActivityForResult(intent, i10);
        }
    }

    public FragmentWrapper(androidx.fragment.app.Fragment fragment) {
        this.f10088b = fragment;
    }
}
