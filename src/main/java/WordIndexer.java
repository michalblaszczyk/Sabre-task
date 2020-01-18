import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordIndexer {

    public String indexLetterToWords(String sentence) {
        return Optional.ofNullable(sentence)
                .map(this::indexLetter)
                .orElseGet(() -> "");
    }

    public void printIndexedWords(String sentence){
        System.out.println(indexLetterToWords(sentence));
    }

    private String indexLetter(String sentence){
        sentence=sentence.replaceAll("[^A-Za-z ]","").toLowerCase();
        String[] arrayWords = sentence.split(" ");
        Map<Character, TreeSet<String>> mapWithCharacters = getMapWithAllLettersAsKey(sentence);
        new TreeSet<>(Arrays.asList(arrayWords)).forEach(word -> addWordToMap(mapWithCharacters, word));
        return mapToString(mapWithCharacters);

    }

    private Map<Character, TreeSet<String>> getMapWithAllLettersAsKey(String allCharacters) {
        return allCharacters
                .replaceAll(" ", "")
                .chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toMap(Function.identity(),
                        i -> new TreeSet<>(),
                        (prev,next) -> next,
                        TreeMap::new));
    }

    private String mapToString(final Map<Character,TreeSet<String>> indexedMap){
        return indexedMap
                .keySet()
                .stream()
                .map(key->key + ": " +indexedMap.get(key))
                .collect(Collectors.joining())
                .replaceAll("\\[","")
                .replaceAll("]","\n");

    }
    private void addWordToMap(Map<Character, TreeSet<String>> mapOfCharacters, String word) {
        word
                .chars()
                .distinct()
                .forEach(c -> addElementToMap(mapOfCharacters, word, (char) (c)));
    }

    private void addElementToMap(Map<Character, TreeSet<String>> mapOfCharacters, String word, Character c) {
        mapOfCharacters
                .getOrDefault(c, new TreeSet<>())
                .add(word);
    }

}
