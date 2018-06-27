package com.j4guanatos.MockitoTalk.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fgonzalez on 26/06/18.
 */
@RestController
public class CurrenciesController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloworld(){

        return "Hello world";
    }
}
