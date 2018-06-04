package com.company;

/**
 * Created by 93851kel on 03/05/2018.
 */
import java.io.*;


import static com.company.projConstants.*;
public class mineRobot {
    private double creds = 0;
    private int numOfBreaks = 0;
    private int x;
    private int y;
    private int ID;
    private int[][] rMap = new int[MAPSIZE][MAPSIZE];
    private int yMovements = 0;
    private int xMovements = 0;
    double creditsEarned = 0;
    private boolean movingUp = true;
    private boolean broken = false;
    private boolean firstRun = true;
    final boolean krystianBrained = false;
    File f = new File(ID + "_" + "mapRobot.txt");


    public void DistributeCreds(double credits){
        creds = credits;

    }
// todo this shit
    public double numOfCreds(){
        return creds;
    }

    public void Move(){
        //todo get rid of this and replace it with a mining movement algorithm
        if(creds != 0) {
            creds -= 2;
            if (movingUp == true) {
                if (yMovements != MAPSIZE - 3) {
                    y++;
                    yMovements++;

                }
            }
            if (movingUp == false) {
                if (yMovements != MAPSIZE - 3) {
                    y--;
                    yMovements++;

                }
            }
            if (xMovements < 3 && yMovements == MAPSIZE - 3) {
                x++;
                xMovements++;
            } else if (xMovements == 3) {
                if (movingUp == true) {
                    movingUp = false;
                    xMovements = 0;
                } else {
                    movingUp = true;
                    xMovements = 0;
                }

                yMovements = 0;
            }
        }
    }

    public void GetMap(int[][] i){
    rMap = i;

    }
    public void setID(int id){
        ID = id;
    }
    public int NumOfBreaks(){

        return numOfBreaks;
    }

    public boolean IsBroken(){

        return broken;
    }

    public void SetBroken(){
        broken = true;
    }

    public void SetNumOfBreaks(int num){
        numOfBreaks = num;
    }



    public void spitOutStats(){
        try{
            BufferedWriter fileout = new BufferedWriter(new FileWriter(f,true));
            fileout.write(x + " " + y + " " + creditsEarned + " " + creds + "");
            fileout.newLine();
            fileout.flush();
            fileout.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }



}
