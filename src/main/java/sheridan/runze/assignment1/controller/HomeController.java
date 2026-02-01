package sheridan.runze.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import sheridan.runze.assignment1.logic.WordBlockLogic;
import java.util.List;

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

        // Validation handled by logic class
        if (!WordBlockLogic.isValid(trimmedWord)) {
            model.addAttribute("error",
                    "Please enter between 1 and 10 characters.");
            return "word";
        }

        List<String> images =
                WordBlockLogic.buildImageList(trimmedWord);

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