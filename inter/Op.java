package inter;
import lexer.*;
import symbols.*;
public class Op extends Expr{
public Op(Token tok, Type p)
{
	super(tok, p);
}
public Expr reduce()//inheited by Arith,Unary and Access
{
	Expr x=gen();//generate a term
	Temp t=new Temp(type);
	emit(t.toString()+" = "+x.toString());//emit instructions
	return t;
}
}
