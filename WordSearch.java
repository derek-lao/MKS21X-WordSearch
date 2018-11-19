import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.lang.*;
public class WordSearch{
    private char[][] data;

//the random seed used to produce this WordSearch
    private int seed;

    //a random Object to unify your random calls
    private Random randgen;

    //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
    private ArrayList<String> wordsToAdd;

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String> wordsAdded;

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */

    public WordSearch(int rows,int cols){
      data=new char[rows][cols];
      clear();
    }

    public WordSearch(int rows, int cols, String fileName) throws FileNotFoundException{
      if((rows>0)&&(cols>0)){
        data=new char[rows][cols];
        clear();
      }
      wordsToAdd=new ArrayList<String>();
      wordsAdded=new ArrayList<String>();

      File f = new File(fileName);//can combine
      Scanner in = new Scanner(f);//into one line
        //NOW read the file here...
      while(in.hasNext())
      {
        String word=in.next();
        wordsToAdd.add(word);
      }

    //Choose a randSeed using the clock random
      seed = (int)System.currentTimeMillis()%10001;
      randgen = new Random(seed);

    }

    public WordSearch(int rows, int cols, String fileName, int randSeed) throws FileNotFoundException{
      if((rows>0)&&(cols>0)){
        data=new char[rows][cols];
        clear();
      }
      wordsToAdd=new ArrayList<String>();
      wordsAdded=new ArrayList<String>();
      File f = new File(fileName);//can combine
      Scanner in = new Scanner(f);//into one line

        //NOW read the file here...
      while(in.hasNext())
      {
        String word=in.next();
        wordsToAdd.add(word);
      }

      seed=randSeed;
      randgen=new Random(randSeed);
    }
    //Use the random seed specified.

    private void fillWithLetters(){
      for(int r=0;r<data.length;r++)
      {
        for(int c=0;c<data[0].length;c++)
        {
          if(data[r][c]=='_')
          {
            int letter=Math.abs(randgen.nextInt()%('Z'-'A'))+'A';
            data[r][c]=(char)letter;
          }
        }
      }
    }

    private void demolishLetters(){
      for(int r=0;r<data.length;r++)
      {
        for(int c=0;c<data[0].length;c++)
        {
          if(data[r][c]=='_')
          {
            data[r][c]=' ';
          }
        }
      }
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for(int r=0;r<data.length;r++)
      {
        for(int c=0;c<data[r].length;c++)
        {
          data[r][c]='_';
        }
      }
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
      String answer="|";
      for(int r=0;r<data.length;r++)
      {
        for(int c=0;c<data[r].length;c++)
        {
          if(c<data[r].length-1)
          {
            answer=answer+(data[r][c]+" ");
          }
          else
          {
            answer=answer+data[r][c];
          }
        }
        if(r<data.length-1)
        {
          answer+="|\n\n|";
        }
        else
        {
          answer+="|";
        }
      }
      answer+="\nWords:";
      for(int i=0;i<wordsAdded.size();i++)
      {
        String word=wordsAdded.get(i);
        answer+=(" "+word+",");
      }
      answer=answer.substring(0,answer.length()-1)+" (seed: " +seed+ ")";
      return answer;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added in the direction rowIncrement,colIncrement
     *Words must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@param rowIncrement is -1,0, or 1 and represents the displacement of each letter in the row direction
     *@param colIncrement is -1,0, or 1 and represents the displacement of each letter in the col direction
     *@return true when: the word is added successfully.
     *        false when: the word doesn't fit, OR  rowchange and colchange are both 0,
     *        OR there are overlapping letters that do not match
     */
    private boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
      if((rowIncrement==0&&colIncrement==0)
      ||(Math.abs(rowIncrement)>1||Math.abs(colIncrement)>1))
      //this checks for both increments being 0, also checked in addAllWords, but it is redundant
      {
        return false;
      }
      for(int i=0;i<word.length();i++)
      {
        int rowPosition = row+(i*rowIncrement);
        int colPosition = col+(i*colIncrement);
        if(rowPosition>=data.length           || rowPosition<0 ||
        colPosition>=data[0].length || colPosition<0)
        {
          return false;
        }
        //checked all out of bounds stuff

        else
        {
          continue;
        }
      }
      for(int i=0;i<word.length();i++)
      {
        if(data[row+(i*rowIncrement)][col+(i*colIncrement)]!='_')
        {
          if(data[row+(i*rowIncrement)][col+(i*colIncrement)]!=word.charAt(i))
          {
            return false;
          }
        }
      }
      for(int i=0;i<word.length();i++)
      {
        data[row+(i*rowIncrement)][col+(i*colIncrement)]=word.charAt(i);
      }
      wordsToAdd.remove(word);
      wordsAdded.add(word);
      //System.out.println(wordsToAdd);
      return true;
    }

    /*[rowIncrement,colIncrement] examples:
     *[-1,1] would add up and the right because (row -1 each time, col + 1 each time)
     *[ 1,0] would add downwards because (row+1), with no col change
     *[ 0,-1] would add towards the left because (col - 1), with no row change
     */



    private void addAllWords(){
      int increment=wordsToAdd.size();
      for(int n=0;n<increment;n++)
      {
        int position=Math.abs(randgen.nextInt())%wordsToAdd.size();
        String randomword=wordsToAdd.get(position);
        int randomrow=Math.abs(randgen.nextInt())%data.length;
        int randomcol=Math.abs(randgen.nextInt())%data[0].length;
        int randomrowIncrement=randgen.nextInt()%2;
        int randomcolIncrement;
        if(randomrowIncrement==0)
        {
          randomcolIncrement=Math.abs((randgen.nextInt()%2) * 2)-1;
        }
        else
        {
          randomcolIncrement=randgen.nextInt()%2;
        }
        //this checks for both increments being 0, also checked in addWords, but it is redundant
        for(int i=0;i<50;i++)
        {
          //System.out.println(randomword+" "+randomrow+" "+randomcol+" "+randomrowIncrement+" "+randomcolIncrement);
          if(addWord(randomword,randomrow,randomcol,randomrowIncrement,randomcolIncrement))
          {
            i=49;
            //System.out.println("Success!");
          }
          else
          {
            randomrow=Math.abs(randgen.nextInt())%data.length;
            randomcol=Math.abs(randgen.nextInt())%data[0].length;
          }
        }
      }
    }

    //      Choose a random word, and a random direction (rowIncrement/colIncrement)
    // Try to add that word to different starting positions* until:
    // you successfully add the word
    // you run out of positional tries
    // Repeat this process until you added all of the words, or you tried to add unsuccessfully too many times in a row.
    // OPTIONAL    Optimize your addAllWords such that:
    // You do not try to add words to positions that would not fit the word on the board. **
    // Use the rowIncrement/colIncrement to decide what the range of valid row/col should be.
    //
    //     *Each try in step 2 only changes the position of the start, not the direction or word
    //     **A five letter word that is meant to be added across to the right should not START in the last 4 columns of the board
    public static void main(String[] args){
      WordSearch dummy;
      String instructions= "Hey buddy, you kinda suck at this,"+
      " lemme tell ya what to do: \n\nYou can do some of these"+
      " three things:  \n\n1. java WordSearch rows cols filename\n2."+
      " java WordSearch rows cols filename randomSeed\n3. java WordSearch"+
      " rows cols filename randomSeed answers\n *For the third one, in the"+
      " answers part, you must type \"key\"\n *row and col must be nonzero"+
      " positive integers\n *randomSeed must be a nonnegative integer"+
      " between 0 and 10000 inclusive\n\nAlright you dummy, go do that"+
      " wordsearch";
      int rowCall;
      int colCall;
      String filenameCall;
      int seedCall;
      String answerCall;
      if(args.length<3||args.length>5)
      {
        System.out.println(instructions);
      }

      try
      {
        if(args.length==3)
        {
          rowCall=Integer.parseInt(args[0]);
          colCall=Integer.parseInt(args[1]);
          filenameCall=args[2];
          dummy=new WordSearch(rowCall,colCall,filenameCall);
          dummy.addAllWords();
          dummy.fillWithLetters();
          System.out.println(dummy.toString());
        }
        if(args.length==4)
        {
          rowCall=Integer.parseInt(args[0]);
          colCall=Integer.parseInt(args[1]);
          filenameCall=args[2];
          seedCall=Integer.parseInt(args[3]);
          if(seedCall<0||seedCall>10000)
          {
            System.out.println(instructions);
          }
          else
          {
            dummy=new WordSearch(rowCall,colCall,filenameCall,seedCall);
            dummy.addAllWords();
            dummy.fillWithLetters();
            System.out.println(dummy.toString());
          }
        }
        if(args.length==5)
        {
          rowCall=Integer.parseInt(args[0]);
          colCall=Integer.parseInt(args[1]);
          filenameCall=args[2];
          seedCall=Integer.parseInt(args[3]);
          if(seedCall<0||seedCall>10000)
          {
            System.out.println(instructions);
          }
          else
          {
            answerCall=args[4];
            if(!answerCall.equals("key"))
            {
              dummy=new WordSearch(rowCall,colCall,filenameCall,seedCall);
              dummy.addAllWords();
              dummy.fillWithLetters();
              System.out.println(dummy.toString());
            }
            else
            {
              dummy=new WordSearch(rowCall,colCall,filenameCall,seedCall);
              dummy.addAllWords();
              dummy.demolishLetters();
              System.out.println(dummy.toString());
            }
          }
        }
      }
      catch(NumberFormatException e)
      {
        e.printStackTrace();
        System.out.println(instructions);
      }
      catch(FileNotFoundException e)
      {
        e.printStackTrace();
        System.out.println(instructions);
      }
    }

}
