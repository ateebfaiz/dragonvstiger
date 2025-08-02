package androidx.credentials.provider.utils;

import android.annotation.SuppressLint;
import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.BeginGetCredentialResponse;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.provider.Action;
import androidx.credentials.provider.AuthenticationAction;
import androidx.credentials.provider.BeginGetCredentialOption;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.CredentialEntry;
import androidx.credentials.provider.RemoteEntry;
import f0.a1;
import f0.b1;
import f0.c1;
import f0.d1;
import f0.e1;
import f0.f1;
import f0.g0;
import f0.g1;
import f0.h0;
import f0.h1;
import f0.i1;
import f0.j0;
import f0.j1;
import f0.k0;
import f0.k1;
import f0.l0;
import f0.m0;
import f0.n0;
import f0.o0;
import f0.r0;
import f0.x0;
import f0.y0;
import f0.z0;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

@RequiresApi(34)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class BeginGetCredentialUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public static final class Companion {

        static final class a extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final a f15335a = new a();

            a() {
                super(1);
            }

            /* renamed from: a */
            public final BeginGetCredentialOption invoke(androidx.credentials.provider.BeginGetCredentialOption beginGetCredentialOption) {
                Companion companion = BeginGetCredentialUtil.Companion;
                m.e(beginGetCredentialOption, "option");
                return companion.convertToJetpackBeginOption(beginGetCredentialOption);
            }
        }

        static final class b extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final b f15336a = new b();

            b() {
                super(1);
            }

            public final CredentialEntry a(android.service.credentials.CredentialEntry credentialEntry) {
                CredentialEntry.Companion companion = CredentialEntry.Companion;
                Slice a10 = i1.a(credentialEntry);
                m.e(a10, "entry.slice");
                return companion.createFrom$credentials_release(a10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(h1.a(obj));
            }
        }

        static final class c extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final c f15337a = new c();

            c() {
                super(1);
            }

            /* renamed from: a */
            public final Boolean invoke(CredentialEntry credentialEntry) {
                boolean z10;
                if (credentialEntry != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }

        static final class d extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final d f15338a = new d();

            d() {
                super(1);
            }

            /* renamed from: a */
            public final CredentialEntry invoke(CredentialEntry credentialEntry) {
                m.c(credentialEntry);
                return credentialEntry;
            }
        }

        static final class e extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final e f15339a = new e();

            e() {
                super(1);
            }

            public final Action a(android.service.credentials.Action action) {
                Action.Companion companion = Action.Companion;
                Slice a10 = k1.a(action);
                m.e(a10, "entry.slice");
                return companion.fromSlice(a10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(j1.a(obj));
            }
        }

        static final class f extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final f f15340a = new f();

            f() {
                super(1);
            }

            /* renamed from: a */
            public final Boolean invoke(Action action) {
                boolean z10;
                if (action != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }

        static final class g extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final g f15341a = new g();

            g() {
                super(1);
            }

            /* renamed from: a */
            public final Action invoke(Action action) {
                m.c(action);
                return action;
            }
        }

        static final class h extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final h f15342a = new h();

            h() {
                super(1);
            }

            public final AuthenticationAction a(android.service.credentials.Action action) {
                AuthenticationAction.Companion companion = AuthenticationAction.Companion;
                Slice a10 = k1.a(action);
                m.e(a10, "entry.slice");
                return companion.fromSlice(a10);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(j1.a(obj));
            }
        }

        static final class i extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final i f15343a = new i();

            i() {
                super(1);
            }

            /* renamed from: a */
            public final Boolean invoke(AuthenticationAction authenticationAction) {
                boolean z10;
                if (authenticationAction != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }

        static final class j extends n implements Function1 {

            /* renamed from: a  reason: collision with root package name */
            public static final j f15344a = new j();

            j() {
                super(1);
            }

            /* renamed from: a */
            public final AuthenticationAction invoke(AuthenticationAction authenticationAction) {
                m.c(authenticationAction);
                return authenticationAction;
            }
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public static final BeginGetCredentialOption convertToFrameworkRequest$lambda$5(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return r0.a(function1.invoke(obj));
        }

        /* access modifiers changed from: private */
        public final BeginGetCredentialOption convertToJetpackBeginOption(androidx.credentials.provider.BeginGetCredentialOption beginGetCredentialOption) {
            m0.a();
            return j0.a(beginGetCredentialOption.getId(), beginGetCredentialOption.getType(), beginGetCredentialOption.getCandidateQueryData());
        }

        /* access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$10(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* access modifiers changed from: private */
        public static final Action convertToJetpackResponse$lambda$11(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return (Action) function1.invoke(obj);
        }

        /* access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$12(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return (AuthenticationAction) function1.invoke(obj);
        }

        /* access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$13(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$14(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return (AuthenticationAction) function1.invoke(obj);
        }

        /* access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$6(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return (CredentialEntry) function1.invoke(obj);
        }

        /* access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$7(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$8(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return (CredentialEntry) function1.invoke(obj);
        }

        /* access modifiers changed from: private */
        public static final Action convertToJetpackResponse$lambda$9(Function1 function1, Object obj) {
            m.f(function1, "$tmp0");
            return (Action) function1.invoke(obj);
        }

        private final void populateActionEntries(BeginGetCredentialResponse.Builder builder, List<Action> list) {
            for (Action slice : list) {
                h0.a();
                BeginGetCredentialResponse.Builder unused = builder.addAction(g0.a(Action.Companion.toSlice(slice)));
            }
        }

        private final void populateAuthenticationEntries(BeginGetCredentialResponse.Builder builder, List<AuthenticationAction> list) {
            for (AuthenticationAction slice : list) {
                h0.a();
                BeginGetCredentialResponse.Builder unused = builder.addAuthenticationAction(g0.a(AuthenticationAction.Companion.toSlice(slice)));
            }
        }

        private final void populateCredentialEntries(BeginGetCredentialResponse.Builder builder, List<? extends CredentialEntry> list) {
            for (CredentialEntry credentialEntry : list) {
                Slice slice$credentials_release = CredentialEntry.Companion.toSlice$credentials_release(credentialEntry);
                if (slice$credentials_release != null) {
                    l0.a();
                    m0.a();
                    BeginGetCredentialResponse.Builder unused = builder.addCredentialEntry(k0.a(j0.a(credentialEntry.getBeginGetCredentialOption().getId(), credentialEntry.getType(), Bundle.EMPTY), slice$credentials_release));
                }
            }
        }

        @SuppressLint({"MissingPermission"})
        private final void populateRemoteEntry(BeginGetCredentialResponse.Builder builder, RemoteEntry remoteEntry) {
            if (remoteEntry != null) {
                f0.c.a();
                BeginGetCredentialResponse.Builder unused = builder.setRemoteCredentialEntry(f0.b.a(RemoteEntry.Companion.toSlice(remoteEntry)));
            }
        }

        public final BeginGetCredentialRequest convertToFrameworkRequest(androidx.credentials.provider.BeginGetCredentialRequest beginGetCredentialRequest) {
            m.f(beginGetCredentialRequest, "request");
            BeginGetCredentialRequest.Builder a10 = o0.a();
            if (beginGetCredentialRequest.getCallingAppInfo() != null) {
                f0.f.a();
                BeginGetCredentialRequest.Builder unused = a10.setCallingAppInfo(f0.d.a(beginGetCredentialRequest.getCallingAppInfo().getPackageName(), beginGetCredentialRequest.getCallingAppInfo().getSigningInfo(), beginGetCredentialRequest.getCallingAppInfo().getOrigin()));
            }
            BeginGetCredentialRequest a11 = a10.setBeginGetCredentialOptions((List) beginGetCredentialRequest.getBeginGetCredentialOptions().stream().map(new g1(a.f15335a)).collect(Collectors.toList())).build();
            m.e(a11, "builder.setBeginGetCrede…\n                .build()");
            return a11;
        }

        public final BeginGetCredentialResponse convertToFrameworkResponse(androidx.credentials.provider.BeginGetCredentialResponse beginGetCredentialResponse) {
            m.f(beginGetCredentialResponse, "response");
            BeginGetCredentialResponse.Builder a10 = n0.a();
            populateCredentialEntries(a10, beginGetCredentialResponse.getCredentialEntries());
            populateActionEntries(a10, beginGetCredentialResponse.getActions());
            populateAuthenticationEntries(a10, beginGetCredentialResponse.getAuthenticationActions());
            populateRemoteEntry(a10, beginGetCredentialResponse.getRemoteEntry());
            BeginGetCredentialResponse a11 = a10.build();
            m.e(a11, "frameworkBuilder.build()");
            return a11;
        }

        public final androidx.credentials.provider.BeginGetCredentialRequest convertToJetpackRequest$credentials_release(BeginGetCredentialRequest beginGetCredentialRequest) {
            CallingAppInfo callingAppInfo;
            m.f(beginGetCredentialRequest, "request");
            ArrayList arrayList = new ArrayList();
            List<Object> a10 = beginGetCredentialRequest.getBeginGetCredentialOptions();
            m.e(a10, "request.beginGetCredentialOptions");
            for (Object a11 : a10) {
                BeginGetCredentialOption a12 = r0.a(a11);
                BeginGetCredentialOption.Companion companion = androidx.credentials.provider.BeginGetCredentialOption.Companion;
                String a13 = a12.getId();
                m.e(a13, "it.id");
                String a14 = a12.getType();
                m.e(a14, "it.type");
                Bundle a15 = a12.getCandidateQueryData();
                m.e(a15, "it.candidateQueryData");
                arrayList.add(companion.createFrom$credentials_release(a13, a14, a15));
            }
            android.service.credentials.CallingAppInfo a16 = beginGetCredentialRequest.getCallingAppInfo();
            if (a16 != null) {
                String a17 = a16.getPackageName();
                m.e(a17, "it.packageName");
                SigningInfo a18 = a16.getSigningInfo();
                m.e(a18, "it.signingInfo");
                callingAppInfo = new CallingAppInfo(a17, a18, a16.getOrigin());
            } else {
                callingAppInfo = null;
            }
            return new androidx.credentials.provider.BeginGetCredentialRequest(arrayList, callingAppInfo);
        }

        public final androidx.credentials.provider.BeginGetCredentialResponse convertToJetpackResponse(BeginGetCredentialResponse beginGetCredentialResponse) {
            RemoteEntry remoteEntry;
            m.f(beginGetCredentialResponse, "response");
            Object a10 = beginGetCredentialResponse.getCredentialEntries().stream().map(new d1(b.f15336a)).filter(new e1(c.f15337a)).map(new f1(d.f15338a)).collect(Collectors.toList());
            m.e(a10, "response.credentialEntri…lect(Collectors.toList())");
            List list = (List) a10;
            Object a11 = beginGetCredentialResponse.getActions().stream().map(new x0(e.f15339a)).filter(new y0(f.f15340a)).map(new z0(g.f15341a)).collect(Collectors.toList());
            m.e(a11, "response.actions.stream(…lect(Collectors.toList())");
            List list2 = (List) a11;
            Object a12 = beginGetCredentialResponse.getAuthenticationActions().stream().map(new a1(h.f15342a)).filter(new b1(i.f15343a)).map(new c1(j.f15344a)).collect(Collectors.toList());
            m.e(a12, "response.authenticationA…lect(Collectors.toList())");
            List list3 = (List) a12;
            android.service.credentials.RemoteEntry a13 = beginGetCredentialResponse.getRemoteCredentialEntry();
            if (a13 != null) {
                RemoteEntry.Companion companion = RemoteEntry.Companion;
                Slice a14 = a13.getSlice();
                m.e(a14, "it.slice");
                remoteEntry = companion.fromSlice(a14);
            } else {
                remoteEntry = null;
            }
            return new androidx.credentials.provider.BeginGetCredentialResponse(list, list2, list3, remoteEntry);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final androidx.credentials.provider.BeginGetCredentialRequest convertToJetpackRequest$credentials_release(BeginGetCredentialRequest beginGetCredentialRequest) {
        return Companion.convertToJetpackRequest$credentials_release(beginGetCredentialRequest);
    }
}
