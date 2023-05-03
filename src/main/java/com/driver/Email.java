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

    public void changePassword(String oldPassword, String newPassword){
        if(!oldPassword.equals(this.password)) return;
            int n = newPassword.length();
            if(n<8){
                return;
            }
            boolean upperCase=false;
            boolean loweCase=false;
            boolean digit=false;
            boolean specialchar=false;

            for(int i=0;i<n;i++){
                int tmp =newPassword.charAt(i);
                if(tmp>=97 && tmp<=122) loweCase=true;
                else if(tmp>=65 && tmp<=90) upperCase=true;
                else if(tmp>=48 && tmp<=57) digit=true;
                else{
                    specialchar=true;
                }
            }
            if(loweCase && upperCase && digit && specialchar){
                this.password=newPassword;
            }
            return;
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
