package pacmann.springboot.restserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class to start the Springboot restserver.
 */
@SpringBootApplication
public class PacManModelApplication {

  public PacManModelApplication() {
  }

  public static void main(String[] args) {
    SpringApplication.run(PacManModelApplication.class, args);
  }
}
