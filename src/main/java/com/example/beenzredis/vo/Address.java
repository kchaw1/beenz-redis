package com.example.beenzredis.vo;

import lombok.Getter;

@Getter
public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }
}
