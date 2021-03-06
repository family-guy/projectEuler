import java.util.*;
/* Problem 49 */

public class Problem49 {
	public static void main(String[] arg) {
		ArrayList<String> solutions = new ArrayList<String>();
		boolean[] primes = IntegerArithmetic.sieveEratosthenes(9999);
		ArrayList<Integer> fourDigitPrimes = new ArrayList<Integer>();
		for (int i = 1000; i < 10000; i++) {
			if (primes[i]) fourDigitPrimes.add(i);
		}
		for (int i = 0; i < fourDigitPrimes.size() - 2; i++) {
			int ithElt = fourDigitPrimes.get(i);
			for (int j = i + 1; j < fourDigitPrimes.size() - 1; j++) {
				int jthElt = fourDigitPrimes.get(j);
				if (Combinatorics.isPerm(ithElt, jthElt)) {
					int difference = jthElt - ithElt; int thirdTerm = jthElt + difference;
					if (thirdTerm < 10000 && primes[thirdTerm] && Combinatorics.isPerm(ithElt, thirdTerm)) {
						solutions.add(Integer.toString(ithElt) + Integer.toString(jthElt) + Integer.toString(thirdTerm));
					}
				}
			}
		}
		System.out.println("The concatenations of the two possible sequences are " + solutions);
		for (int i = 0; i < solutions.size(); i++) {
			if (!solutions.get(i).equals("148748178147")) System.out.println("Therefore the solution is " + solutions.get(i));
		}
	}
}