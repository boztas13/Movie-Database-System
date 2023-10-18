public abstract class Person {
    private int ID;
    protected String name;
    protected String surname;
    protected String Phone;
    protected Date birthDate;
    protected char gender;
    protected String personType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String toString(){
        return getID()+";"+getName()+";"+getSurname()+";"+getPhone()+";"+ getBirthDate().toString()+";"+getGender();
    }
    public static String tableColumns(){
        return "ID;name;surname;phone;birthdate;gender;username;password";
    }

}
