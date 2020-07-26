package com.flydean.object;

/**
 * @author wayne
 * @version SensitiveObject1,  2020/7/26
 */
public class SensitiveObject1 {
    private char[] password;

    SensitiveObject1(String iniValue){
        this.password = iniValue.toCharArray();
    }

    public final String get() {
        return String.valueOf(password);
    }

    public final void doPasswordChange(){
        for(int i = 0; i < password.length; i++) {
            password[i]= '*' ;}
    }

    public final void printValue(){
        System.out.println(String.valueOf(password));
    }

    public static void main(String[] args) {
        SensitiveObject1 sensitiveObject1= new SensitiveObject1("www.flydean.com");
        sensitiveObject1.printValue();
        sensitiveObject1.doPasswordChange();
        sensitiveObject1.printValue();
    }
}
