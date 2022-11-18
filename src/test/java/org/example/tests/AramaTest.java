package org.example.tests;

import org.example.driver.ProjeBaseTest;
import org.example.pages.UrunArama;
import org.example.pages.UrunSec;
import org.junit.Test;

public class AramaTest extends ProjeBaseTest {

    @Test
    public void aramatest(){
        UrunArama arama=new UrunArama();
        arama.UrunBul();


    }


}
