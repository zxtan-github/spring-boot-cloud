package other.autoconfig.annotation;


import org.springframework.context.annotation.Import;
import other.autoconfig.selector.MyGroupDeferredImportSelector01;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import(MyGroupDeferredImportSelector01.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomSelector {
}

