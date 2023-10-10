package com.luv2code.springdemo.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
    private String firstName;
    /*
     * With this annotation we make this
     * field required for the model.
     * */
    @NotNull(message = "Is required")
    @Size(min = 1, message = "Is required") // Set the minimum length
    private String lastName;

    @NotNull(message = "Is required")
    @Min(value = 0, message = "Must be greater than or equal to zero")
    @Max(value = 10, message = "Must be less than or equal to ten")
    //private int freePasses;

    /*
    * +------------------------------+
    * | MAKE AN INPUT FIELD REQUIRED |
    * +------------------------------+
    *
    * We don't have to use int because is a primitive type,
    * so we must use the related class to the type, because
    * if the value is sent with anything the trim method converted
    * into null, so this VI can save null as a reference to nothing.
    * */
    private Integer freePasses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }
}
