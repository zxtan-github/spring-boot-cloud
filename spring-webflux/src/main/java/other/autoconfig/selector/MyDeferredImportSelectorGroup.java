package other.autoconfig.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import other.autoconfig.service.Service03;

import java.util.HashSet;

public class MyDeferredImportSelectorGroup implements DeferredImportSelector.Group {

    HashSet<Entry> entries = new HashSet<>();
    AnnotationMetadata meta;

    @Override
    public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
        this.meta = metadata;
        // 这里什么也不做，不执行DeferredImportSelector01.selectImports

        // 这里遍历DeferredImportSelector时，执行DeferredImportSelector#selectImports，并将其添加到最终selectImports要返回的entries中
        for (String importClassName : selector.selectImports(metadata)) {
            this.entries.add(new Entry(metadata, importClassName));
        }
    }

    @Override
    public Iterable<Entry> selectImports() {
        Entry entry = new Entry(meta, Service03.class.getName());
        entries.add(entry);
        return entries;
    }
}
