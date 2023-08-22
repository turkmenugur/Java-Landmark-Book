package com.trkmn.javalandmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable {
    //Serializable
    //Bir yerden bir yere veri yollarken bunu veriye çevirip diğer tarafta eski haline getirebiliyor.MainActivity sınıfında intent işlemi yaparken landmark göndermemizi sağlıyor
    String name;
    String country;
    int image;

    public Landmark(String name, String country, int image){
        this.name = name;
        this.country = country;
        this.image = image;
    }
}
