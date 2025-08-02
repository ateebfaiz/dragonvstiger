package io.jsonwebtoken.io;

class Base64UrlEncoder extends Base64Encoder {
    Base64UrlEncoder() {
        super(Base64.URL_SAFE);
    }
}
