package dao;

import model.CrewAssignment;
import java.util.List;

public interface CrewAssignmentDAO {
    void addCrewAssignment(CrewAssignment crewAssignment);
    CrewAssignment getCrewAssignmentById(String crewAssignmentId);
    List<CrewAssignment> getAllCrewAssignments();
    void updateCrewAssignment(CrewAssignment crewAssignment);
    void deleteCrewAssignment(String crewAssignmentId);
    // Other crew assignment-related methods...
}
