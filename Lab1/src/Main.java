import hero.Hero;
import move.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        int num = -1;
        String myString = "";
        System.out.println("Для изменения перемещения персонажа различными способами введите:");
        System.out.println("0 - идет пешком");
        System.out.println("1 - едет на лошади");
        System.out.println("2 - летит");
        System.out.println("Для завершения работы программы введите - 3");

        Scanner in = new Scanner(System.in);
        String str = "";
        while(num != 3) {
            if(in.hasNextInt()){
                num = in.nextInt();
                switch(num){
                    case(0) -> hero.setMoveStrategy(new Walk());
                    case(1) -> hero.setMoveStrategy((new RideOnHorse()));
                    case(2) -> hero.setMoveStrategy(new Flying());
                }
                hero.move();
            }
            else{
                str = in.next();
                System.out.println("You need to enter the number!");
            }
        }
        in.close();
    }
}