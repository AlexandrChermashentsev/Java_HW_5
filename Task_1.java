package Seminar_5_HW;

import java.util.*;

/*
Написать метод, определяющий правильность расстановки скобок в выражении
Могут содержаться следующие скобки: () [] {} <>
Примеры:
    () -> true
    [{}] ((<>)) -> true
    ) -> false
    [) -> false
    []{}(<)> -> false
 */

public class Task_1 {
    public static void main(String[] args) {
        System.out.println(isCorrectParentheses("[(<>)]()")); //true
        System.out.println(isCorrectParentheses("[]{}(<)>")); // false
        System.out.println(isCorrectParentheses("[)")); // false
        System.out.println(isCorrectParentheses("[{}] ((<>))")); // true

    }

    private static boolean isCorrectParentheses(String text){
        Map<Character, Character> db = new HashMap<>();
        db.put('(', ')');
        db.put('[', ']');
        db.put('{', '}');
        db.put('<', '>');
        
        List<Character> temp_list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if(db.containsKey(text.charAt(i))){
                temp_list.add(db.get(text.charAt(i)));
            } else 
            if (db.containsValue(text.charAt(i))){
                for (int j = temp_list.size()-1; j >= 0; j--) {
                    if (!temp_list.get(j).equals(text.charAt(i))){
                        return false;
                    } else {
                        temp_list.remove(j);
                        break;
                    }
                }
            }
        }
        return true;
    }
}