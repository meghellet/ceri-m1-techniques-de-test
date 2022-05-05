package fr.univavignon.pokedex.api;

import org.junit.Test;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.mockito.*;

public class IPokedexTest {
    public static List<Pokemon> pokedex;
    IPokedex iPokedex;
    IPokemonFactory iPokemonFactory;
    IPokemonMetadataProvider iPokemonMetadataProvider;

    @Before
    public void init() {
        iPokedex = mock(IPokedex.class);
        iPokemonFactory = mock(IPokemonFactory.class);
        iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        pokedex = new ArrayList<Pokemon>();
    }

    @Test
    public void size() {
        addPokemon();
        when(iPokedex.size()).thenReturn(pokedex.size());
        assertEquals(iPokedex.size(), 2);
        assertEquals(iPokedex.size(), pokedex.size());
    }

    @Test
    public void addPokemon() {
        Pokemon pok1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pok2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        pokedex.add(pok1);
        pokedex.add(pok2);

        when(iPokedex.addPokemon(pok1)).thenReturn(pok1.getIndex());
        when(iPokedex.addPokemon(pok2)).thenReturn(pok2.getIndex());

        assertEquals(iPokedex.addPokemon(pok1), 0);
        assertEquals(iPokedex.addPokemon(pok2), 133);
    }
    public Pokemon getPokemonIndex(int index) throws PokedexException {
        for(int i=0; i < pokedex.size(); i++) {
            if(pokedex.get(i).getIndex() == index)
            {
                return pokedex.get(i);
            }
        }
        throw new PokedexException("L'index Est incorrect => 0 < Index <150 ");
    }

    @Test
    public void getPokemon() throws PokedexException {
        addPokemon();

        when(iPokedex.getPokemon(Mockito.anyInt())).thenReturn(getPokemonIndex(0));
        assertEquals(pokedex.get(0), getPokemonIndex(0));
        assertEquals(pokedex.get(1), getPokemonIndex(133));
    }



    @Test
    public void getPokemons() {
        addPokemon();
        List<Pokemon> listPokemon = new ArrayList<Pokemon>();

        for(Pokemon p: pokedex) {
            listPokemon.add(p);
        }

        Pokemon pok2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        listPokemon.add(pok2);

        when(pokedex.get(0).getIndex()).thenReturn(listPokemon.get(0).getIndex());
        assertEquals(pokedex.get(1).getIndex(), 133);
    }

    @Test
    public void testGetPokemons() {
    }
}