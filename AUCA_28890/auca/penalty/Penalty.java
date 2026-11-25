package auca.penalty;

import auca.exceptions.ValidationException;
import auca.interfaces.Identifiable;
import auca.interfaces.Validatable;
import auca.taxobligation.TaxObligation;

import java.math.BigDecimal;

public class Penalty implements Identifiable, Validatable {
    private String penaltyId;
    private TaxObligation obligation;
    private String penaltyType;
    private BigDecimal baseAmount;
    private BigDecimal penaltyRate;
    private BigDecimal penaltyAmount;

    public Penalty(String penaltyId, TaxObligation obligation, String penaltyType,
                   BigDecimal baseAmount, BigDecimal penaltyRate, BigDecimal penaltyAmount) {
        this.penaltyId = penaltyId;
        this.obligation = obligation;
        this.penaltyType = penaltyType;
        this.baseAmount = baseAmount;
        this.penaltyRate = penaltyRate;
        this.penaltyAmount = penaltyAmount;
    }

    public String getPenaltyId() {
        return penaltyId;
    }

    public void setPenaltyId(String penaltyId) {
        this.penaltyId = penaltyId;
    }

    public TaxObligation getObligation() {
        return obligation;
    }

    public void setObligation(TaxObligation obligation) {
        this.obligation = obligation;
    }

    public String getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BigDecimal getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(BigDecimal penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public BigDecimal getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(BigDecimal penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public void calculatePenalty() {
        penaltyAmount= baseAmount.multiply(penaltyRate)
                .divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public String getId() {
        return penaltyId;
    }

    @Override
    public String getDisplayName() {
        return "Penalty" + penaltyId;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void validate() throws ValidationException {
        if (obligation == null) {
            throw new ValidationException("Require obligation");
        }
        if (baseAmount ==null || baseAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Base amount must be greater than zero");
        }
        if(penaltyRate == null || penaltyRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Penalty rate is invalid");
        }
        calculatePenalty();
    }

    @Override
    public void printDetails() {
        System.out.println("Penalty ID: " + penaltyId);
        System.out.println("obligation: " + obligation);
        System.out.println("Penalty Type: " + penaltyType);
        System.out.println("Base Amount: " + baseAmount);
        System.out.println("Penalty Rate: " + penaltyRate);
        System.out.println("Penalty Amount: " + penaltyAmount);
    }

    @Override
    public String getSummary() {
        return penaltyId +" -Penalty" + penaltyRate;
    }
}
