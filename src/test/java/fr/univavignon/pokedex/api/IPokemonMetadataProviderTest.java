package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class IPokemonMetadataProviderTest extends TestCase {

    //Creation d'un Mock
    IPokemonMetadataProvider metaData = mock(IPokemonMetadataProvider.class);
    //Création d'une éspace de pokemon avec ses métadonnées
    PokemonMetadata bulbizarre=new PokemonMetadata(0,"Bulbizarre",126,126,90);
    PokemonMetadata aquali=new PokemonMetadata(133,"Aquali",186,168,260);
    @Before
    public void setUp(){
        try {
            when(metaData.getPokemonMetadata(0)).thenReturn(bulbizarre);
            when(metaData.getPokemonMetadata(133)).thenReturn(aquali);
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMetaData() {
        try {

            //on renvoie bulbizarre lorsque on met l'index 0
            Mockito.doReturn(this.bulbizarre).when(this.metaData).getPokemonMetadata(0);
            //on renvoie bulbizarre lorsque on met l'index 133
            Mockito.doReturn(this.aquali).when(this.metaData).getPokemonMetadata(133);
            //on lance lexception lorsque l'index nest pas situé entre 0 et 150
            Mockito.doThrow(new PokedexException("Un pokemon avec cet index n'existe pas ! ")).when(metaData).getPokemonMetadata(Mockito.intThat(index -> index < 0 || index > 150));
            //on verifie que nous avons bulbizarre lorsque on met l'index 0
            assertEquals(this.bulbizarre, this.metaData.getPokemonMetadata(0));
            //on verifie que nous avons aquali lorsque on met l'index 133
            assertEquals(this.aquali, this.metaData.getPokemonMetadata(133));
            //on verifie que nous avons une exception lorsque nous mettons un index hors de 0 et 150
            Assert.assertThrows(PokedexException.class, () -> metaData.getPokemonMetadata(-151));
        }catch (PokedexException e){
            e.printStackTrace();
        }
    }
}
