package com.cbsingh;

import com.cbsingh.model.BookStatus;
import com.cbsingh.model.Constants;
import com.cbsingh.model.ReservationStatus;

import java.util.Date;

public class Member extends Account{
    private Date dateOfMembership;
    private int totalBooksCheckedOut;

    public int getTotalBooksCheckedOut(){
        return totalBooksCheckedOut;
    }

    public boolean reserveBookItem(BookItem bookItem){
        return  false;
    }

    public void incrementTotalBooksCheckedOut(){
        totalBooksCheckedOut++;
    }

    public boolean checkoutBookItem(BookItem bookItem){
        if(this.getTotalBooksCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER){
            System.out.println("User already checked-out max no. of books");
            return false;
        }

        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());

        if(bookReservation != null && bookReservation.getMemberId() != this.getId()){
            System.out.println("Book is already reserved by other member");
            return false;
        } else if(bookReservation != null) {
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }

        if(!bookItem.checkout(this.getId())){
            return false;
        }

        this.incrementTotalBooksCheckedOut();
        return true;
    }

    public void returnBookItem(BookItem bookItem){
        checkForFine(bookItem.getBarcode());

        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());

        if(bookReservation != null){
            bookItem.setBookItemStatus(BookStatus.RESERVED);
            // Book Item - send book available notification
        } else {
            bookItem.setBookItemStatus(BookStatus.AVAILABLE);
        }
    }

    private void checkForFine(String bookItemBarcode) {
        BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
        Date dueDate = bookLending.getDueDate();
        Date today = new Date();

        if(today.compareTo(dueDate)>0){
            long diff = today.getTime() - dueDate.getTime();
            long diffDays = diff/(24*60*60*1000);
            Fine.collectFine(bookLending.getMemberId(), diffDays);
        }
    }
}
