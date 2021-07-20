package it.thealmighty.css.controller;

import javastrava.api.v3.auth.AuthorisationService;
import javastrava.api.v3.auth.impl.retrofit.AuthorisationServiceImpl;
import javastrava.api.v3.auth.model.Token;
import javastrava.api.v3.model.StravaAthlete;
import javastrava.api.v3.service.Strava;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/athlete")
    public StravaAthlete getAthlete(){
        AuthorisationService service = new AuthorisationServiceImpl();
        Token token = service.tokenExchange(63357, "77c5bce40da6257682d8693b9cb0ed59fa38b9a1", "WRITE");

        Strava strava = new Strava(token);
        StravaAthlete athlete = strava.getAthlete(63357);

        return athlete;
    }
}
