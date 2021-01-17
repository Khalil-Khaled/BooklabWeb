package tn.booklab.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String categoryName;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private String image;

    @Column
    private int quantity;

    @Column
    private int rating;


    @Temporal (TemporalType.DATE)
    private Date publishDate;

    @Column
    private String author;

    @Column
    private int pageNumber;

    @Column
    private ItemType type;

    public Item() {}

    public Item(int id, String name, String categoryName, String description, double price, String image, int quantity, int rating, Date publishDate, String author, int pageNumber, ItemType type) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.rating = rating;
        this.publishDate = publishDate;
        this.author = author;
        this.pageNumber = pageNumber;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", rating=" + rating +
                ", publishDate=" + publishDate +
                ", author='" + author + '\'' +
                ", pageNumber=" + pageNumber +
                ", type=" + type +
                '}';
    }
}
