package usage.jsonlib.jsonarray;

import junit.framework.TestCase;
import net.sf.json.JSONObject;

public class TestJSONObject extends TestCase {

    public void test_array_from_brackets() {
        String str = "{}[]{}";
        JSONObject object = JSONObject.fromObject(str);
        System.out.println(object);
        // {}
    }


    public void test_array_element() {
        String str1 = "[string]";
        String str2 = "[5]";
        String str3 = "{hello}";
        String str4 = "{}";

        JSONObject object = new JSONObject();
        object.element("key1", str1);
        object.element("key2", str2);
        object.element("key3", str3);
        object.element("key4", str4);

        System.out.println(object);
        // 2.4      {"key1":"[string]","key2":[5],"key3":"{hello}","key4":{}}
        // 3.0.0    {"key1":"[string]","key2":"[5]","key3":"{hello}","key4":"{}"}
    }
}
