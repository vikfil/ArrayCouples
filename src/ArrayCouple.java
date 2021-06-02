import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayCouple {
    private Map<Integer, Integer> mapWithPair;
    private Map<Integer, Integer> mapWithoutPair;

    public ArrayCouple() {
        this.mapWithPair = new HashMap<>();
        this.mapWithoutPair = new LinkedHashMap<>();
    }
    public String arrayChallenge(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            boolean hasPair = false;
            if (mapWithPair.containsKey(arr[i]) && mapWithPair.get(arr[i]) == arr[i + 1]) {
                continue;
            }
            mapWithPair.put(arr[i], arr[i +1]);
            for (int j = i + 2; j < arr.length; j += 2) {
                if (mapWithPair.containsKey(arr[j + 1]) && mapWithPair.get(arr[i]) == arr[j] ) {
                    mapWithPair.put(arr[j], arr[j + 1]);
                    hasPair = true;
                }
            }
            if (!hasPair) {
                mapWithPair.remove(arr[i]);
                mapWithoutPair.put(arr[i], arr[i + 1]);
            }
        }

        return mapWithoutPair.isEmpty() ? "yes" : buildStringFromMap(mapWithoutPair);
    }

    private String buildStringFromMap(Map<Integer, Integer> map) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            builder.append(entry.getKey());
            builder.append(",");
            builder.append(entry.getValue());
            builder.append(",");
        }
        return builder.deleteCharAt(builder.length()-1).toString();
    }

    public static void main(String[] args) {
        int[] arr1 = {2,1,1,2,3,3};
        System.out.println(new ArrayCouple().arrayChallenge(arr1));
    }
}
