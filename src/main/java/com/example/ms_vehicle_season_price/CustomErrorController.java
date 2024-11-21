package com.example.ms_vehicle_season_price;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public final class CustomErrorController implements ErrorController {

    /**
     * Handle the error.
     *
     * @return the error page
     */
    @RequestMapping("/error")
    public String handleError() {
        return "404";
    }
}