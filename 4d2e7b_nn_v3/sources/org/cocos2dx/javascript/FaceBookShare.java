package org.cocos2dx.javascript;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.facebook.g;
import com.facebook.j;
import com.facebook.l;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.b;
import y7.c;

public class FaceBookShare {
    static final String TAG = "FaceBookShare";
    private static g callbackManager;
    public static Context context;
    private static AppActivity mActivity;
    private static b shareDialog;

    class a implements j {
        a() {
        }

        public void a(l lVar) {
            Log.d(FaceBookShare.TAG, "分享失败");
        }

        /* renamed from: b */
        public void onSuccess(c cVar) {
            Log.d(FaceBookShare.TAG, "分享成功");
        }

        public void onCancel() {
            Log.d(FaceBookShare.TAG, "分享取消");
        }
    }

    public static void doShare(String str) {
        if (b.w(ShareLinkContent.class)) {
            shareDialog.m(((ShareLinkContent.b) new ShareLinkContent.b().h(Uri.parse(str))).r());
        }
    }

    public static void onActivityResult(int i10, int i11, Intent intent) {
        callbackManager.a(i10, i11, intent);
    }

    public static void onCreate(AppActivity appActivity) {
        mActivity = appActivity;
        context = appActivity.getApplicationContext();
        callbackManager = g.a.a();
        b bVar = new b(mActivity);
        shareDialog = bVar;
        bVar.j(callbackManager, new a());
    }
}
