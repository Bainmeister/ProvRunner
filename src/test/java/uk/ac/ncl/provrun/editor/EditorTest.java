package uk.ac.ncl.provrun.editor;

import junit.framework.TestCase;

/**
 * Created by simon on 24/06/15.
 */
public class EditorTest extends TestCase {

    public void testCreate() throws Exception {
        assertEquals("1", Editor.create());
    }

    public void testUpdate() throws Exception {
        assertEquals("2", Editor.update("1"));
    }
}