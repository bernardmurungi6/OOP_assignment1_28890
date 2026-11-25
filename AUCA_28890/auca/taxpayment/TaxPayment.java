package auca.taxpayment;

import auca.exceptions.ValidationException;
import auca.interfaces.Identifiable;
import auca.interfaces.Validatable;
import auca.taxassesment.TaxAssessment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TaxPayment implements Identifiable, Validatable {
    private String paymentId;
    private TaxAssessment assessment;
    private String paymentReference;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentMethod;

    public TaxPayment(String paymentId, TaxAssessment assessment, String paymentReference,
                      BigDecimal amount, LocalDate paymentDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.assessment = assessment;
        this.paymentReference = paymentReference;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public TaxAssessment getAssessment() {
        return assessment;
    }

    public void setAssessment(TaxAssessment assessment) {
        this.assessment = assessment;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    @Override
    public String getId() {
        return paymentId;
    }

    @Override
    public String getDisplayName() {
        return "Tax Payment" + paymentId;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void validate() throws ValidationException {
        if (assessment == null) {
            throw new ValidationException("Assessment is required");
        }

        if (!assessment.getStatus().equals("Confirmed")) {
            throw new ValidationException("Assessment is not confirmed");
        }

        if (paymentReference == null ||
        paymentReference.trim().isEmpty()){
            throw new ValidationException("Payment Reference is required");
        }
        if(amount==null || amount.compareTo(BigDecimal.ZERO)<=0){
            throw new ValidationException("Amount required must be greater than zero");
        }

        if(paymentDate == null){
            throw new ValidationException("Payment Date is required");
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Assessment Id: " + paymentId);
        System.out.println("Assessment : " + assessment.getId());
        System.out.println("Payment Reference: " + paymentReference);
        System.out.println("Amount: " + amount);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Payment Method: " + paymentMethod);
    }

    @Override
    public String getSummary() {
        return paymentId + "-" + amount;
    }
}
