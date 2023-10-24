package hello.login.web.argumentResolver;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)//실제 동작할때까지 애노테이션 남아있어야 해서
public @interface Login {
}
