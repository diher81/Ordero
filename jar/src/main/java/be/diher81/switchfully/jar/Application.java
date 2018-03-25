package be.diher81.switchfully.jar;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "be.diher81.switchfully")
public class Application {

    final static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        run("Ordero");
        SpringApplication.run(Application.class, args);
    }

    private static void run(String parameter){

        if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }

}
