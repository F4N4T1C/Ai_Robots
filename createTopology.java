package com.company;


import java.util.*;
import static com.company.mapVar.*;
/**
 * Created by 93851kel on 03/05/2018.
 */
public class createTopology {


    private int[][] map = new int[ROW][COL];





        public void topology(String[] args) {

            Random randy = new Random();
            Scanner s = new Scanner(System.in);


                for(int i = 0; i <ROW;i++){ // these are rows ...

                    for(int j = 0; j <COL;j++){ // these are cols ...
                        map[i][j] = randy.nextInt(10)+1;

                        System.out.print(map[i][j]+" ");


                    }
                    System.out.println();


                }

        }

        public int[][] getMap(){



            return map;
        }



}
