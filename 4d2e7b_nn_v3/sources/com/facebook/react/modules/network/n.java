package com.facebook.react.modules.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import androidx.core.location.LocationRequestCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.zip.GZIPOutputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

abstract class n {

    class a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MediaType f3340a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InputStream f3341b;

        a(MediaType mediaType, InputStream inputStream) {
            this.f3340a = mediaType;
            this.f3341b = inputStream;
        }

        public long contentLength() {
            try {
                return (long) this.f3341b.available();
            } catch (IOException unused) {
                return 0;
            }
        }

        public MediaType contentType() {
            return this.f3340a;
        }

        public void writeTo(BufferedSink bufferedSink) {
            Source source = null;
            try {
                source = Okio.source(this.f3341b);
                bufferedSink.writeAll(source);
            } finally {
                n.b(source);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(Source source) {
        try {
            source.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static RequestBody c(MediaType mediaType, InputStream inputStream) {
        return new a(mediaType, inputStream);
    }

    public static RequestBody d(MediaType mediaType, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            return RequestBody.create(mediaType, byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return null;
        }
    }

    public static j e(RequestBody requestBody, i iVar) {
        return new j(requestBody, iVar);
    }

    private static InputStream f(Context context, Uri uri) {
        InputStream openStream;
        ReadableByteChannel newChannel;
        File createTempFile = File.createTempFile("RequestBodyUtil", "temp", context.getApplicationContext().getCacheDir());
        createTempFile.deleteOnExit();
        URL url = new URL(uri.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        try {
            openStream = url.openStream();
            newChannel = Channels.newChannel(openStream);
            fileOutputStream.getChannel().transferFrom(newChannel, 0, LocationRequestCompat.PASSIVE_INTERVAL);
            FileInputStream fileInputStream = new FileInputStream(createTempFile);
            if (newChannel != null) {
                newChannel.close();
            }
            if (openStream != null) {
                openStream.close();
            }
            fileOutputStream.close();
            return fileInputStream;
            throw th;
            throw th;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static RequestBody g(String str) {
        if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH")) {
            return RequestBody.create((MediaType) null, ByteString.EMPTY);
        }
        return null;
    }

    public static InputStream h(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            if (parse.getScheme().startsWith("http")) {
                return f(context, parse);
            }
            if (!str.startsWith("data:")) {
                return context.getContentResolver().openInputStream(parse);
            }
            byte[] decode = Base64.decode(str.split(",")[1], 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeByteArray.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (Exception e10) {
            z2.a.k("ReactNative", "Could not retrieve file for contentUri " + str, e10);
            return null;
        }
    }

    public static boolean i(String str) {
        return "gzip".equalsIgnoreCase(str);
    }
}
