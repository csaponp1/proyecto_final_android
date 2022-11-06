package fr.neutronstars.json;
import org.json.JSONArray;
import org.json.JSONObject;
public class JSON {

    public static void main(String... args){
        JSONObject obj = new JSONObject();
        try {
            obj.accumulate("key", "value");
            obj.accumulate("number", 2);

            System.out.println(obj.toString());

            JSONArray array = new JSONArray();
            array.put("value");
            array.put(obj);

            System.out.println(array.toString());

            if (obj.has("key")) System.out.println(obj.getString("key"));
            if (obj.has("number")) System.out.println(obj.getString("number"));

            for (int i = 0; i < array.length(); i++) {
                System.out.println(array.get(i));
            }
        }catch(Exception ex){
            System.out.println("no se puede conectar"+ex.getMessage());
        }

    }


}
