import java.sql.SQLOutput;

public class PokemonGame {
    public static void main(String[] args) {
        System.out.println("포켓몬 게임을 시작합니다/n야생 포켓몬이 나타낫습니다");
      //  System.out.println(Math.random());   //범위 0.0 <= x < 1.0
      //  System.out.println((int)(Math.random() * 6)+1);   //범위 1 <= x < 6
        
        //적군 랜덤 생성 코드
        int enemyPick = (int)(Math.random() * 3);
        System.out.println(enemyPick);
        if(enemyPick == 0){
            NoFly noFly = new NoFly();
            Pikachu pikachu = new Pikachu(noFly);
        }else if(enemyPick == 1){
            NoFly noFly = new NoFly();
            Squirtle pikachu = new Squirtle(noFly);
        }else if(enemyPick == 2){
            Wings wings = new Wings();
            Charizard pikachu = new Charizard(wings);
        }else{
            System.out.println("여기는 영원히 실행이 안됩니다");
        }

    }
}
