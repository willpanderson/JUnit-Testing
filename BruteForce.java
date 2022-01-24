public class BruteForce{

    public static int measureEditDistance (int[] rankings) {
    	int editDistance = 0;
    	for(int i = 0; i < rankings.length; i++) {
    		/**set j = i + 1 so "i < j" is always true**/
    		for(int j = i + 1; j < rankings.length; j++) {
    			/**make the check from assignment 1 description, increment editDistance if true**/
    			if(rankings[i] > rankings[j]) {
    				editDistance++;
    			}
    		}
    	}
    	return editDistance;
    }
}
