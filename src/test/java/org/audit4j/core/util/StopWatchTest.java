package org.audit4j.core.util;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>StopWatchTest</code> contains tests for the class <code>{@link StopWatch}</code>.
 *
 * @generatedBy CodePro at 2/4/15 9:28 AM
 * @author JanithB
 * @version $Revision: 1.0 $
 */
public class StopWatchTest {
    /**
     * Run the StopWatch() constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testStopWatch_1()
        throws Exception {

        StopWatch result = new StopWatch();

        // add additional test code here
        assertNotNull(result);
        assertEquals("StopWatch '': running time (millis) = 0", result.toString());
        assertEquals(false, result.isRunning());
        assertEquals(0, result.getTaskCount());
        assertEquals("StopWatch '': running time (millis) = 0", result.shortSummary());
        assertEquals(0L, result.getTotalTime());
        assertEquals("StopWatch '': running time (millis) = 0\n-----------------------------------------\nms % Task name\n-----------------------------------------\n", result.prettyPrint());
        assertEquals(0.0, result.getTotalTimeSeconds(), 1.0);
        assertEquals(0L, result.getTotalTimeMillis());
    }

    /**
     * Run the StopWatch(String) constructor test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testStopWatch_2()
        throws Exception {
        String id = "";

        StopWatch result = new StopWatch(id);

        // add additional test code here
        assertNotNull(result);
        assertEquals("StopWatch '': running time (millis) = 0", result.toString());
        assertEquals(false, result.isRunning());
        assertEquals(0, result.getTaskCount());
        assertEquals("StopWatch '': running time (millis) = 0", result.shortSummary());
        assertEquals(0L, result.getTotalTime());
        assertEquals("StopWatch '': running time (millis) = 0\n-----------------------------------------\nms % Task name\n-----------------------------------------\n", result.prettyPrint());
        assertEquals(0.0, result.getTotalTimeSeconds(), 1.0);
        assertEquals(0L, result.getTotalTimeMillis());
    }

    /**
     * Run the StopWatch.TaskInfo getLastTaskInfo() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetLastTaskInfo_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        StopWatch.TaskInfo result = fixture.getLastTaskInfo();

        // add additional test code here
        assertNotNull(result);
        assertEquals(14605L, result.getTime());
        assertEquals("", result.getTaskName());
        assertEquals(0.0, result.getTimeSeconds(), 1.0);
        assertEquals(0L, result.getTimeMillis());
    }

    /**
     * Run the StopWatch.TaskInfo getLastTaskInfo() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetLastTaskInfo_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        StopWatch.TaskInfo result = fixture.getLastTaskInfo();

        // add additional test code here
        assertNotNull(result);
        assertEquals(16578L, result.getTime());
        assertEquals("", result.getTaskName());
        assertEquals(0.0, result.getTimeSeconds(), 1.0);
        assertEquals(0L, result.getTimeMillis());
    }

    /**
     * Run the String getLastTaskName() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetLastTaskName_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        String result = fixture.getLastTaskName();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getLastTaskName() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetLastTaskName_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        String result = fixture.getLastTaskName();

        // add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the long getLastTaskTime() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetLastTaskTime_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        long result = fixture.getLastTaskTime();

        // add additional test code here
        assertEquals(20526L, result);
    }

    /**
     * Run the long getLastTaskTime() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetLastTaskTime_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        long result = fixture.getLastTaskTime();

        // add additional test code here
        assertEquals(590117L, result);
    }

    /**
     * Run the long getLastTaskTimeMillis() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetLastTaskTimeMillis_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        long result = fixture.getLastTaskTimeMillis();

        // add additional test code here
        assertEquals(0L, result);
    }

    /**
     * Run the long getLastTaskTimeMillis() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetLastTaskTimeMillis_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        long result = fixture.getLastTaskTimeMillis();

        // add additional test code here
        assertEquals(0L, result);
    }

    /**
     * Run the int getTaskCount() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetTaskCount_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        int result = fixture.getTaskCount();

        // add additional test code here
        assertEquals(1, result);
    }

    /**
     * Run the StopWatch.TaskInfo[] getTaskInfo() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetTaskInfo_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        StopWatch.TaskInfo[] result = fixture.getTaskInfo();

        // add additional test code here
        assertNotNull(result);
        assertEquals(1, result.length);
        assertNotNull(result[0]);
        assertEquals(10263L, result[0].getTime());
        assertEquals("", result[0].getTaskName());
        assertEquals(0.0, result[0].getTimeSeconds(), 1.0);
        assertEquals(0L, result[0].getTimeMillis());
    }

    /**
     * Run the StopWatch.TaskInfo[] getTaskInfo() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testGetTaskInfo_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(false);
        fixture.start("");
        fixture.stop();

        StopWatch.TaskInfo[] result = fixture.getTaskInfo();

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the long getTotalTime() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetTotalTime_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        long result = fixture.getTotalTime();

        // add additional test code here
        assertEquals(17763L, result);
    }

    /**
     * Run the long getTotalTimeMillis() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetTotalTimeMillis_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        long result = fixture.getTotalTimeMillis();

        // add additional test code here
        assertEquals(0L, result);
    }

    /**
     * Run the double getTotalTimeSeconds() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testGetTotalTimeSeconds_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        double result = fixture.getTotalTimeSeconds();

        // add additional test code here
        assertEquals(0.0, result, 0.1);
    }

    /**
     * Run the boolean isRunning() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testIsRunning_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        boolean result = fixture.isRunning();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the boolean isRunning() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testIsRunning_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        boolean result = fixture.isRunning();

        // add additional test code here
        assertEquals(false, result);
    }

    /**
     * Run the String prettyPrint() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testPrettyPrint_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        String result = fixture.prettyPrint();

        // add additional test code here
        assertEquals("StopWatch '': running time (millis) = 0\n-----------------------------------------\nms % Task name\n-----------------------------------------\n00000 ? \n", result);
    }

    /**
     * Run the String prettyPrint() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testPrettyPrint_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        String result = fixture.prettyPrint();

        // add additional test code here
        assertEquals("StopWatch '': running time (millis) = 0\n-----------------------------------------\nms % Task name\n-----------------------------------------\n00000 ? \n", result);
    }

    /**
     * Run the String prettyPrint() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testPrettyPrint_3()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(false);
        fixture.start("");
        fixture.stop();

        String result = fixture.prettyPrint();

        // add additional test code here
        assertEquals("StopWatch '': running time (millis) = 0\nNo task info kept", result);
    }

    /**
     * Run the void reset() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testReset_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        fixture.reset();

        // add additional test code here
    }

    /**
     * Run the void setKeepTaskList(boolean) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testSetKeepTaskList_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();
        boolean keepTaskList = true;

        fixture.setKeepTaskList(keepTaskList);

        // add additional test code here
    }

    /**
     * Run the String shortSummary() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testShortSummary_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        String result = fixture.shortSummary();

        // add additional test code here
        assertEquals("StopWatch '': running time (millis) = 0", result);
    }

    /**
     * Run the void start() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testStart_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        fixture.start();

        // add additional test code here
    }

    /**
     * Run the void start() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testStart_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        fixture.start();

        // add additional test code here
    }

    /**
     * Run the void start(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testStart_3()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();
        String taskName = "";

        fixture.start(taskName);

        // add additional test code here
    }

    /**
     * Run the void start(String) method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testStart_4()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();
        String taskName = "";

        fixture.start(taskName);

        // add additional test code here
    }

    /**
     * Run the void stop() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test(expected = java.lang.IllegalStateException.class)
    public void testStop_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        fixture.stop();

        // add additional test code here
    }

    /**
     * Run the void stop() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test(expected = java.lang.IllegalStateException.class)
    public void testStop_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        fixture.stop();

        // add additional test code here
    }

    /**
     * Run the void stop() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test(expected = java.lang.IllegalStateException.class)
    public void testStop_3()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(false);
        fixture.start("");
        fixture.stop();

        fixture.stop();

        // add additional test code here
    }

    /**
     * Run the String toString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testToString_1()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(false);
        fixture.start("");
        fixture.stop();

        String result = fixture.toString();

        // add additional test code here
        assertEquals("StopWatch '': running time (millis) = 0; no task info kept", result);
    }

    /**
     * Run the String toString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testToString_2()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        String result = fixture.toString();

        // add additional test code here
        assertEquals("StopWatch '': running time (millis) = 0; [] took 0 = 0%", result);
    }

    /**
     * Run the String toString() method test.
     *
     * @throws Exception
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Test
    public void testToString_3()
        throws Exception {
        StopWatch fixture = new StopWatch("");
        fixture.setKeepTaskList(true);
        fixture.start("");
        fixture.stop();

        String result = fixture.toString();

        // add additional test code here
        assertEquals("StopWatch '': running time (millis) = 0; [] took 0 = 0%", result);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *         if the initialization fails for some reason
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @Before
    public void setUp()
        throws Exception {
        // add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *         if the clean-up fails for some reason
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    @After
    public void tearDown()
        throws Exception {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     * @generatedBy CodePro at 2/4/15 9:28 AM
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(StopWatchTest.class);
    }
}