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

        List<String> images = new ArrayList<>();
        // convert the input word to upper then break it into character use toCharArray()
        for (char c : word.toUpperCase().toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                images.add("/images/block_" + c + ".png");
            }
        }
        // Store the image path in the model
        model.addAttribute("images", images);
        return "word";
    }
}