package l9;

import android.text.TextUtils;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.work.WorkRequest;
import com.linecorp.linesdk.LineIdToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SigningKeyResolver;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final long f12739a = TimeUnit.DAYS.toSeconds(WorkRequest.MIN_BACKOFF_MILLIS);

    private static LineIdToken.Address a(Claims claims) {
        Map map = (Map) claims.get("address", Map.class);
        if (map == null) {
            return null;
        }
        return new LineIdToken.Address.b().k((String) map.get("street_address")).h((String) map.get("locality")).j((String) map.get("region")).i((String) map.get("postal_code")).g((String) map.get("country")).f();
    }

    private static LineIdToken b(String str, Claims claims) {
        Class cls = String.class;
        return new LineIdToken.b().P(str).J(claims.getIssuer()).Q(claims.getSubject()).x(claims.getAudience()).C(claims.getExpiration()).I(claims.getIssuedAt()).y((Date) claims.get("auth_time", Date.class)).M((String) claims.get("nonce", cls)).w((List) claims.get("amr", List.class)).L((String) claims.get("name", cls)).O((String) claims.get("picture", cls)).N((String) claims.get("phone_number", cls)).B((String) claims.get("email", cls)).F((String) claims.get(HintConstants.AUTOFILL_HINT_GENDER, cls)).z((String) claims.get("birthdate", cls)).v(a(claims)).G((String) claims.get("given_name", cls)).H((String) claims.get("given_name_pronunciation", cls)).K((String) claims.get("middle_name", cls)).D((String) claims.get("family_name", cls)).E((String) claims.get("family_name_pronunciation", cls)).A();
    }

    public static LineIdToken c(String str, SigningKeyResolver signingKeyResolver) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(str, Jwts.parser().setAllowedClockSkewSeconds(f12739a).setSigningKeyResolver(signingKeyResolver).parseClaimsJws(str).getBody());
        } catch (Exception e10) {
            Log.e("IdTokenParser", "failed to parse IdToken: " + str, e10);
            throw e10;
        }
    }
}
