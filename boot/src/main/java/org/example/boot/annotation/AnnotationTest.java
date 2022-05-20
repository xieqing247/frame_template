package org.example.boot.annotation;

import javax.annotation.*;
import java.lang.annotation.*;

public class AnnotationTest {
    public static void main(String[] args) {
        AnnotationTest qing = new AnnotationTest();
        Class<?> cla = qing.getClass();
        /*
        Annotation[] annotations = cla.getAnnotations();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation>  acla =  annotation.annotationType();
            MyTheMing love = acla.getAnnotation(MyTheMing.class);
            System.out.println(love.ming());
        }
        */
        getAnnos(cla);
    }


    /**
     * interface java.lang.annotation.Documented 等 存在循环，导致内存溢出，所以需要排除java的源注解
     * @param classz
     */
    private static void getAnnos(Class<?> classz){
        Annotation[] annotations = classz.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() != Deprecated.class &&
                    annotation.annotationType() != SuppressWarnings.class &&
                    annotation.annotationType() != Override.class &&
                    annotation.annotationType() != PostConstruct.class &&
                    annotation.annotationType() != PreDestroy.class &&
                    annotation.annotationType() != Resource.class &&
                    annotation.annotationType() != Resources.class &&
                    annotation.annotationType() != Generated.class &&
                    annotation.annotationType() != Target.class &&
                    annotation.annotationType() != Retention.class &&
                    annotation.annotationType() != Documented.class &&
                    annotation.annotationType() != Inherited.class
            ) {
                if (annotation.annotationType() == MyComponent.class){
                    System.out.println(" 存在注解 @MyTheMing ");
                }else{
                    getAnnos(annotation.annotationType());
                }
            }
        }
    }
}
