package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

    IPokemonMetadataProvider PokemonMetadataProvider = null;
    ArrayList<Pokemon> listPokemons;

    IPokemonFactory pokemonFactory = null;


    public Pokedex(IPokemonMetadataProvider PokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.listPokemons = new ArrayList<>();
        this.PokemonMetadataProvider = PokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return listPokemons.size();
        //return 0;
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        listPokemons.add(pokemon);
        int newLitsPockemons = listPokemons.size() - 1 ;
        return newLitsPockemons ;
        //return 0;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if(id > 150 || id < 0){
            throw new PokedexException("L'id n'est pas compris entre 0 et 150 !");
        }
        Pokemon SearchPockemon = listPokemons.get(id);
        return SearchPockemon ;
    }

    public List<Pokemon> getPokemons(){

        return listPokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        // TODO Auto-generated method stub
        List<Pokemon> listTrierByOrder = new ArrayList<>(this.listPokemons);
        listTrierByOrder.sort(order);
        return listTrierByOrder;

        //return null;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return  pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        //return null;
    }


}
