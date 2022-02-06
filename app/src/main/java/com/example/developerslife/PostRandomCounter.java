package com.example.developerslife;


import java.util.ArrayList;

public class PostRandomCounter implements PostIterator {
    private ArrayList<Post> array;
    private int counter;
    public Post getEarlyPost(){
        if (counter != 0 ){
            return array.get(--counter);
        }
        return array.get(counter);
    }

    @Override
    public boolean isFirstPost() {
        return counter == 0;
    }



    @Override
    public boolean isLastPost() {
        return false;
    }


    @Override
    public Post getPost() {
        return array.get(counter);
    }

    public Post getNextPost(){
        if (counter < array.size() - 1) {
            Post result = array.get(++counter);
            return result;
        }
        if (counter == array.size() - 1) {
            getNewPost();
            counter++;
            return array.get(array.size()-1);
        }
        return array.get(array.size() - 1);
    }

    private void getNewPost(){
        Post post = new Post(Service.urlToJSON("https://developerslife.ru/random?json=true"));
        array.add(post);
    }

    public PostRandomCounter(){
        array = new ArrayList<>();
        getNewPost();
        this.counter = -1;
    }
}
