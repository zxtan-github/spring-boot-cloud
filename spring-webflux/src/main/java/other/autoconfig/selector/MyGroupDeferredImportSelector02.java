package other.autoconfig.selector;


import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import other.autoconfig.service.Service01;
import other.autoconfig.service.Service02;

public class MyGroupDeferredImportSelector02 implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Service02.class.getName()};
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        return MyDeferredImportSelectorGroup.class;
    }


}
