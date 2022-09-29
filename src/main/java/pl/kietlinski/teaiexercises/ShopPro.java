package pl.kietlinski.teaiexercises;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Pro")
public class ShopPro extends Shop{

    @Value("${price.vat}")
    private double vat;
    @Value("${price.discount}")
    private double discount;

    @EventListener(ApplicationReadyEvent.class)
    public void getInfo() {
        for (Product product : getProducts()){
            product.setPrice(product.getPrice()*(1-vat)*(1-discount));
        }
        super.getInfo();
    }
}
