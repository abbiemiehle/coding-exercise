import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CodingExercise {

    public static void main(String[] args) {
        // print results for example usage of aboveBelow method
        Map<String, Long> aboveBelowExample = aboveBelow(Arrays.asList(1, 5, 2, 1, 10), 6);
        System.out.println(aboveBelowExample);

        // print results for example usage of stringRotation method
        String stringRotationExample = stringRotation("MyString", 2);
        System.out.println(stringRotationExample);
    }

    /*
        Take an unsorted list of integers and an integer to use as a comparison value, then return
        a map with keys "above" and "below" with the values being the corresponding number of integers
        in the list that are above and below the comparison value.
    */
    public static Map<String, Long> aboveBelow(List<Integer> numList, int compValue) {
        // use streams to count how many integers in the list are above or below comparison value
        long above = numList.stream().filter(num -> num > compValue).count();
        long below = numList.stream().filter(num -> num < compValue).count();

        // return the map of calculated above and below counts
        return Map.of(
                "above", above,
                "below", below
        );
    }


    /*
        Take a string and a positive integer to use as the rotation amount, then return a new string with
        the characters in the original string rotated right by the rotation amount. Overflow past the end
        of the string will rotate around and appear at the front of the new string.
    */
    public static String stringRotation(String originalString, int rotateAmt) {
        // if rotation amount is negative, print error message and return empty string
        if (rotateAmt < 0) {
            System.err.println("Rotation Amount must be a positive value.");
            return "";
        }

        // if rotation amount is bigger than length of string, subtract length to prevent out of bounds error
        if (rotateAmt > originalString.length()) {
            rotateAmt -= originalString.length();
        }

        // determine the index where the characters in the string will need to wrap around to the beginning
        int splitIndex = originalString.length() - rotateAmt;

        // get substrings of string on either side of calculated index, with index being included in beginning
        String beginning = originalString.substring(splitIndex);
        String end = originalString.substring(0, splitIndex);

        // return substrings concatenated together
        return beginning + end;
    }
}
