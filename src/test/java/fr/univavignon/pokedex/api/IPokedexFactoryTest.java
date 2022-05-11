package fr.univavignon.pokedex.api;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;


public class IPokedexFactoryTest {
    IPokedexFactory iPokedexFactory;
    IPokemonMetadataProvider iPokemonMetadataProvider;
    IPokemonFactory iPokemonFactory;
    IPokedex pokedex;

    @Before
    public void init() {
        //Creation de Mock
        iPokedexFactory = mock(IPokedexFactory.class) ;
        iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        iPokemonFactory = mock(IPokemonFactory.class);
        pokedex = mock(IPokedex.class);
    }

    @Test
    public void createPokedex() {
        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory)).thenReturn(pokedex);
        assertEquals(iPokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory), pokedex);
    }
}