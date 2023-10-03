package com.cbsingh;

import com.cbsingh.model.ReservationStatus;

import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    public static BookReservation fetchReservationDetails(String barcode){
        return null;
    }

    public String getMemberId() {
        return memberId;
    }

    public void updateStatus(ReservationStatus reservationStatus) {
        status = reservationStatus;
    }
}
