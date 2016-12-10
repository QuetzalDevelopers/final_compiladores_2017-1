%{
package compilador;

import java.io.*;
import javax.swing.JTextArea;
%}


%token<obj> NUM
%token<sval> ID
%token<sval> STR 
%token<sval> CHR
%token VOID INT FLOAT CHAR
%token IF
%token PUNTO_COMA
%token DEFINE
%token STRUCT
%token WHILE
%token DO
%token FOR
%token RETORNA


%left COMA
%left MENOR MAYOR MAYOR_IGUAL MENOR_IGUAL 
%left ASIG ADDASIG MULASIG MENOSASIG DIVASIG PORCASIG  
%left OR
%left AND
%left NOT 
%left EQUAL DISTINTO
%left ADD MENOS PORC
%left MUL DIV
%left LPAR RPAR
%left LLAVE_ABRE LLAVE_CIERRA 
%left LCORCHETE RCORCHETE
%nonassoc IFX
%nonassoc ELSE


%type<obj> S L
%type<sval> Or Oa
%type<obj> E Et Ef
%type<obj> Bb
%type<obj> B
%type<obj> program


%start program


%%


P: {SemanticAcc.init(ts);} D Df {$$ = SemanticAcc.Program((Sentencia)$3);};

D: D B {tipo = ((Type)$2).B; width= ((Type) $2).width;} Ld PTOYC | ;

B: INT {$$ = new Type(0, 4);} | FLOAT {$$ = new Type(1, 8);};

Ld: Ld COMA ID{SemanticAcc.putId($3,tipo);} | ID {SemanticAcc.putId($1, tipo);};

L: L S {$$ = SemanticAcc.Sent((Sentencia)$1,(Sentencia)$2);}
    | S {$$ = SemanticAcc.Sent((Sentencia)$1);};

S:IF LPAR Bb RPAR S %prec IFX {$$ = SemanticAcc.If((Bool)$3, (Sentencia)$5);}
    | IF LPAR Bb RPAR S ELSE S {$$ = SemanticAcc.IfElse((Bool)$3, (Sentencia)$5, (Sentencia)$7);}
    | ID Oa E PTOYC{$$= SemanticAcc.Asig($1,$2,(Expresion)$3);};
    
Bb: Bb OR Bb {$$ = SemanticAcc.Or((Bool)$1, (Bool)$3);}
    | Bb AND Bb {$$ =SemanticAcc.And((Bool)$1, (Bool)$3);}
    | E Or E {$$=SemanticAcc.Exp((Expresion)$1,$2,(Expresion) $3);};
    
Oa: ASIG{$$="=";}| ADDASIG{$$="+=";} | MENOSASIG{$$="-=";} | MULASIG{$$="*=";} | DIVASIG{$$="/=";} | PORCASIG{$$="%=";};
    
Or: MENOR{$$="<";} | MAYOR {$$=">";}| EQUAL{$$="==";} | MAYOR_IGUAL{$$=">=";} | MENOR_IGUAL{$$="<=";} | DISTINTO{$$="!=";};

E: E ADD Et {$$ = SemanticAcc.Add((Expresion)$1, (Expresion)$3);}
    | Et {$$ = $1;} ;
    
Et: Et MUL Ef {$$ = SemanticAcc.Mul((Expresion)$1,(Expresion) $3);}
    | Ef {$$ = $1;} ;
    
Ef: LPAR E RPAR{$$ = $2;}
    | ID {$$ =SemanticAcc.getId($1);}
    | NUM{$$ =SemanticAcc.getNum((Number)$1);};
    | STR{$$ =SemanticAcc.getStr((String)$1);};
    | CHR{$$ =SemanticAcc.getChr((Char)$1);}; 
    
%%

JTextArea ts;
int tipo, width;

// Referencia al analizador Léxicio
Yylex lexer;

/*
 * Constructor: recibe una referencia del archivo a leer
 * y crea el objeto del analizador léxico
 */
public Parser(Reader r, JTextArea ts){
    lexer = new Yylex(r, this) ;
    this.ts = ts;
    SemanticAcc.yyparser = this;
}
    
/*
 * Método que encapsula el método yylex de la clase Yylex
 * retorna el token siguiente.
 */
private int yylex (){
    int yyl_return = -1;
    try{  
        yylval = new ParserVal(0);
        yyl_return = lexer.yylex();
    }catch (IOException e){
        System.err.println("error de E/S:"+e);
    }
    return yyl_return;
}

/*
 * Método para el manejo de errores
 */
public void yyerror (String msg) 
{
    System.err.println("Error en línea "+Integer.toString(lexer.getYyline())+" : "+msg);
}


