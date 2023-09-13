//학번: 2020136058
//이름: 김용주



class Weapons {

    interface Weapon {
        void weaponattack();
    }


        public static class Bow implements Weapons.Weapon{

            public void weaponattack() {
                System.out.println("활로 화살을 쏩니다");
            }
        }

        public static class Sword implements Weapons.Weapon{
            public void weaponattack() {
                System.out.println("칼을 휘두릅니다");
            }
        }
        public void weaponattact() {
            System.out.println("집행검을 사용합니다");
        }

}



