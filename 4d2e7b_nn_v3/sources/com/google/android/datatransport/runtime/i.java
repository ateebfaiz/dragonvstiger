package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

final class i implements Transport {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f6490a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6491b;

    /* renamed from: c  reason: collision with root package name */
    private final Encoding f6492c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer f6493d;

    /* renamed from: e  reason: collision with root package name */
    private final j f6494e;

    i(TransportContext transportContext, String str, Encoding encoding, Transformer transformer, j jVar) {
        this.f6490a = transportContext;
        this.f6491b = str;
        this.f6492c = encoding;
        this.f6493d = transformer;
        this.f6494e = jVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(Exception exc) {
    }

    /* access modifiers changed from: package-private */
    public TransportContext b() {
        return this.f6490a;
    }

    public void schedule(Event event, TransportScheduleCallback transportScheduleCallback) {
        this.f6494e.send(SendRequest.a().setTransportContext(this.f6490a).setEvent(event).setTransportName(this.f6491b).setTransformer(this.f6493d).setEncoding(this.f6492c).build(), transportScheduleCallback);
    }

    public void send(Event event) {
        schedule(event, new h());
    }
}
