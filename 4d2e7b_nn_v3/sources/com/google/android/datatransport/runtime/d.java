package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.k;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import javax.inject.Provider;

final class d extends k {
    private Provider C;
    private Provider X;

    /* renamed from: a  reason: collision with root package name */
    private Provider f6471a;

    /* renamed from: b  reason: collision with root package name */
    private Provider f6472b;

    /* renamed from: c  reason: collision with root package name */
    private Provider f6473c;

    /* renamed from: d  reason: collision with root package name */
    private Provider f6474d;

    /* renamed from: e  reason: collision with root package name */
    private Provider f6475e;

    /* renamed from: f  reason: collision with root package name */
    private Provider f6476f;

    /* renamed from: g  reason: collision with root package name */
    private Provider f6477g;

    /* renamed from: h  reason: collision with root package name */
    private Provider f6478h;

    /* renamed from: i  reason: collision with root package name */
    private Provider f6479i;

    /* renamed from: j  reason: collision with root package name */
    private Provider f6480j;

    /* renamed from: w  reason: collision with root package name */
    private Provider f6481w;

    private static final class b implements k.a {

        /* renamed from: a  reason: collision with root package name */
        private Context f6482a;

        private b() {
        }

        /* renamed from: b */
        public b a(Context context) {
            this.f6482a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        public k build() {
            Preconditions.checkBuilderRequirement(this.f6482a, Context.class);
            return new d(this.f6482a);
        }
    }

    public static k.a h() {
        return new b();
    }

    private void j(Context context) {
        this.f6471a = DoubleCheck.provider(ExecutionModule_ExecutorFactory.create());
        Factory create = InstanceFactory.create(context);
        this.f6472b = create;
        CreationContextFactory_Factory create2 = CreationContextFactory_Factory.create(create, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create());
        this.f6473c = create2;
        this.f6474d = DoubleCheck.provider(MetadataBackendRegistry_Factory.create(this.f6472b, create2));
        this.f6475e = SchemaManager_Factory.create(this.f6472b, EventStoreModule_DbNameFactory.create(), EventStoreModule_SchemaVersionFactory.create());
        this.f6476f = DoubleCheck.provider(EventStoreModule_PackageNameFactory.create(this.f6472b));
        this.f6477g = DoubleCheck.provider(SQLiteEventStore_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), EventStoreModule_StoreConfigFactory.create(), this.f6475e, this.f6476f));
        SchedulingConfigModule_ConfigFactory create3 = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
        this.f6478h = create3;
        SchedulingModule_WorkSchedulerFactory create4 = SchedulingModule_WorkSchedulerFactory.create(this.f6472b, this.f6477g, create3, TimeModule_UptimeClockFactory.create());
        this.f6479i = create4;
        Provider provider = this.f6471a;
        Provider provider2 = this.f6474d;
        Provider provider3 = this.f6477g;
        this.f6480j = DefaultScheduler_Factory.create(provider, provider2, create4, provider3, provider3);
        Provider provider4 = this.f6472b;
        Provider provider5 = this.f6474d;
        Provider provider6 = this.f6477g;
        this.f6481w = Uploader_Factory.create(provider4, provider5, provider6, this.f6479i, this.f6471a, provider6, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.f6477g);
        Provider provider7 = this.f6471a;
        Provider provider8 = this.f6477g;
        this.C = WorkInitializer_Factory.create(provider7, provider8, this.f6479i, provider8);
        this.X = DoubleCheck.provider(TransportRuntime_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.f6480j, this.f6481w, this.C));
    }

    /* access modifiers changed from: package-private */
    public EventStore a() {
        return (EventStore) this.f6477g.get();
    }

    /* access modifiers changed from: package-private */
    public TransportRuntime b() {
        return (TransportRuntime) this.X.get();
    }

    private d(Context context) {
        j(context);
    }
}
