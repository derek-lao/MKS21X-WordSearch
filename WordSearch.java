import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
    private char[][] data;

//the random seed used to produce this WordSearch
    private int seed;

    //a random Object to unify your random calls
    private Random randgen;

    //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
    private ArrayList<String>wordsToAdd;

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String>wordsAdded;

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
      randgen = new Random();
      File f = new File(fileName);//can combine
      Scanner in = new Scanner(f);//into one line

        //NOW read the file here...
      while(in.hasNext())
      {
        String word=in.next();
        wordsToAdd.add(word);
      }

    //Choose a randSeed using the clock random
      randgen=new Random(System.currentTimemillis());

    }

    public WordSearch(int rows, int cols, String fileName, int randSeed){

    }
    //Use the random seed specified.


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
      File f = new File(fileName);//can combine
      Scanner in = new Scanner(f);//into one line

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
      while(in.hasNext())
      {
        String word=in.next();
        answer+=(" "+word+",");
      }
      answer=answer.substring(0,answer.length()-1)+" (seed: "+randSeed+")";
      return answer;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned
     * and the board is NOT modified.
     */
    // public boolean addWordHorizontal(String word,int row, int col){
    //   for(int i=0;i<word.length();i++)
    //   {
    //     if(!(row<data.length && col+i<data[row].length && (data[row][col+i]=='_' || data[row][col+i]==word.charAt(i))))
    //     return false;
    //   }
    //   for(int i=0;i<word.length();i++)
    //   {
    //     data[row][col+i]=word.charAt(i);
    //   }
    //   return true;
    // }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    // public boolean addWordVertical(String word,int row, int col){
    //   for(int i=0;i<word.length();i++)
    //   {
    //     if(!(row+i<data.length && col<data[row].length && (data[row+i][col]=='_' || data[row+i][col]==word.charAt(i))))
    //     return false;
    //   }
    //   for(int i=0;i<word.length();i++)
    //   {
    //     data[row+i][col]=word.charAt(i);
    //   }
    //   return true;
    // }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    // public boolean addWordDiagonal(String word,int row, int col){
    //   for(int i=0;i<word.length();i++)
    //   {
    //     if(!(row+i<data.length && col+i<data[row].length && (data[row+i][col+i]=='_' || data[row+i][col+i]==word.charAt(i))))
    //     return false;
    //   }
    //   for(int i=0;i<word.length();i++)
    //   {
    //     data[row+i][col+i]=word.charAt(i);
    //   }
    //   return true;
    // }

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
      ||(Math.abs(rowIncrement)>1&&Math.abs(colIncrement)>1))
      {
        return false;
      }
      for(int i=0;i<word.length();i++)
      {
        int rowPosition = row+(i*rowIncrement);
        int colPosition = col+(i*colIncrement);
        if(rowPosition>data.length           || rowPosition<0 ||
        colPosition>data[rowPosition].length || colPosition<0)
        {
          return false;
        }
        else
        {
          continue;
        }
      }
      for(int i=0;i<word.length();i++)
      {
        data[row+(i*rowIncrement)][col+(i*colIncrement)]=word.charAt(i);
        wordsAdded.add(0,wordsToAdd.remove(0));
      }
      return true;
    }

    /*[rowIncrement,colIncrement] examples:
     *[-1,1] would add up and the right because (row -1 each time, col + 1 each time)
     *[ 1,0] would add downwards because (row+1), with no col change
     *[ 0,-1] would add towards the left because (col - 1), with no row change
     */

    public boolean addAllWords(){

    }
    public static void main(String[] args){
      for(int i=0, r=0, c=0;i<4;i++,r++,c++)
      {
        System.out.println(i+", "+r+", "+c);
      }
      System.out.println("done");
    }

}
