
package model;


public class CrewAssignment {
    private String flightNumber;
    private String role;
    private String crewMemberName;

    public CrewAssignment() {
    }

    public CrewAssignment(String flightNumber, String role, String crewMemberName) {
        this.flightNumber = flightNumber;
        this.role = role;
        this.crewMemberName = crewMemberName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCrewMemberName() {
        return crewMemberName;
    }

    public void setCrewMemberName(String crewMemberName) {
        this.crewMemberName = crewMemberName;
    }

    @Override
    public String toString() {
        return flightNumber + "|" + role + "|" + crewMemberName;
    }
    
    
}
