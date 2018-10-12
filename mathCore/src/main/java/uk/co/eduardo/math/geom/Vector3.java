/*
 * Copyright (c) PRGX.
 * All Rights Reserved.
 */
package uk.co.eduardo.math.geom;

/**
 * Represents a 3D vector.
 *
 * @author erodri02
 */
public class Vector3
{
   /** Zero vector. */
   public static final Vector3 ZERO = new Vector3( 0, 0, 0 );

   /** Unit vector in the X direction. */
   public static final Vector3 X = new Vector3( 1, 0, 0 );

   /** Unit vector in the Y direction. */
   public static final Vector3 Y = new Vector3( 0, 1, 0 );

   /** Unit vector in the Z direction. */
   public static final Vector3 Z = new Vector3( 0, 0, 1 );

   /** The x component. */
   public final double x;

   /** The y component. */
   public final double y;

   /** The z component. */
   public final double z;

   /**
    * Initializes a new Vector object.
    *
    * @param x the x component.
    * @param y the y component.
    * @param z the z component.
    */
   public Vector3( final double x, final double y, final double z )
   {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   /**
    * Computes the L2 norm of the vector.
    *
    * @return returns a unit vector.
    */
   public Vector3 normalize()
   {
      final double length = length();
      return new Vector3( this.x / length, this.y / length, this.z / length );
   }

   /**
    * Calculates the Euclidian distance of the vector.
    *
    * @return the length of the vector.
    */
   public double length()
   {
      return Math.sqrt( ( this.x * this.x ) + ( this.y * this.y ) + ( this.z * this.z ) );
   }

   /**
    * Returns this + other. Computes:
    *
    * <pre>
    *  &#x250C;                  &#x2510;
    *  &#x2502; this.x + other.x &#x2502;
    *  &#x2502; this.y + other.y &#x2502;
    *  &#x2502; this.z + other.z &#x2502;
    *  &#x2514;                  &#x2518;
    * </pre>
    *
    * @param other the other operand. Cannot be <code>null</code>.
    * @return this + other.
    */
   public Vector3 add( final Vector3 other )
   {
      return new Vector3( this.x + other.x, this.y + other.y, this.z + other.z );
   }

   /**
    * Returns this - other. Computes:
    *
    * <pre>
    *  &#x250C;                  &#x2510;
    *  &#x2502; this.x - other.x &#x2502;
    *  &#x2502; this.y - other.y &#x2502;
    *  &#x2502; this.z - other.z &#x2502;
    *  &#x2514;                  &#x2518;
    * </pre>
    *
    * @param other the other operand. Cannot be <code>null</code>.
    * @return this - other.
    */
   public Vector3 sub( final Vector3 other )
   {
      return new Vector3( this.x - other.x, this.y - other.y, this.z - other.z );
   }

   /**
    * Returns this * factor. Computes:
    *
    * <pre>
    *  &#x250C;                 &#x2510;
    *  &#x2502; this.x * factor &#x2502;
    *  &#x2502; this.y * factor &#x2502;
    *  &#x2502; this.z * factor &#x2502;
    *  &#x2514;                 &#x2518;
    * </pre>
    *
    * @param factor the scale factor.
    * @return this * other.
    */
   public Vector3 mul( final double factor )
   {
      return new Vector3( this.x * factor, this.y * factor, this.z * factor );
   }

   /**
    * Returns this / factor. Computes:
    *
    * <pre>
    *  &#x250C;                 &#x2510;
    *  &#x2502; this.x / factor &#x2502;
    *  &#x2502; this.y / factor &#x2502;
    *  &#x2502; this.z / factor &#x2502;
    *  &#x2514;                 &#x2518;
    * </pre>
    *
    * @param factor the scale factor.
    * @return this / other.
    */
   public Vector3 div( final double factor )
   {
      return new Vector3( this.x / factor, this.y / factor, this.z / factor );
   }

   /**
    * Calculates the cross product of this vector and the other.
    *
    * <pre>
    * result = this x other
    * </pre>
    *
    * @param other the other vector. Cannot be <code>null</code>.
    * @return the vector perpendicular to both this vector and the other.
    */
   public Vector3 cross( final Vector3 other )
   {
      final double rx = ( this.y * other.z ) - ( this.z * other.y );
      final double ry = ( this.z * other.x ) - ( this.x * other.z );
      final double rz = ( this.x * other.y ) - ( this.y * other.x );
      return new Vector3( rx, ry, rz );
   }

   /**
    * Calculates the dot product between this vector and the other.
    *
    * @param other the other vector. Cannot be <code>null</code>.
    * @return the dot product between this vector and the other.
    */
   public double dot( final Vector3 other )
   {
      return ( this.x * other.x ) + ( this.y * other.y ) + ( this.z * other.z );
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return String.format( "[%.3f, %.3f, %.3f]", this.x, this.y, this.z ); //$NON-NLS-1$
   }
}
