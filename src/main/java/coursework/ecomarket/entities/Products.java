package coursework.ecomarket.entities;

import lombok.Data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="active")
    private boolean active;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private float price;
    @Column(name="discription")
    private String discription;
    @Column(name = "category")
    private String category;
    @Column(name="photo")
    private String photo;
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.MERGE, orphanRemoval = true)
    //@NotFound(action = NotFoundAction.IGNORE)
    //private List<CartProduct> carts;
    //@ManyToMany(mappedBy = "prod")
    //private Set<Order> order;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
//    public List<CartProduct> getCart() {
//        return carts;
//    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getId() {
        return id;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = "../../images/products/" + photo;
    }
//    public void addCart(Carts cart, Products product) {
//        carts.add(new CartProduct(cart, product));
//    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products product = (Products) o;
        return Objects.equals(id, product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}