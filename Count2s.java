
public class Count2s {

	public static int numberOf2s(int n) {
	    if (n < 2)
	        return 0;
	 
	    int result = 0;
	    int power10 = 1;
	    while (power10 * 10 < n) {
	        power10 *= 10;
	    }
	    // power10 = 100
	    int msb = n / power10; // 3
	    int reminder = n % power10; // 19
	 
	    // Count # of 2s from MSB
	    if (msb > 2)
	        // This counts the first 2 from 200 to 299
	        result += power10;
	    if (msb == 2)
	        // If n = 219, this counts the first 2
	        // from 200 to 219 (20 of 2s).
	        result += reminder + 1;
	 
	    // Count # of 2s from reminder
	    // This (recursively) counts for # of 2s from 1 to 100
	    // msb = 3, so we need to multiply by that.
	    result += msb * numberOf2s(power10);
	    // This (recursively) counts for # of 2s from 1 to reminder
	    result += numberOf2s(reminder);
	 
	    return result;
	}
	
	public static int count2sI(int num) {
		 int countof2s = 0, digit = 0;
		 int j = num, seendigits=0, position=0, pow10_pos = 1;
		 /* maintaining this value instead of calling pow() is an 6x perf
		 * gain (48s -> 8s) pow10_posMinus1. maintaining this value
		 * instead of calling Numof2s is an 2x perf gain (8s -> 4s).
		 * overall > 10x speedup */
		 while (j > 0) {
		 digit = j % 10;
		 int pow10_posMinus1 = pow10_pos / 10;
		 countof2s += digit * position * pow10_posMinus1;
		 /* we do this if digit <, >, or = 2
		 * Digit < 2 implies there are no 2s contributed by this
		 * digit.
		 * Digit == 2 implies there are 2 * numof2s contributed by
		 * the previous position + num of 2s contributed by the
		 * presence of this 2 */
		 if (digit == 2) {
		 countof2s += seendigits + 1;
		 }
		 /* Digit > 2 implies there are digit * num of 2s by the prev.
		 * position + 10^position */
		 else if(digit > 2) {
		 countof2s += pow10_pos;
		 }
		 seendigits = seendigits + pow10_pos * digit;
		 pow10_pos *= 10;
		 position++;
		 j = j / 10;
		 }
		 return(countof2s);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(count2sI(319));

	}

}
