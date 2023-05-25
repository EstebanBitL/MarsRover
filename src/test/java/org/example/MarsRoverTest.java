package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarsRoverTest {

    @Test
    public void testInitialPositionAndDirection() {
        MarsRover rover = new MarsRover(1, 1, 'N');
        assertTrue(rover.checkPosition(1, 1, 'N'));
    }

    @Test
    public void testCheckPosition() {
        MarsRover rover = new MarsRover(2, 3, 'S');

        assertTrue(rover.checkPosition(2, 3, 'S'));
        assertFalse(rover.checkPosition(1, 1, 'N'));
        assertFalse(rover.checkPosition(1,1,'W'));
        assertFalse(rover.checkPosition(1,1, 'O'));
    }

    @Test
    public void testMoveForward() {
        MarsRover rover = new MarsRover(0, 0, 'N');
        rover.processCommands("FF");//adelante ++

        assertTrue(rover.checkPosition(0, 2, 'N'));

        rover = new MarsRover(0, 0, 'S');
        rover.processCommands("F");//adelante

        assertTrue(rover.checkPosition(0, -1, 'S'));

        rover = new MarsRover(0, 0, 'W');
        rover.processCommands("FL");//adelante izquier

        assertTrue(rover.checkPosition(-1,0,'S'));

        rover = new MarsRover(0, 0, 'E');
        rover.processCommands("FR");//adelante der

        assertTrue(rover.checkPosition(1,0,'S'));
    }

    @Test
    public void testMoveBackward() {
        MarsRover rover = new MarsRover(0, 0, 'N');
        rover.processCommands("BB");
        assertTrue(rover.checkPosition(0, -2, 'N'));

        rover = new MarsRover(0, 0, 'S');
        rover.processCommands("B");
        assertTrue(rover.checkPosition(0, 1, 'S'));
    }

    @Test
    public void testTurnLeft() {
        MarsRover rover = new MarsRover(0, 0, 'N');
        rover.processCommands("L");
        assertTrue(rover.checkPosition(0, 0, 'W'));

        rover = new MarsRover(0, 0, 'E');
        rover.processCommands("LLL");
        assertTrue(rover.checkPosition(0, 0, 'S'));
    }

    @Test
    public void testTurnRight() {
        //va a la direccion este desde la posicion 0
        MarsRover rover = new MarsRover(0, 0, 'N');
        rover.processCommands("R");
        assertTrue(rover.checkPosition(0, 0, 'E'));

        //va a la direccion oeste desde la posicion 0 queda mirando al sur
        rover = new MarsRover(0, 0, 'W');
        rover.processCommands("RRR");
        assertTrue(rover.checkPosition(0, 0, 'S'));
    }

    @Test
    public void testCadenaDeComandos_1(){
        MarsRover rover = new MarsRover(1, 1, 'N');
        rover.processCommands("FB");
        //hace adelante atras pero siempre queda mirando al norte camino feliz
        assertTrue(rover.checkPosition(1,1,'N'));
        //hace adelante atras pero siempre queda mirando al norte camino triste
        assertFalse(rover.checkPosition(1,1,'S'));
    }

    @Test
    public void testCadenaDeComandos_2(){
        MarsRover rover = new MarsRover(1, 1, 'N');
        rover.processCommands("LFR");
        //le paso izq,adel,der queda mirando al norte
        assertTrue(rover.checkPosition(0,1,'N'));
    }

    @Test
    public void testCadenaDeComandos_3FF(){
        MarsRover rover = new MarsRover(1, 1, 'N');
        rover.processCommands("FF");
        //cadena complicada tuve que imitar el rover
        assertTrue(rover.checkPosition(1,3,'N'));
    }
    @Test
    public void testCadenaDeComandos_3FFR(){
        MarsRover rover = new MarsRover(1, 1, 'N');
        rover.processCommands("FFR");
        assertTrue(rover.checkPosition(1,3,'E'));
    }
    @Test
    public void testCadenaDeComandos_3FFRFF(){
        MarsRover rover = new MarsRover(1, 1, 'N');
        rover.processCommands("FFRFF");
        assertTrue(rover.checkPosition(3,3,'E'));
    }
    @Test
    public void testCadenaDeComandos_3FFRFFL(){
        MarsRover rover = new MarsRover(1, 1, 'N');
        rover.processCommands("FFRFFL");
        assertTrue(rover.checkPosition(3,3,'N'));
    }
    @Test
    public void testCadenaDeComandos_3FFRFFLF(){
        MarsRover rover = new MarsRover(1, 1, 'N');
        rover.processCommands("FFRFFLF");
        assertTrue(rover.checkPosition(3,4,'N'));
    }
    @Test
    public void testCadenaDeComandos_3FFRFFLFR(){
        MarsRover rover = new MarsRover(1, 1, 'N');
        rover.processCommands("FFRFFLFR");
        assertTrue(rover.checkPosition(3,4,'E'));
    }

    @Test
    public void testCadenaDeComandos_3FFRFFLFRFF(){
        MarsRover rover = new MarsRover(1, 1, 'N');
        rover.processCommands("FFRFFLFRFF");
        //cadena complicada tuve que imitar el rover
        assertTrue(rover.checkPosition(5,4,'E'));
    }
}