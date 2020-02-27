package ru.job4j.array;

public class EndsWith {

    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        for (int i = 0; i < post.length; i++) {
            return word[word.length - 1 - i] == post[post.length - 1 - i];
        }
        return result;
    }

}
