package com.reactnative.ivpusic.imagepicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import com.yalantis.ucrop.a;
import com.zing.zalo.zalosdk.common.Constant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import w6.h;

class PickerModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final int CAMERA_PICKER_REQUEST = 61111;
    private static final String E_ACTIVITY_DOES_NOT_EXIST = "E_ACTIVITY_DOES_NOT_EXIST";
    private static final String E_CALLBACK_ERROR = "E_CALLBACK_ERROR";
    private static final String E_CAMERA_IS_NOT_AVAILABLE = "E_CAMERA_IS_NOT_AVAILABLE";
    private static final String E_CANNOT_LAUNCH_CAMERA = "E_CANNOT_LAUNCH_CAMERA";
    private static final String E_ERROR_WHILE_CLEANING_FILES = "E_ERROR_WHILE_CLEANING_FILES";
    private static final String E_FAILED_TO_OPEN_CAMERA = "E_FAILED_TO_OPEN_CAMERA";
    private static final String E_FAILED_TO_SHOW_PICKER = "E_FAILED_TO_SHOW_PICKER";
    private static final String E_NO_CAMERA_PERMISSION_KEY = "E_NO_CAMERA_PERMISSION";
    private static final String E_NO_CAMERA_PERMISSION_MSG = "User did not grant camera permission.";
    private static final String E_NO_IMAGE_DATA_FOUND = "E_NO_IMAGE_DATA_FOUND";
    private static final String E_NO_LIBRARY_PERMISSION_KEY = "E_NO_LIBRARY_PERMISSION";
    private static final String E_NO_LIBRARY_PERMISSION_MSG = "User did not grant library permission.";
    private static final String E_PICKER_CANCELLED_KEY = "E_PICKER_CANCELLED";
    private static final String E_PICKER_CANCELLED_MSG = "User cancelled image selection";
    private static final int IMAGE_PICKER_REQUEST = 61110;
    /* access modifiers changed from: private */
    public a compression = new a();
    private String cropperActiveWidgetColor = null;
    private boolean cropperCircleOverlay = false;
    private String cropperStatusBarColor = null;
    private String cropperToolbarColor = null;
    private String cropperToolbarTitle = null;
    private String cropperToolbarWidgetColor = null;
    private boolean cropping = false;
    private boolean disableCropperColorSetters = false;
    private boolean enableRotationGesture = false;
    private boolean freeStyleCropEnabled = false;
    private int height = 0;
    private boolean hideBottomControls = false;
    private boolean includeBase64 = false;
    private boolean includeExif = false;
    private Uri mCameraCaptureURI;
    private String mCurrentMediaPath;
    private String mediaType = "any";
    private boolean multiple = false;
    /* access modifiers changed from: private */
    public ReadableMap options;
    private ReactApplicationContext reactContext;
    /* access modifiers changed from: private */
    public f resultCollector = new f();
    private boolean showCropFrame = true;
    private boolean showCropGuidelines = true;
    private boolean useFrontCamera = false;
    private int width = 0;

    class a implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PickerModule f11160a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f11161b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f11162c;

        a(PickerModule pickerModule, Activity activity, Promise promise) {
            this.f11160a = pickerModule;
            this.f11161b = activity;
            this.f11162c = promise;
        }

        /* renamed from: a */
        public Void call() {
            try {
                File file = new File(this.f11160a.getTmpDir(this.f11161b));
                if (file.exists()) {
                    this.f11160a.deleteRecursive(file);
                    this.f11162c.resolve((Object) null);
                    return null;
                }
                throw new Exception("File does not exist");
            } catch (Exception e10) {
                e10.printStackTrace();
                this.f11162c.reject(PickerModule.E_ERROR_WHILE_CLEANING_FILES, e10.getMessage());
            }
        }
    }

    class b implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11164a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PickerModule f11165b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f11166c;

        b(String str, PickerModule pickerModule, Promise promise) {
            this.f11164a = str;
            this.f11165b = pickerModule;
            this.f11166c = promise;
        }

        /* renamed from: a */
        public Void call() {
            try {
                String str = this.f11164a;
                if (str.startsWith("file://")) {
                    str = str.substring(7);
                }
                File file = new File(str);
                if (file.exists()) {
                    this.f11165b.deleteRecursive(file);
                    this.f11166c.resolve((Object) null);
                    return null;
                }
                throw new Exception("File does not exist. Path: " + str);
            } catch (Exception e10) {
                e10.printStackTrace();
                this.f11166c.reject(PickerModule.E_ERROR_WHILE_CLEANING_FILES, e10.getMessage());
            }
        }
    }

    class c implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f11168a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callable f11169b;

        c(Promise promise, Callable callable) {
            this.f11168a = promise;
            this.f11169b = callable;
        }

        public boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
            if (i10 == 1) {
                for (int i11 = 0; i11 < strArr.length; i11++) {
                    String str = strArr[i11];
                    if (iArr[i11] == -1) {
                        if (str.equals("android.permission.CAMERA")) {
                            this.f11168a.reject(PickerModule.E_NO_CAMERA_PERMISSION_KEY, PickerModule.E_NO_CAMERA_PERMISSION_MSG);
                        } else if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                            this.f11168a.reject(PickerModule.E_NO_LIBRARY_PERMISSION_KEY, PickerModule.E_NO_LIBRARY_PERMISSION_MSG);
                        } else {
                            this.f11168a.reject(PickerModule.E_NO_LIBRARY_PERMISSION_KEY, "Required permission missing");
                        }
                        return true;
                    }
                }
                try {
                    this.f11169b.call();
                } catch (Exception e10) {
                    this.f11168a.reject(PickerModule.E_CALLBACK_ERROR, "Unknown error", (Throwable) e10);
                }
            }
            return true;
        }
    }

    class d implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f11171a;

        d(Activity activity) {
            this.f11171a = activity;
        }

        /* renamed from: a */
        public Void call() {
            PickerModule.this.initiateCamera(this.f11171a);
            return null;
        }
    }

    class e implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f11173a;

        e(Activity activity) {
            this.f11173a = activity;
        }

        /* renamed from: a */
        public Void call() {
            PickerModule.this.initiatePicker(this.f11173a);
            return null;
        }
    }

    class f implements Callable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f11175a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Uri f11176b;

        f(Activity activity, Uri uri) {
            this.f11175a = activity;
            this.f11176b = uri;
        }

        /* renamed from: a */
        public Void call() {
            PickerModule.this.startCropping(this.f11175a, this.f11176b);
            return null;
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f11178a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11179b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f11180c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f11181d;

        class a implements Callback {
            a() {
            }

            public void invoke(Object... objArr) {
                String str = objArr[0];
                try {
                    Bitmap i10 = PickerModule.this.validateVideo(str);
                    long lastModified = new File(str).lastModified();
                    long longValue = PickerModule.getVideoDuration(str).longValue();
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putInt(Snapshot.WIDTH, i10.getWidth());
                    writableNativeMap.putInt(Snapshot.HEIGHT, i10.getHeight());
                    writableNativeMap.putString("mime", g.this.f11181d);
                    writableNativeMap.putInt("size", (int) new File(str).length());
                    writableNativeMap.putInt("duration", (int) longValue);
                    writableNativeMap.putString("path", "file://" + str);
                    writableNativeMap.putString("modificationDate", String.valueOf(lastModified));
                    PickerModule.this.resultCollector.d(writableNativeMap);
                } catch (Exception e10) {
                    PickerModule.this.resultCollector.c(PickerModule.E_NO_IMAGE_DATA_FOUND, e10);
                }
            }
        }

        class b implements Callback {
            b() {
            }

            public void invoke(Object... objArr) {
                WritableNativeMap writableNativeMap = objArr[0];
                PickerModule.this.resultCollector.b(writableNativeMap.getString(Constant.PARAM_OAUTH_CODE), writableNativeMap.getString("message"));
            }
        }

        g(Activity activity, String str, String str2, String str3) {
            this.f11178a = activity;
            this.f11179b = str;
            this.f11180c = str2;
            this.f11181d = str3;
        }

        public void run() {
            PickerModule.this.compression.d(this.f11178a, PickerModule.this.options, this.f11179b, this.f11180c, new PromiseImpl(new a(), new b()));
        }
    }

    PickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.reactContext = reactApplicationContext;
    }

    private void cameraPickerResult(Activity activity, int i10, int i11, Intent intent) {
        if (i11 == 0) {
            this.resultCollector.b(E_PICKER_CANCELLED_KEY, E_PICKER_CANCELLED_MSG);
        } else if (i11 == -1) {
            Uri uri = this.mCameraCaptureURI;
            if (uri == null) {
                this.resultCollector.b(E_NO_IMAGE_DATA_FOUND, "Cannot resolve image url");
            } else if (this.cropping) {
                new a.C0132a().e(Bitmap.CompressFormat.JPEG);
                startCropping(activity, uri);
            } else {
                try {
                    this.resultCollector.e(1);
                    WritableMap selection = getSelection(activity, uri, true);
                    if (selection != null) {
                        this.resultCollector.d(selection);
                    }
                } catch (Exception e10) {
                    this.resultCollector.b(E_NO_IMAGE_DATA_FOUND, e10.getMessage());
                }
            }
        }
    }

    private void configureCropperColors(a.C0132a aVar) {
        String str = this.cropperActiveWidgetColor;
        if (str != null) {
            aVar.b(Color.parseColor(str));
        }
        String str2 = this.cropperToolbarColor;
        if (str2 != null) {
            aVar.l(Color.parseColor(str2));
        }
        String str3 = this.cropperStatusBarColor;
        if (str3 != null) {
            aVar.k(Color.parseColor(str3));
        }
        String str4 = this.cropperToolbarWidgetColor;
        if (str4 != null) {
            aVar.n(Color.parseColor(str4));
        }
    }

    private File createExternalStoragePrivateFile(Context context, Uri uri) throws FileNotFoundException {
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        String extension = getExtension(context, uri);
        File externalCacheDir = context.getExternalCacheDir();
        File file = new File(externalCacheDir, "/temp/" + System.currentTimeMillis() + com.alibaba.pdns.f.G + extension);
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[openInputStream.available()];
            openInputStream.read(bArr);
            fileOutputStream.write(bArr);
            openInputStream.close();
            fileOutputStream.close();
        } catch (IOException e10) {
            Log.w("image-crop-picker", "Error writing " + file, e10);
        }
        return file;
    }

    private File createImageFile() throws IOException {
        String str = "image-" + UUID.randomUUID().toString();
        File externalFilesDir = this.reactContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!externalFilesDir.exists() && !externalFilesDir.isDirectory()) {
            externalFilesDir.mkdirs();
        }
        File createTempFile = File.createTempFile(str, ".jpg", externalFilesDir);
        this.mCurrentMediaPath = "file:" + createTempFile.getAbsolutePath();
        return createTempFile;
    }

    private File createVideoFile() throws IOException {
        String str = "video-" + UUID.randomUUID().toString();
        File externalFilesDir = this.reactContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!externalFilesDir.exists() && !externalFilesDir.isDirectory()) {
            externalFilesDir.mkdirs();
        }
        File createTempFile = File.createTempFile(str, ".mp4", externalFilesDir);
        this.mCurrentMediaPath = "file:" + createTempFile.getAbsolutePath();
        return createTempFile;
    }

    private void croppingResult(Activity activity, int i10, int i11, Intent intent) {
        if (intent != null) {
            Uri b10 = com.yalantis.ucrop.a.b(intent);
            if (b10 != null) {
                try {
                    if (this.width > 0 && this.height > 0) {
                        a aVar = this.compression;
                        ReactApplicationContext reactApplicationContext = this.reactContext;
                        String path = b10.getPath();
                        int i12 = this.width;
                        int i13 = this.height;
                        b10 = Uri.fromFile(aVar.e(reactApplicationContext, path, i12, i13, i12, i13, 100));
                    }
                    WritableMap selection = getSelection(activity, b10, false);
                    if (selection != null) {
                        selection.putMap("cropRect", getCroppedRectMap(intent));
                        this.resultCollector.e(1);
                        this.resultCollector.d(selection);
                        return;
                    }
                    throw new Exception("Cannot crop video files");
                } catch (Exception e10) {
                    this.resultCollector.b(E_NO_IMAGE_DATA_FOUND, e10.getMessage());
                }
            } else {
                this.resultCollector.b(E_NO_IMAGE_DATA_FOUND, "Cannot find image data");
            }
        } else {
            this.resultCollector.b(E_PICKER_CANCELLED_KEY, E_PICKER_CANCELLED_MSG);
        }
    }

    /* access modifiers changed from: private */
    public void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File deleteRecursive : file.listFiles()) {
                deleteRecursive(deleteRecursive);
            }
        }
        file.delete();
    }

    private void getAsyncSelection(Activity activity, Uri uri, boolean z10) throws Exception {
        String resolveRealPath = resolveRealPath(activity, uri, z10);
        if (resolveRealPath == null || resolveRealPath.isEmpty()) {
            this.resultCollector.b(E_NO_IMAGE_DATA_FOUND, "Cannot resolve asset path.");
            return;
        }
        String mimeType = getMimeType(resolveRealPath);
        if (mimeType == null || !mimeType.startsWith("video/")) {
            this.resultCollector.d(getImage(activity, resolveRealPath));
        } else {
            getVideo(activity, resolveRealPath, mimeType);
        }
    }

    private String getBase64StringFromFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[8192];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private static WritableMap getCroppedRectMap(Intent intent) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putInt("x", intent.getIntExtra("com.yalantis.ucrop.OffsetX", -1));
        writableNativeMap.putInt("y", intent.getIntExtra("com.yalantis.ucrop.OffsetY", -1));
        writableNativeMap.putInt(Snapshot.WIDTH, intent.getIntExtra("com.yalantis.ucrop.ImageWidth", -1));
        writableNativeMap.putInt(Snapshot.HEIGHT, intent.getIntExtra("com.yalantis.ucrop.ImageHeight", -1));
        return writableNativeMap;
    }

    private WritableMap getImage(Activity activity, String str) throws Exception {
        int i10;
        int i11;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (str.startsWith(com.alibaba.pdns.s.e.c.f18246k) || str.startsWith(com.alibaba.pdns.s.e.c.f18247l)) {
            throw new Exception("Cannot select remote files");
        }
        BitmapFactory.Options validateImage = validateImage(str);
        boolean z10 = true;
        int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (!(attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7)) {
            z10 = false;
        }
        String path = this.compression.c(this.reactContext, this.options, str, validateImage).getPath();
        BitmapFactory.Options validateImage2 = validateImage(path);
        long lastModified = new File(str).lastModified();
        writableNativeMap.putString("path", "file://" + path);
        if (z10) {
            i10 = validateImage2.outHeight;
        } else {
            i10 = validateImage2.outWidth;
        }
        writableNativeMap.putInt(Snapshot.WIDTH, i10);
        if (z10) {
            i11 = validateImage2.outWidth;
        } else {
            i11 = validateImage2.outHeight;
        }
        writableNativeMap.putInt(Snapshot.HEIGHT, i11);
        writableNativeMap.putString("mime", validateImage2.outMimeType);
        writableNativeMap.putInt("size", (int) new File(path).length());
        writableNativeMap.putString("modificationDate", String.valueOf(lastModified));
        writableNativeMap.putString("filename", new File(str).getName());
        if (this.includeBase64) {
            writableNativeMap.putString("data", getBase64StringFromFile(path));
        }
        if (this.includeExif) {
            try {
                writableNativeMap.putMap("exif", b.a(str));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return writableNativeMap;
    }

    private String getMimeType(String str) {
        Uri fromFile = Uri.fromFile(new File(str));
        if (fromFile.getScheme().equals(FirebaseAnalytics.Param.CONTENT)) {
            return this.reactContext.getContentResolver().getType(fromFile);
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(fromFile.toString());
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
        }
        return null;
    }

    private WritableMap getSelection(Activity activity, Uri uri, boolean z10) throws Exception {
        String resolveRealPath = resolveRealPath(activity, uri, z10);
        if (resolveRealPath == null || resolveRealPath.isEmpty()) {
            throw new Exception("Cannot resolve asset path.");
        }
        String mimeType = getMimeType(resolveRealPath);
        if (mimeType == null || !mimeType.startsWith("video/")) {
            return getImage(activity, resolveRealPath);
        }
        getVideo(activity, resolveRealPath, mimeType);
        return null;
    }

    /* access modifiers changed from: private */
    public String getTmpDir(Activity activity) {
        String str = activity.getCacheDir() + "/react-native-image-crop-picker";
        new File(str).mkdir();
        return str;
    }

    private void getVideo(Activity activity, String str, String str2) throws Exception {
        validateVideo(str);
        new Thread(new g(activity, str, getTmpDir(activity) + DomExceptionUtils.SEPARATOR + UUID.randomUUID().toString() + ".mp4", str2)).run();
    }

    /* access modifiers changed from: private */
    public static Long getVideoDuration(String str) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.valueOf(Long.parseLong(mediaMetadataRetriever.extractMetadata(9)));
        } catch (Exception unused) {
            return -1L;
        }
    }

    private void imagePickerResult(Activity activity, int i10, int i11, Intent intent) {
        ClipData clipData;
        if (i11 == 0) {
            this.resultCollector.b(E_PICKER_CANCELLED_KEY, E_PICKER_CANCELLED_MSG);
        } else if (i11 != -1) {
        } else {
            if (this.multiple) {
                ClipData clipData2 = intent.getClipData();
                if (clipData2 == null) {
                    try {
                        this.resultCollector.e(1);
                        getAsyncSelection(activity, intent.getData(), false);
                    } catch (Exception e10) {
                        this.resultCollector.b(E_NO_IMAGE_DATA_FOUND, e10.getMessage());
                    }
                } else {
                    this.resultCollector.e(clipData2.getItemCount());
                    for (int i12 = 0; i12 < clipData2.getItemCount(); i12++) {
                        getAsyncSelection(activity, clipData2.getItemAt(i12).getUri(), false);
                    }
                }
            } else {
                Uri data = intent.getData();
                if (data == null && (clipData = intent.getClipData()) != null && clipData.getItemCount() > 0) {
                    data = clipData.getItemAt(0).getUri();
                }
                if (data == null) {
                    this.resultCollector.b(E_NO_IMAGE_DATA_FOUND, "Cannot resolve image url");
                } else if (this.cropping) {
                    startCropping(activity, data);
                } else {
                    try {
                        getAsyncSelection(activity, data, false);
                    } catch (Exception e11) {
                        this.resultCollector.b(E_NO_IMAGE_DATA_FOUND, e11.getMessage());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void initiateCamera(Activity activity) {
        File file;
        String str;
        try {
            if (this.mediaType.equals("video")) {
                str = "android.media.action.VIDEO_CAPTURE";
                file = createVideoFile();
            } else {
                str = "android.media.action.IMAGE_CAPTURE";
                file = createImageFile();
            }
            Intent intent = new Intent(str);
            Uri uriForFile = FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName() + ".provider", file);
            this.mCameraCaptureURI = uriForFile;
            intent.putExtra("output", uriForFile);
            if (this.useFrontCamera) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
            if (intent.resolveActivity(activity.getPackageManager()) == null) {
                this.resultCollector.b(E_CANNOT_LAUNCH_CAMERA, "Cannot launch camera");
            } else {
                activity.startActivityForResult(intent, CAMERA_PICKER_REQUEST);
            }
        } catch (Exception e10) {
            this.resultCollector.c(E_FAILED_TO_OPEN_CAMERA, e10);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d A[Catch:{ Exception -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[Catch:{ Exception -> 0x0028 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initiatePicker(android.app.Activity r4) {
        /*
            r3 = this;
            androidx.activity.result.PickVisualMediaRequest$Builder r0 = new androidx.activity.result.PickVisualMediaRequest$Builder     // Catch:{ Exception -> 0x0028 }
            r0.<init>()     // Catch:{ Exception -> 0x0028 }
            androidx.activity.result.PickVisualMediaRequest r1 = new androidx.activity.result.PickVisualMediaRequest     // Catch:{ Exception -> 0x0028 }
            r1.<init>()     // Catch:{ Exception -> 0x0028 }
            boolean r1 = r3.cropping     // Catch:{ Exception -> 0x0028 }
            if (r1 != 0) goto L_0x004a
            java.lang.String r1 = r3.mediaType     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = "photo"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0028 }
            if (r1 == 0) goto L_0x0019
            goto L_0x004a
        L_0x0019:
            boolean r1 = r3.cropping     // Catch:{ Exception -> 0x0028 }
            if (r1 == 0) goto L_0x002a
            androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageOnly r1 = androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE     // Catch:{ Exception -> 0x0028 }
            androidx.activity.result.PickVisualMediaRequest$Builder r0 = r0.setMediaType(r1)     // Catch:{ Exception -> 0x0028 }
            androidx.activity.result.PickVisualMediaRequest r0 = r0.build()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0059
        L_0x0028:
            r4 = move-exception
            goto L_0x0077
        L_0x002a:
            java.lang.String r1 = r3.mediaType     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = "video"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0028 }
            if (r1 == 0) goto L_0x003f
            androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$VideoOnly r1 = androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE     // Catch:{ Exception -> 0x0028 }
            androidx.activity.result.PickVisualMediaRequest$Builder r0 = r0.setMediaType(r1)     // Catch:{ Exception -> 0x0028 }
            androidx.activity.result.PickVisualMediaRequest r0 = r0.build()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0059
        L_0x003f:
            androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$ImageAndVideo r1 = androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE     // Catch:{ Exception -> 0x0028 }
            androidx.activity.result.PickVisualMediaRequest$Builder r0 = r0.setMediaType(r1)     // Catch:{ Exception -> 0x0028 }
            androidx.activity.result.PickVisualMediaRequest r0 = r0.build()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0059
        L_0x004a:
            androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$SingleMimeType r1 = new androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia$SingleMimeType     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = "image/*"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0028 }
            androidx.activity.result.PickVisualMediaRequest$Builder r0 = r0.setMediaType(r1)     // Catch:{ Exception -> 0x0028 }
            androidx.activity.result.PickVisualMediaRequest r0 = r0.build()     // Catch:{ Exception -> 0x0028 }
        L_0x0059:
            boolean r1 = r3.multiple     // Catch:{ Exception -> 0x0028 }
            if (r1 == 0) goto L_0x0067
            androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia r1 = new androidx.activity.result.contract.ActivityResultContracts$PickMultipleVisualMedia     // Catch:{ Exception -> 0x0028 }
            r1.<init>()     // Catch:{ Exception -> 0x0028 }
            android.content.Intent r0 = r1.createIntent((android.content.Context) r4, (androidx.activity.result.PickVisualMediaRequest) r0)     // Catch:{ Exception -> 0x0028 }
            goto L_0x0070
        L_0x0067:
            androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia r1 = new androidx.activity.result.contract.ActivityResultContracts$PickVisualMedia     // Catch:{ Exception -> 0x0028 }
            r1.<init>()     // Catch:{ Exception -> 0x0028 }
            android.content.Intent r0 = r1.createIntent((android.content.Context) r4, (androidx.activity.result.PickVisualMediaRequest) r0)     // Catch:{ Exception -> 0x0028 }
        L_0x0070:
            r1 = 61110(0xeeb6, float:8.5633E-41)
            r4.startActivityForResult(r0, r1)     // Catch:{ Exception -> 0x0028 }
            goto L_0x007e
        L_0x0077:
            com.reactnative.ivpusic.imagepicker.f r0 = r3.resultCollector
            java.lang.String r1 = "E_FAILED_TO_SHOW_PICKER"
            r0.c(r1, r4)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnative.ivpusic.imagepicker.PickerModule.initiatePicker(android.app.Activity):void");
    }

    private boolean isCameraAvailable(Activity activity) {
        if (activity.getPackageManager().hasSystemFeature("android.hardware.camera") || activity.getPackageManager().hasSystemFeature("android.hardware.camera.any")) {
            return true;
        }
        return false;
    }

    private void permissionsCheck(Activity activity, Promise promise, List<String> list, Callable<Void> callable) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>(list);
        if (Build.VERSION.SDK_INT > 29) {
            arrayList2.remove("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        for (String str : arrayList2) {
            if (ContextCompat.checkSelfPermission(activity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            ((w6.g) activity).requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1, new c(promise, callable));
            return;
        }
        try {
            callable.call();
        } catch (Exception e10) {
            promise.reject(E_CALLBACK_ERROR, "Unknown error", (Throwable) e10);
        }
    }

    private String resolveRealPath(Activity activity, Uri uri, boolean z10) throws IOException {
        String str;
        int i10 = Build.VERSION.SDK_INT;
        if (z10) {
            str = Uri.parse(this.mCurrentMediaPath).getPath();
        } else {
            str = e.b(activity, uri);
        }
        if (i10 < 29) {
            return str;
        }
        String path = Uri.fromFile(activity.getExternalCacheDir()).getPath();
        String path2 = Uri.fromFile(activity.getExternalFilesDir((String) null)).getPath();
        String path3 = Uri.fromFile(activity.getCacheDir()).getPath();
        String path4 = Uri.fromFile(activity.getFilesDir()).getPath();
        if (str.startsWith(path) || str.startsWith(path2) || str.startsWith(path3) || str.startsWith(path4)) {
            return str;
        }
        return e.b(activity, Uri.fromFile(createExternalStoragePrivateFile(activity, uri)));
    }

    private void setConfiguration(ReadableMap readableMap) {
        String str;
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        int i11;
        boolean z13;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        if (readableMap.hasKey("mediaType")) {
            str = readableMap.getString("mediaType");
        } else {
            str = "any";
        }
        this.mediaType = str;
        boolean z21 = true;
        if (!readableMap.hasKey("multiple") || !readableMap.getBoolean("multiple")) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.multiple = z10;
        if (!readableMap.hasKey("includeBase64") || !readableMap.getBoolean("includeBase64")) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.includeBase64 = z11;
        if (!readableMap.hasKey("includeExif") || !readableMap.getBoolean("includeExif")) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.includeExif = z12;
        if (readableMap.hasKey(Snapshot.WIDTH)) {
            i10 = readableMap.getInt(Snapshot.WIDTH);
        } else {
            i10 = 0;
        }
        this.width = i10;
        if (readableMap.hasKey(Snapshot.HEIGHT)) {
            i11 = readableMap.getInt(Snapshot.HEIGHT);
        } else {
            i11 = 0;
        }
        this.height = i11;
        if (!readableMap.hasKey("cropping") || !readableMap.getBoolean("cropping")) {
            z13 = false;
        } else {
            z13 = true;
        }
        this.cropping = z13;
        String str6 = null;
        if (readableMap.hasKey("cropperActiveWidgetColor")) {
            str2 = readableMap.getString("cropperActiveWidgetColor");
        } else {
            str2 = null;
        }
        this.cropperActiveWidgetColor = str2;
        if (readableMap.hasKey("cropperStatusBarColor")) {
            str3 = readableMap.getString("cropperStatusBarColor");
        } else {
            str3 = null;
        }
        this.cropperStatusBarColor = str3;
        if (readableMap.hasKey("cropperToolbarColor")) {
            str4 = readableMap.getString("cropperToolbarColor");
        } else {
            str4 = null;
        }
        this.cropperToolbarColor = str4;
        if (readableMap.hasKey("cropperToolbarTitle")) {
            str5 = readableMap.getString("cropperToolbarTitle");
        } else {
            str5 = null;
        }
        this.cropperToolbarTitle = str5;
        if (readableMap.hasKey("cropperToolbarWidgetColor")) {
            str6 = readableMap.getString("cropperToolbarWidgetColor");
        }
        this.cropperToolbarWidgetColor = str6;
        if (!readableMap.hasKey("cropperCircleOverlay") || !readableMap.getBoolean("cropperCircleOverlay")) {
            z14 = false;
        } else {
            z14 = true;
        }
        this.cropperCircleOverlay = z14;
        if (!readableMap.hasKey("freeStyleCropEnabled") || !readableMap.getBoolean("freeStyleCropEnabled")) {
            z15 = false;
        } else {
            z15 = true;
        }
        this.freeStyleCropEnabled = z15;
        if (!readableMap.hasKey("showCropGuidelines") || readableMap.getBoolean("showCropGuidelines")) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.showCropGuidelines = z16;
        if (!readableMap.hasKey("showCropFrame") || readableMap.getBoolean("showCropFrame")) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.showCropFrame = z17;
        if (!readableMap.hasKey("hideBottomControls") || !readableMap.getBoolean("hideBottomControls")) {
            z18 = false;
        } else {
            z18 = true;
        }
        this.hideBottomControls = z18;
        if (!readableMap.hasKey("enableRotationGesture") || !readableMap.getBoolean("enableRotationGesture")) {
            z19 = false;
        } else {
            z19 = true;
        }
        this.enableRotationGesture = z19;
        if (!readableMap.hasKey("disableCropperColorSetters") || !readableMap.getBoolean("disableCropperColorSetters")) {
            z20 = false;
        } else {
            z20 = true;
        }
        this.disableCropperColorSetters = z20;
        if (!readableMap.hasKey("useFrontCamera") || !readableMap.getBoolean("useFrontCamera")) {
            z21 = false;
        }
        this.useFrontCamera = z21;
        this.options = readableMap;
    }

    /* access modifiers changed from: private */
    public void startCropping(Activity activity, Uri uri) {
        int i10;
        a.C0132a aVar = new a.C0132a();
        aVar.e(Bitmap.CompressFormat.JPEG);
        aVar.f(100);
        aVar.d(this.cropperCircleOverlay);
        aVar.g(this.freeStyleCropEnabled);
        aVar.j(this.showCropGuidelines);
        aVar.i(this.showCropFrame);
        aVar.h(this.hideBottomControls);
        String str = this.cropperToolbarTitle;
        if (str != null) {
            aVar.m(str);
        }
        if (this.enableRotationGesture) {
            aVar.c(3, 3, 3);
        }
        if (!this.disableCropperColorSetters) {
            configureCropperColors(aVar);
        }
        String tmpDir = getTmpDir(activity);
        com.yalantis.ucrop.a g10 = com.yalantis.ucrop.a.c(uri, Uri.fromFile(new File(tmpDir, UUID.randomUUID().toString() + ".jpg"))).g(aVar);
        int i11 = this.width;
        if (i11 > 0 && (i10 = this.height) > 0) {
            g10.f((float) i11, (float) i10);
        }
        g10.d(activity);
    }

    private BitmapFactory.Options validateImage(String str) throws Exception {
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        options2.inPreferredConfig = Bitmap.Config.RGB_565;
        options2.inDither = true;
        BitmapFactory.decodeFile(str, options2);
        if (options2.outMimeType != null && options2.outWidth != 0 && options2.outHeight != 0) {
            return options2;
        }
        throw new Exception("Invalid image selected");
    }

    /* access modifiers changed from: private */
    public Bitmap validateVideo(String str) throws Exception {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
        if (frameAtTime != null) {
            return frameAtTime;
        }
        throw new Exception("Cannot retrieve video data");
    }

    @ReactMethod
    public void clean(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
        } else {
            permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new a(this, currentActivity, promise));
        }
    }

    @ReactMethod
    public void cleanSingle(String str, Promise promise) {
        if (str == null) {
            promise.reject(E_ERROR_WHILE_CLEANING_FILES, "Cannot cleanup empty path");
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
        } else {
            permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new b(str, this, promise));
        }
    }

    public String getExtension(Context context, Uri uri) {
        if (uri.getScheme().equals(FirebaseAnalytics.Param.CONTENT)) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
        }
        return MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
    }

    public String getName() {
        return "ImageCropPicker";
    }

    public void onActivityResult(Activity activity, int i10, int i11, Intent intent) {
        if (i10 == IMAGE_PICKER_REQUEST) {
            imagePickerResult(activity, i10, i11, intent);
        } else if (i10 == CAMERA_PICKER_REQUEST) {
            cameraPickerResult(activity, i10, i11, intent);
        } else if (i10 == 69) {
            croppingResult(activity, i10, i11, intent);
        }
    }

    public void onNewIntent(Intent intent) {
    }

    @ReactMethod
    public void openCamera(ReadableMap readableMap, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
        } else if (!isCameraAvailable(currentActivity)) {
            promise.reject(E_CAMERA_IS_NOT_AVAILABLE, "Camera not available");
        } else {
            setConfiguration(readableMap);
            this.resultCollector.f(promise, false);
            permissionsCheck(currentActivity, promise, Arrays.asList(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"}), new d(currentActivity));
        }
    }

    @ReactMethod
    public void openCropper(ReadableMap readableMap, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
            return;
        }
        setConfiguration(readableMap);
        this.resultCollector.f(promise, false);
        permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new f(currentActivity, Uri.parse(readableMap.getString("path"))));
    }

    @ReactMethod
    public void openPicker(ReadableMap readableMap, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
            return;
        }
        setConfiguration(readableMap);
        this.resultCollector.f(promise, this.multiple);
        permissionsCheck(currentActivity, promise, Collections.singletonList("android.permission.WRITE_EXTERNAL_STORAGE"), new e(currentActivity));
    }
}
