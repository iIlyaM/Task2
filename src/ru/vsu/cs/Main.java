package ru.vsu.cs;

import java.util.Scanner;

public class Main {


    public static void main(String[] args)
    {
        String goals = readGoals();
        String[] scores = goals.split(":");

        int n1 = Integer.parseInt(scores[0]);
        int m1 = Integer.parseInt(scores[1]);

         goals = readGoals();
         scores = goals.split(":");

        int n2 = Integer.parseInt(scores[0]);
        int m2 = Integer.parseInt(scores[1]);

        Stage stageWinner = searchForStageWinner(n1, m1, n2, m2);

        printResultOfGames(stageWinner);
    }

    private static String readGoals()
	{
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter the results of game between Team N and M: ");
       return scan.nextLine();
    }

    private static int calculateTheSumOfGoalsTeamN(int n1, int n2)
	{
        return n1 + n2;
    }

    private static int calculateTheSumOfGoalsTeamM(int m1, int m2)
    {
        return m1 + m2;
    }

    private static Stage searchForStageWinner(int n1, int m1, int n2, int m2)
	{
        int sumPointsOfN = calculateTheSumOfGoalsTeamN(n1, n2);
        int sumPointsOfM = calculateTheSumOfGoalsTeamM(m1, m2);

        if (sumPointsOfN > sumPointsOfM)
        {
            return Stage.TEAM_N_STAGE_WINNER;
        }
        else if (sumPointsOfN < sumPointsOfM)
        {
            return Stage.TEAM_M_STAGE_WINNER;
        }
        else
        {
            return searchForWinnerInDraw(n2, m1);
        }
    }

    private static Stage searchForWinnerInDraw(int n2, int m1)
    {
        if (n2 > m1)
        {
            return Stage.TEAM_N_STAGE_WINNER;
        }
        else
        {
            return Stage.TEAM_M_STAGE_WINNER;
        }
    }

    private static void printResultOfGames(Stage totals)
	{
	    switch(totals)
        {
            case TEAM_N_STAGE_WINNER:
                System.out.println("Team N won the stage!");
                break;

            case TEAM_M_STAGE_WINNER:
                System.out.println("Team M won the stage!");
                break;
        }
    }
}
