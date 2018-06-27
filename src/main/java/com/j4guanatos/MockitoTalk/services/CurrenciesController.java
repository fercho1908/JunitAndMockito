package com.j4guanatos.MockitoTalk.services;

import com.j4guanatos.banxico.exception.BanxicoException;
import com.j4guanatos.banxico.logic.BanxicoStubLogic;
import com.j4guanatos.banxico.logic.BanxicoStubLogicImpl;
import com.j4guanatos.banxico.model.ChangeType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fgonzalez on 26/06/18.
 */
@RestController
public class CurrenciesController {

    @RequestMapping(method = RequestMethod.GET)
    public List<ChangeType> helloworld(){
        BanxicoStubLogic  banxicoStubLogic = new BanxicoStubLogicImpl();
        try {
            return  banxicoStubLogic.findAdll();
        } catch (BanxicoException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
