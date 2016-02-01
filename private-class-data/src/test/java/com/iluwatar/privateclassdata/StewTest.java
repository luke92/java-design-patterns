/**
 * The MIT License
 * Copyright (c) 2014 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.privateclassdata;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;

/**
 * Date: 12/27/15 - 10:46 PM
 *
 * @author Jeroen Meulemeester
 */
public class StewTest extends StdOutTest {

  /**
   * Verify if mixing the stew doesn't change the internal state
   */
  @Test
  public void testMix() {
    final ImmutableStew stew = new ImmutableStew(1, 2, 3, 4);
    final String expectedMessage = "Mixing the immutable stew we find: 1 potatoes, "
        + "2 carrots, 3 meat and 4 peppers";

    final InOrder inOrder = inOrder(getStdOutMock());
    for (int i = 0; i < 20; i++) {
      stew.mix();
      inOrder.verify(getStdOutMock()).println(expectedMessage);
    }

    inOrder.verifyNoMoreInteractions();
  }

}