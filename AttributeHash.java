import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaddyr on 7/3/17.
 */
public class AttributeHash {

    private Map<String, Attribute> attributeMap;

    public AttributeHash() {
        attributeMap = new HashMap<>();
    }

    public void put(Attribute attribute) {
        if (attributeMap.containsKey(attribute.getName())) {
            Attribute current = attributeMap.get(attribute.getName());
            try {
                current.mergeAttribute(attribute);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            attributeMap.put(attribute.getName(),attribute);
        }
    }

    public String toString() {
        String temp = "";
        for (Attribute attribute : attributeMap.values()) {
            temp+=attribute + "\n";
        }
        return temp;
    }


}
