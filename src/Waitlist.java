import java.util.Arrays;
import java.util.Set;

public class Waitlist {
  private String[] studentIds;

  /**
   * Creates a waitlist with the given student IDs and capacity.
   * 
   * The `capacity` determines the maximum number of students that can be on the
   * waitlist.
   * If `capacity` is larger than the number of given student IDs, the additional
   * slots
   * in the waitlist will be initialized as `null`.
   * 
   * @param studentIds the initial student IDs to include on the waitlist
   * @param capacity   the total capacity of the waitlist
   * @throws IllegalArgumentException if `capacity` is smaller than the number of
   *                                  given student IDs
   */
  public Waitlist(String[] studentIds, int capacity) {
    if (capacity < studentIds.length) {
      throw new IllegalArgumentException(
          "Capacity (" + capacity + ") cannot be smaller than the number of student IDs given (" + studentIds.length
              + ").");
    }
    this.studentIds = Arrays.copyOf(studentIds, capacity);
  }

  /**
   * Removes students with the given studentIds from the waitlist.
   * 
   * If a studentId in the toRemove Set is not present in the waitlist,
   * that student is ignored. The remaining students on the waitlist
   * have their order preserved.
   * this was hard to do by myself I had help
   * 
   * @param toRemove studentIds of the students to remove
   */
  public void removeStudents(Set<String> toRemove) {
    // this will keep track of where we should place the next student we keep
    int writeIndex = 0;

    // go through every spot in the waitlist array
    for (int i = 0; i < studentIds.length; i++) {

      // get the student id at this spot
      String id = studentIds[i];

      // keep the id if it is not null and it is not in the remove set
      if (id != null && !toRemove.contains(id)) {

        // put the kept id into the next open front spot
        studentIds[writeIndex] = id;

        // move to the next front spot
        writeIndex++;
      }
    }

    // set the remaining spots to null
    for (int i = writeIndex; i < studentIds.length; i++) {
      studentIds[i] = null;
    }
  }

  /**
   * Returns a copy of the waitlist.
   * 
   * Null values represent open spaces on the waitlist.
   * 
   * @return a copy of the current waitlist array, including `null` values for
   *         open slots
   */
  public String[] getWaitlist() {
    return Arrays.copyOf(studentIds, studentIds.length);
  }

  @Override
  public String toString() {
    return Arrays.toString(studentIds);
  }
}
