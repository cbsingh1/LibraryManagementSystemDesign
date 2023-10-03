package com.cbsingh;

import com.cbsingh.model.BookFormat;
import com.cbsingh.model.BookStatus;

import java.util.Date;

public class BookItem extends Book {

    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private Double price;
    private BookFormat format;
    private BookStatus status;
    private Date purchaseDate;
    private Date publicationDate;
    private Rack placedAt;

    public boolean checkout(String memberId){
        if(this.getIsReferenceOnly()) {
            System.out.println("This book is reference only & can't be issued");
            return false;
        }
        this.setBookItemStatus(BookStatus.LOANED);
        return true;
    }

    public String getBarcode() {
        return barcode;
    }

    public boolean getIsReferenceOnly(){
        return isReferenceOnly;
    }

    public void setBookItemStatus(BookStatus status){
        this.status = status;
    }
}
