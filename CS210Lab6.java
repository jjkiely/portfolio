import java.util.*;

import static java.util.Arrays.sort;

public class CS210Lab6 {
    //List of numbers
    private static long[] list = new long[]{7270536038336708566L,
            8019217342518227357L,
            3040884611156577620L,
            4971410678527411098L,
            183064013267932758L,
            8056584603037925167L,
            1899884129638764508L,
            5128941762697709445L,
            5047244487910064394L,
            3305601720113745382L,
            5776953008539814370L,
            34988082947722169L,
            7434345681532331612L,
            5407786886759427803L,
            688068291500036320L,
            2068510150417278708L,
            1868790318480929054L,
            3425404376196216488L,
            1131190712360422749L,
            102967645096808272L,
            1445942735952374406L,
            8456737838228485082L,
            7623544032966572081L,
            3942629391233399085L,
            75109850685511728L,
            223515536869223609L,
            764673323466830185L,
            2792331077502901882L,
            8043871486090449356L,
            8027891460874623856L,
            9035205129603316628L,
            5210176758109223792L,
            6369027410439876015L,
            719764136449271247L,
            6275216998605832028L,
            7518974182407464286L,
            8228098362075889963L,
            4364500170274364383L,
            5160900320056121570L,
            3574188741140445768L,
            3799725687163235416L,
            8971054323076859594L,
            303947614746485290L,
            4072768654844778108L,
            422948319988286530L,
            228169257627773589L,
            4695919214544378987L,
            5634695221137989240L,
            2134479954298742138L,
            7591363728605668117L,
            227743280468209272L,
            3815359581987719752L,
            240831188333789404L,
            1682051551566226L,
            7028911732181187415L,
            8534901095561461575L,
            604981729275990578L,
            4379371367686136078L,
            2561184379973031673L,
            3251231714574439892L,
            8507596701451728093L,
            1479176915196229414L,
            4596908701725205546L,
            7434222118200184219L,

    };
    //This method finds the smallest distance between the groups of numbers
    private static long findDistance() {
        long currentMinimum = 1682051551566226L;//this initial value is the smallest number in the list
        for (int i = 0; i < 10000; i++) { //this will run 10000 iterations of the method in order to ensure that a small value is found
            Random random = new Random(); //initialises the random class
            long[] group1 = new long[4]; //first group
            for (int j = 0; j < group1.length; j++) {
                int ran = random.nextInt(64);//this loop populates the first group with randomly selected values from the array
                group1[j] = list[ran];
            }
            long[] group2 = new long[4]; //second group
            for (int j = 0; j < group2.length; j++) {
                int ran = random.nextInt(64); //this loop populates the second group with randomly selected values from the array
                group2[j] = list[ran];
            }
            check(group1, group2); //calls the check method
            long group1total = 0;
            long group2total = 0;
            for (int j = 0; j < group1.length; j++) {
                group1total += group1[j]; //calculates the sum of all values in the group
            }
            for (int j = 0; j < group2.length; j++) {
                group2total += group2[j]; //calculates the sum of all values in the group
            }
            long difference = Math.abs(group1total - group2total); //the difference between the two groups
            if (difference < currentMinimum) {
                currentMinimum = difference; //changes minimum value if necessary
            }
        }
        return currentMinimum;
    }

    private static void check(long[] group1, long[] group2) { //this method checks that there are no duplicate values between groups
        for (int i = 0; i < group1.length; i++) { //nested loops allow the code to check from both sides at once
            for (int j = group1.length-1; j > 0; j--) {
                Random random = new Random();
                if (group1[i] == group1[j]) { //if there is a duplicate
                    int ran = random.nextInt(64); // then the random number is regenerated
                    while (ran == j) {
                        ran = random.nextInt(64);
                    }
                    group1[j] = list[ran];// and the duplicate is replaced with a different value from the array
                }
                if (group2[i] == group2[j]) { //as above
                    int ran = random.nextInt(64);
                    while (ran == j) {
                        ran = random.nextInt(64);
                    }
                    group2[j] = list[ran];
                } else
                    break; //if there is no duplicate then the loop will stop
            }
        }
        for (int i = 0; i < group1.length; i++) { //This loop performs the same function as above
            for (int j = 0; j < group2.length-1; j++) {// except it checks for values that are present in both groups
                if (group1[i] == group2[j]) {
                    Random random = new Random();
                    int ran = random.nextInt(64);
                    while (ran == j) {
                        ran = random.nextInt(64);
                    }
                    group2[j] = list[ran];

                }
            }
        }
    }


        public static void main (String[]args)
        {
            sort(list);
            System.out.println(findDistance());
        }
}
