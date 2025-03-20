package com.SpringBoot.Point_of_Sale.dto.request;

    import java.util.Date;

    public class ResponseOrderDetailsDTO {
        // customer
        private String customerName;
        private String customerAddress;
        private String customerContact;

        // order
        private Date date;
        private double total;

        public ResponseOrderDetailsDTO() {
        }

        public ResponseOrderDetailsDTO(String customerName, String customerAddress, String customerContact, Date date, double total) {
            this.customerName = customerName;
            this.customerAddress = customerAddress;
            this.customerContact = customerContact;
            this.date = date;
            this.total = total;
        }

        // Getters and setters (if needed)
    }