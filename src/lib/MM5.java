package lib;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MM5 {

	static int len=0;
	static String shiki="";
	static boolean f=true;
	private static String str = "";

	public MM5(String str){
		this.str = str;
		this.str +="=";

	}

	//入力された文字strを変換してshikiに格納する
		public static int calc(int x[]) {
			len=str.length();
			String num="";

			//ループ前に１文字目を判定
			if(str.substring(0,1).equals("x"))
				f=false;

			int i;
			for(i=0;i<len - 1;i++){

				/******通常モード******/
				if(f){
					//strから１文字ずつshikiに格納する
					shiki=shiki+str.substring(i,i+1);

					if(f){	//次の文字がxなら変換モードへ移行
						if(str.substring(i+1,i+2).equals("x")){
							f=false;
							//xの後が数値ではない場合、エラー
							if(check(str.substring(i+2,i+3)))
								return -1;
						}
					}
				}

				/*******ここまで*******/
				/******変換モード******/
				else{
					//num に x の後の数字を記憶していく
					num=num+str.substring(i,i+1);

					//次の文字が数字ではないなら、xの後の数字が確定し、通常モードへ移行
					if(check(str.substring(i+1,i+2))){
						System.out.println(shiki);
						shiki=shiki+x[Integer.parseInt(num.substring(1,num.length()))];
						num="";
						f=true;
					}
				}
				/*******ここまで*******/

			}
			System.out.println(shiki);


			int ans = 0;
			//文字列内の数式を計算し、返す。
			try{
				ScriptEngineManager factory = new ScriptEngineManager();
				ScriptEngine engine = factory.getEngineByName("JavaScript");
				ans = (int) engine.eval(shiki);
			}catch(ScriptException e){
				throw new RuntimeException(e);
			}
			//計算結果を返す
			return ans;
		}

		//数字ではない文字ならtrueを返す
		public static boolean check(String a) {
			if(
				(a.equals("0"))||
				(a.equals("1"))||
				(a.equals("2"))||
				(a.equals("3"))||
				(a.equals("4"))||
				(a.equals("5"))||
				(a.equals("6"))||
				(a.equals("7"))||
				(a.equals("8"))||
				(a.equals("9"))
				)
				return false;
			else
				return true;
		}



}
