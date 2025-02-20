import java.util.*;

class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedResults = new TreeMap<>(); 

   
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
        sortedResults.put(candidate, sortedResults.getOrDefault(candidate, 0) + 1);
    }

    public void displayVotesInOrder() {
        System.out.println("Votes in Order of Voting: " + voteOrder);
    }

    public void displaySortedResults() {
        System.out.println("Sorted Voting Results: " + sortedResults);
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();
        
       
        voting.castVote("Alice");
        voting.castVote("Bob");
        voting.castVote("Alice");
        voting.castVote("Charlie");
        voting.castVote("Bob");

     
        voting.displayVotesInOrder();
        voting.displaySortedResults();
    }
}
