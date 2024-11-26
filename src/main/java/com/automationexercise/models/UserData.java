package com.automationexercise.models;

public class UserData {
  public String name;
  public String email;
  public String password;
  public String firstName;
  public String lastName;
  public String address;
  public String state;
  public String city;
  public String zipcode;
  public String mobileNumber;
  public String country;

  @Override
  public String toString() {
    return "UserData [name=" + name + ", email=" + email + ", password=" + password + ", firstName=" + firstName
        + ", lastName=" + lastName + ", address=" + address + ", state=" + state + ", city=" + city + ", zipcode="
        + zipcode + ", mobileNumber=" + mobileNumber + ", country=" + country + "]";
  }

}
