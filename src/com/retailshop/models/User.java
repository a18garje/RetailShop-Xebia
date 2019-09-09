package com.retailshop.models;

public class User {

  private long userId;
  private String name;
  private String address;
  private Cart userCart;

  public User(long userId, String name, String address) {

    this.userId = userId;
    this.name = name;
    this.address = address;
    this.userCart = new Cart();
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Cart getCart() {
    return this.userCart;
  }
}
