package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }


    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public  boolean isLength(String password){
        if(password.length()>=8){
            return  true;
        }
        return false;
    }
    public  boolean isUpperCase(String password){
        for(int i =0 ; i < password.length() ; i++){
            if(password.charAt(i)>='A'&&password.charAt(i)<='Z'){
                return  true;
            }
        }
        return false;
    }
    public  boolean isLowerCase(String password){
        for(int i =0 ; i < password.length() ; i++){
            if(password.charAt(i)>='a'&&password.charAt(i)<='z'){
                return  true;
            }
        }
        return false;
    }
    public  boolean isDigit(String password){
        for(int i =0 ; i < password.length() ; i++){
            if(password.charAt(i)>='0'&&password.charAt(i)<='9'){
                return  true;
            }
        }
        return false;
    }
    public  boolean isSpecialCharacter(String password){
        for(int i =0 ; i < password.length() ; i++){
            if(password.charAt(i)>=32&&password.charAt(i)<=47 && password.charAt(i)>=58&&password.charAt(i)<=64&&
                    password.charAt(i)>=91&&password.charAt(i)<=96&&password.charAt(i)>=123&&password.charAt(i)<=126){
                return  true;
            }
        }
        return false;
    }
    public boolean authenticate(String password){
        if(isLength(password)&&isUpperCase(password)&&isLowerCase(password)&&isDigit(password)&&isSpecialCharacter(password)){
            return true;
        }
        return  false;
    }
    public void changePassword(String oldPassword, String newPassword){
        if(this.password.equals(oldPassword)){
            if(authenticate(newPassword)){
                this.password=newPassword;
            }
        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
