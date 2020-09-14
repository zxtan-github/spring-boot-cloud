package other.autoconfig.selector;


import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import other.autoconfig.service.Service01;
import other.autoconfig.service.Service03;

import java.util.HashSet;
import java.util.function.Predicate;

public class MyGroupDeferredImportSelector01 implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Service01.class.getName()};
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        return MyDeferredImportSelectorGroup.class;
    }


}
