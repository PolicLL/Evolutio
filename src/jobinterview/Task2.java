package jobinterview;

/*

2) 
Napisati program koji provjerava da li je uneseni tekst palindrom. Uzeti u obzir samo slova,
ignorirati sve ostale znakove.

Npr:

input: "A mene tu, ni minute nema"
output: “Palindrom”

input: "Trka automobila"
output: “Nije palindrom”

*/

public class Task2 
{
    private String text;
    
    public boolean isPalindrom(String str)
    {
        if(str.equals(""))
        {
            System.out.println("No text ... ");
            return false;
        }
        
        
        this.text = str;
        
        text = text.toLowerCase();
        text = removeNonLetters(text);
        
        return isPalindrom(text , 0 , text.length() - 1);

    }

    @Override
    public String toString() {
        return "Text : " + text;
    }

    
    
    
    private boolean isPalindrom(String text , int pointer1 , int pointer2)
    {
        if(pointer1 > pointer2)
            return true;
        
        if(text.charAt(pointer1) == text.charAt(pointer2))
            return isPalindrom(text, pointer1 + 1, pointer2 - 1);
        
        else
            return false;
    }
    

    
    private  String removeNonLetters(String text)
    {
        for(int i = 0; i < text.length(); ++i)
        {
            char tempSign = text.charAt(i);
            
            if(!isCharLetter(tempSign))
            {
                text = removeSign(text, i);
                --i;
            }
        }
        
        return text;
    }
    
    private  boolean isCharLetter(char letter)
    {
        int value = (int) letter;
        
        if((value > 64) && (value < 91))
            return true;
        
        else if((value > 96) && (value < 123))
            return true;
        
        return false;
    }
    
    private  String removeSign(String text , int position)
    {
        return text.substring(0 , position) + text.substring(position + 1 , text.length());
    }

}
