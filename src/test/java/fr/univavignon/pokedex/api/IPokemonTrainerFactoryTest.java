package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
public class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory testpokemontrainerfactory;
    Team team;
    IPokedex pokedex;
    PokemonTrainer PokeTrainer_one, PokeTrainer_two;

    @Before
    public void init() {
        testpokemontrainerfactory = mock(IPokemonTrainerFactory.class);

        IPokedexFactory pokedexfactory = mock(IPokedexFactory.class);
        IPokemonMetadataProvider pokmetaprovider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        pokedex = pokedexfactory.createPokedex(pokmetaprovider, pokemonFactory);
        PokeTrainer_one = new PokemonTrainer("Essaid", team.valueOf("MYSTIC"), pokedex);
        PokeTrainer_two = new PokemonTrainer("Michel", team.valueOf("VALOR"), pokedex);
    }
    @Test
    public void createTrainer() {
        when(testpokemontrainerfactory.createTrainer(Mockito.anyString(),Mockito.any(Team.class),Mockito.any(IPokedexFactory.class))).thenAnswer(
                new Answer() {
                    @Override
                    public Object answer(InvocationOnMock invocation) throws PokedexException {
                        Object[] args = invocation.getArguments();
                        String valeur = (String) args[0];
                        if(valeur.equals("Essaid")){
                            return new PokemonTrainer("Essaid", team.valueOf("MYSTIC"), pokedex);
                        }
                        else if(valeur.equals("Michel")) {
                            return new PokemonTrainer("Michel", team.valueOf("VALOR"), pokedex);
                        }
                        else {
                            return new PokedexException("Erreur: La creation est impossible ");
                        }
                    }
                }
        );
        assertEquals(PokeTrainer_one.getName(), "Essaid" );
        assertEquals(PokeTrainer_one.getTeam(), team.valueOf("MYSTIC"));
        assertEquals(PokeTrainer_two.getName(), "Michel");
        assertEquals(PokeTrainer_two.getTeam(), team.valueOf("VALOR"));

    }
}