import java.util.List;

public class Category {
    private String name;
    private String imageFilename;
    private List<Category> children;

    public Category(String name, String imageFilename) {
        this.name = name;
        this.imageFilename = imageFilename;

    }

    public String getName() {
        return name;
    }

    public String getImageFilename() {
        return imageFilename;
    }



}