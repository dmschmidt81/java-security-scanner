
package security;

public class SecurityRule {

    private String ruleName;
    private String ruleDescription;
    private int riskWeight;
    private String pattern;

    public SecurityRule(
        String ruleName,
        String ruleDescription,
        int riskWeight,
        String pattern
    ) 
    {
        this.ruleName = ruleName;
        this.ruleDescription = ruleDescription;
        this.riskWeight = riskWeight;
        this.pattern = pattern;
    }

    public String getRuleName() 
    {
        return ruleName;
    }

    public String getRuleDescription() 
    {
        return ruleDescription;
    }

    public int getRiskWeight() 
    {
        return riskWeight;
    }

    public String getPattern() 
    {
        return pattern;
    }
}
