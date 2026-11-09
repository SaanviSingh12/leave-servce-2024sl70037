import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.bits.LeaveCalculator;

public class LeaveCalculatorTest {
    LeaveCalculator leaveCalc = new LeaveCalculator();

    @Test
    public void leaveEncashmentTest() {
        assertEquals(10000, leaveCalc.getLeaveEncashment("Dummy"));
    }

    @Test
    public void leaveEncashmentNullEmployeeTest() {
        assertEquals(0, leaveCalc.getLeaveEncashment(null));
    }

    @Test
    public void leaveBalanceTest() {
        assertEquals(10, leaveCalc.getLeaveBalance("DUMMY"));
    }
}

