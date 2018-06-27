package com.j4guanatos.banxico.logic;

import com.j4guanatos.banxico.exception.BanxicoException;
import com.j4guanatos.banxico.model.ChangeType;
import com.j4guanatos.banxico.stub.ws.DgieWSPortSoapBindingStub;
import com.j4guanatos.banxico.utils.CurrencyEnum;
import com.j4guanatos.banxico.utils.Formats;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by prueba on 10/11/16.
 */
public class BanxicoStubLogicImpl implements BanxicoStubLogic {

    @Override
    public ChangeType findBySerieNumber(CurrencyEnum currencyEnum) throws BanxicoException {
        try {
            String result = consumeService();
            return procesarTexto(result, currencyEnum);
        } catch (MalformedURLException e) {
            throw new BanxicoException(e.getMessage(), e);
        } catch (RemoteException e) {
            throw new BanxicoException(e.getMessage(), e);
        }
    }

    @Override
    public List<ChangeType> findByMultiSerie(List<CurrencyEnum> currencyEnums) throws BanxicoException {
        try {
            String result = consumeService();
            List<ChangeType> changeTypes = new ArrayList<>();
            for (CurrencyEnum currencyEnum : currencyEnums) {
                changeTypes.add(procesarTexto(result, currencyEnum));
            }
            return changeTypes;
        } catch (MalformedURLException e) {
            throw new BanxicoException(e.getMessage(), e);
        } catch (RemoteException e) {
            throw new BanxicoException(e.getMessage(), e);
        }
    }

    @Override
    public List<ChangeType> findAdll() throws BanxicoException {
        try {
            String result = consumeService();
            List<ChangeType> changeTypes = new ArrayList<>();
            for (CurrencyEnum currencyEnum : CurrencyEnum.values()) {
                changeTypes.add(procesarTexto(result, currencyEnum));
            }
            return changeTypes;
        } catch (MalformedURLException e) {
            throw new BanxicoException(e.getMessage(), e);
        } catch (RemoteException e) {
            throw new BanxicoException(e.getMessage(), e);
        }
    }

    private String consumeService() throws MalformedURLException, RemoteException {
        URL url = new URL("http://www.banxico.org.mx/DgieWSWeb/DgieWS?WSDL");
        DgieWSPortSoapBindingStub dgieWSPortSoapBindingStub = new DgieWSPortSoapBindingStub(url, null);
        dgieWSPortSoapBindingStub.setTimeout(10000);
        String result = dgieWSPortSoapBindingStub.tiposDeCambioBanxico();
        return result;
    }

    private String getRegex(String IDSerie) {
        return "<bm:Series\\s++TITULO\\s*+=\\s*+\"(?<titulo>[^\"]*+)\""
                + "\\s++IDSERIE\\s*+=\\s*+\"" + IDSerie + "\"[^>]*+>"
                + "\\s*+<bm:Obs\\s++TIME_PERIOD\\s*+=\\s*+\"(?<fecha>[^\"]*+)\""
                + "\\s++OBS_VALUE\\s*+=\\s*+\"(?<cotizacion>[^\"]*)";
    }

    private ChangeType procesarTexto(final String uxml, CurrencyEnum currencyEnum) throws BanxicoException {
        // Sacar las entities
        //  (se rompe el XML pero es mas facil procesarlo directamente)
        String xml = unescapeCommonEntities(uxml);

        // Obtener los campos buscados con una expresion regular sobre todo el xml
        Pattern idPatt = Pattern.compile(this.getRegex(currencyEnum.getSerieId()));
        Matcher m = idPatt.matcher(xml);
        if (!m.find()) {
            throw new BanxicoException("Information Not found");
        }
        ChangeType changeType = new ChangeType();
        changeType.setChangeValue(new BigDecimal(m.group("cotizacion")));
        try {
            changeType.setQueryDate(this.parseStringDate(m.group("fecha")));
        } catch (ParseException e) {
            throw new BanxicoException(e.getMessage(), e);
        }
        changeType.setDescription(Formats.removeSpace(m.group("titulo")));
        changeType.setCurrency(currencyEnum.getCurrency());
        return changeType;
    }

    private String unescapeCommonEntities(final String xmle) {
        return xmle.replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">")
                .replaceAll("&amp;", "&")
                .replaceAll("&apos;", "'")
                .replaceAll("&quot;", "\"");
    }

    private Date parseStringDate(String stringDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(stringDate);
        return date;
    }

}
