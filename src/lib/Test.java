package lib;

import java.io.IOException;

public class Test {
	public static void main(String args[]) throws IOException
	{
		double a, b, eps, x, val[] = new double [1];
		int max, ind[] = new int [1];

		a   = -2.0;
		b   = -1.0;
		eps = 1.0e-10;
		max = 100;

		Kansu kn = new Kansu(0);
		x = App.gold(a, b, eps, val, ind, max, kn);

		System.out.println("x " + x + " val " + val[0] + " ind " + ind[0]);
	}
}

