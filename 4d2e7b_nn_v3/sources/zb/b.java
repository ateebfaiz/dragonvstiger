package zb;

import java.util.List;
import java.util.Map;

public interface b extends a {
    Object call(Object... objArr);

    Object callBy(Map map);

    List getParameters();

    k getReturnType();

    List getTypeParameters();

    m getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
