package org.example.tests;

import org.example.driver.ProjeBaseTest;
import org.example.pages.UrunArama;
import org.example.pages.UrunSec;
import org.junit.Test;

public class UrunTest extends ProjeBaseTest {

    @Test
    public void uruntest(){
        UrunArama arama=new UrunArama();
        arama.UrunBul();
        UrunSec urun=new UrunSec();
        urun.UrunEkle();
    }
}
