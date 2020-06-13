package com.ibm.mdm.model;

import javax.validation.ConstraintViolation;

public class ServiceConstraintViolation {

    private final String message;
    private final String property;
    private final String rootBeanClass;

    public ServiceConstraintViolation(ConstraintViolation<Service> violation) {
        this.message = violation.getMessage();
        this.property = violation.getPropertyPath().toString();
        this.rootBeanClass = violation.getRootBeanClass().toString();
    }

    public String getMessage() {
        return message;
    }

    public String getProperty() {
        return property;
    }

    public String getRootBeanClass() {
        return rootBeanClass;
    }
}
