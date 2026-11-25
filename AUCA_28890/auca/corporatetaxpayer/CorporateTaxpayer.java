package auca.corporatetaxpayer;

import auca.abstracts.RegisteredTaxpayer;
import auca.exceptions.ValidationException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CorporateTaxpayer extends RegisteredTaxpayer{
    private String companyRegistrationNo;
    private String legalName;
    private LocalDate incorporationDate;
    private String businessSector;
    private String authorizedRepresentative;
    private BigDecimal annualTurnover;

    public CorporateTaxpayer(String partyId, String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth,
                             String tin, LocalDate registrationDate, String taxpayerStatus, String district, String sector, String taxOffice,
                             String companyRegistrationNo, String legalName, LocalDate incorporationDate,
                             String businessSector, String authorizedRepresentative, BigDecimal annualTurnover) {
        super(partyId, firstName, lastName, email, phoneNumber, dateOfBirth, tin, registrationDate, taxpayerStatus, district, sector, taxOffice);
        this.companyRegistrationNo = companyRegistrationNo;
        this.legalName = legalName;
        this.incorporationDate = incorporationDate;
        this.businessSector = businessSector;
        this.authorizedRepresentative = authorizedRepresentative;
        this.annualTurnover = annualTurnover;
    }

    public String getCompanyRegistrationNo() {
        return companyRegistrationNo;
    }

    public String getLegalName() {
        return legalName;
    }

    public LocalDate getIncorporationDate() {
        return incorporationDate;
    }

    public String getBusinessSector() {
        return businessSector;
    }

    public String getAuthorizedRepresentative() {
        return authorizedRepresentative;
    }

    public BigDecimal getAnnualTurnover() {
        return annualTurnover;
    }


    @Override
    public void validate() throws ValidationException {
        super.validate();
        if (companyRegistrationNo == null ||
                !companyRegistrationNo.matches("[A-Z0-9-]{5,30}")) {
            throw new ValidationException("Company Registration No is invalid");
        }

        if (legalName == null ||
                legalName.trim().length() < 3 ||
                legalName.trim().length() > 120) {
            throw new ValidationException("Legal Name must contain 3 to 120 characters");
        }

        if (incorporationDate == null) {
            throw new ValidationException("Incorporation Date is required");
        }

        if (incorporationDate.isAfter(LocalDate.now())) {
            throw new ValidationException("Incorporation Date cannot be in the future");
        }

        if (!incorporationDate.isBefore(getRegistrationDate())) {
            throw new ValidationException("Incorporation Date must be before Registration Date");
        }

        if (businessSector == null || businessSector.trim().isEmpty()) {
            throw new ValidationException("Business Sector is required");
        }

        if (authorizedRepresentative == null ||
                authorizedRepresentative.trim().isEmpty()) {
            throw new ValidationException("Authorized Representative is required");
        }

        if (annualTurnover == null ||
                annualTurnover.compareTo(BigDecimal.ZERO) < 0 ||
                annualTurnover.compareTo(new BigDecimal("999999999999.99")) > 0 ||
                annualTurnover.scale() > 2) {
            throw new ValidationException("Annual Turnover is invalid");
        }
    }

    @Override
    public String getDisplayName() {
        return legalName;
    }

    @Override
    public void printDetails() {

        System.out.println("Company Registration No: " + companyRegistrationNo);
        System.out.println("Legal Name: " + legalName);
        System.out.println("Incorporation Date: " + incorporationDate);
        System.out.println("Business Sector: " + businessSector);
        System.out.println("Authorized Representative: " + authorizedRepresentative);
        System.out.println("Annual Turnover: " + annualTurnover);
    }

    @Override
    public String getSummary() {
        return "Corporate Taxpayer: "  + legalName + " | Tin: " + getTin();
    }
}
