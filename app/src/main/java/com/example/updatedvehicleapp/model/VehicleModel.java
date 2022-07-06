package com.example.updatedvehicleapp.model;

public class VehicleModel {
    private String vehicleId;
    private String plateNumber;
    private String owner;
    private String email;
    private String type;
    private String phone;
    private String colour;
    private String timeIn;
    private String timeOut;

    public VehicleModel(String vehicleId, String plateNumber, String owner, String email, String type, String phone, String colour, String timeIn, String timeOut) {
        this.vehicleId = vehicleId;
        this.plateNumber = plateNumber;
        this.owner = owner;
        this.email = email;
        this.type = type;
        this.phone = phone;
        this.colour = colour;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getColor() {
        return colour;
    }

    public void setColor(String colour) {
        this.colour = colour;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }


}
