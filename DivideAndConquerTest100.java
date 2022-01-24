import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DivideAndConquerTest100 {
	
	@Test
	void HolyGrail() {
		int [] rankings = {10,2,3,4,5,6,7,8,9,1};
		int result = DivideAndConquer.measureEditDistance(rankings);
		assertEquals(17,result);
	}	

}
