package de.db12.ulam0;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

import de.db12.ulam0.UlamRing.Dir;

public class UlamPosition {
	private int x;
	private int y;
	private int value;
	private int n;
	private Dir dir;
	private boolean prime;

	public UlamPosition(int n, Dir dir, int x, int y, int value, boolean prime) {
		this.n = n;
		this.dir = dir;
		this.x = x;
		this.y = y;
		this.prime = prime;
		this.value = value;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public int getValue() {
		return value;
	}

	public int getN() {
		return n;
	}

	public Dir getDir() {
		return dir;
	}

	public int getNorm() {
		return x * x + y * y;
	}

	public String getPFZNorm() {
		List<Integer> pfactors = new ArrayList<Integer>();
		int tmp = getNorm();
		for (int i = 2; i <= tmp; i++) {
			if (tmp % i == 0) {
				pfactors.add(i);
				if (i> 2 && i%4 != 1)
					System.out.println("Error " + getNorm() + " " +i);
				tmp /= i;
				i--;
			}
		}

		return Joiner.on(",").join(pfactors);
	}

	@Override
	public String toString() {
		return "UlamPosition [x=" + x + ", y=" + y + ", value=" + value
				+ ", n=" + n + (prime ? ", prim" : "") + ", norm=" + getNorm()
				+ ", pfactors=" + getPFZNorm()
				+ "]";
	}

	public boolean isPrime() {
		return prime;
	}

}
