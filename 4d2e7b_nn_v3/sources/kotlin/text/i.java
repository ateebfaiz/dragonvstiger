package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;

public abstract class i {
    /* access modifiers changed from: private */
    public static final MatchResult c(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new g(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final IntRange d(MatchResult matchResult, int i10) {
        return l.l(matchResult.start(i10), matchResult.end(i10));
    }
}
