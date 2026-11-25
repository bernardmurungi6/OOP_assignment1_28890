package auca.taxassesment;

import auca.exceptions.ValidationException;
import auca.interfaces.Identifiable;
import auca.interfaces.Validatable;
import auca.taxdeclaration.TaxDeclaration;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TaxAssessment implements Identifiable, Validatable {
    private String assessmentId;
    private TaxDeclaration declaration;
    private BigDecimal assessedTax;
    private BigDecimal adjustmentAmount;
    private LocalDate assessmentDate;
    private String status;

    public TaxAssessment(String assessmentId, TaxDeclaration declaration, BigDecimal assessedTax,
                         BigDecimal adjustmentAmount, LocalDate assessmentDate, String status) {
        this.assessmentId = assessmentId;
        this.declaration = declaration;
        this.assessedTax = assessedTax;
        this.adjustmentAmount = adjustmentAmount;
        this.assessmentDate = assessmentDate;
        this.status = status;
    }

    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public TaxDeclaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(TaxDeclaration declaration) {
        this.declaration = declaration;
    }

    public BigDecimal getAssessedTax() {
        return assessedTax;
    }

    public void setAssessedTax(BigDecimal assessedTax) {
        this.assessedTax = assessedTax;
    }

    public BigDecimal getAdjustmentAmount() {
        return adjustmentAmount;
    }

    public void setAdjustmentAmount(BigDecimal adjustmentAmount) {
        this.adjustmentAmount = adjustmentAmount;
    }

    public LocalDate getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(LocalDate assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public BigDecimal getTotal(){
        return assessedTax.add(adjustmentAmount);
    }

    @Override
    public String getId() {
        return assessmentId;
    }

    @Override
    public String getDisplayName() {
        return "Assessment " + assessmentId;
    }

    @Override
    public boolean isActive() {
        return status.equalsIgnoreCase("Draft")
                || status.equalsIgnoreCase("Confirmed");
    }

    @Override
    public void validate() throws ValidationException {
        if (declaration == null){
            throw new ValidationException("Declaration is null");
        }
        if (assessedTax == null || adjustmentAmount == null){
            throw new ValidationException("Tax assessment is required");
        }

        if (assessmentDate == null){
            throw new ValidationException("Assessment date is required");
        }

        if (!status.equals("Draft") && !status.equals("Confirmed")
        && !status.equals("Cancelled")){
            throw new ValidationException("Assessment status is not valid");
        }

        if(getTotal().compareTo(BigDecimal.ZERO) < 0){
            throw new ValidationException("Tax assessment total cannot negative");
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Assessment Id: " + assessmentId);
        System.out.println("Declaration: " + declaration);
        System.out.println("Assessed Tax: " + assessedTax);
        System.out.println("Adjustment Amount: " + adjustmentAmount);
        System.out.println("Total Amount: " + getTotal());
        System.out.println("Assessment Date: " + assessmentDate);
        System.out.println("Status: " + status);
    }

    @Override
    public String getSummary() {
        return assessmentId + "-" + declaration.getDisplayName();
    }
}
