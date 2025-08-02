package com.google.firebase.messaging;

import androidx.core.app.NotificationCompat;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    private static final class a implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final a f9176a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f9177b = FieldDescriptor.builder("projectNumber").withProperty(AtProtobuf.builder().tag(1).build()).build();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f9178c = FieldDescriptor.builder("messageId").withProperty(AtProtobuf.builder().tag(2).build()).build();

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f9179d = FieldDescriptor.builder("instanceId").withProperty(AtProtobuf.builder().tag(3).build()).build();

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f9180e = FieldDescriptor.builder("messageType").withProperty(AtProtobuf.builder().tag(4).build()).build();

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f9181f = FieldDescriptor.builder("sdkPlatform").withProperty(AtProtobuf.builder().tag(5).build()).build();

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f9182g = FieldDescriptor.builder("packageName").withProperty(AtProtobuf.builder().tag(6).build()).build();

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f9183h = FieldDescriptor.builder("collapseKey").withProperty(AtProtobuf.builder().tag(7).build()).build();

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f9184i = FieldDescriptor.builder("priority").withProperty(AtProtobuf.builder().tag(8).build()).build();

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f9185j = FieldDescriptor.builder("ttl").withProperty(AtProtobuf.builder().tag(9).build()).build();

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f9186k = FieldDescriptor.builder("topic").withProperty(AtProtobuf.builder().tag(10).build()).build();

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f9187l = FieldDescriptor.builder("bulkId").withProperty(AtProtobuf.builder().tag(11).build()).build();

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f9188m = FieldDescriptor.builder(NotificationCompat.CATEGORY_EVENT).withProperty(AtProtobuf.builder().tag(12).build()).build();

        /* renamed from: n  reason: collision with root package name */
        private static final FieldDescriptor f9189n = FieldDescriptor.builder("analyticsLabel").withProperty(AtProtobuf.builder().tag(13).build()).build();

        /* renamed from: o  reason: collision with root package name */
        private static final FieldDescriptor f9190o = FieldDescriptor.builder("campaignId").withProperty(AtProtobuf.builder().tag(14).build()).build();

        /* renamed from: p  reason: collision with root package name */
        private static final FieldDescriptor f9191p = FieldDescriptor.builder("composerLabel").withProperty(AtProtobuf.builder().tag(15).build()).build();

        private a() {
        }

        /* renamed from: a */
        public void encode(MessagingClientEvent messagingClientEvent, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f9177b, messagingClientEvent.getProjectNumber());
            objectEncoderContext.add(f9178c, (Object) messagingClientEvent.getMessageId());
            objectEncoderContext.add(f9179d, (Object) messagingClientEvent.getInstanceId());
            objectEncoderContext.add(f9180e, (Object) messagingClientEvent.getMessageType());
            objectEncoderContext.add(f9181f, (Object) messagingClientEvent.getSdkPlatform());
            objectEncoderContext.add(f9182g, (Object) messagingClientEvent.getPackageName());
            objectEncoderContext.add(f9183h, (Object) messagingClientEvent.getCollapseKey());
            objectEncoderContext.add(f9184i, messagingClientEvent.getPriority());
            objectEncoderContext.add(f9185j, messagingClientEvent.getTtl());
            objectEncoderContext.add(f9186k, (Object) messagingClientEvent.getTopic());
            objectEncoderContext.add(f9187l, messagingClientEvent.getBulkId());
            objectEncoderContext.add(f9188m, (Object) messagingClientEvent.getEvent());
            objectEncoderContext.add(f9189n, (Object) messagingClientEvent.getAnalyticsLabel());
            objectEncoderContext.add(f9190o, messagingClientEvent.getCampaignId());
            objectEncoderContext.add(f9191p, (Object) messagingClientEvent.getComposerLabel());
        }
    }

    private static final class b implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final b f9192a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f9193b = FieldDescriptor.builder("messagingClientEvent").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private b() {
        }

        /* renamed from: a */
        public void encode(MessagingClientEventExtension messagingClientEventExtension, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f9193b, (Object) messagingClientEventExtension.getMessagingClientEventInternal());
        }
    }

    private static final class c implements ObjectEncoder {

        /* renamed from: a  reason: collision with root package name */
        static final c f9194a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f9195b = FieldDescriptor.of("messagingClientEventExtension");

        private c() {
        }

        /* renamed from: a */
        public void encode(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) {
            objectEncoderContext.add(f9195b, (Object) protoEncoderDoNotUse.getMessagingClientEventExtension());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder((Class<U>) ProtoEncoderDoNotUse.class, (ObjectEncoder<? super U>) c.f9194a);
        encoderConfig.registerEncoder((Class<U>) MessagingClientEventExtension.class, (ObjectEncoder<? super U>) b.f9192a);
        encoderConfig.registerEncoder((Class<U>) MessagingClientEvent.class, (ObjectEncoder<? super U>) a.f9176a);
    }
}
