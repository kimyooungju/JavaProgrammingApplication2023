//학번:2020136058
//이름: 김용주


public class PokemonGame extends Weapons {
    public static void main(String[] args) {
//        Pokemon p0 = new Pokemon();
//        p0.attack();
//        p0.evolve();
        Charizard c1 = new Charizard();
        Squirtle s1 = new Squirtle();
        Pikachu p1 = new Pikachu();
        //  Pokemon c1 = new Charizard();  // upcast

        s1.setWeapon(new Weapons.Weapon() {
            @Override
            public void weaponattack() {
                System.out.println("집행검을 사용합니다");
            }
        });
        p1.setWeapon(new Weapons.Bow());
        c1.setWeapon(new Weapons.Sword());

        p1.perforeWeapon();
        c1.perforeWeapon();
        s1.perforeWeapon();


    }
}
