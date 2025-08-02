package com.sensorsdata.analytics.android.sdk.visual;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.pdns.f;
import com.alibaba.pdns.j;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.util.AppStateTools;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.util.DeviceUtils;
import com.sensorsdata.analytics.android.sdk.util.Dispatcher;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.util.SAPageInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SAViewUtils;
import com.sensorsdata.analytics.android.sdk.util.SnapCache;
import com.sensorsdata.analytics.android.sdk.util.WebUtils;
import com.sensorsdata.analytics.android.sdk.util.WindowHelper;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewNode;
import com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil;
import com.sensorsdata.analytics.android.sdk.visual.model.CommonNode;
import com.sensorsdata.analytics.android.sdk.visual.model.FlutterNode;
import com.sensorsdata.analytics.android.sdk.visual.model.FlutterNodeInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNode;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo;
import com.sensorsdata.analytics.android.sdk.visual.snap.Caller;
import com.sensorsdata.analytics.android.sdk.visual.snap.PropertyDescription;
import com.sensorsdata.analytics.android.sdk.visual.snap.ResourceIds;
import com.sensorsdata.analytics.android.sdk.visual.snap.SoftWareCanvas;
import com.sensorsdata.analytics.android.sdk.visual.utils.AlertMessageUtils;
import com.sensorsdata.analytics.android.sdk.visual.utils.VisualUtil;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class ViewSnapshot {
    private static final int JS_NOT_INTEGRATED_ALERT_TIME_OUT = 5000;
    private static final int MAX_CLASS_NAME_CACHE_SIZE = 255;
    private static final String TAG = "SA.ViewSnapshot";
    private final ClassNameCache mClassnameCache;
    private final Handler mMainThreadHandler;
    private final List<PropertyDescription> mProperties;
    private final ResourceIds mResourceIds;
    private final RootViewFinder mRootViewFinder;
    /* access modifiers changed from: private */
    public SnapInfo mSnapInfo = new SnapInfo();

    private static class CachedBitmap {
        private Bitmap mCached = null;
        private String mImageHash = "";
        private final Paint mPaint = new Paint(2);

        private static byte[] concat(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        /* access modifiers changed from: private */
        public String getImageHash() {
            return this.mImageHash;
        }

        private String toHex(byte[] bArr) {
            String str = "";
            for (int i10 = 0; i10 < bArr.length; i10++) {
                str = (str + "0123456789ABCDEF".charAt((bArr[i10] >> 4) & 15)) + "0123456789ABCDEF".charAt(bArr[i10] & 15);
            }
            return str;
        }

        public synchronized void recreate(int i10, int i11, int i12, Bitmap bitmap) {
            byte[] bytes;
            byte[] bytes2;
            byte[] bytes3;
            Bitmap bitmap2 = this.mCached;
            if (!(bitmap2 != null && bitmap2.getWidth() == i10 && this.mCached.getHeight() == i11)) {
                try {
                    this.mCached = Bitmap.createBitmap(i10, i11, Bitmap.Config.RGB_565);
                } catch (Throwable unused) {
                    this.mCached = null;
                }
                Bitmap bitmap3 = this.mCached;
                if (bitmap3 != null) {
                    bitmap3.setDensity(i12);
                }
            }
            if (this.mCached != null) {
                new Canvas(this.mCached).drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.mCached.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    String lastThirdMsg = NodesProcess.getInstance().getWebNodesManager().getLastThirdMsg();
                    if (!TextUtils.isEmpty(lastThirdMsg) && (bytes3 = lastThirdMsg.getBytes()) != null && bytes3.length > 0) {
                        byteArray = concat(byteArray, bytes3);
                    }
                    String lastThirdMsg2 = NodesProcess.getInstance().getFlutterNodesManager().getLastThirdMsg();
                    if (!TextUtils.isEmpty(lastThirdMsg2) && (bytes2 = lastThirdMsg2.getBytes()) != null && bytes2.length > 0) {
                        byteArray = concat(byteArray, bytes2);
                    }
                    String lastDebugInfo = VisualizedAutoTrackService.getInstance().getLastDebugInfo();
                    if (!TextUtils.isEmpty(lastDebugInfo) && (bytes = lastDebugInfo.getBytes()) != null && bytes.length > 0) {
                        byteArray = concat(byteArray, bytes);
                    }
                    this.mImageHash = toHex(MessageDigest.getInstance(j.f17955b).digest(byteArray));
                } catch (Exception e10) {
                    SALog.i(ViewSnapshot.TAG, "CachedBitmap.recreate;Create image_hash error=" + e10);
                }
            }
            return;
        }

        public synchronized void writeBitmapJSON(Bitmap.CompressFormat compressFormat, int i10, OutputStream outputStream) throws IOException {
            try {
                Bitmap bitmap = this.mCached;
                if (!(bitmap == null || bitmap.getWidth() == 0)) {
                    if (this.mCached.getHeight() != 0) {
                        outputStream.write(34);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        this.mCached.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        byteArrayOutputStream.flush();
                        outputStream.write(new String(Base64Coder.encode(byteArrayOutputStream.toByteArray())).getBytes());
                        outputStream.write(34);
                    }
                }
                outputStream.write("null".getBytes());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static class ClassNameCache extends LruCache<Class<?>, String> {
        public ClassNameCache(int i10) {
            super(i10);
        }

        /* access modifiers changed from: protected */
        public String create(Class<?> cls) {
            return cls.getCanonicalName();
        }
    }

    private static class RootViewFinder implements Callable<List<RootViewInfo>> {
        private final CachedBitmap mCachedBitmap = new CachedBitmap();
        private final int mClientDensity = 160;
        private final List<RootViewInfo> mRootViews = new ArrayList();

        private static Bitmap getFlutterBitmap(Activity activity) {
            try {
                Method declaredMethod = Class.forName("io.flutter.embedding.android.FlutterActivity").getDeclaredMethod("getFlutterEngine", (Class[]) null);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(activity, (Object[]) null);
                Method method = Class.forName("io.flutter.embedding.engine.FlutterEngine").getMethod("getRenderer", (Class[]) null);
                method.setAccessible(true);
                Object invoke2 = method.invoke(invoke, (Object[]) null);
                Method method2 = Class.forName("io.flutter.embedding.engine.renderer.FlutterRenderer").getMethod("getBitmap", (Class[]) null);
                method2.setAccessible(true);
                return (Bitmap) method2.invoke(invoke2, (Object[]) null);
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
                return null;
            }
        }

        private void scaleBitmap(RootViewInfo rootViewInfo, Bitmap bitmap) {
            float f10 = 1.0f;
            if (bitmap != null) {
                int density = bitmap.getDensity();
                if (density != 0) {
                    f10 = 160.0f / ((float) density);
                }
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int width2 = (int) (((double) (((float) bitmap.getWidth()) * f10)) + 0.5d);
                int height2 = (int) (((double) (((float) bitmap.getHeight()) * f10)) + 0.5d);
                if (width > 0 && height > 0 && width2 > 0 && height2 > 0) {
                    this.mCachedBitmap.recreate(width2, height2, 160, bitmap);
                }
            }
            rootViewInfo.scale = f10;
            rootViewInfo.screenshot = this.mCachedBitmap;
        }

        /* access modifiers changed from: package-private */
        public Bitmap mergeViewLayers(View[] viewArr, RootViewInfo rootViewInfo) {
            boolean z10;
            View[] viewArr2 = viewArr;
            RootViewInfo rootViewInfo2 = rootViewInfo;
            int width = rootViewInfo2.rootView.getWidth();
            int height = rootViewInfo2.rootView.getHeight();
            if (width == 0 || height == 0) {
                int[] deviceSize = DeviceUtils.getDeviceSize(SensorsDataAPI.sharedInstance().getSAContextManager().getContext());
                width = deviceSize[0];
                height = deviceSize[1];
                if (width == 0 || height == 0) {
                    return null;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            SoftWareCanvas softWareCanvas = new SoftWareCanvas(createBitmap);
            int[] iArr = new int[2];
            if (ViewUtil.getMainWindowCount(viewArr) > 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            WindowHelper.init();
            ViewUtil.invalidateLayerTypeView(viewArr);
            boolean z11 = false;
            for (View view : viewArr2) {
                if (view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0 && ViewUtil.isWindowNeedTraverse(view, WindowHelper.getWindowPrefix(view), z10)) {
                    softWareCanvas.save();
                    if (!WindowHelper.isMainWindow(view)) {
                        view.getLocationOnScreen(iArr);
                        softWareCanvas.translate((float) iArr[0], (float) iArr[1]);
                        if (WindowHelper.isDialogOrPopupWindow(view) && !z11) {
                            Paint paint = new Paint();
                            paint.setColor(-1610612736);
                            softWareCanvas.drawRect(-((float) iArr[0]), -((float) iArr[1]), (float) softWareCanvas.getWidth(), (float) softWareCanvas.getHeight(), paint);
                            z11 = true;
                        }
                    }
                    view.draw(softWareCanvas);
                    softWareCanvas.restoreToCount(1);
                }
            }
            softWareCanvas.destroy();
            return createBitmap;
        }

        public List<RootViewInfo> call() throws Exception {
            FlutterNodeInfo flutterNodeInfo;
            this.mRootViews.clear();
            try {
                Activity foregroundActivity = AppStateTools.getInstance().getForegroundActivity();
                if (foregroundActivity != null) {
                    JSONObject activityPageInfo = SAPageInfoUtils.getActivityPageInfo(foregroundActivity);
                    JSONObject rNPageInfo = SAPageInfoUtils.getRNPageInfo();
                    if (activityPageInfo == null) {
                        activityPageInfo = new JSONObject();
                    }
                    JSONUtils.mergeDuplicateProperty(rNPageInfo, activityPageInfo);
                    String optString = activityPageInfo.optString("$screen_name");
                    String optString2 = activityPageInfo.optString("$title");
                    boolean instanceOfFlutterActivity = ViewUtil.instanceOfFlutterActivity(foregroundActivity);
                    if (instanceOfFlutterActivity && (flutterNodeInfo = (FlutterNodeInfo) NodesProcess.getInstance().getFlutterNodesManager().getPageInfo(SnapCache.getInstance().getCanonicalName(foregroundActivity.getClass()))) != null) {
                        String screen_name = flutterNodeInfo.getScreen_name();
                        String title = flutterNodeInfo.getTitle();
                        if (!TextUtils.isEmpty(optString)) {
                            optString = screen_name;
                        }
                        if (!TextUtils.isEmpty(title)) {
                            optString2 = title;
                        }
                    }
                    Window window = foregroundActivity.getWindow();
                    View rootView = (window == null || !window.isActive()) ? null : window.getDecorView().getRootView();
                    if (rootView == null) {
                        return this.mRootViews;
                    }
                    RootViewInfo rootViewInfo = new RootViewInfo(optString, optString2, rootView);
                    View[] sortedWindowViews = WindowHelper.getSortedWindowViews();
                    if (instanceOfFlutterActivity) {
                        scaleBitmap(rootViewInfo, getFlutterBitmap(foregroundActivity));
                        this.mRootViews.add(rootViewInfo);
                    } else if (sortedWindowViews != null && sortedWindowViews.length > 0) {
                        Bitmap mergeViewLayers = mergeViewLayers(sortedWindowViews, rootViewInfo);
                        for (View view : sortedWindowViews) {
                            if (view.getWindowVisibility() == 0 && view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0) {
                                if (!TextUtils.equals(WindowHelper.getWindowPrefix(view), WindowHelper.getMainWindowPrefix())) {
                                    if (!WindowHelper.isCustomWindow(view)) {
                                        RootViewInfo rootViewInfo2 = new RootViewInfo(optString, optString2, view.getRootView());
                                        scaleBitmap(rootViewInfo2, mergeViewLayers);
                                        this.mRootViews.add(rootViewInfo2);
                                    }
                                }
                            }
                        }
                        if (this.mRootViews.size() == 0) {
                            scaleBitmap(rootViewInfo, mergeViewLayers);
                            this.mRootViews.add(rootViewInfo);
                        }
                    }
                }
            } catch (Throwable th) {
                SALog.d(ViewSnapshot.TAG, "" + th);
            }
            return this.mRootViews;
        }
    }

    private static class RootViewInfo {
        final String activityTitle;
        final View rootView;
        float scale = 1.0f;
        final String screenName;
        CachedBitmap screenshot = null;

        RootViewInfo(String str, String str2, View view) {
            this.screenName = str;
            this.activityTitle = str2;
            this.rootView = view;
        }
    }

    public ViewSnapshot(List<PropertyDescription> list, ResourceIds resourceIds, Handler handler) {
        this.mProperties = list;
        this.mResourceIds = resourceIds;
        this.mMainThreadHandler = handler;
        this.mRootViewFinder = new RootViewFinder();
        this.mClassnameCache = new ClassNameCache(255);
    }

    private void addProperties(JSONObject jSONObject, View view) throws Exception {
        Caller caller;
        Object applyMethod;
        jSONObject.put("importantForAccessibility", true);
        Class<?> cls = view.getClass();
        for (PropertyDescription next : this.mProperties) {
            if (!(!next.targetClass.isAssignableFrom(cls) || (caller = next.accessor) == null || (applyMethod = caller.applyMethod(view)) == null)) {
                if (applyMethod instanceof Number) {
                    jSONObject.put(next.name, applyMethod);
                } else if (applyMethod instanceof Boolean) {
                    boolean booleanValue = ((Boolean) applyMethod).booleanValue();
                    if ("clickable".equals(next.name)) {
                        if (VisualUtil.isSupportClick(view)) {
                            booleanValue = true;
                        } else if (VisualUtil.isForbiddenClick(view)) {
                            booleanValue = false;
                        }
                    }
                    jSONObject.put(next.name, booleanValue);
                } else if (applyMethod instanceof ColorStateList) {
                    jSONObject.put(next.name, Integer.valueOf(((ColorStateList) applyMethod).getDefaultColor()));
                } else if (applyMethod instanceof Drawable) {
                    Drawable drawable = (Drawable) applyMethod;
                    Rect bounds = drawable.getBounds();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    Class cls2 = drawable.getClass();
                    while (cls2 != Object.class && cls2 != null) {
                        jSONArray.put(SnapCache.getInstance().getCanonicalName(cls2));
                        cls2 = cls2.getSuperclass();
                    }
                    jSONObject2.put("classes", jSONArray);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("left", bounds.left);
                    jSONObject3.put("right", bounds.right);
                    jSONObject3.put("top", bounds.top);
                    jSONObject3.put("bottom", bounds.bottom);
                    jSONObject2.put("dimensions", jSONObject3);
                    if (drawable instanceof ColorDrawable) {
                        jSONObject2.put("color", ((ColorDrawable) drawable).getColor());
                    }
                    jSONObject.put(next.name, jSONObject2);
                } else {
                    jSONObject.put(next.name, applyMethod.toString());
                }
            }
        }
    }

    private String getResName(View view) {
        int id2 = view.getId();
        if (-1 == id2) {
            return null;
        }
        return this.mResourceIds.nameForId(id2);
    }

    private void getVisibleRect(View view, Rect rect, boolean z10) {
        if (z10) {
            view.getGlobalVisibleRect(rect);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocalVisibleRect(rect);
        rect.offset(iArr[0], iArr[1]);
    }

    private boolean isSnapShotUpdated(String str, StringBuilder sb2) {
        boolean z10;
        boolean z11;
        if (str == null || sb2 == null) {
            z10 = false;
        } else {
            z10 = str.equals(sb2.toString());
        }
        if (!z10 || NodesProcess.getInstance().getWebNodesManager().hasAlertInfo() || NodesProcess.getInstance().getFlutterNodesManager().hasAlertInfo()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (sb2 != null) {
            sb2.delete(0, sb2.length()).append(str);
        }
        return z11;
    }

    private void mergeThirdViewNodes(JSONArray jSONArray, CommonNode commonNode, View view, float f10) {
        boolean z10;
        int i10;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hashCode", commonNode.getId() + view.hashCode());
            jSONObject.put(FirebaseAnalytics.Param.INDEX, 0);
            if (!TextUtils.isEmpty(commonNode.get$element_content())) {
                jSONObject.put("element_content", commonNode.get$element_content());
            }
            SnapInfo snapInfo = this.mSnapInfo;
            int i11 = snapInfo.elementLevel + 1;
            snapInfo.elementLevel = i11;
            jSONObject.put("element_level", i11);
            if (f10 == 0.0f) {
                f10 = commonNode.getScale();
            }
            jSONObject.put("left", (double) (commonNode.getLeft() * f10));
            jSONObject.put("top", (double) (commonNode.getTop() * f10));
            jSONObject.put(Snapshot.WIDTH, (int) (commonNode.getWidth() * f10));
            jSONObject.put(Snapshot.HEIGHT, (int) (commonNode.getHeight() * f10));
            if (commonNode.getOriginTop() * f10 > ((float) view.getHeight()) || commonNode.getOriginLeft() * f10 > ((float) view.getWidth())) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!commonNode.isVisibility() || !z10) {
                i10 = 8;
            } else {
                i10 = 0;
            }
            jSONObject.put("visibility", i10);
            jSONObject.put("clickable", commonNode.isEnable_click());
            jSONObject.put("importantForAccessibility", true);
            jSONObject.put("is_list_view", commonNode.isIs_list_view());
            jSONObject.put("element_path", commonNode.get$element_path());
            if (!TextUtils.isEmpty(commonNode.get$element_position())) {
                jSONObject.put("element_position", commonNode.get$element_position());
            }
            this.mSnapInfo.webLibVersion = commonNode.getLib_version();
            jSONObject.put("scrollX", 0);
            jSONObject.put("scrollY", 0);
            if (commonNode instanceof WebNode) {
                WebNode webNode = (WebNode) commonNode;
                jSONObject.put("h5_title", webNode.get$title());
                jSONObject.put("tag_name", webNode.getTagName());
                jSONObject.put(ImagesContract.URL, webNode.get$url());
                if (!TextUtils.isEmpty(webNode.get$element_selector())) {
                    jSONObject.put("element_selector", webNode.get$element_selector());
                }
                jSONObject.put("list_selector", webNode.getList_selector());
                jSONObject.put("is_h5", true);
                jSONObject.put("element_platform", "h5");
            }
            if (commonNode instanceof FlutterNode) {
                FlutterNode flutterNode = (FlutterNode) commonNode;
                jSONObject.put("title", flutterNode.getTitle());
                jSONObject.put(FirebaseAnalytics.Param.SCREEN_NAME, flutterNode.getScreen_name());
                jSONObject.put("element_platform", "flutter");
            }
            JSONArray jSONArray2 = new JSONArray();
            if (commonNode instanceof WebNode) {
                jSONArray2.put(((WebNode) commonNode).getTagName());
            }
            Class cls = view.getClass();
            do {
                jSONArray2.put(SnapCache.getInstance().getCanonicalName(cls));
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    break;
                }
            } while (cls != null);
            jSONObject.put("classes", jSONArray2);
            List<String> subelements = commonNode.getSubelements();
            JSONArray jSONArray3 = new JSONArray();
            if (subelements != null && subelements.size() > 0) {
                for (String str : subelements) {
                    jSONArray3.put(str + view.hashCode());
                }
            }
            jSONObject.put("subviews", jSONArray3);
            jSONArray.put(jSONObject);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    private void reset() {
        this.mSnapInfo = new SnapInfo();
    }

    private void snapshotFlutterView(JSONArray jSONArray, View view, List<String> list, SnapInfo snapInfo) {
        String str = snapInfo.activityName;
        if (!TextUtils.isEmpty(str)) {
            FlutterNodeInfo flutterNodeInfo = (FlutterNodeInfo) NodesProcess.getInstance().getFlutterNodesManager().getNodes(str);
            if (flutterNodeInfo == null) {
                Dispatcher.getInstance().postDelayed(new AlertMessageUtils.AlertRunnable(AlertMessageUtils.AlertRunnable.AlertType.FLUTTER, str), 5000);
            } else if (flutterNodeInfo.getStatus() == NodeInfo.Status.SUCCESS) {
                List<? extends CommonNode> nodes = flutterNodeInfo.getNodes();
                if (nodes != null && nodes.size() > 0) {
                    Iterator<? extends CommonNode> it = nodes.iterator();
                    while (it.hasNext()) {
                        FlutterNode flutterNode = (FlutterNode) it.next();
                        mergeThirdViewNodes(jSONArray, flutterNode, view, SensorsDataAPI.sharedInstance().getSAContextManager().getContext().getResources().getDisplayMetrics().scaledDensity);
                        if (flutterNode.isRootView()) {
                            list.add(flutterNode.getId() + view.hashCode());
                        }
                    }
                }
            } else if (flutterNodeInfo.getStatus() == NodeInfo.Status.FAILURE) {
                this.mSnapInfo.flutter_alertInfos = flutterNodeInfo.getAlertInfos();
            }
        }
    }

    private void snapshotView(JSONArray jSONArray, final View view, int i10) throws Exception {
        Activity foregroundActivity;
        if (SAViewUtils.isViewSelfVisible(view)) {
            ArrayList<String> arrayList = new ArrayList<>();
            int i11 = this.mSnapInfo.elementLevel;
            if (ViewUtil.instanceOfFlutterSurfaceView(view)) {
                SnapInfo snapInfo = this.mSnapInfo;
                snapInfo.isFlutter = true;
                if (TextUtils.isEmpty(snapInfo.activityName) && (foregroundActivity = AppStateTools.getInstance().getForegroundActivity()) != null) {
                    this.mSnapInfo.activityName = SnapCache.getInstance().getCanonicalName(foregroundActivity.getClass());
                }
                FlutterNodeInfo flutterNodeInfo = (FlutterNodeInfo) NodesProcess.getInstance().getFlutterNodesManager().getPageInfo(this.mSnapInfo.activityName);
                if (flutterNodeInfo != null) {
                    this.mSnapInfo.flutterLibVersion = flutterNodeInfo.getFlutter_lib_version();
                }
                snapshotFlutterView(jSONArray, view, arrayList, this.mSnapInfo);
            }
            if (ViewUtil.instanceOfWebView(view)) {
                this.mSnapInfo.isWebView = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                try {
                    view.post(new Runnable() {
                        public void run() {
                            String str = (String) ReflectUtil.callMethod(view, "getUrl", new Object[0]);
                            if (!TextUtils.isEmpty(str)) {
                                ViewSnapshot.this.mSnapInfo.webViewUrl = str;
                                Float f10 = (Float) ReflectUtil.callMethod(view, "getScale", new Object[0]);
                                if (f10 != null) {
                                    ViewSnapshot.this.mSnapInfo.webViewScale = f10.floatValue();
                                }
                                countDownLatch.countDown();
                                WebUtils.loadUrl(view, "javascript:window.sensorsdata_app_call_js('visualized')");
                                return;
                            }
                            countDownLatch.countDown();
                        }
                    });
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
                try {
                    countDownLatch.await(500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e11) {
                    SALog.printStackTrace(e11);
                }
                SALog.i(TAG, "WebView url: " + this.mSnapInfo.webViewUrl);
                if (!TextUtils.isEmpty(this.mSnapInfo.webViewUrl)) {
                    WebNodeInfo webNodeInfo = (WebNodeInfo) NodesProcess.getInstance().getWebNodesManager().getNodes(this.mSnapInfo.webViewUrl);
                    if (webNodeInfo == null) {
                        Dispatcher.getInstance().postDelayed(new AlertMessageUtils.AlertRunnable(AlertMessageUtils.AlertRunnable.AlertType.H5, this.mSnapInfo.webViewUrl), 5000);
                    } else if (webNodeInfo.getStatus() == NodeInfo.Status.SUCCESS) {
                        List<? extends CommonNode> nodes = webNodeInfo.getNodes();
                        if (nodes != null && nodes.size() > 0) {
                            arrayList = new ArrayList<>();
                            Iterator<? extends CommonNode> it = nodes.iterator();
                            while (it.hasNext()) {
                                WebNode webNode = (WebNode) it.next();
                                mergeThirdViewNodes(jSONArray, webNode, view, this.mSnapInfo.webViewScale);
                                if (webNode.isRootView()) {
                                    arrayList.add(webNode.getId() + view.hashCode());
                                }
                            }
                        }
                    } else if (webNodeInfo.getStatus() == NodeInfo.Status.FAILURE) {
                        this.mSnapInfo.alertInfos = webNodeInfo.getAlertInfos();
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hashCode", view.hashCode());
            jSONObject.put("id", view.getId());
            jSONObject.put(FirebaseAnalytics.Param.INDEX, SAViewUtils.getChildIndex(view.getParent(), view));
            if (ViewUtil.instanceOfWebView(view) || ViewUtil.instanceOfFlutterSurfaceView(view)) {
                jSONObject.put("element_level", i11);
            } else {
                SnapInfo snapInfo2 = this.mSnapInfo;
                int i12 = snapInfo2.elementLevel + 1;
                snapInfo2.elementLevel = i12;
                jSONObject.put("element_level", i12);
            }
            jSONObject.put("element_selector", SAViewUtils.getElementSelector(view));
            JSONObject screenNameAndTitle = VisualUtil.getScreenNameAndTitle(view, this.mSnapInfo);
            if (screenNameAndTitle != null) {
                String optString = screenNameAndTitle.optString("$screen_name");
                String optString2 = screenNameAndTitle.optString("$title");
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject.put(FirebaseAnalytics.Param.SCREEN_NAME, optString);
                }
                if (!TextUtils.isEmpty(optString2)) {
                    jSONObject.put("title", optString2);
                }
            }
            ViewNode viewNode = ViewUtil.getViewNode(view, i10, true);
            if (viewNode != null) {
                if (!TextUtils.isEmpty(viewNode.getViewPath())) {
                    jSONObject.put("element_path", viewNode.getViewPath());
                }
                if (!TextUtils.isEmpty(viewNode.getViewPosition())) {
                    jSONObject.put("element_position", viewNode.getViewPosition());
                }
                if (!TextUtils.isEmpty(viewNode.getViewContent()) && VisualUtil.isSupportElementContent(view)) {
                    jSONObject.put("element_content", viewNode.getViewContent());
                }
                jSONObject.put("is_list_view", viewNode.isListView());
            }
            jSONObject.put("element_platform", f.f17924q);
            jSONObject.put("sa_id_name", getResName(view));
            try {
                String str = (String) view.getTag(R.id.sensors_analytics_tag_view_id);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("sa_id_name", str);
                }
            } catch (Exception e12) {
                SALog.printStackTrace(e12);
            }
            if (WindowHelper.isMainWindow(view.getRootView())) {
                jSONObject.put("top", view.getTop());
                jSONObject.put("left", view.getLeft());
                jSONObject.put(Snapshot.WIDTH, view.getWidth());
                jSONObject.put(Snapshot.HEIGHT, view.getHeight());
            } else if (WindowHelper.isDecorView(view.getClass())) {
                DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
                int i13 = displayMetrics.widthPixels;
                int i14 = displayMetrics.heightPixels;
                jSONObject.put("top", view.getTop());
                jSONObject.put("left", view.getLeft());
                jSONObject.put(Snapshot.WIDTH, i13);
                jSONObject.put(Snapshot.HEIGHT, i14);
            } else {
                ViewParent parent = view.getParent();
                if (parent == null || !WindowHelper.isDecorView(parent.getClass())) {
                    jSONObject.put("top", view.getTop());
                    jSONObject.put("left", view.getLeft());
                    jSONObject.put(Snapshot.WIDTH, view.getWidth());
                    jSONObject.put(Snapshot.HEIGHT, view.getHeight());
                } else {
                    Rect rect = new Rect();
                    getVisibleRect(view, rect, false);
                    jSONObject.put("top", rect.top);
                    jSONObject.put("left", rect.left);
                    jSONObject.put(Snapshot.WIDTH, rect.width());
                    jSONObject.put(Snapshot.HEIGHT, rect.height());
                }
            }
            int scrollX = view.getScrollX();
            if ((view instanceof TextView) && ((TextView) view).getMaxLines() == 1) {
                scrollX = 0;
            }
            if (ViewUtil.instanceOfX5WebView(view)) {
                try {
                    jSONObject.put("scrollX", ReflectUtil.callMethod(view, "getWebScrollX", new Object[0]));
                    jSONObject.put("scrollY", ReflectUtil.callMethod(view, "getWebScrollY", new Object[0]));
                } catch (Exception e13) {
                    SALog.printStackTrace(e13);
                }
            } else {
                jSONObject.put("scrollX", scrollX);
                jSONObject.put("scrollY", view.getScrollY());
            }
            jSONObject.put("visibility", VisualUtil.getVisibility(view));
            float translationX = view.getTranslationX();
            float translationY = view.getTranslationY();
            jSONObject.put("translationX", (double) translationX);
            jSONObject.put("translationY", (double) translationY);
            JSONArray jSONArray2 = new JSONArray();
            Class cls = view.getClass();
            do {
                jSONArray2.put(this.mClassnameCache.get(cls));
                cls = cls.getSuperclass();
                if (cls == Object.class) {
                    break;
                }
            } while (cls != null);
            jSONObject.put("classes", jSONArray2);
            addProperties(jSONObject, view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int[] rules = ((RelativeLayout.LayoutParams) layoutParams).getRules();
                JSONArray jSONArray3 = new JSONArray();
                for (int put : rules) {
                    jSONArray3.put(put);
                }
                jSONObject.put("layoutRules", jSONArray3);
            }
            JSONArray jSONArray4 = new JSONArray();
            if (arrayList.size() > 0) {
                for (String put2 : arrayList) {
                    jSONArray4.put(put2);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i15 = 0; i15 < childCount; i15++) {
                    View childAt = viewGroup.getChildAt(i15);
                    if (childAt != null) {
                        jSONArray4.put(childAt.hashCode());
                    }
                }
            }
            jSONObject.put("subviews", jSONArray4);
            jSONArray.put(jSONObject);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            int childCount2 = viewGroup2.getChildCount();
            for (int i16 = 0; i16 < childCount2; i16++) {
                View childAt2 = viewGroup2.getChildAt(i16);
                if (childAt2 != null) {
                    snapshotView(jSONArray, childAt2, i16);
                }
            }
        }
    }

    private void snapshotViewHierarchy(JSONArray jSONArray, View view) throws Exception {
        reset();
        snapshotView(jSONArray, view, 0);
        NodesProcess.getInstance().getWebNodesManager().setHasThirdView(this.mSnapInfo.isWebView);
        NodesProcess.getInstance().getFlutterNodesManager().setHasThirdView(this.mSnapInfo.isFlutter);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo snapshots(java.io.OutputStream r18, java.lang.StringBuilder r19) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r4 = 1
            java.lang.String r5 = "SA.ViewSnapshot"
            long r6 = java.lang.System.currentTimeMillis()
            java.util.concurrent.FutureTask r8 = new java.util.concurrent.FutureTask
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$RootViewFinder r0 = r1.mRootViewFinder
            r8.<init>(r0)
            android.os.Handler r0 = r1.mMainThreadHandler
            r0.post(r8)
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream
            r9.<init>(r2)
            java.util.List r10 = java.util.Collections.emptyList()
            java.lang.String r0 = "["
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0043, TimeoutException -> 0x0041, ExecutionException -> 0x003f, all -> 0x003d }
            r11 = 2
            java.lang.Object r0 = r8.get(r11, r0)     // Catch:{ InterruptedException -> 0x0043, TimeoutException -> 0x0041, ExecutionException -> 0x003f, all -> 0x003d }
            java.util.List r0 = (java.util.List) r0     // Catch:{ InterruptedException -> 0x0043, TimeoutException -> 0x0041, ExecutionException -> 0x003f, all -> 0x003d }
            r8.cancel(r4)
            android.os.Handler r10 = r1.mMainThreadHandler
            r10.removeCallbacks(r8)
            r10 = r0
            goto L_0x0069
        L_0x003d:
            r0 = move-exception
            goto L_0x0045
        L_0x003f:
            r0 = move-exception
            goto L_0x0057
        L_0x0041:
            r0 = move-exception
            goto L_0x005d
        L_0x0043:
            r0 = move-exception
            goto L_0x0063
        L_0x0045:
            java.lang.String r11 = "Throwable thrown during screenshot attempt"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r11, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0053 }
        L_0x004a:
            r8.cancel(r4)
            android.os.Handler r0 = r1.mMainThreadHandler
            r0.removeCallbacks(r8)
            goto L_0x0069
        L_0x0053:
            r0 = move-exception
            r2 = r4
            goto L_0x01f0
        L_0x0057:
            java.lang.String r11 = "Exception thrown during screenshot attempt"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r11, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0053 }
            goto L_0x004a
        L_0x005d:
            java.lang.String r11 = "Screenshot took more than 2 second to be scheduled and executed. No screenshot will be sent."
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r11, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0053 }
            goto L_0x004a
        L_0x0063:
            java.lang.String r11 = "Screenshot interrupted, no screenshot will be sent."
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r11, (java.lang.Throwable) r0)     // Catch:{ all -> 0x01ee }
            goto L_0x004a
        L_0x0069:
            int r8 = r10.size()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r11 = "infoCount:"
            r0.append(r11)
            r0.append(r8)
            java.lang.String r11 = ",time:"
            r0.append(r11)
            long r11 = java.lang.System.currentTimeMillis()
            long r11 = r11 - r6
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)
            r0 = 0
            r11 = r0
            r12 = 0
        L_0x0091:
            if (r12 >= r8) goto L_0x01b7
            java.lang.Object r13 = r10.get(r12)
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$RootViewInfo r13 = (com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.RootViewInfo) r13
            java.lang.String r14 = ","
            if (r12 <= 0) goto L_0x00a4
            byte[] r15 = r14.getBytes()
            r9.write(r15)
        L_0x00a4:
            if (r13 == 0) goto L_0x00b9
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$CachedBitmap r15 = r13.screenshot
            if (r15 == 0) goto L_0x00b9
            java.lang.String r15 = r15.getImageHash()
            r3 = r19
            boolean r15 = r1.isSnapShotUpdated(r15, r3)
            if (r15 != 0) goto L_0x00bd
            if (r12 <= 0) goto L_0x00b9
            goto L_0x00bd
        L_0x00b9:
            r16 = 0
            goto L_0x01a9
        L_0x00bd:
            java.lang.String r0 = "{"
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            java.lang.String r0 = "\"activity\":"
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            java.lang.String r11 = r13.screenName
            java.lang.String r15 = r13.activityTitle
            java.lang.String r0 = org.json.JSONObject.quote(r11)
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            byte[] r0 = r14.getBytes()
            r9.write(r0)
            java.lang.String r0 = "\"scale\":"
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            float r0 = r13.scale
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.Object[] r3 = new java.lang.Object[r4]
            r16 = 0
            r3[r16] = r0
            java.lang.String r0 = "%s"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            byte[] r0 = r14.getBytes()
            r9.write(r0)
            java.lang.String r0 = "\"serialized_objects\":"
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x015b }
            r0.<init>()     // Catch:{ Exception -> 0x015b }
            java.lang.String r3 = "rootObject"
            android.view.View r4 = r13.rootView     // Catch:{ Exception -> 0x015b }
            int r4 = r4.hashCode()     // Catch:{ Exception -> 0x015b }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x015b }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x015b }
            r3.<init>()     // Catch:{ Exception -> 0x015b }
            android.view.View r4 = r13.rootView     // Catch:{ Exception -> 0x015b }
            r1.snapshotViewHierarchy(r3, r4)     // Catch:{ Exception -> 0x015b }
            java.lang.String r4 = "objects"
            r0.put(r4, r3)     // Catch:{ Exception -> 0x015b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x015b }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x015b }
            r9.write(r0)     // Catch:{ Exception -> 0x015b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015b }
            r0.<init>()     // Catch:{ Exception -> 0x015b }
            java.lang.String r3 = "snapshotViewHierarchy:"
            r0.append(r3)     // Catch:{ Exception -> 0x015b }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x015b }
            long r3 = r3 - r6
            r0.append(r3)     // Catch:{ Exception -> 0x015b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x015b }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x015b }
            goto L_0x015f
        L_0x015b:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x015f:
            byte[] r0 = r14.getBytes()
            r9.write(r0)
            java.lang.String r0 = "\"image_hash\":"
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$CachedBitmap r0 = r13.screenshot
            java.lang.String r0 = r0.getImageHash()
            java.lang.String r0 = org.json.JSONObject.quote(r0)
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            byte[] r0 = r14.getBytes()
            r9.write(r0)
            java.lang.String r0 = "\"screenshot\":"
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            r9.flush()
            com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot$CachedBitmap r0 = r13.screenshot
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG
            r4 = 70
            r0.writeBitmapJSON(r3, r4, r2)
            java.lang.String r0 = "}"
            byte[] r0 = r0.getBytes()
            r9.write(r0)
            r0 = r11
            r11 = r15
        L_0x01a7:
            r3 = 1
            goto L_0x01b3
        L_0x01a9:
            java.lang.String r3 = "{}"
            byte[] r3 = r3.getBytes()
            r9.write(r3)
            goto L_0x01a7
        L_0x01b3:
            int r12 = r12 + r3
            r4 = r3
            goto L_0x0091
        L_0x01b7:
            java.lang.String r2 = "]"
            byte[] r2 = r2.getBytes()
            r9.write(r2)
            r9.flush()
            com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r2 = r1.mSnapInfo
            r2.screenName = r0
            r2.activityTitle = r11
            com.sensorsdata.analytics.android.sdk.util.AppStateTools r0 = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance()
            android.app.Activity r0 = r0.getForegroundActivity()
            if (r0 == 0) goto L_0x01eb
            com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r2 = r1.mSnapInfo
            boolean r3 = com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.instanceOfFlutterActivity(r0)
            r2.isFlutter = r3
            com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r2 = r1.mSnapInfo
            com.sensorsdata.analytics.android.sdk.util.SnapCache r3 = com.sensorsdata.analytics.android.sdk.util.SnapCache.getInstance()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r3.getCanonicalName(r0)
            r2.activityName = r0
        L_0x01eb:
            com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo r0 = r1.mSnapInfo
            return r0
        L_0x01ee:
            r0 = move-exception
            r2 = 1
        L_0x01f0:
            r8.cancel(r2)
            android.os.Handler r2 = r1.mMainThreadHandler
            r2.removeCallbacks(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot.snapshots(java.io.OutputStream, java.lang.StringBuilder):com.sensorsdata.analytics.android.sdk.visual.model.SnapInfo");
    }
}
