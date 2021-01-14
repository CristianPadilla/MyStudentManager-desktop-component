package Modelo;

import javax.swing.JOptionPane;

public class Lectura {

    public static void mostrar(String mensaje) //metodo para mostrar un mensaje
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public static int leerEntero(String mensaje) //metodo para leer un dato de tipo string y convertirlo a entero
    {
        String N = JOptionPane.showInputDialog(mensaje);
        int n = Integer.parseInt(N);
        return n;
    }

    public static double leerDoble(String mensaje) //metodo para leer un dato string y convertirlo a double
    {
        String N = JOptionPane.showInputDialog(mensaje);
        double n = Double.parseDouble(N);
        return n;
    }

    public long leerLong(String mensaje) //metodo para leer un dato string y convertirlo a long
    {
        String N = JOptionPane.showInputDialog(mensaje);
        long n = Long.parseLong(N);
        return n;
    }

    public float leerFloat(String mensaje) {
        //metodo para leer un dato string y convertirlo a float
        String N = JOptionPane.showInputDialog(mensaje);
        float n = Float.parseFloat(N);
        return n;

    }

    public static String leerString(String mensaje) //metodo para leer un dato string y convertirlo a char
    {
        String N = JOptionPane.showInputDialog(mensaje);
        return N;

    }

}
