package pl.sda;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Company {
    private String name;
    private String address;
    private String postCode;
    private String city;

    public String getFullAddress(){
        return address + " " + postCode + " " + city;
    }
}
