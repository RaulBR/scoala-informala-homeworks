package ro.scii.io.homework;

import java.util.Random;

// TODO CODE REVIEW: PLEASE format your code.

// TODO CODE REVIEW: If this is a Runnable, DON'T call it a thread. VoteRunnable, VoteAction, etc would be much more suitable.
public class ThreadVote implements Runnable {
Random r= new Random();
	int time;
	VoteBallot vote;
	// TODO CODE REVIEW: This is never used!
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
