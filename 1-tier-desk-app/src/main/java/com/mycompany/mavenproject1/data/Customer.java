package com.mycompany.mavenproject1.data;

import java.util.Objects;

public class Customer {
    
    private String name;
    private int age;
    private String phone;
    private Country country;
    private double creditLimit;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() >= 5)
            this.name = name;
        
        else
            throw new Exception("Name must be greater than 5 characters");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        if (phone.length() != this.getCountry().getDigits())
            throw new Exception ("The phone number is not valid!");
            
        else
            this.phone = phone;
    }

    public Country getCountry() {
        return country;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        
        if (this.getAge() > 35)
            this.creditLimit = 500;
        
        else if (this.getAge() > 18)
            this.creditLimit = 300;
        
        else
            this.creditLimit = 100;
        
        
        if (this.getCountry().getAcronym().equalsIgnoreCase("BR"))
            this.creditLimit += 100;
    }
    


    public void setCountry(Country country) throws Exception {
        
        if (country == null)
            throw new Exception ("Country must be informed!");
        
        else
            this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", age=" + age + ", phone=" + phone + ", country=" + country + ", creditLimit=" + creditLimit + '}';
    }

    
}
