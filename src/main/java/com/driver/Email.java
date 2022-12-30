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

    public boolean authenticate(String password){
      boolean isUpperCase=false,isLowerCase=false,isOneDigit=false,
              isSpecialCharacter=false;
      if(password.length()<8){
          return false;
      }
      for(int i=0 ; i<password.length() ; i++){
          char ch = password.charAt(i);
          if(ch>='A' && ch<='Z'){
             isUpperCase=true;
          }
          else if(ch>='a' && ch<='z'){
              isLowerCase=true;
          }
          else if(ch>='0' && ch<='9'){
              isOneDigit=true;
          }
          else{
              isSpecialCharacter =true;
          }
        }
      if(isUpperCase&&isLowerCase&&isOneDigit&&isSpecialCharacter){
          return true;
      }
      return false;
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
