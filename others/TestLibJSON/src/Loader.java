import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import java.util.Map;
import java.util.TreeMap;

/**
 * Тестирую применение библиотеки json-simple
 */
public class Loader {
    public static void main(String[] args) {
        System.out.println("Begin");

        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
        Object obj = JSONValue.parse(s);
        JSONArray jArray = (JSONArray) obj;

        System.out.println("Classes: ");
        System.out.println(jArray.get(0).getClass());
        JSObject o = (JSObject) jArray.get(1);

        //System.out.println("result" + result);

        System.out.println("End");

    }

    public static String getData() {
        System.out.println("getDataStart");
        String data = "";

        // TODO


        System.out.println("getDataEnd");
        return data;
    }

    public static void getInner(Object obj) {
        try {

        } catch (Exception ex) {
            throw new NullPointerException("End");
        }
    }
}
