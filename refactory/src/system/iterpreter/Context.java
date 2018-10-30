package system.iterpreter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 环境
 * @author 马一帆
 * @version 0.1
 */
public class Context
{
    private Map<Object, Object> valueMap = new HashMap<>();

    public void addValue(Variable x, BigDecimal y) {
        valueMap.put(x, y);
    }

    public BigDecimal LookupValue(Variable x) {
        return (BigDecimal) valueMap.get(x);
    }
}
