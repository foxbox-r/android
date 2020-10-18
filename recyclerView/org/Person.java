
public class Person {
    String name;
    String mobile;
    public Person(String name,String mobile){
        this.name = name;
        this.mobile = mobile;
    }

    public String getName(){
        return this.name;
    }

    public String getMobile(){
        return this.mobile;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }
}
