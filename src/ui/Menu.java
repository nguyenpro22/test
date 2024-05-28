/*
Menu: là 1 cái khuôn chuyên đúc ra 1 anh quản lý menu
anh này giúp quản lý ds các lựa chọn
*/
package ui;

import java.util.ArrayList;
import utils.Inputer;

public class Menu {
   public String title;
   public ArrayList<String> optionList = new ArrayList<>();
   
   //constructor

    public Menu(String title) {
        this.title = title;
    }
   //method
    //add option
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    
    //print menu
    public void print(){
        int count = 1;
        System.out.println("------"+title.toUpperCase()+"------");
        for (String item : optionList) {
            System.out.println(count + ". " + item);
            count++;
        }
    }
    //trong menu làm thêm method getChoice
    public int getChoice(){
        return Inputer.getAnInteger("Input your choice: ", 
                "Your choice must to between 1 and " + optionList.size(),
                1, optionList.size(), false);
    }
}
