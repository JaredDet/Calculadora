package modelo;

public class Calculadora {

    public Calculadora() {

    }

    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public boolean validarDivisionPorCero(double num2){
        return num2 != 0;
    }
    public double dividir(double num1, double num2) {

        return num1/num2;
    }
    public double modulo(double num1, double num2){

        return num1%num2;
    }

    public double potencia(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    private double raiz(double num1, double num2) {
        return Math.pow(num1, 1.0 / num2);
    }

    public boolean metodoRaiz(double num1, double num2) {
        if (num2 != 0) {
            return true;
        }
        System.err.print("No se puede dividir por cero" + "\n");
        System.out.println();
        return false;
    }

    private double logaritmo(double num1, double num2) {

        return Math.log10(num1) / Math.log10(num2);
    }

    public boolean metodoLogaritmo(double num1, double num2) {

        if (num1 > 0 && num2 > 0) {
            return true;
        }
        System.err.print("El logaritmo no está definido para los no naturales" + "\n");
        System.out.println();
        return false;
    }
}
