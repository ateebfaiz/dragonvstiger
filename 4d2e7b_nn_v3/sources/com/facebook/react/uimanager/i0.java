package com.facebook.react.uimanager;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.m;
import com.facebook.react.p;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class i0 extends ExploreByTouchHelper {

    /* renamed from: f  reason: collision with root package name */
    private static int f3699f = 1056964608;

    /* renamed from: g  reason: collision with root package name */
    private static final int f3700g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final HashMap f3701h;

    /* renamed from: a  reason: collision with root package name */
    private final View f3702a;

    /* renamed from: b  reason: collision with root package name */
    private final d f3703b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f3704c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap f3705d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    View f3706e;

    class a extends Handler {
        a() {
        }

        public void handleMessage(Message message) {
            ((View) message.obj).sendAccessibilityEvent(4);
        }
    }

    class b extends com.facebook.react.uimanager.events.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WritableMap f3708a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i10, int i11, WritableMap writableMap) {
            super(i10, i11);
            this.f3708a = writableMap;
        }

        /* access modifiers changed from: protected */
        public WritableMap getEventData() {
            return this.f3708a;
        }

        public String getEventName() {
            return "topAccessibilityAction";
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3710a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3711b;

        /* JADX WARNING: Can't wrap try/catch for region: R(130:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|(2:41|42)|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|(2:81|82)|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|(3:173|174|176)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(131:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|(2:81|82)|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|(3:173|174|176)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(132:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|(3:173|174|176)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(133:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|(2:77|78)|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|(3:173|174|176)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(134:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|(3:173|174|176)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(135:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|(3:173|174|176)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(137:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|(2:73|74)|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(138:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(139:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|(2:69|70)|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(140:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(141:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|(2:65|66)|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(142:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(143:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|(2:61|62)|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(144:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(145:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|(2:57|58)|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(147:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(148:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(150:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(151:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(152:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(153:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Can't wrap try/catch for region: R(154:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|69|70|71|73|74|75|77|78|79|81|82|83|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126|127|128|129|130|131|132|133|134|135|136|137|138|139|140|141|142|143|144|145|146|147|148|149|150|151|152|153|154|155|156|157|158|159|160|161|162|163|164|165|166|167|168|169|170|171|172|173|174|176) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x0153 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:103:0x015d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:105:0x0167 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x0171 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x017b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x0185 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:113:0x018f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x0199 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:117:0x01a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:119:0x01ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x01b7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:123:0x01c1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:125:0x01cb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x01d5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:129:0x01e1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x01eb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:133:0x01f5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:135:0x01ff */
        /* JADX WARNING: Missing exception handler attribute for start block: B:137:0x0209 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x0213 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x021d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:143:0x0229 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:145:0x0235 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:147:0x0241 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:149:0x024d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:151:0x0259 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:153:0x0265 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:155:0x0271 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:157:0x027d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:159:0x0289 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:161:0x0295 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:163:0x02a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:165:0x02ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:167:0x02b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:169:0x02c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:171:0x02d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:173:0x02dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x0149 */
        static {
            /*
                com.facebook.react.uimanager.i0$f[] r0 = com.facebook.react.uimanager.i0.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3711b = r0
                r1 = 1
                com.facebook.react.uimanager.i0$f r2 = com.facebook.react.uimanager.i0.f.ALERT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f3711b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.uimanager.i0$f r3 = com.facebook.react.uimanager.i0.f.BUTTON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f3711b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.uimanager.i0$f r4 = com.facebook.react.uimanager.i0.f.CHECKBOX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f3711b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.uimanager.i0$f r5 = com.facebook.react.uimanager.i0.f.COMBOBOX     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f3711b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.uimanager.i0$f r6 = com.facebook.react.uimanager.i0.f.GRID     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f3711b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.uimanager.i0$f r7 = com.facebook.react.uimanager.i0.f.HEADING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f3711b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.facebook.react.uimanager.i0$f r8 = com.facebook.react.uimanager.i0.f.IMG     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                r7 = 8
                int[] r8 = f3711b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.facebook.react.uimanager.i0$f r9 = com.facebook.react.uimanager.i0.f.LINK     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r8[r9] = r7     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r8 = 9
                int[] r9 = f3711b     // Catch:{ NoSuchFieldError -> 0x006c }
                com.facebook.react.uimanager.i0$f r10 = com.facebook.react.uimanager.i0.f.LIST     // Catch:{ NoSuchFieldError -> 0x006c }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r9[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                r9 = 10
                int[] r10 = f3711b     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.facebook.react.uimanager.i0$f r11 = com.facebook.react.uimanager.i0.f.MENU     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r11 = r11.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r10[r11] = r9     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                r10 = 11
                int[] r11 = f3711b     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.facebook.react.uimanager.i0$f r12 = com.facebook.react.uimanager.i0.f.MENUBAR     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r12 = r12.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r11[r12] = r10     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                r11 = 12
                int[] r12 = f3711b     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.facebook.react.uimanager.i0$f r13 = com.facebook.react.uimanager.i0.f.MENUITEM     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r13 = r13.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r12[r13] = r11     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                r12 = 13
                int[] r13 = f3711b     // Catch:{ NoSuchFieldError -> 0x009c }
                com.facebook.react.uimanager.i0$f r14 = com.facebook.react.uimanager.i0.f.NONE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r14 = r14.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r13[r14] = r12     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                r13 = 14
                int[] r14 = f3711b     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.facebook.react.uimanager.i0$f r15 = com.facebook.react.uimanager.i0.f.PROGRESSBAR     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r15 = r15.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r14[r15] = r13     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                r14 = 15
                int[] r15 = f3711b     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.facebook.react.uimanager.i0$f r16 = com.facebook.react.uimanager.i0.f.RADIO     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r16 = r16.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r15[r16] = r14     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                r15 = 16
                int[] r16 = f3711b     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.facebook.react.uimanager.i0$f r17 = com.facebook.react.uimanager.i0.f.RADIOGROUP     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r17 = r17.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r16[r17] = r15     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                r16 = 17
                int[] r17 = f3711b     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.facebook.react.uimanager.i0$f r18 = com.facebook.react.uimanager.i0.f.SCROLLBAR     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r18 = r18.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r17[r18] = r16     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                r17 = 18
                int[] r18 = f3711b     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.facebook.react.uimanager.i0$f r19 = com.facebook.react.uimanager.i0.f.SEARCHBOX     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r19 = r19.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r18[r19] = r17     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                r18 = 19
                int[] r19 = f3711b     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.facebook.react.uimanager.i0$f r20 = com.facebook.react.uimanager.i0.f.SLIDER     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r20 = r20.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r19[r20] = r18     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                r19 = 20
                int[] r20 = f3711b     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.facebook.react.uimanager.i0$f r21 = com.facebook.react.uimanager.i0.f.SPINBUTTON     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r21 = r21.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r20[r21] = r19     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                r20 = 21
                int[] r21 = f3711b     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.facebook.react.uimanager.i0$f r22 = com.facebook.react.uimanager.i0.f.SUMMARY     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r22 = r22.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r21[r22] = r20     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                r21 = 22
                int[] r22 = f3711b     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.facebook.react.uimanager.i0$f r23 = com.facebook.react.uimanager.i0.f.SWITCH     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r22[r23] = r21     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r22 = f3711b     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.facebook.react.uimanager.i0$f r23 = com.facebook.react.uimanager.i0.f.TAB     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r24 = 23
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r22 = f3711b     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.facebook.react.uimanager.i0$f r23 = com.facebook.react.uimanager.i0.f.TABLIST     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r24 = 24
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r22 = f3711b     // Catch:{ NoSuchFieldError -> 0x012c }
                com.facebook.react.uimanager.i0$f r23 = com.facebook.react.uimanager.i0.f.TIMER     // Catch:{ NoSuchFieldError -> 0x012c }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r24 = 25
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r22 = f3711b     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.facebook.react.uimanager.i0$f r23 = com.facebook.react.uimanager.i0.f.TOOLBAR     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r24 = 26
                r22[r23] = r24     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                com.facebook.react.uimanager.i0$e[] r15 = com.facebook.react.uimanager.i0.e.values()
                int r15 = r15.length
                int[] r15 = new int[r15]
                f3710a = r15
                com.facebook.react.uimanager.i0$e r23 = com.facebook.react.uimanager.i0.e.BUTTON     // Catch:{ NoSuchFieldError -> 0x0149 }
                int r23 = r23.ordinal()     // Catch:{ NoSuchFieldError -> 0x0149 }
                r15[r23] = r1     // Catch:{ NoSuchFieldError -> 0x0149 }
            L_0x0149:
                int[] r1 = f3710a     // Catch:{ NoSuchFieldError -> 0x0153 }
                com.facebook.react.uimanager.i0$e r15 = com.facebook.react.uimanager.i0.e.DROPDOWNLIST     // Catch:{ NoSuchFieldError -> 0x0153 }
                int r15 = r15.ordinal()     // Catch:{ NoSuchFieldError -> 0x0153 }
                r1[r15] = r0     // Catch:{ NoSuchFieldError -> 0x0153 }
            L_0x0153:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x015d }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.TOGGLEBUTTON     // Catch:{ NoSuchFieldError -> 0x015d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015d }
            L_0x015d:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0167 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.SEARCH     // Catch:{ NoSuchFieldError -> 0x0167 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0167 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0167 }
            L_0x0167:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0171 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.IMAGE     // Catch:{ NoSuchFieldError -> 0x0171 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0171 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0171 }
            L_0x0171:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x017b }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.IMAGEBUTTON     // Catch:{ NoSuchFieldError -> 0x017b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x017b }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x017b }
            L_0x017b:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0185 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.KEYBOARDKEY     // Catch:{ NoSuchFieldError -> 0x0185 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0185 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x0185 }
            L_0x0185:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x018f }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.TEXT     // Catch:{ NoSuchFieldError -> 0x018f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018f }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x018f }
            L_0x018f:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0199 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.ADJUSTABLE     // Catch:{ NoSuchFieldError -> 0x0199 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0199 }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x0199 }
            L_0x0199:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01a3 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.CHECKBOX     // Catch:{ NoSuchFieldError -> 0x01a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a3 }
                r0[r1] = r9     // Catch:{ NoSuchFieldError -> 0x01a3 }
            L_0x01a3:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01ad }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.RADIO     // Catch:{ NoSuchFieldError -> 0x01ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ad }
                r0[r1] = r10     // Catch:{ NoSuchFieldError -> 0x01ad }
            L_0x01ad:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01b7 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.SPINBUTTON     // Catch:{ NoSuchFieldError -> 0x01b7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b7 }
                r0[r1] = r11     // Catch:{ NoSuchFieldError -> 0x01b7 }
            L_0x01b7:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01c1 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.SWITCH     // Catch:{ NoSuchFieldError -> 0x01c1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01c1 }
                r0[r1] = r12     // Catch:{ NoSuchFieldError -> 0x01c1 }
            L_0x01c1:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01cb }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.LIST     // Catch:{ NoSuchFieldError -> 0x01cb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01cb }
                r0[r1] = r13     // Catch:{ NoSuchFieldError -> 0x01cb }
            L_0x01cb:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01d5 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.GRID     // Catch:{ NoSuchFieldError -> 0x01d5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d5 }
                r0[r1] = r14     // Catch:{ NoSuchFieldError -> 0x01d5 }
            L_0x01d5:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01e1 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.SCROLLVIEW     // Catch:{ NoSuchFieldError -> 0x01e1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01e1 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01e1 }
            L_0x01e1:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01eb }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.HORIZONTALSCROLLVIEW     // Catch:{ NoSuchFieldError -> 0x01eb }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01eb }
                r0[r1] = r16     // Catch:{ NoSuchFieldError -> 0x01eb }
            L_0x01eb:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01f5 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.PAGER     // Catch:{ NoSuchFieldError -> 0x01f5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01f5 }
                r0[r1] = r17     // Catch:{ NoSuchFieldError -> 0x01f5 }
            L_0x01f5:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x01ff }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.DRAWERLAYOUT     // Catch:{ NoSuchFieldError -> 0x01ff }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ff }
                r0[r1] = r18     // Catch:{ NoSuchFieldError -> 0x01ff }
            L_0x01ff:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0209 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.SLIDINGDRAWER     // Catch:{ NoSuchFieldError -> 0x0209 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0209 }
                r0[r1] = r19     // Catch:{ NoSuchFieldError -> 0x0209 }
            L_0x0209:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0213 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.ICONMENU     // Catch:{ NoSuchFieldError -> 0x0213 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0213 }
                r0[r1] = r20     // Catch:{ NoSuchFieldError -> 0x0213 }
            L_0x0213:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x021d }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.VIEWGROUP     // Catch:{ NoSuchFieldError -> 0x021d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x021d }
                r0[r1] = r21     // Catch:{ NoSuchFieldError -> 0x021d }
            L_0x021d:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0229 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.WEBVIEW     // Catch:{ NoSuchFieldError -> 0x0229 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0229 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0229 }
            L_0x0229:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0235 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.NONE     // Catch:{ NoSuchFieldError -> 0x0235 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0235 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0235 }
            L_0x0235:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0241 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.LINK     // Catch:{ NoSuchFieldError -> 0x0241 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0241 }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0241 }
            L_0x0241:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x024d }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.SUMMARY     // Catch:{ NoSuchFieldError -> 0x024d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x024d }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x024d }
            L_0x024d:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0259 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.HEADER     // Catch:{ NoSuchFieldError -> 0x0259 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0259 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0259 }
            L_0x0259:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0265 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.ALERT     // Catch:{ NoSuchFieldError -> 0x0265 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0265 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0265 }
            L_0x0265:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0271 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.COMBOBOX     // Catch:{ NoSuchFieldError -> 0x0271 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0271 }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0271 }
            L_0x0271:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x027d }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.MENU     // Catch:{ NoSuchFieldError -> 0x027d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x027d }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x027d }
            L_0x027d:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0289 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.MENUBAR     // Catch:{ NoSuchFieldError -> 0x0289 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0289 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0289 }
            L_0x0289:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x0295 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.MENUITEM     // Catch:{ NoSuchFieldError -> 0x0295 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0295 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0295 }
            L_0x0295:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x02a1 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.PROGRESSBAR     // Catch:{ NoSuchFieldError -> 0x02a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02a1 }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02a1 }
            L_0x02a1:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x02ad }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.RADIOGROUP     // Catch:{ NoSuchFieldError -> 0x02ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02ad }
                r2 = 34
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02ad }
            L_0x02ad:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x02b9 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.SCROLLBAR     // Catch:{ NoSuchFieldError -> 0x02b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02b9 }
                r2 = 35
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02b9 }
            L_0x02b9:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x02c5 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.TAB     // Catch:{ NoSuchFieldError -> 0x02c5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02c5 }
                r2 = 36
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02c5 }
            L_0x02c5:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x02d1 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.TABLIST     // Catch:{ NoSuchFieldError -> 0x02d1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02d1 }
                r2 = 37
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02d1 }
            L_0x02d1:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x02dd }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.TIMER     // Catch:{ NoSuchFieldError -> 0x02dd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02dd }
                r2 = 38
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02dd }
            L_0x02dd:
                int[] r0 = f3710a     // Catch:{ NoSuchFieldError -> 0x02e9 }
                com.facebook.react.uimanager.i0$e r1 = com.facebook.react.uimanager.i0.e.TOOLBAR     // Catch:{ NoSuchFieldError -> 0x02e9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x02e9 }
                r2 = 39
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x02e9 }
            L_0x02e9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.i0.c.<clinit>():void");
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final List f3712a;

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            public String f3713a;

            /* renamed from: b  reason: collision with root package name */
            public int f3714b;

            /* renamed from: c  reason: collision with root package name */
            public int f3715c;

            /* renamed from: d  reason: collision with root package name */
            public int f3716d;

            private a() {
            }
        }

        public d(ClickableSpan[] clickableSpanArr, Spannable spannable) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < clickableSpanArr.length; i10++) {
                ClickableSpan clickableSpan = clickableSpanArr[i10];
                int spanStart = spannable.getSpanStart(clickableSpan);
                int spanEnd = spannable.getSpanEnd(clickableSpan);
                if (spanStart != spanEnd && spanStart >= 0 && spanEnd >= 0 && spanStart <= spannable.length() && spanEnd <= spannable.length()) {
                    a aVar = new a();
                    aVar.f3713a = spannable.subSequence(spanStart, spanEnd).toString();
                    aVar.f3714b = spanStart;
                    aVar.f3715c = spanEnd;
                    aVar.f3716d = (clickableSpanArr.length - 1) - i10;
                    arrayList.add(aVar);
                }
            }
            this.f3712a = arrayList;
        }

        public a a(int i10) {
            for (a aVar : this.f3712a) {
                if (aVar.f3716d == i10) {
                    return aVar;
                }
            }
            return null;
        }

        public a b(int i10, int i11) {
            for (a aVar : this.f3712a) {
                if (aVar.f3714b == i10 && aVar.f3715c == i11) {
                    return aVar;
                }
            }
            return null;
        }

        public int c() {
            return this.f3712a.size();
        }
    }

    public enum e {
        NONE,
        BUTTON,
        DROPDOWNLIST,
        TOGGLEBUTTON,
        LINK,
        SEARCH,
        IMAGE,
        IMAGEBUTTON,
        KEYBOARDKEY,
        TEXT,
        ADJUSTABLE,
        SUMMARY,
        HEADER,
        ALERT,
        CHECKBOX,
        COMBOBOX,
        MENU,
        MENUBAR,
        MENUITEM,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        SCROLLBAR,
        SPINBUTTON,
        SWITCH,
        TAB,
        TABLIST,
        TIMER,
        LIST,
        GRID,
        PAGER,
        SCROLLVIEW,
        HORIZONTALSCROLLVIEW,
        VIEWGROUP,
        WEBVIEW,
        DRAWERLAYOUT,
        SLIDINGDRAWER,
        ICONMENU,
        TOOLBAR;

        public static e b(f fVar) {
            switch (c.f3711b[fVar.ordinal()]) {
                case 1:
                    return ALERT;
                case 2:
                    return BUTTON;
                case 3:
                    return CHECKBOX;
                case 4:
                    return COMBOBOX;
                case 5:
                    return GRID;
                case 6:
                    return HEADER;
                case 7:
                    return IMAGE;
                case 8:
                    return LINK;
                case 9:
                    return LIST;
                case 10:
                    return MENU;
                case 11:
                    return MENUBAR;
                case 12:
                    return MENUITEM;
                case 13:
                    return NONE;
                case 14:
                    return PROGRESSBAR;
                case 15:
                    return RADIO;
                case 16:
                    return RADIOGROUP;
                case 17:
                    return SCROLLBAR;
                case 18:
                    return SEARCH;
                case 19:
                    return ADJUSTABLE;
                case 20:
                    return SPINBUTTON;
                case 21:
                    return SUMMARY;
                case 22:
                    return SWITCH;
                case 23:
                    return TAB;
                case 24:
                    return TABLIST;
                case 25:
                    return TIMER;
                case 26:
                    return TOOLBAR;
                default:
                    return null;
            }
        }

        public static e c(String str) {
            if (str == null) {
                return NONE;
            }
            for (e eVar : values()) {
                if (eVar.name().equalsIgnoreCase(str)) {
                    return eVar;
                }
            }
            throw new IllegalArgumentException("Invalid accessibility role value: " + str);
        }

        public static e d(View view) {
            f fVar = (f) view.getTag(m.f20867x);
            if (fVar != null) {
                return b(fVar);
            }
            return (e) view.getTag(m.f20850g);
        }

        public static String e(e eVar) {
            switch (c.f3710a[eVar.ordinal()]) {
                case 1:
                    return "android.widget.Button";
                case 2:
                    return "android.widget.Spinner";
                case 3:
                    return "android.widget.ToggleButton";
                case 4:
                    return "android.widget.EditText";
                case 5:
                    return "android.widget.ImageView";
                case 6:
                    return "android.widget.ImageButton";
                case 7:
                    return "android.inputmethodservice.Keyboard$Key";
                case 8:
                    return "android.widget.TextView";
                case 9:
                    return "android.widget.SeekBar";
                case 10:
                    return "android.widget.CheckBox";
                case 11:
                    return "android.widget.RadioButton";
                case 12:
                    return "android.widget.SpinButton";
                case 13:
                    return "android.widget.Switch";
                case 14:
                    return "android.widget.AbsListView";
                case 15:
                    return "android.widget.GridView";
                case 16:
                    return "android.widget.ScrollView";
                case 17:
                    return "android.widget.HorizontalScrollView";
                case 18:
                    return "androidx.viewpager.widget.ViewPager";
                case 19:
                    return "androidx.drawerlayout.widget.DrawerLayout";
                case 20:
                    return "android.widget.SlidingDrawer";
                case 21:
                    return "com.android.internal.view.menu.IconMenuView";
                case 22:
                    return "android.view.ViewGroup";
                case 23:
                    return "android.webkit.WebView";
                case 24:
                case 25:
                case 26:
                case 27:
                case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                case 29:
                case 30:
                case 31:
                case 32:
                case MotionEventCompat.AXIS_GENERIC_2 /*33*/:
                case 34:
                case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                case 36:
                case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
                case MotionEventCompat.AXIS_GENERIC_7 /*38*/:
                case MotionEventCompat.AXIS_GENERIC_8 /*39*/:
                    return "android.view.View";
                default:
                    throw new IllegalArgumentException("Invalid accessibility role value: " + eVar);
            }
        }
    }

    public enum f {
        ALERT,
        ALERTDIALOG,
        APPLICATION,
        ARTICLE,
        BANNER,
        BUTTON,
        CELL,
        CHECKBOX,
        COLUMNHEADER,
        COMBOBOX,
        COMPLEMENTARY,
        CONTENTINFO,
        DEFINITION,
        DIALOG,
        DIRECTORY,
        DOCUMENT,
        FEED,
        FIGURE,
        FORM,
        GRID,
        GROUP,
        HEADING,
        IMG,
        LINK,
        LIST,
        LISTITEM,
        LOG,
        MAIN,
        MARQUEE,
        MATH,
        MENU,
        MENUBAR,
        MENUITEM,
        METER,
        NAVIGATION,
        NONE,
        NOTE,
        OPTION,
        PRESENTATION,
        PROGRESSBAR,
        RADIO,
        RADIOGROUP,
        REGION,
        ROW,
        ROWGROUP,
        ROWHEADER,
        SCROLLBAR,
        SEARCHBOX,
        SEPARATOR,
        SLIDER,
        SPINBUTTON,
        STATUS,
        SUMMARY,
        SWITCH,
        TAB,
        TABLE,
        TABLIST,
        TABPANEL,
        TERM,
        TIMER,
        TOOLBAR,
        TOOLTIP,
        TREE,
        TREEGRID,
        TREEITEM;

        public static f b(String str) {
            for (f fVar : values()) {
                if (fVar.name().equalsIgnoreCase(str)) {
                    return fVar;
                }
            }
            return null;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f3701h = hashMap;
        hashMap.put("activate", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK.getId()));
        hashMap.put("longpress", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_LONG_CLICK.getId()));
        hashMap.put("increment", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId()));
        hashMap.put("decrement", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId()));
        hashMap.put("expand", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND.getId()));
        hashMap.put("collapse", Integer.valueOf(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE.getId()));
    }

    public i0(View view, boolean z10, int i10) {
        super(view);
        this.f3702a = view;
        view.setFocusable(z10);
        ViewCompat.setImportantForAccessibility(view, i10);
        this.f3703b = (d) view.getTag(m.f20849f);
    }

    public static AccessibilityNodeInfoCompat a(View view) {
        if (view == null) {
            return null;
        }
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        try {
            ViewCompat.onInitializeAccessibilityNodeInfo(view, obtain);
            return obtain;
        } catch (NullPointerException unused) {
            if (obtain != null) {
                obtain.recycle();
            }
            return null;
        }
    }

    private Rect b(d.a aVar) {
        float f10;
        View view = this.f3702a;
        boolean z10 = false;
        if (!(view instanceof TextView)) {
            return new Rect(0, 0, this.f3702a.getWidth(), this.f3702a.getHeight());
        }
        TextView textView = (TextView) view;
        Layout layout = textView.getLayout();
        if (layout == null) {
            return new Rect(0, 0, textView.getWidth(), textView.getHeight());
        }
        double d10 = (double) aVar.f3714b;
        double d11 = (double) aVar.f3715c;
        int i10 = (int) d10;
        int lineForOffset = layout.getLineForOffset(i10);
        if (d10 > ((double) layout.getLineEnd(lineForOffset))) {
            return null;
        }
        Rect rect = new Rect();
        double primaryHorizontal = (double) layout.getPrimaryHorizontal(i10);
        Paint paint = new Paint();
        AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) c(aVar.f3714b, aVar.f3715c, AbsoluteSizeSpan.class);
        if (absoluteSizeSpan != null) {
            f10 = (float) absoluteSizeSpan.getSize();
        } else {
            f10 = textView.getTextSize();
        }
        paint.setTextSize(f10);
        int ceil = (int) Math.ceil((double) paint.measureText(aVar.f3713a));
        if (lineForOffset != layout.getLineForOffset((int) d11)) {
            z10 = true;
        }
        layout.getLineBounds(lineForOffset, rect);
        int scrollY = textView.getScrollY() + textView.getTotalPaddingTop();
        rect.top += scrollY;
        rect.bottom += scrollY;
        rect.left = (int) (((double) rect.left) + ((primaryHorizontal + ((double) textView.getTotalPaddingLeft())) - ((double) textView.getScrollX())));
        if (z10) {
            return new Rect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int i11 = rect.left;
        return new Rect(i11, rect.top, ceil + i11, rect.bottom);
    }

    public static CharSequence d(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        if (accessibilityNodeInfoCompat == null) {
            accessibilityNodeInfoCompat2 = a(view);
        } else {
            accessibilityNodeInfoCompat2 = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
        }
        if (accessibilityNodeInfoCompat2 == null) {
            return null;
        }
        try {
            CharSequence contentDescription = accessibilityNodeInfoCompat2.getContentDescription();
            CharSequence text = accessibilityNodeInfoCompat2.getText();
            boolean z10 = !TextUtils.isEmpty(text);
            boolean z11 = view instanceof EditText;
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(contentDescription) && (!z11 || !z10)) {
                sb2.append(contentDescription);
                return sb2;
            } else if (z10) {
                sb2.append(text);
                accessibilityNodeInfoCompat2.recycle();
                return sb2;
            } else if (view instanceof ViewGroup) {
                StringBuilder sb3 = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
                    ViewCompat.onInitializeAccessibilityNodeInfo(childAt, obtain);
                    if (k(obtain, childAt) && !i(obtain, childAt)) {
                        CharSequence d10 = d(childAt, (AccessibilityNodeInfoCompat) null);
                        if (!TextUtils.isEmpty(d10)) {
                            sb3.append(d10 + ", ");
                        }
                    }
                    obtain.recycle();
                }
                String l10 = l(sb3);
                accessibilityNodeInfoCompat2.recycle();
                return l10;
            } else {
                accessibilityNodeInfoCompat2.recycle();
                return null;
            }
        } finally {
            accessibilityNodeInfoCompat2.recycle();
        }
    }

    public static boolean e(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (!(accessibilityNodeInfoCompat == null || view == null || !(view instanceof ViewGroup))) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt != null) {
                    boolean obtain = AccessibilityNodeInfoCompat.obtain();
                    try {
                        ViewCompat.onInitializeAccessibilityNodeInfo(childAt, obtain);
                        if (obtain.isVisibleToUser()) {
                            if (!i(obtain, childAt)) {
                                obtain = k(obtain, childAt);
                                if (obtain) {
                                    obtain.recycle();
                                    return true;
                                }
                            }
                        }
                    } finally {
                        if (obtain != null) {
                            obtain.recycle();
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean f(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null || (TextUtils.isEmpty(accessibilityNodeInfoCompat.getStateDescription()) && !accessibilityNodeInfoCompat.isCheckable() && !h(accessibilityNodeInfoCompat))) {
            return false;
        }
        return true;
    }

    public static boolean g(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null || accessibilityNodeInfoCompat.getCollectionInfo() != null || (TextUtils.isEmpty(accessibilityNodeInfoCompat.getText()) && TextUtils.isEmpty(accessibilityNodeInfoCompat.getContentDescription()) && TextUtils.isEmpty(accessibilityNodeInfoCompat.getHintText()))) {
            return false;
        }
        return true;
    }

    public static boolean h(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat.RangeInfoCompat rangeInfo;
        if (accessibilityNodeInfoCompat == null || (rangeInfo = accessibilityNodeInfoCompat.getRangeInfo()) == null) {
            return false;
        }
        float max = rangeInfo.getMax();
        float min = rangeInfo.getMin();
        float current = rangeInfo.getCurrent();
        if (max - min <= 0.0f || current < min || current > max) {
            return false;
        }
        return true;
    }

    public static boolean i(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat == null || view == null || !accessibilityNodeInfoCompat.isVisibleToUser()) {
            return false;
        }
        if (accessibilityNodeInfoCompat.isScreenReaderFocusable() || j(accessibilityNodeInfoCompat)) {
            return true;
        }
        return false;
    }

    public static boolean j(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        if (accessibilityNodeInfoCompat.isClickable() || accessibilityNodeInfoCompat.isLongClickable() || accessibilityNodeInfoCompat.isFocusable()) {
            return true;
        }
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = accessibilityNodeInfoCompat.getActionList();
        if (actionList.contains(16) || actionList.contains(32) || actionList.contains(1)) {
            return true;
        }
        return false;
    }

    public static boolean k(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        int importantForAccessibility;
        if (accessibilityNodeInfoCompat == null || view == null || (importantForAccessibility = ViewCompat.getImportantForAccessibility(view)) == 4) {
            return false;
        }
        if (importantForAccessibility == 2 && accessibilityNodeInfoCompat.getChildCount() <= 0) {
            return false;
        }
        if (g(accessibilityNodeInfoCompat) || f(accessibilityNodeInfoCompat) || accessibilityNodeInfoCompat.isCheckable() || e(accessibilityNodeInfoCompat, view)) {
            return true;
        }
        return false;
    }

    private static String l(StringBuilder sb2) {
        int length = sb2.length();
        if (length > 0) {
            sb2.delete(length - f3700g, length);
        }
        return sb2.toString();
    }

    public static void m(View view, boolean z10, int i10) {
        ViewCompat.setAccessibilityDelegate(view, new i0(view, z10, i10));
    }

    private void n(View view) {
        if (this.f3704c.hasMessages(1, view)) {
            this.f3704c.removeMessages(1, view);
        }
        this.f3704c.sendMessageDelayed(this.f3704c.obtainMessage(1, view), 200);
    }

    public static void o(View view, boolean z10, int i10) {
        if (ViewCompat.hasAccessibilityDelegate(view)) {
            return;
        }
        if (view.getTag(m.f20850g) != null || view.getTag(m.f20851h) != null || view.getTag(m.f20844a) != null || view.getTag(m.f20860q) != null || view.getTag(m.f20846c) != null || view.getTag(m.f20849f) != null || view.getTag(m.f20867x) != null) {
            ViewCompat.setAccessibilityDelegate(view, new i0(view, z10, i10));
        }
    }

    public static void p(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, e eVar, Context context) {
        if (eVar == null) {
            eVar = e.NONE;
        }
        accessibilityNodeInfoCompat.setClassName(e.e(eVar));
        if (eVar.equals(e.LINK)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.f20902w));
        } else if (eVar.equals(e.IMAGE)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.f20900u));
        } else if (eVar.equals(e.IMAGEBUTTON)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.f20901v));
            accessibilityNodeInfoCompat.setClickable(true);
        } else if (eVar.equals(e.BUTTON)) {
            accessibilityNodeInfoCompat.setClickable(true);
        } else if (eVar.equals(e.TOGGLEBUTTON)) {
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.setCheckable(true);
        } else if (eVar.equals(e.SUMMARY)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.I));
        } else if (eVar.equals(e.HEADER)) {
            accessibilityNodeInfoCompat.setHeading(true);
        } else if (eVar.equals(e.ALERT)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.f20880a));
        } else if (eVar.equals(e.COMBOBOX)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.f20899t));
        } else if (eVar.equals(e.MENU)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.f20903x));
        } else if (eVar.equals(e.MENUBAR)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.f20904y));
        } else if (eVar.equals(e.MENUITEM)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.f20905z));
        } else if (eVar.equals(e.PROGRESSBAR)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.A));
        } else if (eVar.equals(e.RADIOGROUP)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.B));
        } else if (eVar.equals(e.SCROLLBAR)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.D));
        } else if (eVar.equals(e.SPINBUTTON)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.E));
        } else if (eVar.equals(e.TAB)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.C));
        } else if (eVar.equals(e.TABLIST)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.J));
        } else if (eVar.equals(e.TIMER)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.K));
        } else if (eVar.equals(e.TOOLBAR)) {
            accessibilityNodeInfoCompat.setRoleDescription(context.getString(p.L));
        }
    }

    private static void q(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ReadableMap readableMap, Context context) {
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            Dynamic dynamic = readableMap.getDynamic(nextKey);
            if (nextKey.equals("selected") && dynamic.getType() == ReadableType.Boolean) {
                accessibilityNodeInfoCompat.setSelected(dynamic.asBoolean());
            } else if (nextKey.equals("disabled") && dynamic.getType() == ReadableType.Boolean) {
                accessibilityNodeInfoCompat.setEnabled(!dynamic.asBoolean());
            } else if (nextKey.equals("checked") && dynamic.getType() == ReadableType.Boolean) {
                boolean asBoolean = dynamic.asBoolean();
                accessibilityNodeInfoCompat.setCheckable(true);
                accessibilityNodeInfoCompat.setChecked(asBoolean);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object c(int i10, int i11, Class cls) {
        View view = this.f3702a;
        if (!(view instanceof TextView) || !(((TextView) view).getText() instanceof Spanned)) {
            return null;
        }
        Object[] spans = ((Spanned) ((TextView) this.f3702a).getText()).getSpans(i10, i11, cls);
        if (spans.length > 0) {
            return spans[0];
        }
        return null;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.f3703b != null) {
            return super.getAccessibilityNodeProvider(view);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        r6 = (android.text.Spanned) r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getVirtualViewAt(float r5, float r6) {
        /*
            r4 = this;
            com.facebook.react.uimanager.i0$d r0 = r4.f3703b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L_0x0069
            int r0 = r0.c()
            if (r0 == 0) goto L_0x0069
            android.view.View r0 = r4.f3702a
            boolean r2 = r0 instanceof android.widget.TextView
            if (r2 != 0) goto L_0x0013
            goto L_0x0069
        L_0x0013:
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r2 = r0.getText()
            boolean r2 = r2 instanceof android.text.Spanned
            if (r2 != 0) goto L_0x001e
            return r1
        L_0x001e:
            android.text.Layout r2 = r0.getLayout()
            if (r2 != 0) goto L_0x0025
            return r1
        L_0x0025:
            int r3 = r0.getTotalPaddingLeft()
            float r3 = (float) r3
            float r5 = r5 - r3
            int r3 = r0.getTotalPaddingTop()
            float r3 = (float) r3
            float r6 = r6 - r3
            int r3 = r0.getScrollX()
            float r3 = (float) r3
            float r5 = r5 + r3
            int r3 = r0.getScrollY()
            float r3 = (float) r3
            float r6 = r6 + r3
            int r6 = (int) r6
            int r6 = r2.getLineForVertical(r6)
            int r5 = r2.getOffsetForHorizontal(r6, r5)
            java.lang.Class<android.text.style.ClickableSpan> r6 = android.text.style.ClickableSpan.class
            java.lang.Object r5 = r4.c(r5, r5, r6)
            android.text.style.ClickableSpan r5 = (android.text.style.ClickableSpan) r5
            if (r5 != 0) goto L_0x0051
            return r1
        L_0x0051:
            java.lang.CharSequence r6 = r0.getText()
            android.text.Spanned r6 = (android.text.Spanned) r6
            int r0 = r6.getSpanStart(r5)
            int r5 = r6.getSpanEnd(r5)
            com.facebook.react.uimanager.i0$d r6 = r4.f3703b
            com.facebook.react.uimanager.i0$d$a r5 = r6.b(r0, r5)
            if (r5 == 0) goto L_0x0069
            int r1 = r5.f3716d
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.i0.getVirtualViewAt(float, float):int");
    }

    /* access modifiers changed from: protected */
    public void getVisibleVirtualViews(List list) {
        if (this.f3703b != null) {
            for (int i10 = 0; i10 < this.f3703b.c(); i10++) {
                list.add(Integer.valueOf(i10));
            }
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ReadableType readableType;
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        ReadableMap readableMap = (ReadableMap) view.getTag(m.f20853j);
        if (readableMap != null && readableMap.hasKey("min") && readableMap.hasKey("now") && readableMap.hasKey("max")) {
            Dynamic dynamic = readableMap.getDynamic("min");
            Dynamic dynamic2 = readableMap.getDynamic("now");
            Dynamic dynamic3 = readableMap.getDynamic("max");
            if (dynamic != null && dynamic.getType() == (readableType = ReadableType.Number) && dynamic2 != null && dynamic2.getType() == readableType && dynamic3 != null && dynamic3.getType() == readableType) {
                int asInt = dynamic.asInt();
                int asInt2 = dynamic2.asInt();
                int asInt3 = dynamic3.asInt();
                if (asInt3 > asInt && asInt2 >= asInt && asInt3 >= asInt2) {
                    accessibilityEvent.setItemCount(asInt3 - asInt);
                    accessibilityEvent.setCurrentItemIndex(asInt2);
                }
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z10;
        ReadableType readableType;
        String str;
        int i10;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (view.getTag(m.f20852i) != null) {
            if (((Boolean) view.getTag(m.f20852i)).booleanValue()) {
                i10 = 524288;
            } else {
                i10 = 262144;
            }
            accessibilityNodeInfoCompat.addAction(i10);
        }
        e d10 = e.d(view);
        String str2 = (String) view.getTag(m.f20847d);
        if (d10 != null) {
            p(accessibilityNodeInfoCompat, d10, view.getContext());
        }
        if (str2 != null) {
            accessibilityNodeInfoCompat.setTooltipText(str2);
        }
        Object tag = view.getTag(m.f20857n);
        if (tag != null) {
            View a10 = n7.a.a(view.getRootView(), (String) tag);
            this.f3706e = a10;
            if (a10 != null) {
                accessibilityNodeInfoCompat.setLabeledBy(a10);
            }
        }
        ReadableMap readableMap = (ReadableMap) view.getTag(m.f20851h);
        if (readableMap != null) {
            q(accessibilityNodeInfoCompat, readableMap, view.getContext());
        }
        ReadableArray readableArray = (ReadableArray) view.getTag(m.f20844a);
        ReadableMap readableMap2 = (ReadableMap) view.getTag(m.f20846c);
        if (readableMap2 != null) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(readableMap2.getInt("rowIndex"), readableMap2.getInt("rowSpan"), readableMap2.getInt("columnIndex"), readableMap2.getInt("columnSpan"), readableMap2.getBoolean("heading")));
        }
        boolean z11 = true;
        if (readableArray != null) {
            int i11 = 0;
            while (i11 < readableArray.size()) {
                ReadableMap map = readableArray.getMap(i11);
                if (map.hasKey("name")) {
                    int i12 = f3699f;
                    if (map.hasKey(Constants.ScionAnalytics.PARAM_LABEL)) {
                        str = map.getString(Constants.ScionAnalytics.PARAM_LABEL);
                    } else {
                        str = null;
                    }
                    HashMap hashMap = f3701h;
                    if (hashMap.containsKey(map.getString("name"))) {
                        i12 = ((Integer) hashMap.get(map.getString("name"))).intValue();
                    } else {
                        f3699f++;
                    }
                    this.f3705d.put(Integer.valueOf(i12), map.getString("name"));
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i12, str));
                    i11++;
                } else {
                    throw new IllegalArgumentException("Unknown accessibility action.");
                }
            }
        }
        ReadableMap readableMap3 = (ReadableMap) view.getTag(m.f20853j);
        if (readableMap3 != null && readableMap3.hasKey("min") && readableMap3.hasKey("now") && readableMap3.hasKey("max")) {
            Dynamic dynamic = readableMap3.getDynamic("min");
            Dynamic dynamic2 = readableMap3.getDynamic("now");
            Dynamic dynamic3 = readableMap3.getDynamic("max");
            if (dynamic != null && dynamic.getType() == (readableType = ReadableType.Number) && dynamic2 != null && dynamic2.getType() == readableType && dynamic3 != null && dynamic3.getType() == readableType) {
                int asInt = dynamic.asInt();
                int asInt2 = dynamic2.asInt();
                int asInt3 = dynamic3.asInt();
                if (asInt3 > asInt && asInt2 >= asInt && asInt3 >= asInt2) {
                    accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(0, (float) asInt, (float) asInt3, (float) asInt2));
                }
            }
        }
        String str3 = (String) view.getTag(m.f20860q);
        if (str3 != null) {
            accessibilityNodeInfoCompat.setViewIdResourceName(str3);
        }
        boolean isEmpty = TextUtils.isEmpty(accessibilityNodeInfoCompat.getContentDescription());
        boolean isEmpty2 = TextUtils.isEmpty(accessibilityNodeInfoCompat.getText());
        if (!isEmpty || !isEmpty2) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (readableArray == null && readableMap == null && tag == null && d10 == null) {
            z11 = false;
        }
        if (z10 && z11) {
            accessibilityNodeInfoCompat.setContentDescription(d(view, accessibilityNodeInfoCompat));
        }
    }

    /* access modifiers changed from: protected */
    public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForVirtualView(int i10, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        d dVar = this.f3703b;
        if (dVar == null) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect(0, 0, 1, 1));
            return;
        }
        d.a a10 = dVar.a(i10);
        if (a10 == null) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect(0, 0, 1, 1));
            return;
        }
        Rect b10 = b(a10);
        if (b10 == null) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect(0, 0, 1, 1));
            return;
        }
        accessibilityNodeInfoCompat.setContentDescription(a10.f3713a);
        accessibilityNodeInfoCompat.addAction(16);
        accessibilityNodeInfoCompat.setBoundsInParent(b10);
        accessibilityNodeInfoCompat.setRoleDescription(this.f3702a.getResources().getString(p.f20902w));
        accessibilityNodeInfoCompat.setClassName(e.e(e.BUTTON));
    }

    public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        if (i10 == 524288) {
            view.setTag(m.f20852i, Boolean.FALSE);
        }
        if (i10 == 262144) {
            view.setTag(m.f20852i, Boolean.TRUE);
        }
        if (!this.f3705d.containsKey(Integer.valueOf(i10))) {
            return super.performAccessibilityAction(view, i10, bundle);
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putString("actionName", (String) this.f3705d.get(Integer.valueOf(i10)));
        ReactContext reactContext = (ReactContext) view.getContext();
        if (reactContext.hasActiveReactInstance()) {
            int id2 = view.getId();
            int e10 = k1.e(reactContext);
            UIManager g10 = k1.g(reactContext, i7.a.a(id2));
            if (g10 != null) {
                ((com.facebook.react.uimanager.events.e) g10.getEventDispatcher()).c(new b(e10, id2, createMap));
            }
        } else {
            ReactSoftExceptionLogger.logSoftException("ReactAccessibilityDelegate", new ReactNoCrashSoftException("Cannot get RCTEventEmitter, no CatalystInstance"));
        }
        e eVar = (e) view.getTag(m.f20850g);
        ReadableMap readableMap = (ReadableMap) view.getTag(m.f20853j);
        if (eVar != e.ADJUSTABLE) {
            return true;
        }
        if (i10 != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId() && i10 != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId()) {
            return true;
        }
        if (readableMap != null && !readableMap.hasKey("text")) {
            n(view);
        }
        return super.performAccessibilityAction(view, i10, bundle);
    }
}
