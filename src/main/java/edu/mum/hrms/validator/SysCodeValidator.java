package edu.mum.hrms.validator;


import org.springframework.validation.Errors;

import edu.mum.hrms.model.SysCode;
import edu.mum.hrms.util.LcfValidationUtils;

public class SysCodeValidator extends LcfBaseValidator<SysCode>  {

    public void validate(Object obj, Errors errors) {
    	LcfValidationUtils.validateString(errors, "theKey");
    	LcfValidationUtils.validateInteger(errors, "seq");
    	LcfValidationUtils.validateIntMinAndMax(errors, "seq",1,200);
    }
}