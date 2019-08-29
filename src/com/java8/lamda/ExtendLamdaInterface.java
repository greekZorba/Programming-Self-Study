package com.java8.lamda;

public class ExtendLamdaInterface implements TempLamdaInterface {

    private TempLamdaInterface lamdaInterface;

    public ExtendLamdaInterface(TempLamdaInterface lamdaInterface){
        this.lamdaInterface = lamdaInterface;
    }

    @Override
    public void init(){
        lamdaInterface.init();
    }
}
