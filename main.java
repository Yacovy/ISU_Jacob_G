package ISU_Jacob_G;

import java.util.ArrayList;
import java.util.Scanner;
    public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menuState = "0";
        ArrayList<String> discNames = new ArrayList<String>();
        ArrayList<Integer> discSpeed = new ArrayList<Integer>();
        ArrayList<Integer> discFade = new ArrayList<Integer>();
        ArrayList<Integer> discTurn = new ArrayList<Integer>();
        System.out.println("PLEASE play this game in a full screen terminal for the best results");
        // entire game loop -> only exits when user edits
        while (!menuState.equals("4")){
        // menu section
        System.out.println("To start type 1");
        System.out.println("To create your own discs type 2");
        System.out.println("To get an intro to the game type 3");
        System.out.println("To quit type 4");
        menuState = sc.nextLine();
        
        //Game loop
        while(menuState.equals("1")){
            //creating default discs if someone doesn't have recommended discs
         
            if(!(discSpeed.contains(1)||discSpeed.contains(2)||discSpeed.contains(3)||discSpeed.contains(4))){
            discNames.add("Putter");
            discSpeed.add(2);
            discFade.add(0);
            discTurn.add(0);
            }
            if(!(discSpeed.contains(5)||discSpeed.contains(6)||discSpeed.contains(7)||discSpeed.contains(8))){
            discNames.add("Midrange");
            discSpeed.add(6);
            discFade.add(2);
            discTurn.add(-2);
            }
            if(!(discSpeed.contains(9)||discSpeed.contains(10)||discSpeed.contains(11)||discSpeed.contains(12))){
            discNames.add("Driver");
            discSpeed.add(10);
            discFade.add(2);
            discTurn.add(-2);
            }

            //course creation represented by a 50 by 30 space
            String [] course = new String [50 * 30];
            int courseNum = 0;
            System.out.println("which hole would you like to play? (1 to 3)");
            courseNum = sc.nextInt();
            int location = 0;
            // HOLE 1 HOLE 1 HOLE 1 HOLE 1HOLE 1 HOLE 1 HOLE 1 HOLE 1
            if(courseNum==1){
                for(int i = 0; i < 50 * 30; i++){
                    course[i] = "o";
                }
                course[50*29 - 47] = "X";
                location = 50 * 29 - 47;
                course[50*4 - 25] = "B";
                for (int i = 0; i < 30; i++) {
                    course[50*29+i] = "/";
                }

                for (int i = 0; i < 30; i++) {
                    course[50*i] = "/";
                }
                for (int i = 0; i < 10; i++) {
                    course[50*20+14+i] = "T";
                }
                for (int i = 0; i < 5; i++) {
                    course[50*7+26+i] = "T";
                }
                for (int i = 0; i < 4; i++) {
                    course[50*15+9+i] = "T";
                }

                
                
                for(int i = 0; i < 50 * 30; i++){
                    if(i % 49 < 20 || i % 50 > 30)
                        course[i] = "/";
                    if(i < 50)
                        course[i] = "/";
                }
                //hole 2 creation
            }
            if(courseNum==2){
                for(int i = 0; i < 50 * 30; i++){
                    course[i] = "o";
                }
                course[50*29 - 10] = "X";
                location = 50*29 - 10;
                course[50*12 + 5] = "B";
                
                for(int i = 50 * 15; i < 50 * 30; i++){
                    if(i % 50 < 30 || i % 49 > 20)
                        course[i] = "/";
                    if(i < 50)
                        course[i] = "/";
                }
                for (int i = 0; i < 30; i++) {
                    course[50*29+i] = "/";
                }
                for (int i = 0; i < 29; i++) {
                    course[50*(i+1)+49] = "/";
                }
                for (int i = 0; i < 50; i++) {
                    course[i] = "/";
                }
                for (int i = 0; i < 30; i++) {
                    course[50*i] = "/";
                }
                for (int i = 0; i < 8*50; i++) {
                    course[i] = "T";
                }
                for (int i = 0; i < 7; i++) {
                    course[50*15+34+i] = "T";
                }
                for (int i = 0; i < 3; i++) {
                    course[50*(8+i)+20] = "T";
                }
                course[50*11+10] = "T";
                course[50*14+16] = "T";
                //hole 3 creation , Hole 3 is debug and testing
            }
            if(courseNum==3){
                for(int i = 0; i < 50 * 30; i++){
                    course[i] = "o";
                }
                course[50*25 - 25] = "X";
                location = 50 * 25 - 25;
               
                
            }

            
        

            //print course FOR ANY COURSE
            //Contains main gameplay loop-> always prints map before user input
            int playing = 1;
            int strokes = 0;
            String [] tempCourse = course;
            while(playing==1){
                //printing map
                for(int i = 0; i < 50 * 30; i++){
                    
                    if( i%50==0){
                    System.out.println();
                    }
                    System.out.print(tempCourse[i]);
                }
                tempCourse = course;
                System.out.println();
                //prints user discs
                for(int d=0;d<discNames.size();d++){
                    System.out.println();
                    System.out.println("name: " + discNames.get(d) + "  speed: " + discSpeed.get(d) + "  turn: " + discTurn.get(d) + "  fade: " + discFade.get(d));
                }
                System.out.println();
                int confirmationDisc = 0;
                
                sc.nextLine();
                int discThrownNum = 0;
                //ask for user discs
                while (confirmationDisc == 0){
                
                    System.out.println("Which disc would you like to throw");
                    String discThrown = sc.nextLine();
                    if(discNames.contains(discThrown)){
                        confirmationDisc=1;
                        discThrownNum = discNames.indexOf(discThrown);
                    }
                    else{
                        System.out.println("NON VALID DISC. TRY AGAIN");
                    }
                    
                }
                
               
                System.out.println("Would you like to throw it backhand (type 1) or forehand (type 2)?");
                int throwtype = sc.nextInt();
                System.out.println("Which direction do you want to throw the disc (1 for up, 2 for right, 3 for down, 4 for left)");
                int ThrowDir = sc.nextInt();
                int locationBeforeCheck = location;
                int locationAfterCheck = 0;
                course[location] = "o";
                //disc movement calculator 
                for (int FadeTurnCount = 0; FadeTurnCount < 2; FadeTurnCount++){
                    for (int speedCalc = 0; speedCalc < discSpeed.get(discThrownNum); speedCalc++){
                       
                        // disc movement in linear directions
                        if(ThrowDir==1){
                            locationAfterCheck = locationBeforeCheck - 50;
                        }
                        if(ThrowDir==2){
                            locationAfterCheck = locationBeforeCheck + 1;
                        }
                        if(ThrowDir==3){
                            locationAfterCheck = locationBeforeCheck + 50;
                        }
                        if(ThrowDir==4){
                            locationAfterCheck = locationBeforeCheck - 1;
                        }
                        // hazard check for discs
                        if(course [locationAfterCheck].equals("/")){
                            System.out.println("Throw went OB");
                            location = locationBeforeCheck;
                            speedCalc = 1000;
                            FadeTurnCount= 1000;
                            strokes++;
                        }
                        else if(course [locationAfterCheck].equals("T")){
                            System.out.println("Throw hit a tree");
                            location = locationBeforeCheck;
                            speedCalc =1000;
                            FadeTurnCount=1000;
                            
                        }
                        else if (course [locationAfterCheck].equals("B")) {
                            System.out.println("You got it in the basket");
                            location = locationAfterCheck;
                            playing = 2;
                            FadeTurnCount=1000;
                            speedCalc =1000;
                        }
                        else{
                            locationBeforeCheck = locationAfterCheck;
                        }
                        //Turn movement(Early movement to the right)
                        if ( (speedCalc % 6 -(-discTurn.get(discThrownNum)) == 0 || speedCalc % 5-(-discTurn.get(discThrownNum)) == 0|| speedCalc % 7-(-discTurn.get(discThrownNum)) == 0 || speedCalc % 8 - (-discTurn.get(discThrownNum))==0) && discTurn.get(discThrownNum)!=0&&FadeTurnCount==0){
                            if(throwtype==1&&ThrowDir==1){
                                locationAfterCheck = locationBeforeCheck + 1;
                            }
                            if(throwtype==2&&ThrowDir==1){
                                locationAfterCheck = locationBeforeCheck - 1;
                            }
                            if(throwtype==1&&ThrowDir==2){
                                locationAfterCheck = locationBeforeCheck + 50;
                            }
                            if(throwtype==2&&ThrowDir==2){
                                locationAfterCheck = locationBeforeCheck - 50;
                            }
                            if(throwtype==1&&ThrowDir==3){
                                locationAfterCheck = locationBeforeCheck - 1;
                            }
                            if(throwtype==2&&ThrowDir==3){
                                locationAfterCheck = locationBeforeCheck + 1;
                            }
                            if(throwtype==1&&ThrowDir==4){
                                locationAfterCheck = locationBeforeCheck - 50;
                            }
                            if(throwtype==2&&ThrowDir==4){
                                locationAfterCheck = locationBeforeCheck + 50;
                            }
                             // hazard check for discs
                            if(course [locationAfterCheck].equals("/")){
                                System.out.println("Throw went OB");
                                location = locationBeforeCheck;
                           
                                FadeTurnCount=1000;
                                strokes++;
                            }
                            else if(course [locationAfterCheck].equals("T")){
                                System.out.println("Throw hit a tree");
                                location = locationBeforeCheck;
                            
                                FadeTurnCount=1000;
                            
                            }
                            else if (course [locationAfterCheck].equals("B")) {
                                System.out.println("You got it in the basket");
                                location = locationAfterCheck;
                                playing = 2;
                                FadeTurnCount=1000;
                            }
                        
                            else{
                                locationBeforeCheck = locationAfterCheck;
                            }
                         //Fade movement(Late movement to the left)
                        }
                        if ((speedCalc % 6 -(discFade.get(discThrownNum)) == 0 || speedCalc % 5-discFade.get(discThrownNum) == 0|| speedCalc % 7-(discFade.get(discThrownNum)) == 0 || speedCalc % 5-(discFade.get(discThrownNum)) == 0|| speedCalc % 8-(-discFade.get(discThrownNum)) == 0)&& discFade.get(discThrownNum)!=0&&FadeTurnCount==1){
                           for (int i = 0; i < 2; i++) {
            
                                if(throwtype==1&&ThrowDir==1){
                                    locationAfterCheck = locationBeforeCheck - 1;
                                }
                                if(throwtype==2&&ThrowDir==1){
                                    locationAfterCheck = locationBeforeCheck + 1;
                                }
                                if(throwtype==1&&ThrowDir==2){
                                    locationAfterCheck = locationBeforeCheck - 50;
                                }
                                if(throwtype==2&&ThrowDir==2){
                                    locationAfterCheck = locationBeforeCheck + 50;
                                }
                                if(throwtype==1&&ThrowDir==3){
                                    locationAfterCheck = locationBeforeCheck + 1;
                                }
                                if(throwtype==2&&ThrowDir==3){
                                    locationAfterCheck = locationBeforeCheck - 1;
                                }
                                if(throwtype==1&&ThrowDir==4){
                                    locationAfterCheck = locationBeforeCheck + 50;
                                }
                                if(throwtype==2&&ThrowDir==4){
                                    locationAfterCheck = locationBeforeCheck - 50;
                                }
                                 // hazard check for discs
                                if(course [locationAfterCheck].equals("/")){
                                    System.out.println("Throw went OB");
                                    location = locationBeforeCheck;
                               
                                    FadeTurnCount=1000;
                                    strokes++;
                                }
                                else if(course [locationAfterCheck].equals("T")){
                                    System.out.println("Throw hit a tree");
                                    location = locationBeforeCheck;
                                
                                    FadeTurnCount=1000;
                                
                                }
                                else if (course [locationAfterCheck].equals("B")) {
                                    System.out.println("You got it in the basket");
                                    location = locationAfterCheck;
                                    playing = 2;
                                    FadeTurnCount=1000;
                                }
                            
                                else{
                                    locationBeforeCheck = locationAfterCheck;
                                }
                            
                           }
                        }
                       
                    
                    }
                    
                    
                if(FadeTurnCount<4){
                    location =  locationAfterCheck;
                }
                
            }
                
                strokes++;
                course[location] = "X";
             
                
        }
            System.out.println("You scored " + strokes + " on this hole. CONGRATS");
            menuState = "0";








        }
        //disc creation loop
        if(menuState.equals("2")){
            int creationMenu = 0;
            //creation menu
            while(creationMenu != 3){
                
                System.out.println("To create a disc type 1");
                System.out.println("To delete a disc type 2");
                System.out.println("To exit this submenu disc type 3");


                creationMenu = sc.nextInt();
                sc.nextLine();
                //creating a disc
                // in the list disc stats-> stats are broken into 3 parts speed turn and fade
                if(discNames.size() >= 10 && creationMenu != 3 && creationMenu != 2){
                    System.out.println("YOU HAVE TOO MANY DISCS (>10) Delete some to continue");
                    creationMenu = 0;

                }
                if(creationMenu == 1){

                    System.out.println("What is the name of the disc");
                    
                    String temp_name = sc.nextLine();
                    discNames.add(temp_name);
                    System.out.println("What is the speed of the disc(1 to 12)");
                    int temp_speed = sc.nextInt();
                    discSpeed.add(temp_speed);
                    System.out.println("What is the turn of the disc(0 to -4)");
                    int temp_turn = sc.nextInt();
                    discTurn.add(temp_turn);
                    System.out.println("What is the fade of the disc(0 to 4)");
                    int temp_fade = sc.nextInt();
                    discFade.add(temp_fade);
                }
                while(creationMenu==2){
                    for(int d=0;d<discNames.size();d++){
                        System.out.println();
                        System.out.println("name: " + discNames.get(d) + "  speed: " + discSpeed.get(d) + "  turn: " + discTurn.get(d) + "  fade: " + discFade.get(d));
                    }
                    // disc deletion section
                    System.out.println("Input the name of the disc would you like to delete");
                    String tempName = sc.nextLine();
                    
                    if (discNames.contains(tempName)){
                        discFade.remove(discNames.indexOf(tempName));
                        discSpeed.remove(discNames.indexOf(tempName));
                        discTurn.remove(discNames.indexOf(tempName));
                        discNames.remove(discNames.indexOf(tempName));
                        creationMenu = 0;
                    }
                    else{
                        System.out.println("NOT A VALID NAME, TRY AGAIN");
                    }
                }
            }
        
        }

        // intro loop
        while(menuState.equals("3")){
            System.out.println("Welcome to Disc Golf on Java, brought to you by the PDGA");
            System.out.println("Disc movement in this game is broken into three parts: Speed, Turn and Fade");
            System.out.println("Speed will determine the distance that the disc flies");
            System.out.println("Turn will determine the amount the disc will move right at first on a backhand throw. It has a range of 0 to -4 with - 4 being the most");
            System.out.println("Fade will determine the amount the disc will move left at the end of a backhand throw. It has a range of 0 to 4 with 4 being the most");
            System.out.println("Disc names will be used in oreder to determine which disc you will throw so keep the names simple");
            System.out.println("There are three holes, the first two are fully designed holes, the third is for testing tour discs");
            System.out.println("After selecting a course you will see a map");
            System.out.println("\"X\" represents where you are currently");
            System.out.println("\"o\" represent open are where a disc can land");
            System.out.println("/ represents an area which is out of bounds or OB, any disc that flies into such an area is brought to the edge of OB and given a penalty ");
            System.out.println("T tepresents a tree, your disc will simply fall down");
            System.out.println("For forhad throws the turn will be twoards the left and then  fade right");
            System.out.println("For backhand throws the  turn will be twoards the right and then fade left");
            menuState = "0";
        }
        
        
        }
    }
}

