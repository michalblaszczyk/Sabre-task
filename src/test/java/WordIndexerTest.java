import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordIndexerTest {

    public final WordIndexer indexer = new WordIndexer();

    @Test
    public void shouldReturnCorrectInput(){
        String inputText = "ala ma";
        String output="a:ala, ma\n" +
                "l:ala\n"+
                "m:ma";
        assertEquals(indexer.indexLetterToWords(inputText),output);
    }

    @Test
    public void shouldReturnCorrectString() {
        String inputText = "ala ma kota, kot koduje w Javie Kota";
        String output = "a: ala, javie, kota, ma\n" +
                "d: koduje\n" +
                "e: javie, koduje\n" +
                "i: javie\n" +
                "j: javie, koduje\n" +
                "k: koduje, kot, kota\n" +
                "l: ala\n" +
                "m: ma\n" +
                "o: koduje, kot, kota\n" +
                "t: kot, kota\n" +
                "u: koduje\n" +
                "v: javie\n" +
                "w: w\n";
        assertEquals(indexer.indexLetterToWords(inputText), output);
    }

    @Test
    public void nullShouldReturnEmptyString() {
        String inputText = null;
        String output = "";
        assertEquals(indexer.indexLetterToWords(inputText), output);
    }

    @Test
    public void emptySentenceShouldReturnEmptyString() {
        String inputText = "";
        String output = "";
        assertEquals(indexer.indexLetterToWords(inputText), output);
    }

    @Test
    public void whiteCharactersShouldReturnEmptyString() {
        String inputText = "   ,    ,,    ,,   ,  ";
        String output = "";
        assertEquals(indexer.indexLetterToWords(inputText), output);
    }
}
