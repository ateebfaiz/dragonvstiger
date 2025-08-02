package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext add(double d10) throws IOException;

    @NonNull
    ValueEncoderContext add(float f10) throws IOException;

    @NonNull
    ValueEncoderContext add(int i10) throws IOException;

    @NonNull
    ValueEncoderContext add(long j10) throws IOException;

    @NonNull
    ValueEncoderContext add(@Nullable String str) throws IOException;

    @NonNull
    ValueEncoderContext add(boolean z10) throws IOException;

    @NonNull
    ValueEncoderContext add(@NonNull byte[] bArr) throws IOException;
}
