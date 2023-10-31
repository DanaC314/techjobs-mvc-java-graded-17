package org.launchcode.techjobsmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    //ArrayList<Jobs> jobs;

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
@PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")) {
            jobs = JobData.findAll();
            model.addAttribute("title", "Jobs With" + ": " + searchType + ":");
            model.addAttribute("columns", columnChoices);
        }else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title","Jobs With All" + ":" + searchTerm);
            model.addAttribute("columns", columnChoices);
        }
        model.addAttribute("jobs",jobs);
        return "search";
}
}

