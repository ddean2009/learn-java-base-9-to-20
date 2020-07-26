package com.flydean.object;

/**
 * @author wayne
 * @version MaliciousSubSensitiveObject,  2020/7/26
 */
public class MaliciousSubSensitiveObject extends SensitiveObject2 implements Cloneable{
    MaliciousSubSensitiveObject(String iniValue) {
        super(iniValue);
    }

    public MaliciousSubSensitiveObject clone(){
        MaliciousSubSensitiveObject s = null;
        try {
            s = (MaliciousSubSensitiveObject)super.clone();
        } catch(Exception e) {
            System.out.println("not cloneable");
        }
        return s;
    }

    public static void main(String[] args) {
        MaliciousSubSensitiveObject object1 = new MaliciousSubSensitiveObject("www.flydean.com");
        MaliciousSubSensitiveObject object2 = object1.clone();
        String password1= object1.get();
        System.out.println(password1);
        object2.doPasswordChange();
        object1.printValue();
    }
}
