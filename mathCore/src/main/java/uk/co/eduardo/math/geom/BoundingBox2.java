/*
 * Copyright (c) PRGX.
 * All Rights Reserved.
 */
package uk.co.eduardo.math.geom;

import java.util.Collection;

/**
 * Represents a 2D bounding box.
 *
 * @author erodri02
 */
public class BoundingBox2
{
   /** The start corner of the bounding box. */
   public final Vector2 start;

   /** The end corner of the bounding box. */
   public final Vector2 end;

   /**
    * Initializes a new BoundingBox object.
    */
   public BoundingBox2()
   {
      this( Vector2.ZERO, Vector2.ZERO );
   }

   private BoundingBox2( final Vector2 start, final Vector2 end )
   {
      this.start = start;
      this.end = end;
   }

   /**
    * Tests to see if the bounding box is empty.
    *
    * @return whether the bounding box is empty.
    */
   public boolean isEmpty()
   {
      return ( this.start == Vector2.ZERO ) && ( this.end == Vector2.ZERO );
   }

   /**
    * Creates a new bounding box by adding a point to this bounding box.
    *
    * @param v the point to add to the bounding box. Cannot be <code>null</code>.
    * @return a new bounding box that also includes the specified point.
    */
   public BoundingBox2 union( final Vector2 v )
   {
      if( isEmpty() )
      {
         return new BoundingBox2( v, v );
      }

      final Vector2 s = new Vector2( Math.min( v.x, this.start.x ), Math.min( v.y, this.start.y ) );
      final Vector2 e = new Vector2( Math.max( v.x, this.end.x ), Math.max( v.y, this.end.y ) );
      return new BoundingBox2( s, e );
   }

   /**
    * Gets the centre of the bounding box.
    *
    * @return the centre of the bounding box.
    */
   public Vector2 getCentroid()
   {
      return this.start.add( this.end ).div( 2 );
   }

   /**
    * Factory method for creating a bounding box from a collection of points.
    *
    * @param points the points from which to create the bounding box.
    * @return the bounding box of the points.
    */
   public static BoundingBox2 fromPoints( final Collection< Vector2 > points )
   {
      BoundingBox2 box = new BoundingBox2();
      for( final Vector2 p : points )
      {
         box = box.union( p );
      }
      return box;
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return String.format( "%s -> %s", this.start, this.end ); //$NON-NLS-1$
   }
}
