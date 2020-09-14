package other.autoconfig;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import other.autoconfig.selector.MyGroupDeferredImportSelector01;
import other.autoconfig.selector.MyGroupDeferredImportSelector02;
import other.autoconfig.service.Service01;
import other.autoconfig.service.Service02;
import other.autoconfig.service.Service03;

@Configuration
@Import({MyGroupDeferredImportSelector01.class, MyGroupDeferredImportSelector02.class})
public class MyGroupDeferredImportSelectorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyGroupDeferredImportSelectorTest.class);
        Service03 service03 = context.getBean(Service03.class);
        service03.service();
        Service01 service01 = context.getBean(Service01.class);
        service01.service();
        Service02 service02 = context.getBean(Service02.class);
        service02.service();
    }

    @Bean
    public Service03 getService03() {
        return new Service03();
    }
}
