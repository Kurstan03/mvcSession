package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

/**
 * @author kurstan
 * @created at 15.02.2023 12:05
 */
@Controller
@RequestMapping("/companies")
public class CompanyApi {
    private final CompanyService companyService;
    @Autowired
    public CompanyApi(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public String getAllCompanies(Model model){
        model.addAttribute("companies", companyService.getAllCompanies());
        return "main";
    }
    @GetMapping("/{id}")
    public String getCompanyById(@PathVariable("id") Long id, Model model){
        model.addAttribute("company", companyService.getCompanyById(id));
        return "company";
    }
    @GetMapping("/newCompany")
    public String createCompany(Model model) {
        model.addAttribute("newCompany", new Company());
        return "newCompany";
    }
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany") Company company){
        companyService.save(company);
        return "redirect:/companies";
    }
    @DeleteMapping("{companyId}/delete")
    public String deleteCompany(@PathVariable("companyId") Long id){
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }
    @GetMapping("/{companyId}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("company", companyService.getCompanyById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String updateCompany(@PathVariable("id") Long id,
                                @ModelAttribute("company") Company company){
        companyService.updateCompany(id, company);
        return "redirect:/companies";
    }
}
