import javafx.scene.image.Image;

public class categories {
    String name;
    String filename;
}

class food extends categories{
    food(){
        name = "foodhi";
        filename = "food";
    }
}
class drink extends categories{
    drink(){
        name = "drink";
        filename = "drink";
    }
}
class activities extends categories{
    activities(){
        name = "activities";
        filename = "activities";
    }
}
