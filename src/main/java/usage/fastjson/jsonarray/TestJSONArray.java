package usage.fastjson.jsonarray;

import com.alibaba.fastjson.JSONArray;
import junit.framework.TestCase;

import java.util.HashMap;

public class TestJSONArray extends TestCase {

    public void test_array_from_brackets() {
        try {
            String str = "[]{}[]";
            JSONArray array = JSONArray.parseArray(str);
            fail("this should be failed!");
        } catch (Exception e) {
            // ok
            System.out.println(e);
            assertEquals("not close json text, token : {", e.getMessage());
        }
    }

    public void test_array_element() {
        String str1 = "[string]";
        String str2 = "[5]";
        String str3 = "{hello}";//通过异常来解析，这种处理方式感觉不合适。。
        String str4 = "{}";

        JSONArray array = new JSONArray();
        array.add(str1);
        array.add(str2);
        array.add(str3);
        array.add(str4);

        System.out.println(array);
        // ["[string]","[5]","{hello}","{}"]
    }

    public void testFromObject_Map() {
        JSONArray expected = JSONArray.parseArray("[{}]");
        Object actual = JSONArray.toJSON(new HashMap());
        System.out.println(expected);   // [{}]
        System.out.println(actual);     // {}
    }
}
