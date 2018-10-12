/*
 * Copyright (c) PRGX.
 * All Rights Reserved.
 */
package uk.co.eduardo.math.geom;

/**
 * An oriented plane is described by its horizontal vector and its vertical vector. There are infinite parallel planes with the same
 * horizontal and vertical vectors. We define a specific one by additionally specifying a point on the plane.
 *
 * @author erodri02
 */
public class OrientedPlane
{
   /** The standard XY plane that crosses the origin. */
   public static final OrientedPlane XY = new OrientedPlane( Vector3.X, Vector3.Y, Vector3.ZERO );

   /** The standard ZY plane that crosses the origin. */
   public static final OrientedPlane ZY = new OrientedPlane( Vector3.Z, Vector3.Y, Vector3.ZERO );

   /** The standard XZ plane that crosses the origin. */
   public static final OrientedPlane XZ = new OrientedPlane( Vector3.X, Vector3.Z, Vector3.ZERO );

   /** The horizontal unit vector for the plane. */
   public final Vector3 horiz;

   /** The vertical unit vector for the plane. */
   public final Vector3 vert;

   /** The normal unit vector for the plane. */
   public final Vector3 norm;

   /** A position on the plane. */
   public final Vector3 pointOnPlane;

   /**
    * Initializes a new Plane object.
    *
    * @param horiz the horizontal vector for the plane.
    * @param vert the vertical vector for the plane.
    * @param pointOnPlane a point on the plane.
    */
   public OrientedPlane( final Vector3 horiz, final Vector3 vert, final Vector3 pointOnPlane )
   {
      this.pointOnPlane = pointOnPlane;
      this.horiz = horiz.normalize();
      this.vert = vert.normalize();
      this.norm = this.horiz.cross( this.vert );
   }

   /**
    * Projects a point, p, onto this plane along this plane's normal vector.
    *
    * @param p the point to project.
    * @return the point p projected onto this plane.
    */
   public Vector3 project( final Vector3 p )
   {
      return p.sub( this.norm.mul( p.sub( this.pointOnPlane ).dot( this.norm ) ) );
   }

   /**
    * Creates a new oriented plane with the same orientation as this one but at a different location relative to this plane.
    * <p>
    * The new plane is created by adding the given offset to point on this plane.
    * </p>
    *
    * @param offset the offset to add to the point on this plane.
    * @return a new plane that has the same orientation but is at a relative location to this one.
    */
   public OrientedPlane translate( final Vector3 offset )
   {
      return new OrientedPlane( this.horiz, this.vert, this.pointOnPlane.add( offset ) );
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return String.format( "horiz: %s\tvert: %s\tpoint: %s", this.horiz, this.vert, this.pointOnPlane ); //$NON-NLS-1$
   }
}
