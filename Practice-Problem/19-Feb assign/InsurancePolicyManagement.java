import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy policy = (InsurancePolicy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Number='" + policyNumber + '\'' +
                ", Holder='" + policyholderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Type='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    private Set<InsurancePolicy> hashSet = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSet = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        for (InsurancePolicy policy : hashSet) {
            System.out.println(policy);
        }
    }

    public void displayExpiringSoon() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date thresholdDate = calendar.getTime();

        System.out.println("\nPolicies Expiring Soon:");
        for (InsurancePolicy policy : treeSet) {
            if (policy.getExpiryDate().before(thresholdDate)) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String type) {
        System.out.println("\nPolicies with Coverage Type: " + type);
        for (InsurancePolicy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        for (InsurancePolicy policy : hashSet) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        System.out.println("\nDuplicate Policies:");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Policy Number: " + entry.getKey() + " appears " + entry.getValue() + " times.");
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement management = new InsurancePolicyManagement();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 20); 
        InsurancePolicy policy1 = new InsurancePolicy("P001", "Alice", cal.getTime(), "Health", 500.0);

        cal.add(Calendar.DAY_OF_YEAR, 50); 
        InsurancePolicy policy2 = new InsurancePolicy("P002", "Bob", cal.getTime(), "Auto", 700.0);

        cal.add(Calendar.DAY_OF_YEAR, -80); 
        InsurancePolicy policy3 = new InsurancePolicy("P003", "Charlie", cal.getTime(), "Home", 900.0);

        InsurancePolicy policy4 = new InsurancePolicy("P001", "Alice", cal.getTime(), "Health", 500.0); // Duplicate

        management.addPolicy(policy1);
        management.addPolicy(policy2);
        management.addPolicy(policy3);
        management.addPolicy(policy4);

        management.displayAllPolicies();
        management.displayExpiringSoon();
        management.displayByCoverageType("Health");
        management.findDuplicatePolicies();
    }
}
