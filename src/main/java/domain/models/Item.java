package domain.models;

public class Item {
    private String name;
    private String imageUrl;
    private double price;
    private String location;
    private String notes;
    private boolean reserved = false;

    public Item(String name, String imageUrl,
                double price, String location,
                String notes) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.location = location;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", notes='" + notes + '\'' +
                ", reserved=" + reserved +
                '}';
    }
}

