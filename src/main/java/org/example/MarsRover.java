package org.example;
public class MarsRover {
    private int x;  // Posición en el eje x
    private int y;  // Posición en el eje y
    private char direction;  // Dirección (N, S, E, O)

    public MarsRover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public boolean checkPosition(int x, int y, char direction) {
        return this.x == x && this.y == y && this.direction == direction;
    }

    public void processCommands(String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'F':  // Mover hacia adelante
                    moveForward();
                    break;
                case 'B':  // Mover hacia atrás
                    moveBackward();
                    break;
                case 'L':  // Girar a la izquierda
                    turnLeft();
                    break;
                case 'R':  // Girar a la derecha
                    turnRight();
                    break;
                default:
                    // Comando inválido, puedes lanzar una excepción o manejarlo según tus necesidades
                    break;
            }
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
        }
    }

    private void moveBackward() {
        switch (direction) {
            case 'N':
                y--;
                break;
            case 'S':
                y++;
                break;
            case 'E':
                x--;
                break;
            case 'W':
                x++;
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'W':
                direction = 'S';
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }
}