package reservation_server.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Address {
    private String street;
    private String city;
    private int zipCode;
    private String state;
}
