package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

class ExceptionPropagatingEncoder<T, R> implements Encoder<T, R> {
    private final Encoder<T, R> encoder;

    ExceptionPropagatingEncoder(Encoder<T, R> encoder2) {
        Assert.notNull(encoder2, "Encoder cannot be null.");
        this.encoder = encoder2;
    }

    public R encode(T t10) throws EncodingException {
        Assert.notNull(t10, "Encode argument cannot be null.");
        try {
            return this.encoder.encode(t10);
        } catch (EncodingException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new EncodingException("Unable to encode input: " + e11.getMessage(), e11);
        }
    }
}
