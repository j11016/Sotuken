package lib;

public class J11016_newton {
	//関数値を求めるメソッド
    double f(double x){
            double y;
            y=x*x*x-6.0*x*x+12.0*x-11.0;
            return y;
    }

    //導関数
    double df(double x){
            double dy;
            dy=3.0*x*x-12.0*x+12.0;
            return dy;
    }

String keisan(double x0){
            double EPS = 1e-8;  //続く計算値間の差
            int i=0;
            int end=100;//反復数の最大値。これ以上では収束しないと判断。
     double xn,xn1;
     String s="";
     xn=x0;
     for(i=0; i<=end; i++){
         xn1=xn-f(xn)/df(xn);
         if(Math.abs((xn1 - xn)/xn1) < EPS){
             s=String.valueOf(xn1);
             break;
         }
         xn=xn1;
     }
     if(i == end){
         s="発散";
     }
     return s;
}

    public static void main(String[] args) {
            J11016_newton nw=new J11016_newton();
                //非線型方程式を解く場合、グラフなどを描いて、根の近傍の値を
                //知っておく必要がある。　
                double x=3.0;//根の近傍の値
                double kon;
                if(nw.keisan(x) != "発散"){
                    //文字列で返ってきた値を数値に変換
        kon=Double.valueOf(nw.keisan(x)).doubleValue();
        System.out.printf("根 = %f",kon);
                }
                else{
        System.out.printf("発散して根は得られません");
                }
    System.out.println();
    }

}
