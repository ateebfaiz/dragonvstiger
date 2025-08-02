package org.cocos2dx.javascript;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pdns.f;
import com.cocos.lib.CocosActivity;
import com.cocos.lib.CocosDownloader;
import com.cocos.lib.CocosHelper;
import com.cocos.lib.CocosHttpURLConnection;
import com.cocos.lib.CocosLocalStorage;
import com.cocos.lib.CocosMahAgent;
import com.cocos.lib.CocoslibCallback;
import com.cocos.lib.GlobalObject;
import com.cocos.sdk.WgProxyController;
import com.facebook.react.modules.i18nmanager.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.cocos2dx.javascript.CopySubGameAsyncTask;
import org.cocos2dx.javascript.connection.ConnectionCreator;
import org.cocos2dx.javascript.rn.RNDelegateManager;
import org.cocos2dx.okhttp3.Dispatcher;
import w6.b;
import w6.g;
import w6.h;

public class AppActivity extends CocosActivity implements CopySubGameAsyncTask.CopyListener, b, g, CocoslibCallback, CocosMahAgent {
    private static final int HOTFIX_ENABLED = 1;
    private static final String TAG = "AppActivity";
    private static final String TAG_PLACE_HOLDER_VIEW = "tag_place_holder_view";
    public DragFloatActionButton exitBtn = null;
    public ArrayList<Map<String, String>> finishedGameList;
    public ArrayList<String> gameFileList;
    public boolean isRTL = false;
    public ActivityResultLauncher<Intent> launcher;
    private String[] rtlLanguages = {"ar", "fa", "ur", "ku", "ckb", "so", "he", "syr", "tg"};

    private void addSplashView() {
        ImageView imageView = new ImageView(this);
        imageView.setTag(TAG_PLACE_HOLDER_VIEW);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setImageResource(R.drawable.launch_page);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup != null) {
            viewGroup.addView(imageView);
        }
    }

    private void clearHotfixCache() {
        try {
            String string = SPUtil.getInstance(this).getString("version3", "");
            String hallVersion = PlatformUtils.getHallVersion();
            if (!string.isEmpty() && hallVersion != null) {
                if (hallVersion.length() > 0 && !string.equals(hallVersion)) {
                    Log.d(TAG, "clearHotfixCache: 覆盖安装");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(CocosHelper.getWritablePath());
                    String str = File.separator;
                    sb2.append(str);
                    sb2.append("update");
                    sb2.append(str);
                    sb2.append("hall");
                    if (deleteDirectory(new File(sb2.toString()))) {
                        Log.d(TAG, "clearHotfixCache removeDirectory ok");
                    } else {
                        Log.d(TAG, "clearHotfixCache removeDirectory fail");
                    }
                    SPUtil.getInstance(this).saveString("version3", "");
                    if (SPUtil.getInstance(this).getString("version3", "").isEmpty() && hallVersion != null && hallVersion.length() > 0) {
                        SPUtil.getInstance(this).saveString("version3", hallVersion);
                        Log.d(TAG, "clearHotfixCache pkVer: " + hallVersion);
                        return;
                    }
                    return;
                }
            }
            Log.d(TAG, "clearHotfixCache no need");
            if (SPUtil.getInstance(this).getString("version3", "").isEmpty()) {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void copyAssetsDir2Phone(Activity activity, String str, String str2) {
        try {
            String[] list = activity.getAssets().list(str);
            if (list.length > 0) {
                new File(str2 + File.separator + str).mkdirs();
                for (String str3 : list) {
                    copyAssetsDir2Phone(activity, str + File.separator + str3, str2);
                }
                return;
            }
            InputStream open = activity.getAssets().open(str);
            File file = new File(str2 + File.separator + str);
            if (!file.exists() || file.length() == 0) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        open.close();
                        fileOutputStream.close();
                        return;
                    }
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static void copyAssetsFile2Phone(Activity activity, String str, String str2) {
        try {
            InputStream open = activity.getAssets().open(str);
            File file = new File(str2 + File.separator + str);
            if (file.exists()) {
                if (file.length() != 0) {
                    return;
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    private boolean deleteDirectory(File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDirectory(file2);
                } else {
                    file2.delete();
                }
            }
        }
        return file.delete();
    }

    private void initLaunch() {
    }

    /* access modifiers changed from: private */
    public void initRn() {
        CocosLocalStorage.setInitListener((CocosLocalStorage.ILocalStorageListener) null);
        String infoValue = PlatformUtils.getInfoValue("siteCode");
        String infoValue2 = PlatformUtils.getInfoValue("skinType");
        String item = CocosLocalStorage.getItem("lang_key" + infoValue + "_" + infoValue2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("storage language is ");
        sb2.append(item);
        Log.d(TAG, sb2.toString());
        if (TextUtils.isEmpty(item)) {
            item = PlatformUtils.getInfoValue("language");
            Log.d(TAG, "manifest language is " + item);
        }
        if (Arrays.asList(this.rtlLanguages).contains(item)) {
            this.isRTL = true;
            if (PlatformUtils.getInfoValue("skinRtl").equals("1")) {
                this.isRTL = false;
            }
            a f10 = a.f();
            f10.e(this, this.isRTL);
            f10.b(this, this.isRTL);
            Log.d(TAG, "initRn: RNDelegateManager init isRTL " + this.isRTL);
        } else {
            this.isRTL = false;
            Log.d(TAG, "initRn: RNDelegateManager init isRTL false");
        }
        Log.d(TAG, "initRn: RNDelegateManager init");
        RNDelegateManager.getInstance().init(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0() {
        GlobalObject.runOnUiThread(new a(this));
    }

    public void copyHallCfg2WritablePath() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CocosHelper.getWritablePath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("update");
        sb2.append(str);
        sb2.append("hall");
        String sb3 = sb2.toString();
        if (!new File(sb3).exists()) {
            new File(sb3).mkdirs();
            copyAssetsFile2Phone(this, "project.manifest", sb3);
        }
    }

    public void copySubGame() {
        if (this.gameFileList.size() < 1) {
            onCopySubGameEnd();
            return;
        }
        try {
            CopySubGameAsyncTask copySubGameAsyncTask = new CopySubGameAsyncTask();
            copySubGameAsyncTask.setActivity(this);
            copySubGameAsyncTask.setListener(this);
            copySubGameAsyncTask.execute(new String[]{this.gameFileList.get(0)});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public HttpURLConnection createProxyConnection(URL url) {
        return ConnectionCreator.getInstance().createProxyConnection(url);
    }

    public ActivityResultLauncher<Intent> getLauncher() {
        return this.launcher;
    }

    public void invokeDefaultOnBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        PlatformUtils.onActivityResult(i10, i11, intent);
        FaceBookShare.onActivityResult(i10, i11, intent);
        if (PlatformUtils.isRn() && RNDelegateManager.getInstance().getReactDelegate() != null) {
            RNDelegateManager.getInstance().getReactDelegate().k(i10, i11, intent, true);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCopyComplete() {
        Log.d(TAG, "拷贝完成,下一个");
        String substring = this.gameFileList.get(0).substring(0, this.gameFileList.get(0).lastIndexOf(f.G));
        HashMap hashMap = new HashMap();
        hashMap.put("subgame", substring);
        hashMap.put("isSucc", "1");
        this.finishedGameList.add(hashMap);
        this.gameFileList.remove(0);
        copySubGame();
    }

    public void onCopyError(String str) {
        Log.d(TAG, "拷贝失败,下一个");
        String substring = this.gameFileList.get(0).substring(0, this.gameFileList.get(0).lastIndexOf(f.G));
        HashMap hashMap = new HashMap();
        hashMap.put("subgame", substring);
        hashMap.put("isSucc", "0");
        this.finishedGameList.add(hashMap);
        this.gameFileList.remove(0);
        copySubGame();
    }

    /* access modifiers changed from: package-private */
    public void onCopySubGameEnd() {
        Log.d(TAG, "拷贝子游戏完成");
        String jSONString = JSON.toJSONString(this.finishedGameList);
        Log.d(TAG, jSONString);
        String encodeToString = Base64.encodeToString(jSONString.getBytes(), 2);
        Log.d(TAG, encodeToString);
        PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.onUnzipComplete(\"%s\");", new Object[]{encodeToString}));
    }

    public void onCopying(float f10) {
        Log.d(TAG, "进度:" + f10);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate((Bundle) null);
        if (isTaskRoot()) {
            addSplashView();
            removeSplashViewDelay();
            CocosHelper.setKeepScreenOn(true);
            CCSensorsDataAPI.onCreate(this);
            PlatformUtils.onCreate(this);
            FaceBookShare.onCreate(this);
            clearHotfixCache();
            copyHallCfg2WritablePath();
            initLaunch();
            CocosHttpURLConnection.cocoslibCallback = this;
            CocosHttpURLConnection.mahAgent = this;
            CocosDownloader.mahAgent = this;
            String[] serversConfigByEncryptedData = CommonUtils.getServersConfigByEncryptedData(PlatformUtils.getInfoValue("bucketServers"));
            ConnectionCreator.getInstance().setUseWgMah(WgProxyController.getInstance().startUp(PlatformUtils.wrapUserInfo(this, "0", "null", false), serversConfigByEncryptedData));
            if (PlatformUtils.isRn()) {
                CocosLocalStorage.setInitListener(new c(this));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        WgProxyController.getInstance().shutdown();
        PlatformUtils.onDestroy();
        if (PlatformUtils.isRn()) {
            RNDelegateManager.getInstance().destroy();
        }
    }

    public void onHttpException(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("linkURL", (Object) str);
            jSONObject.put("message", (Object) str2);
            String json = jSONObject.toString();
            Log.d(TAG, "onHttpErrorCallback, jsonString: " + json);
            CCSensorsDataAPI.track("CocosHttpException", json);
        } catch (Exception e10) {
            Log.e(TAG, "onHttpErrorCallback: ", e10);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        PlatformUtils.onRequestPermissionsResult(i10, strArr, iArr);
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        PlatformUtils.onResume();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }

    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        if (i10 == 10) {
            PlatformUtils.callJSMethod(String.format("window['G']?.PlatformUtils?.memoryWarning()", new Object[0]));
        }
    }

    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        PlatformUtils.onWindowFocusChanged(z10);
        if (PlatformUtils.isRn() && RNDelegateManager.getInstance().getReactDelegate() != null) {
            RNDelegateManager.getInstance().getReactDelegate().p(z10);
        }
    }

    public void removeSplashView() {
        View findViewWithTag;
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup != null && (findViewWithTag = viewGroup.findViewWithTag(TAG_PLACE_HOLDER_VIEW)) != null) {
            Log.d(TAG, "removeSplashView 2");
            viewGroup.removeView(findViewWithTag);
        }
    }

    public void removeSplashViewDelay() {
        new Handler().postDelayed(new b(this), 5000);
    }

    public void requestPermissions(String[] strArr, int i10, h hVar) {
        int[] iArr = new int[strArr.length];
        boolean z10 = false;
        for (int i11 = 0; i11 < strArr.length; i11++) {
            int checkSelfPermission = ContextCompat.checkSelfPermission(this, strArr[i11]);
            iArr[i11] = checkSelfPermission;
            if (!z10) {
                if (checkSelfPermission != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
        }
        if (z10) {
            ActivityCompat.requestPermissions(this, strArr, i10);
        } else {
            hVar.onRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    public boolean setDownloadClient(CocosDownloader cocosDownloader, int i10, Dispatcher dispatcher) {
        return ConnectionCreator.getInstance().setDownloadClient(cocosDownloader, i10, dispatcher);
    }

    public void updateStatusBarUI() {
        PlatformUtils.changeStatusBarUI();
    }
}
