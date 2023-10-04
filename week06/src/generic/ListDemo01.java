package generic;

import java.util.ArrayList;
import java.util.List; // built in

import Pokemonster.Pikachu;
import Pokemonster.Charizard;
import Pokemonster.Squirtle;

public class ListDemo01 {
    public static void main(String[] args) {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pikachu(new NoFly()));
        pokemons.add(new Squirtle(new NoFly()));
        pokemons.add(new Charizard(new Wings()));

        for(Pokemon p : pokemons)
            p.attack();
    }
}