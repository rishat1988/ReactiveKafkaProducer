package com.example.reactivekafkaproducer.entities;

public enum Communication {

    Email("Email"),
    Phone("Phone"),
    Informing_is_not_required("informing is not required");

    final String value;

    Communication(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
