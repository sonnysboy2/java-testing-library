
import java.lang.annotation.*;
/**
  A marker class saying that this class holds testing methods
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestTarget {}
