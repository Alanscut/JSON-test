package usage.jsonlib.jsonarray;

import junit.framework.TestCase;
import net.sf.json.JSONArray;

import java.util.HashMap;

public class TestJSONArray extends TestCase {

    public void test_array_from_brackets() {
        String str = "[]{}[]";
        JSONArray array = JSONArray.fromObject(str);
        System.out.println(array);
        // []
    }

    public void test_array_element() {
        String str1 = "[string]";
        String str2 = "[5]";
        String str3 = "{hello}";//通过异常来解析，这种处理方式感觉不合适。。
        String str4 = "{}";

        JSONArray array = new JSONArray();
        array.element(str1);
        array.element(str2);
        array.element(str3);
        array.element(str4);

        System.out.println(array);
        // 2.4      ["[string]",[5],"{hello}",{}]
        // 3.0.0    ["[string]",[5],"{hello}",{}]
    }

    public void testFromObject_Map() {
        JSONArray expected = JSONArray.fromObject("[{}]");
        JSONArray actual = JSONArray.fromObject(new HashMap());
        System.out.println(expected);   // [{}]
        System.out.println(actual);     // [{}]
    }
}
