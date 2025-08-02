package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

class ExceptionPropagatingDecoder<T, R> implements Decoder<T, R> {
    private final Decoder<T, R> decoder;

    ExceptionPropagatingDecoder(Decoder<T, R> decoder2) {
        Assert.notNull(decoder2, "Decoder cannot be null.");
        this.decoder = decoder2;
    }

    public R decode(T t10) throws DecodingException {
        Assert.notNull(t10, "Decode argument cannot be null.");
        try {
            return this.decoder.decode(t10);
        } catch (DecodingException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new DecodingException("Unable to decode input: " + e11.getMessage(), e11);
        }
    }
}
