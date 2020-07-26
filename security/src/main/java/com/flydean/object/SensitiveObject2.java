package com.flydean.object;

/**
 * @author wayne
 * @version SensitiveObject2,  2020/7/26
 */
public class SensitiveObject2 {
    private char[] password;
    private boolean returned=false;

    SensitiveObject2(String iniValue){
        this.password = iniValue.toCharArray();
    }

    public final String get()
    {
        if(!returned) {
            returned=true;
            return String.valueOf(password);
        }else {
        throw new IllegalStateException("已经返回过了，无法重复返回");
        }
    }

    public final void doPasswordChange(){
        if(!returned) {
            for (int i = 0; i < password.length; i++) {
                password[i] = '*';
            }
        }
    }

    public final void printValue(){
        System.out.println(String.valueOf(password));
    }

    public static void main(String[] args) {
        SensitiveObject2 sensitiveObject2= new SensitiveObject2("www.flydean.com");
//        SensitiveObject2 cloneObject = (SensitiveObject2) sensitiveObject2.clone();
//        System.out.println(sensitiveObject2.get());
        sensitiveObject2.doPasswordChange();
        System.out.println(sensitiveObject2.get());
//        System.out.println(cloneObject.get());
    }
}
