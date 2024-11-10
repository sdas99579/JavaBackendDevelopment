package springDemo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    private String city;
    private String pincode;

//    public Address(String city, String pincode) {
//        this.city = city;
//        this.pincode = pincode;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getPincode() {
//        return pincode;
//    }
//
//    public void setPincode(String pincode) {
//        this.pincode = pincode;
//    }
//    public Address()
//    {
//
//    }
//
//    @Override
//    public String toString() {
//        return "Address{" +
//                "city='" + city + '\'' +
//                ", pincode='" + pincode + '\'' +
//                '}';
//    }
}
