/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.io.Serializable;

/**
 *
 * @author Danny
 */
public class Jugador extends Fichas implements Serializable{
    private String nombre;
    private int turno;
    private int tableroXI;
    private int tableroYI;
    private int tableroXF;
    private int tableroYF;
    private int contadorSeis;
    
    public Jugador(String nombre, int lugar, int posicionX, int posicionY, int tableroXF, int tableroYF) {
        this.nombre = nombre;
        this.posicionX = tableroXI = posicionX;
        this.posicionY = tableroYI = posicionY;
        this.lugar = lugar;
        this.turno = lugar;
        this.tableroXF = tableroXF;
        this.tableroYF = tableroYF;
    }
    
    /**
     * Revisa si el dado cayo tres veces seis
     * @param movimientos 
     */
    private void dadoTresVecesSeis(int movimientos) {
        if (contadorSeis != 3) {
            if (movimientos == 6) {
                contadorSeis++;
                if(contadorSeis == 3) {
                    posicionX = tableroXI;
                    posicionY = tableroYI;
                   
                }
            } else {
                contadorSeis = 0;
            }
        } else {
            if (movimientos != 6) {
                
                posicionX = tableroXI;
                posicionY = tableroYI;
            } else {
                
                contadorSeis = 0;
            }
        }
    }
    
    /**
     * Funcion mover Jugador. Mueve la ficha jugador a la siguiente casilla 
     * correspondiente a la forma del tablero.
     * 
     * Si posicionX es par se ejecutara un algoritmo propio.
     * Si posicionX es impar: se ejecutara un algoritmo diferente al par
     * 
     * @param movimientos 
    }
    */
    public void mover(int movimientos) {
        int posicionAnteriorX = posicionX, posicionAnteriorY = posicionY, movimientosAnterior = movimientos;
        if(posicionX % 2 != 0) {
            if (!((posicionY + movimientos > tableroYF) && (posicionX == tableroXF))) {
                if(posicionY + movimientos > 7) {
                    while(posicionY != 7) {
                        posicionY++;
                        movimientos--;
                    }
                    posicionY = 8-movimientos;
                    posicionX--;
                    if (tableroXF == posicionX && tableroYF > posicionY) {
                        posicionY = posicionAnteriorY;
                        posicionX = posicionAnteriorX;
                        
                    }
                } else {
                    posicionY = posicionY + movimientos;
                }
                
            } 
        } else {
            if (!((posicionY - movimientos < tableroYF) && (posicionX == tableroXF))) {
                if(posicionY - movimientos < 0) {
                    while(posicionY != 0) {
                        posicionY--;
                        movimientos--;
                    }
                    posicionY = posicionY + movimientos -1;
                    posicionX--;
                    if (tableroXF == posicionX && tableroYF < posicionY) {
                        posicionY = posicionAnteriorY;
                        posicionX = posicionAnteriorX;
                       
                    }
                } else {
                    posicionY = posicionY - movimientos;
                }
           
            } 
        }
        dadoTresVecesSeis(movimientosAnterior);
    }

    public String getNombre() {
        return nombre;
    }
    
    public int getTurno() {
        return turno;
    }
    
    public void setTurno(int turno) {
        this.turno = turno;
    }

}
