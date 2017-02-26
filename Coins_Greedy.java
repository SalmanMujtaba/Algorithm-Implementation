//Greedy Algorithm : Coins denomination

public class Coins_Greedy {

	int number = 0;
	int makeChangeGreedyStyle(int amount, int[] coins) {
		// Check if there is no more change to make.
		if (amount == 0) {
		System.out.println("");
		return 0;
		}
		// Loop over the change in order of greatest to smallest.
		for (int i = coins.length; i > 0; i--) {
		int coin = coins[i - 1];
		// If the next largest coin is found, print out its value.
		if (amount >= coin) {
		System.out.print(coin + " ");
		number = number + 1;
		return  makeChangeGreedyStyle(amount - coin, coins);
		
		}
		}
		System.out.print("Cannot make change; ");
		System.out.println("cents remaining: " + amount);
		return 0;
		}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Coins_Greedy c = new Coins_Greedy();
		int[] coin = {1,4,5,6};
		c.makeChangeGreedyStyle(100, coin);
		System.out.println(c.number);
		

	}

}
