import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Set;

public class WaitlistTest {

  // TODO: Implement tests for removeStudents

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create
  // an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals
  // instance method or ==
  // java.util.Arrays is imported for you at the top of this file.
  // test for removing two students and shifting left
  @Test
  public void testRemoveStudentsRemovesTwoAndShifts() {
    String[] start = { "x", "r", "q", "m", "v" };
    Waitlist list = new Waitlist(start, 7);

    Set<String> toRemove = Set.of("r", "m");
    list.removeStudents(toRemove);

    String[] expected = { "x", "q", "v", null, null, null, null };
    String[] actual = list.getWaitlist();

    assertTrue(Arrays.equals(expected, actual));
  }

  // test for removing nobody using an empty set
  @Test
  public void testRemoveStudentsRemovesNone() {
    String[] start = { "a", "b", "c" };
    Waitlist list = new Waitlist(start, 5);

    Set<String> toRemove = Set.of();
    list.removeStudents(toRemove);

    String[] expected = { "a", "b", "c", null, null };
    String[] actual = list.getWaitlist();

    assertTrue(Arrays.equals(expected, actual));
  }

  // test for removing an id that is not in the waitlist
  @Test
  public void testRemoveStudentsRemoveNotFound() {
    String[] start = { "a", "b", "c" };
    Waitlist list = new Waitlist(start, 5);

    Set<String> toRemove = Set.of("z");
    list.removeStudents(toRemove);

    String[] expected = { "a", "b", "c", null, null };
    String[] actual = list.getWaitlist();

    assertTrue(Arrays.equals(expected, actual));
  }
}