package com.company;

/**
 * Created by 93851kel on 03/05/2018.
 */
import java.io.*;


import static com.company.projConstants.*;
public class mapRobot {
    private double creds = 0;
    private int numOfBreaks = 0;
    private int x;
    private int y;
    private int ID = 1;
    private int[][] rMap = new int[MAPSIZE][MAPSIZE];
    private int yMovements = 0;
    private int xMovements = 0;
    double creditsEarned = 0;
    private boolean movingUp = true;
    private boolean broken = false;
    private boolean firstRun = true;
    final boolean krystianBrained = false;
    File f = new File(ID + "_" + "mapRobot.txt");
    mapRobot(int X, int Y){
        x = X;
        y = Y;
    }

    public void DistributeCreds(double credits){
        creds = credits;

    }
    public double returnCredits(){
        return creds;
    }

    public double numOfCreds(){
        return creds;
    }

    public void Move(){
        if(creds != 0) {
            creds -= 2;
            if(x != 998) {
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
            }else if(y == 1){
            //do nothing
            }else {
                y--;
            }
        }
    }

    public int[][] GiveMap(){
        for(int i = 0; i < MAPSIZE;i++){
            for(int j = 0; j < MAPSIZE;j++){
                rMap[i][j] = INVALID;
            }
        }
        return rMap.clone();
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

    public void DiscoverMap(int[][] map){
        creditsEarned = 0;
        if(rMap[x][y] == INVALID)    { creditsEarned++; }
        rMap[x][y] = map[x][y];
        if(rMap[x+1][y] == INVALID)  { creditsEarned++; }
        rMap[x+1][y] = map[x+1][y];
        if(rMap[x-1][y] == INVALID)  { creditsEarned++; }
        rMap[x-1][y] = map[x-1][y];
        if(rMap[x][y+1] == INVALID)  { creditsEarned++; }
        rMap[x][y+1] = map[x][y+1];
        if(rMap[x][y-1] == INVALID)  { creditsEarned++; }
        rMap[x][y-1] = map[x][y-1];
        if(rMap[x+1][y+1] == INVALID){ creditsEarned++; }
        rMap[x+1][y+1] = map[x+1][y+1];
        if(rMap[x-1][y+1] == INVALID){ creditsEarned++; }
        rMap[x-1][y+1] = map[x-1][y+1];
        if(rMap[x+1][y-1] == INVALID){ creditsEarned++; }
        rMap[x+1][y-1] = map[x+1][y-1];
        if(rMap[x-1][y-1] == INVALID){ creditsEarned++; }
        rMap[x-1][y-1] = map[x-1][y-1];
        creds += creditsEarned;
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
