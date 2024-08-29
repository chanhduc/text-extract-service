package ngo.chanhduc.spring.springamazontextract.annotations;

import jakarta.validation.Constraint;
import ngo.chanhduc.spring.springamazontextract.validators.ValidFileTypeValidator;

import java.lang.annotation.*;

/**
 * @author Chanh-Duc Ngo
 * @created-date 28/08/2024
 */
@Documented
@Constraint(validatedBy = ValidFileTypeValidator.class)
@Target( { ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFileType {
    String message() default "Invalid file type. Only PNG, JPEG, TIFF and PDF are allowed.";
    Class<?>[] groups () default {};
    Class<? extends jakarta.validation.Payload>[] payload() default {};
}
