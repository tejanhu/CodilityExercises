/*
 * This is my solution to exercise 2.
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

/**
 *
 * @author HusseinATejan
 */
public class PasswordValidator {

    //
    public static int solution(String S) {
        //creates substring array
        String someSubStrings[] = new String[S.length()];

        //regular expression to match password format
        String pattern = "(^[A-Z]|[$A-Za-z.[^0-9]]\\w)";

        //create a pattern object
        Pattern r = Pattern.compile(pattern);

        //create array to store each substrings' length
        int[] lengths = new int[someSubStrings.length];

        int biggestLength = -1;

        //iterate through String S to store substring
        for (int i = 0; i < S.length(); i++) {
            for (int j = 1; j <= someSubStrings.length - i; j++) {
                //store each substring of String S from position 1 to the last substring
                someSubStrings[i] = S.substring(i, i + j);
                //checks through array to find substrings that match format
                Matcher m = r.matcher(someSubStrings[i]);

                //if it matches store each substrings' length
                if (m.matches()) {
                    lengths[i] = someSubStrings[i].length();
                }
            }
        }

        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] > biggestLength) {
                biggestLength = lengths[i];
            }
        }

        return biggestLength;
    }

    public static void main(String[] args) {

        //alphanumeric text
        String S = "a0Ba";

        System.out.println(solution(S));

    }

}//END class
