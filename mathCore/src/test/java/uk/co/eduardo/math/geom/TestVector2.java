/*
 * Copyright (c) PRGX.
 * All Rights Reserved.
 */
package uk.co.eduardo.math.geom;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests 2D vectors
 *
 * @author erodri02
 */
public class TestVector2
{
   private static final double TOLERANCE = 1e-4;

   /**
    * Tests adding two vectors.
    */
   @Test
   public void testAdd()
   {
      for( int i = -100; i < 100; i++ )
      {
         for( int j = -100; j < 100; j++ )
         {
            final Vector2 a = new Vector2( i, j );
            final Vector2 b = new Vector2( 2 * j, 2 * i );

            final Vector2 s = a.add( b );
            final double expectedX = i + ( 2 * j );
            final double expectedY = j + ( 2 * i );
            Assert.assertEquals( expectedX, s.x, TOLERANCE );
            Assert.assertEquals( expectedY, s.y, TOLERANCE );
         }
      }
   }

   /**
    * Tests subtracting two vectors.
    */
   @Test
   public void testSub()
   {
      for( int i = -100; i < 100; i++ )
      {
         for( int j = -100; j < 100; j++ )
         {
            final Vector2 a = new Vector2( i, j );
            final Vector2 b = new Vector2( 2 * j, 2 * i );

            final Vector2 s = a.sub( b );
            final double expectedX = i - ( 2 * j );
            final double expectedY = j - ( 2 * i );
            Assert.assertEquals( expectedX, s.x, TOLERANCE );
            Assert.assertEquals( expectedY, s.y, TOLERANCE );
         }
      }
   }
}
