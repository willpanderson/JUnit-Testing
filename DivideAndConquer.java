public class DivideAndConquer {
	
	/**Globally stores a progressively sorted array**/
	static int [] sorted;
	
	/**Modification of the MergeSort**/
    public static int measureEditDistance (int[] rankings) {
    	sorted = rankings;
    	return measureEditDistance(0, rankings.length);
    }
    
    public static int measureEditDistance(int lower, int upper) {
    	int editDistance = 0;
    	if(upper - lower == 1) { return 0; }
    	
    	int mid = lower + (upper - lower ) / 2; 
    	editDistance += measureEditDistance(lower, mid); /**Divide**/
    	editDistance += measureEditDistance(mid, upper); /**Divide**/ /**If n not a power of 2, right subsets the extra element**/
    	editDistance += measureCrossEditDistance(lower, upper); /**Conquer**/
    	return editDistance;
    }
    
    /** Handle the new "merge" procedure
     * lower: index representing the left most index into rankings of the current problem
     * upper: index representing the right most index into rankings of the current subproblem
     * **/
    public static int measureCrossEditDistance(int lower, int upper) {
    	int editDistance = 0;
    	
    	/**Keep track of:
    	 *  i: index into left subproblem
    	 *  j: index into right subproblem
    	 *  insertPt: where to update globally stored array with new sorted order**/
    	int i  = 0;
    	int j = 0;
    	int insertPt = lower;
    	
    	/**Find the midpoint of the current problem**/
    	int mid = lower + (upper - lower ) / 2;
    	/**Find the size of the current problem**/
    	int halfSize = (upper - lower ) / 2;
    	int [] left = new int [halfSize];
    	int [] right;
    	
    	/**Accounting for any "n" that is not a power of 2
    	 * - give the extra element to the right always**/
    	if((upper - lower ) % 2 != 0) {  
    		right = new int[halfSize + 1]; 
    		right[halfSize] = sorted[mid + halfSize];
    	}
    	else { 
    		right = new int[halfSize]; }   	
    	
    	/**Retrieve the sorted left and right subproblems from the global variable**/
    	for(int m = 0; m < halfSize; m++) {
    		left[m] = sorted[lower + m];
    		right[m] = sorted[mid + m];
    	}
   	
    	/**While neither left nor right subproblem is empty**/
    	while(i < left.length & j < right.length) {
    		/**Check for trigger to increment the edit distance**/
    		if(left[i] > right[j]) {
    			/**Increment edit distance, accounting for all the numbers in the left that will be bigger than right[j]
    			 *  --add right[j] to the sorted array**/
    			editDistance += left.length - i;
    			sorted[insertPt] = right[j];
    			j++;
    		}
    		else {
    			sorted[insertPt] = left[i];
    			i++;
    		}
    		insertPt++;
    	}
    	
    	/**Append all remaining from the left subproblem**/
    	while(i < left.length) {
    		sorted[insertPt] = left[i];
    		i++; insertPt++;
    	}
    	/**Append all remaining from the right subproblem**/
    	while(j < right.length) {
    		sorted[insertPt] = right[j];
    		j++; insertPt++;
    	}
    	
    	return editDistance;
    }
    
}