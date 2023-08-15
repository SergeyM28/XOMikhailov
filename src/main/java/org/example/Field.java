package org.example;

import javax.print.DocFlavor;

public class Field {
    private String fieldCode;
    private String fieldView;

    private void makeView(){
        StringBuilder stringBuilder = new StringBuilder();
        int currentIndex = 0;
        for (int i = 0; i < 3; i++){
            stringBuilder.append("|");
            for (int j = currentIndex; j < currentIndex + 3; j++){
                switch(this.fieldCode.charAt(j)){
                    case '0':
                        stringBuilder.append(" ");
                        break;
                    case '1':
                        stringBuilder.append("X");
                        break;
                    case '2':
                        stringBuilder.append("0");
                        break;
                    default:
                        throw new RuntimeException("Ошибка, передано неверное число");
                }
            }
            stringBuilder.append("|\n");
            currentIndex += 3;
        }
        this.fieldView = stringBuilder.toString();
    }

    private void makeCode(){
        StringBuilder stringBuilder = new StringBuilder();
        int currentIndex = 0;
        while (stringBuilder.length() < 9){
                switch(this.fieldView.charAt(currentIndex)){
                    case ' ':
                        stringBuilder.append("0");
                        break;
                    case 'X':
                        stringBuilder.append("1");
                        break;
                    case '0':
                        stringBuilder.append("2");
                        break;
                }
                currentIndex++;
                }
        this.fieldCode = stringBuilder.toString();
    }
    public String transferCodeToVoew(String code){
        this.fieldCode = code;
        makeView();
        return fieldView;
    }
    public String transferViewToCode(String view){
        this.fieldView = view;
        makeCode();
        return fieldCode;
    }
}
