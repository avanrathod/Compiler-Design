package inter;

import symbols.Type;

public class While extends Stmt {
	Expr expr;
	Stmt stmt;
	public While() {
		// TODO Auto-generated constructor stub
		expr=null;
		stmt=null;
	}
	public void init(Expr x,Stmt s) 
	{
		expr=x;
		stmt=s;
		if(expr.type!=Type.Bool)
			expr.error("boolean reqired for while");
	}
	public void gen(int b,int a) {
		after=a;
		expr.jumping(0, a);
		int label=newlabel();
		emitlable(label);
		stmt.gen(label, b);
		emit("goto L"+b);
	}
}
