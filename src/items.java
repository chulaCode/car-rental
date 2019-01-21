
import java.util.Date;

public class items {

    //private int id;
    private String carName;
    private String accessories;
    private String address;
    private Boolean status;
    private String city, gear;
    private int qty, phone, seat;
    private Double price;
    private byte[] image;
    private int to, from,stock;
    
    public items(String car, String acc, Double price, byte[] image, int from, int to)
    {
        this.accessories = acc;
        this.carName = car;
        this.price=price;
        this.image=image;
        this.from=from;
        this.to=to;
       
    }
    public items(int stock){
        this.stock=stock;
    }
    public items(String car, String acc){ 
        this.accessories = acc;
       
        this.carName=car;
     
    }

    public items(String car, String acc, String add, Boolean status, String city,
             String gear, int seat, int phone, Double price, byte[] image) {
        //this.id=id;
        this.accessories = acc;
        this.address = add;
        this.carName = car;
        this.city = city;
        this.phone = phone;
        this.qty = qty;
        this.gear = gear;
        this.seat = seat;
        this.status = status;
    }

    public items(String car, String acc, Double price, byte[] image, Boolean status, String gear, int seat) {
        //this.id=id;
        this.carName = car;
        this.accessories = acc;
        this.price = price;
        this.image = image;
        this.status = status;
        this.gear = gear;
        this.seat = seat;
        this.price = price;

    }
    public items(String car, String acc, Double price, int from, int to) {
        //this.id=id;
        this.carName = car;
        this.accessories = acc;
        this.price = price;
       
        
        this.from = from;
        this.to = to;
        
    }


    items() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTo() {
        return to;
    }
    public int getStock()
    {
        return stock;
    }

    public int getFrom() {
        return from;
    }

    public String getCarName() {
        return carName;
    }

    public String getAccessories() {
        return accessories;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public byte[] getImage() {
        return image;
    }

    public String getGear() {
        return gear;
    }

    public int getSeat() {
        return seat;
    }

    public int getQty() {
        return qty;
    }

    public int getPhone() {
        return phone;
    }

    public Double getPrice() {
        return price;
    }

    public void setTo(int to) {
        this.to = to;
    }
    public void setStock(int st)
    {
        this.stock=st;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setCarName(String car) {
        this.carName = car;
    }

    public void setAccessories(String acc) {
        this.accessories = acc;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
