import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Encryption {
    //Desc: Encrypts or decrypts a file.
    //Input: The user supplies the character '1' to encrypt, or '2' to decrypt via the keyboard.
    //       The user also supplies the name of the source file via the keyboard.
    //Output: If the user wants to encrypt, the text in input file is encrypted and the encrypted text is
    //        stored in "encrypted.txt". The original file is not changed.
    //        If the user wants to decrypt, the text in input file is decrypted and the decrypted text is
    //        stored in "decrypted.txt". The original file is not changed.
    /*
       pseudocode:   print("1. Encrypt a file")
                    print("2. Decrypt a file")
                    choice=readChar()
                    switch (choice)
                    {
                        case '1': encrypt(); break
                        case '2': decrypt(); break
                    }
       requirements:  To make a program which allows the user to enter the filename of a file, encrypts the
                      file, and writes the encrypted information to another file. The program also allows the user to
                      enter the filename of a file, decrypts the file, and writes the decrypted information to another file.

       Testing: the type of testing i used was equivalence testing mainly by checking  the boundaries of the algorithm's used
                like 'a', 'z', '0', '9'
     */

    public static void main(String[]arg) throws FileNotFoundException
    {
        Scanner keyboard=new Scanner(System.in);
        char choice='1';
        System.out.println("1. Encrypt a file");
        System.out.println("2. Decrypt a file");
        choice=keyboard.nextLine().charAt(0);

        switch (choice)
        {
            case '1': encrypt(); break;
            case '2': decrypt(); break;
        }
    }
    //Desc : Encrypts a file.
    //Input: The user supplies the name of a disk file via the keyboard and the file must exist.
    //Output: The text in the specified file encrypted and written to "encrypted.txt".
    //Pseudocode:   print("Enter file name")
    /*              s=readLine()
    //              f=open(s)
                    g=open("encrypted.txt")
                    while (f.hasChar())
                    {
                        ch = f.readChar()
                        ch=convert(ch)
                        g.print(ch)
                    }
               f.close()
               g.close()
     */
    public static void encrypt() throws FileNotFoundException
    {
        Scanner keyboard=new Scanner(System.in);
        System.out.print("Enter file name: ");
        String s=keyboard.nextLine();
        Scanner input = new Scanner( new File(s));
        input.useDelimiter(""); //line 14
        PrintWriter f = new PrintWriter("encrypted.txt");
        while (input.hasNext())
        {
            char ch = input.next().charAt(0);
            ch=convert(ch);
            f.print(ch);
        }
        input.close();
        f.close();
        System.out.println("Completed Encryption");
    }
    //Desc : Convert a character of a letter both uppercase and lowercase to its Successor except
    //       z and Z, which are converted to 'a' and 'A' respectively.
    //       converts characters that are digits to its predecessor except 0, which is
    //       converted to 9. And converts everything else unchanged.
    //Return: characters of there respective encryption algorithms
    /* Pseudocode: if ch is less than 'z' and ch greater than or equal to 'a' OR ch less than 'Z' and ch greater than or equal to'A'
                   { Returns the successor of the character}
                   else if ch is equal to 'Z' OR ch is equal to 'z'
                   { returns 'a' or 'A' depending on the character passed }
                   else if ch is greater than '0' AND ch less than or equal '9'{
                   returns the predecessor of the passed ch}
                   else if ch is equal to '0'}
                   else returns everything unchanged

     */
    public static char convert (char ch)
    {
        if ((ch<'z'&&ch>='a')||(ch<'Z'&&ch>='A'))
            return (char)(ch+1);

        else if (ch=='Z'||ch=='z')
            return (char)(ch-25);
        else if (ch>'0'&&ch<='9')
            return (char)(ch-1);

        else if (ch=='0')
            return (char)(ch+9);
        else return ch;
    }
    //Desc : Decrypts a file.
    //Input: The user supplies the name of a disk file via the keyboard and the file must exist.
    //Output: The text in the specified file decrypted and written to "decrypted.txt".
    //Throw: FileNotFoundException if the input source file does not exist, or decrypted.txt cannot be created
    //Pseudocode:   print("Enter file name")
    /*              s=readLine()
    //              f=open(s)
                    g=open("decrypted.txt")
                    while (f.hasChar())
                    {
                        ch = f.readChar()
                        ch=inverseconvert(ch)
                        g.print(ch)
                    }
               f.close()
               g.close()
     */
    public static void decrypt() throws FileNotFoundException
    {
        Scanner keyboard=new Scanner(System.in);
        char ch='a';
        System.out.print("Enter file name: ");
        String s=keyboard.nextLine();
        Scanner input = new Scanner(new File(s));
        input.useDelimiter("");
        PrintWriter f = new PrintWriter("decrypted.txt");
        while (input.hasNext())
        {
            ch = input.next().charAt(0);
            ch=inverseConvert(ch);
            f.print(ch);
        }
        input.close();
        f.close();
        System.out.println("Completed Encryption");
    }

    //Desc : Convert the characters back to their orginal characters by using
    //       the reverse of the algorithm we used for encrypting the text.
    //Return: the characters of the respective algorithms.
    //Pseudocode:
    /*         if ch is less than or equal to 'z' AND ch  is greater than 'a' OR ch is less than or equal to 'Z' AND ch greater 'A'
                { returns the revers letter of the encrypted file}
                else if ch is equal to 'A' OR ch is equal to 'a'{
                returns 'z' or 'Z' depending on the ch }
                else if ch is greater than or equal to the character '0' AND ch is less than the character digit '9'
                { returns the successor of the digit character }
                else if ch equal to '9'{ returns the character '0'}
                else return everything else unchanged

     */
    public static char inverseConvert(char ch)
    {
        if ((ch<='z'&&ch>'a')||(ch<='Z'&&ch>'A'))
            return (char)(ch-1);
        else if (ch=='A'||ch=='a')
            return (char)(ch+25);
        else if (ch>='0'&&ch<'9')
            return (char)(ch+1);
        else if (ch=='9')
            return (char)(ch-9);
        else return ch;
    }

}


