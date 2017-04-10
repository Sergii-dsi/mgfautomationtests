package atsdsi.framework.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {
    private static final Logger log = LoggerFactory.getLogger(CustomLogger.class);


    /// <summary>
    /// Writes verification text and result to log

    public static void TraceVerification(boolean pass, String description)
    {
        String passFailText = (pass ? "PASS" : "FAIL");


        if (description != "")
        {
            log.info (  System.currentTimeMillis()  + " " + "\t" + description);
        }
        log.info(System.currentTimeMillis() + " " + "\t   Verification - " + passFailText);
    }

    /// <summary>
    /// Writes verification text, step number and result to log

    public static void TraceVerification(boolean pass, int stepNumber, String description)
    {
        String passFailText = (pass ? "PASS" : "FAIL");


        log.info(System.currentTimeMillis() + " "  + "\t" +  stepNumber+ " " + description);
        log.info(System.currentTimeMillis() + " "  + "\t" + "   Verification - " + passFailText);
    }






}