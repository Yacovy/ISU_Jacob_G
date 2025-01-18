package ISU_Jacob_G;

import java.util.ArrayList;
import java.util.Scanner;
    public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menu_state = "0";
        ArrayList<String> disc_names = new ArrayList<String>();
        ArrayList<Integer> disc_speed = new ArrayList<Integer>();
        ArrayList<Integer> disc_fade = new ArrayList<Integer>();
        ArrayList<Integer> disc_turn = new ArrayList<Integer>();
        System.out.println("PLEASE play this game in a full screen terminal for the best results");
        // entire game loop -> only exits when user edits
        while (!menu_state.equals("4")){
        // menu section
        System.out.println("To start type 1");
        System.out.println("To create your own discs type 2");
        System.out.println("To get an intro to the game type 3");
        System.out.println("To quit type 4");
        menu_state = sc.nextLine();
        
        //Game loop
        while(menu_state.equals("1")){
            //creating default discs if someone doesn't have recommended discs
         
            if(!(disc_speed.contains(1)||disc_speed.contains(2)||disc_speed.contains(3)||disc_speed.contains(4))){
            disc_names.add("Putter");
            disc_speed.add(2);
            disc_fade.add(0);
            disc_turn.add(0);
            }
            if(!(disc_speed.contains(5)||disc_speed.contains(6)||disc_speed.contains(7)||disc_speed.contains(8))){
            disc_names.add("Midrange");
            disc_speed.add(6);
            disc_fade.add(2);
            disc_turn.add(-2);
            }
            if(!(disc_speed.contains(9)||disc_speed.contains(10)||disc_speed.contains(11)||disc_speed.contains(12))){
            disc_names.add("Driver");
            disc_speed.add(10);
            disc_fade.add(2);
            disc_turn.add(-2);
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
            String [] tempcourse = course;
            while(playing==1){
                //printing map
                for(int i = 0; i < 50 * 30; i++){
                    
                    if( i%50==0){
                    System.out.println();
                    }
                    System.out.print(tempcourse[i]);
                }
                tempcourse = course;
                System.out.println();
                //prints user discs
                for(int d=0;d<disc_names.size();d++){
                    System.out.println();
                    System.out.println("name: " + disc_names.get(d) + "  speed: " + disc_speed.get(d) + "  turn: " + disc_turn.get(d) + "  fade: " + disc_fade.get(d));
                }
                System.out.println();
                int confirmationDisc = 0;
                
                sc.nextLine();
                int discThrownNum = 0;
                //ask for user discs
                while (confirmationDisc == 0){
                
                    System.out.println("Which disc would you like to throw");
                    String discThrown = sc.nextLine();
                    if(disc_names.contains(discThrown)){
                        confirmationDisc=1;
                        discThrownNum = disc_names.indexOf(discThrown);
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
                    for (int beforeTurn = 0; beforeTurn < disc_speed.get(discThrownNum); beforeTurn++){
                       
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
                            beforeTurn = 1000;
                            FadeTurnCount= 1000;
                            strokes++;
                        }
                        else if(course [locationAfterCheck].equals("T")){
                            System.out.println("Throw hit a tree");
                            location = locationBeforeCheck;
                            beforeTurn =1000;
                            FadeTurnCount=1000;
                            
                        }
                        else if (course [locationAfterCheck].equals("B")) {
                            System.out.println("You got it in the basket");
                            location = locationAfterCheck;
                            playing = 2;
                            FadeTurnCount=1000;
                            beforeTurn =1000;
                        }
                        else{
                            locationBeforeCheck = locationAfterCheck;
                        }
                        //Turn movement(Early movement to the right)
                        if ( (beforeTurn % 6 -(-disc_turn.get(discThrownNum)) == 0 || beforeTurn % 5-(-disc_turn.get(discThrownNum)) == 0|| beforeTurn % 7-(-disc_turn.get(discThrownNum)) == 0 || beforeTurn % 8 - (-disc_turn.get(discThrownNum))==0) && disc_turn.get(discThrownNum)!=0&&FadeTurnCount==0){
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
                        if ((beforeTurn % 6 -(disc_fade.get(discThrownNum)) == 0 || beforeTurn % 5-disc_fade.get(discThrownNum) == 0|| beforeTurn % 7-(disc_fade.get(discThrownNum)) == 0 || beforeTurn % 5-(disc_fade.get(discThrownNum)) == 0|| beforeTurn % 8-(-disc_fade.get(discThrownNum)) == 0)&& disc_fade.get(discThrownNum)!=0&&FadeTurnCount==1){
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
            menu_state = "0";








        }
        //disc creation loop
        if(menu_state.equals("2")){
            int creation_menu = 0;
            //creation menu
            while(creation_menu != 3){
                
                System.out.println("To create a disc type 1");
                System.out.println("To delete a disc type 2");
                System.out.println("To exit this submenu disc type 3");


                creation_menu = sc.nextInt();
                sc.nextLine();
                //creating a disc
                // in the list disc stats-> stats are broken into 3 parts speed turn and fade
                if(disc_names.size() >= 10 && creation_menu != 3 && creation_menu != 2){
                    System.out.println("YOU HAVE TOO MANY DISCS (>10) Delete some to continue");
                    creation_menu = 0;

                }
                if(creation_menu == 1){

                    System.out.println("What is the name of the disc");
                    
                    String temp_name = sc.nextLine();
                    disc_names.add(temp_name);
                    System.out.println("What is the speed of the disc(1 to 12)");
                    int temp_speed = sc.nextInt();
                    disc_speed.add(temp_speed);
                    System.out.println("What is the turn of the disc(0 to -4)");
                    int temp_turn = sc.nextInt();
                    disc_turn.add(temp_turn);
                    System.out.println("What is the fade of the disc(0 to 4)");
                    int temp_fade = sc.nextInt();
                    disc_fade.add(temp_fade);
                }
                while(creation_menu==2){
                    for(int d=0;d<disc_names.size();d++){
                        System.out.println();
                        System.out.println("name: " + disc_names.get(d) + "  speed: " + disc_speed.get(d) + "  turn: " + disc_turn.get(d) + "  fade: " + disc_fade.get(d));
                    }
                    // disc deletion section
                    System.out.println("Input the name of the disc would you like to delete");
                    String tempName = sc.nextLine();
                    
                    if (disc_names.contains(tempName)){
                        disc_fade.remove(disc_names.indexOf(tempName));
                        disc_speed.remove(disc_names.indexOf(tempName));
                        disc_turn.remove(disc_names.indexOf(tempName));
                        disc_names.remove(disc_names.indexOf(tempName));
                        creation_menu = 0;
                    }
                    else{
                        System.out.println("NOT A VALID NAME, TRY AGAIN");
                    }
                }
            }
        
        }

        // intro loop
        while(menu_state.equals("3")){
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
            menu_state = "0";
        }
        
        
        }
    }
}

