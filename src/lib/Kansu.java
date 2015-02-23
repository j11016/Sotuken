package lib;

public class Kansu {
	private int sw;
	// コンストラクタ
Kansu (int s) {sw = s;}
	// 型関値の計算
double snx(double x)
{

double y = 0.0;

switch (sw) {
case 0:
y = x * x * x * x + 3.0 * x * x * x + 2.0 * x * x + 1.0;
break;
}

return y;
}

}
