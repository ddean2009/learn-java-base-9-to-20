package com.flydean;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author wayne
 * @version MyProcessor,  2020/5/5 11:50 下午
 */
@SupportedAnnotationTypes("com.flydean.*")
@SupportedSourceVersion(SourceVersion.RELEASE_14)
public class MyProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("process annotation!");
        annotations.forEach(annotation -> {
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(annotation);
            elements.stream()
                    .filter(TypeElement.class::isInstance)
                    .map(TypeElement.class::cast)
                    .map(TypeElement::getQualifiedName)
                    .map(name -> "Class " + name + " is annotated with " + annotation.getQualifiedName())
                    .forEach(System.out::println);
        });
        return true;
    }
}
