import Operaciones.Operaciones;

public class Main {

    public static void main(String[] args) {

        float a = Operaciones.validarEntrada();
        float b = Operaciones.validarEntrada();

        salida(a, b);
    }

    //Metodo de salida

    public static void salida(float a, float b) {

        Operaciones.sumar(a, b);
        Operaciones.restar(a, b);
        Operaciones.multiplicar(a, b);
        Operaciones.dividir(a, b);
        Operaciones.exponente(a, b);
        Operaciones.calRaiz(a, b);
        Operaciones.calLog(a, b);

    }
}
