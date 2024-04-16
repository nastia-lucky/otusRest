package utils;

import com.google.inject.Guice;
import com.google.inject.Injector;
import modules.GuiceModule;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import java.util.Arrays;

public class BaseTest {

  //protected Injector injector=Guice.createInjector(new GuiceModule());

  /*@BeforeMethod
  public void setInjector(ITestContext context) {
    Injector injector= Guice.createInjector(new GuiceModule());
    context.addInjector(Arrays.asList(new GuiceModule()),injector);
  }  */
}
