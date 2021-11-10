package jobinterview;

import java.util.Scanner;
import java.util.Random;

/*

Simulirati igru ”kamen, škare, papir”. Igrač igra protiv računala. Igrač bira jedno od ta tri
pojma i dobija bod u svakom krugu ukoliko ima jači alat. Pravila su:

• kamen pobjeđuje škare
• škare pobjeđuju papir
• papir pobjeđuje kamen

*/

/*

K - kamen
S - skare
P - papir 

*/

public class Task1 
{

    private Scanner input;
    private Random random;
    
    private int playerPoints , computerPoints;
    
    private char playerInput , computerInput;
    
    public Task1()
    {
        input = new Scanner(System.in);
        random = new Random();
        
        playerPoints = 0;
        computerPoints = 0;
        
        playerInput = ' ';
        computerInput = ' ';
    }
    
    public void startGame()
    {
        
        while(true)
        {
            
            printOptionsMessage();
            getPlayerInput();
            
            if(checkPlayerInput(playerInput))
            {
                computerInput = getComputerInput();
                System.out.println("Computer choose : " + computerInput);

                calculateResult();
                printResults();
            }
            else
                System.out.println("Odaberi znak ponovo ! ");
        }
    }
    
    private void printOptionsMessage()
    {
        System.out.print("Odaberi (K - kamen , S - skare , P - papir) : ");
    }
    
    private void getPlayerInput()
    {
        playerInput = input.next().charAt(0);
    }
    
    private boolean checkPlayerInput(char input)
    {
        return ((input == 'K') || (input == 'S') || (input == 'P'));
    }
    
    
    
    private char getComputerInput()
    {
        return convertNumberToCharOption(generateComputersOption());
    }
    
    private int generateComputersOption()
    {
        return random.nextInt(3);
    }
    
    private char convertNumberToCharOption(int number)
    {
        if(number == 0)
            return 'K';
        else if(number == 1)
            return 'S';
        else if(number == 2)
            return 'P';
        
        return ' ';
    }
    
    
   
    private void calculateResult()
    {
        // check if player wins
        if((playerInput == 'K') && (computerInput == 'S')) // kamen vs skare
            ++playerPoints;
        
        else if((playerInput == 'S') && (computerInput == 'P')) // skare vs papir
            ++playerPoints;
        
        else if((playerInput == 'P') && (computerInput == 'K')) // papir vs kamen
            ++playerPoints;
        
        // check if computer wins
        else if((computerInput == 'K') && (playerInput == 'S'))
            ++computerPoints;
        
        else if((computerInput == 'S') && (playerInput == 'P'))
            ++computerPoints;
        
        else if((computerInput == 'P') && (playerInput == 'K'))
            ++computerPoints;
        
    }

    private void printResults()
    {
        System.err.println("PLAYER POINTS : " + playerPoints + " ||| COMPUTER POINTS : " + computerPoints);
        
    }
    
}
