package com.example.android.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String SCORE_TEAM_A = "scoreA";
    private static final String SCORE_TEAM_B = "scoreB";
    private static final String FOUL_TEAM_A = "foulA";
    private static final String FOUL_TEAM_B = "foulB";

    private int pointsForTeamA = 0;
    private int pointsForTeamB = 0;
    private int foulsCommittedTeamA = 0;
    private int foulsCommittedTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pointsForTeamA = savedInstanceState.getInt(SCORE_TEAM_A);
        pointsForTeamB = savedInstanceState.getInt(SCORE_TEAM_B);
        foulsCommittedTeamA = savedInstanceState.getInt(FOUL_TEAM_A);
        foulsCommittedTeamB = savedInstanceState.getInt(FOUL_TEAM_B);

        displayPointsForTeamA(pointsForTeamA);
        displayPointsForTeamB(pointsForTeamA);
        displayFoulsByTeamA(foulsCommittedTeamA);
        displayFoulsByTeamB(foulsCommittedTeamB);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(SCORE_TEAM_A, pointsForTeamA);
        savedInstanceState.putInt(SCORE_TEAM_B, pointsForTeamB);
        savedInstanceState.putInt(FOUL_TEAM_A, foulsCommittedTeamA);
        savedInstanceState.putInt(FOUL_TEAM_B, foulsCommittedTeamB);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }




    /**
     * Displays the current points scored by Team A.
     */
    private void displayPointsForTeamA(int score) {
        TextView scoreTextView = (TextView) findViewById(R.id.team_a_score);
        scoreTextView.setText(String.valueOf(score));
    }

    /**
     * Displays the current points scored by Team B.
     */
    private void displayPointsForTeamB(int score) {
        TextView scoreTextView = (TextView) findViewById(R.id.team_b_score);
        scoreTextView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of fouls committed by Team A.
     */
    private void displayFoulsByTeamA(int fouls) {
        TextView foulsTextView = (TextView) findViewById(R.id.team_a_fouls);
        foulsTextView.setText(String.valueOf(fouls));
    }

    /**
     * Displays the number of fouls committed by Team B.
     */
    private void displayFoulsByTeamB(int fouls) {
        TextView foulsTextView = (TextView) findViewById(R.id.team_b_fouls);
        foulsTextView.setText(String.valueOf(fouls));
    }

    /**
     * Increases the goals scored by Team A with a point.
     */
    public void addPointForTeamA(View view) {
        pointsForTeamA = pointsForTeamA + 1;
        displayPointsForTeamA(pointsForTeamA);
    }

    /**
     * Increases the goals scored by Team B with a point.
     */
    public void addPointForTeamB(View view) {
        pointsForTeamB = pointsForTeamB + 1;
        displayPointsForTeamB(pointsForTeamB);
    }

    /**
     * Increases the number of fouls committed by Team A by one.
     */
    public void addFoulForTeamA(View view) {
        foulsCommittedTeamA = foulsCommittedTeamA + 1;
        displayFoulsByTeamA(foulsCommittedTeamA);
    }

    /**
     * Increases the number of fouls committed by Team B by one.
     */
    public void addFoulForTeamB(View view) {
        foulsCommittedTeamB = foulsCommittedTeamB + 1;
        displayFoulsByTeamB(foulsCommittedTeamB);
    }

    /**
     * Resets the game, clearing the goals scored and fouls committed by both teams.
     */
    public void resetGame(View view) {
        pointsForTeamA = 0;
        pointsForTeamB = 0;
        foulsCommittedTeamA = 0;
        foulsCommittedTeamB = 0;

        displayPointsForTeamA(pointsForTeamA);
        displayPointsForTeamB(pointsForTeamB);
        displayFoulsByTeamA(foulsCommittedTeamA);
        displayFoulsByTeamB(foulsCommittedTeamB);
    }
}
