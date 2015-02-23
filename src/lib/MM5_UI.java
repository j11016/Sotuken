package lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MM5_UI {
	//変数
			static int x[] = {0,1,2,3,4,5,6,7,8,9};


			public static void main (String[ ] args) throws IOException {


				BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
				String str = input.readLine( );

				MM5 mm5 = new MM5(str);
				int ans = mm5.calc(x);
				System.out.println(ans);
			}

		}