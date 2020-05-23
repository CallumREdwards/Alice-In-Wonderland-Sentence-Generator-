import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BigramGenerator  {
    HashMap<String, HashMap<String, Integer>> bigramFrequency = new HashMap<>();
    HashMap<String, Integer> totalFrequency = new HashMap<>();    // Num of times this word comes before another

    public BigramGenerator(String[] trainingData) {
        countFrequency(trainingData);
    }

    private void countFrequency(String[] trainingData) {
        String previousWord = null;
        for (String word : trainingData) {

            if (previousWord != null) {
                HashMap<String, Integer> interMap = bigramFrequency.getOrDefault(previousWord, new HashMap<>());
                interMap.put(word, 1 + interMap.getOrDefault(word, 0));
                bigramFrequency.put(previousWord, interMap);
                totalFrequency.put(previousWord, 1 + totalFrequency.getOrDefault(previousWord, 0));
            }

            previousWord = word;
        }
    }

    public String[] generate(String initialWord, int length) {
        String[] sentence =  new String[length];
        String currentWord = initialWord;

        for (int i=0; i<length; i++){
            sentence[i] = currentWord;
            currentWord = nextWord(currentWord);
        }

        return sentence;
    }

    private String nextWord(String currentWord){
        Set<Map.Entry<String, Integer>> frequencySet = bigramFrequency.get(currentWord).entrySet();

        int randomNum = ThreadLocalRandom.current().nextInt(1, totalFrequency.get(currentWord) + 1);

        for (Map.Entry<String, Integer> entry : frequencySet) {
            randomNum -= entry.getValue();
            if (randomNum <= 0) return entry.getKey();
        }

        assert false;
        return null;
    }
}
