/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;


/******************************************************************************
 *  
 *
 *  Polynomials with integer coefficients.
 *

 *
 ******************************************************************************/

public class Polynomial {
    private int[][] coef;  // coefficients
    private int degX;     // degree X of polynomial
    private int degY;     // degree Y of polynomial

    // a * (x^x)(y^y)
    public Polynomial(int a, int x,int y) {
        coef = new int[x+1][y+1];
        
        coef[x][y] = a;
        degX = degree("x");
        degY = degree("y");
    }

    // return the degree of this polynomial 
    public int degree(String degreeType) {
        int d = 0;
     
     
        for (int i = 0; i < coef.length; i++){
            for (int j = 0; j < coef[0].length; j++){
                if (coef[i][j] != 0){
                    if(degreeType=="x"){
                         if(i>d){
                             d = i;
                         }
                         
                    }
                    else{
                         if(j>d){
                             d = j;
                         }
                         
                    }
                }
            }
            
        }
            
        return d;
    }

    // return c = a + b
    public Polynomial plus(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, Math.max(a.degX, b.degX), Math.max(a.degY, b.degY));// new plynomial with max degree between a and b 
        //sum the variables with the same degree
    
        for (int i = 0; i <= a.degX; i++){
            for (int j = 0; j <= a.degY; j++){

                c.coef[i][j] += a.coef[i][j];
            }
           
        }
      
        for (int i = 0; i <= b.degX; i++){
            for (int j = 0; j <= b.degY; j++){

                c.coef[i][j] += b.coef[i][j];
            }
          
        }
        c.degX = c.degree("x");
        
        c.degY = c.degree("y");
     
        return c;
    }


 
    // return c = (a - b)
    public Polynomial minus(Polynomial b) {
Polynomial a = this;
        Polynomial c = new Polynomial(0, Math.max(a.degX, b.degX), Math.max(a.degY, b.degY));// new plynomial with max degree between a and b 
        //minus the variables with the same degree
 
        for (int i = 0; i <= a.degX; i++){
            for (int j = 0; j <= a.degY; j++){
 
                c.coef[i][j] += a.coef[i][j];
            }
           
        }
       
        for (int i = 0; i <= b.degX; i++){
            for (int j = 0; j <= b.degY; j++){

                c.coef[i][j] -= b.coef[i][j];
            }
          
        }
        c.degX = c.degree("x");

        c.degY = c.degree("y");

        return c;
    }
   
    // return (a * b)
    public Polynomial multiply(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, a.degX + b.degX,a.degY + b.degY);// new plynomial with max degree between the sum a and b 
        //multiply each variable
        for (int i = 0; i <= a.degX; i++){
            for (int j = 0; j <= a.degY; j++){
                for (int x = 0; x <= b.degX; x++){
                    for (int y = 0; y <= b.degY; y++){
                        c.coef[i+x][j+y] += (a.coef[i][j] * b.coef[x][y]);
                    }
                    
                }
                   
            }
        }

                
        c.degX = c.degree("x");
 
        c.degY = c.degree("y");

        return c;

    }



    // return the polynomial evaluated at x and y
    public int evaluate(int x, int y) {
        int p = 0;
        for (int i = degX; i >= 0; i--){
            for (int j = degY; j >= 0; j--){
                if(coef[i][j]!=0){
                    p = coef[i][j] + (x * p*y); 
                }
                 
            }
        }
            
        return p;
    }


    // convert to string representation
    public String toString() {
     
        String s = "";
        
        for (int i = degX; i >= 0; i--) {
            for (int j = degY; j >= 0; j--) {
                if      (coef[i][j] == 0) continue;
                else if (coef[i][j]  > 0){
                    if(s.isEmpty()==false){
                        s = s + " + " ;
                    }
                    s = s +  ( coef[i][j]);
                }
                else if (coef[i][j]  < 0){
                    if(s.isEmpty()==false){
                         s = s + " - ";
                    }
                    s = s  + (-coef[i][j]);
                }
                if      (i == 1) s = s + "x";
                else if (i >  1) s = s + "x^" + i;
                if      (j == 1) s = s + "y";
                else if (j >  1) s = s + "y^" + j;
            }
        
        }
        return s;
    }

    // test client
    public static void main(String[] args) { 
      

        Polynomial p1   = new Polynomial(4, 3,1);// 4x^3y
        System.out.println(" hola 1    " + p1 );
        Polynomial p2   = new Polynomial(3, 2,2);//  3x^2y^2
        System.out.println(" hola 2    " + p2);
        Polynomial p3   = new Polynomial(1, 0,1);//1y
        System.out.println(" hola 3    " + p3);
        Polynomial p4   = new Polynomial(2, 1,4);//2xy^4
        System.out.println(" hola 4    " + p4);
        Polynomial p1_2    = p1.plus(p2);   // (4x^3y) + (3x^2y^2) 
        System.out.println(" p1   " + p1_2 );
        Polynomial p1_2_3    = p1_2.plus(p3); // (4x^3y + 3x^2y^2) + 1y 
        System.out.println(" p2   " + p1_2_3 );
        Polynomial p   = p1_2_3.plus(p4); // (4x^3y + 3x^2y^2 + 1y) + 2xy^4
        System.out.println(" p3   " + p );

        Polynomial q1   = new Polynomial(3, 2,0);// 3x^2
        System.out.println(" hola 5    " + q1);
        Polynomial q2   = new Polynomial(5, 0,1);// 5y
        System.out.println(" hola 6    " + q2);
        Polynomial q    = q1.plus(q2);                     // 3x^2 + 5y
        System.out.println(" q  " + q );


        Polynomial r    = p.plus(q);//( 4x^3y + 3x^2y^2 + 1y + 2xy^4) + (  3x^2 + 5y)
        Polynomial t    = p.minus(q);//( 4x^3y + 3x^2y^2 + 1y + 2xy^4) - (  3x^2 + 5y)
        
        Polynomial s    = p.multiply(q);//( 4x^3y + 3x^2y^2 + 1y + 2xy^41) * (  3x^2 + 5y)
      

        System.out.println("p(x) =        " + p);
        System.out.println("q(x) =        " + q);
        System.out.println("p(x) - q(x) = " + t);
        System.out.println("p(x) + q(x) = " + r);
        

        System.out.println("p(x) * q(x) = " + s);
        System.out.println("p(3)        = " + p.evaluate(3,1));
   
   }

}



