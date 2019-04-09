package com.SDETTest.SDETTest.model;
 
public class Person {
    
    private int Id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Gender;
    private String Country;
    private String State;


    /**
     * @return the state
     */
    public String getState() {
        return State;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return Country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.Country = country;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.Gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.Email = email;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.Id = id;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.State = state;
    }

    

}