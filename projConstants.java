package com.company;

/**
 * Created by Robert Hubert on 21/03/2018.
 */
public class projConstants {

    // ---------*---------*---------*---------*---------*
    // Integer Constants
    public static final int INVALID  = -1;


    public static final int ROW = 200;
    public static final int COL = 200;
    public static final int MAXCRED = 1500;




    private projConstants(){
        //this prevents even the native class from calling this constructor as well
        throw new AssertionError();
    }

}