package com.example.developerslife;

public interface PostIterator {
    Post getPost();
    Post getNextPost();
    Post getEarlyPost();
    boolean isFirstPost();
    boolean isLastPost();

}
