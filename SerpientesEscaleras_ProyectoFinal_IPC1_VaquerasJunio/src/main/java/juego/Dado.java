/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Danny
 */
public class Dado {
    
    //contructor por defecto 
    public Dado(){
    }
    
    //contructor con parametros 
    public static int tirarDado(int valorMinimo, int valorMaximo, int cantDados, boolean mostrarMensaje){
        int dado = valorMinimo;
        int resultado = valorMinimo;
        for (int i = 1; i <= cantDados; i++) {
            dado =(int) Math.floor(Math.random()*(valorMaximo-valorMinimo+1)+valorMinimo);
            if (mostrarMensaje)
                System.out.println("Se lanzó el "+i+"°"+" dado y su resultado fue: "+ dado);
            if (resultado < dado)
                resultado = dado;
        }
        if (cantDados > 1)
            if (mostrarMensaje)
                System.out.println("El resultado mayor de los "+cantDados + " lanzados es: "+resultado);
        return resultado;
    }
}

