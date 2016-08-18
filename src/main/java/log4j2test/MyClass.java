package log4j2test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.ThreadContext;

public class MyClass {
  private static final Logger logger = LogManager.getLogger(MyClass.class);
  private static final Marker MARKER = MarkerManager.getMarker("myMarker");

  public void logSimpleMessage() {
    // This adds a simple message to the logs
    logger.info("This is a test");
  }

  public void logWithTag() {
    // This adds a message with a tag to the logs named 'log4j2-Marker'
    logger.info(MARKER, "This is a test");
  }

  public void logWithExtras() {
    // MDC extras
    ThreadContext.put("Environment", "Development");
    // NDC extras are sent under 'log4j2-NDC'
    ThreadContext.push("Extra_details");
    // This adds a message with extras to the logs
    logger.info("This is a testolo with extra");
  }

  public void logException() {
    try {
      unsafeMethod();
    } catch (Exception e) {
      // This adds an exception to the logs
      logger.error("Exception caught", e);
    }
  }

  public void unsafeMethod() {
    throw new UnsupportedOperationException("You shouldn't call that");
  }
}
