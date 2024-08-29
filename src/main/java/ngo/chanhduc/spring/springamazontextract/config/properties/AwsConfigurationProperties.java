package ngo.chanhduc.spring.springamazontextract.config.properties;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @author Chanh-Duc Ngo
 * @created-date 28/08/2024
 */
@Validated
@ConfigurationProperties(prefix = "ngo.chanhduc.aws")
public class AwsConfigurationProperties {

    @NotBlank
    private String region;

    @NotBlank
    private String accessKey;

    @NotBlank
    private String secretKey;

    public @NotBlank String getRegion() {
        return region;
    }

    public void setRegion(@NotBlank String region) {
        this.region = region;
    }

    public @NotBlank String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(@NotBlank String accessKey) {
        this.accessKey = accessKey;
    }

    public @NotBlank String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(@NotBlank String secretKey) {
        this.secretKey = secretKey;
    }
}
