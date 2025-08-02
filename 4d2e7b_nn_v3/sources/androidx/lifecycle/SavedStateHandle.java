package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.i0;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.t;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.t1;
import kotlinx.coroutines.flow.u1;

public final class SavedStateHandle {
    /* access modifiers changed from: private */
    public static final Class<? extends Object>[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    /* access modifiers changed from: private */
    public final Map<String, j1> flows;
    private final Map<String, SavingStateLiveData<?>> liveDatas;
    /* access modifiers changed from: private */
    public final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    public static final class Companion {
        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(SavedStateHandle.KEYS);
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(SavedStateHandle.VALUES);
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    throw new IllegalStateException("Invalid bundle passed as restored state".toString());
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = parcelableArrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    Object obj = parcelableArrayList.get(i10);
                    m.d(obj, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap.put((String) obj, parcelableArrayList2.get(i10));
                }
                return new SavedStateHandle(linkedHashMap);
            } else if (bundle2 == null) {
                return new SavedStateHandle();
            } else {
                HashMap hashMap = new HashMap();
                for (String next : bundle2.keySet()) {
                    m.e(next, "key");
                    hashMap.put(next, bundle2.get(next));
                }
                return new SavedStateHandle(hashMap);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.ACCEPTABLE_CLASSES) {
                m.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SavedStateHandle(Map<String, ? extends Object> map) {
        m.f(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.regular = linkedHashMap;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new k(this);
        linkedHashMap.putAll(map);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        return Companion.createHandle(bundle, bundle2);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String str, boolean z10, T t10) {
        MutableLiveData<T> mutableLiveData;
        SavingStateLiveData savingStateLiveData;
        SavingStateLiveData<?> savingStateLiveData2 = this.liveDatas.get(str);
        if (savingStateLiveData2 instanceof MutableLiveData) {
            mutableLiveData = savingStateLiveData2;
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        if (this.regular.containsKey(str)) {
            savingStateLiveData = new SavingStateLiveData(this, str, this.regular.get(str));
        } else if (z10) {
            this.regular.put(str, t10);
            savingStateLiveData = new SavingStateLiveData(this, str, t10);
        } else {
            savingStateLiveData = new SavingStateLiveData(this, str);
        }
        this.liveDatas.put(str, savingStateLiveData);
        return savingStateLiveData;
    }

    /* access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandle savedStateHandle) {
        m.f(savedStateHandle, "this$0");
        for (Map.Entry entry : i0.p(savedStateHandle.savedStateProviders).entrySet()) {
            savedStateHandle.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
        }
        Set<String> keySet = savedStateHandle.regular.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String next : keySet) {
            arrayList.add(next);
            arrayList2.add(savedStateHandle.regular.get(next));
        }
        return BundleKt.bundleOf(t.a(KEYS, arrayList), t.a(VALUES, arrayList2));
    }

    @MainThread
    public final void clearSavedStateProvider(String str) {
        m.f(str, "key");
        this.savedStateProviders.remove(str);
    }

    @MainThread
    public final boolean contains(String str) {
        m.f(str, "key");
        return this.regular.containsKey(str);
    }

    @MainThread
    public final <T> T get(String str) {
        m.f(str, "key");
        try {
            return this.regular.get(str);
        } catch (ClassCastException unused) {
            remove(str);
            return null;
        }
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String str) {
        m.f(str, "key");
        MutableLiveData<T> liveDataInternal = getLiveDataInternal(str, false, (Object) null);
        m.d(liveDataInternal, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return liveDataInternal;
    }

    @MainThread
    public final <T> t1 getStateFlow(String str, T t10) {
        m.f(str, "key");
        Map<String, j1> map = this.flows;
        j1 j1Var = map.get(str);
        if (j1Var == null) {
            if (!this.regular.containsKey(str)) {
                this.regular.put(str, t10);
            }
            j1Var = u1.a(this.regular.get(str));
            this.flows.put(str, j1Var);
            map.put(str, j1Var);
        }
        t1 a10 = e.a(j1Var);
        m.d(a10, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return a10;
    }

    @MainThread
    public final Set<String> keys() {
        return r0.j(r0.j(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    @MainThread
    public final <T> T remove(String str) {
        m.f(str, "key");
        T remove = this.regular.remove(str);
        SavingStateLiveData remove2 = this.liveDatas.remove(str);
        if (remove2 != null) {
            remove2.detach();
        }
        this.flows.remove(str);
        return remove;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(String str, T t10) {
        MutableLiveData mutableLiveData;
        m.f(str, "key");
        if (Companion.validateValue(t10)) {
            SavingStateLiveData<?> savingStateLiveData = this.liveDatas.get(str);
            if (savingStateLiveData instanceof MutableLiveData) {
                mutableLiveData = savingStateLiveData;
            } else {
                mutableLiveData = null;
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(t10);
            } else {
                this.regular.put(str, t10);
            }
            j1 j1Var = this.flows.get(str);
            if (j1Var != null) {
                j1Var.setValue(t10);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't put value with type ");
        m.c(t10);
        sb2.append(t10.getClass());
        sb2.append(" into saved state");
        throw new IllegalArgumentException(sb2.toString());
    }

    @MainThread
    public final void setSavedStateProvider(String str, SavedStateRegistry.SavedStateProvider savedStateProvider2) {
        m.f(str, "key");
        m.f(savedStateProvider2, "provider");
        this.savedStateProviders.put(str, savedStateProvider2);
    }

    @MainThread
    public final <T> MutableLiveData<T> getLiveData(String str, T t10) {
        m.f(str, "key");
        return getLiveDataInternal(str, true, t10);
    }

    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str, T t10) {
            super(t10);
            m.f(str, "key");
            this.key = str;
            this.handle = savedStateHandle;
        }

        public final void detach() {
            this.handle = null;
        }

        public void setValue(T t10) {
            SavedStateHandle savedStateHandle = this.handle;
            if (savedStateHandle != null) {
                savedStateHandle.regular.put(this.key, t10);
                j1 j1Var = (j1) savedStateHandle.flows.get(this.key);
                if (j1Var != null) {
                    j1Var.setValue(t10);
                }
            }
            super.setValue(t10);
        }

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str) {
            m.f(str, "key");
            this.key = str;
            this.handle = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new k(this);
    }
}
