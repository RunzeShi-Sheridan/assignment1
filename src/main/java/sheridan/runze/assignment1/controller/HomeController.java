package sheridan.runze.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}