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
      String answer="";
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
          answer+="\n\n";
        }
        else
        {
          continue;
        }
      }
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
    public boolean addWordHorizontal(String word,int row, int col){
      for(int i=0;i<word.length();i++)
      {
        if(!(row<data.length && col+i<data[row].length && (data[row][col+i]=='_' || data[row][col+i]==word.charAt(i))))
        return false;
      }
      for(int i=0;i<word.length();i++)
      {
        data[row][col+i]=word.charAt(i);
      }
      return true;
    }

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
    public boolean addWordVertical(String word,int row, int col){
      for(int i=0;i<word.length();i++)
      {
        if(!(row+i<data.length && col<data[row].length && (data[row+i][col]=='_' || data[row+i][col]==word.charAt(i))))
        return false;
      }
      for(int i=0;i<word.length();i++)
      {
        data[row+i][col]=word.charAt(i);
      }
      return true;
    }

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
    public boolean addWordDiagonal(String word,int row, int col){
      for(int i=0;i<word.length();i++)
      {
        if(!(row+i<data.length && col+i<data[row].length && (data[row+i][col+i]=='_' || data[row+i][col+i]==word.charAt(i))))
        return false;
      }
      for(int i=0;i<word.length();i++)
      {
        data[row+i][col+i]=word.charAt(i);
      }
      return true;
    }

}
