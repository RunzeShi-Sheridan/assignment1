package sheridan.runze.assignment1.logic;

import java.util.ArrayList;
import java.util.List;

public class WordBlockLogic {

    public static boolean isValid(String word) {
        return word != null && !word.isBlank() && word.length() <= 10;
    }

    public static List<String> buildImageList(String word) {
        List<String> images = new ArrayList<>();

        for (char c : word.toUpperCase().toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                images.add("/images/block_" + c + ".png");
            } else {
                images.add("SPACE");
            }
        }
        return images;
    }
}