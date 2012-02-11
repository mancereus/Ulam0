package de.db12.ulam0;
public class UlamRing {
	private int distance;

	public enum Dir {
		n, w, s, o
	};

	public UlamRing(int n) {
		this.distance = n;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
