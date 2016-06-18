package ro.scii.io.homework;

/**
 * This class simulates a vote box to put votes in. It takes in the votes and it
 * uses the {@linkplain ReadWriteFile} class to add put the on the disc.
 * 
 * @author Raul
 *
 */
public class VoteBox {

	/**
	 * This method thake's in a {@link VoteBallot} it format's it to CSV and
	 * with {@link ReadWriteFile} it add's the data to the disk
	 * 
	 * @param votBallet
	 */
	public void addVote(VoteBallot votBallet) {
		ReadWriteFile write = new ReadWriteFile();

		String candidate = votBallet.getCandidate();
		if (candidate.equals("")) {
			candidate = "Null vote";
		}
		write.WriteData(toCsv(votBallet.getCnp(), votBallet.getVotersName(), candidate));

	}

	private String toCsv(String cnp, String votersName, String candidate) {

		return cnp + "," + votersName + "," + candidate;
	}

}
