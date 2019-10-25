package usage.fastjson.jsonarray;

import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;

public class TestJSONObject extends TestCase {

    public void test_array_from_brackets() {
        String str = "{}[]{}";
        JSONObject object = JSONObject.parseObject(str);
        System.out.println(object);
        // {}
    }

    public void test_array_element() {
        String str1 = "[string]";
        String str2 = "[5]";
        String str3 = "{hello}";
        String str4 = "{}";

        JSONObject object = new JSONObject();
        object.put("key1", str1);
        object.put("key2", str2);
        object.put("key3", str3);
        object.put("key4", str4);

        System.out.println(object);
        // {"key1":"[string]","key2":"[5]","key3":"{hello}","key4":"{}"}
    }
}
