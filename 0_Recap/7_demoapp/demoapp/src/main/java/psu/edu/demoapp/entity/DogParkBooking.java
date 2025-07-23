package psu.edu.demoapp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "dog_park_booking")
public class DogParkBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    private String dogName;
    private String breed;
    private Double weightKg;

    private LocalDate slotDate;
    private LocalTime slotStart;
    private LocalTime slotEnd;

    private LocalDate vaccinationExpiry;

    private String ownerUsername;   // maps to users.username

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Double getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(Double weightKg) {
		this.weightKg = weightKg;
	}

	public LocalDate getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}

	public LocalTime getSlotStart() {
		return slotStart;
	}

	public void setSlotStart(LocalTime slotStart) {
		this.slotStart = slotStart;
	}

	public LocalTime getSlotEnd() {
		return slotEnd;
	}

	public void setSlotEnd(LocalTime slotEnd) {
		this.slotEnd = slotEnd;
	}

	public LocalDate getVaccinationExpiry() {
		return vaccinationExpiry;
	}

	public void setVaccinationExpiry(LocalDate vaccinationExpiry) {
		this.vaccinationExpiry = vaccinationExpiry;
	}

	public String getOwnerUsername() {
		return ownerUsername;
	}

	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}


    
    
    
}
