import java.util.Scanner;
import java.util.Random;
import java.util.*;

class pacman{
    int x;
    int y;
    public pacman(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void move() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("enter < > ^ v: ");
        System.out.println();
        char dir = sc.next().charAt(0);

        int newx = x;
        int newy = y;
        gameboard.gamegrid[y][x] = ' ';

        if (dir == '^') newy--;
        else if (dir == 'v') newy++;
        else if (dir == '>') newx++;
        else if (dir == '<') newx--;

        if (gameboard.gamegrid[newy][newx] != '#') {
            x = newx;
            y = newy;
        }
    }

}

class gameboard {
    static char[][] gamegrid = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','#','.','.','.','.','#','.','.','.','.','#'},
            {'#','.','#','.','#','.','#','#','.','#','.','#','#','.','#'},
            {'#','.','#','.','.','.','#','.','.','.','.','#','.','.','#'},
            {'#','.','#','#','#','.','#','.','#','#','#','#','.','#','#'},
            {'#','.','.','.','#','.','#','.','.','.','.','#','.','.','#'},
            {'#','#','#','.','#','.','#','#','#','#','.','#','#','.','#'},
            {'#','.','.','.','.','.','.','.','#','.','.','.','#','.','#'},
            {'#','.','#','#','#','#','#','.','#','.','#','.','#','.','#'},
            {'#','.','.','.','.','.','#','.','.','.','#','.','.','.','#'},
            {'#','#','#','#','#','.','#','#','#','.','#','#','#','#','#'},
            {'#','.','.','.','#','.','.','.','#','.','.','.','.','.','#'},
            {'#','.','#','.','#','#','#','.','#','#','#','#','#','.','#'},
            {'#','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
    };

    pacman p;
    ghost g;
    public gameboard(pacman p,ghost g){
        this.p=p;
        this.g=g;
    }

    void print() {
        for (int i = 0; i < gamegrid.length; i++) {
            for (int j = 0; j < gamegrid[i].length; j++) {

                if (i == p.y && j == p.x) {
                    System.out.print("\uD83D\uDC7D");
                }
                else if (i == g.y && j == g.x) {
                    System.out.print("\uD83D\uDC7B");}
                else {
                    System.out.print(gamegrid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
class food {

    public static void eat(int x, int y) {
        gameboard.gamegrid[y][x] = ' ';
    }
}
class ghost {
    int x;
    int y;
    int random;

    public ghost(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        int newx = x;
        int newy = y;

        Random r = new Random();
        int d = r.nextInt(4);

        if (d == 0) newy++;
        else if (d == 1) newy--;
        else if (d == 2) newx--;
        else newx++;

        if (newx >= 0 && newx < gameboard.gamegrid[0].length &&
                newy >= 0 && newy < gameboard.gamegrid.length &&
                gameboard.gamegrid[newy][newx] != '#') {

            x = newx;
            y = newy;
        }

    }
}
public class pacmangame__ {
    public static void main(String[] args) {
        pacman p = new pacman(1, 1);
        ghost g = new ghost(2, 3);
        gameboard gb = new gameboard(p, g);
        System.out.println();
        System.out.println();
        System.out.println("\uD83D\uDC7B\uD83D\uDC7B\uD83D\uDC7BEat the dots. Avoid the ghosts. Survive the maze\uD83D\uDC7B\uD83D\uDC7B\uD83D\uDC7B");
        System.out.println();
        System.out.println("welcome to the pacman game.");
        System.out.println();
        while (true) {
            gb.print();
            p.move();
            g.move();

            if (p.x == g.x && p.y == g.y) {
                System.out.println();
                System.out.println("Ghost ate you alive... :( ");
                System.out.println();
                System.out.println("Game by Aima.");
                break;
            }
        }
    }
}