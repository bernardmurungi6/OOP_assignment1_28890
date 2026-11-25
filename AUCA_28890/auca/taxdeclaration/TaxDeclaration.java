package auca.taxdeclaration;

import auca.exceptions.ValidationException;
import auca.interfaces.Identifiable;
import auca.interfaces.Validatable;
import auca.taxobligation.TaxObligation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TaxDeclaration implements Identifiable, Validatable {
    private String declarationId;
    private TaxObligation obligation;
    private LocalDate fillingDate;
    private BigDecimal taxableAmount;
    private BigDecimal declaredTax;
    private String status;

    public TaxDeclaration(String declarationId, TaxObligation obligation, LocalDate fillingDate,
                          BigDecimal taxableAmount, BigDecimal declaredTax, String status) {
        this.declarationId = declarationId;
        this.obligation = obligation;
        this.fillingDate = fillingDate;
        this.taxableAmount = taxableAmount;
        this.declaredTax = declaredTax;
        this.status = status;
    }

    public String getDeclarationId() {
        return declarationId;
    }

    public void setDeclarationId(String declarationId) {
        this.declarationId = declarationId;
    }

    public TaxObligation getObligation() {
        return obligation;
    }

    public void setObligation(TaxObligation obligation) {
        this.obligation = obligation;
    }

    public LocalDate getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(LocalDate fillingDate) {
        this.fillingDate = fillingDate;
    }

    public BigDecimal getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public BigDecimal getDeclaredTax() {
        return declaredTax;
    }

    public void setDeclaredTax(BigDecimal declaredTax) {
        this.declaredTax = declaredTax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String getId() {
        return declarationId;
    }

    @Override
    public String getDisplayName() {
        return "Declaration" + declarationId;
    }

    @Override
    public boolean isActive() {
        return status.equalsIgnoreCase("Pending")
                || status.equalsIgnoreCase("Late");
    }

    @Override
    public void validate() throws ValidationException {
        if( obligation == null && fillingDate == null){
            throw new ValidationException("Obligation and fillingDate are mandatory");
        }

        if( taxableAmount == null || taxableAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new ValidationException("Invalid Taxable amount");
        }

        if( declaredTax == null || declaredTax.compareTo(BigDecimal.ZERO) < 0){
            throw new ValidationException("Invalid declared tax");
        }

    }

    @Override
    public void printDetails() {
        System.out.println("Declaration: " + declarationId);
        System.out.println("Obligation: " + obligation);
        System.out.println("FillingDate: " + fillingDate);
        System.out.println("TaxableAmount: " + taxableAmount);
        System.out.println("DeclaredTax: " + declaredTax);
        System.out.println("Status: " + status);

    }

    @Override
    public String getSummary() {
        return "Declaration" + declarationId + "-" + status;
    }
}
