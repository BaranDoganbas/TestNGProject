package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersRetryAnalyzer implements IAnnotationTransformer{
//    Bu sinifin amaci, TUM FAILED TEST CASE'LERI BIR KEZ DAHA OTOMATIK OLARAK XML FILE ILE RUN ETMEK
//    BU SINIF ListenersRetry SINIFINI XML'DE KULLANABILMEK ICIN OLUSTURULDU
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//        Bu sinif ListenersRetry util class'ina baglidir
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }
}
