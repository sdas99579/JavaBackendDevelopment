package abstraction;

public enum EnumDemo {
    SUNDAY("sunday",0),
    MONDAY("monday",1),
    TUESDAY("tuesday",2);


    String val;
    Integer id;


    EnumDemo(String val, Integer  id) {
        this.val=val;
        this.id=id;
    }
}
