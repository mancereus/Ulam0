package de.db12.ulam0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.db12.ulam0.UlamRing;
import de.db12.ulam0.UlamRing.Dir;

public class UlamCalc {

	public static void main(String[] args) {
		List<UlamPosition> pos = new ArrayList<UlamPosition>();
		List<Integer> primes = new ArrayList<Integer>();
		int count = 0;
		int x = 0;
		int y = 0;
		for (int i = 1; i < 10; i++) {
			new UlamRing(i);
			x++;
			y--;
			for (Dir dir : Dir.values()) {
				for (int j = 0; j < 2 * i; j++) {
					switch (dir) {
					case n:
						y++;
						break;
					case w:
						y--;
						break;
					case s:
						x--;
						break;
					case o:
						x++;
						break;

					default:
						break;
					}
					++count;
					boolean prime = isPrime(count, primes);
					if (prime)
						primes.add(count);
					pos.add(new UlamPosition(i, dir, x, y, count, prime));
				}
			}
		}

		for (UlamPosition up : pos) {
			if (up.isPrime())
				System.out.println(up);
		}
	}

	private static boolean isPrime(int count, List<Integer> primes) {
		if (count < 2)
			return false;
		for (Integer p : primes) {
			if (count % p == 0)
				return false;

		}
		return true;
	}
}
