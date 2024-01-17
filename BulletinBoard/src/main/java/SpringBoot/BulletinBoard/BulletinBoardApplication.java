package SpringBoot.BulletinBoard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BulletinBoardApplication {
	private static final Logger logger = LoggerFactory.getLogger(BulletinBoardApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BulletinBoardApplication.class, args);
		logger.info("SprintBoot-based BulletinBoard server was just started !!!");
	}

}
