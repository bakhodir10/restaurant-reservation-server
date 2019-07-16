package reservation.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String city;
    private int zipCode;
    private String state;
}
