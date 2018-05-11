package com.nsp.j2ee.core.converters.api;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationService
{
    public Set<ConstraintViolation<Object>> validate(Object object);
}
