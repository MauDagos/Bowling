import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    
    static Frame[] frames;
    static Frame bonus;
    static int totalPoints;
    
    public static void main(String[] args) {
        
        // We read line by line the file passed as the first argument.
        try (BufferedReader br = new BufferedReader(new FileReader(new File(args[0])))) {
            String line;
            while ((line = br.readLine()) != null) {
               
                // A player's match consists of 10 frames.
                frames = new Frame[10];
                bonus = null;
                totalPoints = 0;
                
                createFrames(line);
                countPoints();
                
                // Display results
                for (int i = 0; i < frames.length; i++) {
                    System.out.print((i+1) + "\t");
                }
                System.out.println("Bonus\t\tTotal Points");
                for (Frame f : frames) {
                    System.out.print(f.toString() + "\t");
                }
                System.out.println(bonus.toString() + "  \t" + totalPoints);
                System.out.println();
                
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
    
    /**
     *      Method for creating frames from the input string
     */
    public static void createFrames(String in) {
        
        Scanner sc = new Scanner(in);
        sc.useDelimiter("[\\[\\],\\s]+");                               // For getting pairs of numbers. We don't read square brackets, commas or any whitespace.
        
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Frame(sc.nextInt(), sc.nextInt());          // We create a frame with the next pair of numbers read.
        }
        
        bonus = new Frame(sc.hasNextInt() ? sc.nextInt() : 0,
                          sc.hasNextInt() ? sc.nextInt() : 0);          // We create the bonus frame, but we check if there are numbers available for it.
        
        sc.close();
        
    }
    
    /**
     *      Method for counting the points.
     */
    public static void countPoints() {
        
        for (int i = 0; i < frames.length; i++) {
            // We add the points obtained in this frame to the player's total.
            totalPoints += frames[i].getSum();
            
            // Check if the frame is a STRIKE.
            if (frames[i].isStrike()) {
                // We have to add to this frame the points obtained in the next two rolls.
                // If the next frame is a strike, then it only counts as one roll and we have to check the next frame after it, adding only it's first roll.
                
                // We have to check if there is another frame available. If not, that means we're considering the last frame and we have to look at the bonus.
                if (i + 1 < frames.length) {
                    totalPoints += frames[i+1].getSum();
                    
                    if (frames[i+1].isStrike()) {
                        
                        if (i + 2 < frames.length) {
                            totalPoints += frames[i+2].getFirstRoll();
                        } else {
                            totalPoints += bonus.getFirstRoll();
                        }
                        
                    }
                } else {
                    totalPoints += bonus.getSum();
                }
            }
            
            // Check if the frame is a SPLIT.
            else if (frames[i].isSplit()) {
                // We have to add to this frame the points obtained in the next roll.
                
                // We have to check if there is another frame available. If not, that means we're considering the last frame and we have to look at the bonus.
                if (i + 1 < frames.length) {
                    totalPoints += frames[i+1].getFirstRoll();
                } else {
                    totalPoints += bonus.getFirstRoll();
                }
            }
        }
        
    }
    
}