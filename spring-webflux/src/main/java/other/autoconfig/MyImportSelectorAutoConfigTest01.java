package other.autoconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
import other.autoconfig.selector.MyImportSelector;
import other.autoconfig.service.Service01;
import other.autoconfig.service.Service02;
import other.autoconfig.service.Service03;

@Import(MyImportSelector.class)
@Configuration
@Service
public class MyImportSelectorAutoConfigTest01 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyImportSelectorAutoConfigTest01.class);
        Service01 service01 = context.getBean(Service01.class);
        service01.service();
        Service02 service02 = context.getBean(Service02.class);
        service02.service();
        Service03 service03 = context.getBean(Service03.class);
        service03.service();
    }

    @Bean
    public Service03 getService03() {
        return new Service03();
    }
}

