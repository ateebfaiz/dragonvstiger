package com.reactnativecommunity.asyncstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

@s6.a(name = "RNCAsyncStorage")
public final class AsyncStorageModule extends NativeAsyncStorageModuleSpec {
    private static final int MAX_SQL_KEYS = 999;
    public static final String NAME = "RNCAsyncStorage";
    private final l executor;
    /* access modifiers changed from: private */
    public k mReactDatabaseSupplier;
    private boolean mShuttingDown;

    class a extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f11193a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableArray f11194b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ReactContext reactContext, Callback callback, ReadableArray readableArray) {
            super(reactContext);
            this.f11193a = callback;
            this.f11194b = readableArray;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            if (!AsyncStorageModule.this.ensureDatabase()) {
                this.f11193a.invoke(b.a((String) null), null);
                return;
            }
            String[] strArr = {"key", "value"};
            HashSet hashSet = new HashSet();
            WritableArray createArray = Arguments.createArray();
            int i10 = 0;
            while (i10 < this.f11194b.size()) {
                int min = Math.min(this.f11194b.size() - i10, 999);
                int i11 = min;
                int i12 = i10;
                WritableArray writableArray = createArray;
                Cursor query = AsyncStorageModule.this.mReactDatabaseSupplier.m().query("catalystLocalStorage", strArr, a.a(min), a.b(this.f11194b, i10, min), (String) null, (String) null, (String) null);
                hashSet.clear();
                try {
                    if (query.getCount() != this.f11194b.size()) {
                        for (int i13 = i12; i13 < i12 + i11; i13++) {
                            hashSet.add(this.f11194b.getString(i13));
                        }
                    }
                    if (query.moveToFirst()) {
                        do {
                            WritableArray createArray2 = Arguments.createArray();
                            createArray2.pushString(query.getString(0));
                            createArray2.pushString(query.getString(1));
                            writableArray.pushArray(createArray2);
                            hashSet.remove(query.getString(0));
                        } while (query.moveToNext());
                    }
                    query.close();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        WritableArray createArray3 = Arguments.createArray();
                        createArray3.pushString((String) it.next());
                        createArray3.pushNull();
                        writableArray.pushArray(createArray3);
                    }
                    hashSet.clear();
                    i10 = i12 + 999;
                    createArray = writableArray;
                } catch (Exception e10) {
                    z2.a.H("ReactNative", e10.getMessage(), e10);
                    this.f11193a.invoke(b.b((String) null, e10.getMessage()), null);
                    query.close();
                    return;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            this.f11193a.invoke(null, createArray);
        }
    }

    class b extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f11196a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableArray f11197b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ReactContext reactContext, Callback callback, ReadableArray readableArray) {
            super(reactContext);
            this.f11196a = callback;
            this.f11197b = readableArray;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            WritableMap writableMap = null;
            if (!AsyncStorageModule.this.ensureDatabase()) {
                this.f11196a.invoke(b.a((String) null));
                return;
            }
            SQLiteStatement compileStatement = AsyncStorageModule.this.mReactDatabaseSupplier.m().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
            try {
                AsyncStorageModule.this.mReactDatabaseSupplier.m().beginTransaction();
                int i10 = 0;
                while (i10 < this.f11197b.size()) {
                    if (this.f11197b.getArray(i10).size() != 2) {
                        WritableMap d10 = b.d((String) null);
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                            return;
                        } catch (Exception e10) {
                            z2.a.H("ReactNative", e10.getMessage(), e10);
                            if (d10 == null) {
                                b.b((String) null, e10.getMessage());
                                return;
                            }
                            return;
                        }
                    } else if (this.f11197b.getArray(i10).getString(0) == null) {
                        WritableMap c10 = b.c((String) null);
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                            return;
                        } catch (Exception e11) {
                            z2.a.H("ReactNative", e11.getMessage(), e11);
                            if (c10 == null) {
                                b.b((String) null, e11.getMessage());
                                return;
                            }
                            return;
                        }
                    } else if (this.f11197b.getArray(i10).getString(1) == null) {
                        WritableMap d11 = b.d((String) null);
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                            return;
                        } catch (Exception e12) {
                            z2.a.H("ReactNative", e12.getMessage(), e12);
                            if (d11 == null) {
                                b.b((String) null, e12.getMessage());
                                return;
                            }
                            return;
                        }
                    } else {
                        compileStatement.clearBindings();
                        compileStatement.bindString(1, this.f11197b.getArray(i10).getString(0));
                        compileStatement.bindString(2, this.f11197b.getArray(i10).getString(1));
                        compileStatement.execute();
                        i10++;
                    }
                }
                AsyncStorageModule.this.mReactDatabaseSupplier.m().setTransactionSuccessful();
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                } catch (Exception e13) {
                    z2.a.H("ReactNative", e13.getMessage(), e13);
                    writableMap = b.b((String) null, e13.getMessage());
                }
            } catch (Exception e14) {
                z2.a.H("ReactNative", e14.getMessage(), e14);
                WritableMap b10 = b.b((String) null, e14.getMessage());
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                } catch (Exception e15) {
                    z2.a.H("ReactNative", e15.getMessage(), e15);
                    if (b10 == null) {
                        writableMap = b.b((String) null, e15.getMessage());
                    }
                }
                writableMap = b10;
            } catch (Throwable th) {
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                } catch (Exception e16) {
                    z2.a.H("ReactNative", e16.getMessage(), e16);
                    b.b((String) null, e16.getMessage());
                }
                throw th;
            }
            if (writableMap != null) {
                this.f11196a.invoke(writableMap);
                return;
            }
            this.f11196a.invoke(new Object[0]);
        }
    }

    class c extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f11199a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableArray f11200b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ReactContext reactContext, Callback callback, ReadableArray readableArray) {
            super(reactContext);
            this.f11199a = callback;
            this.f11200b = readableArray;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            WritableMap writableMap = null;
            if (!AsyncStorageModule.this.ensureDatabase()) {
                this.f11199a.invoke(b.a((String) null));
                return;
            }
            try {
                AsyncStorageModule.this.mReactDatabaseSupplier.m().beginTransaction();
                for (int i10 = 0; i10 < this.f11200b.size(); i10 += 999) {
                    int min = Math.min(this.f11200b.size() - i10, 999);
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().delete("catalystLocalStorage", a.a(min), a.b(this.f11200b, i10, min));
                }
                AsyncStorageModule.this.mReactDatabaseSupplier.m().setTransactionSuccessful();
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                } catch (Exception e10) {
                    z2.a.H("ReactNative", e10.getMessage(), e10);
                    writableMap = b.b((String) null, e10.getMessage());
                }
            } catch (Exception e11) {
                z2.a.H("ReactNative", e11.getMessage(), e11);
                WritableMap b10 = b.b((String) null, e11.getMessage());
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                } catch (Exception e12) {
                    z2.a.H("ReactNative", e12.getMessage(), e12);
                    if (b10 == null) {
                        b10 = b.b((String) null, e12.getMessage());
                    }
                }
                writableMap = b10;
            } catch (Throwable th) {
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                } catch (Exception e13) {
                    z2.a.H("ReactNative", e13.getMessage(), e13);
                    b.b((String) null, e13.getMessage());
                }
                throw th;
            }
            if (writableMap != null) {
                this.f11199a.invoke(writableMap);
                return;
            }
            this.f11199a.invoke(new Object[0]);
        }
    }

    class d extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f11202a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableArray f11203b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ReactContext reactContext, Callback callback, ReadableArray readableArray) {
            super(reactContext);
            this.f11202a = callback;
            this.f11203b = readableArray;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            WritableMap writableMap = null;
            if (!AsyncStorageModule.this.ensureDatabase()) {
                this.f11202a.invoke(b.a((String) null));
                return;
            }
            try {
                AsyncStorageModule.this.mReactDatabaseSupplier.m().beginTransaction();
                int i10 = 0;
                while (i10 < this.f11203b.size()) {
                    if (this.f11203b.getArray(i10).size() != 2) {
                        WritableMap d10 = b.d((String) null);
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                            return;
                        } catch (Exception e10) {
                            z2.a.H("ReactNative", e10.getMessage(), e10);
                            if (d10 == null) {
                                b.b((String) null, e10.getMessage());
                                return;
                            }
                            return;
                        }
                    } else if (this.f11203b.getArray(i10).getString(0) == null) {
                        WritableMap c10 = b.c((String) null);
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                            return;
                        } catch (Exception e11) {
                            z2.a.H("ReactNative", e11.getMessage(), e11);
                            if (c10 == null) {
                                b.b((String) null, e11.getMessage());
                                return;
                            }
                            return;
                        }
                    } else if (this.f11203b.getArray(i10).getString(1) == null) {
                        WritableMap d11 = b.d((String) null);
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                            return;
                        } catch (Exception e12) {
                            z2.a.H("ReactNative", e12.getMessage(), e12);
                            if (d11 == null) {
                                b.b((String) null, e12.getMessage());
                                return;
                            }
                            return;
                        }
                    } else if (!a.e(AsyncStorageModule.this.mReactDatabaseSupplier.m(), this.f11203b.getArray(i10).getString(0), this.f11203b.getArray(i10).getString(1))) {
                        WritableMap a10 = b.a((String) null);
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                            return;
                        } catch (Exception e13) {
                            z2.a.H("ReactNative", e13.getMessage(), e13);
                            if (a10 == null) {
                                b.b((String) null, e13.getMessage());
                                return;
                            }
                            return;
                        }
                    } else {
                        i10++;
                    }
                }
                AsyncStorageModule.this.mReactDatabaseSupplier.m().setTransactionSuccessful();
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                } catch (Exception e14) {
                    z2.a.H("ReactNative", e14.getMessage(), e14);
                    writableMap = b.b((String) null, e14.getMessage());
                }
            } catch (Exception e15) {
                z2.a.H("ReactNative", e15.getMessage(), e15);
                WritableMap b10 = b.b((String) null, e15.getMessage());
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                } catch (Exception e16) {
                    z2.a.H("ReactNative", e16.getMessage(), e16);
                    if (b10 == null) {
                        writableMap = b.b((String) null, e16.getMessage());
                    }
                }
                writableMap = b10;
            } catch (Throwable th) {
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.m().endTransaction();
                } catch (Exception e17) {
                    z2.a.H("ReactNative", e17.getMessage(), e17);
                    b.b((String) null, e17.getMessage());
                }
                throw th;
            }
            if (writableMap != null) {
                this.f11202a.invoke(writableMap);
                return;
            }
            this.f11202a.invoke(new Object[0]);
        }
    }

    class e extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f11205a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ReactContext reactContext, Callback callback) {
            super(reactContext);
            this.f11205a = callback;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            if (!AsyncStorageModule.this.mReactDatabaseSupplier.k()) {
                this.f11205a.invoke(b.a((String) null));
                return;
            }
            try {
                AsyncStorageModule.this.mReactDatabaseSupplier.a();
                this.f11205a.invoke(new Object[0]);
            } catch (Exception e10) {
                z2.a.H("ReactNative", e10.getMessage(), e10);
                this.f11205a.invoke(b.b((String) null, e10.getMessage()));
            }
        }
    }

    class f extends GuardedAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f11207a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ReactContext reactContext, Callback callback) {
            super(reactContext);
            this.f11207a = callback;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void doInBackgroundGuarded(Void... voidArr) {
            if (!AsyncStorageModule.this.ensureDatabase()) {
                this.f11207a.invoke(b.a((String) null), null);
                return;
            }
            WritableArray createArray = Arguments.createArray();
            Cursor query = AsyncStorageModule.this.mReactDatabaseSupplier.m().query("catalystLocalStorage", new String[]{"key"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            try {
                if (query.moveToFirst()) {
                    do {
                        createArray.pushString(query.getString(0));
                    } while (query.moveToNext());
                }
                query.close();
                this.f11207a.invoke(null, createArray);
            } catch (Exception e10) {
                z2.a.H("ReactNative", e10.getMessage(), e10);
                this.f11207a.invoke(b.b((String) null, e10.getMessage()), null);
                query.close();
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    /* access modifiers changed from: private */
    public boolean ensureDatabase() {
        if (this.mShuttingDown || !this.mReactDatabaseSupplier.k()) {
            return false;
        }
        return true;
    }

    @ReactMethod
    public void clear(Callback callback) {
        new e(getReactApplicationContext(), callback).executeOnExecutor(this.executor, new Void[0]);
    }

    public void clearSensitiveData() {
        this.mReactDatabaseSupplier.b();
    }

    @ReactMethod
    public void getAllKeys(Callback callback) {
        new f(getReactApplicationContext(), callback).executeOnExecutor(this.executor, new Void[0]);
    }

    public String getName() {
        return NAME;
    }

    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    public void invalidate() {
        this.mShuttingDown = true;
        this.mReactDatabaseSupplier.h();
    }

    @ReactMethod
    public void multiGet(ReadableArray readableArray, Callback callback) {
        if (readableArray == null) {
            callback.invoke(b.c((String) null), null);
            return;
        }
        new a(getReactApplicationContext(), callback, readableArray).executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiMerge(ReadableArray readableArray, Callback callback) {
        new d(getReactApplicationContext(), callback, readableArray).executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiRemove(ReadableArray readableArray, Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new c(getReactApplicationContext(), callback, readableArray).executeOnExecutor(this.executor, new Void[0]);
        }
    }

    @ReactMethod
    public void multiSet(ReadableArray readableArray, Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new b(getReactApplicationContext(), callback, readableArray).executeOnExecutor(this.executor, new Void[0]);
        }
    }

    AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor2) {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        h.g(reactApplicationContext);
        this.executor = new l(executor2);
        this.mReactDatabaseSupplier = k.n(reactApplicationContext);
    }
}
