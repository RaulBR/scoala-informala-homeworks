package ro.scii.io.homework;

import java.util.Random;

public class ThreadVote implements Runnable {
Random r= new Random();
	int time;
	VoteBallot vote;
	VoteBox box;
	 public ThreadVote(VoteBallot vote) {
		 this.vote=vote;
		time=r.nextInt(2000);
	}
	
	@Override
	public void run() {
		
		try{
			Thread.sleep(3000-time);
			VoteBox box= new  VoteBox();
					box.addVote(vote);
		} catch(Exception e){
			
		}
	
	}

}
