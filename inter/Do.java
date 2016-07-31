package inter;

import symbols.Type;

public class Do extends Stmt {

	Expr expr;
	Stmt stmt;
	public Do() {
		// TODO Auto-generated constructor stub
		expr=null;
		stmt=null;
	}
	public void init(Expr x,Stmt s) 
	{
		expr=x;
		stmt=s;
		if(expr.type!=Type.Bool)
			expr.error("boolean reqired for do");
	}
	public void gen(int b,int a) {
		after=a;
		//
		int label=newlabel();
		stmt.gen( b,label);
		emitlable(label);
		expr.jumping(b,0);
		
		emit("goto L"+b);
	}

}
