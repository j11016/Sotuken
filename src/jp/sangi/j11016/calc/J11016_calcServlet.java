package jp.sangi.j11016.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import lib.MM1;
import lib.MM2;
import lib.MM3;
import lib.MM4;


@SuppressWarnings("serial")
public class J11016_calcServlet extends HttpServlet {

	int x[] = new int[10];
	int ans = 0;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.sendRedirect("index.html");


	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ





        resp.setContentType("text/plain");
        resp.setContentType("text/html; charset=utf-8");


        String x1 = req.getParameter("service1");
        String x2 = req.getParameter("service2");
        String x3 = req.getParameter("service3");
        String x4 = req.getParameter("service4");
        String x5 = req.getParameter("service5");
        String formula = req.getParameter("arrival");


        req.setAttribute("service1",x1);
        req.setAttribute("service2",x2);
        req.setAttribute("service3",x3);
        req.setAttribute("service4",x4);
        req.setAttribute("service5",x5);
        req.setAttribute("arrival",formula);


        //stringからint
        int hensu1 = Integer.parseInt(x1);
        int hensu2 = Integer.parseInt(x2);
        int hensu3 = Integer.parseInt(x3);
        int hensu4 = Integer.parseInt(x4);
        int hensu5 = Integer.parseInt(x5);
        int formula2 = Integer.parseInt(formula);





      //インスタンス
        //MM4 mm4 = new MM4();
        x[0]=hensu1;
        x[1]=hensu2;
        x[2]=hensu3;
        x[3]=hensu4;
        x[4]=hensu5;
       // x[5]=;
       // x[6]=;
       // x[7]=;
       // x[8]=;
       // x[9]=;



        String shiki=(String) req.getAttribute("formula");

        //コンストラクタ
        MM4 mm4 = new MM4(shiki);


        ans = mm4.calc(x);

        String answer = String.valueOf(ans);
        req.setAttribute("ans",answer);



        //String formula2 = mm4.getFormula();

		this.getServletContext().getRequestDispatcher("/MM1.jsp").forward(req, resp);


	}

}
