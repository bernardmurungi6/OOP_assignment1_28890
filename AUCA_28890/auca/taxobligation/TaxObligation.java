package auca.taxobligation;

import auca.abstracts.RegisteredTaxpayer;
import auca.exceptions.ValidationException;
import auca.interfaces.Identifiable;
import auca.interfaces.Validatable;
import auca.taxtype.TaxType;

import java.time.LocalDate;

public class TaxObligation implements Identifiable, Validatable {
    private String obligationId;
    private RegisteredTaxpayer taxpayer;
    private TaxType taxType;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private LocalDate dueDate;

    public TaxObligation(String obligationId, RegisteredTaxpayer taxpayer, TaxType taxType, LocalDate periodStart,
                         LocalDate periodEnd, LocalDate dueDate) {
        this.obligationId = obligationId;
        this.taxpayer = taxpayer;
        this.taxType = taxType;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.dueDate = dueDate;

    }

    public String getObligationId() {
        return obligationId;
    }

    public void setObligationId(String obligationId) {
        this.obligationId = obligationId;
    }

    public RegisteredTaxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(RegisteredTaxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public TaxType getTaxType() {
        return taxType;
    }

    public void setTaxType(TaxType taxType) {
        this.taxType = taxType;
    }

    public LocalDate getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public LocalDate getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(LocalDate periodEnd) {
        this.periodEnd = periodEnd;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String getId() {
        return obligationId;
    }

    @Override
    public String getDisplayName() {
        return "Tax Obligation" + obligationId;
    }

    @Override
    public boolean isActive() {
        return taxpayer !=null && taxpayer.isActive()
         && taxType != null && taxType.isActive();
    }

    @Override
    public void validate() throws ValidationException {
        if(taxpayer == null || taxType ==null){
            throw new ValidationException("taxpayer or taxType are required");
        }

        if( !isActive()){
            throw new ValidationException("inactive taxpayer or taxType");
        }

        if(periodStart == null || periodEnd == null || dueDate == null){
            throw new ValidationException("All dates are required");
        }

        if(periodStart.isAfter(periodEnd)){
            throw new ValidationException("invalid tax period");
        }

        if (dueDate.isBefore(periodEnd)) {
            throw new ValidationException("Due date cannot be before period end");
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Tax Obligation: " + obligationId);
        System.out.println("Tax Type: " + taxpayer.getDisplayName());
        System.out.println("Tax Type: " + taxType.getTaxName());
        System.out.println("Period Start: " + periodStart);
        System.out.println("Period End: " + periodEnd);
        System.out.println("Due Date: " + dueDate);


    }

    @Override
    public String getSummary() {
        return obligationId +"-"+ taxType.getTaxName();
    }
}