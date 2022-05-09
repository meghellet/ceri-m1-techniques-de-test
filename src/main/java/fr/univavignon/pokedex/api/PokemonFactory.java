package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
    PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata pokemonMetadata;
        Pokemon pokemon = null;
        try {
            pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
            int iv = 50;
            pokemon = new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp,  hp, dust, candy, iv );
        } catch (PokedexException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pokemon;

    }
}
