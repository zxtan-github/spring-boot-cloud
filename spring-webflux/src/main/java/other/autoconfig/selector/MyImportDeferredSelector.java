package other.autoconfig.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import other.autoconfig.service.Service01;
import other.autoconfig.service.Service02;

public class MyImportDeferredSelector implements DeferredImportSelector {

    public MyImportDeferredSelector() {
        System.out.println("other.autoconfig.selector.DeferredImportSelector#init");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        importingClassMetadata.getAnnotationTypes().forEach(e -> System.out.println(e));
        return new String[]{Service01.class.getName(), Service02.class.getName()};
    }
}
