package psu.edu.book.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookreporttb")
public class BookReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int custid;
    private int bookid;
    private double unitPrice;
    private int quantity;
    private LocalDateTime date;

    public BookReport() {}

 // Constructor
    public BookReport(int custid, int bookid, double unitPrice, int quantity, LocalDateTime date) {
        this.custid = custid;
        this.bookid = bookid;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.date = date;
    }

    // Getters and Setters
    public int getId() { return id; }
    public int getCustid() { return custid; }
    public int getBookid() { return bookid; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }
    public LocalDateTime getDate() { return date; }

    public void setId(int id) { this.id = id; }
    public void setCustid(int custid) { this.custid = custid; }
    public void setBookid(int bookid) { this.bookid = bookid; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setDate(LocalDateTime date) { this.date = date; }

//    To String
    @Override
    public String toString() {
        return "BookReport{" +
                "id=" + id +
                ", custid=" + custid +
                ", bookid=" + bookid +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
