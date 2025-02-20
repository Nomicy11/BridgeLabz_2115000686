import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

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

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
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

public class InsurancePolicyManagement2

 {
    private Map<String, InsurancePolicy> policyMap = new HashMap<>();
	private Map<String, InsurancePolicy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<Date, InsurancePolicy> sortedByExpiry = new TreeMap<>();

   
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedByExpiry.put(policy.getExpiryDate(), policy);
    }

  
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    
    public List<InsurancePolicy> getExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date thresholdDate = calendar.getTime();

        for (Map.Entry<Date, InsurancePolicy> entry : sortedByExpiry.entrySet()) {
            if (entry.getKey().before(thresholdDate)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    
    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    
    public void removeExpiredPolicies() {
        Date currentDate = new Date();
        Iterator<Map.Entry<Date, InsurancePolicy>> iterator = sortedByExpiry.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Date, InsurancePolicy> entry = iterator.next();
            if (entry.getKey().before(currentDate)) {
                policyMap.remove(entry.getValue().getPolicyNumber());
                orderedPolicyMap.remove(entry.getValue().getPolicyNumber());
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagement2 management = new InsurancePolicyManagement2();
        Calendar cal = Calendar.getInstance();

      
        cal.add(Calendar.DAY_OF_YEAR, 20);
        InsurancePolicy policy1 = new InsurancePolicy("P001", "Alice", cal.getTime(), "Health", 500.0);

        cal.add(Calendar.DAY_OF_YEAR, 40);
        InsurancePolicy policy2 = new InsurancePolicy("P002", "Bob", cal.getTime(), "Auto", 700.0);

        cal.add(Calendar.DAY_OF_YEAR, -90);
        InsurancePolicy policy3 = new InsurancePolicy("P003", "Charlie", cal.getTime(), "Home", 900.0);

        management.addPolicy(policy1);
        management.addPolicy(policy2);
        management.addPolicy(policy3);

        
        System.out.println("Policy by Number (P001): " + management.getPolicyByNumber("P001"));
        System.out.println("Expiring Soon: " + management.getExpiringSoon());
        System.out.println("Policies by Holder (Alice): " + management.getPoliciesByHolder("Alice"));

        management.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + management.policyMap);
    }
}

