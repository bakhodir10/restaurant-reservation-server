package reservation_server.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Embeddable
public class Address {
    private String street;
    private String city;
    private Integer zipCode;
    private String state;
}
