package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ro.scii.io.homework.VoteCommittee;

public class VoteCommitteeTest {

	@Test
	public void addCandidateTest() {
		ArrayList<String> eu = new ArrayList<>();
		eu.add("eu");
		VoteCommittee vote = new VoteCommittee();
		vote.addCandidate("eu");

		assertEquals(eu, vote.getCandidatesList());

	}

	@Test
	public void checkCnpTest() {
		ArrayList<String> cnp = new ArrayList<>();
		cnp.add("0000,x,y");
		cnp.add("0001,x,y");
		cnp.add("0000,x,y");
		ArrayList<String> cnpOK = new ArrayList<>();

		cnpOK.add("0001,x,y");
		VoteCommittee vote = new VoteCommittee();

		assertEquals(cnpOK, vote.cnpCheck(cnp));

	}

	@Test
	public void countCandidateTest() {
		ArrayList<String> can = new ArrayList<>();
		can.add("nas");
		can.add("cap");
		Map<String, Integer> c = new HashMap<>();
		c.put("nas", 1);
		c.put("cap", 1);
		VoteCommittee vote = new VoteCommittee();

		assertEquals(c, vote.voteCount(can));

	}

	@Test
	public void notACandidatTest() {
		ArrayList<String> can = new ArrayList<>();
		can.add("0001,x,jim");
		can.add("0002,x,fim");
		can.add("0003,x,tim");
		ArrayList<String> canOK = new ArrayList<>();
		canOK.add("jim");
		canOK.add("fim");

		VoteCommittee vote = new VoteCommittee();
		vote.addCandidate("jim");
		vote.addCandidate("fim");
		assertEquals(canOK, vote.getCandidats(can));

	}

	@Test
	public void NoVoteTest() {
		ArrayList<String> can = new ArrayList<>();
		can.add("0001,x,jim");
		can.add("0002,x,fim");
		can.add("0003,x,Null vote");
		ArrayList<String> canOK = new ArrayList<>();
		canOK.add("jim");
		canOK.add("fim");

		VoteCommittee vote = new VoteCommittee();
		vote.addCandidate("jim");
		vote.addCandidate("fim");
		assertEquals(canOK, vote.getCandidats(can));

	}

}