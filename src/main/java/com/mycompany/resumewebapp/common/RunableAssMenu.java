package com.mycompany.resumewebapp.common;

import java.util.Scanner;

public interface RunableAssMenu {

    default void showMenu(){
        while (true) {
            System.out.println("Hansi emeliyyati etmek isteyirsiniz");
            System.out.println(
                    "0. First create \n" +
                            "1. Create new \n" +
                            "2. Update \n" +
                            "3. Delete \n" +
                            "4. Search \n" +
                            "5. Show all");

            int action = new Scanner(System.in).nextInt();

            if (action == 0){
                initialize();
            }else if (action == 1){
                initializeNew();
            }else if (action == 2){
                update();
            }else if (action == 3){
                delete();
            } else if (action == 4) {
                find();
            } else if (action == 5) {
                printAll();
            }
        }
    }

    void initialize();

    void initializeNew();

    void update();

    void delete();

    void printAll();

    void find();

}
