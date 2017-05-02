package com.tc2r.foodflipmatch;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

/* Instructor: Anna Xu
* Link: https://www.youtube.com/watch?v=94CWNE9ruMA
*
* Develop Memory Game Tutorial
*
* Notes on Project:
* Added a delay on button press to stop users from spamming the game.
*
* Notes: I believe this is a very basic way to program, and
* that it would be much more efficient if advanced for loops were applied.
*
*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	TextView tv_p1, tv_p2;

	ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34;

	// array for the images
	Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};
	// Actual images
	int image101, image102, image103, image104, image105, image106, image201, image202, image203, image204, image205, image206;

	int firstCard, secondCard;
	int clickedFirst, clickedSecond;



	int cardNumber = 1;
	int turn = 1;
	int playerPoints = 0, cpuPoints = 0;
	boolean pause = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv_p1 = (TextView) findViewById(R.id.tv_p1);
		tv_p2 = (TextView) findViewById(R.id.tv_p2);


		iv_11 = (ImageView) findViewById(R.id.iv_11);
		iv_12 = (ImageView) findViewById(R.id.iv_12);
		iv_13 = (ImageView) findViewById(R.id.iv_13);
		iv_14 = (ImageView) findViewById(R.id.iv_14);
		iv_21 = (ImageView) findViewById(R.id.iv_21);
		iv_22 = (ImageView) findViewById(R.id.iv_22);
		iv_23 = (ImageView) findViewById(R.id.iv_23);
		iv_24 = (ImageView) findViewById(R.id.iv_24);
		iv_31 = (ImageView) findViewById(R.id.iv_31);
		iv_32 = (ImageView) findViewById(R.id.iv_32);
		iv_33 = (ImageView) findViewById(R.id.iv_33);
		iv_34 = (ImageView) findViewById(R.id.iv_34);

		iv_11.setTag("0");
		iv_12.setTag("1");
		iv_13.setTag("2");
		iv_14.setTag("3");
		iv_21.setTag("4");
		iv_22.setTag("5");
		iv_23.setTag("6");
		iv_24.setTag("7");
		iv_31.setTag("8");
		iv_32.setTag("9");
		iv_33.setTag("10");
		iv_34.setTag("11");
		// load the card images
		frontOfCardsResources();

		// Shuffle the images
		Collections.shuffle(Arrays.asList(cardsArray));

		//changing the color of the second player to display inactivity
		tv_p2.setTextColor(Color.GRAY);

		iv_11.setOnClickListener(this);
		iv_12.setOnClickListener(this);
		iv_13.setOnClickListener(this);
		iv_14.setOnClickListener(this);
		iv_21.setOnClickListener(this);
		iv_22.setOnClickListener(this);
		iv_23.setOnClickListener(this);
		iv_24.setOnClickListener(this);
		iv_31.setOnClickListener(this);
		iv_32.setOnClickListener(this);
		iv_33.setOnClickListener(this);
		iv_34.setOnClickListener(this);

	}



	@Override
	public void onClick(View view) {
		int theCard;

		switch (view.getId()) {
			case R.id.iv_11:
				pause = true;
				Toast.makeText(this, String.valueOf(view.getId())+" VS "+ String.valueOf(view.getId()), Toast.LENGTH_SHORT).show();
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_11, theCard);
				break;
			case R.id.iv_12:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_12, theCard);
				break;
			case R.id.iv_13:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_13, theCard);
				break;
			case R.id.iv_14:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_14, theCard);
				break;
			case R.id.iv_21:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_21, theCard);
				break;
			case R.id.iv_22:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_22, theCard);
				break;

			case R.id.iv_23:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_23, theCard);
				break;
			case R.id.iv_24:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_24, theCard);
				break;

			case R.id.iv_31:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_31, theCard);
				break;

			case R.id.iv_32:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_32, theCard);
				break;
			case R.id.iv_33:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_33, theCard);
				break;
			case R.id.iv_34:
				pause = true;
				theCard = Integer.parseInt((String) view.getTag());
				doStuff(iv_34, theCard);
				break;
		}
	}

	private void doStuff(ImageView iv, int card) {

		Toast.makeText(this, String.valueOf(card), Toast.LENGTH_SHORT).show();

		// set the correct image to the imageview
		switch (cardsArray[card]) {
			case 101:
				iv.setImageResource(image101);
				break;
			case 102:
				iv.setImageResource(image102);
				break;
			case 103:
				iv.setImageResource(image103);
				break;
			case 104:
				iv.setImageResource(image104);
				break;
			case 105:
				iv.setImageResource(image105);
				break;
			case 106:
				iv.setImageResource(image106);
				break;
			case 201:
				iv.setImageResource(image201);
				break;
			case 202:
				iv.setImageResource(image202);
				break;
			case 203:
				iv.setImageResource(image203);
				break;
			case 204:
				iv.setImageResource(image204);
				break;
			case 205:
				iv.setImageResource(image205);
				break;
			case 206:
				iv.setImageResource(image206);
				break;
		}

		// check which image is selected and save it temporary
		if (cardNumber == 1) {

			firstCard = cardsArray[card];
			if (firstCard > 200) {
				firstCard = firstCard - 100;
			}
			cardNumber = 2;
			clickedFirst = card;

			iv.setEnabled(false);

		} else if (cardNumber == 2) {
			secondCard = cardsArray[card];
			if (secondCard > 200) {
				secondCard = secondCard - 100;
			}
			cardNumber = 1;
			clickedSecond = card;

			iv_11.setEnabled(false);
			iv_12.setEnabled(false);
			iv_13.setEnabled(false);
			iv_14.setEnabled(false);
			iv_21.setEnabled(false);
			iv_22.setEnabled(false);
			iv_23.setEnabled(false);
			iv_24.setEnabled(false);
			iv_31.setEnabled(false);
			iv_32.setEnabled(false);
			iv_33.setEnabled(false);
			iv_34.setEnabled(false);

			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {

					// check if the selected images are equal
					calculate();
				}
			}, 1000);
		}

		Handler delayHandler = new Handler();
		delayHandler.postDelayed(new Runnable() {
			@Override
			public void run() {

				// check if the selected images are equal
				pause = false;
			}
		}, 1000);

	}

	private void calculate() {
		// if images are equal remove them and add point.
		if(firstCard == secondCard){
			if(clickedFirst == 0) {
				iv_11.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 1){
				iv_12.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 2){
				iv_13.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 3){
				iv_14.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 4){
				iv_21.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 5){
				iv_22.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 6){
				iv_23.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 7){
				iv_24.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 8){
				iv_31.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 9){
				iv_32.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 10) {
				iv_33.setVisibility(View.INVISIBLE);
			}else if (clickedFirst == 11) {
				iv_34.setVisibility(View.INVISIBLE);
			}

				if(clickedSecond == 0) {
					iv_11.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 1){
					iv_12.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 2){
					iv_13.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 3){
					iv_14.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 4){
					iv_21.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 5){
					iv_22.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 6){
					iv_23.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 7){
					iv_24.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 8){
					iv_31.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 9){
					iv_32.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 10) {
					iv_33.setVisibility(View.INVISIBLE);
				}else if (clickedSecond == 11) {
					iv_34.setVisibility(View.INVISIBLE);
				}

			// add points to the correct player
			if(turn == 1){
				playerPoints++;
				tv_p1.setText("P1:  "+ playerPoints);
			}else if (turn == 2){
				cpuPoints++;
				tv_p2.setText("P2:  "+ cpuPoints);
			}

		}else{
			iv_11.setImageResource(R.drawable.unknown);
			iv_12.setImageResource(R.drawable.unknown);
			iv_13.setImageResource(R.drawable.unknown);
			iv_14.setImageResource(R.drawable.unknown);
			iv_21.setImageResource(R.drawable.unknown);
			iv_22.setImageResource(R.drawable.unknown);
			iv_23.setImageResource(R.drawable.unknown);
			iv_24.setImageResource(R.drawable.unknown);
			iv_31.setImageResource(R.drawable.unknown);
			iv_32.setImageResource(R.drawable.unknown);
			iv_33.setImageResource(R.drawable.unknown);
			iv_34.setImageResource(R.drawable.unknown);


			// change the player turn
			if(turn == 1){
				turn = 2;
				tv_p1.setTextColor(Color.GRAY);
				tv_p2.setTextColor(Color.BLACK);
			}else if(turn == 2){
				turn = 1;
				tv_p1.setTextColor(Color.BLACK);
				tv_p2.setTextColor(Color.GRAY);
			}
		}

		iv_11.setEnabled(true);
		iv_12.setEnabled(true);
		iv_13.setEnabled(true);
		iv_14.setEnabled(true);
		iv_21.setEnabled(true);
		iv_22.setEnabled(true);
		iv_23.setEnabled(true);
		iv_24.setEnabled(true);
		iv_31.setEnabled(true);
		iv_32.setEnabled(true);
		iv_33.setEnabled(true);
		iv_34.setEnabled(true);

		// check if the game is over
		checkEnd();
	}

	private void checkEnd() {
		if(iv_11.getVisibility() == View.INVISIBLE &&
						iv_12.getVisibility() == View.INVISIBLE &&
						iv_13.getVisibility() == View.INVISIBLE &&
						iv_14.getVisibility() == View.INVISIBLE &&
						iv_21.getVisibility() == View.INVISIBLE &&
						iv_22.getVisibility() == View.INVISIBLE &&
						iv_23.getVisibility() == View.INVISIBLE &&
						iv_24.getVisibility() == View.INVISIBLE &&
						iv_31.getVisibility() == View.INVISIBLE &&
						iv_32.getVisibility() == View.INVISIBLE &&
						iv_33.getVisibility() == View.INVISIBLE &&
						iv_34.getVisibility() == View.INVISIBLE){

			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
			alertDialogBuilder
							.setMessage("GAME OVER! \n P1: " + playerPoints + "\n P2: " + cpuPoints)
							.setCancelable(false)
							.setPositiveButton("NEW", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialogInterface, int i) {
									Intent intent = new Intent(getApplicationContext(), MainActivity.class);
									startActivity(intent);
									finish();
								}
							})
							.setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialogInterface, int i) {
									finish();

								}
							});
			AlertDialog alertDialog = alertDialogBuilder.create();
			alertDialog.show();
		}
	}
	private void frontOfCardsResources() {
		image101 = R.drawable.image01;
		image102 = R.drawable.image02;
		image103 = R.drawable.image03;
		image104 = R.drawable.image04;
		image105 = R.drawable.image05;
		image106 = R.drawable.image06;
		image201 = R.drawable.image01;
		image202 = R.drawable.image02;
		image203 = R.drawable.image03;
		image204 = R.drawable.image04;
		image205 = R.drawable.image05;
		image206 = R.drawable.image06;
	}
}
