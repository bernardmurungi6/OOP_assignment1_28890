package auca.taxclearance;

import auca.abstracts.RegisteredTaxpayer;
import auca.exceptions.ValidationException;
import auca.interfaces.Identifiable;
import auca.interfaces.Validatable;
import auca.revenueofficer.RevenueOfficer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TaxClearance implements Identifiable, Validatable {
    private String clearanceId;
    private RegisteredTaxpayer taxpayer;
    private LocalDate requestDate;
    private LocalDate expiryDate;
    private String status;
    private RevenueOfficer approvedBy;

    public TaxClearance(String clearanceId, RegisteredTaxpayer taxpayer, LocalDate requestDate,
                        LocalDate expiryDate, String status, RevenueOfficer approvedBy) {
        this.clearanceId = clearanceId;
        this.taxpayer = taxpayer;
        this.requestDate = requestDate;
        this.expiryDate = expiryDate;
        this.status = status;
        this.approvedBy = approvedBy;
    }

    public String getClearanceId() {
        return clearanceId;
    }

    public void setClearanceId(String clearanceId) {
        this.clearanceId = clearanceId;
    }

    public RegisteredTaxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(RegisteredTaxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RevenueOfficer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(RevenueOfficer approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Override
    public String getId() {
        return clearanceId;
    }

    @Override
    public String getDisplayName() {
        return "Clearance" + clearanceId;
    }

    @Override
    public boolean isActive() {
        return status.equalsIgnoreCase("Approved");
    }

    @Override
    public void validate() throws ValidationException {
        if(taxpayer == null){
            throw new ValidationException("Taxpayer is required");
        }
        if(requestDate == null || expiryDate == null){
            throw new ValidationException("Request date or expiry date are required");
        }

        if(!expiryDate.isAfter(requestDate)){
            throw new ValidationException("Request date must be after expiry date");
        }

        if(status.equalsIgnoreCase("Approved")){
            if(approvedBy == null || !approvedBy.isActive()){
                throw new ValidationException("Approved by is required");
            }
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Clearance ID: " + clearanceId);
        System.out.println("Taxpayer ID: " + taxpayer.getDisplayName());
        System.out.println("Request date : " + requestDate);
        System.out.println("Expiry date: " + expiryDate);
        System.out.println("Status: " + status);
        System.out.println("Approved by: " + approvedBy.getDisplayName());
    }

    @Override
    public String getSummary() {
        return clearanceId +"-" + status;
    }
}
