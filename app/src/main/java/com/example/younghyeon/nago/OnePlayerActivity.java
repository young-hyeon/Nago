package com.example.younghyeon.nago;

import android.os.Bundle;

/**
 * Created by YOUNGHYEON on 2016-02-03.
 */
public class OnePlayerActivity extends MainActivity{

    int ko_z;
    int FILL_EYE_ERR = 1;
    int FILL_EYE_OK = 0;
    double komi = 6.5;
    int B_SIZE = 13;
    int WIDTH = (B_SIZE + 2);
    int BOARD_MAX = (WIDTH * WIDTH);
    int board[] =  {
            3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,0,0,0,0,0,0,0,0,0,0,0,0,0,3,
            3,3,3,3,3,3,3,3,3,3,3,3,3,3,3
    };
    int dir4[] = { +1,-1,+WIDTH,-WIDTH };  // 1, -1, 15, -15  4방향 좌표 값 구하기 위해서
    int[] check_board = new int[BOARD_MAX]; // 바둑판 만한 크기의 1차원 배열로 선언
    int color = 1;
    int cur_position;
    int latest_z;
    int cur_z = 1;
    int liberty = 0;
    int stone = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_player_activity);
    }
}
