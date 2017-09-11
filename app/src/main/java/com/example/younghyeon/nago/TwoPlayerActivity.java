package com.example.younghyeon.nago;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * Created by YOUNGHYEON on 2016-02-03.
 */
public class TwoPlayerActivity extends MainActivity{

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
        setContentView(R.layout.two_player_activity);
        final ImageButton IB_Stone0101 = (ImageButton) findViewById(R.id.stone0101);
        final ImageButton IB_Stone0102 = (ImageButton) findViewById(R.id.stone0102);
        final ImageButton IB_Stone0103 = (ImageButton) findViewById(R.id.stone0103);
        final ImageButton IB_Stone0104 = (ImageButton) findViewById(R.id.stone0104);
        final ImageButton IB_Stone0105 = (ImageButton) findViewById(R.id.stone0105);
        final ImageButton IB_Stone0106 = (ImageButton) findViewById(R.id.stone0106);
        final ImageButton IB_Stone0107 = (ImageButton) findViewById(R.id.stone0107);
        final ImageButton IB_Stone0108 = (ImageButton) findViewById(R.id.stone0108);
        final ImageButton IB_Stone0109 = (ImageButton) findViewById(R.id.stone0109);
        final ImageButton IB_Stone0110 = (ImageButton) findViewById(R.id.stone0110);
        final ImageButton IB_Stone0111 = (ImageButton) findViewById(R.id.stone0111);
        final ImageButton IB_Stone0112 = (ImageButton) findViewById(R.id.stone0112);
        final ImageButton IB_Stone0113 = (ImageButton) findViewById(R.id.stone0113);

        final ImageButton IB_Stone0201 = (ImageButton) findViewById(R.id.stone0201);
        final ImageButton IB_Stone0202 = (ImageButton) findViewById(R.id.stone0202);
        final ImageButton IB_Stone0203 = (ImageButton) findViewById(R.id.stone0203);
        final ImageButton IB_Stone0204 = (ImageButton) findViewById(R.id.stone0204);
        final ImageButton IB_Stone0205 = (ImageButton) findViewById(R.id.stone0205);
        final ImageButton IB_Stone0206 = (ImageButton) findViewById(R.id.stone0206);
        final ImageButton IB_Stone0207 = (ImageButton) findViewById(R.id.stone0207);
        final ImageButton IB_Stone0208 = (ImageButton) findViewById(R.id.stone0208);
        final ImageButton IB_Stone0209 = (ImageButton) findViewById(R.id.stone0209);
        final ImageButton IB_Stone0210 = (ImageButton) findViewById(R.id.stone0210);
        final ImageButton IB_Stone0211 = (ImageButton) findViewById(R.id.stone0211);
        final ImageButton IB_Stone0212 = (ImageButton) findViewById(R.id.stone0212);
        final ImageButton IB_Stone0213 = (ImageButton) findViewById(R.id.stone0213);

        final ImageButton IB_Stone0301 = (ImageButton) findViewById(R.id.stone0301);
        final ImageButton IB_Stone0302 = (ImageButton) findViewById(R.id.stone0302);
        final ImageButton IB_Stone0303 = (ImageButton) findViewById(R.id.stone0303);
        final ImageButton IB_Stone0304 = (ImageButton) findViewById(R.id.stone0304);
        final ImageButton IB_Stone0305 = (ImageButton) findViewById(R.id.stone0305);
        final ImageButton IB_Stone0306 = (ImageButton) findViewById(R.id.stone0306);
        final ImageButton IB_Stone0307 = (ImageButton) findViewById(R.id.stone0307);
        final ImageButton IB_Stone0308 = (ImageButton) findViewById(R.id.stone0308);
        final ImageButton IB_Stone0309 = (ImageButton) findViewById(R.id.stone0309);
        final ImageButton IB_Stone0310 = (ImageButton) findViewById(R.id.stone0310);
        final ImageButton IB_Stone0311 = (ImageButton) findViewById(R.id.stone0311);
        final ImageButton IB_Stone0312 = (ImageButton) findViewById(R.id.stone0312);
        final ImageButton IB_Stone0313 = (ImageButton) findViewById(R.id.stone0313);

        final ImageButton IB_Stone0401 = (ImageButton) findViewById(R.id.stone0401);
        final ImageButton IB_Stone0402 = (ImageButton) findViewById(R.id.stone0402);
        final ImageButton IB_Stone0403 = (ImageButton) findViewById(R.id.stone0403);
        final ImageButton IB_Stone0404 = (ImageButton) findViewById(R.id.stone0404);
        final ImageButton IB_Stone0405 = (ImageButton) findViewById(R.id.stone0405);
        final ImageButton IB_Stone0406 = (ImageButton) findViewById(R.id.stone0406);
        final ImageButton IB_Stone0407 = (ImageButton) findViewById(R.id.stone0407);
        final ImageButton IB_Stone0408 = (ImageButton) findViewById(R.id.stone0408);
        final ImageButton IB_Stone0409 = (ImageButton) findViewById(R.id.stone0409);
        final ImageButton IB_Stone0410 = (ImageButton) findViewById(R.id.stone0410);
        final ImageButton IB_Stone0411 = (ImageButton) findViewById(R.id.stone0411);
        final ImageButton IB_Stone0412 = (ImageButton) findViewById(R.id.stone0412);
        final ImageButton IB_Stone0413 = (ImageButton) findViewById(R.id.stone0413);

        final ImageButton IB_Stone0501 = (ImageButton) findViewById(R.id.stone0501);
        final ImageButton IB_Stone0502 = (ImageButton) findViewById(R.id.stone0502);
        final ImageButton IB_Stone0503 = (ImageButton) findViewById(R.id.stone0503);
        final ImageButton IB_Stone0504 = (ImageButton) findViewById(R.id.stone0504);
        final ImageButton IB_Stone0505 = (ImageButton) findViewById(R.id.stone0505);
        final ImageButton IB_Stone0506 = (ImageButton) findViewById(R.id.stone0506);
        final ImageButton IB_Stone0507 = (ImageButton) findViewById(R.id.stone0507);
        final ImageButton IB_Stone0508 = (ImageButton) findViewById(R.id.stone0508);
        final ImageButton IB_Stone0509 = (ImageButton) findViewById(R.id.stone0509);
        final ImageButton IB_Stone0510 = (ImageButton) findViewById(R.id.stone0510);
        final ImageButton IB_Stone0511 = (ImageButton) findViewById(R.id.stone0511);
        final ImageButton IB_Stone0512 = (ImageButton) findViewById(R.id.stone0512);
        final ImageButton IB_Stone0513 = (ImageButton) findViewById(R.id.stone0513);

        final ImageButton IB_Stone0601 = (ImageButton) findViewById(R.id.stone0601);
        final ImageButton IB_Stone0602 = (ImageButton) findViewById(R.id.stone0602);
        final ImageButton IB_Stone0603 = (ImageButton) findViewById(R.id.stone0603);
        final ImageButton IB_Stone0604 = (ImageButton) findViewById(R.id.stone0604);
        final ImageButton IB_Stone0605 = (ImageButton) findViewById(R.id.stone0605);
        final ImageButton IB_Stone0606 = (ImageButton) findViewById(R.id.stone0606);
        final ImageButton IB_Stone0607 = (ImageButton) findViewById(R.id.stone0607);
        final ImageButton IB_Stone0608 = (ImageButton) findViewById(R.id.stone0608);
        final ImageButton IB_Stone0609 = (ImageButton) findViewById(R.id.stone0609);
        final ImageButton IB_Stone0610 = (ImageButton) findViewById(R.id.stone0610);
        final ImageButton IB_Stone0611 = (ImageButton) findViewById(R.id.stone0611);
        final ImageButton IB_Stone0612 = (ImageButton) findViewById(R.id.stone0612);
        final ImageButton IB_Stone0613 = (ImageButton) findViewById(R.id.stone0613);

        final ImageButton IB_Stone0701 = (ImageButton) findViewById(R.id.stone0701);
        final ImageButton IB_Stone0702 = (ImageButton) findViewById(R.id.stone0702);
        final ImageButton IB_Stone0703 = (ImageButton) findViewById(R.id.stone0703);
        final ImageButton IB_Stone0704 = (ImageButton) findViewById(R.id.stone0704);
        final ImageButton IB_Stone0705 = (ImageButton) findViewById(R.id.stone0705);
        final ImageButton IB_Stone0706 = (ImageButton) findViewById(R.id.stone0706);
        final ImageButton IB_Stone0707 = (ImageButton) findViewById(R.id.stone0707);
        final ImageButton IB_Stone0708 = (ImageButton) findViewById(R.id.stone0708);
        final ImageButton IB_Stone0709 = (ImageButton) findViewById(R.id.stone0709);
        final ImageButton IB_Stone0710 = (ImageButton) findViewById(R.id.stone0710);
        final ImageButton IB_Stone0711 = (ImageButton) findViewById(R.id.stone0711);
        final ImageButton IB_Stone0712 = (ImageButton) findViewById(R.id.stone0712);
        final ImageButton IB_Stone0713 = (ImageButton) findViewById(R.id.stone0713);

        final ImageButton IB_Stone0801 = (ImageButton) findViewById(R.id.stone0801);
        final ImageButton IB_Stone0802 = (ImageButton) findViewById(R.id.stone0802);
        final ImageButton IB_Stone0803 = (ImageButton) findViewById(R.id.stone0803);
        final ImageButton IB_Stone0804 = (ImageButton) findViewById(R.id.stone0804);
        final ImageButton IB_Stone0805 = (ImageButton) findViewById(R.id.stone0805);
        final ImageButton IB_Stone0806 = (ImageButton) findViewById(R.id.stone0806);
        final ImageButton IB_Stone0807 = (ImageButton) findViewById(R.id.stone0807);
        final ImageButton IB_Stone0808 = (ImageButton) findViewById(R.id.stone0808);
        final ImageButton IB_Stone0809 = (ImageButton) findViewById(R.id.stone0809);
        final ImageButton IB_Stone0810 = (ImageButton) findViewById(R.id.stone0810);
        final ImageButton IB_Stone0811 = (ImageButton) findViewById(R.id.stone0811);
        final ImageButton IB_Stone0812 = (ImageButton) findViewById(R.id.stone0812);
        final ImageButton IB_Stone0813 = (ImageButton) findViewById(R.id.stone0813);

        final ImageButton IB_Stone0901 = (ImageButton) findViewById(R.id.stone0901);
        final ImageButton IB_Stone0902 = (ImageButton) findViewById(R.id.stone0902);
        final ImageButton IB_Stone0903 = (ImageButton) findViewById(R.id.stone0903);
        final ImageButton IB_Stone0904 = (ImageButton) findViewById(R.id.stone0904);
        final ImageButton IB_Stone0905 = (ImageButton) findViewById(R.id.stone0905);
        final ImageButton IB_Stone0906 = (ImageButton) findViewById(R.id.stone0906);
        final ImageButton IB_Stone0907 = (ImageButton) findViewById(R.id.stone0907);
        final ImageButton IB_Stone0908 = (ImageButton) findViewById(R.id.stone0908);
        final ImageButton IB_Stone0909 = (ImageButton) findViewById(R.id.stone0909);
        final ImageButton IB_Stone0910 = (ImageButton) findViewById(R.id.stone0910);
        final ImageButton IB_Stone0911 = (ImageButton) findViewById(R.id.stone0911);
        final ImageButton IB_Stone0912 = (ImageButton) findViewById(R.id.stone0912);
        final ImageButton IB_Stone0913 = (ImageButton) findViewById(R.id.stone0913);

        final ImageButton IB_Stone1001 = (ImageButton) findViewById(R.id.stone1001);
        final ImageButton IB_Stone1002 = (ImageButton) findViewById(R.id.stone1002);
        final ImageButton IB_Stone1003 = (ImageButton) findViewById(R.id.stone1003);
        final ImageButton IB_Stone1004 = (ImageButton) findViewById(R.id.stone1004);
        final ImageButton IB_Stone1005 = (ImageButton) findViewById(R.id.stone1005);
        final ImageButton IB_Stone1006 = (ImageButton) findViewById(R.id.stone1006);
        final ImageButton IB_Stone1007 = (ImageButton) findViewById(R.id.stone1007);
        final ImageButton IB_Stone1008 = (ImageButton) findViewById(R.id.stone1008);
        final ImageButton IB_Stone1009 = (ImageButton) findViewById(R.id.stone1009);
        final ImageButton IB_Stone1010 = (ImageButton) findViewById(R.id.stone1010);
        final ImageButton IB_Stone1011 = (ImageButton) findViewById(R.id.stone1011);
        final ImageButton IB_Stone1012 = (ImageButton) findViewById(R.id.stone1012);
        final ImageButton IB_Stone1013 = (ImageButton) findViewById(R.id.stone1013);

        final ImageButton IB_Stone1101 = (ImageButton) findViewById(R.id.stone1101);
        final ImageButton IB_Stone1102 = (ImageButton) findViewById(R.id.stone1102);
        final ImageButton IB_Stone1103 = (ImageButton) findViewById(R.id.stone1103);
        final ImageButton IB_Stone1104 = (ImageButton) findViewById(R.id.stone1104);
        final ImageButton IB_Stone1105 = (ImageButton) findViewById(R.id.stone1105);
        final ImageButton IB_Stone1106 = (ImageButton) findViewById(R.id.stone1106);
        final ImageButton IB_Stone1107 = (ImageButton) findViewById(R.id.stone1107);
        final ImageButton IB_Stone1108 = (ImageButton) findViewById(R.id.stone1108);
        final ImageButton IB_Stone1109 = (ImageButton) findViewById(R.id.stone1109);
        final ImageButton IB_Stone1110 = (ImageButton) findViewById(R.id.stone1110);
        final ImageButton IB_Stone1111 = (ImageButton) findViewById(R.id.stone1111);
        final ImageButton IB_Stone1112 = (ImageButton) findViewById(R.id.stone1112);
        final ImageButton IB_Stone1113 = (ImageButton) findViewById(R.id.stone1113);

        final ImageButton IB_Stone1201 = (ImageButton) findViewById(R.id.stone1201);
        final ImageButton IB_Stone1202 = (ImageButton) findViewById(R.id.stone1202);
        final ImageButton IB_Stone1203 = (ImageButton) findViewById(R.id.stone1203);
        final ImageButton IB_Stone1204 = (ImageButton) findViewById(R.id.stone1204);
        final ImageButton IB_Stone1205 = (ImageButton) findViewById(R.id.stone1205);
        final ImageButton IB_Stone1206 = (ImageButton) findViewById(R.id.stone1206);
        final ImageButton IB_Stone1207 = (ImageButton) findViewById(R.id.stone1207);
        final ImageButton IB_Stone1208 = (ImageButton) findViewById(R.id.stone1208);
        final ImageButton IB_Stone1209 = (ImageButton) findViewById(R.id.stone1209);
        final ImageButton IB_Stone1210 = (ImageButton) findViewById(R.id.stone1210);
        final ImageButton IB_Stone1211 = (ImageButton) findViewById(R.id.stone1211);
        final ImageButton IB_Stone1212 = (ImageButton) findViewById(R.id.stone1212);
        final ImageButton IB_Stone1213 = (ImageButton) findViewById(R.id.stone1213);

        final ImageButton IB_Stone1301 = (ImageButton) findViewById(R.id.stone1301);
        final ImageButton IB_Stone1302 = (ImageButton) findViewById(R.id.stone1302);
        final ImageButton IB_Stone1303 = (ImageButton) findViewById(R.id.stone1303);
        final ImageButton IB_Stone1304 = (ImageButton) findViewById(R.id.stone1304);
        final ImageButton IB_Stone1305 = (ImageButton) findViewById(R.id.stone1305);
        final ImageButton IB_Stone1306 = (ImageButton) findViewById(R.id.stone1306);
        final ImageButton IB_Stone1307 = (ImageButton) findViewById(R.id.stone1307);
        final ImageButton IB_Stone1308 = (ImageButton) findViewById(R.id.stone1308);
        final ImageButton IB_Stone1309 = (ImageButton) findViewById(R.id.stone1309);
        final ImageButton IB_Stone1310 = (ImageButton) findViewById(R.id.stone1310);
        final ImageButton IB_Stone1311 = (ImageButton) findViewById(R.id.stone1311);
        final ImageButton IB_Stone1312 = (ImageButton) findViewById(R.id.stone1312);
        final ImageButton IB_Stone1313 = (ImageButton) findViewById(R.id.stone1313);





        Button put_button = (Button) findViewById(R.id.put_button);

        put_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (latest_z != cur_z) { // 돌이 놓여져 있지 않은 자리에 돌을 놓았을 경우에만 착수가 가능하다
                    put(cur_z, color, FILL_EYE_ERR); // 해당 돌을 빈자리에 놓는다
                    print_cur_board(v); // 보드판 출력
                    color = flip_color(color); // 색깔 바꾸기
                }
            }
        });

        Button back_button = (Button) findViewById(R.id.back_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                board[latest_z] = 0;
                color = flip_color(color);
                print_cur_board(v);
            }
        });

        MyListener put_listener = new MyListener();

        IB_Stone0101.setOnClickListener(put_listener);
        IB_Stone0102.setOnClickListener(put_listener);
        IB_Stone0103.setOnClickListener(put_listener);
        IB_Stone0104.setOnClickListener(put_listener);
        IB_Stone0105.setOnClickListener(put_listener);
        IB_Stone0106.setOnClickListener(put_listener);
        IB_Stone0107.setOnClickListener(put_listener);
        IB_Stone0108.setOnClickListener(put_listener);
        IB_Stone0109.setOnClickListener(put_listener);
        IB_Stone0110.setOnClickListener(put_listener);
        IB_Stone0111.setOnClickListener(put_listener);
        IB_Stone0112.setOnClickListener(put_listener);
        IB_Stone0113.setOnClickListener(put_listener);

        IB_Stone0201.setOnClickListener(put_listener);
        IB_Stone0202.setOnClickListener(put_listener);
        IB_Stone0203.setOnClickListener(put_listener);
        IB_Stone0204.setOnClickListener(put_listener);
        IB_Stone0205.setOnClickListener(put_listener);
        IB_Stone0206.setOnClickListener(put_listener);
        IB_Stone0207.setOnClickListener(put_listener);
        IB_Stone0208.setOnClickListener(put_listener);
        IB_Stone0209.setOnClickListener(put_listener);
        IB_Stone0210.setOnClickListener(put_listener);
        IB_Stone0211.setOnClickListener(put_listener);
        IB_Stone0212.setOnClickListener(put_listener);
        IB_Stone0213.setOnClickListener(put_listener);

        IB_Stone0301.setOnClickListener(put_listener);
        IB_Stone0302.setOnClickListener(put_listener);
        IB_Stone0303.setOnClickListener(put_listener);
        IB_Stone0304.setOnClickListener(put_listener);
        IB_Stone0305.setOnClickListener(put_listener);
        IB_Stone0306.setOnClickListener(put_listener);
        IB_Stone0307.setOnClickListener(put_listener);
        IB_Stone0308.setOnClickListener(put_listener);
        IB_Stone0309.setOnClickListener(put_listener);
        IB_Stone0310.setOnClickListener(put_listener);
        IB_Stone0311.setOnClickListener(put_listener);
        IB_Stone0312.setOnClickListener(put_listener);
        IB_Stone0313.setOnClickListener(put_listener);

        IB_Stone0401.setOnClickListener(put_listener);
        IB_Stone0402.setOnClickListener(put_listener);
        IB_Stone0403.setOnClickListener(put_listener);
        IB_Stone0404.setOnClickListener(put_listener);
        IB_Stone0405.setOnClickListener(put_listener);
        IB_Stone0406.setOnClickListener(put_listener);
        IB_Stone0407.setOnClickListener(put_listener);
        IB_Stone0408.setOnClickListener(put_listener);
        IB_Stone0409.setOnClickListener(put_listener);
        IB_Stone0410.setOnClickListener(put_listener);
        IB_Stone0411.setOnClickListener(put_listener);
        IB_Stone0412.setOnClickListener(put_listener);
        IB_Stone0413.setOnClickListener(put_listener);

        IB_Stone0501.setOnClickListener(put_listener);
        IB_Stone0502.setOnClickListener(put_listener);
        IB_Stone0503.setOnClickListener(put_listener);
        IB_Stone0504.setOnClickListener(put_listener);
        IB_Stone0505.setOnClickListener(put_listener);
        IB_Stone0506.setOnClickListener(put_listener);
        IB_Stone0507.setOnClickListener(put_listener);
        IB_Stone0508.setOnClickListener(put_listener);
        IB_Stone0509.setOnClickListener(put_listener);
        IB_Stone0510.setOnClickListener(put_listener);
        IB_Stone0511.setOnClickListener(put_listener);
        IB_Stone0512.setOnClickListener(put_listener);
        IB_Stone0513.setOnClickListener(put_listener);

        IB_Stone0601.setOnClickListener(put_listener);
        IB_Stone0602.setOnClickListener(put_listener);
        IB_Stone0603.setOnClickListener(put_listener);
        IB_Stone0604.setOnClickListener(put_listener);
        IB_Stone0605.setOnClickListener(put_listener);
        IB_Stone0606.setOnClickListener(put_listener);
        IB_Stone0607.setOnClickListener(put_listener);
        IB_Stone0608.setOnClickListener(put_listener);
        IB_Stone0609.setOnClickListener(put_listener);
        IB_Stone0610.setOnClickListener(put_listener);
        IB_Stone0611.setOnClickListener(put_listener);
        IB_Stone0612.setOnClickListener(put_listener);
        IB_Stone0613.setOnClickListener(put_listener);

        IB_Stone0701.setOnClickListener(put_listener);
        IB_Stone0702.setOnClickListener(put_listener);
        IB_Stone0703.setOnClickListener(put_listener);
        IB_Stone0704.setOnClickListener(put_listener);
        IB_Stone0705.setOnClickListener(put_listener);
        IB_Stone0706.setOnClickListener(put_listener);
        IB_Stone0707.setOnClickListener(put_listener);
        IB_Stone0708.setOnClickListener(put_listener);
        IB_Stone0709.setOnClickListener(put_listener);
        IB_Stone0710.setOnClickListener(put_listener);
        IB_Stone0711.setOnClickListener(put_listener);
        IB_Stone0712.setOnClickListener(put_listener);
        IB_Stone0713.setOnClickListener(put_listener);

        IB_Stone0801.setOnClickListener(put_listener);
        IB_Stone0802.setOnClickListener(put_listener);
        IB_Stone0803.setOnClickListener(put_listener);
        IB_Stone0804.setOnClickListener(put_listener);
        IB_Stone0805.setOnClickListener(put_listener);
        IB_Stone0806.setOnClickListener(put_listener);
        IB_Stone0807.setOnClickListener(put_listener);
        IB_Stone0808.setOnClickListener(put_listener);
        IB_Stone0809.setOnClickListener(put_listener);
        IB_Stone0810.setOnClickListener(put_listener);
        IB_Stone0811.setOnClickListener(put_listener);
        IB_Stone0812.setOnClickListener(put_listener);
        IB_Stone0813.setOnClickListener(put_listener);

        IB_Stone0901.setOnClickListener(put_listener);
        IB_Stone0902.setOnClickListener(put_listener);
        IB_Stone0903.setOnClickListener(put_listener);
        IB_Stone0904.setOnClickListener(put_listener);
        IB_Stone0905.setOnClickListener(put_listener);
        IB_Stone0906.setOnClickListener(put_listener);
        IB_Stone0907.setOnClickListener(put_listener);
        IB_Stone0908.setOnClickListener(put_listener);
        IB_Stone0909.setOnClickListener(put_listener);
        IB_Stone0910.setOnClickListener(put_listener);
        IB_Stone0911.setOnClickListener(put_listener);
        IB_Stone0912.setOnClickListener(put_listener);
        IB_Stone0913.setOnClickListener(put_listener);

        IB_Stone1001.setOnClickListener(put_listener);
        IB_Stone1002.setOnClickListener(put_listener);
        IB_Stone1003.setOnClickListener(put_listener);
        IB_Stone1004.setOnClickListener(put_listener);
        IB_Stone1005.setOnClickListener(put_listener);
        IB_Stone1006.setOnClickListener(put_listener);
        IB_Stone1007.setOnClickListener(put_listener);
        IB_Stone1008.setOnClickListener(put_listener);
        IB_Stone1009.setOnClickListener(put_listener);
        IB_Stone1010.setOnClickListener(put_listener);
        IB_Stone1011.setOnClickListener(put_listener);
        IB_Stone1012.setOnClickListener(put_listener);
        IB_Stone1013.setOnClickListener(put_listener);

        IB_Stone1101.setOnClickListener(put_listener);
        IB_Stone1102.setOnClickListener(put_listener);
        IB_Stone1103.setOnClickListener(put_listener);
        IB_Stone1104.setOnClickListener(put_listener);
        IB_Stone1105.setOnClickListener(put_listener);
        IB_Stone1106.setOnClickListener(put_listener);
        IB_Stone1107.setOnClickListener(put_listener);
        IB_Stone1108.setOnClickListener(put_listener);
        IB_Stone1109.setOnClickListener(put_listener);
        IB_Stone1110.setOnClickListener(put_listener);
        IB_Stone1111.setOnClickListener(put_listener);
        IB_Stone1112.setOnClickListener(put_listener);
        IB_Stone1113.setOnClickListener(put_listener);

        IB_Stone1201.setOnClickListener(put_listener);
        IB_Stone1202.setOnClickListener(put_listener);
        IB_Stone1203.setOnClickListener(put_listener);
        IB_Stone1204.setOnClickListener(put_listener);
        IB_Stone1205.setOnClickListener(put_listener);
        IB_Stone1206.setOnClickListener(put_listener);
        IB_Stone1207.setOnClickListener(put_listener);
        IB_Stone1208.setOnClickListener(put_listener);
        IB_Stone1209.setOnClickListener(put_listener);
        IB_Stone1210.setOnClickListener(put_listener);
        IB_Stone1211.setOnClickListener(put_listener);
        IB_Stone1212.setOnClickListener(put_listener);
        IB_Stone1213.setOnClickListener(put_listener);

        IB_Stone1301.setOnClickListener(put_listener);
        IB_Stone1302.setOnClickListener(put_listener);
        IB_Stone1303.setOnClickListener(put_listener);
        IB_Stone1304.setOnClickListener(put_listener);
        IB_Stone1305.setOnClickListener(put_listener);
        IB_Stone1306.setOnClickListener(put_listener);
        IB_Stone1307.setOnClickListener(put_listener);
        IB_Stone1308.setOnClickListener(put_listener);
        IB_Stone1309.setOnClickListener(put_listener);
        IB_Stone1310.setOnClickListener(put_listener);
        IB_Stone1311.setOnClickListener(put_listener);
        IB_Stone1312.setOnClickListener(put_listener);
        IB_Stone1313.setOnClickListener(put_listener);
    }

    void print_cur_board (View v) {
        ImageButton IB_Stone0101 = (ImageButton) findViewById(R.id.stone0101);
        ImageButton IB_Stone0102 = (ImageButton) findViewById(R.id.stone0102);
        ImageButton IB_Stone0103 = (ImageButton) findViewById(R.id.stone0103);
        ImageButton IB_Stone0104 = (ImageButton) findViewById(R.id.stone0104);
        ImageButton IB_Stone0105 = (ImageButton) findViewById(R.id.stone0105);
        ImageButton IB_Stone0106 = (ImageButton) findViewById(R.id.stone0106);
        ImageButton IB_Stone0107 = (ImageButton) findViewById(R.id.stone0107);
        ImageButton IB_Stone0108 = (ImageButton) findViewById(R.id.stone0108);
        ImageButton IB_Stone0109 = (ImageButton) findViewById(R.id.stone0109);
        ImageButton IB_Stone0110 = (ImageButton) findViewById(R.id.stone0110);
        ImageButton IB_Stone0111 = (ImageButton) findViewById(R.id.stone0111);
        ImageButton IB_Stone0112 = (ImageButton) findViewById(R.id.stone0112);
        ImageButton IB_Stone0113 = (ImageButton) findViewById(R.id.stone0113);

        ImageButton IB_Stone0201 = (ImageButton) findViewById(R.id.stone0201);
        ImageButton IB_Stone0202 = (ImageButton) findViewById(R.id.stone0202);
        ImageButton IB_Stone0203 = (ImageButton) findViewById(R.id.stone0203);
        ImageButton IB_Stone0204 = (ImageButton) findViewById(R.id.stone0204);
        ImageButton IB_Stone0205 = (ImageButton) findViewById(R.id.stone0205);
        ImageButton IB_Stone0206 = (ImageButton) findViewById(R.id.stone0206);
        ImageButton IB_Stone0207 = (ImageButton) findViewById(R.id.stone0207);
        ImageButton IB_Stone0208 = (ImageButton) findViewById(R.id.stone0208);
        ImageButton IB_Stone0209 = (ImageButton) findViewById(R.id.stone0209);
        ImageButton IB_Stone0210 = (ImageButton) findViewById(R.id.stone0210);
        ImageButton IB_Stone0211 = (ImageButton) findViewById(R.id.stone0211);
        ImageButton IB_Stone0212 = (ImageButton) findViewById(R.id.stone0212);
        ImageButton IB_Stone0213 = (ImageButton) findViewById(R.id.stone0213);

        ImageButton IB_Stone0301 = (ImageButton) findViewById(R.id.stone0301);
        ImageButton IB_Stone0302 = (ImageButton) findViewById(R.id.stone0302);
        ImageButton IB_Stone0303 = (ImageButton) findViewById(R.id.stone0303);
        ImageButton IB_Stone0304 = (ImageButton) findViewById(R.id.stone0304);
        ImageButton IB_Stone0305 = (ImageButton) findViewById(R.id.stone0305);
        ImageButton IB_Stone0306 = (ImageButton) findViewById(R.id.stone0306);
        ImageButton IB_Stone0307 = (ImageButton) findViewById(R.id.stone0307);
        ImageButton IB_Stone0308 = (ImageButton) findViewById(R.id.stone0308);
        ImageButton IB_Stone0309 = (ImageButton) findViewById(R.id.stone0309);
        ImageButton IB_Stone0310 = (ImageButton) findViewById(R.id.stone0310);
        ImageButton IB_Stone0311 = (ImageButton) findViewById(R.id.stone0311);
        ImageButton IB_Stone0312 = (ImageButton) findViewById(R.id.stone0312);
        ImageButton IB_Stone0313 = (ImageButton) findViewById(R.id.stone0313);

        ImageButton IB_Stone0401 = (ImageButton) findViewById(R.id.stone0401);
        ImageButton IB_Stone0402 = (ImageButton) findViewById(R.id.stone0402);
        ImageButton IB_Stone0403 = (ImageButton) findViewById(R.id.stone0403);
        ImageButton IB_Stone0404 = (ImageButton) findViewById(R.id.stone0404);
        ImageButton IB_Stone0405 = (ImageButton) findViewById(R.id.stone0405);
        ImageButton IB_Stone0406 = (ImageButton) findViewById(R.id.stone0406);
        ImageButton IB_Stone0407 = (ImageButton) findViewById(R.id.stone0407);
        ImageButton IB_Stone0408 = (ImageButton) findViewById(R.id.stone0408);
        ImageButton IB_Stone0409 = (ImageButton) findViewById(R.id.stone0409);
        ImageButton IB_Stone0410 = (ImageButton) findViewById(R.id.stone0410);
        ImageButton IB_Stone0411 = (ImageButton) findViewById(R.id.stone0411);
        ImageButton IB_Stone0412 = (ImageButton) findViewById(R.id.stone0412);
        ImageButton IB_Stone0413 = (ImageButton) findViewById(R.id.stone0413);

        ImageButton IB_Stone0501 = (ImageButton) findViewById(R.id.stone0501);
        ImageButton IB_Stone0502 = (ImageButton) findViewById(R.id.stone0502);
        ImageButton IB_Stone0503 = (ImageButton) findViewById(R.id.stone0503);
        ImageButton IB_Stone0504 = (ImageButton) findViewById(R.id.stone0504);
        ImageButton IB_Stone0505 = (ImageButton) findViewById(R.id.stone0505);
        ImageButton IB_Stone0506 = (ImageButton) findViewById(R.id.stone0506);
        ImageButton IB_Stone0507 = (ImageButton) findViewById(R.id.stone0507);
        ImageButton IB_Stone0508 = (ImageButton) findViewById(R.id.stone0508);
        ImageButton IB_Stone0509 = (ImageButton) findViewById(R.id.stone0509);
        ImageButton IB_Stone0510 = (ImageButton) findViewById(R.id.stone0510);
        ImageButton IB_Stone0511 = (ImageButton) findViewById(R.id.stone0511);
        ImageButton IB_Stone0512 = (ImageButton) findViewById(R.id.stone0512);
        ImageButton IB_Stone0513 = (ImageButton) findViewById(R.id.stone0513);

        ImageButton IB_Stone0601 = (ImageButton) findViewById(R.id.stone0601);
        ImageButton IB_Stone0602 = (ImageButton) findViewById(R.id.stone0602);
        ImageButton IB_Stone0603 = (ImageButton) findViewById(R.id.stone0603);
        ImageButton IB_Stone0604 = (ImageButton) findViewById(R.id.stone0604);
        ImageButton IB_Stone0605 = (ImageButton) findViewById(R.id.stone0605);
        ImageButton IB_Stone0606 = (ImageButton) findViewById(R.id.stone0606);
        ImageButton IB_Stone0607 = (ImageButton) findViewById(R.id.stone0607);
        ImageButton IB_Stone0608 = (ImageButton) findViewById(R.id.stone0608);
        ImageButton IB_Stone0609 = (ImageButton) findViewById(R.id.stone0609);
        ImageButton IB_Stone0610 = (ImageButton) findViewById(R.id.stone0610);
        ImageButton IB_Stone0611 = (ImageButton) findViewById(R.id.stone0611);
        ImageButton IB_Stone0612 = (ImageButton) findViewById(R.id.stone0612);
        ImageButton IB_Stone0613 = (ImageButton) findViewById(R.id.stone0613);

        ImageButton IB_Stone0701 = (ImageButton) findViewById(R.id.stone0701);
        ImageButton IB_Stone0702 = (ImageButton) findViewById(R.id.stone0702);
        ImageButton IB_Stone0703 = (ImageButton) findViewById(R.id.stone0703);
        ImageButton IB_Stone0704 = (ImageButton) findViewById(R.id.stone0704);
        ImageButton IB_Stone0705 = (ImageButton) findViewById(R.id.stone0705);
        ImageButton IB_Stone0706 = (ImageButton) findViewById(R.id.stone0706);
        ImageButton IB_Stone0707 = (ImageButton) findViewById(R.id.stone0707);
        ImageButton IB_Stone0708 = (ImageButton) findViewById(R.id.stone0708);
        ImageButton IB_Stone0709 = (ImageButton) findViewById(R.id.stone0709);
        ImageButton IB_Stone0710 = (ImageButton) findViewById(R.id.stone0710);
        ImageButton IB_Stone0711 = (ImageButton) findViewById(R.id.stone0711);
        ImageButton IB_Stone0712 = (ImageButton) findViewById(R.id.stone0712);
        ImageButton IB_Stone0713 = (ImageButton) findViewById(R.id.stone0713);

        ImageButton IB_Stone0801 = (ImageButton) findViewById(R.id.stone0801);
        ImageButton IB_Stone0802 = (ImageButton) findViewById(R.id.stone0802);
        ImageButton IB_Stone0803 = (ImageButton) findViewById(R.id.stone0803);
        ImageButton IB_Stone0804 = (ImageButton) findViewById(R.id.stone0804);
        ImageButton IB_Stone0805 = (ImageButton) findViewById(R.id.stone0805);
        ImageButton IB_Stone0806 = (ImageButton) findViewById(R.id.stone0806);
        ImageButton IB_Stone0807 = (ImageButton) findViewById(R.id.stone0807);
        ImageButton IB_Stone0808 = (ImageButton) findViewById(R.id.stone0808);
        ImageButton IB_Stone0809 = (ImageButton) findViewById(R.id.stone0809);
        ImageButton IB_Stone0810 = (ImageButton) findViewById(R.id.stone0810);
        ImageButton IB_Stone0811 = (ImageButton) findViewById(R.id.stone0811);
        ImageButton IB_Stone0812 = (ImageButton) findViewById(R.id.stone0812);
        ImageButton IB_Stone0813 = (ImageButton) findViewById(R.id.stone0813);

        ImageButton IB_Stone0901 = (ImageButton) findViewById(R.id.stone0901);
        ImageButton IB_Stone0902 = (ImageButton) findViewById(R.id.stone0902);
        ImageButton IB_Stone0903 = (ImageButton) findViewById(R.id.stone0903);
        ImageButton IB_Stone0904 = (ImageButton) findViewById(R.id.stone0904);
        ImageButton IB_Stone0905 = (ImageButton) findViewById(R.id.stone0905);
        ImageButton IB_Stone0906 = (ImageButton) findViewById(R.id.stone0906);
        ImageButton IB_Stone0907 = (ImageButton) findViewById(R.id.stone0907);
        ImageButton IB_Stone0908 = (ImageButton) findViewById(R.id.stone0908);
        ImageButton IB_Stone0909 = (ImageButton) findViewById(R.id.stone0909);
        ImageButton IB_Stone0910 = (ImageButton) findViewById(R.id.stone0910);
        ImageButton IB_Stone0911 = (ImageButton) findViewById(R.id.stone0911);
        ImageButton IB_Stone0912 = (ImageButton) findViewById(R.id.stone0912);
        ImageButton IB_Stone0913 = (ImageButton) findViewById(R.id.stone0913);

        ImageButton IB_Stone1001 = (ImageButton) findViewById(R.id.stone1001);
        ImageButton IB_Stone1002 = (ImageButton) findViewById(R.id.stone1002);
        ImageButton IB_Stone1003 = (ImageButton) findViewById(R.id.stone1003);
        ImageButton IB_Stone1004 = (ImageButton) findViewById(R.id.stone1004);
        ImageButton IB_Stone1005 = (ImageButton) findViewById(R.id.stone1005);
        ImageButton IB_Stone1006 = (ImageButton) findViewById(R.id.stone1006);
        ImageButton IB_Stone1007 = (ImageButton) findViewById(R.id.stone1007);
        ImageButton IB_Stone1008 = (ImageButton) findViewById(R.id.stone1008);
        ImageButton IB_Stone1009 = (ImageButton) findViewById(R.id.stone1009);
        ImageButton IB_Stone1010 = (ImageButton) findViewById(R.id.stone1010);
        ImageButton IB_Stone1011 = (ImageButton) findViewById(R.id.stone1011);
        ImageButton IB_Stone1012 = (ImageButton) findViewById(R.id.stone1012);
        ImageButton IB_Stone1013 = (ImageButton) findViewById(R.id.stone1013);

        ImageButton IB_Stone1101 = (ImageButton) findViewById(R.id.stone1101);
        ImageButton IB_Stone1102 = (ImageButton) findViewById(R.id.stone1102);
        ImageButton IB_Stone1103 = (ImageButton) findViewById(R.id.stone1103);
        ImageButton IB_Stone1104 = (ImageButton) findViewById(R.id.stone1104);
        ImageButton IB_Stone1105 = (ImageButton) findViewById(R.id.stone1105);
        ImageButton IB_Stone1106 = (ImageButton) findViewById(R.id.stone1106);
        ImageButton IB_Stone1107 = (ImageButton) findViewById(R.id.stone1107);
        ImageButton IB_Stone1108 = (ImageButton) findViewById(R.id.stone1108);
        ImageButton IB_Stone1109 = (ImageButton) findViewById(R.id.stone1109);
        ImageButton IB_Stone1110 = (ImageButton) findViewById(R.id.stone1110);
        ImageButton IB_Stone1111 = (ImageButton) findViewById(R.id.stone1111);
        ImageButton IB_Stone1112 = (ImageButton) findViewById(R.id.stone1112);
        ImageButton IB_Stone1113 = (ImageButton) findViewById(R.id.stone1113);

        ImageButton IB_Stone1201 = (ImageButton) findViewById(R.id.stone1201);
        ImageButton IB_Stone1202 = (ImageButton) findViewById(R.id.stone1202);
        ImageButton IB_Stone1203 = (ImageButton) findViewById(R.id.stone1203);
        ImageButton IB_Stone1204 = (ImageButton) findViewById(R.id.stone1204);
        ImageButton IB_Stone1205 = (ImageButton) findViewById(R.id.stone1205);
        ImageButton IB_Stone1206 = (ImageButton) findViewById(R.id.stone1206);
        ImageButton IB_Stone1207 = (ImageButton) findViewById(R.id.stone1207);
        ImageButton IB_Stone1208 = (ImageButton) findViewById(R.id.stone1208);
        ImageButton IB_Stone1209 = (ImageButton) findViewById(R.id.stone1209);
        ImageButton IB_Stone1210 = (ImageButton) findViewById(R.id.stone1210);
        ImageButton IB_Stone1211 = (ImageButton) findViewById(R.id.stone1211);
        ImageButton IB_Stone1212 = (ImageButton) findViewById(R.id.stone1212);
        ImageButton IB_Stone1213 = (ImageButton) findViewById(R.id.stone1213);

        ImageButton IB_Stone1301 = (ImageButton) findViewById(R.id.stone1301);
        ImageButton IB_Stone1302 = (ImageButton) findViewById(R.id.stone1302);
        ImageButton IB_Stone1303 = (ImageButton) findViewById(R.id.stone1303);
        ImageButton IB_Stone1304 = (ImageButton) findViewById(R.id.stone1304);
        ImageButton IB_Stone1305 = (ImageButton) findViewById(R.id.stone1305);
        ImageButton IB_Stone1306 = (ImageButton) findViewById(R.id.stone1306);
        ImageButton IB_Stone1307 = (ImageButton) findViewById(R.id.stone1307);
        ImageButton IB_Stone1308 = (ImageButton) findViewById(R.id.stone1308);
        ImageButton IB_Stone1309 = (ImageButton) findViewById(R.id.stone1309);
        ImageButton IB_Stone1310 = (ImageButton) findViewById(R.id.stone1310);
        ImageButton IB_Stone1311 = (ImageButton) findViewById(R.id.stone1311);
        ImageButton IB_Stone1312 = (ImageButton) findViewById(R.id.stone1312);
        ImageButton IB_Stone1313 = (ImageButton) findViewById(R.id.stone1313);

        for (int a = 0 ; a < 209; a++) {
            switch (a){
                case 16:
                    if (board[a] == 0) IB_Stone0101.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0101.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0101.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 17:
                    if (board[a] == 0) IB_Stone0102.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0102.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0102.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 18:
                    if (board[a] == 0) IB_Stone0103.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0103.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0103.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 19:
                    if (board[a] == 0) IB_Stone0104.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0104.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0104.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 20:
                    if (board[a] == 0) IB_Stone0105.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0105.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0105.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 21:
                    if (board[a] == 0) IB_Stone0106.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0106.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0106.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 22:
                    if (board[a] == 0) IB_Stone0107.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0107.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0107.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 23:
                    if (board[a] == 0) IB_Stone0108.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0108.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0108.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 24:
                    if (board[a] == 0) IB_Stone0109.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0109.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0109.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 25:
                    if (board[a] == 0) IB_Stone0110.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0110.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0110.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 26:
                    if (board[a] == 0) IB_Stone0111.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0111.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0111.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 27:
                    if (board[a] == 0) IB_Stone0112.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0112.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0112.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 28:
                    if (board[a] == 0) IB_Stone0113.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0113.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0113.setBackgroundResource(R.drawable.white_stone);
                    break;


                case 31:
                    if (board[a] == 0) IB_Stone0201.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0201.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0201.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 32:
                    if (board[a] == 0) IB_Stone0202.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0202.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0202.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 33:
                    if (board[a] == 0) IB_Stone0203.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0203.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0203.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 34:
                    if (board[a] == 0) IB_Stone0204.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0204.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0204.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 35:
                    if (board[a] == 0) IB_Stone0205.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0205.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0205.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 36:
                    if (board[a] == 0) IB_Stone0206.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0206.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0206.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 37:
                    if (board[a] == 0) IB_Stone0207.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0207.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0207.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 38:
                    if (board[a] == 0) IB_Stone0208.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0208.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0208.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 39:
                    if (board[a] == 0) IB_Stone0209.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0209.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0209.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 40:
                    if (board[a] == 0) IB_Stone0210.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0210.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0210.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 41:
                    if (board[a] == 0) IB_Stone0211.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0211.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0211.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 42:
                    if (board[a] == 0) IB_Stone0212.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0212.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0212.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 43:
                    if (board[a] == 0) IB_Stone0213.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0213.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0213.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 46:
                    if (board[a] == 0) IB_Stone0301.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0301.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0301.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 47:
                    if (board[a] == 0) IB_Stone0302.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0302.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0302.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 48:
                    if (board[a] == 0) IB_Stone0303.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0303.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0303.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 49:
                    if (board[a] == 0) IB_Stone0304.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0304.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0304.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 50:
                    if (board[a] == 0) IB_Stone0305.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0305.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0305.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 51:
                    if (board[a] == 0) IB_Stone0306.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0306.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0306.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 52:
                    if (board[a] == 0) IB_Stone0307.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0307.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0307.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 53:
                    if (board[a] == 0) IB_Stone0308.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0308.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0308.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 54:
                    if (board[a] == 0) IB_Stone0309.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0309.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0309.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 55:
                    if (board[a] == 0) IB_Stone0310.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0310.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0310.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 56:
                    if (board[a] == 0) IB_Stone0311.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0311.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0311.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 57:
                    if (board[a] == 0) IB_Stone0312.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0312.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0312.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 58:
                    if (board[a] == 0) IB_Stone0313.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0313.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0313.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 61:
                    if (board[a] == 0) IB_Stone0401.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0401.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0401.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 62:
                    if (board[a] == 0) IB_Stone0402.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0402.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0402.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 63:
                    if (board[a] == 0) IB_Stone0403.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0403.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0403.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 64:
                    if (board[a] == 0) IB_Stone0404.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0404.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0404.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 65:
                    if (board[a] == 0) IB_Stone0405.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0405.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0405.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 66:
                    if (board[a] == 0) IB_Stone0406.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0406.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0406.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 67:
                    if (board[a] == 0) IB_Stone0407.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0407.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0407.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 68:
                    if (board[a] == 0) IB_Stone0408.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0408.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0408.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 69:
                    if (board[a] == 0) IB_Stone0409.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0409.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0409.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 70:
                    if (board[a] == 0) IB_Stone0410.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0410.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0410.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 71:
                    if (board[a] == 0) IB_Stone0411.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0411.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0411.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 72:
                    if (board[a] == 0) IB_Stone0412.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0412.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0412.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 73:
                    if (board[a] == 0) IB_Stone0413.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0413.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0413.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 76:
                    if (board[a] == 0) IB_Stone0501.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0501.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0501.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 77:
                    if (board[a] == 0) IB_Stone0502.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0502.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0502.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 78:
                    if (board[a] == 0) IB_Stone0503.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0503.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0503.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 79:
                    if (board[a] == 0) IB_Stone0504.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0504.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0504.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 80:
                    if (board[a] == 0) IB_Stone0505.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0505.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0505.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 81:
                    if (board[a] == 0) IB_Stone0506.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0506.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0506.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 82:
                    if (board[a] == 0) IB_Stone0507.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0507.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0507.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 83:
                    if (board[a] == 0) IB_Stone0508.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0508.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0508.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 84:
                    if (board[a] == 0) IB_Stone0509.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0509.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0509.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 85:
                    if (board[a] == 0) IB_Stone0510.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0510.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0510.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 86:
                    if (board[a] == 0) IB_Stone0511.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0511.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0511.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 87:
                    if (board[a] == 0) IB_Stone0512.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0512.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0512.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 88:
                    if (board[a] == 0) IB_Stone0513.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0513.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0513.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 91:
                    if (board[a] == 0) IB_Stone0601.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0601.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0601.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 92:
                    if (board[a] == 0) IB_Stone0602.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0602.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0602.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 93:
                    if (board[a] == 0) IB_Stone0603.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0603.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0603.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 94:
                    if (board[a] == 0) IB_Stone0604.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0604.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0604.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 95:
                    if (board[a] == 0) IB_Stone0605.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0605.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0605.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 96:
                    if (board[a] == 0) IB_Stone0606.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0606.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0606.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 97:
                    if (board[a] == 0) IB_Stone0607.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0607.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0607.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 98:
                    if (board[a] == 0) IB_Stone0608.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0608.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0608.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 99:
                    if (board[a] == 0) IB_Stone0609.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0609.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0609.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 100:
                    if (board[a] == 0) IB_Stone0610.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0610.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0610.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 101:
                    if (board[a] == 0) IB_Stone0611.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0611.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0611.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 102:
                    if (board[a] == 0) IB_Stone0612.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0612.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0612.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 103:
                    if (board[a] == 0) IB_Stone0613.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0613.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0613.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 106:
                    if (board[a] == 0) IB_Stone0701.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0701.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0701.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 107:
                    if (board[a] == 0) IB_Stone0702.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0702.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0702.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 108:
                    if (board[a] == 0) IB_Stone0703.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0703.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0703.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 109:
                    if (board[a] == 0) IB_Stone0704.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0704.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0704.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 110:
                    if (board[a] == 0) IB_Stone0705.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0705.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0705.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 111:
                    if (board[a] == 0) IB_Stone0706.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0706.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0706.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 112:
                    if (board[a] == 0) IB_Stone0707.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0707.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0707.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 113:
                    if (board[a] == 0) IB_Stone0708.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0708.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0708.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 114:
                    if (board[a] == 0) IB_Stone0709.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0709.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0709.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 115:
                    if (board[a] == 0) IB_Stone0710.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0710.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0710.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 116:
                    if (board[a] == 0) IB_Stone0711.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0711.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0711.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 117:
                    if (board[a] == 0) IB_Stone0712.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0712.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0712.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 118:
                    if (board[a] == 0) IB_Stone0713.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0713.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0713.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 121:
                    if (board[a] == 0) IB_Stone0801.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0801.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0801.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 122:
                    if (board[a] == 0) IB_Stone0802.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0802.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0802.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 123:
                    if (board[a] == 0) IB_Stone0803.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0803.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0803.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 124:
                    if (board[a] == 0) IB_Stone0804.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0804.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0804.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 125:
                    if (board[a] == 0) IB_Stone0805.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0805.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0805.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 126:
                    if (board[a] == 0) IB_Stone0806.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0806.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0806.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 127:
                    if (board[a] == 0) IB_Stone0807.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0807.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0807.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 128:
                    if (board[a] == 0) IB_Stone0808.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0808.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0808.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 129:
                    if (board[a] == 0) IB_Stone0809.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0809.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0809.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 130:
                    if (board[a] == 0) IB_Stone0810.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0810.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0810.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 131:
                    if (board[a] == 0) IB_Stone0811.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0811.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0811.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 132:
                    if (board[a] == 0) IB_Stone0812.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0812.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0812.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 133:
                    if (board[a] == 0) IB_Stone0813.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0813.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0813.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 136:
                    if (board[a] == 0) IB_Stone0901.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0901.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0901.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 137:
                    if (board[a] == 0) IB_Stone0902.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0902.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0902.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 138:
                    if (board[a] == 0) IB_Stone0903.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0903.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0903.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 139:
                    if (board[a] == 0) IB_Stone0904.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0904.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0904.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 140:
                    if (board[a] == 0) IB_Stone0905.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0905.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0905.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 141:
                    if (board[a] == 0) IB_Stone0906.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0906.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0906.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 142:
                    if (board[a] == 0) IB_Stone0907.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0907.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0907.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 143:
                    if (board[a] == 0) IB_Stone0908.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0908.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0908.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 144:
                    if (board[a] == 0) IB_Stone0909.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0909.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0909.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 145:
                    if (board[a] == 0) IB_Stone0910.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0910.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0910.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 146:
                    if (board[a] == 0) IB_Stone0911.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0911.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0911.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 147:
                    if (board[a] == 0) IB_Stone0912.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0912.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0912.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 148:
                    if (board[a] == 0) IB_Stone0913.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone0913.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone0913.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 151:
                    if (board[a] == 0) IB_Stone1001.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1001.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1001.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 152:
                    if (board[a] == 0) IB_Stone1002.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1002.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1002.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 153:
                    if (board[a] == 0) IB_Stone1003.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1003.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1003.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 154:
                    if (board[a] == 0) IB_Stone1004.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1004.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1004.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 155:
                    if (board[a] == 0) IB_Stone1005.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1005.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1005.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 156:
                    if (board[a] == 0) IB_Stone1006.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1006.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1006.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 157:
                    if (board[a] == 0) IB_Stone1007.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1007.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1007.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 158:
                    if (board[a] == 0) IB_Stone1008.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1008.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1008.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 159:
                    if (board[a] == 0) IB_Stone1009.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1009.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1009.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 160:
                    if (board[a] == 0) IB_Stone1010.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1010.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1010.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 161:
                    if (board[a] == 0) IB_Stone1011.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1011.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1011.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 162:
                    if (board[a] == 0) IB_Stone1012.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1012.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1012.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 163:
                    if (board[a] == 0) IB_Stone1013.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1013.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1013.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 166:
                    if (board[a] == 0) IB_Stone1101.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1101.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1101.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 167:
                    if (board[a] == 0) IB_Stone1102.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1102.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1102.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 168:
                    if (board[a] == 0) IB_Stone1103.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1103.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1103.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 169:
                    if (board[a] == 0) IB_Stone1104.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1104.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1104.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 170:
                    if (board[a] == 0) IB_Stone1105.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1105.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1105.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 171:
                    if (board[a] == 0) IB_Stone1106.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1106.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1106.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 172:
                    if (board[a] == 0) IB_Stone1107.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1107.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1107.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 173:
                    if (board[a] == 0) IB_Stone1108.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1108.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1108.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 174:
                    if (board[a] == 0) IB_Stone1109.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1109.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1109.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 175:
                    if (board[a] == 0) IB_Stone1110.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1110.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1110.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 176:
                    if (board[a] == 0) IB_Stone1111.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1111.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1111.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 177:
                    if (board[a] == 0) IB_Stone1112.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1112.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1112.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 178:
                    if (board[a] == 0) IB_Stone1113.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1113.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1113.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 181:
                    if (board[a] == 0) IB_Stone1201.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1201.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1201.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 182:
                    if (board[a] == 0) IB_Stone1202.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1202.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1202.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 183:
                    if (board[a] == 0) IB_Stone1203.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1203.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1203.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 184:
                    if (board[a] == 0) IB_Stone1204.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1204.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1204.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 185:
                    if (board[a] == 0) IB_Stone1205.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1205.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1205.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 186:
                    if (board[a] == 0) IB_Stone1206.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1206.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1206.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 187:
                    if (board[a] == 0) IB_Stone1207.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1207.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1207.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 188:
                    if (board[a] == 0) IB_Stone1208.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1208.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1208.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 189:
                    if (board[a] == 0) IB_Stone1209.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1209.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1209.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 190:
                    if (board[a] == 0) IB_Stone1210.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1210.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1210.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 191:
                    if (board[a] == 0) IB_Stone1211.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1211.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1211.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 192:
                    if (board[a] == 0) IB_Stone1212.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1212.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1212.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 193:
                    if (board[a] == 0) IB_Stone1213.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1213.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1213.setBackgroundResource(R.drawable.white_stone);
                    break;

                case 196:
                    if (board[a] == 0) IB_Stone1301.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1301.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1301.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 197:
                    if (board[a] == 0) IB_Stone1302.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1302.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1302.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 198:
                    if (board[a] == 0) IB_Stone1303.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1303.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1303.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 199:
                    if (board[a] == 0) IB_Stone1304.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1304.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1304.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 200:
                    if (board[a] == 0) IB_Stone1305.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1305.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1305.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 201:
                    if (board[a] == 0) IB_Stone1306.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1306.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1306.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 202:
                    if (board[a] == 0) IB_Stone1307.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1307.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1307.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 203:
                    if (board[a] == 0) IB_Stone1308.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1308.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1308.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 204:
                    if (board[a] == 0) IB_Stone1309.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1309.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1309.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 205:
                    if (board[a] == 0) IB_Stone1310.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1310.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1310.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 206:
                    if (board[a] == 0) IB_Stone1311.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1311.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1311.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 207:
                    if (board[a] == 0) IB_Stone1312.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1312.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1312.setBackgroundResource(R.drawable.white_stone);
                    break;
                case 208:
                    if (board[a] == 0) IB_Stone1313.setBackgroundResource(R.drawable.blank);
                    else if (board[a] == 1) IB_Stone1313.setBackgroundResource(R.drawable.black_stone);
                    else if (board[a] == 2) IB_Stone1313.setBackgroundResource(R.drawable.white_stone);
                    break;
            }
        }
    }

    public class MyListener implements View.OnClickListener {
        public void onClick(View v) {
            print_cur_board(v);
            cur_position = v.getId();
            if (color == 1) {
                ImageButton button1 = (ImageButton) v;
                switch (cur_position) {
                    case R.id.stone0101:
                        cur_z = get_z(1,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0102:
                        cur_z = get_z(1,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0103:
                        cur_z = get_z(1,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0104:
                        cur_z = get_z(1,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0105:
                        cur_z = get_z(1,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0106:
                        cur_z = get_z(1,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0107:
                        cur_z = get_z(1,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0108:
                        cur_z = get_z(1,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0109:
                        cur_z = get_z(1,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0110:
                        cur_z = get_z(1,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0111:
                        cur_z = get_z(1,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0112:
                        cur_z = get_z(1,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0113:
                        cur_z = get_z(1,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone0201:
                        cur_z = get_z(2,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0202:
                        cur_z = get_z(2,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0203:
                        cur_z = get_z(2,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0204:
                        cur_z = get_z(2,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0205:
                        cur_z = get_z(2,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0206:
                        cur_z = get_z(2,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0207:
                        cur_z = get_z(2,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0208:
                        cur_z = get_z(2,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0209:
                        cur_z = get_z(2,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0210:
                        cur_z = get_z(2,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0211:
                        cur_z = get_z(2,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0212:
                        cur_z = get_z(2,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0213:
                        cur_z = get_z(2,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone0301:
                        cur_z = get_z(3,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0302:
                        cur_z = get_z(3,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0303:
                        cur_z = get_z(3,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0304:
                        cur_z = get_z(3,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0305:
                        cur_z = get_z(3,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0306:
                        cur_z = get_z(3,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0307:
                        cur_z = get_z(3,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0308:
                        cur_z = get_z(3,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0309:
                        cur_z = get_z(3,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0310:
                        cur_z = get_z(3,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0311:
                        cur_z = get_z(3,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0312:
                        cur_z = get_z(3,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0313:
                        cur_z = get_z(3,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone0401:
                        cur_z = get_z(4,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0402:
                        cur_z = get_z(4,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0403:
                        cur_z = get_z(4,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0404:
                        cur_z = get_z(4,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0405:
                        cur_z = get_z(4,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0406:
                        cur_z = get_z(4,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0407:
                        cur_z = get_z(4,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0408:
                        cur_z = get_z(4,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0409:
                        cur_z = get_z(4,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0410:
                        cur_z = get_z(4,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0411:
                        cur_z = get_z(4,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0412:
                        cur_z = get_z(4,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0413:
                        cur_z = get_z(4,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone0501:
                        cur_z = get_z(5,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0502:
                        cur_z = get_z(5,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0503:
                        cur_z = get_z(5,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0504:
                        cur_z = get_z(5,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0505:
                        cur_z = get_z(5,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0506:
                        cur_z = get_z(5,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0507:
                        cur_z = get_z(5,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0508:
                        cur_z = get_z(5,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0509:
                        cur_z = get_z(5,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0510:
                        cur_z = get_z(5,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0511:
                        cur_z = get_z(5,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0512:
                        cur_z = get_z(5,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0513:
                        cur_z = get_z(5,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone0601:
                        cur_z = get_z(6,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0602:
                        cur_z = get_z(6,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0603:
                        cur_z = get_z(6,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0604:
                        cur_z = get_z(6,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0605:
                        cur_z = get_z(6,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0606:
                        cur_z = get_z(6,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0607:
                        cur_z = get_z(6,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0608:
                        cur_z = get_z(6,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0609:
                        cur_z = get_z(6,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0610:
                        cur_z = get_z(6,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0611:
                        cur_z = get_z(6,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0612:
                        cur_z = get_z(6,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0613:
                        cur_z = get_z(6,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone0701:
                        cur_z = get_z(7,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0702:
                        cur_z = get_z(7,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0703:
                        cur_z = get_z(7,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0704:
                        cur_z = get_z(7,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0705:
                        cur_z = get_z(7,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0706:
                        cur_z = get_z(7,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0707:
                        cur_z = get_z(7,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0708:
                        cur_z = get_z(7,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0709:
                        cur_z = get_z(7,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0710:
                        cur_z = get_z(7,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0711:
                        cur_z = get_z(7,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0712:
                        cur_z = get_z(7,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0713:
                        cur_z = get_z(7,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone0801:
                        cur_z = get_z(8,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0802:
                        cur_z = get_z(8,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0803:
                        cur_z = get_z(8,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0804:
                        cur_z = get_z(8,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0805:
                        cur_z = get_z(8,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0806:
                        cur_z = get_z(8,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0807:
                        cur_z = get_z(8,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0808:
                        cur_z = get_z(8,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0809:
                        cur_z = get_z(8,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0810:
                        cur_z = get_z(8,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0811:
                        cur_z = get_z(8,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0812:
                        cur_z = get_z(8,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0813:
                        cur_z = get_z(8,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone0901:
                        cur_z = get_z(9,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0902:
                        cur_z = get_z(9,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0903:
                        cur_z = get_z(9,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0904:
                        cur_z = get_z(9,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0905:
                        cur_z = get_z(9,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0906:
                        cur_z = get_z(9,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0907:
                        cur_z = get_z(9,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0908:
                        cur_z = get_z(9,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0909:
                        cur_z = get_z(9,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0910:
                        cur_z = get_z(9,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0911:
                        cur_z = get_z(9,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0912:
                        cur_z = get_z(9,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone0913:
                        cur_z = get_z(9,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone1001:
                        cur_z = get_z(10,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1002:
                        cur_z = get_z(10,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1003:
                        cur_z = get_z(10,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1004:
                        cur_z = get_z(10,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1005:
                        cur_z = get_z(10,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1006:
                        cur_z = get_z(10,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1007:
                        cur_z = get_z(10,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1008:
                        cur_z = get_z(10,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1009:
                        cur_z = get_z(10,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1010:
                        cur_z = get_z(10,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1011:
                        cur_z = get_z(10,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1012:
                        cur_z = get_z(10,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1013:
                        cur_z = get_z(10,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone1101:
                        cur_z = get_z(11,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1102:
                        cur_z = get_z(11,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1103:
                        cur_z = get_z(11,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1104:
                        cur_z = get_z(11,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1105:
                        cur_z = get_z(11,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1106:
                        cur_z = get_z(11,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1107:
                        cur_z = get_z(11,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1108:
                        cur_z = get_z(11,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1109:
                        cur_z = get_z(11,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1110:
                        cur_z = get_z(11,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1111:
                        cur_z = get_z(11,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1112:
                        cur_z = get_z(11,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1113:
                        cur_z = get_z(11,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone1201:
                        cur_z = get_z(12,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1202:
                        cur_z = get_z(12,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1203:
                        cur_z = get_z(12,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1204:
                        cur_z = get_z(12,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1205:
                        cur_z = get_z(12,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1206:
                        cur_z = get_z(12,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1207:
                        cur_z = get_z(12,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1208:
                        cur_z = get_z(12,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1209:
                        cur_z = get_z(12,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1210:
                        cur_z = get_z(12,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1211:
                        cur_z = get_z(12,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1212:
                        cur_z = get_z(12,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1213:
                        cur_z = get_z(12,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;

                    case R.id.stone1301:
                        cur_z = get_z(13,1);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1302:
                        cur_z = get_z(13,2);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1303:
                        cur_z = get_z(13,3);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1304:
                        cur_z = get_z(13,4);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1305:
                        cur_z = get_z(13,5);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1306:
                        cur_z = get_z(13,6);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1307:
                        cur_z = get_z(13,7);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1308:
                        cur_z = get_z(13,8);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1309:
                        cur_z = get_z(13,9);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1310:
                        cur_z = get_z(13,10);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1311:
                        cur_z = get_z(13,11);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1312:
                        cur_z = get_z(13,12);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                    case R.id.stone1313:
                        cur_z = get_z(13,13);
                        if (board[cur_z] == 0) {
                            button1.setBackgroundResource(R.drawable.black_stone);
                        }
                        break;
                }
            }

            if (color == 2) {
                ImageButton button2 = (ImageButton) v;
                switch (cur_position) {
                    case R.id.stone0101:
                        cur_z = get_z(1,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0102:
                        cur_z = get_z(1,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0103:
                        cur_z = get_z(1,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0104:
                        cur_z = get_z(1,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0105:
                        cur_z = get_z(1,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0106:
                        cur_z = get_z(1,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0107:
                        cur_z = get_z(1,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0108:
                        cur_z = get_z(1,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0109:
                        cur_z = get_z(1,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0110:
                        cur_z = get_z(1,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0111:
                        cur_z = get_z(1,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0112:
                        cur_z = get_z(1,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0113:
                        cur_z = get_z(1,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone0201:
                        cur_z = get_z(2,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0202:
                        cur_z = get_z(2,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0203:
                        cur_z = get_z(2,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0204:
                        cur_z = get_z(2,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0205:
                        cur_z = get_z(2,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0206:
                        cur_z = get_z(2,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0207:
                        cur_z = get_z(2,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0208:
                        cur_z = get_z(2,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0209:
                        cur_z = get_z(2,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0210:
                        cur_z = get_z(2,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0211:
                        cur_z = get_z(2,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0212:
                        cur_z = get_z(2,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0213:
                        cur_z = get_z(2,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone0301:
                        cur_z = get_z(3,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0302:
                        cur_z = get_z(3,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0303:
                        cur_z = get_z(3,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0304:
                        cur_z = get_z(3,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0305:
                        cur_z = get_z(3,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0306:
                        cur_z = get_z(3,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0307:
                        cur_z = get_z(3,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0308:
                        cur_z = get_z(3,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0309:
                        cur_z = get_z(3,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0310:
                        cur_z = get_z(3,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0311:
                        cur_z = get_z(3,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0312:
                        cur_z = get_z(3,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0313:
                        cur_z = get_z(3,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone0401:
                        cur_z = get_z(4,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0402:
                        cur_z = get_z(4,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0403:
                        cur_z = get_z(4,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0404:
                        cur_z = get_z(4,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0405:
                        cur_z = get_z(4,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0406:
                        cur_z = get_z(4,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0407:
                        cur_z = get_z(4,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0408:
                        cur_z = get_z(4,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0409:
                        cur_z = get_z(4,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0410:
                        cur_z = get_z(4,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0411:
                        cur_z = get_z(4,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0412:
                        cur_z = get_z(4,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0413:
                        cur_z = get_z(4,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone0501:
                        cur_z = get_z(5,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0502:
                        cur_z = get_z(5,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0503:
                        cur_z = get_z(5,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0504:
                        cur_z = get_z(5,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0505:
                        cur_z = get_z(5,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0506:
                        cur_z = get_z(5,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0507:
                        cur_z = get_z(5,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0508:
                        cur_z = get_z(5,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0509:
                        cur_z = get_z(5,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0510:
                        cur_z = get_z(5,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0511:
                        cur_z = get_z(5,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0512:
                        cur_z = get_z(5,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0513:
                        cur_z = get_z(5,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone0601:
                        cur_z = get_z(6,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0602:
                        cur_z = get_z(6,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0603:
                        cur_z = get_z(6,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0604:
                        cur_z = get_z(6,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0605:
                        cur_z = get_z(6,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0606:
                        cur_z = get_z(6,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0607:
                        cur_z = get_z(6,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0608:
                        cur_z = get_z(6,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0609:
                        cur_z = get_z(6,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0610:
                        cur_z = get_z(6,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0611:
                        cur_z = get_z(6,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0612:
                        cur_z = get_z(6,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0613:
                        cur_z = get_z(6,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone0701:
                        cur_z = get_z(7,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0702:
                        cur_z = get_z(7,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0703:
                        cur_z = get_z(7,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0704:
                        cur_z = get_z(7,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0705:
                        cur_z = get_z(7,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0706:
                        cur_z = get_z(7,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0707:
                        cur_z = get_z(7,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0708:
                        cur_z = get_z(7,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0709:
                        cur_z = get_z(7,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0710:
                        cur_z = get_z(7,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0711:
                        cur_z = get_z(7,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0712:
                        cur_z = get_z(7,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0713:
                        cur_z = get_z(7,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone0801:
                        cur_z = get_z(8,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0802:
                        cur_z = get_z(8,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0803:
                        cur_z = get_z(8,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0804:
                        cur_z = get_z(8,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0805:
                        cur_z = get_z(8,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0806:
                        cur_z = get_z(8,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0807:
                        cur_z = get_z(8,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0808:
                        cur_z = get_z(8,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0809:
                        cur_z = get_z(8,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0810:
                        cur_z = get_z(8,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0811:
                        cur_z = get_z(8,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0812:
                        cur_z = get_z(8,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0813:
                        cur_z = get_z(8,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone0901:
                        cur_z = get_z(9,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0902:
                        cur_z = get_z(9,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0903:
                        cur_z = get_z(9,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0904:
                        cur_z = get_z(9,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0905:
                        cur_z = get_z(9,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0906:
                        cur_z = get_z(9,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0907:
                        cur_z = get_z(9,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0908:
                        cur_z = get_z(9,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0909:
                        cur_z = get_z(9,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0910:
                        cur_z = get_z(9,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0911:
                        cur_z = get_z(9,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0912:
                        cur_z = get_z(9,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone0913:
                        cur_z = get_z(9,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone1001:
                        cur_z = get_z(10,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1002:
                        cur_z = get_z(10,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1003:
                        cur_z = get_z(10,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1004:
                        cur_z = get_z(10,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1005:
                        cur_z = get_z(10,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1006:
                        cur_z = get_z(10,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1007:
                        cur_z = get_z(10,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1008:
                        cur_z = get_z(10,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1009:
                        cur_z = get_z(10,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1010:
                        cur_z = get_z(10,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1011:
                        cur_z = get_z(10,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1012:
                        cur_z = get_z(10,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1013:
                        cur_z = get_z(10,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone1101:
                        cur_z = get_z(11,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1102:
                        cur_z = get_z(11,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1103:
                        cur_z = get_z(11,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1104:
                        cur_z = get_z(11,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1105:
                        cur_z = get_z(11,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1106:
                        cur_z = get_z(11,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1107:
                        cur_z = get_z(11,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1108:
                        cur_z = get_z(11,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1109:
                        cur_z = get_z(11,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1110:
                        cur_z = get_z(11,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1111:
                        cur_z = get_z(11,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1112:
                        cur_z = get_z(11,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1113:
                        cur_z = get_z(11,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone1201:
                        cur_z = get_z(12,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1202:
                        cur_z = get_z(12,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1203:
                        cur_z = get_z(12,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1204:
                        cur_z = get_z(12,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1205:
                        cur_z = get_z(12,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1206:
                        cur_z = get_z(12,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1207:
                        cur_z = get_z(12,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1208:
                        cur_z = get_z(12,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1209:
                        cur_z = get_z(12,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1210:
                        cur_z = get_z(12,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1211:
                        cur_z = get_z(12,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1212:
                        cur_z = get_z(12,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1213:
                        cur_z = get_z(12,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                    case R.id.stone1301:
                        cur_z = get_z(13,1);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1302:
                        cur_z = get_z(13,2);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1303:
                        cur_z = get_z(13,3);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1304:
                        cur_z = get_z(13,4);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1305:
                        cur_z = get_z(13,5);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1306:
                        cur_z = get_z(13,6);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1307:
                        cur_z = get_z(13,7);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1308:
                        cur_z = get_z(13,8);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1309:
                        cur_z = get_z(13,9);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1310:
                        cur_z = get_z(13,10);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1311:
                        cur_z = get_z(13,11);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1312:
                        cur_z = get_z(13,12);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;
                    case R.id.stone1313:
                        cur_z = get_z(13,13);
                        if (board[cur_z] == 0) {
                            button2.setBackgroundResource(R.drawable.white_stone);
                        }
                        break;

                }
            }
        }
    }

    void remove(int tz, int color) {// 넘어온 돌의 색과 연결된 돌을 모두 지운다

        int z, i;
        board[tz] = 0;
        for (i = 0; i<4; i++) {
            z = tz + dir4[i];
            if (board[z] == color) remove(z, color);
        }
    }

    int put(int tz, int color, int fill_eye_err) {

        board[tz] = color;
        latest_z = tz;

        int[][] around = new int[4][3];
        int un_col = flip_color(color);   // 다른 색의 돌

        // count 4 neighbor's liberty and stones.
        int space = 0;
        int wall = 0;
        int mycol_safe = 0;
        int capture_sum = 0;
        int ko_maybe = 0;
        int i;

        for (i = 0; i<4; i++) {
            around[i][0] = 0;
            around[i][1] = 0;
            around[i][2] = 0;
            int z = tz + dir4[i];
            int c = board[z];	// color
            if (c == 0) space++; // 빈 공간
            if (c == 3) wall++; // 돌을 두지 못하는 벽이다
            if (c == 0 || c == 3) continue; // 돌이 놓여져 있다면 밑에 코드를 진행

            count_liberty(z);
            around[i][0] = liberty;
            around[i][1] = stone;
            around[i][2] = c;
            /*
            if (c == un_col && liberty == 1) { capture_sum += stone; ko_maybe = z; }
            if (c == color  && liberty >= 2) mycol_safe++;*/
        }
/*
        if (capture_sum == 0 && space == 0 && mycol_safe == 0) return 1; // suicide
        if (tz == ko_z) return 2; // ko
        if (wall + mycol_safe == 4 && fill_eye_err != 0) return 3; // eye
        if (board[tz] != 0) return 4;
*/


        for (i = 0; i<4; i++) { // 돌을 놓고 난 후 상대 방의 돌을 땄을 때 보드판에서 상대방의 돌을 지우는 코드
            int d = around[i][0];
            int c = around[i][2];
            if (c == un_col && d == 0 && board[tz + dir4[i]] != 0) { // tz 주변이 반대 색깔의 돌이고 활로가 0이고 주변이 비어있지 않을떄
                remove(tz + dir4[i], un_col); // tz의 주변 돌을 지운다
            }
        }
/*
        count_liberty(tz);
        if (capture_sum == 1 && stone == 1 && liberty == 1) ko_z = ko_maybe;
        else ko_z = 0;*/
        return 0;
    }

    void count_liberty_sub(int tz, int color) {
        int z, i;

        check_board[tz] = 1;     // search flag
        stone++;            // number of stone
        for (i = 0; i<4; i++) {
            z = tz + dir4[i];
            if (check_board[z] != 0) continue; // check = 1 이면 이미 검색했으니 넘긴다
            if (board[z] == 0) { // 만약 주변이 비어있다면 check = 1 활로 + 1
                check_board[z] = 1;
                liberty++;      // number of liberty
            }
            if (board[z] == color) count_liberty_sub(z, color);
            // 비어있지 않고 내 돌이 놓여져 있으면 그 돌의 주변의 활로를 또 찾는다
        }
    }

    void count_liberty(int tz) {
        int i;
        liberty = 0;
        stone = 0; // 활로랑 돌 초기화

        for (i = 0; i < BOARD_MAX; i++) check_board[i] = 0; // 체크보드 초기화
        count_liberty_sub(tz, board[tz]); // 놓은 돌 주변의 돌 활로 체크
    }

    int get_z (int x, int y)
    {
        return x * WIDTH + y;
    }

    int flip_color (int col) {
        return 3 - col;
    }

}
