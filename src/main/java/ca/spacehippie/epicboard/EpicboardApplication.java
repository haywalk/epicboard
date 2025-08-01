package ca.spacehippie.epicboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

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
	 * 
	 * @return  "Hello, world!"
	 */
	@GetMapping("helloworld")
	public String helloWorld() {
	// 	String DB_URL = "jdbc:mysql://localhost:3306/epicboard";
    // 	String USER = "epicboard";
    // 	String PASS = "epic";
    // 	String QUERY = "SELECT * FROM posts";
	// 	try { 
	// 		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    //         Statement stmt = conn.createStatement();
    //         ResultSet rs = stmt.executeQuery(QUERY);
	// 		// Extract data from result set
	// 		while (rs.next()) {
	// 			// Retrieve by column name
	// 			System.out.println("Success");
	// 		}
    //      return "success";
    //   } catch (SQLException e) {
	// 	return e.getMessage();
    //   } 
		try {
			return "done";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	/**
	 * Return a board's index.
	 * 
	 * @param id Board ID (name).
	 * @return JSON index of board.
	 */
	@GetMapping("board")
	public String getBoard(@RequestParam(value = "id", defaultValue="") String id) {
		return DatabaseAccessor.getBoard(id);
	}

	/**
	 * Return a thread.
	 * 
	 * @param id Thread ID. 
	 * @reutrn JSON content of thread.
	 */
	@GetMapping("thread")
	public String getThread(@RequestParam(value = "id", defaultValue="") String id) {
		//return "json content of thread " + id;
		// SELECT * FROM posts WHERE thread = id
		// return as JSON
		return DatabaseAccessor.getThread(id);
	}

	/**
	 * Create a thread.
	 * 
	 * @param board Board ID.
	 * @return Status.
	 */
	@GetMapping("new")
	public String newThread(@RequestParam(value="id", defaultValue="") String board) {
		return "created new thread on board " + board;
		// upload image (required for a thread)
		// get board as JSON
		// add post, update DB
	}
	
	/**
	 * Reply to a thread.
	 * 
	 * @param id Thread ID.
	 * @return Status.
	 */
	@GetMapping("reply")
	public String replyThread(@RequestParam(value="id", defaultValue="") String id) {
		return "replied to thread " + id;
		// upload image if applicable
		// Get thread as JSON
		// append reply
		// update DB
	}
}
