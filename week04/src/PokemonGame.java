
public class PokemonGame {
    public static void main(String[] args) {
        NoFly noFly = new NoFly();
        Pikachu pikachu = new Pikachu(noFly);  // Association 연관관계, Has-a (Aggregation) //pikachu 객체가 없어져도 nofly객체 다른객체에 사용가능
       // pikachu.setFlyable(new NoFly()); // 프로그램 실행 중 동적으로 하늘을 나는 방식 변경

        pikachu.performFly();
    }
}
