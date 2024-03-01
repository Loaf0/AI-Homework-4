package aiHomework4;
import csis4463.*;
import java.util.ArrayList;
import java.util.Collections;

/*
* @author Tyler Snyder, Miguel 
* @date 03/01/24
* This is our group submission of homework #4 for CSIS-4463
*/

public class SomeExamples {
	
	public static void main(String[] args) {
		
		PuzzleSolution solution;

		float[][] ExpandedTable = new float[6][6];
		float[][] GeneratedTable = new float[6][6];
		float[][] MemoryTable = new float[6][6];
		
		float expandedStates;
		float generatedStates;
		float statesInMemory;
		
		for(int t = 1; t < 7; t++)
		{
			ArrayList<SlidingTilePuzzle> puzzles = new ArrayList<SlidingTilePuzzle>();
			ArrayList<SlidingTilePuzzle> temp = new ArrayList<SlidingTilePuzzle>();
	
			//Uniform Cost Search
			for(int i = 0; i < 100; i++) 
			{
				puzzles.add(new SlidingTilePuzzle(3, 3, t*2));
			}
			
			expandedStates = 0;
			generatedStates = 0;
			statesInMemory = 0;
				
			while(puzzles.size()>0) 
			{
				solution = SlidingTilePuzzleSolver.uniformCostSearch(puzzles.get(0));
				expandedStates += solution.getNumberOfStatesExpanded(); 
				generatedStates += solution.getNumGenerated();
				statesInMemory += solution.getNumberOfStatesInMemory();
				puzzles.remove(0);
			}
			
			ExpandedTable[t-1][0] = expandedStates/100;
			GeneratedTable[t-1][0] = generatedStates/100;		
			MemoryTable[t-1][0] = statesInMemory/100;
					
			//A*1
			for(int i = 0; i < 100; i++) 
			{
				puzzles.add(new SlidingTilePuzzle(3, 3, t*2));
			}
			
			expandedStates = 0;
			generatedStates = 0;
			statesInMemory = 0;
				
			while(puzzles.size()>0) 
			{
				solution = SlidingTilePuzzleSolver.AStarSearchManhattanDistance(puzzles.get(0));
				expandedStates += solution.getNumberOfStatesExpanded(); 
				generatedStates += solution.getNumGenerated();
				statesInMemory += solution.getNumberOfStatesInMemory();
				puzzles.remove(0);
			}
			
			ExpandedTable[t-1][1] = expandedStates/100;
			GeneratedTable[t-1][1] = generatedStates/100;		
			MemoryTable[t-1][1] = statesInMemory/100;
			
			//A*2
			for(int i = 0; i < 100; i++) 
			{
				puzzles.add(new SlidingTilePuzzle(3, 3, t*2));
			}
			
			expandedStates = 0;
			generatedStates = 0;
			statesInMemory = 0;
				
			while(puzzles.size()>0) 
			{
				solution = SlidingTilePuzzleSolver.AStarSearchMisplacedTiles(puzzles.get(0));
				expandedStates += solution.getNumberOfStatesExpanded(); 
				generatedStates += solution.getNumGenerated();
				statesInMemory += solution.getNumberOfStatesInMemory();
				puzzles.remove(0);
			}
			
			ExpandedTable[t-1][2] = expandedStates/100;
			GeneratedTable[t-1][2] = generatedStates/100;		
			MemoryTable[t-1][2] = statesInMemory/100;
			
			//ID
			for(int i = 0; i < 100; i++) 
			{
				puzzles.add(new SlidingTilePuzzle(3, 3, t*2));
			}
			
			expandedStates = 0;
			generatedStates = 0;
			statesInMemory = 0;
				
			while(puzzles.size()>0) 
			{
				solution = SlidingTilePuzzleSolver.iterativeDeepening(puzzles.get(0));
				expandedStates += solution.getNumberOfStatesExpanded(); 
				generatedStates += solution.getNumGenerated();
				statesInMemory += solution.getNumberOfStatesInMemory();
				puzzles.remove(0);
			}
			
			ExpandedTable[t-1][3] = expandedStates/100;
			GeneratedTable[t-1][3] = generatedStates/100;		
			MemoryTable[t-1][3] = statesInMemory/100;
			
			//IDA*1
			for(int i = 0; i < 100; i++) 
			{
				puzzles.add(new SlidingTilePuzzle(3, 3, t*2));
			}
			
			expandedStates = 0;
			generatedStates = 0;
			statesInMemory = 0;
				
			while(puzzles.size()>0) 
			{
				solution = SlidingTilePuzzleSolver.idaStarManhattanDistance(puzzles.get(0));
				expandedStates += solution.getNumberOfStatesExpanded(); 
				generatedStates += solution.getNumGenerated();
				statesInMemory += solution.getNumberOfStatesInMemory();
				puzzles.remove(0);
			}
			
			ExpandedTable[t-1][4] = expandedStates/100;
			GeneratedTable[t-1][4] = generatedStates/100;		
			MemoryTable[t-1][4] = statesInMemory/100;
			
			//IDA*2
			for(int i = 0; i < 100; i++) 
			{
				puzzles.add(new SlidingTilePuzzle(3, 3, t*2));
			}
			
			expandedStates = 0;
			generatedStates = 0;
			statesInMemory = 0;
				
			while(puzzles.size()>0) 
			{
				solution = SlidingTilePuzzleSolver.idaStarMisplacedTiles(puzzles.get(0));
				expandedStates += solution.getNumberOfStatesExpanded(); 
				generatedStates += solution.getNumGenerated();
				statesInMemory += solution.getNumberOfStatesInMemory();
				puzzles.remove(0);
			}
			
			ExpandedTable[t-1][5] = expandedStates/100;
			GeneratedTable[t-1][5] = generatedStates/100;		
			MemoryTable[t-1][5] = statesInMemory/100;
		}
		
		System.out.println("Num States Expanded \n L            UCS            A*1            A*2             ID          IDA*1          IDA*2");
		printTable(ExpandedTable);
		
		System.out.println("Num States Generated \n L            UCS            A*1            A*2             ID          IDA*1          IDA*2");
		printTable(GeneratedTable);
		
		System.out.println("Max States in Memory \n L            UCS            A*1            A*2             ID          IDA*1          IDA*2");
		printTable(MemoryTable);
	}
	
	public static void printTable(float[][] arr) 
	{	
		for (int i = 1; i < 7; i++)
		{
			System.out.printf("%2d", i*2);
			for (int j = 1; j < 7; j++)
			{
				System.out.printf("%15s", "" + arr[i-1][j-1]);
			}
			System.out.println();
		}
	}
}