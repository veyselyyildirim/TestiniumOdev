package org.example.pages;

import junit.framework.Assert;
import org.example.methods.Methods;
import org.openqa.selenium.By;

public class UrunArama {
    Methods methods=new Methods();

    public void UrunBul(){
        methods.sendKeysById("search","ceket");
        methods.Enter("search");
        methods.scrollWithAction(By.cssSelector("div[class=\"productList__moreContent -prev\"]>button"));
        methods.clickByCss("div[class=\"productList__moreContent -prev\"]>button");
        methods.waitBySecond(2);

        String url="https://www.network.com.tr/search?searchKey=ceket&page=2";
        String yeniurl=methods.urlal();
        Assert.assertEquals(url, yeniurl );




    }
}
