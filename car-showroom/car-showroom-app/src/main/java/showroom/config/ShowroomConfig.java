package showroom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShowroomConfig {

    @Bean
    String foo() { return new String("bar"); }
}
