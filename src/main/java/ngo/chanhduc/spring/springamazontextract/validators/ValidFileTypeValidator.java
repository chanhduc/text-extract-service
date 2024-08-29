package ngo.chanhduc.spring.springamazontextract.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ngo.chanhduc.spring.springamazontextract.annotations.ValidFileType;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Chanh-Duc Ngo
 * @created-date 28/08/2024
 */
public class ValidFileTypeValidator implements
        ConstraintValidator<ValidFileType, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null) {
            return false;
        }
        String contentType = file.getContentType();
        return contentType.equals("image/png") || contentType.equals("image/jpeg") ||
                contentType.equals("image/tiff") || contentType.equals("application/pdf");
    }
}
