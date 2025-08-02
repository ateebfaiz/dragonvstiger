package f7;

import com.facebook.fbreact.specs.NativeAccessibilityInfoSpec;
import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.fbreact.specs.NativeBlobModuleSpec;
import com.facebook.fbreact.specs.NativeDevToolsSettingsManagerSpec;
import com.facebook.fbreact.specs.NativeDialogManagerAndroidSpec;
import com.facebook.fbreact.specs.NativeFileReaderModuleSpec;
import com.facebook.fbreact.specs.NativeI18nManagerSpec;
import com.facebook.fbreact.specs.NativeIntentAndroidSpec;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.fbreact.specs.NativePermissionsAndroidSpec;
import com.facebook.fbreact.specs.NativeShareModuleSpec;
import com.facebook.fbreact.specs.NativeSoundManagerSpec;
import com.facebook.fbreact.specs.NativeVibrationSpec;
import com.facebook.fbreact.specs.NativeWebSocketModuleSpec;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.devloading.DevLoadingModule;
import com.facebook.react.modules.devtoolssettings.DevToolsSettingsManagerModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.sound.SoundManagerModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.v0;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.unimplementedview.ReactUnimplementedViewManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import t6.a;
import z4.l;

public class s extends v0 implements w0 {

    /* renamed from: a  reason: collision with root package name */
    private Map f12068a;

    public s(a aVar) {
    }

    private static void f(Map map, String str, Provider provider) {
        map.put(str, ModuleSpec.viewManagerSpec(provider));
    }

    private a g() {
        Class[] clsArr = {AccessibilityInfoModule.class, AppearanceModule.class, AppStateModule.class, BlobModule.class, DevLoadingModule.class, FileReaderModule.class, ClipboardModule.class, DialogModule.class, FrescoModule.class, I18nManagerModule.class, ImageLoaderModule.class, ImageStoreManager.class, IntentModule.class, NativeAnimatedModule.class, NetworkingModule.class, PermissionsModule.class, DevToolsSettingsManagerModule.class, ShareModule.class, StatusBarModule.class, SoundManagerModule.class, ToastModule.class, VibrationModule.class, WebSocketModule.class};
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < 23; i10++) {
            Class cls = clsArr[i10];
            s6.a aVar = (s6.a) cls.getAnnotation(s6.a.class);
            if (aVar != null) {
                hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.isCxxModule(), ReactModuleInfo.b(cls)));
            }
        }
        return new i(hashMap);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Map i(Map map) {
        return map;
    }

    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        ModuleSpec moduleSpec = (ModuleSpec) h().get(str);
        if (moduleSpec != null) {
            return (ViewManager) moduleSpec.getProvider().get();
        }
        return null;
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReactDrawerLayoutManager());
        arrayList.add(new ReactHorizontalScrollViewManager());
        arrayList.add(new ReactHorizontalScrollContainerViewManager());
        arrayList.add(new ReactProgressBarViewManager());
        arrayList.add(new ReactScrollViewManager());
        arrayList.add(new ReactSwitchManager());
        arrayList.add(new SwipeRefreshLayoutManager());
        arrayList.add(new FrescoBasedReactTextInlineImageViewManager());
        arrayList.add(new ReactImageManager());
        arrayList.add(new ReactModalHostManager());
        arrayList.add(new ReactRawTextManager());
        arrayList.add(new ReactTextInputManager());
        arrayList.add(new ReactTextViewManager());
        arrayList.add(new ReactViewManager());
        arrayList.add(new ReactVirtualTextViewManager());
        arrayList.add(new ReactUnimplementedViewManager());
        return arrayList;
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -2115067288:
                if (str.equals("ToastAndroid")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1962922905:
                if (str.equals("ImageStoreManager")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1850625090:
                if (str.equals(NativeSoundManagerSpec.NAME)) {
                    c10 = 2;
                    break;
                }
                break;
            case -1654566518:
                if (str.equals(NativeDialogManagerAndroidSpec.NAME)) {
                    c10 = 3;
                    break;
                }
                break;
            case -1344126773:
                if (str.equals(NativeFileReaderModuleSpec.NAME)) {
                    c10 = 4;
                    break;
                }
                break;
            case -1062061717:
                if (str.equals(NativePermissionsAndroidSpec.NAME)) {
                    c10 = 5;
                    break;
                }
                break;
            case -657277650:
                if (str.equals("ImageLoader")) {
                    c10 = 6;
                    break;
                }
                break;
            case -570370161:
                if (str.equals(NativeI18nManagerSpec.NAME)) {
                    c10 = 7;
                    break;
                }
                break;
            case -504784764:
                if (str.equals("Appearance")) {
                    c10 = 8;
                    break;
                }
                break;
            case -457866500:
                if (str.equals(NativeAccessibilityInfoSpec.NAME)) {
                    c10 = 9;
                    break;
                }
                break;
            case -382654004:
                if (str.equals("StatusBarManager")) {
                    c10 = 10;
                    break;
                }
                break;
            case -254310125:
                if (str.equals(NativeWebSocketModuleSpec.NAME)) {
                    c10 = 11;
                    break;
                }
                break;
            case -99249460:
                if (str.equals("DevLoadingView")) {
                    c10 = 12;
                    break;
                }
                break;
            case 163245714:
                if (str.equals(FrescoModule.NAME)) {
                    c10 = 13;
                    break;
                }
                break;
            case 403570038:
                if (str.equals("Clipboard")) {
                    c10 = 14;
                    break;
                }
                break;
            case 443276868:
                if (str.equals(NativeDevToolsSettingsManagerSpec.NAME)) {
                    c10 = 15;
                    break;
                }
                break;
            case 563961875:
                if (str.equals(NativeIntentAndroidSpec.NAME)) {
                    c10 = 16;
                    break;
                }
                break;
            case 1221389072:
                if (str.equals("AppState")) {
                    c10 = 17;
                    break;
                }
                break;
            case 1515242260:
                if (str.equals(NativeNetworkingAndroidSpec.NAME)) {
                    c10 = 18;
                    break;
                }
                break;
            case 1547941001:
                if (str.equals(NativeBlobModuleSpec.NAME)) {
                    c10 = 19;
                    break;
                }
                break;
            case 1555425035:
                if (str.equals(NativeShareModuleSpec.NAME)) {
                    c10 = 20;
                    break;
                }
                break;
            case 1721274886:
                if (str.equals(NativeAnimatedModuleSpec.NAME)) {
                    c10 = 21;
                    break;
                }
                break;
            case 1922110066:
                if (str.equals(NativeVibrationSpec.NAME)) {
                    c10 = 22;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new ToastModule(reactApplicationContext);
            case 1:
                return new ImageStoreManager(reactApplicationContext);
            case 2:
                return new SoundManagerModule(reactApplicationContext);
            case 3:
                return new DialogModule(reactApplicationContext);
            case 4:
                return new FileReaderModule(reactApplicationContext);
            case 5:
                return new PermissionsModule(reactApplicationContext);
            case 6:
                return new ImageLoaderModule(reactApplicationContext);
            case 7:
                return new I18nManagerModule(reactApplicationContext);
            case 8:
                return new AppearanceModule(reactApplicationContext);
            case 9:
                return new AccessibilityInfoModule(reactApplicationContext);
            case 10:
                return new StatusBarModule(reactApplicationContext);
            case 11:
                return new WebSocketModule(reactApplicationContext);
            case 12:
                return new DevLoadingModule(reactApplicationContext);
            case 13:
                return new FrescoModule(reactApplicationContext, true, (l) null);
            case 14:
                return new ClipboardModule(reactApplicationContext);
            case 15:
                return new DevToolsSettingsManagerModule(reactApplicationContext);
            case 16:
                return new IntentModule(reactApplicationContext);
            case 17:
                return new AppStateModule(reactApplicationContext);
            case 18:
                return new NetworkingModule(reactApplicationContext);
            case 19:
                return new BlobModule(reactApplicationContext);
            case 20:
                return new ShareModule(reactApplicationContext);
            case 21:
                return new NativeAnimatedModule(reactApplicationContext);
            case 22:
                return new VibrationModule(reactApplicationContext);
            default:
                return null;
        }
    }

    public a getReactModuleInfoProvider() {
        if (!e6.a.a()) {
            return g();
        }
        try {
            return (a) e6.a.b("com.facebook.react.shell.MainReactPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return g();
        } catch (InstantiationException e10) {
            throw new RuntimeException("No ReactModuleInfoProvider for com.facebook.react.shell.MainReactPackage$$ReactModuleInfoProvider", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("No ReactModuleInfoProvider for com.facebook.react.shell.MainReactPackage$$ReactModuleInfoProvider", e11);
        }
    }

    public Collection getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        return h().keySet();
    }

    public List getViewManagers(ReactApplicationContext reactApplicationContext) {
        return new ArrayList(h().values());
    }

    public Map h() {
        if (this.f12068a == null) {
            HashMap hashMap = new HashMap();
            f(hashMap, ReactDrawerLayoutManager.REACT_CLASS, new b());
            f(hashMap, ReactHorizontalScrollViewManager.REACT_CLASS, new p());
            f(hashMap, ReactHorizontalScrollContainerViewManager.REACT_CLASS, new q());
            f(hashMap, ReactProgressBarViewManager.REACT_CLASS, new r());
            f(hashMap, ReactScrollViewManager.REACT_CLASS, new c());
            f(hashMap, ReactSwitchManager.REACT_CLASS, new d());
            f(hashMap, SwipeRefreshLayoutManager.REACT_CLASS, new e());
            f(hashMap, FrescoBasedReactTextInlineImageViewManager.REACT_CLASS, new f());
            f(hashMap, ReactImageManager.REACT_CLASS, new g());
            f(hashMap, ReactModalHostManager.REACT_CLASS, new h());
            f(hashMap, ReactRawTextManager.REACT_CLASS, new j());
            f(hashMap, ReactTextInputManager.REACT_CLASS, new k());
            f(hashMap, ReactTextViewManager.REACT_CLASS, new l());
            f(hashMap, ReactViewManager.REACT_CLASS, new m());
            f(hashMap, ReactVirtualTextViewManager.REACT_CLASS, new n());
            f(hashMap, ReactUnimplementedViewManager.REACT_CLASS, new o());
            this.f12068a = hashMap;
        }
        return this.f12068a;
    }
}
