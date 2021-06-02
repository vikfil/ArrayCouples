import java.util.*;

public class ArrayCouple {
    private Set<Pair> setWithPair;
    private Set<Pair> setWithoutPair;

    public ArrayCouple() {
        this.setWithPair = new HashSet<>();
        this.setWithoutPair = new LinkedHashSet<>();
    }
    public String arrayChallenge(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            boolean hasPair = false;
            if (setWithPair.contains(new Pair(arr[i],arr[i + 1]))) {
                continue;
            }
            Pair newPair = new Pair(arr[i], arr[i +1]);
            setWithPair.add(newPair);
            for (int j = i + 2; j < arr.length; j += 2) {
                if (newPair.getX() == arr[j + 1] && newPair.getY() == arr[j])  {
                    setWithPair.add(new Pair(arr[j], arr[j + 1]));
                    hasPair = true;
                }
            }
            if (!hasPair) {
                setWithPair.remove(newPair);
                setWithoutPair.add(newPair);
            }
        }

        return setWithoutPair.isEmpty() ? "yes" : buildStringFromSet(setWithoutPair);
    }

    private String buildStringFromSet(Set<Pair> set) {
        StringBuilder builder = new StringBuilder();
        for (Pair pair : set) {
            builder.append(pair.getX());
            builder.append(",");
            builder.append(pair.getY());
            builder.append(",");
        }
        return builder.deleteCharAt(builder.length()-1).toString();
    }

    public static void main(String[] args) {
        int[] arr1 = {5,4,6,7,7,6,4,5};
        System.out.println(new ArrayCouple().arrayChallenge(arr1));
    }
}
