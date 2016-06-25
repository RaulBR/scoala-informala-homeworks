package ro.scii.io.homework;

public class VoteBallet {
	private String cnp;
	private String votersName;
	private String Candidate;

	public VoteBallet(String cnp, String votersName, String candidate) {

		this.cnp = cnp;
		this.votersName = votersName;
		this.Candidate = candidate;

	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getVotersName() {
		return votersName;
	}

	public String getCandidate() {
		return Candidate;
	}

}
