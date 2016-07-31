package inter;

import symbols.Type;

public class Else extends Stmt {
	Expr expr;
	Stmt stmt1,stmt2;
	public Else(Expr x,Stmt s1,Stmt s2) {
		// TODO Auto-generated constructor stub
		expr=x;
		stmt1=s1
				;
		stmt2=s2;
		if(expr.type!=Type.Bool)
			expr.error("bolean required in if");
	}

		public void gen(int b,int a)
		{
			int label1=newlabel();
			int label2=newlabel();
			expr.jumping(0, label2);
			emitlable(label1);
			stmt1.gen(label1,a);
			emit("goto L"+a);
			
			emitlable(label2);
			stmt1.gen(label2,a);
		}
}
