import java.util.*;
import java.util.stream.Collectors;

public class ArrayCouple {
    private Set<Pair> setWithoutReversedPair;

    public String arrayChallenge(int[] arr) {
        Set<Pair> pairSet = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i += 2) {
            pairSet.add(new Pair(arr[i], arr[i + 1]));
        }

        setWithoutReversedPair = pairSet.stream()
                 .filter(pair -> !pairSet.contains(new Pair(pair.getY(), pair.getX())) || pair.getX() == pair.getY())
                 .collect(Collectors.toCollection(LinkedHashSet::new));

        return setWithoutReversedPair.isEmpty() ? "yes" : buildStringFromSet(setWithoutReversedPair);
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
