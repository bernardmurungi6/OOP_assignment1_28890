package auca.individualtaxpayer;

import auca.abstracts.RegisteredTaxpayer;
import auca.exceptions.ValidationException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IndividualTaxpayer extends  RegisteredTaxpayer {
    private String nationalId;
    private String occupation;
    private String businessName;
    private LocalDate businessDate;
    private BigDecimal annualTurnover;
    private boolean resident;

    public IndividualTaxpayer(String partyId, String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, String tin, LocalDate registrationDate,
                              String taxpayerStatus, String district, String sector, String taxOffice, String nationalId, String occupation, String businessName, LocalDate businessDate, BigDecimal annualTurnover, boolean resident) {
        super(partyId, firstName, lastName, email, phoneNumber, dateOfBirth, tin, registrationDate, taxpayerStatus, district, sector, taxOffice);
        this.nationalId = nationalId;
        this.occupation = occupation;
        this.businessName = businessName;
        this.businessDate = businessDate;
        this.annualTurnover = annualTurnover;
        this.resident = resident;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getBusinessName() {
        return businessName;
    }

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public BigDecimal getAnnualTurnover() {
        return annualTurnover;
    }

    public boolean isResident() {
        return resident;
    }


    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public void setAnnualTurnover(BigDecimal annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }


    @Override
    public void validate() throws ValidationException {
        super.validate();

        if (nationalId == null || !nationalId.matches("[0-9]{16}")) {
            throw new ValidationException("National ID must contain 16 digits");
        }

        if (occupation == null || occupation.trim().isEmpty()) {
            throw new ValidationException("Occupation is required");
        }

        if (annualTurnover == null ||
                annualTurnover.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Annual turnover cannot be negative");
        }

        if (businessDate == null) {
            throw new ValidationException("Business date is required");
        }
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("NationalId: " + nationalId);
        System.out.println("Occupation: " + occupation);
        System.out.println("BusinessName: " + businessName);
        System.out.println("BusinessDate: " + businessDate);
        System.out.println("AnnualTurnover: " + annualTurnover);
        System.out.println("Resident: " + resident);
    }

    @Override
    public String getDisplayName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String getSummary() {
        return "Individual Taxpayer: "  + getDisplayName() + " | Tin:" + getTin();

    }
}
