package com.sensorsdata.analytics.android.sdk.plugin.encrypt;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.SASpUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractStoreManager {
    private static final String TAG = "SA.AbstractStoreManager";
    protected boolean mDefaultState = true;
    private final Lock mLock = new ReentrantLock(true);
    private final LruCacheData mLruCacheSPData = new LruCacheData(10);
    /* access modifiers changed from: private */
    public String mMaxPluginType;
    private StorePlugin mMaxPriorityPlugin;
    private final List<StorePlugin> mStorePluginList = new ArrayList();
    private final Set<String> mStoreTypes = new HashSet();

    private class LruCacheData {
        private LruCache<String, Object> mCacheSPData;

        public LruCacheData(int i10) {
            this.mCacheSPData = new LruCache<>(i10);
        }

        /* access modifiers changed from: package-private */
        public Object get(String str) {
            LruCache<String, Object> lruCache = this.mCacheSPData;
            return lruCache.get(AbstractStoreManager.this.mMaxPluginType + str);
        }

        /* access modifiers changed from: package-private */
        public void put(String str, Object obj) {
            LruCache<String, Object> lruCache = this.mCacheSPData;
            lruCache.put(AbstractStoreManager.this.mMaxPluginType + str, obj);
        }

        /* access modifiers changed from: package-private */
        public void remove(String str) {
            LruCache<String, Object> lruCache = this.mCacheSPData;
            lruCache.remove(AbstractStoreManager.this.mMaxPluginType + str);
        }
    }

    protected AbstractStoreManager() {
    }

    private <T> T getValue(String str, String str2, T t10) {
        T t11;
        StorePlugin storePlugin = this.mMaxPriorityPlugin;
        Iterator<StorePlugin> it = this.mStorePluginList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StorePlugin next = it.next();
            if (next instanceof DefaultStorePlugin) {
                DefaultStorePlugin defaultStorePlugin = (DefaultStorePlugin) next;
                if (defaultStorePlugin.storeKeys() != null && defaultStorePlugin.storeKeys().contains(str)) {
                    storePlugin = next;
                    break;
                }
            }
        }
        str2.hashCode();
        char c10 = 65535;
        switch (str2.hashCode()) {
            case -1808118735:
                if (str2.equals("String")) {
                    c10 = 0;
                    break;
                }
                break;
            case -672261858:
                if (str2.equals("Integer")) {
                    c10 = 1;
                    break;
                }
                break;
            case 2076426:
                if (str2.equals("Bool")) {
                    c10 = 2;
                    break;
                }
                break;
            case 2374300:
                if (str2.equals("Long")) {
                    c10 = 3;
                    break;
                }
                break;
            case 67973692:
                if (str2.equals("Float")) {
                    c10 = 4;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                t11 = storePlugin.getString(storePlugin.type() + str);
                break;
            case 1:
                t11 = storePlugin.getInteger(storePlugin.type() + str);
                break;
            case 2:
                t11 = storePlugin.getBool(storePlugin.type() + str);
                break;
            case 3:
                t11 = storePlugin.getLong(storePlugin.type() + str);
                break;
            case 4:
                t11 = storePlugin.getFloat(storePlugin.type() + str);
                break;
            default:
                t11 = null;
                break;
        }
        if (t11 == null) {
            return t10;
        }
        return t11;
    }

    private void removeUselessValue(String str) {
        for (StorePlugin next : this.mStorePluginList) {
            if (next != this.mMaxPriorityPlugin) {
                next.remove(next.type() + str);
            }
        }
    }

    private void storeKeys(String str, Object obj, String str2) {
        StorePlugin storePlugin = this.mMaxPriorityPlugin;
        Iterator<StorePlugin> it = this.mStorePluginList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StorePlugin next = it.next();
            if (next instanceof DefaultStorePlugin) {
                DefaultStorePlugin defaultStorePlugin = (DefaultStorePlugin) next;
                if (defaultStorePlugin.storeKeys() != null && defaultStorePlugin.storeKeys().contains(str)) {
                    storePlugin = next;
                    break;
                }
            }
        }
        str2.hashCode();
        char c10 = 65535;
        switch (str2.hashCode()) {
            case -1808118735:
                if (str2.equals("String")) {
                    c10 = 0;
                    break;
                }
                break;
            case -672261858:
                if (str2.equals("Integer")) {
                    c10 = 1;
                    break;
                }
                break;
            case 2076426:
                if (str2.equals("Bool")) {
                    c10 = 2;
                    break;
                }
                break;
            case 2374300:
                if (str2.equals("Long")) {
                    c10 = 3;
                    break;
                }
                break;
            case 67973692:
                if (str2.equals("Float")) {
                    c10 = 4;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                storePlugin.setString(storePlugin.type() + str, (String) obj);
                return;
            case 1:
                storePlugin.setInteger(storePlugin.type() + str, ((Integer) obj).intValue());
                return;
            case 2:
                storePlugin.setBool(storePlugin.type() + str, ((Boolean) obj).booleanValue());
                return;
            case 3:
                storePlugin.setLong(storePlugin.type() + str, ((Long) obj).longValue());
                return;
            case 4:
                storePlugin.setFloat(storePlugin.type() + str, ((Float) obj).floatValue());
                return;
            default:
                return;
        }
    }

    public boolean getBool(String str, boolean z10) {
        boolean booleanValue;
        this.mLock.lock();
        try {
            Boolean bool = (Boolean) this.mLruCacheSPData.get(str);
            if (bool != null) {
                booleanValue = bool.booleanValue();
            } else if (this.mDefaultState) {
                booleanValue = ((Boolean) getValue(str, "Bool", Boolean.valueOf(z10))).booleanValue();
            } else {
                Iterator<StorePlugin> it = this.mStorePluginList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StorePlugin next = it.next();
                    Boolean bool2 = next.getBool(next.type() + str);
                    if (bool2 != null) {
                        if (next != this.mMaxPriorityPlugin) {
                            next.remove(next.type() + str);
                            StorePlugin storePlugin = this.mMaxPriorityPlugin;
                            storePlugin.setBool(this.mMaxPluginType + str, bool2.booleanValue());
                        }
                        this.mLruCacheSPData.put(str, bool2);
                        bool = bool2;
                    } else {
                        bool = bool2;
                    }
                }
                if (bool != null) {
                    z10 = bool.booleanValue();
                }
                this.mLock.unlock();
                return z10;
            }
            return booleanValue;
        } catch (Exception e10) {
            SALog.i(TAG, "get data failed,key = " + str, (Throwable) e10);
            return z10;
        } finally {
            this.mLock.unlock();
        }
    }

    public float getFloat(String str, float f10) {
        float floatValue;
        this.mLock.lock();
        try {
            Float f11 = (Float) this.mLruCacheSPData.get(str);
            if (f11 != null) {
                floatValue = f11.floatValue();
            } else if (this.mDefaultState) {
                floatValue = ((Float) getValue(str, "Float", Float.valueOf(f10))).floatValue();
            } else {
                Iterator<StorePlugin> it = this.mStorePluginList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StorePlugin next = it.next();
                    Float f12 = next.getFloat(next.type() + str);
                    if (f12 != null) {
                        if (next != this.mMaxPriorityPlugin) {
                            next.remove(next.type() + str);
                            StorePlugin storePlugin = this.mMaxPriorityPlugin;
                            storePlugin.setFloat(this.mMaxPluginType + str, f12.floatValue());
                        }
                        this.mLruCacheSPData.put(str, f12);
                        f11 = f12;
                    } else {
                        f11 = f12;
                    }
                }
                if (f11 != null) {
                    f10 = f11.floatValue();
                }
                this.mLock.unlock();
                return f10;
            }
            return floatValue;
        } catch (Exception e10) {
            SALog.i(TAG, "get data failed,key = " + str, (Throwable) e10);
            return f10;
        } finally {
            this.mLock.unlock();
        }
    }

    public int getInteger(String str, int i10) {
        int intValue;
        this.mLock.lock();
        try {
            Integer num = (Integer) this.mLruCacheSPData.get(str);
            if (num != null) {
                intValue = num.intValue();
            } else if (this.mDefaultState) {
                intValue = ((Integer) getValue(str, "Integer", Integer.valueOf(i10))).intValue();
            } else {
                Iterator<StorePlugin> it = this.mStorePluginList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StorePlugin next = it.next();
                    Integer integer = next.getInteger(next.type() + str);
                    if (integer != null) {
                        if (next != this.mMaxPriorityPlugin) {
                            next.remove(next.type() + str);
                            StorePlugin storePlugin = this.mMaxPriorityPlugin;
                            storePlugin.setInteger(this.mMaxPluginType + str, integer.intValue());
                        }
                        this.mLruCacheSPData.put(str, integer);
                        num = integer;
                    } else {
                        num = integer;
                    }
                }
                if (num != null) {
                    i10 = num.intValue();
                }
                this.mLock.unlock();
                return i10;
            }
            return intValue;
        } catch (Exception e10) {
            SALog.i(TAG, "get data failed,key = " + str, (Throwable) e10);
            return i10;
        } finally {
            this.mLock.unlock();
        }
    }

    public Long getLong(String str, long j10) {
        long j11;
        this.mLock.lock();
        try {
            Long l10 = (Long) this.mLruCacheSPData.get(str);
            if (l10 == null) {
                if (this.mDefaultState) {
                    l10 = (Long) getValue(str, "Long", Long.valueOf(j10));
                } else {
                    Iterator<StorePlugin> it = this.mStorePluginList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        StorePlugin next = it.next();
                        Long l11 = next.getLong(next.type() + str);
                        if (l11 != null) {
                            if (next != this.mMaxPriorityPlugin) {
                                next.remove(next.type() + str);
                                StorePlugin storePlugin = this.mMaxPriorityPlugin;
                                storePlugin.setLong(this.mMaxPluginType + str, l11.longValue());
                            }
                            this.mLruCacheSPData.put(str, l11);
                            l10 = l11;
                        } else {
                            l10 = l11;
                        }
                    }
                    if (l10 == null) {
                        j11 = j10;
                    } else {
                        j11 = l10.longValue();
                    }
                    Long valueOf = Long.valueOf(j11);
                    this.mLock.unlock();
                    return valueOf;
                }
            }
            this.mLock.unlock();
            return l10;
        } catch (Exception e10) {
            SALog.i(TAG, "get data failed,key = " + str, (Throwable) e10);
            this.mLock.unlock();
            return Long.valueOf(j10);
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public String getString(String str, String str2) {
        this.mLock.lock();
        try {
            String str3 = (String) this.mLruCacheSPData.get(str);
            if (str3 == null) {
                if (this.mDefaultState) {
                    str3 = (String) getValue(str, "String", str2);
                } else {
                    Iterator<StorePlugin> it = this.mStorePluginList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        StorePlugin next = it.next();
                        String string = next.getString(next.type() + str);
                        if (!TextUtils.isEmpty(string)) {
                            if (next != this.mMaxPriorityPlugin) {
                                next.remove(next.type() + str);
                                StorePlugin storePlugin = this.mMaxPriorityPlugin;
                                storePlugin.setString(this.mMaxPluginType + str, string);
                            }
                            this.mLruCacheSPData.put(str, string);
                            str3 = string;
                        } else {
                            str3 = string;
                        }
                    }
                    if (str3 != null) {
                        str2 = str3;
                    }
                    this.mLock.unlock();
                    return str2;
                }
            }
            this.mLock.unlock();
            return str3;
        } catch (Exception e10) {
            SALog.i(TAG, "get data failed,key = " + str, (Throwable) e10);
            this.mLock.unlock();
            return str2;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public boolean isExists(String str) {
        this.mLock.lock();
        try {
            if (TextUtils.isEmpty(str)) {
                this.mLock.unlock();
                return false;
            }
            for (StorePlugin next : this.mStorePluginList) {
                if (next.isExists(next.type() + str)) {
                    this.mLock.unlock();
                    return true;
                }
            }
            this.mLock.unlock();
            return false;
        } catch (Exception e10) {
            SALog.i(TAG, "isExists failed,key = " + str, (Throwable) e10);
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isRegisterPlugin(Context context, String str) {
        try {
            File file = new File("data/data/" + context.getPackageName() + "/shared_prefs", str + ".xml");
            if (!file.exists()) {
                return false;
            }
            if (SASpUtils.getSharedPreferences(context, str, 0).getAll().size() == 0) {
                SALog.i(TAG, "delete sp: " + str);
                return !file.delete();
            }
            return true;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void registerPlugin(StorePlugin storePlugin) {
        if (storePlugin != null) {
            String type = storePlugin.type();
            if (TextUtils.isEmpty(type)) {
                SALog.i(TAG, "PluginType is null");
                return;
            }
            if (this.mStoreTypes.contains(type)) {
                Iterator<StorePlugin> it = this.mStorePluginList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StorePlugin next = it.next();
                    if (TextUtils.equals(type, next.type())) {
                        this.mStorePluginList.remove(next);
                        break;
                    }
                }
            } else {
                this.mStoreTypes.add(type);
            }
            this.mStorePluginList.add(0, storePlugin);
            this.mMaxPriorityPlugin = storePlugin;
            this.mMaxPluginType = storePlugin.type();
        }
    }

    public void remove(String str) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                StorePlugin storePlugin = this.mMaxPriorityPlugin;
                Iterator<StorePlugin> it = this.mStorePluginList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StorePlugin next = it.next();
                    if ((next instanceof DefaultStorePlugin) && ((DefaultStorePlugin) next).storeKeys() != null && ((DefaultStorePlugin) next).storeKeys().contains(str)) {
                        storePlugin = next;
                        break;
                    }
                }
                storePlugin.remove(storePlugin.type() + str);
            } else {
                for (StorePlugin next2 : this.mStorePluginList) {
                    next2.remove(next2.type() + str);
                }
            }
            this.mLruCacheSPData.remove(str);
        } catch (Exception e10) {
            SALog.i(TAG, "remove failed,key = " + str, (Throwable) e10);
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
        this.mLock.unlock();
    }

    public void setBool(String str, boolean z10) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, Boolean.valueOf(z10), "Bool");
                this.mLock.unlock();
                return;
            }
            removeUselessValue(str);
            StorePlugin storePlugin = this.mMaxPriorityPlugin;
            storePlugin.setBool(this.mMaxPluginType + str, z10);
            this.mLruCacheSPData.put(str, Boolean.valueOf(z10));
            this.mLock.unlock();
        } catch (Exception e10) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + z10, (Throwable) e10);
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void setFloat(String str, float f10) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, Float.valueOf(f10), "Float");
                this.mLock.unlock();
                return;
            }
            removeUselessValue(str);
            StorePlugin storePlugin = this.mMaxPriorityPlugin;
            storePlugin.setFloat(this.mMaxPluginType + str, f10);
            this.mLruCacheSPData.put(str, Float.valueOf(f10));
            this.mLock.unlock();
        } catch (Exception e10) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + f10, (Throwable) e10);
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void setInteger(String str, int i10) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, Integer.valueOf(i10), "Integer");
                this.mLock.unlock();
                return;
            }
            removeUselessValue(str);
            StorePlugin storePlugin = this.mMaxPriorityPlugin;
            storePlugin.setInteger(this.mMaxPluginType + str, i10);
            this.mLruCacheSPData.put(str, Integer.valueOf(i10));
            this.mLock.unlock();
        } catch (Exception e10) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + i10, (Throwable) e10);
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void setLong(String str, long j10) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, Long.valueOf(j10), "Long");
                this.mLock.unlock();
                return;
            }
            removeUselessValue(str);
            StorePlugin storePlugin = this.mMaxPriorityPlugin;
            storePlugin.setLong(this.mMaxPluginType + str, j10);
            this.mLruCacheSPData.put(str, Long.valueOf(j10));
            this.mLock.unlock();
        } catch (Exception e10) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + j10, (Throwable) e10);
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void setString(String str, String str2) {
        this.mLock.lock();
        try {
            if (this.mDefaultState) {
                storeKeys(str, str2, "String");
                this.mLock.unlock();
                return;
            }
            if (str2 == null) {
                for (StorePlugin next : this.mStorePluginList) {
                    next.remove(next.type() + str);
                }
                this.mLruCacheSPData.remove(str);
            } else {
                removeUselessValue(str);
                StorePlugin storePlugin = this.mMaxPriorityPlugin;
                storePlugin.setString(this.mMaxPluginType + str, str2);
                this.mLruCacheSPData.put(str, str2);
            }
            this.mLock.unlock();
        } catch (Exception e10) {
            SALog.i(TAG, "save data failed,key = " + str + "value = " + str2, (Throwable) e10);
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void upgrade() {
        StorePlugin storePlugin;
        this.mLock.lock();
        try {
            for (int size = this.mStorePluginList.size() - 1; size >= 0; size--) {
                StorePlugin storePlugin2 = this.mStorePluginList.get(size);
                int i10 = size - 1;
                if (i10 >= 0) {
                    storePlugin = this.mStorePluginList.get(i10);
                } else {
                    storePlugin = null;
                }
                if (storePlugin != null) {
                    storePlugin.upgrade(storePlugin2);
                }
            }
        } catch (Exception e10) {
            SALog.i(TAG, "upgrade failed", (Throwable) e10);
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
        this.mLock.unlock();
    }
}
