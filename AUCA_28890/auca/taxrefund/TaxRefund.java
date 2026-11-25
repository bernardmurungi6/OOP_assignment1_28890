package auca.taxrefund;

import auca.abstracts.RegisteredTaxpayer;
import auca.exceptions.ValidationException;
import auca.interfaces.Identifiable;
import auca.interfaces.Validatable;
import auca.taxassesment.TaxAssessment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TaxRefund implements Identifiable , Validatable {
    private String refundId;
    private RegisteredTaxpayer taxpayer;
    private TaxAssessment assessment;
    private BigDecimal requestedAmount;
    private LocalDate requestDate;
    private String status;

    public TaxRefund(String refundId, RegisteredTaxpayer taxpayer, TaxAssessment assessment,
                     BigDecimal requestedAmount, LocalDate requestDate, String status) {
        this.refundId = refundId;
        this.taxpayer = taxpayer;
        this.assessment = assessment;
        this.requestedAmount = requestedAmount;
        this.requestDate = requestDate;
        this.status = status;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public RegisteredTaxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(RegisteredTaxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public TaxAssessment getAssessment() {
        return assessment;
    }

    public void setAssessment(TaxAssessment assessment) {
        this.assessment = assessment;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String getId() {
        return refundId;
    }

    @Override
    public String getDisplayName() {
        return "Refund" + refundId;
    }

    @Override
    public boolean isActive() {
        return status.equalsIgnoreCase("Pending");
    }

    @Override
    public void validate() throws ValidationException {
        if (taxpayer == null || assessment == null) {
            throw new ValidationException("Taxpayer and assessment are required");
        }
        if (requestedAmount == null || requestedAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("invalid requested amount");
        }
        if(!taxpayer.isActive()) {
            throw new ValidationException("Taxpayer is not active");
        }

        if(requestDate == null){
            throw new ValidationException("request date is required");
        }

    }

    @Override
    public void printDetails() {
        System.out.println("Refund Id: " + refundId);
        System.out.println("Taxpayer: " + taxpayer.getDisplayName());
        System.out.println("Assessment: " + assessment.getId());
        System.out.println("Requested Amount: " + requestedAmount);
        System.out.println("Request Date: " + requestDate);
        System.out.println("Status: " + status);
    }

    @Override
    public String getSummary() {
        return refundId +"-" + requestedAmount +"-" + status;
    }
}
