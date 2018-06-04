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
        int[][] rMap;
        int[][] map = new int[MAPSIZE][MAPSIZE];

        //Doubles
        double currCreds = MAXCRED;

        //BOOL

        final boolean krystianBrained = false;
        //Robots
        mapRobot[] mapR = new mapRobot[20];
        mapR[0] = new mapRobot(1,1);
        rMap = mapR[0].GiveMap();

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
                double totalCreds = currCreds;
                boolean hasBeenDistributedMap = false;
                boolean hasBeenDistributedMine = false;
                boolean hasBeenReturnedMap = false;
                boolean hasBeenReturnedMine = false;
                boolean mapMapped = false;
                boolean mapDone = false;
                boolean[] isWaiting = new boolean[20];
                int[] waitTime = new int[20];
                int[] timeWaited = new int[20];

                @Override
                public void run() {
                    // todo figure out why it is still losing 1 credit
                    mapR[0].DiscoverMap(map);

                    if(mapDone == false && totalCreds > -1) {

                        if(map == rMap){
                            mapDone = true;
                            totalCreds += mapR[0].numOfCreds();
                            mapR[0].DistributeCreds(0);
                        }
                        if (hasBeenDistributedMap == false) {
                            mapR[0].DistributeCreds(totalCreds);
                            hasBeenDistributedMap = true;
                        }
                        if (mapMapped == false) {
                            if(mapR[0].IsBroken() == true){
                                return;
                            }
                            if (mapR[0].IsBroken() == false) {

                                if (timeWaited[0] == waitTime[0] && isWaiting[0] == true) {
                                    isWaiting[0] = false;
                                    mapR[0].DistributeCreds(10);
                                }
                                if (isWaiting[0] != true) {
                                    if (mapR[0].numOfCreds() == 0) {
                                        mapR[0].SetNumOfBreaks(mapR[0].NumOfBreaks() + 1);
                                        waitTime[0] = 3 ^ mapR[0].NumOfBreaks();
                                        isWaiting[0] = true;

                                    }
                                    if (mapR[0].NumOfBreaks() > 4) {
                                        mapR[0].SetBroken();
                                        isWaiting[0] = false;
                                    } else {
                                        mapR[0].Move();
                                        mapR[0].DiscoverMap(map);
                                        mapR[0].spitOutStats();
                                    }

                                } else {
                                    timeWaited[0]++;
                                }
                            }
                        } else {
                            System.out.println("JOBS DONE");
                            if(hasBeenReturnedMap == false){

                            }
                            if (hasBeenDistributedMine == false) {
                                for(int i = 0; i < 20; i++){
                                    mineR[i].DistributeCreds(totalCreds);



                                }
                            }
                            for(int i = 0;i < 20; i++ ) {
                                if (timeWaited[0] == waitTime[0] && isWaiting[0] == true) {
                                    isWaiting[0] = false;
                                    mineR[i].DistributeCreds(10);
                                }
                                if (isWaiting[0] != true) {
                                    if (mineR[i].numOfCreds() == 0) {
                                        mineR[i].SetNumOfBreaks(mineR[i].NumOfBreaks() + 1);
                                        waitTime[0] = 3 ^ mineR[i].NumOfBreaks();
                                        isWaiting[0] = true;

                                    }
                                    if (mineR[i].NumOfBreaks() > 4) {
                                        mineR[i].SetBroken();
                                        isWaiting[0] = false;
                                    } else {
                                        mineR[i].Move();
                                        //todo this
                                        mineR[i].Mine();
                                        mineR[i].spitOutStats();
                                    }

                                } else {
                                    timeWaited[0]++;
                                }
                            }
                        }
                    }


                }

            }, 0 ,1);





        }catch (FileNotFoundException e){
            e.printStackTrace();
        }







    }
}
