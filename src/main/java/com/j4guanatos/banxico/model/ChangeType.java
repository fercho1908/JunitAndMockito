package com.j4guanatos.banxico.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by prueba on 10/11/16.
 */
public class ChangeType {

    private BigDecimal changeValue;
    private Date queryDate;
    private String description;
    private String currency;

    public BigDecimal getChangeValue() {
        return changeValue;
    }

    public void setChangeValue(BigDecimal changeValue) {
        this.changeValue = changeValue;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangeType that = (ChangeType) o;

        if (changeValue != null ? !changeValue.equals(that.changeValue) : that.changeValue != null) return false;
        if (queryDate != null ? !queryDate.equals(that.queryDate) : that.queryDate != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return !(currency != null ? !currency.equals(that.currency) : that.currency != null);

    }

    @Override
    public int hashCode() {
        int result = changeValue != null ? changeValue.hashCode() : 0;
        result = 31 * result + (queryDate != null ? queryDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChangeType{" +
                "changeValue=" + changeValue +
                ", queryDate=" + queryDate +
                ", description='" + description + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
