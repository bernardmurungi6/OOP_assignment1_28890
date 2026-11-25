package auca.abstracts;

import auca.exceptions.ValidationException;
import auca.interfaces.Identifiable;
import auca.interfaces.Validatable;

import java.time.LocalDate;

public abstract class TaxParty implements Identifiable, Validatable {
    private String partyId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public TaxParty(String partyId, String firstName, String lastName,
                    String email, String phoneNumber, LocalDate dateOfBirth) {
        this.partyId = partyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

//getters
    public String getPartyId() {
        return partyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    //setters
    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String getId() {
        return partyId;
    }

    @Override
    public String getDisplayName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public void validate() throws ValidationException {

            if (partyId == null ||
                    partyId.trim().length() < 4 ||
                    partyId.trim().length() > 30) {

                throw new ValidationException(
                        "Party ID must contain 4 to 30 characters");
            }


            if (firstName == null ||
                    firstName.trim().length() < 2 ||
                    firstName.trim().length() > 60) {

                throw new ValidationException(
                        "First name must contain 2 to 60 characters");
            }


            if (lastName == null ||
                    lastName.trim().length() < 2 ||
                    lastName.trim().length() > 60) {

                throw new ValidationException(
                        "Last name must contain 2 to 60 characters");
            }

            if (email == null ||
                    email.length() > 120 ||
                    !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

                throw new ValidationException("Invalid email address");
            }


            if (phoneNumber == null ||
                    !phoneNumber.matches("\\+?[0-9]{10,15}")) {

                throw new ValidationException(
                        "Phone must contain 10 to 15 digits");
            }

            if (dateOfBirth == null) {
                throw new ValidationException("Date of birth is required");
            }

            if (!dateOfBirth.isBefore(LocalDate.now())) {
                throw new ValidationException(
                        "Date of birth must be before today");
            }
        }

    }