package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import b0.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i0;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.n;
import kotlin.ranges.l;
import kotlin.t;

public final class ActivityResultContracts {

    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            m.f(context, "context");
            m.f(uri, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            m.f(context, "context");
            m.f(uri, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            m.e(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        public final Boolean parseResult(int i10, Intent intent) {
            return Boolean.valueOf(i10 == -1);
        }
    }

    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        private final String mimeType;

        public CreateDocument(String str) {
            m.f(str, "mimeType");
            this.mimeType = str;
        }

        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String str) {
            m.f(context, "context");
            m.f(str, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String str) {
            m.f(context, "context");
            m.f(str, "input");
            Intent putExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", str);
            m.e(putExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return putExtra;
        }

        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        public CreateDocument() {
            this("*/*");
        }
    }

    public static class GetContent extends ActivityResultContract<String, Uri> {
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String str) {
            m.f(context, "context");
            m.f(str, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String str) {
            m.f(context, "context");
            m.f(str, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
            m.e(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        public static final class Companion {
            private Companion() {
            }

            public final List<Uri> getClipDataUris$activity_release(Intent intent) {
                m.f(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return r.l();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i10 = 0; i10 < itemCount; i10++) {
                        Uri uri = clipData.getItemAt(i10).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String str) {
            m.f(context, "context");
            m.f(str, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String str) {
            m.f(context, "context");
            m.f(str, "input");
            Intent putExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            m.e(putExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return putExtra;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = Companion.getClipDataUris$activity_release(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> parseResult(int r2, android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x0010
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = Companion
                java.util.List r2 = r2.getClipDataUris$activity_release(r3)
                if (r2 == 0) goto L_0x0010
                goto L_0x0014
            L_0x0010:
                java.util.List r2 = kotlin.collections.r.l()
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.parseResult(int, android.content.Intent):java.util.List");
        }
    }

    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String[] strArr) {
            m.f(context, "context");
            m.f(strArr, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String[] strArr) {
            m.f(context, "context");
            m.f(strArr, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
            m.e(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @RequiresApi(21)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, Uri uri) {
            m.f(context, "context");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            m.f(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String[] strArr) {
            m.f(context, "context");
            m.f(strArr, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, String[] strArr) {
            m.f(context, "context");
            m.f(strArr, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            m.e(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> parseResult(int r2, android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x0010
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion
                java.util.List r2 = r2.getClipDataUris$activity_release(r3)
                if (r2 == 0) goto L_0x0010
                goto L_0x0014
            L_0x0010:
                java.util.List r2 = kotlin.collections.r.l()
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.OpenMultipleDocuments.parseResult(int, android.content.Intent):java.util.List");
        }
    }

    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        public Intent createIntent(Context context, Void voidR) {
            m.f(context, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            m.e(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        public Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final int maxItems;

        public static final class Companion {
            private Companion() {
            }

            @SuppressLint({"NewApi", "ClassVerificationFailure"})
            public final int getMaxItems$activity_release() {
                if (PickVisualMedia.Companion.isSystemPickerAvailable$activity_release()) {
                    return MediaStore.getPickImagesMaxLimit();
                }
                return Integer.MAX_VALUE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public PickMultipleVisualMedia() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            m.f(context, "context");
            m.f(pickVisualMediaRequest, "input");
            return null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PickMultipleVisualMedia(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? Companion.getMaxItems$activity_release() : i10);
        }

        @CallSuper
        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            m.f(context, "context");
            m.f(pickVisualMediaRequest, "input");
            PickVisualMedia.Companion companion = PickVisualMedia.Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (this.maxItems <= MediaStore.getPickImagesMaxLimit()) {
                    intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
                    return intent;
                }
                throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
            } else if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                    Intent intent2 = new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent2.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                    intent2.putExtra(PickVisualMedia.EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX, this.maxItems);
                    return intent2;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } else if (companion.isGmsPickerAvailable$activity_release(context)) {
                ResolveInfo gmsPicker$activity_release = companion.getGmsPicker$activity_release(context);
                if (gmsPicker$activity_release != null) {
                    ActivityInfo activityInfo2 = gmsPicker$activity_release.activityInfo;
                    Intent intent3 = new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES);
                    intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                    intent3.putExtra(PickVisualMedia.GMS_EXTRA_PICK_IMAGES_MAX, this.maxItems);
                    return intent3;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } else {
                Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent4.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (intent4.getType() != null) {
                    return intent4;
                }
                intent4.setType("*/*");
                intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent4;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
            r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<android.net.Uri> parseResult(int r2, android.content.Intent r3) {
            /*
                r1 = this;
                r0 = -1
                if (r2 != r0) goto L_0x0004
                goto L_0x0005
            L_0x0004:
                r3 = 0
            L_0x0005:
                if (r3 == 0) goto L_0x0010
                androidx.activity.result.contract.ActivityResultContracts$GetMultipleContents$Companion r2 = androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion
                java.util.List r2 = r2.getClipDataUris$activity_release(r3)
                if (r2 == 0) goto L_0x0010
                goto L_0x0014
            L_0x0010:
                java.util.List r2 = kotlin.collections.r.l()
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia.parseResult(int, android.content.Intent):java.util.List");
        }

        public PickMultipleVisualMedia(int i10) {
            this.maxItems = i10;
            if (i10 <= 1) {
                throw new IllegalArgumentException("Max items must be higher than 1".toString());
            }
        }
    }

    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {
        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";

        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ void getACTION_SYSTEM_FALLBACK_PICK_IMAGES$annotations() {
            }

            public static /* synthetic */ void getEXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX$annotations() {
            }

            public final ResolveInfo getGmsPicker$activity_release(Context context) {
                m.f(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.GMS_ACTION_PICK_IMAGES), 1114112);
            }

            public final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
                m.f(context, "context");
                return context.getPackageManager().resolveActivity(new Intent(PickVisualMedia.ACTION_SYSTEM_FALLBACK_PICK_IMAGES), 1114112);
            }

            public final String getVisualMimeType$activity_release(VisualMediaType visualMediaType) {
                m.f(visualMediaType, "input");
                if (visualMediaType instanceof ImageOnly) {
                    return "image/*";
                }
                if (visualMediaType instanceof VideoOnly) {
                    return "video/*";
                }
                if (visualMediaType instanceof SingleMimeType) {
                    return ((SingleMimeType) visualMediaType).getMimeType();
                }
                if (visualMediaType instanceof ImageAndVideo) {
                    return null;
                }
                throw new n();
            }

            public final boolean isGmsPickerAvailable$activity_release(Context context) {
                m.f(context, "context");
                if (getGmsPicker$activity_release(context) != null) {
                    return true;
                }
                return false;
            }

            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable() {
                return isSystemPickerAvailable$activity_release();
            }

            public final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
                m.f(context, "context");
                if (getSystemFallbackPicker$activity_release(context) != null) {
                    return true;
                }
                return false;
            }

            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isSystemPickerAvailable$activity_release() {
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 33) {
                    return true;
                }
                if (i10 < 30 || b.a(30) < 2) {
                    return false;
                }
                return true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable(Context context) {
                m.f(context, "context");
                return isSystemPickerAvailable$activity_release() || isSystemFallbackPickerAvailable$activity_release(context) || isGmsPickerAvailable$activity_release(context);
            }
        }

        public static final class ImageAndVideo implements VisualMediaType {
            public static final ImageAndVideo INSTANCE = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        public static final class ImageOnly implements VisualMediaType {
            public static final ImageOnly INSTANCE = new ImageOnly();

            private ImageOnly() {
            }
        }

        public static final class SingleMimeType implements VisualMediaType {
            private final String mimeType;

            public SingleMimeType(String str) {
                m.f(str, "mimeType");
                this.mimeType = str;
            }

            public final String getMimeType() {
                return this.mimeType;
            }
        }

        public static final class VideoOnly implements VisualMediaType {
            public static final VideoOnly INSTANCE = new VideoOnly();

            private VideoOnly() {
            }
        }

        public interface VisualMediaType {
        }

        public static final ResolveInfo getGmsPicker$activity_release(Context context) {
            return Companion.getGmsPicker$activity_release(context);
        }

        public static final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
            return Companion.getSystemFallbackPicker$activity_release(context);
        }

        public static final boolean isGmsPickerAvailable$activity_release(Context context) {
            return Companion.isGmsPickerAvailable$activity_release(context);
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable() {
            return Companion.isPhotoPickerAvailable();
        }

        public static final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
            return Companion.isSystemFallbackPickerAvailable$activity_release(context);
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isSystemPickerAvailable$activity_release() {
            return Companion.isSystemPickerAvailable$activity_release();
        }

        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            m.f(context, "context");
            m.f(pickVisualMediaRequest, "input");
            return null;
        }

        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable(Context context) {
            return Companion.isPhotoPickerAvailable(context);
        }

        @CallSuper
        public Intent createIntent(Context context, PickVisualMediaRequest pickVisualMediaRequest) {
            Intent intent;
            m.f(context, "context");
            m.f(pickVisualMediaRequest, "input");
            Companion companion = Companion;
            if (companion.isSystemPickerAvailable$activity_release()) {
                Intent intent2 = new Intent("android.provider.action.PICK_IMAGES");
                intent2.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                return intent2;
            }
            if (companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release != null) {
                    ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                    intent = new Intent(ACTION_SYSTEM_FALLBACK_PICK_IMAGES);
                    intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else if (companion.isGmsPickerAvailable$activity_release(context)) {
                ResolveInfo gmsPicker$activity_release = companion.getGmsPicker$activity_release(context);
                if (gmsPicker$activity_release != null) {
                    ActivityInfo activityInfo2 = gmsPicker$activity_release.activityInfo;
                    intent = new Intent(GMS_ACTION_PICK_IMAGES);
                    intent.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
                    intent.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent3.setType(companion.getVisualMimeType$activity_release(pickVisualMediaRequest.getMediaType()));
                if (intent3.getType() != null) {
                    return intent3;
                }
                intent3.setType("*/*");
                intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent3;
            }
            return intent;
        }

        public final Uri parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent == null) {
                return null;
            }
            Uri data = intent.getData();
            if (data == null) {
                data = (Uri) r.Z(GetMultipleContents.Companion.getClipDataUris$activity_release(intent));
            }
            return data;
        }
    }

    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        public static final class Companion {
            private Companion() {
            }

            public final Intent createIntent$activity_release(String[] strArr) {
                m.f(strArr, "input");
                Intent putExtra = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, strArr);
                m.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return putExtra;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Intent createIntent(Context context, String[] strArr) {
            m.f(context, "context");
            m.f(strArr, "input");
            return Companion.createIntent$activity_release(strArr);
        }

        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context context, String[] strArr) {
            m.f(context, "context");
            m.f(strArr, "input");
            if (strArr.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(i0.f());
            }
            for (String checkSelfPermission : strArr) {
                if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                    return null;
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(l.c(i0.c(strArr.length), 16));
            for (String a10 : strArr) {
                Pair a11 = t.a(a10, Boolean.TRUE);
                linkedHashMap.put(a11.c(), a11.d());
            }
            return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
        }

        public Map<String, Boolean> parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                return i0.f();
            }
            if (intent == null) {
                return i0.f();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return i0.f();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            int length = intArrayExtra.length;
            for (int i11 = 0; i11 < length; i11++) {
                arrayList.add(Boolean.valueOf(intArrayExtra[i11] == 0));
            }
            return i0.n(r.B0(j.t(stringArrayExtra), arrayList));
        }
    }

    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        public Intent createIntent(Context context, String str) {
            m.f(context, "context");
            m.f(str, "input");
            return RequestMultiplePermissions.Companion.createIntent$activity_release(new String[]{str});
        }

        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, String str) {
            m.f(context, "context");
            m.f(str, "input");
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        public Boolean parseResult(int i10, Intent intent) {
            if (intent == null || i10 != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            boolean z10 = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (intArrayExtra[i11] == 0) {
                        z10 = true;
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Intent createIntent(Context context, Intent intent) {
            m.f(context, "context");
            m.f(intent, "input");
            return intent;
        }

        public ActivityResult parseResult(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            m.f(context, "context");
            m.f(intentSenderRequest, "input");
            Intent putExtra = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
            m.e(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return putExtra;
        }

        public ActivityResult parseResult(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            m.f(context, "context");
            m.f(uri, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            m.f(context, "context");
            m.f(uri, "input");
            Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
            m.e(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        public final Boolean parseResult(int i10, Intent intent) {
            return Boolean.valueOf(i10 == -1);
        }
    }

    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Void voidR) {
            m.f(context, "context");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Void voidR) {
            m.f(context, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        public final Bitmap parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Uri uri) {
            m.f(context, "context");
            m.f(uri, "input");
            return null;
        }

        @CallSuper
        public Intent createIntent(Context context, Uri uri) {
            m.f(context, "context");
            m.f(uri, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
            m.e(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        public final Bitmap parseResult(int i10, Intent intent) {
            if (i10 != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    private ActivityResultContracts() {
    }
}
