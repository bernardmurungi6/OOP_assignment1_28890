package auca.abstracts;

import auca.exceptions.ValidationException;

import java.time.LocalDate;

public abstract class RegisteredTaxpayer extends TaxParty{
    private String tin;
    private LocalDate registrationDate;
    private String taxpayerStatus;
    private String district;
    private String sector;
    private String taxOffice;

    public RegisteredTaxpayer(String partyId, String firstName, String lastName, String email,
                              String phoneNumber, LocalDate dateOfBirth, String tin, LocalDate registrationDate,
                              String taxpayerStatus, String district, String sector, String taxOffice) {
        super(partyId, firstName, lastName, email, phoneNumber, dateOfBirth);
        this.tin = tin;
        this.registrationDate = registrationDate;
        this.taxpayerStatus = taxpayerStatus;
        this.district = district;
        this.sector = sector;
        this.taxOffice = taxOffice;
    }


    public String getTin() {
        return tin;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getTaxpayerStatus() {
        return taxpayerStatus;
    }

    public String getDistrict() {
        return district;
    }

    public String getSector() {
        return sector;
    }

    public String getTaxOffice() {
        return taxOffice;
    }


    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setTaxpayerStatus(String taxpayerStatus) {
        this.taxpayerStatus = taxpayerStatus;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setTaxOffice(String taxOffice) {
        this.taxOffice = taxOffice;
    }


    @Override
    public boolean isActive() {
        return taxpayerStatus.equals("Active");
    }

    @Override
    public void validate() throws ValidationException {
        super.validate();
        if ( tin == null || !tin.matches("[0-9]{5}")){
            throw new ValidationException("TIN must contain 5 digits");
        }

        if (registrationDate == null){
            throw new ValidationException("Registration Date must not be null");
        }
        if (!isActive() &&
         !taxpayerStatus.equals("Inactive")){
            throw new ValidationException("Taxpayer status must be active");
        }
    }

    @Override
    public void printDetails() {

        System.out.println("TIN: " + tin);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Taxpayer Status: " + taxpayerStatus);
        System.out.println("District: " + district);
        System.out.println("Sector: " + sector);
        System.out.println("Tax Office: " + taxOffice);
    }

    @Override
    public String getSummary() {
        return getDisplayName() + " - TIN: " +tin;
    }
}
