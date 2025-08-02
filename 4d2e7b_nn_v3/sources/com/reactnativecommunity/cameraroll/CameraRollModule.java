package com.reactnativecommunity.cameraroll;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import ta.f;
import ta.h;

@s6.a(name = "RNCCameraRoll")
public class CameraRollModule extends NativeCameraRollModuleSpec {
    private static final String ASSET_TYPE_ALL = "All";
    private static final String ASSET_TYPE_PHOTOS = "Photos";
    private static final String ASSET_TYPE_VIDEOS = "Videos";
    private static final int DELETE_REQUEST_CODE = 1001;
    private static final String ERROR_UNABLE_TO_DELETE = "E_UNABLE_TO_DELETE";
    private static final String ERROR_UNABLE_TO_FILTER = "E_UNABLE_TO_FILTER";
    private static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
    private static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
    private static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
    private static final String INCLUDE_ALBUMS = "albums";
    private static final String INCLUDE_FILENAME = "filename";
    private static final String INCLUDE_FILE_EXTENSION = "fileExtension";
    private static final String INCLUDE_FILE_SIZE = "fileSize";
    private static final String INCLUDE_IMAGE_SIZE = "imageSize";
    private static final String INCLUDE_LOCATION = "location";
    private static final String INCLUDE_ORIENTATION = "orientation";
    private static final String INCLUDE_PLAYABLE_DURATION = "playableDuration";
    private static final String INCLUDE_SOURCE_TYPE = "sourceType";
    public static final String NAME = "RNCCameraRoll";
    /* access modifiers changed from: private */
    public static final String[] PROJECTION = {"_id", "mime_type", "bucket_display_name", "datetaken", "date_added", "date_modified", Snapshot.WIDTH, Snapshot.HEIGHT, "_size", "_data", INCLUDE_ORIENTATION};
    private static final String SELECTION_BUCKET = "bucket_display_name = ?";
    /* access modifiers changed from: private */
    public Promise deletePromise;

    class a extends BaseActivityEventListener {
        a() {
        }

        public void onActivityResult(Activity activity, int i10, int i11, Intent intent) {
            if (i10 == 1001 && CameraRollModule.this.deletePromise != null) {
                if (i11 == -1) {
                    CameraRollModule.this.deletePromise.resolve("Files successfully deleted");
                } else {
                    CameraRollModule.this.deletePromise.reject("ERROR", "Deletion was not completed");
                }
                CameraRollModule.this.deletePromise = null;
            }
        }
    }

    class b extends HashMap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11221a;

        b(String str) {
            this.f11221a = str;
            put("id", str);
            put("count", 1);
        }
    }

    private static class c extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final Context f11223a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11224b;

        /* renamed from: c  reason: collision with root package name */
        private final String f11225c;

        /* renamed from: d  reason: collision with root package name */
        private final String f11226d;

        /* renamed from: e  reason: collision with root package name */
        private final ReadableArray f11227e;

        /* renamed from: f  reason: collision with root package name */
        private final Promise f11228f;

        /* renamed from: g  reason: collision with root package name */
        private final String f11229g;

        /* renamed from: h  reason: collision with root package name */
        private final long f11230h;

        /* renamed from: i  reason: collision with root package name */
        private final long f11231i;

        /* renamed from: j  reason: collision with root package name */
        private final Set f11232j;

        private static Set a(ReadableArray readableArray) {
            HashSet hashSet = new HashSet();
            if (readableArray == null) {
                return hashSet;
            }
            for (int i10 = 0; i10 < readableArray.size(); i10++) {
                String string = readableArray.getString(i10);
                if (string != null) {
                    hashSet.add(string);
                }
            }
            return hashSet;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void doInBackgroundGuarded(Void... voidArr) {
            Cursor cursor;
            StringBuilder sb2 = new StringBuilder("1");
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.f11226d)) {
                sb2.append(" AND bucket_display_name = ?");
                arrayList.add(this.f11226d);
            }
            if (this.f11229g.equals(CameraRollModule.ASSET_TYPE_PHOTOS)) {
                sb2.append(" AND media_type = 1");
            } else if (this.f11229g.equals(CameraRollModule.ASSET_TYPE_VIDEOS)) {
                sb2.append(" AND media_type = 3");
            } else if (this.f11229g.equals(CameraRollModule.ASSET_TYPE_ALL)) {
                sb2.append(" AND media_type IN (3,1)");
            } else {
                this.f11228f.reject(CameraRollModule.ERROR_UNABLE_TO_FILTER, "Invalid filter option: '" + this.f11229g + "'. Expected one of '" + CameraRollModule.ASSET_TYPE_PHOTOS + "', '" + CameraRollModule.ASSET_TYPE_VIDEOS + "' or '" + CameraRollModule.ASSET_TYPE_ALL + "'.");
                return;
            }
            ReadableArray readableArray = this.f11227e;
            int i10 = 0;
            if (readableArray != null && readableArray.size() > 0) {
                sb2.append(" AND mime_type IN (");
                for (int i11 = 0; i11 < this.f11227e.size(); i11++) {
                    sb2.append("?,");
                    arrayList.add(this.f11227e.getString(i11));
                }
                sb2.replace(sb2.length() - 1, sb2.length(), ")");
            }
            long j10 = this.f11230h;
            if (j10 > 0) {
                sb2.append(" AND (datetaken > ? OR ( datetaken IS NULL AND date_added> ? ))");
                arrayList.add(this.f11230h + "");
                arrayList.add((j10 / 1000) + "");
            }
            long j11 = this.f11231i;
            if (j11 > 0) {
                sb2.append(" AND (datetaken <= ? OR ( datetaken IS NULL AND date_added <= ? ))");
                arrayList.add(this.f11231i + "");
                arrayList.add((j11 / 1000) + "");
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.f11223a.getContentResolver();
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    Bundle bundle = new Bundle();
                    bundle.putString("android:query-arg-sql-selection", sb2.toString());
                    bundle.putStringArray("android:query-arg-sql-selection-args", (String[]) arrayList.toArray(new String[arrayList.size()]));
                    bundle.putString("android:query-arg-sql-sort-order", "date_added DESC, date_modified DESC");
                    bundle.putInt("android:query-arg-limit", this.f11224b + 1);
                    if (!TextUtils.isEmpty(this.f11225c)) {
                        bundle.putInt("android:query-arg-offset", Integer.parseInt(this.f11225c));
                    }
                    cursor = contentResolver.query(MediaStore.Files.getContentUri("external"), CameraRollModule.PROJECTION, bundle, (CancellationSignal) null);
                } else {
                    String str = "limit=" + (this.f11224b + 1);
                    if (!TextUtils.isEmpty(this.f11225c)) {
                        str = "limit=" + this.f11225c + "," + (this.f11224b + 1);
                    }
                    cursor = contentResolver.query(MediaStore.Files.getContentUri("external").buildUpon().encodedQuery(str).build(), CameraRollModule.PROJECTION, sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "date_added DESC, date_modified DESC");
                }
                if (cursor == null) {
                    this.f11228f.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD, "Could not get media");
                    return;
                }
                CameraRollModule.putEdges(contentResolver, cursor, writableNativeMap, this.f11224b, this.f11232j);
                int i12 = this.f11224b;
                if (!TextUtils.isEmpty(this.f11225c)) {
                    i10 = Integer.parseInt(this.f11225c);
                }
                CameraRollModule.putPageInfo(cursor, writableNativeMap, i12, i10);
                cursor.close();
                this.f11228f.resolve(writableNativeMap);
            } catch (SecurityException e10) {
                this.f11228f.reject(CameraRollModule.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get media: need READ_EXTERNAL_STORAGE permission", (Throwable) e10);
            } catch (Throwable th) {
                cursor.close();
                this.f11228f.resolve(writableNativeMap);
                throw th;
            }
        }

        private c(ReactContext reactContext, int i10, String str, String str2, ReadableArray readableArray, String str3, long j10, long j11, ReadableArray readableArray2, Promise promise) {
            super(reactContext);
            this.f11223a = reactContext;
            this.f11224b = i10;
            this.f11225c = str;
            this.f11226d = str2;
            this.f11227e = readableArray;
            this.f11228f = promise;
            this.f11229g = str3;
            this.f11230h = j10;
            this.f11231i = j11;
            this.f11232j = a(readableArray2);
        }
    }

    private static class d extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final Context f11233a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f11234b;

        /* renamed from: c  reason: collision with root package name */
        private final Promise f11235c;

        /* renamed from: d  reason: collision with root package name */
        private final ReadableMap f11236d;

        public d(ReactContext reactContext, Uri uri, ReadableMap readableMap, Promise promise) {
            super(reactContext);
            this.f11233a = reactContext;
            this.f11234b = uri;
            this.f11235c = promise;
            this.f11236d = readableMap;
        }

        private WritableMap c(Uri uri) {
            ContentResolver contentResolver = this.f11233a.getContentResolver();
            Cursor query = contentResolver.query(uri, CameraRollModule.PROJECTION, (String) null, (String[]) null, (String) null);
            if (query != null) {
                query.moveToFirst();
                WritableMap d10 = CameraRollModule.convertMediaToMap(contentResolver, query, f.a(new Object[]{"location", CameraRollModule.INCLUDE_FILENAME, CameraRollModule.INCLUDE_FILE_SIZE, CameraRollModule.INCLUDE_FILE_EXTENSION, CameraRollModule.INCLUDE_IMAGE_SIZE, CameraRollModule.INCLUDE_PLAYABLE_DURATION, CameraRollModule.INCLUDE_ORIENTATION, CameraRollModule.INCLUDE_ALBUMS, CameraRollModule.INCLUDE_SOURCE_TYPE}));
                query.close();
                return d10;
            }
            throw new RuntimeException("Failed to find the photo that was just saved!");
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(String str, Uri uri) {
            if (uri != null) {
                try {
                    this.f11235c.resolve(c(uri));
                } catch (Exception e10) {
                    this.f11235c.reject(CameraRollModule.ERROR_UNABLE_TO_SAVE, e10.getMessage());
                }
            } else {
                this.f11235c.reject(CameraRollModule.ERROR_UNABLE_TO_SAVE, "Could not add image to gallery");
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x01e5 A[SYNTHETIC, Splitter:B:104:0x01e5] */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x01eb A[SYNTHETIC, Splitter:B:107:0x01eb] */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x01f6 A[SYNTHETIC, Splitter:B:112:0x01f6] */
        /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x01da A[SYNTHETIC, Splitter:B:99:0x01da] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doInBackgroundGuarded(java.lang.Void... r19) {
            /*
                r18 = this;
                r1 = r18
                java.lang.String r0 = "is_pending"
                java.lang.String r2 = "Could not close output channel"
                java.lang.String r3 = "Could not close input channel"
                java.lang.String r4 = "ReactNative"
                java.io.File r5 = new java.io.File
                android.net.Uri r6 = r1.f11234b
                java.lang.String r6 = r6.getPath()
                r5.<init>(r6)
                android.net.Uri r6 = r1.f11234b
                java.lang.String r6 = r6.toString()
                java.lang.String r6 = ta.h.b(r6)
                java.lang.String r7 = "video"
                r8 = 1
                r9 = 0
                if (r6 == 0) goto L_0x002d
                boolean r10 = r6.contains(r7)
                if (r10 == 0) goto L_0x002d
                r10 = r8
                goto L_0x002e
            L_0x002d:
                r10 = r9
            L_0x002e:
                com.facebook.react.bridge.ReadableMap r12 = r1.f11236d     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                java.lang.String r13 = "album"
                java.lang.String r12 = r12.getString(r13)     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                r13 = r13 ^ r8
                int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                r15 = 29
                java.lang.String r11 = "E_UNABLE_TO_LOAD"
                if (r14 < r15) goto L_0x00d5
                android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r7.<init>()     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                if (r13 == 0) goto L_0x0071
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r13.<init>()     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r14 = android.os.Environment.DIRECTORY_DCIM     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r13.append(r14)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r14 = java.io.File.separator     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r13.append(r14)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r13.append(r12)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r12 = r13.toString()     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r13 = "relative_path"
                r7.put(r13, r12)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                goto L_0x0071
            L_0x0066:
                r0 = move-exception
                r5 = r0
                r10 = 0
            L_0x0069:
                r11 = 0
                goto L_0x01e9
            L_0x006c:
                r0 = move-exception
                r10 = 0
            L_0x006e:
                r11 = 0
                goto L_0x01d3
            L_0x0071:
                java.lang.String r12 = "mime_type"
                r7.put(r12, r6)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r6 = "_display_name"
                java.lang.String r12 = r5.getName()     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r7.put(r6, r12)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r7.put(r0, r6)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                android.content.Context r6 = r1.f11233a     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                if (r10 == 0) goto L_0x0095
                android.net.Uri r8 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                android.net.Uri r8 = r6.insert(r8, r7)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                goto L_0x009b
            L_0x0095:
                android.net.Uri r8 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                android.net.Uri r8 = r6.insert(r8, r7)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
            L_0x009b:
                if (r8 != 0) goto L_0x00a4
                com.facebook.react.bridge.Promise r10 = r1.f11235c     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r12 = "ContentResolver#insert() returns null, insert failed"
                r10.reject((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
            L_0x00a4:
                java.io.OutputStream r10 = r6.openOutputStream(r8)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00d3, all -> 0x00d0 }
                r11.<init>(r5)     // Catch:{ IOException -> 0x00d3, all -> 0x00d0 }
                long unused = android.os.FileUtils.copy(r11, r10)     // Catch:{ IOException -> 0x00cd }
                r7.clear()     // Catch:{ IOException -> 0x00cd }
                java.lang.Integer r5 = java.lang.Integer.valueOf(r9)     // Catch:{ IOException -> 0x00cd }
                r7.put(r0, r5)     // Catch:{ IOException -> 0x00cd }
                r5 = 0
                r6.update(r8, r7, r5, r5)     // Catch:{ IOException -> 0x00cd }
                com.facebook.react.bridge.WritableMap r0 = r1.c(r8)     // Catch:{ IOException -> 0x00cd }
                com.facebook.react.bridge.Promise r5 = r1.f11235c     // Catch:{ IOException -> 0x00cd }
                r5.resolve(r0)     // Catch:{ IOException -> 0x00cd }
                goto L_0x01ab
            L_0x00c9:
                r0 = move-exception
                r5 = r0
                goto L_0x01e9
            L_0x00cd:
                r0 = move-exception
                goto L_0x01d3
            L_0x00d0:
                r0 = move-exception
                r5 = r0
                goto L_0x0069
            L_0x00d3:
                r0 = move-exception
                goto L_0x006e
            L_0x00d5:
                if (r13 == 0) goto L_0x00f3
                com.facebook.react.bridge.ReadableMap r0 = r1.f11236d     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r6 = "type"
                java.lang.String r0 = r0.getString(r6)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                boolean r0 = r7.equals(r0)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                if (r0 == 0) goto L_0x00ec
                java.lang.String r0 = android.os.Environment.DIRECTORY_MOVIES     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                goto L_0x00f9
            L_0x00ec:
                java.lang.String r0 = android.os.Environment.DIRECTORY_PICTURES     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                goto L_0x00f9
            L_0x00f3:
                java.lang.String r0 = android.os.Environment.DIRECTORY_DCIM     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
            L_0x00f9:
                if (r13 == 0) goto L_0x0115
                java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r6.<init>(r0, r12)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                boolean r0 = r6.exists()     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                if (r0 != 0) goto L_0x0114
                boolean r0 = r6.mkdirs()     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                if (r0 != 0) goto L_0x0114
                com.facebook.react.bridge.Promise r0 = r1.f11235c     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r5 = "Album Directory not created. Did you request WRITE_EXTERNAL_STORAGE?"
                r0.reject((java.lang.String) r11, (java.lang.String) r5)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                return
            L_0x0114:
                r0 = r6
            L_0x0115:
                boolean r6 = r0.isDirectory()     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                if (r6 != 0) goto L_0x0123
                com.facebook.react.bridge.Promise r0 = r1.f11235c     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r5 = "External media storage directory not available"
                r0.reject((java.lang.String) r11, (java.lang.String) r5)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                return
            L_0x0123:
                java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                java.lang.String r7 = r5.getName()     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                r6.<init>(r0, r7)     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                java.lang.String r7 = r5.getName()     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                r8 = 46
                int r10 = r7.indexOf(r8)     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                if (r10 < 0) goto L_0x014b
                int r10 = r7.lastIndexOf(r8)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r10 = r7.substring(r9, r10)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                int r8 = r7.lastIndexOf(r8)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r7 = r7.substring(r8)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r8 = r7
                r7 = r10
                goto L_0x014d
            L_0x014b:
                java.lang.String r8 = ""
            L_0x014d:
                boolean r10 = r6.createNewFile()     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                if (r10 != 0) goto L_0x0173
                java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r10.<init>()     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r10.append(r7)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r11 = "_"
                r10.append(r11)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                int r11 = r9 + 1
                r10.append(r9)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r10.append(r8)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                java.lang.String r9 = r10.toString()     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r6.<init>(r0, r9)     // Catch:{ IOException -> 0x006c, all -> 0x0066 }
                r9 = r11
                goto L_0x014d
            L_0x0173:
                java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                r11.<init>(r5)     // Catch:{ IOException -> 0x01cf, all -> 0x01c9 }
                java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x01c5, all -> 0x01c0 }
                r10.<init>(r6)     // Catch:{ IOException -> 0x01c5, all -> 0x01c0 }
                java.nio.channels.FileChannel r12 = r10.getChannel()     // Catch:{ IOException -> 0x00cd }
                java.nio.channels.FileChannel r13 = r11.getChannel()     // Catch:{ IOException -> 0x00cd }
                java.nio.channels.FileChannel r0 = r11.getChannel()     // Catch:{ IOException -> 0x00cd }
                long r16 = r0.size()     // Catch:{ IOException -> 0x00cd }
                r14 = 0
                r12.transferFrom(r13, r14, r16)     // Catch:{ IOException -> 0x00cd }
                r11.close()     // Catch:{ IOException -> 0x00cd }
                r10.close()     // Catch:{ IOException -> 0x00cd }
                android.content.Context r0 = r1.f11233a     // Catch:{ IOException -> 0x00cd }
                java.lang.String r5 = r6.getAbsolutePath()     // Catch:{ IOException -> 0x00cd }
                java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ IOException -> 0x00cd }
                com.reactnativecommunity.cameraroll.a r6 = new com.reactnativecommunity.cameraroll.a     // Catch:{ IOException -> 0x00cd }
                r6.<init>(r1)     // Catch:{ IOException -> 0x00cd }
                r7 = 0
                android.media.MediaScannerConnection.scanFile(r0, r5, r7, r6)     // Catch:{ IOException -> 0x00cd }
            L_0x01ab:
                r11.close()     // Catch:{ IOException -> 0x01af }
                goto L_0x01b4
            L_0x01af:
                r0 = move-exception
                r5 = r0
                z2.a.k(r4, r3, r5)
            L_0x01b4:
                if (r10 == 0) goto L_0x01e8
                r10.close()     // Catch:{ IOException -> 0x01ba }
                goto L_0x01e8
            L_0x01ba:
                r0 = move-exception
                r3 = r0
                z2.a.k(r4, r2, r3)
                goto L_0x01e8
            L_0x01c0:
                r0 = move-exception
                r7 = 0
                r5 = r0
                r10 = r7
                goto L_0x01e9
            L_0x01c5:
                r0 = move-exception
                r7 = 0
                r10 = r7
                goto L_0x01d3
            L_0x01c9:
                r0 = move-exception
                r7 = 0
                r5 = r0
                r10 = r7
                r11 = r10
                goto L_0x01e9
            L_0x01cf:
                r0 = move-exception
                r7 = 0
                r10 = r7
                r11 = r10
            L_0x01d3:
                com.facebook.react.bridge.Promise r5 = r1.f11235c     // Catch:{ all -> 0x00c9 }
                r5.reject((java.lang.Throwable) r0)     // Catch:{ all -> 0x00c9 }
                if (r11 == 0) goto L_0x01e3
                r11.close()     // Catch:{ IOException -> 0x01de }
                goto L_0x01e3
            L_0x01de:
                r0 = move-exception
                r5 = r0
                z2.a.k(r4, r3, r5)
            L_0x01e3:
                if (r10 == 0) goto L_0x01e8
                r10.close()     // Catch:{ IOException -> 0x01ba }
            L_0x01e8:
                return
            L_0x01e9:
                if (r11 == 0) goto L_0x01f4
                r11.close()     // Catch:{ IOException -> 0x01ef }
                goto L_0x01f4
            L_0x01ef:
                r0 = move-exception
                r6 = r0
                z2.a.k(r4, r3, r6)
            L_0x01f4:
                if (r10 == 0) goto L_0x01ff
                r10.close()     // Catch:{ IOException -> 0x01fa }
                goto L_0x01ff
            L_0x01fa:
                r0 = move-exception
                r3 = r0
                z2.a.k(r4, r2, r3)
            L_0x01ff:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.cameraroll.CameraRollModule.d.doInBackgroundGuarded(java.lang.Void[]):void");
        }
    }

    public CameraRollModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new a());
    }

    /* access modifiers changed from: private */
    public static WritableMap convertMediaToMap(ContentResolver contentResolver, Cursor cursor, Set<String> set) {
        Cursor cursor2 = cursor;
        Set<String> set2 = set;
        int columnIndex = cursor2.getColumnIndex("_id");
        int columnIndex2 = cursor2.getColumnIndex("mime_type");
        int columnIndex3 = cursor2.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor2.getColumnIndex("datetaken");
        int columnIndex5 = cursor2.getColumnIndex("date_added");
        int columnIndex6 = cursor2.getColumnIndex("date_modified");
        int columnIndex7 = cursor2.getColumnIndex(Snapshot.WIDTH);
        int columnIndex8 = cursor2.getColumnIndex(Snapshot.HEIGHT);
        int columnIndex9 = cursor2.getColumnIndex("_size");
        int columnIndex10 = cursor2.getColumnIndex("_data");
        int columnIndex11 = cursor2.getColumnIndex(INCLUDE_ORIENTATION);
        boolean contains = set2.contains("location");
        boolean contains2 = set2.contains(INCLUDE_FILENAME);
        boolean contains3 = set2.contains(INCLUDE_FILE_SIZE);
        boolean contains4 = set2.contains(INCLUDE_FILE_EXTENSION);
        boolean contains5 = set2.contains(INCLUDE_IMAGE_SIZE);
        boolean contains6 = set2.contains(INCLUDE_PLAYABLE_DURATION);
        boolean contains7 = set2.contains(INCLUDE_ORIENTATION);
        boolean contains8 = set2.contains(INCLUDE_ALBUMS);
        boolean contains9 = set2.contains(INCLUDE_SOURCE_TYPE);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        WritableNativeMap writableNativeMap3 = writableNativeMap2;
        WritableNativeMap writableNativeMap4 = writableNativeMap;
        if (!putImageInfo(contentResolver, cursor, writableNativeMap2, columnIndex7, columnIndex8, columnIndex9, columnIndex10, columnIndex11, columnIndex2, contains2, contains3, contains4, contains5, contains6, contains7)) {
            return null;
        }
        Cursor cursor3 = cursor;
        WritableNativeMap writableNativeMap5 = writableNativeMap3;
        putBasicNodeInfo(cursor3, writableNativeMap5, columnIndex, columnIndex2, columnIndex3, columnIndex4, columnIndex5, columnIndex6, contains8, contains9);
        putLocationInfo(cursor3, writableNativeMap5, columnIndex10, contains, columnIndex2, contentResolver);
        writableNativeMap4.putMap("node", writableNativeMap5);
        return writableNativeMap4;
    }

    private static void putBasicNodeInfo(Cursor cursor, WritableMap writableMap, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10, boolean z11) {
        writableMap.putString("id", Long.toString(cursor.getLong(i10)));
        writableMap.putString("type", cursor.getString(i11));
        writableMap.putArray("subTypes", Arguments.createArray());
        if (z11) {
            writableMap.putString(INCLUDE_SOURCE_TYPE, "UserLibrary");
        } else {
            writableMap.putNull(INCLUDE_SOURCE_TYPE);
        }
        WritableArray createArray = Arguments.createArray();
        if (z10) {
            createArray.pushString(cursor.getString(i12));
        }
        writableMap.putArray("group_name", createArray);
        long j10 = cursor.getLong(i13);
        if (j10 == 0) {
            j10 = cursor.getLong(i14) * 1000;
        }
        writableMap.putDouble("timestamp", ((double) j10) / 1000.0d);
        writableMap.putDouble("modificationTimestamp", (double) cursor.getLong(i15));
    }

    /* access modifiers changed from: private */
    public static void putEdges(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i10, Set<String> set) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        cursor.moveToFirst();
        int i11 = 0;
        while (i11 < i10 && !cursor.isAfterLast()) {
            WritableMap convertMediaToMap = convertMediaToMap(contentResolver, cursor, set);
            if (convertMediaToMap != null) {
                writableNativeArray.pushMap(convertMediaToMap);
            } else {
                i11--;
            }
            cursor.moveToNext();
            i11++;
        }
        writableMap.putArray("edges", writableNativeArray);
    }

    private static boolean putImageInfo(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        Uri withAppendedId;
        Cursor cursor2 = cursor;
        int i16 = i14;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        int columnIndex = cursor2.getColumnIndex("_id");
        long j10 = columnIndex >= 0 ? cursor2.getLong(columnIndex) : -1;
        String string = cursor2.getString(i15);
        boolean z16 = string != null && string.startsWith("video");
        if (z16) {
            withAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, j10);
        } else {
            withAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j10);
        }
        Uri uri = withAppendedId;
        writableNativeMap.putString("uri", uri.toString());
        boolean putImageSize = putImageSize(contentResolver, cursor, writableNativeMap, i10, i11, i14, uri, z16, z13);
        boolean putPlayableDuration = putPlayableDuration(contentResolver, writableNativeMap, uri, z16, z14);
        if (z10) {
            writableNativeMap.putString(INCLUDE_FILENAME, new File(cursor2.getString(i13)).getName());
        } else {
            writableNativeMap.putNull(INCLUDE_FILENAME);
        }
        if (z11) {
            writableNativeMap.putDouble(INCLUDE_FILE_SIZE, (double) cursor2.getLong(i12));
        } else {
            writableNativeMap.putNull(INCLUDE_FILE_SIZE);
        }
        if (z12) {
            writableNativeMap.putString("extension", h.a(string));
        } else {
            writableNativeMap.putNull("extension");
        }
        if (!z15) {
            writableNativeMap.putNull(INCLUDE_ORIENTATION);
        } else if (cursor2.isNull(i16)) {
            writableNativeMap.putInt(INCLUDE_ORIENTATION, cursor2.getInt(i16));
        } else {
            writableNativeMap.putInt(INCLUDE_ORIENTATION, 0);
        }
        writableMap.putMap("image", writableNativeMap);
        return putImageSize && putPlayableDuration;
    }

    private static boolean putImageSize(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i10, int i11, int i12, Uri uri, boolean z10, boolean z11) {
        int i13;
        AssetFileDescriptor assetFileDescriptor;
        boolean z12;
        Cursor cursor2 = cursor;
        WritableMap writableMap2 = writableMap;
        int i14 = i12;
        writableMap2.putNull(Snapshot.WIDTH);
        writableMap2.putNull(Snapshot.HEIGHT);
        boolean z13 = true;
        if (!z11) {
            return true;
        }
        int i15 = cursor2.getInt(i10);
        int i16 = cursor2.getInt(i11);
        if (i15 <= 0 || i16 <= 0) {
            boolean z14 = false;
            try {
                assetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                z12 = true;
            } catch (FileNotFoundException e10) {
                z2.a.k("ReactNative", "Could not open asset file " + uri.toString(), e10);
                z12 = false;
                assetFileDescriptor = null;
            }
            if (assetFileDescriptor != null) {
                if (z10) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor());
                    } catch (RuntimeException unused) {
                    }
                    try {
                        i15 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        i16 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                        z14 = z12;
                    } catch (NumberFormatException e11) {
                        z2.a.k("ReactNative", "Number format exception occurred while trying to fetch video metadata for " + uri.toString(), e11);
                    }
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception unused2) {
                    }
                    z13 = z14;
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(assetFileDescriptor.getFileDescriptor(), (Rect) null, options);
                    int i17 = options.outWidth;
                    i16 = options.outHeight;
                    i15 = i17;
                    z13 = z12;
                }
                try {
                    assetFileDescriptor.close();
                } catch (IOException e12) {
                    z2.a.k("ReactNative", "Can't close media descriptor " + uri.toString(), e12);
                }
            } else {
                z13 = z12;
            }
        }
        if (!cursor2.isNull(i14) && (i13 = cursor2.getInt(i14)) >= 0 && i13 % 180 != 0) {
            int i18 = i16;
            i16 = i15;
            i15 = i18;
        }
        writableMap2.putInt(Snapshot.WIDTH, i15);
        writableMap2.putInt(Snapshot.HEIGHT, i16);
        return z13;
    }

    private static void putLocationInfo(Cursor cursor, WritableMap writableMap, int i10, boolean z10, int i11, ContentResolver contentResolver) {
        AssetFileDescriptor assetFileDescriptor;
        writableMap.putNull("location");
        if (z10) {
            try {
                String string = cursor.getString(i11);
                if (string != null) {
                    if (string.startsWith("video")) {
                        Uri parse = Uri.parse("file://" + cursor.getString(i10));
                        try {
                            assetFileDescriptor = contentResolver.openAssetFileDescriptor(parse, "r");
                        } catch (FileNotFoundException e10) {
                            z2.a.k("ReactNative", "Could not open asset file " + parse.toString(), e10);
                            assetFileDescriptor = null;
                        }
                        if (assetFileDescriptor != null) {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor());
                            } catch (RuntimeException unused) {
                            }
                            try {
                                String extractMetadata = mediaMetadataRetriever.extractMetadata(23);
                                if (extractMetadata != null) {
                                    String replaceAll = extractMetadata.replaceAll(DomExceptionUtils.SEPARATOR, "");
                                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                                    writableNativeMap.putDouble("latitude", Double.parseDouble(replaceAll.split("[+]|[-]")[1]));
                                    writableNativeMap.putDouble("longitude", Double.parseDouble(replaceAll.split("[+]|[-]")[2]));
                                    writableMap.putMap("location", writableNativeMap);
                                }
                            } catch (NumberFormatException e11) {
                                z2.a.k("ReactNative", "Number format exception occurred while trying to fetch video metadata for " + parse.toString(), e11);
                            }
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception unused2) {
                            }
                        }
                        if (assetFileDescriptor != null) {
                            try {
                                assetFileDescriptor.close();
                                return;
                            } catch (IOException unused3) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                ExifInterface exifInterface = new ExifInterface(cursor.getString(i10));
                float[] fArr = new float[2];
                if (exifInterface.getLatLong(fArr)) {
                    double d10 = (double) fArr[0];
                    WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    writableNativeMap2.putDouble("longitude", (double) fArr[1]);
                    writableNativeMap2.putDouble("latitude", d10);
                    writableMap.putMap("location", writableNativeMap2);
                }
            } catch (IOException e12) {
                z2.a.k("ReactNative", "Could not read the metadata", e12);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void putPageInfo(Cursor cursor, WritableMap writableMap, int i10, int i11) {
        boolean z10;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (i10 < cursor.getCount()) {
            z10 = true;
        } else {
            z10 = false;
        }
        writableNativeMap.putBoolean("has_next_page", z10);
        if (i10 < cursor.getCount()) {
            writableNativeMap.putString("end_cursor", Integer.toString(i11 + i10));
        }
        writableMap.putMap("page_info", writableNativeMap);
    }

    private static boolean putPlayableDuration(ContentResolver contentResolver, WritableMap writableMap, Uri uri, boolean z10, boolean z11) {
        AssetFileDescriptor assetFileDescriptor;
        writableMap.putNull(INCLUDE_PLAYABLE_DURATION);
        boolean z12 = true;
        if (z11 && z10) {
            boolean z13 = false;
            Integer num = null;
            try {
                assetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException e10) {
                z2.a.k("ReactNative", "Could not open asset file " + uri.toString(), e10);
                z12 = false;
                assetFileDescriptor = null;
            }
            if (assetFileDescriptor != null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor());
                } catch (RuntimeException unused) {
                }
                try {
                    num = Integer.valueOf(Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000);
                    z13 = z12;
                } catch (NumberFormatException e11) {
                    z2.a.k("ReactNative", "Number format exception occurred while trying to fetch video metadata for " + uri.toString(), e11);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception unused2) {
                }
                z12 = z13;
            }
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused3) {
                }
            }
            if (num != null) {
                writableMap.putInt(INCLUDE_PLAYABLE_DURATION, num.intValue());
            }
        }
        return z12;
    }

    public void addListener(String str) {
    }

    @ReactMethod
    public void deleteMediaFiles(ReadableArray readableArray, Promise promise) {
        ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
        ArrayList<Uri> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < readableArray.size(); i10++) {
            arrayList.add(Uri.parse(readableArray.getString(i10)));
        }
        this.deletePromise = promise;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                IntentSender intentSender = MediaStore.createDeleteRequest(contentResolver, arrayList).getIntentSender();
                Activity currentActivity = getCurrentActivity();
                if (currentActivity != null) {
                    currentActivity.startIntentSenderForResult(intentSender, 1001, (Intent) null, 0, 0, 0);
                } else {
                    promise.reject("ERROR", "Activity is null");
                }
            } catch (Exception e10) {
                promise.reject("ERROR", e10.getMessage());
            }
        } else {
            try {
                for (Uri delete : arrayList) {
                    contentResolver.delete(delete, (String) null, (String[]) null);
                }
                promise.resolve("Files deleted");
            } catch (Exception e11) {
                promise.reject("ERROR", e11.getMessage());
            }
        }
    }

    @ReactMethod
    public void deletePhotos(ReadableArray readableArray, Promise promise) {
        if (readableArray.size() == 0) {
            promise.reject(ERROR_UNABLE_TO_DELETE, "Need at least one URI to delete");
        } else {
            deleteMediaFiles(readableArray, promise);
        }
    }

    @ReactMethod
    public void getAlbums(ReadableMap readableMap, Promise promise) {
        Cursor query;
        WritableNativeArray writableNativeArray;
        String string = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : ASSET_TYPE_ALL;
        StringBuilder sb2 = new StringBuilder("1");
        ArrayList arrayList = new ArrayList();
        if (string.equals(ASSET_TYPE_PHOTOS)) {
            sb2.append(" AND media_type = 1");
        } else if (string.equals(ASSET_TYPE_VIDEOS)) {
            sb2.append(" AND media_type = 3");
        } else if (string.equals(ASSET_TYPE_ALL)) {
            sb2.append(" AND media_type IN (3,1)");
        } else {
            promise.reject(ERROR_UNABLE_TO_FILTER, "Invalid filter option: '" + string + "'. Expected one of '" + ASSET_TYPE_PHOTOS + "', '" + ASSET_TYPE_VIDEOS + "' or '" + ASSET_TYPE_ALL + "'.");
            return;
        }
        try {
            query = getReactApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"bucket_display_name", "bucket_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), (String) null);
            if (query == null) {
                promise.reject(ERROR_UNABLE_TO_LOAD, "Could not get media");
                return;
            }
            writableNativeArray = new WritableNativeArray();
            if (query.moveToFirst()) {
                HashMap hashMap = new HashMap();
                do {
                    int columnIndex = query.getColumnIndex("bucket_display_name");
                    int columnIndex2 = query.getColumnIndex("bucket_id");
                    if (columnIndex >= 0) {
                        String string2 = query.getString(columnIndex2);
                        String string3 = query.getString(columnIndex);
                        if (string3 != null) {
                            Map map = (Map) hashMap.get(string3);
                            if (map == null) {
                                hashMap.put(string3, new b(string2));
                            } else {
                                map.put("count", Integer.valueOf(((Integer) map.get("count")).intValue() + 1));
                            }
                        }
                    } else {
                        throw new IndexOutOfBoundsException();
                    }
                } while (query.moveToNext());
                for (Map.Entry entry : hashMap.entrySet()) {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    Map map2 = (Map) entry.getValue();
                    writableNativeMap.putString("title", (String) entry.getKey());
                    writableNativeMap.putInt("count", ((Integer) map2.get("count")).intValue());
                    writableNativeMap.putString("id", (String) map2.get("id"));
                    writableNativeArray.pushMap(writableNativeMap);
                }
            }
            query.close();
            promise.resolve(writableNativeArray);
        } catch (Exception e10) {
            promise.reject(ERROR_UNABLE_TO_LOAD, "Could not get media", (Throwable) e10);
        } catch (Throwable th) {
            query.close();
            promise.resolve(writableNativeArray);
            throw th;
        }
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getPhotoByInternalID(String str, ReadableMap readableMap, Promise promise) {
        promise.reject("CameraRoll:getPhotoByInternalID", "getPhotoByInternalID is not supported on Android");
    }

    @ReactMethod
    public void getPhotoThumbnail(String str, ReadableMap readableMap, Promise promise) {
        promise.reject("CameraRoll:getPhotoThumbnail", "getPhotoThumbnail is not supported on Android");
    }

    @ReactMethod
    public void getPhotos(ReadableMap readableMap, Promise promise) {
        String str;
        String str2;
        String str3;
        long j10;
        long j11;
        ReadableArray readableArray;
        ReadableArray readableArray2;
        ReadableMap readableMap2 = readableMap;
        int i10 = readableMap2.getInt("first");
        if (readableMap2.hasKey("after")) {
            str = readableMap2.getString("after");
        } else {
            str = null;
        }
        if (readableMap2.hasKey("groupName")) {
            str2 = readableMap2.getString("groupName");
        } else {
            str2 = null;
        }
        if (readableMap2.hasKey("assetType")) {
            str3 = readableMap2.getString("assetType");
        } else {
            str3 = ASSET_TYPE_PHOTOS;
        }
        String str4 = str3;
        if (readableMap2.hasKey("fromTime")) {
            j10 = (long) readableMap2.getDouble("fromTime");
        } else {
            j10 = 0;
        }
        if (readableMap2.hasKey("toTime")) {
            j11 = (long) readableMap2.getDouble("toTime");
        } else {
            j11 = 0;
        }
        if (readableMap2.hasKey("mimeTypes")) {
            readableArray = readableMap2.getArray("mimeTypes");
        } else {
            readableArray = null;
        }
        if (readableMap2.hasKey("include")) {
            readableArray2 = readableMap2.getArray("include");
        } else {
            readableArray2 = null;
        }
        new c(getReactApplicationContext(), i10, str, str2, readableArray, str4, j10, j11, readableArray2, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void removeListeners(double d10) {
    }

    @ReactMethod
    public void saveToCameraRoll(String str, ReadableMap readableMap, Promise promise) {
        new d(getReactApplicationContext(), Uri.parse(str), readableMap, promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
