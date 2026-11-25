package auca.taxtype;

import auca.exceptions.ValidationException;
import auca.interfaces.Identifiable;
import auca.interfaces.Validatable;

import java.math.BigDecimal;

public class TaxType implements Identifiable, Validatable {
    private String taxTypeId;
    private String taxCode;
    private String taxName;
    private BigDecimal rate;
    private String fillingFrequency;
    private boolean active;

    public TaxType(String taxTypeId, String taxCode, String taxName,
                   BigDecimal rate, String fillingFrequency, boolean active) {
        this.taxTypeId = taxTypeId;
        this.taxCode = taxCode;
        this.taxName = taxName;
        this.rate = rate;
        this.fillingFrequency = fillingFrequency;
        this.active = active;
    }

    public String getTaxTypeId() {
        return taxTypeId;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public String getTaxName() {
        return taxName;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public String getFillingFrequency() {
        return fillingFrequency;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public String getId() {
        return taxTypeId;
    }

    @Override
    public String getDisplayName() {
        return taxName;
    }

    @Override
    public void validate() throws ValidationException {
        if (taxTypeId == null || taxTypeId.trim().isEmpty()) {
            throw new ValidationException("Tax Type ID cannot be empty");
        }

        if( taxName == null || taxName.trim().isEmpty()){
            throw new ValidationException("Tax Name cannot be empty");
        }

        if (rate == null || rate.compareTo(BigDecimal.ZERO) < 0
        || rate.compareTo(new BigDecimal("100")) >0 ) {
            throw new ValidationException("Rate must be between 0 and 100");
        }

        if ( ! fillingFrequency.equals("Monthly") && ! fillingFrequency.equals("Quarterly")
        && ! fillingFrequency.equals("Annual") ){
            throw new ValidationException("Filling Frequency must be either Monthly or Quarterly");
        }


    }

    @Override
    public void printDetails() {
        System.out.println("Tax Type ID: " + taxTypeId);
        System.out.println("Tax Code: " + taxCode);
        System.out.println("Tax Name: " + taxName);
        System.out.println("Rate: " + rate);
        System.out.println("Filling Frequency: " + fillingFrequency);
        System.out.println("Active: " + active);
    }

    @Override
    public String getSummary() {

        return taxName + "-" +rate +"%";
    }
}
