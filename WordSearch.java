public class WordSearch{
    private char[][] data;

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
      data=new char[rows][cols];
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
            answer=answer+data[r][c]+" ";
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
        if(data[row][col+i]=='_' && row<data.length && col<data[row].length)
        {
          data[row][col+i]=word.charAt(i);
        }
        else
        {
          return false;
        }
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
    }
}
