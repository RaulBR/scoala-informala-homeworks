package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ro.scii.io.homework.VoteBallot;


public class VoteBalletTest {
	
	
	@Test
	public void cnpVoteBalletTest(){
		VoteBallot testVote= new VoteBallot("123","","");
		
		assertEquals("123", testVote.getCnp());
		
		
	}
	
	@Test
	public void candidatevoteBalletTest(){
		VoteBallot testVote= new VoteBallot("","","vasile");
		
		assertEquals("vasile", testVote.getCandidate());
		
		
	}
	
	@Test
	public void votersNamevoteBalletTest() {
		VoteBallot testVote = new VoteBallot("", "gigi", "");

		assertEquals("gigi", testVote.getVotersName());

	}
	

}
