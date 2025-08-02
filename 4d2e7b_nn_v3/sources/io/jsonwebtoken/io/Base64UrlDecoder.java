package io.jsonwebtoken.io;

class Base64UrlDecoder extends Base64Decoder {
    Base64UrlDecoder() {
        super(Base64.URL_SAFE);
    }
}
