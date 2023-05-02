package pages;

public class GridTestPage extends BasePages{
    private String cell = "//body/div[@id='root']/div[1]/table[1]";
   
    public GridTestPage(){
        super(driver);
    }

    public void navigateToGrid(){
        navigateTo("https://1v2njkypo4.csb.app");
    }

    public String getValueFromGrid(int row, int column){
       return getValueFromTable(cell, row, column);
    }
    public void setValueOnGrid(int row, int column, String value){
        setValueOnTable(cell, row, column, value);
    }

   

}
