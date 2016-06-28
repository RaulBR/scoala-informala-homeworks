package ro.scii.io.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is child class of {@link Election}.
 * <p>
 * Reed's a list of Strings form the Disk in CSV format (cnp,name,candiadte
 * name): if a cnp is duplicat it fully removes it form the count. It count the
 * number of candidates that aper on a preset candidate list in the parent class
 * 
 * </p>
 * 
 * @example "0000000,Vasile Alexandri,Furpu Tin"
 * 
 * 
 * @author Raul
 *
 */
public class VoteCommittee extends Election {

	//

	/**
	 * This method prints put the election results.
	 *
	 */
	public void print() {
		ReadWriteFile readFile = new ReadWriteFile();
		result(voteCount(getCandidats(cnpCheck(readFile.readFile()))));
	}

	/**
	 * This method returns a ArrayList<String> of candidates. (make sure you
	 * pass the values thru the {@link cnpCheck})
	 * 
	 * @param cnpCheched
	 *
	 */
	public ArrayList<String> getCandidats(ArrayList<String> cnpCheched) {

		ArrayList<String> candidates = new ArrayList<>();
		for (String s : cnpCheched) {
			for (String candidate : getCandidatesList()) {
				if (candidate.equals(s.split(",")[2])) {

					if (!s.split(",")[2].equals("Null vote")) {

						candidates.add(s.split(",")[2]);
					}
				}
			}
		}
		return candidates;

	}

	/**
	 * This method returns a Map<String, Integer> of candidates and the umber of
	 * times they apeer i nthe list.
	 * 
	 * @param unCountedList
	 *
	 */
	public  Map<String, Integer> voteCount(ArrayList<String> unCountedList) {
		Map<String, Integer> votes = new HashMap<>();
		for (String temp : unCountedList) {
			Integer count = votes.get(temp);
			votes.put(temp, (count == null) ? 1 : count + 1);
		}
		return votes;
	}

	/**
	 * This method returns a ArrayList<String> tipe CSV, it removes duplicate
	 * cnp's
	 * 
	 * @param listToBeChecked
	 *
	 */
	public ArrayList<String> cnpCheck(ArrayList<String> listToBeChecked) {
		ArrayList<String> listCorrectVotes = new ArrayList<>();

		for (int i = 0; i < listToBeChecked.size()-1; i++) {
			String[] check = listToBeChecked.get(i).split(",");
			String verify = check[0];
			boolean duplicat = false;

			for (int j = i + 1; j < listToBeChecked.size(); j++) {
				String[] verifyTO = listToBeChecked.get(j).split(",");
				if (verify.equals(verifyTO[0])) {
					System.err.println("CNP " + verifyTO[0] + " voted more then once, Fine 5000");
					duplicat = true;
					listToBeChecked.remove(j);
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

	/**
	 * This method count the number of votes are prepend in a file on the disc
	 * and.
	 */

	public void countVotes() {
		ReadWriteFile readFile = new ReadWriteFile();
		result(voteCount(getCandidats(cnpCheck(readFile.readFile()))));

	}
}
