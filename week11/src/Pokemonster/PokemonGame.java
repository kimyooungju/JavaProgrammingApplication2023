package Pokemonster;

import fly.NoFly;
import fly.Wings;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PokemonGame {
    public static Pokemon enemy = null;
    public static void main(String[] args) {
        System.out.println("포켓몬 게임을 시작합니다.");
      //  System.out.println(Math.random());   //범위 0.0 <= x < 1.0
      //  System.out.println((int)(Math.random() * 6)+1);   //범위 1 <= x < 6
        

        try {
            //플레이어 포켓몬스터 선택
            //Pokemon player = new Pokemon(); //추상클래스는 객체 생성 불가
            Pokemon player = null; //추상클래스의 변수 선언은 가능 (upcasting 용)
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("포켓몬을 고르세요.\n1) 피카츄   2) 꼬부기   3)리자몽 : ");
                int pokemonPick = scanner.nextInt();
                if (pokemonPick == 1) {
                   // player = new Pikachu(new NoFly());
                    player = new Pikachu(()-> System.out.println("로켓 추진기로 날아갑니다"));//람다식은 1회성
                    break;
                } else if (pokemonPick == 2) {
                    player = new Squirtle(new NoFly());
                    break;
                } else if (pokemonPick == 3) {
                    player = new Charizard(new Wings());
                    break;
                } else {
                    System.out.println("정상적인 값이 아닙니다");
                }
            }

            produceEnemy();  // 적군 생성 (함수생성)

            int menu, skillMenu;
            while (true) {
                System.out.println("\t1) 전투   2) 도망   3) 물약(힐포션)  4) 종료 : ");
                menu = scanner.nextInt();
                if (menu == 1) {
                    while(true) {
                        System.out.print("전투 기술 : 1)" + player.skills.get(0) + "   2) " + player.skills.get(1) + "   3) " + player.skills.get(2) + "  : ");
                        skillMenu = scanner.nextInt();
                        if(skillMenu <= player.skills.size()){
                            player.attack(enemy, skillMenu);
                            enemy.attack(player, (int)(Math.random() * 3) + 1);
                            //    System.out.println("사용 할 수 있는 기술이 아닙니다.");
                            // player.attack(enemy, scanner.next());
                            break;
                        }else{
                            System.out.println("메뉴에서 공격기술을 선탟하세요.");
                        }
                    }
                } else if (menu == 2) {
                    player.performFly();
                    System.out.println("현재 지역을 탈출합니다!");
                    produceEnemy();
                } else if (menu == 3) {
                    System.out.println("게임을 종료합니다.");

                } else if (menu == 4) {
                    System.out.println("게임을 종료합니다.");
                    break;
                } else {
                    System.out.println("메뉴에서 선택하세요");
                }
            }
        }catch (InputMismatchException err){
            System.out.println("입력 값은 숫자가 아닙니다");
            System.out.println(" 예외 내용 : " + err.getMessage());
        }catch(NullPointerException err) {
            System.out.println("플레이어 객체가 생성되지 않았습니다.");
            System.out.println(" 예외 내용 : " + err.getMessage());
        }catch(IndexOutOfBoundsException err) {
            System.out.println("존재하지 않는 스킬입니다. 기술 범위를 벗어남.");
            System.out.println(" 예외 내용 : " + err.getMessage());
        }catch(Exception err) {
            System.out.println("예외가 발생했습니다.");
            System.out.println(" 예외 내용 : " + err.getMessage());
        }finally {
            System.out.println("프로그램 종료");
        }
    }

    private static void produceEnemy() {
        System.out.println("야생 포켓몬이 나타났습니다.");
        //적군 랜덤 생성 코드

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

    }
}
