package pl.sda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Shop {
    private String name;
    private String address;
    private String phone;
    private String mail;
    private String nip;
    private Company company;

    public String getContactInfo(){
        return "tel: " + phone + " " + mail;
    }

}
