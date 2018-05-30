package com.company;
import static com.company.projConstants.*;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        //Ints
        int second = 1000;
        int decisecond = 100;
        int centisecond = 1000;
        int[][] map = new int[10][10];
        //Doubles
        double currCreds = MAXCRED;

        //BOOL
        boolean hasBeenDistributed = false;
        boolean mapMapped = false;
        boolean mapDone = false;
        final boolean krystianBrained = false;
        //Robots
        mapRobot[] mapR = new mapRobot[20];
        mapR[0] = new mapRobot(1,1);


        mineRobot[] mineR = new mineRobot[20];
        for(int i = 0; i < 20; i++){
            mineR[i] = new mineRobot();

        }
        Timer t = new Timer();
        try{
            File f = new File("Topology.txt");
            Scanner s = new Scanner(f);
            for(int i = 0; i < 10;i++){
                for(int j = 0; j < 10; j++){
                    map[i][j] = s.nextInt();
                }
            }

            t.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                do{
                    if (hasBeenDistributed == false){
                        if(mapMapped == false){
                            mapR[0].distributeCreds(currCreds);


                        }
                    }








                }while(currCreds != 0 || mapMapped == false);

                }
            }, 0 ,decisecond);





        }catch (FileNotFoundException e){
            e.printStackTrace();
        }







    }
}
