package com.example.developerslife;


import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    PostCategoryCounter counterLatestPost = null;
    PostCategoryCounter counterHotPost = null;
    PostCategoryCounter counterTopPost = null;
    PostRandomCounter counterRandomPost = null;
    PostIterator counterPost =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.post_image);
        TextView textView = findViewById(R.id.description);

        Button buttonNext = findViewById(R.id.button_next);
        Button buttonPrev = findViewById(R.id.button_prev);
        Button buttonLatest = findViewById(R.id.button_latest);
        Button buttonTop = findViewById(R.id.button_top);
        Button buttonHot = findViewById(R.id.button_hot);
        Button buttonRandom = findViewById(R.id.button_random);


        counterRandomPost = new PostRandomCounter();
        counterPost = counterRandomPost;
        Post post = counterPost.getNextPost();
        textView.setText(post.getDescription());
        Glide.with(MainActivity.this).load(post.getGifURL()).placeholder(R.drawable.loading_foreground).error(R.drawable.error_foreground).into(imageView);
        buttonPrev.setEnabled(false);
        buttonRandom.setEnabled(false);

        buttonRandom.setOnClickListener(view -> {
            counterPost = counterRandomPost;
            if (counterPost.getPost().getId() == 0 && !counterPost.getPost().getDescription().equals("Проблема с сетью")) {
                textView.setText("нет постов");
                imageView.setImageBitmap(null);
                buttonRandom.setEnabled(false);
                buttonHot.setEnabled(true);
                buttonLatest.setEnabled(true);
                buttonTop.setEnabled(true);
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
            } else {
                Post post1 = counterPost.getPost();
                textView.setText(post1.getDescription());
                Glide.with(MainActivity.this).load(post1.getGifURL()).placeholder(R.drawable.loading_foreground).error(R.drawable.error_foreground).into(imageView);
                buttonRandom.setEnabled(false);
                buttonHot.setEnabled(true);
                buttonLatest.setEnabled(true);
                buttonTop.setEnabled(true);
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
                if (counterPost.isLastPost()) {
                    buttonNext.setEnabled(false);
                }
                if (counterPost.isFirstPost()) {
                    buttonPrev.setEnabled(false);
                }
            }
        });


        buttonLatest.setOnClickListener(view -> {
            if (counterLatestPost == null) {
                counterLatestPost = new PostCategoryCounter("https://developerslife.ru/latest/0?json=true");
            }
            counterPost = counterLatestPost;
            if (counterPost.getPost().getId() == 0 && !counterPost.getPost().getDescription().equals("Проблема с сетью")) {
                textView.setText("здесь пока нет постов");
                Glide.with(MainActivity.this).load(R.drawable.not_posts_foreground).into(imageView);
                buttonHot.setEnabled(true);
                buttonLatest.setEnabled(false);
                buttonTop.setEnabled(true);
                buttonNext.setEnabled(false);
                buttonPrev.setEnabled(false);
                buttonRandom.setEnabled(true);
            } else {
                Post post12 = counterPost.getPost();
                textView.setText(post12.getDescription());
                Glide.with(MainActivity.this).load(post12.getGifURL()).placeholder(R.drawable.loading_foreground).error(R.drawable.error_foreground).into(imageView);
                buttonHot.setEnabled(true);
                buttonLatest.setEnabled(false);
                buttonTop.setEnabled(true);
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
                buttonRandom.setEnabled(true);
                if (counterPost.isLastPost()) {
                    buttonNext.setEnabled(false);
                }
                if (counterPost.isFirstPost()) {
                    buttonPrev.setEnabled(false);
                }
            }
        });

        buttonTop.setOnClickListener(view -> {
            if (counterTopPost == null) {
                counterTopPost = new PostCategoryCounter("https://developerslife.ru/top/0?json=true");
            }
            counterPost = counterTopPost;
            if (counterPost.getPost().getId() == 0 && !counterPost.getPost().getDescription().equals("Проблема с сетью")) {
                textView.setText("здесь пока нет постов");
                Glide.with(MainActivity.this).load(R.drawable.not_posts_foreground).into(imageView);
                buttonHot.setEnabled(true);
                buttonLatest.setEnabled(true);
                buttonTop.setEnabled(false);
                buttonNext.setEnabled(false);
                buttonPrev.setEnabled(false);
                buttonRandom.setEnabled(true);
            } else {

                Post post13 = counterPost.getPost();
                textView.setText(post13.getDescription());
                Glide.with(MainActivity.this).load(post13.getGifURL()).placeholder(R.drawable.loading_foreground).error(R.drawable.error_foreground).into(imageView);
                buttonHot.setEnabled(true);
                buttonLatest.setEnabled(true);
                buttonTop.setEnabled(false);
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
                buttonRandom.setEnabled(true);
                if (counterPost.isLastPost()) {
                    buttonNext.setEnabled(false);
                }
                if (counterPost.isFirstPost()) {
                    buttonPrev.setEnabled(false);
                }
            }
        });

        buttonHot.setOnClickListener(view -> {
            if (counterHotPost == null) {
                counterHotPost = new PostCategoryCounter("https://developerslife.ru/hot/0?json=true");
            }
            counterPost = counterHotPost;
            if (counterPost.getPost().getId() == 0 && !counterPost.getPost().getDescription().equals("Проблема с сетью")) {
                textView.setText("здесь пока нет постов");
                Glide.with(MainActivity.this).load(R.drawable.not_posts_foreground).into(imageView);
                buttonHot.setEnabled(false);
                buttonNext.setEnabled(false);
                buttonPrev.setEnabled(false);
                buttonLatest.setEnabled(true);
                buttonTop.setEnabled(true);
                buttonRandom.setEnabled(true);
            } else {
                counterPost = counterHotPost;
                Post post14 = counterPost.getNextPost();
                textView.setText(post14.getDescription());
                Glide.with(MainActivity.this).load(post14.getGifURL()).placeholder(R.drawable.loading_foreground).error(R.drawable.error_foreground).into(imageView);
                buttonHot.setEnabled(false);
                buttonLatest.setEnabled(true);
                buttonTop.setEnabled(true);
                buttonRandom.setEnabled(true);
                buttonNext.setEnabled(true);
                buttonPrev.setEnabled(true);
                if (counterPost.isLastPost()) {
                    buttonNext.setEnabled(false);
                }
                if (counterPost.isFirstPost()) {
                    buttonPrev.setEnabled(false);
                }
            }
        });

        buttonNext.setOnClickListener(view -> {
            Post post15 = counterPost.getNextPost();
            textView.setText(post15.getDescription());
            Glide.with(MainActivity.this).load(post15.getGifURL()).placeholder(R.drawable.loading_foreground).error(R.drawable.error_foreground).into(imageView);
            buttonPrev.setEnabled(true);
            if (counterPost.isLastPost()){
                buttonNext.setEnabled(false);
            }
        });

        buttonPrev.setOnClickListener(view -> {
            Post post16 = counterPost.getEarlyPost();
            textView.setText(post16.getDescription());
            Glide.with(MainActivity.this).load(post16.getGifURL()).placeholder(R.drawable.loading_foreground).error(R.drawable.error_foreground).into(imageView);
            buttonNext.setEnabled(true);
            if (counterPost.isFirstPost()){
                buttonPrev.setEnabled(false);
            }
        });
    }
}
