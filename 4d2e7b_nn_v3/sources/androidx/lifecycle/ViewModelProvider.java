package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public class ViewModelProvider {
    private final CreationExtras defaultCreationExtras;
    private final Factory factory;
    private final ViewModelStore store;

    public interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final Factory from(ViewModelInitializer<?>... viewModelInitializerArr) {
                m.f(viewModelInitializerArr, "initializers");
                return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
            }
        }

        <T extends ViewModel> T create(Class<T> cls);

        <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras);
    }

    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = Companion.a.f15874a;
        /* access modifiers changed from: private */
        public static NewInstanceFactory sInstance;

        public static final class Companion {

            private static final class a implements CreationExtras.Key {

                /* renamed from: a  reason: collision with root package name */
                public static final a f15874a = new a();

                private a() {
                }
            }

            private Companion() {
            }

            public static /* synthetic */ void getInstance$annotations() {
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory access$getSInstance$cp = NewInstanceFactory.sInstance;
                m.c(access$getSInstance$cp);
                return access$getSInstance$cp;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return l.b(this, cls, creationExtras);
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            m.f(cls, "modelClass");
            try {
                T newInstance = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                m.e(newInstance, "{\n                modelC…wInstance()\n            }");
                return (ViewModel) newInstance;
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (IllegalAccessException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
            m.f(viewModel, "viewModel");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory2) {
        this(viewModelStore, factory2, (CreationExtras) null, 4, (DefaultConstructorMarker) null);
        m.f(viewModelStore, "store");
        m.f(factory2, "factory");
    }

    @MainThread
    public <T extends ViewModel> T get(Class<T> cls) {
        m.f(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static final CreationExtras.Key<Application> APPLICATION_KEY = Companion.a.f15873a;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
        /* access modifiers changed from: private */
        public static AndroidViewModelFactory sInstance;
        private final Application application;

        public static final class Companion {

            private static final class a implements CreationExtras.Key {

                /* renamed from: a  reason: collision with root package name */
                public static final a f15873a = new a();

                private a() {
                }
            }

            private Companion() {
            }

            public final Factory defaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner viewModelStoreOwner) {
                m.f(viewModelStoreOwner, "owner");
                if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
                    return ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory();
                }
                return NewInstanceFactory.Companion.getInstance();
            }

            public final AndroidViewModelFactory getInstance(Application application) {
                m.f(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory access$getSInstance$cp = AndroidViewModelFactory.sInstance;
                m.c(access$getSInstance$cp);
                return access$getSInstance$cp;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private AndroidViewModelFactory(Application application2, int i10) {
            this.application = application2;
        }

        public static final AndroidViewModelFactory getInstance(Application application2) {
            return Companion.getInstance(application2);
        }

        public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            m.f(cls, "modelClass");
            m.f(creationExtras, "extras");
            if (this.application != null) {
                return create(cls);
            }
            Application application2 = (Application) creationExtras.get(APPLICATION_KEY);
            if (application2 != null) {
                return create(cls, application2);
            }
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public AndroidViewModelFactory() {
            this((Application) null, 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application2) {
            this(application2, 0);
            m.f(application2, "application");
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            m.f(cls, "modelClass");
            Application application2 = this.application;
            if (application2 != null) {
                return create(cls, application2);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private final <T extends ViewModel> T create(Class<T> cls, Application application2) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                T t10 = (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application2});
                m.e(t10, "{\n                try {\n…          }\n            }");
                return t10;
            } catch (NoSuchMethodException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (InstantiationException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory2, CreationExtras creationExtras) {
        m.f(viewModelStore, "store");
        m.f(factory2, "factory");
        m.f(creationExtras, "defaultCreationExtras");
        this.store = viewModelStore;
        this.factory = factory2;
        this.defaultCreationExtras = creationExtras;
    }

    @MainThread
    public <T extends ViewModel> T get(String str, Class<T> cls) {
        T t10;
        m.f(str, "key");
        m.f(cls, "modelClass");
        T t11 = this.store.get(str);
        if (cls.isInstance(t11)) {
            Factory factory2 = this.factory;
            OnRequeryFactory onRequeryFactory = factory2 instanceof OnRequeryFactory ? (OnRequeryFactory) factory2 : null;
            if (onRequeryFactory != null) {
                m.c(t11);
                onRequeryFactory.onRequery(t11);
            }
            m.d(t11, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return t11;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultCreationExtras);
        mutableCreationExtras.set(NewInstanceFactory.VIEW_MODEL_KEY, str);
        try {
            t10 = this.factory.create(cls, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t10 = this.factory.create(cls);
        }
        this.store.put(str, t10);
        return t10;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory2, CreationExtras creationExtras, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, factory2, (i10 & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner) {
        this(viewModelStoreOwner.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(viewModelStoreOwner), ViewModelProviderGetKt.defaultCreationExtras(viewModelStoreOwner));
        m.f(viewModelStoreOwner, "owner");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory2) {
        this(viewModelStoreOwner.getViewModelStore(), factory2, ViewModelProviderGetKt.defaultCreationExtras(viewModelStoreOwner));
        m.f(viewModelStoreOwner, "owner");
        m.f(factory2, "factory");
    }
}
