package androidx.credentials.provider.utils;

import android.annotation.SuppressLint;
import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginCreateCredentialRequest;
import android.service.credentials.BeginCreateCredentialResponse;
import android.service.credentials.CallingAppInfo;
import androidx.annotation.RequiresApi;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.provider.BeginCreateCustomCredentialRequest;
import androidx.credentials.provider.BeginCreatePasswordCredentialRequest;
import androidx.credentials.provider.BeginCreatePublicKeyCredentialRequest;
import androidx.credentials.provider.CreateEntry;
import androidx.credentials.provider.RemoteEntry;
import f0.d;
import f0.e;
import f0.f;
import f0.g;
import f0.h;
import f0.i;
import f0.s;
import f0.t;
import f0.u;
import f0.v;
import f0.w;
import java.util.List;
import java.util.stream.Collectors;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

@RequiresApi(34)
public final class BeginCreateCredentialUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {

        static final class a extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final a f15332a = new a();

            a() {
                super(1);
            }

            public final CreateEntry a(android.service.credentials.CreateEntry createEntry) {
                CreateEntry.Companion companion = CreateEntry.Companion;
                Slice a10 = w.a(createEntry);
                m.e(a10, "entry.slice");
                return companion.fromSlice(a10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(v.a(obj));
            }
        }

        static final class b extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final b f15333a = new b();

            b() {
                super(1);
            }

            /* renamed from: a */
            public final Boolean invoke(CreateEntry createEntry) {
                boolean z10;
                if (createEntry != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }

        static final class c extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final c f15334a = new c();

            c() {
                super(1);
            }

            /* renamed from: a */
            public final CreateEntry invoke(CreateEntry createEntry) {
                m.c(createEntry);
                return createEntry;
            }
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public static final CreateEntry convertToJetpackResponse$lambda$5(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return (CreateEntry) function1.invoke(obj);
        }

        /* access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$6(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* access modifiers changed from: private */
        public static final CreateEntry convertToJetpackResponse$lambda$7(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return (CreateEntry) function1.invoke(obj);
        }

        private final void populateCreateEntries(BeginCreateCredentialResponse.Builder builder, List<CreateEntry> list) {
            for (CreateEntry slice : list) {
                Slice slice2 = CreateEntry.Companion.toSlice(slice);
                if (slice2 != null) {
                    BeginCreateCredentialResponse.Builder unused = builder.addCreateEntry(h.a(slice2));
                }
            }
        }

        @SuppressLint({"MissingPermission"})
        private final void populateRemoteEntry(BeginCreateCredentialResponse.Builder builder, RemoteEntry remoteEntry) {
            if (remoteEntry != null) {
                f0.c.a();
                BeginCreateCredentialResponse.Builder unused = builder.setRemoteCreateEntry(f0.b.a(RemoteEntry.Companion.toSlice(remoteEntry)));
            }
        }

        public final BeginCreateCredentialRequest convertToFrameworkRequest(androidx.credentials.provider.BeginCreateCredentialRequest beginCreateCredentialRequest) {
            CallingAppInfo callingAppInfo;
            m.f(beginCreateCredentialRequest, "request");
            if (beginCreateCredentialRequest.getCallingAppInfo() != null) {
                f.a();
                callingAppInfo = d.a(beginCreateCredentialRequest.getCallingAppInfo().getPackageName(), beginCreateCredentialRequest.getCallingAppInfo().getSigningInfo(), beginCreateCredentialRequest.getCallingAppInfo().getOrigin());
            } else {
                callingAppInfo = null;
            }
            g.a();
            return e.a(beginCreateCredentialRequest.getType(), beginCreateCredentialRequest.getCandidateQueryData(), callingAppInfo);
        }

        public final BeginCreateCredentialResponse convertToFrameworkResponse(androidx.credentials.provider.BeginCreateCredentialResponse beginCreateCredentialResponse) {
            m.f(beginCreateCredentialResponse, "response");
            BeginCreateCredentialResponse.Builder a10 = i.a();
            populateCreateEntries(a10, beginCreateCredentialResponse.getCreateEntries());
            populateRemoteEntry(a10, beginCreateCredentialResponse.getRemoteEntry());
            BeginCreateCredentialResponse a11 = a10.build();
            m.e(a11, "frameworkBuilder.build()");
            return a11;
        }

        public final androidx.credentials.provider.BeginCreateCredentialRequest convertToJetpackRequest$credentials_release(BeginCreateCredentialRequest beginCreateCredentialRequest) {
            androidx.credentials.provider.CallingAppInfo callingAppInfo;
            androidx.credentials.provider.CallingAppInfo callingAppInfo2;
            androidx.credentials.provider.CallingAppInfo callingAppInfo3;
            m.f(beginCreateCredentialRequest, "request");
            androidx.credentials.provider.CallingAppInfo callingAppInfo4 = null;
            try {
                String a10 = beginCreateCredentialRequest.getType();
                int hashCode = a10.hashCode();
                if (hashCode != -543568185) {
                    if (hashCode == -95037569) {
                        if (a10.equals(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                            BeginCreatePublicKeyCredentialRequest.Companion companion = BeginCreatePublicKeyCredentialRequest.Companion;
                            Bundle a11 = beginCreateCredentialRequest.getData();
                            m.e(a11, "request.data");
                            CallingAppInfo a12 = beginCreateCredentialRequest.getCallingAppInfo();
                            if (a12 != null) {
                                String a13 = a12.getPackageName();
                                m.e(a13, "it.packageName");
                                SigningInfo a14 = a12.getSigningInfo();
                                m.e(a14, "it.signingInfo");
                                callingAppInfo3 = new androidx.credentials.provider.CallingAppInfo(a13, a14, a12.getOrigin());
                            } else {
                                callingAppInfo3 = null;
                            }
                            return companion.createFrom$credentials_release(a11, callingAppInfo3);
                        }
                    }
                } else if (a10.equals(PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    BeginCreatePasswordCredentialRequest.Companion companion2 = BeginCreatePasswordCredentialRequest.Companion;
                    Bundle a15 = beginCreateCredentialRequest.getData();
                    m.e(a15, "request.data");
                    CallingAppInfo a16 = beginCreateCredentialRequest.getCallingAppInfo();
                    if (a16 != null) {
                        String a17 = a16.getPackageName();
                        m.e(a17, "it.packageName");
                        SigningInfo a18 = a16.getSigningInfo();
                        m.e(a18, "it.signingInfo");
                        callingAppInfo2 = new androidx.credentials.provider.CallingAppInfo(a17, a18, a16.getOrigin());
                    } else {
                        callingAppInfo2 = null;
                    }
                    return companion2.createFrom$credentials_release(a15, callingAppInfo2);
                }
                String a19 = beginCreateCredentialRequest.getType();
                m.e(a19, "request.type");
                Bundle a20 = beginCreateCredentialRequest.getData();
                m.e(a20, "request.data");
                CallingAppInfo a21 = beginCreateCredentialRequest.getCallingAppInfo();
                if (a21 != null) {
                    String a22 = a21.getPackageName();
                    m.e(a22, "it.packageName");
                    SigningInfo a23 = a21.getSigningInfo();
                    m.e(a23, "it.signingInfo");
                    callingAppInfo = new androidx.credentials.provider.CallingAppInfo(a22, a23, a21.getOrigin());
                } else {
                    callingAppInfo = null;
                }
                return new BeginCreateCustomCredentialRequest(a19, a20, callingAppInfo);
            } catch (FrameworkClassParsingException unused) {
                String a24 = beginCreateCredentialRequest.getType();
                m.e(a24, "request.type");
                Bundle a25 = beginCreateCredentialRequest.getData();
                m.e(a25, "request.data");
                CallingAppInfo a26 = beginCreateCredentialRequest.getCallingAppInfo();
                if (a26 != null) {
                    String a27 = a26.getPackageName();
                    m.e(a27, "it.packageName");
                    SigningInfo a28 = a26.getSigningInfo();
                    m.e(a28, "it.signingInfo");
                    callingAppInfo4 = new androidx.credentials.provider.CallingAppInfo(a27, a28, a26.getOrigin());
                }
                return new BeginCreateCustomCredentialRequest(a24, a25, callingAppInfo4);
            }
        }

        public final androidx.credentials.provider.BeginCreateCredentialResponse convertToJetpackResponse(BeginCreateCredentialResponse beginCreateCredentialResponse) {
            RemoteEntry remoteEntry;
            m.f(beginCreateCredentialResponse, "frameworkResponse");
            Object a10 = beginCreateCredentialResponse.getCreateEntries().stream().map(new s(a.f15332a)).filter(new t(b.f15333a)).map(new u(c.f15334a)).collect(Collectors.toList());
            m.e(a10, "frameworkResponse.create…lect(Collectors.toList())");
            List list = (List) a10;
            android.service.credentials.RemoteEntry a11 = beginCreateCredentialResponse.getRemoteCreateEntry();
            if (a11 != null) {
                RemoteEntry.Companion companion = RemoteEntry.Companion;
                Slice a12 = a11.getSlice();
                m.e(a12, "it.slice");
                remoteEntry = companion.fromSlice(a12);
            } else {
                remoteEntry = null;
            }
            return new androidx.credentials.provider.BeginCreateCredentialResponse(list, remoteEntry);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final androidx.credentials.provider.BeginCreateCredentialRequest convertToJetpackRequest$credentials_release(BeginCreateCredentialRequest beginCreateCredentialRequest) {
        return Companion.convertToJetpackRequest$credentials_release(beginCreateCredentialRequest);
    }
}
