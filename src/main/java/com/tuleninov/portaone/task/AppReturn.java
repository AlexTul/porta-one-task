package com.tuleninov.portaone.task;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppReturn implements Returnable {

    private static final Logger log = LoggerFactory.getLogger(AppReturn.class);

    /**
     * The method accepts an arbitrary text as input and finds in each word of this text
     * the very first symbol that is no longer repeated in the analyzed word.
     * From the received set of characters, the method selects the first unique character
     * (that is, the one that no longer occurs in the set) and returns it.
     *
     * @param text an arbitrary text
     * @return the first unique character
     */
    @Override
    public char returnFirstUniqueChar(String text) {
        if (text == null || text.isEmpty() || text.isBlank()) {
            log.error("The text must be non-null, non-empty, must not contains only white space codepoints.");
            throw new IllegalStateException("""
                    The text must be non-null, non-empty, must not contains only white space codepoints.
                    """);
        }

        Map<Character, Integer> word = new LinkedHashMap<>();
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                putFirstUniqueChar(word, ch);
            } else {
                if (!word.isEmpty()) {
                    var firstKeyWord = getFirstCharFromCollection(word);
                    putFirstUniqueChar(chars, firstKeyWord);
                    word.clear();
                }
            }
        }

        return getFirstCharFromCollection(chars);
    }

    /**
     * The method returns the first character from collection.
     *
     * @param word the collection
     * @return the first unique character
     */
    private Character getFirstCharFromCollection(Map<Character, Integer> word) {
        return word.entrySet().iterator().next().getKey();
    }

    /**
     * The method puts the character from collection.
     *
     * @param collection the collection
     * @param ch         the character
     */
    private void putFirstUniqueChar(Map<Character, Integer> collection, char ch) {
        if (collection.get(ch) != null) {
            collection.remove(ch);
        } else {
            collection.put(ch, 1);
        }
    }
}
