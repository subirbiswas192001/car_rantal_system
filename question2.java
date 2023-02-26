import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.util.Iterator;
abstract class themepark{
public int total_cost(int m,int n){
return 500*n+300*m;
 }
 abstract void playGame();
}
class Queensland extends themepark{
 public void playGame(){
Scanner in=new Scanner(System.in);
boolean[] Games=new boolean[30];
Arrays.fill(Games, false);
boolean wtp=true;
while(wtp){
System.out.println("which game do you want to play? (1-30). 0 to quit");
int x=in.nextInt();
if(x==0) wtp=false;
else if(x>30 || x<1) System.out.println("please input valid number");
 else if(Games[x]==true) System.out.println("Warning! play each game atmost once.");
else{
 System.out.println("Sucessfully played game "+x);
 Games[x]=true;
}
}
 }
}
class Wonderla extends themepark{
 public void playGame(){
 Scanner in=new Scanner(System.in);
 int[] Games=new int[40];
Arrays.fill(Games,0);
boolean wtp=true;
while(wtp){
System.out.println("which game do you want to play? (1-40). 0 to quit");
int x=in.nextInt();
 if(x==0) wtp=false;
else if(x>40 || x<1) System.out.println("please input valid number");
else{
 System.out.println("Sucessfully played game "+x);
 Games[x]++;
}
}
System.out.println("Games repeated=");
for(int i=0;i<40;i++) if(Games[i]>1) System.out.print(i+", ");
 System.out.println("\nGames not played=");
 for(int i=0;i<40;i++) if(Games[i]==0) System.out.print(i+", ");
 System.out.println("\nGames played once=");
 for(int i=0;i<40;i++) if(Games[i]==1) System.out.print(i+", ");
 }
}
public class question2{
 public static void main(String[] args) {
 System.out.println("\n\nQueensland:");
 new Queensland().playGame();
 System.out.println("\n\nWonderla:");
 new Wonderla().playGame();
 }
}