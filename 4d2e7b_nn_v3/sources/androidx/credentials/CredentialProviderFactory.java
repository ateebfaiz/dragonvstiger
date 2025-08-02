package androidx.credentials;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class CredentialProviderFactory {
    private static final String CREDENTIAL_PROVIDER_KEY = "androidx.credentials.CREDENTIAL_PROVIDER_KEY";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_CRED_MAN_PRE_FRAMEWORK_API_LEVEL = 33;
    private static final String TAG = "CredProviderFactory";

    public static final class Companion {
        private Companion() {
        }

        private final List<String> getAllowedProvidersFromManifest(Context context) {
            String string;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 132);
            ArrayList arrayList = new ArrayList();
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            if (serviceInfoArr != null) {
                m.e(serviceInfoArr, "packageInfo.services");
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    Bundle bundle = serviceInfo.metaData;
                    if (!(bundle == null || (string = bundle.getString(CredentialProviderFactory.CREDENTIAL_PROVIDER_KEY)) == null)) {
                        arrayList.add(string);
                    }
                }
            }
            return r.w0(arrayList);
        }

        private final CredentialProvider instantiatePreUProvider(List<String> list, Context context) {
            CredentialProvider credentialProvider = null;
            for (String cls : list) {
                try {
                    Object newInstance = Class.forName(cls).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                    m.d(newInstance, "null cannot be cast to non-null type androidx.credentials.CredentialProvider");
                    CredentialProvider credentialProvider2 = (CredentialProvider) newInstance;
                    if (!credentialProvider2.isAvailableOnDevice()) {
                        continue;
                    } else if (credentialProvider != null) {
                        Log.i(CredentialProviderFactory.TAG, "Only one active OEM CredentialProvider allowed");
                        return null;
                    } else {
                        credentialProvider = credentialProvider2;
                    }
                } catch (Throwable unused) {
                }
            }
            return credentialProvider;
        }

        private final CredentialProvider tryCreatePreUOemProvider(Context context) {
            List<String> allowedProvidersFromManifest = getAllowedProvidersFromManifest(context);
            if (allowedProvidersFromManifest.isEmpty()) {
                return null;
            }
            return instantiatePreUProvider(allowedProvidersFromManifest, context);
        }

        public final CredentialProvider getBestAvailableProvider(Context context) {
            m.f(context, "context");
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 34) {
                return new CredentialProviderFrameworkImpl(context);
            }
            if (i10 <= 33) {
                return tryCreatePreUOemProvider(context);
            }
            return null;
        }

        @RequiresApi(34)
        public final CredentialProvider getUAndAboveProvider(Context context) {
            m.f(context, "context");
            return new CredentialProviderFrameworkImpl(context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
