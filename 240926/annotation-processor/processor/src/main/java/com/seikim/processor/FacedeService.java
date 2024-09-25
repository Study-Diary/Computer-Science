package com.seikim.annotationstudy.annotation3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import org.springframework.stereotype.Service;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
@Service
public @interface FacedeService {
}

@SupportedAnnotationTypes("com.seikim.annotationstudy.annotation3.FacedeService")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
class FacedeServiceProcessor extends AbstractProcessor {

	private Messager messager;

	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		messager = processingEnv.getMessager();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element element : roundEnv.getElementsAnnotatedWith(FacedeService.class)) {
			String className = element.getSimpleName().toString();
			if (!className.contains("FacedeService")) {
				messager.printMessage(Diagnostic.Kind.ERROR,
						"Class name must contain 'FacedeService'. Found: " + className, element);
			}
		}
		return true;
	}
}

@FacedeService
class MyFacedeService {
	// ETC..
}

@FacedeService
class MyService {
	// ETC..
}