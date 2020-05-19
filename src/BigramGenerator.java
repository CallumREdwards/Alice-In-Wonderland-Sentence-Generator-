import java.util.HashMap;

public class BigramGenerator implements Generator {
    public BigramGenerator(String[] trainingData) {

    }

    private HashMap<String, HashMap<String, Integer>> countFrequency(String[] trainingData) {
        HashMap<String, HashMap<String, Integer>> bigramFrequency = new HashMap<>();
        String previousWord = null;
        for (String word : trainingData) {
            if (previousWord == null) continue;
            HashMap<String, Integer> interMap = bigramFrequency.getOrDefault(previousWord, new HashMap<>());
            interMap.put(word, 1 + interMap.getOrDefault(word, 0));
            previousWord = word;
        }
        return bigramFrequency;
    }

    @Override
    public String[] generate() {
        return null;
    }
}
