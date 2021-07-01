package Operaciones;

import java.util.Scanner;

import static java.lang.Math.pow;

public class Operaciones {

    //Metodos

    //Metodo para sumar dos numeros

    public static void sumar(float numero1, float numero2) {

        System.out.println(numero1 + numero2);
    }

    //Metodo para restar dos numeros

    public static void restar(float numero1, float numero2) {

        System.out.println(numero1 - numero2);
    }

    //Metodo para multiplicar dos numeros

    public static void multiplicar(float numero1, float numero2) {

        System.out.println(numero1 * numero2);
    }

    //Metodo para dividir dos numeros

    public static void dividir(float numero1, float numero2) {

        try{

            System.out.println(numero1 / numero2);

        }catch(ArithmeticException cero){

            System.out.println("Imposible dividir por 0");
        }
    }

    //Metodo para elevar un numero respecto a otro

    public static void exponente(float numero1, float numero2){

        System.out.println(pow(numero1, numero2));
    }

    //Metodo para sacar la raiz de un numero respecto a otro

    public static void calRaiz(float numero1, float numero2) {

        try {

            System.out.println(pow(numero1, 1.0 / numero2));

        } catch (ArithmeticException ex) {

            System.out.println("Imposible dividir por 0");

        }
    }

    //Metodo para calcular el logaritmo de un numero respecto a otro

        public static void calLog(float numero1, float numero2){

            try {

                System.out.println((Math.log10(numero1)/Math.log10(numero2)));

            } catch (ArithmeticException ex) {

                System.out.println("Imposible dividir por 0");

            }
    }

    //Metodo que crea una entrada

    public static String Entrada(){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese numero");

        String entrada = teclado.nextLine();

        return entrada;
    }

    //Metodo que valida una entrada

    public static float validarEntrada(){

        float entrada = 0;
        try{
            entrada = Float.parseFloat(Entrada());

        }
        catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
            entrada = validarEntrada();
        }
        return (entrada);
    }
}
