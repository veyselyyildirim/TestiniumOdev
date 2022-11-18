package org.example.pages;

import junit.framework.Assert;
import org.example.methods.Methods;
import org.openqa.selenium.By;

public class UrunSec {
    Methods methods=new Methods();

    public void UrunEkle(){
        methods.hover(By.cssSelector(".product__discountPercent"));
        String data=methods.getAttribute(By.cssSelector(".product__discountPercent"),"data-id");




    }

}
