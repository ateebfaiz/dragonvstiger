package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;

public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    private static final class a implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final a f6403a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6404b = FieldDescriptor.builder("window").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6405c = FieldDescriptor.builder("logSourceMetrics").withProperty(AtProtobuf.builder().tag(2).build()).build();

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f6406d = FieldDescriptor.builder("globalMetrics").withProperty(AtProtobuf.builder().tag(3).build()).build();

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f6407e = FieldDescriptor.builder("appNamespace").withProperty(AtProtobuf.builder().tag(4).build()).build();

        private a() {
        }

        /* renamed from: a */
        public void encode(ClientMetrics clientMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6404b, (Object) clientMetrics.getWindowInternal());
            objectEncoderContext.add(f6405c, (Object) clientMetrics.getLogSourceMetricsList());
            objectEncoderContext.add(f6406d, (Object) clientMetrics.getGlobalMetricsInternal());
            objectEncoderContext.add(f6407e, (Object) clientMetrics.getAppNamespace());
        }
    }

    private static final class b implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final b f6408a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6409b = FieldDescriptor.builder("storageMetrics").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private b() {
        }

        /* renamed from: a */
        public void encode(GlobalMetrics globalMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6409b, (Object) globalMetrics.getStorageMetricsInternal());
        }
    }

    private static final class c implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final c f6410a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6411b = FieldDescriptor.builder("eventsDroppedCount").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6412c = FieldDescriptor.builder("reason").withProperty(AtProtobuf.builder().tag(3).build()).build();

        private c() {
        }

        /* renamed from: a */
        public void encode(LogEventDropped logEventDropped, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6411b, logEventDropped.getEventsDroppedCount());
            objectEncoderContext.add(f6412c, (Object) logEventDropped.getReason());
        }
    }

    private static final class d implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final d f6413a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6414b = FieldDescriptor.builder("logSource").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6415c = FieldDescriptor.builder("logEventDropped").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private d() {
        }

        /* renamed from: a */
        public void encode(LogSourceMetrics logSourceMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6414b, (Object) logSourceMetrics.getLogSource());
            objectEncoderContext.add(f6415c, (Object) logSourceMetrics.getLogEventDroppedList());
        }
    }

    private static final class e implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final e f6416a = new e();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6417b = FieldDescriptor.of("clientMetrics");

        private e() {
        }

        /* renamed from: a */
        public void encode(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6417b, (Object) protoEncoderDoNotUse.getClientMetrics());
        }
    }

    private static final class f implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final f f6418a = new f();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6419b = FieldDescriptor.builder("currentCacheSizeBytes").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6420c = FieldDescriptor.builder("maxCacheSizeBytes").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private f() {
        }

        /* renamed from: a */
        public void encode(StorageMetrics storageMetrics, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6419b, storageMetrics.getCurrentCacheSizeBytes());
            objectEncoderContext.add(f6420c, storageMetrics.getMaxCacheSizeBytes());
        }
    }

    private static final class g implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final g f6421a = new g();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6422b = FieldDescriptor.builder("startMs").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6423c = FieldDescriptor.builder("endMs").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private g() {
        }

        /* renamed from: a */
        public void encode(TimeWindow timeWindow, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6422b, timeWindow.getStartMs());
            objectEncoderContext.add(f6423c, timeWindow.getEndMs());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder((Class<U>) ProtoEncoderDoNotUse.class, (ObjectEncoder<? super U>) e.f6416a);
        encoderConfig.registerEncoder((Class<U>) ClientMetrics.class, (ObjectEncoder<? super U>) a.f6403a);
        encoderConfig.registerEncoder((Class<U>) TimeWindow.class, (ObjectEncoder<? super U>) g.f6421a);
        encoderConfig.registerEncoder((Class<U>) LogSourceMetrics.class, (ObjectEncoder<? super U>) d.f6413a);
        encoderConfig.registerEncoder((Class<U>) LogEventDropped.class, (ObjectEncoder<? super U>) c.f6410a);
        encoderConfig.registerEncoder((Class<U>) GlobalMetrics.class, (ObjectEncoder<? super U>) b.f6408a);
        encoderConfig.registerEncoder((Class<U>) StorageMetrics.class, (ObjectEncoder<? super U>) f.f6418a);
    }
}
