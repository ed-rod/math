/*
 * Copyright (c) PRGX.
 * All Rights Reserved.
 */
package uk.co.eduardo.math.geom;

import java.util.Objects;

/**
 * Represents a line segment.
 *
 * @author erodri02
 */
public class LineSegment2
{
   /** The starting point of the line segment. */
   public final Vector2 start;

   /** The end point of the line segment. */
   public final Vector2 end;

   /**
    * Initializes a new LineSegment object.
    *
    * @param start the start of the line segment. Cannot be <code>null</code>.
    * @param end the end of the line segment. Cannot be <code>null</code>.
    */
   public LineSegment2( final Vector2 start, final Vector2 end )
   {
      this.start = Objects.requireNonNull( start );
      this.end = Objects.requireNonNull( end );
   }

   /**
    * Gets the mid point of the line segment.
    *
    * @return the mid point of the line segment.
    */
   public Vector2 getMidpoint()
   {
      return this.start.add( this.end ).div( 2 );
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return String.format( "| %s -> %s |", this.start, this.end ); //$NON-NLS-1$
   }
}
