package other;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomEnableAutoConfiguration {
    public CustomEnableAutoConfiguration() {
        System.out.println("CustomEnableAutoConfiguration");
    }
}
