package usage.fastjson.jsonarray;

import com.alibaba.fastjson.JSON;
import javafx.scene.control.cell.CheckBoxListCell;
import junit.framework.TestCase;

public class TestSimpleJSON extends TestCase {

    public void test_parse_number() {
        String str = "5";
        Object object = JSON.parse("5");
        assertTrue(object instanceof Number);
        System.out.println(object); // 5

        /**
         * fastjson could parse a number which leading zero
         * but it only remove the leading zero when parsing it.
         */
        object = JSON.parse("012");
        System.out.println(object); // 12
    }

    public void test_parse_boolean() {
        Object object = JSON.parse("true");
        assertTrue(object instanceof Boolean);

        try {
            object = JSON.parse("True");
            fail("'True' is not boolean value");
        } catch (Exception e) {
            assertTrue( e.getMessage().startsWith("syntax error"));
        }
    }

    public void test_parse_string() {
        /**
         * a string which is not been wrapped with quotes is not a valid json
         */
        try {
            Object object = JSON.parse("hello");
            fail("'hello' which is not been wrapped with quotes is not a valid json");
        } catch (Exception e) {
            assertTrue(e.getMessage().startsWith("syntax error"));
        }

        Object object = JSON.parse("'hello'");
        assertTrue(object instanceof String);
        assertEquals("hello", object);
    }
}
