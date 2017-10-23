/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Joe Thornton
 * Homework 1
 * Recognizer for simple expression grammer
 * 
 * to run on Athena (linux)
 * save as Recursivedecent.java
 * compile javac Recursivedecent.java
 * execute java Recursivedecent
 */
public class Recursivedecent {
    private String input;
    private int index;
    private boolean error=false;
    public Recursivedecent(String input){
        this.input=input;
        index=0;
        first();
    }
    private void advanceptr(){
        if(index<input.length()-1){
            index++;
        }
    }
    private char token(){
        if(index<=input.length()-1){
            return input.charAt(index);
        }else{
            error=true;
            input="q";
        }
        return 0;
    }
    private void match(char t){
        if(t == token()){
            advanceptr();
        }else{
           error=true;
           input="q";
        }
        
    }
    private void error(){
        error=true;
        System.out.println("error at index: "+index);
        input="q";
        advanceptr();
    }
    private void first(){
        piece();
        match('$');
        if(error==false){
            System.out.println("legal" );
        }else
            error();
    }
    private void piece(){
        if(error==false){
            while(token()=='u'||token()=='w'||token()=='x'||token()=='y'||token()=='p'||
                token()=='i'){
                stmnt();
                match(';');
            }
            if(token()=='r'||token()=='k'){
                lststmnt();
                match(';');
            }
        }
    }
    private void block(){
        if(error==false)
            piece();
    }
    private void stmnt(){
        if(error==false){
            if(token()=='w'){
                whilst();
            }
            if(token()=='i'){
                ifst();
            }
            if(token()=='p'){
                forst();
            }
            if(token()=='u'||token()=='y'||token()=='x'){
                assignst();
            }
        }
    }
    private void assignst(){
        if(error==false){
            if(token()=='u'||token()=='x'||token()=='y'){
                varlist();
                match('=');
                explst();
            }
        }
    }
    private void whilst(){
        if(error==false){
            match('w');
            expr();
            match('d');
            block();
            match('e');
        }
    }
    private void ifst(){
        if(error==false){
            match('i');
            expr();
            match('t');
            block();
            if(token()=='s'){
                match('s');
                block();
            }
            match('e');
        }
    }
    private void forst(){
        if(error==false){
            match('p');
            varname();
            match('=');
            expr();
            match(',');
            expr();
            if(token()==','){
                match(',');
                expr();
            }
            match('d');
            block();
            match('e');
        }
    }
    private void lststmnt(){
        if(error==false){
            if(token()=='r'){
                match('r');
                if(token()=='n'||token()=='f'||token()=='v'||token()=='0'||token()=='1'
                ||token()=='2'||token()=='3'||token()=='4'||token()=='5'||token()=='u'||
                token()=='x'||token()=='y'||token()=='('||token()=='-'||token()=='&'||token()=='#'){
                    explst();
                }
            }
            else{
                match('k');
            }
        }
    }
    private void varlist(){
        if(error==false){
            varname();
            while(token()==','){
                varname();
            }
        }
    }
    private void explst(){
        if(error==false){
            expr();
            match(',');
            while (token()=='n'||token()=='f'||token()=='v'||token()=='0'||token()=='1'
               ||token()=='2'||token()=='3'||token()=='4'||token()=='5'||
               token()=='u'||token()=='x'||token()=='y'||token()=='('||
               token()=='-'||token()=='&'||token()=='#'){
                expr();
                match(',');
            }
        }
    }

    private void expr(){
        if(error==false){
            if(token()=='n'||token()=='f'||token()=='v'||token()=='0'||token()=='1'||
                token()=='2'||token()=='3'||token()=='4'||token()=='5'||
                token()=='u'||token()=='x'||token()=='y'||token()=='(')
            {
                term();
                if(token()=='+'||token()=='-'||token()=='*'||token()=='/'||token()=='<'
                    ||token()=='>'||token()=='a'||token()=='o')
                {
                    binop();
                    expr();
                }
            }else if(token()=='-'||token()=='&'||token()=='#'){ 
                unop();
                expr();
            }
        }
    }
    private void term(){
        if(error==false){
            switch (token()) {
                case 'n':
                case 'f':
                case 'v':
                    match(token());
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                    num();
                    break;
                case 'u':
                case 'x':
                case 'y':
                    varname();
                    break;
                default:
                    match('(');
                    expr();
                    match(')');
                    break;
            }
            
        }
    }
    private void binop(){
        if(error==false){
            if(token()=='+'||token()=='-'||token()=='*'||token()=='/'||token()=='<'
                ||token()=='>'||token()=='a'||token()=='o')
            {
                match(token());
            }else
                match('+');
        }
    }
    private void unop (){
        if(error==false){
            if(token()=='-'||token()=='&'||token()=='#'){
                match(token());
            }else
                match('-');
        }
    }
    private void varname(){
        if(error==false){
            letter();
            while(token()=='u'||token()=='x'||token()=='y'||token()=='1'||token()=='2'||token()=='3'||token()=='4'||token()=='5'||token()=='0'){
                if(token()=='u'||token()=='x'||token()=='y')
                {
                    letter();
                }else
                    digit();
            }
        }
    }
    private void num(){
        if(error==false){
            digit();
            while(token()=='1'||token()=='2'||token()=='3'||token()=='4'||token()=='5'||token()=='0'){
                digit();
            }
        }
    }
    private void letter(){
        if(error==false){
            if(token()=='u'||token()=='x'||token()=='y'){
                match(token());
            }else
                match('u');
        }
    }
    private void digit(){
        if(error==false){
            if(token()=='1'||token()=='2'||token()=='3'||token()=='4'||token()=='5'||token()=='0'){
                match(token());
            }else
                match('1');
        }
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while(true){
            System.out.println("input string ");
            String input = in.nextLine();
            Recursivedecent rec=new Recursivedecent(input);
        }
        
        
    }
    
}
