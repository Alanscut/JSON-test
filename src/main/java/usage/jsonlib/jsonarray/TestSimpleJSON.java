package usage.jsonlib.jsonarray;

import junit.framework.TestCase;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class TestSimpleJSON extends TestCase {
    public void test_parse_number() {
        Object object = null;
        try {
            object = JSONSerializer.toJSON("5");
            fail("json-lib could not parse a single number to a number JSON");
        } catch (Exception e) {
            assertEquals("Invalid JSON String", e.getMessage());
        }

        object = JSONSerializer.toJSON("[5]");
        assertTrue(object instanceof JSONArray);
        JSONArray array = (JSONArray) object;
        assertTrue(array.get(0) instanceof Number);
        System.out.println(object); // [5]

        /**
         * json-lib could parse a number which leading zero
         * start with '0' will read as an octal number,
         * start with '0x' will read as hex number.
         */
        object = JSONSerializer.toJSON("[012]");
        System.out.println(object); // 10

        object = JSONSerializer.toJSON("[0x12]");
        System.out.println(object); // 18
    }

    public void test_parse_boolean() {
        Object object = JSONSerializer.toJSON("[true]");
        JSONArray array = (JSONArray) object;
        assertTrue(array.get(0) instanceof Boolean);


    }

    public void test_parse_string() {
        /**
         * a string which is not been wrapped with quotes is not a valid json
         */
        try {
            Object object = JSONSerializer.toJSON("hello");
            fail("'hello' which is not been wrapped with quotes is not a valid json");
        } catch (Exception e) {
//            assertTrue(e.getMessage().startsWith("syntax error"));
            System.out.println(e.getMessage());
        }


        /**
         * json-lib can't parse a string
         */
        Object object = null;
        try {
            object = JSONSerializer.toJSON("'hello'");
        } catch (Exception e) {
            assertEquals("Invalid JSON String", e.getMessage());
        }
    }
}
