package de.db12.ulam0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import com.google.common.base.Joiner;
import com.google.common.collect.TreeMultimap;

import de.db12.ulam0.UlamRing.Dir;

public class UlamCalc {

	public static void main(String[] args) {
		TreeMultimap<String, Long> pfzprimes = TreeMultimap.create();
		List<UlamPosition> pos = new ArrayList<UlamPosition>();
		List<Long> primes = new ArrayList<Long>();
		long count = 0;
		int x = 0;
		int y = 0;
		for (int i = 1; i < 50; i++) {
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
					if (prime) {
						primes.add(count);
					}
					UlamPosition up = new UlamPosition(i, dir, x, y, count, prime);
					pos.add(up);
					if(prime)
					pfzprimes.put(up.getPFZNorm(), up.getValue());
				}
			}
		}

		for (UlamPosition up : pos) {
			if (up.isPrime())
				System.out.println(up);
		}
		for (Entry<String, Collection<Long>> entry : pfzprimes.asMap().entrySet()) {
			System.out.println(entry.getKey() + " " + Joiner.on(",").join(entry.getValue()));
		}
	}

	private static boolean isPrime(long count, List<Long> primes) {
		if (count < 2)
			return false;
		for (Long p : primes) {
			if (count % p == 0)
				return false;

		}
		return true;
	}
}
