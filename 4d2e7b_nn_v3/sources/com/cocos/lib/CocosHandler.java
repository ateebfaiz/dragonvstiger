package com.cocos.lib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class CocosHandler extends Handler {
    public static final int HANDLER_SHOW_DIALOG = 1;
    private WeakReference<Activity> mActivity;

    public static class DialogMessage {
        public String message;
        public String title;

        public DialogMessage(String str, String str2) {
            this.title = str;
            this.message = str2;
        }
    }

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
        }
    }

    public CocosHandler(Activity activity) {
        this.mActivity = new WeakReference<>(activity);
    }

    private void showDialog(Message message) {
        DialogMessage dialogMessage = (DialogMessage) message.obj;
        new AlertDialog.Builder(this.mActivity.get()).setTitle(dialogMessage.title).setMessage(dialogMessage.message).setPositiveButton("Ok", new a()).create().show();
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            showDialog(message);
        }
    }
}
