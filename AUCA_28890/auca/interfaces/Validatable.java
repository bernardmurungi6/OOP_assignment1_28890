package auca.interfaces;

import auca.exceptions.ValidationException;

public interface Validatable {
    void validate() throws ValidationException;
    void printDetails();
    String getSummary();

}
