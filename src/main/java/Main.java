import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        String test = "ala ma kota, kot koduje w Javie Kota";
        new WordIndexer().printIndexedWords(test);

        }

}
