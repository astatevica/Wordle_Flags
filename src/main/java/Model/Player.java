package Model;

public class Player {
    //Mainīgie
    private String name;
    private String email;
    private String password;

    //Getteri
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }


    //Setteri
    // && inputName.length() >= 3 && inputName.matches("[A-Za-z0-9]+")
    //Šo pārbada pie DBUtils
    public void setName(String inputName) {
        if(inputName != null){
            name = inputName;
        }else{
            name = "---wrong-name----";
        }
    }

    //Atrast pareizo regex (NEDER:[^[^\.\s][\w\-\.{2,}]+@([\w-]+\.)+[\w-]{2,}$])
    //Šo pārbada pie DBUtils
    public void setEmail(String inputEmail) {
        if(inputEmail != null && inputEmail.length() >= 5 ){
            email = inputEmail;
        }else{
            email = "---wrong-email-or-not-shown---";
        }
    }

    //paroles regexu var uzlabot šis neder(^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$)
    //inputPassword.length() >= 9
    public void setPassword(String inputPassword) {
        if(inputPassword != null){
            password = inputPassword;
        }else{
            password = "---password-does-not-meet-the-requrements----";
        }
    }

    //Konstruktori
    public Player(){
        setName("superMonster2341");
        setEmail("superMonster2341@gmail.com");
        setPassword("sup23mon41");
    }

    public Player(String inputName, String inputEmail, String inputPassword){
        setName(inputName);
        setEmail(inputEmail);
        setPassword(inputPassword);
    }

    //ToString
    public String toString(){
        String result = "Username: " + getName() + " Email: " + getEmail() + " Password: " + getPassword();
        return result;
    }
}
