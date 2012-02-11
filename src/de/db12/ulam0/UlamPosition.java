package de.db12.ulam0;

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
		return x*x + y*y;
	}
	public String getPFZ() {
		return "";
	}
	@Override
	public String toString() {
		return "UlamPosition [x=" + x + ", y=" + y + ", value=" + value
				+ ", n=" + n + (prime ? ", prim" : "") + ", norm=" + getNorm() + "]";
	}
	public boolean isPrime() {
		return prime;
	}
	
}
