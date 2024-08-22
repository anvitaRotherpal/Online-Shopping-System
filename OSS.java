import java.util.*;

public class OSS{             //OSS=Online Shopping System
    public String ID;
    public String name;
    public String description;
    public boolean availability;
    
    public OSS(String ID, String name, String description){
        this.ID=ID;
        this.name=name;
        this.description=description;
        this.availibility=true;
    }
    
        public String getID(){
            return ID;
        }
    
        public String getName(){
            return name;
        }
    
        public String getDescription(){
            return description;
        }
    
        public String getAvailability(){
            return String.valueOf(availability);
        }
    
        public void setAvailable(boolean availability) {
            this.availability=true;
        }
    
        
    
        
    
        
    }
    
    public class Electronics extends OSS{
        public String brand;
        public int price;
    
        public Electronics(String ID, String name, String description, String brand, int price){
            super(ID,name,description);
            this.brand=brand;
            this.price=price;
        }
    
            public String getBrand(){
                return brand;
            }
    
            public int getPrice(){
                return price;
            }
    
           
        
    }
    
    public class Clothing extends OSS{
        int size;
        String gender;   //determines if the clothing is for a male or a female
    
    
        public Clothing(String ID, String name, String description, int size, String gender){
            super(ID,name,description);
            this.size=size;
            this.gender=gender;
    
        }
    
        public int getSize(){
            return size;
        }
    
        public int getGender(){
            return gender;
        }
    
        
    }
    
    public class Accessories extends OSS{
        String material;
        String style;       //determines whether the accessory is either formal or casual
    
        public Accessories(String ID, String name, String description, String material, String style){
            super(ID,name,description);
            this.material=material;
            this.style=style;
        }
    
        public String getMaterial(){
            return material;
        }
    
        public  String getStyle(){
            return style;
        }
    
        
    }
    public class User{
        private String username;
        private String password;
        private ShoppingCart cart;
        private List<Order> orderHistory;
    
        public User(String username, String password){
            this.username=username;
            this.password=password;
            this.cart=new ShoppingCart();
            this.orderHistory=new ArrayList<>();
    
        }
    
        public String getUsername(){
            return username;
        }
    
        public void setUsername(String username){
            this.username=username;
        }
    
        public String getPassword(){
            return password;
        }
    
        public void setPassword(String password){
            this.password=password;
        }
    
        public ShoppingCart getShoppingCart() {
            return cart;
        }
    
        public List<Order> getOrderHistory() {
            return orderHistory;
        }
    
        public void addOrder(Order order) {
            orderHistory.add(order);
        }
    
        public void removeOrder(Order order) {
            orderHistory.remove(order);
        }
    
    
    
        
    }

    public class ShoppingCart {
        private List<Product> items;
    
        public ShoppingCart() {
            this.items = new ArrayList<>();
        }
    
        public void addItem(Product product) {
            items.add(product);
        }
    
        public void removeItem(Product product) {
            items.remove(product);
        }
    
        public List<Product> getItems() {
            return items;
        }
    }
    
    
    public class Order {
        private List<Product> items;
        private double totalPrice;
        private Date orderDate;
    
        public Order(List<Product> items, double totalPrice, Date orderDate){
           this.items=items;
           this.totalPrice=totalPrice;
           this.orderDate=orderDate;
        }
       
    
        public List<Product> getItems() {
            return items;
        }
    
        public void setItems(List<Product> items) {
            this.items = items;
        }
    
        public double getTotalPrice() {
            return totalPrice;
        }
    
        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }
    
        public Date getOrderDate() {
            return orderDate;
        }
    
        public void setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
        }
        public void calculateTotalPrice() {
            this.totalPrice = 0;  // Reset total price
            for (Product product : items) {
                this.totalPrice += product.getPrice();
            }
        }

       
    
    }
    public class OnlineStore {
        private List<Product> products;
        private Map<String, User> users;
        private Map<String, ShoppingCart> shoppingCarts;
    
        public void addProduct(Product product) {
            products.add(product);
        }
    
        public void removeProduct(int productId) {
            // Iterate over the items list
            for (Product product : items) {
                if (product.getProductId() == productId) { 
                    items.remove(product); 
                    calculateTotalPrice(); 
                    return; 
            }
           
            System.out.println("Product with ID " + productId + " not found in the order.");
        }
    }
    
        public User createUser(String username, String password) {
            User newUser = new User(username, password);
            users.put(username, newUser);
            return newUser;
        }
    
       
    }
    public class OnlineStoreTest {
        public static void main(String[] args) {
            OnlineStore store = new OnlineStore();
            
            
            Electronics laptop = new Electronics(/* parameters */);
            store.addProduct(laptop);
            
            Clothing tShirt = new Clothing(/* parameters */);
            store.addProduct(tShirt);
            
            User user = store.createUser("abc", "abc123");
            
            
        }
    }
    
    
    
    
        
    
    
    
    
    
    