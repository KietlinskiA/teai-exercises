package pl.kietlinski.teaiexercises;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@Profile("Plus")
public class ShopPlus extends Shop{

    @Value("${price.vat}")
    private double vat;

    @EventListener(ApplicationReadyEvent.class)
    public void getInfo() {
        for (Product product : getProducts()){
            product.setPrice(product.getPrice()*(1-vat));
        }
        super.getInfo();
    }
}
