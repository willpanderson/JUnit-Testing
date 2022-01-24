import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BruteForceTestExample {


	//Since it is an array, I may want different sizes. Therefore, I don't see a consistent set up to do before each test.
	/*@BeforeEach
	void setUp() throws Exception {	
 	}*/

	//I could declare a global array rankings but it does make setting up the array more work. In this tearDown method, I would want to clear the array.
	@AfterEach
	/*void tearDown() throws Exception {
	 * rankings = null;
	}*/
    
	@Test
	void Test1() {
	//In order and expect nothing should be different
		int [] rankings = {1,2,3,4,5,6,7,8,9,10};
		int result = BruteForce.measureEditDistance(rankings);
		assertEquals(0,result);
	}
	
	@Test
	void Test2() {
	//Made a change occur at the end of the array
		int [] rankings = {1,2,3,4,5,6,7,8,10,9};
		int result = BruteForce.measureEditDistance(rankings);
		assertEquals(1,result);
	}
	
	@Test
	void Test3() {
	//Made a change occur by swapping the first and last position
		int [] rankings = {10,2,3,4,6,5,7,8,9,1};
		int result = BruteForce.measureEditDistance(rankings);
		assertEquals(17,result);
	}
	
	@Test
	void Test4() {
	//Checking behavior when the array is of length one
		int [] rankings = {1};
		int result = BruteForce.measureEditDistance(rankings);
		assertEquals(0,result);
	}
}
