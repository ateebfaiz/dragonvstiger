package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

public final /* synthetic */ class c implements ValueEncoder {
    public final void encode(Object obj, Object obj2) {
        ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
    }
}
