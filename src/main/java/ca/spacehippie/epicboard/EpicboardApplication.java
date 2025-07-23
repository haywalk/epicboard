package ca.spacehippie.epicboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST API for EpicBoard.
 * 
 * @version 2025-07-23
 */
@SpringBootApplication
@RestController
@RequestMapping("api") // prefix /api/ for all endpoints
public class EpicboardApplication {
	/**
	 * Start the program.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EpicboardApplication.class, args);
	}

	/**
	 * Bare-bones endpoint /api/helloworld 
	 * @return  "Hello, world!"
	 */
	@GetMapping("helloworld")
	public String helloWorld() {
		return "Hello, world!";
	}
}
