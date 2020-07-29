package com.flydean.atomicity;

/**
 * @author wayne
 * @version ChainedMethodWithBuilder,  2020/7/29
 */
public class ChainedMethodWithBuilder {
    private int age=0;
    private String name="";
    private String adress="";

    public ChainedMethodWithBuilder(Builder builder){
        this.adress=builder.adress;
        this.age=builder.age;
        this.name=builder.name;
    }

    public static class Builder{
        private int age=0;
        private String name="";
        private String adress="";

        public static Builder newInstance(){
            return new Builder();
        }
        private Builder() {}

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAdress(String adress) {
            this.adress = adress;
            return this;
        }

        public ChainedMethodWithBuilder build(){
            return new ChainedMethodWithBuilder(this);
        }
    }

    public static void main(String[] args) {
        final ChainedMethodWithBuilder[] builder = new ChainedMethodWithBuilder[1];
        Thread t1 = new Thread(() -> {
            builder[0] =ChainedMethodWithBuilder.Builder.newInstance()
                .setAge(1).setAdress("www.flydean.com1").setName("name1")
                .build();});
        t1.start();

        Thread t2 = new Thread(() ->{
            builder[0] =ChainedMethodWithBuilder.Builder.newInstance()
                .setAge(1).setAdress("www.flydean.com1").setName("name1")
                .build();});
        t2.start();
    }
}
