package Pokemonster;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PokemonGame {
    public static void main(String[] args) {
        System.out.println("포켓몬 게임을 시작합니다/n야생 포켓몬이 나타낫습니다");
      //  System.out.println(Math.random());   //범위 0.0 <= x < 1.0
      //  System.out.println((int)(Math.random() * 6)+1);   //범위 1 <= x < 6
        
        //적군 랜덤 생성 코드
        Pokemon enemy = null;
        int enemyPick = (int)(Math.random() * 3);
        System.out.println(enemyPick);
        if(enemyPick == 0){
            NoFly noFly = new NoFly();
            enemy = new Pikachu(noFly);
        }else if(enemyPick == 1){
            NoFly noFly = new NoFly();
            enemy = new Squirtle(noFly);
        }else if(enemyPick == 2){
            Wings wings = new Wings();
            enemy = new Charizard(wings);
        }else{
            System.out.println("여기는 영원히 실행이 안됩니다");
        }

        try {
            //플레이어 포켓몬스터 선택
            //Pokemon player = new Pokemon(); //추상클래스는 객체 생성 불가
            Pokemon player = null; //추상클래스의 변수 선언은 가능 (upcasting 용)
            Scanner scanner = new Scanner(System.in);
            System.out.println("포켓몬을 고르세요.\n1) 피카츄   2) 꼬부기   3)리자몽 : ");
            int pokemonPick = scanner.nextInt();
            if (pokemonPick == 1) {
                player = new Pikachu(new NoFly());
            } else if (pokemonPick == 2) {
                player = new Squirtle(new NoFly());
            } else if (pokemonPick == 3) {
                player = new Charizard(new NoFly());
            } else {
                System.out.println("정상적인 값이 아닙니다");
            }
            int menu, skillMenu;
            while (true) {
                System.out.println("\t1) 전투   2) 도망   3) 종료 : ");
                menu = scanner.nextInt();
                if (menu == 1) {
                    System.out.print("전투 기술 : 1)" + player.skills.get(0) + "   2) " + player.skills.get(1) + "   3) " + player.skills.get(2) + "  : ");
                    skillMenu = scanner.nextInt();
                    player.attack(enemy, skillMenu);
                    enemy.attack(player, (int) (Math.random() * 3) + 1);
                    // player.attack(enemy, scanner.next());
                } else if (menu == 2) {

                } else {
                    System.out.println("게임을 종료합니다.");
                    break;
                }
            }
        }catch (InputMismatchException err){
            System.out.println("입력 값은 숫자가 아닙니다");
            System.out.println(" 예외 내용 : " + err.getMessage());
        }catch(Exception err){
            System.out.println("예외가 발생했습니다.");
            System.out.println(" 예외 내용 : " + err.getMessage());
        }finally {
            System.out.println("프로그램 종료");
        }
    }
}
