package ru.vsu.cs;

import java.util.Scanner;

public class Main {


    public static void main(String[] args)
	{
        int x1 = readGoals("Team N at home");

        int y1 = readGoals("Team M in a foreign field");

        int x2 = readGoals("Team N in a foreign field");

        int y2 = readGoals("Team M at home");

        Result firstMatchWinner = searchFirstMatchWinner(x1, y1);

        Result secondMatchWinner = searchSecondMatchWinner(x2, y2);

        Stage stageWinner = searchForStageWinner(x1, x2, y1, y2);

        Result[] results = Result.values();

        Stage[] totals = Stage.values();



        printMatchWinner(firstMatchWinner);

        printMatchWinner(secondMatchWinner);


        printResultOfGames(stageWinner);
    }

    private static int readGoals(String name)
	{
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter the number of goals scored by %s: ", name);

        return sc.nextInt();
    }

    private static int calculateTheDifference(int x, int y)
	{
        return x - y;
    }

    private static Result searchFirstMatchWinner(int x1, int y1)
	{
        int winnerOfMatchOne = calculateTheDifference(x1, y1);

        if (winnerOfMatchOne > 0)
        {
            return Result.TEAM_N_WINNER;
        }
        else if (winnerOfMatchOne < 0) {
            return Result.TEAM_M_WINNER;
        }
        else
        {
            return Result.DRAW;
        }
    }

    private static Result searchSecondMatchWinner(int x2, int y2)
	{
        int winnerOfMatchTwo = calculateTheDifference(x2, y2);

        if (winnerOfMatchTwo > 0)
        {
            return Result.TEAM_N_WINNER;
        }
        else if (winnerOfMatchTwo < 0)
        {
            return Result.TEAM_M_WINNER;
        }
        else
        {
            return Result.DRAW;
        }
    }

    private static Stage searchForStageWinner(int x1, int y1, int x2, int y2)
	{
        int winnerOfFirstMatch = calculateTheDifference(x1, y1);

        int winnerOfSecondMatch = calculateTheDifference(x2, y2);

        if (winnerOfFirstMatch > 0 && winnerOfSecondMatch > 0)
        {
            return Stage.TEAM_N_STAGE_WINNER;
        }
        else if (winnerOfFirstMatch < 0 && winnerOfSecondMatch < 0)
        {
            return Stage.TEAM_M_STAGE_WINNER;
        }
        else
        {
            return searchForWinnerInDraw(x2, y1);
        }
    }

    private static Stage searchForWinnerInDraw(int x2, int y1)
	{
        int winnerStageInDraw = calculateTheDifference(x2, y1);

        if (winnerStageInDraw > 0)
        {
            return Stage.TEAM_N_STAGE_WINNER;
        }
        else if (winnerStageInDraw < 0)
        {
            return Stage.TEAM_M_STAGE_WINNER;
        }
        else
        {
            return null;
        }
    }

    private static void printMatchWinner(Result results)
	{
	    switch(results) {
            case TEAM_N_WINNER:
                System.out.println("Team N won this match!");
                break;

            case TEAM_M_WINNER:
                System.out.println("Team M won this match!");
                break;

            case DRAW:
                System.out.println("Draw!");
                break;
        }
    }

    private static void printResultOfGames(Stage totals)
	{
	    switch(totals) {
            case TEAM_N_STAGE_WINNER:
                System.out.println("Team N won the stage!");
                break;

            case TEAM_M_STAGE_WINNER:
                System.out.println("Team M won the stage!");
                break;
        }
    }
}
