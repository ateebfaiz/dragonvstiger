package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

public class Utf8Old extends Utf8 {
    private static final ThreadLocal<a> CACHE = ThreadLocal.withInitial(new d());

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final CharsetEncoder f15446a;

        /* renamed from: b  reason: collision with root package name */
        final CharsetDecoder f15447b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f15448c = null;

        /* renamed from: d  reason: collision with root package name */
        ByteBuffer f15449d = null;

        a() {
            Charset charset = StandardCharsets.UTF_8;
            this.f15446a = charset.newEncoder();
            this.f15447b = charset.newDecoder();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ a lambda$static$0() {
        return new a();
    }

    public String decodeUtf8(ByteBuffer byteBuffer, int i10, int i11) {
        CharsetDecoder charsetDecoder = CACHE.get().f15447b;
        charsetDecoder.reset();
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i10);
        duplicate.limit(i10 + i11);
        try {
            return charsetDecoder.decode(duplicate).toString();
        } catch (CharacterCodingException e10) {
            throw new IllegalArgumentException("Bad encoding", e10);
        }
    }

    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        a aVar = CACHE.get();
        if (aVar.f15448c != charSequence) {
            encodedLength(charSequence);
        }
        byteBuffer.put(aVar.f15449d);
    }

    public int encodedLength(CharSequence charSequence) {
        CharBuffer charBuffer;
        a aVar = CACHE.get();
        int length = (int) (((float) charSequence.length()) * aVar.f15446a.maxBytesPerChar());
        ByteBuffer byteBuffer = aVar.f15449d;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            aVar.f15449d = ByteBuffer.allocate(Math.max(128, length));
        }
        aVar.f15449d.clear();
        aVar.f15448c = charSequence;
        if (charSequence instanceof CharBuffer) {
            charBuffer = (CharBuffer) charSequence;
        } else {
            charBuffer = CharBuffer.wrap(charSequence);
        }
        CoderResult encode = aVar.f15446a.encode(charBuffer, aVar.f15449d, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e10) {
                throw new IllegalArgumentException("bad character encoding", e10);
            }
        }
        aVar.f15449d.flip();
        return aVar.f15449d.remaining();
    }
}
