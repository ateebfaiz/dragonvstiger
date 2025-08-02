package com.facebook.react.modules.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.facebook.react.modules.dialog.DialogModule;
import com.google.firebase.analytics.FirebaseAnalytics;

public class a extends DialogFragment implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private final DialogModule.b f3287b;

    public a() {
        this.f3287b = null;
    }

    private static Dialog o(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle((CharSequence) bundle.getString("title"));
        if (bundle.containsKey("button_positive")) {
            title.setPositiveButton((CharSequence) bundle.getString("button_positive"), onClickListener);
        }
        if (bundle.containsKey("button_negative")) {
            title.setNegativeButton((CharSequence) bundle.getString("button_negative"), onClickListener);
        }
        if (bundle.containsKey("button_neutral")) {
            title.setNeutralButton((CharSequence) bundle.getString("button_neutral"), onClickListener);
        }
        if (bundle.containsKey("message")) {
            title.setMessage((CharSequence) bundle.getString("message"));
        }
        if (bundle.containsKey(FirebaseAnalytics.Param.ITEMS)) {
            title.setItems(bundle.getCharSequenceArray(FirebaseAnalytics.Param.ITEMS), onClickListener);
        }
        return title.create();
    }

    private static Dialog p(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle(bundle.getString("title"));
        if (bundle.containsKey("button_positive")) {
            title.setPositiveButton(bundle.getString("button_positive"), onClickListener);
        }
        if (bundle.containsKey("button_negative")) {
            title.setNegativeButton(bundle.getString("button_negative"), onClickListener);
        }
        if (bundle.containsKey("button_neutral")) {
            title.setNeutralButton(bundle.getString("button_neutral"), onClickListener);
        }
        if (bundle.containsKey("message")) {
            title.setMessage(bundle.getString("message"));
        }
        if (bundle.containsKey(FirebaseAnalytics.Param.ITEMS)) {
            title.setItems(bundle.getCharSequenceArray(FirebaseAnalytics.Param.ITEMS), onClickListener);
        }
        return title.create();
    }

    public static Dialog q(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        if (r(context)) {
            return o(context, bundle, onClickListener);
        }
        return p(context, bundle, onClickListener);
    }

    private static boolean r(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar);
        obtainStyledAttributes.recycle();
        return hasValue;
    }

    public void onClick(DialogInterface dialogInterface, int i10) {
        DialogModule.b bVar = this.f3287b;
        if (bVar != null) {
            bVar.onClick(dialogInterface, i10);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return q(requireActivity(), requireArguments(), this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogModule.b bVar = this.f3287b;
        if (bVar != null) {
            bVar.onDismiss(dialogInterface);
        }
    }

    public a(DialogModule.b bVar, Bundle bundle) {
        this.f3287b = bVar;
        setArguments(bundle);
    }
}
