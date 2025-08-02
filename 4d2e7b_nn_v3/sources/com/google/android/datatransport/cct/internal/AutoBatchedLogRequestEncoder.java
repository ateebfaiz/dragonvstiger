package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

public final class AutoBatchedLogRequestEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoBatchedLogRequestEncoder();

    private static final class a implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final a f6304a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6305b = FieldDescriptor.of("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6306c = FieldDescriptor.of("model");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f6307d = FieldDescriptor.of("hardware");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f6308e = FieldDescriptor.of("device");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f6309f = FieldDescriptor.of("product");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f6310g = FieldDescriptor.of("osBuild");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f6311h = FieldDescriptor.of("manufacturer");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f6312i = FieldDescriptor.of("fingerprint");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f6313j = FieldDescriptor.of("locale");

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f6314k = FieldDescriptor.of("country");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f6315l = FieldDescriptor.of("mccMnc");

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f6316m = FieldDescriptor.of("applicationBuild");

        private a() {
        }

        /* renamed from: a */
        public void encode(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6305b, (Object) androidClientInfo.getSdkVersion());
            objectEncoderContext.add(f6306c, (Object) androidClientInfo.getModel());
            objectEncoderContext.add(f6307d, (Object) androidClientInfo.getHardware());
            objectEncoderContext.add(f6308e, (Object) androidClientInfo.getDevice());
            objectEncoderContext.add(f6309f, (Object) androidClientInfo.getProduct());
            objectEncoderContext.add(f6310g, (Object) androidClientInfo.getOsBuild());
            objectEncoderContext.add(f6311h, (Object) androidClientInfo.getManufacturer());
            objectEncoderContext.add(f6312i, (Object) androidClientInfo.getFingerprint());
            objectEncoderContext.add(f6313j, (Object) androidClientInfo.getLocale());
            objectEncoderContext.add(f6314k, (Object) androidClientInfo.getCountry());
            objectEncoderContext.add(f6315l, (Object) androidClientInfo.getMccMnc());
            objectEncoderContext.add(f6316m, (Object) androidClientInfo.getApplicationBuild());
        }
    }

    private static final class b implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final b f6317a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6318b = FieldDescriptor.of("logRequest");

        private b() {
        }

        /* renamed from: a */
        public void encode(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6318b, (Object) batchedLogRequest.getLogRequests());
        }
    }

    private static final class c implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final c f6319a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6320b = FieldDescriptor.of("clientType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6321c = FieldDescriptor.of("androidClientInfo");

        private c() {
        }

        /* renamed from: a */
        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6320b, (Object) clientInfo.getClientType());
            objectEncoderContext.add(f6321c, (Object) clientInfo.getAndroidClientInfo());
        }
    }

    private static final class d implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final d f6322a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6323b = FieldDescriptor.of("eventTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6324c = FieldDescriptor.of("eventCode");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f6325d = FieldDescriptor.of("eventUptimeMs");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f6326e = FieldDescriptor.of("sourceExtension");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f6327f = FieldDescriptor.of("sourceExtensionJsonProto3");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f6328g = FieldDescriptor.of("timezoneOffsetSeconds");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f6329h = FieldDescriptor.of("networkConnectionInfo");

        private d() {
        }

        /* renamed from: a */
        public void encode(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6323b, logEvent.getEventTimeMs());
            objectEncoderContext.add(f6324c, (Object) logEvent.getEventCode());
            objectEncoderContext.add(f6325d, logEvent.getEventUptimeMs());
            objectEncoderContext.add(f6326e, (Object) logEvent.getSourceExtension());
            objectEncoderContext.add(f6327f, (Object) logEvent.getSourceExtensionJsonProto3());
            objectEncoderContext.add(f6328g, logEvent.getTimezoneOffsetSeconds());
            objectEncoderContext.add(f6329h, (Object) logEvent.getNetworkConnectionInfo());
        }
    }

    private static final class e implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final e f6330a = new e();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6331b = FieldDescriptor.of("requestTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6332c = FieldDescriptor.of("requestUptimeMs");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f6333d = FieldDescriptor.of("clientInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f6334e = FieldDescriptor.of("logSource");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f6335f = FieldDescriptor.of("logSourceName");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f6336g = FieldDescriptor.of("logEvent");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f6337h = FieldDescriptor.of("qosTier");

        private e() {
        }

        /* renamed from: a */
        public void encode(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6331b, logRequest.getRequestTimeMs());
            objectEncoderContext.add(f6332c, logRequest.getRequestUptimeMs());
            objectEncoderContext.add(f6333d, (Object) logRequest.getClientInfo());
            objectEncoderContext.add(f6334e, (Object) logRequest.getLogSource());
            objectEncoderContext.add(f6335f, (Object) logRequest.getLogSourceName());
            objectEncoderContext.add(f6336g, (Object) logRequest.getLogEvents());
            objectEncoderContext.add(f6337h, (Object) logRequest.getQosTier());
        }
    }

    private static final class f implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final f f6338a = new f();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f6339b = FieldDescriptor.of("networkType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f6340c = FieldDescriptor.of("mobileSubtype");

        private f() {
        }

        /* renamed from: a */
        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f6339b, (Object) networkConnectionInfo.getNetworkType());
            objectEncoderContext.add(f6340c, (Object) networkConnectionInfo.getMobileSubtype());
        }
    }

    private AutoBatchedLogRequestEncoder() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        b bVar = b.f6317a;
        encoderConfig.registerEncoder((Class<U>) BatchedLogRequest.class, (ObjectEncoder<? super U>) bVar);
        encoderConfig.registerEncoder((Class<U>) b.class, (ObjectEncoder<? super U>) bVar);
        e eVar = e.f6330a;
        encoderConfig.registerEncoder((Class<U>) LogRequest.class, (ObjectEncoder<? super U>) eVar);
        encoderConfig.registerEncoder((Class<U>) e.class, (ObjectEncoder<? super U>) eVar);
        c cVar = c.f6319a;
        encoderConfig.registerEncoder((Class<U>) ClientInfo.class, (ObjectEncoder<? super U>) cVar);
        encoderConfig.registerEncoder((Class<U>) c.class, (ObjectEncoder<? super U>) cVar);
        a aVar = a.f6304a;
        encoderConfig.registerEncoder((Class<U>) AndroidClientInfo.class, (ObjectEncoder<? super U>) aVar);
        encoderConfig.registerEncoder((Class<U>) a.class, (ObjectEncoder<? super U>) aVar);
        d dVar = d.f6322a;
        encoderConfig.registerEncoder((Class<U>) LogEvent.class, (ObjectEncoder<? super U>) dVar);
        encoderConfig.registerEncoder((Class<U>) d.class, (ObjectEncoder<? super U>) dVar);
        f fVar = f.f6338a;
        encoderConfig.registerEncoder((Class<U>) NetworkConnectionInfo.class, (ObjectEncoder<? super U>) fVar);
        encoderConfig.registerEncoder((Class<U>) g.class, (ObjectEncoder<? super U>) fVar);
    }
}
