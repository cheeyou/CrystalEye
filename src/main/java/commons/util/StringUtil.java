package commons.util;

import static java.util.Objects.requireNonNull;

/**
 * Helper functions for handling strings
 */
public class StringUtil {
    /*
     * Returns true if the (@code sentence) contains the (@code phrase).
     * Ignores case
     * @param sentence cannot be null
     * @param word cannot be null, cannot be empty
     */
    public static boolean containsPhraseIgnoreCase(String sentence, String phrase) {
        requireNonNull(sentence);
        requireNonNull(phrase);

        String preppedPhrase = phrase.trim().toLowerCase();
        AppUtil.checkArgument(!preppedPhrase.isEmpty(), "phrase parameter cannot be empty");

        String preppedSentence = sentence.toLowerCase();

        return preppedSentence.contains(preppedPhrase);
    }
}
