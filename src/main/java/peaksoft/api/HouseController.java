package peaksoft.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kurstan
 * @created at 14.02.2023 12:38
 */
@Controller
@RequestMapping("/house")
public class HouseController {
    @GetMapping()
    public String getAllHouses(){
        return "index";
    }
    @GetMapping("/getDescription")
    public String getDescription(){
        return "index2";
    }
}
