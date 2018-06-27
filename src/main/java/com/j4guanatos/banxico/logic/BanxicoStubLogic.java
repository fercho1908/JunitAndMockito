package com.j4guanatos.banxico.logic;


import com.j4guanatos.banxico.exception.BanxicoException;
import com.j4guanatos.banxico.model.ChangeType;
import com.j4guanatos.banxico.utils.CurrencyEnum;

import java.util.List;

/**
 * Created by prueba on 10/11/16.
 */
public interface BanxicoStubLogic {

    public ChangeType findBySerieNumber(CurrencyEnum currencyEnum) throws BanxicoException;

    public List<ChangeType> findByMultiSerie(List<CurrencyEnum> currencyEnums) throws BanxicoException;

    public List<ChangeType> findAdll() throws BanxicoException;
}
