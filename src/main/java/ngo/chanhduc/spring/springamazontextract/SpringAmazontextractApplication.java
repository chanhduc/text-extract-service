package ngo.chanhduc.spring.springamazontextract;

import ngo.chanhduc.spring.springamazontextract.config.properties.AwsConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AwsConfigurationProperties.class)
public class SpringAmazontextractApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAmazontextractApplication.class, args);
    }

}
