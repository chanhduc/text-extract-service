package ngo.chanhduc.spring.springamazontextract.config;

import ngo.chanhduc.spring.springamazontextract.config.properties.AwsConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.textract.TextractClient;

/**
 * @author Chanh-Duc Ngo
 * @created-date 28/08/2024
 */
@Configuration
public class TextractClientConfig {

    AwsConfigurationProperties awsConfigurationProperties;

    public TextractClientConfig(AwsConfigurationProperties awsConfigurationProperties) {
        this.awsConfigurationProperties = awsConfigurationProperties;
    }

    @Bean
    public TextractClient textractClient() {
        String region = awsConfigurationProperties.getRegion();
        String accessKey = awsConfigurationProperties.getAccessKey();
        String secretKey = awsConfigurationProperties.getSecretKey();

        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKey, secretKey);

        return TextractClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();

    }
}
