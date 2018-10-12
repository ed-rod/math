/*
 * Copyright (c) PRGX.
 * All Rights Reserved.
 */
package uk.co.eduardo.math.geom;

import java.util.Collection;

/**
 * Represents a bounding box.
 *
 * @author erodri02
 */
public class BoundingBox3
{
   /** The start corner of the bounding box. */
   public final Vector3 start;

   /** The end corner of the bounding box. */
   public final Vector3 end;

   /**
    * Initializes a new BoundingBox object.
    */
   public BoundingBox3()
   {
      this( Vector3.ZERO, Vector3.ZERO );
   }

   private BoundingBox3( final Vector3 start, final Vector3 end )
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
      return ( this.start == Vector3.ZERO ) && ( this.end == Vector3.ZERO );
   }

   /**
    * Creates a new bounding box by adding a point to this bounding box.
    *
    * @param v the point to add to the bounding box. Cannot be <code>null</code>.
    * @return a new bounding box that also includes the specified point.
    */
   public BoundingBox3 union( final Vector3 v )
   {
      if( isEmpty() )
      {
         return new BoundingBox3( v, v );
      }

      final Vector3 s = new Vector3( Math.min( v.x, this.start.x ), Math.min( v.y, this.start.y ), Math.min( v.z, this.start.z ) );
      final Vector3 e = new Vector3( Math.max( v.x, this.end.x ), Math.max( v.y, this.end.y ), Math.max( v.z, this.end.z ) );
      return new BoundingBox3( s, e );
   }

   /**
    * Gets the centre of the bounding box.
    *
    * @return the centre of the bounding box.
    */
   public Vector3 getCentroid()
   {
      return this.start.add( this.end ).div( 2 );
   }

   /**
    * Factory method for creating a bounding box from a collection of points.
    *
    * @param points the points from which to create the bounding box.
    * @return the bounding box of the points.
    */
   public static BoundingBox3 fromPoints( final Collection< Vector3 > points )
   {
      BoundingBox3 box = new BoundingBox3();
      for( final Vector3 p : points )
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
