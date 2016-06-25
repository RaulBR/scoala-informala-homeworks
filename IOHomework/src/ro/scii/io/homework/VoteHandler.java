package ro.scii.io.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VoteHandler {

	Map<String, Integer> votes = new HashMap<>();

	public VoteHandler() {
		ReadWriteFile readFile = new ReadWriteFile();

		votes = voteCount(getCandidats(cnpCheck(readFile.readFile())));

	}

	public void print() {
		result(votes);
	}

	public ArrayList<String> getCandidats(ArrayList<String> cnpCheched) {
		ArrayList<String> candidates = new ArrayList<>();
		for (String s : cnpCheched) {
		if(!s.split(",")[2].equals("Null vote")){
				
			candidates.add(s.split(",")[2]);
		}
		}
		return candidates;

	}

	private Map<String, Integer> voteCount(ArrayList<String> unCountedList) {

		for (String temp : unCountedList) {
			Integer count = votes.get(temp);
			votes.put(temp, (count == null) ? 1 : count + 1);
		}
		return votes;
	}

	private ArrayList<String> cnpCheck(ArrayList<String> listToBeChecked) {
		ArrayList<String> listCorrectVotes = new ArrayList<>();
		for (int i = 0; i < listToBeChecked.size() - 1; i++) {
			String[] check = listToBeChecked.get(i).split(",");
			String verify = check[0];
			boolean duplicat = false;
			for (int j = i + 1; j < listToBeChecked.size(); j++) {
				String[] verifyTO = listToBeChecked.get(j).split(",");
				if (verify.equals(verifyTO[0])) {
					System.err.println("CNP" + verifyTO[0] + " vvoted more then once, Fine 5000");
					duplicat = true;
					
				}

			}
			if (duplicat == false) {

				listCorrectVotes.add(listToBeChecked.get(i));
			}
		}

		return listCorrectVotes;

	}

	private void result(Map<String, Integer> map) {
		int sum = 0;
		for (Integer f : map.values()) {
			sum += f;
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			double number = entry.getValue();
			double procent = number / sum * 100;
			System.out.println("Candidate " + entry.getKey() + " votes : " + procent + " %");
		}

	}
}
