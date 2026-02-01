package sheridan.runze.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;
import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "redirect:/word";
    }

    @GetMapping("/word")
    public String wordPage() {
        return "word";
    }

    @PostMapping("/process")
    public String processWord(@RequestParam String word, Model model) {

        String trimmedWord = word.trim();

        // Validation: non-blank and length between 1-10
        if (trimmedWord.isEmpty() || trimmedWord.length() > 10) {
            model.addAttribute("error",
                    "Please enter between 1 and 10 characters.");
            return "word";
        }

        List<String> images = new ArrayList<>();

        // convert the input word to upper then break it into character use toCharArray()
        for (char c : trimmedWord.toUpperCase().toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                images.add("/images/block_" + c + ".png");
            } else {
                // Non-letter characters are replaced as spaces
                images.add("SPACE");
            }

        }
        // Store the image path in the model
        model.addAttribute("images", images);
        return "word";
    }

    @GetMapping("/reset")
    public String reset(Model model) {
        // Clear the images attribute so the page returns to its initial state
        model.addAttribute("images", null);
        return "word";
    }
}