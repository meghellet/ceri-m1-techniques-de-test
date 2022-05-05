package fr.univavignon.pokedex.api;

import org.junit.Test;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;

public class IPokemonFactoryTest {
    IPokemonFactory iPokemonFactory;
    Pokemon pokemon_1, pokemon_2;

    @Before
    public void init() {
        iPokemonFactory = mock(IPokemonFactory.class);
        pokemon_1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokemon_2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }
    @Test
    public void createPokemon() {
        when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon_1);
        when(iPokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pokemon_2);

        assertEquals(0, pokemon_1.getIndex());
        assertEquals("Aquali", pokemon_2.getName());
        assertEquals(133, pokemon_2.getIndex());
        assertEquals(4000, pokemon_1.getDust());
    }
}