package Model;

import java.util.ArrayList;

abstract class Vehicle {
    //atributai
    private Integer id;
    private String brand;
    private String model;
    // private LocalDate firstRegistrationDate;
    private Integer horsePower;
    private Double price;
    private Integer seats;
    private String numberPlate;
    private Double taxRate;


    ////////////////////////////////////////////////////////////////////////////////////
    private static ArrayList<Vehicle> vehicleArrayList;

//    public Vehicle(String brand, String model, Integer horsePower, Double price, Integer seats, String numberPlate, Double taxRate) {
//    this.vehicleArrayList = new ArrayList<Vehicle>();
//    }

    public ArrayList<Vehicle> getVehicleArrayList() {
        return vehicleArrayList;
    }

    public void setVehicleArrayList(ArrayList<Vehicle> vehicleArrayList) {
        this.vehicleArrayList = vehicleArrayList;
    }

//    this.vehicleArrayList = new ArrayList<Vehicle>();


    ////////////////////////////////////////////////////////////////////////////////


    //#region Getteriai ir Setteriai
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

//    public LocalDate getFirstRegistrationDate() {
//        return firstRegistrationDate;
//    }
//
//    public void setFirstRegistrationDate(LocalDate firstRegistrationDate) {
//        this.firstRegistrationDate = firstRegistrationDate;
//    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
    //#endregion

    // Konstruktorius
    public Vehicle(String brand, String model,
                   Integer horsePower, Double price, Integer seats, String numberPlate,
                   Double taxRate) {
        //this.id = HelperFunctions.generateNewId();
        this.brand = brand;
        this.model = model;
        // this.firstRegistrationDate = firstRegistrationDate;
        this.horsePower = horsePower;
        this.price = price;
        this.seats = seats;
        this.numberPlate = numberPlate;
        this.taxRate = taxRate;
    }
////////////////////////////////////////////////////////////////////////////

    public static String printCar(ArrayList<Vehicle> vehicleArrayList) {
        String x = null;
        for (Vehicle i : vehicleArrayList) {
            System.out.println(i.getId() + i.getBrand());

            x = i.getBrand() + "" + i.getModel();
        }
        return x;
    }

    ////////////////////////////////////////////////////////////////////////////
}

