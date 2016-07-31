package inter;
import lexer.Token;
import inter.Node;
import symbols.*;
public class Expr extends Node {
public Token op;//opertaor
public Type type;//type at the node
Expr(Token tok,Type p)
{
	op=tok;
	type=p;
}
public Expr gen()//returns the address of current expr
{
	return this;
}
public Expr reduce()
{
	return this;
}
public void jumping(int t,int f)//jumping code for bool expr
{
	emitjumps(toString(),t,f);
}
public void emitjumps(String test,int t,int f)//jumping code for bool exprgi
{
	if(t!=0&&f!=0)
	{
		emit("if "+test+" goto L"+t);
		emit("goto L"+f);
	}
	else if(t!=0)
		emit("if "+test+ "goto L"+ t);	
	else if(f!=0)
			emit("iffalse "+test+ "goto L"+ f);
}
public String toString()
{
	return op.toString();
}
}
