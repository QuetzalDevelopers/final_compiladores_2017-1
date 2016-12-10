package compilador;
import java.io.*;
%%

%int 
%{

int errorL [];
int errorC[];
int lineas=1;
int totalErrores=0;
int cuentaCar=1;
int i;
%}

letra = [a-zA-Z_]
caracter = [a-zA-Z_0-9]
digito = [0-9]

%%

"return" {cuentaCar+=yylength();return Parser.RETORNA;}  
"define" {cuentaCar+=yylength();return Parser.DEFINE;}
"if" {cuentaCar+=yylength();return Parser.IF;}
"else" {cuentaCar+=yylength();return Parser.ELSE;}
"do" {cuentaCar+=yylength(); return Parser.DO}
"while" {cuentaCar+=yylength();return Parser.WHILE;}
"for" {cuentaCar+=yylength();return Parser.FOR}
"struct" {cuentaCar+=yylength();return Parser.STRUCT}
"int" {cuentaCar+=yylength();return Parser.INT;}
"float" {cuentaCar+=yylength();return Parser.FLOAT;}
"char" {cuentaCar+=yylength();return Parser.CHAR;} 
"void" {cuentaCar+=yylength();return Parser.VOID;} 
{letra}{caracter}* {cuentaCar+=yylength();return Parser.ID;}
";" {cuentaCar+=yylength();return Parser.PUNTO_COMA;}
"(" {cuentaCar+=yylength();return Parser.LPAR;}
")" {cuentaCar+=yylength();return Parser.RPAR;}
"{" {cuentaCar+=yylength();return Parser.LLAVE_ABRE;}
"}" {cuentaCar+=yylength();return Parser.LLAVE_CIERRA;}
"[" {cuentaCar+=yylength();return Parser.LCORCHETE}
"]" {cuentaCar+=yylength();return Parser.RCORCHETE}
"," {cuentaCar+=yylength();return Parser.COMA;}
"+" {cuentaCar+=yylength();return Parser.ADD;}
"-" {cuentaCar+=yylength();return Parser.MENOS;}
"*" {cuentaCar+=yylength();return Parser.MUL;}
"/" {cuentaCar+=yylength();return Parser.DIV;}
{digito}+ {if(atoi(yytext())<=1000){return Parser.NUM;}else{errorL[totalErrores]=lineas;errorC[totalErrores]=cuentaCar;cuentaCar+=yylength();totalErrores+=1;}}
"<" {cuentaCar+=yylength();return Parser.MENOR;}
">" {cuentaCar+=yylength();return Parser.MAYOR;}
">=" {cuentaCar+=yylength();return Parser.MAYOR_IGUAL;}
"<=" {cuentaCar+=yylength();return Parser.MENOR_IGUAL;}
"!" {cuentaCar+=yylength();return Parser.NOT;}
"!=" {cuentaCar+=yylength();return Parser.DISTINTO;}
"=" {cuentaCar+=yylength();return Parser.ASIG;}
"==" {cuentaCar+=yylength();return Parser.EQUAL;}
"+=" {cuentaCar+=yylength();return Parser.ADDASIG;}
"-=" {cuentaCar+=yylength();return Parser.MENOSASIG;}
"*=" {cuentaCar+=yylength();return Parser.MULASIG;}
"/=" {cuentaCar+=yylength();return Parser.DIVASIG;}
"%=" {cuentaCar+=yylength();return Parser.PORCASIG;}
"||" {cuentaCar+=yylength();return Parser.OR;}
"&&" {cuentaCar+=yylength();return Parser.AND;}
[\n] {lineas++;cuentaCar=1;}
[\t] {cuentaCar+=4;}
[ ] {cuentaCar+=1;}
. {System.out.println("\nCaracter inesperado ");cuentaCar+=yylength();}
<<EOF>> {System.out.println("\n\nERRORES:\n\n");
		for(i=0;i<totalErrores;i++)
			System.out.println("Error en la linea: %d en el caracter: %d\n",errorL[i],errorC[i]);
		System.out.println("\n");
		return 0;}

