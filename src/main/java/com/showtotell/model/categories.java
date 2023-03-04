import javafx.scene.image.Image;

public class categories {
    String name;
    String filename;
}

class food extends categories{
    food(){
        name = "food";
        filename = "food";
    }
}
class drink extends categories{
    drink(){
        name = "drink";
        filename = "dirnk";
    }
}
class activities extends categories{
    activities(){
        name = "activities";
        filename = "activities";
    }
}
