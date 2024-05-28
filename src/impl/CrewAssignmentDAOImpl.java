// dao/impl/CrewAssignmentDAOImpl.java
package impl;

import dao.CrewAssignmentDAO;
import model.CrewAssignment;
import java.util.ArrayList;
import java.util.List;

public class CrewAssignmentDAOImpl implements CrewAssignmentDAO {
    private List<CrewAssignment> crewAssignments = new ArrayList<>();

    @Override
    public void addCrewAssignment(CrewAssignment crewAssignment) {
        crewAssignments.add(crewAssignment);
    }

    @Override
    public CrewAssignment getCrewAssignmentById(String crewAssignmentId) {
        for (CrewAssignment crewAssignment : crewAssignments) {
            if (crewAssignment.getCrewMemberName().equals(crewAssignmentId)) {
                return crewAssignment;
            }
        }
        return null; // Not found
    }

    @Override
    public List<CrewAssignment> getAllCrewAssignments() {
        return new ArrayList<>(crewAssignments); // Return a copy to prevent external modification
    }

    @Override
    public void updateCrewAssignment(CrewAssignment crewAssignment) {
        for (int i = 0; i < crewAssignments.size(); i++) {
            if (crewAssignments.get(i).getCrewMemberName().equals(crewAssignment.getCrewMemberName())) {
                crewAssignments.set(i, crewAssignment);
                break;
            }
        }
    }

    @Override
    public void deleteCrewAssignment(String crewAssignmentId) {
        crewAssignments.removeIf(crewAssignment -> crewAssignment.getCrewMemberName().equals(crewAssignmentId));
    }
    // Other crew assignment-related methods can be added
}
