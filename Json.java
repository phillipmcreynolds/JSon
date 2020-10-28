import java.util.ArrayList;

/**
 * Utility class to serialize objects to/from JSON
 * @author phillipmcreynolds
 * @version 1.0.0
 */
public class Json {
    /**
     * serializes an array to JSON
     * the objects in the array must implement toString()
     * @param objects Array to serialize
     * @param wrapperKey the wrapper key (if there is one)
     * @param isRoot is the array a root level JSON object?
     * @return JSONized string
     */
    public static String arrayToJSON(ArrayList<Object> objects, String wrapperKey, boolean isRoot) {
        String s = "";
        // it is a root-level array
        if (isRoot) {
            s += "[\n";
        }

        // is it wrapped with a key?
        if ((wrapperKey == null) || (wrapperKey.length() == 0)) {
        } else {
            s += "\"" + wrapperKey + "\": [";
        }

        // call toString on all the objects, interspersed with commas
        for (int i = 0; i < objects.size(); i++) {
            if (!isRoot) {
                s += "\"";
            }
            s += objects.get(i).toString();

            if (!isRoot) {
                s += "\"";
            }
            if (i != objects.size() - 1) {
                s += ", ";
            }
        }
        s += "]";

        return s;
    }
}
