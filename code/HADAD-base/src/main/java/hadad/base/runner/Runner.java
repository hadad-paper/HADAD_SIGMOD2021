package hadad.base.runner;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Runner {
    public static void main(String[] args) throws NumberFormatException,

            Exception {
        Injector injector = Guice.createInjector(new EModule());
        final ERunner crossModelRewriter = injector.getInstance(ERunner.class);
        //crossModelRewriter.run();
    }
}
